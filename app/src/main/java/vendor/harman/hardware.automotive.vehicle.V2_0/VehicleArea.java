package vendor.harman.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class VehicleArea {
    public static final int DOOR = 100663296;
    public static final int GLOBAL = 16777216;
    public static final int MASK = 251658240;
    public static final int MIRROR = 67108864;
    public static final int SEAT = 83886080;
    public static final int WINDOW = 50331648;
    public static final int ZONE = 33554432;

    public static final String toString(int o) {
        if (o == 16777216) {
            return "GLOBAL";
        }
        if (o == 33554432) {
            return "ZONE";
        }
        if (o == 50331648) {
            return "WINDOW";
        }
        if (o == 67108864) {
            return "MIRROR";
        }
        if (o == 83886080) {
            return "SEAT";
        }
        if (o == 100663296) {
            return "DOOR";
        }
        if (o == 251658240) {
            return "MASK";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        if ((o & 16777216) == 16777216) {
            list.add("GLOBAL");
            flipped = 0 | 16777216;
        }
        if ((o & ZONE) == 33554432) {
            list.add("ZONE");
            flipped |= ZONE;
        }
        if ((o & WINDOW) == 50331648) {
            list.add("WINDOW");
            flipped |= WINDOW;
        }
        if ((o & MIRROR) == 67108864) {
            list.add("MIRROR");
            flipped |= MIRROR;
        }
        if ((o & SEAT) == 83886080) {
            list.add("SEAT");
            flipped |= SEAT;
        }
        if ((100663296 & o) == 100663296) {
            list.add("DOOR");
            flipped |= DOOR;
        }
        if ((251658240 & o) == 251658240) {
            list.add("MASK");
            flipped |= MASK;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}