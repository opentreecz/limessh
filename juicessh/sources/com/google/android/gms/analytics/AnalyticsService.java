package com.google.android.gms.analytics;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.internal.gtm.zzcu;
import com.sonelli.C1860sh;

/* loaded from: classes.dex */
public final class AnalyticsService extends Service implements zzcu {

    /* renamed from: O */
    public C1860sh<AnalyticsService> f531O;

    /* renamed from: a */
    public final C1860sh<AnalyticsService> m811a() {
        if (this.f531O == null) {
            this.f531O = new C1860sh<>(this);
        }
        return this.f531O;
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    /* renamed from: b */
    public final void mo809b(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    /* renamed from: c */
    public final boolean mo810c(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        m811a();
        return null;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        m811a().m8432a();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        m811a().m8433b();
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        return m811a().m8434c(intent, i, i2);
    }
}
