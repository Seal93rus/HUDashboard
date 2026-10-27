/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.car.diagnostic;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.JsonWriter;
import android.util.SparseArray;
import android.util.SparseIntArray;

import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Objects;

/**
 * A CarDiagnosticEvent represents a diagnostic frame (live or freeze).
 */
public class CarDiagnosticEvent implements Parcelable {

    public static final Creator<CarDiagnosticEvent> CREATOR =
            new Creator<CarDiagnosticEvent>() {
                @Override
                public CarDiagnosticEvent createFromParcel(Parcel in) {
                    return new CarDiagnosticEvent(in);
                }

                @Override
                public CarDiagnosticEvent[] newArray(int size) {
                    return new CarDiagnosticEvent[size];
                }
            };

    public final int frameType;
    public final long timestamp;
    public final String dtc;

    private final SparseArray<Float> floatValues;
    private final SparseIntArray intValues;

    public CarDiagnosticEvent(Parcel in) {
        frameType = in.readInt();
        timestamp = in.readLong();

        int len = in.readInt();
        floatValues = new SparseArray<>(len);
        for (int i = 0; i < len; i++) {
            int key = in.readInt();
            float value = in.readFloat();
            floatValues.put(key, value);
        }

        int len2 = in.readInt();
        intValues = new SparseIntArray(len2);
        for (int i = 0; i < len2; i++) {
            int key = in.readInt();
            int value = in.readInt();
            intValues.put(key, value);
        }

        dtc = (String) in.readValue(String.class.getClassLoader());
    }

    private CarDiagnosticEvent(int frameType, long timestamp,
                               SparseArray<Float> floatValues, SparseIntArray intValues, String dtc) {
        this.frameType = frameType;
        this.timestamp = timestamp;
        this.floatValues = floatValues;
        this.intValues = intValues;
        this.dtc = dtc;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(frameType);
        dest.writeLong(timestamp);

        dest.writeInt(floatValues.size());
        for (int i = 0; i < floatValues.size(); i++) {
            int key = floatValues.keyAt(i);
            dest.writeInt(key);
            dest.writeFloat(floatValues.valueAt(i));
        }

        dest.writeInt(intValues.size());
        for (int i = 0; i < intValues.size(); i++) {
            int key = intValues.keyAt(i);
            dest.writeInt(key);
            dest.writeInt(intValues.valueAt(i));
        }

        dest.writeValue(dtc);
    }

    public void writeToJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();

        jsonWriter.name("type");
        switch (frameType) {
            case 0:
                jsonWriter.value("live");
                break;
            case 1:
                jsonWriter.value("freeze");
                break;
            default:
                throw new IllegalStateException("unknown frameType " + frameType);
        }

        jsonWriter.name("timestamp").value(timestamp);

