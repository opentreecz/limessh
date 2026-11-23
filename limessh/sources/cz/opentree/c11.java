package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class c11 extends zp0 {

    /* renamed from: O */
    public final byte[] f1864O;

    /* renamed from: P */
    public final byte[] f1865P;

    public c11(fq0 fq0Var) {
        if (!xp0.m9866t(fq0Var.mo3870u(0)).m9872x(BigInteger.valueOf(0L))) {
            throw new IllegalArgumentException("unknown version of sequence");
        }
        this.f1864O = e51.m3436e(bq0.m2592t(fq0Var.mo3870u(1)).m2598v());
        this.f1865P = e51.m3436e(bq0.m2592t(fq0Var.mo3870u(2)).m2598v());
    }

    public c11(byte[] bArr, byte[] bArr2) {
        this.f1864O = e51.m3436e(bArr);
        this.f1865P = e51.m3436e(bArr2);
    }

    /* renamed from: k */
    public static c11 m2652k(Object obj) {
        if (obj instanceof c11) {
            return (c11) obj;
        }
        if (obj != null) {
            return new c11(fq0.m3869t(obj));
        }
        return null;
    }

    @Override // cz.opentree.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(0L));
        rp0Var.m8224a(new gr0(this.f1864O));
        rp0Var.m8224a(new gr0(this.f1865P));
        return new kr0(rp0Var);
    }

    /* renamed from: m */
    public byte[] m2653m() {
        return e51.m3436e(this.f1864O);
    }

    /* renamed from: n */
    public byte[] m2654n() {
        return e51.m3436e(this.f1865P);
    }
}
