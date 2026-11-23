package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.asn1.p004x9.X9ObjectIdentifiers;
import org.bouncycastle.math.field.PolynomialExtensionField;

/* loaded from: classes.dex */
public class at0 extends zp0 implements X9ObjectIdentifiers {

    /* renamed from: U */
    public static final BigInteger f1521U = BigInteger.valueOf(1);

    /* renamed from: O */
    public et0 f1522O;

    /* renamed from: P */
    public gv0 f1523P;

    /* renamed from: Q */
    public ct0 f1524Q;

    /* renamed from: R */
    public BigInteger f1525R;

    /* renamed from: S */
    public BigInteger f1526S;

    /* renamed from: T */
    public byte[] f1527T;

    public at0(gv0 gv0Var, ct0 ct0Var, BigInteger bigInteger, BigInteger bigInteger2) {
        this(gv0Var, ct0Var, bigInteger, bigInteger2, null);
    }

    public at0(gv0 gv0Var, ct0 ct0Var, BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr) {
        et0 et0Var;
        this.f1523P = gv0Var;
        this.f1524Q = ct0Var;
        this.f1525R = bigInteger;
        this.f1526S = bigInteger2;
        this.f1527T = e51.m3436e(bArr);
        if (fv0.m3884e(gv0Var)) {
            et0Var = new et0(gv0Var.m4270p().mo2332c());
        } else {
            if (!fv0.m3882c(gv0Var)) {
                throw new IllegalArgumentException("'curve' is of an unsupported type");
            }
            int[] mo1947a = ((PolynomialExtensionField) gv0Var.m4270p()).mo2330a().mo1947a();
            if (mo1947a.length == 3) {
                et0Var = new et0(mo1947a[2], mo1947a[1]);
            } else {
                if (mo1947a.length != 5) {
                    throw new IllegalArgumentException("Only trinomial and pentomial curves are supported");
                }
                et0Var = new et0(mo1947a[4], mo1947a[1], mo1947a[2], mo1947a[3]);
            }
        }
        this.f1522O = et0Var;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(6);
        rp0Var.m8224a(new xp0(f1521U));
        rp0Var.m8224a(this.f1522O);
        rp0Var.m8224a(new zs0(this.f1523P, this.f1527T));
        rp0Var.m8224a(this.f1524Q);
        rp0Var.m8224a(new xp0(this.f1525R));
        BigInteger bigInteger = this.f1526S;
        if (bigInteger != null) {
            rp0Var.m8224a(new xp0(bigInteger));
        }
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public gv0 m2271k() {
        return this.f1523P;
    }

    /* renamed from: m */
    public iv0 m2272m() {
        return this.f1524Q.m2980k();
    }

    /* renamed from: n */
    public BigInteger m2273n() {
        return this.f1526S;
    }

    /* renamed from: o */
    public BigInteger m2274o() {
        return this.f1525R;
    }

    /* renamed from: p */
    public byte[] m2275p() {
        return e51.m3436e(this.f1527T);
    }
}
