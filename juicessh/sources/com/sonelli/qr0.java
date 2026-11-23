package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class qr0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f6084O;

    public qr0(byte[] bArr) {
        this.f6084O = bArr;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f6084O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof qr0) {
            return e51.m3432a(this.f6084O, ((qr0) eq0Var).f6084O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 12, this.f6084O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        return ks0.m5992a(this.f6084O.length) + 1 + this.f6084O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m7775t() {
        return j51.m5064c(this.f6084O);
    }

    public String toString() {
        return m7775t();
    }
}
