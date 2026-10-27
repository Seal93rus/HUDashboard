package com.seal93rus.HUdashboard.CarData;

public interface ICustomViewDataUpdate {
    void refreshUI();

    void startListenDataUpdate();

    void stopListenDataUpdate();
}