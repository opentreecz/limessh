package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class wv0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f7800f = new BigInteger(1, o51.m6872a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFF"));

    /* renamed from: e */
    public int[] f7801e;

    public wv0() {
        this.f7801e = j01.m5015i();
    }

    public wv0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f7800f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SM2P256V1FieldElement");
        }
        this.f7801e = vv0.m9349d(bigInteger);
    }

    public wv0(int[] iArr) {
        this.f7801e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        vv0.m9346a(this.f7801e, ((wv0) hv0Var).f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m5015i = j01.m5015i();
        vv0.m9347b(this.f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        e01.m3375d(vv0.f7559a, ((wv0) hv0Var).f7801e, m5015i);
        vv0.m9350e(m5015i, this.f7801e, m5015i);
        return new wv0(m5015i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof wv0) {
            return j01.m5020n(this.f7801e, ((wv0) obj).f7801e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f7800f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m5015i = j01.m5015i();
        e01.m3375d(vv0.f7559a, this.f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5026t(this.f7801e);
    }

    public int hashCode() {
        return f7800f.hashCode() ^ e51.m3449r(this.f7801e, 0, 8);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5028v(this.f7801e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        vv0.m9350e(this.f7801e, ((wv0) hv0Var).f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m5015i = j01.m5015i();
        vv0.m9352g(this.f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f7801e;
        if (j01.m5028v(iArr) || j01.m5026t(iArr)) {
            return this;
        }
        int[] m5015i = j01.m5015i();
        vv0.m9355j(iArr, m5015i);
        vv0.m9350e(m5015i, iArr, m5015i);
        int[] m5015i2 = j01.m5015i();
        vv0.m9356k(m5015i, 2, m5015i2);
        vv0.m9350e(m5015i2, m5015i, m5015i2);
        int[] m5015i3 = j01.m5015i();
        vv0.m9356k(m5015i2, 2, m5015i3);
        vv0.m9350e(m5015i3, m5015i, m5015i3);
        vv0.m9356k(m5015i3, 6, m5015i);
        vv0.m9350e(m5015i, m5015i3, m5015i);
        int[] m5015i4 = j01.m5015i();
        vv0.m9356k(m5015i, 12, m5015i4);
        vv0.m9350e(m5015i4, m5015i, m5015i4);
        vv0.m9356k(m5015i4, 6, m5015i);
        vv0.m9350e(m5015i, m5015i3, m5015i);
        vv0.m9355j(m5015i, m5015i3);
        vv0.m9350e(m5015i3, iArr, m5015i3);
        vv0.m9356k(m5015i3, 31, m5015i4);
        vv0.m9350e(m5015i4, m5015i3, m5015i);
        vv0.m9356k(m5015i4, 32, m5015i4);
        vv0.m9350e(m5015i4, m5015i, m5015i4);
        vv0.m9356k(m5015i4, 62, m5015i4);
        vv0.m9350e(m5015i4, m5015i, m5015i4);
        vv0.m9356k(m5015i4, 4, m5015i4);
        vv0.m9350e(m5015i4, m5015i2, m5015i4);
        vv0.m9356k(m5015i4, 32, m5015i4);
        vv0.m9350e(m5015i4, iArr, m5015i4);
        vv0.m9356k(m5015i4, 62, m5015i4);
        vv0.m9355j(m5015i4, m5015i2);
        if (j01.m5020n(iArr, m5015i2)) {
            return new wv0(m5015i4);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m5015i = j01.m5015i();
        vv0.m9355j(this.f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m5015i = j01.m5015i();
        vv0.m9358m(this.f7801e, ((wv0) hv0Var).f7801e, m5015i);
        return new wv0(m5015i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return j01.m5023q(this.f7801e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5004J(this.f7801e);
    }
}
