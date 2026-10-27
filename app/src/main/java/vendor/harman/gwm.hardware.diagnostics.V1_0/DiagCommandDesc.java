package vendor.harman.gwm.hardware.diagnostics.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class DiagCommandDesc {
    public int command_id;
    public int command_type;
    public final ArrayList<valueTypePair> commandParams = new ArrayList<>();
    public final ArrayList<Byte> commandBytes = new ArrayList<>();

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject != null && otherObject.getClass() == DiagCommandDesc.class) {
            DiagCommandDesc other = (DiagCommandDesc) otherObject;
            return this.command_id == other.command_id && this.command_type == other.command_type && HidlSupport.deepEquals(this.commandParams, other.commandParams) && HidlSupport.deepEquals(this.commandBytes, other.commandBytes);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.command_id))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.command_type))), Integer.valueOf(HidlSupport.deepHashCode(this.commandParams)), Integer.valueOf(HidlSupport.deepHashCode(this.commandBytes)));
    }

    public final String toString() {
        return "{.command_id = " + CommandID.toString(this.command_id) + ", .command_type = " + ValueType.toString(this.command_type) + ", .commandParams = " + this.commandParams + ", .commandBytes = " + this.commandBytes + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(40L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<DiagCommandDesc> readVectorFromParcel(HwParcel parcel) {
        ArrayList<DiagCommandDesc> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            DiagCommandDesc _hidl_vec_element = new DiagCommandDesc();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.command_id = _hidl_blob.getInt32(0 + _hidl_offset);
        this.command_type = _hidl_blob.getInt32(4 + _hidl_offset);
        int _hidl_vec_size = _hidl_blob.getInt32(8 + _hidl_offset + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 24, _hidl_blob.handle(), 8 + _hidl_offset + 0, true);
        this.commandParams.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            valueTypePair _hidl_vec_element = new valueTypePair();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 24);
            this.commandParams.add(_hidl_vec_element);
        }
        int _hidl_vec_size2 = _hidl_blob.getInt32(24 + _hidl_offset + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 1, _hidl_blob.handle(), 24 + _hidl_offset + 0, true);
        this.commandBytes.clear();
        for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
            this.commandBytes.add(Byte.valueOf(childBlob2.getInt8(_hidl_index_02 * 1)));
        }
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(40);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<DiagCommandDesc> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 40);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 40);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.command_id);
        _hidl_blob.putInt32(4 + _hidl_offset, this.command_type);
        int _hidl_vec_size = this.commandParams.size();
        _hidl_blob.putInt32(8 + _hidl_offset + 8, _hidl_vec_size);
        _hidl_blob.putBool(8 + _hidl_offset + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 24);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            this.commandParams.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 24);
        }
        _hidl_blob.putBlob(8 + _hidl_offset + 0, childBlob);
        int _hidl_vec_size2 = this.commandBytes.size();
        _hidl_blob.putInt32(24 + _hidl_offset + 8, _hidl_vec_size2);
        _hidl_blob.putBool(24 + _hidl_offset + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 1);
        for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
            childBlob2.putInt8(_hidl_index_02 * 1, this.commandBytes.get(_hidl_index_02).byteValue());
        }
        _hidl_blob.putBlob(24 + _hidl_offset + 0, childBlob2);
    }
}