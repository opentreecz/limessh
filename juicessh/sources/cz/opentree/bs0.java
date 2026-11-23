package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class bs0 extends gq0 {

    /* renamed from: Q */
    public int f1818Q;

    public bs0() {
        this.f1818Q = -1;
    }

    public bs0(rp0 rp0Var) {
        super(rp0Var, false);
        this.f1818Q = -1;
    }

    public bs0(ASN1Encodable aSN1Encodable) {
        super(aSN1Encodable);
        this.f1818Q = -1;
    }

    public bs0(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        super(z, aSN1EncodableArr);
        this.f1818Q = -1;
    }

    /* renamed from: C */
    public final int m2602C() throws IOException {
        if (this.f1818Q < 0) {
            int length = this.f2973O.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f2973O[i2].mo1950f().mo2597s().mo2261n();
            }
            this.f1818Q = i;
        }
        return this.f1818Q;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        if (z) {
            cq0Var.m2960f(49);
        }
        cq0 mo2959e = cq0Var.mo2959e();
        int length = this.f2973O.length;
        int i = 0;
        if (this.f1818Q >= 0 || length > 16) {
            cq0Var.m2972r(m2602C());
            while (i < length) {
                mo2959e.mo2975u(this.f2973O[i].mo1950f(), true);
                i++;
            }
            return;
        }
        eq0[] eq0VarArr = new eq0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            eq0 mo2597s = this.f2973O[i3].mo1950f().mo2597s();
            eq0VarArr[i3] = mo2597s;
            i2 += mo2597s.mo2261n();
        }
        this.f1818Q = i2;
        cq0Var.m2972r(i2);
        while (i < length) {
            mo2959e.mo2975u(eq0VarArr[i], true);
            i++;
        }
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m2602C = m2602C();
        return ks0.m5992a(m2602C) + 1 + m2602C;
    }

    @Override // cz.opentree.gq0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
