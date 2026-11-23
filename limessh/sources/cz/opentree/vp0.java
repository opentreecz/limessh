package cz.opentree;

import java.io.IOException;

/* loaded from: classes.dex */
public class vp0 extends eq0 {

    /* renamed from: O */
    public byte[] f7544O;

    public vp0(byte[] bArr) {
        if (bArr.length < 4) {
            throw new IllegalArgumentException("GeneralizedTime string too short");
        }
        this.f7544O = bArr;
        if (!m9338w(0) || !m9338w(1) || !m9338w(2) || !m9338w(3)) {
            throw new IllegalArgumentException("illegal characters in GeneralizedTime string");
        }
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return e51.m3445n(this.f7544O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof vp0) {
            return e51.m3432a(this.f7544O, ((vp0) eq0Var).f7544O);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 24, this.f7544O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        int length = this.f7544O.length;
        return ks0.m5992a(length) + 1 + length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new br0(this.f7544O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new br0(this.f7544O);
    }

    /* renamed from: t */
    public boolean m9335t() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f7544O;
            if (i == bArr.length) {
                return false;
            }
            if (bArr[i] == 46 && i == 14) {
                return true;
            }
            i++;
        }
    }

    /* renamed from: u */
    public boolean m9336u() {
        return m9338w(10) && m9338w(11);
    }

    /* renamed from: v */
    public boolean m9337v() {
        return m9338w(12) && m9338w(13);
    }

    /* renamed from: w */
    public final boolean m9338w(int i) {
        byte[] bArr = this.f7544O;
        return bArr.length > i && bArr[i] >= 48 && bArr[i] <= 57;
    }
}
