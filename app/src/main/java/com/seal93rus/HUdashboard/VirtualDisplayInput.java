package com.seal93rus.HUdashboard;

import android.util.Log;

public class VirtualDisplayInput {
    private static final String TAG = "VirtualDisplayInput";
    private final int displayId;

    public VirtualDisplayInput(int displayId) {
        this.displayId = displayId;
    }

    public void injectTap(float x, float y) {
        new Thread(() -> {
            try {
                String cmd = "input -d " + displayId + " tap " + (int) x + " " + (int) y;
                Process process = Runtime.getRuntime().exec(new String[]{"sh", "-c", cmd});
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    Log.w(TAG, "input command failed with exit " + exitCode);
                } else {
                    Log.i(TAG, "Tap injected at " + x + "," + y + " on display " + displayId);
                }
            } catch (Exception e) {
                Log.e(TAG, "Ошибка инжекта через shell", e);
            }
        }).start();
    }

    public void release() {
        // ничего не делаем
    }
}