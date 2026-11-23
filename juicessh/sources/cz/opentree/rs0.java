package cz.opentree;

import java.math.BigInteger;
import java.util.Enumeration;

/* loaded from: classes.dex */
public class rs0 extends zp0 {

    /* renamed from: O */
    public BigInteger f6280O;

    /* renamed from: P */
    public BigInteger f6281P;

    /* renamed from: Q */
    public BigInteger f6282Q;

    /* renamed from: R */
    public BigInteger f6283R;

    /* renamed from: S */
    public BigInteger f6284S;

    /* renamed from: T */
    public BigInteger f6285T;

    /* renamed from: U */
    public BigInteger f6286U;

    /* renamed from: V */
    public BigInteger f6287V;

    /* renamed from: W */
    public BigInteger f6288W;

    /* renamed from: X */
    public fq0 f6289X;

    public rs0(fq0 fq0Var) {
        this.f6289X = null;
        Enumeration mo3871v = fq0Var.mo3871v();
        xp0 xp0Var = (xp0) mo3871v.nextElement();
        int m9868B = xp0Var.m9868B();
        if (m9868B < 0 || m9868B > 1) {
            throw new IllegalArgumentException("wrong version for RSA private key");
        }
        this.f6280O = xp0Var.m9871w();
        this.f6281P = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6282Q = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6283R = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6284S = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6285T = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6286U = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6287V = ((xp0) mo3871v.nextElement()).m9871w();
        this.f6288W = ((xp0) mo3871v.nextElement()).m9871w();
        if (mo3871v.hasMoreElements()) {
            this.f6289X = (fq0) mo3871v.nextElement();
        }
    }

    /* renamed from: o */
    public static rs0 m8232o(Object obj) {
        if (obj instanceof rs0) {
            return (rs0) obj;
        }
        if (obj != null) {
            return new rs0(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(10);
        rp0Var.m8224a(new xp0(this.f6280O));
        rp0Var.m8224a(new xp0(m8236p()));
        rp0Var.m8224a(new xp0(m8240t()));
        rp0Var.m8224a(new xp0(m8239s()));
        rp0Var.m8224a(new xp0(m8237q()));
        rp0Var.m8224a(new xp0(m8238r()));
        rp0Var.m8224a(new xp0(m8234m()));
        rp0Var.m8224a(new xp0(m8235n()));
        rp0Var.m8224a(new xp0(m8233k()));
        fq0 fq0Var = this.f6289X;
        if (fq0Var != null) {
            rp0Var.m8224a(fq0Var);
        }
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public BigInteger m8233k() {
        return this.f6288W;
    }

    /* renamed from: m */
    public BigInteger m8234m() {
        return this.f6286U;
    }

    /* renamed from: n */
    public BigInteger m8235n() {
        return this.f6287V;
    }

    /* renamed from: p */
    public BigInteger m8236p() {
        return this.f6281P;
    }

    /* renamed from: q */
    public BigInteger m8237q() {
        return this.f6284S;
    }

    /* renamed from: r */
    public BigInteger m8238r() {
        return this.f6285T;
    }

    /* renamed from: s */
    public BigInteger m8239s() {
        return this.f6283R;
    }

    /* renamed from: t */
    public BigInteger m8240t() {
        return this.f6282Q;
    }
}
