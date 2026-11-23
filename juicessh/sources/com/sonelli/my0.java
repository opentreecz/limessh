package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class my0 {
    /* renamed from: a */
    public static void m6574a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m6575b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    /* renamed from: c */
    public static void m6576c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: d */
    public static void m6577d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: e */
    public static long[] m6578e(BigInteger bigInteger) {
        return p01.m7206q(193, bigInteger);
    }

    /* renamed from: f */
    public static void m6579f(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        j01.m5014h(jArr, jArr2);
        for (int i = 1; i < 193; i += 2) {
            m6584k(jArr2, m5018l);
            m6588o(m5018l, jArr2);
            m6584k(jArr2, m5018l);
            m6588o(m5018l, jArr2);
            m6577d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m6580g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 49);
        jArr[1] = (j2 >>> 15) ^ (j3 << 34);
        jArr[2] = (j3 >>> 30) ^ (j4 << 19);
        jArr[3] = ((j4 >>> 45) ^ (j5 << 4)) ^ (j6 << 53);
        jArr[4] = ((j5 >>> 60) ^ (j7 << 38)) ^ (j6 >>> 11);
        jArr[5] = (j7 >>> 26) ^ (j8 << 23);
        jArr[6] = j8 >>> 41;
        jArr[7] = 0;
    }

    /* renamed from: h */
    public static void m6581h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 562949953421311L;
        jArr2[1] = ((j >>> 49) ^ (j2 << 15)) & 562949953421311L;
        jArr2[2] = ((j2 >>> 34) ^ (j3 << 30)) & 562949953421311L;
        jArr2[3] = (j3 >>> 19) ^ (j4 << 45);
    }

    /* renamed from: i */
    public static void m6582i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m6581h(jArr, jArr4);
        m6581h(jArr2, jArr5);
        m6583j(jArr4[0], jArr5[0], jArr3, 0);
        m6583j(jArr4[1], jArr5[1], jArr3, 1);
        m6583j(jArr4[2], jArr5[2], jArr3, 2);
        m6583j(jArr4[3], jArr5[3], jArr3, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m6583j(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m6583j(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m6583j(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr6 = new long[3];
        m6583j(j, j3, jArr6, 0);
        m6583j(j2, j4, jArr6, 1);
        long j5 = jArr6[0];
        long j6 = jArr6[1];
        long j7 = jArr6[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        m6580g(jArr3);
    }

    /* renamed from: j */
    public static void m6583j(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = {0, j2, jArr2[1] << 1, jArr2[2] ^ j2, jArr2[2] << 1, jArr2[4] ^ j2, jArr2[3] << 1, jArr2[6] ^ j2};
        int i2 = (int) j;
        long j3 = (jArr2[(i2 >>> 3) & 7] << 3) ^ jArr2[i2 & 7];
        long j4 = 0;
        int i3 = 36;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = (((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6)) ^ (jArr2[(i4 >>> 9) & 7] << 9)) ^ (jArr2[(i4 >>> 12) & 7] << 12);
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 15;
        } while (i3 > 0);
        jArr[i] = jArr[i] ^ (562949953421311L & j3);
        int i5 = i + 1;
        jArr[i5] = jArr[i5] ^ ((j3 >>> 49) ^ (j4 << 15));
    }

    /* renamed from: k */
    public static void m6584k(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        jArr2[6] = jArr[3] & 1;
    }

    /* renamed from: l */
    public static void m6585l(long[] jArr, long[] jArr2) {
        if (j01.m5029w(jArr)) {
            throw new IllegalStateException();
        }
        long[] m5016j = j01.m5016j();
        long[] m5016j2 = j01.m5016j();
        m6590q(jArr, m5016j);
        m6592s(m5016j, 1, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j2, 1, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 3, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 6, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 12, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 24, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 48, m5016j2);
        m6586m(m5016j, m5016j2, m5016j);
        m6592s(m5016j, 96, m5016j2);
        m6586m(m5016j, m5016j2, jArr2);
    }

    /* renamed from: m */
    public static void m6586m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m6582i(jArr, jArr2, m5018l);
        m6588o(m5018l, jArr3);
    }

    /* renamed from: n */
    public static void m6587n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m6582i(jArr, jArr2, m5018l);
        m6575b(jArr3, m5018l, jArr3);
    }

    /* renamed from: o */
    public static void m6588o(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = j5 ^ (j7 >>> 50);
        long j9 = (j4 ^ ((j7 >>> 1) ^ (j7 << 14))) ^ (j6 >>> 50);
        long j10 = j ^ (j8 << 63);
        long j11 = (j2 ^ (j6 << 63)) ^ ((j8 >>> 1) ^ (j8 << 14));
        long j12 = ((j3 ^ (j7 << 63)) ^ ((j6 >>> 1) ^ (j6 << 14))) ^ (j8 >>> 50);
        long j13 = j9 >>> 1;
        jArr2[0] = (j10 ^ j13) ^ (j13 << 15);
        jArr2[1] = (j13 >>> 49) ^ j11;
        jArr2[2] = j12;
        jArr2[3] = 1 & j9;
    }

    /* renamed from: p */
    public static void m6589p(long[] jArr, long[] jArr2) {
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        long j2 = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        long j3 = (m3089e3 & 4294967295L) ^ (jArr[3] << 32);
        long j4 = m3089e3 >>> 32;
        jArr2[0] = j ^ (j2 << 8);
        jArr2[1] = ((j3 ^ (j4 << 8)) ^ (j2 >>> 56)) ^ (j2 << 33);
        jArr2[2] = (j2 >>> 31) ^ ((j4 >>> 56) ^ (j4 << 33));
        jArr2[3] = j4 >>> 31;
    }

    /* renamed from: q */
    public static void m6590q(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m6584k(jArr, m5018l);
        m6588o(m5018l, jArr2);
    }

    /* renamed from: r */
    public static void m6591r(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m6584k(jArr, m5018l);
        m6575b(jArr2, m5018l, jArr2);
    }

    /* renamed from: s */
    public static void m6592s(long[] jArr, int i, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m6584k(jArr, m5018l);
        while (true) {
            m6588o(m5018l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m6584k(jArr2, m5018l);
            }
        }
    }

    /* renamed from: t */
    public static int m6593t(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
