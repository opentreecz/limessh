package cz.opentree;

import java.io.IOException;

/* loaded from: classes.dex */
public class qp0 extends eq0 {

    /* renamed from: P */
    public static final qp0 f6065P = new qp0((byte) 0);

    /* renamed from: Q */
    public static final qp0 f6066Q = new qp0((byte) -1);

    /* renamed from: O */
    public final byte f6067O;

    public qp0(byte b) {
        this.f6067O = b;
    }

    /* renamed from: t */
    public static qp0 m7773t(byte[] bArr) {
        if (bArr.length != 1) {
            throw new IllegalArgumentException("BOOLEAN value should have 1 byte in it");
        }
        byte b = bArr[0];
        return b != -1 ? b != 0 ? new qp0(b) : f6065P : f6066Q;
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return m7774u() ? 1 : 0;
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        return (eq0Var instanceof qp0) && m7774u() == ((qp0) eq0Var).m7774u();
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2964j(z, 1, this.f6067O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        return 3;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return m7774u() ? f6066Q : f6065P;
    }

    public String toString() {
        return m7774u() ? "TRUE" : "FALSE";
    }

    /* renamed from: u */
    public boolean m7774u() {
        return this.f6067O != 0;
    }
}
