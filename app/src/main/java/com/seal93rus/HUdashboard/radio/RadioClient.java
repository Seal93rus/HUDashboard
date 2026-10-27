package com.seal93rus.HUdashboard.radio;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;

import com.seal93rus.HUdashboard.radio.IRadioServiceCallback;
import com.seal93rus.HUdashboard.radio.IRadioServiceManager;
import com.seal93rus.HUdashboard.radio.RadioEngineerData;
import com.seal93rus.HUdashboard.radio.RadioStation;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Клиент локального радио.
 * Bind -> IRadioServiceManager, регистрирует IRadioServiceCallback.
 * Кэширует текущую станцию и аудиофокус, раздаёт события слушателям на main-потоке.
 */
public class RadioClient {

    public interface Listener {
        /** Пришли новые данные о станции/band/сигнале/mute. Перечитай pull-методы. */
        void onRadioDataChanged();
        /** Изменился аудиофокус (isAudioFocused()). */
        void onAudioFocusChanged(boolean focused);
        /** Сервис подключён/отключён. */
        void onServiceStateChanged(boolean connected);
    }

    private static final String TAG = "RadioClient";
    private static final String PKG = "com.harman.radioservice";
    private static final String ACTION = "com.harman.radioservice.action.RADIO_SERVICE";

    private static RadioClient sInstance;

    public static synchronized RadioClient get(Context ctx) {
        if (sInstance == null) sInstance = new RadioClient(ctx.getApplicationContext());
        return sInstance;
    }

    private final Context appContext;
    private final Handler main = new Handler(Looper.getMainLooper());
    private final CopyOnWriteArrayList<Listener> listeners = new CopyOnWriteArrayList<>();

    private IRadioServiceManager service;
    private boolean bound = false;
    private boolean serviceAvailable = false;
    private boolean rebinding = false;

    // кэш
    private RadioStation currentStation;
    private boolean audioFocused = false;

    private final Object lock = new Object();

    private final IBinder.DeathRecipient deathRecipient = () -> {
        Log.w(TAG, "binder died");
        service = null;
        serviceAvailable = false;
        bound = false;
        notifyServiceState(false);
        scheduleRebind();
    };

    private final IRadioServiceCallback callback = new IRadioServiceCallback.Stub() {
        @Override public void onRadioStationChanged(RadioStation station) {
            Log.d(TAG, "onRadioStationChanged: " + station);
            if (station == null) return;
            RadioStation copy = copyOf(station);
            boolean changed;
            synchronized (lock) {
                RadioStation old = currentStation;
                if (old != null && old.equals(copy)) {
                    // та же станция (band+freq), обновим только signal, и только если перешли порог 15
                    boolean oldOk = old.getSignalStrength() >= 15;
                    boolean newOk = copy.getSignalStrength() >= 15;
                    changed = oldOk != newOk;
                    if (changed) {
                        old.setSignalStrength(copy.getSignalStrength());
                    }
                } else {
                    currentStation = copy;
                    changed = true;
                }
            }
            if (changed) notifyData();
        }

        @Override public void onRadioStationListChanged() {}
        @Override public void onPresetListChanged() {}
        @Override public void onSearchStationsChanged(int radioBand) {}
        @Override public void onRadioBandChanged(int radioBand) {
            Log.d(TAG, "onRadioBandChanged: " + radioBand);
            if (service != null) {
                try {
                    RadioStation s = service.getCurrentStation();
                    synchronized (lock) { currentStation = copyOf(s); }
                } catch (RemoteException e) {
                    Log.e(TAG, "pull after bandChanged", e);
                }
            }
            notifyData();
        }
        @Override public void onAudioFocusChanged(int status) {
            Log.d(TAG, "onAudioFocusChanged: " + status);
            handleFocus(status);
        }
        @Override public void onRadioMuteChanged(boolean isMuted) {
            Log.d(TAG, "onRadioMuteChanged: " + isMuted);
            notifyData();
        }
        @Override public void onError(int status) { Log.w(TAG, "onError: " + status); }
        @Override public void onRadioDataBaseReady() {}
        @Override public void onSearchStationsDone() {}
        @Override public void onSearchStationsInterrupted() {}
        @Override public void onNavigationRegionChanged() {}
        @Override public void onEngineerDataChanged(RadioEngineerData data) {
            if (data == null) return;
            boolean changed = false;
            synchronized (lock) {
                if (currentStation != null && currentStation.getFrequency() != data.getFrequency()) {
                    currentStation.setFrequency(data.getFrequency());
                    changed = true;
                }
            }
            if (changed) notifyData();
        }
        @Override public void onHardKeyMuted(int muted) {}
        @Override public void onAntennaStatusChanged(int status) {}
        @Override public void onTrafficAnnouncement(boolean active) {}
        @Override public void onTaAudioFocusChanged(int status) {}
        @Override public void onTaModeChanged(boolean status) {}
    };

    private final ServiceConnection connection = new ServiceConnection() {
        @Override public void onServiceConnected(ComponentName name, IBinder binder) {
            Log.d(TAG, "onServiceConnected");
            IRadioServiceManager mgr = IRadioServiceManager.Stub.asInterface(binder);
            if (mgr == null) return;
            try {
                binder.linkToDeath(deathRecipient, 0);
                mgr.addRadioServiceCallback(callback);
            } catch (RemoteException e) {
                Log.e(TAG, "onServiceConnected", e);
                return;
            }
            service = mgr;
            bound = true;
            serviceAvailable = true;
            rebinding = false;

            // pull начального состояния
            try {
                currentStation = copyOf(mgr.getCurrentStation());
                handleFocus(mgr.getAudioFocusStatus());
            } catch (RemoteException e) {
                Log.e(TAG, "initial pull failed", e);
            }
            notifyServiceState(true);
            notifyData();
        }

        @Override public void onServiceDisconnected(ComponentName name) {
            Log.w(TAG, "onServiceDisconnected");
            service = null;
            bound = false;
            serviceAvailable = false;
            notifyServiceState(false);
            scheduleRebind();
        }
    };

