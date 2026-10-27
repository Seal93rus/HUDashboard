package vendor.harman.gwm.hardware.diagnostics.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class TSatelliteStatus {
    public byte numOfFix;
    public byte numOfUsedSat;
    public byte numOfVisibleSat;

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject != null && otherObject.getClass() == TSatelliteStatus.class) {
            TSatelliteStatus other = (TSatelliteStatus) otherObject;
            return this.numOfVisibleSat == other.numOfVisibleSat && this.numOfFix == other.numOfFix && this.numOfUsedSat == other.numOfUsedSat;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Byte.valueOf(this.numOfVisibleSat))), Integer.valueOf(HidlSupport.deepHashCode(Byte.valueOf(this.numOfFix))), Integer.valueOf(HidlSupport.deepHashCode(Byte.valueOf(this.numOfUsedSat))));
    }

    public final String toString() {
        return "{.numOfVisibleSat = " + ((int) this.numOfVisibleSat) + ", .numOfFix = " + ((int) this.numOfFix) + ", .numOfUsedSat = " + ((int) this.numOfUsedSat) + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(3L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<TSatelliteStatus> readVectorFromParcel(HwParcel parcel) {
        ArrayList<TSatelliteStatus> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 3, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            TSatelliteStatus _hidl_vec_element = new TSatelliteStatus();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 3);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.numOfVisibleSat = _hidl_blob.getInt8(0 + _hidl_offset);
        this.numOfFix = _hidl_blob.getInt8(1 + _hidl_offset);
        this.numOfUsedSat = _hidl_blob.getInt8(2 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(3);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<TSatelliteStatus> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 3);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 3);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt8(0 + _hidl_offset, this.numOfVisibleSat);
        _hidl_blob.putInt8(1 + _hidl_offset, this.numOfFix);
        _hidl_blob.putInt8(2 + _hidl_offset, this.numOfUsedSat);
    }
}