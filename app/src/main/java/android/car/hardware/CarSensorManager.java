package android.car.hardware;

import android.car.CarApiUtil;
import android.car.CarLibLog;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import android.car.internal.CarRatedListeners;
import android.car.internal.SingleMessageHandler;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes.dex */
public final class CarSensorManager implements CarManagerBase {
    private static final int MSG_SENSOR_EVENTS = 0;
    public static final int SENSOR_RATE_FAST = 1;
    public static final int SENSOR_RATE_FASTEST = 0;
    public static final int SENSOR_RATE_NORMAL = 3;
    public static final int SENSOR_RATE_UI = 2;
    public static final int SENSOR_TYPE_ABS_ACTIVE = 24;
    public static final int SENSOR_TYPE_CAR_SPEED = 2;
    public static final int SENSOR_TYPE_CURRENT_GEAR = 13;
    public static final int SENSOR_TYPE_DRIVING_STATUS = 11;
    public static final int SENSOR_TYPE_ENGINE_COOLANT_TEMP = 15;
    public static final int SENSOR_TYPE_ENGINE_OIL_TEMP = 16;
    public static final int SENSOR_TYPE_ENVIRONMENT = 12;
    public static final int SENSOR_TYPE_FUEL_LEVEL = 5;
    public static final int SENSOR_TYPE_FUEL_LEVEL_LOW = 8;
    public static final int SENSOR_TYPE_GEAR = 7;
    public static final int SENSOR_TYPE_IGNITION_STATE = 22;
    private static final int SENSOR_TYPE_MAX = 25;
    public static final int SENSOR_TYPE_NIGHT = 9;
    public static final int SENSOR_TYPE_ODOMETER = 4;
    public static final int SENSOR_TYPE_PARKING_BRAKE = 6;
    public static final int SENSOR_TYPE_RESERVED1 = 1;
    public static final int SENSOR_TYPE_RESERVED10 = 10;
    public static final int SENSOR_TYPE_RESERVED14 = 14;
    public static final int SENSOR_TYPE_RESERVED17 = 17;
    public static final int SENSOR_TYPE_RESERVED18 = 18;
    public static final int SENSOR_TYPE_RESERVED20 = 20;
    public static final int SENSOR_TYPE_RESERVED21 = 21;
    public static final int SENSOR_TYPE_RPM = 3;
    public static final int SENSOR_TYPE_TRACTION_CONTROL_ACTIVE = 25;
    public static final int SENSOR_TYPE_TURN_SIGNAL_STATE = 19;
    public static final int SENSOR_TYPE_VENDOR_EXTENSION_END = 1879048191;
    public static final int SENSOR_TYPE_VENDOR_EXTENSION_START = 1610612736;
    public static final int SENSOR_TYPE_WHEEL_TICK_DISTANCE = 23;
    private final SparseArray<CarSensorListeners> mActiveSensorListeners = new SparseArray<>();
    private CarSensorEventListenerToService mCarSensorEventListenerToService;
    private final SingleMessageHandler<android.car.hardware.CarSensorEvent> mHandlerCallback;
    private final ICarSensor mService;

    public interface OnSensorChangedListener {
        void onSensorChanged(android.car.hardware.CarSensorEvent carSensorEvent);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorRate {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface SensorType {
    }

    public CarSensorManager(IBinder service, Context context, Handler handler) {
        this.mService = ICarSensor.Stub.asInterface(service);
        this.mHandlerCallback = new SingleMessageHandler<android.car.hardware.CarSensorEvent>(handler.getLooper(), 0) { // from class: android.car.hardware.CarSensorManager.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.android.car.internal.SingleMessageHandler
            public void handleEvent(android.car.hardware.CarSensorEvent event) {
                CarSensorListeners listeners;
                synchronized (CarSensorManager.this.mActiveSensorListeners) {
                    listeners = (CarSensorListeners) CarSensorManager.this.mActiveSensorListeners.get(event.sensorType);
                }
                if (listeners != null) {
                    listeners.onSensorChanged(event);
                }
            }
        };
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized (this.mActiveSensorListeners) {
            this.mActiveSensorListeners.clear();
            this.mCarSensorEventListenerToService = null;
        }
    }

    public int[] getSupportedSensors() throws CarNotConnectedException {
        try {
            return this.mService.getSupportedSensors();
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        } catch (IllegalStateException e2) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
            return new int[0];
        }
    }

    public boolean isSensorSupported(int sensorType) throws CarNotConnectedException {
        int[] sensors = getSupportedSensors();
        for (int sensorSupported : sensors) {
            if (sensorType == sensorSupported) {
                return true;
            }
        }
        return false;
    }

    public static boolean isSensorSupported(int[] sensorList, int sensorType) {
        for (int sensorSupported : sensorList) {
            if (sensorType == sensorSupported) {
                return true;
            }
        }
        return false;
    }

    public boolean registerListener(OnSensorChangedListener listener, int sensorType, int rate) throws CarNotConnectedException, IllegalArgumentException, RemoteException {
        boolean z = true;
        assertSensorType(sensorType);
        if (rate != 0 && rate != 3 && rate != 2 && rate != 1) {
            throw new IllegalArgumentException("wrong rate " + rate);
        }
        synchronized (this.mActiveSensorListeners) {
            if (this.mCarSensorEventListenerToService == null) {
                this.mCarSensorEventListenerToService = new CarSensorEventListenerToService(this);
            }
            boolean needsServerUpdate = false;
            CarSensorListeners listeners = this.mActiveSensorListeners.get(sensorType);
            if (listeners == null) {
                listeners = new CarSensorListeners(rate);
                this.mActiveSensorListeners.put(sensorType, listeners);
                needsServerUpdate = true;
            }
            if (listeners.addAndUpdateRate(listener, rate)) {
                needsServerUpdate = true;
            }
            if (needsServerUpdate && !registerOrUpdateSensorListener(sensorType, rate)) {
                z = false;
            }
        }
        return z;
    }

