package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.IOException;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class tq0 extends iq0 {
    public tq0(boolean z, int i, ASN1Encodable aSN1Encodable) {
        super(z, i, aSN1Encodable);
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        Enumeration m4249w;
        cq0Var.m2976v(z, KeycodeConstants.KEYCODE_NUMPAD_ENTER, this.f3394O);
        cq0Var.m2960f(128);
        if (this.f3395P) {
            cq0Var.mo2975u(this.f3396Q.mo1950f(), true);
        } else {
            ASN1Encodable aSN1Encodable = this.f3396Q;
            if (aSN1Encodable instanceof bq0) {
                m4249w = aSN1Encodable instanceof nq0 ? ((nq0) aSN1Encodable).m6773B() : new nq0(((bq0) aSN1Encodable).m2598v()).m6773B();
            } else if (aSN1Encodable instanceof fq0) {
                m4249w = ((fq0) aSN1Encodable).mo3871v();
            } else {
                if (!(aSN1Encodable instanceof gq0)) {
                    throw new tp0("not implemented: " + this.f3396Q.getClass().getName());
                }
                m4249w = ((gq0) aSN1Encodable).m4249w();
            }
            cq0Var.m2962h(m4249w);
        }
        cq0Var.m2960f(0);
        cq0Var.m2960f(0);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m5993b;
        int mo2261n = this.f3396Q.mo1950f().mo2261n();
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
        return this.f3395P || this.f3396Q.mo1950f().mo2262q();
    }
}
