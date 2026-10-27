package vendor.harman.gwm.hardware.diagnostics.V1_0;

import android.hidl.base.V1_0.DebugInfo;
import android.hidl.base.V1_0.IBase;
import android.os.HwBinder;
import android.os.HwBlob;
import android.os.HwParcel;
import android.os.IHwBinder;
import android.os.IHwInterface;
import android.os.RemoteException;
import android.os.SystemProperties;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


/* JADX INFO: loaded from: classes.dex */
public interface IDiag extends IBase {
    public static final String kInterfaceName = "vendor.harman.gwm.hardware.diagnostics@1.0::IDiag";

    @FunctionalInterface
    public interface getDataCallback {
        void onValues(int i, SDiagDataDesc sDiagDataDesc);
    }

    @Override // android.hidl.base.V1_0.IBase
    IHwBinder asBinder();

    void executeCommandResponse(int i, DiagCommandDesc diagCommandDesc) throws RemoteException;

    void getDTCResponse(int i, DTCRequestDesc dTCRequestDesc) throws RemoteException;

    void getData(SDiagDataDesc sDiagDataDesc, getDataCallback getdatacallback) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    DebugInfo getDebugInfo() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<byte[]> getHashChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    ArrayList<String> interfaceChain() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    String interfaceDescriptor() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean linkToDeath(IHwBinder.DeathRecipient deathRecipient, long j) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void notifySyspropsChanged() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void ping() throws RemoteException;

    void registerCallback(IDiagCallback iDiagCallback) throws RemoteException;

    void setData(SDiagDataDesc sDiagDataDesc) throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    void setHALInstrumentation() throws RemoteException;

    @Override // android.hidl.base.V1_0.IBase
    boolean unlinkToDeath(IHwBinder.DeathRecipient deathRecipient) throws RemoteException;

    static IDiag asInterface(IHwBinder binder) {
        if (binder == null) {
            return null;
        }
        IHwInterface iface = binder.queryLocalInterface(kInterfaceName);
        if (iface != null && (iface instanceof IDiag)) {
            return (IDiag) iface;
        }
        IDiag proxy = new Proxy(binder);
        try {
            for (String descriptor : proxy.interfaceChain()) {
                if (descriptor.equals(kInterfaceName)) {
                    return proxy;
                }
            }
        } catch (RemoteException e) {
        }
        return null;
    }

    static IDiag castFrom(IHwInterface iface) {
        if (iface == null) {
            return null;
        }
        return asInterface(iface.asBinder());
    }

