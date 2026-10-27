/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.car.media;

import android.car.Car;
import android.car.CarLibLog;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.IVolumeController;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;

/**
 * Manager for car audio.
 */
public final class CarAudioManager implements CarManagerBase {

    /** Car audio usage: default. */
    public static final int CAR_AUDIO_USAGE_DEFAULT = 0;
    /** Car audio usage: music. */
    public static final int CAR_AUDIO_USAGE_MUSIC = 1;
    /** Car audio usage: radio. */
    public static final int CAR_AUDIO_USAGE_RADIO = 2;
    /** Car audio usage: navigation guidance. */
    public static final int CAR_AUDIO_USAGE_NAVIGATION_GUIDANCE = 3;
    /** Car audio usage: voice call. */
    public static final int CAR_AUDIO_USAGE_VOICE_CALL = 4;
    /** Car audio usage: voice command. */
    public static final int CAR_AUDIO_USAGE_VOICE_COMMAND = 5;
    /** Car audio usage: alarm. */
    public static final int CAR_AUDIO_USAGE_ALARM = 6;
    /** Car audio usage: notification. */
    public static final int CAR_AUDIO_USAGE_NOTIFICATION = 7;
    /** Car audio usage: system sound. */
    public static final int CAR_AUDIO_USAGE_SYSTEM_SOUND = 8;
    /** Car audio usage: system safety alert. */
    public static final int CAR_AUDIO_USAGE_SYSTEM_SAFETY_ALERT = 9;
    /** Car audio usage: ringtone. */
    public static final int CAR_AUDIO_USAGE_RINGTONE = 10;
    /** Car audio usage: external audio source. */
    public static final int CAR_AUDIO_USAGE_EXTERNAL_AUDIO_SOURCE = 11;
    /** Car audio usage: max. */
    public static final int CAR_AUDIO_USAGE_MAX = 11;

    public static final String CAR_EXTERNAL_SOURCE_TYPE_AUX_IN0 = "AUX_IN0";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_AUX_IN1 = "AUX_IN1";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_CD_DVD = "CD_DVD";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_EXT_NAV_GUIDANCE = "EXT_NAV_GUIDANCE";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_EXT_SAFETY_ALERT = "EXT_SAFETY_ALERT";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_EXT_VOICE_CALL = "EXT_VOICE_CALL";
    public static final String CAR_EXTERNAL_SOURCE_TYPE_EXT_VOICE_COMMAND = "EXT_VOICE_COMMAND";

    public static final String CAR_RADIO_TYPE_AM_FM = "RADIO_AM_FM";
    public static final String CAR_RADIO_TYPE_AM_FM_HD = "RADIO_AM_FM_HD";
    public static final String CAR_RADIO_TYPE_DAB = "RADIO_DAB";
    public static final String CAR_RADIO_TYPE_SATELLITE = "RADIO_SATELLITE";

    @Retention(RetentionPolicy.SOURCE)
    public @interface CarAudioUsage {
    }

    /**
     * Listener for parameter changes.
     */
    public interface OnParameterChangeListener {
        /**
         * Called when the parameters change.
         *
         * @param params the changed parameters
         */
        void onParameterChange(String params);
    }

    private final ICarAudio mService;
    private final AudioManager mAudioManager;
    private final Handler mHandler;

    private OnParameterChangeListener mOnParameterChangeListener;
    private ParameterChangeCallback mParameterChangeCallback;

    public CarAudioManager(IBinder service, Context context, Handler handler) {
        mService = ICarAudio.Stub.asInterface(service);
        mAudioManager = (AudioManager) context.getSystemService(Car.AUDIO_SERVICE);
        mHandler = handler;
    }

