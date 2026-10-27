package android.hardware.automotive.vehicleProgram.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class THERMAL_TEMP_DATA_TYPE {
    public static final int AMP1 = 16;
    public static final int AMP2 = 32;
    public static final int BACK_SXM = 2;
    public static final int DISPLAY_MONITOR = 4;
    public static final int GYRO = 64;
    public static final int MAIN_TEMPERATURE = 8;
    public static final int PMI = 1;

    public static final String toString(int o) {
        if (o == 1) {
            return "PMI";
        }
        if (o == 2) {
            return "BACK_SXM";
        }
        if (o == 4) {
            return "DISPLAY_MONITOR";
        }
        if (o == 8) {
            return "MAIN_TEMPERATURE";
        }
        if (o == 16) {
            return "AMP1";
        }
        if (o == 32) {
            return "AMP2";
        }
        if (o == 64) {
            return "GYRO";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        if ((o & 1) == 1) {
            list.add("PMI");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("BACK_SXM");
            flipped |= 2;
        }
        if ((o & 4) == 4) {
            list.add("DISPLAY_MONITOR");
            flipped |= 4;
        }
        if ((o & 8) == 8) {
            list.add("MAIN_TEMPERATURE");
            flipped |= 8;
        }
        if ((o & 16) == 16) {
            list.add("AMP1");
            flipped |= 16;
        }
        if ((o & 32) == 32) {
            list.add("AMP2");
            flipped |= 32;
        }
        if ((o & 64) == 64) {
            list.add("GYRO");
            flipped |= 64;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}