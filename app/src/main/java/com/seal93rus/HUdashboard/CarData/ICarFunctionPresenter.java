package com.seal93rus.HUdashboard.CarData;

public interface ICarFunctionPresenter extends IBasePresenter<ICarFunctionView> {
    float getBatterVoltage();


    float getCoolantTemperature();

    int getFuelState();

    float getTransmissionOilTemperature();
}
