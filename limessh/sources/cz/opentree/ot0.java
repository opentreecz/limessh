package cz.opentree;

import org.bouncycastle.crypto.digests.EncodableDigest;

/* loaded from: classes.dex */
public class ot0 extends lt0 implements EncodableDigest {

    /* renamed from: d */
    public int f5547d;

    /* renamed from: e */
    public int f5548e;

    /* renamed from: f */
    public int f5549f;

    /* renamed from: g */
    public int f5550g;

    /* renamed from: h */
    public int f5551h;

    /* renamed from: i */
    public int[] f5552i = new int[80];

    /* renamed from: j */
    public int f5553j;

    public ot0() {
        mo6299k();
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: b */
    public int mo7096b(byte[] bArr, int i) {
        m6295g();
        h51.m4367c(this.f5547d, bArr, i);
        h51.m4367c(this.f5548e, bArr, i + 4);
        h51.m4367c(this.f5549f, bArr, i + 8);
        h51.m4367c(this.f5550g, bArr, i + 12);
        h51.m4367c(this.f5551h, bArr, i + 16);
        mo6299k();
        return 20;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHA-1";
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return 20;
    }

    @Override // cz.opentree.lt0
    /* renamed from: h */
    public void mo6296h() {
        for (int i = 16; i < 80; i++) {
            int[] iArr = this.f5552i;
            int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
            iArr[i] = (i2 >>> 31) | (i2 << 1);
        }
        int i3 = this.f5547d;
        int i4 = this.f5548e;
        int i5 = this.f5549f;
        int i6 = this.f5550g;
        int i7 = this.f5551h;
        int i8 = 0;
        int i9 = 0;
        while (i8 < 4) {
            int i10 = i9 + 1;
            int m7098l = i7 + ((i3 << 5) | (i3 >>> 27)) + m7098l(i4, i5, i6) + this.f5552i[i9] + 1518500249;
            int i11 = (i4 >>> 2) | (i4 << 30);
            int i12 = i10 + 1;
            int m7098l2 = i6 + ((m7098l << 5) | (m7098l >>> 27)) + m7098l(i3, i11, i5) + this.f5552i[i10] + 1518500249;
            int i13 = (i3 >>> 2) | (i3 << 30);
            int i14 = i12 + 1;
            int m7098l3 = i5 + ((m7098l2 << 5) | (m7098l2 >>> 27)) + m7098l(m7098l, i13, i11) + this.f5552i[i12] + 1518500249;
            i7 = (m7098l >>> 2) | (m7098l << 30);
            int i15 = i14 + 1;
            i4 = i11 + ((m7098l3 << 5) | (m7098l3 >>> 27)) + m7098l(m7098l2, i7, i13) + this.f5552i[i14] + 1518500249;
            i6 = (m7098l2 >>> 2) | (m7098l2 << 30);
            i3 = i13 + ((i4 << 5) | (i4 >>> 27)) + m7098l(m7098l3, i6, i7) + this.f5552i[i15] + 1518500249;
            i5 = (m7098l3 >>> 2) | (m7098l3 << 30);
            i8++;
            i9 = i15 + 1;
        }
        int i16 = 0;
        while (i16 < 4) {
            int i17 = i9 + 1;
            int m7100n = i7 + ((i3 << 5) | (i3 >>> 27)) + m7100n(i4, i5, i6) + this.f5552i[i9] + 1859775393;
            int i18 = (i4 >>> 2) | (i4 << 30);
            int i19 = i17 + 1;
            int m7100n2 = i6 + ((m7100n << 5) | (m7100n >>> 27)) + m7100n(i3, i18, i5) + this.f5552i[i17] + 1859775393;
            int i20 = (i3 >>> 2) | (i3 << 30);
            int i21 = i19 + 1;
            int m7100n3 = i5 + ((m7100n2 << 5) | (m7100n2 >>> 27)) + m7100n(m7100n, i20, i18) + this.f5552i[i19] + 1859775393;
            i7 = (m7100n >>> 2) | (m7100n << 30);
            int i22 = i21 + 1;
            i4 = i18 + ((m7100n3 << 5) | (m7100n3 >>> 27)) + m7100n(m7100n2, i7, i20) + this.f5552i[i21] + 1859775393;
            i6 = (m7100n2 >>> 2) | (m7100n2 << 30);
            i3 = i20 + ((i4 << 5) | (i4 >>> 27)) + m7100n(m7100n3, i6, i7) + this.f5552i[i22] + 1859775393;
            i5 = (m7100n3 >>> 2) | (m7100n3 << 30);
            i16++;
            i9 = i22 + 1;
        }
        int i23 = 0;
        while (i23 < 4) {
            int m7099m = i7 + (((((i3 << 5) | (i3 >>> 27)) + m7099m(i4, i5, i6)) + this.f5552i[i9]) - 1894007588);
            int m7099m2 = i6 + (((((m7099m << 5) | (m7099m >>> 27)) + m7099m(i3, r2, i5)) + this.f5552i[r12]) - 1894007588);
            int m7099m3 = i5 + (((((m7099m2 << 5) | (m7099m2 >>> 27)) + m7099m(m7099m, r1, r2)) + this.f5552i[r13]) - 1894007588);
            i7 = (m7099m >>> 2) | (m7099m << 30);
            i4 = ((i4 >>> 2) | (i4 << 30)) + (((((m7099m3 << 5) | (m7099m3 >>> 27)) + m7099m(m7099m2, i7, r1)) + this.f5552i[r12]) - 1894007588);
            i6 = (m7099m2 >>> 2) | (m7099m2 << 30);
            i3 = ((i3 >>> 2) | (i3 << 30)) + (((((i4 << 5) | (i4 >>> 27)) + m7099m(m7099m3, i6, i7)) + this.f5552i[r13]) - 1894007588);
            i5 = (m7099m3 >>> 2) | (m7099m3 << 30);
            i23++;
            i9 = i9 + 1 + 1 + 1 + 1 + 1;
        }
        int i24 = 0;
        while (i24 <= 3) {
            int m7100n4 = i7 + (((((i3 << 5) | (i3 >>> 27)) + m7100n(i4, i5, i6)) + this.f5552i[i9]) - 899497514);
            int m7100n5 = i6 + (((((m7100n4 << 5) | (m7100n4 >>> 27)) + m7100n(i3, r2, i5)) + this.f5552i[r11]) - 899497514);
            int m7100n6 = i5 + (((((m7100n5 << 5) | (m7100n5 >>> 27)) + m7100n(m7100n4, r1, r2)) + this.f5552i[r12]) - 899497514);
            i7 = (m7100n4 >>> 2) | (m7100n4 << 30);
            i4 = ((i4 >>> 2) | (i4 << 30)) + (((((m7100n6 << 5) | (m7100n6 >>> 27)) + m7100n(m7100n5, i7, r1)) + this.f5552i[r11]) - 899497514);
            i6 = (m7100n5 >>> 2) | (m7100n5 << 30);
            i3 = ((i3 >>> 2) | (i3 << 30)) + (((((i4 << 5) | (i4 >>> 27)) + m7100n(m7100n6, i6, i7)) + this.f5552i[r12]) - 899497514);
            i5 = (m7100n6 >>> 2) | (m7100n6 << 30);
            i24++;
            i9 = i9 + 1 + 1 + 1 + 1 + 1;
        }
        this.f5547d += i3;
        this.f5548e += i4;
        this.f5549f += i5;
        this.f5550g += i6;
        this.f5551h += i7;
        this.f5553j = 0;
        for (int i25 = 0; i25 < 16; i25++) {
            this.f5552i[i25] = 0;
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: i */
    public void mo6297i(long j) {
        if (this.f5553j > 14) {
            mo6296h();
        }
        int[] iArr = this.f5552i;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) j;
    }

    @Override // cz.opentree.lt0
    /* renamed from: j */
    public void mo6298j(byte[] bArr, int i) {
        int i2 = bArr[i] << 24;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = i3 + 1;
        int i6 = (bArr[i5 + 1] & 255) | i4 | ((bArr[i5] & 255) << 8);
        int[] iArr = this.f5552i;
        int i7 = this.f5553j;
        iArr[i7] = i6;
        int i8 = i7 + 1;
        this.f5553j = i8;
        if (i8 == 16) {
            mo6296h();
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: k */
    public void mo6299k() {
        super.mo6299k();
        this.f5547d = 1732584193;
        this.f5548e = -271733879;
        this.f5549f = -1732584194;
        this.f5550g = 271733878;
        this.f5551h = -1009589776;
        this.f5553j = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5552i;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    /* renamed from: l */
    public final int m7098l(int i, int i2, int i3) {
        return ((~i) & i3) | (i2 & i);
    }

    /* renamed from: m */
    public final int m7099m(int i, int i2, int i3) {
        return (i & i3) | (i & i2) | (i2 & i3);
    }

    /* renamed from: n */
    public final int m7100n(int i, int i2, int i3) {
        return (i ^ i2) ^ i3;
    }
}
