package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class ey0 {

    /* renamed from: a */
    public static final long[] f2552a = {-5270498306774157648L, 5270498306774195053L, 19634136210L};

    /* renamed from: a */
    public static void m3566a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: b */
    public static void m3567b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr2[5] ^ jArr[5];
    }

    /* renamed from: c */
    public static void m3568c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    /* renamed from: d */
    public static void m3569d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: e */
    public static long[] m3570e(BigInteger bigInteger) {
        return p01.m7206q(KeycodeConstants.KEYCODE_NUMPAD_RIGHT_PAREN, bigInteger);
    }

    /* renamed from: f */
    public static void m3571f(long[] jArr, long[] jArr2) {
        long[] m4318k = h01.m4318k();
        h01.m4314g(jArr, jArr2);
        for (int i = 1; i < 163; i += 2) {
            m3575j(jArr2, m4318k);
            m3579n(m4318k, jArr2);
            m3575j(jArr2, m4318k);
            m3579n(m4318k, jArr2);
            m3569d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m3572g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 55);
        jArr[1] = (j2 >>> 9) ^ (j3 << 46);
        jArr[2] = (j3 >>> 18) ^ (j4 << 37);
        jArr[3] = (j4 >>> 27) ^ (j5 << 28);
        jArr[4] = (j5 >>> 36) ^ (j6 << 19);
        jArr[5] = j6 >>> 45;
    }

    /* renamed from: h */
    public static void m3573h(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = (jArr[2] << 18) ^ (j2 >>> 46);
        long j4 = ((j2 << 9) ^ (j >>> 55)) & 36028797018963967L;
        long j5 = j & 36028797018963967L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = (j7 >>> 46) ^ (jArr2[2] << 18);
        long j9 = ((j6 >>> 55) ^ (j7 << 9)) & 36028797018963967L;
        long j10 = j6 & 36028797018963967L;
        long[] jArr4 = new long[10];
        m3574i(j5, j10, jArr4, 0);
        m3574i(j3, j8, jArr4, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        m3574i(j11, j12, jArr4, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        m3574i(j5 ^ j13, j10 ^ j14, jArr4, 6);
        m3574i(j11 ^ j13, j12 ^ j14, jArr4, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j17 ^ j19) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j18 ^ j20) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 55);
        long j24 = (j21 ^ j16) ^ (j23 >>> 55);
        long j25 = j23 & 36028797018963967L;
        long j26 = ((j22 & 36028797018963967L) >>> 1) ^ ((j25 & 1) << 54);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 36028797018963967L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 54)) ^ (j32 >>> 54);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 36028797018963967L;
        long j40 = (j24 >>> 1) ^ (j39 >>> 54);
        long j41 = j40 ^ (j40 << 1);
        long j42 = j41 ^ (j41 << 2);
        long j43 = j42 ^ (j42 << 4);
        long j44 = j43 ^ (j43 << 8);
        long j45 = j44 ^ (j44 << 16);
        long j46 = j45 ^ (j45 << 32);
        jArr3[0] = j19;
        jArr3[1] = (j20 ^ j32) ^ jArr4[2];
        jArr3[2] = ((j21 ^ j39) ^ j32) ^ jArr4[3];
        jArr3[3] = j46 ^ j39;
        jArr3[4] = jArr4[2] ^ j46;
        jArr3[5] = jArr4[3];
        m3572g(jArr3);
    }

    /* renamed from: i */
    public static void m3574i(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = {0, j2, jArr2[1] << 1, jArr2[2] ^ j2, jArr2[2] << 1, jArr2[4] ^ j2, jArr2[3] << 1, jArr2[6] ^ j2};
        long j3 = jArr2[((int) j) & 3];
        long j4 = 0;
        int i2 = 47;
        do {
            int i3 = (int) (j >>> i2);
            long j5 = (jArr2[i3 & 7] ^ (jArr2[(i3 >>> 3) & 7] << 3)) ^ (jArr2[(i3 >>> 6) & 7] << 6);
            j3 ^= j5 << i2;
            j4 ^= j5 >>> (-i2);
            i2 -= 9;
        } while (i2 > 0);
        jArr[i] = 36028797018963967L & j3;
        jArr[i + 1] = (j3 >>> 55) ^ (j4 << 9);
    }

    /* renamed from: j */
    public static void m3575j(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
    }

    /* renamed from: k */
    public static void m3576k(long[] jArr, long[] jArr2) {
        if (h01.m4329v(jArr)) {
            throw new IllegalStateException();
        }
        long[] m4316i = h01.m4316i();
        long[] m4316i2 = h01.m4316i();
        m3581p(jArr, m4316i);
        m3583r(m4316i, 1, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i2, 1, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i, 3, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i2, 3, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i, 9, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i2, 9, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i, 27, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i2, 27, m4316i2);
        m3577l(m4316i, m4316i2, m4316i);
        m3583r(m4316i, 81, m4316i2);
        m3577l(m4316i, m4316i2, jArr2);
    }

    /* renamed from: l */
    public static void m3577l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m4318k = h01.m4318k();
        m3573h(jArr, jArr2, m4318k);
        m3579n(m4318k, jArr3);
    }

    /* renamed from: m */
    public static void m3578m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m4318k = h01.m4318k();
        m3573h(jArr, jArr2, m4318k);
        m3567b(jArr3, m4318k, jArr3);
    }

    /* renamed from: n */
    public static void m3579n(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = j4 ^ ((((j6 >>> 35) ^ (j6 >>> 32)) ^ (j6 >>> 29)) ^ (j6 >>> 28));
        long j8 = (j3 ^ ((((j6 << 29) ^ (j6 << 32)) ^ (j6 << 35)) ^ (j6 << 36))) ^ ((j5 >>> 28) ^ (((j5 >>> 35) ^ (j5 >>> 32)) ^ (j5 >>> 29)));
        long j9 = j ^ ((((j7 << 29) ^ (j7 << 32)) ^ (j7 << 35)) ^ (j7 << 36));
        long j10 = (j2 ^ ((((j5 << 29) ^ (j5 << 32)) ^ (j5 << 35)) ^ (j5 << 36))) ^ ((j7 >>> 28) ^ (((j7 >>> 35) ^ (j7 >>> 32)) ^ (j7 >>> 29)));
        long j11 = j8 >>> 35;
        jArr2[0] = (((j9 ^ j11) ^ (j11 << 3)) ^ (j11 << 6)) ^ (j11 << 7);
        jArr2[1] = j10;
        jArr2[2] = 34359738367L & j8;
    }

    /* renamed from: o */
    public static void m3580o(long[] jArr, long[] jArr2) {
        long[] m4316i = h01.m4316i();
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        m4316i[0] = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        m4316i[1] = m3089e3 >>> 32;
        m3577l(m4316i, f2552a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ (m3089e3 & 4294967295L);
    }

    /* renamed from: p */
    public static void m3581p(long[] jArr, long[] jArr2) {
        long[] m4318k = h01.m4318k();
        m3575j(jArr, m4318k);
        m3579n(m4318k, jArr2);
    }

    /* renamed from: q */
    public static void m3582q(long[] jArr, long[] jArr2) {
        long[] m4318k = h01.m4318k();
        m3575j(jArr, m4318k);
        m3567b(jArr2, m4318k, jArr2);
    }

    /* renamed from: r */
    public static void m3583r(long[] jArr, int i, long[] jArr2) {
        long[] m4318k = h01.m4318k();
        m3575j(jArr, m4318k);
        while (true) {
            m3579n(m4318k, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m3575j(jArr2, m4318k);
            }
        }
    }

    /* renamed from: s */
    public static int m3584s(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 29))) & 1;
    }
}
