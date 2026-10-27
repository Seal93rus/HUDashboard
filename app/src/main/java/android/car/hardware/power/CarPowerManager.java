/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.car.hardware.power;

import android.car.Car;
import android.car.CarManagerBase;
import android.car.CarNotConnectedException;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.android.internal.annotations.GuardedBy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;

/**
 * Manager for car power management.
 */
public class CarPowerManager implements CarManagerBase {

    private static final boolean DBG = false;
    private static final String TAG = "CarPowerManager";

    /**
     * Reason for boot: user power on.
     */
    public static final int BOOT_REASON_USER_POWER_ON = 0;

    /**
     * Reason for boot: door unlock.
     */
    public static final int BOOT_REASON_DOOR_UNLOCK = 1;

    /**
     * Reason for boot: timer.
     */
    public static final int BOOT_REASON_TIMER = 2;

    /**
     * Reason for boot: door open.
     */
    public static final int BOOT_REASON_DOOR_OPEN = 3;

    /**
     * Reason for boot: remote start.
     */
    public static final int BOOT_REASON_REMOTE_START = 4;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BootReason {
    }

    /**
     * Listener for car power state changes.
     */
    public interface CarPowerStateListener {
        /** State: shutdown cancelled. */
        int SHUTDOWN_CANCELLED = 0;
        /** State: entering shutdown. */
        int SHUTDOWN_ENTER = 1;
        /** State: entering suspend. */
        int SUSPEND_ENTER = 2;
        /** State: exiting suspend. */
        int SUSPEND_EXIT = 3;

        /**
         * Called when the car power state changes.
         *
         * @param state the new state
         */
        void onStateChanged(int state);
    }

    private final ICarPower mService;
    private final Object mLock = new Object();

    @GuardedBy("mLock")
    private ICarPowerStateListener mListenerToService;

    private CarPowerStateListener mListener;
    private Executor mExecutor;

    public CarPowerManager(IBinder service, Context context, Handler handler) {
        mService = ICarPower.Stub.asInterface(service);
    }

    /**
     * Returns the reason for boot.
     *
     * @return one of the {@link BootReason} values
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public int getBootReason() throws CarNotConnectedException {
        try {
            return mService.getBootReason();
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in getBootReason", e);
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Requests a shutdown on the next suspend.
     *
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public void requestShutdownOnNextSuspend() throws CarNotConnectedException {
        try {
            mService.requestShutdownOnNextSuspend();
        } catch (RemoteException e) {
            Log.e(TAG, "Exception in requestShutdownOnNextSuspend", e);
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Sets the power state listener.
     *
     * @param listener the listener
     * @param executor the executor on which the listener is called
     * @throws IllegalStateException    if a listener is already set
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public void setListener(CarPowerStateListener listener, Executor executor)
            throws IllegalStateException, CarNotConnectedException {
        synchronized (mLock) {
            if (mListenerToService == null) {
                ICarPowerStateListener listenerToService = new ICarPowerStateListener.Stub() {
                    @Override
                    public void onStateChanged(int state, int token) throws RemoteException {
                        handleEvent(state, token);
                    }
                };
                try {
                    mService.registerListener(listenerToService);
                    mListenerToService = listenerToService;
                } catch (RemoteException ex) {
                    Log.e(TAG, "Could not connect: ", ex);
                    throw new CarNotConnectedException(ex);
                } catch (IllegalStateException ex) {
                    Car.checkCarNotConnectedExceptionFromCarService(ex);
                }
            }
            if (mExecutor == null && mListener == null) {
                mExecutor = executor;
                mListener = listener;
            } else {
                throw new IllegalStateException("Listener must be cleared first");
            }
        }
    }

    /**
     * Clears the power state listener.
     */
    public void clearListener() {
        ICarPowerStateListener listenerToService;
        synchronized (mLock) {
            listenerToService = mListenerToService;
            mListenerToService = null;
            mListener = null;
            mExecutor = null;
        }
        if (listenerToService == null) {
            Log.w(TAG, "unregisterListener: listener was not registered");
            return;
        }
        try {
            mService.unregisterListener(listenerToService);
        } catch (RemoteException ex) {
            Log.e(TAG, "Failed to unregister listener", ex);
        } catch (IllegalStateException ex) {
            Car.hideCarNotConnectedExceptionFromCarService(ex);
        }
    }

    private void handleEvent(final int state, final int token) {
        final Executor executor;
        synchronized (mLock) {
            executor = mExecutor;
        }
        if (executor != null) {
            executor.execute(() -> handleEventInternal(state, token));
        } else {
            handleEventInternal(state, token);
        }
    }

    private void handleEventInternal(int state, int token) {
        mListener.onStateChanged(state);
        if (state == CarPowerStateListener.SHUTDOWN_ENTER
                || state == CarPowerStateListener.SUSPEND_ENTER) {
            try {
                mService.finished(mListenerToService, token);
            } catch (RemoteException e) {
                Log.e(TAG, "Exception in finished", e);
            }
        }
    }

    @Override
    public void onCarDisconnected() {
        ICarPowerStateListener listenerToService;
        synchronized (mLock) {
            listenerToService = mListenerToService;
        }
        if (listenerToService != null) {
            clearListener();
        }
    }
}