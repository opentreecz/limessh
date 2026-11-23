package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class sr0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f6588O;

    public sr0(byte[] bArr) {
        this.f6588O = e51.m3436e(bArr);
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f6588O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof sr0) {
            return e51.m3432a(this.f6588O, ((sr0) eq0Var).f6588O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 21, this.f6588O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f6588O.length) + 1 + this.f6588O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }
}
