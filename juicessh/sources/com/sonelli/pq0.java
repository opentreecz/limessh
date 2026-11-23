package com.sonelli;

import java.io.IOException;

/* loaded from: classes.dex */
public class pq0 extends fq0 {
    public pq0() {
    }

    public pq0(rp0 rp0Var) {
        super(rp0Var);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2971q(z, 48, this.f2760O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        int length = this.f2760O.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += this.f2760O[i2].mo1950f().mo2261n();
        }
        return i + 2 + 2;
    }
}
