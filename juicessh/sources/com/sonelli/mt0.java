package com.sonelli;

import org.bouncycastle.crypto.ExtendedDigest;

/* loaded from: classes.dex */
public class mt0 implements ExtendedDigest {

    /* renamed from: g */
    public static long[] f5139g = {1, 32898, -9223372036854742902L, -9223372034707259392L, 32907, 2147483649L, -9223372034707259263L, -9223372036854743031L, 138, 136, 2147516425L, 2147483658L, 2147516555L, -9223372036854775669L, -9223372036854742903L, -9223372036854743037L, -9223372036854743038L, -9223372036854775680L, 32778, -9223372034707292150L, -9223372034707259263L, -9223372036854742912L, 2147483649L, -9223372034707259384L};

    /* renamed from: a */
    public long[] f5140a = new long[25];

    /* renamed from: b */
    public byte[] f5141b = new byte[192];

    /* renamed from: c */
    public int f5142c;

    /* renamed from: d */
    public int f5143d;

    /* renamed from: e */
    public int f5144e;

    /* renamed from: f */
    public boolean f5145f;

    public mt0(int i) {
        m6525l(i);
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: a */
    public void mo6293a(byte[] bArr, int i, int i2) {
        m6523j(bArr, i, i2);
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: c */
    public void mo6294c(byte b) {
        m6523j(new byte[]{b}, 0, 1);
    }

    @Override // org.bouncycastle.crypto.Digest
    /* renamed from: f */
    public int mo6519f() {
        return this.f5144e / 8;
    }

    /* renamed from: g */
    public final void m6520g(byte[] bArr, int i) {
        int i2 = this.f5142c >> 6;
        for (int i3 = 0; i3 < i2; i3++) {
            long[] jArr = this.f5140a;
            jArr[i3] = jArr[i3] ^ h51.m4370f(bArr, i);
            i += 8;
        }
        m6522i();
    }

    /* renamed from: h */
    public final void m6521h() {
        h51.m4374j(this.f5140a, 0, this.f5142c >> 6, this.f5141b, 0);
    }

    /* renamed from: i */
    public final void m6522i() {
        long[] jArr = this.f5140a;
        int i = 0;
        long j = jArr[0];
        char c = 1;
        long j2 = jArr[1];
        long j3 = jArr[2];
        char c2 = 3;
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = jArr[9];
        long j11 = jArr[10];
        long j12 = jArr[11];
        long j13 = jArr[12];
        long j14 = jArr[13];
        long j15 = jArr[14];
        long j16 = jArr[15];
        long j17 = jArr[16];
        long j18 = jArr[17];
        long j19 = jArr[18];
        long j20 = jArr[19];
        long j21 = jArr[20];
        long j22 = jArr[21];
        long j23 = jArr[22];
        long j24 = jArr[23];
        int i2 = 24;
        long j25 = jArr[24];
        while (i < i2) {
            long j26 = (((j ^ j6) ^ j11) ^ j16) ^ j21;
            long j27 = (((j2 ^ j7) ^ j12) ^ j17) ^ j22;
            long j28 = (((j3 ^ j8) ^ j13) ^ j18) ^ j23;
            long j29 = (((j4 ^ j9) ^ j14) ^ j19) ^ j24;
            long j30 = (((j5 ^ j10) ^ j15) ^ j20) ^ j25;
            long j31 = ((j27 << c) | (j27 >>> (-1))) ^ j30;
            long j32 = ((j28 << c) | (j28 >>> (-1))) ^ j26;
            long j33 = ((j29 << c) | (j29 >>> (-1))) ^ j27;
            long j34 = ((j30 << c) | (j30 >>> (-1))) ^ j28;
            long j35 = ((j26 << c) | (j26 >>> (-1))) ^ j29;
            long j36 = j ^ j31;
            long j37 = j6 ^ j31;
            long j38 = j11 ^ j31;
            long j39 = j16 ^ j31;
            long j40 = j21 ^ j31;
            long j41 = j2 ^ j32;
            long j42 = j7 ^ j32;
            long j43 = j12 ^ j32;
            long j44 = j17 ^ j32;
            long j45 = j22 ^ j32;
            long j46 = j3 ^ j33;
            long j47 = j8 ^ j33;
            long j48 = j13 ^ j33;
            long j49 = j18 ^ j33;
            long j50 = j23 ^ j33;
            long j51 = j4 ^ j34;
            long j52 = j9 ^ j34;
            long j53 = j14 ^ j34;
            long j54 = j19 ^ j34;
            long j55 = j24 ^ j34;
            long j56 = j5 ^ j35;
            long j57 = j10 ^ j35;
            long j58 = j15 ^ j35;
            long j59 = j20 ^ j35;
            long j60 = j25 ^ j35;
            long j61 = (j41 << c) | (j41 >>> 63);
            long j62 = (j42 << 44) | (j42 >>> 20);
            long j63 = (j57 << 20) | (j57 >>> 44);
            long j64 = (j50 << 61) | (j50 >>> c2);
            long j65 = (j58 << 39) | (j58 >>> 25);
            long j66 = (j40 << 18) | (j40 >>> 46);
            long j67 = (j46 << 62) | (j46 >>> 2);
            long j68 = (j48 << 43) | (j48 >>> 21);
            long j69 = (j53 << 25) | (j53 >>> 39);
            long j70 = (j59 << 8) | (j59 >>> 56);
            long j71 = (j55 << 56) | (j55 >>> 8);
            long j72 = (j39 << 41) | (j39 >>> 23);
            long j73 = (j56 << 27) | (j56 >>> 37);
            long j74 = (j60 << 14) | (j60 >>> 50);
            long j75 = (j45 << 2) | (j45 >>> 62);
            long j76 = (j52 << 55) | (j52 >>> 9);
            long j77 = (j44 << 45) | (j44 >>> 19);
            long j78 = (j37 << 36) | (j37 >>> 28);
            long j79 = (j51 << 28) | (j51 >>> 36);
            long j80 = (j54 << 21) | (j54 >>> 43);
            long j81 = (j49 << 15) | (j49 >>> 49);
            long j82 = (j43 << 10) | (j43 >>> 54);
            long j83 = (j47 << 6) | (j47 >>> 58);
            long j84 = (j38 << 3) | (j38 >>> 61);
            long j85 = ((~j62) & j68) ^ j36;
            long j86 = ((~j68) & j80) ^ j62;
            j3 = j68 ^ ((~j80) & j74);
            j4 = j80 ^ ((~j74) & j36);
            long j87 = j74 ^ ((~j36) & j62);
            long j88 = j79 ^ ((~j63) & j84);
            long j89 = ((~j84) & j77) ^ j63;
            long j90 = ((~j77) & j64) ^ j84;
            long j91 = j77 ^ ((~j64) & j79);
            long j92 = ((~j79) & j63) ^ j64;
            j11 = j61 ^ ((~j83) & j69);
            long j93 = ((~j69) & j70) ^ j83;
            long j94 = ((~j70) & j66) ^ j69;
            long j95 = j70 ^ ((~j66) & j61);
            long j96 = ((~j61) & j83) ^ j66;
            long j97 = j73 ^ ((~j78) & j82);
            long j98 = ((~j82) & j81) ^ j78;
            long j99 = j82 ^ ((~j81) & j71);
            long j100 = ((~j71) & j73) ^ j81;
            long j101 = ((~j73) & j78) ^ j71;
            long j102 = j67 ^ ((~j76) & j65);
            long j103 = ((~j65) & j72) ^ j76;
            j21 = j102;
            long j104 = j65 ^ ((~j72) & j75);
            long j105 = ((~j75) & j67) ^ j72;
            long j106 = ((~j67) & j76) ^ j75;
            long j107 = j85 ^ f5139g[i];
            i++;
            j7 = j89;
            j13 = j94;
            j12 = j93;
            j14 = j95;
            j22 = j103;
            c2 = 3;
            j24 = j105;
            j23 = j104;
            j10 = j92;
            jArr = jArr;
            j20 = j101;
            j15 = j96;
            j8 = j90;
            j9 = j91;
            j18 = j99;
            j16 = j97;
            j5 = j87;
            j6 = j88;
            i2 = 24;
            j19 = j100;
            j17 = j98;
            c = 1;
            j2 = j86;
            j25 = j106;
            j = j107;
        }
        long[] jArr2 = jArr;
        jArr2[0] = j;
        jArr2[1] = j2;
        jArr2[2] = j3;
        jArr2[3] = j4;
        jArr2[4] = j5;
        jArr2[5] = j6;
        jArr2[6] = j7;
        jArr2[7] = j8;
        jArr2[8] = j9;
        jArr2[9] = j10;
        jArr2[10] = j11;
        jArr2[11] = j12;
        jArr2[12] = j13;
        jArr2[13] = j14;
        jArr2[14] = j15;
        jArr2[15] = j16;
        jArr2[16] = j17;
        jArr2[17] = j18;
        jArr2[18] = j19;
        jArr2[19] = j20;
        jArr2[20] = j21;
        jArr2[21] = j22;
        jArr2[22] = j23;
        jArr2[23] = j24;
        jArr2[24] = j25;
    }

    /* renamed from: j */
    public void m6523j(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = this.f5143d;
        if (i4 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f5145f) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        int i5 = i4 >> 3;
        int i6 = this.f5142c >> 3;
        int i7 = 0;
        while (i7 < i2) {
            if (i5 != 0 || i7 > (i3 = i2 - i6)) {
                int min = Math.min(i6 - i5, i2 - i7);
                System.arraycopy(bArr, i + i7, this.f5141b, i5, min);
                i5 += min;
                i7 += min;
                if (i5 == i6) {
                    m6520g(this.f5141b, 0);
                    i5 = 0;
                }
            } else {
                do {
                    m6520g(bArr, i + i7);
                    i7 += i6;
                } while (i7 <= i3);
            }
        }
        this.f5143d = i5 << 3;
    }

    /* renamed from: k */
    public void m6524k(int i, int i2) {
        if (i2 < 1 || i2 > 7) {
            throw new IllegalArgumentException("'bits' must be in the range 1 to 7");
        }
        int i3 = this.f5143d;
        if (i3 % 8 != 0) {
            throw new IllegalStateException("attempt to absorb with odd length queue");
        }
        if (this.f5145f) {
            throw new IllegalStateException("attempt to absorb while squeezing");
        }
        this.f5141b[i3 >> 3] = (byte) (i & ((1 << i2) - 1));
        this.f5143d = i3 + i2;
    }

    /* renamed from: l */
    public final void m6525l(int i) {
        if (i != 128 && i != 224 && i != 256 && i != 288 && i != 384 && i != 512) {
            throw new IllegalArgumentException("bitLength must be one of 128, 224, 256, 288, 384, or 512.");
        }
        m6526m(1600 - (i << 1));
    }

    /* renamed from: m */
    public final void m6526m(int i) {
        if (i <= 0 || i >= 1600 || i % 64 != 0) {
            throw new IllegalStateException("invalid rate value");
        }
        this.f5142c = i;
        int i2 = 0;
        while (true) {
            long[] jArr = this.f5140a;
            if (i2 >= jArr.length) {
                e51.m3442k(this.f5141b, (byte) 0);
                this.f5143d = 0;
                this.f5145f = false;
                this.f5144e = (1600 - i) / 2;
                return;
            }
            jArr[i2] = 0;
            i2++;
        }
    }

    /* renamed from: n */
    public final void m6527n() {
        byte[] bArr = this.f5141b;
        int i = this.f5143d;
        int i2 = i >> 3;
        bArr[i2] = (byte) (bArr[i2] | ((byte) (1 << (i & 7))));
        int i3 = i + 1;
        this.f5143d = i3;
        if (i3 == this.f5142c) {
            m6520g(bArr, 0);
            this.f5143d = 0;
        }
        int i4 = this.f5143d;
        int i5 = i4 >> 6;
        int i6 = i4 & 63;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            long[] jArr = this.f5140a;
            jArr[i8] = jArr[i8] ^ h51.m4370f(this.f5141b, i7);
            i7 += 8;
        }
        if (i6 > 0) {
            long j = (1 << i6) - 1;
            long[] jArr2 = this.f5140a;
            jArr2[i5] = jArr2[i5] ^ (h51.m4370f(this.f5141b, i7) & j);
        }
        long[] jArr3 = this.f5140a;
        int i9 = (this.f5142c - 1) >> 6;
        jArr3[i9] = jArr3[i9] ^ Long.MIN_VALUE;
        m6522i();
        m6521h();
        this.f5143d = this.f5142c;
        this.f5145f = true;
    }

    /* renamed from: o */
    public void m6528o() {
        m6525l(this.f5144e);
    }

    /* renamed from: p */
    public void m6529p(byte[] bArr, int i, long j) {
        if (!this.f5145f) {
            m6527n();
        }
        long j2 = 0;
        if (j % 8 != 0) {
            throw new IllegalStateException("outputLength not a multiple of 8");
        }
        while (j2 < j) {
            if (this.f5143d == 0) {
                m6522i();
                m6521h();
                this.f5143d = this.f5142c;
            }
            int min = (int) Math.min(this.f5143d, j - j2);
            System.arraycopy(this.f5141b, (this.f5142c - this.f5143d) / 8, bArr, ((int) (j2 / 8)) + i, min / 8);
            this.f5143d -= min;
            j2 += min;
        }
    }
}
