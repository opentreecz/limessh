package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class aw0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f1534f = new BigInteger(1, o51.m6872a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: e */
    public int[] f1535e;

    public aw0() {
        this.f1535e = f01.m3630f();
    }

    public aw0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f1534f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
        }
        this.f1535e = zv0.m10636d(bigInteger);
    }

    public aw0(int[] iArr) {
        this.f1535e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m3630f = f01.m3630f();
        zv0.m10633a(this.f1535e, ((aw0) hv0Var).f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m3630f = f01.m3630f();
        zv0.m10634b(this.f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m3630f = f01.m3630f();
        e01.m3375d(zv0.f8598a, ((aw0) hv0Var).f1535e, m3630f);
        zv0.m10637e(m3630f, this.f1535e, m3630f);
        return new aw0(m3630f);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof aw0) {
            return f01.m3634j(this.f1535e, ((aw0) obj).f1535e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f1534f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m3630f = f01.m3630f();
        e01.m3375d(zv0.f8598a, this.f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return f01.m3639o(this.f1535e);
    }

    public int hashCode() {
        return f1534f.hashCode() ^ e51.m3449r(this.f1535e, 0, 4);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return f01.m3641q(this.f1535e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m3630f = f01.m3630f();
        zv0.m10637e(this.f1535e, ((aw0) hv0Var).f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m3630f = f01.m3630f();
        zv0.m10639g(this.f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f1535e;
        if (f01.m3641q(iArr) || f01.m3639o(iArr)) {
            return this;
        }
        int[] m3630f = f01.m3630f();
        zv0.m10642j(iArr, m3630f);
        zv0.m10637e(m3630f, iArr, m3630f);
        int[] m3630f2 = f01.m3630f();
        zv0.m10643k(m3630f, 2, m3630f2);
        zv0.m10637e(m3630f2, m3630f, m3630f2);
        int[] m3630f3 = f01.m3630f();
        zv0.m10643k(m3630f2, 4, m3630f3);
        zv0.m10637e(m3630f3, m3630f2, m3630f3);
        zv0.m10643k(m3630f3, 2, m3630f2);
        zv0.m10637e(m3630f2, m3630f, m3630f2);
        zv0.m10643k(m3630f2, 10, m3630f);
        zv0.m10637e(m3630f, m3630f2, m3630f);
        zv0.m10643k(m3630f, 10, m3630f3);
        zv0.m10637e(m3630f3, m3630f2, m3630f3);
        zv0.m10642j(m3630f3, m3630f2);
        zv0.m10637e(m3630f2, iArr, m3630f2);
        zv0.m10643k(m3630f2, 95, m3630f2);
        zv0.m10642j(m3630f2, m3630f3);
        if (f01.m3634j(iArr, m3630f3)) {
            return new aw0(m3630f2);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m3630f = f01.m3630f();
        zv0.m10642j(this.f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m3630f = f01.m3630f();
        zv0.m10645m(this.f1535e, ((aw0) hv0Var).f1535e, m3630f);
        return new aw0(m3630f);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return f01.m3637m(this.f1535e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return f01.m3648x(this.f1535e);
    }
}
