package com.seal93rus.HUdashboard;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager2.widget.ViewPager2;

import com.seal93rus.HUdashboard.CarData.AcTemperatureController;
import com.seal93rus.HUdashboard.CarData.CarFunctionModel;
import com.seal93rus.HUdashboard.CarData.CarHvacHelper;
import com.seal93rus.HUdashboard.radio.RadioClient;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private View displayContainer;
    private SurfaceView surfaceView;
    private VirtualDisplayManager displayManager;
    private ViewPager2 viewPager;
    private VirtualDisplayManager.AppInfo selectedApp;
    private RadioClient radioClient;

    private AppCompatButton stopButton;
    private View carDataView;

    private AppCompatTextView outsideTempView;
    private AppCompatTextView textClock;
    private AppCompatTextView textDate;
    private AppCompatTextView ac_temp;

    private AppCompatButton ac_button_increase;
    private AppCompatButton ac_button_decrease;
    private AcTemperatureController acController;

    private final Handler uiHandler = new Handler(Looper.getMainLooper());
    private static final long OUTSIDE_TEMP_INTERVAL_MS = 1000L;
    private static final long AC_TEMP_INTERVAL_MS      = 1000L;

    private final Runnable outsideTempTick = new Runnable() {
        @Override
        public void run() {
            refreshOutsideTemp();
            uiHandler.postDelayed(this, OUTSIDE_TEMP_INTERVAL_MS);
        }
    };

    private final Runnable acTempTick = new Runnable() {
        @Override
        public void run() {
            refreshAcTemp();
            uiHandler.postDelayed(this, AC_TEMP_INTERVAL_MS);
        }
    };

    private final SimpleDateFormat timeFmt = new SimpleDateFormat("HH:mm", Locale.getDefault());
    private final SimpleDateFormat dateFmt = new SimpleDateFormat("d MMMM", new Locale("ru"));

    private final BroadcastReceiver timeReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateClockAndDate();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carDataView        = findViewById(R.id.carDataView);
        surfaceView        = findViewById(R.id.surfaceView);
        displayContainer   = findViewById(R.id.displayContainer);
        stopButton         = findViewById(R.id.stopButton);
        outsideTempView    = findViewById(R.id.outside_temp);
        textClock          = findViewById(R.id.textClock);
        textDate           = findViewById(R.id.textDate);
        ac_temp            = findViewById(R.id.ac_temp);
        ac_button_increase = findViewById(R.id.ac_button_increase);
        ac_button_decrease = findViewById(R.id.ac_button_decrease);

        displayManager = VirtualDisplayManager.getInstance(this);
        viewPager      = findViewById(R.id.viewPager);

        radioClient = RadioClient.get(this);
        radioClient.start();

        acController = new AcTemperatureController();

        List<PageItem> pageList = new ArrayList<>();
        pageList.add(new MusicItem("Мой Плейлист", 0));
        pageList.add(new TunerItem("Нота До (C)"));
        viewPager.setAdapter(new PageAdapter(pageList));

        if (surfaceView != null) surfaceView.getHolder().addCallback(this);
        if (ac_button_increase != null) ac_button_increase.setOnClickListener(v -> onAcIncrease());
        if (ac_button_decrease != null) ac_button_decrease.setOnClickListener(v -> onAcDecrease());

        displayContainer.setOnClickListener(v -> startVirtualDisplay());
        stopButton.setOnClickListener(v -> stopVirtualDisplay());
        updateSelectedAppLabel();
    }

    private void updateClockAndDate() {
        Date now = new Date();
        if (textClock != null) textClock.setText(timeFmt.format(now));
        if (textDate != null) textDate.setText(dateFmt.format(now));
    }

    private void refreshOutsideTemp() {
        if (outsideTempView == null) return;
        float t = CarHvacHelper.getInstance().getOutsideTemperature();
        if (Float.isNaN(t)) {
            outsideTempView.setText("n/d");
        } else {
            outsideTempView.setText(String.format(Locale.getDefault(), "%.0f°C", t));
        }
    }

    private void refreshAcTemp() {
        if (ac_temp == null) return;
        float t = CarHvacHelper.getInstance().getLeftTemp();
        if (Float.isNaN(t)) {
            ac_temp.setText("n/d");
        } else {
            ac_temp.setText(String.format(Locale.getDefault(), "%.1f°C", t));
        }
    }

    private void onAcIncrease() {
        CarFunctionModel model = CarFunctionModel.getInstance();
        if (model == null || !model.isIgnitionOn()) {
            Toast.makeText(this, "Зажигание выключено", Toast.LENGTH_SHORT).show();
            return;
        }

        float current = CarHvacHelper.getInstance().getLeftTemp();
        float max = AcTemperatureController.tempMax();
        if (!Float.isNaN(current) && current >= max - 0.01f) {
            Toast.makeText(this,
                    "Уже максимум (" + String.format(Locale.getDefault(), "%.1f", max) + "°C)",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (acController.increaseDriverTemp()) {
            uiHandler.postDelayed(this::refreshAcTemp, 300);
        } else {
            Toast.makeText(this, "Команда не отправлена", Toast.LENGTH_SHORT).show();
        }
    }

    private void onAcDecrease() {
        CarFunctionModel model = CarFunctionModel.getInstance();
        if (model == null || !model.isIgnitionOn()) {
            Toast.makeText(this, "Зажигание выключено", Toast.LENGTH_SHORT).show();
            return;
        }

        float current = CarHvacHelper.getInstance().getLeftTemp();
        float min = AcTemperatureController.tempMin();
        if (!Float.isNaN(current) && current <= min + 0.01f) {
            Toast.makeText(this,
                    "Уже минимум (" + String.format(Locale.getDefault(), "%.1f", min) + "°C)",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        if (acController.decreaseDriverTemp()) {
            uiHandler.postDelayed(this::refreshAcTemp, 300);
        } else {
            Toast.makeText(this, "Команда не отправлена", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_TIME_TICK);
        filter.addAction(Intent.ACTION_TIME_CHANGED);
        filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
        filter.addAction(Intent.ACTION_DATE_CHANGED);
        filter.addAction(Intent.ACTION_LOCALE_CHANGED);
        registerReceiver(timeReceiver, filter);
        updateClockAndDate();
    }

    @Override
    protected void onStop() {
        super.onStop();
        try { unregisterReceiver(timeReceiver); } catch (IllegalArgumentException ignored) {}
    }

    @Override
    protected void onResume() {
        super.onResume();
        uiHandler.removeCallbacks(outsideTempTick);
        uiHandler.removeCallbacks(acTempTick);
        uiHandler.post(outsideTempTick);
        uiHandler.post(acTempTick);
    }

    @Override
    protected void onPause() {
        super.onPause();
        uiHandler.removeCallbacks(outsideTempTick);
        uiHandler.removeCallbacks(acTempTick);
    }

    private void startVirtualDisplay() {
        if (displayManager.isActive()) {
            Toast.makeText(this, R.string.already_running, Toast.LENGTH_SHORT).show();
            return;
        }
        surfaceView.setVisibility(View.VISIBLE);
        stopButton.setVisibility(View.VISIBLE);
    }

    private void stopVirtualDisplay() {
        displayManager.release();
        if (surfaceView != null) {
            surfaceView.setVisibility(View.GONE);
            stopButton.setVisibility(View.GONE);
        }
        Toast.makeText(this, R.string.display_released, Toast.LENGTH_SHORT).show();
        displayContainer.setClickable(true);
    }

    private void showAppPicker() {
        List<VirtualDisplayManager.AppInfo> apps = displayManager.getInstalledApps();
        if (apps.isEmpty()) {
            Toast.makeText(this, R.string.no_apps_found, Toast.LENGTH_SHORT).show();
            return;
        }
        String[] labels = new String[apps.size()];
        for (int i = 0; i < apps.size(); i++) labels[i] = apps.get(i).label;
        new AlertDialog.Builder(this)
                .setTitle(R.string.pick_app_title)
                .setItems(labels, (dialog, which) -> {
                    selectedApp = apps.get(which);
                    updateSelectedAppLabel();
                })
                .setNegativeButton(android.R.string.cancel, null)
                .show();
    }

    private void launchSelectedApp() {
        if (!displayManager.isActive()) {
            Toast.makeText(this, R.string.need_start_first, Toast.LENGTH_SHORT).show();
            return;
        }
        if (selectedApp == null) {
            Toast.makeText(this, R.string.no_app_selected, Toast.LENGTH_SHORT).show();
            return;
        }
        boolean ok = displayManager.launchAppOnDisplay(selectedApp.packageName);
        Toast.makeText(this, ok ? R.string.launch_ok : R.string.launch_fail,
                Toast.LENGTH_SHORT).show();
        if (ok) displayContainer.setClickable(false);
    }

    private void updateSelectedAppLabel() {
        if (selectedApp != null) launchSelectedApp();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        Surface surface = holder.getSurface();
        if (surface != null && surface.isValid()) displayManager.setSurface(surface);
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int w, int h) {
        if (w <= 0 || h <= 0) return;
        displayManager.setSize(w, h);
        if (!displayManager.isActive()) {
            Surface surface = holder.getSurface();
            displayManager.setSurface(surface);
            if (displayManager.create() != null) {
                Toast.makeText(this, R.string.display_created, Toast.LENGTH_SHORT).show();
                showAppPicker();
            }
        } else {
            displayManager.resize(w, h);
        }
    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        displayManager.setSurface(null);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!isChangingConfigurations() && displayManager != null) displayManager.release();
        if (isFinishing() && radioClient != null) radioClient.stop();
        uiHandler.removeCallbacksAndMessages(null);
    }
}