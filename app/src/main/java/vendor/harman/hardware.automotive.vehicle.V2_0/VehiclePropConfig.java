package vendor.harman.hardware.automotive.vehicle.V2_0;

import vendor.harman.hardware.automotive.vehicle.V2_0.VehicleAreaConfig;
import vendor.harman.hardware.automotive.vehicle.V2_0.VehiclePropertyAccess;
import vendor.harman.hardware.automotive.vehicle.V2_0.VehiclePropertyChangeMode;
import android.os.HidlSupport;
import android.os.HwBlob;
import android.os.HwParcel;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class VehiclePropConfig {
    public int access;
    public int changeMode;
    public int configFlags;
    public float maxSampleRate;
    public float minSampleRate;
    public int prop;
    public int supportedAreas;
    public final ArrayList<vendor.harman.hardware.automotive.vehicle.V2_0.VehicleAreaConfig> areaConfigs = new ArrayList<>();
    public final ArrayList<Integer> configArray = new ArrayList<>();
    public String configString = new String();

    public final boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject != null && otherObject.getClass() == VehiclePropConfig.class) {
            VehiclePropConfig other = (VehiclePropConfig) otherObject;
            return this.prop == other.prop && this.access == other.access && this.changeMode == other.changeMode && this.supportedAreas == other.supportedAreas && HidlSupport.deepEquals(this.areaConfigs, other.areaConfigs) && this.configFlags == other.configFlags && HidlSupport.deepEquals(this.configArray, other.configArray) && HidlSupport.deepEquals(this.configString, other.configString) && this.minSampleRate == other.minSampleRate && this.maxSampleRate == other.maxSampleRate;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.prop))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.access))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.changeMode))), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.supportedAreas))), Integer.valueOf(HidlSupport.deepHashCode(this.areaConfigs)), Integer.valueOf(HidlSupport.deepHashCode(Integer.valueOf(this.configFlags))), Integer.valueOf(HidlSupport.deepHashCode(this.configArray)), Integer.valueOf(HidlSupport.deepHashCode(this.configString)), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.minSampleRate))), Integer.valueOf(HidlSupport.deepHashCode(Float.valueOf(this.maxSampleRate))));
    }

    public final String toString() {
        return "{.prop = " + this.prop + ", .access = " + VehiclePropertyAccess.toString(this.access) + ", .changeMode = " + VehiclePropertyChangeMode.toString(this.changeMode) + ", .supportedAreas = " + this.supportedAreas + ", .areaConfigs = " + this.areaConfigs + ", .configFlags = " + this.configFlags + ", .configArray = " + this.configArray + ", .configString = " + this.configString + ", .minSampleRate = " + this.minSampleRate + ", .maxSampleRate = " + this.maxSampleRate + "}";
    }

    public final void readFromParcel(HwParcel parcel) {
        HwBlob blob = parcel.readBuffer(80L);
        readEmbeddedFromParcel(parcel, blob, 0L);
    }

    public static final ArrayList<VehiclePropConfig> readVectorFromParcel(HwParcel parcel) {
        ArrayList<VehiclePropConfig> _hidl_vec = new ArrayList<>();
        HwBlob _hidl_blob = parcel.readBuffer(16L);
        int _hidl_vec_size = _hidl_blob.getInt32(8L);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 80, _hidl_blob.handle(), 0L, true);
        _hidl_vec.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            VehiclePropConfig _hidl_vec_element = new VehiclePropConfig();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 80);
            _hidl_vec.add(_hidl_vec_element);
        }
        return _hidl_vec;
    }

    public final void readEmbeddedFromParcel(HwParcel parcel, HwBlob _hidl_blob, long _hidl_offset) {
        this.prop = _hidl_blob.getInt32(0 + _hidl_offset);
        this.access = _hidl_blob.getInt32(4 + _hidl_offset);
        this.changeMode = _hidl_blob.getInt32(8 + _hidl_offset);
        this.supportedAreas = _hidl_blob.getInt32(12 + _hidl_offset);
        int _hidl_vec_size = _hidl_blob.getInt32(16 + _hidl_offset + 8);
        HwBlob childBlob = parcel.readEmbeddedBuffer(_hidl_vec_size * 40, _hidl_blob.handle(), 16 + _hidl_offset + 0, true);
        this.areaConfigs.clear();
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            vendor.harman.hardware.automotive.vehicle.V2_0.VehicleAreaConfig _hidl_vec_element = new VehicleAreaConfig();
            _hidl_vec_element.readEmbeddedFromParcel(parcel, childBlob, _hidl_index_0 * 40);
            this.areaConfigs.add(_hidl_vec_element);
        }
        this.configFlags = _hidl_blob.getInt32(32 + _hidl_offset);
        int _hidl_vec_size2 = _hidl_blob.getInt32(40 + _hidl_offset + 8);
        HwBlob childBlob2 = parcel.readEmbeddedBuffer(_hidl_vec_size2 * 4, _hidl_blob.handle(), 40 + _hidl_offset + 0, true);
        this.configArray.clear();
        for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
            this.configArray.add(Integer.valueOf(childBlob2.getInt32(_hidl_index_02 * 4)));
        }
        this.configString = _hidl_blob.getString(56 + _hidl_offset);
        parcel.readEmbeddedBuffer(this.configString.getBytes().length + 1, _hidl_blob.handle(), 56 + _hidl_offset + 0, false);
        this.minSampleRate = _hidl_blob.getFloat(72 + _hidl_offset);
        this.maxSampleRate = _hidl_blob.getFloat(76 + _hidl_offset);
    }

    public final void writeToParcel(HwParcel parcel) {
        HwBlob _hidl_blob = new HwBlob(80);
        writeEmbeddedToBlob(_hidl_blob, 0L);
        parcel.writeBuffer(_hidl_blob);
    }

    public static final void writeVectorToParcel(HwParcel parcel, ArrayList<VehiclePropConfig> _hidl_vec) {
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
        _hidl_blob.putInt32(0 + _hidl_offset, this.prop);
        _hidl_blob.putInt32(4 + _hidl_offset, this.access);
        _hidl_blob.putInt32(8 + _hidl_offset, this.changeMode);
        _hidl_blob.putInt32(12 + _hidl_offset, this.supportedAreas);
        int _hidl_vec_size = this.areaConfigs.size();
        _hidl_blob.putInt32(16 + _hidl_offset + 8, _hidl_vec_size);
        _hidl_blob.putBool(16 + _hidl_offset + 12, false);
        HwBlob childBlob = new HwBlob(_hidl_vec_size * 40);
        for (int _hidl_index_0 = 0; _hidl_index_0 < _hidl_vec_size; _hidl_index_0++) {
            this.areaConfigs.get(_hidl_index_0).writeEmbeddedToBlob(childBlob, _hidl_index_0 * 40);
        }
        _hidl_blob.putBlob(16 + _hidl_offset + 0, childBlob);
        _hidl_blob.putInt32(32 + _hidl_offset, this.configFlags);
        int _hidl_vec_size2 = this.configArray.size();
        _hidl_blob.putInt32(40 + _hidl_offset + 8, _hidl_vec_size2);
        _hidl_blob.putBool(40 + _hidl_offset + 12, false);
        HwBlob childBlob2 = new HwBlob(_hidl_vec_size2 * 4);
        for (int _hidl_index_02 = 0; _hidl_index_02 < _hidl_vec_size2; _hidl_index_02++) {
            childBlob2.putInt32(_hidl_index_02 * 4, this.configArray.get(_hidl_index_02).intValue());
        }
        _hidl_blob.putBlob(40 + _hidl_offset + 0, childBlob2);
        _hidl_blob.putString(56 + _hidl_offset, this.configString);
        _hidl_blob.putFloat(72 + _hidl_offset, this.minSampleRate);
        _hidl_blob.putFloat(76 + _hidl_offset, this.maxSampleRate);
    }
}