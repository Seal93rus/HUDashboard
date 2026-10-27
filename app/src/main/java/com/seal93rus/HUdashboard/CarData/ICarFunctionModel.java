package com.seal93rus.HUdashboard.CarData;

// Изменили class на interface
public interface ICarFunctionModel {
    void destroy();

    float getBatteryVoltage();
    float getCoolantTemperature();
    int getFuelState();

    float getTransmissionOilTemperature(); // Исправлена опечатка
    int getTemperatureUnits();
}