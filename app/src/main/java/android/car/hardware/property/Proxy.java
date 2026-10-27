package android.car.hardware.property;

import android.os.RemoteException;

public interface Proxy {
    void onEvent(CarPropertyEvent event) throws RemoteException;
}
