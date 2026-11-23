package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class cr0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f2040O;

    public cr0(byte[] bArr) {
        this.f2040O = e51.m3436e(bArr);
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f2040O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof cr0) {
            return e51.m3432a(this.f2040O, ((cr0) eq0Var).f2040O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 25, this.f2040O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f2040O.length) + 1 + this.f2040O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }
}
