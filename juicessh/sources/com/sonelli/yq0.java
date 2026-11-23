package com.sonelli;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class yq0 extends up0 {
    public yq0(aq0 aq0Var, xp0 xp0Var, eq0 eq0Var, int i, eq0 eq0Var2) {
        super(aq0Var, xp0Var, eq0Var, i, eq0Var2);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        aq0 aq0Var = this.f7083O;
        if (aq0Var != null) {
            byteArrayOutputStream.write(aq0Var.m10587j("DER"));
        }
        xp0 xp0Var = this.f7084P;
        if (xp0Var != null) {
            byteArrayOutputStream.write(xp0Var.m10587j("DER"));
        }
        eq0 eq0Var = this.f7085Q;
        if (eq0Var != null) {
            byteArrayOutputStream.write(eq0Var.m10587j("DER"));
        }
        byteArrayOutputStream.write(new pr0(true, this.f7086R, this.f7087S).m10587j("DER"));
        cq0Var.m2967m(z, 32, 8, byteArrayOutputStream.toByteArray());
    }

    @Override // com.sonelli.up0, com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        return getEncoded().length;
    }

    @Override // com.sonelli.up0, com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // com.sonelli.up0, com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
