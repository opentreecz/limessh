package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class ds0 extends iq0 {
    public ds0(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        eq0 mo2597s = this.f3396Q.mo1950f().mo2597s();
        cq0Var.m2976v(z, (this.f3395P || mo2597s.mo2262q()) ? KeycodeConstants.KEYCODE_NUMPAD_ENTER : 128, this.f3394O);
        if (this.f3395P) {
            cq0Var.m2972r(mo2597s.mo2261n());
        }
        cq0Var.mo2959e().mo2975u(mo2597s, this.f3395P);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m5993b;
        int mo2261n = this.f3396Q.mo1950f().mo2597s().mo2261n();
        if (this.f3395P) {
            m5993b = ks0.m5993b(this.f3394O) + ks0.m5992a(mo2261n);
        } else {
            mo2261n--;
            m5993b = ks0.m5993b(this.f3394O);
        }
        return m5993b + mo2261n;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return this.f3395P || this.f3396Q.mo1950f().mo2597s().mo2262q();
    }

    @Override // com.sonelli.iq0, com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
