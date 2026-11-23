package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class tx0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f6866e;

    public tx0() {
        this.f6866e = f01.m3631g();
    }

    public tx0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 113) {
            throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
        }
        this.f6866e = sx0.m8496e(bigInteger);
    }

    public tx0(long[] jArr) {
        this.f6866e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m3631g = f01.m3631g();
        sx0.m8492a(this.f6866e, ((tx0) hv0Var).f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m3631g = f01.m3631g();
        sx0.m8494c(this.f6866e, m3631g);
        return new tx0(m3631g);
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
        if (obj instanceof tx0) {
            return f01.m3635k(this.f6866e, ((tx0) obj).f6866e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 113;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m3631g = f01.m3631g();
        sx0.m8501j(this.f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return f01.m3640p(this.f6866e);
    }

    public int hashCode() {
        return e51.m3450s(this.f6866e, 0, 2) ^ 113009;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return f01.m3642r(this.f6866e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m3631g = f01.m3631g();
        sx0.m8502k(this.f6866e, ((tx0) hv0Var).f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f6866e;
        long[] jArr2 = ((tx0) hv0Var).f6866e;
        long[] jArr3 = ((tx0) hv0Var2).f6866e;
        long[] jArr4 = ((tx0) hv0Var3).f6866e;
        long[] m3633i = f01.m3633i();
        sx0.m8503l(jArr, jArr2, m3633i);
        sx0.m8503l(jArr3, jArr4, m3633i);
        long[] m3631g = f01.m3631g();
        sx0.m8504m(m3633i, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m3631g = f01.m3631g();
        sx0.m8505n(this.f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m3631g = f01.m3631g();
        sx0.m8506o(this.f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f6866e;
        long[] jArr2 = ((tx0) hv0Var).f6866e;
        long[] jArr3 = ((tx0) hv0Var2).f6866e;
        long[] m3633i = f01.m3633i();
        sx0.m8507p(jArr, m3633i);
        sx0.m8503l(jArr2, jArr3, m3633i);
        long[] m3631g = f01.m3631g();
        sx0.m8504m(m3633i, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m3631g = f01.m3631g();
        sx0.m8508q(this.f6866e, i, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f6866e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return f01.m3649y(this.f6866e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m3631g = f01.m3631g();
        sx0.m8497f(this.f6866e, m3631g);
        return new tx0(m3631g);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return sx0.m8509r(this.f6866e);
    }
}
