package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class fr0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f2765O;

    public fr0(byte[] bArr) {
        this.f2765O = bArr;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f2765O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof fr0) {
            return e51.m3432a(this.f2765O, ((fr0) eq0Var).f2765O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 18, this.f2765O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f2765O.length) + 1 + this.f2765O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m3873t() {
        return j51.m5063b(this.f2765O);
    }

    public String toString() {
        return m3873t();
    }
}
