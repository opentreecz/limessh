package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.sonelli.C1501lc;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public final class BackgroundDetector implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: S */
    public static final BackgroundDetector f736S = new BackgroundDetector();

    /* renamed from: O */
    public final AtomicBoolean f737O = new AtomicBoolean();

    /* renamed from: P */
    public final AtomicBoolean f738P = new AtomicBoolean();

    /* renamed from: Q */
    @GuardedBy("sInstance")
    public final ArrayList<BackgroundStateChangeListener> f739Q = new ArrayList<>();

    /* renamed from: R */
    @GuardedBy("sInstance")
    public boolean f740R = false;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface BackgroundStateChangeListener {
        /* renamed from: a */
        void mo1005a(boolean z);
    }

    /* renamed from: b */
    public static BackgroundDetector m999b() {
        return f736S;
    }

    /* renamed from: c */
    public static void m1000c(Application application) {
        BackgroundDetector backgroundDetector = f736S;
        synchronized (backgroundDetector) {
            if (!backgroundDetector.f740R) {
                application.registerActivityLifecycleCallbacks(backgroundDetector);
                application.registerComponentCallbacks(backgroundDetector);
                backgroundDetector.f740R = true;
            }
        }
    }

    /* renamed from: a */
    public final void m1001a(BackgroundStateChangeListener backgroundStateChangeListener) {
        synchronized (f736S) {
            this.f739Q.add(backgroundStateChangeListener);
        }
    }

    /* renamed from: d */
    public final boolean m1002d() {
        return this.f737O.get();
    }

    /* renamed from: e */
    public final void m1003e(boolean z) {
        synchronized (f736S) {
            ArrayList<BackgroundStateChangeListener> arrayList = this.f739Q;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                BackgroundStateChangeListener backgroundStateChangeListener = arrayList.get(i);
                i++;
                backgroundStateChangeListener.mo1005a(z);
            }
        }
    }

    @TargetApi(16)
    /* renamed from: f */
    public final boolean m1004f(boolean z) {
        if (!this.f738P.get()) {
            if (!C1501lc.m6143c()) {
                return z;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f738P.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f737O.set(true);
            }
        }
        return m1002d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        boolean compareAndSet = this.f737O.compareAndSet(true, false);
        this.f738P.set(true);
        if (compareAndSet) {
            m1003e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        boolean compareAndSet = this.f737O.compareAndSet(true, false);
        this.f738P.set(true);
        if (compareAndSet) {
            m1003e(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f737O.compareAndSet(false, true)) {
            this.f738P.set(true);
            m1003e(true);
        }
    }
}
