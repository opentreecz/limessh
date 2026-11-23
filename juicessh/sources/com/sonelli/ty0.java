package com.sonelli;

import com.sonelli.hv0;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ty0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f6867e;

    public ty0() {
        this.f6867e = j01.m5016j();
    }

    public ty0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 233) {
            throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
        }
        this.f6867e = sy0.m8536e(bigInteger);
    }

    public ty0(long[] jArr) {
        this.f6867e = jArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m5016j = j01.m5016j();
        sy0.m8532a(this.f6867e, ((ty0) hv0Var).f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m5016j = j01.m5016j();
        sy0.m8534c(this.f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: d */
    public hv0 mo2279d(hv0 hv0Var) {
        return mo2284j(hv0Var.mo2281g());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ty0) {
            return j01.m5021o(this.f6867e, ((ty0) obj).f6867e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return 233;
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m5016j = j01.m5016j();
        sy0.m8543l(this.f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return j01.m5027u(this.f6867e);
    }

    public int hashCode() {
        return e51.m3450s(this.f6867e, 0, 4) ^ 2330074;
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return j01.m5029w(this.f6867e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m5016j = j01.m5016j();
        sy0.m8544m(this.f6867e, ((ty0) hv0Var).f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // com.sonelli.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f6867e;
        long[] jArr2 = ((ty0) hv0Var).f6867e;
        long[] jArr3 = ((ty0) hv0Var2).f6867e;
        long[] jArr4 = ((ty0) hv0Var3).f6867e;
        long[] m5018l = j01.m5018l();
        sy0.m8545n(jArr, jArr2, m5018l);
        sy0.m8545n(jArr3, jArr4, m5018l);
        long[] m5016j = j01.m5016j();
        sy0.m8546o(m5018l, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m5016j = j01.m5016j();
        sy0.m8547p(this.f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m5016j = j01.m5016j();
        sy0.m8548q(this.f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f6867e;
        long[] jArr2 = ((ty0) hv0Var).f6867e;
        long[] jArr3 = ((ty0) hv0Var2).f6867e;
        long[] m5018l = j01.m5018l();
        sy0.m8549r(jArr, m5018l);
        sy0.m8545n(jArr2, jArr3, m5018l);
        long[] m5016j = j01.m5016j();
        sy0.m8546o(m5018l, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m5016j = j01.m5016j();
        sy0.m8550s(this.f6867e, i, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f6867e[0] & 1) != 0;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return j01.m5005K(this.f6867e);
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m5016j = j01.m5016j();
        sy0.m8537f(this.f6867e, m5016j);
        return new ty0(m5016j);
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return sy0.m8551t(this.f6867e);
    }
}
