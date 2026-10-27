package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class EM_DIAG_DATA_TYPE {
    public static final int EM_DIAG_DATA_TYPE_CAN_GATEWAY = 6;
    public static final int EM_DIAG_DATA_TYPE_CMD = 0;
    public static final int EM_DIAG_DATA_TYPE_DTC = 1;
    public static final int EM_DIAG_DATA_TYPE_END = 9;
    public static final int EM_DIAG_DATA_TYPE_PKI = 8;
    public static final int EM_DIAG_DATA_TYPE_RDBI = 3;
    public static final int EM_DIAG_DATA_TYPE_STATUS = 2;
    public static final int EM_DIAG_DATA_TYPE_TEST = 7;
    public static final int EM_DIAG_DATA_TYPE_VERSION = 5;
    public static final int EM_DIAG_DATA_TYPE_WDBI = 4;

    public static final String toString(int o) {
        if (o == 0) {
            return "EM_DIAG_DATA_TYPE_CMD";
        }
        if (o == 1) {
            return "EM_DIAG_DATA_TYPE_DTC";
        }
        if (o == 2) {
            return "EM_DIAG_DATA_TYPE_STATUS";
        }
        if (o == 3) {
            return "EM_DIAG_DATA_TYPE_RDBI";
        }
        if (o == 4) {
            return "EM_DIAG_DATA_TYPE_WDBI";
        }
        if (o == 5) {
            return "EM_DIAG_DATA_TYPE_VERSION";
        }
        if (o == 6) {
            return "EM_DIAG_DATA_TYPE_CAN_GATEWAY";
        }
        if (o == 7) {
            return "EM_DIAG_DATA_TYPE_TEST";
        }
        if (o == 8) {
            return "EM_DIAG_DATA_TYPE_PKI";
        }
        if (o == 9) {
            return "EM_DIAG_DATA_TYPE_END";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("EM_DIAG_DATA_TYPE_CMD");
        if ((o & 1) == 1) {
            list.add("EM_DIAG_DATA_TYPE_DTC");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("EM_DIAG_DATA_TYPE_STATUS");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("EM_DIAG_DATA_TYPE_RDBI");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("EM_DIAG_DATA_TYPE_WDBI");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("EM_DIAG_DATA_TYPE_VERSION");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("EM_DIAG_DATA_TYPE_CAN_GATEWAY");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("EM_DIAG_DATA_TYPE_TEST");
            flipped |= 7;
        }
        if ((o & 8) == 8) {
            list.add("EM_DIAG_DATA_TYPE_PKI");
            flipped |= 8;
        }
        if ((o & 9) == 9) {
            list.add("EM_DIAG_DATA_TYPE_END");
            flipped |= 9;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}