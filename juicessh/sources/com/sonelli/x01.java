package com.sonelli;

/* loaded from: classes.dex */
public class x01 extends zp0 {

    /* renamed from: O */
    public final xp0 f7837O;

    /* renamed from: P */
    public final int f7838P;

    /* renamed from: Q */
    public final vs0 f7839Q;

    public x01(int i, vs0 vs0Var) {
        this.f7837O = new xp0(0L);
        this.f7838P = i;
        this.f7839Q = vs0Var;
    }

    public x01(fq0 fq0Var) {
        this.f7837O = xp0.m9866t(fq0Var.mo3870u(0));
        this.f7838P = xp0.m9866t(fq0Var.mo3870u(1)).m9868B();
        this.f7839Q = vs0.m9342m(fq0Var.mo3870u(2));
    }

    /* renamed from: m */
    public static x01 m9662m(Object obj) {
        if (obj instanceof x01) {
            return (x01) obj;
        }
        if (obj != null) {
            return new x01(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(this.f7837O);
        rp0Var.m8224a(new xp0(this.f7838P));
        rp0Var.m8224a(this.f7839Q);
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public int m9663k() {
        return this.f7838P;
    }

    /* renamed from: n */
    public vs0 m9664n() {
        return this.f7839Q;
    }
}
