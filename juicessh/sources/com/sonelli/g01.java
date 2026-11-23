package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class g01 {
    /* renamed from: a */
    public static int m3904a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    /* renamed from: b */
    public static int m3905b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (iArr3[4] & 4294967295L);
        iArr3[4] = (int) j5;
        return (int) (j5 >>> 32);
    }

    /* renamed from: c */
    public static void m3906c(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
    }

    /* renamed from: d */
    public static int[] m3907d() {
        return new int[5];
    }

    /* renamed from: e */
    public static int[] m3908e() {
        return new int[10];
    }

    /* renamed from: f */
    public static boolean m3909f(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static int[] m3910g(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 160) {
            throw new IllegalArgumentException();
        }
        int[] m3907d = m3907d();
        int i = 0;
        while (bigInteger.signum() != 0) {
            m3907d[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return m3907d;
    }

    /* renamed from: h */
    public static int m3911h(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 5) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    /* renamed from: i */
    public static boolean m3912i(int[] iArr, int[] iArr2) {
        for (int i = 4; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: j */
    public static boolean m3913j(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static boolean m3914k(int[] iArr) {
        for (int i = 0; i < 5; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: l */
    public static void m3915l(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & 4294967295L;
        int i = 1;
        long j2 = iArr2[1] & 4294967295L;
        long j3 = iArr2[2] & 4294967295L;
        long j4 = iArr2[3] & 4294967295L;
        long j5 = iArr2[4] & 4294967295L;
        long j6 = iArr[0] & 4294967295L;
        long j7 = (j6 * j) + 0;
        iArr3[0] = (int) j7;
        long j8 = (j7 >>> 32) + (j6 * j2);
        iArr3[1] = (int) j8;
        long j9 = (j8 >>> 32) + (j6 * j3);
        iArr3[2] = (int) j9;
        long j10 = (j9 >>> 32) + (j6 * j4);
        iArr3[3] = (int) j10;
        long j11 = (j10 >>> 32) + (j6 * j5);
        iArr3[4] = (int) j11;
        iArr3[5] = (int) (j11 >>> 32);
        for (int i2 = 5; i < i2; i2 = 5) {
            long j12 = iArr[i] & 4294967295L;
            long j13 = (j12 * j) + (iArr3[r3] & 4294967295L) + 0;
            iArr3[i + 0] = (int) j13;
            int i3 = i + 1;
            long j14 = j2;
            long j15 = (j13 >>> 32) + (j12 * j2) + (iArr3[i3] & 4294967295L);
            iArr3[i3] = (int) j15;
            long j16 = j5;
            long j17 = (j15 >>> 32) + (j12 * j3) + (iArr3[r6] & 4294967295L);
            iArr3[i + 2] = (int) j17;
            long j18 = (j17 >>> 32) + (j12 * j4) + (iArr3[r6] & 4294967295L);
            iArr3[i + 3] = (int) j18;
            long j19 = (j18 >>> 32) + (j12 * j16) + (iArr3[r3] & 4294967295L);
            iArr3[i + 4] = (int) j19;
            iArr3[i + 5] = (int) (j19 >>> 32);
            i = i3;
            j5 = j16;
            j = j;
            j2 = j14;
        }
    }

    /* renamed from: m */
    public static long m3916m(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = i & 4294967295L;
        long j2 = iArr[i2 + 0] & 4294967295L;
        long j3 = (j * j2) + (iArr2[i3 + 0] & 4294967295L) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = iArr[i2 + 1] & 4294967295L;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (iArr2[i3 + 1] & 4294967295L);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = iArr[i2 + 2] & 4294967295L;
        long j8 = j6 + (j * j7) + j4 + (iArr2[i3 + 2] & 4294967295L);
        iArr3[i4 + 2] = (int) j8;
        long j9 = iArr[i2 + 3] & 4294967295L;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (iArr2[i3 + 3] & 4294967295L);
        iArr3[i4 + 3] = (int) j10;
        long j11 = iArr[i2 + 4] & 4294967295L;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (4294967295L & iArr2[i3 + 4]);
        iArr3[i4 + 4] = (int) j12;
        return (j12 >>> 32) + j11;
    }

    /* renamed from: n */
    public static int m3917n(int i, long j, int[] iArr, int i2) {
        long j2 = i & 4294967295L;
        long j3 = j & 4294967295L;
        long j4 = (j2 * j3) + (iArr[r1] & 4294967295L) + 0;
        iArr[i2 + 0] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        long j7 = (j4 >>> 32) + j6 + (iArr[r7] & 4294967295L);
        iArr[i2 + 1] = (int) j7;
        long j8 = (j7 >>> 32) + j5 + (iArr[r7] & 4294967295L);
        iArr[i2 + 2] = (int) j8;
        long j9 = (j8 >>> 32) + (4294967295L & iArr[r7]);
        iArr[i2 + 3] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return p01.m7212w(5, iArr, i2, 4);
    }

    /* renamed from: o */
    public static int m3918o(int i, int i2, int[] iArr, int i3) {
        long j = i & 4294967295L;
        long j2 = i2 & 4294967295L;
        long j3 = (j * j2) + (iArr[r4] & 4294967295L) + 0;
        iArr[i3 + 0] = (int) j3;
        long j4 = (j3 >>> 32) + j2 + (iArr[r7] & 4294967295L);
        iArr[i3 + 1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = j5 + (iArr[r0] & 4294967295L);
        iArr[i3 + 2] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return p01.m7212w(5, iArr, i3, 3);
    }

    /* renamed from: p */
    public static int m3919p(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = iArr2[0] & 4294967295L;
        long j3 = iArr2[1] & 4294967295L;
        long j4 = iArr2[2] & 4294967295L;
        long j5 = iArr2[3] & 4294967295L;
        long j6 = iArr2[4] & 4294967295L;
        long j7 = 0;
        while (i < 5) {
            long j8 = iArr[i] & j;
            long j9 = (j8 * j2) + (iArr3[r21] & j) + 0;
            iArr3[i + 0] = (int) j9;
            int i2 = i + 1;
            long j10 = j3;
            long j11 = (j9 >>> 32) + (j8 * j3) + (iArr3[i2] & 4294967295L);
            iArr3[i2] = (int) j11;
            long j12 = j4;
            long j13 = (j11 >>> 32) + (j8 * j4) + (iArr3[r21] & 4294967295L);
            iArr3[i + 2] = (int) j13;
            long j14 = (j13 >>> 32) + (j8 * j5) + (iArr3[r7] & 4294967295L);
            iArr3[i + 3] = (int) j14;
            long j15 = (j14 >>> 32) + (j8 * j6) + (iArr3[r5] & 4294967295L);
            iArr3[i + 4] = (int) j15;
            long j16 = (j15 >>> 32) + (iArr3[r0] & 4294967295L) + j7;
            iArr3[i + 5] = (int) j16;
            j7 = j16 >>> 32;
            i = i2;
            j = 4294967295L;
            j2 = j2;
            j4 = j12;
            j3 = j10;
        }
        return (int) j7;
    }

    /* renamed from: q */
    public static int m3920q(int i, int i2, int[] iArr, int i3) {
        long j = ((i2 & 4294967295L) * (i & 4294967295L)) + (iArr[r0] & 4294967295L) + 0;
        iArr[i3 + 0] = (int) j;
        long j2 = (j >>> 32) + (4294967295L & iArr[r1]);
        iArr[i3 + 1] = (int) j2;
        if ((j2 >>> 32) == 0) {
            return 0;
        }
        return p01.m7212w(5, iArr, i3, 2);
    }

    /* renamed from: r */
    public static void m3921r(int[] iArr, int[] iArr2) {
        long j = iArr[0] & 4294967295L;
        int i = 10;
        int i2 = 0;
        int i3 = 4;
        while (true) {
            int i4 = i3 - 1;
            long j2 = iArr[i3] & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = ((i6 << 31) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = iArr[1] & 4294967295L;
                long j7 = j5 + (j6 * j);
                int i7 = (int) j7;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j8 = (iArr2[2] & 4294967295L) + (j7 >>> 32);
                long j9 = iArr[2] & 4294967295L;
                long j10 = j8 + (j9 * j);
                int i8 = (int) j10;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                int i9 = i8 >>> 31;
                long j11 = (iArr2[3] & 4294967295L) + (j10 >>> 32) + (j9 * j6);
                long j12 = (iArr2[4] & 4294967295L) + (j11 >>> 32);
                long j13 = iArr[3] & 4294967295L;
                long j14 = (iArr2[5] & 4294967295L) + (j12 >>> 32);
                long j15 = (iArr2[6] & 4294967295L) + (j14 >>> 32);
                long j16 = (j11 & 4294967295L) + (j13 * j);
                int i10 = (int) j16;
                iArr2[3] = (i10 << 1) | i9;
                int i11 = i10 >>> 31;
                long j17 = (j12 & 4294967295L) + (j16 >>> 32) + (j13 * j6);
                long j18 = (j14 & 4294967295L) + (j17 >>> 32) + (j13 * j9);
                long j19 = j15 + (j18 >>> 32);
                long j20 = iArr[4] & 4294967295L;
                long j21 = (iArr2[7] & 4294967295L) + (j19 >>> 32);
                long j22 = j19 & 4294967295L;
                long j23 = (j17 & 4294967295L) + (j * j20);
                int i12 = (int) j23;
                iArr2[4] = (i12 << 1) | i11;
                long j24 = (j18 & 4294967295L) + (j23 >>> 32) + (j20 * j6);
                long j25 = j22 + (j24 >>> 32) + (j20 * j9);
                long j26 = (4294967295L & j21) + (j25 >>> 32) + (j20 * j13);
                long j27 = (iArr2[8] & 4294967295L) + (j21 >>> 32) + (j26 >>> 32);
                int i13 = (int) j24;
                iArr2[5] = (i12 >>> 31) | (i13 << 1);
                int i14 = (int) j25;
                iArr2[6] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                int i16 = (int) j26;
                iArr2[7] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j27;
                iArr2[8] = i17 | (i18 << 1);
                iArr2[9] = (i18 >>> 31) | ((iArr2[9] + ((int) (j27 >>> 32))) << 1);
                return;
            }
            i3 = i4;
            i2 = i6;
        }
    }

    /* renamed from: s */
    public static int m3922s(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[4] & 4294967295L) - (iArr2[4] & 4294967295L));
        iArr3[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    /* renamed from: t */
    public static int m3923t(int[] iArr, int[] iArr2) {
        long j = ((iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[3] & 4294967295L) - (iArr[3] & 4294967295L));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr2[4] & 4294967295L) - (4294967295L & iArr[4]));
        iArr2[4] = (int) j5;
        return (int) (j5 >> 32);
    }

    /* renamed from: u */
    public static BigInteger m3924u(int[] iArr) {
        byte[] bArr = new byte[20];
        for (int i = 0; i < 5; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                h51.m4367c(i2, bArr, (4 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: v */
    public static void m3925v(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
    }
}
