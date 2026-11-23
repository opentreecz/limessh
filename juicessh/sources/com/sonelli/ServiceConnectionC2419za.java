package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.sonelli.AbstractC2207w9;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.za */
/* loaded from: classes.dex */
public final class ServiceConnectionC2419za implements ServiceConnection {

    /* renamed from: a */
    public final Map<ServiceConnection, ServiceConnection> f8480a = new HashMap();

    /* renamed from: b */
    public int f8481b = 2;

    /* renamed from: c */
    public boolean f8482c;

    /* renamed from: d */
    public IBinder f8483d;

    /* renamed from: e */
    public final AbstractC2207w9.a f8484e;

    /* renamed from: f */
    public ComponentName f8485f;

    /* renamed from: g */
    public final /* synthetic */ C2270xa f8486g;

    public ServiceConnectionC2419za(C2270xa c2270xa, AbstractC2207w9.a aVar) {
        this.f8486g = c2270xa;
        this.f8484e = aVar;
    }

    /* renamed from: a */
    public final IBinder m10406a() {
        return this.f8483d;
    }

    /* renamed from: b */
    public final ComponentName m10407b() {
        return this.f8485f;
    }

    /* renamed from: c */
    public final int m10408c() {
        return this.f8481b;
    }

    /* renamed from: d */
    public final boolean m10409d() {
        return this.f8482c;
    }

    /* renamed from: e */
    public final void m10410e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        Context context;
        C1926tb unused;
        Context unused2;
        unused = this.f8486g.f7914f;
        unused2 = this.f8486g.f7912d;
        AbstractC2207w9.a aVar = this.f8484e;
        context = this.f8486g.f7912d;
        aVar.m9456c(context);
        this.f8480a.put(serviceConnection, serviceConnection2);
    }

    /* renamed from: f */
    public final void m10411f(ServiceConnection serviceConnection, String str) {
        C1926tb unused;
        Context unused2;
        unused = this.f8486g.f7914f;
        unused2 = this.f8486g.f7912d;
        this.f8480a.remove(serviceConnection);
    }

    /* renamed from: g */
    public final boolean m10412g(ServiceConnection serviceConnection) {
        return this.f8480a.containsKey(serviceConnection);
    }

    /* renamed from: h */
    public final void m10413h(String str) {
        C1926tb c1926tb;
        Context context;
        Context context2;
        C1926tb c1926tb2;
        Context context3;
        Handler handler;
        Handler handler2;
        long j;
        this.f8481b = 3;
        c1926tb = this.f8486g.f7914f;
        context = this.f8486g.f7912d;
        AbstractC2207w9.a aVar = this.f8484e;
        context2 = this.f8486g.f7912d;
        boolean m8640d = c1926tb.m8640d(context, str, aVar.m9456c(context2), this, this.f8484e.m9457d());
        this.f8482c = m8640d;
        if (m8640d) {
            handler = this.f8486g.f7913e;
            Message obtainMessage = handler.obtainMessage(1, this.f8484e);
            handler2 = this.f8486g.f7913e;
            j = this.f8486g.f7916h;
            handler2.sendMessageDelayed(obtainMessage, j);
            return;
        }
        this.f8481b = 2;
        try {
            c1926tb2 = this.f8486g.f7914f;
            context3 = this.f8486g.f7912d;
            c1926tb2.m8639c(context3, this);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* renamed from: i */
    public final void m10414i(String str) {
        Handler handler;
        C1926tb c1926tb;
        Context context;
        handler = this.f8486g.f7913e;
        handler.removeMessages(1, this.f8484e);
        c1926tb = this.f8486g.f7914f;
        context = this.f8486g.f7912d;
        c1926tb.m8639c(context, this);
        this.f8482c = false;
        this.f8481b = 2;
    }

    /* renamed from: j */
    public final boolean m10415j() {
        return this.f8480a.isEmpty();
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f8486g.f7911c;
        synchronized (hashMap) {
            handler = this.f8486g.f7913e;
            handler.removeMessages(1, this.f8484e);
            this.f8483d = iBinder;
            this.f8485f = componentName;
            Iterator<ServiceConnection> it = this.f8480a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceConnected(componentName, iBinder);
            }
            this.f8481b = 1;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        HashMap hashMap;
        Handler handler;
        hashMap = this.f8486g.f7911c;
        synchronized (hashMap) {
            handler = this.f8486g.f7913e;
            handler.removeMessages(1, this.f8484e);
            this.f8483d = null;
            this.f8485f = componentName;
            Iterator<ServiceConnection> it = this.f8480a.values().iterator();
            while (it.hasNext()) {
                it.next().onServiceDisconnected(componentName);
            }
            this.f8481b = 2;
        }
    }
}
