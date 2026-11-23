package cz.opentree;

import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class e10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ long f2317O;

    /* renamed from: P */
    public final /* synthetic */ y00 f2318P;

    public e10(y00 y00Var, long j) {
        this.f2318P = y00Var;
        this.f2317O = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y00 y00Var = this.f2318P;
        long j = this.f2317O;
        y00Var.mo7585d();
        y00Var.mo7583b();
        y00Var.m2299y();
        y00Var.mo1484j().m8529O().m9083a("Resetting analytics data (FE)");
        k30 m10667v = y00Var.m10667v();
        m10667v.mo7585d();
        m10667v.f4451e.m7608a();
        boolean m9122q = y00Var.f5899a.m9122q();
        C0960ez m7589n = y00Var.m7589n();
        m7589n.f2565j.m4969b(j);
        if (!TextUtils.isEmpty(m7589n.m7589n().f2554A.m6012a())) {
            m7589n.f2554A.m6013b(null);
        }
        if (C2310xr.m9876b() && m7589n.m7590o().m2630u(C1735pu.f5872y0)) {
            m7589n.f2577v.m4969b(0L);
        }
        if (!m7589n.m7590o().m2615I()) {
            m7589n.m3586B(!m9122q);
        }
        m7589n.f2555B.m6013b(null);
        m7589n.f2556C.m4969b(0L);
        m7589n.f2557D.m5747b(null);
        y00Var.m10664s().m3957X();
        if (C2310xr.m9876b() && y00Var.m7590o().m2630u(C1735pu.f5872y0)) {
            y00Var.m10667v().f4450d.m8587a();
        }
        y00Var.f8102i = !m9122q;
        this.f2318P.m10664s().m3952S(new AtomicReference<>());
    }
}
