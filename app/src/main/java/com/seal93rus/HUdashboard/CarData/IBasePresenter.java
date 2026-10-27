package com.seal93rus.HUdashboard.CarData;


import android.os.Bundle;


public interface IBasePresenter<T> {
    BaseModel getModel();

    void onCreate(Bundle bundle);

    void onDestroy();

    void setView(T t);
}