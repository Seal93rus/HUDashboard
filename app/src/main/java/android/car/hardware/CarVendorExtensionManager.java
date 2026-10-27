package android.car.hardware;

import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.car.hardware.property.CarPropertyManagerBase;
import android.os.Handler;
import android.os.IBinder;
import android.util.ArraySet;
import com.android.internal.annotations.GuardedBy;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class CarVendorExtensionManager implements CarManagerBase {
    private static final boolean DBG = false;
    private static final String TAG = CarVendorExtensionManager.class.getSimpleName();

    @GuardedBy("mLock")
    private ArraySet<CarVendorExtensionCallback> mCallbacks;
    private final Object mLock = new Object();
    private final CarPropertyManagerBase mPropertyManager;

    public interface CarVendorExtensionCallback {
        void onChangeEvent(android.car.hardware.CarPropertyValue carPropertyValue);

        void onErrorEvent(int i, int i2);
    }

    public CarVendorExtensionManager(IBinder service, Handler handler) {
        this.mPropertyManager = new CarPropertyManagerBase(service, handler, false, TAG);
    }

    public void registerCallback(CarVendorExtensionCallback callback) throws CarNotConnectedException {
        synchronized (this.mLock) {
            if (this.mCallbacks == null) {
                this.mPropertyManager.registerCallback(new CarPropertyManagerBase.CarPropertyEventCallback() { // from class: android.car.hardware.CarVendorExtensionManager.1
                    @Override // android.car.hardware.property.CarPropertyManagerBase.CarPropertyEventCallback
                    public void onChangeEvent(CarPropertyValue value) {
                        for (CarVendorExtensionCallback listener : CarVendorExtensionManager.this.getCallbacks()) {
                            listener.onChangeEvent(value);
                        }
                    }

                    @Override // android.car.hardware.property.CarPropertyManagerBase.CarPropertyEventCallback
                    public void onErrorEvent(int propertyId, int zone) {
                        for (CarVendorExtensionCallback listener : CarVendorExtensionManager.this.getCallbacks()) {
                            listener.onErrorEvent(propertyId, zone);
                        }
                    }
                });
                this.mCallbacks = new ArraySet<>(1);
            }
            this.mCallbacks.add(callback);
        }
    }

    public void unregisterCallback(CarVendorExtensionCallback callback) {
        synchronized (this.mLock) {
            this.mCallbacks.remove(callback);
            if (this.mCallbacks.isEmpty()) {
                this.mPropertyManager.unregisterCallback();
                this.mCallbacks = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CarVendorExtensionCallback[] getCallbacks() {
        CarVendorExtensionCallback[] carVendorExtensionCallbackArr;
        synchronized (this.mLock) {
            carVendorExtensionCallbackArr = (CarVendorExtensionCallback[]) this.mCallbacks.toArray(new CarVendorExtensionCallback[this.mCallbacks.size()]);
        }
        return carVendorExtensionCallbackArr;
    }

    public List<CarPropertyConfig> getProperties() throws CarNotConnectedException {
        return this.mPropertyManager.getPropertyList();
    }

    public <E> E getGlobalProperty(Class<E> cls, int i) throws CarNotConnectedException {
        return (E) getProperty(cls, i, 0);
    }

    public <E> E getProperty(Class<E> propertyClass, int propId, int area) throws CarNotConnectedException {
        return this.mPropertyManager.getProperty(propertyClass, propId, area).getValue();
    }

    public <E> void setGlobalProperty(Class<E> propertyClass, int propId, E value) throws CarNotConnectedException {
        this.mPropertyManager.setProperty(propertyClass, propId, 0, value);
    }

    public <E> void setProperty(Class<E> propertyClass, int propId, int area, E value) throws CarNotConnectedException {
        this.mPropertyManager.setProperty(propertyClass, propId, area, value);
    }

    @Override // android.car.CarManagerBase
    public void onCarDisconnected() {
        this.mPropertyManager.onCarDisconnected();
    }
}