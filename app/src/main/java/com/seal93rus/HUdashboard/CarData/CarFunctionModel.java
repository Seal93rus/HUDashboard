package com.seal93rus.HUdashboard.CarData;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.ICar;
import android.car.hardware.CarPropertyValue;
import android.car.hardware.CarSensorEvent;
import android.car.hardware.CarSensorManager;
import android.car.hardware.CarVendorExtensionManager;
import android.car.hardware.hvac.CarHvacManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.hardware.automotive.vehicleProgram.V1_0.CustomProperty;
import android.util.Log;

public class CarFunctionModel extends BaseModel implements ICarFunctionModel,
        CarVendorExtensionManager.CarVendorExtensionCallback,
        CarHvacManager.CarHvacEventCallback,
        CarSensorManager.OnSensorChangedListener {

    public static final int BATTERY_HEALTH_CHANGED = 7;
    public static final int BATTERY_VOLTAGE_CHANGED = 6;
    public static final int COOLANT_TEMPERATURE_CHANGED = 1;
    public static final int DEGREES_CELSIUS = 0;
    public static final int DEGREES_FAHRENHEIT = 1;
    public static final int FUEL_STATE_CHANGED = 4;
    public static final String TAG = "DBHUSCarFunctionModel";
    public static final int TEMPERATURE_UNITS_CHANGED = 3;
    public static final int TRANSMISSION_OIL_TEMPERATURE_CHANGED = 2;

    private final Car m_car;
    private CarHvacManager m_carHvacManger;
    private Context m_context;
    private CarSensorManager m_sensorManager;
    private CarVendorExtensionManager m_vendorExtensionManger;

    private float m_fCoolantTemperature = 0.0f;
    private float m_fOilTemperature = 0.0f;
    private int m_fFuelState = 0;
    private float m_fBatteryVoltage = 0.0f;
    private int m_iTemperatureType = 0;

    /**
     * Режим питания из VHAL.
     * -1 = неизвестно. 0=OFF, 1=ACC, 2=ON, 3=CRANK/RUN, 4=ON_FULL (зависит от прошивки).
     */
    private int m_iPowerMode = -1;

    private static CarFunctionModel sInstance;
    private Handler m_handler = new Handler();

    private final ServiceConnection m_carConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ICar carService = ICar.Stub.asInterface(service);
            if (carService != null) {
                Log.i(TAG, "onServiceConnected");
                try {
                    IBinder binder = carService.getCarService(Car.VENDOR_EXTENSION_SERVICE);
                    m_vendorExtensionManger = new CarVendorExtensionManager(binder, m_handler);

                    IBinder hvacBinder = carService.getCarService(Car.HVAC_SERVICE);
                    m_carHvacManger = new CarHvacManager(hvacBinder, m_context, m_handler);

                    // Инициализируем хелпер ровно в момент, когда HVAC-менеджер готов.
                    CarHvacHelper.getInstance().initHelper(m_carHvacManger);
                    Log.i(TAG, "CarHvacHelper initialized from CarFunctionModel");

                    m_sensorManager = (CarSensorManager) m_car.getCarManager(Car.SENSOR_SERVICE);
                    initData();
                    setHVACCallbackListener();
                    return;
                } catch (CarNotConnectedException e) {
                    Log.e(TAG, "onServiceConnected car not connected");
                    return;
                } catch (RemoteException e2) {
                    Log.e(TAG, "onServiceConnected remote exception: " + e2.getMessage());
                    return;
                }
            }
            Log.e(TAG, "carService = null !!!!!");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.w(TAG, "onServiceDisconnected");
            m_vendorExtensionManger = null;
            m_sensorManager = null;
            m_carHvacManger = null;
            m_iPowerMode = -1; // зажигание снова неизвестно
            CarHvacHelper.getInstance().initHelper(null);
        }
    };

    public CarFunctionModel(Context context) {
        m_context = context;
        m_car = Car.createCar(m_context, m_carConnection);
        if (m_car == null) {
            Log.e(TAG, "Car.createCar() returned null — car service unavailable. Degraded mode.");
            return;
        }
        m_car.connect();
        sInstance = this;
    }

    public static CarFunctionModel getInstance() {
        return sInstance;
    }

    public int getPowerMode() {
        return m_iPowerMode;
    }

    /**
     * Безопасно ли сейчас отправлять vendor-команды.
     * Пока POWER_MODE не получен (-1), считаем зажигание выключенным —
     * это защищает от команд "в пустоту" при старте.
     */
    public boolean isIgnitionOn() {
        return m_iPowerMode >= 2;
    }

    @Override
    public void destroy() {
        if (m_carHvacManger != null) m_carHvacManger.unregisterCallback(this);
        if (m_vendorExtensionManger != null) m_vendorExtensionManger.unregisterCallback(this);
        if (m_sensorManager != null) m_sensorManager.unregisterListener(this);
        CarHvacHelper.getInstance().initHelper(null);
        if (m_car != null) m_car.disconnect();
        m_context = null;
        m_handler.removeCallbacksAndMessages(null);
    }

    @Override
    public float getBatteryVoltage() { return m_fBatteryVoltage; }
    @Override
    public float getCoolantTemperature() { return m_fCoolantTemperature; }
    @Override
    public int getFuelState() { return m_fFuelState; }
    public float getTransmissionOilTemperature() { return m_fOilTemperature; }
    @Override
    public int getTemperatureUnits() { return m_iTemperatureType; }

    @Override
    public void onChangeEvent(CarPropertyValue carPropertyValue) {
        int property_id = carPropertyValue.getPropertyId();
        Object value = carPropertyValue.getValue();
        Log.v(TAG, "onChangeEvent property_id: " + property_id + " value: " + value);
        switch (property_id) {
            case 4:
                if (value instanceof Integer) {
                    m_iTemperatureType = (Integer) value;
                    dispatchEvent(TEMPERATURE_UNITS_CHANGED, value);
                }
                break;
            case CustomProperty.GWMV2_IP_REMADST:
                if (value instanceof Integer) {
                    m_fFuelState = (Integer) value;
                    dispatchEvent(FUEL_STATE_CHANGED, m_fFuelState);
                }
                break;
            case CustomProperty.GWMV2_DCT_TRSMOILTEMP:
                if (value instanceof Float) {
                    m_fOilTemperature = (Float) value;
                    dispatchEvent(TRANSMISSION_OIL_TEMPERATURE_CHANGED, m_fOilTemperature);
                }
                break;
            case CustomProperty.GWMV2_INPUTVOLTFOROTA:
                if (value instanceof Float) {
                    m_fBatteryVoltage = (Float) value;
                    dispatchEvent(BATTERY_VOLTAGE_CHANGED, m_fBatteryVoltage);
                }
                break;
            case CustomProperty.GWMV2_POWER_MODE_TC: // если нет — замените на GWMV2_POWER_MODE
                if (value instanceof Integer) {
                    m_iPowerMode = (Integer) value;
                    Log.d(TAG, "Power mode changed: " + m_iPowerMode
                            + ", ignitionOn=" + isIgnitionOn());
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onErrorEvent(int i, int i1) {
        Log.e(TAG, "onErrorEvent i: " + i + " i1: " + i1);
    }

    @Override
    public void onSensorChanged(CarSensorEvent carSensorEvent) {
        if (carSensorEvent.sensorType == 15) {
            float value = carSensorEvent.floatValues[0];
            dispatchEvent(COOLANT_TEMPERATURE_CHANGED, value);
        }
    }

    private void initData() {
        CarSensorEvent event;
        try {
            if (m_carHvacManger != null) {
                int value = m_carHvacManger.getIntProperty(4, Integer.MIN_VALUE);
                if (value != 0 && value != 1) value = 0;
                m_iTemperatureType = value;
            }

            if (m_vendorExtensionManger != null) {
                // --- POWER_MODE (зажигание) ---
                try {
                    Integer pm = (Integer) m_vendorExtensionManger.getGlobalProperty(
                            Integer.class, CustomProperty.GWMV2_POWER_MODE_TC);
                    if (pm != null) {
                        m_iPowerMode = pm;
                        Log.d(TAG, "initData powerMode=" + m_iPowerMode
                                + ", ignitionOn=" + isIgnitionOn());
                    }
                } catch (Exception e) {
                    Log.w(TAG, "initData: POWER_MODE read failed: " + e.getMessage());
                }

                m_fOilTemperature = (Float) m_vendorExtensionManger.getGlobalProperty(
                        Float.class, CustomProperty.GWMV2_DCT_TRSMOILTEMP);
                dispatchEvent(TRANSMISSION_OIL_TEMPERATURE_CHANGED, m_fOilTemperature);

                m_fBatteryVoltage = (Float) m_vendorExtensionManger.getGlobalProperty(
                        Float.class, CustomProperty.GWMV2_INPUTVOLTFOROTA);
                dispatchEvent(BATTERY_VOLTAGE_CHANGED, m_fBatteryVoltage);

                m_fFuelState = (Integer) m_vendorExtensionManger.getGlobalProperty(
                        Integer.class, CustomProperty.GWMV2_IP_REMADST);
                dispatchEvent(FUEL_STATE_CHANGED, m_fFuelState);
            }

            if (m_sensorManager != null
                    && (event = m_sensorManager.getLatestSensorEvent(15)) != null) {
                m_fCoolantTemperature = event.floatValues[0];
                dispatchEvent(COOLANT_TEMPERATURE_CHANGED, m_fCoolantTemperature);
            }
            dispatchEvent(TEMPERATURE_UNITS_CHANGED, m_iTemperatureType);
            Log.i(TAG, "initData type: " + m_iTemperatureType
                    + " coolant: " + m_fCoolantTemperature
                    + " oil: " + m_fOilTemperature
                    + " powerMode: " + m_iPowerMode);
        } catch (CarNotConnectedException e) {
            Log.e(TAG, "initData Car not connected");
        } catch (Exception e2) {
            Log.e(TAG, "initData failed: " + e2.getMessage());
        }
    }

    private void setHVACCallbackListener() {
        try {
            m_carHvacManger.registerCallback(this);
            m_vendorExtensionManger.registerCallback(this);
            m_sensorManager.registerListener(this, 15, 2);
        } catch (CarNotConnectedException e) {
            Log.e(TAG, "setHVACCallbackListener failed, car not connected");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Отправить vendor-команду-триггер (value = 1).
     * Блокируется, если зажигание выключено или POWER_MODE ещё неизвестен.
     */
    public boolean sendVendorTrigger(int propId) {
        if (m_vendorExtensionManger == null) {
            Log.e(TAG, "sendVendorTrigger: vendor manager is null");
            return false;
        }
        if (!isIgnitionOn()) {
            Log.w(TAG, "sendVendorTrigger: ignition off (mode=" + m_iPowerMode
                    + "), ignoring propId=" + propId);
            return false;
        }
        try {
            m_vendorExtensionManger.setGlobalProperty(Integer.class, propId, 1);
            Log.i(TAG, "sendVendorTrigger: sent propId=" + propId);
            return true;
        } catch (CarNotConnectedException e) {
            Log.e(TAG, "sendVendorTrigger: CarNotConnected", e);
            return false;
        } catch (Exception e) {
            Log.e(TAG, "sendVendorTrigger failed", e);
            return false;
        }
    }
}