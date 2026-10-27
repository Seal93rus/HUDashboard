package vendor.harman.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class VmsMessageWithLayerAndPublisherIdIntegerValuesIndex {
    public static final int LAYER_SUBTYPE = 2;
    public static final int LAYER_TYPE = 1;
    public static final int LAYER_VERSION = 3;
    public static final int MESSAGE_TYPE = 0;
    public static final int PUBLISHER_ID = 4;

    public static final String toString(int o) {
        return o == 4 ? "PUBLISHER_ID" : "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        if ((o & 4) == 4) {
            list.add("PUBLISHER_ID");
            flipped = 0 | 4;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}