package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ww0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f7803f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFE56D"));

    /* renamed from: g */
    public static final int[] f7804g = {868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644};

    /* renamed from: e */
    public int[] f7805e;

    public ww0() {
        this.f7805e = i01.m4687e();
    }

    public ww0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f7803f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
        }
        this.f7805e = vw0.m9362c(bigInteger);
    }

    public ww0(int[] iArr) {
        this.f7805e = iArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        vw0.m9360a(this.f7805e, ((ww0) hv0Var).f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m4687e = i01.m4687e();
        vw0.m9361b(this.f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        e01.m3375d(vw0.f7562a, ((ww0) hv0Var).f7805e, m4687e);
        vw0.m9363d(m4687e, this.f7805e, m4687e);
        return new ww0(m4687e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ww0) {
            return i01.m4689g(this.f7805e, ((ww0) obj).f7805e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f7803f.bitLength();
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m4687e = i01.m4687e();
        e01.m3375d(vw0.f7562a, this.f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return i01.m4693k(this.f7805e);
    }

    public int hashCode() {
        return f7803f.hashCode() ^ e51.m3449r(this.f7805e, 0, 7);
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return i01.m4694l(this.f7805e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        vw0.m9363d(this.f7805e, ((ww0) hv0Var).f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m4687e = i01.m4687e();
        vw0.m9365f(this.f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f7805e;
        if (i01.m4694l(iArr) || i01.m4693k(iArr)) {
            return this;
        }
        int[] m4687e = i01.m4687e();
        vw0.m9368i(iArr, m4687e);
        vw0.m9363d(m4687e, iArr, m4687e);
        vw0.m9368i(m4687e, m4687e);
        vw0.m9363d(m4687e, iArr, m4687e);
        int[] m4687e2 = i01.m4687e();
        vw0.m9368i(m4687e, m4687e2);
        vw0.m9363d(m4687e2, iArr, m4687e2);
        int[] m4687e3 = i01.m4687e();
        vw0.m9369j(m4687e2, 4, m4687e3);
        vw0.m9363d(m4687e3, m4687e2, m4687e3);
        int[] m4687e4 = i01.m4687e();
        vw0.m9369j(m4687e3, 3, m4687e4);
        vw0.m9363d(m4687e4, m4687e, m4687e4);
        vw0.m9369j(m4687e4, 8, m4687e4);
        vw0.m9363d(m4687e4, m4687e3, m4687e4);
        vw0.m9369j(m4687e4, 4, m4687e3);
        vw0.m9363d(m4687e3, m4687e2, m4687e3);
        vw0.m9369j(m4687e3, 19, m4687e2);
        vw0.m9363d(m4687e2, m4687e4, m4687e2);
        int[] m4687e5 = i01.m4687e();
        vw0.m9369j(m4687e2, 42, m4687e5);
        vw0.m9363d(m4687e5, m4687e2, m4687e5);
        vw0.m9369j(m4687e5, 23, m4687e2);
        vw0.m9363d(m4687e2, m4687e3, m4687e2);
        vw0.m9369j(m4687e2, 84, m4687e3);
        vw0.m9363d(m4687e3, m4687e5, m4687e3);
        vw0.m9369j(m4687e3, 20, m4687e3);
        vw0.m9363d(m4687e3, m4687e4, m4687e3);
        vw0.m9369j(m4687e3, 3, m4687e3);
        vw0.m9363d(m4687e3, iArr, m4687e3);
        vw0.m9369j(m4687e3, 2, m4687e3);
        vw0.m9363d(m4687e3, iArr, m4687e3);
        vw0.m9369j(m4687e3, 4, m4687e3);
        vw0.m9363d(m4687e3, m4687e, m4687e3);
        vw0.m9368i(m4687e3, m4687e3);
        vw0.m9368i(m4687e3, m4687e5);
        if (i01.m4689g(iArr, m4687e5)) {
            return new ww0(m4687e3);
        }
        vw0.m9363d(m4687e3, f7804g, m4687e3);
        vw0.m9368i(m4687e3, m4687e5);
        if (i01.m4689g(iArr, m4687e5)) {
            return new ww0(m4687e3);
        }
        return null;
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m4687e = i01.m4687e();
        vw0.m9368i(this.f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        vw0.m9370k(this.f7805e, ((ww0) hv0Var).f7805e, m4687e);
        return new ww0(m4687e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return i01.m4691i(this.f7805e, 0) == 1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return i01.m4703u(this.f7805e);
    }
}
