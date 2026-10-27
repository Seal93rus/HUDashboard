package com.seal93rus.HUdashboard.radio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.seal93rus.HUdashboard.radio.RadioEngineerData;
import com.seal93rus.HUdashboard.radio.RadioStation;

/* JADX INFO: loaded from: classes.dex */
public interface IRadioServiceCallback extends IInterface {
    void onAntennaStatusChanged(int i) throws RemoteException;

    void onAudioFocusChanged(int i) throws RemoteException;

    void onEngineerDataChanged(RadioEngineerData radioEngineerData) throws RemoteException;

    void onError(int i) throws RemoteException;

    void onHardKeyMuted(int i) throws RemoteException;

    void onNavigationRegionChanged() throws RemoteException;

    void onPresetListChanged() throws RemoteException;

    void onRadioBandChanged(int i) throws RemoteException;

    void onRadioDataBaseReady() throws RemoteException;

    void onRadioMuteChanged(boolean z) throws RemoteException;

    void onRadioStationChanged(RadioStation radioStation) throws RemoteException;

    void onRadioStationListChanged() throws RemoteException;

    void onSearchStationsChanged(int i) throws RemoteException;

    void onSearchStationsDone() throws RemoteException;

    void onSearchStationsInterrupted() throws RemoteException;

    void onTaAudioFocusChanged(int i) throws RemoteException;

    void onTaModeChanged(boolean z) throws RemoteException;

    void onTrafficAnnouncement(boolean z) throws RemoteException;

    public static abstract class Stub extends Binder implements IRadioServiceCallback {
        private static final String DESCRIPTOR = "com.example.virtualdisplaytest.radio.IRadioServiceCallback";
        static final int TRANSACTION_onAntennaStatusChanged = 15;
        static final int TRANSACTION_onAudioFocusChanged = 7;
        static final int TRANSACTION_onEngineerDataChanged = 13;
        static final int TRANSACTION_onError = 9;
        static final int TRANSACTION_onHardKeyMuted = 14;
        static final int TRANSACTION_onNavigationRegionChanged = 12;
        static final int TRANSACTION_onPresetListChanged = 3;
        static final int TRANSACTION_onRadioBandChanged = 5;
        static final int TRANSACTION_onRadioDataBaseReady = 8;
        static final int TRANSACTION_onRadioMuteChanged = 6;
        static final int TRANSACTION_onRadioStationChanged = 1;
        static final int TRANSACTION_onRadioStationListChanged = 2;
        static final int TRANSACTION_onSearchStationsChanged = 4;
        static final int TRANSACTION_onSearchStationsDone = 10;
        static final int TRANSACTION_onSearchStationsInterrupted = 11;
        static final int TRANSACTION_onTaAudioFocusChanged = 17;
        static final int TRANSACTION_onTaModeChanged = 18;
        static final int TRANSACTION_onTrafficAnnouncement = 16;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRadioServiceCallback asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRadioServiceCallback)) {
                return (IRadioServiceCallback) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            boolean _arg0;
            RadioEngineerData _arg02;
            RadioStation _arg03;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg03 = RadioStation.CREATOR.createFromParcel(data);
                    } else {
                        _arg03 = null;
                    }
                    onRadioStationChanged(_arg03);
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioStationListChanged();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    onPresetListChanged();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    onSearchStationsChanged(data.readInt());
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioBandChanged(data.readInt());
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    onRadioMuteChanged(_arg0);
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    onAudioFocusChanged(data.readInt());
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    onRadioDataBaseReady();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    onError(data.readInt());
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    onSearchStationsDone();
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    onSearchStationsInterrupted();
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    onNavigationRegionChanged();
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = RadioEngineerData.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    onEngineerDataChanged(_arg02);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    onHardKeyMuted(data.readInt());
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    onAntennaStatusChanged(data.readInt());
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    onTrafficAnnouncement(_arg0);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    onTaAudioFocusChanged(data.readInt());
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    _arg0 = data.readInt() != 0;
                    onTaModeChanged(_arg0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRadioServiceCallback {
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

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onRadioStationChanged(RadioStation station) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (station != null) {
                        _data.writeInt(1);
                        station.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(1, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onRadioStationListChanged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onPresetListChanged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onSearchStationsChanged(int radioBand) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(radioBand);
                    this.mRemote.transact(4, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onRadioBandChanged(int radioBand) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(radioBand);
                    this.mRemote.transact(5, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onRadioMuteChanged(boolean isMuted) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(isMuted ? 1 : 0);
                    this.mRemote.transact(6, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onAudioFocusChanged(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(7, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onRadioDataBaseReady() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onError(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(9, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onSearchStationsDone() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onSearchStationsInterrupted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onNavigationRegionChanged() throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onEngineerDataChanged(RadioEngineerData data) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (data != null) {
                        _data.writeInt(1);
                        data.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(13, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onHardKeyMuted(int muted) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(muted);
                    this.mRemote.transact(14, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onAntennaStatusChanged(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(15, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onTrafficAnnouncement(boolean active) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(active ? 1 : 0);
                    this.mRemote.transact(16, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onTaAudioFocusChanged(int status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status);
                    this.mRemote.transact(17, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceCallback
            public void onTaModeChanged(boolean status) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(status ? 1 : 0);
                    this.mRemote.transact(18, _data, null, 1);
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}