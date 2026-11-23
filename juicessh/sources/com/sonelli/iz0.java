package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class iz0 {
    /* renamed from: a */
    public static void m4970a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr2[6] ^ jArr[6];
    }

    /* renamed from: b */
    public static void m4971b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 13; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: c */
    public static void m4972c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    /* renamed from: d */
    public static void m4973d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
        jArr2[5] = jArr2[5] ^ jArr[5];
        jArr2[6] = jArr2[6] ^ jArr[6];
    }

    /* renamed from: e */
    public static long[] m4974e(BigInteger bigInteger) {
        return p01.m7206q(409, bigInteger);
    }

    /* renamed from: f */
    public static void m4975f(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(13);
        m01.m6330b(jArr, jArr2);
        for (int i = 1; i < 409; i += 2) {
            m4980k(jArr2, m7201l);
            m4984o(m7201l, jArr2);
            m4980k(jArr2, m7201l);
            m4984o(m7201l, jArr2);
            m4973d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m4976g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
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
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = (j8 >>> 35) ^ (j9 << 24);
        jArr[8] = (j9 >>> 40) ^ (j10 << 19);
        jArr[9] = (j10 >>> 45) ^ (j11 << 14);
        jArr[10] = (j11 >>> 50) ^ (j12 << 9);
        jArr[11] = ((j12 >>> 55) ^ (j13 << 4)) ^ (j14 << 63);
        jArr[12] = (j13 >>> 60) ^ (j14 >>> 1);
        jArr[13] = 0;
    }

    /* renamed from: h */
    public static void m4977h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = ((j3 >>> 49) ^ (j4 << 15)) & 576460752303423487L;
        jArr2[4] = ((j4 >>> 44) ^ (j5 << 20)) & 576460752303423487L;
        jArr2[5] = ((j5 >>> 39) ^ (j6 << 25)) & 576460752303423487L;
        jArr2[6] = (j6 >>> 34) ^ (j7 << 30);
    }

    /* renamed from: i */
    public static void m4978i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[7];
        long[] jArr5 = new long[7];
        m4977h(jArr, jArr4);
        m4977h(jArr2, jArr5);
        for (int i = 0; i < 7; i++) {
            m4979j(jArr4, jArr5[i], jArr3, i);
        }
        m4976g(jArr3);
    }

    /* renamed from: j */
    public static void m4979j(long[] jArr, long j, long[] jArr2, int i) {
        long[] jArr3 = {0, j, jArr3[1] << 1, jArr3[2] ^ j, jArr3[2] << 1, jArr3[4] ^ j, jArr3[3] << 1, jArr3[6] ^ j};
        for (int i2 = 0; i2 < 7; i2++) {
            long j2 = jArr[i2];
            int i3 = (int) j2;
            long j3 = 0;
            long j4 = jArr3[i3 & 7] ^ (jArr3[(i3 >>> 3) & 7] << 3);
            int i4 = 54;
            do {
                int i5 = (int) (j2 >>> i4);
                long j5 = jArr3[i5 & 7] ^ (jArr3[(i5 >>> 3) & 7] << 3);
                j4 ^= j5 << i4;
                j3 ^= j5 >>> (-i4);
                i4 -= 6;
            } while (i4 > 0);
            int i6 = i + i2;
            jArr2[i6] = jArr2[i6] ^ (576460752303423487L & j4);
            int i7 = i6 + 1;
            jArr2[i7] = jArr2[i7] ^ ((j3 << 5) ^ (j4 >>> 59));
        }
    }

    /* renamed from: k */
    public static void m4980k(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        d01.m3086b(jArr[3], jArr2, 6);
        d01.m3086b(jArr[4], jArr2, 8);
        d01.m3086b(jArr[5], jArr2, 10);
        jArr2[12] = d01.m3085a((int) jArr[6]);
    }

    /* renamed from: l */
    public static void m4981l(long[] jArr, long[] jArr2) {
        if (m01.m6335g(jArr)) {
            throw new IllegalStateException();
        }
        long[] m6331c = m01.m6331c();
        long[] m6331c2 = m01.m6331c();
        long[] m6331c3 = m01.m6331c();
        m4986q(jArr, m6331c);
        m4988s(m6331c, 1, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c2, 1, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 3, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 6, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 12, m6331c2);
        m4982m(m6331c, m6331c2, m6331c3);
        m4988s(m6331c3, 24, m6331c);
        m4988s(m6331c, 24, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 48, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 96, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4988s(m6331c, 192, m6331c2);
        m4982m(m6331c, m6331c2, m6331c);
        m4982m(m6331c, m6331c3, jArr2);
    }

    /* renamed from: m */
    public static void m4982m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6332d = m01.m6332d();
        m4978i(jArr, jArr2, m6332d);
        m4984o(m6332d, jArr3);
    }

    /* renamed from: n */
    public static void m4983n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6332d = m01.m6332d();
        m4978i(jArr, jArr2, m6332d);
        m4971b(jArr3, m6332d, jArr3);
    }

    /* renamed from: o */
    public static void m4984o(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[12];
        long j10 = j6 ^ (j9 << 39);
        long j11 = j7 ^ ((j9 >>> 25) ^ (j9 << 62));
        long j12 = j8 ^ (j9 >>> 2);
        long j13 = jArr[11];
        long j14 = j5 ^ (j13 << 39);
        long j15 = j10 ^ ((j13 >>> 25) ^ (j13 << 62));
        long j16 = j11 ^ (j13 >>> 2);
        long j17 = jArr[10];
        long j18 = j4 ^ (j17 << 39);
        long j19 = j14 ^ ((j17 >>> 25) ^ (j17 << 62));
        long j20 = j15 ^ (j17 >>> 2);
        long j21 = jArr[9];
        long j22 = j3 ^ (j21 << 39);
        long j23 = j18 ^ ((j21 >>> 25) ^ (j21 << 62));
        long j24 = j19 ^ (j21 >>> 2);
        long j25 = jArr[8];
        long j26 = j ^ (j12 << 39);
        long j27 = (j2 ^ (j25 << 39)) ^ ((j12 >>> 25) ^ (j12 << 62));
        long j28 = (j22 ^ ((j25 >>> 25) ^ (j25 << 62))) ^ (j12 >>> 2);
        long j29 = j16 >>> 25;
        jArr2[0] = j26 ^ j29;
        jArr2[1] = (j29 << 23) ^ j27;
        jArr2[2] = j28;
        jArr2[3] = j23 ^ (j25 >>> 2);
        jArr2[4] = j24;
        jArr2[5] = j20;
        jArr2[6] = j16 & 33554431;
    }

    /* renamed from: p */
    public static void m4985p(long[] jArr, long[] jArr2) {
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        long j2 = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        long m3089e4 = d01.m3089e(jArr[3]);
        long j3 = (m3089e3 & 4294967295L) | (m3089e4 << 32);
        long j4 = (m3089e3 >>> 32) | (m3089e4 & (-4294967296L));
        long m3089e5 = d01.m3089e(jArr[4]);
        long m3089e6 = d01.m3089e(jArr[5]);
        long j5 = (m3089e5 >>> 32) | (m3089e6 & (-4294967296L));
        long m3089e7 = d01.m3089e(jArr[6]);
        long j6 = m3089e7 & 4294967295L;
        long j7 = m3089e7 >>> 32;
        jArr2[0] = j ^ (j2 << 44);
        jArr2[1] = (j3 ^ (j4 << 44)) ^ (j2 >>> 20);
        jArr2[2] = (((m3089e5 & 4294967295L) | (m3089e6 << 32)) ^ (j5 << 44)) ^ (j4 >>> 20);
        jArr2[3] = (((j7 << 44) ^ j6) ^ (j5 >>> 20)) ^ (j2 << 13);
        jArr2[4] = (j2 >>> 51) ^ ((j7 >>> 20) ^ (j4 << 13));
        jArr2[5] = (j5 << 13) ^ (j4 >>> 51);
        jArr2[6] = (j7 << 13) ^ (j5 >>> 51);
    }

    /* renamed from: q */
    public static void m4986q(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(13);
        m4980k(jArr, m7201l);
        m4984o(m7201l, jArr2);
    }

    /* renamed from: r */
    public static void m4987r(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(13);
        m4980k(jArr, m7201l);
        m4971b(jArr2, m7201l, jArr2);
    }

    /* renamed from: s */
    public static void m4988s(long[] jArr, int i, long[] jArr2) {
        long[] m7201l = p01.m7201l(13);
        m4980k(jArr, m7201l);
        while (true) {
            m4984o(m7201l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m4980k(jArr2, m7201l);
            }
        }
    }

    /* renamed from: t */
    public static int m4989t(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
