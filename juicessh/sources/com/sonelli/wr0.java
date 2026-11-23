package com.sonelli;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class wr0 extends up0 {
    public wr0(aq0 aq0Var, xp0 xp0Var, eq0 eq0Var, int i, eq0 eq0Var2) {
        super(aq0Var, xp0Var, eq0Var, i, eq0Var2);
    }

    public wr0(rp0 rp0Var) {
        super(rp0Var);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        aq0 aq0Var = this.f7083O;
        if (aq0Var != null) {
            byteArrayOutputStream.write(aq0Var.m10587j("DL"));
        }
        xp0 xp0Var = this.f7084P;
        if (xp0Var != null) {
            byteArrayOutputStream.write(xp0Var.m10587j("DL"));
        }
        eq0 eq0Var = this.f7085Q;
        if (eq0Var != null) {
            byteArrayOutputStream.write(eq0Var.m10587j("DL"));
        }
        byteArrayOutputStream.write(new ds0(true, this.f7086R, this.f7087S).m10587j("DL"));
        cq0Var.m2967m(z, 32, 8, byteArrayOutputStream.toByteArray());
    }

    @Override // com.sonelli.up0, com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        return getEncoded().length;
    }

    @Override // com.sonelli.up0, com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
