package android.hardware.automotive.vehicleProgram.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CustomPowerMode {
    public static final int VPM_DEGRADED = 16;
    public static final int VPM_TITAN = 0;
    public static final int VPM_TOD = 17;
    public static final int VPM_UPDATE = 18;

    public static final String toString(int o) {
        if (o == 0) {
            return "VPM_TITAN";
        }
        if (o == 16) {
            return "VPM_DEGRADED";
        }
        if (o == 17) {
            return "VPM_TOD";
        }
        if (o == 18) {
            return "VPM_UPDATE";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("VPM_TITAN");
        if ((o & 16) == 16) {
            list.add("VPM_DEGRADED");
            flipped = 0 | 16;
        }
        if ((o & 17) == 17) {
            list.add("VPM_TOD");
            flipped |= 17;
        }
        if ((o & 18) == 18) {
            list.add("VPM_UPDATE");
            flipped |= 18;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}