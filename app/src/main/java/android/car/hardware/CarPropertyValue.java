package android.car.hardware;

import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes.dex */
public class CarPropertyValue<T> implements Parcelable {
    private final int mAreaId;
    private final int mPropertyId;
    private final T mValue;
    private static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final Creator<CarPropertyValue> CREATOR = new Creator<CarPropertyValue>() { // from class: android.car.hardware.CarPropertyValue.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarPropertyValue createFromParcel(Parcel in) {
            return new CarPropertyValue(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CarPropertyValue[] newArray(int size) {
            return new CarPropertyValue[size];
        }
    };

    public CarPropertyValue(int propertyId, T value) {
        this(propertyId, 0, value);
    }

    public CarPropertyValue(int propertyId, int areaId, T value) {
        this.mPropertyId = propertyId;
        this.mAreaId = areaId;
        this.mValue = value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CarPropertyValue(Parcel parcel) {
        this.mPropertyId = parcel.readInt();
        this.mAreaId = parcel.readInt();
        String string = parcel.readString();
        try {
            Class<?> cls = Class.forName(string);
            if (String.class.equals(cls)) {
                this.mValue = (T) new String(parcel.readBlob(), DEFAULT_CHARSET);
            } else if (byte[].class.equals(cls)) {
                this.mValue = (T) parcel.readBlob();
            } else {
                this.mValue = (T) parcel.readValue(cls.getClassLoader());
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException("Class not found: " + string);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mPropertyId);
        parcel.writeInt(this.mAreaId);
        Class<?> cls = this.mValue == null ? null : this.mValue.getClass();
        parcel.writeString(cls != null ? cls.getName() : null);
        if (String.class.equals(cls)) {
            parcel.writeBlob(((String) this.mValue).getBytes(DEFAULT_CHARSET));
        } else if (byte[].class.equals(cls)) {
            parcel.writeBlob((byte[]) this.mValue);
        } else {
            parcel.writeValue(this.mValue);
        }
    }

    public int getPropertyId() {
        return this.mPropertyId;
    }

    public int getAreaId() {
        return this.mAreaId;
    }

    public T getValue() {
        return this.mValue;
    }

    public String toString() {
        return "CarPropertyValue{mPropertyId=0x" + Integer.toHexString(this.mPropertyId) + ", mAreaId=0x" + Integer.toHexString(this.mAreaId) + ", mValue=" + this.mValue + '}';
    }
}