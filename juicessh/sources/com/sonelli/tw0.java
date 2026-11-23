package com.sonelli;

import com.sonelli.iv0;

/* loaded from: classes.dex */
public class tw0 extends iv0.AbstractC1181c {
    public tw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public tw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        sw0 sw0Var = (sw0) this.f3429c;
        if (sw0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        sw0 sw0Var2 = (sw0) this.f3428b;
        sw0 sw0Var3 = (sw0) this.f3430d[0];
        int[] m4315h = h01.m4315h();
        int[] m4315h2 = h01.m4315h();
        int[] m4315h3 = h01.m4315h();
        rw0.m8267j(sw0Var.f6602e, m4315h3);
        int[] m4315h4 = h01.m4315h();
        rw0.m8267j(m4315h3, m4315h4);
        boolean mo2282h = sw0Var3.mo2282h();
        int[] iArr = sw0Var3.f6602e;
        if (!mo2282h) {
            rw0.m8267j(iArr, m4315h2);
            iArr = m4315h2;
        }
        rw0.m8270m(sw0Var2.f6602e, iArr, m4315h);
        rw0.m8258a(sw0Var2.f6602e, iArr, m4315h2);
        rw0.m8262e(m4315h2, m4315h, m4315h2);
        rw0.m8266i(h01.m4309b(m4315h2, m4315h2, m4315h2), m4315h2);
        rw0.m8262e(m4315h3, sw0Var2.f6602e, m4315h3);
        rw0.m8266i(p01.m7178I(6, m4315h3, 2, 0), m4315h3);
        rw0.m8266i(p01.m7179J(6, m4315h4, 3, 0, m4315h), m4315h);
        sw0 sw0Var4 = new sw0(m4315h4);
        rw0.m8267j(m4315h2, sw0Var4.f6602e);
        int[] iArr2 = sw0Var4.f6602e;
        rw0.m8270m(iArr2, m4315h3, iArr2);
        int[] iArr3 = sw0Var4.f6602e;
        rw0.m8270m(iArr3, m4315h3, iArr3);
        sw0 sw0Var5 = new sw0(m4315h3);
        rw0.m8270m(m4315h3, sw0Var4.f6602e, sw0Var5.f6602e);
        int[] iArr4 = sw0Var5.f6602e;
        rw0.m8262e(iArr4, m4315h2, iArr4);
        int[] iArr5 = sw0Var5.f6602e;
        rw0.m8270m(iArr5, m4315h, iArr5);
        sw0 sw0Var6 = new sw0(m4315h2);
        rw0.m8271n(sw0Var.f6602e, sw0Var6.f6602e);
        if (!mo2282h) {
            int[] iArr6 = sw0Var6.f6602e;
            rw0.m8262e(iArr6, sw0Var3.f6602e, iArr6);
        }
        return new tw0(m4937h, sw0Var4, sw0Var5, new hv0[]{sw0Var6});
    }

    @Override // com.sonelli.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m8820E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m8820E() {
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
        sw0 sw0Var = (sw0) this.f3428b;
        sw0 sw0Var2 = (sw0) this.f3429c;
        sw0 sw0Var3 = (sw0) iv0Var.m4942n();
        sw0 sw0Var4 = (sw0) iv0Var.mo2645o();
        sw0 sw0Var5 = (sw0) this.f3430d[0];
        sw0 sw0Var6 = (sw0) iv0Var.mo4943p(0);
        int[] m4317j = h01.m4317j();
        int[] m4315h = h01.m4315h();
        int[] m4315h2 = h01.m4315h();
        int[] m4315h3 = h01.m4315h();
        boolean mo2282h = sw0Var5.mo2282h();
        if (mo2282h) {
            iArr = sw0Var3.f6602e;
            iArr2 = sw0Var4.f6602e;
        } else {
            rw0.m8267j(sw0Var5.f6602e, m4315h2);
            rw0.m8262e(m4315h2, sw0Var3.f6602e, m4315h);
            rw0.m8262e(m4315h2, sw0Var5.f6602e, m4315h2);
            rw0.m8262e(m4315h2, sw0Var4.f6602e, m4315h2);
            iArr = m4315h;
            iArr2 = m4315h2;
        }
        boolean mo2282h2 = sw0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = sw0Var.f6602e;
            iArr4 = sw0Var2.f6602e;
        } else {
            rw0.m8267j(sw0Var6.f6602e, m4315h3);
            rw0.m8262e(m4315h3, sw0Var.f6602e, m4317j);
            rw0.m8262e(m4315h3, sw0Var6.f6602e, m4315h3);
            rw0.m8262e(m4315h3, sw0Var2.f6602e, m4315h3);
            iArr3 = m4317j;
            iArr4 = m4315h3;
        }
        int[] m4315h4 = h01.m4315h();
        rw0.m8270m(iArr3, iArr, m4315h4);
        rw0.m8270m(iArr4, iArr2, m4315h);
        if (h01.m4328u(m4315h4)) {
            return h01.m4328u(m4315h) ? mo2638C() : m4937h.mo2308r();
        }
        rw0.m8267j(m4315h4, m4315h2);
        int[] m4315h5 = h01.m4315h();
        rw0.m8262e(m4315h2, m4315h4, m4315h5);
        rw0.m8262e(m4315h2, iArr3, m4315h2);
        rw0.m8264g(m4315h5, m4315h5);
        h01.m4331x(iArr4, m4315h5, m4317j);
        rw0.m8266i(h01.m4309b(m4315h2, m4315h2, m4315h5), m4315h5);
        sw0 sw0Var7 = new sw0(m4315h3);
        rw0.m8267j(m4315h, sw0Var7.f6602e);
        int[] iArr5 = sw0Var7.f6602e;
        rw0.m8270m(iArr5, m4315h5, iArr5);
        sw0 sw0Var8 = new sw0(m4315h5);
        rw0.m8270m(m4315h2, sw0Var7.f6602e, sw0Var8.f6602e);
        rw0.m8263f(sw0Var8.f6602e, m4315h, m4317j);
        rw0.m8265h(m4317j, sw0Var8.f6602e);
        sw0 sw0Var9 = new sw0(m4315h4);
        if (!mo2282h) {
            int[] iArr6 = sw0Var9.f6602e;
            rw0.m8262e(iArr6, sw0Var5.f6602e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = sw0Var9.f6602e;
            rw0.m8262e(iArr7, sw0Var6.f6602e, iArr7);
        }
        return new tw0(m4937h, sw0Var7, sw0Var8, new hv0[]{sw0Var9});
    }

    @Override // com.sonelli.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new tw0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
