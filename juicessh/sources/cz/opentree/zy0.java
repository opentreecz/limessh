package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class zy0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f8609e;

    public zy0() {
        this.f8609e = j01.m5016j();
    }

    public zy0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 239) {
            throw new IllegalArgumentException("x value invalid for SecT239FieldElement");
        }
        this.f8609e = yy0.m10259e(bigInteger);
    }

    public zy0(long[] jArr) {
        this.f8609e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m5016j = j01.m5016j();
        yy0.m10255a(this.f8609e, ((zy0) hv0Var).f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m5016j = j01.m5016j();
        yy0.m10257c(this.f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        return mo2284j(hv0Var.mo2281g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zy0) {
            return j01.m5021o(this.f8609e, ((zy0) obj).f8609e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 239;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m5016j = j01.m5016j();
        yy0.m10266l(this.f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5027u(this.f8609e);
    }

    public int hashCode() {
        return e51.m3450s(this.f8609e, 0, 4) ^ 23900158;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5029w(this.f8609e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m5016j = j01.m5016j();
        yy0.m10267m(this.f8609e, ((zy0) hv0Var).f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f8609e;
        long[] jArr2 = ((zy0) hv0Var).f8609e;
        long[] jArr3 = ((zy0) hv0Var2).f8609e;
        long[] jArr4 = ((zy0) hv0Var3).f8609e;
        long[] m5018l = j01.m5018l();
        yy0.m10268n(jArr, jArr2, m5018l);
        yy0.m10268n(jArr3, jArr4, m5018l);
        long[] m5016j = j01.m5016j();
        yy0.m10269o(m5018l, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m5016j = j01.m5016j();
        yy0.m10270p(this.f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m5016j = j01.m5016j();
        yy0.m10271q(this.f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f8609e;
        long[] jArr2 = ((zy0) hv0Var).f8609e;
        long[] jArr3 = ((zy0) hv0Var2).f8609e;
        long[] m5018l = j01.m5018l();
        yy0.m10272r(jArr, m5018l);
        yy0.m10268n(jArr2, jArr3, m5018l);
        long[] m5016j = j01.m5016j();
        yy0.m10269o(m5018l, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m5016j = j01.m5016j();
        yy0.m10273s(this.f8609e, i, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f8609e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5005K(this.f8609e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m5016j = j01.m5016j();
        yy0.m10260f(this.f8609e, m5016j);
        return new zy0(m5016j);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return yy0.m10274t(this.f8609e);
    }
}
