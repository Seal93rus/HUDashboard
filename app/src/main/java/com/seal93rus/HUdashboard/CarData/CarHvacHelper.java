package com.seal93rus.HUdashboard.CarData;

import android.car.CarNotConnectedException;
import android.car.hardware.hvac.CarHvacManager;
import android.util.Log;

public class CarHvacHelper {
    private static CarHvacHelper instance;
    private CarHvacManager mCarHvacManager;

    private CarHvacHelper() {}

    public static CarHvacHelper getInstance() {
        if (instance == null) {
            synchronized (CarHvacHelper.class) {
                if (instance == null) instance = new CarHvacHelper();
            }
        }
        return instance;
    }

    public void initHelper(CarHvacManager carHvacManager) {
        this.mCarHvacManager = carHvacManager;
    }

    public boolean isAirOpen() {
        if (mCarHvacManager == null) return false;
        try {
            return mCarHvacManager.getBooleanProperty(
                    CarHvacManager.ID_ZONED_HVAC_POWER_ON, Integer.MIN_VALUE);
        } catch (CarNotConnectedException e) {
            return false;
        }
    }

    public int getWindSpeech() {
        if (mCarHvacManager == null) return 0;
        try {
            return mCarHvacManager.getIntProperty(
                    CarHvacManager.ID_ZONED_FAN_SPEED_RPM, Integer.MIN_VALUE);
        } catch (CarNotConnectedException e) {
            return 0;
        }
    }

    public float getLeftTemp() {
        if (mCarHvacManager == null) return Float.NaN;
        try {
            float v = mCarHvacManager.getFloatProperty(16386, 1);
            if (v == 0.0f) {
                // fallback: на некоторых GWM V2 driver-зона = areaId 0
                v = mCarHvacManager.getFloatProperty(16386, 0);
            }
            return v;
        } catch (CarNotConnectedException e) {
            return Float.NaN;
        }
    }

    public float getRightTemp() {
        if (mCarHvacManager == null) return Float.NaN;
        try {
            float v = mCarHvacManager.getFloatProperty(16386, 4);
            if (v == 0.0f) {
                v = mCarHvacManager.getFloatProperty(16386, 3);
            }
            return v;
        } catch (CarNotConnectedException e) {
            return Float.NaN;
        }
    }

    public float getOutsideTemperature() {
        if (mCarHvacManager == null) return Float.NaN;
        try {
            return mCarHvacManager.getFloatProperty(3, Integer.MIN_VALUE);
        } catch (CarNotConnectedException e) {
            return Float.NaN;
        }
    }

    public boolean setLeftTemp(float tempCelsius) {
        if (mCarHvacManager == null) return false;
        try {
            mCarHvacManager.setFloatProperty(16386, 1, tempCelsius);
            Log.i("CarHvacHelper", "setLeftTemp: " + tempCelsius);
            return true;
        } catch (CarNotConnectedException e) {
            Log.e("CarHvacHelper", "setLeftTemp failed", e);
            return false;
        }
    }

    public boolean setRightTemp(float tempCelsius) {
        if (mCarHvacManager == null) return false;
        try {
            mCarHvacManager.setFloatProperty(16386, 4, tempCelsius);
            Log.i("CarHvacHelper", "setRightTemp: " + tempCelsius);
            return true;
        } catch (CarNotConnectedException e) {
            Log.e("CarHvacHelper", "setRightTemp failed", e);
            return false;
        }
    }
}