package com.sonelli;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public abstract class eq0 extends zp0 {
    /* renamed from: p */
    public static eq0 m3546p(byte[] bArr) throws IOException {
        wp0 wp0Var = new wp0(bArr);
        try {
            eq0 m9629n = wp0Var.m9629n();
            if (wp0Var.available() == 0) {
                return m9629n;
            }
            throw new IOException("Extra data detected in stream");
        } catch (ClassCastException unused) {
            throw new IOException("cannot recognise object in stream");
        }
    }

    @Override // com.sonelli.zp0
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ASN1Encodable) && mo2259k(((ASN1Encodable) obj).mo1950f());
    }

    @Override // com.sonelli.zp0, org.bouncycastle.asn1.ASN1Encodable
    /* renamed from: f */
    public final eq0 mo1950f() {
        return this;
    }

    @Override // com.sonelli.zp0
    /* renamed from: h */
    public void mo3547h(OutputStream outputStream) throws IOException {
        cq0.m2955a(outputStream).m2974t(this);
    }

    @Override // com.sonelli.zp0
    /* renamed from: i */
    public void mo3548i(OutputStream outputStream, String str) throws IOException {
        cq0.m2956b(outputStream, str).m2974t(this);
    }

    /* renamed from: k */
    public abstract boolean mo2259k(eq0 eq0Var);

    /* renamed from: m */
    public abstract void mo2260m(cq0 cq0Var, boolean z) throws IOException;

    /* renamed from: n */
    public abstract int mo2261n() throws IOException;

    /* renamed from: o */
    public final boolean m3549o(eq0 eq0Var) {
        return this == eq0Var || mo2259k(eq0Var);
    }

    /* renamed from: q */
    public abstract boolean mo2262q();

    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
