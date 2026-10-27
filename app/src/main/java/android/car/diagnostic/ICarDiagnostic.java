package android.car.diagnostic;

import android.car.diagnostic.ICarDiagnosticEventListener;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public interface ICarDiagnostic extends IInterface {
    boolean clearFreezeFrames(long[] jArr) throws RemoteException;

    CarDiagnosticEvent getFreezeFrame(long j) throws RemoteException;

    long[] getFreezeFrameTimestamps() throws RemoteException;

    CarDiagnosticEvent getLatestLiveFrame() throws RemoteException;

    boolean isClearFreezeFramesSupported() throws RemoteException;

    boolean isFreezeFrameNotificationSupported() throws RemoteException;

    boolean isGetFreezeFrameSupported() throws RemoteException;

    boolean isLiveFrameSupported() throws RemoteException;

    boolean registerOrUpdateDiagnosticListener(int i, int i2, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException;

    void unregisterDiagnosticListener(int i, ICarDiagnosticEventListener iCarDiagnosticEventListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ICarDiagnostic {
        private static final String DESCRIPTOR = "android.car.diagnostic.ICarDiagnostic";
        static final int TRANSACTION_clearFreezeFrames = 6;
        static final int TRANSACTION_getFreezeFrame = 5;
        static final int TRANSACTION_getFreezeFrameTimestamps = 4;
        static final int TRANSACTION_getLatestLiveFrame = 3;
        static final int TRANSACTION_isClearFreezeFramesSupported = 11;
        static final int TRANSACTION_isFreezeFrameNotificationSupported = 9;
        static final int TRANSACTION_isGetFreezeFrameSupported = 10;
        static final int TRANSACTION_isLiveFrameSupported = 8;
        static final int TRANSACTION_registerOrUpdateDiagnosticListener = 2;
        static final int TRANSACTION_unregisterDiagnosticListener = 7;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ICarDiagnostic asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof ICarDiagnostic)) {
                return (ICarDiagnostic) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            switch (code) {
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    ICarDiagnosticEventListener _arg2 = ICarDiagnosticEventListener.Stub.asInterface(data.readStrongBinder());
                    boolean _result = registerOrUpdateDiagnosticListener(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    CarDiagnosticEvent _result2 = getLatestLiveFrame();
                    reply.writeNoException();
                    if (_result2 != null) {
                        reply.writeInt(1);
                        _result2.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _result3 = getFreezeFrameTimestamps();
                    reply.writeNoException();
                    reply.writeLongArray(_result3);
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    long _arg02 = data.readLong();
                    CarDiagnosticEvent _result4 = getFreezeFrame(_arg02);
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(1);
                        _result4.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    long[] _arg03 = data.createLongArray();
                    boolean _result5 = clearFreezeFrames(_arg03);
                    reply.writeNoException();
                    reply.writeInt(_result5 ? 1 : 0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    ICarDiagnosticEventListener _arg12 = ICarDiagnosticEventListener.Stub.asInterface(data.readStrongBinder());
                    unregisterDiagnosticListener(_arg04, _arg12);
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result6 = isLiveFrameSupported();
                    reply.writeNoException();
                    reply.writeInt(_result6 ? 1 : 0);
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result7 = isFreezeFrameNotificationSupported();
                    reply.writeNoException();
                    reply.writeInt(_result7 ? 1 : 0);
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result8 = isGetFreezeFrameSupported();
                    reply.writeNoException();
                    reply.writeInt(_result8 ? 1 : 0);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result9 = isClearFreezeFramesSupported();
                    reply.writeNoException();
                    reply.writeInt(_result9 ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements ICarDiagnostic {
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

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean registerOrUpdateDiagnosticListener(int frameType, int rate, ICarDiagnosticEventListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(frameType);
                    _data.writeInt(rate);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public CarDiagnosticEvent getLatestLiveFrame() throws RemoteException {
                CarDiagnosticEvent _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = CarDiagnosticEvent.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public long[] getFreezeFrameTimestamps() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                    long[] _result = _reply.createLongArray();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public CarDiagnosticEvent getFreezeFrame(long timestamp) throws RemoteException {
                CarDiagnosticEvent _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLong(timestamp);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = CarDiagnosticEvent.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean clearFreezeFrames(long[] timestamps) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeLongArray(timestamps);
                    this.mRemote.transact(6, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public void unregisterDiagnosticListener(int frameType, ICarDiagnosticEventListener callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(frameType);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isLiveFrameSupported() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isFreezeFrameNotificationSupported() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isGetFreezeFrameSupported() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // android.car.diagnostic.ICarDiagnostic
            public boolean isClearFreezeFramesSupported() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}