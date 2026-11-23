package com.sonelli;

import com.sonelli.iv0;

/* loaded from: classes.dex */
public class jx0 extends iv0.AbstractC1181c {
    public jx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public jx0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        ix0 ix0Var = (ix0) this.f3429c;
        if (ix0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        ix0 ix0Var2 = (ix0) this.f3428b;
        ix0 ix0Var3 = (ix0) this.f3430d[0];
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        int[] m5015i3 = j01.m5015i();
        hx0.m4675j(ix0Var.f3444e, m5015i3);
        int[] m5015i4 = j01.m5015i();
        hx0.m4675j(m5015i3, m5015i4);
        boolean mo2282h = ix0Var3.mo2282h();
        int[] iArr = ix0Var3.f3444e;
        if (!mo2282h) {
            hx0.m4675j(iArr, m5015i2);
            iArr = m5015i2;
        }
        hx0.m4678m(ix0Var2.f3444e, iArr, m5015i);
        hx0.m4666a(ix0Var2.f3444e, iArr, m5015i2);
        hx0.m4670e(m5015i2, m5015i, m5015i2);
        hx0.m4674i(j01.m5008b(m5015i2, m5015i2, m5015i2), m5015i2);
        hx0.m4670e(m5015i3, ix0Var2.f3444e, m5015i3);
        hx0.m4674i(p01.m7178I(8, m5015i3, 2, 0), m5015i3);
        hx0.m4674i(p01.m7179J(8, m5015i4, 3, 0, m5015i), m5015i);
        ix0 ix0Var4 = new ix0(m5015i4);
        hx0.m4675j(m5015i2, ix0Var4.f3444e);
        int[] iArr2 = ix0Var4.f3444e;
        hx0.m4678m(iArr2, m5015i3, iArr2);
        int[] iArr3 = ix0Var4.f3444e;
        hx0.m4678m(iArr3, m5015i3, iArr3);
        ix0 ix0Var5 = new ix0(m5015i3);
        hx0.m4678m(m5015i3, ix0Var4.f3444e, ix0Var5.f3444e);
        int[] iArr4 = ix0Var5.f3444e;
        hx0.m4670e(iArr4, m5015i2, iArr4);
        int[] iArr5 = ix0Var5.f3444e;
        hx0.m4678m(iArr5, m5015i, iArr5);
        ix0 ix0Var6 = new ix0(m5015i2);
        hx0.m4679n(ix0Var.f3444e, ix0Var6.f3444e);
        if (!mo2282h) {
            int[] iArr6 = ix0Var6.f3444e;
            hx0.m4670e(iArr6, ix0Var3.f3444e, iArr6);
        }
        return new jx0(m4937h, ix0Var4, ix0Var5, new hv0[]{ix0Var6});
    }

    @Override // com.sonelli.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m5745E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m5745E() {
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
        ix0 ix0Var = (ix0) this.f3428b;
        ix0 ix0Var2 = (ix0) this.f3429c;
        ix0 ix0Var3 = (ix0) iv0Var.m4942n();
        ix0 ix0Var4 = (ix0) iv0Var.mo2645o();
        ix0 ix0Var5 = (ix0) this.f3430d[0];
        ix0 ix0Var6 = (ix0) iv0Var.mo4943p(0);
        int[] m5017k = j01.m5017k();
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        int[] m5015i3 = j01.m5015i();
        boolean mo2282h = ix0Var5.mo2282h();
        if (mo2282h) {
            iArr = ix0Var3.f3444e;
            iArr2 = ix0Var4.f3444e;
        } else {
            hx0.m4675j(ix0Var5.f3444e, m5015i2);
            hx0.m4670e(m5015i2, ix0Var3.f3444e, m5015i);
            hx0.m4670e(m5015i2, ix0Var5.f3444e, m5015i2);
            hx0.m4670e(m5015i2, ix0Var4.f3444e, m5015i2);
            iArr = m5015i;
            iArr2 = m5015i2;
        }
        boolean mo2282h2 = ix0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = ix0Var.f3444e;
            iArr4 = ix0Var2.f3444e;
        } else {
            hx0.m4675j(ix0Var6.f3444e, m5015i3);
            hx0.m4670e(m5015i3, ix0Var.f3444e, m5017k);
            hx0.m4670e(m5015i3, ix0Var6.f3444e, m5015i3);
            hx0.m4670e(m5015i3, ix0Var2.f3444e, m5015i3);
            iArr3 = m5017k;
            iArr4 = m5015i3;
        }
        int[] m5015i4 = j01.m5015i();
        hx0.m4678m(iArr3, iArr, m5015i4);
        hx0.m4678m(iArr4, iArr2, m5015i);
        if (j01.m5028v(m5015i4)) {
            return j01.m5028v(m5015i) ? mo2638C() : m4937h.mo2308r();
        }
        hx0.m4675j(m5015i4, m5015i2);
        int[] m5015i5 = j01.m5015i();
        hx0.m4670e(m5015i2, m5015i4, m5015i5);
        hx0.m4670e(m5015i2, iArr3, m5015i2);
        hx0.m4672g(m5015i5, m5015i5);
        j01.m5031y(iArr4, m5015i5, m5017k);
        hx0.m4674i(j01.m5008b(m5015i2, m5015i2, m5015i5), m5015i5);
        ix0 ix0Var7 = new ix0(m5015i3);
        hx0.m4675j(m5015i, ix0Var7.f3444e);
        int[] iArr5 = ix0Var7.f3444e;
        hx0.m4678m(iArr5, m5015i5, iArr5);
        ix0 ix0Var8 = new ix0(m5015i5);
        hx0.m4678m(m5015i2, ix0Var7.f3444e, ix0Var8.f3444e);
        hx0.m4671f(ix0Var8.f3444e, m5015i, m5017k);
        hx0.m4673h(m5017k, ix0Var8.f3444e);
        ix0 ix0Var9 = new ix0(m5015i4);
        if (!mo2282h) {
            int[] iArr6 = ix0Var9.f3444e;
            hx0.m4670e(iArr6, ix0Var5.f3444e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = ix0Var9.f3444e;
            hx0.m4670e(iArr7, ix0Var6.f3444e, iArr7);
        }
        return new jx0(m4937h, ix0Var7, ix0Var8, new hv0[]{ix0Var9});
    }

    @Override // com.sonelli.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new jx0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
