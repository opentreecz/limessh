package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzjp;
import com.sonelli.e30;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class AppMeasurementService extends Service implements zzjp {

    /* renamed from: O */
    public e30<AppMeasurementService> f978O;

    @Override // com.google.android.gms.measurement.internal.zzjp
    /* renamed from: a */
    public final void mo1442a(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    /* renamed from: b */
    public final void mo1443b(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.measurement.internal.zzjp
    /* renamed from: c */
    public final boolean mo1444c(int i) {
        return stopSelfResult(i);
    }

    /* renamed from: d */
    public final e30<AppMeasurementService> m1447d() {
        if (this.f978O == null) {
            this.f978O = new e30<>(this);
        }
        return this.f978O;
    }

    @Override // android.app.Service
    @MainThread
    public final IBinder onBind(Intent intent) {
        return m1447d().m3398b(intent);
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        m1447d().m3399c();
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        m1447d().m3404h();
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        m1447d().m3407k(intent);
    }

    @Override // android.app.Service
    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return m1447d().m3397a(intent, i, i2);
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        return m1447d().m3405i(intent);
    }
}
