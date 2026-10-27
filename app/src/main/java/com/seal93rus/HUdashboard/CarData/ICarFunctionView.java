package com.seal93rus.HUdashboard.CarData;

public interface ICarFunctionView {
    void updateFuelState(int f);

    void updateBatteryVoltage(float f);

    void updateCoolantTemperature(float f);


    void updateTransmissionOilTemperature(float f);
}
