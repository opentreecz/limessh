package com.sonelli;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class ss0 extends zp0 {

    /* renamed from: O */
    public fq0 f6591O;

    public ss0(fq0 fq0Var) {
        this.f6591O = fq0Var;
    }

    /* renamed from: k */
    public static ss0 m8483k(Object obj) {
        if (obj instanceof ss0) {
            return (ss0) obj;
        }
        if (obj != null) {
            return new ss0(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        return this.f6591O;
    }

    /* renamed from: m */
    public BigInteger m8484m() {
        return new BigInteger(1, ((bq0) this.f6591O.mo3870u(1)).m2598v());
    }

    /* renamed from: n */
    public final eq0 m8485n(int i) {
        Enumeration mo3871v = this.f6591O.mo3871v();
        while (mo3871v.hasMoreElements()) {
            ASN1Encodable aSN1Encodable = (ASN1Encodable) mo3871v.nextElement();
            if (aSN1Encodable instanceof iq0) {
                iq0 iq0Var = (iq0) aSN1Encodable;
                if (iq0Var.m4911v() == i) {
                    eq0 m4910u = iq0Var.m4910u();
                    m4910u.mo1950f();
                    return m4910u;
                }
            }
        }
        return null;
    }

    /* renamed from: o */
    public eq0 m8486o() {
        return m8485n(0);
    }
}
