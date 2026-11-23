package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;

/* loaded from: classes.dex */
public class xq0 extends pp0 {
    public xq0(ASN1Encodable aSN1Encodable) throws IOException {
        super(aSN1Encodable.mo1950f().m10587j("DER"), 0);
    }

    public xq0(byte[] bArr) {
        this(bArr, 0);
    }

    public xq0(byte[] bArr, int i) {
        super(bArr, i);
    }

    /* renamed from: A */
    public static xq0 m9873A(byte[] bArr) {
        if (bArr.length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        byte b = bArr[0];
        int length = bArr.length - 1;
        byte[] bArr2 = new byte[length];
        if (length != 0) {
            System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
        }
        return new xq0(bArr2, b);
    }

    /* renamed from: B */
    public static xq0 m9874B(Object obj) {
        if (obj == null || (obj instanceof xq0)) {
            return (xq0) obj;
        }
        if (obj instanceof vr0) {
            vr0 vr0Var = (vr0) obj;
            return new xq0(vr0Var.f5756O, vr0Var.f5757P);
        }
        if (!(obj instanceof byte[])) {
            throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
        }
        try {
            return (xq0) eq0.m3546p((byte[]) obj);
        } catch (Exception e) {
            throw new IllegalArgumentException("encoding error in getInstance: " + e.toString());
        }
    }

    /* renamed from: C */
    public static xq0 m9875C(iq0 iq0Var, boolean z) {
        eq0 m4910u = iq0Var.m4910u();
        return (z || (m4910u instanceof xq0)) ? m9874B(m4910u) : m9873A(bq0.m2592t(m4910u).m2598v());
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        int i;
        byte[] bArr = this.f5756O;
        int length = bArr.length;
        if (length != 0 && (i = this.f5757P) != 0) {
            int i2 = length - 1;
            if (bArr[i2] != ((byte) (bArr[i2] & (255 << i)))) {
                cq0Var.m2966l(z, 3, (byte) i, bArr, 0, i2, (byte) (bArr[i2] & (255 << i)));
                return;
            }
        }
        cq0Var.m2965k(z, 3, (byte) this.f5757P, bArr);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f5756O.length + 1) + 1 + this.f5756O.length + 1;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    @Override // cz.opentree.pp0, cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return this;
    }

    @Override // cz.opentree.pp0, cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return this;
    }
}
