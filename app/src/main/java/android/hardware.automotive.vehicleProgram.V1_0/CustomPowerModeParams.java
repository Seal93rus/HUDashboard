package android.hardware.automotive.vehicleProgram.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CustomPowerModeParams {
    public static final int VPM_GENERATOR = 9;
    public static final int VPM_LASTMODE = 11;
    public static final int VPM_OVERHEAT = 10;
    public static final int VPM_POWERSAVING1 = 5;
    public static final int VPM_POWERSAVING2 = 6;
    public static final int VPM_POWERSAVING3 = 7;
    public static final int VPM_POWERSAVING_OFF = 4;
    public static final int VPM_TRANSPORT = 8;

    public static final String toString(int o) {
        if (o == 4) {
            return "VPM_POWERSAVING_OFF";
        }
        if (o == 5) {
            return "VPM_POWERSAVING1";
        }
        if (o == 6) {
            return "VPM_POWERSAVING2";
        }
        if (o == 7) {
            return "VPM_POWERSAVING3";
        }
        if (o == 8) {
            return "VPM_TRANSPORT";
        }
        if (o == 9) {
            return "VPM_GENERATOR";
        }
        if (o == 10) {
            return "VPM_OVERHEAT";
        }
        if (o == 11) {
            return "VPM_LASTMODE";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        if ((o & 4) == 4) {
            list.add("VPM_POWERSAVING_OFF");
            flipped = 0 | 4;
        }
        if ((o & 5) == 5) {
            list.add("VPM_POWERSAVING1");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("VPM_POWERSAVING2");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("VPM_POWERSAVING3");
            flipped |= 7;
        }
        if ((o & 8) == 8) {
            list.add("VPM_TRANSPORT");
            flipped |= 8;
        }
        if ((o & 9) == 9) {
            list.add("VPM_GENERATOR");
            flipped |= 9;
        }
        if ((o & 10) == 10) {
            list.add("VPM_OVERHEAT");
            flipped |= 10;
        }
        if ((o & 11) == 11) {
            list.add("VPM_LASTMODE");
            flipped |= 11;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}