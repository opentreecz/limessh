package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class yy0 {
    /* renamed from: a */
    public static void m10255a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m10256b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr2[7] ^ jArr[7];
    }

    /* renamed from: c */
    public static void m10257c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: d */
    public static void m10258d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: e */
    public static long[] m10259e(BigInteger bigInteger) {
        return p01.m7206q(239, bigInteger);
    }

    /* renamed from: f */
    public static void m10260f(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        j01.m5014h(jArr, jArr2);
        for (int i = 1; i < 239; i += 2) {
            m10265k(jArr2, m5018l);
            m10269o(m5018l, jArr2);
            m10265k(jArr2, m5018l);
            m10269o(m5018l, jArr2);
            m10258d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m10261g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 60);
        jArr[1] = (j2 >>> 4) ^ (j3 << 56);
        jArr[2] = (j3 >>> 8) ^ (j4 << 52);
        jArr[3] = (j4 >>> 12) ^ (j5 << 48);
        jArr[4] = (j5 >>> 16) ^ (j6 << 44);
        jArr[5] = (j6 >>> 20) ^ (j7 << 40);
        jArr[6] = (j7 >>> 24) ^ (j8 << 36);
        jArr[7] = j8 >>> 28;
    }

    /* renamed from: h */
    public static void m10262h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 1152921504606846975L;
        jArr2[1] = ((j >>> 60) ^ (j2 << 4)) & 1152921504606846975L;
        jArr2[2] = ((j2 >>> 56) ^ (j3 << 8)) & 1152921504606846975L;
        jArr2[3] = (j3 >>> 52) ^ (j4 << 12);
    }

    /* renamed from: i */
    public static void m10263i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m10262h(jArr, jArr4);
        m10262h(jArr2, jArr5);
        m10264j(jArr4[0], jArr5[0], jArr3, 0);
        m10264j(jArr4[1], jArr5[1], jArr3, 1);
        m10264j(jArr4[2], jArr5[2], jArr3, 2);
        m10264j(jArr4[3], jArr5[3], jArr3, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m10264j(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m10264j(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m10264j(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr6 = new long[3];
        m10264j(j, j3, jArr6, 0);
        m10264j(j2, j4, jArr6, 1);
        long j5 = jArr6[0];
        long j6 = jArr6[1];
        long j7 = jArr6[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        m10261g(jArr3);
    }

    /* renamed from: j */
    public static void m10264j(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = {0, j2, jArr2[1] << 1, jArr2[2] ^ j2, jArr2[2] << 1, jArr2[4] ^ j2, jArr2[3] << 1, jArr2[6] ^ j2};
        int i2 = (int) j;
        long j3 = (jArr2[(i2 >>> 3) & 7] << 3) ^ jArr2[i2 & 7];
        long j4 = 0;
        int i3 = 54;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3);
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 6;
        } while (i3 > 0);
        jArr[i] = jArr[i] ^ (1152921504606846975L & j3);
        int i5 = i + 1;
        jArr[i5] = ((((((j & 585610922974906400L) & ((j2 << 4) >> 63)) >>> 5) ^ j4) << 4) ^ (j3 >>> 60)) ^ jArr[i5];
    }

    /* renamed from: k */
    public static void m10265k(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        d01.m3086b(jArr[3], jArr2, 6);
    }

    /* renamed from: l */
    public static void m10266l(long[] jArr, long[] jArr2) {
        if (j01.m5029w(jArr)) {
            throw new IllegalStateException();
        }
        long[] m5016j = j01.m5016j();
        long[] m5016j2 = j01.m5016j();
        m10271q(jArr, m5016j);
        m10267m(m5016j, jArr, m5016j);
        m10271q(m5016j, m5016j);
        m10267m(m5016j, jArr, m5016j);
        m10273s(m5016j, 3, m5016j2);
        m10267m(m5016j2, m5016j, m5016j2);
        m10271q(m5016j2, m5016j2);
        m10267m(m5016j2, jArr, m5016j2);
        m10273s(m5016j2, 7, m5016j);
        m10267m(m5016j, m5016j2, m5016j);
        m10273s(m5016j, 14, m5016j2);
        m10267m(m5016j2, m5016j, m5016j2);
        m10271q(m5016j2, m5016j2);
        m10267m(m5016j2, jArr, m5016j2);
        m10273s(m5016j2, 29, m5016j);
        m10267m(m5016j, m5016j2, m5016j);
        m10271q(m5016j, m5016j);
        m10267m(m5016j, jArr, m5016j);
        m10273s(m5016j, 59, m5016j2);
        m10267m(m5016j2, m5016j, m5016j2);
        m10271q(m5016j2, m5016j2);
        m10267m(m5016j2, jArr, m5016j2);
        m10273s(m5016j2, 119, m5016j);
        m10267m(m5016j, m5016j2, m5016j);
        m10271q(m5016j, jArr2);
    }

    /* renamed from: m */
    public static void m10267m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m10263i(jArr, jArr2, m5018l);
        m10269o(m5018l, jArr3);
    }

    /* renamed from: n */
    public static void m10268n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m10263i(jArr, jArr2, m5018l);
        m10256b(jArr3, m5018l, jArr3);
    }

    /* renamed from: o */
    public static void m10269o(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = j7 ^ (j8 >>> 17);
        long j10 = (j6 ^ (j8 << 47)) ^ (j9 >>> 17);
        long j11 = ((j5 ^ (j8 >>> 47)) ^ (j9 << 47)) ^ (j10 >>> 17);
        long j12 = j ^ (j11 << 17);
        long j13 = (j2 ^ (j10 << 17)) ^ (j11 >>> 47);
        long j14 = ((j3 ^ (j9 << 17)) ^ (j10 >>> 47)) ^ (j11 << 47);
        long j15 = (((j4 ^ (j8 << 17)) ^ (j9 >>> 47)) ^ (j10 << 47)) ^ (j11 >>> 17);
        long j16 = j15 >>> 47;
        jArr2[0] = j12 ^ j16;
        jArr2[1] = j13;
        jArr2[2] = (j16 << 30) ^ j14;
        jArr2[3] = 140737488355327L & j15;
    }

    /* renamed from: p */
    public static void m10270p(long[] jArr, long[] jArr2) {
        int i = 0;
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        long j2 = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        int i2 = 2;
        long m3089e3 = d01.m3089e(jArr[2]);
        long m3089e4 = d01.m3089e(jArr[3]);
        long j3 = (m3089e3 & 4294967295L) | (m3089e4 << 32);
        long j4 = (m3089e4 & (-4294967296L)) | (m3089e3 >>> 32);
        long j5 = j4 >>> 49;
        long j6 = (j2 >>> 49) | (j4 << 15);
        long j7 = j4 ^ (j2 << 15);
        long[] m5018l = j01.m5018l();
        int[] iArr = {39, 120};
        while (i < i2) {
            int i3 = iArr[i] >>> 6;
            int i4 = iArr[i] & 63;
            m5018l[i3] = m5018l[i3] ^ (j2 << i4);
            int i5 = i3 + 1;
            int[] iArr2 = iArr;
            int i6 = -i4;
            m5018l[i5] = m5018l[i5] ^ ((j7 << i4) | (j2 >>> i6));
            int i7 = i3 + 2;
            m5018l[i7] = m5018l[i7] ^ ((j6 << i4) | (j7 >>> i6));
            int i8 = i3 + 3;
            m5018l[i8] = m5018l[i8] ^ ((j5 << i4) | (j6 >>> i6));
            int i9 = i3 + 4;
            m5018l[i9] = m5018l[i9] ^ (j5 >>> i6);
            i++;
            i2 = 2;
            iArr = iArr2;
        }
        m10269o(m5018l, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j3;
    }

    /* renamed from: q */
    public static void m10271q(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m10265k(jArr, m5018l);
        m10269o(m5018l, jArr2);
    }

    /* renamed from: r */
    public static void m10272r(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m10265k(jArr, m5018l);
        m10256b(jArr2, m5018l, jArr2);
    }

    /* renamed from: s */
    public static void m10273s(long[] jArr, int i, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m10265k(jArr, m5018l);
        while (true) {
            m10269o(m5018l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m10265k(jArr2, m5018l);
            }
        }
    }

    /* renamed from: t */
    public static int m10274t(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[1] >>> 17)) ^ (jArr[2] >>> 34))) & 1;
    }
}
