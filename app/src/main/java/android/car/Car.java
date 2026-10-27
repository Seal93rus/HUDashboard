package android.car;

import android.car.cluster.CarInstrumentClusterManager;
import android.car.content.pm.CarPackageManager;
import android.car.diagnostic.CarDiagnosticManager;
import android.car.hardware.CarSensorManager;
import android.car.hardware.CarVendorExtensionManager;
import android.car.hardware.cabin.CarCabinManager;
import android.car.hardware.hvac.CarHvacManager;
import android.car.hardware.power.CarPowerManager;
import android.car.media.CarAudioManager;
import android.car.navigation.CarNavigationStatusManager;
import android.car.test.CarTestManagerBinderWrapper;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.os.UserHandle;
import android.util.Log;
import com.android.internal.annotations.GuardedBy;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class Car {
    public static final String APP_FOCUS_SERVICE = "app_focus";
    public static final String AUDIO_SERVICE = "audio";
    public static final String BLUETOOTH_SERVICE = "car_bluetooth";
    public static final String CABIN_SERVICE = "cabin";
    public static final String CAR_EXTRA_MEDIA_PACKAGE = "android.car.intent.extra.MEDIA_PACKAGE";
    public static final String CAR_INSTRUMENT_CLUSTER_SERVICE = "cluster_service";
    public static final String CAR_INTENT_ACTION_MEDIA_TEMPLATE = "android.car.intent.action.MEDIA_TEMPLATE";
    public static final String CAR_NAVIGATION_SERVICE = "car_navigation_service";
    public static final String CAR_NOT_CONNECTED_EXCEPTION_MSG = "CarNotConnected";
    private static final long CAR_SERVICE_BIND_MAX_RETRY = 20;
    private static final long CAR_SERVICE_BIND_RETRY_INTERVAL_MS = 500;
    private static final String CAR_SERVICE_CLASS = "com.android.car.CarService";
    public static final String CAR_SERVICE_INTERFACE_NAME = "android.car.ICar";
    private static final String CAR_SERVICE_PACKAGE = "com.android.car";
    public static final int CONNECTION_TYPE_EMBEDDED = 5;
    public static final String DIAGNOSTIC_SERVICE = "diagnostic";
    public static final String HVAC_SERVICE = "hvac";
    public static final String INFO_SERVICE = "info";
    public static final String PACKAGE_SERVICE = "package";
    public static final String PERMISSION_CAR_APP_FOCUS_FORCED = "harman.car.permission.APP_FOCUS_FORCED";
    public static final String PERMISSION_CAR_CABIN = "android.car.permission.CAR_CABIN";
    public static final String PERMISSION_CAR_CONTROL_AUDIO_SETTINGS = "android.car.permission.CAR_CONTROL_AUDIO_SETTINGS";
    public static final String PERMISSION_CAR_CONTROL_AUDIO_VOLUME = "android.car.permission.CAR_CONTROL_AUDIO_VOLUME";
    public static final String PERMISSION_CAR_DIAGNOSTIC_CLEAR = "android.car.permission.DIAGNOSTIC_CLEAR";
    public static final String PERMISSION_CAR_DIAGNOSTIC_READ_ALL = "android.car.permission.DIAGNOSTIC_READ_ALL";
    public static final String PERMISSION_CAR_DISPLAY_IN_CLUSTER = "android.car.permission.CAR_DISPLAY_IN_CLUSTER";
    public static final String PERMISSION_CAR_HVAC = "android.car.permission.CAR_HVAC";
    public static final String PERMISSION_CAR_INSTRUMENT_CLUSTER_CONTROL = "android.car.permission.CAR_INSTRUMENT_CLUSTER_CONTROL";
    public static final String PERMISSION_CAR_NAVIGATION_MANAGER = "android.car.permission.CAR_NAVIGATION_MANAGER";
    public static final String PERMISSION_CAR_POWER = "com.harman.car.permission.CAR_POWER";
    public static final String PERMISSION_CAR_PROJECTION = "android.car.permission.CAR_PROJECTION";
    public static final String PERMISSION_CAR_RADIO = "android.car.permission.CAR_RADIO";
    public static final String PERMISSION_CAR_TEST_SERVICE = "android.car.permission.CAR_TEST_SERVICE";
    public static final String PERMISSION_CONTROL_APP_BLOCKING = "android.car.permission.CONTROL_APP_BLOCKING";
    public static final String PERMISSION_FUEL = "android.car.permission.CAR_FUEL";
    public static final String PERMISSION_MILEAGE = "android.car.permission.CAR_MILEAGE";
    public static final String PERMISSION_MOCK_VEHICLE_HAL = "android.car.permission.CAR_MOCK_VEHICLE_HAL";
    public static final String PERMISSION_SPEED = "android.car.permission.CAR_SPEED";
    public static final String PERMISSION_VEHICLE_DYNAMICS_STATE = "android.car.permission.VEHICLE_DYNAMICS_STATE";
    public static final String PERMISSION_VENDOR_EXTENSION = "android.car.permission.CAR_VENDOR_EXTENSION";
    public static final String POWER_SERVICE = "power";
    public static final String PROJECTION_SERVICE = "projection";
    public static final String RADIO_SERVICE = "radio";
    public static final String SENSOR_SERVICE = "sensor";
    private static final int STATE_CONNECTED = 2;
    private static final int STATE_CONNECTING = 1;
    private static final int STATE_DISCONNECTED = 0;
    public static final String TEST_SERVICE = "car-service-test";
    public static final String VENDOR_EXTENSION_SERVICE = "vendor_extension";
    public static final int VERSION = 3;
    private final Object mCarManagerLock;



    @GuardedBy("this")
    private int mConnectionRetryCount;
    private final Runnable mConnectionRetryFailedRunnable;
    private final Runnable mConnectionRetryRunnable;

    @GuardedBy("this")
    private int mConnectionState;
    private final Context mContext;
    private final Handler mEventHandler;
    private final Handler mMainThreadEventHandler;
    private final boolean mOwnsService;

    @GuardedBy("this")
    private ICar mService;
    private final ServiceConnection mServiceConnectionListener;
    private final ServiceConnection mServiceConnectionListenerClient;

    @GuardedBy("mCarManagerLock")
    private final HashMap<String, CarManagerBase> mServiceMap;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ConnectionType {
    }

    public static Car createCar(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        if (!context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
            Log.e(CarLibLog.TAG_CAR, "FEATURE_AUTOMOTIVE not declared while android.car is used");
            return null;
        }
        try {
            return new Car(context, serviceConnectionListener, handler);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public static Car createCar(Context context, ServiceConnection serviceConnectionListener) {
        return createCar(context, serviceConnectionListener, null);
    }

    private Car(Context context, ServiceConnection serviceConnectionListener, Handler handler) {
        this.mConnectionRetryRunnable = new Runnable() { // from class: android.car.Car.1
            @Override // java.lang.Runnable
            public void run() {
                Car.this.startCarService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: android.car.Car.2
            @Override // java.lang.Runnable
            public void run() {
                Car.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName(Car.CAR_SERVICE_PACKAGE, Car.CAR_SERVICE_CLASS));
            }
        };
        this.mServiceConnectionListener = new ServiceConnection() { // from class: android.car.Car.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service) {
                synchronized (Car.this) {
                    Car.this.mService = ICar.Stub.asInterface(service);
                    Car.this.mConnectionState = 2;
                }
                Car.this.mServiceConnectionListenerClient.onServiceConnected(name, service);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                synchronized (Car.this) {
                    Car.this.mService = null;
                    if (Car.this.mConnectionState != 0) {
                        Car.this.mConnectionState = 0;
                        Car.this.disconnect();
                        Car.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
                    }
                }
            }
        };
        this.mCarManagerLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.mContext = context;
        this.mEventHandler = determineEventHandler(handler);
        this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
        this.mService = null;
        this.mOwnsService = true;
        this.mServiceConnectionListenerClient = serviceConnectionListener;
    }

    public Car(Context context, ICar service, Handler handler) {
        this.mConnectionRetryRunnable = new Runnable() { // from class: android.car.Car.1
            @Override // java.lang.Runnable
            public void run() {
                Car.this.startCarService();
            }
        };
        this.mConnectionRetryFailedRunnable = new Runnable() { // from class: android.car.Car.2
            @Override // java.lang.Runnable
            public void run() {
                Car.this.mServiceConnectionListener.onServiceDisconnected(new ComponentName(Car.CAR_SERVICE_PACKAGE, Car.CAR_SERVICE_CLASS));
            }
        };
        this.mServiceConnectionListener = new ServiceConnection() { // from class: android.car.Car.3
            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName name, IBinder service2) {
                synchronized (Car.this) {
                    Car.this.mService = ICar.Stub.asInterface(service2);
                    Car.this.mConnectionState = 2;
                }
                Car.this.mServiceConnectionListenerClient.onServiceConnected(name, service2);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName name) {
                synchronized (Car.this) {
                    Car.this.mService = null;
                    if (Car.this.mConnectionState != 0) {
                        Car.this.mConnectionState = 0;
                        Car.this.disconnect();
                        Car.this.mServiceConnectionListenerClient.onServiceDisconnected(name);
                    }
                }
            }
        };
        this.mCarManagerLock = new Object();
        this.mServiceMap = new HashMap<>();
        this.mContext = context;
        this.mEventHandler = determineEventHandler(handler);
        this.mMainThreadEventHandler = determineMainThreadEventHandler(this.mEventHandler);
        this.mService = service;
        this.mOwnsService = false;
        this.mConnectionState = 2;
        this.mServiceConnectionListenerClient = null;
    }

    private static Handler determineMainThreadEventHandler(Handler eventHandler) {
        Looper mainLooper = Looper.getMainLooper();
        return eventHandler.getLooper() == mainLooper ? eventHandler : new Handler(mainLooper);
    }

    private static Handler determineEventHandler(Handler handler) {
        if (handler == null) {
            Looper looper = Looper.getMainLooper();
            return new Handler(looper);
        }
        return handler;
    }

    public void connect() throws IllegalStateException {
        synchronized (this) {
            if (this.mConnectionState != 0) {
                throw new IllegalStateException("already connected or connecting");
            }
            this.mConnectionState = 1;
            startCarService();
        }
    }

    public void disconnect() {
        synchronized (this) {
            if (this.mConnectionState != 0) {
                this.mEventHandler.removeCallbacks(this.mConnectionRetryRunnable);
                this.mMainThreadEventHandler.removeCallbacks(this.mConnectionRetryFailedRunnable);
                this.mConnectionRetryCount = 0;
                tearDownCarManagers();
                this.mService = null;
                this.mConnectionState = 0;
                if (this.mOwnsService) {
                    this.mContext.unbindService(this.mServiceConnectionListener);
                }
            }
        }
    }

    public boolean isConnected() {
        boolean z;
        synchronized (this) {
            z = this.mService != null;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this) {
            z = this.mConnectionState == 1;
        }
        return z;
    }

    public Object getCarManager(String serviceName) throws CarNotConnectedException {
        ICar service = getICarOrThrow();
        synchronized (this.mCarManagerLock) {
            CarManagerBase manager = this.mServiceMap.get(serviceName);
            if (manager == null) {
                try {
                    IBinder binder = service.getCarService(serviceName);
                    if (binder == null) {
                        Log.w(CarLibLog.TAG_CAR, "getCarManager could not get binder for service:" + serviceName);
                        return null;
                    }
                    manager = createCarManager(serviceName, binder);
                    if (manager == null) {
                        Log.w(CarLibLog.TAG_CAR, "getCarManager could not create manager for service:" + serviceName);
                        return null;
                    }
                    this.mServiceMap.put(serviceName, manager);
                } catch (RemoteException e) {
                    handleRemoteException(e);
                }
            }
            return manager;
        }
    }

    public int getCarConnectionType() {
        return 5;
    }

    public static void checkCarNotConnectedExceptionFromCarService(IllegalStateException e) throws IllegalStateException, CarNotConnectedException {
        String message = e.getMessage();
        if ("CarNotConnected".equals(message)) {
            throw new CarNotConnectedException();
        }
        throw e;
    }

    public static void hideCarNotConnectedExceptionFromCarService(IllegalStateException e) throws IllegalStateException {
        String message = e.getMessage();
        if ("CarNotConnected".equals(message)) {
            return;
        }
        throw e;
    }

    private CarManagerBase createCarManager(String serviceName, IBinder binder) throws CarNotConnectedException {
        int hash = serviceName.hashCode();
        switch (hash) {
            case -1969960369: if (serviceName.equals(PROJECTION_SERVICE)) return new CarProjectionManager(binder, this.mEventHandler); break;
            case -1855028221: if (serviceName.equals(BLUETOOTH_SERVICE)) return new CarBluetoothManager(binder, this.mContext); break;
            case -1853877803: if (serviceName.equals(CAR_NAVIGATION_SERVICE)) return new CarNavigationStatusManager(binder); break;
            case -1547904089: if (serviceName.equals(DIAGNOSTIC_SERVICE)) return new CarDiagnosticManager(binder, this.mContext, this.mEventHandler); break;
            case -905948230:  if (serviceName.equals(SENSOR_SERVICE)) return new CarSensorManager(binder, this.mContext, this.mEventHandler); break;
            case -874200568:  if (serviceName.equals(VENDOR_EXTENSION_SERVICE)) return new CarVendorExtensionManager(binder, this.mEventHandler); break;
            case -807062458:  if (serviceName.equals(PACKAGE_SERVICE)) return new CarPackageManager(binder, this.mContext); break;
            case -603093501:  if (serviceName.equals(TEST_SERVICE)) return new CarTestManagerBinderWrapper(binder); break;
            case 3214768:      if (serviceName.equals(HVAC_SERVICE)) return new CarHvacManager(binder, this.mContext, this.mEventHandler); break;
            case 3237038:      if (serviceName.equals(INFO_SERVICE)) return new CarInfoManager(binder); break;
            case 93166550:     if (serviceName.equals(AUDIO_SERVICE)) return new CarAudioManager(binder, this.mContext, this.mEventHandler); break;
            case 94415849:     if (serviceName.equals(CABIN_SERVICE)) return new CarCabinManager(binder, this.mContext, this.mEventHandler); break;
            case 106858757:    if (serviceName.equals(POWER_SERVICE)) return new CarPowerManager(binder, this.mContext, this.mEventHandler); break;
            case 1644291440:   if (serviceName.equals(CAR_INSTRUMENT_CLUSTER_SERVICE)) return new CarInstrumentClusterManager(binder, this.mEventHandler); break;
            case 1830376762:   if (serviceName.equals(APP_FOCUS_SERVICE)) return new CarAppFocusManager(binder, this.mEventHandler); break;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startCarService() {
        Intent intent = new Intent();
        intent.setPackage(CAR_SERVICE_PACKAGE);
        intent.setAction(CAR_SERVICE_INTERFACE_NAME);
        boolean bound = this.mContext.bindServiceAsUser(intent, this.mServiceConnectionListener, 1, UserHandle.CURRENT_OR_SELF);
        if (!bound) {
            this.mConnectionRetryCount++;
            if (this.mConnectionRetryCount > CAR_SERVICE_BIND_MAX_RETRY) {
                Log.w(CarLibLog.TAG_CAR, "cannot bind to car service after max retry");
                this.mMainThreadEventHandler.post(this.mConnectionRetryFailedRunnable);
                return;
            } else {
                this.mEventHandler.postDelayed(this.mConnectionRetryRunnable, CAR_SERVICE_BIND_RETRY_INTERVAL_MS);
                return;
            }
        }
        this.mConnectionRetryCount = 0;
    }

    private synchronized ICar getICarOrThrow() throws IllegalStateException {
        if (this.mService == null) {
            throw new IllegalStateException("not connected");
        }
        return this.mService;
    }

    private void handleRemoteException(RemoteException e) {
        Log.w(CarLibLog.TAG_CAR, "RemoteException", e);
        disconnect();
    }

    private void tearDownCarManagers() {
        synchronized (this.mCarManagerLock) {
            for (CarManagerBase manager : this.mServiceMap.values()) {
                manager.onCarDisconnected();
            }
            this.mServiceMap.clear();
        }
    }
}