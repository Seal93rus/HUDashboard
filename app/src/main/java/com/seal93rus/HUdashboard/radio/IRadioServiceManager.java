package com.seal93rus.HUdashboard.radio;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.seal93rus.HUdashboard.radio.IRadioServiceCallback;
import com.seal93rus.HUdashboard.radio.RadioEngineerData;
import com.seal93rus.HUdashboard.radio.RadioStation;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface IRadioServiceManager extends IInterface {
    void abandonRadioAudioFocus() throws RemoteException;

    void addRadioServiceCallback(IRadioServiceCallback iRadioServiceCallback) throws RemoteException;

    boolean autoStore() throws RemoteException;

    void cancelSeek() throws RemoteException;

    boolean cancelTA() throws RemoteException;

    boolean diagonse_setFrequency(int i) throws RemoteException;

    int diagonse_switchToBand(int i) throws RemoteException;

    List<RadioStation> getAllPresetList() throws RemoteException;

    List<RadioStation> getAllStationList() throws RemoteException;

    int getAudioFocusStatus() throws RemoteException;

    List<RadioStation> getCurrentPresetList() throws RemoteException;

    RadioStation getCurrentStation() throws RemoteException;

    List<RadioStation> getCurrentStationList() throws RemoteException;

    String getCurrentStationName() throws RemoteException;

    int getFrequencyWithStationName(int i, String str) throws RemoteException;

    List<RadioStation> getPresetListWithBand(int i) throws RemoteException;

    RadioEngineerData getRadioEngineerData() throws RemoteException;

    List<RadioStation> getSearchResultList() throws RemoteException;

    List<RadioStation> getStationListWithBand(int i) throws RemoteException;

    String getStationNameWithFrequency(int i) throws RemoteException;

    int getStoredRadioBand() throws RemoteException;

    int getStoredRadioFrequency(int i) throws RemoteException;

    boolean getStoredRadioMuted() throws RemoteException;

    boolean getTaMode() throws RemoteException;

    boolean hasFocus() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    boolean isMuted() throws RemoteException;

    boolean mute() throws RemoteException;

    int openRadioBand(int i) throws RemoteException;

    void play() throws RemoteException;

    void removeRadioServiceCallback(IRadioServiceCallback iRadioServiceCallback) throws RemoteException;

    int requestRadioAudioFocus() throws RemoteException;

    boolean saveCurrentStation(RadioStation radioStation) throws RemoteException;

    boolean savePresetList(List<RadioStation> list) throws RemoteException;

    boolean savePresetListWithBand(int i, List<RadioStation> list) throws RemoteException;

    void saveSearchStationList(int i, List<RadioStation> list) throws RemoteException;

    void scanDown() throws RemoteException;

    void scanUp() throws RemoteException;

    boolean searchStations() throws RemoteException;

    void seekDown() throws RemoteException;

    void seekUp() throws RemoteException;

    void setEngineerMode(boolean z) throws RemoteException;

    void setFrequency(int i) throws RemoteException;

    void setRadioBackGroundRun(boolean z) throws RemoteException;

    boolean setStationWithName(int i, String str) throws RemoteException;

    void setTaMode(boolean z) throws RemoteException;

    boolean startBackgroundSearch() throws RemoteException;

    void storedRadioBand(int i) throws RemoteException;

    void storedRadioFrequency(int i, int i2) throws RemoteException;

    void storedRadioMuted(boolean z) throws RemoteException;

    void tune(RadioStation radioStation) throws RemoteException;

    void tuneDown() throws RemoteException;

    void tuneUp() throws RemoteException;

    boolean unMute() throws RemoteException;

    public static abstract class Stub extends Binder implements IRadioServiceManager {
        private static final String DESCRIPTOR = "com.harman.radioservice.IRadioServiceManager";
        static final int TRANSACTION_abandonRadioAudioFocus = 36;
        static final int TRANSACTION_addRadioServiceCallback = 44;
        static final int TRANSACTION_autoStore = 20;
        static final int TRANSACTION_cancelSeek = 9;
        static final int TRANSACTION_cancelTA = 52;
        static final int TRANSACTION_diagonse_setFrequency = 43;
        static final int TRANSACTION_diagonse_switchToBand = 42;
        static final int TRANSACTION_getAllPresetList = 33;
        static final int TRANSACTION_getAllStationList = 30;
        static final int TRANSACTION_getAudioFocusStatus = 51;
        static final int TRANSACTION_getCurrentPresetList = 31;
        static final int TRANSACTION_getCurrentStation = 13;
        static final int TRANSACTION_getCurrentStationList = 28;
        static final int TRANSACTION_getCurrentStationName = 14;
        static final int TRANSACTION_getFrequencyWithStationName = 16;
        static final int TRANSACTION_getPresetListWithBand = 32;
        static final int TRANSACTION_getRadioEngineerData = 50;
        static final int TRANSACTION_getSearchResultList = 46;
        static final int TRANSACTION_getStationListWithBand = 29;
        static final int TRANSACTION_getStationNameWithFrequency = 15;
        static final int TRANSACTION_getStoredRadioBand = 10;
        static final int TRANSACTION_getStoredRadioFrequency = 11;
        static final int TRANSACTION_getStoredRadioMuted = 12;
        static final int TRANSACTION_getTaMode = 54;
        static final int TRANSACTION_hasFocus = 38;
        static final int TRANSACTION_isInitialized = 37;
        static final int TRANSACTION_isMuted = 41;
        static final int TRANSACTION_mute = 39;
        static final int TRANSACTION_openRadioBand = 34;
        static final int TRANSACTION_play = 48;
        static final int TRANSACTION_removeRadioServiceCallback = 45;
        static final int TRANSACTION_requestRadioAudioFocus = 35;
        static final int TRANSACTION_saveCurrentStation = 24;
        static final int TRANSACTION_savePresetList = 25;
        static final int TRANSACTION_savePresetListWithBand = 26;
        static final int TRANSACTION_saveSearchStationList = 27;
        static final int TRANSACTION_scanDown = 8;
        static final int TRANSACTION_scanUp = 7;
        static final int TRANSACTION_searchStations = 18;
        static final int TRANSACTION_seekDown = 6;
        static final int TRANSACTION_seekUp = 5;
        static final int TRANSACTION_setEngineerMode = 49;
        static final int TRANSACTION_setFrequency = 4;
        static final int TRANSACTION_setRadioBackGroundRun = 47;
        static final int TRANSACTION_setStationWithName = 17;
        static final int TRANSACTION_setTaMode = 53;
        static final int TRANSACTION_startBackgroundSearch = 19;
        static final int TRANSACTION_storedRadioBand = 21;
        static final int TRANSACTION_storedRadioFrequency = 22;
        static final int TRANSACTION_storedRadioMuted = 23;
        static final int TRANSACTION_tune = 3;
        static final int TRANSACTION_tuneDown = 2;
        static final int TRANSACTION_tuneUp = 1;
        static final int TRANSACTION_unMute = 40;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static IRadioServiceManager asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin != null && (iin instanceof IRadioServiceManager)) {
                return (IRadioServiceManager) iin;
            }
            return new Proxy(obj);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            RadioStation _arg0;
            RadioStation _arg02;
            switch (code) {
                case 1:
                    data.enforceInterface(DESCRIPTOR);
                    tuneUp();
                    reply.writeNoException();
                    return true;
                case 2:
                    data.enforceInterface(DESCRIPTOR);
                    tuneDown();
                    reply.writeNoException();
                    return true;
                case 3:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg02 = RadioStation.CREATOR.createFromParcel(data);
                    } else {
                        _arg02 = null;
                    }
                    tune(_arg02);
                    reply.writeNoException();
                    return true;
                case 4:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg03 = data.readInt();
                    setFrequency(_arg03);
                    reply.writeNoException();
                    return true;
                case 5:
                    data.enforceInterface(DESCRIPTOR);
                    seekUp();
                    reply.writeNoException();
                    return true;
                case 6:
                    data.enforceInterface(DESCRIPTOR);
                    seekDown();
                    reply.writeNoException();
                    return true;
                case 7:
                    data.enforceInterface(DESCRIPTOR);
                    scanUp();
                    reply.writeNoException();
                    return true;
                case 8:
                    data.enforceInterface(DESCRIPTOR);
                    scanDown();
                    reply.writeNoException();
                    return true;
                case 9:
                    data.enforceInterface(DESCRIPTOR);
                    cancelSeek();
                    reply.writeNoException();
                    return true;
                case 10:
                    data.enforceInterface(DESCRIPTOR);
                    int _result = getStoredRadioBand();
                    reply.writeNoException();
                    reply.writeInt(_result);
                    return true;
                case 11:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg04 = data.readInt();
                    int _result2 = getStoredRadioFrequency(_arg04);
                    reply.writeNoException();
                    reply.writeInt(_result2);
                    return true;
                case 12:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result3 = getStoredRadioMuted();
                    reply.writeNoException();
                    reply.writeInt(_result3 ? 1 : 0);
                    return true;
                case 13:
                    data.enforceInterface(DESCRIPTOR);
                    RadioStation _result4 = getCurrentStation();
                    reply.writeNoException();
                    if (_result4 != null) {
                        reply.writeInt(1);
                        _result4.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 14:
                    data.enforceInterface(DESCRIPTOR);
                    String _result5 = getCurrentStationName();
                    reply.writeNoException();
                    reply.writeString(_result5);
                    return true;
                case 15:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg05 = data.readInt();
                    String _result6 = getStationNameWithFrequency(_arg05);
                    reply.writeNoException();
                    reply.writeString(_result6);
                    return true;
                case 16:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg06 = data.readInt();
                    String _arg1 = data.readString();
                    int _result7 = getFrequencyWithStationName(_arg06, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result7);
                    return true;
                case 17:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg07 = data.readInt();
                    String _arg12 = data.readString();
                    boolean _result8 = setStationWithName(_arg07, _arg12);
                    reply.writeNoException();
                    reply.writeInt(_result8 ? 1 : 0);
                    return true;
                case 18:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result9 = searchStations();
                    reply.writeNoException();
                    reply.writeInt(_result9 ? 1 : 0);
                    return true;
                case 19:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result10 = startBackgroundSearch();
                    reply.writeNoException();
                    reply.writeInt(_result10 ? 1 : 0);
                    return true;
                case 20:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result11 = autoStore();
                    reply.writeNoException();
                    reply.writeInt(_result11 ? 1 : 0);
                    return true;
                case 21:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg08 = data.readInt();
                    storedRadioBand(_arg08);
                    reply.writeNoException();
                    return true;
                case 22:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg09 = data.readInt();
                    int _arg13 = data.readInt();
                    storedRadioFrequency(_arg09, _arg13);
                    reply.writeNoException();
                    return true;
                case 23:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg010 = data.readInt() != 0;
                    storedRadioMuted(_arg010);
                    reply.writeNoException();
                    return true;
                case 24:
                    data.enforceInterface(DESCRIPTOR);
                    if (data.readInt() != 0) {
                        _arg0 = RadioStation.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    boolean _result12 = saveCurrentStation(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result12 ? 1 : 0);
                    return true;
                case 25:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _arg011 = data.createTypedArrayList(RadioStation.CREATOR);
                    boolean _result13 = savePresetList(_arg011);
                    reply.writeNoException();
                    reply.writeInt(_result13 ? 1 : 0);
                    return true;
                case 26:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg012 = data.readInt();
                    List<RadioStation> _arg14 = data.createTypedArrayList(RadioStation.CREATOR);
                    boolean _result14 = savePresetListWithBand(_arg012, _arg14);
                    reply.writeNoException();
                    reply.writeInt(_result14 ? 1 : 0);
                    return true;
                case 27:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg013 = data.readInt();
                    List<RadioStation> _arg15 = data.createTypedArrayList(RadioStation.CREATOR);
                    saveSearchStationList(_arg013, _arg15);
                    reply.writeNoException();
                    return true;
                case 28:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _result15 = getCurrentStationList();
                    reply.writeNoException();
                    reply.writeTypedList(_result15);
                    return true;
                case 29:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg014 = data.readInt();
                    List<RadioStation> _result16 = getStationListWithBand(_arg014);
                    reply.writeNoException();
                    reply.writeTypedList(_result16);
                    return true;
                case 30:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _result17 = getAllStationList();
                    reply.writeNoException();
                    reply.writeTypedList(_result17);
                    return true;
                case 31:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _result18 = getCurrentPresetList();
                    reply.writeNoException();
                    reply.writeTypedList(_result18);
                    return true;
                case 32:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg015 = data.readInt();
                    List<RadioStation> _result19 = getPresetListWithBand(_arg015);
                    reply.writeNoException();
                    reply.writeTypedList(_result19);
                    return true;
                case 33:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _result20 = getAllPresetList();
                    reply.writeNoException();
                    reply.writeTypedList(_result20);
                    return true;
                case 34:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg016 = data.readInt();
                    int _result21 = openRadioBand(_arg016);
                    reply.writeNoException();
                    reply.writeInt(_result21);
                    return true;
                case 35:
                    data.enforceInterface(DESCRIPTOR);
                    int _result22 = requestRadioAudioFocus();
                    reply.writeNoException();
                    reply.writeInt(_result22);
                    return true;
                case 36:
                    data.enforceInterface(DESCRIPTOR);
                    abandonRadioAudioFocus();
                    reply.writeNoException();
                    return true;
                case 37:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result23 = isInitialized();
                    reply.writeNoException();
                    reply.writeInt(_result23 ? 1 : 0);
                    return true;
                case 38:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result24 = hasFocus();
                    reply.writeNoException();
                    reply.writeInt(_result24 ? 1 : 0);
                    return true;
                case 39:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result25 = mute();
                    reply.writeNoException();
                    reply.writeInt(_result25 ? 1 : 0);
                    return true;
                case 40:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result26 = unMute();
                    reply.writeNoException();
                    reply.writeInt(_result26 ? 1 : 0);
                    return true;
                case 41:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result27 = isMuted();
                    reply.writeNoException();
                    reply.writeInt(_result27 ? 1 : 0);
                    return true;
                case 42:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg017 = data.readInt();
                    int _result28 = diagonse_switchToBand(_arg017);
                    reply.writeNoException();
                    reply.writeInt(_result28);
                    return true;
                case 43:
                    data.enforceInterface(DESCRIPTOR);
                    int _arg018 = data.readInt();
                    boolean _result29 = diagonse_setFrequency(_arg018);
                    reply.writeNoException();
                    reply.writeInt(_result29 ? 1 : 0);
                    return true;
                case 44:
                    data.enforceInterface(DESCRIPTOR);
                    IRadioServiceCallback _arg019 = IRadioServiceCallback.Stub.asInterface(data.readStrongBinder());
                    addRadioServiceCallback(_arg019);
                    reply.writeNoException();
                    return true;
                case 45:
                    data.enforceInterface(DESCRIPTOR);
                    IRadioServiceCallback _arg020 = IRadioServiceCallback.Stub.asInterface(data.readStrongBinder());
                    removeRadioServiceCallback(_arg020);
                    reply.writeNoException();
                    return true;
                case 46:
                    data.enforceInterface(DESCRIPTOR);
                    List<RadioStation> _result30 = getSearchResultList();
                    reply.writeNoException();
                    reply.writeTypedList(_result30);
                    return true;
                case 47:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg021 = data.readInt() != 0;
                    setRadioBackGroundRun(_arg021);
                    reply.writeNoException();
                    return true;
                case 48:
                    data.enforceInterface(DESCRIPTOR);
                    play();
                    reply.writeNoException();
                    return true;
                case 49:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg022 = data.readInt() != 0;
                    setEngineerMode(_arg022);
                    reply.writeNoException();
                    return true;
                case 50:
                    data.enforceInterface(DESCRIPTOR);
                    RadioEngineerData _result31 = getRadioEngineerData();
                    reply.writeNoException();
                    if (_result31 != null) {
                        reply.writeInt(1);
                        _result31.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 51:
                    data.enforceInterface(DESCRIPTOR);
                    int _result32 = getAudioFocusStatus();
                    reply.writeNoException();
                    reply.writeInt(_result32);
                    return true;
                case 52:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result33 = cancelTA();
                    reply.writeNoException();
                    reply.writeInt(_result33 ? 1 : 0);
                    return true;
                case 53:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg023 = data.readInt() != 0;
                    setTaMode(_arg023);
                    reply.writeNoException();
                    return true;
                case 54:
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result34 = getTaMode();
                    reply.writeNoException();
                    reply.writeInt(_result34 ? 1 : 0);
                    return true;
                case 1598968902:
                    reply.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static class Proxy implements IRadioServiceManager {
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

            @Override // com.harman.radioservice.IRadioServiceManager
            public void tuneUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(1, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void tuneDown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void tune(RadioStation station) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (station != null) {
                        _data.writeInt(1);
                        station.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(3, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void setFrequency(int frequency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(frequency);
                    this.mRemote.transact(4, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void seekUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(5, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void seekDown() throws RemoteException {
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

            @Override // com.harman.radioservice.IRadioServiceManager
            public void scanUp() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void scanDown() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void cancelSeek() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int getStoredRadioBand() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int getStoredRadioFrequency(int band) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    this.mRemote.transact(11, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean getStoredRadioMuted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public RadioStation getCurrentStation() throws RemoteException {
                RadioStation _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = RadioStation.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public String getCurrentStationName() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public String getStationNameWithFrequency(int frequency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(frequency);
                    this.mRemote.transact(15, _data, _reply, 0);
                    _reply.readException();
                    String _result = _reply.readString();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int getFrequencyWithStationName(int band, String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeString(name);
                    this.mRemote.transact(16, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean setStationWithName(int band, String name) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeString(name);
                    this.mRemote.transact(17, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean searchStations() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(18, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean startBackgroundSearch() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(19, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean autoStore() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(20, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void storedRadioBand(int band) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    this.mRemote.transact(21, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void storedRadioFrequency(int band, int frequency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeInt(frequency);
                    this.mRemote.transact(22, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void storedRadioMuted(boolean muted) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(muted ? 1 : 0);
                    this.mRemote.transact(23, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean saveCurrentStation(RadioStation station) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (station != null) {
                        _data.writeInt(1);
                        station.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    this.mRemote.transact(24, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean savePresetList(List<RadioStation> list) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeTypedList(list);
                    this.mRemote.transact(25, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean savePresetListWithBand(int band, List<RadioStation> list) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeTypedList(list);
                    this.mRemote.transact(26, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void saveSearchStationList(int band, List<RadioStation> list) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    _data.writeTypedList(list);
                    this.mRemote.transact(27, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getCurrentStationList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(28, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getStationListWithBand(int band) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    this.mRemote.transact(29, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getAllStationList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(30, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getCurrentPresetList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(31, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getPresetListWithBand(int band) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(band);
                    this.mRemote.transact(32, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getAllPresetList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(33, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int openRadioBand(int radioBand) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(radioBand);
                    this.mRemote.transact(34, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int requestRadioAudioFocus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(35, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void abandonRadioAudioFocus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(36, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean isInitialized() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(37, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean hasFocus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(38, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean mute() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(39, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean unMute() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(40, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean isMuted() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(41, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int diagonse_switchToBand(int radioBand) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(radioBand);
                    this.mRemote.transact(42, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean diagonse_setFrequency(int frequency) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(frequency);
                    this.mRemote.transact(43, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void addRadioServiceCallback(IRadioServiceCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(44, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void removeRadioServiceCallback(IRadioServiceCallback callback) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeStrongBinder(callback != null ? callback.asBinder() : null);
                    this.mRemote.transact(45, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public List<RadioStation> getSearchResultList() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(46, _data, _reply, 0);
                    _reply.readException();
                    List<RadioStation> _result = _reply.createTypedArrayList(RadioStation.CREATOR);
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void setRadioBackGroundRun(boolean tag) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(tag ? 1 : 0);
                    this.mRemote.transact(47, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void play() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(48, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void setEngineerMode(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(49, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public RadioEngineerData getRadioEngineerData() throws RemoteException {
                RadioEngineerData _result;
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(50, _data, _reply, 0);
                    _reply.readException();
                    if (_reply.readInt() != 0) {
                        _result = RadioEngineerData.CREATOR.createFromParcel(_reply);
                    } else {
                        _result = null;
                    }
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public int getAudioFocusStatus() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(51, _data, _reply, 0);
                    _reply.readException();
                    int _result = _reply.readInt();
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean cancelTA() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(52, _data, _reply, 0);
                    _reply.readException();
                    boolean _result = _reply.readInt() != 0;
                    return _result;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public void setTaMode(boolean enable) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    this.mRemote.transact(53, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override // com.harman.radioservice.IRadioServiceManager
            public boolean getTaMode() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(54, _data, _reply, 0);
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