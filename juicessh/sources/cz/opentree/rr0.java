package cz.opentree;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class rr0 extends eq0 implements ASN1String {

    /* renamed from: P */
    public static final char[] f6276P = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: O */
    public final byte[] f6277O;

    public rr0(byte[] bArr) {
        this.f6277O = e51.m3436e(bArr);
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        return e51.m3445n(this.f6277O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof rr0) {
            return e51.m3432a(this.f6277O, ((rr0) eq0Var).f6277O);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        cq0Var.m2968n(z, 28, this.f6277O);
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f6277O.length) + 1 + this.f6277O.length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m8230t() {
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            byte[] encoded = getEncoded();
            for (int i = 0; i != encoded.length; i++) {
                char[] cArr = f6276P;
                stringBuffer.append(cArr[(encoded[i] >>> 4) & 15]);
                stringBuffer.append(cArr[encoded[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException unused) {
            throw new dq0("internal error encoding UniversalString");
        }
    }

    public String toString() {
        return m8230t();
    }
}