    public void unregisterListener(OnSensorChangedListener listener) {
        synchronized (this.mActiveSensorListeners) {
            for (int i = 0; i < this.mActiveSensorListeners.size(); i++) {
                doUnregisterListenerLocked(listener, Integer.valueOf(this.mActiveSensorListeners.keyAt(i)));
            }
        }
    }

    public void unregisterListener(OnSensorChangedListener listener, int sensorType) {
        synchronized (this.mActiveSensorListeners) {
            doUnregisterListenerLocked(listener, Integer.valueOf(sensorType));
        }
    }

    private void doUnregisterListenerLocked(OnSensorChangedListener listener, Integer sensor) {
        CarSensorListeners listeners = this.mActiveSensorListeners.get(sensor.intValue());
        if (listeners != null) {
            boolean needsServerUpdate = false;
            if (listeners.contains(listener)) {
                needsServerUpdate = listeners.remove(listener);
            }
            if (listeners.isEmpty()) {
                try {
                    this.mService.unregisterSensorListener(sensor.intValue(), this.mCarSensorEventListenerToService);
                } catch (RemoteException e) {
                }
                this.mActiveSensorListeners.remove(sensor.intValue());
            } else if (needsServerUpdate) {
                try {
                    registerOrUpdateSensorListener(sensor.intValue(), listeners.getRate());
                } catch (CarNotConnectedException e2) {
                } catch (RemoteException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private boolean registerOrUpdateSensorListener(int sensor, int rate) throws CarNotConnectedException, RemoteException {
        try {
        } catch (IllegalStateException e2) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
        }
        if (!this.mService.registerOrUpdateSensorListener(sensor, rate, this.mCarSensorEventListenerToService)) {
            return false;
        }
        return true;
    }

    public android.car.hardware.CarSensorEvent getLatestSensorEvent(int type) throws CarNotConnectedException {
        assertSensorType(type);
        try {
            return this.mService.getLatestSensorEvent(type);
        } catch (RemoteException e) {
            handleCarServiceRemoteExceptionAndThrow(e);
            return null;
        } catch (IllegalStateException e2) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
            return null;
        }
    }

    private void handleCarServiceRemoteExceptionAndThrow(RemoteException e) throws CarNotConnectedException {
        if (Log.isLoggable(CarLibLog.TAG_SENSOR, Log.INFO)) {
            Log.i(CarLibLog.TAG_SENSOR, "RemoteException from car service:" + e.getMessage());
        }
        throw new CarNotConnectedException();
    }

    private void assertSensorType(int sensorType) {
        if (sensorType != 0) {
            if (sensorType <= 25) {
                return;
            }
            if (sensorType >= 1610612736 && sensorType <= 1879048191) {
                return;
            }
        }
        throw new IllegalArgumentException("invalid sensor type " + sensorType);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnSensorChanged(List<android.car.hardware.CarSensorEvent> events) {
        this.mHandlerCallback.sendEvents(events);
    }

    private static class CarSensorEventListenerToService extends ICarSensorEventListener.Stub {
        private final WeakReference<CarSensorManager> mManager;

        public CarSensorEventListenerToService(CarSensorManager manager) {
            this.mManager = new WeakReference<>(manager);
        }

        @Override // android.car.hardware.ICarSensorEventListener
        public void onSensorChanged(List<android.car.hardware.CarSensorEvent> events) {
            CarSensorManager manager = this.mManager.get();
            if (manager != null) {
                manager.handleOnSensorChanged(events);
            }
        }
    }

    private class CarSensorListeners extends CarRatedListeners<OnSensorChangedListener> {
        CarSensorListeners(int rate) {
            super(rate);
        }

        void onSensorChanged(final CarSensorEvent event) {
            List<OnSensorChangedListener> listeners;
            long updateTime = event.timestamp;
            if (updateTime < this.mLastUpdateTime) {
                Log.w(CarLibLog.TAG_SENSOR, "dropping old sensor data");
                return;
            }
            this.mLastUpdateTime = updateTime;
            synchronized (CarSensorManager.this.mActiveSensorListeners) {
                listeners = new ArrayList<>(getListeners());
            }
            listeners.forEach(new Consumer<OnSensorChangedListener>() { // from class: android.car.hardware.CarSensorManager.CarSensorListeners.1
                @Override // java.util.function.Consumer
                public void accept(OnSensorChangedListener listener) {
                    listener.onSensorChanged(event);
                }
            });
        }
    }

    public android.car.hardware.CarSensorConfig getSensorConfig(int type) throws CarNotConnectedException {
        assertSensorType(type);
        try {
            return this.mService.getSensorConfig(type);
        } catch (RemoteException e) {
            handleCarServiceRemoteExceptionAndThrow(e);
            return new android.car.hardware.CarSensorConfig(0, Bundle.EMPTY);
        } catch (IllegalStateException e2) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
            return new CarSensorConfig(0, Bundle.EMPTY);
        }
    }
}