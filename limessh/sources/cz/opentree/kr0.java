package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class kr0 extends fq0 {

    /* renamed from: P */
    public int f4643P;

    public kr0(rp0 rp0Var) {
        super(rp0Var);
        this.f4643P = -1;
    }

    public kr0(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        super(aSN1EncodableArr, z);
        this.f4643P = -1;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        if (z) {
            cq0Var.m2960f(48);
        }
        ir0 mo2958d = cq0Var.mo2958d();
        int length = this.f2760O.length;
        int i = 0;
        if (this.f4643P >= 0 || length > 16) {
            cq0Var.m2972r(m5991x());
            while (i < length) {
                this.f2760O[i].mo1950f().mo2596r().mo2260m(mo2958d, true);
                i++;
            }
            return;
        }
        eq0[] eq0VarArr = new eq0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            eq0 mo2596r = this.f2760O[i3].mo1950f().mo2596r();
            eq0VarArr[i3] = mo2596r;
            i2 += mo2596r.mo2261n();
        }
        this.f4643P = i2;
        cq0Var.m2972r(i2);
        while (i < length) {
            eq0VarArr[i].mo2260m(mo2958d, true);
            i++;
        }
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m5991x = m5991x();
        return ks0.m5992a(m5991x) + 1 + m5991x;
    }

    @Override // cz.opentree.fq0, cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // cz.opentree.fq0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }

    /* renamed from: x */
    public final int m5991x() throws IOException {
        if (this.f4643P < 0) {
            int length = this.f2760O.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f2760O[i2].mo1950f().mo2596r().mo2261n();
            }
            this.f4643P = i;
        }
        return this.f4643P;
    }
}
