package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class ar0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f1516O;

    public ar0(byte[] bArr) {
        this.f1516O = bArr;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f1516O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof ar0) {
            return e51.m3432a(this.f1516O, ((ar0) eq0Var).f1516O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 27, this.f1516O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f1516O.length) + 1 + this.f1516O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m2267t() {
        return j51.m5063b(this.f1516O);
    }

    public String toString() {
        return m2267t();
    }
}
