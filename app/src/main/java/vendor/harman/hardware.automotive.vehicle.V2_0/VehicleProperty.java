package vendor.harman.hardware.automotive.vehicle.V2_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class VehicleProperty {
    public static final int ABS_ACTIVE = 287310858;
    public static final int AP_POWER_BOOTUP_REASON = 289409538;
    public static final int AP_POWER_STATE = 289475072;
    public static final int AUDIO_EXT_ROUTING_HINT = 289474821;
    public static final int AUDIO_FOCUS = 289474816;
    public static final int AUDIO_FOCUS_EXT_SYNC = 289474832;
    public static final int AUDIO_HW_VARIANT = 289409284;
    public static final int AUDIO_PARAMETERS = 286263559;
    public static final int AUDIO_ROUTING_POLICY = 289474819;
    public static final int AUDIO_STREAM_STATE = 289474822;
    public static final int AUDIO_VOLUME = 289474817;
    public static final int AUDIO_VOLUME_EXT_SYNC = 289474833;
    public static final int AUDIO_VOLUME_LIMIT = 289474818;
    public static final int CURRENT_GEAR = 289408001;
    public static final int CURRENT_TIME_IN_SECONDS = 289409585;
    public static final int DISPLAY_BRIGHTNESS = 289409537;
    public static final int DOOR_LOCK = 371198722;
    public static final int DOOR_MOVE = 373295873;
    public static final int DOOR_POS = 373295872;
    public static final int DRIVING_STATUS = 289408004;
    public static final int ENGINE_COOLANT_TEMP = 291504897;
    public static final int ENGINE_OIL_TEMP = 291504900;
    public static final int ENGINE_RPM = 291504901;
    public static final int ENV_CABIN_TEMPERATURE = 291505924;
    public static final int ENV_OUTSIDE_TEMPERATURE = 291505923;
    public static final int FUEL_LEVEL_LOW = 287310853;
    public static final int GEAR_SELECTION = 289408000;
    public static final int HVAC_ACTUAL_FAN_SPEED_RPM = 306185487;
    public static final int HVAC_AC_ON = 304088325;
    public static final int HVAC_AUTO_ON = 304088330;
    public static final int HVAC_AUTO_RECIRC_ON = 304088338;
    public static final int HVAC_DEFROSTER = 320865540;
    public static final int HVAC_DUAL_ON = 304088329;
    public static final int HVAC_FAN_DIRECTION = 306185473;
    public static final int HVAC_FAN_DIRECTION_AVAILABLE = 306185489;
    public static final int HVAC_FAN_SPEED = 306185472;
    public static final int HVAC_MAX_AC_ON = 304088326;
    public static final int HVAC_MAX_DEFROST_ON = 304088327;
    public static final int HVAC_POWER_ON = 304088336;
    public static final int HVAC_RECIRC_ON = 304088328;
    public static final int HVAC_SEAT_TEMPERATURE = 356517131;
    public static final int HVAC_SIDE_MIRROR_HEAT = 339739916;
    public static final int HVAC_STEERING_WHEEL_TEMP = 289408269;
    public static final int HVAC_TEMPERATURE_CURRENT = 308282626;
    public static final int HVAC_TEMPERATURE_SET = 308282627;
    public static final int HVAC_TEMPERATURE_UNITS = 306185486;
    public static final int HW_KEY_INPUT = 289475088;
    public static final int IGNITION_STATE = 289408009;
    public static final int INFO_FUEL_CAPACITY = 291504388;
    public static final int INFO_MAKE = 286261505;
    public static final int INFO_MODEL = 286261506;
    public static final int INFO_MODEL_YEAR = 289407235;
    public static final int INFO_VIN = 286261504;
    public static final int INSTRUMENT_CLUSTER_INFO = 289475104;
    public static final int INVALID = 0;
    public static final int MIRROR_FOLD = 287312709;
    public static final int MIRROR_LOCK = 287312708;
    public static final int MIRROR_Y_MOVE = 339741507;
    public static final int MIRROR_Y_POS = 339741506;
    public static final int MIRROR_Z_MOVE = 339741505;
    public static final int MIRROR_Z_POS = 339741504;
    public static final int NIGHT_MODE = 287310855;
    public static final int OBD2_FREEZE_FRAME = 299896065;
    public static final int OBD2_FREEZE_FRAME_CLEAR = 299896067;
    public static final int OBD2_FREEZE_FRAME_INFO = 299896066;
    public static final int OBD2_LIVE_FRAME = 299896064;
    public static final int PARKING_BRAKE_ON = 287310850;
    public static final int PERF_ODOMETER = 291504644;
    public static final int PERF_VEHICLE_SPEED = 291504647;
    public static final int RADIO_PRESET = 289474561;
    public static final int SEAT_BACKREST_ANGLE_1_MOVE = 356518792;
    public static final int SEAT_BACKREST_ANGLE_1_POS = 356518791;
    public static final int SEAT_BACKREST_ANGLE_2_MOVE = 356518794;
    public static final int SEAT_BACKREST_ANGLE_2_POS = 356518793;
    public static final int SEAT_BELT_BUCKLED = 354421634;
    public static final int SEAT_BELT_HEIGHT_MOVE = 356518788;
    public static final int SEAT_BELT_HEIGHT_POS = 356518787;
    public static final int SEAT_DEPTH_MOVE = 356518798;
    public static final int SEAT_DEPTH_POS = 356518797;
    public static final int SEAT_FORE_AFT_MOVE = 356518790;
    public static final int SEAT_FORE_AFT_POS = 356518789;
    public static final int SEAT_HEADREST_ANGLE_MOVE = 356518808;
    public static final int SEAT_HEADREST_ANGLE_POS = 356518807;
    public static final int SEAT_HEADREST_FORE_AFT_MOVE = 356518810;
    public static final int SEAT_HEADREST_FORE_AFT_POS = 356518809;
    public static final int SEAT_HEADREST_HEIGHT_MOVE = 356518806;
    public static final int SEAT_HEADREST_HEIGHT_POS = 289409941;
    public static final int SEAT_HEIGHT_MOVE = 356518796;
    public static final int SEAT_HEIGHT_POS = 356518795;
    public static final int SEAT_LUMBAR_FORE_AFT_MOVE = 356518802;
    public static final int SEAT_LUMBAR_FORE_AFT_POS = 356518801;
    public static final int SEAT_LUMBAR_SIDE_SUPPORT_MOVE = 356518804;
    public static final int SEAT_LUMBAR_SIDE_SUPPORT_POS = 356518803;
    public static final int SEAT_MEMORY_SELECT = 356518784;
    public static final int SEAT_MEMORY_SET = 356518785;
    public static final int SEAT_TILT_MOVE = 356518800;
    public static final int SEAT_TILT_POS = 356518799;
    public static final int TRACTION_CONTROL_ACTIVE = 287310859;
    public static final int TURN_SIGNAL_STATE = 289408008;
    public static final int UNIX_TIME = 290458160;
    public static final int VEHICLE_MAP_SERVICE = 299895808;
    public static final int WHEEL_TICK = 299893510;
    public static final int WINDOW_LOCK = 287312836;
    public static final int WINDOW_MOVE = 289409985;
    public static final int WINDOW_POS = 289409984;
    public static final int WINDOW_VENT_MOVE = 289409987;
    public static final int WINDOW_VENT_POS = 289409986;

    public static final String toString(int o) {
        if (o == 0) {
            return "INVALID";
        }
        if (o == 286261504) {
            return "INFO_VIN";
        }
        if (o == 286261505) {
            return "INFO_MAKE";
        }
        if (o == 286261506) {
            return "INFO_MODEL";
        }
        if (o == 289407235) {
            return "INFO_MODEL_YEAR";
        }
        if (o == 291504388) {
            return "INFO_FUEL_CAPACITY";
        }
        if (o == 291504644) {
            return "PERF_ODOMETER";
        }
        if (o == 291504647) {
            return "PERF_VEHICLE_SPEED";
        }
        if (o == 291504897) {
            return "ENGINE_COOLANT_TEMP";
        }
        if (o == 291504900) {
            return "ENGINE_OIL_TEMP";
        }
        if (o == 291504901) {
            return "ENGINE_RPM";
        }
        if (o == 299893510) {
            return "WHEEL_TICK";
        }
        if (o == 289408000) {
            return "GEAR_SELECTION";
        }
        if (o == 289408001) {
            return "CURRENT_GEAR";
        }
        if (o == 287310850) {
            return "PARKING_BRAKE_ON";
        }
        if (o == 289408004) {
            return "DRIVING_STATUS";
        }
        if (o == 287310853) {
            return "FUEL_LEVEL_LOW";
        }
        if (o == 287310855) {
            return "NIGHT_MODE";
        }
        if (o == 289408008) {
            return "TURN_SIGNAL_STATE";
        }
        if (o == 289408009) {
            return "IGNITION_STATE";
        }
        if (o == 287310858) {
            return "ABS_ACTIVE";
        }
        if (o == 287310859) {
            return "TRACTION_CONTROL_ACTIVE";
        }
        if (o == 306185472) {
            return "HVAC_FAN_SPEED";
        }
        if (o == 306185473) {
            return "HVAC_FAN_DIRECTION";
        }
        if (o == 308282626) {
            return "HVAC_TEMPERATURE_CURRENT";
        }
        if (o == 308282627) {
            return "HVAC_TEMPERATURE_SET";
        }
        if (o == 320865540) {
            return "HVAC_DEFROSTER";
        }
        if (o == 304088325) {
            return "HVAC_AC_ON";
        }
        if (o == 304088326) {
            return "HVAC_MAX_AC_ON";
        }
        if (o == 304088327) {
            return "HVAC_MAX_DEFROST_ON";
        }
        if (o == 304088328) {
            return "HVAC_RECIRC_ON";
        }
        if (o == 304088329) {
            return "HVAC_DUAL_ON";
        }
        if (o == 304088330) {
            return "HVAC_AUTO_ON";
        }
        if (o == 356517131) {
            return "HVAC_SEAT_TEMPERATURE";
        }
        if (o == 339739916) {
            return "HVAC_SIDE_MIRROR_HEAT";
        }
        if (o == 289408269) {
            return "HVAC_STEERING_WHEEL_TEMP";
        }
        if (o == 306185486) {
            return "HVAC_TEMPERATURE_UNITS";
        }
        if (o == 306185487) {
            return "HVAC_ACTUAL_FAN_SPEED_RPM";
        }
        if (o == 304088336) {
            return "HVAC_POWER_ON";
        }
        if (o == 306185489) {
            return "HVAC_FAN_DIRECTION_AVAILABLE";
        }
        if (o == 304088338) {
            return "HVAC_AUTO_RECIRC_ON";
        }
        if (o == 291505923) {
            return "ENV_OUTSIDE_TEMPERATURE";
        }
        if (o == 291505924) {
            return "ENV_CABIN_TEMPERATURE";
        }
        if (o == 289474561) {
            return "RADIO_PRESET";
        }
        if (o == 289474816) {
            return "AUDIO_FOCUS";
        }
        if (o == 289474832) {
            return "AUDIO_FOCUS_EXT_SYNC";
        }
        if (o == 289474817) {
            return "AUDIO_VOLUME";
        }
        if (o == 289474833) {
            return "AUDIO_VOLUME_EXT_SYNC";
        }
        if (o == 289474818) {
            return "AUDIO_VOLUME_LIMIT";
        }
        if (o == 289474819) {
            return "AUDIO_ROUTING_POLICY";
        }
        if (o == 289409284) {
            return "AUDIO_HW_VARIANT";
        }
        if (o == 289474821) {
            return "AUDIO_EXT_ROUTING_HINT";
        }
        if (o == 289474822) {
            return "AUDIO_STREAM_STATE";
        }
        if (o == 286263559) {
            return "AUDIO_PARAMETERS";
        }
        if (o == 289475072) {
            return "AP_POWER_STATE";
        }
        if (o == 289409537) {
            return "DISPLAY_BRIGHTNESS";
        }
        if (o == 289409538) {
            return "AP_POWER_BOOTUP_REASON";
        }
        if (o == 289475088) {
            return "HW_KEY_INPUT";
        }
        if (o == 289475104) {
            return "INSTRUMENT_CLUSTER_INFO";
        }
        if (o == 290458160) {
            return "UNIX_TIME";
        }
        if (o == 289409585) {
            return "CURRENT_TIME_IN_SECONDS";
        }
        if (o == 373295872) {
            return "DOOR_POS";
        }
        if (o == 373295873) {
            return "DOOR_MOVE";
        }
        if (o == 371198722) {
            return "DOOR_LOCK";
        }
        if (o == 339741504) {
            return "MIRROR_Z_POS";
        }
        if (o == 339741505) {
            return "MIRROR_Z_MOVE";
        }
        if (o == 339741506) {
            return "MIRROR_Y_POS";
        }
        if (o == 339741507) {
            return "MIRROR_Y_MOVE";
        }
        if (o == 287312708) {
            return "MIRROR_LOCK";
        }
        if (o == 287312709) {
            return "MIRROR_FOLD";
        }
        if (o == 356518784) {
            return "SEAT_MEMORY_SELECT";
        }
        if (o == 356518785) {
            return "SEAT_MEMORY_SET";
        }
        if (o == 354421634) {
            return "SEAT_BELT_BUCKLED";
        }
        if (o == 356518787) {
            return "SEAT_BELT_HEIGHT_POS";
        }
        if (o == 356518788) {
            return "SEAT_BELT_HEIGHT_MOVE";
        }
        if (o == 356518789) {
            return "SEAT_FORE_AFT_POS";
        }
        if (o == 356518790) {
            return "SEAT_FORE_AFT_MOVE";
        }
        if (o == 356518791) {
            return "SEAT_BACKREST_ANGLE_1_POS";
        }
        if (o == 356518792) {
            return "SEAT_BACKREST_ANGLE_1_MOVE";
        }
        if (o == 356518793) {
            return "SEAT_BACKREST_ANGLE_2_POS";
        }
        if (o == 356518794) {
            return "SEAT_BACKREST_ANGLE_2_MOVE";
        }
        if (o == 356518795) {
            return "SEAT_HEIGHT_POS";
        }
        if (o == 356518796) {
            return "SEAT_HEIGHT_MOVE";
        }
        if (o == 356518797) {
            return "SEAT_DEPTH_POS";
        }
        if (o == 356518798) {
            return "SEAT_DEPTH_MOVE";
        }
        if (o == 356518799) {
            return "SEAT_TILT_POS";
        }
        if (o == 356518800) {
            return "SEAT_TILT_MOVE";
        }
        if (o == 356518801) {
            return "SEAT_LUMBAR_FORE_AFT_POS";
        }
        if (o == 356518802) {
            return "SEAT_LUMBAR_FORE_AFT_MOVE";
        }
        if (o == 356518803) {
            return "SEAT_LUMBAR_SIDE_SUPPORT_POS";
        }
        if (o == 356518804) {
            return "SEAT_LUMBAR_SIDE_SUPPORT_MOVE";
        }
        if (o == 289409941) {
            return "SEAT_HEADREST_HEIGHT_POS";
        }
        if (o == 356518806) {
            return "SEAT_HEADREST_HEIGHT_MOVE";
        }
        if (o == 356518807) {
            return "SEAT_HEADREST_ANGLE_POS";
        }
        if (o == 356518808) {
            return "SEAT_HEADREST_ANGLE_MOVE";
        }
        if (o == 356518809) {
            return "SEAT_HEADREST_FORE_AFT_POS";
        }
        if (o == 356518810) {
            return "SEAT_HEADREST_FORE_AFT_MOVE";
        }
        if (o == 289409984) {
            return "WINDOW_POS";
        }
        if (o == 289409985) {
            return "WINDOW_MOVE";
        }
        if (o == 289409986) {
            return "WINDOW_VENT_POS";
        }
        if (o == 289409987) {
            return "WINDOW_VENT_MOVE";
        }
        if (o == 287312836) {
            return "WINDOW_LOCK";
        }
        if (o == 299895808) {
            return "VEHICLE_MAP_SERVICE";
        }
        if (o == 299896064) {
            return "OBD2_LIVE_FRAME";
        }
        if (o == 299896065) {
            return "OBD2_FREEZE_FRAME";
        }
        if (o == 299896066) {
            return "OBD2_FREEZE_FRAME_INFO";
        }
        if (o == 299896067) {
            return "OBD2_FREEZE_FRAME_CLEAR";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("INVALID");
        if ((o & INFO_VIN) == 286261504) {
            list.add("INFO_VIN");
            flipped = 0 | INFO_VIN;
        }
        if ((o & INFO_MAKE) == 286261505) {
            list.add("INFO_MAKE");
            flipped |= INFO_MAKE;
        }
        if ((o & INFO_MODEL) == 286261506) {
            list.add("INFO_MODEL");
            flipped |= INFO_MODEL;
        }
        if ((289407235 & o) == 289407235) {
            list.add("INFO_MODEL_YEAR");
            flipped |= INFO_MODEL_YEAR;
        }
        if ((291504388 & o) == 291504388) {
            list.add("INFO_FUEL_CAPACITY");
            flipped |= INFO_FUEL_CAPACITY;
        }
        if ((291504644 & o) == 291504644) {
            list.add("PERF_ODOMETER");
            flipped |= PERF_ODOMETER;
        }
        if ((291504647 & o) == 291504647) {
            list.add("PERF_VEHICLE_SPEED");
            flipped |= PERF_VEHICLE_SPEED;
        }
        if ((291504897 & o) == 291504897) {
            list.add("ENGINE_COOLANT_TEMP");
            flipped |= ENGINE_COOLANT_TEMP;
        }
        if ((291504900 & o) == 291504900) {
            list.add("ENGINE_OIL_TEMP");
            flipped |= ENGINE_OIL_TEMP;
        }
        if ((291504901 & o) == 291504901) {
            list.add("ENGINE_RPM");
            flipped |= ENGINE_RPM;
        }
        if ((299893510 & o) == 299893510) {
            list.add("WHEEL_TICK");
            flipped |= WHEEL_TICK;
        }
        if ((289408000 & o) == 289408000) {
            list.add("GEAR_SELECTION");
            flipped |= GEAR_SELECTION;
        }
        if ((289408001 & o) == 289408001) {
            list.add("CURRENT_GEAR");
            flipped |= CURRENT_GEAR;
        }
        if ((o & PARKING_BRAKE_ON) == 287310850) {
            list.add("PARKING_BRAKE_ON");
            flipped |= PARKING_BRAKE_ON;
        }
        if ((289408004 & o) == 289408004) {
            list.add("DRIVING_STATUS");
            flipped |= DRIVING_STATUS;
        }
        if ((287310853 & o) == 287310853) {
            list.add("FUEL_LEVEL_LOW");
            flipped |= FUEL_LEVEL_LOW;
        }
        if ((287310855 & o) == 287310855) {
            list.add("NIGHT_MODE");
            flipped |= NIGHT_MODE;
        }
        if ((289408008 & o) == 289408008) {
            list.add("TURN_SIGNAL_STATE");
            flipped |= TURN_SIGNAL_STATE;
        }
        if ((289408009 & o) == 289408009) {
            list.add("IGNITION_STATE");
            flipped |= IGNITION_STATE;
        }
        if ((287310858 & o) == 287310858) {
            list.add("ABS_ACTIVE");
            flipped |= ABS_ACTIVE;
        }
        if ((287310859 & o) == 287310859) {
            list.add("TRACTION_CONTROL_ACTIVE");
            flipped |= TRACTION_CONTROL_ACTIVE;
        }
        if ((306185472 & o) == 306185472) {
            list.add("HVAC_FAN_SPEED");
            flipped |= HVAC_FAN_SPEED;
        }
        if ((306185473 & o) == 306185473) {
            list.add("HVAC_FAN_DIRECTION");
            flipped |= HVAC_FAN_DIRECTION;
        }
        if ((308282626 & o) == 308282626) {
            list.add("HVAC_TEMPERATURE_CURRENT");
            flipped |= HVAC_TEMPERATURE_CURRENT;
        }
        if ((308282627 & o) == 308282627) {
            list.add("HVAC_TEMPERATURE_SET");
            flipped |= HVAC_TEMPERATURE_SET;
        }
        if ((320865540 & o) == 320865540) {
            list.add("HVAC_DEFROSTER");
            flipped |= HVAC_DEFROSTER;
        }
        if ((304088325 & o) == 304088325) {
            list.add("HVAC_AC_ON");
            flipped |= HVAC_AC_ON;
        }
        if ((304088326 & o) == 304088326) {
            list.add("HVAC_MAX_AC_ON");
            flipped |= HVAC_MAX_AC_ON;
        }
        if ((304088327 & o) == 304088327) {
            list.add("HVAC_MAX_DEFROST_ON");
            flipped |= HVAC_MAX_DEFROST_ON;
        }
        if ((304088328 & o) == 304088328) {
            list.add("HVAC_RECIRC_ON");
            flipped |= HVAC_RECIRC_ON;
        }
        if ((304088329 & o) == 304088329) {
            list.add("HVAC_DUAL_ON");
            flipped |= HVAC_DUAL_ON;
        }
        if ((304088330 & o) == 304088330) {
            list.add("HVAC_AUTO_ON");
            flipped |= HVAC_AUTO_ON;
        }
        if ((356517131 & o) == 356517131) {
            list.add("HVAC_SEAT_TEMPERATURE");
            flipped |= HVAC_SEAT_TEMPERATURE;
        }
        if ((339739916 & o) == 339739916) {
            list.add("HVAC_SIDE_MIRROR_HEAT");
            flipped |= HVAC_SIDE_MIRROR_HEAT;
        }
        if ((289408269 & o) == 289408269) {
            list.add("HVAC_STEERING_WHEEL_TEMP");
            flipped |= HVAC_STEERING_WHEEL_TEMP;
        }
        if ((306185486 & o) == 306185486) {
            list.add("HVAC_TEMPERATURE_UNITS");
            flipped |= HVAC_TEMPERATURE_UNITS;
        }
        if ((306185487 & o) == 306185487) {
            list.add("HVAC_ACTUAL_FAN_SPEED_RPM");
            flipped |= HVAC_ACTUAL_FAN_SPEED_RPM;
        }
        if ((304088336 & o) == 304088336) {
            list.add("HVAC_POWER_ON");
            flipped |= HVAC_POWER_ON;
        }
        if ((306185489 & o) == 306185489) {
            list.add("HVAC_FAN_DIRECTION_AVAILABLE");
            flipped |= HVAC_FAN_DIRECTION_AVAILABLE;
        }
        if ((304088338 & o) == 304088338) {
            list.add("HVAC_AUTO_RECIRC_ON");
            flipped |= HVAC_AUTO_RECIRC_ON;
        }
        if ((291505923 & o) == 291505923) {
            list.add("ENV_OUTSIDE_TEMPERATURE");
            flipped |= ENV_OUTSIDE_TEMPERATURE;
        }
        if ((291505924 & o) == 291505924) {
            list.add("ENV_CABIN_TEMPERATURE");
            flipped |= ENV_CABIN_TEMPERATURE;
        }
        if ((289474561 & o) == 289474561) {
            list.add("RADIO_PRESET");
            flipped |= RADIO_PRESET;
        }
        if ((289474816 & o) == 289474816) {
            list.add("AUDIO_FOCUS");
            flipped |= AUDIO_FOCUS;
        }
        if ((289474832 & o) == 289474832) {
            list.add("AUDIO_FOCUS_EXT_SYNC");
            flipped |= AUDIO_FOCUS_EXT_SYNC;
        }
        if ((289474817 & o) == 289474817) {
            list.add("AUDIO_VOLUME");
            flipped |= AUDIO_VOLUME;
        }
        if ((289474833 & o) == 289474833) {
            list.add("AUDIO_VOLUME_EXT_SYNC");
            flipped |= AUDIO_VOLUME_EXT_SYNC;
        }
        if ((289474818 & o) == 289474818) {
            list.add("AUDIO_VOLUME_LIMIT");
            flipped |= AUDIO_VOLUME_LIMIT;
        }
        if ((289474819 & o) == 289474819) {
            list.add("AUDIO_ROUTING_POLICY");
            flipped |= AUDIO_ROUTING_POLICY;
        }
        if ((289409284 & o) == 289409284) {
            list.add("AUDIO_HW_VARIANT");
            flipped |= AUDIO_HW_VARIANT;
        }
        if ((289474821 & o) == 289474821) {
            list.add("AUDIO_EXT_ROUTING_HINT");
            flipped |= AUDIO_EXT_ROUTING_HINT;
        }
        if ((289474822 & o) == 289474822) {
            list.add("AUDIO_STREAM_STATE");
            flipped |= AUDIO_STREAM_STATE;
        }
        if ((o & AUDIO_PARAMETERS) == 286263559) {
            list.add("AUDIO_PARAMETERS");
            flipped |= AUDIO_PARAMETERS;
        }
        if ((289475072 & o) == 289475072) {
            list.add("AP_POWER_STATE");
            flipped |= AP_POWER_STATE;
        }
        if ((289409537 & o) == 289409537) {
            list.add("DISPLAY_BRIGHTNESS");
            flipped |= DISPLAY_BRIGHTNESS;
        }
        if ((289409538 & o) == 289409538) {
            list.add("AP_POWER_BOOTUP_REASON");
            flipped |= AP_POWER_BOOTUP_REASON;
        }
        if ((289475088 & o) == 289475088) {
            list.add("HW_KEY_INPUT");
            flipped |= HW_KEY_INPUT;
        }
        if ((289475104 & o) == 289475104) {
            list.add("INSTRUMENT_CLUSTER_INFO");
            flipped |= INSTRUMENT_CLUSTER_INFO;
        }
        if ((290458160 & o) == 290458160) {
            list.add("UNIX_TIME");
            flipped |= UNIX_TIME;
        }
        if ((289409585 & o) == 289409585) {
            list.add("CURRENT_TIME_IN_SECONDS");
            flipped |= CURRENT_TIME_IN_SECONDS;
        }
        if ((373295872 & o) == 373295872) {
            list.add("DOOR_POS");
            flipped |= DOOR_POS;
        }
        if ((373295873 & o) == 373295873) {
            list.add("DOOR_MOVE");
            flipped |= DOOR_MOVE;
        }
        if ((371198722 & o) == 371198722) {
            list.add("DOOR_LOCK");
            flipped |= DOOR_LOCK;
        }
        if ((339741504 & o) == 339741504) {
            list.add("MIRROR_Z_POS");
            flipped |= MIRROR_Z_POS;
        }
        if ((339741505 & o) == 339741505) {
            list.add("MIRROR_Z_MOVE");
            flipped |= MIRROR_Z_MOVE;
        }
        if ((339741506 & o) == 339741506) {
            list.add("MIRROR_Y_POS");
            flipped |= MIRROR_Y_POS;
        }
        if ((339741507 & o) == 339741507) {
            list.add("MIRROR_Y_MOVE");
            flipped |= MIRROR_Y_MOVE;
        }
        if ((287312708 & o) == 287312708) {
            list.add("MIRROR_LOCK");
            flipped |= MIRROR_LOCK;
        }
        if ((287312709 & o) == 287312709) {
            list.add("MIRROR_FOLD");
            flipped |= MIRROR_FOLD;
        }
        if ((356518784 & o) == 356518784) {
            list.add("SEAT_MEMORY_SELECT");
            flipped |= SEAT_MEMORY_SELECT;
        }
        if ((356518785 & o) == 356518785) {
            list.add("SEAT_MEMORY_SET");
            flipped |= SEAT_MEMORY_SET;
        }
        if ((354421634 & o) == 354421634) {
            list.add("SEAT_BELT_BUCKLED");
            flipped |= SEAT_BELT_BUCKLED;
        }
        if ((356518787 & o) == 356518787) {
            list.add("SEAT_BELT_HEIGHT_POS");
            flipped |= SEAT_BELT_HEIGHT_POS;
        }
        if ((356518788 & o) == 356518788) {
            list.add("SEAT_BELT_HEIGHT_MOVE");
            flipped |= SEAT_BELT_HEIGHT_MOVE;
        }
        if ((356518789 & o) == 356518789) {
            list.add("SEAT_FORE_AFT_POS");
            flipped |= SEAT_FORE_AFT_POS;
        }
        if ((356518790 & o) == 356518790) {
            list.add("SEAT_FORE_AFT_MOVE");
            flipped |= SEAT_FORE_AFT_MOVE;
        }
        if ((356518791 & o) == 356518791) {
            list.add("SEAT_BACKREST_ANGLE_1_POS");
            flipped |= SEAT_BACKREST_ANGLE_1_POS;
        }
        if ((356518792 & o) == 356518792) {
            list.add("SEAT_BACKREST_ANGLE_1_MOVE");
            flipped |= SEAT_BACKREST_ANGLE_1_MOVE;
        }
        if ((356518793 & o) == 356518793) {
            list.add("SEAT_BACKREST_ANGLE_2_POS");
            flipped |= SEAT_BACKREST_ANGLE_2_POS;
        }
        if ((356518794 & o) == 356518794) {
            list.add("SEAT_BACKREST_ANGLE_2_MOVE");
            flipped |= SEAT_BACKREST_ANGLE_2_MOVE;
        }
        if ((356518795 & o) == 356518795) {
            list.add("SEAT_HEIGHT_POS");
            flipped |= SEAT_HEIGHT_POS;
        }
        if ((356518796 & o) == 356518796) {
            list.add("SEAT_HEIGHT_MOVE");
            flipped |= SEAT_HEIGHT_MOVE;
        }
        if ((356518797 & o) == 356518797) {
            list.add("SEAT_DEPTH_POS");
            flipped |= SEAT_DEPTH_POS;
        }
        if ((356518798 & o) == 356518798) {
            list.add("SEAT_DEPTH_MOVE");
            flipped |= SEAT_DEPTH_MOVE;
        }
        if ((356518799 & o) == 356518799) {
            list.add("SEAT_TILT_POS");
            flipped |= SEAT_TILT_POS;
        }
        if ((356518800 & o) == 356518800) {
            list.add("SEAT_TILT_MOVE");
            flipped |= SEAT_TILT_MOVE;
        }
        if ((356518801 & o) == 356518801) {
            list.add("SEAT_LUMBAR_FORE_AFT_POS");
            flipped |= SEAT_LUMBAR_FORE_AFT_POS;
        }
        if ((356518802 & o) == 356518802) {
            list.add("SEAT_LUMBAR_FORE_AFT_MOVE");
            flipped |= SEAT_LUMBAR_FORE_AFT_MOVE;
        }
        if ((356518803 & o) == 356518803) {
            list.add("SEAT_LUMBAR_SIDE_SUPPORT_POS");
            flipped |= SEAT_LUMBAR_SIDE_SUPPORT_POS;
        }
        if ((356518804 & o) == 356518804) {
            list.add("SEAT_LUMBAR_SIDE_SUPPORT_MOVE");
            flipped |= SEAT_LUMBAR_SIDE_SUPPORT_MOVE;
        }
        if ((289409941 & o) == 289409941) {
            list.add("SEAT_HEADREST_HEIGHT_POS");
            flipped |= SEAT_HEADREST_HEIGHT_POS;
        }
        if ((356518806 & o) == 356518806) {
            list.add("SEAT_HEADREST_HEIGHT_MOVE");
            flipped |= SEAT_HEADREST_HEIGHT_MOVE;
        }
        if ((356518807 & o) == 356518807) {
            list.add("SEAT_HEADREST_ANGLE_POS");
            flipped |= SEAT_HEADREST_ANGLE_POS;
        }
        if ((356518808 & o) == 356518808) {
            list.add("SEAT_HEADREST_ANGLE_MOVE");
            flipped |= SEAT_HEADREST_ANGLE_MOVE;
        }
        if ((356518809 & o) == 356518809) {
            list.add("SEAT_HEADREST_FORE_AFT_POS");
            flipped |= SEAT_HEADREST_FORE_AFT_POS;
        }
        if ((356518810 & o) == 356518810) {
            list.add("SEAT_HEADREST_FORE_AFT_MOVE");
            flipped |= SEAT_HEADREST_FORE_AFT_MOVE;
        }
        if ((289409984 & o) == 289409984) {
            list.add("WINDOW_POS");
            flipped |= WINDOW_POS;
        }
        if ((289409985 & o) == 289409985) {
            list.add("WINDOW_MOVE");
            flipped |= WINDOW_MOVE;
        }
        if ((289409986 & o) == 289409986) {
            list.add("WINDOW_VENT_POS");
            flipped |= WINDOW_VENT_POS;
        }
        if ((289409987 & o) == 289409987) {
            list.add("WINDOW_VENT_MOVE");
            flipped |= WINDOW_VENT_MOVE;
        }
        if ((287312836 & o) == 287312836) {
            list.add("WINDOW_LOCK");
            flipped |= WINDOW_LOCK;
        }
        if ((299895808 & o) == 299895808) {
            list.add("VEHICLE_MAP_SERVICE");
            flipped |= VEHICLE_MAP_SERVICE;
        }
        if ((299896064 & o) == 299896064) {
            list.add("OBD2_LIVE_FRAME");
            flipped |= OBD2_LIVE_FRAME;
        }
        if ((299896065 & o) == 299896065) {
            list.add("OBD2_FREEZE_FRAME");
            flipped |= OBD2_FREEZE_FRAME;
        }
        if ((299896066 & o) == 299896066) {
            list.add("OBD2_FREEZE_FRAME_INFO");
            flipped |= OBD2_FREEZE_FRAME_INFO;
        }
        if ((299896067 & o) == 299896067) {
            list.add("OBD2_FREEZE_FRAME_CLEAR");
            flipped |= OBD2_FREEZE_FRAME_CLEAR;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}