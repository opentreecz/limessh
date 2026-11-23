package com.sonelli;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.WorkerThread;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.analytics.connector.internal.zza;
import com.google.firebase.events.Subscriber;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public class i70 implements AnalyticsConnector {

    /* renamed from: c */
    public static volatile AnalyticsConnector f3269c;

    /* renamed from: a */
    public final AppMeasurement f3270a;

    /* renamed from: b */
    public final Map<String, zza> f3271b;

    /* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
    /* renamed from: com.sonelli.i70$a */
    /* loaded from: classes.dex */
    public class C1148a implements AnalyticsConnector.AnalyticsConnectorHandle {
        public C1148a(i70 i70Var, String str) {
        }
    }

    public i70(AppMeasurement appMeasurement) {
        C0813ca.m2729k(appMeasurement);
        this.f3270a = appMeasurement;
        this.f3271b = new ConcurrentHashMap();
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK"})
    /* renamed from: c */
    public static AnalyticsConnector m4723c(FirebaseApp firebaseApp, Context context, Subscriber subscriber) {
        C0813ca.m2729k(firebaseApp);
        C0813ca.m2729k(context);
        C0813ca.m2729k(subscriber);
        C0813ca.m2729k(context.getApplicationContext());
        if (f3269c == null) {
            synchronized (i70.class) {
                if (f3269c == null) {
                    Bundle bundle = new Bundle(1);
                    if (firebaseApp.m1586q()) {
                        subscriber.mo1863b(e70.class, q70.f5950a, p70.f5633a);
                        bundle.putBoolean("dataCollectionDefaultEnabled", firebaseApp.m1585p());
                    }
                    f3269c = new i70(AppMeasurement.m1436b(context, bundle));
                }
            }
        }
        return f3269c;
    }

    /* renamed from: d */
    public static final /* synthetic */ void m4724d(dd0 dd0Var) {
        boolean z = ((e70) dd0Var.m3191a()).f2343a;
        synchronized (i70.class) {
            ((i70) f3269c).f3270a.m1440d(z);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    /* renamed from: a */
    public void mo1595a(@NonNull String str, @NonNull String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (l70.m6091a(str) && l70.m6092b(str2, bundle) && l70.m6093c(str, str2, bundle)) {
            l70.m6094d(str, str2, bundle);
            this.f3270a.logEventInternal(str, str2, bundle);
        }
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector
    @WorkerThread
    /* renamed from: b */
    public AnalyticsConnector.AnalyticsConnectorHandle mo1596b(@NonNull String str, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        C0813ca.m2729k(analyticsConnectorListener);
        if (!l70.m6091a(str) || m4725e(str)) {
            return null;
        }
        AppMeasurement appMeasurement = this.f3270a;
        zza k70Var = "fiam".equals(str) ? new k70(appMeasurement, analyticsConnectorListener) : ("crash".equals(str) || "clx".equals(str)) ? new m70(appMeasurement, analyticsConnectorListener) : null;
        if (k70Var == null) {
            return null;
        }
        this.f3271b.put(str, k70Var);
        return new C1148a(this, str);
    }

    /* renamed from: e */
    public final boolean m4725e(@NonNull String str) {
        return (str.isEmpty() || !this.f3271b.containsKey(str) || this.f3271b.get(str) == null) ? false : true;
    }
}
