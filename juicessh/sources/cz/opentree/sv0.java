package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class sv0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f6597f = j01.m5004J(rv0.f6293a);

    /* renamed from: g */
    public static final int[] f6598g = {1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848};

    /* renamed from: e */
    public int[] f6599e;

    public sv0() {
        this.f6599e = j01.m5015i();
    }

    public sv0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f6597f) >= 0) {
            throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
        }
        this.f6599e = rv0.m8246d(bigInteger);
    }

    public sv0(int[] iArr) {
        this.f6599e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        rv0.m8243a(this.f6599e, ((sv0) hv0Var).f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m5015i = j01.m5015i();
        rv0.m8244b(this.f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        e01.m3375d(rv0.f6293a, ((sv0) hv0Var).f6599e, m5015i);
        rv0.m8247e(m5015i, this.f6599e, m5015i);
        return new sv0(m5015i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sv0) {
            return j01.m5020n(this.f6599e, ((sv0) obj).f6599e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f6597f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m5015i = j01.m5015i();
        e01.m3375d(rv0.f6293a, this.f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5026t(this.f6599e);
    }

    public int hashCode() {
        return f6597f.hashCode() ^ e51.m3449r(this.f6599e, 0, 8);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5028v(this.f6599e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        rv0.m8247e(this.f6599e, ((sv0) hv0Var).f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m5015i = j01.m5015i();
        rv0.m8249g(this.f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f6599e;
        if (j01.m5028v(iArr) || j01.m5026t(iArr)) {
            return this;
        }
        int[] m5015i = j01.m5015i();
        rv0.m8252j(iArr, m5015i);
        rv0.m8247e(m5015i, iArr, m5015i);
        rv0.m8252j(m5015i, m5015i);
        rv0.m8247e(m5015i, iArr, m5015i);
        int[] m5015i2 = j01.m5015i();
        rv0.m8252j(m5015i, m5015i2);
        rv0.m8247e(m5015i2, iArr, m5015i2);
        int[] m5015i3 = j01.m5015i();
        rv0.m8253k(m5015i2, 3, m5015i3);
        rv0.m8247e(m5015i3, m5015i, m5015i3);
        rv0.m8253k(m5015i3, 4, m5015i);
        rv0.m8247e(m5015i, m5015i2, m5015i);
        rv0.m8253k(m5015i, 4, m5015i3);
        rv0.m8247e(m5015i3, m5015i2, m5015i3);
        rv0.m8253k(m5015i3, 15, m5015i2);
        rv0.m8247e(m5015i2, m5015i3, m5015i2);
        rv0.m8253k(m5015i2, 30, m5015i3);
        rv0.m8247e(m5015i3, m5015i2, m5015i3);
        rv0.m8253k(m5015i3, 60, m5015i2);
        rv0.m8247e(m5015i2, m5015i3, m5015i2);
        rv0.m8253k(m5015i2, 11, m5015i3);
        rv0.m8247e(m5015i3, m5015i, m5015i3);
        rv0.m8253k(m5015i3, 120, m5015i);
        rv0.m8247e(m5015i, m5015i2, m5015i);
        rv0.m8252j(m5015i, m5015i);
        rv0.m8252j(m5015i, m5015i2);
        if (j01.m5020n(iArr, m5015i2)) {
            return new sv0(m5015i);
        }
        rv0.m8247e(m5015i, f6598g, m5015i);
        rv0.m8252j(m5015i, m5015i2);
        if (j01.m5020n(iArr, m5015i2)) {
            return new sv0(m5015i);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m5015i = j01.m5015i();
        rv0.m8252j(this.f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        rv0.m8256n(this.f6599e, ((sv0) hv0Var).f6599e, m5015i);
        return new sv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return j01.m5023q(this.f6599e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5004J(this.f6599e);
    }
}
