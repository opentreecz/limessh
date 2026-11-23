package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ix0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f3443f = new BigInteger(1, o51.m6872a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: e */
    public int[] f3444e;

    public ix0() {
        this.f3444e = j01.m5015i();
    }

    public ix0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f3443f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256R1FieldElement");
        }
        this.f3444e = hx0.m4669d(bigInteger);
    }

    public ix0(int[] iArr) {
        this.f3444e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        hx0.m4666a(this.f3444e, ((ix0) hv0Var).f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m5015i = j01.m5015i();
        hx0.m4667b(this.f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        e01.m3375d(hx0.f3241a, ((ix0) hv0Var).f3444e, m5015i);
        hx0.m4670e(m5015i, this.f3444e, m5015i);
        return new ix0(m5015i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ix0) {
            return j01.m5020n(this.f3444e, ((ix0) obj).f3444e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f3443f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m5015i = j01.m5015i();
        e01.m3375d(hx0.f3241a, this.f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5026t(this.f3444e);
    }

    public int hashCode() {
        return f3443f.hashCode() ^ e51.m3449r(this.f3444e, 0, 8);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5028v(this.f3444e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        hx0.m4670e(this.f3444e, ((ix0) hv0Var).f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m5015i = j01.m5015i();
        hx0.m4672g(this.f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f3444e;
        if (j01.m5028v(iArr) || j01.m5026t(iArr)) {
            return this;
        }
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        hx0.m4675j(iArr, m5015i);
        hx0.m4670e(m5015i, iArr, m5015i);
        hx0.m4676k(m5015i, 2, m5015i2);
        hx0.m4670e(m5015i2, m5015i, m5015i2);
        hx0.m4676k(m5015i2, 4, m5015i);
        hx0.m4670e(m5015i, m5015i2, m5015i);
        hx0.m4676k(m5015i, 8, m5015i2);
        hx0.m4670e(m5015i2, m5015i, m5015i2);
        hx0.m4676k(m5015i2, 16, m5015i);
        hx0.m4670e(m5015i, m5015i2, m5015i);
        hx0.m4676k(m5015i, 32, m5015i);
        hx0.m4670e(m5015i, iArr, m5015i);
        hx0.m4676k(m5015i, 96, m5015i);
        hx0.m4670e(m5015i, iArr, m5015i);
        hx0.m4676k(m5015i, 94, m5015i);
        hx0.m4675j(m5015i, m5015i2);
        if (j01.m5020n(iArr, m5015i2)) {
            return new ix0(m5015i);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m5015i = j01.m5015i();
        hx0.m4675j(this.f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        hx0.m4678m(this.f3444e, ((ix0) hv0Var).f3444e, m5015i);
        return new ix0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return j01.m5023q(this.f3444e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5004J(this.f3444e);
    }
}
