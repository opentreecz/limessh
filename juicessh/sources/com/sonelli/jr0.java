package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class jr0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final byte[] f3647O;

    public jr0(byte[] bArr) {
        this.f3647O = bArr;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f3647O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof jr0) {
            return e51.m3432a(this.f3647O, ((jr0) eq0Var).f3647O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 19, this.f3647O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f3647O.length) + 1 + this.f3647O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m5188t() {
        return j51.m5063b(this.f3647O);
    }

    public String toString() {
        return m5188t();
    }
}
