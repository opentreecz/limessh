package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class mx0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f5160f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFF"));

    /* renamed from: e */
    public int[] f5161e;

    public mx0() {
        this.f5161e = p01.m7200k(12);
    }

    public mx0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5160f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
        }
        this.f5161e = lx0.m6310e(bigInteger);
    }

    public mx0(int[] iArr) {
        this.f5161e = iArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(12);
        lx0.m6306a(this.f5161e, ((mx0) hv0Var).f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m7200k = p01.m7200k(12);
        lx0.m6308c(this.f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(12);
        e01.m3375d(lx0.f4924a, ((mx0) hv0Var).f5161e, m7200k);
        lx0.m6311f(m7200k, this.f5161e, m7200k);
        return new mx0(m7200k);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mx0) {
            return p01.m7204o(12, this.f5161e, ((mx0) obj).f5161e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f5160f.bitLength();
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m7200k = p01.m7200k(12);
        e01.m3375d(lx0.f4924a, this.f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return p01.m7213x(12, this.f5161e);
    }

    public int hashCode() {
        return f5160f.hashCode() ^ e51.m3449r(this.f5161e, 0, 12);
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return p01.m7214y(12, this.f5161e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(12);
        lx0.m6311f(this.f5161e, ((mx0) hv0Var).f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m7200k = p01.m7200k(12);
        lx0.m6312g(this.f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f5161e;
        if (p01.m7214y(12, iArr) || p01.m7213x(12, iArr)) {
            return this;
        }
        int[] m7200k = p01.m7200k(12);
        int[] m7200k2 = p01.m7200k(12);
        int[] m7200k3 = p01.m7200k(12);
        int[] m7200k4 = p01.m7200k(12);
        lx0.m6315j(iArr, m7200k);
        lx0.m6311f(m7200k, iArr, m7200k);
        lx0.m6316k(m7200k, 2, m7200k2);
        lx0.m6311f(m7200k2, m7200k, m7200k2);
        lx0.m6315j(m7200k2, m7200k2);
        lx0.m6311f(m7200k2, iArr, m7200k2);
        lx0.m6316k(m7200k2, 5, m7200k3);
        lx0.m6311f(m7200k3, m7200k2, m7200k3);
        lx0.m6316k(m7200k3, 5, m7200k4);
        lx0.m6311f(m7200k4, m7200k2, m7200k4);
        lx0.m6316k(m7200k4, 15, m7200k2);
        lx0.m6311f(m7200k2, m7200k4, m7200k2);
        lx0.m6316k(m7200k2, 2, m7200k3);
        lx0.m6311f(m7200k, m7200k3, m7200k);
        lx0.m6316k(m7200k3, 28, m7200k3);
        lx0.m6311f(m7200k2, m7200k3, m7200k2);
        lx0.m6316k(m7200k2, 60, m7200k3);
        lx0.m6311f(m7200k3, m7200k2, m7200k3);
        lx0.m6316k(m7200k3, 120, m7200k2);
        lx0.m6311f(m7200k2, m7200k3, m7200k2);
        lx0.m6316k(m7200k2, 15, m7200k2);
        lx0.m6311f(m7200k2, m7200k4, m7200k2);
        lx0.m6316k(m7200k2, 33, m7200k2);
        lx0.m6311f(m7200k2, m7200k, m7200k2);
        lx0.m6316k(m7200k2, 64, m7200k2);
        lx0.m6311f(m7200k2, iArr, m7200k2);
        lx0.m6316k(m7200k2, 30, m7200k);
        lx0.m6315j(m7200k, m7200k2);
        if (p01.m7204o(12, iArr, m7200k2)) {
            return new mx0(m7200k);
        }
        return null;
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m7200k = p01.m7200k(12);
        lx0.m6315j(this.f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(12);
        lx0.m6318m(this.f5161e, ((mx0) hv0Var).f5161e, m7200k);
        return new mx0(m7200k);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return p01.m7207r(this.f5161e, 0) == 1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return p01.m7187R(12, this.f5161e);
    }
}
