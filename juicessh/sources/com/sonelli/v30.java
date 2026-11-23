package com.sonelli;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class v30 extends w30 {

    /* renamed from: d */
    public final AlarmManager f7402d;

    /* renamed from: e */
    public final AbstractC1127hu f7403e;

    /* renamed from: f */
    public Integer f7404f;

    public v30(z30 z30Var) {
        super(z30Var);
        this.f7402d = (AlarmManager) mo1482h().getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f7403e = new u30(this, z30Var.m10370f0(), z30Var);
    }

    /* renamed from: A */
    public final PendingIntent m9160A() {
        Context mo1482h = mo1482h();
        return PendingIntent.getBroadcast(mo1482h, 0, new Intent().setClassName(mo1482h, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), 0);
    }

    @Override // com.sonelli.w30
    /* renamed from: v */
    public final boolean mo2315v() {
        this.f7402d.cancel(m9160A());
        if (Build.VERSION.SDK_INT < 24) {
            return false;
        }
        m9163y();
        return false;
    }

    /* renamed from: w */
    public final void m9161w(long j) {
        m9404t();
        mo1480f();
        Context mo1482h = mo1482h();
        if (!C1683oz.m7134b(mo1482h)) {
            mo1484j().m8529O().m9083a("Receiver not registered/enabled");
        }
        if (!g40.m3991X(mo1482h, false)) {
            mo1484j().m8529O().m9083a("Service not registered/enabled");
        }
        m9162x();
        mo1484j().m8530P().m9084b("Scheduling upload, millis", Long.valueOf(j));
        long mo1178b = mo1483i().mo1178b() + j;
        if (j < Math.max(0L, C1735pu.f5871y.m6320a(null).longValue()) && !this.f7403e.m4650d()) {
            this.f7403e.m4649c(j);
        }
        mo1480f();
        if (Build.VERSION.SDK_INT < 24) {
            this.f7402d.setInexactRepeating(2, mo1178b, Math.max(C1735pu.f5861t.m6320a(null).longValue(), j), m9160A());
            return;
        }
        Context mo1482h2 = mo1482h();
        ComponentName componentName = new ComponentName(mo1482h2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int m9164z = m9164z();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        C0840cp.m2896b(mo1482h2, new JobInfo.Builder(m9164z, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    /* renamed from: x */
    public final void m9162x() {
        m9404t();
        mo1484j().m8530P().m9083a("Unscheduling upload");
        this.f7402d.cancel(m9160A());
        this.f7403e.m4651e();
        if (Build.VERSION.SDK_INT >= 24) {
            m9163y();
        }
    }

    @TargetApi(24)
    /* renamed from: y */
    public final void m9163y() {
        ((JobScheduler) mo1482h().getSystemService("jobscheduler")).cancel(m9164z());
    }

    /* renamed from: z */
    public final int m9164z() {
        if (this.f7404f == null) {
            String valueOf = String.valueOf(mo1482h().getPackageName());
            this.f7404f = Integer.valueOf((valueOf.length() != 0 ? "measurement".concat(valueOf) : new String("measurement")).hashCode());
        }
        return this.f7404f.intValue();
    }
}
