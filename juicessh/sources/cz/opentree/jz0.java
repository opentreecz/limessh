package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class jz0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f4398e;

    public jz0() {
        this.f4398e = m01.m6331c();
    }

    public jz0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 409) {
            throw new IllegalArgumentException("x value invalid for SecT409FieldElement");
        }
        this.f4398e = iz0.m4974e(bigInteger);
    }

    public jz0(long[] jArr) {
        this.f4398e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m6331c = m01.m6331c();
        iz0.m4970a(this.f4398e, ((jz0) hv0Var).f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m6331c = m01.m6331c();
        iz0.m4972c(this.f4398e, m6331c);
        return new jz0(m6331c);
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
        if (obj instanceof jz0) {
            return m01.m6333e(this.f4398e, ((jz0) obj).f4398e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 409;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m6331c = m01.m6331c();
        iz0.m4981l(this.f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return m01.m6334f(this.f4398e);
    }

    public int hashCode() {
        return e51.m3450s(this.f4398e, 0, 7) ^ 4090087;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return m01.m6335g(this.f4398e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m6331c = m01.m6331c();
        iz0.m4982m(this.f4398e, ((jz0) hv0Var).f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f4398e;
        long[] jArr2 = ((jz0) hv0Var).f4398e;
        long[] jArr3 = ((jz0) hv0Var2).f4398e;
        long[] jArr4 = ((jz0) hv0Var3).f4398e;
        long[] m7201l = p01.m7201l(13);
        iz0.m4983n(jArr, jArr2, m7201l);
        iz0.m4983n(jArr3, jArr4, m7201l);
        long[] m6331c = m01.m6331c();
        iz0.m4984o(m7201l, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m6331c = m01.m6331c();
        iz0.m4985p(this.f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m6331c = m01.m6331c();
        iz0.m4986q(this.f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f4398e;
        long[] jArr2 = ((jz0) hv0Var).f4398e;
        long[] jArr3 = ((jz0) hv0Var2).f4398e;
        long[] m7201l = p01.m7201l(13);
        iz0.m4987r(jArr, m7201l);
        iz0.m4983n(jArr2, jArr3, m7201l);
        long[] m6331c = m01.m6331c();
        iz0.m4984o(m7201l, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m6331c = m01.m6331c();
        iz0.m4988s(this.f4398e, i, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f4398e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return m01.m6336h(this.f4398e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m6331c = m01.m6331c();
        iz0.m4975f(this.f4398e, m6331c);
        return new jz0(m6331c);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return iz0.m4989t(this.f4398e);
    }
}
