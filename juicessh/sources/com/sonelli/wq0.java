package com.sonelli;

import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public class wq0 extends eq0 implements ASN1String {

    /* renamed from: O */
    public final char[] f7787O;

    public wq0(char[] cArr) {
        Objects.requireNonNull(cArr, "'string' cannot be null");
        this.f7787O = cArr;
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        return e51.m3447p(this.f7787O);
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (eq0Var instanceof wq0) {
            return e51.m3433b(this.f7787O, ((wq0) eq0Var).f7787O);
        }
        return false;
    }

    @Override // com.sonelli.eq0
    /* renamed from: m */
    public void mo2260m(cq0 cq0Var, boolean z) throws IOException {
        int length = this.f7787O.length;
        if (z) {
            cq0Var.m2960f(30);
        }
        cq0Var.m2972r(length * 2);
        byte[] bArr = new byte[8];
        int i = length & (-4);
        int i2 = 0;
        while (i2 < i) {
            char[] cArr = this.f7787O;
            char c = cArr[i2];
            char c2 = cArr[i2 + 1];
            char c3 = cArr[i2 + 2];
            char c4 = cArr[i2 + 3];
            i2 += 4;
            bArr[0] = (byte) (c >> '\b');
            bArr[1] = (byte) c;
            bArr[2] = (byte) (c2 >> '\b');
            bArr[3] = (byte) c2;
            bArr[4] = (byte) (c3 >> '\b');
            bArr[5] = (byte) c3;
            bArr[6] = (byte) (c4 >> '\b');
            bArr[7] = (byte) c4;
            cq0Var.m2961g(bArr, 0, 8);
        }
        if (i2 < length) {
            int i3 = 0;
            do {
                char c5 = this.f7787O[i2];
                i2++;
                int i4 = i3 + 1;
                bArr[i3] = (byte) (c5 >> '\b');
                i3 = i4 + 1;
                bArr[i4] = (byte) c5;
            } while (i2 < length);
            cq0Var.m2961g(bArr, 0, i3);
        }
    }

    @Override // com.sonelli.eq0
    /* renamed from: n */
    public int mo2261n() {
        return ks0.m5992a(this.f7787O.length * 2) + 1 + (this.f7787O.length * 2);
    }

    @Override // com.sonelli.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return false;
    }

    /* renamed from: t */
    public String m9631t() {
        return new String(this.f7787O);
    }

    public String toString() {
        return m9631t();
    }
}
