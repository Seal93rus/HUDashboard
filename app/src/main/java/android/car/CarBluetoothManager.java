package android.car;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes.dex */
public final class CarBluetoothManager implements CarManagerBase {
    public static final String ACTION_AUTOCONNECT_CONNECTION_FAILED = "harman.android.car.bluetooth.autoconnect_failed";
    public static final int BLUETOOTH_DEVICE_CONNECTION_PRIORITY_0 = 0;
    public static final int BLUETOOTH_DEVICE_CONNECTION_PRIORITY_1 = 1;
    public static final String BLUETOOTH_NO_PRIORITY_DEVICE = "";
    public static final String EXTRA_PROFILE = "harman.android.car.bluetooth.autoconnect_profile";
    private static final String TAG = "CarBluetoothManager";
    private final Context mContext;
    private final ICarBluetooth mService;

    @Retention(RetentionPolicy.SOURCE)
    public @interface PriorityType {
    }

    public void setBluetoothDeviceConnectionPriority(BluetoothDevice deviceToSet, int profileToSet, int priorityToSet) throws CarNotConnectedException {
        try {
            this.mService.setBluetoothDeviceConnectionPriority(deviceToSet, profileToSet, priorityToSet);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setBluetoothDeviceConnectionPriority failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void clearBluetoothDeviceConnectionPriority(int profileToClear, int priorityToClear) throws CarNotConnectedException {
        try {
            this.mService.clearBluetoothDeviceConnectionPriority(profileToClear, priorityToClear);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "clearBluetoothDeviceConnectionPriority failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public boolean isPriorityDevicePresent(int profile, int priorityToCheck) throws CarNotConnectedException {
        try {
            return this.mService.isPriorityDevicePresent(profile, priorityToCheck);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "isPrioritySet failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public String getDeviceNameWithPriority(int profile, int priorityToCheck) throws CarNotConnectedException {
        try {
            return this.mService.getDeviceNameWithPriority(profile, priorityToCheck);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getDeviceNameWithPriority failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void startAutoconnect(boolean restart, boolean skipFav) throws IllegalStateException, CarNotConnectedException {
        try {
            this.mService.startAutoconnect(restart, skipFav);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "startAutoconnect failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void pauseAutoconnect() throws IllegalStateException, CarNotConnectedException {
        try {
            this.mService.pauseAutoconnect();
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "pauseAutoconnect failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setPriority(BluetoothDevice device, int profile, int prio) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            this.mService.setPriority(device, profile, prio);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setPriority failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public int getPriority(BluetoothDevice device, int profile) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            return this.mService.getPriority(device, profile);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "getPriority failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setConnectionRule(BluetoothDevice device, boolean allow) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        setConnectionRule(device, 19, allow);
    }

    public void setConnectionRule(BluetoothDevice device, int profile, boolean allow) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            this.mService.setConnectionRule(device, profile, allow);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setConnectionRule failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public boolean isConnectionAllowed(BluetoothDevice device, int profile) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            return this.mService.isConnectionAllowed(device, profile);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "isConnectionAllowed failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setAutoconnect(BluetoothDevice device, int profile, boolean autoconnect) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            this.mService.setAutoconnect(device, profile, autoconnect);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setAutoconnect failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public void setEnableAutoConnectForProfiles(int profile, boolean enableAutoConnectForProfile) throws IllegalStateException, CarNotConnectedException, IllegalArgumentException {
        try {
            this.mService.setEnableAutoConnectForProfiles(profile, enableAutoConnectForProfile);
        } catch (RemoteException e) {
            Log.e(CarLibLog.TAG_CAR, "setEnableAutoConnectForProfiles failed", e);
            throw new CarNotConnectedException(e);
        }
    }

    public CarBluetoothManager(IBinder service, Context context) {
        this.mContext = context;
        this.mService = ICarBluetooth.Stub.asInterface(service);
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
    }
}