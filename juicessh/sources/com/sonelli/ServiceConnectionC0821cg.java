package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzce;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;

/* renamed from: com.sonelli.cg */
/* loaded from: classes.dex */
public final class ServiceConnectionC0821cg implements ServiceConnection {

    /* renamed from: a */
    public volatile zzce f1929a;

    /* renamed from: b */
    public volatile boolean f1930b;

    /* renamed from: c */
    public final /* synthetic */ C0709ag f1931c;

    public ServiceConnectionC0821cg(C0709ag c0709ag) {
        this.f1931c = c0709ag;
    }

    /* renamed from: a */
    public final zzce m2784a() {
        ServiceConnectionC0821cg serviceConnectionC0821cg;
        C1434k4.m5823i();
        Intent intent = new Intent("com.google.android.gms.analytics.service.START");
        intent.setComponent(new ComponentName("com.google.android.gms", "com.google.android.gms.analytics.service.AnalyticsService"));
        Context m8675x = this.f1931c.m8675x();
        intent.putExtra("app_package_name", m8675x.getPackageName());
        C1926tb m8637b = C1926tb.m8637b();
        synchronized (this) {
            this.f1929a = null;
            this.f1930b = true;
            serviceConnectionC0821cg = this.f1931c.f1377Q;
            boolean m8638a = m8637b.m8638a(m8675x, intent, serviceConnectionC0821cg, KeycodeConstants.KEYCODE_MEDIA_EJECT);
            this.f1931c.m8679z("Bind to service requested", Boolean.valueOf(m8638a));
            if (!m8638a) {
                this.f1930b = false;
                return null;
            }
            try {
                wait(C0770bh.f1671A.m2801a().longValue());
            } catch (InterruptedException unused) {
                this.f1931c.m8649A0("Wait for service connect was interrupted");
            }
            this.f1930b = false;
            zzce zzceVar = this.f1929a;
            this.f1929a = null;
            if (zzceVar == null) {
                this.f1931c.m8650B0("Successfully bound to service but never got onServiceConnected callback");
            }
            return zzceVar;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        ServiceConnectionC0821cg serviceConnectionC0821cg;
        C0813ca.m2724f("AnalyticsServiceConnection.onServiceConnected");
        synchronized (this) {
            try {
                if (iBinder == null) {
                    this.f1931c.m8650B0("Service connected with null binder");
                    return;
                }
                zzce zzceVar = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.analytics.internal.IAnalyticsService".equals(interfaceDescriptor)) {
                        if (iBinder != null) {
                            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.analytics.internal.IAnalyticsService");
                            zzceVar = queryLocalInterface instanceof zzce ? (zzce) queryLocalInterface : new C1108hh(iBinder);
                        }
                        this.f1931c.m8676x0("Bound to IAnalyticsService interface");
                    } else {
                        this.f1931c.m8674w0("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException unused) {
                    this.f1931c.m8650B0("Service connect failed to get IAnalyticsService");
                }
                if (zzceVar == null) {
                    try {
                        C1926tb m8637b = C1926tb.m8637b();
                        Context m8675x = this.f1931c.m8675x();
                        serviceConnectionC0821cg = this.f1931c.f1377Q;
                        m8637b.m8639c(m8675x, serviceConnectionC0821cg);
                    } catch (IllegalArgumentException unused2) {
                    }
                } else if (this.f1930b) {
                    this.f1929a = zzceVar;
                } else {
                    this.f1931c.m8649A0("onServiceConnected received after the timeout limit");
                    this.f1931c.m8662j0().m5829e(new RunnableC0873dg(this, zzceVar));
                }
            } finally {
                notifyAll();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        C0813ca.m2724f("AnalyticsServiceConnection.onServiceDisconnected");
        this.f1931c.m8662j0().m5829e(new RunnableC0925eg(this, componentName));
    }
}
