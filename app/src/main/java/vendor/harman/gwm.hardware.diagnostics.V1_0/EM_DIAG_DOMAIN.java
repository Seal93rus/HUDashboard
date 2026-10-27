package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class EM_DIAG_DOMAIN {
    public static final int EM_DIAG_DOMAIN_ADAS = 3;
    public static final int EM_DIAG_DOMAIN_ADAS_AVAP = 6;
    public static final int EM_DIAG_DOMAIN_CAN_GATEWAY = 5;
    public static final int EM_DIAG_DOMAIN_DIAG_FW = 0;
    public static final int EM_DIAG_DOMAIN_DIAG_HAL_AME = 1;
    public static final int EM_DIAG_DOMAIN_DIAG_HAL_OEM = 2;
    public static final int EM_DIAG_DOMAIN_END = 7;
    public static final int EM_DIAG_DOMAIN_GNSS = 4;

    public static final String toString(int o) {
        if (o == 0) {
            return "EM_DIAG_DOMAIN_DIAG_FW";
        }
        if (o == 1) {
            return "EM_DIAG_DOMAIN_DIAG_HAL_AME";
        }
        if (o == 2) {
            return "EM_DIAG_DOMAIN_DIAG_HAL_OEM";
        }
        if (o == 3) {
            return "EM_DIAG_DOMAIN_ADAS";
        }
        if (o == 4) {
            return "EM_DIAG_DOMAIN_GNSS";
        }
        if (o == 5) {
            return "EM_DIAG_DOMAIN_CAN_GATEWAY";
        }
        if (o == 6) {
            return "EM_DIAG_DOMAIN_ADAS_AVAP";
        }
        if (o == 7) {
            return "EM_DIAG_DOMAIN_END";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("EM_DIAG_DOMAIN_DIAG_FW");
        if ((o & 1) == 1) {
            list.add("EM_DIAG_DOMAIN_DIAG_HAL_AME");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("EM_DIAG_DOMAIN_DIAG_HAL_OEM");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("EM_DIAG_DOMAIN_ADAS");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("EM_DIAG_DOMAIN_GNSS");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("EM_DIAG_DOMAIN_CAN_GATEWAY");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("EM_DIAG_DOMAIN_ADAS_AVAP");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("EM_DIAG_DOMAIN_END");
            flipped |= 7;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}