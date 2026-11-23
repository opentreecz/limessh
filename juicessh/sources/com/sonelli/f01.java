package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class f01 {
    /* renamed from: a */
    public static int m3625a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    /* renamed from: b */
    public static int m3626b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L);
        iArr3[3] = (int) j4;
        return (int) (j4 >>> 32);
    }

    /* renamed from: c */
    public static void m3627c(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
    }

    /* renamed from: d */
    public static void m3628d(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
    }

    /* renamed from: e */
    public static void m3629e(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
    }

    /* renamed from: f */
    public static int[] m3630f() {
        return new int[4];
    }

    /* renamed from: g */
    public static long[] m3631g() {
        return new long[2];
    }

    /* renamed from: h */
    public static int[] m3632h() {
        return new int[8];
    }

    /* renamed from: i */
    public static long[] m3633i() {
        return new long[4];
    }

    /* renamed from: j */
    public static boolean m3634j(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    public static boolean m3635k(long[] jArr, long[] jArr2) {
        for (int i = 1; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: l */
    public static int[] m3636l(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 128) {
            throw new IllegalArgumentException();
        }
        int[] m3630f = m3630f();
        int i = 0;
        while (bigInteger.signum() != 0) {
            m3630f[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return m3630f;
    }

    /* renamed from: m */
    public static int m3637m(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            int i3 = i >> 5;
            if (i3 < 0 || i3 >= 4) {
                return 0;
            }
            i2 = iArr[i3] >>> (i & 31);
        }
        return i2 & 1;
    }

    /* renamed from: n */
    public static boolean m3638n(int[] iArr, int[] iArr2) {
        for (int i = 3; i >= 0; i--) {
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

    /* renamed from: o */
    public static boolean m3639o(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    public static boolean m3640p(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: q */
    public static boolean m3641q(int[] iArr) {
        for (int i = 0; i < 4; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: r */
    public static boolean m3642r(long[] jArr) {
        for (int i = 0; i < 2; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public static void m3643s(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & 4294967295L;
        int i = 1;
        long j2 = iArr2[1] & 4294967295L;
        long j3 = iArr2[2] & 4294967295L;
        long j4 = iArr2[3] & 4294967295L;
        long j5 = iArr[0] & 4294967295L;
        long j6 = (j5 * j) + 0;
        iArr3[0] = (int) j6;
        char c = ' ';
        long j7 = (j6 >>> 32) + (j5 * j2);
        iArr3[1] = (int) j7;
        long j8 = (j7 >>> 32) + (j5 * j3);
        iArr3[2] = (int) j8;
        long j9 = (j8 >>> 32) + (j5 * j4);
        iArr3[3] = (int) j9;
        iArr3[4] = (int) (j9 >>> 32);
        for (int i2 = 4; i < i2; i2 = 4) {
            long j10 = iArr[i] & 4294967295L;
            int i3 = i;
            long j11 = (j10 * j) + (iArr3[r3] & 4294967295L) + 0;
            iArr3[i + 0] = (int) j11;
            int i4 = i3 + 1;
            long j12 = j;
            long j13 = (j11 >>> c) + (j10 * j2) + (iArr3[i4] & 4294967295L);
            iArr3[i4] = (int) j13;
            long j14 = (j13 >>> 32) + (j10 * j3) + (iArr3[r8] & 4294967295L);
            iArr3[i3 + 2] = (int) j14;
            c = ' ';
            long j15 = (j14 >>> 32) + (j10 * j4) + (iArr3[r5] & 4294967295L);
            iArr3[i3 + 3] = (int) j15;
            iArr3[i3 + 4] = (int) (j15 >>> 32);
            i = i4;
            j = j12;
            j2 = j2;
        }
    }

    /* renamed from: t */
    public static int m3644t(int[] iArr, int[] iArr2, int[] iArr3) {
        int i = 0;
        long j = 4294967295L;
        long j2 = iArr2[0] & 4294967295L;
        long j3 = iArr2[1] & 4294967295L;
        long j4 = iArr2[2] & 4294967295L;
        long j5 = iArr2[3] & 4294967295L;
        long j6 = 0;
        while (i < 4) {
            long j7 = iArr[i] & j;
            long j8 = (j7 * j2) + (iArr3[r15] & j) + 0;
            iArr3[i + 0] = (int) j8;
            int i2 = i + 1;
            long j9 = (j8 >>> 32) + (j7 * j3) + (iArr3[i2] & 4294967295L);
            iArr3[i2] = (int) j9;
            long j10 = (j9 >>> 32) + (j7 * j4) + (iArr3[r17] & 4294967295L);
            iArr3[i + 2] = (int) j10;
            long j11 = (j10 >>> 32) + (j7 * j5) + (iArr3[r4] & 4294967295L);
            iArr3[i + 3] = (int) j11;
            long j12 = j6 + (j11 >>> 32) + (iArr3[r0] & 4294967295L);
            iArr3[i + 4] = (int) j12;
            j6 = j12 >>> 32;
            i = i2;
            j = 4294967295L;
            j2 = j2;
            j3 = j3;
        }
        return (int) j6;
    }

    /* renamed from: u */
    public static void m3645u(int[] iArr, int[] iArr2) {
        long j = 4294967295L;
        long j2 = iArr[0] & 4294967295L;
        char c = 3;
        int i = 8;
        int i2 = 0;
        int i3 = 3;
        while (true) {
            int i4 = i3 - 1;
            long j3 = iArr[i3] & j;
            long j4 = j3 * j3;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j4 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j4 >>> 1);
            int i6 = (int) j4;
            if (i4 <= 0) {
                long j5 = j2 * j2;
                long j6 = ((i6 << 31) & j) | (j5 >>> 33);
                iArr2[0] = (int) j5;
                long j7 = iArr[1] & j;
                long j8 = j6 + (j7 * j2);
                int i7 = (int) j8;
                iArr2[1] = (i7 << 1) | (((int) (j5 >>> 32)) & 1);
                long j9 = (iArr2[2] & j) + (j8 >>> 32);
                long j10 = iArr[2] & j;
                long j11 = iArr2[c] & j;
                long j12 = iArr2[4] & j;
                long j13 = j9 + (j10 * j2);
                int i8 = (int) j13;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j14 = j11 + (j13 >>> 32) + (j10 * j7);
                long j15 = j12 + (j14 >>> 32);
                long j16 = iArr[3] & 4294967295L;
                long j17 = (iArr2[5] & 4294967295L) + (j15 >>> 32);
                long j18 = j15 & 4294967295L;
                long j19 = (iArr2[6] & 4294967295L) + (j17 >>> 32);
                long j20 = (j14 & 4294967295L) + (j2 * j16);
                int i9 = (int) j20;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j21 = j18 + (j20 >>> 32) + (j7 * j16);
                long j22 = (j17 & 4294967295L) + (j21 >>> 32) + (j16 * j10);
                long j23 = j19 + (j22 >>> 32);
                int i10 = (int) j21;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                int i11 = (int) (4294967295L & j22);
                iArr2[5] = (i10 >>> 31) | (i11 << 1);
                int i12 = i11 >>> 31;
                int i13 = (int) j23;
                iArr2[6] = i12 | (i13 << 1);
                iArr2[7] = (i13 >>> 31) | ((iArr2[7] + ((int) (j23 >>> 32))) << 1);
                return;
            }
            i3 = i4;
            i2 = i6;
            c = c;
            j = j;
        }
    }

    /* renamed from: v */
    public static int m3646v(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L));
        iArr3[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    /* renamed from: w */
    public static int m3647w(int[] iArr, int[] iArr2) {
        long j = ((iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[3] & 4294967295L) - (4294967295L & iArr[3]));
        iArr2[3] = (int) j4;
        return (int) (j4 >> 32);
    }

    /* renamed from: x */
    public static BigInteger m3648x(int[] iArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 4; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                h51.m4367c(i2, bArr, (3 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: y */
    public static BigInteger m3649y(long[] jArr) {
        byte[] bArr = new byte[16];
        for (int i = 0; i < 2; i++) {
            long j = jArr[i];
            if (j != 0) {
                h51.m4372h(j, bArr, (1 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: z */
    public static void m3650z(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
    }
}
