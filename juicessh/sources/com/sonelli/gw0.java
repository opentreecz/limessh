package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class gw0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f3017f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFF"));

    /* renamed from: e */
    public int[] f3018e;

    public gw0() {
        this.f3018e = g01.m3907d();
    }

    public gw0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f3017f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP160R1FieldElement");
        }
        this.f3018e = fw0.m3890c(bigInteger);
    }

    public gw0(int[] iArr) {
        this.f3018e = iArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        fw0.m3888a(this.f3018e, ((gw0) hv0Var).f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m3907d = g01.m3907d();
        fw0.m3889b(this.f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        e01.m3375d(fw0.f2776a, ((gw0) hv0Var).f3018e, m3907d);
        fw0.m3891d(m3907d, this.f3018e, m3907d);
        return new gw0(m3907d);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gw0) {
            return g01.m3909f(this.f3018e, ((gw0) obj).f3018e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f3017f.bitLength();
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m3907d = g01.m3907d();
        e01.m3375d(fw0.f2776a, this.f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return g01.m3913j(this.f3018e);
    }

    public int hashCode() {
        return f3017f.hashCode() ^ e51.m3449r(this.f3018e, 0, 5);
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return g01.m3914k(this.f3018e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        fw0.m3891d(this.f3018e, ((gw0) hv0Var).f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m3907d = g01.m3907d();
        fw0.m3893f(this.f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f3018e;
        if (g01.m3914k(iArr) || g01.m3913j(iArr)) {
            return this;
        }
        int[] m3907d = g01.m3907d();
        fw0.m3896i(iArr, m3907d);
        fw0.m3891d(m3907d, iArr, m3907d);
        int[] m3907d2 = g01.m3907d();
        fw0.m3897j(m3907d, 2, m3907d2);
        fw0.m3891d(m3907d2, m3907d, m3907d2);
        fw0.m3897j(m3907d2, 4, m3907d);
        fw0.m3891d(m3907d, m3907d2, m3907d);
        fw0.m3897j(m3907d, 8, m3907d2);
        fw0.m3891d(m3907d2, m3907d, m3907d2);
        fw0.m3897j(m3907d2, 16, m3907d);
        fw0.m3891d(m3907d, m3907d2, m3907d);
        fw0.m3897j(m3907d, 32, m3907d2);
        fw0.m3891d(m3907d2, m3907d, m3907d2);
        fw0.m3897j(m3907d2, 64, m3907d);
        fw0.m3891d(m3907d, m3907d2, m3907d);
        fw0.m3896i(m3907d, m3907d2);
        fw0.m3891d(m3907d2, iArr, m3907d2);
        fw0.m3897j(m3907d2, 29, m3907d2);
        fw0.m3896i(m3907d2, m3907d);
        if (g01.m3909f(iArr, m3907d)) {
            return new gw0(m3907d2);
        }
        return null;
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m3907d = g01.m3907d();
        fw0.m3896i(this.f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m3907d = g01.m3907d();
        fw0.m3898k(this.f3018e, ((gw0) hv0Var).f3018e, m3907d);
        return new gw0(m3907d);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return g01.m3911h(this.f3018e, 0) == 1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return g01.m3924u(this.f3018e);
    }
}
