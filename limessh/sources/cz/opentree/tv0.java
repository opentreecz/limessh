package cz.opentree;

import cz.opentree.iv0;

/* loaded from: classes.dex */
public class tv0 extends iv0.AbstractC1181c {
    public tv0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public tv0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        return this.f3429c.mo2283i() ? m4937h().mo2308r() : m8819H(true);
    }

    @Override // cz.opentree.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m8818G() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : m8819H(false).mo2641a(iv0Var);
    }

    /* renamed from: E */
    public sv0 m8816E(sv0 sv0Var, int[] iArr) {
        sv0 sv0Var2 = (sv0) m4937h().m4266l();
        if (sv0Var.mo2282h()) {
            return sv0Var2;
        }
        sv0 sv0Var3 = new sv0();
        if (iArr == null) {
            iArr = sv0Var3.f6599e;
            rv0.m8252j(sv0Var.f6599e, iArr);
        }
        rv0.m8252j(iArr, sv0Var3.f6599e);
        int[] iArr2 = sv0Var3.f6599e;
        rv0.m8247e(iArr2, sv0Var2.f6599e, iArr2);
        return sv0Var3;
    }

    /* renamed from: F */
    public sv0 m8817F() {
        hv0[] hv0VarArr = this.f3430d;
        sv0 sv0Var = (sv0) hv0VarArr[1];
        if (sv0Var != null) {
            return sv0Var;
        }
        sv0 m8816E = m8816E((sv0) hv0VarArr[0], null);
        hv0VarArr[1] = m8816E;
        return m8816E;
    }

    /* renamed from: G */
    public iv0 m8818G() {
        return (m4945r() || this.f3429c.mo2283i()) ? this : m8819H(false).mo2641a(this);
    }

    /* renamed from: H */
    public tv0 m8819H(boolean z) {
        sv0 sv0Var = (sv0) this.f3428b;
        sv0 sv0Var2 = (sv0) this.f3429c;
        sv0 sv0Var3 = (sv0) this.f3430d[0];
        sv0 m8817F = m8817F();
        int[] m5015i = j01.m5015i();
        rv0.m8252j(sv0Var.f6599e, m5015i);
        rv0.m8251i(j01.m5008b(m5015i, m5015i, m5015i) + j01.m5010d(m8817F.f6599e, m5015i), m5015i);
        int[] m5015i2 = j01.m5015i();
        rv0.m8257o(sv0Var2.f6599e, m5015i2);
        int[] m5015i3 = j01.m5015i();
        rv0.m8247e(m5015i2, sv0Var2.f6599e, m5015i3);
        int[] m5015i4 = j01.m5015i();
        rv0.m8247e(m5015i3, sv0Var.f6599e, m5015i4);
        rv0.m8257o(m5015i4, m5015i4);
        int[] m5015i5 = j01.m5015i();
        rv0.m8252j(m5015i3, m5015i5);
        rv0.m8257o(m5015i5, m5015i5);
        sv0 sv0Var4 = new sv0(m5015i3);
        rv0.m8252j(m5015i, sv0Var4.f6599e);
        int[] iArr = sv0Var4.f6599e;
        rv0.m8256n(iArr, m5015i4, iArr);
        int[] iArr2 = sv0Var4.f6599e;
        rv0.m8256n(iArr2, m5015i4, iArr2);
        sv0 sv0Var5 = new sv0(m5015i4);
        rv0.m8256n(m5015i4, sv0Var4.f6599e, sv0Var5.f6599e);
        int[] iArr3 = sv0Var5.f6599e;
        rv0.m8247e(iArr3, m5015i, iArr3);
        int[] iArr4 = sv0Var5.f6599e;
        rv0.m8256n(iArr4, m5015i5, iArr4);
        sv0 sv0Var6 = new sv0(m5015i2);
        if (!j01.m5026t(sv0Var3.f6599e)) {
            int[] iArr5 = sv0Var6.f6599e;
            rv0.m8247e(iArr5, sv0Var3.f6599e, iArr5);
        }
        sv0 sv0Var7 = null;
        if (z) {
            sv0Var7 = new sv0(m5015i5);
            int[] iArr6 = sv0Var7.f6599e;
            rv0.m8247e(iArr6, m8817F.f6599e, iArr6);
            int[] iArr7 = sv0Var7.f6599e;
            rv0.m8257o(iArr7, iArr7);
        }
        return new tv0(m4937h(), sv0Var4, sv0Var5, new hv0[]{sv0Var6, sv0Var7});
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
        sv0 sv0Var = (sv0) this.f3428b;
        sv0 sv0Var2 = (sv0) this.f3429c;
        sv0 sv0Var3 = (sv0) this.f3430d[0];
        sv0 sv0Var4 = (sv0) iv0Var.m4942n();
        sv0 sv0Var5 = (sv0) iv0Var.mo2645o();
        sv0 sv0Var6 = (sv0) iv0Var.mo4943p(0);
        int[] m5017k = j01.m5017k();
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        int[] m5015i3 = j01.m5015i();
        boolean mo2282h = sv0Var3.mo2282h();
        if (mo2282h) {
            iArr = sv0Var4.f6599e;
            iArr2 = sv0Var5.f6599e;
        } else {
            rv0.m8252j(sv0Var3.f6599e, m5015i2);
            rv0.m8247e(m5015i2, sv0Var4.f6599e, m5015i);
            rv0.m8247e(m5015i2, sv0Var3.f6599e, m5015i2);
            rv0.m8247e(m5015i2, sv0Var5.f6599e, m5015i2);
            iArr = m5015i;
            iArr2 = m5015i2;
        }
        boolean mo2282h2 = sv0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = sv0Var.f6599e;
            iArr4 = sv0Var2.f6599e;
        } else {
            rv0.m8252j(sv0Var6.f6599e, m5015i3);
            rv0.m8247e(m5015i3, sv0Var.f6599e, m5017k);
            rv0.m8247e(m5015i3, sv0Var6.f6599e, m5015i3);
            rv0.m8247e(m5015i3, sv0Var2.f6599e, m5015i3);
            iArr3 = m5017k;
            iArr4 = m5015i3;
        }
        int[] m5015i4 = j01.m5015i();
        rv0.m8256n(iArr3, iArr, m5015i4);
        rv0.m8256n(iArr4, iArr2, m5015i);
        if (j01.m5028v(m5015i4)) {
            return j01.m5028v(m5015i) ? mo2638C() : m4937h.mo2308r();
        }
        int[] m5015i5 = j01.m5015i();
        rv0.m8252j(m5015i4, m5015i5);
        int[] m5015i6 = j01.m5015i();
        rv0.m8247e(m5015i5, m5015i4, m5015i6);
        rv0.m8247e(m5015i5, iArr3, m5015i2);
        rv0.m8249g(m5015i6, m5015i6);
        j01.m5031y(iArr4, m5015i6, m5017k);
        rv0.m8251i(j01.m5008b(m5015i2, m5015i2, m5015i6), m5015i6);
        sv0 sv0Var7 = new sv0(m5015i3);
        rv0.m8252j(m5015i, sv0Var7.f6599e);
        int[] iArr5 = sv0Var7.f6599e;
        rv0.m8256n(iArr5, m5015i6, iArr5);
        sv0 sv0Var8 = new sv0(m5015i6);
        rv0.m8256n(m5015i2, sv0Var7.f6599e, sv0Var8.f6599e);
        rv0.m8248f(sv0Var8.f6599e, m5015i, m5017k);
        rv0.m8250h(m5017k, sv0Var8.f6599e);
        sv0 sv0Var9 = new sv0(m5015i4);
        if (!mo2282h) {
            int[] iArr6 = sv0Var9.f6599e;
            rv0.m8247e(iArr6, sv0Var3.f6599e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = sv0Var9.f6599e;
            rv0.m8247e(iArr7, sv0Var6.f6599e, iArr7);
        }
        if (!mo2282h || !mo2282h2) {
            m5015i5 = null;
        }
        return new tv0(m4937h, sv0Var7, sv0Var8, new hv0[]{sv0Var9, m8816E(sv0Var9, m5015i5)});
    }

    @Override // cz.opentree.iv0
    /* renamed from: p */
    public hv0 mo4943p(int i) {
        return i == 1 ? m8817F() : super.mo4943p(i);
    }

    @Override // cz.opentree.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new tv0(m4937h(), this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
