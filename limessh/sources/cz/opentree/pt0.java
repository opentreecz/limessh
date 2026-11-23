package cz.opentree;

import org.bouncycastle.crypto.digests.EncodableDigest;

/* loaded from: classes.dex */
public class pt0 extends lt0 implements EncodableDigest {

    /* renamed from: n */
    public static final int[] f5767n = {1116352408, 1899447441, -1245643825, -373957723, 961987163, 1508970993, -1841331548, -1424204075, -670586216, 310598401, 607225278, 1426881987, 1925078388, -2132889090, -1680079193, -1046744716, -459576895, -272742522, 264347078, 604807628, 770255983, 1249150122, 1555081692, 1996064986, -1740746414, -1473132947, -1341970488, -1084653625, -958395405, -710438585, 113926993, 338241895, 666307205, 773529912, 1294757372, 1396182291, 1695183700, 1986661051, -2117940946, -1838011259, -1564481375, -1474664885, -1035236496, -949202525, -778901479, -694614492, -200395387, 275423344, 430227734, 506948616, 659060556, 883997877, 958139571, 1322822218, 1537002063, 1747873779, 1955562222, 2024104815, -2067236844, -1933114872, -1866530822, -1538233109, -1090935817, -965641998};

    /* renamed from: d */
    public int f5768d;

    /* renamed from: e */
    public int f5769e;

    /* renamed from: f */
    public int f5770f;

    /* renamed from: g */
    public int f5771g;

    /* renamed from: h */
    public int f5772h;

    /* renamed from: i */
    public int f5773i;

    /* renamed from: j */
    public int f5774j;

    /* renamed from: k */
    public int f5775k;

    /* renamed from: l */
    public int[] f5776l = new int[64];

    /* renamed from: m */
    public int f5777m;

