package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class qx0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f6123f = new BigInteger(1, o51.m6872a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));

    /* renamed from: e */
    public int[] f6124e;

    public qx0() {
        this.f6124e = p01.m7200k(17);
    }

    public qx0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f6123f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
        }
        this.f6124e = px0.m7559c(bigInteger);
    }

    public qx0(int[] iArr) {
        this.f6124e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(17);
        px0.m7557a(this.f6124e, ((qx0) hv0Var).f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m7200k = p01.m7200k(17);
        px0.m7558b(this.f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(17);
        e01.m3375d(px0.f5883a, ((qx0) hv0Var).f6124e, m7200k);
        px0.m7562f(m7200k, this.f6124e, m7200k);
        return new qx0(m7200k);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qx0) {
            return p01.m7204o(17, this.f6124e, ((qx0) obj).f6124e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f6123f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m7200k = p01.m7200k(17);
        e01.m3375d(px0.f5883a, this.f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return p01.m7213x(17, this.f6124e);
    }

    public int hashCode() {
        return f6123f.hashCode() ^ e51.m3449r(this.f6124e, 0, 17);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return p01.m7214y(17, this.f6124e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(17);
        px0.m7562f(this.f6124e, ((qx0) hv0Var).f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m7200k = p01.m7200k(17);
        px0.m7563g(this.f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f6124e;
        if (p01.m7214y(17, iArr) || p01.m7213x(17, iArr)) {
            return this;
        }
        int[] m7200k = p01.m7200k(17);
        int[] m7200k2 = p01.m7200k(17);
        px0.m7567k(iArr, 519, m7200k);
        px0.m7566j(m7200k, m7200k2);
        if (p01.m7204o(17, iArr, m7200k2)) {
            return new qx0(m7200k);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m7200k = p01.m7200k(17);
        px0.m7566j(this.f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m7200k = p01.m7200k(17);
        px0.m7568l(this.f6124e, ((qx0) hv0Var).f6124e, m7200k);
        return new qx0(m7200k);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return p01.m7207r(this.f6124e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return p01.m7187R(17, this.f6124e);
    }
}
