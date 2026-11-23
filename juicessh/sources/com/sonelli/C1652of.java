package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.gtm.zzbw;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* renamed from: com.sonelli.of */
/* loaded from: classes.dex */
public final class C1652of extends AbstractC2006uf {

    /* renamed from: Q */
    public final C1159ig f5478Q;

    public C1652of(C2216wf c2216wf, C2342yf c2342yf) {
        super(c2216wf);
        C0813ca.m2729k(c2342yf);
        this.f5478Q = new C1159ig(c2216wf, c2342yf);
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        this.f5478Q.m8877D0();
    }

    /* renamed from: G0 */
    public final void m7016G0() {
        C1434k4.m5823i();
        this.f5478Q.m4755G0();
    }

    /* renamed from: H0 */
    public final void m7017H0() {
        this.f5478Q.m4756H0();
    }

    /* renamed from: I0 */
    public final long m7018I0(C2424zf c2424zf) {
        m8878F0();
        C0813ca.m2729k(c2424zf);
        C1434k4.m5823i();
        long m4757I0 = this.f5478Q.m4757I0(c2424zf, true);
        if (m4757I0 == 0) {
            this.f5478Q.m4760M0(c2424zf);
        }
        return m4757I0;
    }

    /* renamed from: K0 */
    public final void m7019K0(zzbw zzbwVar) {
        m8878F0();
        m8662j0().m5829e(new RunnableC1814rf(this, zzbwVar));
    }

    /* renamed from: L0 */
    public final void m7020L0(C1043gh c1043gh) {
        C0813ca.m2729k(c1043gh);
        m8878F0();
        m8653Z("Hit delivery requested", c1043gh);
        m8662j0().m5829e(new RunnableC1758qf(this, c1043gh));
    }

    /* renamed from: M0 */
    public final void m7021M0() {
        m8878F0();
        Context m8675x = m8675x();
        if (!C1817rh.m7905b(m8675x) || !C1860sh.m8431i(m8675x)) {
            m7019K0(null);
            return;
        }
        Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        intent.setComponent(new ComponentName(m8675x, "com.google.android.gms.analytics.AnalyticsService"));
        m8675x.startService(intent);
    }

    /* renamed from: N0 */
    public final boolean m7022N0() {
        m8878F0();
        try {
            m8662j0().m5828c(new CallableC1858sf(this)).get(4L, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            m8672t0("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            m8674w0("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            m8672t0("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    /* renamed from: O0 */
    public final void m7023O0() {
        m8878F0();
        C1434k4.m5823i();
        C1159ig c1159ig = this.f5478Q;
        C1434k4.m5823i();
        c1159ig.m8878F0();
        c1159ig.m8676x0("Service disconnected");
    }

    /* renamed from: P0 */
    public final void m7024P0() {
        C1434k4.m5823i();
        this.f5478Q.m4762P0();
    }
}
