package cz.opentree;

import cz.opentree.iv0;

/* loaded from: classes.dex */
public class bx0 extends iv0.AbstractC1181c {
    public bx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public bx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        ax0 ax0Var = (ax0) this.f3429c;
        if (ax0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        ax0 ax0Var2 = (ax0) this.f3428b;
        ax0 ax0Var3 = (ax0) this.f3430d[0];
        int[] m4687e = i01.m4687e();
        int[] m4687e2 = i01.m4687e();
        int[] m4687e3 = i01.m4687e();
        zw0.m10656j(ax0Var.f1538e, m4687e3);
        int[] m4687e4 = i01.m4687e();
        zw0.m10656j(m4687e3, m4687e4);
        boolean mo2282h = ax0Var3.mo2282h();
        int[] iArr = ax0Var3.f1538e;
        if (!mo2282h) {
            zw0.m10656j(iArr, m4687e2);
            iArr = m4687e2;
        }
        zw0.m10659m(ax0Var2.f1538e, iArr, m4687e);
        zw0.m10647a(ax0Var2.f1538e, iArr, m4687e2);
        zw0.m10651e(m4687e2, m4687e, m4687e2);
        zw0.m10655i(i01.m4684b(m4687e2, m4687e2, m4687e2), m4687e2);
        zw0.m10651e(m4687e3, ax0Var2.f1538e, m4687e3);
        zw0.m10655i(p01.m7178I(7, m4687e3, 2, 0), m4687e3);
        zw0.m10655i(p01.m7179J(7, m4687e4, 3, 0, m4687e), m4687e);
        ax0 ax0Var4 = new ax0(m4687e4);
        zw0.m10656j(m4687e2, ax0Var4.f1538e);
        int[] iArr2 = ax0Var4.f1538e;
        zw0.m10659m(iArr2, m4687e3, iArr2);
        int[] iArr3 = ax0Var4.f1538e;
        zw0.m10659m(iArr3, m4687e3, iArr3);
        ax0 ax0Var5 = new ax0(m4687e3);
        zw0.m10659m(m4687e3, ax0Var4.f1538e, ax0Var5.f1538e);
        int[] iArr4 = ax0Var5.f1538e;
        zw0.m10651e(iArr4, m4687e2, iArr4);
        int[] iArr5 = ax0Var5.f1538e;
        zw0.m10659m(iArr5, m4687e, iArr5);
        ax0 ax0Var6 = new ax0(m4687e2);
        zw0.m10660n(ax0Var.f1538e, ax0Var6.f1538e);
        if (!mo2282h) {
            int[] iArr6 = ax0Var6.f1538e;
            zw0.m10651e(iArr6, ax0Var3.f1538e, iArr6);
        }
        return new bx0(m4937h, ax0Var4, ax0Var5, new hv0[]{ax0Var6});
    }

    @Override // cz.opentree.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m2643E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m2643E() {
        return (m4945r() || this.f3429c.mo2283i()) ? this : mo2638C().mo2641a(this);
    }

    @Override // cz.opentree.iv0
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
        ax0 ax0Var = (ax0) this.f3428b;
        ax0 ax0Var2 = (ax0) this.f3429c;
        ax0 ax0Var3 = (ax0) iv0Var.m4942n();
        ax0 ax0Var4 = (ax0) iv0Var.mo2645o();
        ax0 ax0Var5 = (ax0) this.f3430d[0];
        ax0 ax0Var6 = (ax0) iv0Var.mo4943p(0);
        int[] m4688f = i01.m4688f();
        int[] m4687e = i01.m4687e();
        int[] m4687e2 = i01.m4687e();
        int[] m4687e3 = i01.m4687e();
        boolean mo2282h = ax0Var5.mo2282h();
        if (mo2282h) {
            iArr = ax0Var3.f1538e;
            iArr2 = ax0Var4.f1538e;
        } else {
            zw0.m10656j(ax0Var5.f1538e, m4687e2);
            zw0.m10651e(m4687e2, ax0Var3.f1538e, m4687e);
            zw0.m10651e(m4687e2, ax0Var5.f1538e, m4687e2);
            zw0.m10651e(m4687e2, ax0Var4.f1538e, m4687e2);
            iArr = m4687e;
            iArr2 = m4687e2;
        }
        boolean mo2282h2 = ax0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = ax0Var.f1538e;
            iArr4 = ax0Var2.f1538e;
        } else {
            zw0.m10656j(ax0Var6.f1538e, m4687e3);
            zw0.m10651e(m4687e3, ax0Var.f1538e, m4688f);
            zw0.m10651e(m4687e3, ax0Var6.f1538e, m4687e3);
            zw0.m10651e(m4687e3, ax0Var2.f1538e, m4687e3);
            iArr3 = m4688f;
            iArr4 = m4687e3;
        }
        int[] m4687e4 = i01.m4687e();
        zw0.m10659m(iArr3, iArr, m4687e4);
        zw0.m10659m(iArr4, iArr2, m4687e);
        if (i01.m4694l(m4687e4)) {
            return i01.m4694l(m4687e) ? mo2638C() : m4937h.mo2308r();
        }
        zw0.m10656j(m4687e4, m4687e2);
        int[] m4687e5 = i01.m4687e();
        zw0.m10651e(m4687e2, m4687e4, m4687e5);
        zw0.m10651e(m4687e2, iArr3, m4687e2);
        zw0.m10653g(m4687e5, m4687e5);
        i01.m4695m(iArr4, m4687e5, m4688f);
        zw0.m10655i(i01.m4684b(m4687e2, m4687e2, m4687e5), m4687e5);
        ax0 ax0Var7 = new ax0(m4687e3);
        zw0.m10656j(m4687e, ax0Var7.f1538e);
        int[] iArr5 = ax0Var7.f1538e;
        zw0.m10659m(iArr5, m4687e5, iArr5);
        ax0 ax0Var8 = new ax0(m4687e5);
        zw0.m10659m(m4687e2, ax0Var7.f1538e, ax0Var8.f1538e);
        zw0.m10652f(ax0Var8.f1538e, m4687e, m4688f);
        zw0.m10654h(m4688f, ax0Var8.f1538e);
        ax0 ax0Var9 = new ax0(m4687e4);
        if (!mo2282h) {
            int[] iArr6 = ax0Var9.f1538e;
            zw0.m10651e(iArr6, ax0Var5.f1538e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = ax0Var9.f1538e;
            zw0.m10651e(iArr7, ax0Var6.f1538e, iArr7);
        }
        return new bx0(m4937h, ax0Var7, ax0Var8, new hv0[]{ax0Var9});
    }

    @Override // cz.opentree.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new bx0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
