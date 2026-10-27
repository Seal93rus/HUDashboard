package android.content;



import android.os.IBinder;

public interface ServiceConnection {
    void onServiceConnected(ComponentName name, IBinder service);
    void onServiceDisconnected(ComponentName name);

    // Эти методы объявлены как default в Android, мы пишем их пустую реализацию
    default void onBindingDied(ComponentName name) {
    }
    default void onNullBinding(ComponentName name) {
    }
}