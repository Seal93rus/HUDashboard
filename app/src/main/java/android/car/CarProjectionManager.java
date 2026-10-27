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

import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;

import java.lang.ref.WeakReference;

/**
 * CarProjectionManager allows to register listeners and runners for projection.
 */
public final class CarProjectionManager implements CarManagerBase {

    /**
     * Voice search type: projection voice search.
     */
    public static final int PROJECTION_VOICE_SEARCH = 1;

    /**
     * Voice search type: projection long-press voice search.
     */
    public static final int PROJECTION_LONG_PRESS_VOICE_SEARCH = 2;

    /**
     * Listener for projection events.
     */
    public interface CarProjectionListener {
        /**
         * Called when a voice assistant request is received.
         *
         * @param fromLongPress whether the request came from a long press
         */
        void onVoiceAssistantRequest(boolean fromLongPress);
    }

    private final ICarProjection mService;
    private final Handler mHandler;
    private final ICarProjectionCallbackImpl mBinderListener;

    private CarProjectionListener mListener;
    private int mVoiceSearchFilter;

    CarProjectionManager(IBinder service, Handler handler) {
        mService = ICarProjection.Stub.asInterface(service);
        mHandler = handler;
        mBinderListener = new ICarProjectionCallbackImpl(this);
    }

    /**
     * @deprecated use {@link #registerProjectionListener(CarProjectionListener, int)} instead.
     */
    @Deprecated
    public void regsiterProjectionListener(CarProjectionListener listener, int voiceSearchFilter)
            throws CarNotConnectedException {
        registerProjectionListener(listener, voiceSearchFilter);
    }

    /**
     * Registers a listener for projection events.
     *
     * @param listener          the listener to register
     * @param voiceSearchFilter the voice search filter
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public void registerProjectionListener(CarProjectionListener listener, int voiceSearchFilter)
            throws CarNotConnectedException {
        if (listener == null) {
            throw new IllegalArgumentException("null listener");
        }
        synchronized (this) {
            if (mListener == null || mVoiceSearchFilter != voiceSearchFilter) {
                try {
                    mService.registerProjectionListener(mBinderListener, voiceSearchFilter);
                } catch (RemoteException e) {
                    throw new CarNotConnectedException(e);
                }
            }
            mListener = listener;
            mVoiceSearchFilter = voiceSearchFilter;
        }
    }

    /**
     * @deprecated use {@link #unregisterProjectionListener()} instead.
     */
    @Deprecated
    public void unregsiterProjectionListener() {
        unregisterProjectionListener();
    }

    /**
     * Unregisters the projection listener.
     */
    public void unregisterProjectionListener() {
        synchronized (this) {
            try {
                mService.unregisterProjectionListener(mBinderListener);
            } catch (RemoteException e) {
                // ignore
            }
            mListener = null;
            mVoiceSearchFilter = 0;
        }
    }

    /**
     * Registers a projection runner.
     *
     * @param serviceIntent the intent of the projection runner service
     * @throws CarNotConnectedException if the connection to the car service is lost
     */
    public void registerProjectionRunner(Intent serviceIntent) throws CarNotConnectedException {
        if (serviceIntent == null) {
            throw new IllegalArgumentException("null serviceIntent");
        }
        synchronized (this) {
            try {
                mService.registerProjectionRunner(serviceIntent);
            } catch (RemoteException e) {
                throw new CarNotConnectedException(e);
            }
        }
    }

    /**
     * Unregisters a projection runner.
     *
     * @param serviceIntent the intent of the projection runner service
     */
    public void unregisterProjectionRunner(Intent serviceIntent) {
        if (serviceIntent == null) {
            throw new IllegalArgumentException("null serviceIntent");
        }
        synchronized (this) {
            try {
                mService.unregisterProjectionRunner(serviceIntent);
            } catch (RemoteException e) {
                // ignore
            }
        }
    }

    @Override
    public void onCarDisconnected() {
        // Nothing to do
    }

    /* package */ void handleVoiceAssistantRequest(boolean fromLongPress) {
        synchronized (this) {
            if (mListener != null) {
                CarProjectionListener listener = mListener;
                listener.onVoiceAssistantRequest(fromLongPress);
            }
        }
    }

    private static class ICarProjectionCallbackImpl extends ICarProjectionCallback.Stub {

        private final WeakReference<CarProjectionManager> mManager;

        private ICarProjectionCallbackImpl(CarProjectionManager manager) {
            mManager = new WeakReference<>(manager);
        }

        @Override
        public void onVoiceAssistantRequest(final boolean fromLongPress) {
            final CarProjectionManager manager = mManager.get();
            if (manager == null) {
                return;
            }
            manager.mHandler.post(new Runnable() {
                @Override
                public void run() {
                    manager.handleVoiceAssistantRequest(fromLongPress);
                }
            });
        }
    }
}