package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class EGNSSAntennaStatus {
    public static final int GNSS_ANT_STATUS_NORMAL = 0;
    public static final int GNSS_ANT_STATUS_OPEN = 2;
    public static final int GNSS_ANT_STATUS_OUTOFSERVICE = 5;
    public static final int GNSS_ANT_STATUS_OVERCURRENT = 1;
    public static final int GNSS_ANT_STATUS_SHORT_BATT = 4;
    public static final int GNSS_ANT_STATUS_SHORT_GND = 3;

    public static final String toString(int o) {
        if (o == 0) {
            return "GNSS_ANT_STATUS_NORMAL";
        }
        if (o == 1) {
            return "GNSS_ANT_STATUS_OVERCURRENT";
        }
        if (o == 2) {
            return "GNSS_ANT_STATUS_OPEN";
        }
        if (o == 3) {
            return "GNSS_ANT_STATUS_SHORT_GND";
        }
        if (o == 4) {
            return "GNSS_ANT_STATUS_SHORT_BATT";
        }
        if (o == 5) {
            return "GNSS_ANT_STATUS_OUTOFSERVICE";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("GNSS_ANT_STATUS_NORMAL");
        if ((o & 1) == 1) {
            list.add("GNSS_ANT_STATUS_OVERCURRENT");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("GNSS_ANT_STATUS_OPEN");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("GNSS_ANT_STATUS_SHORT_GND");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("GNSS_ANT_STATUS_SHORT_BATT");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("GNSS_ANT_STATUS_OUTOFSERVICE");
            flipped |= 5;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}