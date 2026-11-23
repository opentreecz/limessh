package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class rq0 extends gq0 {
    public rq0() {
    }

    public rq0(rp0 rp0Var) {
        super(rp0Var, false);
    }

    public rq0(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
    }

    public rq0(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        super(z, aSN1EncodableArr);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2971q(z, 49, this.f2973O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int length = this.f2973O.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += this.f2973O[i2].mo1950f().mo2261n();
        }
        return i + 2 + 2;
    }
}
