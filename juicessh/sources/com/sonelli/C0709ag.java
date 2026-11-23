package com.sonelli;

import android.content.ComponentName;
import android.os.RemoteException;
import com.google.android.gms.internal.gtm.zzce;
import java.util.Collections;

/* renamed from: com.sonelli.ag */
/* loaded from: classes.dex */
public final class C0709ag extends AbstractC2006uf {

    /* renamed from: Q */
    public final ServiceConnectionC0821cg f1377Q;

    /* renamed from: R */
    public zzce f1378R;

    /* renamed from: S */
    public final AbstractC2217wg f1379S;

    /* renamed from: T */
    public final C2221wh f1380T;

    public C0709ag(C2216wf c2216wf) {
        super(c2216wf);
        this.f1380T = new C2221wh(c2216wf.m9476d());
        this.f1377Q = new ServiceConnectionC0821cg(this);
        this.f1379S = new C0768bg(this, c2216wf);
    }

    @Override // com.sonelli.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
    }

    /* renamed from: G0 */
    public final boolean m2054G0() {
        C1434k4.m5823i();
        m8878F0();
        if (this.f1378R != null) {
            return true;
        }
        zzce m2784a = this.f1377Q.m2784a();
        if (m2784a == null) {
            return false;
        }
        this.f1378R = m2784a;
        m2060Q0();
        return true;
    }

    /* renamed from: H0 */
    public final void m2055H0() {
        C1434k4.m5823i();
        m8878F0();
        try {
            C1926tb.m8637b().m8639c(m8675x(), this.f1377Q);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        if (this.f1378R != null) {
            this.f1378R = null;
            m8664l0().m7023O0();
        }
    }

    /* renamed from: I0 */
    public final boolean m2056I0() {
        C1434k4.m5823i();
        m8878F0();
        return this.f1378R != null;
    }

    /* renamed from: J0 */
    public final void m2057J0(ComponentName componentName) {
        C1434k4.m5823i();
        if (this.f1378R != null) {
            this.f1378R = null;
            m8679z("Disconnected from device AnalyticsService", componentName);
            m8664l0().m7023O0();
        }
    }

    /* renamed from: N0 */
    public final void m2058N0(zzce zzceVar) {
        C1434k4.m5823i();
        this.f1378R = zzceVar;
        m2060Q0();
        m8664l0().m7016G0();
    }

    /* renamed from: P0 */
    public final boolean m2059P0(C1043gh c1043gh) {
        C0813ca.m2729k(c1043gh);
        C1434k4.m5823i();
        m8878F0();
        zzce zzceVar = this.f1378R;
        if (zzceVar == null) {
            return false;
        }
        try {
            zzceVar.mo1216z0(c1043gh.m4126e(), c1043gh.m4129h(), c1043gh.m4131j() ? C2007ug.m8885h() : C2007ug.m8886i(), Collections.emptyList());
            m2060Q0();
            return true;
        } catch (RemoteException unused) {
            m8676x0("Failed to send hits to AnalyticsService");
            return false;
        }
    }

    /* renamed from: Q0 */
    public final void m2060Q0() {
        this.f1380T.m9520b();
        this.f1379S.m9501h(C0770bh.f1701z.m2801a().longValue());
    }

    /* renamed from: R0 */
    public final void m2061R0() {
        C1434k4.m5823i();
        if (m2056I0()) {
            m8676x0("Inactivity, disconnecting from device AnalyticsService");
            m2055H0();
        }
    }
}
