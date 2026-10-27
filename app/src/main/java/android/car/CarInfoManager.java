package android.car;

import android.car.annotation.FutureFeature;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.android.internal.annotations.GuardedBy;

/* JADX INFO: loaded from: classes.dex */
public final class CarInfoManager implements CarManagerBase {
    public static final String BASIC_INFO_KEY_MANUFACTURER = "android.car.manufacturer";
    public static final String BASIC_INFO_KEY_MODEL = "android.car.model";
    public static final String BASIC_INFO_KEY_MODEL_YEAR = "android.car.model-year";
    public static final String BASIC_INFO_KEY_VEHICLE_ID = "android.car.vehicle-id";
    public static final String INFO_KEY_PRODUCT_CONFIGURATION = "android.car.product-config";
    public static final String KEY_FUEL_CAPACITY = "android.car.fuel-capacity";

    @GuardedBy("this")
    private Bundle mBasicInfo;
    private final ICarInfo mService;

    public String getManufacturer() throws CarNotConnectedException {
        return getBasicInfo().getString(BASIC_INFO_KEY_MANUFACTURER);
    }

    public String getModel() throws CarNotConnectedException {
        return getBasicInfo().getString(BASIC_INFO_KEY_MODEL);
    }

    public String getModelYear() throws CarNotConnectedException {
        return getBasicInfo().getString(BASIC_INFO_KEY_MODEL_YEAR);
    }

    public String getVehicleId() throws CarNotConnectedException {
        return getBasicInfo().getString(BASIC_INFO_KEY_VEHICLE_ID);
    }

    public String getFuelCapacity() throws CarNotConnectedException {
        return getBasicInfo().getString(KEY_FUEL_CAPACITY);
    }

    @FutureFeature
    public String getProductConfiguration() throws CarNotConnectedException {
        try {
            return this.mService.getStringInfo(INFO_KEY_PRODUCT_CONFIGURATION);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        } catch (IllegalStateException e2) {
            CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
            return null;
        }
    }

    private synchronized Bundle getBasicInfo() throws CarNotConnectedException {
        Bundle bundle;
        if (this.mBasicInfo != null) {
            bundle = this.mBasicInfo;
        } else {
            try {
                this.mBasicInfo = this.mService.getBasicInfo();
            } catch (RemoteException e) {
                throw new CarNotConnectedException(e);
            } catch (IllegalStateException e2) {
                CarApiUtil.checkCarNotConnectedExceptionFromCarService(e2);
            }
            bundle = this.mBasicInfo;
        }
        return bundle;
    }

    CarInfoManager(IBinder service) {
        this.mService = ICarInfo.Stub.asInterface(service);
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
        synchronized (this) {
            this.mBasicInfo = null;
        }
    }
}