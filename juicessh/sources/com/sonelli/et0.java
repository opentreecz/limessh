package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.asn1.p004x9.X9ObjectIdentifiers;

/* loaded from: classes.dex */
public class et0 extends zp0 implements X9ObjectIdentifiers {

    /* renamed from: O */
    public aq0 f2537O;

    /* renamed from: P */
    public eq0 f2538P;

    public et0(int i, int i2) {
        this(i, i2, 0, 0);
    }

    public et0(int i, int i2, int i3, int i4) {
        this.f2537O = X9ObjectIdentifiers.f8849d;
        rp0 rp0Var = new rp0(3);
        rp0Var.m8224a(new xp0(i));
        if (i3 == 0) {
            if (i4 != 0) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            rp0Var.m8224a(X9ObjectIdentifiers.f8850e);
            rp0Var.m8224a(new xp0(i2));
        } else {
            if (i3 <= i2 || i4 <= i3) {
                throw new IllegalArgumentException("inconsistent k values");
            }
            rp0Var.m8224a(X9ObjectIdentifiers.f8851f);
            rp0 rp0Var2 = new rp0(3);
            rp0Var2.m8224a(new xp0(i2));
            rp0Var2.m8224a(new xp0(i3));
            rp0Var2.m8224a(new xp0(i4));
            rp0Var.m8224a(new kr0(rp0Var2));
        }
        this.f2538P = new kr0(rp0Var);
    }

    public et0(BigInteger bigInteger) {
        this.f2537O = X9ObjectIdentifiers.f8848c;
        this.f2538P = new xp0(bigInteger);
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(2);
        rp0Var.m8224a(this.f2537O);
        rp0Var.m8224a(this.f2538P);
        return new kr0(rp0Var);
    }
}
