package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class kw0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f4666f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC73"));

    /* renamed from: e */
    public int[] f4667e;

    public kw0() {
        this.f4667e = g01.m3907d();
    }

    public kw0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f4666f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
        }
        this.f4667e = jw0.m5735c(bigInteger);
    }

    public kw0(int[] iArr) {
        this.f4667e = iArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        jw0.m5733a(this.f4667e, ((kw0) hv0Var).f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m3907d = g01.m3907d();
        jw0.m5734b(this.f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        e01.m3375d(jw0.f4388a, ((kw0) hv0Var).f4667e, m3907d);
        jw0.m5736d(m3907d, this.f4667e, m3907d);
        return new kw0(m3907d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof kw0) {
            return g01.m3909f(this.f4667e, ((kw0) obj).f4667e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f4666f.bitLength();
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m3907d = g01.m3907d();
        e01.m3375d(jw0.f4388a, this.f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return g01.m3913j(this.f4667e);
    }

    public int hashCode() {
        return f4666f.hashCode() ^ e51.m3449r(this.f4667e, 0, 5);
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return g01.m3914k(this.f4667e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        jw0.m5736d(this.f4667e, ((kw0) hv0Var).f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m3907d = g01.m3907d();
        jw0.m5738f(this.f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f4667e;
        if (g01.m3914k(iArr) || g01.m3913j(iArr)) {
            return this;
        }
        int[] m3907d = g01.m3907d();
        jw0.m5741i(iArr, m3907d);
        jw0.m5736d(m3907d, iArr, m3907d);
        int[] m3907d2 = g01.m3907d();
        jw0.m5741i(m3907d, m3907d2);
        jw0.m5736d(m3907d2, iArr, m3907d2);
        int[] m3907d3 = g01.m3907d();
        jw0.m5741i(m3907d2, m3907d3);
        jw0.m5736d(m3907d3, iArr, m3907d3);
        int[] m3907d4 = g01.m3907d();
        jw0.m5742j(m3907d3, 3, m3907d4);
        jw0.m5736d(m3907d4, m3907d2, m3907d4);
        jw0.m5742j(m3907d4, 7, m3907d3);
        jw0.m5736d(m3907d3, m3907d4, m3907d3);
        jw0.m5742j(m3907d3, 3, m3907d4);
        jw0.m5736d(m3907d4, m3907d2, m3907d4);
        int[] m3907d5 = g01.m3907d();
        jw0.m5742j(m3907d4, 14, m3907d5);
        jw0.m5736d(m3907d5, m3907d3, m3907d5);
        jw0.m5742j(m3907d5, 31, m3907d3);
        jw0.m5736d(m3907d3, m3907d5, m3907d3);
        jw0.m5742j(m3907d3, 62, m3907d5);
        jw0.m5736d(m3907d5, m3907d3, m3907d5);
        jw0.m5742j(m3907d5, 3, m3907d3);
        jw0.m5736d(m3907d3, m3907d2, m3907d3);
        jw0.m5742j(m3907d3, 18, m3907d3);
        jw0.m5736d(m3907d3, m3907d4, m3907d3);
        jw0.m5742j(m3907d3, 2, m3907d3);
        jw0.m5736d(m3907d3, iArr, m3907d3);
        jw0.m5742j(m3907d3, 3, m3907d3);
        jw0.m5736d(m3907d3, m3907d, m3907d3);
        jw0.m5742j(m3907d3, 6, m3907d3);
        jw0.m5736d(m3907d3, m3907d2, m3907d3);
        jw0.m5742j(m3907d3, 2, m3907d3);
        jw0.m5736d(m3907d3, iArr, m3907d3);
        jw0.m5741i(m3907d3, m3907d);
        if (g01.m3909f(iArr, m3907d)) {
            return new kw0(m3907d3);
        }
        return null;
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m3907d = g01.m3907d();
        jw0.m5741i(this.f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        jw0.m5743k(this.f4667e, ((kw0) hv0Var).f4667e, m3907d);
        return new kw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return g01.m3911h(this.f4667e, 0) == 1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return g01.m3924u(this.f4667e);
    }
}
