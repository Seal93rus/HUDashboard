package com.seal93rus.HUdashboard.CarData;

import android.content.Context;
import android.provider.Settings;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public class BaseModel {
    private final ArrayList<IEventListener> m_aryListener = new ArrayList<>();

    public interface IEventListener {
        void onHandleEvent(int i, Object obj);

        default void onHandleEvent(int iEventID, Object value, Object area) {
        }
    }

    public synchronized void addEventListener(IEventListener listener) {
        if (!this.m_aryListener.contains(listener)) {
            this.m_aryListener.add(listener);
        }
    }

    public synchronized void dispatchEvent(int iEventID, Object obj) {
        for (int i = this.m_aryListener.size() - 1; i >= 0; i--) {
            IEventListener listener = this.m_aryListener.get(i);
            if (listener != null) {
                listener.onHandleEvent(iEventID, obj);
            }
        }
    }

    public synchronized void dispatchEvent(int iEventID, Object value, Object area) {
        for (int i = this.m_aryListener.size() - 1; i >= 0; i--) {
            IEventListener listener = this.m_aryListener.get(i);
            if (listener != null) {
                listener.onHandleEvent(iEventID, value, area);
            }
        }
    }

    public String getTimeText(Context context, Date date) {
        String strTimeText = getDateFormat(context).format(date);
        return strTimeText;
    }

    public synchronized void removeEventListener(IEventListener listener) {
        this.m_aryListener.remove(listener);
    }

    private DateFormat getDateFormat(Context context) {
        String strFormat = Settings.System.getString(context.getContentResolver(), "date_format");
        if (strFormat == null || "".equals(strFormat)) {
            return DateFormat.getDateInstance(3);
        }
        try {
            return new SimpleDateFormat(strFormat);
        } catch (IllegalArgumentException e) {
            return DateFormat.getDateInstance(3);
        }
    }
}