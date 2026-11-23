package cz.opentree;

import java.io.IOException;

/* loaded from: classes.dex */
public class jq0 extends eq0 {

    /* renamed from: O */
    public byte[] f3645O;

    public jq0(byte[] bArr) {
        if (bArr.length < 2) {
            throw new IllegalArgumentException("UTCTime string too short");
        }
        this.f3645O = bArr;
        if (!m5187t(0) || !m5187t(1)) {
            throw new IllegalArgumentException("illegal characters in UTCTime string");
        }
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return e51.m3445n(this.f3645O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof jq0) {
            return e51.m3432a(this.f3645O, ((jq0) eq0Var).f3645O);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 23, this.f3645O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        int length = this.f3645O.length;
        return ks0.m5992a(length) + 1 + length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public final boolean m5187t(int i) {
        byte[] bArr = this.f3645O;
        return bArr.length > i && bArr[i] >= 48 && bArr[i] <= 57;
    }

    public String toString() {
        return j51.m5063b(this.f3645O);
    }
}
