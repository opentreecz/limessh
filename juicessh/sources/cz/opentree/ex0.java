package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ex0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f2549f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F"));

    /* renamed from: e */
    public int[] f2550e;

    public ex0() {
        this.f2550e = j01.m5015i();
    }

    public ex0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f2549f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
        }
        this.f2550e = dx0.m3328c(bigInteger);
    }

    public ex0(int[] iArr) {
        this.f2550e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        dx0.m3326a(this.f2550e, ((ex0) hv0Var).f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m5015i = j01.m5015i();
        dx0.m3327b(this.f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        e01.m3375d(dx0.f2295a, ((ex0) hv0Var).f2550e, m5015i);
        dx0.m3329d(m5015i, this.f2550e, m5015i);
        return new ex0(m5015i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ex0) {
            return j01.m5020n(this.f2550e, ((ex0) obj).f2550e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f2549f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m5015i = j01.m5015i();
        e01.m3375d(dx0.f2295a, this.f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5026t(this.f2550e);
    }

    public int hashCode() {
        return f2549f.hashCode() ^ e51.m3449r(this.f2550e, 0, 8);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5028v(this.f2550e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        dx0.m3329d(this.f2550e, ((ex0) hv0Var).f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m5015i = j01.m5015i();
        dx0.m3331f(this.f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f2550e;
        if (j01.m5028v(iArr) || j01.m5026t(iArr)) {
            return this;
        }
        int[] m5015i = j01.m5015i();
        dx0.m3334i(iArr, m5015i);
        dx0.m3329d(m5015i, iArr, m5015i);
        int[] m5015i2 = j01.m5015i();
        dx0.m3334i(m5015i, m5015i2);
        dx0.m3329d(m5015i2, iArr, m5015i2);
        int[] m5015i3 = j01.m5015i();
        dx0.m3335j(m5015i2, 3, m5015i3);
        dx0.m3329d(m5015i3, m5015i2, m5015i3);
        dx0.m3335j(m5015i3, 3, m5015i3);
        dx0.m3329d(m5015i3, m5015i2, m5015i3);
        dx0.m3335j(m5015i3, 2, m5015i3);
        dx0.m3329d(m5015i3, m5015i, m5015i3);
        int[] m5015i4 = j01.m5015i();
        dx0.m3335j(m5015i3, 11, m5015i4);
        dx0.m3329d(m5015i4, m5015i3, m5015i4);
        dx0.m3335j(m5015i4, 22, m5015i3);
        dx0.m3329d(m5015i3, m5015i4, m5015i3);
        int[] m5015i5 = j01.m5015i();
        dx0.m3335j(m5015i3, 44, m5015i5);
        dx0.m3329d(m5015i5, m5015i3, m5015i5);
        int[] m5015i6 = j01.m5015i();
        dx0.m3335j(m5015i5, 88, m5015i6);
        dx0.m3329d(m5015i6, m5015i5, m5015i6);
        dx0.m3335j(m5015i6, 44, m5015i5);
        dx0.m3329d(m5015i5, m5015i3, m5015i5);
        dx0.m3335j(m5015i5, 3, m5015i3);
        dx0.m3329d(m5015i3, m5015i2, m5015i3);
        dx0.m3335j(m5015i3, 23, m5015i3);
        dx0.m3329d(m5015i3, m5015i4, m5015i3);
        dx0.m3335j(m5015i3, 6, m5015i3);
        dx0.m3329d(m5015i3, m5015i, m5015i3);
        dx0.m3335j(m5015i3, 2, m5015i3);
        dx0.m3334i(m5015i3, m5015i);
        if (j01.m5020n(iArr, m5015i)) {
            return new ex0(m5015i3);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m5015i = j01.m5015i();
        dx0.m3334i(this.f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        dx0.m3336k(this.f2550e, ((ex0) hv0Var).f2550e, m5015i);
        return new ex0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return j01.m5023q(this.f2550e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5004J(this.f2550e);
    }
}
