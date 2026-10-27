package vendor.harman.gwm.hardware.diagnostics.V1_0;

import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class SDiagDataDesc {
    public int emcmdId;
    public int emdataId;
    public int emdataType;
    public final RawValue value = new RawValue();
    public int valueType;

    public static final class RawValue {
        public final ArrayList<Integer> int32Values = new ArrayList<>();
        public final ArrayList<Float> floatValues = new ArrayList<>();
        public final ArrayList<Long> int64Values = new ArrayList<>();
        public final ArrayList<Byte> bytes = new ArrayList<>();
        public String stringValue = new String();

        public final boolean equals(Object otherObject) {
            if (this == otherObject) {
                return true;
            }
            if (otherObject != null && otherObject.getClass() == RawValue.class) {
                RawValue other = (RawValue) otherObject;
                return HidlSupport.deepEquals(this.int32Values, other.int32Values) && HidlSupport.deepEquals(this.floatValues, other.floatValues) && HidlSupport.deepEquals(this.int64Values, other.int64Values) && HidlSupport.deepEquals(this.bytes, other.bytes) && HidlSupport.deepEquals(this.stringValue, other.stringValue);
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(this.int32Values)), Integer.valueOf(HidlSupport.deepHashCode(this.floatValues)), Integer.valueOf(HidlSupport.deepHashCode(this.int64Values)), Integer.valueOf(HidlSupport.deepHashCode(this.bytes)), Integer.valueOf(HidlSupport.deepHashCode(this.stringValue)));
        }

        public final String toString() {
            return "{.int32Values = " + this.int32Values + ", .floatValues = " + this.floatValues + ", .int64Values = " + this.int64Values + ", .bytes = " + this.bytes + ", .stringValue = " + this.stringValue + "}";
        }

        public final void readFromParcel(HwParcel parcel) {
            HwBlob blob = parcel.readBuffer(80L);
            readEmbeddedFromParcel(parcel, blob, 0L);
        }

        public static final ArrayList<RawValue> readVectorFromParcel(HwParcel parcel) {
            ArrayList<RawValue> _hidl_vec = new ArrayList<>();
            HwBlob _hidl_blob = parcel.readBuffer(16L);
            int _hidl_vec_size = _hidl_blob.getInt32(8L);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 80, _hidl_blob.handle(), 0L, true);
            _hidl_vec.clear();
            for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                RawValue _hidl_vec_element = new RawValue();
                _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 80);
                _hidl_vec.add(_hidl_vec_element);
            }
            return _hidl_vec;
        }

        public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
            int _hidl_vec_size = _hidl_blob.getInt32(0 + _hidl_offset + 8);
            HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 4, _hidl_blob.handle(), 0 + _hidl_offset + 0, true);
            this.int32Values.clear();
            for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                int _hidl_vec_element = childBlob.getInt32(_hidl_index_0 * 4);
                this.int32Values.add(Integer.valueOf(_hidl_vec_element));
            }
            int _hidl_vec_size2 = _hidl_blob.getInt32(16 + _hidl_offset + 8);
            HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 4, _hidl_blob.handle(), 16 + _hidl_offset + 0, true);
            this.floatValues.clear();
            for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
                float _hidl_vec_element2 = childBlob2.getFloat(_hidl_index_02 * 4);
                this.floatValues.add(Float.valueOf(_hidl_vec_element2));
            }
            int _hidl_vec_size3 = _hidl_blob.getInt32(32 + _hidl_offset + 8);
            HwBlob childBlob3 = parcel.readEmbeddedBuffer(_hidl_vec_size3 * 8, _hidl_blob.handle(), 32 + _hidl_offset + 0, true);
            this.int64Values.clear();
            for (int _hidl_index_03 = 0; _hidl_index_03 < _hidl_vec_size3; _hidl_index_03++) {
                long _hidl_vec_element3 = childBlob3.getInt64(_hidl_index_03 * 8);
                this.int64Values.add(Long.valueOf(_hidl_vec_element3));
            }
            int _hidl_vec_size4 = _hidl_blob.getInt32(48 + _hidl_offset + 8);
            HwBlob childBlob4 = parcel.readEmbeddedBuffer(_hidl_vec_size4 * 1, _hidl_blob.handle(), 48 + _hidl_offset + 0, true);
            this.bytes.clear();
            for (int _hidl_index_04 = 0; _hidl_index_04 < _hidl_vec_size4; _hidl_index_04++) {
                byte _hidl_vec_element4 = childBlob4.getInt8(_hidl_index_04 * 1);
                this.bytes.add(Byte.valueOf(_hidl_vec_element4));
            }
            this.stringValue = _hidl_blob.getString(64 + _hidl_offset);
            parcel.readEmbeddedBuffer(this.stringValue.getBytes().length + 1, _hidl_blob.handle(), 64 + _hidl_offset + 0, false);
        }

        public final void writeToParcel(HwParcel parcel) {
            HwBlob _hidl_blob = new HwBlob(80);
            writeEmbeddedToBlob(_hidl_blob, 0L);
            parcel.writeBuffer(_hidl_blob);
        }

        public static final void writeVectorToParcel(HwParcel parcel, ArrayList<RawValue> _hidl_vec) {
            HwBlob _hidl_blob = new HwBlob(16);
            int _hidl_vec_size = _hidl_vec.size();
            _hidl_blob.putInt32(8L, _hidl_vec_size);
            _hidl_blob.putBool(12L, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 80);
            for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 80);
            }
            _hidl_blob.putBlob(0L, childBlob);
            parcel.writeBuffer(_hidl_blob);
        }

        public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
            int _hidl_vec_size = this.int32Values.size();
            _hidl_blob.putInt32(0 + _hidl_offset + 8, _hidl_vec_size);
            _hidl_blob.putBool(0 + _hidl_offset + 12, false);
            HwBlob childBlob = new HwBlob(_hidl_vec_size * 4);
            for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
                childBlob.putInt32(_hidl_index_0 * 4, this.int32Values.get(_hidl_index_0).intValue());
            }
            _hidl_blob.putBlob(0 + _hidl_offset + 0, childBlob);
            int _hidl_vec_size2 = this.floatValues.size();
            _hidl_blob.putInt32(16 + _hidl_offset + 8, _hidl_vec_size2);
            _hidl_blob.putBool(16 + _hidl_offset + 12, false);
            HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 4);
            for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
                childBlob2.putFloat(_hidl_index_02 * 4, this.floatValues.get(_hidl_index_02).floatValue());
            }
            _hidl_blob.putBlob(16 + _hidl_offset + 0, childBlob2);
            int _hidl_vec_size3 = this.int64Values.size();
            _hidl_blob.putInt32(32 + _hidl_offset + 8, _hidl_vec_size3);
            _hidl_blob.putBool(32 + _hidl_offset + 12, false);
            HwBlob childBlob3 = new HwBlob(_hidl_vec_size3 * 8);
            for (int _hidl_index_03 = 0; _hidl_index_03 < _hidl_vec_size3; _hidl_index_03++) {
                childBlob3.putInt64(_hidl_index_03 * 8, this.int64Values.get(_hidl_index_03).longValue());
            }
            _hidl_blob.putBlob(32 + _hidl_offset + 0, childBlob3);
            int _hidl_vec_size4 = this.bytes.size();
            _hidl_blob.putInt32(48 + _hidl_offset + 8, _hidl_vec_size4);
            _hidl_blob.putBool(48 + _hidl_offset + 12, false);
            HwBlob childBlob4 = new HwBlob(_hidl_vec_size4 * 1);
            for (int _hidl_index_04 = 0; _hidl_index_04 < _hidl_vec_size4; _hidl_index_04++) {
                childBlob4.putInt8(_hidl_index_04 * 1, this.bytes.get(_hidl_index_04).byteValue());
            }
            _hidl_blob.putBlob(48 + _hidl_offset + 0, childBlob4);
            _hidl_blob.putString(64 + _hidl_offset, this.stringValue);
        }
    }

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject != null && otherObject.getClass() == SDiagDataDesc.class) {
            SDiagDataDesc other = (SDiagDataDesc) otherObject;
            return this.emdataType == other.emdataType && this.emdataId == other.emdataId && this.emcmdId == other.emcmdId && this.valueType == other.valueType && HidlSupport.deepEquals(this.value, other.value);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.emdataType))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.emdataId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.emcmdId))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.valueType))), Integer.valueOf(HidlSupport.deepHashCode(this.value)));
    }

    public final String toString() {
        return "{.emdataType = " + EM_DIAG_DATA_TYPE.toString(this.emdataType) + ", .emdataId = " + EM_DIAG_DATA_ID.toString(this.emdataId) + ", .emcmdId = " + CommandID.toString(this.emcmdId) + ", .valueType = " + ValueType.toString(this.valueType) + ", .value = " + this.value + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(96L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<SDiagDataDesc> readVectorFromParcel(HwParcel parcel) {
        ArrayList<SDiagDataDesc> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 96, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            SDiagDataDesc _hidl_vec_element = new SDiagDataDesc();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 96);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.emdataType = _hidl_blob.getInt32(0 + _hidl_offset);
        this.emdataId = _hidl_blob.getInt32(4 + _hidl_offset);
        this.emcmdId = _hidl_blob.getInt32(8 + _hidl_offset);
        this.valueType = _hidl_blob.getInt32(12 + _hidl_offset);
        this.value.readEmbeddedFromParcel(parcel, _hidl_blob, 16 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(96);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<SDiagDataDesc> _hidl_vec) {
        HwBlob _hidl_blob = new HwBlob(16);
        int _hidl_vec_size = _hidl_vec.size();
        _hidl_blob.putInt32(8L, _hidl_vec_size);
        _hidl_blob.putBool(12L, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 96);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            _hidl_vec.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 96);
        }
        _hidl_blob.putBlob(0L, childBlob);
        parcel.writeBuffer(_hidl_blob);
    }

    public final void writeEmbeddedToBlob(HwBlob _hidl_blob, long _hidl_offset) {
        _hidl_blob.putInt32(0 + _hidl_offset, this.emdataType);
        _hidl_blob.putInt32(4 + _hidl_offset, this.emdataId);
        _hidl_blob.putInt32(8 + _hidl_offset, this.emcmdId);
        _hidl_blob.putInt32(12 + _hidl_offset, this.valueType);
        this.value.writeEmbeddedToBlob(_hidl_blob, 16 + _hidl_offset);
    }
}