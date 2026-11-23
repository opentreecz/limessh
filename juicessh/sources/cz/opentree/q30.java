package cz.opentree;

import android.os.Bundle;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q30 {

    /* renamed from: a */
    public long f5927a;

    /* renamed from: b */
    public long f5928b;

    /* renamed from: c */
    public final AbstractC1127hu f5929c;

    /* renamed from: d */
    public final /* synthetic */ k30 f5930d;

    public q30(k30 k30Var) {
        this.f5930d = k30Var;
        this.f5929c = new p30(this, k30Var.f5899a);
        long mo1178b = k30Var.mo1483i().mo1178b();
        this.f5927a = mo1178b;
        this.f5928b = mo1178b;
    }

    /* renamed from: a */
    public final void m7608a() {
        this.f5929c.m4651e();
        this.f5927a = 0L;
        this.f5928b = 0L;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m7609b(long j) {
        this.f5930d.mo7585d();
        this.f5929c.m4651e();
        this.f5927a = j;
        this.f5928b = j;
    }

    @WorkerThread
    /* renamed from: d */
    public final boolean m7610d(boolean z, boolean z2, long j) {
        this.f5930d.mo7585d();
        this.f5930d.m2299y();
        if (!C1946tr.m8792b() || !this.f5930d.m7590o().m2630u(C1735pu.f5783C0)) {
            j = this.f5930d.mo1483i().mo1178b();
        }
        if (!C2310xr.m9876b() || !this.f5930d.m7590o().m2630u(C1735pu.f5872y0) || this.f5930d.f5899a.m9122q()) {
            this.f5930d.m7589n().f2577v.m4969b(this.f5930d.mo1483i().mo1177a());
        }
        long j2 = j - this.f5927a;
        if (!z && j2 < 1000) {
            this.f5930d.mo1484j().m8530P().m9084b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
            return false;
        }
        if (this.f5930d.m7590o().m2630u(C1735pu.f5818V) && !z2) {
            j2 = (C0736as.m2268b() && this.f5930d.m7590o().m2630u(C1735pu.f5820X) && C1946tr.m8792b() && this.f5930d.m7590o().m2630u(C1735pu.f5783C0)) ? m7613g(j) : m7611e();
        }
        this.f5930d.mo1484j().m8530P().m9084b("Recording user engagement, ms", Long.valueOf(j2));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j2);
        a20.m1959M(this.f5930d.m10665t().m1961E(!this.f5930d.m7590o().m2619M().booleanValue()), bundle, true);
        if (this.f5930d.m7590o().m2630u(C1735pu.f5818V) && !this.f5930d.m7590o().m2630u(C1735pu.f5819W) && z2) {
            bundle.putLong("_fr", 1L);
        }
        if (!this.f5930d.m7590o().m2630u(C1735pu.f5819W) || !z2) {
            this.f5930d.m10662q().m10009S("auto", "_e", bundle);
        }
        this.f5927a = j;
        this.f5929c.m4651e();
        this.f5929c.m4649c(3600000L);
        return true;
    }

    @WorkerThread
    /* renamed from: e */
    public final long m7611e() {
        long mo1178b = this.f5930d.mo1483i().mo1178b();
        long j = mo1178b - this.f5928b;
        this.f5928b = mo1178b;
        return j;
    }

    @WorkerThread
    /* renamed from: f */
    public final void m7612f(long j) {
        this.f5929c.m4651e();
    }

    @WorkerThread
    /* renamed from: g */
    public final long m7613g(long j) {
        long j2 = j - this.f5928b;
        this.f5928b = j;
        return j2;
    }

    @WorkerThread
    /* renamed from: h */
    public final void m7614h() {
        this.f5930d.mo7585d();
        m7610d(false, false, this.f5930d.mo1483i().mo1178b());
        this.f5930d.m10661p().m9893w(this.f5930d.mo1483i().mo1178b());
    }
}
