package cz.opentree;

import cz.opentree.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class pz0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f5898e;

    public pz0() {
        this.f5898e = o01.m6827c();
    }

    public pz0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 571) {
            throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
        }
        this.f5898e = oz0.m7143h(bigInteger);
    }

    public pz0(long[] jArr) {
        this.f5898e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m6827c = o01.m6827c();
        oz0.m7137b(this.f5898e, ((pz0) hv0Var).f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m6827c = o01.m6827c();
        oz0.m7141f(this.f5898e, m6827c);
        return new pz0(m6827c);
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
        if (obj instanceof pz0) {
            return o01.m6829e(this.f5898e, ((pz0) obj).f5898e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 571;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m6827c = o01.m6827c();
        oz0.m7148m(this.f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return o01.m6830f(this.f5898e);
    }

    public int hashCode() {
        return e51.m3450s(this.f5898e, 0, 9) ^ 5711052;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return o01.m6831g(this.f5898e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m6827c = o01.m6827c();
        oz0.m7149n(this.f5898e, ((pz0) hv0Var).f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f5898e;
        long[] jArr2 = ((pz0) hv0Var).f5898e;
        long[] jArr3 = ((pz0) hv0Var2).f5898e;
        long[] jArr4 = ((pz0) hv0Var3).f5898e;
        long[] m6828d = o01.m6828d();
        oz0.m7150o(jArr, jArr2, m6828d);
        oz0.m7150o(jArr3, jArr4, m6828d);
        long[] m6827c = o01.m6827c();
        oz0.m7154s(m6828d, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m6827c = o01.m6827c();
        oz0.m7156u(this.f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m6827c = o01.m6827c();
        oz0.m7157v(this.f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f5898e;
        long[] jArr2 = ((pz0) hv0Var).f5898e;
        long[] jArr3 = ((pz0) hv0Var2).f5898e;
        long[] m6828d = o01.m6828d();
        oz0.m7158w(jArr, m6828d);
        oz0.m7150o(jArr2, jArr3, m6828d);
        long[] m6827c = o01.m6827c();
        oz0.m7154s(m6828d, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m6827c = o01.m6827c();
        oz0.m7159x(this.f5898e, i, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f5898e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return o01.m6832h(this.f5898e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m6827c = o01.m6827c();
        oz0.m7144i(this.f5898e, m6827c);
        return new pz0(m6827c);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return oz0.m7160y(this.f5898e);
    }
}
