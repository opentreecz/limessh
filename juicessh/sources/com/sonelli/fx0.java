package com.sonelli;

import com.sonelli.iv0;

/* loaded from: classes.dex */
public class fx0 extends iv0.AbstractC1181c {
    public fx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public fx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        ex0 ex0Var = (ex0) this.f3429c;
        if (ex0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        ex0 ex0Var2 = (ex0) this.f3428b;
        ex0 ex0Var3 = (ex0) this.f3430d[0];
        int[] m5015i = j01.m5015i();
        dx0.m3334i(ex0Var.f2550e, m5015i);
        int[] m5015i2 = j01.m5015i();
        dx0.m3334i(m5015i, m5015i2);
        int[] m5015i3 = j01.m5015i();
        dx0.m3334i(ex0Var2.f2550e, m5015i3);
        dx0.m3333h(j01.m5008b(m5015i3, m5015i3, m5015i3), m5015i3);
        dx0.m3329d(m5015i, ex0Var2.f2550e, m5015i);
        dx0.m3333h(p01.m7178I(8, m5015i, 2, 0), m5015i);
        int[] m5015i4 = j01.m5015i();
        dx0.m3333h(p01.m7179J(8, m5015i2, 3, 0, m5015i4), m5015i4);
        ex0 ex0Var4 = new ex0(m5015i2);
        dx0.m3334i(m5015i3, ex0Var4.f2550e);
        int[] iArr = ex0Var4.f2550e;
        dx0.m3336k(iArr, m5015i, iArr);
        int[] iArr2 = ex0Var4.f2550e;
        dx0.m3336k(iArr2, m5015i, iArr2);
        ex0 ex0Var5 = new ex0(m5015i);
        dx0.m3336k(m5015i, ex0Var4.f2550e, ex0Var5.f2550e);
        int[] iArr3 = ex0Var5.f2550e;
        dx0.m3329d(iArr3, m5015i3, iArr3);
        int[] iArr4 = ex0Var5.f2550e;
        dx0.m3336k(iArr4, m5015i4, iArr4);
        ex0 ex0Var6 = new ex0(m5015i3);
        dx0.m3337l(ex0Var.f2550e, ex0Var6.f2550e);
        if (!ex0Var3.mo2282h()) {
            int[] iArr5 = ex0Var6.f2550e;
            dx0.m3329d(iArr5, ex0Var3.f2550e, iArr5);
        }
        return new fx0(m4937h, ex0Var4, ex0Var5, new hv0[]{ex0Var6});
    }

    @Override // com.sonelli.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m3900E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m3900E() {
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
        ex0 ex0Var = (ex0) this.f3428b;
        ex0 ex0Var2 = (ex0) this.f3429c;
        ex0 ex0Var3 = (ex0) iv0Var.m4942n();
        ex0 ex0Var4 = (ex0) iv0Var.mo2645o();
        ex0 ex0Var5 = (ex0) this.f3430d[0];
        ex0 ex0Var6 = (ex0) iv0Var.mo4943p(0);
        int[] m5017k = j01.m5017k();
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        int[] m5015i3 = j01.m5015i();
        boolean mo2282h = ex0Var5.mo2282h();
        if (mo2282h) {
            iArr = ex0Var3.f2550e;
            iArr2 = ex0Var4.f2550e;
        } else {
            dx0.m3334i(ex0Var5.f2550e, m5015i2);
            dx0.m3329d(m5015i2, ex0Var3.f2550e, m5015i);
            dx0.m3329d(m5015i2, ex0Var5.f2550e, m5015i2);
            dx0.m3329d(m5015i2, ex0Var4.f2550e, m5015i2);
            iArr = m5015i;
            iArr2 = m5015i2;
        }
        boolean mo2282h2 = ex0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = ex0Var.f2550e;
            iArr4 = ex0Var2.f2550e;
        } else {
            dx0.m3334i(ex0Var6.f2550e, m5015i3);
            dx0.m3329d(m5015i3, ex0Var.f2550e, m5017k);
            dx0.m3329d(m5015i3, ex0Var6.f2550e, m5015i3);
            dx0.m3329d(m5015i3, ex0Var2.f2550e, m5015i3);
            iArr3 = m5017k;
            iArr4 = m5015i3;
        }
        int[] m5015i4 = j01.m5015i();
        dx0.m3336k(iArr3, iArr, m5015i4);
        dx0.m3336k(iArr4, iArr2, m5015i);
        if (j01.m5028v(m5015i4)) {
            return j01.m5028v(m5015i) ? mo2638C() : m4937h.mo2308r();
        }
        dx0.m3334i(m5015i4, m5015i2);
        int[] m5015i5 = j01.m5015i();
        dx0.m3329d(m5015i2, m5015i4, m5015i5);
        dx0.m3329d(m5015i2, iArr3, m5015i2);
        dx0.m3331f(m5015i5, m5015i5);
        j01.m5031y(iArr4, m5015i5, m5017k);
        dx0.m3333h(j01.m5008b(m5015i2, m5015i2, m5015i5), m5015i5);
        ex0 ex0Var7 = new ex0(m5015i3);
        dx0.m3334i(m5015i, ex0Var7.f2550e);
        int[] iArr5 = ex0Var7.f2550e;
        dx0.m3336k(iArr5, m5015i5, iArr5);
        ex0 ex0Var8 = new ex0(m5015i5);
        dx0.m3336k(m5015i2, ex0Var7.f2550e, ex0Var8.f2550e);
        dx0.m3330e(ex0Var8.f2550e, m5015i, m5017k);
        dx0.m3332g(m5017k, ex0Var8.f2550e);
        ex0 ex0Var9 = new ex0(m5015i4);
        if (!mo2282h) {
            int[] iArr6 = ex0Var9.f2550e;
            dx0.m3329d(iArr6, ex0Var5.f2550e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = ex0Var9.f2550e;
            dx0.m3329d(iArr7, ex0Var6.f2550e, iArr7);
        }
        return new fx0(m4937h, ex0Var7, ex0Var8, new hv0[]{ex0Var9});
    }

    @Override // com.sonelli.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new fx0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
