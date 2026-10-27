/*
 * Copyright (C) ... (ваш/оригинальный копирайт)
 */

package com.seal93rus.HUdashboard.CarData;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * Presenter for car functions (battery, coolant, transmission oil, fuel).
 */
public class CarFunctionPresenter implements ICarFunctionPresenter, BaseModel.IEventListener {

    public static final String TAG = "CarFunctionPresenter";

    private final Context m_context;
    private final CarFunctionModel m_model;
    private ICarFunctionView m_view;

    /** Handler on the main thread, used to deliver model events to the view. */
    private final Handler mMainHandler = new Handler(Looper.getMainLooper());

    public CarFunctionPresenter(Context context) {
        m_context = context;
        m_model = new CarFunctionModel(context);
        m_model.addEventListener(this);
    }

    @Override
    public float getBatterVoltage() {
        if (m_model != null) {
            return m_model.getBatteryVoltage();
        }
        return 0.0f;
    }

    @Override
    public float getCoolantTemperature() {
        if (m_model != null) {
            return m_model.getCoolantTemperature();
        }
        return 0.0f;
    }

    @Override
    public int getFuelState() {
        if (m_model != null) {
            return m_model.getFuelState();
        }
        return 0;
    }

    @Override
    public float getTransmissionOilTemperature() {
        if (m_model != null) {
            return m_model.getTransmissionOilTemperature();
        }
        return 0.0f;
    }

    @Override
    public BaseModel getModel() {
        return null;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // Nothing to do
    }

    @Override
    public void onDestroy() {
        m_model.removeEventListener(this);
        m_model.destroy();
    }

    @Override
    public void setView(ICarFunctionView view) {
        m_view = view;
    }

    @Override
    public void onHandleEvent(final int iEventID, final Object data) {
        Log.v(TAG, "onHandleEvent iEventID: " + iEventID + " data: " + data);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                int type = m_model.getTemperatureUnits();
                switch (iEventID) {
                    case 1:
                        m_view.updateCoolantTemperature(
                                formatTemperature(type, (Float) data));
                        break;
                    case 2:
                        m_view.updateTransmissionOilTemperature((Float) data);
                        break;
                    case 4:
                        m_view.updateFuelState((Integer) data);
                        break;
                    case 6:
                        m_view.updateBatteryVoltage((Float) data);
                        break;
                    default:
                        Log.w(TAG, "Unknown event in onHandleEvent: " + iEventID);
                        break;
                }
            }
        };
        mMainHandler.post(r);
    }

    private float formatTemperature(int type, float value) {
        Log.i(TAG, "formatTemperature type: " + type + " value: " + value);
        if (type == 1) {
            float temp = (float) ((((double) value) * 1.8d) + 32.0d);
            return Math.round(temp * 10.0f) / 10.0f;
        }
        return value;
    }
}