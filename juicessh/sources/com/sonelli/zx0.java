package com.sonelli;

import com.sonelli.hv0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class zx0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f8608e;

    public zx0() {
        this.f8608e = h01.m4316i();
    }

    public zx0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 131) {
            throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
        }
        this.f8608e = yx0.m10240e(bigInteger);
    }

    public zx0(long[] jArr) {
        this.f8608e = jArr;
    }

    @Override // com.sonelli.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m4316i = h01.m4316i();
        yx0.m10236a(this.f8608e, ((zx0) hv0Var).f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m4316i = h01.m4316i();
        yx0.m10238c(this.f8608e, m4316i);
        return new zx0(m4316i);
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
        if (obj instanceof zx0) {
            return h01.m4321n(this.f8608e, ((zx0) obj).f8608e);
        }
        return false;
    }

    @Override // com.sonelli.hv0
    /* renamed from: f */
    public int mo2280f() {
        return KeycodeConstants.KEYCODE_F1;
    }

    @Override // com.sonelli.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m4316i = h01.m4316i();
        yx0.m10246k(this.f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return h01.m4327t(this.f8608e);
    }

    public int hashCode() {
        return e51.m3450s(this.f8608e, 0, 3) ^ 131832;
    }

    @Override // com.sonelli.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return h01.m4329v(this.f8608e);
    }

    @Override // com.sonelli.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m4316i = h01.m4316i();
        yx0.m10247l(this.f8608e, ((zx0) hv0Var).f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // com.sonelli.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f8608e;
        long[] jArr2 = ((zx0) hv0Var).f8608e;
        long[] jArr3 = ((zx0) hv0Var2).f8608e;
        long[] jArr4 = ((zx0) hv0Var3).f8608e;
        long[] m7201l = p01.m7201l(5);
        yx0.m10248m(jArr, jArr2, m7201l);
        yx0.m10248m(jArr3, jArr4, m7201l);
        long[] m4316i = h01.m4316i();
        yx0.m10249n(m7201l, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // com.sonelli.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m4316i = h01.m4316i();
        yx0.m10250o(this.f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m4316i = h01.m4316i();
        yx0.m10251p(this.f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f8608e;
        long[] jArr2 = ((zx0) hv0Var).f8608e;
        long[] jArr3 = ((zx0) hv0Var2).f8608e;
        long[] m7201l = p01.m7201l(5);
        yx0.m10252q(jArr, m7201l);
        yx0.m10248m(jArr2, jArr3, m7201l);
        long[] m4316i = h01.m4316i();
        yx0.m10249n(m7201l, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m4316i = h01.m4316i();
        yx0.m10253r(this.f8608e, i, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // com.sonelli.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f8608e[0] & 1) != 0;
    }

    @Override // com.sonelli.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return h01.m4306I(this.f8608e);
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m4316i = h01.m4316i();
        yx0.m10241f(this.f8608e, m4316i);
        return new zx0(m4316i);
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // com.sonelli.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return yx0.m10254s(this.f8608e);
    }
}
