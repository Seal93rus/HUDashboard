package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class DTC_ID {
    public static final int DUMMY_DTC = 0;

    public static final String toString(int o) {
        return o == 0 ? "DUMMY_DTC" : "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        list.add("DUMMY_DTC");
        if (o != 0) {
            list.add("0x" + Integer.toHexString(o & (-1)));
        }
        return String.join(" | ", list);
    }
}