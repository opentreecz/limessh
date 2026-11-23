package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class sw0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f6601f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFF"));

    /* renamed from: e */
    public int[] f6602e;

    public sw0() {
        this.f6602e = h01.m4315h();
    }

    public sw0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f6601f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192R1FieldElement");
        }
        this.f6602e = rw0.m8261d(bigInteger);
    }

    public sw0(int[] iArr) {
        this.f6602e = iArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        rw0.m8258a(this.f6602e, ((sw0) hv0Var).f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m4315h = h01.m4315h();
        rw0.m8259b(this.f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        e01.m3375d(rw0.f6296a, ((sw0) hv0Var).f6602e, m4315h);
        rw0.m8262e(m4315h, this.f6602e, m4315h);
        return new sw0(m4315h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sw0) {
            return h01.m4320m(this.f6602e, ((sw0) obj).f6602e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f6601f.bitLength();
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m4315h = h01.m4315h();
        e01.m3375d(rw0.f6296a, this.f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return h01.m4326s(this.f6602e);
    }

    public int hashCode() {
        return f6601f.hashCode() ^ e51.m3449r(this.f6602e, 0, 6);
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return h01.m4328u(this.f6602e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        rw0.m8262e(this.f6602e, ((sw0) hv0Var).f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m4315h = h01.m4315h();
        rw0.m8264g(this.f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f6602e;
        if (h01.m4328u(iArr) || h01.m4326s(iArr)) {
            return this;
        }
        int[] m4315h = h01.m4315h();
        int[] m4315h2 = h01.m4315h();
        rw0.m8267j(iArr, m4315h);
        rw0.m8262e(m4315h, iArr, m4315h);
        rw0.m8268k(m4315h, 2, m4315h2);
        rw0.m8262e(m4315h2, m4315h, m4315h2);
        rw0.m8268k(m4315h2, 4, m4315h);
        rw0.m8262e(m4315h, m4315h2, m4315h);
        rw0.m8268k(m4315h, 8, m4315h2);
        rw0.m8262e(m4315h2, m4315h, m4315h2);
        rw0.m8268k(m4315h2, 16, m4315h);
        rw0.m8262e(m4315h, m4315h2, m4315h);
        rw0.m8268k(m4315h, 32, m4315h2);
        rw0.m8262e(m4315h2, m4315h, m4315h2);
        rw0.m8268k(m4315h2, 64, m4315h);
        rw0.m8262e(m4315h, m4315h2, m4315h);
        rw0.m8268k(m4315h, 62, m4315h);
        rw0.m8267j(m4315h, m4315h2);
        if (h01.m4320m(iArr, m4315h2)) {
            return new sw0(m4315h);
        }
        return null;
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m4315h = h01.m4315h();
        rw0.m8267j(this.f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        rw0.m8270m(this.f6602e, ((sw0) hv0Var).f6602e, m4315h);
        return new sw0(m4315h);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return h01.m4323p(this.f6602e, 0) == 1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return h01.m4305H(this.f6602e);
    }
}