    public pt0() {
        mo6299k();
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: b */
    public int mo7096b(byte[] bArr, int i) {
        m6295g();
        h51.m4367c(this.f5768d, bArr, i);
        h51.m4367c(this.f5769e, bArr, i + 4);
        h51.m4367c(this.f5770f, bArr, i + 8);
        h51.m4367c(this.f5771g, bArr, i + 12);
        h51.m4367c(this.f5772h, bArr, i + 16);
        h51.m4367c(this.f5773i, bArr, i + 20);
        h51.m4367c(this.f5774j, bArr, i + 24);
        mo6299k();
        return 28;
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: e */
    public String mo7097e() {
        return "SHA-224";
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return 28;
    }

    @Override // cz.opentree.lt0
    /* renamed from: h */
    public void mo6296h() {
        for (int i = 16; i <= 63; i++) {
            int[] iArr = this.f5776l;
            int m7451q = m7451q(iArr[i - 2]);
            int[] iArr2 = this.f5776l;
            iArr[i] = m7451q + iArr2[i - 7] + m7450p(iArr2[i - 15]) + this.f5776l[i - 16];
        }
        int i2 = this.f5768d;
        int i3 = this.f5769e;
        int i4 = this.f5770f;
        int i5 = this.f5771g;
        int i6 = this.f5772h;
        int i7 = this.f5773i;
        int i8 = this.f5774j;
        int i9 = this.f5775k;
        int i10 = 0;
        for (int i11 = 0; i11 < 8; i11++) {
            int m7449o = m7449o(i6) + m7446l(i6, i7, i8);
            int[] iArr3 = f5767n;
            int i12 = i9 + m7449o + iArr3[i10] + this.f5776l[i10];
            int i13 = i5 + i12;
            int m7448n = i12 + m7448n(i2) + m7447m(i2, i3, i4);
            int i14 = i10 + 1;
            int m7449o2 = i8 + m7449o(i13) + m7446l(i13, i6, i7) + iArr3[i14] + this.f5776l[i14];
            int i15 = i4 + m7449o2;
            int m7448n2 = m7449o2 + m7448n(m7448n) + m7447m(m7448n, i2, i3);
            int i16 = i14 + 1;
            int m7449o3 = i7 + m7449o(i15) + m7446l(i15, i13, i6) + iArr3[i16] + this.f5776l[i16];
            int i17 = i3 + m7449o3;
            int m7448n3 = m7449o3 + m7448n(m7448n2) + m7447m(m7448n2, m7448n, i2);
            int i18 = i16 + 1;
            int m7449o4 = i6 + m7449o(i17) + m7446l(i17, i15, i13) + iArr3[i18] + this.f5776l[i18];
            int i19 = i2 + m7449o4;
            int m7448n4 = m7449o4 + m7448n(m7448n3) + m7447m(m7448n3, m7448n2, m7448n);
            int i20 = i18 + 1;
            int m7449o5 = i13 + m7449o(i19) + m7446l(i19, i17, i15) + iArr3[i20] + this.f5776l[i20];
            i9 = m7448n + m7449o5;
            i5 = m7449o5 + m7448n(m7448n4) + m7447m(m7448n4, m7448n3, m7448n2);
            int i21 = i20 + 1;
            int m7449o6 = i15 + m7449o(i9) + m7446l(i9, i19, i17) + iArr3[i21] + this.f5776l[i21];
            i8 = m7448n2 + m7449o6;
            i4 = m7449o6 + m7448n(i5) + m7447m(i5, m7448n4, m7448n3);
            int i22 = i21 + 1;
            int m7449o7 = i17 + m7449o(i8) + m7446l(i8, i9, i19) + iArr3[i22] + this.f5776l[i22];
            i7 = m7448n3 + m7449o7;
            i3 = m7449o7 + m7448n(i4) + m7447m(i4, i5, m7448n4);
            int i23 = i22 + 1;
            int m7449o8 = i19 + m7449o(i7) + m7446l(i7, i8, i9) + iArr3[i23] + this.f5776l[i23];
            i6 = m7448n4 + m7449o8;
            i2 = m7449o8 + m7448n(i3) + m7447m(i3, i4, i5);
            i10 = i23 + 1;
        }
        this.f5768d += i2;
        this.f5769e += i3;
        this.f5770f += i4;
        this.f5771g += i5;
        this.f5772h += i6;
        this.f5773i += i7;
        this.f5774j += i8;
        this.f5775k += i9;
        this.f5777m = 0;
        for (int i24 = 0; i24 < 16; i24++) {
            this.f5776l[i24] = 0;
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: i */
    public void mo6297i(long j) {
        if (this.f5777m > 14) {
            mo6296h();
        }
        int[] iArr = this.f5776l;
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
        int[] iArr = this.f5776l;
        int i7 = this.f5777m;
        iArr[i7] = i6;
        int i8 = i7 + 1;
        this.f5777m = i8;
        if (i8 == 16) {
            mo6296h();
        }
    }

    @Override // cz.opentree.lt0
    /* renamed from: k */
    public void mo6299k() {
        super.mo6299k();
        this.f5768d = -1056596264;
        this.f5769e = 914150663;
        this.f5770f = 812702999;
        this.f5771g = -150054599;
        this.f5772h = -4191439;
        this.f5773i = 1750603025;
        this.f5774j = 1694076839;
        this.f5775k = -1090891868;
        this.f5777m = 0;
        int i = 0;
        while (true) {
            int[] iArr = this.f5776l;
            if (i == iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    /* renamed from: l */
    public final int m7446l(int i, int i2, int i3) {
        return ((~i) & i3) ^ (i2 & i);
    }

    /* renamed from: m */
    public final int m7447m(int i, int i2, int i3) {
        return ((i & i3) ^ (i & i2)) ^ (i2 & i3);
    }

    /* renamed from: n */
    public final int m7448n(int i) {
        return ((i << 10) | (i >>> 22)) ^ (((i >>> 2) | (i << 30)) ^ ((i >>> 13) | (i << 19)));
    }

    /* renamed from: o */
    public final int m7449o(int i) {
        return ((i << 7) | (i >>> 25)) ^ (((i >>> 6) | (i << 26)) ^ ((i >>> 11) | (i << 21)));
    }

    /* renamed from: p */
    public final int m7450p(int i) {
        return (i >>> 3) ^ (((i >>> 7) | (i << 25)) ^ ((i >>> 18) | (i << 14)));
    }

    /* renamed from: q */
    public final int m7451q(int i) {
        return (i >>> 10) ^ (((i >>> 17) | (i << 15)) ^ ((i >>> 19) | (i << 13)));
    }
}
