package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.internal.gtm.zzcu;
import com.sonelli.C1860sh;

@TargetApi(24)
/* loaded from: classes.dex */
public final class AnalyticsJobService extends JobService implements zzcu {

    /* renamed from: O */
    public C1860sh<AnalyticsJobService> f529O;

    /* renamed from: a */
    public final C1860sh<AnalyticsJobService> m808a() {
        if (this.f529O == null) {
            this.f529O = new C1860sh<>(this);
        }
        return this.f529O;
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    @TargetApi(24)
    /* renamed from: b */
    public final void mo809b(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.internal.gtm.zzcu
    /* renamed from: c */
    public final boolean mo810c(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        m808a().m8432a();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        m808a().m8433b();
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        return m808a().m8434c(intent, i, i2);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return m808a().m8435d(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