    public AudioAttributes getAudioAttributesForCarUsage(int carUsage)
            throws CarNotConnectedException {
        try {
            return mService.getAudioAttributesForCarUsage(carUsage);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public AudioAttributes getAudioAttributesForRadio(String radioType)
            throws CarNotConnectedException, IllegalArgumentException {
        try {
            return mService.getAudioAttributesForRadio(radioType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public AudioAttributes getAudioAttributesForExternalSource(String externalSourceType)
            throws CarNotConnectedException, IllegalArgumentException {
        try {
            return mService.getAudioAttributesForExternalSource(externalSourceType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public String[] getSupportedExternalSourceTypes() throws CarNotConnectedException {
        try {
            return mService.getSupportedExternalSourceTypes();
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    public String[] getSupportedRadioTypes() throws CarNotConnectedException {
        try {
            return mService.getSupportedRadioTypes();
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Requests audio focus.
     *
     * <p>This method uses the hidden {@code AudioManager#requestAudioFocus(listener, attributes,
     * durationHint, flags)} overload, which is not part of the public SDK. When compiling
     * against the public SDK, use reflection — see {@link #requestAudioFocusWithFlags}.
     */
    public int requestAudioFocus(AudioManager.OnAudioFocusChangeListener l,
                                 AudioAttributes requestAttributes, int durationHint, int flags)
            throws CarNotConnectedException, IllegalArgumentException {
        return requestAudioFocusWithFlags(l, requestAttributes, durationHint, flags);
    }

    /**
     * Abandons audio focus.
     *
     * <p>This method uses the hidden {@code AudioManager#abandonAudioFocus(listener,
     * attributes)} overload, which is not part of the public SDK. When compiling against
     * the public SDK, use reflection — see {@link #abandonAudioFocusWithAttributes}.
     */
    public void abandonAudioFocus(AudioManager.OnAudioFocusChangeListener l,
                                  AudioAttributes aa) {
        abandonAudioFocusWithAttributes(l, aa);
    }

    // ---------------------------------------------------------------------
    // Hidden-API bridges
    // ---------------------------------------------------------------------

    private int requestAudioFocusWithFlags(AudioManager.OnAudioFocusChangeListener l,
                                           AudioAttributes requestAttributes, int durationHint, int flags) {
        try {
            return (Integer) AudioManager.class
                    .getMethod("requestAudioFocus",
                            AudioManager.OnAudioFocusChangeListener.class,
                            AudioAttributes.class,
                            int.class,
                            int.class)
                    .invoke(mAudioManager, l, requestAttributes, durationHint, flags);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "AudioManager.requestAudioFocus(4 args) is unavailable", e);
        }
    }

    private void abandonAudioFocusWithAttributes(AudioManager.OnAudioFocusChangeListener l,
                                                 AudioAttributes aa) {
        try {
            AudioManager.class
                    .getMethod("abandonAudioFocus",
                            AudioManager.OnAudioFocusChangeListener.class,
                            AudioAttributes.class)
                    .invoke(mAudioManager, l, aa);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(
                    "AudioManager.abandonAudioFocus(2 args) is unavailable", e);
        }
    }

    // ---------------------------------------------------------------------
    // Volume / mute / parameters
    // ---------------------------------------------------------------------

    public void setStreamVolume(int streamType, int index, int flags)
            throws CarNotConnectedException {
        try {
            mService.setStreamVolume(streamType, index, flags);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setStreamVolume failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setVolumeController(IVolumeController controller)
            throws CarNotConnectedException {
        try {
            mService.setVolumeController(controller);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setVolumeController failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public int getStreamMaxVolume(int stream) throws CarNotConnectedException {
        try {
            return mService.getStreamMaxVolume(stream);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getStreamMaxVolume failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public int getStreamMinVolume(int stream) throws CarNotConnectedException {
        try {
            return mService.getStreamMinVolume(stream);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getStreamMinVolume failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public int getStreamVolume(int stream) throws CarNotConnectedException {
        try {
            return mService.getStreamVolume(stream);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getStreamVolume failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public boolean isMediaMuted() throws CarNotConnectedException {
        try {
            return mService.isMediaMuted();
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "isMediaMuted failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public boolean setMediaMute(boolean mute) throws CarNotConnectedException {
        try {
            return mService.setMediaMute(mute);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setMediaMute failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public String[] getParameterKeys() throws CarNotConnectedException {
        try {
            return mService.getParameterKeys();
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getParameterKeys failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setParameters(String parameters) throws CarNotConnectedException {
        try {
            mService.setParameters(parameters);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setParameters failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public String getParameters(String keys) throws CarNotConnectedException {
        try {
            return mService.getParameters(keys);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getParameters failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setOnParameterChangeListener(OnParameterChangeListener listener)
            throws CarNotConnectedException {
        ParameterChangeCallback oldCb;
        ParameterChangeCallback newCb = null;
        synchronized (this) {
            oldCb = mParameterChangeCallback;
            if (listener != null) {
                newCb = new ParameterChangeCallback(this);
                mParameterChangeCallback = newCb;
                mOnParameterChangeListener = listener;
            } else {
                mParameterChangeCallback = null;
                mOnParameterChangeListener = null;
            }
        }
        if (oldCb != null) {
            try {
                mService.unregisterOnParameterChangeListener(oldCb);
            } catch (RemoteException e) {
                Log.e(CarLibLog.TAG_CAR, "setOnParameterChangeListener failed", e);
                throw new CarNotConnectedException(e);
            }
        }
        if (newCb != null) {
            try {
                mService.registerOnParameterChangeListener(newCb);
            } catch (RemoteException e) {
                Log.e(CarLibLog.TAG_CAR, "setOnParameterChangeListener failed", e);
                throw new CarNotConnectedException(e);
            }
        }
    }

    @Override
    public void onCarDisconnected() {
        // Nothing to do
    }

    private static class ParameterChangeCallback extends ICarAudioCallback.Stub {

        private final WeakReference<CarAudioManager> mManager;

        private ParameterChangeCallback(CarAudioManager manager) {
            mManager = new WeakReference<>(manager);
        }

        @Override
        public void onParameterChange(final String params) {
            CarAudioManager manager = mManager.get();
            if (manager == null) {
                return;
            }
            final OnParameterChangeListener listener = manager.mOnParameterChangeListener;
            if (listener == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onParameterChange(params);
                }
            });
        }
    }
}