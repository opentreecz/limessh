package cz.opentree;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.internal.gtm.zzcu;
import com.google.android.gms.stats.WakeLock;

/* renamed from: cz.opentree.sh */
/* loaded from: classes.dex */
public final class C1860sh<T extends Context & zzcu> {

    /* renamed from: c */
    public static Boolean f6439c;

    /* renamed from: a */
    public final Handler f6440a;

    /* renamed from: b */
    public final T f6441b;

    public C1860sh(T t) {
        C0813ca.m2729k(t);
        this.f6441b = t;
        this.f6440a = new HandlerC1161ii();
    }

    /* renamed from: i */
    public static boolean m8431i(Context context) {
        C0813ca.m2729k(context);
        Boolean bool = f6439c;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean m2086o = C0713ai.m2086o(context, "com.google.android.gms.analytics.AnalyticsService");
        f6439c = Boolean.valueOf(m2086o);
        return m2086o;
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: a */
    public final void m8432a() {
        C2216wf.m9474c(this.f6441b).m9477e().m8676x0("Local AnalyticsService is starting up");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: b */
    public final void m8433b() {
        C2216wf.m9474c(this.f6441b).m9477e().m8676x0("Local AnalyticsService is shutting down");
    }

    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    /* renamed from: c */
    public final int m8434c(Intent intent, int i, final int i2) {
        try {
            synchronized (C1817rh.f6210a) {
                WakeLock wakeLock = C1817rh.f6211b;
                if (wakeLock != null && wakeLock.m1513b()) {
                    wakeLock.m1514c();
                }
            }
        } catch (SecurityException unused) {
        }
        final C1451kh m9477e = C2216wf.m9474c(this.f6441b).m9477e();
        if (intent == null) {
            m9477e.m8649A0("AnalyticsService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        m9477e.m8651D("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            m8438h(new Runnable(this, i2, m9477e) { // from class: cz.opentree.th

                /* renamed from: O */
                public final C1860sh f6766O;

                /* renamed from: P */
                public final int f6767P;

                /* renamed from: Q */
                public final C1451kh f6768Q;

                {
                    this.f6766O = this;
                    this.f6767P = i2;
                    this.f6768Q = m9477e;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f6766O.m8436f(this.f6767P, this.f6768Q);
                }
            });
        }
        return 2;
    }

    @TargetApi(24)
    /* renamed from: d */
    public final boolean m8435d(final JobParameters jobParameters) {
        final C1451kh m9477e = C2216wf.m9474c(this.f6441b).m9477e();
        String string = jobParameters.getExtras().getString("action");
        m9477e.m8679z("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        m8438h(new Runnable(this, m9477e, jobParameters) { // from class: cz.opentree.uh

            /* renamed from: O */
            public final C1860sh f6963O;

            /* renamed from: P */
            public final C1451kh f6964P;

            /* renamed from: Q */
            public final JobParameters f6965Q;

            {
                this.f6963O = this;
                this.f6964P = m9477e;
                this.f6965Q = jobParameters;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f6963O.m8437g(this.f6964P, this.f6965Q);
            }
        });
        return true;
    }

    /* renamed from: f */
    public final /* synthetic */ void m8436f(int i, C1451kh c1451kh) {
        if (this.f6441b.mo810c(i)) {
            c1451kh.m8676x0("Local AnalyticsService processed last dispatch request");
        }
    }

    /* renamed from: g */
    public final /* synthetic */ void m8437g(C1451kh c1451kh, JobParameters jobParameters) {
        c1451kh.m8676x0("AnalyticsJobService processed last dispatch request");
        this.f6441b.mo809b(jobParameters, false);
    }

    /* renamed from: h */
    public final void m8438h(Runnable runnable) {
        C2216wf.m9474c(this.f6441b).m9480h().m7019K0(new C2170vh(this, runnable));
    }
}
