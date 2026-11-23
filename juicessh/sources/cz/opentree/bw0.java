package cz.opentree;

import cz.opentree.iv0;

/* loaded from: classes.dex */
public class bw0 extends iv0.AbstractC1181c {
    public bw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        super(gv0Var, hv0Var, hv0Var2);
    }

    public bw0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.iv0
    /* renamed from: C */
    public iv0 mo2638C() {
        if (m4945r()) {
            return this;
        }
        gv0 m4937h = m4937h();
        aw0 aw0Var = (aw0) this.f3429c;
        if (aw0Var.mo2283i()) {
            return m4937h.mo2308r();
        }
        aw0 aw0Var2 = (aw0) this.f3428b;
        aw0 aw0Var3 = (aw0) this.f3430d[0];
        int[] m3630f = f01.m3630f();
        int[] m3630f2 = f01.m3630f();
        int[] m3630f3 = f01.m3630f();
        zv0.m10642j(aw0Var.f1535e, m3630f3);
        int[] m3630f4 = f01.m3630f();
        zv0.m10642j(m3630f3, m3630f4);
        boolean mo2282h = aw0Var3.mo2282h();
        int[] iArr = aw0Var3.f1535e;
        if (!mo2282h) {
            zv0.m10642j(iArr, m3630f2);
            iArr = m3630f2;
        }
        zv0.m10645m(aw0Var2.f1535e, iArr, m3630f);
        zv0.m10633a(aw0Var2.f1535e, iArr, m3630f2);
        zv0.m10637e(m3630f2, m3630f, m3630f2);
        zv0.m10641i(f01.m3626b(m3630f2, m3630f2, m3630f2), m3630f2);
        zv0.m10637e(m3630f3, aw0Var2.f1535e, m3630f3);
        zv0.m10641i(p01.m7178I(4, m3630f3, 2, 0), m3630f3);
        zv0.m10641i(p01.m7179J(4, m3630f4, 3, 0, m3630f), m3630f);
        aw0 aw0Var4 = new aw0(m3630f4);
        zv0.m10642j(m3630f2, aw0Var4.f1535e);
        int[] iArr2 = aw0Var4.f1535e;
        zv0.m10645m(iArr2, m3630f3, iArr2);
        int[] iArr3 = aw0Var4.f1535e;
        zv0.m10645m(iArr3, m3630f3, iArr3);
        aw0 aw0Var5 = new aw0(m3630f3);
        zv0.m10645m(m3630f3, aw0Var4.f1535e, aw0Var5.f1535e);
        int[] iArr4 = aw0Var5.f1535e;
        zv0.m10637e(iArr4, m3630f2, iArr4);
        int[] iArr5 = aw0Var5.f1535e;
        zv0.m10645m(iArr5, m3630f, iArr5);
        aw0 aw0Var6 = new aw0(m3630f2);
        zv0.m10646n(aw0Var.f1535e, aw0Var6.f1535e);
        if (!mo2282h) {
            int[] iArr6 = aw0Var6.f1535e;
            zv0.m10637e(iArr6, aw0Var3.f1535e, iArr6);
        }
        return new bw0(m4937h, aw0Var4, aw0Var5, new hv0[]{aw0Var6});
    }

    @Override // cz.opentree.iv0
    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return this == iv0Var ? m2640E() : m4945r() ? iv0Var : iv0Var.m4945r() ? mo2638C() : this.f3429c.mo2283i() ? iv0Var : mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: E */
    public iv0 m2640E() {
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
        aw0 aw0Var = (aw0) this.f3428b;
        aw0 aw0Var2 = (aw0) this.f3429c;
        aw0 aw0Var3 = (aw0) iv0Var.m4942n();
        aw0 aw0Var4 = (aw0) iv0Var.mo2645o();
        aw0 aw0Var5 = (aw0) this.f3430d[0];
        aw0 aw0Var6 = (aw0) iv0Var.mo4943p(0);
        int[] m3632h = f01.m3632h();
        int[] m3630f = f01.m3630f();
        int[] m3630f2 = f01.m3630f();
        int[] m3630f3 = f01.m3630f();
        boolean mo2282h = aw0Var5.mo2282h();
        if (mo2282h) {
            iArr = aw0Var3.f1535e;
            iArr2 = aw0Var4.f1535e;
        } else {
            zv0.m10642j(aw0Var5.f1535e, m3630f2);
            zv0.m10637e(m3630f2, aw0Var3.f1535e, m3630f);
            zv0.m10637e(m3630f2, aw0Var5.f1535e, m3630f2);
            zv0.m10637e(m3630f2, aw0Var4.f1535e, m3630f2);
            iArr = m3630f;
            iArr2 = m3630f2;
        }
        boolean mo2282h2 = aw0Var6.mo2282h();
        if (mo2282h2) {
            iArr3 = aw0Var.f1535e;
            iArr4 = aw0Var2.f1535e;
        } else {
            zv0.m10642j(aw0Var6.f1535e, m3630f3);
            zv0.m10637e(m3630f3, aw0Var.f1535e, m3632h);
            zv0.m10637e(m3630f3, aw0Var6.f1535e, m3630f3);
            zv0.m10637e(m3630f3, aw0Var2.f1535e, m3630f3);
            iArr3 = m3632h;
            iArr4 = m3630f3;
        }
        int[] m3630f4 = f01.m3630f();
        zv0.m10645m(iArr3, iArr, m3630f4);
        zv0.m10645m(iArr4, iArr2, m3630f);
        if (f01.m3641q(m3630f4)) {
            return f01.m3641q(m3630f) ? mo2638C() : m4937h.mo2308r();
        }
        zv0.m10642j(m3630f4, m3630f2);
        int[] m3630f5 = f01.m3630f();
        zv0.m10637e(m3630f2, m3630f4, m3630f5);
        zv0.m10637e(m3630f2, iArr3, m3630f2);
        zv0.m10639g(m3630f5, m3630f5);
        f01.m3643s(iArr4, m3630f5, m3632h);
        zv0.m10641i(f01.m3626b(m3630f2, m3630f2, m3630f5), m3630f5);
        aw0 aw0Var7 = new aw0(m3630f3);
        zv0.m10642j(m3630f, aw0Var7.f1535e);
        int[] iArr5 = aw0Var7.f1535e;
        zv0.m10645m(iArr5, m3630f5, iArr5);
        aw0 aw0Var8 = new aw0(m3630f5);
        zv0.m10645m(m3630f2, aw0Var7.f1535e, aw0Var8.f1535e);
        zv0.m10638f(aw0Var8.f1535e, m3630f, m3632h);
        zv0.m10640h(m3632h, aw0Var8.f1535e);
        aw0 aw0Var9 = new aw0(m3630f4);
        if (!mo2282h) {
            int[] iArr6 = aw0Var9.f1535e;
            zv0.m10637e(iArr6, aw0Var5.f1535e, iArr6);
        }
        if (!mo2282h2) {
            int[] iArr7 = aw0Var9.f1535e;
            zv0.m10637e(iArr7, aw0Var6.f1535e, iArr7);
        }
        return new bw0(m4937h, aw0Var7, aw0Var8, new hv0[]{aw0Var9});
    }

    @Override // cz.opentree.iv0
    /* renamed from: v */
    public iv0 mo2642v() {
        return m4945r() ? this : new bw0(this.f3427a, this.f3428b, this.f3429c.mo2285m(), this.f3430d);
    }
}
