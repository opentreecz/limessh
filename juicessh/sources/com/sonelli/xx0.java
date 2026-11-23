package com.sonelli;

import com.sonelli.iv0;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public class xx0 extends iv0.AbstractC1180b {
    public xx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public xx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
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
        hv0 mo2284j = mo2282h ? hv0Var2 : hv0Var2.mo2284j(hv0Var3);
        hv0 mo2287o = mo2282h ? hv0Var3 : hv0Var3.mo2287o();
        hv0 m4266l = m4937h.m4266l();
        if (!mo2282h) {
            m4266l = m4266l.mo2284j(mo2287o);
        }
        hv0 mo2277a = hv0Var2.mo2287o().mo2277a(mo2284j).mo2277a(m4266l);
        if (mo2277a.mo2283i()) {
            return new xx0(m4937h, mo2277a, m4937h.m4267m().mo2286n());
        }
        hv0 mo2287o2 = mo2277a.mo2287o();
        hv0 mo2284j2 = mo2282h ? mo2277a : mo2277a.mo2284j(mo2287o);
        if (!mo2282h) {
            hv0Var = hv0Var.mo2284j(hv0Var3);
        }
        return new xx0(m4937h, mo2287o2, hv0Var.mo3340p(mo2277a, mo2284j).mo2277a(mo2287o2).mo2277a(mo2284j2), new hv0[]{mo2284j2});
    }

    @Override // com.sonelli.iv0
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
        hv0 mo2277a = m4937h.m4266l().mo2284j(mo2287o3).mo2277a(mo2287o2).mo2277a(hv0Var2.mo2284j(hv0Var3));
        hv0 mo2278b = m4941m.mo2278b();
        hv0 mo3339l = m4937h.m4266l().mo2277a(mo2278b).mo2284j(mo2287o3).mo2277a(mo2287o2).mo3339l(mo2277a, mo2287o, mo2287o3);
        hv0 mo2284j = m4940l.mo2284j(mo2287o3);
        hv0 mo2287o4 = mo2284j.mo2277a(mo2277a).mo2287o();
        if (mo2287o4.mo2283i()) {
            return mo3339l.mo2283i() ? iv0Var.mo2638C() : m4937h.mo2308r();
        }
        if (mo3339l.mo2283i()) {
            return new xx0(m4937h, mo3339l, m4937h.m4267m().mo2286n());
        }
        hv0 mo2284j2 = mo3339l.mo2287o().mo2284j(mo2284j);
        hv0 mo2284j3 = mo3339l.mo2284j(mo2287o4).mo2284j(mo2287o3);
        return new xx0(m4937h, mo2284j2, mo3339l.mo2277a(mo2287o4).mo2287o().mo3339l(mo2277a, mo2278b, mo2284j3), new hv0[]{mo2284j3});
    }

    @Override // com.sonelli.iv0
    /* renamed from: a */
    public iv0 mo2641a(iv0 iv0Var) {
        hv0 hv0Var;
        hv0 hv0Var2;
        hv0 hv0Var3;
        hv0 hv0Var4;
        hv0 hv0Var5;
        hv0 hv0Var6;
        if (m4945r()) {
            return iv0Var;
        }
        if (iv0Var.m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        hv0 hv0Var7 = this.f3428b;
        hv0 m4940l = iv0Var.m4940l();
        if (hv0Var7.mo2283i()) {
            return m4940l.mo2283i() ? m4937h.mo2308r() : iv0Var.mo2641a(this);
        }
        hv0 hv0Var8 = this.f3429c;
        hv0 hv0Var9 = this.f3430d[0];
        hv0 m4941m = iv0Var.m4941m();
        hv0 mo4943p = iv0Var.mo4943p(0);
        boolean mo2282h = hv0Var9.mo2282h();
        if (mo2282h) {
            hv0Var = m4940l;
            hv0Var2 = m4941m;
        } else {
            hv0Var = m4940l.mo2284j(hv0Var9);
            hv0Var2 = m4941m.mo2284j(hv0Var9);
        }
        boolean mo2282h2 = mo4943p.mo2282h();
        if (mo2282h2) {
            hv0Var3 = hv0Var8;
        } else {
            hv0Var7 = hv0Var7.mo2284j(mo4943p);
            hv0Var3 = hv0Var8.mo2284j(mo4943p);
        }
        hv0 mo2277a = hv0Var3.mo2277a(hv0Var2);
        hv0 mo2277a2 = hv0Var7.mo2277a(hv0Var);
        if (mo2277a2.mo2283i()) {
            return mo2277a.mo2283i() ? mo2638C() : m4937h.mo2308r();
        }
        if (m4940l.mo2283i()) {
            iv0 m4949w = m4949w();
            hv0 m4942n = m4949w.m4942n();
            hv0 mo2645o = m4949w.mo2645o();
            hv0 mo2279d = mo2645o.mo2277a(m4941m).mo2279d(m4942n);
            hv0Var4 = mo2279d.mo2287o().mo2277a(mo2279d).mo2277a(m4942n).mo2277a(m4937h.m4266l());
            if (hv0Var4.mo2283i()) {
                return new xx0(m4937h, hv0Var4, m4937h.m4267m().mo2286n());
            }
            hv0Var6 = mo2279d.mo2284j(m4942n.mo2277a(hv0Var4)).mo2277a(hv0Var4).mo2277a(mo2645o).mo2279d(hv0Var4).mo2277a(hv0Var4);
            hv0Var5 = m4937h.mo2306k(ECConstants.f8873b);
        } else {
            hv0 mo2287o = mo2277a2.mo2287o();
            hv0 mo2284j = mo2277a.mo2284j(hv0Var7);
            hv0 mo2284j2 = mo2277a.mo2284j(hv0Var);
            hv0 mo2284j3 = mo2284j.mo2284j(mo2284j2);
            if (mo2284j3.mo2283i()) {
                return new xx0(m4937h, mo2284j3, m4937h.m4267m().mo2286n());
            }
            hv0 mo2284j4 = mo2277a.mo2284j(mo2287o);
            hv0 mo2284j5 = !mo2282h2 ? mo2284j4.mo2284j(mo4943p) : mo2284j4;
            hv0 mo3340p = mo2284j2.mo2277a(mo2287o).mo3340p(mo2284j5, hv0Var8.mo2277a(hv0Var9));
            if (!mo2282h) {
                mo2284j5 = mo2284j5.mo2284j(hv0Var9);
            }
            hv0Var4 = mo2284j3;
            hv0Var5 = mo2284j5;
            hv0Var6 = mo3340p;
        }
        return new xx0(m4937h, hv0Var4, hv0Var6, new hv0[]{hv0Var5});
    }

    @Override // com.sonelli.iv0
    /* renamed from: g */
    public boolean mo2644g() {
        hv0 m4940l = m4940l();
        return (m4940l.mo2283i() || m4941m().mo2289s() == m4940l.mo2289s()) ? false : true;
    }

    @Override // com.sonelli.iv0
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

    @Override // com.sonelli.iv0
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
        return new xx0(this.f3427a, hv0Var, hv0Var2.mo2277a(hv0Var3), new hv0[]{hv0Var3});
    }
}