    static IDiag getService(String serviceName) throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, serviceName));
    }

    static IDiag getService() throws RemoteException {
        return asInterface(HwBinder.getService(kInterfaceName, "default"));
    }

    public static final class Proxy implements IDiag {
        private IHwBinder mRemote;

        public Proxy(IHwBinder remote) {
            this.mRemote = (IHwBinder) Objects.requireNonNull(remote);
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this.mRemote;
        }

        public String toString() {
            try {
                return interfaceDescriptor() + "@Proxy";
            } catch (RemoteException e) {
                return "[class or subclass of vendor.harman.gwm.hardware.diagnostics@1.0::IDiag]@Proxy";
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag
        public void registerCallback(IDiagCallback cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IDiag.kInterfaceName);
            _hidl_request.writeStrongBinder(cb == null ? null : cb.asBinder());
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(1, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag
        public void getDTCResponse(int p_Status, DTCRequestDesc dtc_requestDesc) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IDiag.kInterfaceName);
            _hidl_request.writeInt32(p_Status);
            dtc_requestDesc.writeToParcel(_hidl_request);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(2, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag
        public void executeCommandResponse(int p_Status, DiagCommandDesc commandDesc) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IDiag.kInterfaceName);
            _hidl_request.writeInt32(p_Status);
            commandDesc.writeToParcel(_hidl_request);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(3, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag
        public void getData(SDiagDataDesc inDataDesc, getDataCallback _hidl_cb) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IDiag.kInterfaceName);
            inDataDesc.writeToParcel(_hidl_request);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(4, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                int _hidl_out_status = _hidl_reply.readInt32();
                SDiagDataDesc _hidl_out_outDataDesc = new SDiagDataDesc();
                _hidl_out_outDataDesc.readFromParcel(_hidl_reply);
                _hidl_cb.onValues(_hidl_out_status, _hidl_out_outDataDesc);
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag
        public void setData(SDiagDataDesc inDataDesc) throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IDiag.kInterfaceName);
            inDataDesc.writeToParcel(_hidl_request);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(5, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public ArrayList<String> interfaceChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256067662, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ArrayList<String> _hidl_out_descriptors = _hidl_reply.readStringVector();
                return _hidl_out_descriptors;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public String interfaceDescriptor() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256136003, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                String _hidl_out_descriptor = _hidl_reply.readString();
                return _hidl_out_descriptor;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public ArrayList<byte[]> getHashChain() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256398152, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                ArrayList<byte[]> _hidl_out_hashchain = new ArrayList<>();
                HwBlob _hidl_blob = _hidl_reply.readBuffer(16L);
                int _hidl_vec_size = _hidl_blob.getInt32(8L);
                HwBlob childBlob = _hidl_reply.readEmbeddedBuffer(_hidl_vec_size * 32, _hidl_blob.handle(), 0L, true);
                _hidl_out_hashchain.clear();
                for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                    byte[] _hidl_vec_element = new byte[32];
                    long _hidl_array_offset_1 = _hidl_index_0 * 32;
                    for (int _hidl_index_1_0 = 0; _hidl_index_1_0 < 32; _hidl_index_1_0++) {
                        _hidl_vec_element[_hidl_index_1_0] = childBlob.getInt8(_hidl_array_offset_1);
                        _hidl_array_offset_1++;
                    }
                    _hidl_out_hashchain.add(_hidl_vec_element);
                }
                return _hidl_out_hashchain;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public void setHALInstrumentation() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256462420, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public boolean linkToDeath(IHwBinder.DeathRecipient recipient, long cookie) throws RemoteException {
            return this.mRemote.linkToDeath(recipient, cookie);
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public void ping() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(256921159, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public DebugInfo getDebugInfo() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257049926, _hidl_request, _hidl_reply, 0);
                _hidl_reply.verifySuccess();
                _hidl_request.releaseTemporaryStorage();
                DebugInfo _hidl_out_info = new DebugInfo();
                _hidl_out_info.readFromParcel(_hidl_reply);
                return _hidl_out_info;
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public void notifySyspropsChanged() throws RemoteException {
            HwParcel _hidl_request = new HwParcel();
            _hidl_request.writeInterfaceToken(IBase.kInterfaceName);
            HwParcel _hidl_reply = new HwParcel();
            try {
                this.mRemote.transact(257120595, _hidl_request, _hidl_reply, 1);
                _hidl_request.releaseTemporaryStorage();
            } finally {
                _hidl_reply.release();
            }
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public boolean unlinkToDeath(IHwBinder.DeathRecipient recipient) throws RemoteException {
            return this.mRemote.unlinkToDeath(recipient);
        }
    }

    public static abstract class Stub extends HwBinder implements IDiag {
        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public IHwBinder asBinder() {
            return this;
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final ArrayList<String> interfaceChain() {
            return new ArrayList<>(Arrays.asList(IDiag.kInterfaceName, IBase.kInterfaceName));
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final String interfaceDescriptor() {
            return IDiag.kInterfaceName;
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final ArrayList<byte[]> getHashChain() {
            return new ArrayList<>(Arrays.asList(new byte[]{101, -29, -24, 89, -110, -58, 115, 24, -24, -27, 87, -6, -84, -77, -116, -118, -80, 30, 48, 35, 33, 43, 24, 21, 5, 61, -34, -27, 90, 94, 117}, new byte[]{-67, -38, -74, 24, 77, 122, 52, 109, -90, -96, 125, -64, -126, -116, -15, -102, 105, 111, 76, -86, 54, 17, -59, 31, 46, 20, 86, 90, 20, -76, 15, -39}));
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final void setHALInstrumentation() {
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final boolean linkToDeath(DeathRecipient recipient, long cookie) {
            return true;
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final void ping() {
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final DebugInfo getDebugInfo() {
            DebugInfo info = new DebugInfo();
            info.pid = -1;
            info.ptr = 0L;
            info.arch = 0;
            return info;
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final void notifySyspropsChanged() {
            SystemProperties.reportSyspropChanged();
        }

        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag, android.hidl.base.V1_0.IBase
        public final boolean unlinkToDeath(DeathRecipient recipient) {
            return true;
        }

        public IHwInterface queryLocalInterface(String descriptor) {
            if (IDiag.kInterfaceName.equals(descriptor)) {
                return this;
            }
            return null;
        }

        public void registerAsService(String serviceName) throws RemoteException {
            registerService(serviceName);
        }

        public String toString() {
            return interfaceDescriptor() + "@Stub";
        }

        public void onTransact(int _hidl_code, HwParcel _hidl_request, final HwParcel _hidl_reply, int _hidl_flags) throws RemoteException {
            switch (_hidl_code) {
                case 1:
                    _hidl_request.enforceInterface(IDiag.kInterfaceName);
                    IDiagCallback cb = IDiagCallback.asInterface(_hidl_request.readStrongBinder());
                    registerCallback(cb);
                    break;
                case 2:
                    _hidl_request.enforceInterface(IDiag.kInterfaceName);
                    int p_Status = _hidl_request.readInt32();
                    DTCRequestDesc dtc_requestDesc = new DTCRequestDesc();
                    dtc_requestDesc.readFromParcel(_hidl_request);
                    getDTCResponse(p_Status, dtc_requestDesc);
                    break;
                case 3:
                    _hidl_request.enforceInterface(IDiag.kInterfaceName);
                    int p_Status2 = _hidl_request.readInt32();
                    DiagCommandDesc commandDesc = new DiagCommandDesc();
                    commandDesc.readFromParcel(_hidl_request);
                    executeCommandResponse(p_Status2, commandDesc);
                    break;
                case 4:
                    _hidl_request.enforceInterface(IDiag.kInterfaceName);
                    SDiagDataDesc inDataDesc = new SDiagDataDesc();
                    inDataDesc.readFromParcel(_hidl_request);
                    getData(inDataDesc, new getDataCallback() { // from class: vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag.Stub.1
                        @Override // vendor.harman.gwm.hardware.diagnostics.V1_0.IDiag.getDataCallback
                        public void onValues(int status, SDiagDataDesc outDataDesc) {
                            _hidl_reply.writeStatus(0);
                            _hidl_reply.writeInt32(status);
                            outDataDesc.writeToParcel(_hidl_reply);
                            _hidl_reply.send();
                        }
                    });
                    break;
                case 5:
                    _hidl_request.enforceInterface(IDiag.kInterfaceName);
                    SDiagDataDesc inDataDesc2 = new SDiagDataDesc();
                    inDataDesc2.readFromParcel(_hidl_request);
                    setData(inDataDesc2);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.send();
                    break;
                case 256067662:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    ArrayList<String> _hidl_out_descriptors = interfaceChain();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeStringVector(_hidl_out_descriptors);
                    _hidl_reply.send();
                    break;
                case 256131655:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.send();
                    break;
                case 256136003:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    String _hidl_out_descriptor = interfaceDescriptor();
                    _hidl_reply.writeStatus(0);
                    _hidl_reply.writeString(_hidl_out_descriptor);
                    _hidl_reply.send();
                    break;
                case 256398152:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    ArrayList<byte[]> _hidl_out_hashchain = getHashChain();
                    _hidl_reply.writeStatus(0);
                    HwBlob _hidl_blob = new HwBlob(16);
                    int _hidl_vec_size = _hidl_out_hashchain.size();
                    _hidl_blob.putInt32(8L, _hidl_vec_size);
                    _hidl_blob.putBool(12L, false);
                    HwBlob childBlob = new HwBlob(_hidl_vec_size * 32);
                    for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                        long _hidl_array_offset_1 = _hidl_index_0 * 32;
                        for (int _hidl_index_1_0 = 0; _hidl_index_1_0 < 32; _hidl_index_1_0++) {
                            childBlob.putInt8(_hidl_array_offset_1, _hidl_out_hashchain.get(_hidl_index_0)[_hidl_index_1_0]);
                            _hidl_array_offset_1++;
                        }
                    }
                    _hidl_blob.putBlob(0L, childBlob);
                    _hidl_reply.writeBuffer(_hidl_blob);
                    _hidl_reply.send();
                    break;
                case 256462420:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    setHALInstrumentation();
                    break;
                case 257049926:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    DebugInfo _hidl_out_info = getDebugInfo();
                    _hidl_reply.writeStatus(0);
                    _hidl_out_info.writeToParcel(_hidl_reply);
                    _hidl_reply.send();
                    break;
                case 257120595:
                    _hidl_request.enforceInterface(IBase.kInterfaceName);
                    notifySyspropsChanged();
                    break;
            }
        }
    }
}