/*
 * Copyright (C) 2015 The Android Open Source Project
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

package android.car;

import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * CarAppFocusManager manages the application focus in the car.
 */
public final class CarAppFocusManager implements CarManagerBase {

    /**
     * Listener to be notified when an app focus is changed.
     */
    public interface OnAppFocusChangedListener {
        /**
         * Called when the app focus changes.
         *
         * @param appType the type of the app focus
         * @param active  whether the app focus is active
         */
        void onAppFocusChanged(int appType, boolean active);
    }

    /**
     * Callback to be notified when an app focus ownership changes.
     */
    public interface OnAppFocusOwnershipCallback {
        /**
         * Called when the app focus ownership is lost.
         *
         * @param appType the type of the app focus
         */
        void onAppFocusOwnershipLost(int appType);

        /**
         * Called when the app focus ownership is granted.
         *
         * @param appType the type of the app focus
         */
        void onAppFocusOwnershipGranted(int appType);
    }

    /**
     * Result code for requesting an app focus: the request failed.
     */
    public static final int APP_FOCUS_REQUEST_FAILED = 0;

    /**
     * Result code for requesting an app focus: the request succeeded.
     */
    public static final int APP_FOCUS_REQUEST_SUCCEEDED = 1;

    /**
     * The app focus type for navigation.
     */
    public static final int APP_FOCUS_TYPE_NAVIGATION = 1;

    /**
     * The app focus type for voice command.
     */
    public static final int APP_FOCUS_TYPE_VOICE_COMMAND = 2;

