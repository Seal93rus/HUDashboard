package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class EM_DIAG_DATA_ID {
    public static final int EM_DIAG_DATA_ID_CAN_GATEWAY_ = 41472;
    public static final int EM_DIAG_DATA_ID_CAN_GATEWAY_OTA = 41473;
    public static final int EM_DIAG_DATA_ID_CAN_GATEWAY_OTA_CLUSTER = 41474;
    public static final int EM_DIAG_DATA_ID_CAN_PKI_FIRST_REQUEST_UIN_FROM_IOC = 41475;
    public static final int EM_DIAG_DATA_ID_CAN_PKI_FOURTH_GET_COMPARE_RESULT_FROM_IOC = 41478;
    public static final int EM_DIAG_DATA_ID_CAN_PKI_SECOND_GET_UIN_BYTES_FROM_IOC = 41476;
    public static final int EM_DIAG_DATA_ID_CAN_PKI_SEND_ROOT_CA_STATUS_TO_HMI = 41479;
    public static final int EM_DIAG_DATA_ID_CAN_PKI_THIRD_CONFIRM_AND_SEND_UIN_BYTES_TO_IOC = 41477;
    public static final int EM_DIAG_DATA_ID_DTC_ = 0;
    public static final int EM_DIAG_DATA_ID_DTC_CAMERA_CTRL_MOD_INIT_FAIL = 24;
    public static final int EM_DIAG_DATA_ID_DTC_CRC_ERR = 26;
    public static final int EM_DIAG_DATA_ID_DTC_END = 29;
    public static final int EM_DIAG_DATA_ID_DTC_FMAM_ANT_OPEN = 21;
    public static final int EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_BAT = 20;
    public static final int EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_GND = 19;
    public static final int EM_DIAG_DATA_ID_DTC_GPS_ANTE_OPEN = 10;
    public static final int EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_BAT = 9;
    public static final int EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_GND = 8;
    public static final int EM_DIAG_DATA_ID_DTC_INSU_SQI = 25;
    public static final int EM_DIAG_DATA_ID_DTC_IPC_INIT_FAIL = 2;
    public static final int EM_DIAG_DATA_ID_DTC_LOST_COMM_HL_DIS_FRT = 4;
    public static final int EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM = 1;
    public static final int EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM_TBOX = 22;
    public static final int EM_DIAG_DATA_ID_DTC_LOST_TCP_COMMUNICATION = 28;
    public static final int EM_DIAG_DATA_ID_DTC_MISS_CAMERA_MOD = 3;
    public static final int EM_DIAG_DATA_ID_DTC_MISS_FRT_CAMERA = 15;
    public static final int EM_DIAG_DATA_ID_DTC_MISS_LFT_CAMERA = 17;
    public static final int EM_DIAG_DATA_ID_DTC_MISS_REAR_CAMERA = 16;
    public static final int EM_DIAG_DATA_ID_DTC_MISS_RGT_CAMERA = 18;
    public static final int EM_DIAG_DATA_ID_DTC_POWER_FAIL = 23;
    public static final int EM_DIAG_DATA_ID_DTC_TBOX_LOST_COMM_SATE = 7;
    public static final int EM_DIAG_DATA_ID_DTC_UNEXC_LINK_LOSS = 27;
    public static final int EM_DIAG_DATA_ID_DTC_USB_1_DLINE_SHORT_VBUS_BAT = 12;
    public static final int EM_DIAG_DATA_ID_DTC_USB_1_VBUS_SHORT_GND_BAT = 11;
    public static final int EM_DIAG_DATA_ID_DTC_USB_2_DLINE_SHORT_VBUS_BAT = 14;
    public static final int EM_DIAG_DATA_ID_DTC_USB_2_VBUS_SHORT_GND_BAT = 13;
    public static final int EM_DIAG_DATA_ID_DTC_USB_INIT_FAIL = 6;
    public static final int EM_DIAG_DATA_ID_DTC_WIFI_MOD_INIT_FAIL = 5;
    public static final int EM_DIAG_DATA_ID_END = 41480;
    public static final int EM_DIAG_DATA_ID_RDBI_ = 4096;
    public static final int EM_DIAG_DATA_ID_RDBI_AM_SIGNAL_STRENGTH = 4114;
    public static final int EM_DIAG_DATA_ID_RDBI_BT_ACTVIE_PROF_LIST = 4110;
    public static final int EM_DIAG_DATA_ID_RDBI_BT_CURR_DISC_MODE = 4107;
    public static final int EM_DIAG_DATA_ID_RDBI_BT_FW_VERSION = 4111;
    public static final int EM_DIAG_DATA_ID_RDBI_BT_POWER_CLS = 4109;
    public static final int EM_DIAG_DATA_ID_RDBI_BT_STATUS = 4108;
    public static final int EM_DIAG_DATA_ID_RDBI_CURR_CONN_USB_TYPE = 4113;
    public static final int EM_DIAG_DATA_ID_RDBI_END = 4123;
    public static final int EM_DIAG_DATA_ID_RDBI_FM_SIGNAL_STRENGTH = 4115;
    public static final int EM_DIAG_DATA_ID_RDBI_GET_LINK_STATUS_DETE = 4098;
    public static final int EM_DIAG_DATA_ID_RDBI_MAC_ADDR = 4105;
    public static final int EM_DIAG_DATA_ID_RDBI_NUM_OF_USB = 4112;
    public static final int EM_DIAG_DATA_ID_RDBI_PHY_INDENT_NUM = 4097;
    public static final int EM_DIAG_DATA_ID_RDBI_PRES_GPS_COOR = 4106;
    public static final int EM_DIAG_DATA_ID_RDBI_RECV_PACKET = 4103;
    public static final int EM_DIAG_DATA_ID_RDBI_SQI = 4101;
    public static final int EM_DIAG_DATA_ID_RDBI_SQI_THRE_1000_T1 = 4100;
    public static final int EM_DIAG_DATA_ID_RDBI_SQI_THRE_100_T1 = 4099;
    public static final int EM_DIAG_DATA_ID_RDBI_SWTCH_CNTER = 4104;
    public static final int EM_DIAG_DATA_ID_RDBI_TBOX_GEO_COOR_CONN_LOST = 4121;
    public static final int EM_DIAG_DATA_ID_RDBI_TBOX_GW_SUB_MASK = 4119;
    public static final int EM_DIAG_DATA_ID_RDBI_TBOX_LAST_COMM_LOST_TMSP = 4120;
    public static final int EM_DIAG_DATA_ID_RDBI_TBOX_MOD_STATUS = 4122;
    public static final int EM_DIAG_DATA_ID_RDBI_TRANS_PACKET = 4102;
    public static final int EM_DIAG_DATA_ID_RDBI_WIFI_MOD_FW_VERSION = 4117;
    public static final int EM_DIAG_DATA_ID_RDBI_WIFI_MOD_HW_PART_NUM = 4118;
    public static final int EM_DIAG_DATA_ID_RDBI_WIFI_MOD_STATUS = 4116;
    public static final int EM_DIAG_DATA_ID_RTCTRL_ = 12288;
    public static final int EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT0 = 12293;
    public static final int EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT1 = 12294;
    public static final int EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT2 = 12295;
    public static final int EM_DIAG_DATA_ID_RTCTRL_END = 12297;
    public static final int EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT0 = 12290;
    public static final int EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT1 = 12291;
    public static final int EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT2 = 12292;
    public static final int EM_DIAG_DATA_ID_RTCTRL_RESET_PHY = 12289;
    public static final int EM_DIAG_DATA_ID_RTCTRL_RESET_SWTCH_STATI = 12296;
    public static final int EM_DIAG_DATA_ID_STATUS_ = 40960;
    public static final int EM_DIAG_DATA_ID_STATUS_GNSS_ANT = 40961;
    public static final int EM_DIAG_DATA_ID_STATUS_GNSS_SAT_NUM = 40962;
    public static final int EM_DIAG_DATA_ID_STATUS_PKI_WIFI = 40963;
    public static final int EM_DIAG_DATA_ID_VERSION_ = 41216;
    public static final int EM_DIAG_DATA_ID_VERSION_GNSS_FW = 41217;
    public static final int EM_DIAG_DATA_ID_WDBI_ = 8192;
    public static final int EM_DIAG_DATA_ID_WDBI_END = 8198;
    public static final int EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT0 = 8193;
    public static final int EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT1 = 8194;
    public static final int EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT2 = 8195;
    public static final int EM_DIAG_DATA_ID_WDBI_SQI_1000_T1 = 8197;
    public static final int EM_DIAG_DATA_ID_WDBI_SQI_100_T1 = 8196;

    public static final String toString(int o) {
        if (o == 0) {
            return "EM_DIAG_DATA_ID_DTC_";
        }
        if (o == 1) {
            return "EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM";
        }
        if (o == 2) {
            return "EM_DIAG_DATA_ID_DTC_IPC_INIT_FAIL";
        }
        if (o == 3) {
            return "EM_DIAG_DATA_ID_DTC_MISS_CAMERA_MOD";
        }
        if (o == 4) {
            return "EM_DIAG_DATA_ID_DTC_LOST_COMM_HL_DIS_FRT";
        }
        if (o == 5) {
            return "EM_DIAG_DATA_ID_DTC_WIFI_MOD_INIT_FAIL";
        }
        if (o == 6) {
            return "EM_DIAG_DATA_ID_DTC_USB_INIT_FAIL";
        }
        if (o == 7) {
            return "EM_DIAG_DATA_ID_DTC_TBOX_LOST_COMM_SATE";
        }
        if (o == 8) {
            return "EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_GND";
        }
        if (o == 9) {
            return "EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_BAT";
        }
        if (o == 10) {
            return "EM_DIAG_DATA_ID_DTC_GPS_ANTE_OPEN";
        }
        if (o == 11) {
            return "EM_DIAG_DATA_ID_DTC_USB_1_VBUS_SHORT_GND_BAT";
        }
        if (o == 12) {
            return "EM_DIAG_DATA_ID_DTC_USB_1_DLINE_SHORT_VBUS_BAT";
        }
        if (o == 13) {
            return "EM_DIAG_DATA_ID_DTC_USB_2_VBUS_SHORT_GND_BAT";
        }
        if (o == 14) {
            return "EM_DIAG_DATA_ID_DTC_USB_2_DLINE_SHORT_VBUS_BAT";
        }
        if (o == 15) {
            return "EM_DIAG_DATA_ID_DTC_MISS_FRT_CAMERA";
        }
        if (o == 16) {
            return "EM_DIAG_DATA_ID_DTC_MISS_REAR_CAMERA";
        }
        if (o == 17) {
            return "EM_DIAG_DATA_ID_DTC_MISS_LFT_CAMERA";
        }
        if (o == 18) {
            return "EM_DIAG_DATA_ID_DTC_MISS_RGT_CAMERA";
        }
        if (o == 19) {
            return "EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_GND";
        }
        if (o == 20) {
            return "EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_BAT";
        }
        if (o == 21) {
            return "EM_DIAG_DATA_ID_DTC_FMAM_ANT_OPEN";
        }
        if (o == 22) {
            return "EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM_TBOX";
        }
        if (o == 23) {
            return "EM_DIAG_DATA_ID_DTC_POWER_FAIL";
        }
        if (o == 24) {
            return "EM_DIAG_DATA_ID_DTC_CAMERA_CTRL_MOD_INIT_FAIL";
        }
        if (o == 25) {
            return "EM_DIAG_DATA_ID_DTC_INSU_SQI";
        }
        if (o == 26) {
            return "EM_DIAG_DATA_ID_DTC_CRC_ERR";
        }
        if (o == 27) {
            return "EM_DIAG_DATA_ID_DTC_UNEXC_LINK_LOSS";
        }
        if (o == 28) {
            return "EM_DIAG_DATA_ID_DTC_LOST_TCP_COMMUNICATION";
        }
        if (o == 29) {
            return "EM_DIAG_DATA_ID_DTC_END";
        }
        if (o == 4096) {
            return "EM_DIAG_DATA_ID_RDBI_";
        }
        if (o == 4097) {
            return "EM_DIAG_DATA_ID_RDBI_PHY_INDENT_NUM";
        }
        if (o == 4098) {
            return "EM_DIAG_DATA_ID_RDBI_GET_LINK_STATUS_DETE";
        }
        if (o == 4099) {
            return "EM_DIAG_DATA_ID_RDBI_SQI_THRE_100_T1";
        }
        if (o == 4100) {
            return "EM_DIAG_DATA_ID_RDBI_SQI_THRE_1000_T1";
        }
        if (o == 4101) {
            return "EM_DIAG_DATA_ID_RDBI_SQI";
        }
        if (o == 4102) {
            return "EM_DIAG_DATA_ID_RDBI_TRANS_PACKET";
        }
        if (o == 4103) {
            return "EM_DIAG_DATA_ID_RDBI_RECV_PACKET";
        }
        if (o == 4104) {
            return "EM_DIAG_DATA_ID_RDBI_SWTCH_CNTER";
        }
        if (o == 4105) {
            return "EM_DIAG_DATA_ID_RDBI_MAC_ADDR";
        }
        if (o == 4106) {
            return "EM_DIAG_DATA_ID_RDBI_PRES_GPS_COOR";
        }
        if (o == 4107) {
            return "EM_DIAG_DATA_ID_RDBI_BT_CURR_DISC_MODE";
        }
        if (o == 4108) {
            return "EM_DIAG_DATA_ID_RDBI_BT_STATUS";
        }
        if (o == 4109) {
            return "EM_DIAG_DATA_ID_RDBI_BT_POWER_CLS";
        }
        if (o == 4110) {
            return "EM_DIAG_DATA_ID_RDBI_BT_ACTVIE_PROF_LIST";
        }
        if (o == 4111) {
            return "EM_DIAG_DATA_ID_RDBI_BT_FW_VERSION";
        }
        if (o == 4112) {
            return "EM_DIAG_DATA_ID_RDBI_NUM_OF_USB";
        }
        if (o == 4113) {
            return "EM_DIAG_DATA_ID_RDBI_CURR_CONN_USB_TYPE";
        }
        if (o == 4114) {
            return "EM_DIAG_DATA_ID_RDBI_AM_SIGNAL_STRENGTH";
        }
        if (o == 4115) {
            return "EM_DIAG_DATA_ID_RDBI_FM_SIGNAL_STRENGTH";
        }
        if (o == 4116) {
            return "EM_DIAG_DATA_ID_RDBI_WIFI_MOD_STATUS";
        }
        if (o == 4117) {
            return "EM_DIAG_DATA_ID_RDBI_WIFI_MOD_FW_VERSION";
        }
        if (o == 4118) {
            return "EM_DIAG_DATA_ID_RDBI_WIFI_MOD_HW_PART_NUM";
        }
        if (o == 4119) {
            return "EM_DIAG_DATA_ID_RDBI_TBOX_GW_SUB_MASK";
        }
        if (o == 4120) {
            return "EM_DIAG_DATA_ID_RDBI_TBOX_LAST_COMM_LOST_TMSP";
        }
        if (o == 4121) {
            return "EM_DIAG_DATA_ID_RDBI_TBOX_GEO_COOR_CONN_LOST";
        }
        if (o == 4122) {
            return "EM_DIAG_DATA_ID_RDBI_TBOX_MOD_STATUS";
        }
        if (o == 4123) {
            return "EM_DIAG_DATA_ID_RDBI_END";
        }
        if (o == 8192) {
            return "EM_DIAG_DATA_ID_WDBI_";
        }
        if (o == 8193) {
            return "EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT0";
        }
        if (o == 8194) {
            return "EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT1";
        }
        if (o == 8195) {
            return "EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT2";
        }
        if (o == 8196) {
            return "EM_DIAG_DATA_ID_WDBI_SQI_100_T1";
        }
        if (o == 8197) {
            return "EM_DIAG_DATA_ID_WDBI_SQI_1000_T1";
        }
        if (o == 8198) {
            return "EM_DIAG_DATA_ID_WDBI_END";
        }
        if (o == 12288) {
            return "EM_DIAG_DATA_ID_RTCTRL_";
        }
        if (o == 12289) {
            return "EM_DIAG_DATA_ID_RTCTRL_RESET_PHY";
        }
        if (o == 12290) {
            return "EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT0";
        }
        if (o == 12291) {
            return "EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT1";
        }
        if (o == 12292) {
            return "EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT2";
        }
        if (o == 12293) {
            return "EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT0";
        }
        if (o == 12294) {
            return "EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT1";
        }
        if (o == 12295) {
            return "EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT2";
        }
        if (o == 12296) {
            return "EM_DIAG_DATA_ID_RTCTRL_RESET_SWTCH_STATI";
        }
        if (o == 12297) {
            return "EM_DIAG_DATA_ID_RTCTRL_END";
        }
        if (o == 40960) {
            return "EM_DIAG_DATA_ID_STATUS_";
        }
        if (o == 40961) {
            return "EM_DIAG_DATA_ID_STATUS_GNSS_ANT";
        }
        if (o == 40962) {
            return "EM_DIAG_DATA_ID_STATUS_GNSS_SAT_NUM";
        }
        if (o == 40963) {
            return "EM_DIAG_DATA_ID_STATUS_PKI_WIFI";
        }
        if (o == 41216) {
            return "EM_DIAG_DATA_ID_VERSION_";
        }
        if (o == 41217) {
            return "EM_DIAG_DATA_ID_VERSION_GNSS_FW";
        }
        if (o == 41472) {
            return "EM_DIAG_DATA_ID_CAN_GATEWAY_";
        }
        if (o == 41473) {
            return "EM_DIAG_DATA_ID_CAN_GATEWAY_OTA";
        }
        if (o == 41474) {
            return "EM_DIAG_DATA_ID_CAN_GATEWAY_OTA_CLUSTER";
        }
        if (o == 41475) {
            return "EM_DIAG_DATA_ID_CAN_PKI_FIRST_REQUEST_UIN_FROM_IOC";
        }
        if (o == 41476) {
            return "EM_DIAG_DATA_ID_CAN_PKI_SECOND_GET_UIN_BYTES_FROM_IOC";
        }
        if (o == 41477) {
            return "EM_DIAG_DATA_ID_CAN_PKI_THIRD_CONFIRM_AND_SEND_UIN_BYTES_TO_IOC";
        }
        if (o == 41478) {
            return "EM_DIAG_DATA_ID_CAN_PKI_FOURTH_GET_COMPARE_RESULT_FROM_IOC";
        }
        if (o == 41479) {
            return "EM_DIAG_DATA_ID_CAN_PKI_SEND_ROOT_CA_STATUS_TO_HMI";
        }
        if (o == 41480) {
            return "EM_DIAG_DATA_ID_END";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("EM_DIAG_DATA_ID_DTC_");
        if ((o & 1) == 1) {
            list.add("EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("EM_DIAG_DATA_ID_DTC_IPC_INIT_FAIL");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("EM_DIAG_DATA_ID_DTC_MISS_CAMERA_MOD");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("EM_DIAG_DATA_ID_DTC_LOST_COMM_HL_DIS_FRT");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("EM_DIAG_DATA_ID_DTC_WIFI_MOD_INIT_FAIL");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("EM_DIAG_DATA_ID_DTC_USB_INIT_FAIL");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("EM_DIAG_DATA_ID_DTC_TBOX_LOST_COMM_SATE");
            flipped |= 7;
        }
        if ((o & 8) == 8) {
            list.add("EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_GND");
            flipped |= 8;
        }
        if ((o & 9) == 9) {
            list.add("EM_DIAG_DATA_ID_DTC_GPS_ANTE_SHORT_BAT");
            flipped |= 9;
        }
        if ((o & 10) == 10) {
            list.add("EM_DIAG_DATA_ID_DTC_GPS_ANTE_OPEN");
            flipped |= 10;
        }
        if ((o & 11) == 11) {
            list.add("EM_DIAG_DATA_ID_DTC_USB_1_VBUS_SHORT_GND_BAT");
            flipped |= 11;
        }
        if ((o & 12) == 12) {
            list.add("EM_DIAG_DATA_ID_DTC_USB_1_DLINE_SHORT_VBUS_BAT");
            flipped |= 12;
        }
        if ((o & 13) == 13) {
            list.add("EM_DIAG_DATA_ID_DTC_USB_2_VBUS_SHORT_GND_BAT");
            flipped |= 13;
        }
        if ((o & 14) == 14) {
            list.add("EM_DIAG_DATA_ID_DTC_USB_2_DLINE_SHORT_VBUS_BAT");
            flipped |= 14;
        }
        if ((o & 15) == 15) {
            list.add("EM_DIAG_DATA_ID_DTC_MISS_FRT_CAMERA");
            flipped |= 15;
        }
        if ((o & 16) == 16) {
            list.add("EM_DIAG_DATA_ID_DTC_MISS_REAR_CAMERA");
            flipped |= 16;
        }
        if ((o & 17) == 17) {
            list.add("EM_DIAG_DATA_ID_DTC_MISS_LFT_CAMERA");
            flipped |= 17;
        }
        if ((o & 18) == 18) {
            list.add("EM_DIAG_DATA_ID_DTC_MISS_RGT_CAMERA");
            flipped |= 18;
        }
        if ((o & 19) == 19) {
            list.add("EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_GND");
            flipped |= 19;
        }
        if ((o & 20) == 20) {
            list.add("EM_DIAG_DATA_ID_DTC_FMAM_ANT_SHORT_BAT");
            flipped |= 20;
        }
        if ((o & 21) == 21) {
            list.add("EM_DIAG_DATA_ID_DTC_FMAM_ANT_OPEN");
            flipped |= 21;
        }
        if ((o & 22) == 22) {
            list.add("EM_DIAG_DATA_ID_DTC_LOST_ETH_COMM_TBOX");
            flipped |= 22;
        }
        if ((o & 23) == 23) {
            list.add("EM_DIAG_DATA_ID_DTC_POWER_FAIL");
            flipped |= 23;
        }
        if ((o & 24) == 24) {
            list.add("EM_DIAG_DATA_ID_DTC_CAMERA_CTRL_MOD_INIT_FAIL");
            flipped |= 24;
        }
        if ((o & 25) == 25) {
            list.add("EM_DIAG_DATA_ID_DTC_INSU_SQI");
            flipped |= 25;
        }
        if ((o & 26) == 26) {
            list.add("EM_DIAG_DATA_ID_DTC_CRC_ERR");
            flipped |= 26;
        }
        if ((o & 27) == 27) {
            list.add("EM_DIAG_DATA_ID_DTC_UNEXC_LINK_LOSS");
            flipped |= 27;
        }
        if ((o & 28) == 28) {
            list.add("EM_DIAG_DATA_ID_DTC_LOST_TCP_COMMUNICATION");
            flipped |= 28;
        }
        if ((o & 29) == 29) {
            list.add("EM_DIAG_DATA_ID_DTC_END");
            flipped |= 29;
        }
        if ((o & 4096) == 4096) {
            list.add("EM_DIAG_DATA_ID_RDBI_");
            flipped |= 4096;
        }
        if ((o & 4097) == 4097) {
            list.add("EM_DIAG_DATA_ID_RDBI_PHY_INDENT_NUM");
            flipped |= 4097;
        }
        if ((o & 4098) == 4098) {
            list.add("EM_DIAG_DATA_ID_RDBI_GET_LINK_STATUS_DETE");
            flipped |= 4098;
        }
        if ((o & 4099) == 4099) {
            list.add("EM_DIAG_DATA_ID_RDBI_SQI_THRE_100_T1");
            flipped |= 4099;
        }
        if ((o & 4100) == 4100) {
            list.add("EM_DIAG_DATA_ID_RDBI_SQI_THRE_1000_T1");
            flipped |= 4100;
        }
        if ((o & 4101) == 4101) {
            list.add("EM_DIAG_DATA_ID_RDBI_SQI");
            flipped |= 4101;
        }
        if ((o & 4102) == 4102) {
            list.add("EM_DIAG_DATA_ID_RDBI_TRANS_PACKET");
            flipped |= 4102;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_RECV_PACKET) == 4103) {
            list.add("EM_DIAG_DATA_ID_RDBI_RECV_PACKET");
            flipped |= EM_DIAG_DATA_ID_RDBI_RECV_PACKET;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_SWTCH_CNTER) == 4104) {
            list.add("EM_DIAG_DATA_ID_RDBI_SWTCH_CNTER");
            flipped |= EM_DIAG_DATA_ID_RDBI_SWTCH_CNTER;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_MAC_ADDR) == 4105) {
            list.add("EM_DIAG_DATA_ID_RDBI_MAC_ADDR");
            flipped |= EM_DIAG_DATA_ID_RDBI_MAC_ADDR;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_PRES_GPS_COOR) == 4106) {
            list.add("EM_DIAG_DATA_ID_RDBI_PRES_GPS_COOR");
            flipped |= EM_DIAG_DATA_ID_RDBI_PRES_GPS_COOR;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_BT_CURR_DISC_MODE) == 4107) {
            list.add("EM_DIAG_DATA_ID_RDBI_BT_CURR_DISC_MODE");
            flipped |= EM_DIAG_DATA_ID_RDBI_BT_CURR_DISC_MODE;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_BT_STATUS) == 4108) {
            list.add("EM_DIAG_DATA_ID_RDBI_BT_STATUS");
            flipped |= EM_DIAG_DATA_ID_RDBI_BT_STATUS;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_BT_POWER_CLS) == 4109) {
            list.add("EM_DIAG_DATA_ID_RDBI_BT_POWER_CLS");
            flipped |= EM_DIAG_DATA_ID_RDBI_BT_POWER_CLS;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_BT_ACTVIE_PROF_LIST) == 4110) {
            list.add("EM_DIAG_DATA_ID_RDBI_BT_ACTVIE_PROF_LIST");
            flipped |= EM_DIAG_DATA_ID_RDBI_BT_ACTVIE_PROF_LIST;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_BT_FW_VERSION) == 4111) {
            list.add("EM_DIAG_DATA_ID_RDBI_BT_FW_VERSION");
            flipped |= EM_DIAG_DATA_ID_RDBI_BT_FW_VERSION;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_NUM_OF_USB) == 4112) {
            list.add("EM_DIAG_DATA_ID_RDBI_NUM_OF_USB");
            flipped |= EM_DIAG_DATA_ID_RDBI_NUM_OF_USB;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_CURR_CONN_USB_TYPE) == 4113) {
            list.add("EM_DIAG_DATA_ID_RDBI_CURR_CONN_USB_TYPE");
            flipped |= EM_DIAG_DATA_ID_RDBI_CURR_CONN_USB_TYPE;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_AM_SIGNAL_STRENGTH) == 4114) {
            list.add("EM_DIAG_DATA_ID_RDBI_AM_SIGNAL_STRENGTH");
            flipped |= EM_DIAG_DATA_ID_RDBI_AM_SIGNAL_STRENGTH;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_FM_SIGNAL_STRENGTH) == 4115) {
            list.add("EM_DIAG_DATA_ID_RDBI_FM_SIGNAL_STRENGTH");
            flipped |= EM_DIAG_DATA_ID_RDBI_FM_SIGNAL_STRENGTH;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_WIFI_MOD_STATUS) == 4116) {
            list.add("EM_DIAG_DATA_ID_RDBI_WIFI_MOD_STATUS");
            flipped |= EM_DIAG_DATA_ID_RDBI_WIFI_MOD_STATUS;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_WIFI_MOD_FW_VERSION) == 4117) {
            list.add("EM_DIAG_DATA_ID_RDBI_WIFI_MOD_FW_VERSION");
            flipped |= EM_DIAG_DATA_ID_RDBI_WIFI_MOD_FW_VERSION;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_WIFI_MOD_HW_PART_NUM) == 4118) {
            list.add("EM_DIAG_DATA_ID_RDBI_WIFI_MOD_HW_PART_NUM");
            flipped |= EM_DIAG_DATA_ID_RDBI_WIFI_MOD_HW_PART_NUM;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_TBOX_GW_SUB_MASK) == 4119) {
            list.add("EM_DIAG_DATA_ID_RDBI_TBOX_GW_SUB_MASK");
            flipped |= EM_DIAG_DATA_ID_RDBI_TBOX_GW_SUB_MASK;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_TBOX_LAST_COMM_LOST_TMSP) == 4120) {
            list.add("EM_DIAG_DATA_ID_RDBI_TBOX_LAST_COMM_LOST_TMSP");
            flipped |= EM_DIAG_DATA_ID_RDBI_TBOX_LAST_COMM_LOST_TMSP;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_TBOX_GEO_COOR_CONN_LOST) == 4121) {
            list.add("EM_DIAG_DATA_ID_RDBI_TBOX_GEO_COOR_CONN_LOST");
            flipped |= EM_DIAG_DATA_ID_RDBI_TBOX_GEO_COOR_CONN_LOST;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_TBOX_MOD_STATUS) == 4122) {
            list.add("EM_DIAG_DATA_ID_RDBI_TBOX_MOD_STATUS");
            flipped |= EM_DIAG_DATA_ID_RDBI_TBOX_MOD_STATUS;
        }
        if ((o & EM_DIAG_DATA_ID_RDBI_END) == 4123) {
            list.add("EM_DIAG_DATA_ID_RDBI_END");
            flipped |= EM_DIAG_DATA_ID_RDBI_END;
        }
        if ((o & 8192) == 8192) {
            list.add("EM_DIAG_DATA_ID_WDBI_");
            flipped |= 8192;
        }
        if ((o & 8193) == 8193) {
            list.add("EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT0");
            flipped |= 8193;
        }
        if ((o & 8194) == 8194) {
            list.add("EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT1");
            flipped |= 8194;
        }
        if ((o & 8195) == 8195) {
            list.add("EM_DIAG_DATA_ID_WDBI_MASTER_SLAVE_SET_PORT2");
            flipped |= 8195;
        }
        if ((o & 8196) == 8196) {
            list.add("EM_DIAG_DATA_ID_WDBI_SQI_100_T1");
            flipped |= 8196;
        }
        if ((o & 8197) == 8197) {
            list.add("EM_DIAG_DATA_ID_WDBI_SQI_1000_T1");
            flipped |= 8197;
        }
        if ((o & 8198) == 8198) {
            list.add("EM_DIAG_DATA_ID_WDBI_END");
            flipped |= 8198;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_) == 12288) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_;
        }
        if ((o & 12289) == 12289) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_RESET_PHY");
            flipped |= 12289;
        }
        if ((o & 12290) == 12290) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT0");
            flipped |= 12290;
        }
        if ((o & 12291) == 12291) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT1");
            flipped |= 12291;
        }
        if ((o & 12292) == 12292) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_PHY_TEST_MODE_PORT2");
            flipped |= 12292;
        }
        if ((o & 12293) == 12293) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT0");
            flipped |= 12293;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT1) == 12294) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT1");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT1;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT2) == 12295) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT2");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_CABLE_DIAG_PORT2;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_RESET_SWTCH_STATI) == 12296) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_RESET_SWTCH_STATI");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_RESET_SWTCH_STATI;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_END) == 12297) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_END");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_END;
        }
        if ((o & EM_DIAG_DATA_ID_STATUS_) == 40960) {
            list.add("EM_DIAG_DATA_ID_STATUS_");
            flipped |= EM_DIAG_DATA_ID_STATUS_;
        }
        if ((o & EM_DIAG_DATA_ID_STATUS_GNSS_ANT) == 40961) {
            list.add("EM_DIAG_DATA_ID_STATUS_GNSS_ANT");
            flipped |= EM_DIAG_DATA_ID_STATUS_GNSS_ANT;
        }
        if ((o & EM_DIAG_DATA_ID_STATUS_GNSS_SAT_NUM) == 40962) {
            list.add("EM_DIAG_DATA_ID_STATUS_GNSS_SAT_NUM");
            flipped |= EM_DIAG_DATA_ID_STATUS_GNSS_SAT_NUM;
        }
        if ((o & EM_DIAG_DATA_ID_STATUS_PKI_WIFI) == 40963) {
            list.add("EM_DIAG_DATA_ID_STATUS_PKI_WIFI");
            flipped |= EM_DIAG_DATA_ID_STATUS_PKI_WIFI;
        }
        if ((o & EM_DIAG_DATA_ID_VERSION_) == 41216) {
            list.add("EM_DIAG_DATA_ID_VERSION_");
            flipped |= EM_DIAG_DATA_ID_VERSION_;
        }
        if ((41217 & o) == 41217) {
            list.add("EM_DIAG_DATA_ID_VERSION_GNSS_FW");
            flipped |= EM_DIAG_DATA_ID_VERSION_GNSS_FW;
        }
        if ((41472 & o) == 41472) {
            list.add("EM_DIAG_DATA_ID_CAN_GATEWAY_");
            flipped |= EM_DIAG_DATA_ID_CAN_GATEWAY_;
        }
        if ((41473 & o) == 41473) {
            list.add("EM_DIAG_DATA_ID_CAN_GATEWAY_OTA");
            flipped |= EM_DIAG_DATA_ID_CAN_GATEWAY_OTA;
        }
        if ((41474 & o) == 41474) {
            list.add("EM_DIAG_DATA_ID_CAN_GATEWAY_OTA_CLUSTER");
            flipped |= EM_DIAG_DATA_ID_CAN_GATEWAY_OTA_CLUSTER;
        }
        if ((41475 & o) == 41475) {
            list.add("EM_DIAG_DATA_ID_CAN_PKI_FIRST_REQUEST_UIN_FROM_IOC");
            flipped |= EM_DIAG_DATA_ID_CAN_PKI_FIRST_REQUEST_UIN_FROM_IOC;
        }
        if ((41476 & o) == 41476) {
            list.add("EM_DIAG_DATA_ID_CAN_PKI_SECOND_GET_UIN_BYTES_FROM_IOC");
            flipped |= EM_DIAG_DATA_ID_CAN_PKI_SECOND_GET_UIN_BYTES_FROM_IOC;
        }
        if ((41477 & o) == 41477) {
            list.add("EM_DIAG_DATA_ID_CAN_PKI_THIRD_CONFIRM_AND_SEND_UIN_BYTES_TO_IOC");
            flipped |= EM_DIAG_DATA_ID_CAN_PKI_THIRD_CONFIRM_AND_SEND_UIN_BYTES_TO_IOC;
        }
        if ((41478 & o) == 41478) {
            list.add("EM_DIAG_DATA_ID_CAN_PKI_FOURTH_GET_COMPARE_RESULT_FROM_IOC");
            flipped |= EM_DIAG_DATA_ID_CAN_PKI_FOURTH_GET_COMPARE_RESULT_FROM_IOC;
        }
        if ((41479 & o) == 41479) {
            list.add("EM_DIAG_DATA_ID_CAN_PKI_SEND_ROOT_CA_STATUS_TO_HMI");
            flipped |= EM_DIAG_DATA_ID_CAN_PKI_SEND_ROOT_CA_STATUS_TO_HMI;
        }
        if ((41480 & o) == 41480) {
            list.add("EM_DIAG_DATA_ID_END");
            flipped |= EM_DIAG_DATA_ID_END;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}