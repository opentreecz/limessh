package com.sonelli;

/* loaded from: classes.dex */
public class a11 extends zp0 {

    /* renamed from: O */
    public final byte[] f1309O;

    /* renamed from: P */
    public final byte[] f1310P;

    public a11(byte[] bArr, byte[] bArr2) {
        this.f1309O = e51.m3436e(bArr);
        this.f1310P = e51.m3436e(bArr2);
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public eq0 mo1950f() {
        rp0 rp0Var = new rp0();
        rp0Var.m8224a(new xp0(0L));
        rp0Var.m8224a(new gr0(this.f1309O));
        rp0Var.m8224a(new gr0(this.f1310P));
        return new kr0(rp0Var);
    }
}
