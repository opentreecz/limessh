package com.sonelli;

import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class qs0 extends zp0 {

    /* renamed from: O */
    public xp0 f6087O;

    /* renamed from: P */
    public vs0 f6088P;

    /* renamed from: Q */
    public bq0 f6089Q;

    /* renamed from: R */
    public gq0 f6090R;

    /* renamed from: S */
    public pp0 f6091S;

    public qs0(fq0 fq0Var) {
        Enumeration mo3871v = fq0Var.mo3871v();
        xp0 m9866t = xp0.m9866t(mo3871v.nextElement());
        this.f6087O = m9866t;
        int m7780p = m7780p(m9866t);
        this.f6088P = vs0.m9342m(mo3871v.nextElement());
        this.f6089Q = bq0.m2592t(mo3871v.nextElement());
        int i = -1;
        while (mo3871v.hasMoreElements()) {
            iq0 iq0Var = (iq0) mo3871v.nextElement();
            int m4911v = iq0Var.m4911v();
            if (m4911v <= i) {
                throw new IllegalArgumentException("invalid optional field in private key info");
            }
            if (m4911v == 0) {
                this.f6090R = gq0.m4246v(iq0Var, false);
            } else {
                if (m4911v != 1) {
                    throw new IllegalArgumentException("unknown optional field in private key info");
                }
                if (m7780p < 1) {
                    throw new IllegalArgumentException("'publicKey' requires version v2(1) or later");
                }
                this.f6091S = xq0.m9875C(iq0Var, false);
            }
            i = m4911v;
        }
    }

    public qs0(vs0 vs0Var, ASN1Encodable aSN1Encodable) throws IOException {
        this(vs0Var, aSN1Encodable, null, null);
    }

    public qs0(vs0 vs0Var, ASN1Encodable aSN1Encodable, gq0 gq0Var) throws IOException {
        this(vs0Var, aSN1Encodable, gq0Var, null);
    }

    public qs0(vs0 vs0Var, ASN1Encodable aSN1Encodable, gq0 gq0Var, byte[] bArr) throws IOException {
        this.f6087O = new xp0(bArr != null ? f51.f2621b : f51.f2620a);
        this.f6088P = vs0Var;
        this.f6089Q = new gr0(aSN1Encodable);
        this.f6090R = gq0Var;
        this.f6091S = bArr == null ? null : new xq0(bArr);
    }

    /* renamed from: m */
    public static qs0 m7779m(Object obj) {
        if (obj instanceof qs0) {
            return (qs0) obj;
        }
        if (obj != null) {
            return new qs0(fq0.m3869t(obj));
        }
        return null;
    }

    /* renamed from: p */
    public static int m7780p(xp0 xp0Var) {
        int m9868B = xp0Var.m9868B();
        if (m9868B < 0 || m9868B > 1) {
            throw new IllegalArgumentException("invalid version for private key info");
        }
        return m9868B;
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0(5);
        rp0Var.m8224a(this.f6087O);
        rp0Var.m8224a(this.f6088P);
        rp0Var.m8224a(this.f6089Q);
        gq0 gq0Var = this.f6090R;
        if (gq0Var != null) {
            rp0Var.m8224a(new pr0(false, 0, gq0Var));
        }
        pp0 pp0Var = this.f6091S;
        if (pp0Var != null) {
            rp0Var.m8224a(new pr0(false, 1, pp0Var));
        }
        return new kr0(rp0Var);
    }

    /* renamed from: k */
    public gq0 m7781k() {
        return this.f6090R;
    }

    /* renamed from: n */
    public vs0 m7782n() {
        return this.f6088P;
    }

    /* renamed from: o */
    public pp0 m7783o() {
        return this.f6091S;
    }

    /* renamed from: q */
    public ASN1Encodable m7784q() throws IOException {
        return eq0.m3546p(this.f6089Q.m2598v());
    }
}
