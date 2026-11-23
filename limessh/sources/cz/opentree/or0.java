package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class or0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public byte[] f5536O;

    public or0(byte[] bArr) {
        this.f5536O = e51.m3436e(bArr);
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return e51.m3445n(this.f5536O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof or0) {
            return e51.m3432a(this.f5536O, ((or0) eq0Var).f5536O);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 20, this.f5536O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f5536O.length) + 1 + this.f5536O.length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m7085t() {
        return j51.m5063b(this.f5536O);
    }

    public String toString() {
        return m7085t();
    }
}
