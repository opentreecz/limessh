package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzjp;
import cz.opentree.e30;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
@TargetApi(24)
/* loaded from: classes.dex */
public final class AppMeasurementJobService extends JobService implements zzjp {

    /* renamed from: O */
    public e30<AppMeasurementJobService> f976O;

    @Override // com.google.android.gms.measurement.internal.zzjp
    /* renamed from: a */
    public final void mo1442a(Intent intent) {
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    @TargetApi(24)
    /* renamed from: b */
    public final void mo1443b(JobParameters jobParameters, boolean z) {
        jobFinished(jobParameters, false);
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    /* renamed from: c */
    public final boolean mo1444c(int i) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public final e30<AppMeasurementJobService> m1445d() {
        if (this.f976O == null) {
            this.f976O = new e30<>(this);
        }
        return this.f976O;
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        m1445d().m3399c();
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        m1445d().m3404h();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        m1445d().m3407k(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        return m1445d().m3403g(jobParameters);
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        return m1445d().m3405i(intent);
    }
}
