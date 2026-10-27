package com.seal93rus.HUdashboard.CarData;

import android.hardware.automotive.vehicleProgram.V1_0.CustomProperty;
import android.util.Log;

/**
 * Управление температурой климата через CarVendorExtensionManager.
 * Окно климата НЕ открывается.
 *
 * ВАЖНО: отправка блокируется, если зажигание выключено. Иначе CAN-модуль может
 * сохранить "желаемую уставку" на минимум/максимум и применить её при включении
 * зажигания — это и вызывает эффект "температура улетела на минимум без нажатий".
 */
public class AcTemperatureController {

    private static final String TAG = "AcTempController";

    private static final int PROP_DRIVER_TEMP_INC     = CustomProperty.GWMV2_DRVTEMPINCREQ_TC;
    private static final int PROP_DRIVER_TEMP_DEC     = CustomProperty.GWMV2_DRVTEMPDECREQ_TC;
    private static final int PROP_PASSENGER_TEMP_INC  = CustomProperty.GWMV2_FRNTPASSTEMPINCREQ_TC;
    private static final int PROP_PASSENGER_TEMP_DEC  = CustomProperty.GWMV2_FRNTPASSTEMPDECREQ_TC;

    public static final float TEMP_MIN_NORMAL = 16.0f;
    public static final float TEMP_MAX_NORMAL = 32.0f;
    public static final float TEMP_MIN_HAND   = 1.0f;
    public static final float TEMP_MAX_HAND   = 17.0f;

    private static final float TEMP_STEP;

    static {
        int uab = android.os.SystemProperties.getInt("ro.vehicle.config.UAB", 0);
        TEMP_STEP = (uab == 2) ? 1.0f : 0.5f;
    }

    public AcTemperatureController() {}

    public static float getStep()      { return TEMP_STEP; }
    public static boolean isHandMode() { return TEMP_STEP == 1.0f; }
    public static float tempMin()      { return isHandMode() ? TEMP_MIN_HAND : TEMP_MIN_NORMAL; }
    public static float tempMax()      { return isHandMode() ? TEMP_MAX_HAND : TEMP_MAX_NORMAL; }

    public boolean increaseDriverTemp()    { return trigger(PROP_DRIVER_TEMP_INC); }
    public boolean decreaseDriverTemp()    { return trigger(PROP_DRIVER_TEMP_DEC); }
    public boolean increasePassengerTemp() { return trigger(PROP_PASSENGER_TEMP_INC); }
    public boolean decreasePassengerTemp() { return trigger(PROP_PASSENGER_TEMP_DEC); }

    private boolean trigger(int propId) {
        CarFunctionModel model = CarFunctionModel.getInstance();
        if (model == null) {
            Log.e(TAG, "trigger: CarFunctionModel is null");
            return false;
        }
        if (!model.isIgnitionOn()) {
            Log.w(TAG, "trigger: ignition off (mode=" + model.getPowerMode()
                    + "), ignoring propId=" + propId);
            return false;
        }
        return model.sendVendorTrigger(propId);
    }
}