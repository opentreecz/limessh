package cz.opentree;

import cz.opentree.iv0;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public class rz0 extends iv0.AbstractC1180b {
    public rz0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public rz0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        hv0 hv0Var = this.f3428b;
        if (hv0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        hv0 hv0Var2 = this.f3429c;
        hv0 hv0Var3 = this.f3430d[0];
        boolean mo2282h = hv0Var3.mo2282h();
        hv0 mo2287o = mo2282h ? hv0Var3 : hv0Var3.mo2287o();
        hv0 mo2277a = mo2282h ? hv0Var2.mo2287o().mo2277a(hv0Var2) : hv0Var2.mo2277a(hv0Var3).mo2284j(hv0Var2);
        if (mo2277a.mo2283i()) {
            return new rz0(m4937h, mo2277a, m4937h.m4267m());
        }
        hv0 mo2287o2 = mo2277a.mo2287o();
        hv0 mo2284j = mo2282h ? mo2277a : mo2277a.mo2284j(mo2287o);
        hv0 mo2287o3 = hv0Var2.mo2277a(hv0Var).mo2287o();
        if (!mo2282h) {
            hv0Var3 = mo2287o.mo2287o();
        }
        return new rz0(m4937h, mo2287o2, mo2287o3.mo2277a(mo2277a).mo2277a(mo2287o).mo2284j(mo2287o3).mo2277a(hv0Var3).mo2277a(mo2287o2).mo2277a(mo2284j), new hv0[]{mo2284j});
    }

    @Override // cz.opentree.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        if (m4945r()) {
            return iv0Var;
        }
        if (iv0Var.m4945r()) {
            return mo2638C();
        }
        gv0 m4937h = m4937h();
        hv0 hv0Var = this.f3428b;
        if (hv0Var.mo2283i()) {
            return iv0Var;
        }
        hv0 m4940l = iv0Var.m4940l();
        hv0 mo4943p = iv0Var.mo4943p(0);
        if (m4940l.mo2283i() || !mo4943p.mo2282h()) {
            return mo2638C().mo2641a(iv0Var);
        }
        hv0 hv0Var2 = this.f3429c;
        hv0 hv0Var3 = this.f3430d[0];
        hv0 m4941m = iv0Var.m4941m();
        hv0 mo2287o = hv0Var.mo2287o();
        hv0 mo2287o2 = hv0Var2.mo2287o();
        hv0 mo2287o3 = hv0Var3.mo2287o();
        hv0 mo2277a = mo2287o2.mo2277a(hv0Var2.mo2284j(hv0Var3));
        hv0 mo2278b = m4941m.mo2278b();
        hv0 mo3339l = mo2278b.mo2284j(mo2287o3).mo2277a(mo2287o2).mo3339l(mo2277a, mo2287o, mo2287o3);
        hv0 mo2284j = m4940l.mo2284j(mo2287o3);
        hv0 mo2287o4 = mo2284j.mo2277a(mo2277a).mo2287o();
        if (mo2287o4.mo2283i()) {
            return mo3339l.mo2283i() ? iv0Var.mo2638C() : m4937h.mo2308r();
        }
        if (mo3339l.mo2283i()) {
            return new rz0(m4937h, mo3339l, m4937h.m4267m());
        }
        hv0 mo2284j2 = mo3339l.mo2287o().mo2284j(mo2284j);
        hv0 mo2284j3 = mo3339l.mo2284j(mo2287o4).mo2284j(mo2287o3);
        return new rz0(m4937h, mo2284j2, mo3339l.mo2277a(mo2287o4).mo2287o().mo3339l(mo2277a, mo2278b, mo2284j3), new hv0[]{mo2284j3});
    }

    @Override // cz.opentree.iv0
    /* renamed from: a */
    public iv0 mo2641a(iv0 iv0Var) {
        long[] jArr;
        long[] jArr2;
        long[] jArr3;
        pz0 pz0Var;
        pz0 pz0Var2;
        pz0 pz0Var3;
        if (m4945r()) {
            return iv0Var;
        }
        if (iv0Var.m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        pz0 pz0Var4 = (pz0) this.f3428b;
        pz0 pz0Var5 = (pz0) iv0Var.m4940l();
        if (pz0Var4.mo2283i()) {
            return pz0Var5.mo2283i() ? m4937h.mo2308r() : iv0Var.mo2641a(this);
        }
        pz0 pz0Var6 = (pz0) this.f3429c;
        pz0 pz0Var7 = (pz0) this.f3430d[0];
        pz0 pz0Var8 = (pz0) iv0Var.m4941m();
        pz0 pz0Var9 = (pz0) iv0Var.mo4943p(0);
        long[] m6827c = o01.m6827c();
        long[] m6827c2 = o01.m6827c();
        long[] m6827c3 = o01.m6827c();
        long[] m6827c4 = o01.m6827c();
        long[] m7153r = pz0Var7.mo2282h() ? null : oz0.m7153r(pz0Var7.f5898e);
        if (m7153r == null) {
            jArr = pz0Var5.f5898e;
            jArr2 = pz0Var8.f5898e;
        } else {
            oz0.m7151p(pz0Var5.f5898e, m7153r, m6827c2);
            oz0.m7151p(pz0Var8.f5898e, m7153r, m6827c4);
            jArr = m6827c2;
            jArr2 = m6827c4;
        }
        long[] m7153r2 = pz0Var9.mo2282h() ? null : oz0.m7153r(pz0Var9.f5898e);
        long[] jArr4 = pz0Var4.f5898e;
        if (m7153r2 == null) {
            jArr3 = pz0Var6.f5898e;
        } else {
            oz0.m7151p(jArr4, m7153r2, m6827c);
            oz0.m7151p(pz0Var6.f5898e, m7153r2, m6827c3);
            jArr4 = m6827c;
            jArr3 = m6827c3;
        }
        oz0.m7137b(jArr3, jArr2, m6827c3);
        oz0.m7137b(jArr4, jArr, m6827c4);
        if (o01.m6831g(m6827c4)) {
            return o01.m6831g(m6827c3) ? mo2638C() : m4937h.mo2308r();
        }
        if (pz0Var5.mo2283i()) {
            iv0 m4949w = m4949w();
            pz0 pz0Var10 = (pz0) m4949w.m4942n();
            hv0 mo2645o = m4949w.mo2645o();
            hv0 mo2279d = mo2645o.mo2277a(pz0Var8).mo2279d(pz0Var10);
            pz0Var = (pz0) mo2279d.mo2287o().mo2277a(mo2279d).mo2277a(pz0Var10);
            if (pz0Var.mo2283i()) {
                return new rz0(m4937h, pz0Var, m4937h.m4267m());
            }
            pz0Var2 = (pz0) mo2279d.mo2284j(pz0Var10.mo2277a(pz0Var)).mo2277a(pz0Var).mo2277a(mo2645o).mo2279d(pz0Var).mo2277a(pz0Var);
            pz0Var3 = (pz0) m4937h.mo2306k(ECConstants.f8873b);
        } else {
            oz0.m7157v(m6827c4, m6827c4);
            long[] m7153r3 = oz0.m7153r(m6827c3);
            oz0.m7151p(jArr4, m7153r3, m6827c);
            oz0.m7151p(jArr, m7153r3, m6827c2);
            pz0 pz0Var11 = new pz0(m6827c);
            oz0.m7149n(m6827c, m6827c2, pz0Var11.f5898e);
            if (pz0Var11.mo2283i()) {
                return new rz0(m4937h, pz0Var11, m4937h.m4267m());
            }
            pz0 pz0Var12 = new pz0(m6827c3);
            oz0.m7151p(m6827c4, m7153r3, pz0Var12.f5898e);
            if (m7153r2 != null) {
                long[] jArr5 = pz0Var12.f5898e;
                oz0.m7151p(jArr5, m7153r2, jArr5);
            }
            long[] m6828d = o01.m6828d();
            oz0.m7137b(m6827c2, m6827c4, m6827c4);
            oz0.m7158w(m6827c4, m6828d);
            oz0.m7137b(pz0Var6.f5898e, pz0Var7.f5898e, m6827c4);
            oz0.m7150o(m6827c4, pz0Var12.f5898e, m6828d);
            pz0 pz0Var13 = new pz0(m6827c4);
            oz0.m7154s(m6828d, pz0Var13.f5898e);
            if (m7153r != null) {
                long[] jArr6 = pz0Var12.f5898e;
                oz0.m7151p(jArr6, m7153r, jArr6);
            }
            pz0Var = pz0Var11;
            pz0Var2 = pz0Var13;
            pz0Var3 = pz0Var12;
        }
        return new rz0(m4937h, pz0Var, pz0Var2, new hv0[]{pz0Var3});
    }

    @Override // cz.opentree.iv0
    /* renamed from: g */
    public boolean mo2644g() {
        hv0 m4940l = m4940l();
        return (m4940l.mo2283i() || m4941m().mo2289s() == m4940l.mo2289s()) ? false : true;
    }

    @Override // cz.opentree.iv0
    /* renamed from: o */
    public hv0 mo2645o() {
        hv0 hv0Var = this.f3428b;
        hv0 hv0Var2 = this.f3429c;
        if (m4945r() || hv0Var.mo2283i()) {
            return hv0Var2;
        }
        hv0 mo2284j = hv0Var2.mo2277a(hv0Var).mo2284j(hv0Var);
        hv0 hv0Var3 = this.f3430d[0];
        return !hv0Var3.mo2282h() ? mo2284j.mo2279d(hv0Var3) : mo2284j;
    }

    @Override // cz.opentree.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        if (m4945r()) {
            return this;
        }
        hv0 hv0Var = this.f3428b;
        if (hv0Var.mo2283i()) {
            return this;
        }
        hv0 hv0Var2 = this.f3429c;
        hv0 hv0Var3 = this.f3430d[0];
        return new rz0(this.f3427a, hv0Var, hv0Var2.mo2277a(hv0Var3), new hv0[]{hv0Var3});
    }
}
