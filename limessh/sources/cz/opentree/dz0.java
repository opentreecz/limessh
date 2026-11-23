package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class dz0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f2305e;

    public dz0() {
        this.f2305e = k01.m5766c();
    }

    public dz0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 283) {
            throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
        }
        this.f2305e = cz0.m3067e(bigInteger);
    }

    public dz0(long[] jArr) {
        this.f2305e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m5766c = k01.m5766c();
        cz0.m3063a(this.f2305e, ((dz0) hv0Var).f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m5766c = k01.m5766c();
        cz0.m3065c(this.f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        return mo2284j(hv0Var.mo2281g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dz0) {
            return k01.m5768e(this.f2305e, ((dz0) obj).f2305e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 283;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m5766c = k01.m5766c();
        cz0.m3074l(this.f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return k01.m5769f(this.f2305e);
    }

    public int hashCode() {
        return e51.m3450s(this.f2305e, 0, 5) ^ 2831275;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return k01.m5770g(this.f2305e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m5766c = k01.m5766c();
        cz0.m3075m(this.f2305e, ((dz0) hv0Var).f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f2305e;
        long[] jArr2 = ((dz0) hv0Var).f2305e;
        long[] jArr3 = ((dz0) hv0Var2).f2305e;
        long[] jArr4 = ((dz0) hv0Var3).f2305e;
        long[] m7201l = p01.m7201l(9);
        cz0.m3076n(jArr, jArr2, m7201l);
        cz0.m3076n(jArr3, jArr4, m7201l);
        long[] m5766c = k01.m5766c();
        cz0.m3077o(m7201l, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m5766c = k01.m5766c();
        cz0.m3078p(this.f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m5766c = k01.m5766c();
        cz0.m3079q(this.f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f2305e;
        long[] jArr2 = ((dz0) hv0Var).f2305e;
        long[] jArr3 = ((dz0) hv0Var2).f2305e;
        long[] m7201l = p01.m7201l(9);
        cz0.m3080r(jArr, m7201l);
        cz0.m3076n(jArr2, jArr3, m7201l);
        long[] m5766c = k01.m5766c();
        cz0.m3077o(m7201l, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m5766c = k01.m5766c();
        cz0.m3081s(this.f2305e, i, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f2305e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return k01.m5771h(this.f2305e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m5766c = k01.m5766c();
        cz0.m3068f(this.f2305e, m5766c);
        return new dz0(m5766c);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return cz0.m3082t(this.f2305e);
    }
}
