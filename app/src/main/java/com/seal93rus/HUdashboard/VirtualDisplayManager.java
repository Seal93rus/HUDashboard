package com.seal93rus.HUdashboard;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * Обёртка над DisplayManager для системных приложений.
 * Не использует MediaProjection — только прямые системные API.
 */
public class VirtualDisplayManager {

    private static final String TAG = "VirtualDisplayMgr";

    private static VirtualDisplayManager sInstance;

    private final Context appContext;
    private final DisplayManager displayManager;
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    private VirtualDisplay virtualDisplay;
    private Surface targetSurface;

    private int width;
    private int height;
    private int densityDpi = 120;

    private VirtualDisplayInput virtualDisplayInput;

    public int getWidth()  { return width; }
    public int getHeight() { return height; }

    // Измените метод setMetrics, чтобы он сохранял размеры в поля класса
    public void setSize(int w, int h) {
        this.width = w;
        this.height = h;
    }

    // Также добавьте динамическое изменение размера для уже созданного дисплея (опционально)
    public void resize(int w, int h) {
        this.width = w;
        this.height = h;
        if (virtualDisplay != null) {
            virtualDisplay.resize(w, h, densityDpi);
        }
    }


    private VirtualDisplayManager(Context context) {
        this.appContext = context.getApplicationContext();
        this.displayManager =
                (DisplayManager) appContext.getSystemService(Context.DISPLAY_SERVICE);
    }

