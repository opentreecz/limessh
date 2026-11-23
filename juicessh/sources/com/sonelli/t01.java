package com.sonelli;

/* loaded from: classes.dex */
public class t01 extends zp0 {

    /* renamed from: O */
    public final int f6677O;

    /* renamed from: P */
    public final int f6678P;

    /* renamed from: Q */
    public final t41 f6679Q;

    public t01(int i, int i2, t41 t41Var) {
        this.f6677O = i;
        this.f6678P = i2;
        this.f6679Q = new t41(t41Var);
    }

    public t01(fq0 fq0Var) {
        this.f6677O = ((xp0) fq0Var.mo3870u(0)).m9868B();
        this.f6678P = ((xp0) fq0Var.mo3870u(1)).m9868B();
        this.f6679Q = new t41(((bq0) fq0Var.mo3870u(2)).m2598v());
    }

    /* renamed from: m */
    public static t01 m8563m(Object obj) {
        if (obj instanceof t01) {
            return (t01) obj;
        }
        if (obj != null) {
            return new t01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(this.f6677O));
        rp0Var.m8224a(new xp0(this.f6678P));
        rp0Var.m8224a(new gr0(this.f6679Q.m8594c()));
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public t41 m8564k() {
        return new t41(this.f6679Q);
    }

    /* renamed from: n */
    public int m8565n() {
        return this.f6677O;
    }

    /* renamed from: o */
    public int m8566o() {
        return this.f6678P;
    }
}
