package cz.opentree;

import cz.opentree.iv0;

/* loaded from: classes.dex */
public class lw0 extends iv0.AbstractC1181c {
    public lw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public lw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        kw0 kw0Var = (kw0) this.f3429c;
        if (kw0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        kw0 kw0Var2 = (kw0) this.f3428b;
        kw0 kw0Var3 = (kw0) this.f3430d[0];
        int[] m3907d = g01.m3907d();
        int[] m3907d2 = g01.m3907d();
        int[] m3907d3 = g01.m3907d();
        jw0.m5741i(kw0Var.f4667e, m3907d3);
        int[] m3907d4 = g01.m3907d();
        jw0.m5741i(m3907d3, m3907d4);
        boolean mo2282h = kw0Var3.mo2282h();
        int[] iArr = kw0Var3.f4667e;
        if (!mo2282h) {
            jw0.m5741i(iArr, m3907d2);
            iArr = m3907d2;
        }
        jw0.m5743k(kw0Var2.f4667e, iArr, m3907d);
        jw0.m5733a(kw0Var2.f4667e, iArr, m3907d2);
        jw0.m5736d(m3907d2, m3907d, m3907d2);
        jw0.m5740h(g01.m3905b(m3907d2, m3907d2, m3907d2), m3907d2);
        jw0.m5736d(m3907d3, kw0Var2.f4667e, m3907d3);
        jw0.m5740h(p01.m7178I(5, m3907d3, 2, 0), m3907d3);
        jw0.m5740h(p01.m7179J(5, m3907d4, 3, 0, m3907d), m3907d);
        kw0 kw0Var4 = new kw0(m3907d4);
        jw0.m5741i(m3907d2, kw0Var4.f4667e);
        int[] iArr2 = kw0Var4.f4667e;
        jw0.m5743k(iArr2, m3907d3, iArr2);
        int[] iArr3 = kw0Var4.f4667e;
        jw0.m5743k(iArr3, m3907d3, iArr3);
        kw0 kw0Var5 = new kw0(m3907d3);
        jw0.m5743k(m3907d3, kw0Var4.f4667e, kw0Var5.f4667e);
        int[] iArr4 = kw0Var5.f4667e;
        jw0.m5736d(iArr4, m3907d2, iArr4);
        int[] iArr5 = kw0Var5.f4667e;
        jw0.m5743k(iArr5, m3907d, iArr5);
        kw0 kw0Var6 = new kw0(m3907d2);
        jw0.m5744l(kw0Var.f4667e, kw0Var6.f4667e);
        if (!mo2282h) {
            int[] iArr6 = kw0Var6.f4667e;
            jw0.m5736d(iArr6, kw0Var3.f4667e, iArr6);
        }
        return new lw0(m4937h, kw0Var4, kw0Var5, new hv0[]{kw0Var6});
    }

    @Override // cz.opentree.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m6305E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m6305E() {
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
        kw0 kw0Var = (kw0) this.f3428b;
        kw0 kw0Var2 = (kw0) this.f3429c;
        kw0 kw0Var3 = (kw0) iv0Var.m4942n();
        kw0 kw0Var4 = (kw0) iv0Var.mo2645o();
        kw0 kw0Var5 = (kw0) this.f3430d[0];
        kw0 kw0Var6 = (kw0) iv0Var.mo4943p(0);
        int[] m3908e = g01.m3908e();
        int[] m3907d = g01.m3907d();
        int[] m3907d2 = g01.m3907d();
        int[] m3907d3 = g01.m3907d();
        boolean mo2282h = kw0Var5.mo2282h();
        if (mo2282h) {
            iArr = kw0Var3.f4667e;
            iArr2 = kw0Var4.f4667e;
        } else {
            jw0.m5741i(kw0Var5.f4667e, m3907d2);
            jw0.m5736d(m3907d2, kw0Var3.f4667e, m3907d);
            jw0.m5736d(m3907d2, kw0Var5.f4667e, m3907d2);
            jw0.m5736d(m3907d2, kw0Var4.f4667e, m3907d2);
            iArr = m3907d;
            iArr2 = m3907d2;
        }
        boolean mo2282h2 = kw0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = kw0Var.f4667e;
            iArr4 = kw0Var2.f4667e;
        } else {
            jw0.m5741i(kw0Var6.f4667e, m3907d3);
            jw0.m5736d(m3907d3, kw0Var.f4667e, m3908e);
            jw0.m5736d(m3907d3, kw0Var6.f4667e, m3907d3);
            jw0.m5736d(m3907d3, kw0Var2.f4667e, m3907d3);
            iArr3 = m3908e;
            iArr4 = m3907d3;
        }
        int[] m3907d4 = g01.m3907d();
        jw0.m5743k(iArr3, iArr, m3907d4);
        jw0.m5743k(iArr4, iArr2, m3907d);
        if (g01.m3914k(m3907d4)) {
            return g01.m3914k(m3907d) ? mo2638C() : m4937h.mo2308r();
        }
        jw0.m5741i(m3907d4, m3907d2);
        int[] m3907d5 = g01.m3907d();
        jw0.m5736d(m3907d2, m3907d4, m3907d5);
        jw0.m5736d(m3907d2, iArr3, m3907d2);
        jw0.m5738f(m3907d5, m3907d5);
        g01.m3915l(iArr4, m3907d5, m3908e);
        jw0.m5740h(g01.m3905b(m3907d2, m3907d2, m3907d5), m3907d5);
        kw0 kw0Var7 = new kw0(m3907d3);
        jw0.m5741i(m3907d, kw0Var7.f4667e);
        int[] iArr5 = kw0Var7.f4667e;
        jw0.m5743k(iArr5, m3907d5, iArr5);
        kw0 kw0Var8 = new kw0(m3907d5);
        jw0.m5743k(m3907d2, kw0Var7.f4667e, kw0Var8.f4667e);
        jw0.m5737e(kw0Var8.f4667e, m3907d, m3908e);
        jw0.m5739g(m3908e, kw0Var8.f4667e);
        kw0 kw0Var9 = new kw0(m3907d4);
        if (!mo2282h) {
            int[] iArr6 = kw0Var9.f4667e;
            jw0.m5736d(iArr6, kw0Var5.f4667e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = kw0Var9.f4667e;
            jw0.m5736d(iArr7, kw0Var6.f4667e, iArr7);
        }
        return new lw0(m4937h, kw0Var7, kw0Var8, new hv0[]{kw0Var9});
    }

    @Override // cz.opentree.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new lw0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
