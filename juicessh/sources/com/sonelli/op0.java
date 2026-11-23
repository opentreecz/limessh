package com.sonelli;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class op0 extends eq0 {

    /* renamed from: O */
    public final boolean f5530O;

    /* renamed from: P */
    public final int f5531P;

    /* renamed from: Q */
    public final byte[] f5532Q;

    public op0(boolean z, int i, byte[] bArr) {
        this.f5530O = z;
        this.f5531P = i;
        this.f5532Q = e51.m3436e(bArr);
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        boolean z = this.f5530O;
        return ((z ? 1 : 0) ^ this.f5531P) ^ e51.m3445n(this.f5532Q);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (!(eq0Var instanceof op0)) {
            return false;
        }
        op0 op0Var = (op0) eq0Var;
        return this.f5530O == op0Var.f5530O && this.f5531P == op0Var.f5531P && e51.m3432a(this.f5532Q, op0Var.f5532Q);
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2967m(z, this.f5530O ? 96 : 64, this.f5531P, this.f5532Q);
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        return ks0.m5993b(this.f5531P) + ks0.m5992a(this.f5532Q.length) + this.f5532Q.length;
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return this.f5530O;
    }

    /* renamed from: t */
    public int m7079t() {
        return this.f5531P;
    }

    public String toString() {
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[");
        if (mo2262q()) {
            stringBuffer.append("CONSTRUCTED ");
        }
        stringBuffer.append("APPLICATION ");
        stringBuffer.append(Integer.toString(m7079t()));
        stringBuffer.append("]");
        if (this.f5532Q != null) {
            stringBuffer.append(" #");
            str = o51.m6875d(this.f5532Q);
        } else {
            str = " #null";
        }
        stringBuffer.append(str);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }
}
