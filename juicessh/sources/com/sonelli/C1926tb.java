package com.sonelli;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.tb */
/* loaded from: classes.dex */
public class C1926tb {

    /* renamed from: e */
    public static final Object f6748e = new Object();

    /* renamed from: f */
    public static volatile C1926tb f6749f;

    /* renamed from: a */
    public final List<String> f6750a;

    /* renamed from: b */
    public final List<String> f6751b;

    /* renamed from: c */
    public final List<String> f6752c;

    /* renamed from: d */
    public final List<String> f6753d;

    public C1926tb() {
        List<String> list = Collections.EMPTY_LIST;
        this.f6750a = list;
        this.f6751b = list;
        this.f6752c = list;
        this.f6753d = list;
    }

    /* renamed from: b */
    public static C1926tb m8637b() {
        if (f6749f == null) {
            synchronized (f6748e) {
                if (f6749f == null) {
                    f6749f = new C1926tb();
                }
            }
        }
        return f6749f;
    }

    /* renamed from: a */
    public boolean m8638a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m8640d(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    /* renamed from: c */
    public void m8639c(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    /* renamed from: d */
    public final boolean m8640d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        ComponentName component = intent.getComponent();
        if (!(component == null ? false : C0762bc.m2427a(context, component.getPackageName()))) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }
}
