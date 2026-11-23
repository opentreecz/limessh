package com.sonelli;

/* loaded from: classes.dex */
public class r01 extends zp0 {

    /* renamed from: O */
    public final int f6150O;

    /* renamed from: P */
    public final int f6151P;

    /* renamed from: Q */
    public final t41 f6152Q;

    /* renamed from: R */
    public final vs0 f6153R;

    public r01(int i, int i2, t41 t41Var, vs0 vs0Var) {
        this.f6150O = i;
        this.f6151P = i2;
        this.f6152Q = new t41(t41Var.m8594c());
        this.f6153R = vs0Var;
    }

    public r01(fq0 fq0Var) {
        this.f6150O = ((xp0) fq0Var.mo3870u(0)).m9868B();
        this.f6151P = ((xp0) fq0Var.mo3870u(1)).m9868B();
        this.f6152Q = new t41(((bq0) fq0Var.mo3870u(2)).m2598v());
        this.f6153R = vs0.m9342m(fq0Var.mo3870u(3));
    }

    /* renamed from: n */
    public static r01 m7841n(Object obj) {
        if (obj instanceof r01) {
            return (r01) obj;
        }
        if (obj != null) {
            return new r01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(this.f6150O));
        rp0Var.m8224a(new xp0(this.f6151P));
        rp0Var.m8224a(new gr0(this.f6152Q.m8594c()));
        rp0Var.m8224a(this.f6153R);
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public vs0 m7842k() {
        return this.f6153R;
    }

    /* renamed from: m */
    public t41 m7843m() {
        return this.f6152Q;
    }

    /* renamed from: o */
    public int m7844o() {
        return this.f6150O;
    }

    /* renamed from: p */
    public int m7845p() {
        return this.f6151P;
    }
}
