package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class CommandID {
    public static final int AME_ABL_INFO = 57;
    public static final int AME_ABL_INFO_DATE = 58;
    public static final int AME_ABL_INFO_GIT = 59;
    public static final int AME_ABL_INFO_USER = 60;
    public static final int AME_ABL_INFO_VER = 61;
    public static final int AME_ADB_DISABLE = 154;
    public static final int AME_ADB_ENABLE = 153;
    public static final int AME_BT_HEANDFREE_LB_TEST = 121;
    public static final int AME_CHECK_CONNECTION_STATUS_BT = 148;
    public static final int AME_CHECK_CONNECTION_STATUS_ETH_PORT0 = 150;
    public static final int AME_CHECK_CONNECTION_STATUS_ETH_PORT1 = 151;
    public static final int AME_CHECK_CONNECTION_STATUS_ETH_PORT2 = 152;
    public static final int AME_CHECK_CONNECTION_STATUS_WIFI = 149;
    public static final int AME_DISP_COLOR_BAR = 115;
    public static final int AME_DISP_COLOR_BAR_BLACK = 117;
    public static final int AME_DISP_COLOR_BAR_RGB = 118;
    public static final int AME_DISP_COLOR_BAR_WHITE = 116;
    public static final int AME_ETHERNET_IP_PING = 122;
    public static final int AME_ETHERNET_SQI = 138;
    public static final int AME_ETHERNET_SQI_PORT0 = 139;
    public static final int AME_ETHERNET_SQI_PORT1 = 140;
    public static final int AME_ETHERNET_SQI_PORT2 = 141;
    public static final int AME_GET_SYSTEM_RTC_TIME = 161;
    public static final int AME_GPS_GET_LATI = 147;
    public static final int AME_GPS_GET_LONG = 146;
    public static final int AME_GPS_GET_LONLAT = 145;
    public static final int AME_INOUTPUT_CCPLED_OFF = 87;
    public static final int AME_INOUTPUT_CCPLED_ON = 86;
    public static final int AME_INOUTPUT_FACELED_OFF = 85;
    public static final int AME_INOUTPUT_FACELED_ON = 84;
    public static final int AME_INOUTPUT_FRT_DISP_OFF = 89;
    public static final int AME_INOUTPUT_FRT_DISP_ON = 88;
    public static final int AME_INOUTPUT_ON_OFF = 83;
    public static final int AME_INOUTPUT_RL_DISP_OFF = 91;
    public static final int AME_INOUTPUT_RL_DISP_ON = 90;
    public static final int AME_INOUTPUT_RR_DISP_OFF = 93;
    public static final int AME_INOUTPUT_RR_DISP_ON = 92;
    public static final int AME_MEDIA_OPERATION = 120;
    public static final int AME_MEDIA_SWTH_SRC = 119;
    public static final int AME_READ_HU_STATUS = 124;
    public static final int AME_READ_HU_STATUS_AM = 129;
    public static final int AME_READ_HU_STATUS_CAMERA_FRT = 133;
    public static final int AME_READ_HU_STATUS_CAMERA_LT = 131;
    public static final int AME_READ_HU_STATUS_CAMERA_REAR = 134;
    public static final int AME_READ_HU_STATUS_CAMERA_RT = 132;
    public static final int AME_READ_HU_STATUS_DISP_FRT = 135;
    public static final int AME_READ_HU_STATUS_DISP_REAR = 136;
    public static final int AME_READ_HU_STATUS_FM = 128;
    public static final int AME_READ_HU_STATUS_FMAM = 127;
    public static final int AME_READ_HU_STATUS_GPS = 130;
    public static final int AME_READ_HU_STATUS_USB1 = 125;
    public static final int AME_READ_HU_STATUS_USB2 = 126;
    public static final int AME_RESET_TO_FACTORY = 80;
    public static final int AME_RESET_TO_FACTORY_ALL = 81;
    public static final int AME_RESET_TO_FACTORY_EXCE_NAVI = 82;
    public static final int AME_ROUTE_MIC_TO_INTE_SPEAKER = 114;
    public static final int AME_SEL_SPEAKER_ZONE = 104;
    public static final int AME_SEL_SPEAKER_ZONE_ALL = 105;
    public static final int AME_SEL_SPEAKER_ZONE_CENTER = 110;
    public static final int AME_SEL_SPEAKER_ZONE_FL = 106;
    public static final int AME_SEL_SPEAKER_ZONE_FR = 107;
    public static final int AME_SEL_SPEAKER_ZONE_RL = 108;
    public static final int AME_SEL_SPEAKER_ZONE_RR = 109;
    public static final int AME_SEL_SPEAKER_ZONE_STOP = 113;
    public static final int AME_SEL_SPEAKER_ZONE_SW1 = 111;
    public static final int AME_SEL_SPEAKER_ZONE_SW2 = 112;
    public static final int AME_SET_DISPLAY_BRIGHTNESS = 160;
    public static final int AME_SET_HMI_LANG = 95;
    public static final int AME_SET_HMI_LANG_CHN = 98;
    public static final int AME_SET_HMI_LANG_DEFAULT = 96;
    public static final int AME_SET_HMI_LANG_ENG = 97;
    public static final int AME_SET_HMI_LANG_JPN = 100;
    public static final int AME_SET_HMI_LANG_KOR = 99;
    public static final int AME_SET_MUTE = 102;
    public static final int AME_SET_MUTE_UNMUTE = 101;
    public static final int AME_SET_UNMUTE = 103;
    public static final int AME_SKIP_WELCOME_SCREEN = 94;
    public static final int AME_TBOX_COMM_STATUS_CHECK = 123;
    public static final int AME_USB1_ETHNET_DISABLE = 156;
    public static final int AME_USB1_ETHNET_ENABLE = 155;
    public static final int AME_USB2_ETHNET_DISABLE = 158;
    public static final int AME_USB2_ETHNET_ENABLE = 157;
    public static final int AME_USB_COPY_DATA_LOG = 159;
    public static final int AME_USB_OTG_SET_MODE = 142;
    public static final int AME_USB_OTG_SET_MODE_DEVICE = 144;
    public static final int AME_USB_OTG_SET_MODE_HOST = 143;
    public static final int AME_WIFI_SSI = 137;
    public static final int AUDIO_DECREASE_VOLUME = 1;
    public static final int AUDIO_GET_AUDIO_SOURCE = 5;
    public static final int AUDIO_GET_VOLUME = 3;
    public static final int AUDIO_INCREASE_VOLUME = 0;
    public static final int AUDIO_LOOP_A2B_SPEAKER_START = 16;
    public static final int AUDIO_LOOP_A2B_SPEAKER_STATUS = 18;
    public static final int AUDIO_LOOP_A2B_SPEAKER_STOP = 17;
    public static final int AUDIO_LOOP_TBOX_SPEAKER_START = 13;
    public static final int AUDIO_LOOP_TBOX_SPEAKER_STATUS = 15;
    public static final int AUDIO_LOOP_TBOX_SPEAKER_STOP = 14;
    public static final int AUDIO_MIC1_SPEAKER_START = 9;
    public static final int AUDIO_MIC1_SPEAKER_STOP = 10;
    public static final int AUDIO_MIC2_SPEAKER_START = 11;
    public static final int AUDIO_MIC2_SPEAKER_STOP = 12;
    public static final int AUDIO_PLAY_TONE = 7;
    public static final int AUDIO_PLAY_TONE_STOP = 8;
    public static final int AUDIO_SET_AUDIO_SOURCE = 4;
    public static final int AUDIO_SET_SETTINGS_THRESHOLD = 6;
    public static final int AUDIO_SET_VOLUME = 2;
    public static final int AVM_CAMERA_ALL_SURROUND = 74;
    public static final int AVM_CAMERA_CLOSE = 68;
    public static final int AVM_CAMERA_FRONT = 70;
    public static final int AVM_CAMERA_REAR = 71;
    public static final int AVM_CAMERA_RIGHT = 73;
    public static final int AVM_CAMERA_RVC = 69;
    public static final int AVM_CARMER_LEFT = 72;
    public static final int BT_AUTO_PAIRING = 45;
    public static final int BT_CLEAN_ALL_PAIRING = 46;
    public static final int BT_GET_MAC_ADDRESS = 44;
    public static final int BT_SET_OFF = 43;
    public static final int BT_SET_ON = 42;
    public static final int EM_ADAS_OEM_CAMERA_DEMARCATE = 131584;
    public static final int EM_CAN_GATEWAY_OTA = 131328;
    public static final int EM_CAN_GATEWAY_OTA_CLUSTER = 131329;
    public static final int EM_DIAG_DATA_ID_RTCTRL_END = 5415;
    public static final int EM_END = 131585;
    public static final int EM_OEM_DIAG_CMD_DTC_ = 4352;
    public static final int EM_OEM_DIAG_CMD_DTC_CAMERA_CTRL_MOD_INIT_FAIL = 4376;
    public static final int EM_OEM_DIAG_CMD_DTC_CRC_ERR = 4378;
    public static final int EM_OEM_DIAG_CMD_DTC_END = 4380;
    public static final int EM_OEM_DIAG_CMD_DTC_FMAM_ANT_OPEN = 4373;
    public static final int EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_BAT = 4372;
    public static final int EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_GND = 4371;
    public static final int EM_OEM_DIAG_CMD_DTC_GPS_ANTE_OPEN = 4362;
    public static final int EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_BAT = 4361;
    public static final int EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_GND = 4360;
    public static final int EM_OEM_DIAG_CMD_DTC_INSU_SQI = 4377;
    public static final int EM_OEM_DIAG_CMD_DTC_IPC_INIT_FAIL = 4354;
    public static final int EM_OEM_DIAG_CMD_DTC_LOST_COMM_HL_DIS_FRT = 4356;
    public static final int EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM = 4353;
    public static final int EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM_TBOX = 4374;
    public static final int EM_OEM_DIAG_CMD_DTC_MISS_CAMERA_MOD = 4355;
    public static final int EM_OEM_DIAG_CMD_DTC_MISS_FRT_CAMERA = 4367;
    public static final int EM_OEM_DIAG_CMD_DTC_MISS_LFT_CAMERA = 4369;
    public static final int EM_OEM_DIAG_CMD_DTC_MISS_REAR_CAMERA = 4368;
    public static final int EM_OEM_DIAG_CMD_DTC_MISS_RGT_CAMERA = 4370;
    public static final int EM_OEM_DIAG_CMD_DTC_POWER_FAIL = 4375;
    public static final int EM_OEM_DIAG_CMD_DTC_TBOX_LOST_COMM_SATE = 4359;
    public static final int EM_OEM_DIAG_CMD_DTC_UNEXC_LINK_LOSS = 4379;
    public static final int EM_OEM_DIAG_CMD_DTC_USB_1_DLINE_SHORT_VBUS_BAT = 4364;
    public static final int EM_OEM_DIAG_CMD_DTC_USB_1_VBUS_SHORT_GND_BAT = 4363;
    public static final int EM_OEM_DIAG_CMD_DTC_USB_2_DLINE_SHORT_VBUS_BAT = 4366;
    public static final int EM_OEM_DIAG_CMD_DTC_USB_2_VBUS_SHORT_GND_BAT = 4365;
    public static final int EM_OEM_DIAG_CMD_DTC_USB_INIT_FAIL = 4358;
    public static final int EM_OEM_DIAG_CMD_DTC_WIFI_MOD_INIT_FAIL = 4357;
    public static final int EM_OEM_DIAG_CMD_RDBI_ = 4608;
    public static final int EM_OEM_DIAG_CMD_RDBI_AM_SIGNAL_STRENGTH = 4637;
    public static final int EM_OEM_DIAG_CMD_RDBI_BT_ACTVIE_PROF_LIST = 4633;
    public static final int EM_OEM_DIAG_CMD_RDBI_BT_CURR_DISC_MODE = 4630;
    public static final int EM_OEM_DIAG_CMD_RDBI_BT_FW_VERSION = 4634;
    public static final int EM_OEM_DIAG_CMD_RDBI_BT_POWER_CLS = 4632;
    public static final int EM_OEM_DIAG_CMD_RDBI_BT_STATUS = 4631;
    public static final int EM_OEM_DIAG_CMD_RDBI_CURR_CONN_USB_TYPE = 4636;
    public static final int EM_OEM_DIAG_CMD_RDBI_END = 4645;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_CTRL_MODE = 4614;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_ERR_MSG_CNT = 4609;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_GET_LINK_STATUS_DETE = 4621;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_LCE_NUM = 4612;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_LK_LST_NUM = 4610;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MAC_ADDR = 4628;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET = 4869;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT0 = 4870;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT1 = 4871;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT2 = 4872;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_MODE_STATUS = 4615;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_NOSNUM_PHY = 4613;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_PHY_INDENT_NUM = 4620;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_RECV_PACKET = 4626;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_SLSC_NUM = 4611;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_SQI = 4624;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_1000_T1 = 4623;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_100_T1 = 4622;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_SWTCH_CNTER = 4627;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS = 4616;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT0 = 4617;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT1 = 4618;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT2 = 4619;
    public static final int EM_OEM_DIAG_CMD_RDBI_ETH_TRANS_PACKET = 4625;
    public static final int EM_OEM_DIAG_CMD_RDBI_FM_SIGNAL_STRENGTH = 4638;
    public static final int EM_OEM_DIAG_CMD_RDBI_NUM_OF_USB = 4635;
    public static final int EM_OEM_DIAG_CMD_RDBI_PRES_GPS_COOR = 4629;
    public static final int EM_OEM_DIAG_CMD_RDBI_TBOX_GEO_COOR_CONN_LOST = 4644;
    public static final int EM_OEM_DIAG_CMD_RDBI_TBOX_GW_SUB_MASK = 4642;
    public static final int EM_OEM_DIAG_CMD_RDBI_TBOX_LAST_COMM_LOST_TMSP = 4643;
    public static final int EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_FW_VERSION = 4640;
    public static final int EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_HW_PART_NUM = 4641;
    public static final int EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_STATUS = 4639;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ = 5120;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_END = 5131;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG = 5126;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT0 = 5127;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT1 = 5128;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT2 = 5129;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_PHY_STA = 5121;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_SWTCH_STATI = 5130;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE = 5122;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT0 = 5123;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT1 = 5124;
    public static final int EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT2 = 5125;
    public static final int EM_OEM_DIAG_CMD_WDBI_ = 4864;
    public static final int EM_OEM_DIAG_CMD_WDBI_END = 4875;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET = 4865;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT0 = 4866;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT1 = 4867;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT2 = 4868;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_SQI_1000_T1 = 4874;
    public static final int EM_OEM_DIAG_CMD_WDBI_ETH_SQI_100_T1 = 4873;
    public static final int ETHERNET_GET_MAC_ADDRESS = 75;
    public static final int ETHERNET_PING_1 = 76;
    public static final int ETHERNET_PING_2 = 77;
    public static final int ETHERNET_PING_3 = 78;
    public static final int GET_EXT_VERSION_FOR_GWM_OTA = 56;
    public static final int GET_IFLY_FIRM_VERSION = 54;
    public static final int GET_MAINSWVERSION = 53;
    public static final int GET_MAINSWVERSION_FOR_GWM = 55;
    public static final int GPS_GET_LOCATION = 40;
    public static final int GPS_GET_SATELLITE_INFO = 79;
    public static final int HMI_SWITCH_HOME_SCREEN = 66;
    public static final int MEDIA_PAUSE = 24;
    public static final int MEDIA_PLAY = 19;
    public static final int MEDIA_PLAY_BTA = 23;
    public static final int MEDIA_PLAY_IPOD = 22;
    public static final int MEDIA_PLAY_USB1 = 20;
    public static final int MEDIA_PLAY_USB2 = 21;
    public static final int MEDIA_REPEAT_TRACK = 28;
    public static final int MEDIA_SET_BEGIN_TRACK = 27;
    public static final int MEDIA_TRACK_DOWN = 26;
    public static final int MEDIA_TRACK_UP = 25;
    public static final int NAVI_GET_APP_VERSION = 62;
    public static final int NAVI_GET_MAP_VERSION = 63;
    public static final int NAVI_SET_DEMO_START = 64;
    public static final int NAVI_SET_DEMO_STOP = 65;
    public static final int OEM_DTC_GPS_ANT_OPEN = 5381;
    public static final int OEM_DTC_GPS_ANT_SHRT_BAT = 5380;
    public static final int OEM_DTC_GPS_ANT_SHRT_GND = 5379;
    public static final int OEM_DTC_LOST_ETH_COMM = 5376;
    public static final int OEM_DTC_LOST_HL_DISP_FRONT = 5377;
    public static final int OEM_DTC_LOST_TBOX_COMM_SATE = 5378;
    public static final int OEM_GWM_PKI_HUT_DELETE_CERT_ACTIVATE_RESULT_FILE = 5424;
    public static final int OEM_GWM_PKI_HUT_DELETE_CERT_FILE = 5425;
    public static final int OEM_GWM_PKI_HUT_DELETE_CSR_FILE = 5417;
    public static final int OEM_GWM_PKI_HUT_GEN_CSR_FILE = 5416;
    public static final int OEM_GWM_PKI_HUT_READ_HUT_CERT_SERIAL_NUMBER = 5428;
    public static final int OEM_GWM_PKI_HUT_SET_USING_OFFICIAL_ENVIRONMENT = 5427;
    public static final int OEM_GWM_PKI_HUT_SET_USING_TEST_ENVIRONMENT = 5426;
    public static final int OEM_GWM_PKI_READ_HUT_CSR_FILE = 5419;
    public static final int OEM_GWM_PKI_READ_HUT_CSR_HASH = 5420;
    public static final int OEM_GWM_PKI_READ_HUT_GEN_CSR_FILE_RESULT = 5422;
    public static final int OEM_GWM_PKI_READ_HUT_UIN = 5418;
    public static final int OEM_GWM_PKI_REQUEST_HUT_CERT = 5421;
    public static final int OEM_GWM_PKI_REQUEST_HUT_CERT_RESULT = 5423;
    public static final int OEM_PKI_SEND_ROOT_CA_STATUS_TO_HMI = 5414;
    public static final int OEM_RDBI_BT_ACT_PROF_LIST = 5396;
    public static final int OEM_RDBI_BT_CURR_DISC_MODE = 5394;
    public static final int OEM_RDBI_BT_FIRMWARE_VERSION = 5397;
    public static final int OEM_RDBI_BT_STATUS = 5395;
    public static final int OEM_RDBI_ETHERNET_GET_LINK_STATES = 5383;
    public static final int OEM_RDBI_ETHERNET_MAC_ADDR = 5390;
    public static final int OEM_RDBI_ETHERNET_PHY_ID_NUMBER = 5382;
    public static final int OEM_RDBI_ETHERNET_RCV_PACK = 5388;
    public static final int OEM_RDBI_ETHERNET_SQI = 5386;
    public static final int OEM_RDBI_ETHERNET_SQI_THRE_1000BASE_T1 = 5385;
    public static final int OEM_RDBI_ETHERNET_SQI_THRE_100BASE_T1 = 5384;
    public static final int OEM_RDBI_ETHERNET_SWCH_COUNTER = 5389;
    public static final int OEM_RDBI_ETHERNET_TRANS_PACK = 5387;
    public static final int OEM_RDBI_GPS_SHIFT_DATA = 5393;
    public static final int OEM_RDBI_TBOX_GEOG_COOR_CONN_LOST = 5408;
    public static final int OEM_RDBI_TBOX_GW_SUB_MASK = 5406;
    public static final int OEM_RDBI_TBOX_IP_ADDRESS = 5405;
    public static final int OEM_RDBI_TBOX_LAST_CONN_LOST_TM_STAMP = 5407;
    public static final int OEM_RDBI_TBOX_MODULE_STATUS = 5409;
    public static final int OEM_RDBI_TUNER_AM_SIGNAL_STRANGTH = 5400;
    public static final int OEM_RDBI_TUNER_FM_SIGNAL_STRANGTH = 5401;
    public static final int OEM_RDBI_USB_CURRENT_TYPE = 5399;
    public static final int OEM_RDBI_USB_EXTER_DEVIC_NUMBER = 5398;
    public static final int OEM_RDBI_WIFI_MODULE_FIRMWARE_VERSION = 5403;
    public static final int OEM_RDBI_WIFI_MODULE_HW_PART_NUM = 5404;
    public static final int OEM_RDBI_WIFI_MODULE_STATUS = 5402;
    public static final int OEM_ROUT_CTRL_CABLE_DIAG = 5412;
    public static final int OEM_ROUT_CTRL_PHY_TEST_MODE = 5411;
    public static final int OEM_ROUT_CTRL_RESET_PHY_STATI = 5410;
    public static final int OEM_ROUT_CTRL_RESET_SWITCH_STATI = 5413;
    public static final int OEM_WDBI_ETHERNET_SQI_THRE_1000BASE_T1 = 5392;
    public static final int OEM_WDBI_ETHERNET_SQI_THRE_100BASE_T1 = 5391;
    public static final int SCREEN_SET_BRIGHTNESS = 41;
    public static final int TBOX_AUDIO_PLAY = 67;
    public static final int TUNER_GET_FREQUENCY = 30;
    public static final int TUNER_SEEK_DOWN = 32;
    public static final int TUNER_SEEK_UP = 31;
    public static final int TUNER_SET_AM_FREQUENCY = 36;
    public static final int TUNER_SET_FM_FREQUENCY = 35;
    public static final int TUNER_SET_FREQUENCY = 29;
    public static final int TUNER_SWITCH_AM = 33;
    public static final int TUNER_SWITCH_FM = 34;
    public static final int VEHICLE_GET_VEHICLE_CONFIG = 38;
    public static final int VEHICLE_INVOKE_HARDKEY_INPUT = 39;
    public static final int VEHICLE_SET_VEHICLE_CONFIG = 37;
    public static final int WIFI_GET_MAC_ADDRESS = 49;
    public static final int WIFI_SET_HU_CLIENT = 51;
    public static final int WIFI_SET_HU_CONNECT_TO_WIFI_AP = 52;
    public static final int WIFI_SET_OFF = 48;
    public static final int WIFI_SET_ON = 47;
    public static final int WIFT_SET_HU_ACCES_POINT = 50;

    public static final String toString(int o) {
        if (o == 0) {
            return "AUDIO_INCREASE_VOLUME";
        }
        if (o == 1) {
            return "AUDIO_DECREASE_VOLUME";
        }
        if (o == 2) {
            return "AUDIO_SET_VOLUME";
        }
        if (o == 3) {
            return "AUDIO_GET_VOLUME";
        }
        if (o == 4) {
            return "AUDIO_SET_AUDIO_SOURCE";
        }
        if (o == 5) {
            return "AUDIO_GET_AUDIO_SOURCE";
        }
        if (o == 6) {
            return "AUDIO_SET_SETTINGS_THRESHOLD";
        }
        if (o == 7) {
            return "AUDIO_PLAY_TONE";
        }
        if (o == 8) {
            return "AUDIO_PLAY_TONE_STOP";
        }
        if (o == 9) {
            return "AUDIO_MIC1_SPEAKER_START";
        }
        if (o == 10) {
            return "AUDIO_MIC1_SPEAKER_STOP";
        }
        if (o == 11) {
            return "AUDIO_MIC2_SPEAKER_START";
        }
        if (o == 12) {
            return "AUDIO_MIC2_SPEAKER_STOP";
        }
        if (o == 13) {
            return "AUDIO_LOOP_TBOX_SPEAKER_START";
        }
        if (o == 14) {
            return "AUDIO_LOOP_TBOX_SPEAKER_STOP";
        }
        if (o == 15) {
            return "AUDIO_LOOP_TBOX_SPEAKER_STATUS";
        }
        if (o == 16) {
            return "AUDIO_LOOP_A2B_SPEAKER_START";
        }
        if (o == 17) {
            return "AUDIO_LOOP_A2B_SPEAKER_STOP";
        }
        if (o == 18) {
            return "AUDIO_LOOP_A2B_SPEAKER_STATUS";
        }
        if (o == 19) {
            return "MEDIA_PLAY";
        }
        if (o == 20) {
            return "MEDIA_PLAY_USB1";
        }
        if (o == 21) {
            return "MEDIA_PLAY_USB2";
        }
        if (o == 22) {
            return "MEDIA_PLAY_IPOD";
        }
        if (o == 23) {
            return "MEDIA_PLAY_BTA";
        }
        if (o == 24) {
            return "MEDIA_PAUSE";
        }
        if (o == 25) {
            return "MEDIA_TRACK_UP";
        }
        if (o == 26) {
            return "MEDIA_TRACK_DOWN";
        }
        if (o == 27) {
            return "MEDIA_SET_BEGIN_TRACK";
        }
        if (o == 28) {
            return "MEDIA_REPEAT_TRACK";
        }
        if (o == 29) {
            return "TUNER_SET_FREQUENCY";
        }
        if (o == 30) {
            return "TUNER_GET_FREQUENCY";
        }
        if (o == 31) {
            return "TUNER_SEEK_UP";
        }
        if (o == 32) {
            return "TUNER_SEEK_DOWN";
        }
        if (o == 33) {
            return "TUNER_SWITCH_AM";
        }
        if (o == 34) {
            return "TUNER_SWITCH_FM";
        }
        if (o == 35) {
            return "TUNER_SET_FM_FREQUENCY";
        }
        if (o == 36) {
            return "TUNER_SET_AM_FREQUENCY";
        }
        if (o == 37) {
            return "VEHICLE_SET_VEHICLE_CONFIG";
        }
        if (o == 38) {
            return "VEHICLE_GET_VEHICLE_CONFIG";
        }
        if (o == 39) {
            return "VEHICLE_INVOKE_HARDKEY_INPUT";
        }
        if (o == 40) {
            return "GPS_GET_LOCATION";
        }
        if (o == 41) {
            return "SCREEN_SET_BRIGHTNESS";
        }
        if (o == 42) {
            return "BT_SET_ON";
        }
        if (o == 43) {
            return "BT_SET_OFF";
        }
        if (o == 44) {
            return "BT_GET_MAC_ADDRESS";
        }
        if (o == 45) {
            return "BT_AUTO_PAIRING";
        }
        if (o == 46) {
            return "BT_CLEAN_ALL_PAIRING";
        }
        if (o == 47) {
            return "WIFI_SET_ON";
        }
        if (o == 48) {
            return "WIFI_SET_OFF";
        }
        if (o == 49) {
            return "WIFI_GET_MAC_ADDRESS";
        }
        if (o == 50) {
            return "WIFT_SET_HU_ACCES_POINT";
        }
        if (o == 51) {
            return "WIFI_SET_HU_CLIENT";
        }
        if (o == 52) {
            return "WIFI_SET_HU_CONNECT_TO_WIFI_AP";
        }
        if (o == 53) {
            return "GET_MAINSWVERSION";
        }
        if (o == 54) {
            return "GET_IFLY_FIRM_VERSION";
        }
        if (o == 55) {
            return "GET_MAINSWVERSION_FOR_GWM";
        }
        if (o == 56) {
            return "GET_EXT_VERSION_FOR_GWM_OTA";
        }
        if (o == 57) {
            return "AME_ABL_INFO";
        }
        if (o == 58) {
            return "AME_ABL_INFO_DATE";
        }
        if (o == 59) {
            return "AME_ABL_INFO_GIT";
        }
        if (o == 60) {
            return "AME_ABL_INFO_USER";
        }
        if (o == 61) {
            return "AME_ABL_INFO_VER";
        }
        if (o == 62) {
            return "NAVI_GET_APP_VERSION";
        }
        if (o == 63) {
            return "NAVI_GET_MAP_VERSION";
        }
        if (o == 64) {
            return "NAVI_SET_DEMO_START";
        }
        if (o == 65) {
            return "NAVI_SET_DEMO_STOP";
        }
        if (o == 66) {
            return "HMI_SWITCH_HOME_SCREEN";
        }
        if (o == 67) {
            return "TBOX_AUDIO_PLAY";
        }
        if (o == 68) {
            return "AVM_CAMERA_CLOSE";
        }
        if (o == 69) {
            return "AVM_CAMERA_RVC";
        }
        if (o == 70) {
            return "AVM_CAMERA_FRONT";
        }
        if (o == 71) {
            return "AVM_CAMERA_REAR";
        }
        if (o == 72) {
            return "AVM_CARMER_LEFT";
        }
        if (o == 73) {
            return "AVM_CAMERA_RIGHT";
        }
        if (o == 74) {
            return "AVM_CAMERA_ALL_SURROUND";
        }
        if (o == 75) {
            return "ETHERNET_GET_MAC_ADDRESS";
        }
        if (o == 76) {
            return "ETHERNET_PING_1";
        }
        if (o == 77) {
            return "ETHERNET_PING_2";
        }
        if (o == 78) {
            return "ETHERNET_PING_3";
        }
        if (o == 79) {
            return "GPS_GET_SATELLITE_INFO";
        }
        if (o == 80) {
            return "AME_RESET_TO_FACTORY";
        }
        if (o == 81) {
            return "AME_RESET_TO_FACTORY_ALL";
        }
        if (o == 82) {
            return "AME_RESET_TO_FACTORY_EXCE_NAVI";
        }
        if (o == 83) {
            return "AME_INOUTPUT_ON_OFF";
        }
        if (o == 84) {
            return "AME_INOUTPUT_FACELED_ON";
        }
        if (o == 85) {
            return "AME_INOUTPUT_FACELED_OFF";
        }
        if (o == 86) {
            return "AME_INOUTPUT_CCPLED_ON";
        }
        if (o == 87) {
            return "AME_INOUTPUT_CCPLED_OFF";
        }
        if (o == 88) {
            return "AME_INOUTPUT_FRT_DISP_ON";
        }
        if (o == 89) {
            return "AME_INOUTPUT_FRT_DISP_OFF";
        }
        if (o == 90) {
            return "AME_INOUTPUT_RL_DISP_ON";
        }
        if (o == 91) {
            return "AME_INOUTPUT_RL_DISP_OFF";
        }
        if (o == 92) {
            return "AME_INOUTPUT_RR_DISP_ON";
        }
        if (o == 93) {
            return "AME_INOUTPUT_RR_DISP_OFF";
        }
        if (o == 94) {
            return "AME_SKIP_WELCOME_SCREEN";
        }
        if (o == 95) {
            return "AME_SET_HMI_LANG";
        }
        if (o == 96) {
            return "AME_SET_HMI_LANG_DEFAULT";
        }
        if (o == 97) {
            return "AME_SET_HMI_LANG_ENG";
        }
        if (o == 98) {
            return "AME_SET_HMI_LANG_CHN";
        }
        if (o == 99) {
            return "AME_SET_HMI_LANG_KOR";
        }
        if (o == 100) {
            return "AME_SET_HMI_LANG_JPN";
        }
        if (o == 101) {
            return "AME_SET_MUTE_UNMUTE";
        }
        if (o == 102) {
            return "AME_SET_MUTE";
        }
        if (o == 103) {
            return "AME_SET_UNMUTE";
        }
        if (o == 104) {
            return "AME_SEL_SPEAKER_ZONE";
        }
        if (o == 105) {
            return "AME_SEL_SPEAKER_ZONE_ALL";
        }
        if (o == 106) {
            return "AME_SEL_SPEAKER_ZONE_FL";
        }
        if (o == 107) {
            return "AME_SEL_SPEAKER_ZONE_FR";
        }
        if (o == 108) {
            return "AME_SEL_SPEAKER_ZONE_RL";
        }
        if (o == 109) {
            return "AME_SEL_SPEAKER_ZONE_RR";
        }
        if (o == 110) {
            return "AME_SEL_SPEAKER_ZONE_CENTER";
        }
        if (o == 111) {
            return "AME_SEL_SPEAKER_ZONE_SW1";
        }
        if (o == 112) {
            return "AME_SEL_SPEAKER_ZONE_SW2";
        }
        if (o == 113) {
            return "AME_SEL_SPEAKER_ZONE_STOP";
        }
        if (o == 114) {
            return "AME_ROUTE_MIC_TO_INTE_SPEAKER";
        }
        if (o == 115) {
            return "AME_DISP_COLOR_BAR";
        }
        if (o == 116) {
            return "AME_DISP_COLOR_BAR_WHITE";
        }
        if (o == 117) {
            return "AME_DISP_COLOR_BAR_BLACK";
        }
        if (o == 118) {
            return "AME_DISP_COLOR_BAR_RGB";
        }
        if (o == 119) {
            return "AME_MEDIA_SWTH_SRC";
        }
        if (o == 120) {
            return "AME_MEDIA_OPERATION";
        }
        if (o == 121) {
            return "AME_BT_HEANDFREE_LB_TEST";
        }
        if (o == 122) {
            return "AME_ETHERNET_IP_PING";
        }
        if (o == 123) {
            return "AME_TBOX_COMM_STATUS_CHECK";
        }
        if (o == 124) {
            return "AME_READ_HU_STATUS";
        }
        if (o == 125) {
            return "AME_READ_HU_STATUS_USB1";
        }
        if (o == 126) {
            return "AME_READ_HU_STATUS_USB2";
        }
        if (o == 127) {
            return "AME_READ_HU_STATUS_FMAM";
        }
        if (o == 128) {
            return "AME_READ_HU_STATUS_FM";
        }
        if (o == 129) {
            return "AME_READ_HU_STATUS_AM";
        }
        if (o == 130) {
            return "AME_READ_HU_STATUS_GPS";
        }
        if (o == 131) {
            return "AME_READ_HU_STATUS_CAMERA_LT";
        }
        if (o == 132) {
            return "AME_READ_HU_STATUS_CAMERA_RT";
        }
        if (o == 133) {
            return "AME_READ_HU_STATUS_CAMERA_FRT";
        }
        if (o == 134) {
            return "AME_READ_HU_STATUS_CAMERA_REAR";
        }
        if (o == 135) {
            return "AME_READ_HU_STATUS_DISP_FRT";
        }
        if (o == 136) {
            return "AME_READ_HU_STATUS_DISP_REAR";
        }
        if (o == 137) {
            return "AME_WIFI_SSI";
        }
        if (o == 138) {
            return "AME_ETHERNET_SQI";
        }
        if (o == 139) {
            return "AME_ETHERNET_SQI_PORT0";
        }
        if (o == 140) {
            return "AME_ETHERNET_SQI_PORT1";
        }
        if (o == 141) {
            return "AME_ETHERNET_SQI_PORT2";
        }
        if (o == 142) {
            return "AME_USB_OTG_SET_MODE";
        }
        if (o == 143) {
            return "AME_USB_OTG_SET_MODE_HOST";
        }
        if (o == 144) {
            return "AME_USB_OTG_SET_MODE_DEVICE";
        }
        if (o == 145) {
            return "AME_GPS_GET_LONLAT";
        }
        if (o == 146) {
            return "AME_GPS_GET_LONG";
        }
        if (o == 147) {
            return "AME_GPS_GET_LATI";
        }
        if (o == 148) {
            return "AME_CHECK_CONNECTION_STATUS_BT";
        }
        if (o == 149) {
            return "AME_CHECK_CONNECTION_STATUS_WIFI";
        }
        if (o == 150) {
            return "AME_CHECK_CONNECTION_STATUS_ETH_PORT0";
        }
        if (o == 151) {
            return "AME_CHECK_CONNECTION_STATUS_ETH_PORT1";
        }
        if (o == 152) {
            return "AME_CHECK_CONNECTION_STATUS_ETH_PORT2";
        }
        if (o == 153) {
            return "AME_ADB_ENABLE";
        }
        if (o == 154) {
            return "AME_ADB_DISABLE";
        }
        if (o == 155) {
            return "AME_USB1_ETHNET_ENABLE";
        }
        if (o == 156) {
            return "AME_USB1_ETHNET_DISABLE";
        }
        if (o == 157) {
            return "AME_USB2_ETHNET_ENABLE";
        }
        if (o == 158) {
            return "AME_USB2_ETHNET_DISABLE";
        }
        if (o == 159) {
            return "AME_USB_COPY_DATA_LOG";
        }
        if (o == 160) {
            return "AME_SET_DISPLAY_BRIGHTNESS";
        }
        if (o == 161) {
            return "AME_GET_SYSTEM_RTC_TIME";
        }
        if (o == 4352) {
            return "EM_OEM_DIAG_CMD_DTC_";
        }
        if (o == 4353) {
            return "EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM";
        }
        if (o == 4354) {
            return "EM_OEM_DIAG_CMD_DTC_IPC_INIT_FAIL";
        }
        if (o == 4355) {
            return "EM_OEM_DIAG_CMD_DTC_MISS_CAMERA_MOD";
        }
        if (o == 4356) {
            return "EM_OEM_DIAG_CMD_DTC_LOST_COMM_HL_DIS_FRT";
        }
        if (o == 4357) {
            return "EM_OEM_DIAG_CMD_DTC_WIFI_MOD_INIT_FAIL";
        }
        if (o == 4358) {
            return "EM_OEM_DIAG_CMD_DTC_USB_INIT_FAIL";
        }
        if (o == 4359) {
            return "EM_OEM_DIAG_CMD_DTC_TBOX_LOST_COMM_SATE";
        }
        if (o == 4360) {
            return "EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_GND";
        }
        if (o == 4361) {
            return "EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_BAT";
        }
        if (o == 4362) {
            return "EM_OEM_DIAG_CMD_DTC_GPS_ANTE_OPEN";
        }
        if (o == 4363) {
            return "EM_OEM_DIAG_CMD_DTC_USB_1_VBUS_SHORT_GND_BAT";
        }
        if (o == 4364) {
            return "EM_OEM_DIAG_CMD_DTC_USB_1_DLINE_SHORT_VBUS_BAT";
        }
        if (o == 4365) {
            return "EM_OEM_DIAG_CMD_DTC_USB_2_VBUS_SHORT_GND_BAT";
        }
        if (o == 4366) {
            return "EM_OEM_DIAG_CMD_DTC_USB_2_DLINE_SHORT_VBUS_BAT";
        }
        if (o == 4367) {
            return "EM_OEM_DIAG_CMD_DTC_MISS_FRT_CAMERA";
        }
        if (o == 4368) {
            return "EM_OEM_DIAG_CMD_DTC_MISS_REAR_CAMERA";
        }
        if (o == 4369) {
            return "EM_OEM_DIAG_CMD_DTC_MISS_LFT_CAMERA";
        }
        if (o == 4370) {
            return "EM_OEM_DIAG_CMD_DTC_MISS_RGT_CAMERA";
        }
        if (o == 4371) {
            return "EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_GND";
        }
        if (o == 4372) {
            return "EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_BAT";
        }
        if (o == 4373) {
            return "EM_OEM_DIAG_CMD_DTC_FMAM_ANT_OPEN";
        }
        if (o == 4374) {
            return "EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM_TBOX";
        }
        if (o == 4375) {
            return "EM_OEM_DIAG_CMD_DTC_POWER_FAIL";
        }
        if (o == 4376) {
            return "EM_OEM_DIAG_CMD_DTC_CAMERA_CTRL_MOD_INIT_FAIL";
        }
        if (o == 4377) {
            return "EM_OEM_DIAG_CMD_DTC_INSU_SQI";
        }
        if (o == 4378) {
            return "EM_OEM_DIAG_CMD_DTC_CRC_ERR";
        }
        if (o == 4379) {
            return "EM_OEM_DIAG_CMD_DTC_UNEXC_LINK_LOSS";
        }
        if (o == 4380) {
            return "EM_OEM_DIAG_CMD_DTC_END";
        }
        if (o == 4608) {
            return "EM_OEM_DIAG_CMD_RDBI_";
        }
        if (o == 4609) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_ERR_MSG_CNT";
        }
        if (o == 4610) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_LK_LST_NUM";
        }
        if (o == 4611) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_SLSC_NUM";
        }
        if (o == 4612) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_LCE_NUM";
        }
        if (o == 4613) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_NOSNUM_PHY";
        }
        if (o == 4614) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_CTRL_MODE";
        }
        if (o == 4615) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MODE_STATUS";
        }
        if (o == 4616) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS";
        }
        if (o == 4617) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT0";
        }
        if (o == 4618) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT1";
        }
        if (o == 4619) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT2";
        }
        if (o == 4620) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_PHY_INDENT_NUM";
        }
        if (o == 4621) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_GET_LINK_STATUS_DETE";
        }
        if (o == 4622) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_100_T1";
        }
        if (o == 4623) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_1000_T1";
        }
        if (o == 4624) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_SQI";
        }
        if (o == 4625) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_TRANS_PACKET";
        }
        if (o == 4626) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_RECV_PACKET";
        }
        if (o == 4627) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_SWTCH_CNTER";
        }
        if (o == 4628) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MAC_ADDR";
        }
        if (o == 4629) {
            return "EM_OEM_DIAG_CMD_RDBI_PRES_GPS_COOR";
        }
        if (o == 4630) {
            return "EM_OEM_DIAG_CMD_RDBI_BT_CURR_DISC_MODE";
        }
        if (o == 4631) {
            return "EM_OEM_DIAG_CMD_RDBI_BT_STATUS";
        }
        if (o == 4632) {
            return "EM_OEM_DIAG_CMD_RDBI_BT_POWER_CLS";
        }
        if (o == 4633) {
            return "EM_OEM_DIAG_CMD_RDBI_BT_ACTVIE_PROF_LIST";
        }
        if (o == 4634) {
            return "EM_OEM_DIAG_CMD_RDBI_BT_FW_VERSION";
        }
        if (o == 4635) {
            return "EM_OEM_DIAG_CMD_RDBI_NUM_OF_USB";
        }
        if (o == 4636) {
            return "EM_OEM_DIAG_CMD_RDBI_CURR_CONN_USB_TYPE";
        }
        if (o == 4637) {
            return "EM_OEM_DIAG_CMD_RDBI_AM_SIGNAL_STRENGTH";
        }
        if (o == 4638) {
            return "EM_OEM_DIAG_CMD_RDBI_FM_SIGNAL_STRENGTH";
        }
        if (o == 4639) {
            return "EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_STATUS";
        }
        if (o == 4640) {
            return "EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_FW_VERSION";
        }
        if (o == 4641) {
            return "EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_HW_PART_NUM";
        }
        if (o == 4642) {
            return "EM_OEM_DIAG_CMD_RDBI_TBOX_GW_SUB_MASK";
        }
        if (o == 4643) {
            return "EM_OEM_DIAG_CMD_RDBI_TBOX_LAST_COMM_LOST_TMSP";
        }
        if (o == 4644) {
            return "EM_OEM_DIAG_CMD_RDBI_TBOX_GEO_COOR_CONN_LOST";
        }
        if (o == 4645) {
            return "EM_OEM_DIAG_CMD_RDBI_END";
        }
        if (o == 4864) {
            return "EM_OEM_DIAG_CMD_WDBI_";
        }
        if (o == 4865) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET";
        }
        if (o == 4866) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT0";
        }
        if (o == 4867) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT1";
        }
        if (o == 4868) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT2";
        }
        if (o == 4869) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET";
        }
        if (o == 4870) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT0";
        }
        if (o == 4871) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT1";
        }
        if (o == 4872) {
            return "EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT2";
        }
        if (o == 4873) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_SQI_100_T1";
        }
        if (o == 4874) {
            return "EM_OEM_DIAG_CMD_WDBI_ETH_SQI_1000_T1";
        }
        if (o == 4875) {
            return "EM_OEM_DIAG_CMD_WDBI_END";
        }
        if (o == 5120) {
            return "EM_OEM_DIAG_CMD_RTCTRL_";
        }
        if (o == 5121) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_PHY_STA";
        }
        if (o == 5122) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE";
        }
        if (o == 5123) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT0";
        }
        if (o == 5124) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT1";
        }
        if (o == 5125) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT2";
        }
        if (o == 5126) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG";
        }
        if (o == 5127) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT0";
        }
        if (o == 5128) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT1";
        }
        if (o == 5129) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT2";
        }
        if (o == 5130) {
            return "EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_SWTCH_STATI";
        }
        if (o == 5131) {
            return "EM_OEM_DIAG_CMD_RTCTRL_END";
        }
        if (o == 5376) {
            return "OEM_DTC_LOST_ETH_COMM";
        }
        if (o == 5377) {
            return "OEM_DTC_LOST_HL_DISP_FRONT";
        }
        if (o == 5378) {
            return "OEM_DTC_LOST_TBOX_COMM_SATE";
        }
        if (o == 5379) {
            return "OEM_DTC_GPS_ANT_SHRT_GND";
        }
        if (o == 5380) {
            return "OEM_DTC_GPS_ANT_SHRT_BAT";
        }
        if (o == 5381) {
            return "OEM_DTC_GPS_ANT_OPEN";
        }
        if (o == 5382) {
            return "OEM_RDBI_ETHERNET_PHY_ID_NUMBER";
        }
        if (o == 5383) {
            return "OEM_RDBI_ETHERNET_GET_LINK_STATES";
        }
        if (o == 5384) {
            return "OEM_RDBI_ETHERNET_SQI_THRE_100BASE_T1";
        }
        if (o == 5385) {
            return "OEM_RDBI_ETHERNET_SQI_THRE_1000BASE_T1";
        }
        if (o == 5386) {
            return "OEM_RDBI_ETHERNET_SQI";
        }
        if (o == 5387) {
            return "OEM_RDBI_ETHERNET_TRANS_PACK";
        }
        if (o == 5388) {
            return "OEM_RDBI_ETHERNET_RCV_PACK";
        }
        if (o == 5389) {
            return "OEM_RDBI_ETHERNET_SWCH_COUNTER";
        }
        if (o == 5390) {
            return "OEM_RDBI_ETHERNET_MAC_ADDR";
        }
        if (o == 5391) {
            return "OEM_WDBI_ETHERNET_SQI_THRE_100BASE_T1";
        }
        if (o == 5392) {
            return "OEM_WDBI_ETHERNET_SQI_THRE_1000BASE_T1";
        }
        if (o == 5393) {
            return "OEM_RDBI_GPS_SHIFT_DATA";
        }
        if (o == 5394) {
            return "OEM_RDBI_BT_CURR_DISC_MODE";
        }
        if (o == 5395) {
            return "OEM_RDBI_BT_STATUS";
        }
        if (o == 5396) {
            return "OEM_RDBI_BT_ACT_PROF_LIST";
        }
        if (o == 5397) {
            return "OEM_RDBI_BT_FIRMWARE_VERSION";
        }
        if (o == 5398) {
            return "OEM_RDBI_USB_EXTER_DEVIC_NUMBER";
        }
        if (o == 5399) {
            return "OEM_RDBI_USB_CURRENT_TYPE";
        }
        if (o == 5400) {
            return "OEM_RDBI_TUNER_AM_SIGNAL_STRANGTH";
        }
        if (o == 5401) {
            return "OEM_RDBI_TUNER_FM_SIGNAL_STRANGTH";
        }
        if (o == 5402) {
            return "OEM_RDBI_WIFI_MODULE_STATUS";
        }
        if (o == 5403) {
            return "OEM_RDBI_WIFI_MODULE_FIRMWARE_VERSION";
        }
        if (o == 5404) {
            return "OEM_RDBI_WIFI_MODULE_HW_PART_NUM";
        }
        if (o == 5405) {
            return "OEM_RDBI_TBOX_IP_ADDRESS";
        }
        if (o == 5406) {
            return "OEM_RDBI_TBOX_GW_SUB_MASK";
        }
        if (o == 5407) {
            return "OEM_RDBI_TBOX_LAST_CONN_LOST_TM_STAMP";
        }
        if (o == 5408) {
            return "OEM_RDBI_TBOX_GEOG_COOR_CONN_LOST";
        }
        if (o == 5409) {
            return "OEM_RDBI_TBOX_MODULE_STATUS";
        }
        if (o == 5410) {
            return "OEM_ROUT_CTRL_RESET_PHY_STATI";
        }
        if (o == 5411) {
            return "OEM_ROUT_CTRL_PHY_TEST_MODE";
        }
        if (o == 5412) {
            return "OEM_ROUT_CTRL_CABLE_DIAG";
        }
        if (o == 5413) {
            return "OEM_ROUT_CTRL_RESET_SWITCH_STATI";
        }
        if (o == 5414) {
            return "OEM_PKI_SEND_ROOT_CA_STATUS_TO_HMI";
        }
        if (o == 5415) {
            return "EM_DIAG_DATA_ID_RTCTRL_END";
        }
        if (o == 5416) {
            return "OEM_GWM_PKI_HUT_GEN_CSR_FILE";
        }
        if (o == 5417) {
            return "OEM_GWM_PKI_HUT_DELETE_CSR_FILE";
        }
        if (o == 5418) {
            return "OEM_GWM_PKI_READ_HUT_UIN";
        }
        if (o == 5419) {
            return "OEM_GWM_PKI_READ_HUT_CSR_FILE";
        }
        if (o == 5420) {
            return "OEM_GWM_PKI_READ_HUT_CSR_HASH";
        }
        if (o == 5421) {
            return "OEM_GWM_PKI_REQUEST_HUT_CERT";
        }
        if (o == 5422) {
            return "OEM_GWM_PKI_READ_HUT_GEN_CSR_FILE_RESULT";
        }
        if (o == 5423) {
            return "OEM_GWM_PKI_REQUEST_HUT_CERT_RESULT";
        }
        if (o == 5424) {
            return "OEM_GWM_PKI_HUT_DELETE_CERT_ACTIVATE_RESULT_FILE";
        }
        if (o == 5425) {
            return "OEM_GWM_PKI_HUT_DELETE_CERT_FILE";
        }
        if (o == 5426) {
            return "OEM_GWM_PKI_HUT_SET_USING_TEST_ENVIRONMENT";
        }
        if (o == 5427) {
            return "OEM_GWM_PKI_HUT_SET_USING_OFFICIAL_ENVIRONMENT";
        }
        if (o == 5428) {
            return "OEM_GWM_PKI_HUT_READ_HUT_CERT_SERIAL_NUMBER";
        }
        if (o == 131328) {
            return "EM_CAN_GATEWAY_OTA";
        }
        if (o == 131329) {
            return "EM_CAN_GATEWAY_OTA_CLUSTER";
        }
        if (o == 131584) {
            return "EM_ADAS_OEM_CAMERA_DEMARCATE";
        }
        if (o == 131585) {
            return "EM_END";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("AUDIO_INCREASE_VOLUME");
        if ((o & 1) == 1) {
            list.add("AUDIO_DECREASE_VOLUME");
            flipped = 0 | 1;
        }
        if ((o & 2) == 2) {
            list.add("AUDIO_SET_VOLUME");
            flipped |= 2;
        }
        if ((o & 3) == 3) {
            list.add("AUDIO_GET_VOLUME");
            flipped |= 3;
        }
        if ((o & 4) == 4) {
            list.add("AUDIO_SET_AUDIO_SOURCE");
            flipped |= 4;
        }
        if ((o & 5) == 5) {
            list.add("AUDIO_GET_AUDIO_SOURCE");
            flipped |= 5;
        }
        if ((o & 6) == 6) {
            list.add("AUDIO_SET_SETTINGS_THRESHOLD");
            flipped |= 6;
        }
        if ((o & 7) == 7) {
            list.add("AUDIO_PLAY_TONE");
            flipped |= 7;
        }
        if ((o & 8) == 8) {
            list.add("AUDIO_PLAY_TONE_STOP");
            flipped |= 8;
        }
        if ((o & 9) == 9) {
            list.add("AUDIO_MIC1_SPEAKER_START");
            flipped |= 9;
        }
        if ((o & 10) == 10) {
            list.add("AUDIO_MIC1_SPEAKER_STOP");
            flipped |= 10;
        }
        if ((o & 11) == 11) {
            list.add("AUDIO_MIC2_SPEAKER_START");
            flipped |= 11;
        }
        if ((o & 12) == 12) {
            list.add("AUDIO_MIC2_SPEAKER_STOP");
            flipped |= 12;
        }
        if ((o & 13) == 13) {
            list.add("AUDIO_LOOP_TBOX_SPEAKER_START");
            flipped |= 13;
        }
        if ((o & 14) == 14) {
            list.add("AUDIO_LOOP_TBOX_SPEAKER_STOP");
            flipped |= 14;
        }
        if ((o & 15) == 15) {
            list.add("AUDIO_LOOP_TBOX_SPEAKER_STATUS");
            flipped |= 15;
        }
        if ((o & 16) == 16) {
            list.add("AUDIO_LOOP_A2B_SPEAKER_START");
            flipped |= 16;
        }
        if ((o & 17) == 17) {
            list.add("AUDIO_LOOP_A2B_SPEAKER_STOP");
            flipped |= 17;
        }
        if ((o & 18) == 18) {
            list.add("AUDIO_LOOP_A2B_SPEAKER_STATUS");
            flipped |= 18;
        }
        if ((o & 19) == 19) {
            list.add("MEDIA_PLAY");
            flipped |= 19;
        }
        if ((o & 20) == 20) {
            list.add("MEDIA_PLAY_USB1");
            flipped |= 20;
        }
        if ((o & 21) == 21) {
            list.add("MEDIA_PLAY_USB2");
            flipped |= 21;
        }
        if ((o & 22) == 22) {
            list.add("MEDIA_PLAY_IPOD");
            flipped |= 22;
        }
        if ((o & 23) == 23) {
            list.add("MEDIA_PLAY_BTA");
            flipped |= 23;
        }
        if ((o & 24) == 24) {
            list.add("MEDIA_PAUSE");
            flipped |= 24;
        }
        if ((o & 25) == 25) {
            list.add("MEDIA_TRACK_UP");
            flipped |= 25;
        }
        if ((o & 26) == 26) {
            list.add("MEDIA_TRACK_DOWN");
            flipped |= 26;
        }
        if ((o & 27) == 27) {
            list.add("MEDIA_SET_BEGIN_TRACK");
            flipped |= 27;
        }
        if ((o & 28) == 28) {
            list.add("MEDIA_REPEAT_TRACK");
            flipped |= 28;
        }
        if ((o & 29) == 29) {
            list.add("TUNER_SET_FREQUENCY");
            flipped |= 29;
        }
        if ((o & 30) == 30) {
            list.add("TUNER_GET_FREQUENCY");
            flipped |= 30;
        }
        if ((o & 31) == 31) {
            list.add("TUNER_SEEK_UP");
            flipped |= 31;
        }
        if ((o & 32) == 32) {
            list.add("TUNER_SEEK_DOWN");
            flipped |= 32;
        }
        if ((o & 33) == 33) {
            list.add("TUNER_SWITCH_AM");
            flipped |= 33;
        }
        if ((o & 34) == 34) {
            list.add("TUNER_SWITCH_FM");
            flipped |= 34;
        }
        if ((o & 35) == 35) {
            list.add("TUNER_SET_FM_FREQUENCY");
            flipped |= 35;
        }
        if ((o & 36) == 36) {
            list.add("TUNER_SET_AM_FREQUENCY");
            flipped |= 36;
        }
        if ((o & 37) == 37) {
            list.add("VEHICLE_SET_VEHICLE_CONFIG");
            flipped |= 37;
        }
        if ((o & 38) == 38) {
            list.add("VEHICLE_GET_VEHICLE_CONFIG");
            flipped |= 38;
        }
        if ((o & 39) == 39) {
            list.add("VEHICLE_INVOKE_HARDKEY_INPUT");
            flipped |= 39;
        }
        if ((o & 40) == 40) {
            list.add("GPS_GET_LOCATION");
            flipped |= 40;
        }
        if ((o & 41) == 41) {
            list.add("SCREEN_SET_BRIGHTNESS");
            flipped |= 41;
        }
        if ((o & 42) == 42) {
            list.add("BT_SET_ON");
            flipped |= 42;
        }
        if ((o & 43) == 43) {
            list.add("BT_SET_OFF");
            flipped |= 43;
        }
        if ((o & 44) == 44) {
            list.add("BT_GET_MAC_ADDRESS");
            flipped |= 44;
        }
        if ((o & 45) == 45) {
            list.add("BT_AUTO_PAIRING");
            flipped |= 45;
        }
        if ((o & 46) == 46) {
            list.add("BT_CLEAN_ALL_PAIRING");
            flipped |= 46;
        }
        if ((o & 47) == 47) {
            list.add("WIFI_SET_ON");
            flipped |= 47;
        }
        if ((o & 48) == 48) {
            list.add("WIFI_SET_OFF");
            flipped |= 48;
        }
        if ((o & 49) == 49) {
            list.add("WIFI_GET_MAC_ADDRESS");
            flipped |= 49;
        }
        if ((o & 50) == 50) {
            list.add("WIFT_SET_HU_ACCES_POINT");
            flipped |= 50;
        }
        if ((o & 51) == 51) {
            list.add("WIFI_SET_HU_CLIENT");
            flipped |= 51;
        }
        if ((o & 52) == 52) {
            list.add("WIFI_SET_HU_CONNECT_TO_WIFI_AP");
            flipped |= 52;
        }
        if ((o & 53) == 53) {
            list.add("GET_MAINSWVERSION");
            flipped |= 53;
        }
        if ((o & 54) == 54) {
            list.add("GET_IFLY_FIRM_VERSION");
            flipped |= 54;
        }
        if ((o & 55) == 55) {
            list.add("GET_MAINSWVERSION_FOR_GWM");
            flipped |= 55;
        }
        if ((o & 56) == 56) {
            list.add("GET_EXT_VERSION_FOR_GWM_OTA");
            flipped |= 56;
        }
        if ((o & 57) == 57) {
            list.add("AME_ABL_INFO");
            flipped |= 57;
        }
        if ((o & 58) == 58) {
            list.add("AME_ABL_INFO_DATE");
            flipped |= 58;
        }
        if ((o & 59) == 59) {
            list.add("AME_ABL_INFO_GIT");
            flipped |= 59;
        }
        if ((o & 60) == 60) {
            list.add("AME_ABL_INFO_USER");
            flipped |= 60;
        }
        if ((o & 61) == 61) {
            list.add("AME_ABL_INFO_VER");
            flipped |= 61;
        }
        if ((o & 62) == 62) {
            list.add("NAVI_GET_APP_VERSION");
            flipped |= 62;
        }
        if ((o & 63) == 63) {
            list.add("NAVI_GET_MAP_VERSION");
            flipped |= 63;
        }
        if ((o & 64) == 64) {
            list.add("NAVI_SET_DEMO_START");
            flipped |= 64;
        }
        if ((o & 65) == 65) {
            list.add("NAVI_SET_DEMO_STOP");
            flipped |= 65;
        }
        if ((o & 66) == 66) {
            list.add("HMI_SWITCH_HOME_SCREEN");
            flipped |= 66;
        }
        if ((o & 67) == 67) {
            list.add("TBOX_AUDIO_PLAY");
            flipped |= 67;
        }
        if ((o & 68) == 68) {
            list.add("AVM_CAMERA_CLOSE");
            flipped |= 68;
        }
        if ((o & 69) == 69) {
            list.add("AVM_CAMERA_RVC");
            flipped |= 69;
        }
        if ((o & 70) == 70) {
            list.add("AVM_CAMERA_FRONT");
            flipped |= 70;
        }
        if ((o & 71) == 71) {
            list.add("AVM_CAMERA_REAR");
            flipped |= 71;
        }
        if ((o & 72) == 72) {
            list.add("AVM_CARMER_LEFT");
            flipped |= 72;
        }
        if ((o & 73) == 73) {
            list.add("AVM_CAMERA_RIGHT");
            flipped |= 73;
        }
        if ((o & 74) == 74) {
            list.add("AVM_CAMERA_ALL_SURROUND");
            flipped |= 74;
        }
        if ((o & 75) == 75) {
            list.add("ETHERNET_GET_MAC_ADDRESS");
            flipped |= 75;
        }
        if ((o & 76) == 76) {
            list.add("ETHERNET_PING_1");
            flipped |= 76;
        }
        if ((o & 77) == 77) {
            list.add("ETHERNET_PING_2");
            flipped |= 77;
        }
        if ((o & 78) == 78) {
            list.add("ETHERNET_PING_3");
            flipped |= 78;
        }
        if ((o & 79) == 79) {
            list.add("GPS_GET_SATELLITE_INFO");
            flipped |= 79;
        }
        if ((o & 80) == 80) {
            list.add("AME_RESET_TO_FACTORY");
            flipped |= 80;
        }
        if ((o & 81) == 81) {
            list.add("AME_RESET_TO_FACTORY_ALL");
            flipped |= 81;
        }
        if ((o & 82) == 82) {
            list.add("AME_RESET_TO_FACTORY_EXCE_NAVI");
            flipped |= 82;
        }
        if ((o & 83) == 83) {
            list.add("AME_INOUTPUT_ON_OFF");
            flipped |= 83;
        }
        if ((o & 84) == 84) {
            list.add("AME_INOUTPUT_FACELED_ON");
            flipped |= 84;
        }
        if ((o & 85) == 85) {
            list.add("AME_INOUTPUT_FACELED_OFF");
            flipped |= 85;
        }
        if ((o & 86) == 86) {
            list.add("AME_INOUTPUT_CCPLED_ON");
            flipped |= 86;
        }
        if ((o & 87) == 87) {
            list.add("AME_INOUTPUT_CCPLED_OFF");
            flipped |= 87;
        }
        if ((o & 88) == 88) {
            list.add("AME_INOUTPUT_FRT_DISP_ON");
            flipped |= 88;
        }
        if ((o & 89) == 89) {
            list.add("AME_INOUTPUT_FRT_DISP_OFF");
            flipped |= 89;
        }
        if ((o & 90) == 90) {
            list.add("AME_INOUTPUT_RL_DISP_ON");
            flipped |= 90;
        }
        if ((o & 91) == 91) {
            list.add("AME_INOUTPUT_RL_DISP_OFF");
            flipped |= 91;
        }
        if ((o & 92) == 92) {
            list.add("AME_INOUTPUT_RR_DISP_ON");
            flipped |= 92;
        }
        if ((o & 93) == 93) {
            list.add("AME_INOUTPUT_RR_DISP_OFF");
            flipped |= 93;
        }
        if ((o & 94) == 94) {
            list.add("AME_SKIP_WELCOME_SCREEN");
            flipped |= 94;
        }
        if ((o & 95) == 95) {
            list.add("AME_SET_HMI_LANG");
            flipped |= 95;
        }
        if ((o & 96) == 96) {
            list.add("AME_SET_HMI_LANG_DEFAULT");
            flipped |= 96;
        }
        if ((o & 97) == 97) {
            list.add("AME_SET_HMI_LANG_ENG");
            flipped |= 97;
        }
        if ((o & 98) == 98) {
            list.add("AME_SET_HMI_LANG_CHN");
            flipped |= 98;
        }
        if ((o & 99) == 99) {
            list.add("AME_SET_HMI_LANG_KOR");
            flipped |= 99;
        }
        if ((o & 100) == 100) {
            list.add("AME_SET_HMI_LANG_JPN");
            flipped |= 100;
        }
        if ((o & 101) == 101) {
            list.add("AME_SET_MUTE_UNMUTE");
            flipped |= 101;
        }
        if ((o & 102) == 102) {
            list.add("AME_SET_MUTE");
            flipped |= 102;
        }
        if ((o & 103) == 103) {
            list.add("AME_SET_UNMUTE");
            flipped |= 103;
        }
        if ((o & 104) == 104) {
            list.add("AME_SEL_SPEAKER_ZONE");
            flipped |= 104;
        }
        if ((o & 105) == 105) {
            list.add("AME_SEL_SPEAKER_ZONE_ALL");
            flipped |= 105;
        }
        if ((o & 106) == 106) {
            list.add("AME_SEL_SPEAKER_ZONE_FL");
            flipped |= 106;
        }
        if ((o & 107) == 107) {
            list.add("AME_SEL_SPEAKER_ZONE_FR");
            flipped |= 107;
        }
        if ((o & 108) == 108) {
            list.add("AME_SEL_SPEAKER_ZONE_RL");
            flipped |= 108;
        }
        if ((o & 109) == 109) {
            list.add("AME_SEL_SPEAKER_ZONE_RR");
            flipped |= 109;
        }
        if ((o & 110) == 110) {
            list.add("AME_SEL_SPEAKER_ZONE_CENTER");
            flipped |= 110;
        }
        if ((o & 111) == 111) {
            list.add("AME_SEL_SPEAKER_ZONE_SW1");
            flipped |= 111;
        }
        if ((o & 112) == 112) {
            list.add("AME_SEL_SPEAKER_ZONE_SW2");
            flipped |= 112;
        }
        if ((o & 113) == 113) {
            list.add("AME_SEL_SPEAKER_ZONE_STOP");
            flipped |= 113;
        }
        if ((o & 114) == 114) {
            list.add("AME_ROUTE_MIC_TO_INTE_SPEAKER");
            flipped |= 114;
        }
        if ((o & 115) == 115) {
            list.add("AME_DISP_COLOR_BAR");
            flipped |= 115;
        }
        if ((o & 116) == 116) {
            list.add("AME_DISP_COLOR_BAR_WHITE");
            flipped |= 116;
        }
        if ((o & 117) == 117) {
            list.add("AME_DISP_COLOR_BAR_BLACK");
            flipped |= 117;
        }
        if ((o & 118) == 118) {
            list.add("AME_DISP_COLOR_BAR_RGB");
            flipped |= 118;
        }
        if ((o & AME_MEDIA_SWTH_SRC) == 119) {
            list.add("AME_MEDIA_SWTH_SRC");
            flipped |= AME_MEDIA_SWTH_SRC;
        }
        if ((o & 120) == 120) {
            list.add("AME_MEDIA_OPERATION");
            flipped |= 120;
        }
        if ((o & AME_BT_HEANDFREE_LB_TEST) == 121) {
            list.add("AME_BT_HEANDFREE_LB_TEST");
            flipped |= AME_BT_HEANDFREE_LB_TEST;
        }
        if ((o & AME_ETHERNET_IP_PING) == 122) {
            list.add("AME_ETHERNET_IP_PING");
            flipped |= AME_ETHERNET_IP_PING;
        }
        if ((o & AME_TBOX_COMM_STATUS_CHECK) == 123) {
            list.add("AME_TBOX_COMM_STATUS_CHECK");
            flipped |= AME_TBOX_COMM_STATUS_CHECK;
        }
        if ((o & AME_READ_HU_STATUS) == 124) {
            list.add("AME_READ_HU_STATUS");
            flipped |= AME_READ_HU_STATUS;
        }
        if ((o & AME_READ_HU_STATUS_USB1) == 125) {
            list.add("AME_READ_HU_STATUS_USB1");
            flipped |= AME_READ_HU_STATUS_USB1;
        }
        if ((o & 126) == 126) {
            list.add("AME_READ_HU_STATUS_USB2");
            flipped |= 126;
        }
        if ((o & 127) == 127) {
            list.add("AME_READ_HU_STATUS_FMAM");
            flipped |= 127;
        }
        if ((o & 128) == 128) {
            list.add("AME_READ_HU_STATUS_FM");
            flipped |= 128;
        }
        if ((o & 129) == 129) {
            list.add("AME_READ_HU_STATUS_AM");
            flipped |= 129;
        }
        if ((o & 130) == 130) {
            list.add("AME_READ_HU_STATUS_GPS");
            flipped |= 130;
        }
        if ((o & 131) == 131) {
            list.add("AME_READ_HU_STATUS_CAMERA_LT");
            flipped |= 131;
        }
        if ((o & 132) == 132) {
            list.add("AME_READ_HU_STATUS_CAMERA_RT");
            flipped |= 132;
        }
        if ((o & 133) == 133) {
            list.add("AME_READ_HU_STATUS_CAMERA_FRT");
            flipped |= 133;
        }
        if ((o & 134) == 134) {
            list.add("AME_READ_HU_STATUS_CAMERA_REAR");
            flipped |= 134;
        }
        if ((o & 135) == 135) {
            list.add("AME_READ_HU_STATUS_DISP_FRT");
            flipped |= 135;
        }
        if ((o & 136) == 136) {
            list.add("AME_READ_HU_STATUS_DISP_REAR");
            flipped |= 136;
        }
        if ((o & 137) == 137) {
            list.add("AME_WIFI_SSI");
            flipped |= 137;
        }
        if ((o & 138) == 138) {
            list.add("AME_ETHERNET_SQI");
            flipped |= 138;
        }
        if ((o & 139) == 139) {
            list.add("AME_ETHERNET_SQI_PORT0");
            flipped |= 139;
        }
        if ((o & 140) == 140) {
            list.add("AME_ETHERNET_SQI_PORT1");
            flipped |= 140;
        }
        if ((o & 141) == 141) {
            list.add("AME_ETHERNET_SQI_PORT2");
            flipped |= 141;
        }
        if ((o & 142) == 142) {
            list.add("AME_USB_OTG_SET_MODE");
            flipped |= 142;
        }
        if ((o & 143) == 143) {
            list.add("AME_USB_OTG_SET_MODE_HOST");
            flipped |= 143;
        }
        if ((o & 144) == 144) {
            list.add("AME_USB_OTG_SET_MODE_DEVICE");
            flipped |= 144;
        }
        if ((o & 145) == 145) {
            list.add("AME_GPS_GET_LONLAT");
            flipped |= 145;
        }
        if ((o & 146) == 146) {
            list.add("AME_GPS_GET_LONG");
            flipped |= 146;
        }
        if ((o & 147) == 147) {
            list.add("AME_GPS_GET_LATI");
            flipped |= 147;
        }
        if ((o & 148) == 148) {
            list.add("AME_CHECK_CONNECTION_STATUS_BT");
            flipped |= 148;
        }
        if ((o & 149) == 149) {
            list.add("AME_CHECK_CONNECTION_STATUS_WIFI");
            flipped |= 149;
        }
        if ((o & 150) == 150) {
            list.add("AME_CHECK_CONNECTION_STATUS_ETH_PORT0");
            flipped |= 150;
        }
        if ((o & 151) == 151) {
            list.add("AME_CHECK_CONNECTION_STATUS_ETH_PORT1");
            flipped |= 151;
        }
        if ((o & 152) == 152) {
            list.add("AME_CHECK_CONNECTION_STATUS_ETH_PORT2");
            flipped |= 152;
        }
        if ((o & AME_ADB_ENABLE) == 153) {
            list.add("AME_ADB_ENABLE");
            flipped |= AME_ADB_ENABLE;
        }
        if ((o & AME_ADB_DISABLE) == 154) {
            list.add("AME_ADB_DISABLE");
            flipped |= AME_ADB_DISABLE;
        }
        if ((o & AME_USB1_ETHNET_ENABLE) == 155) {
            list.add("AME_USB1_ETHNET_ENABLE");
            flipped |= AME_USB1_ETHNET_ENABLE;
        }
        if ((o & AME_USB1_ETHNET_DISABLE) == 156) {
            list.add("AME_USB1_ETHNET_DISABLE");
            flipped |= AME_USB1_ETHNET_DISABLE;
        }
        if ((o & AME_USB2_ETHNET_ENABLE) == 157) {
            list.add("AME_USB2_ETHNET_ENABLE");
            flipped |= AME_USB2_ETHNET_ENABLE;
        }
        if ((o & AME_USB2_ETHNET_DISABLE) == 158) {
            list.add("AME_USB2_ETHNET_DISABLE");
            flipped |= AME_USB2_ETHNET_DISABLE;
        }
        if ((o & AME_USB_COPY_DATA_LOG) == 159) {
            list.add("AME_USB_COPY_DATA_LOG");
            flipped |= AME_USB_COPY_DATA_LOG;
        }
        if ((o & 160) == 160) {
            list.add("AME_SET_DISPLAY_BRIGHTNESS");
            flipped |= 160;
        }
        if ((o & AME_GET_SYSTEM_RTC_TIME) == 161) {
            list.add("AME_GET_SYSTEM_RTC_TIME");
            flipped |= AME_GET_SYSTEM_RTC_TIME;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_) == 4352) {
            list.add("EM_OEM_DIAG_CMD_DTC_");
            flipped |= EM_OEM_DIAG_CMD_DTC_;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM) == 4353) {
            list.add("EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM");
            flipped |= EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_IPC_INIT_FAIL) == 4354) {
            list.add("EM_OEM_DIAG_CMD_DTC_IPC_INIT_FAIL");
            flipped |= EM_OEM_DIAG_CMD_DTC_IPC_INIT_FAIL;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_MISS_CAMERA_MOD) == 4355) {
            list.add("EM_OEM_DIAG_CMD_DTC_MISS_CAMERA_MOD");
            flipped |= EM_OEM_DIAG_CMD_DTC_MISS_CAMERA_MOD;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_LOST_COMM_HL_DIS_FRT) == 4356) {
            list.add("EM_OEM_DIAG_CMD_DTC_LOST_COMM_HL_DIS_FRT");
            flipped |= EM_OEM_DIAG_CMD_DTC_LOST_COMM_HL_DIS_FRT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_WIFI_MOD_INIT_FAIL) == 4357) {
            list.add("EM_OEM_DIAG_CMD_DTC_WIFI_MOD_INIT_FAIL");
            flipped |= EM_OEM_DIAG_CMD_DTC_WIFI_MOD_INIT_FAIL;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_USB_INIT_FAIL) == 4358) {
            list.add("EM_OEM_DIAG_CMD_DTC_USB_INIT_FAIL");
            flipped |= EM_OEM_DIAG_CMD_DTC_USB_INIT_FAIL;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_TBOX_LOST_COMM_SATE) == 4359) {
            list.add("EM_OEM_DIAG_CMD_DTC_TBOX_LOST_COMM_SATE");
            flipped |= EM_OEM_DIAG_CMD_DTC_TBOX_LOST_COMM_SATE;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_GND) == 4360) {
            list.add("EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_GND");
            flipped |= EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_GND;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_BAT) == 4361) {
            list.add("EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_GPS_ANTE_SHORT_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_GPS_ANTE_OPEN) == 4362) {
            list.add("EM_OEM_DIAG_CMD_DTC_GPS_ANTE_OPEN");
            flipped |= EM_OEM_DIAG_CMD_DTC_GPS_ANTE_OPEN;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_USB_1_VBUS_SHORT_GND_BAT) == 4363) {
            list.add("EM_OEM_DIAG_CMD_DTC_USB_1_VBUS_SHORT_GND_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_USB_1_VBUS_SHORT_GND_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_USB_1_DLINE_SHORT_VBUS_BAT) == 4364) {
            list.add("EM_OEM_DIAG_CMD_DTC_USB_1_DLINE_SHORT_VBUS_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_USB_1_DLINE_SHORT_VBUS_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_USB_2_VBUS_SHORT_GND_BAT) == 4365) {
            list.add("EM_OEM_DIAG_CMD_DTC_USB_2_VBUS_SHORT_GND_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_USB_2_VBUS_SHORT_GND_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_USB_2_DLINE_SHORT_VBUS_BAT) == 4366) {
            list.add("EM_OEM_DIAG_CMD_DTC_USB_2_DLINE_SHORT_VBUS_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_USB_2_DLINE_SHORT_VBUS_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_MISS_FRT_CAMERA) == 4367) {
            list.add("EM_OEM_DIAG_CMD_DTC_MISS_FRT_CAMERA");
            flipped |= EM_OEM_DIAG_CMD_DTC_MISS_FRT_CAMERA;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_MISS_REAR_CAMERA) == 4368) {
            list.add("EM_OEM_DIAG_CMD_DTC_MISS_REAR_CAMERA");
            flipped |= EM_OEM_DIAG_CMD_DTC_MISS_REAR_CAMERA;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_MISS_LFT_CAMERA) == 4369) {
            list.add("EM_OEM_DIAG_CMD_DTC_MISS_LFT_CAMERA");
            flipped |= EM_OEM_DIAG_CMD_DTC_MISS_LFT_CAMERA;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_MISS_RGT_CAMERA) == 4370) {
            list.add("EM_OEM_DIAG_CMD_DTC_MISS_RGT_CAMERA");
            flipped |= EM_OEM_DIAG_CMD_DTC_MISS_RGT_CAMERA;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_GND) == 4371) {
            list.add("EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_GND");
            flipped |= EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_GND;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_BAT) == 4372) {
            list.add("EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_BAT");
            flipped |= EM_OEM_DIAG_CMD_DTC_FMAM_ANT_SHORT_BAT;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_FMAM_ANT_OPEN) == 4373) {
            list.add("EM_OEM_DIAG_CMD_DTC_FMAM_ANT_OPEN");
            flipped |= EM_OEM_DIAG_CMD_DTC_FMAM_ANT_OPEN;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM_TBOX) == 4374) {
            list.add("EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM_TBOX");
            flipped |= EM_OEM_DIAG_CMD_DTC_LOST_ETH_COMM_TBOX;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_POWER_FAIL) == 4375) {
            list.add("EM_OEM_DIAG_CMD_DTC_POWER_FAIL");
            flipped |= EM_OEM_DIAG_CMD_DTC_POWER_FAIL;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_CAMERA_CTRL_MOD_INIT_FAIL) == 4376) {
            list.add("EM_OEM_DIAG_CMD_DTC_CAMERA_CTRL_MOD_INIT_FAIL");
            flipped |= EM_OEM_DIAG_CMD_DTC_CAMERA_CTRL_MOD_INIT_FAIL;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_INSU_SQI) == 4377) {
            list.add("EM_OEM_DIAG_CMD_DTC_INSU_SQI");
            flipped |= EM_OEM_DIAG_CMD_DTC_INSU_SQI;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_CRC_ERR) == 4378) {
            list.add("EM_OEM_DIAG_CMD_DTC_CRC_ERR");
            flipped |= EM_OEM_DIAG_CMD_DTC_CRC_ERR;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_UNEXC_LINK_LOSS) == 4379) {
            list.add("EM_OEM_DIAG_CMD_DTC_UNEXC_LINK_LOSS");
            flipped |= EM_OEM_DIAG_CMD_DTC_UNEXC_LINK_LOSS;
        }
        if ((o & EM_OEM_DIAG_CMD_DTC_END) == 4380) {
            list.add("EM_OEM_DIAG_CMD_DTC_END");
            flipped |= EM_OEM_DIAG_CMD_DTC_END;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_) == 4608) {
            list.add("EM_OEM_DIAG_CMD_RDBI_");
            flipped |= EM_OEM_DIAG_CMD_RDBI_;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_ERR_MSG_CNT) == 4609) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_ERR_MSG_CNT");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_ERR_MSG_CNT;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_LK_LST_NUM) == 4610) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_LK_LST_NUM");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_LK_LST_NUM;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_SLSC_NUM) == 4611) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_SLSC_NUM");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_SLSC_NUM;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_LCE_NUM) == 4612) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_LCE_NUM");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_LCE_NUM;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_NOSNUM_PHY) == 4613) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_NOSNUM_PHY");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_NOSNUM_PHY;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_CTRL_MODE) == 4614) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_CTRL_MODE");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_CTRL_MODE;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MODE_STATUS) == 4615) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MODE_STATUS");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MODE_STATUS;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS) == 4616) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT0) == 4617) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT0");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT0;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT1) == 4618) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT1");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT1;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT2) == 4619) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT2");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_TEST_MODE_STATUS_PORT2;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_PHY_INDENT_NUM) == 4620) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_PHY_INDENT_NUM");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_PHY_INDENT_NUM;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_GET_LINK_STATUS_DETE) == 4621) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_GET_LINK_STATUS_DETE");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_GET_LINK_STATUS_DETE;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_100_T1) == 4622) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_100_T1");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_100_T1;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_1000_T1) == 4623) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_1000_T1");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_SQI_THRE_1000_T1;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_SQI) == 4624) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_SQI");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_SQI;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_TRANS_PACKET) == 4625) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_TRANS_PACKET");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_TRANS_PACKET;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_RECV_PACKET) == 4626) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_RECV_PACKET");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_RECV_PACKET;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_SWTCH_CNTER) == 4627) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_SWTCH_CNTER");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_SWTCH_CNTER;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MAC_ADDR) == 4628) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MAC_ADDR");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MAC_ADDR;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_PRES_GPS_COOR) == 4629) {
            list.add("EM_OEM_DIAG_CMD_RDBI_PRES_GPS_COOR");
            flipped |= EM_OEM_DIAG_CMD_RDBI_PRES_GPS_COOR;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_BT_CURR_DISC_MODE) == 4630) {
            list.add("EM_OEM_DIAG_CMD_RDBI_BT_CURR_DISC_MODE");
            flipped |= EM_OEM_DIAG_CMD_RDBI_BT_CURR_DISC_MODE;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_BT_STATUS) == 4631) {
            list.add("EM_OEM_DIAG_CMD_RDBI_BT_STATUS");
            flipped |= EM_OEM_DIAG_CMD_RDBI_BT_STATUS;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_BT_POWER_CLS) == 4632) {
            list.add("EM_OEM_DIAG_CMD_RDBI_BT_POWER_CLS");
            flipped |= EM_OEM_DIAG_CMD_RDBI_BT_POWER_CLS;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_BT_ACTVIE_PROF_LIST) == 4633) {
            list.add("EM_OEM_DIAG_CMD_RDBI_BT_ACTVIE_PROF_LIST");
            flipped |= EM_OEM_DIAG_CMD_RDBI_BT_ACTVIE_PROF_LIST;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_BT_FW_VERSION) == 4634) {
            list.add("EM_OEM_DIAG_CMD_RDBI_BT_FW_VERSION");
            flipped |= EM_OEM_DIAG_CMD_RDBI_BT_FW_VERSION;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_NUM_OF_USB) == 4635) {
            list.add("EM_OEM_DIAG_CMD_RDBI_NUM_OF_USB");
            flipped |= EM_OEM_DIAG_CMD_RDBI_NUM_OF_USB;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_CURR_CONN_USB_TYPE) == 4636) {
            list.add("EM_OEM_DIAG_CMD_RDBI_CURR_CONN_USB_TYPE");
            flipped |= EM_OEM_DIAG_CMD_RDBI_CURR_CONN_USB_TYPE;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_AM_SIGNAL_STRENGTH) == 4637) {
            list.add("EM_OEM_DIAG_CMD_RDBI_AM_SIGNAL_STRENGTH");
            flipped |= EM_OEM_DIAG_CMD_RDBI_AM_SIGNAL_STRENGTH;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_FM_SIGNAL_STRENGTH) == 4638) {
            list.add("EM_OEM_DIAG_CMD_RDBI_FM_SIGNAL_STRENGTH");
            flipped |= EM_OEM_DIAG_CMD_RDBI_FM_SIGNAL_STRENGTH;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_STATUS) == 4639) {
            list.add("EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_STATUS");
            flipped |= EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_STATUS;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_FW_VERSION) == 4640) {
            list.add("EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_FW_VERSION");
            flipped |= EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_FW_VERSION;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_HW_PART_NUM) == 4641) {
            list.add("EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_HW_PART_NUM");
            flipped |= EM_OEM_DIAG_CMD_RDBI_WIFI_MOD_HW_PART_NUM;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_TBOX_GW_SUB_MASK) == 4642) {
            list.add("EM_OEM_DIAG_CMD_RDBI_TBOX_GW_SUB_MASK");
            flipped |= EM_OEM_DIAG_CMD_RDBI_TBOX_GW_SUB_MASK;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_TBOX_LAST_COMM_LOST_TMSP) == 4643) {
            list.add("EM_OEM_DIAG_CMD_RDBI_TBOX_LAST_COMM_LOST_TMSP");
            flipped |= EM_OEM_DIAG_CMD_RDBI_TBOX_LAST_COMM_LOST_TMSP;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_TBOX_GEO_COOR_CONN_LOST) == 4644) {
            list.add("EM_OEM_DIAG_CMD_RDBI_TBOX_GEO_COOR_CONN_LOST");
            flipped |= EM_OEM_DIAG_CMD_RDBI_TBOX_GEO_COOR_CONN_LOST;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_END) == 4645) {
            list.add("EM_OEM_DIAG_CMD_RDBI_END");
            flipped |= EM_OEM_DIAG_CMD_RDBI_END;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_) == 4864) {
            list.add("EM_OEM_DIAG_CMD_WDBI_");
            flipped |= EM_OEM_DIAG_CMD_WDBI_;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET) == 4865) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT0) == 4866) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT0");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT0;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT1) == 4867) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT1");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT1;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT2) == 4868) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT2");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_MASTER_SLAVE_SET_PORT2;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET) == 4869) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT0) == 4870) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT0");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT0;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT1) == 4871) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT1");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT1;
        }
        if ((o & EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT2) == 4872) {
            list.add("EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT2");
            flipped |= EM_OEM_DIAG_CMD_RDBI_ETH_MASTER_SLAVE_GET_PORT2;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_SQI_100_T1) == 4873) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_SQI_100_T1");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_SQI_100_T1;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_ETH_SQI_1000_T1) == 4874) {
            list.add("EM_OEM_DIAG_CMD_WDBI_ETH_SQI_1000_T1");
            flipped |= EM_OEM_DIAG_CMD_WDBI_ETH_SQI_1000_T1;
        }
        if ((o & EM_OEM_DIAG_CMD_WDBI_END) == 4875) {
            list.add("EM_OEM_DIAG_CMD_WDBI_END");
            flipped |= EM_OEM_DIAG_CMD_WDBI_END;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_) == 5120) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_PHY_STA) == 5121) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_PHY_STA");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_PHY_STA;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE) == 5122) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT0) == 5123) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT0");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT0;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT1) == 5124) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT1");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT1;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT2) == 5125) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT2");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_TEST_MODE_PORT2;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG) == 5126) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT0) == 5127) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT0");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT0;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT1) == 5128) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT1");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT1;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT2) == 5129) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT2");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_CABLE_DIAG_PORT2;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_SWTCH_STATI) == 5130) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_SWTCH_STATI");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_ETH_RESET_SWTCH_STATI;
        }
        if ((o & EM_OEM_DIAG_CMD_RTCTRL_END) == 5131) {
            list.add("EM_OEM_DIAG_CMD_RTCTRL_END");
            flipped |= EM_OEM_DIAG_CMD_RTCTRL_END;
        }
        if ((o & OEM_DTC_LOST_ETH_COMM) == 5376) {
            list.add("OEM_DTC_LOST_ETH_COMM");
            flipped |= OEM_DTC_LOST_ETH_COMM;
        }
        if ((o & OEM_DTC_LOST_HL_DISP_FRONT) == 5377) {
            list.add("OEM_DTC_LOST_HL_DISP_FRONT");
            flipped |= OEM_DTC_LOST_HL_DISP_FRONT;
        }
        if ((o & OEM_DTC_LOST_TBOX_COMM_SATE) == 5378) {
            list.add("OEM_DTC_LOST_TBOX_COMM_SATE");
            flipped |= OEM_DTC_LOST_TBOX_COMM_SATE;
        }
        if ((o & OEM_DTC_GPS_ANT_SHRT_GND) == 5379) {
            list.add("OEM_DTC_GPS_ANT_SHRT_GND");
            flipped |= OEM_DTC_GPS_ANT_SHRT_GND;
        }
        if ((o & OEM_DTC_GPS_ANT_SHRT_BAT) == 5380) {
            list.add("OEM_DTC_GPS_ANT_SHRT_BAT");
            flipped |= OEM_DTC_GPS_ANT_SHRT_BAT;
        }
        if ((o & OEM_DTC_GPS_ANT_OPEN) == 5381) {
            list.add("OEM_DTC_GPS_ANT_OPEN");
            flipped |= OEM_DTC_GPS_ANT_OPEN;
        }
        if ((o & OEM_RDBI_ETHERNET_PHY_ID_NUMBER) == 5382) {
            list.add("OEM_RDBI_ETHERNET_PHY_ID_NUMBER");
            flipped |= OEM_RDBI_ETHERNET_PHY_ID_NUMBER;
        }
        if ((o & OEM_RDBI_ETHERNET_GET_LINK_STATES) == 5383) {
            list.add("OEM_RDBI_ETHERNET_GET_LINK_STATES");
            flipped |= OEM_RDBI_ETHERNET_GET_LINK_STATES;
        }
        if ((o & OEM_RDBI_ETHERNET_SQI_THRE_100BASE_T1) == 5384) {
            list.add("OEM_RDBI_ETHERNET_SQI_THRE_100BASE_T1");
            flipped |= OEM_RDBI_ETHERNET_SQI_THRE_100BASE_T1;
        }
        if ((o & OEM_RDBI_ETHERNET_SQI_THRE_1000BASE_T1) == 5385) {
            list.add("OEM_RDBI_ETHERNET_SQI_THRE_1000BASE_T1");
            flipped |= OEM_RDBI_ETHERNET_SQI_THRE_1000BASE_T1;
        }
        if ((o & OEM_RDBI_ETHERNET_SQI) == 5386) {
            list.add("OEM_RDBI_ETHERNET_SQI");
            flipped |= OEM_RDBI_ETHERNET_SQI;
        }
        if ((o & OEM_RDBI_ETHERNET_TRANS_PACK) == 5387) {
            list.add("OEM_RDBI_ETHERNET_TRANS_PACK");
            flipped |= OEM_RDBI_ETHERNET_TRANS_PACK;
        }
        if ((o & OEM_RDBI_ETHERNET_RCV_PACK) == 5388) {
            list.add("OEM_RDBI_ETHERNET_RCV_PACK");
            flipped |= OEM_RDBI_ETHERNET_RCV_PACK;
        }
        if ((o & OEM_RDBI_ETHERNET_SWCH_COUNTER) == 5389) {
            list.add("OEM_RDBI_ETHERNET_SWCH_COUNTER");
            flipped |= OEM_RDBI_ETHERNET_SWCH_COUNTER;
        }
        if ((o & OEM_RDBI_ETHERNET_MAC_ADDR) == 5390) {
            list.add("OEM_RDBI_ETHERNET_MAC_ADDR");
            flipped |= OEM_RDBI_ETHERNET_MAC_ADDR;
        }
        if ((o & OEM_WDBI_ETHERNET_SQI_THRE_100BASE_T1) == 5391) {
            list.add("OEM_WDBI_ETHERNET_SQI_THRE_100BASE_T1");
            flipped |= OEM_WDBI_ETHERNET_SQI_THRE_100BASE_T1;
        }
        if ((o & OEM_WDBI_ETHERNET_SQI_THRE_1000BASE_T1) == 5392) {
            list.add("OEM_WDBI_ETHERNET_SQI_THRE_1000BASE_T1");
            flipped |= OEM_WDBI_ETHERNET_SQI_THRE_1000BASE_T1;
        }
        if ((o & OEM_RDBI_GPS_SHIFT_DATA) == 5393) {
            list.add("OEM_RDBI_GPS_SHIFT_DATA");
            flipped |= OEM_RDBI_GPS_SHIFT_DATA;
        }
        if ((o & OEM_RDBI_BT_CURR_DISC_MODE) == 5394) {
            list.add("OEM_RDBI_BT_CURR_DISC_MODE");
            flipped |= OEM_RDBI_BT_CURR_DISC_MODE;
        }
        if ((o & OEM_RDBI_BT_STATUS) == 5395) {
            list.add("OEM_RDBI_BT_STATUS");
            flipped |= OEM_RDBI_BT_STATUS;
        }
        if ((o & OEM_RDBI_BT_ACT_PROF_LIST) == 5396) {
            list.add("OEM_RDBI_BT_ACT_PROF_LIST");
            flipped |= OEM_RDBI_BT_ACT_PROF_LIST;
        }
        if ((o & OEM_RDBI_BT_FIRMWARE_VERSION) == 5397) {
            list.add("OEM_RDBI_BT_FIRMWARE_VERSION");
            flipped |= OEM_RDBI_BT_FIRMWARE_VERSION;
        }
        if ((o & OEM_RDBI_USB_EXTER_DEVIC_NUMBER) == 5398) {
            list.add("OEM_RDBI_USB_EXTER_DEVIC_NUMBER");
            flipped |= OEM_RDBI_USB_EXTER_DEVIC_NUMBER;
        }
        if ((o & OEM_RDBI_USB_CURRENT_TYPE) == 5399) {
            list.add("OEM_RDBI_USB_CURRENT_TYPE");
            flipped |= OEM_RDBI_USB_CURRENT_TYPE;
        }
        if ((o & OEM_RDBI_TUNER_AM_SIGNAL_STRANGTH) == 5400) {
            list.add("OEM_RDBI_TUNER_AM_SIGNAL_STRANGTH");
            flipped |= OEM_RDBI_TUNER_AM_SIGNAL_STRANGTH;
        }
        if ((o & OEM_RDBI_TUNER_FM_SIGNAL_STRANGTH) == 5401) {
            list.add("OEM_RDBI_TUNER_FM_SIGNAL_STRANGTH");
            flipped |= OEM_RDBI_TUNER_FM_SIGNAL_STRANGTH;
        }
        if ((o & OEM_RDBI_WIFI_MODULE_STATUS) == 5402) {
            list.add("OEM_RDBI_WIFI_MODULE_STATUS");
            flipped |= OEM_RDBI_WIFI_MODULE_STATUS;
        }
        if ((o & OEM_RDBI_WIFI_MODULE_FIRMWARE_VERSION) == 5403) {
            list.add("OEM_RDBI_WIFI_MODULE_FIRMWARE_VERSION");
            flipped |= OEM_RDBI_WIFI_MODULE_FIRMWARE_VERSION;
        }
        if ((o & OEM_RDBI_WIFI_MODULE_HW_PART_NUM) == 5404) {
            list.add("OEM_RDBI_WIFI_MODULE_HW_PART_NUM");
            flipped |= OEM_RDBI_WIFI_MODULE_HW_PART_NUM;
        }
        if ((o & OEM_RDBI_TBOX_IP_ADDRESS) == 5405) {
            list.add("OEM_RDBI_TBOX_IP_ADDRESS");
            flipped |= OEM_RDBI_TBOX_IP_ADDRESS;
        }
        if ((o & OEM_RDBI_TBOX_GW_SUB_MASK) == 5406) {
            list.add("OEM_RDBI_TBOX_GW_SUB_MASK");
            flipped |= OEM_RDBI_TBOX_GW_SUB_MASK;
        }
        if ((o & OEM_RDBI_TBOX_LAST_CONN_LOST_TM_STAMP) == 5407) {
            list.add("OEM_RDBI_TBOX_LAST_CONN_LOST_TM_STAMP");
            flipped |= OEM_RDBI_TBOX_LAST_CONN_LOST_TM_STAMP;
        }
        if ((o & OEM_RDBI_TBOX_GEOG_COOR_CONN_LOST) == 5408) {
            list.add("OEM_RDBI_TBOX_GEOG_COOR_CONN_LOST");
            flipped |= OEM_RDBI_TBOX_GEOG_COOR_CONN_LOST;
        }
        if ((o & OEM_RDBI_TBOX_MODULE_STATUS) == 5409) {
            list.add("OEM_RDBI_TBOX_MODULE_STATUS");
            flipped |= OEM_RDBI_TBOX_MODULE_STATUS;
        }
        if ((o & OEM_ROUT_CTRL_RESET_PHY_STATI) == 5410) {
            list.add("OEM_ROUT_CTRL_RESET_PHY_STATI");
            flipped |= OEM_ROUT_CTRL_RESET_PHY_STATI;
        }
        if ((o & OEM_ROUT_CTRL_PHY_TEST_MODE) == 5411) {
            list.add("OEM_ROUT_CTRL_PHY_TEST_MODE");
            flipped |= OEM_ROUT_CTRL_PHY_TEST_MODE;
        }
        if ((o & OEM_ROUT_CTRL_CABLE_DIAG) == 5412) {
            list.add("OEM_ROUT_CTRL_CABLE_DIAG");
            flipped |= OEM_ROUT_CTRL_CABLE_DIAG;
        }
        if ((o & OEM_ROUT_CTRL_RESET_SWITCH_STATI) == 5413) {
            list.add("OEM_ROUT_CTRL_RESET_SWITCH_STATI");
            flipped |= OEM_ROUT_CTRL_RESET_SWITCH_STATI;
        }
        if ((o & OEM_PKI_SEND_ROOT_CA_STATUS_TO_HMI) == 5414) {
            list.add("OEM_PKI_SEND_ROOT_CA_STATUS_TO_HMI");
            flipped |= OEM_PKI_SEND_ROOT_CA_STATUS_TO_HMI;
        }
        if ((o & EM_DIAG_DATA_ID_RTCTRL_END) == 5415) {
            list.add("EM_DIAG_DATA_ID_RTCTRL_END");
            flipped |= EM_DIAG_DATA_ID_RTCTRL_END;
        }
        if ((o & OEM_GWM_PKI_HUT_GEN_CSR_FILE) == 5416) {
            list.add("OEM_GWM_PKI_HUT_GEN_CSR_FILE");
            flipped |= OEM_GWM_PKI_HUT_GEN_CSR_FILE;
        }
        if ((o & OEM_GWM_PKI_HUT_DELETE_CSR_FILE) == 5417) {
            list.add("OEM_GWM_PKI_HUT_DELETE_CSR_FILE");
            flipped |= OEM_GWM_PKI_HUT_DELETE_CSR_FILE;
        }
        if ((o & OEM_GWM_PKI_READ_HUT_UIN) == 5418) {
            list.add("OEM_GWM_PKI_READ_HUT_UIN");
            flipped |= OEM_GWM_PKI_READ_HUT_UIN;
        }
        if ((o & OEM_GWM_PKI_READ_HUT_CSR_FILE) == 5419) {
            list.add("OEM_GWM_PKI_READ_HUT_CSR_FILE");
            flipped |= OEM_GWM_PKI_READ_HUT_CSR_FILE;
        }
        if ((o & OEM_GWM_PKI_READ_HUT_CSR_HASH) == 5420) {
            list.add("OEM_GWM_PKI_READ_HUT_CSR_HASH");
            flipped |= OEM_GWM_PKI_READ_HUT_CSR_HASH;
        }
        if ((o & OEM_GWM_PKI_REQUEST_HUT_CERT) == 5421) {
            list.add("OEM_GWM_PKI_REQUEST_HUT_CERT");
            flipped |= OEM_GWM_PKI_REQUEST_HUT_CERT;
        }
        if ((o & OEM_GWM_PKI_READ_HUT_GEN_CSR_FILE_RESULT) == 5422) {
            list.add("OEM_GWM_PKI_READ_HUT_GEN_CSR_FILE_RESULT");
            flipped |= OEM_GWM_PKI_READ_HUT_GEN_CSR_FILE_RESULT;
        }
        if ((o & OEM_GWM_PKI_REQUEST_HUT_CERT_RESULT) == 5423) {
            list.add("OEM_GWM_PKI_REQUEST_HUT_CERT_RESULT");
            flipped |= OEM_GWM_PKI_REQUEST_HUT_CERT_RESULT;
        }
        if ((o & OEM_GWM_PKI_HUT_DELETE_CERT_ACTIVATE_RESULT_FILE) == 5424) {
            list.add("OEM_GWM_PKI_HUT_DELETE_CERT_ACTIVATE_RESULT_FILE");
            flipped |= OEM_GWM_PKI_HUT_DELETE_CERT_ACTIVATE_RESULT_FILE;
        }
        if ((o & OEM_GWM_PKI_HUT_DELETE_CERT_FILE) == 5425) {
            list.add("OEM_GWM_PKI_HUT_DELETE_CERT_FILE");
            flipped |= OEM_GWM_PKI_HUT_DELETE_CERT_FILE;
        }
        if ((o & OEM_GWM_PKI_HUT_SET_USING_TEST_ENVIRONMENT) == 5426) {
            list.add("OEM_GWM_PKI_HUT_SET_USING_TEST_ENVIRONMENT");
            flipped |= OEM_GWM_PKI_HUT_SET_USING_TEST_ENVIRONMENT;
        }
        if ((o & OEM_GWM_PKI_HUT_SET_USING_OFFICIAL_ENVIRONMENT) == 5427) {
            list.add("OEM_GWM_PKI_HUT_SET_USING_OFFICIAL_ENVIRONMENT");
            flipped |= OEM_GWM_PKI_HUT_SET_USING_OFFICIAL_ENVIRONMENT;
        }
        if ((o & OEM_GWM_PKI_HUT_READ_HUT_CERT_SERIAL_NUMBER) == 5428) {
            list.add("OEM_GWM_PKI_HUT_READ_HUT_CERT_SERIAL_NUMBER");
            flipped |= OEM_GWM_PKI_HUT_READ_HUT_CERT_SERIAL_NUMBER;
        }
        if ((o & EM_CAN_GATEWAY_OTA) == 131328) {
            list.add("EM_CAN_GATEWAY_OTA");
            flipped |= EM_CAN_GATEWAY_OTA;
        }
        if ((o & EM_CAN_GATEWAY_OTA_CLUSTER) == 131329) {
            list.add("EM_CAN_GATEWAY_OTA_CLUSTER");
            flipped |= EM_CAN_GATEWAY_OTA_CLUSTER;
        }
        if ((o & EM_ADAS_OEM_CAMERA_DEMARCATE) == 131584) {
            list.add("EM_ADAS_OEM_CAMERA_DEMARCATE");
            flipped |= EM_ADAS_OEM_CAMERA_DEMARCATE;
        }
        if ((o & EM_END) == 131585) {
            list.add("EM_END");
            flipped |= EM_END;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}