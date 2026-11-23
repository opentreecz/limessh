package cz.opentree;

import org.bouncycastle.crypto.digests.EncodableDigest;

/* loaded from: classes.dex */
public class qt0 extends lt0 implements EncodableDigest {

    /* renamed from: n */
    public static final int[] f6094n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: d */
    public int f6095d;

    /* renamed from: e */
    public int f6096e;

    /* renamed from: f */
    public int f6097f;

    /* renamed from: g */
    public int f6098g;

    /* renamed from: h */
    public int f6099h;

    /* renamed from: i */
    public int f6100i;

    /* renamed from: j */
    public int f6101j;

    /* renamed from: k */
    public int f6102k;

    /* renamed from: l */
    public int[] f6103l = new int[64];

    /* renamed from: m */
    public int f6104m;

    public qt0() {
        mo6299k();
    }

    /* renamed from: l */
    public static int m7786l(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    /* renamed from: m */
    public static int m7787m(int i, int i2, int i3) {
        return ((i ^ i2) & i3) | (i & i2);
    }

    /* renamed from: n */
    public static int m7788n(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    /* renamed from: o */
    public static int m7789o(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    /* renamed from: p */
    public static int m7790p(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    /* renamed from: q */
    public static int m7791q(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: b */
    public int mo7096b(byte[] bArr, int i) {
        m6295g();
        h51.m4367c(this.f6095d, bArr, i);
        h51.m4367c(this.f6096e, bArr, i + 4);
        h51.m4367c(this.f6097f, bArr, i + 8);
        h51.m4367c(this.f6098g, bArr, i + 12);
        h51.m4367c(this.f6099h, bArr, i + 16);
        h51.m4367c(this.f6100i, bArr, i + 20);
        h51.m4367c(this.f6101j, bArr, i + 24);
        h51.m4367c(this.f6102k, bArr, i + 28);
        mo6299k();
        return 32;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHA-256";
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return 32;
    }

    @Override // cz.opentree.lt0
    /* renamed from: h */
    public void mo6296h() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f6103l;
            int m7791q = m7791q(iArr[i - 2]);
            int[] iArr2 = this.f6103l;
            iArr[i] = m7791q + iArr2[i - 7] + m7790p(iArr2[i - 15]) + this.f6103l[i - 16];
        }
        int i2 = this.f6095d;
        int i3 = this.f6096e;
        int i4 = this.f6097f;
        int i5 = this.f6098g;
        int i6 = this.f6099h;
        int i7 = this.f6100i;
        int i8 = this.f6101j;
        int i9 = this.f6102k;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int m7789o = m7789o(i6) + m7786l(i6, i7, i8);
            int[] iArr3 = f6094n;
            int i12 = i9 + m7789o + iArr3[i10] + this.f6103l[i10];
            int i13 = i5 + i12;
            int m7788n = i12 + m7788n(i2) + m7787m(i2, i3, i4);
            int i14 = i10 + 1;
            int m7789o2 = i8 + m7789o(i13) + m7786l(i13, i6, i7) + iArr3[i14] + this.f6103l[i14];
            int i15 = i4 + m7789o2;
            int m7788n2 = m7789o2 + m7788n(m7788n) + m7787m(m7788n, i2, i3);
            int i16 = i14 + 1;
            int m7789o3 = i7 + m7789o(i15) + m7786l(i15, i13, i6) + iArr3[i16] + this.f6103l[i16];
            int i17 = i3 + m7789o3;
            int m7788n3 = m7789o3 + m7788n(m7788n2) + m7787m(m7788n2, m7788n, i2);
            int i18 = i16 + 1;
            int m7789o4 = i6 + m7789o(i17) + m7786l(i17, i15, i13) + iArr3[i18] + this.f6103l[i18];
            int i19 = i2 + m7789o4;
            int m7788n4 = m7789o4 + m7788n(m7788n3) + m7787m(m7788n3, m7788n2, m7788n);
            int i20 = i18 + 1;
            int m7789o5 = i13 + m7789o(i19) + m7786l(i19, i17, i15) + iArr3[i20] + this.f6103l[i20];
            i9 = m7788n + m7789o5;
            i5 = m7789o5 + m7788n(m7788n4) + m7787m(m7788n4, m7788n3, m7788n2);
            int i21 = i20 + 1;
            int m7789o6 = i15 + m7789o(i9) + m7786l(i9, i19, i17) + iArr3[i21] + this.f6103l[i21];
            i8 = m7788n2 + m7789o6;
            i4 = m7789o6 + m7788n(i5) + m7787m(i5, m7788n4, m7788n3);
            int i22 = i21 + 1;
            int m7789o7 = i17 + m7789o(i8) + m7786l(i8, i9, i19) + iArr3[i22] + this.f6103l[i22];
            i7 = m7788n3 + m7789o7;
            i3 = m7789o7 + m7788n(i4) + m7787m(i4, i5, m7788n4);
            int i23 = i22 + 1;
            int m7789o8 = i19 + m7789o(i7) + m7786l(i7, i8, i9) + iArr3[i23] + this.f6103l[i23];
            i6 = m7788n4 + m7789o8;
            i2 = m7789o8 + m7788n(i3) + m7787m(i3, i4, i5);
            i10 = i23 + 1;
        }
        this.f6095d += i2;
        this.f6096e += i3;
        this.f6097f += i4;
        this.f6098g += i5;
        this.f6099h += i6;
        this.f6100i += i7;
        this.f6101j += i8;
        this.f6102k += i9;
        this.f6104m = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            this.f6103l[i24] = 0;
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: i */
    public void mo6297i(long j) {
        if (this.f6104m > 14) {
            mo6296h();
        }
        int[] iArr = this.f6103l;
        iArr[14] = (int) (j >>> 32);
        iArr[15] = (int) (j & (-1));
    }

    @Override // cz.opentree.lt0
    /* renamed from: j */
    public void mo6298j(byte[] bArr, int i) {
        int i2 = bArr[i] << 24;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = i3 + 1;
        int i6 = (bArr[i5 + 1] & 255) | i4 | ((bArr[i5] & 255) << 8);
        int[] iArr = this.f6103l;
        int i7 = this.f6104m;
        iArr[i7] = i6;
        int i8 = i7 + 1;
        this.f6104m = i8;
        if (i8 == 16) {
            mo6296h();
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: k */
    public void mo6299k() {
        super.mo6299k();
        this.f6095d = 1779033703;
        this.f6096e = -1150833019;
        this.f6097f = 1013904242;
        this.f6098g = -1521486534;
        this.f6099h = 1359893119;
        this.f6100i = -1694144372;
        this.f6101j = 528734635;
        this.f6102k = 1541459225;
        this.f6104m = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f6103l;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }
}
