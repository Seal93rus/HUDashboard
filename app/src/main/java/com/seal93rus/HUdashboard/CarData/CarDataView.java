package com.seal93rus.HUdashboard.CarData;


import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.seal93rus.HUdashboard.R;
import android.util.Log;


public class CarDataView extends ConstraintLayout implements ICustomViewDataUpdate, ICarFunctionView {
    private static final String TAG = "CarDateView";

    private AppCompatTextView mfuel_state;
    private AppCompatTextView mvoltage;
    private AppCompatTextView mtemp_dtc;
    private AppCompatTextView meng_temp;

    private Activity mActivity;

    private CarFunctionPresenter m_presenter;

    public CarDataView(@NonNull Context context) {
        this(context, null);
    }

    public CarDataView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CarDataView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        createPresenter();
    }

    private IBasePresenter createPresenter() {
        this.m_presenter = new CarFunctionPresenter(getContext());
        this.m_presenter.setView((ICarFunctionView) this);
        return this.m_presenter;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        initCarDateComponent();
        updateData();
    }

    private void initCarDateComponent() {

        this.mfuel_state = (AppCompatTextView) findViewById(R.id.fuel_state);
        this.mvoltage = (AppCompatTextView) findViewById(R.id.voltage);
        this.mtemp_dtc = (AppCompatTextView) findViewById(R.id.temp_dtc);
        this.meng_temp = (AppCompatTextView) findViewById(R.id.eng_temp);
    }

    public void getActivityInstance(Activity activity) {
        Log.d(TAG, "getActivityInstance");
        this.mActivity = activity;
    }

    private void updateData() {
        CarFunctionPresenter carFunctionPresenter = this.m_presenter;
        if (carFunctionPresenter == null) {
            Log.e(TAG, "m_presenter is null in updateData()");
            return;
        }
        updateCoolantTemperature(carFunctionPresenter.getCoolantTemperature());
        updateTransmissionOilTemperature(this.m_presenter.getTransmissionOilTemperature());
        updateBatteryVoltage(this.m_presenter.getBatterVoltage());
        updateFuelState(this.m_presenter.getFuelState());
    }

    @Override // com.harman.gwm.hmi.launcher.view.ICustomViewDataUpdate
    public void refreshUI() {
        updateData();
    }

    public void onSuccess() {
        Log.d(TAG, "onSuccess");
    }

    public void onError() {
        Log.d(TAG, "onError");
    }



    @Override // com.harman.gwm.hmi.launcher.view.ICustomViewDataUpdate
    public void startListenDataUpdate() {
        Log.d(TAG, "startListenDataUpdate");
    }

    @Override // com.harman.gwm.hmi.launcher.view.ICustomViewDataUpdate
    public void stopListenDataUpdate() {
        Log.d(TAG, "stopListenDataUpdate");
    }

    @Override // com.harman.gwm.hmi.launcher.mvp.view.ICarFunctionView
    public void updateCoolantTemperature(float temperature) {
        Log.d(TAG, "updateCoolantTemperature: " + temperature);
        TextView textView = this.meng_temp;
        if (textView == null) {
            Log.e(TAG, "mTextViewTemp is null in updateCoolantTemperature");
        } else if (temperature != 0.0f) {
            textView.setText(String.format("%.0f°C", Float.valueOf(temperature)));
            Log.i(TAG, String.format("Temperature updated: %.0f°c", Float.valueOf(temperature)));
        } else {
            textView.setText("n/d");
            Log.e(TAG, "Temperature is 0.0°c, showing 'no data'");
        }
    }



    @Override // com.harman.gwm.hmi.launcher.mvp.view.ICarFunctionView
    public void updateBatteryVoltage(float voltage) {
        Log.d(TAG, "updateBatteryVoltage: " + voltage);
        TextView textView = this.mvoltage;
        if (textView == null) {
            Log.e(TAG, "mTextViewVoltage is null in updateBatteryVoltage");
        } else if (voltage != 0.0f) {
            textView.setText(String.format("%.1fV", Float.valueOf(voltage)));
            Log.i(TAG, String.format("Voltage updated: %.1fV", Float.valueOf(voltage)));
        } else {
            textView.setText("n/d");
            Log.e(TAG, "Voltage is 0.0V, showing 'no data'");
        }
    }



    @Override // com.harman.gwm.hmi.launcher.mvp.view.ICarFunctionView
    public void updateTransmissionOilTemperature(float temperature) {
        Log.d(TAG, "updateTransmissionOilTemperature: " + temperature);
        TextView textView = this.mtemp_dtc;
        if (textView == null) {
            Log.e(TAG, "mTextViewTempDct is null in updateTransmissionOilTemperature");
        } else if (temperature != 0.0f) {
            textView.setText(String.format("%.0f°C", Float.valueOf(temperature)));
            Log.i(TAG, String.format("DCT Temperature updated: %.0f°С", Float.valueOf(temperature)));
        } else {
            textView.setText("n/d");
           Log.e(TAG, "DCT Temperature is 0.0°c, showing 'no data'");
        }
    }

    @Override // com.harman.gwm.hmi.launcher.mvp.view.ICarFunctionView
    public void updateFuelState (int fuelstate) {
        Log.d(TAG, "updateTransmissionOilTemperature: " + fuelstate);
        TextView textView = this.mfuel_state;
        if (textView == null) {
            Log.e(TAG, "mTextViewFuelstate is null in updateFuelState");
        } else if (fuelstate != 0) {
            textView.setText(String.format("%d км", Integer.valueOf(fuelstate)));
            Log.i(TAG, String.format("Fuel state updated: %d", fuelstate));
        } else {
            textView.setText("n/d");
            Log.e(TAG, "FuelState, showing 'no data'");
        }
    }
}