    /**
     * The max value of the app focus type.
     */
    public static final int APP_FOCUS_MAX = 2;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusRequestResult {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AppFocusType {
    }

    private final IAppFocus mService;
    private final Handler mHandler;

    private final Map<OnAppFocusChangedListener, IAppFocusListenerImpl> mChangeBinders =
            new HashMap<>();
    private final Map<OnAppFocusOwnershipCallback, IAppFocusOwnershipCallbackImpl>
            mOwnershipBinders = new HashMap<>();

    CarAppFocusManager(IBinder service, Handler handler) {
        this.mService = IAppFocus.Stub.asInterface(service);
        this.mHandler = handler;
    }

    /**
     * Registers a listener to be notified when the app focus of the given type changes.
     *
     * @param listener the listener to register
     * @param appType  the type of the app focus
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public void addFocusListener(OnAppFocusChangedListener listener, int appType)
            throws CarNotConnectedException {
        if (listener == null) {
            throw new IllegalArgumentException("null listener");
        }
        IAppFocusListenerImpl binder;
        synchronized (this) {
            binder = mChangeBinders.get(listener);
            if (binder == null) {
                binder = new IAppFocusListenerImpl(this, listener);
                mChangeBinders.put(listener, binder);
            }
            binder.addAppType(appType);
        }
        try {
            mService.registerFocusListener(binder, appType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Unregisters the listener for the given app focus type.
     *
     * @param listener the listener to unregister
     * @param appType  the type of the app focus
     */
    public void removeFocusListener(OnAppFocusChangedListener listener, int appType) {
        synchronized (this) {
            IAppFocusListenerImpl binder = mChangeBinders.get(listener);
            if (binder == null) {
                return;
            }
            try {
                mService.unregisterFocusListener(binder, appType);
            } catch (RemoteException e) {
                // ignore
            }
            synchronized (this) {
                binder.removeAppType(appType);
                if (!binder.hasAppTypes()) {
                    mChangeBinders.remove(listener);
                }
            }
        }
    }

    /**
     * Unregisters the listener for all app focus types.
     *
     * @param listener the listener to unregister
     */
    public void removeFocusListener(OnAppFocusChangedListener listener) {
        synchronized (this) {
            IAppFocusListenerImpl binder = mChangeBinders.remove(listener);
            if (binder == null) {
                return;
            }
            try {
                for (Integer appType : binder.getAppTypes()) {
                    mService.unregisterFocusListener(binder, appType);
                }
            } catch (RemoteException e) {
                // ignore
            }
        }
    }

    /**
     * Returns the list of currently active app focus types.
     *
     * @return the array of active app focus types
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public int[] getActiveAppTypes() throws CarNotConnectedException {
        try {
            return mService.getActiveAppTypes();
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Returns whether the given callback owns the app focus of the given type.
     *
     * @param callback the callback to check
     * @param appType  the type of the app focus
     * @return whether the callback owns the app focus
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public boolean isOwningFocus(OnAppFocusOwnershipCallback callback, int appType)
            throws CarNotConnectedException {
        synchronized (this) {
            IAppFocusOwnershipCallbackImpl binder = mOwnershipBinders.get(callback);
            if (binder == null) {
                return false;
            }
            try {
                return mService.isOwningFocus(binder, appType);
            } catch (RemoteException e) {
                throw new CarNotConnectedException(e);
            }
        }
    }

    /**
     * Requests the app focus of the given type.
     *
     * @param appType           the type of the app focus
     * @param ownershipCallback the callback to be notified about ownership changes
     * @return {@link #APP_FOCUS_REQUEST_SUCCEEDED} or {@link #APP_FOCUS_REQUEST_FAILED}
     * @throws CarNotConnectedException if the connection to the car service is lost
     * @throws SecurityException        if the caller does not have the required permission
     */
    public int requestAppFocus(int appType, OnAppFocusOwnershipCallback ownershipCallback)
            throws CarNotConnectedException, SecurityException {
        if (ownershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        IAppFocusOwnershipCallbackImpl binder;
        synchronized (this) {
            binder = mOwnershipBinders.get(ownershipCallback);
            if (binder == null) {
                binder = new IAppFocusOwnershipCallbackImpl(this, ownershipCallback);
                mOwnershipBinders.put(ownershipCallback, binder);
            }
            binder.addAppType(appType);
        }
        try {
            return mService.requestAppFocus(binder, appType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Requests the app focus of the given type, taking it forcibly from the current owner.
     *
     * @param appType           the type of the app focus
     * @param ownershipCallback the callback to be notified about ownership changes
     * @return {@link #APP_FOCUS_REQUEST_SUCCEEDED} or {@link #APP_FOCUS_REQUEST_FAILED}
     * @throws CarNotConnectedException if the connection to the car service is lost
     * @throws SecurityException        if the caller does not have the required permission
     */
    public int requestAppFocusForced(int appType,
                                     OnAppFocusOwnershipCallback ownershipCallback)
            throws CarNotConnectedException, SecurityException {
        if (ownershipCallback == null) {
            throw new IllegalArgumentException("null listener");
        }
        IAppFocusOwnershipCallbackImpl binder;
        synchronized (this) {
            binder = mOwnershipBinders.get(ownershipCallback);
            if (binder == null) {
                binder = new IAppFocusOwnershipCallbackImpl(this, ownershipCallback);
                mOwnershipBinders.put(ownershipCallback, binder);
            }
            binder.addAppType(appType);
        }
        try {
            return mService.requestAppFocusForced(binder, appType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    /**
     * Abandons the app focus of the given type.
     *
     * @param ownershipCallback the callback that previously requested the app focus
     * @param appType           the type of the app focus
     */
    public void abandonAppFocus(OnAppFocusOwnershipCallback ownershipCallback, int appType) {
        if (ownershipCallback == null) {
            throw new IllegalArgumentException("null callback");
        }
        IAppFocusOwnershipCallbackImpl binder;
        synchronized (this) {
            binder = mOwnershipBinders.get(ownershipCallback);
            if (binder == null) {
                return;
            }
            try {
                mService.abandonAppFocus(binder, appType);
            } catch (RemoteException e) {
                // ignore
            }
            synchronized (this) {
                binder.removeAppType(appType);
                if (!binder.hasAppTypes()) {
                    mOwnershipBinders.remove(ownershipCallback);
                }
            }
        }
    }

    /**
     * Abandons all app focus types owned by the given callback.
     *
     * @param ownershipCallback the callback that previously requested the app focus
     */
    public void abandonAppFocus(OnAppFocusOwnershipCallback ownershipCallback) {
        if (ownershipCallback == null) {
            throw new IllegalArgumentException("null callback");
        }
        synchronized (this) {
            IAppFocusOwnershipCallbackImpl binder = mOwnershipBinders.remove(ownershipCallback);
            if (binder == null) {
                return;
            }
            try {
                for (Integer appType : binder.getAppTypes()) {
                    mService.abandonAppFocus(binder, appType);
                }
            } catch (RemoteException e) {
                // ignore
            }
        }
    }

    /**
     * Returns the pid of the process that currently owns the app focus of the given type.
     *
     * @param appType the type of the app focus
     * @return the pid of the focus owner
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public int getPidOfFocusOwner(int appType) throws CarNotConnectedException {
        try {
            return mService.getPidOfFocusOwner(appType);
        } catch (RemoteException e) {
            throw new CarNotConnectedException(e);
        }
    }

    @Override
    public void onCarDisconnected() {
        // Nothing to do
    }

    private static class IAppFocusListenerImpl extends IAppFocusListener.Stub {

        private final WeakReference<CarAppFocusManager> mManager;
        private final WeakReference<OnAppFocusChangedListener> mListener;
        private final Set<Integer> mAppTypes = new HashSet<>();

        private IAppFocusListenerImpl(CarAppFocusManager manager,
                                      OnAppFocusChangedListener listener) {
            mManager = new WeakReference<>(manager);
            mListener = new WeakReference<>(listener);
        }

        public void addAppType(int appType) {
            mAppTypes.add(appType);
        }

        public void removeAppType(int appType) {
            mAppTypes.remove(appType);
        }

        public Set<Integer> getAppTypes() {
            return mAppTypes;
        }

        public boolean hasAppTypes() {
            return !mAppTypes.isEmpty();
        }

        @Override
        public void onAppFocusChanged(final int appType, final boolean active) {
            CarAppFocusManager manager = mManager.get();
            final OnAppFocusChangedListener listener = mListener.get();
            if (manager == null || listener == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onAppFocusChanged(appType, active);
                }
            });
        }
    }

    private static class IAppFocusOwnershipCallbackImpl extends IAppFocusOwnershipCallback.Stub {

        private final WeakReference<CarAppFocusManager> mManager;
        private final WeakReference<OnAppFocusOwnershipCallback> mCallback;
        private final Set<Integer> mAppTypes = new HashSet<>();

        private IAppFocusOwnershipCallbackImpl(CarAppFocusManager manager,
                                               OnAppFocusOwnershipCallback callback) {
            mManager = new WeakReference<>(manager);
            mCallback = new WeakReference<>(callback);
        }

        public void addAppType(int appType) {
            mAppTypes.add(appType);
        }

        public void removeAppType(int appType) {
            mAppTypes.remove(appType);
        }

        public Set<Integer> getAppTypes() {
            return mAppTypes;
        }

        public boolean hasAppTypes() {
            return !mAppTypes.isEmpty();
        }

        @Override
        public void onAppFocusOwnershipLost(final int appType) {
            CarAppFocusManager manager = mManager.get();
            final OnAppFocusOwnershipCallback callback = mCallback.get();
            if (manager == null || callback == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onAppFocusOwnershipLost(appType);
                }
            });
        }

        @Override
        public void onAppFocusOwnershipGranted(final int appType) {
            CarAppFocusManager manager = mManager.get();
            final OnAppFocusOwnershipCallback callback = mCallback.get();
            if (manager == null || callback == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    callback.onAppFocusOwnershipGranted(appType);
                }
            });
        }
    }
}