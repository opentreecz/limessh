package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ow0 extends hv0.AbstractC1130b {

    /* renamed from: f */
    public static final BigInteger f5565f = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFEE37"));

    /* renamed from: e */
    public int[] f5566e;

    public ow0() {
        this.f5566e = h01.m4315h();
    }

    public ow0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.compareTo(f5565f) >= 0) {
            throw new IllegalArgumentException("x value invalid for SecP192K1FieldElement");
        }
        this.f5566e = nw0.m6807c(bigInteger);
    }

    public ow0(int[] iArr) {
        this.f5566e = iArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        nw0.m6805a(this.f5566e, ((ow0) hv0Var).f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        int[] m4315h = h01.m4315h();
        nw0.m6806b(this.f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        e01.m3375d(nw0.f5386a, ((ow0) hv0Var).f5566e, m4315h);
        nw0.m6808d(m4315h, this.f5566e, m4315h);
        return new ow0(m4315h);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ow0) {
            return h01.m4320m(this.f5566e, ((ow0) obj).f5566e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return f5565f.bitLength();
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        int[] m4315h = h01.m4315h();
        e01.m3375d(nw0.f5386a, this.f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return h01.m4326s(this.f5566e);
    }

    public int hashCode() {
        return f5565f.hashCode() ^ e51.m3449r(this.f5566e, 0, 6);
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return h01.m4328u(this.f5566e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        nw0.m6808d(this.f5566e, ((ow0) hv0Var).f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        int[] m4315h = h01.m4315h();
        nw0.m6810f(this.f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        int[] iArr = this.f5566e;
        if (h01.m4328u(iArr) || h01.m4326s(iArr)) {
            return this;
        }
        int[] m4315h = h01.m4315h();
        nw0.m6813i(iArr, m4315h);
        nw0.m6808d(m4315h, iArr, m4315h);
        int[] m4315h2 = h01.m4315h();
        nw0.m6813i(m4315h, m4315h2);
        nw0.m6808d(m4315h2, iArr, m4315h2);
        int[] m4315h3 = h01.m4315h();
        nw0.m6814j(m4315h2, 3, m4315h3);
        nw0.m6808d(m4315h3, m4315h2, m4315h3);
        nw0.m6814j(m4315h3, 2, m4315h3);
        nw0.m6808d(m4315h3, m4315h, m4315h3);
        nw0.m6814j(m4315h3, 8, m4315h);
        nw0.m6808d(m4315h, m4315h3, m4315h);
        nw0.m6814j(m4315h, 3, m4315h3);
        nw0.m6808d(m4315h3, m4315h2, m4315h3);
        int[] m4315h4 = h01.m4315h();
        nw0.m6814j(m4315h3, 16, m4315h4);
        nw0.m6808d(m4315h4, m4315h, m4315h4);
        nw0.m6814j(m4315h4, 35, m4315h);
        nw0.m6808d(m4315h, m4315h4, m4315h);
        nw0.m6814j(m4315h, 70, m4315h4);
        nw0.m6808d(m4315h4, m4315h, m4315h4);
        nw0.m6814j(m4315h4, 19, m4315h);
        nw0.m6808d(m4315h, m4315h3, m4315h);
        nw0.m6814j(m4315h, 20, m4315h);
        nw0.m6808d(m4315h, m4315h3, m4315h);
        nw0.m6814j(m4315h, 4, m4315h);
        nw0.m6808d(m4315h, m4315h2, m4315h);
        nw0.m6814j(m4315h, 6, m4315h);
        nw0.m6808d(m4315h, m4315h2, m4315h);
        nw0.m6813i(m4315h, m4315h);
        nw0.m6813i(m4315h, m4315h2);
        if (h01.m4320m(iArr, m4315h2)) {
            return new ow0(m4315h);
        }
        return null;
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        int[] m4315h = h01.m4315h();
        nw0.m6813i(this.f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        int[] m4315h = h01.m4315h();
        nw0.m6815k(this.f5566e, ((ow0) hv0Var).f5566e, m4315h);
        return new ow0(m4315h);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return h01.m4323p(this.f5566e, 0) == 1;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return h01.m4305H(this.f5566e);
    }
}
