package com.sonelli;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzjp;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class e30<T extends Context & zzjp> {

    /* renamed from: a */
    public final T f2328a;

    public e30(T t) {
        C0813ca.m2729k(t);
        this.f2328a = t;
    }

    @MainThread
    /* renamed from: a */
    public final int m3397a(final Intent intent, int i, final int i2) {
        C2144uz m9091a = C2144uz.m9091a(this.f2328a, null, null);
        final C1889sy mo1484j = m9091a.mo1484j();
        if (intent == null) {
            mo1484j.m8525K().m9083a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        m9091a.mo1480f();
        mo1484j.m8530P().m9085c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            m3402f(new Runnable(this, i2, mo1484j, intent) { // from class: com.sonelli.h30

                /* renamed from: O */
                public final e30 f3083O;

                /* renamed from: P */
                public final int f3084P;

                /* renamed from: Q */
                public final C1889sy f3085Q;

                /* renamed from: R */
                public final Intent f3086R;

                {
                    this.f3083O = this;
                    this.f3084P = i2;
                    this.f3085Q = mo1484j;
                    this.f3086R = intent;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f3083O.m3400d(this.f3084P, this.f3085Q, this.f3086R);
                }
            });
        }
        return 2;
    }

    @MainThread
    /* renamed from: b */
    public final IBinder m3398b(Intent intent) {
        if (intent == null) {
            m3406j().m8522H().m9083a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new a00(z30.m10331c(this.f2328a));
        }
        m3406j().m8525K().m9084b("onBind received unknown action", action);
        return null;
    }

    @MainThread
    /* renamed from: c */
    public final void m3399c() {
        C2144uz m9091a = C2144uz.m9091a(this.f2328a, null, null);
        C1889sy mo1484j = m9091a.mo1484j();
        m9091a.mo1480f();
        mo1484j.m8530P().m9083a("Local AppMeasurementService is starting up");
    }

    /* renamed from: d */
    public final /* synthetic */ void m3400d(int i, C1889sy c1889sy, Intent intent) {
        if (this.f2328a.mo1444c(i)) {
            c1889sy.m8530P().m9084b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            m3406j().m8530P().m9083a("Completed wakeful intent.");
            this.f2328a.mo1442a(intent);
        }
    }

    /* renamed from: e */
    public final /* synthetic */ void m3401e(C1889sy c1889sy, JobParameters jobParameters) {
        c1889sy.m8530P().m9083a("AppMeasurementJobService processed last upload request.");
        this.f2328a.mo1443b(jobParameters, false);
    }

    /* renamed from: f */
    public final void m3402f(Runnable runnable) {
        z30 m10331c = z30.m10331c(this.f2328a);
        m10331c.mo1481g().m8281A(new i30(this, m10331c, runnable));
    }

    @TargetApi(24)
    @MainThread
    /* renamed from: g */
    public final boolean m3403g(final JobParameters jobParameters) {
        C2144uz m9091a = C2144uz.m9091a(this.f2328a, null, null);
        final C1889sy mo1484j = m9091a.mo1484j();
        String string = jobParameters.getExtras().getString("action");
        m9091a.mo1480f();
        mo1484j.m8530P().m9084b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        m3402f(new Runnable(this, mo1484j, jobParameters) { // from class: com.sonelli.g30

            /* renamed from: O */
            public final e30 f2812O;

            /* renamed from: P */
            public final C1889sy f2813P;

            /* renamed from: Q */
            public final JobParameters f2814Q;

            {
                this.f2812O = this;
                this.f2813P = mo1484j;
                this.f2814Q = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f2812O.m3401e(this.f2813P, this.f2814Q);
            }
        });
        return true;
    }

    @MainThread
    /* renamed from: h */
    public final void m3404h() {
        C2144uz m9091a = C2144uz.m9091a(this.f2328a, null, null);
        C1889sy mo1484j = m9091a.mo1484j();
        m9091a.mo1480f();
        mo1484j.m8530P().m9083a("Local AppMeasurementService is shutting down");
    }

    @MainThread
    /* renamed from: i */
    public final boolean m3405i(Intent intent) {
        if (intent == null) {
            m3406j().m8522H().m9083a("onUnbind called with null intent");
            return true;
        }
        m3406j().m8530P().m9084b("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    /* renamed from: j */
    public final C1889sy m3406j() {
        return C2144uz.m9091a(this.f2328a, null, null).mo1484j();
    }

    @MainThread
    /* renamed from: k */
    public final void m3407k(Intent intent) {
        if (intent == null) {
            m3406j().m8522H().m9083a("onRebind called with null intent");
        } else {
            m3406j().m8530P().m9084b("onRebind called. action", intent.getAction());
        }
    }
}
