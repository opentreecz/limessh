package com.sonelli;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class zr0 extends fq0 {

    /* renamed from: P */
    public int f8584P;

    public zr0() {
        this.f8584P = -1;
    }

    public zr0(rp0 rp0Var) {
        super(rp0Var);
        this.f8584P = -1;
    }

    public zr0(ASN1Encodable[] aSN1EncodableArr, boolean z) {
        super(aSN1EncodableArr, z);
        this.f8584P = -1;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        if (z) {
            cq0Var.m2960f(48);
        }
        cq0 mo2959e = cq0Var.mo2959e();
        int length = this.f2760O.length;
        int i = 0;
        if (this.f8584P >= 0 || length > 16) {
            cq0Var.m2972r(m10621x());
            while (i < length) {
                mo2959e.mo2975u(this.f2760O[i].mo1950f(), true);
                i++;
            }
            return;
        }
        eq0[] eq0VarArr = new eq0[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            eq0 mo2597s = this.f2760O[i3].mo1950f().mo2597s();
            eq0VarArr[i3] = mo2597s;
            i2 += mo2597s.mo2261n();
        }
        this.f8584P = i2;
        cq0Var.m2972r(i2);
        while (i < length) {
            mo2959e.mo2975u(eq0VarArr[i], true);
            i++;
        }
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int m10621x = m10621x();
        return ks0.m5992a(m10621x) + 1 + m10621x;
    }

    @Override // com.sonelli.fq0, com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }

    /* renamed from: x */
    public final int m10621x() throws IOException {
        if (this.f8584P < 0) {
            int length = this.f2760O.length;
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += this.f2760O[i2].mo1950f().mo2597s().mo2261n();
            }
            this.f8584P = i;
        }
        return this.f8584P;
    }
}
