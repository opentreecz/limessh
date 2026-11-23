package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class sx0 {
    /* renamed from: a */
    public static void m8492a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr2[1] ^ jArr[1];
    }

    /* renamed from: b */
    public static void m8493b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: c */
    public static void m8494c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
    }

    /* renamed from: d */
    public static void m8495d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
    }

    /* renamed from: e */
    public static long[] m8496e(BigInteger bigInteger) {
        return p01.m7206q(113, bigInteger);
    }

    /* renamed from: f */
    public static void m8497f(long[] jArr, long[] jArr2) {
        long[] m3633i = f01.m3633i();
        f01.m3629e(jArr, jArr2);
        for (int i = 1; i < 113; i += 2) {
            m8500i(jArr2, m3633i);
            m8504m(m3633i, jArr2);
            m8500i(jArr2, m3633i);
            m8504m(m3633i, jArr2);
            m8495d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m8498g(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = ((jArr[1] << 7) ^ (j >>> 57)) & 144115188075855871L;
        long j3 = j & 144115188075855871L;
        long j4 = jArr2[0];
        long j5 = ((jArr2[1] << 7) ^ (j4 >>> 57)) & 144115188075855871L;
        long j6 = 144115188075855871L & j4;
        long[] jArr4 = new long[6];
        m8499h(j3, j6, jArr4, 0);
        m8499h(j2, j5, jArr4, 2);
        m8499h(j3 ^ j2, j6 ^ j5, jArr4, 4);
        long j7 = jArr4[1] ^ jArr4[2];
        long j8 = jArr4[0];
        long j9 = jArr4[3];
        long j10 = (jArr4[4] ^ j8) ^ j7;
        long j11 = j7 ^ (jArr4[5] ^ j9);
        jArr3[0] = j8 ^ (j10 << 57);
        jArr3[1] = (j10 >>> 7) ^ (j11 << 50);
        jArr3[2] = (j11 >>> 14) ^ (j9 << 43);
        jArr3[3] = j9 >>> 21;
    }

    /* renamed from: h */
    public static void m8499h(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = {0, j2, jArr2[1] << 1, jArr2[2] ^ j2, jArr2[2] << 1, jArr2[4] ^ j2, jArr2[3] << 1, jArr2[6] ^ j2};
        long j3 = jArr2[((int) j) & 7];
        long j4 = 0;
        int i2 = 48;
        do {
            int i3 = (int) (j >>> i2);
            long j5 = (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3)) ^ (jArr2[(i3 >>> 6) & 7] << 6);
            j3 ^= j5 << i2;
            j4 ^= j5 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 144115188075855871L & j3;
        jArr[i + 1] = (((((j & 72198606942111744L) & ((j2 << 7) >> 63)) >>> 8) ^ j4) << 7) ^ (j3 >>> 57);
    }

    /* renamed from: i */
    public static void m8500i(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
    }

    /* renamed from: j */
    public static void m8501j(long[] jArr, long[] jArr2) {
        if (f01.m3642r(jArr)) {
            throw new IllegalStateException();
        }
        long[] m3631g = f01.m3631g();
        long[] m3631g2 = f01.m3631g();
        m8506o(jArr, m3631g);
        m8502k(m3631g, jArr, m3631g);
        m8506o(m3631g, m3631g);
        m8502k(m3631g, jArr, m3631g);
        m8508q(m3631g, 3, m3631g2);
        m8502k(m3631g2, m3631g, m3631g2);
        m8506o(m3631g2, m3631g2);
        m8502k(m3631g2, jArr, m3631g2);
        m8508q(m3631g2, 7, m3631g);
        m8502k(m3631g, m3631g2, m3631g);
        m8508q(m3631g, 14, m3631g2);
        m8502k(m3631g2, m3631g, m3631g2);
        m8508q(m3631g2, 28, m3631g);
        m8502k(m3631g, m3631g2, m3631g);
        m8508q(m3631g, 56, m3631g2);
        m8502k(m3631g2, m3631g, m3631g2);
        m8506o(m3631g2, jArr2);
    }

    /* renamed from: k */
    public static void m8502k(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m3633i = f01.m3633i();
        m8498g(jArr, jArr2, m3633i);
        m8504m(m3633i, jArr3);
    }

    /* renamed from: l */
    public static void m8503l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m3633i = f01.m3633i();
        m8498g(jArr, jArr2, m3633i);
        m8493b(jArr3, m3633i, jArr3);
    }

    /* renamed from: m */
    public static void m8504m(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = j3 ^ ((j4 >>> 40) ^ (j4 >>> 49));
        long j6 = j ^ ((j5 << 15) ^ (j5 << 24));
        long j7 = (j2 ^ ((j4 << 15) ^ (j4 << 24))) ^ ((j5 >>> 40) ^ (j5 >>> 49));
        long j8 = j7 >>> 49;
        jArr2[0] = (j6 ^ j8) ^ (j8 << 9);
        jArr2[1] = 562949953421311L & j7;
    }

    /* renamed from: n */
    public static void m8505n(long[] jArr, long[] jArr2) {
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (4294967295L & m3089e) | (m3089e2 << 32);
        long j2 = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        jArr2[0] = ((j2 << 57) ^ j) ^ (j2 << 5);
        jArr2[1] = (j2 >>> 59) ^ (j2 >>> 7);
    }

    /* renamed from: o */
    public static void m8506o(long[] jArr, long[] jArr2) {
        long[] m3633i = f01.m3633i();
        m8500i(jArr, m3633i);
        m8504m(m3633i, jArr2);
    }

    /* renamed from: p */
    public static void m8507p(long[] jArr, long[] jArr2) {
        long[] m3633i = f01.m3633i();
        m8500i(jArr, m3633i);
        m8493b(jArr2, m3633i, jArr2);
    }

    /* renamed from: q */
    public static void m8508q(long[] jArr, int i, long[] jArr2) {
        long[] m3633i = f01.m3633i();
        m8500i(jArr, m3633i);
        while (true) {
            m8504m(m3633i, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m8500i(jArr2, m3633i);
            }
        }
    }

    /* renamed from: r */
    public static int m8509r(long[] jArr) {
        return ((int) jArr[0]) & 1;
    }
}
