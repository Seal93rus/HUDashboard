package vendor.harman.gwm.hardware.diagnostics.V1_0;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Status {
    public static final int NrcAccessDenied = 51;
    public static final int NrcBrakeSwitchNotClosed = 143;
    public static final int NrcBusyRepeatRequest = 33;
    public static final int NrcConditionsNotCorrect = 34;
    public static final int NrcEngineIsNotRunning = 132;
    public static final int NrcEngineIsRunning = 131;
    public static final int NrcEngineRunTimeTooLow = 133;
    public static final int NrcExceedNumOfAttempts = 54;
    public static final int NrcGeneralProgrammingFailure = 114;
    public static final int NrcGeneralReject = 16;
    public static final int NrcInvalidFormat = 19;
    public static final int NrcInvalidKey = 53;
    public static final int NrcNoError = 0;
    public static final int NrcRequestOutOfRange = 49;
    public static final int NrcRequestSequenceError = 36;
    public static final int NrcResponsePending = 120;
    public static final int NrcResponseTooLong = 20;
    public static final int NrcRpmTooHigh = 129;
    public static final int NrcRpmTooLow = 130;
    public static final int NrcServiceNotSupported = 17;
    public static final int NrcServiceNotSupportedInActiveSession = 127;
    public static final int NrcShifterLeverNotInPark = 144;
    public static final int NrcSubfunctionNotSupported = 18;
    public static final int NrcSubfunctionNotSupportedInActiveSession = 126;
    public static final int NrcTemperatureTooHigh = 134;
    public static final int NrcTemperatureTooLow = 135;
    public static final int NrcThrottleSpeedTooHigh = 138;
    public static final int NrcThrottleSpeedTooLow = 139;
    public static final int NrcTimeDelayNotExpired = 55;
    public static final int NrcTorqueConverterClutchLocked = 145;
    public static final int NrcTransferDataSuspended = 113;
    public static final int NrcTransmissionRangeInGears = 141;
    public static final int NrcTransmissionRangeInNeutral = 140;
    public static final int NrcUploadDownloadNotAccepted = 112;
    public static final int NrcVehicleSpeedTooHigh = 136;
    public static final int NrcVehicleSpeedTooLow = 137;
    public static final int NrcVoltageTooHigh = 146;
    public static final int NrcVoltageTooLow = 147;
    public static final int NrcWrongBlockSequenceCounter = 115;

    public static final String toString(int o) {
        if (o == 0) {
            return "NrcNoError";
        }
        if (o == 16) {
            return "NrcGeneralReject";
        }
        if (o == 17) {
            return "NrcServiceNotSupported";
        }
        if (o == 18) {
            return "NrcSubfunctionNotSupported";
        }
        if (o == 19) {
            return "NrcInvalidFormat";
        }
        if (o == 20) {
            return "NrcResponseTooLong";
        }
        if (o == 33) {
            return "NrcBusyRepeatRequest";
        }
        if (o == 34) {
            return "NrcConditionsNotCorrect";
        }
        if (o == 36) {
            return "NrcRequestSequenceError";
        }
        if (o == 49) {
            return "NrcRequestOutOfRange";
        }
        if (o == 51) {
            return "NrcAccessDenied";
        }
        if (o == 53) {
            return "NrcInvalidKey";
        }
        if (o == 54) {
            return "NrcExceedNumOfAttempts";
        }
        if (o == 55) {
            return "NrcTimeDelayNotExpired";
        }
        if (o == 112) {
            return "NrcUploadDownloadNotAccepted";
        }
        if (o == 113) {
            return "NrcTransferDataSuspended";
        }
        if (o == 114) {
            return "NrcGeneralProgrammingFailure";
        }
        if (o == 115) {
            return "NrcWrongBlockSequenceCounter";
        }
        if (o == 120) {
            return "NrcResponsePending";
        }
        if (o == 126) {
            return "NrcSubfunctionNotSupportedInActiveSession";
        }
        if (o == 127) {
            return "NrcServiceNotSupportedInActiveSession";
        }
        if (o == 129) {
            return "NrcRpmTooHigh";
        }
        if (o == 130) {
            return "NrcRpmTooLow";
        }
        if (o == 131) {
            return "NrcEngineIsRunning";
        }
        if (o == 132) {
            return "NrcEngineIsNotRunning";
        }
        if (o == 133) {
            return "NrcEngineRunTimeTooLow";
        }
        if (o == 134) {
            return "NrcTemperatureTooHigh";
        }
        if (o == 135) {
            return "NrcTemperatureTooLow";
        }
        if (o == 136) {
            return "NrcVehicleSpeedTooHigh";
        }
        if (o == 137) {
            return "NrcVehicleSpeedTooLow";
        }
        if (o == 138) {
            return "NrcThrottleSpeedTooHigh";
        }
        if (o == 139) {
            return "NrcThrottleSpeedTooLow";
        }
        if (o == 140) {
            return "NrcTransmissionRangeInNeutral";
        }
        if (o == 141) {
            return "NrcTransmissionRangeInGears";
        }
        if (o == 143) {
            return "NrcBrakeSwitchNotClosed";
        }
        if (o == 144) {
            return "NrcShifterLeverNotInPark";
        }
        if (o == 145) {
            return "NrcTorqueConverterClutchLocked";
        }
        if (o == 146) {
            return "NrcVoltageTooHigh";
        }
        if (o == 147) {
            return "NrcVoltageTooLow";
        }
        return "0x" + Integer.toHexString(o);
    }

    public static final String dumpBitfield(int o) {
        ArrayList<String> list = new ArrayList<>();
        int flipped = 0;
        list.add("NrcNoError");
        if ((o & 16) == 16) {
            list.add("NrcGeneralReject");
            flipped = 0 | 16;
        }
        if ((o & 17) == 17) {
            list.add("NrcServiceNotSupported");
            flipped |= 17;
        }
        if ((o & 18) == 18) {
            list.add("NrcSubfunctionNotSupported");
            flipped |= 18;
        }
        if ((o & 19) == 19) {
            list.add("NrcInvalidFormat");
            flipped |= 19;
        }
        if ((o & 20) == 20) {
            list.add("NrcResponseTooLong");
            flipped |= 20;
        }
        if ((o & 33) == 33) {
            list.add("NrcBusyRepeatRequest");
            flipped |= 33;
        }
        if ((o & 34) == 34) {
            list.add("NrcConditionsNotCorrect");
            flipped |= 34;
        }
        if ((o & 36) == 36) {
            list.add("NrcRequestSequenceError");
            flipped |= 36;
        }
        if ((o & 49) == 49) {
            list.add("NrcRequestOutOfRange");
            flipped |= 49;
        }
        if ((o & 51) == 51) {
            list.add("NrcAccessDenied");
            flipped |= 51;
        }
        if ((o & 53) == 53) {
            list.add("NrcInvalidKey");
            flipped |= 53;
        }
        if ((o & 54) == 54) {
            list.add("NrcExceedNumOfAttempts");
            flipped |= 54;
        }
        if ((o & 55) == 55) {
            list.add("NrcTimeDelayNotExpired");
            flipped |= 55;
        }
        if ((o & 112) == 112) {
            list.add("NrcUploadDownloadNotAccepted");
            flipped |= 112;
        }
        if ((o & 113) == 113) {
            list.add("NrcTransferDataSuspended");
            flipped |= 113;
        }
        if ((o & 114) == 114) {
            list.add("NrcGeneralProgrammingFailure");
            flipped |= 114;
        }
        if ((o & 115) == 115) {
            list.add("NrcWrongBlockSequenceCounter");
            flipped |= 115;
        }
        if ((o & 120) == 120) {
            list.add("NrcResponsePending");
            flipped |= 120;
        }
        if ((o & 126) == 126) {
            list.add("NrcSubfunctionNotSupportedInActiveSession");
            flipped |= 126;
        }
        if ((o & 127) == 127) {
            list.add("NrcServiceNotSupportedInActiveSession");
            flipped |= 127;
        }
        if ((o & 129) == 129) {
            list.add("NrcRpmTooHigh");
            flipped |= 129;
        }
        if ((o & 130) == 130) {
            list.add("NrcRpmTooLow");
            flipped |= 130;
        }
        if ((o & 131) == 131) {
            list.add("NrcEngineIsRunning");
            flipped |= 131;
        }
        if ((o & 132) == 132) {
            list.add("NrcEngineIsNotRunning");
            flipped |= 132;
        }
        if ((o & 133) == 133) {
            list.add("NrcEngineRunTimeTooLow");
            flipped |= 133;
        }
        if ((o & 134) == 134) {
            list.add("NrcTemperatureTooHigh");
            flipped |= 134;
        }
        if ((o & 135) == 135) {
            list.add("NrcTemperatureTooLow");
            flipped |= 135;
        }
        if ((o & 136) == 136) {
            list.add("NrcVehicleSpeedTooHigh");
            flipped |= 136;
        }
        if ((o & 137) == 137) {
            list.add("NrcVehicleSpeedTooLow");
            flipped |= 137;
        }
        if ((o & 138) == 138) {
            list.add("NrcThrottleSpeedTooHigh");
            flipped |= 138;
        }
        if ((o & 139) == 139) {
            list.add("NrcThrottleSpeedTooLow");
            flipped |= 139;
        }
        if ((o & 140) == 140) {
            list.add("NrcTransmissionRangeInNeutral");
            flipped |= 140;
        }
        if ((o & 141) == 141) {
            list.add("NrcTransmissionRangeInGears");
            flipped |= 141;
        }
        if ((o & 143) == 143) {
            list.add("NrcBrakeSwitchNotClosed");
            flipped |= 143;
        }
        if ((o & 144) == 144) {
            list.add("NrcShifterLeverNotInPark");
            flipped |= 144;
        }
        if ((o & 145) == 145) {
            list.add("NrcTorqueConverterClutchLocked");
            flipped |= 145;
        }
        if ((o & 146) == 146) {
            list.add("NrcVoltageTooHigh");
            flipped |= 146;
        }
        if ((o & 147) == 147) {
            list.add("NrcVoltageTooLow");
            flipped |= 147;
        }
        if (o != flipped) {
            list.add("0x" + Integer.toHexString((flipped ^ (-1)) & o));
        }
        return String.join(" | ", list);
    }
}