package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class pr0 extends iq0 {
    public pr0(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        eq0 mo2596r = this.f3396Q.mo1950f().mo2596r();
        cq0Var.m2976v(z, (this.f3395P || mo2596r.mo2262q()) ? KeycodeConstants.KEYCODE_NUMPAD_ENTER : 128, this.f3394O);
        if (this.f3395P) {
            cq0Var.m2972r(mo2596r.mo2261n());
        }
        mo2596r.mo2260m(cq0Var.mo2958d(), this.f3395P);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m5993b;
        int mo2261n = this.f3396Q.mo1950f().mo2596r().mo2261n();
        if (this.f3395P) {
            m5993b = ks0.m5993b(this.f3394O) + ks0.m5992a(mo2261n);
        } else {
            mo2261n--;
            m5993b = ks0.m5993b(this.f3394O);
        }
        return m5993b + mo2261n;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return this.f3395P || this.f3396Q.mo1950f().mo2596r().mo2262q();
    }

    @Override // cz.opentree.iq0, cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // cz.opentree.iq0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
