package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ax0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f1537f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF000000000000000000000001"));

    /* renamed from: e */
    public int[] f1538e;

    public ax0() {
        this.f1538e = i01.m4687e();
    }

    public ax0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f1537f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
        }
        this.f1538e = zw0.m10650d(bigInteger);
    }

    public ax0(int[] iArr) {
        this.f1538e = iArr;
    }

    /* renamed from: u */
    public static void m2291u(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, int[] iArr7) {
        zw0.m10651e(iArr5, iArr3, iArr7);
        zw0.m10651e(iArr7, iArr, iArr7);
        zw0.m10651e(iArr4, iArr2, iArr6);
        zw0.m10647a(iArr6, iArr7, iArr6);
        zw0.m10651e(iArr4, iArr3, iArr7);
        i01.m4686d(iArr6, iArr4);
        zw0.m10651e(iArr5, iArr2, iArr5);
        zw0.m10647a(iArr5, iArr7, iArr5);
        zw0.m10656j(iArr5, iArr6);
        zw0.m10651e(iArr6, iArr, iArr6);
    }

    /* renamed from: v */
    public static void m2292v(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        i01.m4686d(iArr, iArr4);
        int[] m4687e = i01.m4687e();
        int[] m4687e2 = i01.m4687e();
        for (int i = 0; i < 7; i++) {
            i01.m4686d(iArr2, m4687e);
            i01.m4686d(iArr3, m4687e2);
            int i2 = 1 << i;
            while (true) {
                i2--;
                if (i2 >= 0) {
                    m2293w(iArr2, iArr3, iArr4, iArr5);
                }
            }
            m2291u(iArr, m4687e, m4687e2, iArr2, iArr3, iArr4, iArr5);
        }
    }

    /* renamed from: w */
    public static void m2293w(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4) {
        zw0.m10651e(iArr2, iArr, iArr2);
        zw0.m10660n(iArr2, iArr2);
        zw0.m10656j(iArr, iArr4);
        zw0.m10647a(iArr3, iArr4, iArr);
        zw0.m10651e(iArr3, iArr4, iArr3);
        zw0.m10655i(p01.m7178I(7, iArr3, 2, 0), iArr3);
    }

    /* renamed from: x */
    public static boolean m2294x(int[] iArr) {
        int[] m4687e = i01.m4687e();
        int[] m4687e2 = i01.m4687e();
        i01.m4686d(iArr, m4687e);
        for (int i = 0; i < 7; i++) {
            i01.m4686d(m4687e, m4687e2);
            zw0.m10657k(m4687e, 1 << i, m4687e);
            zw0.m10651e(m4687e, m4687e2, m4687e);
        }
        zw0.m10657k(m4687e, 95, m4687e);
        return i01.m4693k(m4687e);
    }

    /* renamed from: y */
    public static boolean m2295y(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m4687e = i01.m4687e();
        i01.m4686d(iArr2, m4687e);
        int[] m4687e2 = i01.m4687e();
        m4687e2[0] = 1;
        int[] m4687e3 = i01.m4687e();
        m2292v(iArr, m4687e, m4687e2, m4687e3, iArr3);
        int[] m4687e4 = i01.m4687e();
        int[] m4687e5 = i01.m4687e();
        for (int i = 1; i < 96; i++) {
            i01.m4686d(m4687e, m4687e4);
            i01.m4686d(m4687e2, m4687e5);
            m2293w(m4687e, m4687e2, m4687e3, iArr3);
            if (i01.m4694l(m4687e)) {
                e01.m3375d(zw0.f8604a, m4687e5, iArr3);
                zw0.m10651e(iArr3, m4687e4, iArr3);
                return true;
            }
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        zw0.m10647a(this.f1538e, ((ax0) hv0Var).f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m4687e = i01.m4687e();
        zw0.m10648b(this.f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        e01.m3375d(zw0.f8604a, ((ax0) hv0Var).f1538e, m4687e);
        zw0.m10651e(m4687e, this.f1538e, m4687e);
        return new ax0(m4687e);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ax0) {
            return i01.m4689g(this.f1538e, ((ax0) obj).f1538e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f1537f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m4687e = i01.m4687e();
        e01.m3375d(zw0.f8604a, this.f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return i01.m4693k(this.f1538e);
    }

    public int hashCode() {
        return f1537f.hashCode() ^ e51.m3449r(this.f1538e, 0, 7);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return i01.m4694l(this.f1538e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        zw0.m10651e(this.f1538e, ((ax0) hv0Var).f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m4687e = i01.m4687e();
        zw0.m10653g(this.f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f1538e;
        if (i01.m4694l(iArr) || i01.m4693k(iArr)) {
            return this;
        }
        int[] m4687e = i01.m4687e();
        zw0.m10653g(iArr, m4687e);
        int[] m3376e = e01.m3376e(zw0.f8604a);
        int[] m4687e2 = i01.m4687e();
        if (!m2294x(iArr)) {
            return null;
        }
        while (!m2295y(m4687e, m3376e, m4687e2)) {
            zw0.m10648b(m3376e, m3376e);
        }
        zw0.m10656j(m4687e2, m3376e);
        if (i01.m4689g(iArr, m3376e)) {
            return new ax0(m4687e2);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m4687e = i01.m4687e();
        zw0.m10656j(this.f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m4687e = i01.m4687e();
        zw0.m10659m(this.f1538e, ((ax0) hv0Var).f1538e, m4687e);
        return new ax0(m4687e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return i01.m4691i(this.f1538e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return i01.m4703u(this.f1538e);
    }
}
