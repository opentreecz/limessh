package cz.opentree;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t30 {

    /* renamed from: a */
    public final /* synthetic */ k30 f6705a;

    public t30(k30 k30Var) {
        this.f6705a = k30Var;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m8587a() {
        this.f6705a.mo7585d();
        if (this.f6705a.m7589n().m3600x(this.f6705a.mo1483i().mo1177a())) {
            this.f6705a.m7589n().f2573r.m4291a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f6705a.mo1484j().m8530P().m9083a("Detected application was in foreground");
                m8589c(this.f6705a.mo1483i().mo1177a(), false);
            }
        }
    }

    @WorkerThread
    /* renamed from: b */
    public final void m8588b(long j, boolean z) {
        this.f6705a.mo7585d();
        this.f6705a.m5800G();
        if (this.f6705a.m7589n().m3600x(j)) {
            this.f6705a.m7589n().f2573r.m4291a(true);
        }
        this.f6705a.m7589n().f2577v.m4969b(j);
        if (this.f6705a.m7589n().f2573r.m4292b()) {
            m8589c(j, z);
        }
    }

    @WorkerThread
    /* renamed from: c */
    public final void m8589c(long j, boolean z) {
        this.f6705a.mo7585d();
        if (this.f6705a.f5899a.m9122q()) {
            this.f6705a.m7589n().f2577v.m4969b(j);
            this.f6705a.mo1484j().m8530P().m9084b("Session started, time", Long.valueOf(this.f6705a.mo1483i().mo1178b()));
            Long valueOf = Long.valueOf(j / 1000);
            this.f6705a.m10662q().m10012V("auto", "_sid", valueOf, j);
            this.f6705a.m7589n().f2573r.m4291a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", valueOf.longValue());
            if (this.f6705a.m7590o().m2630u(C1735pu.f5860s0) && z) {
                bundle.putLong("_aib", 1L);
            }
            this.f6705a.m10662q().m10006P("auto", "_s", j, bundle);
            if (C1520lr.m6279b() && this.f6705a.m7590o().m2630u(C1735pu.f5870x0)) {
                String m6012a = this.f6705a.m7589n().f2554A.m6012a();
                if (TextUtils.isEmpty(m6012a)) {
                    return;
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("_ffr", m6012a);
                this.f6705a.m10662q().m10006P("auto", "_ssr", j, bundle2);
            }
        }
    }
}