    public static synchronized VirtualDisplayManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VirtualDisplayManager(context);
        }
        return sInstance;
    }

    public boolean isActive() {
        return virtualDisplay != null;
    }

    public int getDisplayId() {
        return virtualDisplay != null ? virtualDisplay.getDisplay().getDisplayId() : -1;
    }



    /**
     * Привязывает Surface, на который будет рендериться содержимое
     * виртуального дисплея. Если дисплей уже создан — перепривязывает.
     */
    public void setSurface(Surface surface) {
        this.targetSurface = surface;

        if (virtualDisplay != null) {
            if (surface != null && surface.isValid()) {
                virtualDisplay.setSurface(surface);
            } else {
                virtualDisplay.setSurface(null);
            }
        }
    }

    /**
     * Создаёт виртуальный дисплей. Если Surface ещё не установлен,
     * дисплей всё равно будет создан, и Surface можно будет
     * привязать позже через setSurface().
     */
    public VirtualDisplay create() {
        if (displayManager == null) {
            Log.e(TAG, "DisplayManager недоступен");
            return null;
        }
        if (virtualDisplay != null) {
            Log.w(TAG, "Виртуальный дисплей уже создан");
            return virtualDisplay;
        }

        // Системные флаги — доступны только системному приложению.
        // PUBLIC    — дисплей виден всей системе.
        // TRUSTED   — доверенный дисплей, может показывать защищённые окна.
        // OWN_FOCUS — у дисплея собственный фокус ввода.
        // PRESENTATION — дисплей может использоваться как presentation.
        // SUPPORTS_INPUT — поддержка ввода (тач, клавиатура).
        final int VIRTUAL_DISPLAY_FLAG_SUPPORTS_TOUCH = 1 << 6; // Бит 64
        final int VIRTUAL_DISPLAY_FLAG_OWN_FOCUS = 1 << 4;// Бит 16
        final int VIRTUAL_DISPLAY_FLAG_TRUSTED = 1 << 10;

        final int flags = DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC
                | DisplayManager.VIRTUAL_DISPLAY_FLAG_PRESENTATION
                | DisplayManager.VIRTUAL_DISPLAY_FLAG_OWN_CONTENT_ONLY
                | VIRTUAL_DISPLAY_FLAG_SUPPORTS_TOUCH
                | VIRTUAL_DISPLAY_FLAG_TRUSTED
                | VIRTUAL_DISPLAY_FLAG_OWN_FOCUS;

        virtualDisplay = displayManager.createVirtualDisplay(
                "HUD_VirtualDisplay",
                width,
                height,
                densityDpi,
                targetSurface,
                flags
        );

        if (virtualDisplay != null) {
            int displayId = virtualDisplay.getDisplay().getDisplayId();

            // ИНИЦИАЛИЗАЦИЯ: Получаем системный InputManager и создаем наш инпут
            virtualDisplayInput = new VirtualDisplayInput(displayId);
            Log.i(TAG, "Виртуальный дисплей создан, id=" + getDisplayId());
        } else {
            Log.e(TAG, "Не удалось создать виртуальный дисплей");
        }
        return virtualDisplay;
    }

    /**
     * Запускает активность на виртуальном дисплее.
     */
    public boolean launchActivityOnDisplay(Class<?> activityClass) {
        if (virtualDisplay == null) {
            Log.e(TAG, "Дисклей ещё не создан");
            return false;
        }
        try {
            Intent intent = new Intent(appContext, activityClass);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            ActivityOptions options = ActivityOptions.makeBasic();
            options.setLaunchDisplayId(virtualDisplay.getDisplay().getDisplayId());

            appContext.startActivity(intent, options.toBundle());
            return true;
        } catch (Exception e) {
            Log.e(TAG, "Ошибка запуска активности на дисплее", e);
            return false;
        }
    }

    /**
     * Освобождает ресурсы дисплея.
     */
    public void release() {
        if (virtualDisplay != null) {
            virtualDisplay.release();
            virtualDisplay = null;
            Log.i(TAG, "Виртуальный дисплей освобождён");
        }
        targetSurface = null;
    }

    /**
     * Возвращает DisplayMetrics для виртуального дисплея.
     */
    public DisplayMetrics setMetrics(int w, int h) {
        DisplayMetrics metrics = new DisplayMetrics();
        metrics.widthPixels = width;
        metrics.heightPixels = height;
        metrics.densityDpi = densityDpi;
        return metrics;
    }

    public void injectTap(float x, float y) {
        if (virtualDisplayInput != null) {
            // Запускаем инжект в фоновом потоке, так как внутри используется Thread.sleep(50),
            // чтобы удержать нажатие и не завис Main UI-поток приложения.
            new Thread(() -> virtualDisplayInput.injectTap(x, y)).start();
        } else {
            Log.w(TAG, "injectTap проигнорирован: virtualDisplayInput не инициализирован");
        }
    }
    /**
     * Запускает приложение по packageName на виртуальном дисплее.
     * @return true если удалось запустить
     */
    public boolean launchAppOnDisplay(String packageName) {
        if (virtualDisplay == null) {
            Log.e(TAG, "Виртуальный дисплей не создан");
            return false;
        }

        try {
            Intent launchIntent = appContext.getPackageManager()
                    .getLaunchIntentForPackage(packageName);

            if (launchIntent == null) {
                Log.e(TAG, "Нет launcher-интента для " + packageName);
                return false;
            }

            launchIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                    | Intent.FLAG_ACTIVITY_MULTIPLE_TASK
                    | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

            ActivityOptions options = ActivityOptions.makeBasic();
            options.setLaunchDisplayId(virtualDisplay.getDisplay().getDisplayId());

            appContext.startActivity(launchIntent, options.toBundle());
            Log.i(TAG, "Запущено " + packageName + " на display "
                    + virtualDisplay.getDisplay().getDisplayId());
            return true;

        } catch (Exception e) {
            Log.e(TAG, "Ошибка запуска " + packageName, e);
            return false;
        }
    }

    /**
     * Возвращает список установленных приложений с launcher-активностью.
     * Сортирует по алфавиту.
     */
    public List<AppInfo> getInstalledApps() {
        PackageManager pm = appContext.getPackageManager();
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(mainIntent, 0);
        List<AppInfo> apps = new ArrayList<>();

        for (ResolveInfo ri : resolveInfos) {
            String pkg = ri.activityInfo.packageName;
            // Пропускаем себя
            if (pkg.equals(appContext.getPackageName())) continue;

            AppInfo info = new AppInfo();
            info.packageName = pkg;
            info.label = ri.loadLabel(pm).toString();
            info.icon = ri.loadIcon(pm);
            apps.add(info);
        }

        Collections.sort(apps, (a, b) ->
                a.label.compareToIgnoreCase(b.label));
        return apps;
    }

    /** Простая модель для списка приложений */
    public static class AppInfo {
        public String packageName;
        public String label;
        public android.graphics.drawable.Drawable icon;
    }
}