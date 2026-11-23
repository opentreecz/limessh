package cz.opentree;

import cz.opentree.hv0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class fy0 extends hv0.AbstractC1129a {

    /* renamed from: e */
    public long[] f2781e;

    public fy0() {
        this.f2781e = h01.m4316i();
    }

    public fy0(BigInteger bigInteger) {
        if (bigInteger == null || bigInteger.signum() < 0 || bigInteger.bitLength() > 163) {
            throw new IllegalArgumentException("x value invalid for SecT163FieldElement");
        }
        this.f2781e = ey0.m3570e(bigInteger);
    }

    public fy0(long[] jArr) {
        this.f2781e = jArr;
    }

    @Override // cz.opentree.hv0
    /* renamed from: a */
    public hv0 mo2277a(hv0 hv0Var) {
        long[] m4316i = h01.m4316i();
        ey0.m3566a(this.f2781e, ((fy0) hv0Var).f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: b */
    public hv0 mo2278b() {
        long[] m4316i = h01.m4316i();
        ey0.m3568c(this.f2781e, m4316i);
        return new fy0(m4316i);
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
        if (obj instanceof fy0) {
            return h01.m4321n(this.f2781e, ((fy0) obj).f2781e);
        }
        return false;
    }

    @Override // cz.opentree.hv0
    /* renamed from: f */
    public int mo2280f() {
        return KeycodeConstants.KEYCODE_NUMPAD_RIGHT_PAREN;
    }

    @Override // cz.opentree.hv0
    /* renamed from: g */
    public hv0 mo2281g() {
        long[] m4316i = h01.m4316i();
        ey0.m3576k(this.f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: h */
    public boolean mo2282h() {
        return h01.m4327t(this.f2781e);
    }

    public int hashCode() {
        return e51.m3450s(this.f2781e, 0, 3) ^ 163763;
    }

    @Override // cz.opentree.hv0
    /* renamed from: i */
    public boolean mo2283i() {
        return h01.m4329v(this.f2781e);
    }

    @Override // cz.opentree.hv0
    /* renamed from: j */
    public hv0 mo2284j(hv0 hv0Var) {
        long[] m4316i = h01.m4316i();
        ey0.m3577l(this.f2781e, ((fy0) hv0Var).f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: k */
    public hv0 mo3338k(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        return mo3339l(hv0Var, hv0Var2, hv0Var3);
    }

    @Override // cz.opentree.hv0
    /* renamed from: l */
    public hv0 mo3339l(hv0 hv0Var, hv0 hv0Var2, hv0 hv0Var3) {
        long[] jArr = this.f2781e;
        long[] jArr2 = ((fy0) hv0Var).f2781e;
        long[] jArr3 = ((fy0) hv0Var2).f2781e;
        long[] jArr4 = ((fy0) hv0Var3).f2781e;
        long[] m4318k = h01.m4318k();
        ey0.m3578m(jArr, jArr2, m4318k);
        ey0.m3578m(jArr3, jArr4, m4318k);
        long[] m4316i = h01.m4316i();
        ey0.m3579n(m4318k, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: m */
    public hv0 mo2285m() {
        return this;
    }

    @Override // cz.opentree.hv0
    /* renamed from: n */
    public hv0 mo2286n() {
        long[] m4316i = h01.m4316i();
        ey0.m3580o(this.f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: o */
    public hv0 mo2287o() {
        long[] m4316i = h01.m4316i();
        ey0.m3581p(this.f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: p */
    public hv0 mo3340p(hv0 hv0Var, hv0 hv0Var2) {
        long[] jArr = this.f2781e;
        long[] jArr2 = ((fy0) hv0Var).f2781e;
        long[] jArr3 = ((fy0) hv0Var2).f2781e;
        long[] m4318k = h01.m4318k();
        ey0.m3582q(jArr, m4318k);
        ey0.m3578m(jArr2, jArr3, m4318k);
        long[] m4316i = h01.m4316i();
        ey0.m3579n(m4318k, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: q */
    public hv0 mo3341q(int i) {
        if (i < 1) {
            return this;
        }
        long[] m4316i = h01.m4316i();
        ey0.m3583r(this.f2781e, i, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0
    /* renamed from: r */
    public hv0 mo2288r(hv0 hv0Var) {
        return mo2277a(hv0Var);
    }

    @Override // cz.opentree.hv0
    /* renamed from: s */
    public boolean mo2289s() {
        return (this.f2781e[0] & 1) != 0;
    }

    @Override // cz.opentree.hv0
    /* renamed from: t */
    public BigInteger mo2290t() {
        return h01.m4306I(this.f2781e);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: u */
    public hv0 mo3342u() {
        long[] m4316i = h01.m4316i();
        ey0.m3571f(this.f2781e, m4316i);
        return new fy0(m4316i);
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: v */
    public boolean mo3343v() {
        return true;
    }

    @Override // cz.opentree.hv0.AbstractC1129a
    /* renamed from: w */
    public int mo3344w() {
        return ey0.m3584s(this.f2781e);
    }
}
