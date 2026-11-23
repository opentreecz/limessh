package com.sonelli;

import com.sonelli.iv0;

/* loaded from: classes.dex */
public class nx0 extends iv0.AbstractC1181c {
    public nx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public nx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        mx0 mx0Var = (mx0) this.f3429c;
        if (mx0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        mx0 mx0Var2 = (mx0) this.f3428b;
        mx0 mx0Var3 = (mx0) this.f3430d[0];
        int[] m7200k = p01.m7200k(12);
        int[] m7200k2 = p01.m7200k(12);
        int[] m7200k3 = p01.m7200k(12);
        lx0.m6315j(mx0Var.f5161e, m7200k3);
        int[] m7200k4 = p01.m7200k(12);
        lx0.m6315j(m7200k3, m7200k4);
        boolean mo2282h = mx0Var3.mo2282h();
        int[] iArr = mx0Var3.f5161e;
        if (!mo2282h) {
            lx0.m6315j(iArr, m7200k2);
            iArr = m7200k2;
        }
        lx0.m6318m(mx0Var2.f5161e, iArr, m7200k);
        lx0.m6306a(mx0Var2.f5161e, iArr, m7200k2);
        lx0.m6311f(m7200k2, m7200k, m7200k2);
        lx0.m6314i(p01.m7192c(12, m7200k2, m7200k2, m7200k2), m7200k2);
        lx0.m6311f(m7200k3, mx0Var2.f5161e, m7200k3);
        lx0.m6314i(p01.m7178I(12, m7200k3, 2, 0), m7200k3);
        lx0.m6314i(p01.m7179J(12, m7200k4, 3, 0, m7200k), m7200k);
        mx0 mx0Var4 = new mx0(m7200k4);
        lx0.m6315j(m7200k2, mx0Var4.f5161e);
        int[] iArr2 = mx0Var4.f5161e;
        lx0.m6318m(iArr2, m7200k3, iArr2);
        int[] iArr3 = mx0Var4.f5161e;
        lx0.m6318m(iArr3, m7200k3, iArr3);
        mx0 mx0Var5 = new mx0(m7200k3);
        lx0.m6318m(m7200k3, mx0Var4.f5161e, mx0Var5.f5161e);
        int[] iArr4 = mx0Var5.f5161e;
        lx0.m6311f(iArr4, m7200k2, iArr4);
        int[] iArr5 = mx0Var5.f5161e;
        lx0.m6318m(iArr5, m7200k, iArr5);
        mx0 mx0Var6 = new mx0(m7200k2);
        lx0.m6319n(mx0Var.f5161e, mx0Var6.f5161e);
        if (!mo2282h) {
            int[] iArr6 = mx0Var6.f5161e;
            lx0.m6311f(iArr6, mx0Var3.f5161e, iArr6);
        }
        return new nx0(m4937h, mx0Var4, mx0Var5, new hv0[]{mx0Var6});
    }

    @Override // com.sonelli.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m6817E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m6817E() {
        return (m4945r() || this.f3429c.mo2283i()) ? this : mo2638C().mo2641a(this);
    }

    @Override // com.sonelli.iv0
    /* renamed from: a */
    public iv0 mo2641a(iv0 iv0Var) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        if (m4945r()) {
            return iv0Var;
        }
        if (iv0Var.m4945r()) {
            return this;
        }
        if (this == iv0Var) {
            return mo2638C();
        }
        gv0 m4937h = m4937h();
        mx0 mx0Var = (mx0) this.f3428b;
        mx0 mx0Var2 = (mx0) this.f3429c;
        mx0 mx0Var3 = (mx0) iv0Var.m4942n();
        mx0 mx0Var4 = (mx0) iv0Var.mo2645o();
        mx0 mx0Var5 = (mx0) this.f3430d[0];
        mx0 mx0Var6 = (mx0) iv0Var.mo4943p(0);
        int[] m7200k = p01.m7200k(24);
        int[] m7200k2 = p01.m7200k(24);
        int[] m7200k3 = p01.m7200k(12);
        int[] m7200k4 = p01.m7200k(12);
        boolean mo2282h = mx0Var5.mo2282h();
        if (mo2282h) {
            iArr = mx0Var3.f5161e;
            iArr2 = mx0Var4.f5161e;
        } else {
            lx0.m6315j(mx0Var5.f5161e, m7200k3);
            lx0.m6311f(m7200k3, mx0Var3.f5161e, m7200k2);
            lx0.m6311f(m7200k3, mx0Var5.f5161e, m7200k3);
            lx0.m6311f(m7200k3, mx0Var4.f5161e, m7200k3);
            iArr = m7200k2;
            iArr2 = m7200k3;
        }
        boolean mo2282h2 = mx0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = mx0Var.f5161e;
            iArr4 = mx0Var2.f5161e;
        } else {
            lx0.m6315j(mx0Var6.f5161e, m7200k4);
            lx0.m6311f(m7200k4, mx0Var.f5161e, m7200k);
            lx0.m6311f(m7200k4, mx0Var6.f5161e, m7200k4);
            lx0.m6311f(m7200k4, mx0Var2.f5161e, m7200k4);
            iArr3 = m7200k;
            iArr4 = m7200k4;
        }
        int[] m7200k5 = p01.m7200k(12);
        lx0.m6318m(iArr3, iArr, m7200k5);
        int[] m7200k6 = p01.m7200k(12);
        lx0.m6318m(iArr4, iArr2, m7200k6);
        if (p01.m7214y(12, m7200k5)) {
            return p01.m7214y(12, m7200k6) ? mo2638C() : m4937h.mo2308r();
        }
        lx0.m6315j(m7200k5, m7200k3);
        int[] m7200k7 = p01.m7200k(12);
        lx0.m6311f(m7200k3, m7200k5, m7200k7);
        lx0.m6311f(m7200k3, iArr3, m7200k3);
        lx0.m6312g(m7200k7, m7200k7);
        l01.m6038a(iArr4, m7200k7, m7200k);
        lx0.m6314i(p01.m7192c(12, m7200k3, m7200k3, m7200k7), m7200k7);
        mx0 mx0Var7 = new mx0(m7200k4);
        lx0.m6315j(m7200k6, mx0Var7.f5161e);
        int[] iArr5 = mx0Var7.f5161e;
        lx0.m6318m(iArr5, m7200k7, iArr5);
        mx0 mx0Var8 = new mx0(m7200k7);
        lx0.m6318m(m7200k3, mx0Var7.f5161e, mx0Var8.f5161e);
        l01.m6038a(mx0Var8.f5161e, m7200k6, m7200k2);
        lx0.m6307b(m7200k, m7200k2, m7200k);
        lx0.m6313h(m7200k, mx0Var8.f5161e);
        mx0 mx0Var9 = new mx0(m7200k5);
        if (!mo2282h) {
            int[] iArr6 = mx0Var9.f5161e;
            lx0.m6311f(iArr6, mx0Var5.f5161e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = mx0Var9.f5161e;
            lx0.m6311f(iArr7, mx0Var6.f5161e, iArr7);
        }
        return new nx0(m4937h, mx0Var7, mx0Var8, new hv0[]{mx0Var9});
    }

    @Override // com.sonelli.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new nx0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
