package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class gr0 extends bq0 {
    public gr0(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.mo1950f().m10587j("DER"));
    }

    public gr0(byte[] bArr) {
        super(bArr);
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 4, this.f1782O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f1782O.length) + 1 + this.f1782O.length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    @Override // cz.opentree.bq0, cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // cz.opentree.bq0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
