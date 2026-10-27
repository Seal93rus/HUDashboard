package android.car;

import android.bluetooth.BluetoothDevice;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ICarBluetooth extends IInterface {
    void clearBluetoothDeviceConnectionPriority(int i, int i2) throws RemoteException;

    String getDeviceNameWithPriority(int i, int i2) throws RemoteException;

    int getPriority(BluetoothDevice bluetoothDevice, int i) throws RemoteException;

    boolean isConnectionAllowed(BluetoothDevice bluetoothDevice, int i) throws RemoteException;

    boolean isPriorityDevicePresent(int i, int i2) throws RemoteException;

    void pauseAutoconnect() throws RemoteException;

    void setAutoconnect(BluetoothDevice bluetoothDevice, int i, boolean z) throws RemoteException;

    void setBluetoothDeviceConnectionPriority(BluetoothDevice bluetoothDevice, int i, int i2) throws RemoteException;

    void setConnectionRule(BluetoothDevice bluetoothDevice, int i, boolean z) throws RemoteException;

    void setEnableAutoConnectForProfiles(int i, boolean z) throws RemoteException;

    void setPriority(BluetoothDevice bluetoothDevice, int i, int i2) throws RemoteException;

    void startAutoconnect(boolean z, boolean z2) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarBluetooth {
        private static final String DESCRIPTOR = "android.car.ICarBluetooth";
        static final int TRANSACTION_clearBluetoothDeviceConnectionPriority = 2;
        static final int TRANSACTION_getDeviceNameWithPriority = 4;
        static final int TRANSACTION_getPriority = 8;
        static final int TRANSACTION_isConnectionAllowed = 10;
        static final int TRANSACTION_isPriorityDevicePresent = 3;
        static final int TRANSACTION_pauseAutoconnect = 6;
        static final int TRANSACTION_setAutoconnect = 11;
        static final int TRANSACTION_setBluetoothDeviceConnectionPriority = 1;
        static final int TRANSACTION_setConnectionRule = 9;
        static final int TRANSACTION_setEnableAutoConnectForProfiles = 12;
        static final int TRANSACTION_setPriority = 7;
        static final int TRANSACTION_startAutoconnect = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarBluetooth asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ICarBluetooth)) {
                return (ICarBluetooth) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            BluetoothDevice _arg0;
            BluetoothDevice _arg02;
            BluetoothDevice _arg03;
            BluetoothDevice _arg04;
            BluetoothDevice _arg05;
            BluetoothDevice _arg06;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg06 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg06 = null;
                    }
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    setBluetoothDeviceConnectionPriority(_arg06, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    int _arg12 = data.readInt();
                    clearBluetoothDeviceConnectionPriority(_arg07, _arg12);
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg08 = data.readInt();
                    int _arg13 = data.readInt();
                    boolean _result = isPriorityDevicePresent(_arg08, _arg13);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    int _arg14 = data.readInt();
                    String _result2 = getDeviceNameWithPriority(_arg09, _arg14);
                    reply.writeNoException();
                    reply.writeString(_result2);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg010 = data.readInt() != 0;
                    boolean _arg15 = data.readInt() != 0;
                    startAutoconnect(_arg010, _arg15);
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    pauseAutoconnect();
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg05 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg05 = null;
                    }
                    int _arg16 = data.readInt();
                    int _arg22 = data.readInt();
                    setPriority(_arg05, _arg16, _arg22);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg04 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg04 = null;
                    }
                    int _arg17 = data.readInt();
                    int _result3 = getPriority(_arg04, _arg17);
                    reply.writeNoException();
                    reply.writeInt(_result3);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    int _arg18 = data.readInt();
                    boolean _arg23 = data.readInt() != 0;
                    setConnectionRule(_arg03, _arg18, _arg23);
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    int _arg19 = data.readInt();
                    boolean _result4 = isConnectionAllowed(_arg02, _arg19);
                    reply.writeNoException();
                    reply.writeInt(_result4 ? 1 : 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = (BluetoothDevice) BluetoothDevice.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    int _arg110 = data.readInt();
                    boolean _arg24 = data.readInt() != 0;
                    setAutoconnect(_arg0, _arg110, _arg24);
                    reply.writeNoException();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg011 = data.readInt();
                    boolean _arg111 = data.readInt() != 0;
                    setEnableAutoConnectForProfiles(_arg011, _arg111);
                    reply.writeNoException();
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICarBluetooth {
            private IBinder mRemote;

            Proxy(IBinder remote) {
                this.mRemote = remote;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.car.ICarBluetooth
            public void setBluetoothDeviceConnectionPriority(BluetoothDevice deviceToSet, int profileToSet, int priorityToSet) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (deviceToSet != null) {
                        _data.writeInt(1);
                        deviceToSet.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profileToSet);
                    _data.writeInt(priorityToSet);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void clearBluetoothDeviceConnectionPriority(int profileToClear, int priorityToClear) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(profileToClear);
                    _data.writeInt(priorityToClear);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public boolean isPriorityDevicePresent(int profile, int priorityToCheck) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(profile);
                    _data.writeInt(priorityToCheck);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public String getDeviceNameWithPriority(int profile, int priorityToCheck) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(profile);
                    _data.writeInt(priorityToCheck);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void startAutoconnect(boolean restart, boolean skipFav) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(restart ? 1 : 0);
                    _data.writeInt(skipFav ? 1 : 0);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void pauseAutoconnect() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void setPriority(BluetoothDevice dev, int profile, int prio) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dev != null) {
                        _data.writeInt(1);
                        dev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profile);
                    _data.writeInt(prio);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public int getPriority(BluetoothDevice dev, int profile) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dev != null) {
                        _data.writeInt(1);
                        dev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profile);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void setConnectionRule(BluetoothDevice dev, int profile, boolean allow) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dev != null) {
                        _data.writeInt(1);
                        dev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profile);
                    _data.writeInt(allow ? 1 : 0);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public boolean isConnectionAllowed(BluetoothDevice dev, int profile) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dev != null) {
                        _data.writeInt(1);
                        dev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profile);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void setAutoconnect(BluetoothDevice dev, int profile, boolean autoconnect) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (dev != null) {
                        _data.writeInt(1);
                        dev.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(profile);
                    _data.writeInt(autoconnect ? 1 : 0);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.ICarBluetooth
            public void setEnableAutoConnectForProfiles(int profile, boolean enableAutoConnectForProfile) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(profile);
                    _data.writeInt(enableAutoConnectForProfile ? 1 : 0);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}