    private RadioClient(Context ctx) { this.appContext = ctx; }

    // ---------- lifecycle ----------

    public void start() {
        if (!bound) bind();
    }

    public void stop() {
        if (service != null) {
            try { service.removeRadioServiceCallback(callback); } catch (RemoteException ignored) {}
            try { service.asBinder().unlinkToDeath(deathRecipient, 0); } catch (Exception ignored) {}
        }
        if (bound) {
            try { appContext.unbindService(connection); } catch (Exception ignored) {}
        }
        bound = false;
        serviceAvailable = false;
        service = null;
        rebinding = false;
        main.removeCallbacksAndMessages(null);   // отменяет отложенный rebind
    }

    private void bind() {
        Intent i = new Intent();
        i.setPackage(PKG);
        i.setAction(ACTION);
        try {
            bound = appContext.bindService(i, connection, Context.BIND_AUTO_CREATE);
            Log.d(TAG, "bindService -> " + bound);
        } catch (SecurityException se) {
            Log.e(TAG, "bindService security", se);
            bound = false;
        } catch (Exception e) {
            Log.e(TAG, "bindService failed", e);
            bound = false;
        }
    }

    private void scheduleRebind() {
        if (rebinding) return;
        rebinding = true;
        main.postDelayed(() -> {
            if (!bound) bind();
        }, 1000);
    }

    // ---------- listeners ----------

    public void addListener(Listener l)    { if (l != null && !listeners.contains(l)) listeners.add(l); }
    public void removeListener(Listener l) { listeners.remove(l); }

    // ---------- pull ----------

    public boolean isServiceAvailable() { return serviceAvailable && service != null; }

    public boolean isAudioFocused() { return audioFocused; }

    public RadioStation getCurrentStation() {
        synchronized (lock) {
            return currentStation == null ? null : copyOf(currentStation);
        }
    }

    public int getFrequency() {
        RadioStation s = getCurrentStation();
        return s != null ? s.getFrequency() : 0;
    }

    public int getBand() {
        RadioStation s = getCurrentStation();
        return s != null ? s.getRadioBand() : -1;
    }

    public boolean isMuted() {
        if (!isServiceAvailable()) return false;
        try { return service.isMuted(); } catch (RemoteException e) { return false; }
    }

    public boolean isPlaying() { return audioFocused && !isMuted(); }

    public boolean isStationSupported() {
        RadioStation s = getCurrentStation();
        return s != null && s.getSignalStrength() >= 15;
    }

    // ---------- commands ----------

    public boolean mute() {
        if (!isServiceAvailable()) return false;
        try { return service.mute(); } catch (RemoteException e) { Log.e(TAG, "mute", e); return false; }
    }

    public boolean unmute() {
        if (!isServiceAvailable()) return false;
        try { return service.unMute(); } catch (RemoteException e) { Log.e(TAG, "unmute", e); return false; }
    }

    public boolean requestFocus() {
        if (!isServiceAvailable()) return false;
        try { return service.requestRadioAudioFocus() > 0; }
        catch (RemoteException e) { Log.e(TAG, "requestFocus", e); return false; }
    }

    public void abandonFocus() {
        if (!isServiceAvailable()) return;
        try { service.abandonRadioAudioFocus(); } catch (RemoteException e) { Log.e(TAG, "abandonFocus", e); }
    }


    public void seekUp()   { call(s -> s.seekUp(),   "seekUp"); }
    public void seekDown() { call(s -> s.seekDown(), "seekDown"); }
    public void scanUp()   { call(s -> s.scanUp(),   "scanUp"); }
    public void scanDown() { call(s -> s.scanDown(), "scanDown"); }
    public void cancelSeek(){ call(s -> s.cancelSeek(), "cancelSeek"); }

    public void openBand(int band) {
        if (!isServiceAvailable()) return;
        try { service.openRadioBand(band); } catch (RemoteException e) { Log.e(TAG, "openBand", e); }
    }

    /** Tune/Pause-аналог для локального радио: если не играет — фокус, если играет и mute — unmute. */


    private interface Cmd { void run(IRadioServiceManager s) throws RemoteException; }
    private void call(Cmd c, String tag) {
        if (!isServiceAvailable()) return;
        try { c.run(service); } catch (RemoteException e) { Log.e(TAG, tag, e); }
    }

    // ---------- focus ----------

    private void handleFocus(int status) {
        boolean focused;
        switch (status) {
            case -3: case -2: case -1: focused = false; break;
            case 1: case 2: case 3: case 4: focused = true; break;
            default: return;
        }
        boolean changed = (audioFocused != focused);
        audioFocused = focused;
        if (changed) {
            final boolean f = focused;
            main.post(() -> { for (Listener l : listeners) l.onAudioFocusChanged(f); });
        }
    }

    // ---------- notify ----------

    private void notifyData() {
        main.post(() -> { for (Listener l : listeners) l.onRadioDataChanged(); });
    }

    private void notifyServiceState(boolean connected) {
        main.post(() -> { for (Listener l : listeners) l.onServiceStateChanged(connected); });
    }

    private static RadioStation copyOf(RadioStation s) {
        if (s == null) return null;
        return new RadioStation(
                s.getRadioBand(), s.getFrequency(), s.getSignalStrength(),
                s.getPresetID(), s.getTuned(), s.getMuted(), s.getStereo(),
                s.getStationName(), s.getPICode(), s.getPTYCode(), s.getProgramService());
    }
}