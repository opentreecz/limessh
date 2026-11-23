package com.sonelli;

import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class vs0 extends zp0 {

    /* renamed from: O */
    public aq0 f7553O;

    /* renamed from: P */
    public ASN1Encodable f7554P;

    public vs0(aq0 aq0Var) {
        this.f7553O = aq0Var;
    }

    public vs0(aq0 aq0Var, ASN1Encodable aSN1Encodable) {
        this.f7553O = aq0Var;
        this.f7554P = aSN1Encodable;
    }

    public vs0(fq0 fq0Var) {
        if (fq0Var.size() >= 1 && fq0Var.size() <= 2) {
            this.f7553O = aq0.m2251A(fq0Var.mo3870u(0));
            this.f7554P = fq0Var.size() == 2 ? fq0Var.mo3870u(1) : null;
        } else {
            throw new IllegalArgumentException("Bad sequence size: " + fq0Var.size());
        }
    }

    /* renamed from: m */
    public static vs0 m9342m(Object obj) {
        if (obj instanceof vs0) {
            return (vs0) obj;
        }
        if (obj != null) {
            return new vs0(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(2);
        rp0Var.m8224a(this.f7553O);
        ASN1Encodable aSN1Encodable = this.f7554P;
        if (aSN1Encodable != null) {
            rp0Var.m8224a(aSN1Encodable);
        }
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public aq0 m9343k() {
        return this.f7553O;
    }

    /* renamed from: n */
    public ASN1Encodable m9344n() {
        return this.f7554P;
    }
}
