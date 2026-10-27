package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ValueType {
    public static final int VT_BYTE = 1;
    public static final int VT_FLOAT = 4;
    public static final int VT_INT = 3;
    public static final int VT_INT64 = 8;
    public static final int VT_SPAIR = 9;
    public static final int VT_STRING = 6;
    public static final int VT_UBYTE = 0;
    public static final int VT_UFLOAT = 5;
    public static final int VT_UINT = 2;
    public static final int VT_UINT64 = 7;

    public static final String toString(int o) {
        if (o == 0) {
            return "VT_UBYTE";
        }
        if (o == 1) {
            return "VT_BYTE";
        }
        if (o == 2) {
            return "VT_UINT";
        }
        if (o == 3) {
            return "VT_INT";
        }
        if (o == 4) {
            return "VT_FLOAT";
        }
        if (o == 5) {
            return "VT_UFLOAT";
        }
        if (o == 6) {
            return "VT_STRING";
        }
        if (o == 7) {
            return "VT_UINT64";
        }
        if (o == 8) {
            return "VT_INT64";
        }
        if (o == 9) {
            return "VT_SPAIR";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("VT_UBYTE");
        if ((o & 1) == 1) {
            list.add("VT_BYTE");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("VT_UINT");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("VT_INT");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("VT_FLOAT");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("VT_UFLOAT");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("VT_STRING");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("VT_UINT64");
            flipped |= 7;
        }
        if ((o & 8) == 8) {
            list.add("VT_INT64");
            flipped |= 8;
        }
        if ((o & 9) == 9) {
            list.add("VT_SPAIR");
            flipped |= 9;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}