package vendor.harman.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class VmsBaseMessageIntegerValuesIndex {
    public static final int MESSAGE_TYPE = 0;

    public static final String toString(int o) {
        return o == 0 ? "MESSAGE_TYPE" : "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        list.add("MESSAGE_TYPE");
        if (o != 0) {
            list.add("0x" + Integer.toHexString(o & (-1)));
        }
        return String.join(" | ", list);
    }
}