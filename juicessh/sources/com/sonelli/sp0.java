package com.sonelli;

import java.io.IOException;

/* loaded from: classes.dex */
public class sp0 extends eq0 {

    /* renamed from: P */
    public static sp0[] f6581P = new sp0[12];

    /* renamed from: O */
    public final byte[] f6582O;

    public sp0(byte[] bArr) {
        if (xp0.m9863C(bArr)) {
            throw new IllegalArgumentException("malformed enumerated");
        }
        if ((bArr[0] & 128) != 0) {
            throw new IllegalArgumentException("enumerated must be non-negative");
        }
        this.f6582O = e51.m3436e(bArr);
        xp0.m9865G(bArr);
    }

    /* renamed from: t */
    public static sp0 m8479t(byte[] bArr) {
        if (bArr.length > 1) {
            return new sp0(bArr);
        }
        if (bArr.length == 0) {
            throw new IllegalArgumentException("ENUMERATED has zero length");
        }
        int i = bArr[0] & 255;
        sp0[] sp0VarArr = f6581P;
        if (i >= sp0VarArr.length) {
            return new sp0(bArr);
        }
        sp0 sp0Var = sp0VarArr[i];
        if (sp0Var != null) {
            return sp0Var;
        }
        sp0 sp0Var2 = new sp0(bArr);
        sp0VarArr[i] = sp0Var2;
        return sp0Var2;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3445n(this.f6582O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof sp0) {
            return e51.m3432a(this.f6582O, ((sp0) eq0Var).f6582O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 10, this.f6582O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f6582O.length) + 1 + this.f6582O.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }
}
