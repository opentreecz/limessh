package com.sonelli;

import com.sonelli.iv0;

/* loaded from: classes.dex */
public class hw0 extends iv0.AbstractC1181c {
    public hw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public hw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        gw0 gw0Var = (gw0) this.f3429c;
        if (gw0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        gw0 gw0Var2 = (gw0) this.f3428b;
        gw0 gw0Var3 = (gw0) this.f3430d[0];
        int[] m3907d = g01.m3907d();
        int[] m3907d2 = g01.m3907d();
        int[] m3907d3 = g01.m3907d();
        fw0.m3896i(gw0Var.f3018e, m3907d3);
        int[] m3907d4 = g01.m3907d();
        fw0.m3896i(m3907d3, m3907d4);
        boolean mo2282h = gw0Var3.mo2282h();
        int[] iArr = gw0Var3.f3018e;
        if (!mo2282h) {
            fw0.m3896i(iArr, m3907d2);
            iArr = m3907d2;
        }
        fw0.m3898k(gw0Var2.f3018e, iArr, m3907d);
        fw0.m3888a(gw0Var2.f3018e, iArr, m3907d2);
        fw0.m3891d(m3907d2, m3907d, m3907d2);
        fw0.m3895h(g01.m3905b(m3907d2, m3907d2, m3907d2), m3907d2);
        fw0.m3891d(m3907d3, gw0Var2.f3018e, m3907d3);
        fw0.m3895h(p01.m7178I(5, m3907d3, 2, 0), m3907d3);
        fw0.m3895h(p01.m7179J(5, m3907d4, 3, 0, m3907d), m3907d);
        gw0 gw0Var4 = new gw0(m3907d4);
        fw0.m3896i(m3907d2, gw0Var4.f3018e);
        int[] iArr2 = gw0Var4.f3018e;
        fw0.m3898k(iArr2, m3907d3, iArr2);
        int[] iArr3 = gw0Var4.f3018e;
        fw0.m3898k(iArr3, m3907d3, iArr3);
        gw0 gw0Var5 = new gw0(m3907d3);
        fw0.m3898k(m3907d3, gw0Var4.f3018e, gw0Var5.f3018e);
        int[] iArr4 = gw0Var5.f3018e;
        fw0.m3891d(iArr4, m3907d2, iArr4);
        int[] iArr5 = gw0Var5.f3018e;
        fw0.m3898k(iArr5, m3907d, iArr5);
        gw0 gw0Var6 = new gw0(m3907d2);
        fw0.m3899l(gw0Var.f3018e, gw0Var6.f3018e);
        if (!mo2282h) {
            int[] iArr6 = gw0Var6.f3018e;
            fw0.m3891d(iArr6, gw0Var3.f3018e, iArr6);
        }
        return new hw0(m4937h, gw0Var4, gw0Var5, new hv0[]{gw0Var6});
    }

    @Override // com.sonelli.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m4665E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m4665E() {
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
        gw0 gw0Var = (gw0) this.f3428b;
        gw0 gw0Var2 = (gw0) this.f3429c;
        gw0 gw0Var3 = (gw0) iv0Var.m4942n();
        gw0 gw0Var4 = (gw0) iv0Var.mo2645o();
        gw0 gw0Var5 = (gw0) this.f3430d[0];
        gw0 gw0Var6 = (gw0) iv0Var.mo4943p(0);
        int[] m3908e = g01.m3908e();
        int[] m3907d = g01.m3907d();
        int[] m3907d2 = g01.m3907d();
        int[] m3907d3 = g01.m3907d();
        boolean mo2282h = gw0Var5.mo2282h();
        if (mo2282h) {
            iArr = gw0Var3.f3018e;
            iArr2 = gw0Var4.f3018e;
        } else {
            fw0.m3896i(gw0Var5.f3018e, m3907d2);
            fw0.m3891d(m3907d2, gw0Var3.f3018e, m3907d);
            fw0.m3891d(m3907d2, gw0Var5.f3018e, m3907d2);
            fw0.m3891d(m3907d2, gw0Var4.f3018e, m3907d2);
            iArr = m3907d;
            iArr2 = m3907d2;
        }
        boolean mo2282h2 = gw0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = gw0Var.f3018e;
            iArr4 = gw0Var2.f3018e;
        } else {
            fw0.m3896i(gw0Var6.f3018e, m3907d3);
            fw0.m3891d(m3907d3, gw0Var.f3018e, m3908e);
            fw0.m3891d(m3907d3, gw0Var6.f3018e, m3907d3);
            fw0.m3891d(m3907d3, gw0Var2.f3018e, m3907d3);
            iArr3 = m3908e;
            iArr4 = m3907d3;
        }
        int[] m3907d4 = g01.m3907d();
        fw0.m3898k(iArr3, iArr, m3907d4);
        fw0.m3898k(iArr4, iArr2, m3907d);
        if (g01.m3914k(m3907d4)) {
            return g01.m3914k(m3907d) ? mo2638C() : m4937h.mo2308r();
        }
        fw0.m3896i(m3907d4, m3907d2);
        int[] m3907d5 = g01.m3907d();
        fw0.m3891d(m3907d2, m3907d4, m3907d5);
        fw0.m3891d(m3907d2, iArr3, m3907d2);
        fw0.m3893f(m3907d5, m3907d5);
        g01.m3915l(iArr4, m3907d5, m3908e);
        fw0.m3895h(g01.m3905b(m3907d2, m3907d2, m3907d5), m3907d5);
        gw0 gw0Var7 = new gw0(m3907d3);
        fw0.m3896i(m3907d, gw0Var7.f3018e);
        int[] iArr5 = gw0Var7.f3018e;
        fw0.m3898k(iArr5, m3907d5, iArr5);
        gw0 gw0Var8 = new gw0(m3907d5);
        fw0.m3898k(m3907d2, gw0Var7.f3018e, gw0Var8.f3018e);
        fw0.m3892e(gw0Var8.f3018e, m3907d, m3908e);
        fw0.m3894g(m3908e, gw0Var8.f3018e);
        gw0 gw0Var9 = new gw0(m3907d4);
        if (!mo2282h) {
            int[] iArr6 = gw0Var9.f3018e;
            fw0.m3891d(iArr6, gw0Var5.f3018e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = gw0Var9.f3018e;
            fw0.m3891d(iArr7, gw0Var6.f3018e, iArr7);
        }
        return new hw0(m4937h, gw0Var7, gw0Var8, new hv0[]{gw0Var9});
    }

    @Override // com.sonelli.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new hw0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