        jsonWriter.name("intValues").beginArray();
        for (int i = 0; i < intValues.size(); i++) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(intValues.keyAt(i));
            jsonWriter.name("value").value(intValues.valueAt(i));
            jsonWriter.endObject();
        }
        jsonWriter.endArray();

        jsonWriter.name("floatValues").beginArray();
        for (int i = 0; i < floatValues.size(); i++) {
            jsonWriter.beginObject();
            jsonWriter.name("id").value(floatValues.keyAt(i));
            jsonWriter.name("value").value(floatValues.valueAt(i));
            jsonWriter.endObject();
        }
        jsonWriter.endArray();

        if (dtc != null) {
            jsonWriter.name("stringValue").value(dtc);
        }

        jsonWriter.endObject();
    }

    public static class Builder {
        private final int mType;
        private long mTimestamp = 0;
        private final SparseArray<Float> mFloatValues = new SparseArray<>();
        private final SparseIntArray mIntValues = new SparseIntArray();
        private String mDtc = null;

        private Builder(int type) {
            mType = type;
        }

        public static Builder newLiveFrameBuilder() {
            return new Builder(0);
        }

        public static Builder newFreezeFrameBuilder() {
            return new Builder(1);
        }

        public Builder atTimestamp(long timestamp) {
            mTimestamp = timestamp;
            return this;
        }

        public Builder withIntValue(int key, int value) {
            mIntValues.put(key, value);
            return this;
        }

        public Builder withFloatValue(int key, float value) {
            mFloatValues.put(key, value);
            return this;
        }

        public Builder withDtc(String dtc) {
            mDtc = dtc;
            return this;
        }

        public CarDiagnosticEvent build() {
            return new CarDiagnosticEvent(mType, mTimestamp, mFloatValues, mIntValues, mDtc);
        }
    }

    public CarDiagnosticEvent withVendorSensorsRemoved() {
        SparseIntArray newIntValues = intValues.clone();
        SparseArray<Float> newFloatValues = floatValues.clone();
        for (int i = 0; i < intValues.size(); i++) {
            int key = intValues.keyAt(i);
            if (key >= 31) {
                newIntValues.delete(key);
            }
        }
        for (int i = 0; i < floatValues.size(); i++) {
            int key = floatValues.keyAt(i);
            if (key >= 70) {
                newFloatValues.delete(key);
            }
        }
        return new CarDiagnosticEvent(frameType, timestamp, newFloatValues, newIntValues, dtc);
    }

    public boolean isLiveFrame() {
        return frameType == 0;
    }

    public boolean isFreezeFrame() {
        return frameType == 1;
    }

    public boolean isEmptyFrame() {
        boolean empty = intValues.size() == 0 && floatValues.size() == 0;
        return isFreezeFrame() ? empty && (dtc == null || dtc.isEmpty()) : empty;
    }

    public CarDiagnosticEvent checkLiveFrame() {
        if (isLiveFrame()) {
            return this;
        }
        throw new IllegalStateException("frame is not a live frame");
    }

    public CarDiagnosticEvent checkFreezeFrame() {
        if (isFreezeFrame()) {
            return this;
        }
        throw new IllegalStateException("frame is not a freeze frame");
    }

    public boolean isEarlierThan(CarDiagnosticEvent otherEvent) {
        return timestamp < Objects.requireNonNull(otherEvent).timestamp;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null || !(otherObject instanceof CarDiagnosticEvent)) {
            return false;
        }
        CarDiagnosticEvent otherEvent = (CarDiagnosticEvent) otherObject;
        if (otherEvent.frameType != frameType
                || otherEvent.timestamp != timestamp
                || otherEvent.intValues.size() != intValues.size()
                || otherEvent.floatValues.size() != floatValues.size()
                || !Objects.equals(dtc, otherEvent.dtc)) {
            return false;
        }
        for (int i = 0; i < intValues.size(); i++) {
            int key = intValues.keyAt(i);
            int otherKey = otherEvent.intValues.keyAt(i);
            if (key != otherKey) {
                return false;
            }
            int value = intValues.valueAt(i);
            int otherValue = otherEvent.intValues.valueAt(i);
            if (value != otherValue) {
                return false;
            }
        }
        for (int i = 0; i < floatValues.size(); i++) {
            int key = floatValues.keyAt(i);
            int otherKey = otherEvent.floatValues.keyAt(i);
            if (key != otherKey) {
                return false;
            }
            float value = floatValues.valueAt(i);
            float otherValue = otherEvent.floatValues.valueAt(i);
            if (value != otherValue) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        Integer[] intKeys = new Integer[intValues.size()];
        Integer[] floatKeys = new Integer[floatValues.size()];
        Integer[] intValuesArr = new Integer[intKeys.length];
        Float[] floatValuesArr = new Float[floatKeys.length];
        for (int i = 0; i < intKeys.length; i++) {
            intKeys[i] = intValues.keyAt(i);
            intValuesArr[i] = intValues.valueAt(i);
        }
        for (int i = 0; i < floatKeys.length; i++) {
            floatKeys[i] = floatValues.keyAt(i);
            floatValuesArr[i] = floatValues.valueAt(i);
        }
        int intKeysHash = Arrays.hashCode(intKeys);
        int intValuesHash = Arrays.hashCode(intValuesArr);
        int floatKeysHash = Arrays.hashCode(floatKeys);
        int floatValuesHash = Arrays.hashCode(floatValuesArr);
        return Objects.hash(frameType, timestamp, dtc,
                intKeysHash, intValuesHash, floatKeysHash, floatValuesHash);
    }

    @Override
    public String toString() {
        return String.format(
                "%s diagnostic frame {\n\ttimestamp: %d, DTC: %s\n\tintValues: %s\n\tfloatValues: %s\n}",
                isLiveFrame() ? "live" : "freeze",
                timestamp,
                dtc,
                intValues.toString(),
                floatValues.toString());
    }

    public int getSystemIntegerSensor(int sensor, int defaultValue) {
        return intValues.get(sensor, defaultValue);
    }

    public float getSystemFloatSensor(int sensor, float defaultValue) {
        return floatValues.get(sensor, defaultValue);
    }

    public int getVendorIntegerSensor(int sensor, int defaultValue) {
        return intValues.get(sensor, defaultValue);
    }

    public float getVendorFloatSensor(int sensor, float defaultValue) {
        return floatValues.get(sensor, defaultValue);
    }

    public Integer getSystemIntegerSensor(int sensor) {
        int index = intValues.indexOfKey(sensor);
        if (index < 0) {
            return null;
        }
        return intValues.valueAt(index);
    }

    public Float getSystemFloatSensor(int sensor) {
        int index = floatValues.indexOfKey(sensor);
        if (index < 0) {
            return null;
        }
        return floatValues.valueAt(index);
    }

    public Integer getVendorIntegerSensor(int sensor) {
        int index = intValues.indexOfKey(sensor);
        if (index < 0) {
            return null;
        }
        return intValues.valueAt(index);
    }

    public Float getVendorFloatSensor(int sensor) {
        int index = floatValues.indexOfKey(sensor);
        if (index < 0) {
            return null;
        }
        return floatValues.valueAt(index);
    }

    public static final class FuelSystemStatus {
        public static final int OPEN_INSUFFICIENT_ENGINE_TEMPERATURE = 1;
        public static final int CLOSED_LOOP = 2;
        public static final int OPEN_ENGINE_LOAD_OR_DECELERATION = 4;
        public static final int OPEN_SYSTEM_FAILURE = 8;
        public static final int CLOSED_LOOP_BUT_FEEDBACK_FAULT = 16;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
        }

        private FuelSystemStatus() {
        }
    }

    public static final class SecondaryAirStatus {
        public static final int UPSTREAM = 1;
        public static final int DOWNSTREAM_OF_CATALYCIC_CONVERTER = 2;
        public static final int FROM_OUTSIDE_OR_OFF = 4;
        public static final int PUMP_ON_FOR_DIAGNOSTICS = 8;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Status {
        }

        private SecondaryAirStatus() {
        }
    }

    public static final class FuelType {
        public static final int NOT_AVAILABLE = 0;
        public static final int GASOLINE = 1;
        public static final int METHANOL = 2;
        public static final int ETHANOL = 3;
        public static final int DIESEL = 4;
        public static final int LPG = 5;
        public static final int CNG = 6;
        public static final int PROPANE = 7;
        public static final int ELECTRIC = 8;
        public static final int BIFUEL_RUNNING_GASOLINE = 9;
        public static final int BIFUEL_RUNNING_METHANOL = 10;
        public static final int BIFUEL_RUNNING_ETHANOL = 11;
        public static final int BIFUEL_RUNNING_LPG = 12;
        public static final int BIFUEL_RUNNING_CNG = 13;
        public static final int BIFUEL_RUNNING_PROPANE = 14;
        public static final int BIFUEL_RUNNING_ELECTRIC = 15;
        public static final int BIFUEL_RUNNING_ELECTRIC_AND_COMBUSTION = 16;
        public static final int HYBRID_GASOLINE = 17;
        public static final int HYBRID_ETHANOL = 18;
        public static final int HYBRID_DIESEL = 19;
        public static final int HYBRID_ELECTRIC = 20;
        public static final int HYBRID_RUNNING_ELECTRIC_AND_COMBUSTION = 21;
        public static final int HYBRID_REGENERATIVE = 22;
        public static final int BIFUEL_RUNNING_DIESEL = 23;

        @Retention(RetentionPolicy.SOURCE)
        public @interface Type {
        }

        private FuelType() {
        }
    }

    public static final class IgnitionMonitor {
        public final boolean available;
        public final boolean incomplete;

        IgnitionMonitor(boolean available, boolean incomplete) {
            this.available = available;
            this.incomplete = incomplete;
        }

        public static final class Decoder {
            private final int mAvailableBitmask;
            private final int mIncompleteBitmask;

            Decoder(int availableBitmask, int incompleteBitmask) {
                mAvailableBitmask = availableBitmask;
                mIncompleteBitmask = incompleteBitmask;
            }

            public IgnitionMonitor fromValue(int value) {
                boolean available = (mAvailableBitmask & value) != 0;
                boolean incomplete = (mIncompleteBitmask & value) != 0;
                return new IgnitionMonitor(available, incomplete);
            }
        }
    }

    public static class CommonIgnitionMonitors {
        public static final int COMPONENTS_AVAILABLE = 0x1;
        public static final int COMPONENTS_INCOMPLETE = 0x2;
        public static final int FUEL_SYSTEM_AVAILABLE = 0x4;
        public static final int FUEL_SYSTEM_INCOMPLETE = 0x8;
        public static final int MISFIRE_AVAILABLE = 0x10;
        public static final int MISFIRE_INCOMPLETE = 0x20;

        public final IgnitionMonitor components;
        public final IgnitionMonitor fuelSystem;
        public final IgnitionMonitor misfire;

        static final IgnitionMonitor.Decoder COMPONENTS_DECODER =
                new IgnitionMonitor.Decoder(COMPONENTS_AVAILABLE, COMPONENTS_INCOMPLETE);
        static final IgnitionMonitor.Decoder FUEL_SYSTEM_DECODER =
                new IgnitionMonitor.Decoder(FUEL_SYSTEM_AVAILABLE, FUEL_SYSTEM_INCOMPLETE);
        static final IgnitionMonitor.Decoder MISFIRE_DECODER =
                new IgnitionMonitor.Decoder(MISFIRE_AVAILABLE, MISFIRE_INCOMPLETE);

        CommonIgnitionMonitors(int bitmask) {
            components = COMPONENTS_DECODER.fromValue(bitmask);
            fuelSystem = FUEL_SYSTEM_DECODER.fromValue(bitmask);
            misfire = MISFIRE_DECODER.fromValue(bitmask);
        }

        public SparkIgnitionMonitors asSparkIgnitionMonitors() {
            if (this instanceof SparkIgnitionMonitors) {
                return (SparkIgnitionMonitors) this;
            }
            return null;
        }

        public CompressionIgnitionMonitors asCompressionIgnitionMonitors() {
            if (this instanceof CompressionIgnitionMonitors) {
                return (CompressionIgnitionMonitors) this;
            }
            return null;
        }
    }

    public static final class SparkIgnitionMonitors extends CommonIgnitionMonitors {
        public static final int EGR_AVAILABLE = 0x40;
        public static final int EGR_INCOMPLETE = 0x80;
        public static final int OXYGEN_SENSOR_HEATER_AVAILABLE = 0x100;
        public static final int OXYGEN_SENSOR_HEATER_INCOMPLETE = 0x200;
        public static final int OXYGEN_SENSOR_AVAILABLE = 0x400;
        public static final int OXYGEN_SENSOR_INCOMPLETE = 0x800;
        public static final int AC_REFRIGERANT_AVAILABLE = 0x1000;
        public static final int AC_REFRIGERANT_INCOMPLETE = 0x2000;
        public static final int SECONDARY_AIR_SYSTEM_AVAILABLE = 0x4000;
        public static final int SECONDARY_AIR_SYSTEM_INCOMPLETE = 0x8000;
        public static final int EVAPORATIVE_SYSTEM_AVAILABLE = 0x10000;
        public static final int EVAPORATIVE_SYSTEM_INCOMPLETE = 0x20000;
        public static final int HEATED_CATALYST_AVAILABLE = 0x40000;
        public static final int HEATED_CATALYST_INCOMPLETE = 0x80000;
        public static final int CATALYST_AVAILABLE = 0x100000;
        public static final int CATALYST_INCOMPLETE = 0x200000;

        public final IgnitionMonitor EGR;
        public final IgnitionMonitor oxygenSensorHeater;
        public final IgnitionMonitor oxygenSensor;
        public final IgnitionMonitor ACRefrigerant;
        public final IgnitionMonitor secondaryAirSystem;
        public final IgnitionMonitor evaporativeSystem;
        public final IgnitionMonitor heatedCatalyst;
        public final IgnitionMonitor catalyst;

        static final IgnitionMonitor.Decoder EGR_DECODER =
                new IgnitionMonitor.Decoder(EGR_AVAILABLE, EGR_INCOMPLETE);
        static final IgnitionMonitor.Decoder OXYGEN_SENSOR_HEATER_DECODER =
                new IgnitionMonitor.Decoder(OXYGEN_SENSOR_HEATER_AVAILABLE,
                        OXYGEN_SENSOR_HEATER_INCOMPLETE);
        static final IgnitionMonitor.Decoder OXYGEN_SENSOR_DECODER =
                new IgnitionMonitor.Decoder(OXYGEN_SENSOR_AVAILABLE, OXYGEN_SENSOR_INCOMPLETE);
        static final IgnitionMonitor.Decoder AC_REFRIGERANT_DECODER =
                new IgnitionMonitor.Decoder(AC_REFRIGERANT_AVAILABLE, AC_REFRIGERANT_INCOMPLETE);
        static final IgnitionMonitor.Decoder SECONDARY_AIR_SYSTEM_DECODER =
                new IgnitionMonitor.Decoder(SECONDARY_AIR_SYSTEM_AVAILABLE,
                        SECONDARY_AIR_SYSTEM_INCOMPLETE);
        static final IgnitionMonitor.Decoder EVAPORATIVE_SYSTEM_DECODER =
                new IgnitionMonitor.Decoder(EVAPORATIVE_SYSTEM_AVAILABLE,
                        EVAPORATIVE_SYSTEM_INCOMPLETE);
        static final IgnitionMonitor.Decoder HEATED_CATALYST_DECODER =
                new IgnitionMonitor.Decoder(HEATED_CATALYST_AVAILABLE,
                        HEATED_CATALYST_INCOMPLETE);
        static final IgnitionMonitor.Decoder CATALYST_DECODER =
                new IgnitionMonitor.Decoder(CATALYST_AVAILABLE, CATALYST_INCOMPLETE);

        SparkIgnitionMonitors(int bitmask) {
            super(bitmask);
            EGR = EGR_DECODER.fromValue(bitmask);
            oxygenSensorHeater = OXYGEN_SENSOR_HEATER_DECODER.fromValue(bitmask);
            oxygenSensor = OXYGEN_SENSOR_DECODER.fromValue(bitmask);
            ACRefrigerant = AC_REFRIGERANT_DECODER.fromValue(bitmask);
            secondaryAirSystem = SECONDARY_AIR_SYSTEM_DECODER.fromValue(bitmask);
            evaporativeSystem = EVAPORATIVE_SYSTEM_DECODER.fromValue(bitmask);
            heatedCatalyst = HEATED_CATALYST_DECODER.fromValue(bitmask);
            catalyst = CATALYST_DECODER.fromValue(bitmask);
        }
    }

    public static final class CompressionIgnitionMonitors extends CommonIgnitionMonitors {
        public static final int EGR_OR_VVT_AVAILABLE = 0x40;
        public static final int EGR_OR_VVT_INCOMPLETE = 0x80;
        public static final int PM_FILTER_AVAILABLE = 0x100;
        public static final int PM_FILTER_INCOMPLETE = 0x200;
        public static final int EXHAUST_GAS_SENSOR_AVAILABLE = 0x400;
        public static final int EXHAUST_GAS_SENSOR_INCOMPLETE = 0x800;
        public static final int BOOST_PRESSURE_AVAILABLE = 0x1000;
        public static final int BOOST_PRESSURE_INCOMPLETE = 0x2000;
        public static final int NOx_SCR_AVAILABLE = 0x4000;
        public static final int NOx_SCR_INCOMPLETE = 0x8000;
        public static final int NMHC_CATALYST_AVAILABLE = 0x10000;
        public static final int NMHC_CATALYST_INCOMPLETE = 0x20000;

        public final IgnitionMonitor EGROrVVT;
        public final IgnitionMonitor PMFilter;
        public final IgnitionMonitor exhaustGasSensor;
        public final IgnitionMonitor boostPressure;
        public final IgnitionMonitor NOxSCR;
        public final IgnitionMonitor NMHCCatalyst;

        static final IgnitionMonitor.Decoder EGR_OR_VVT_DECODER =
                new IgnitionMonitor.Decoder(EGR_OR_VVT_AVAILABLE, EGR_OR_VVT_INCOMPLETE);
        static final IgnitionMonitor.Decoder PM_FILTER_DECODER =
                new IgnitionMonitor.Decoder(PM_FILTER_AVAILABLE, PM_FILTER_INCOMPLETE);
        static final IgnitionMonitor.Decoder EXHAUST_GAS_SENSOR_DECODER =
                new IgnitionMonitor.Decoder(EXHAUST_GAS_SENSOR_AVAILABLE,
                        EXHAUST_GAS_SENSOR_INCOMPLETE);
        static final IgnitionMonitor.Decoder BOOST_PRESSURE_DECODER =
                new IgnitionMonitor.Decoder(BOOST_PRESSURE_AVAILABLE,
                        BOOST_PRESSURE_INCOMPLETE);
        static final IgnitionMonitor.Decoder NOx_SCR_DECODER =
                new IgnitionMonitor.Decoder(NOx_SCR_AVAILABLE, NOx_SCR_INCOMPLETE);
        static final IgnitionMonitor.Decoder NMHC_CATALYST_DECODER =
                new IgnitionMonitor.Decoder(NMHC_CATALYST_AVAILABLE,
                        NMHC_CATALYST_INCOMPLETE);

        CompressionIgnitionMonitors(int bitmask) {
            super(bitmask);
            EGROrVVT = EGR_OR_VVT_DECODER.fromValue(bitmask);
            PMFilter = PM_FILTER_DECODER.fromValue(bitmask);
            exhaustGasSensor = EXHAUST_GAS_SENSOR_DECODER.fromValue(bitmask);
            boostPressure = BOOST_PRESSURE_DECODER.fromValue(bitmask);
            NOxSCR = NOx_SCR_DECODER.fromValue(bitmask);
            NMHCCatalyst = NMHC_CATALYST_DECODER.fromValue(bitmask);
        }
    }

    public Integer getFuelSystemStatus() {
        return getSystemIntegerSensor(0);
    }

    public Integer getSecondaryAirStatus() {
        return getSystemIntegerSensor(5);
    }

    public CommonIgnitionMonitors getIgnitionMonitors() {
        Integer ignitionMonitorsType = getSystemIntegerSensor(2);
        Integer ignitionMonitorsBitmask = getSystemIntegerSensor(3);
        if (ignitionMonitorsType == null || ignitionMonitorsBitmask == null) {
            return null;
        }
        switch (ignitionMonitorsType) {
            case 0:
                return new SparkIgnitionMonitors(ignitionMonitorsBitmask);
            case 1:
                return new CompressionIgnitionMonitors(ignitionMonitorsBitmask);
            default:
                return null;
        }
    }

    public Integer getFuelType() {
        return getSystemIntegerSensor(21);
    }
}