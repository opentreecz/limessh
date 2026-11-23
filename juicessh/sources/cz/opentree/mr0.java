package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class mr0 extends gq0 {

    /* renamed from: Q */
    public int f5131Q;

    public mr0() {
        this.f5131Q = -1;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mr0(boolean z, ASN1Encodable[] aSN1EncodableArr) {
        super(z, aSN1EncodableArr);
        m6512C(z);
        this.f5131Q = -1;
    }

    /* renamed from: C */
    public static boolean m6512C(boolean z) {
        if (z) {
            return z;
        }
        throw new IllegalStateException("DERSet elements should always be in sorted order");
    }

    /* renamed from: E */
    public final int m6513E() throws IOException {
        if (this.f5131Q < 0) {
            int length = this.f2973O.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f2973O[i2].mo1950f().mo2596r().mo2261n();
            }
            this.f5131Q = i;
        }
        return this.f5131Q;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        if (z) {
            cq0Var.m2960f(49);
        }
        ir0 mo2958d = cq0Var.mo2958d();
        int length = this.f2973O.length;
        int i = 0;
        if (this.f5131Q >= 0 || length > 16) {
            cq0Var.m2972r(m6513E());
            while (i < length) {
                this.f2973O[i].mo1950f().mo2596r().mo2260m(mo2958d, true);
                i++;
            }
            return;
        }
        eq0[] eq0VarArr = new eq0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            eq0 mo2596r = this.f2973O[i3].mo1950f().mo2596r();
            eq0VarArr[i3] = mo2596r;
            i2 += mo2596r.mo2261n();
        }
        this.f5131Q = i2;
        cq0Var.m2972r(i2);
        while (i < length) {
            eq0VarArr[i].mo2260m(mo2958d, true);
            i++;
        }
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m6513E = m6513E();
        return ks0.m5992a(m6513E) + 1 + m6513E;
    }

    @Override // cz.opentree.gq0, cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this.f2974P ? this : super.mo2596r();
    }

    @Override // cz.opentree.gq0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
