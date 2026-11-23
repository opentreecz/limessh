package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class cz0 {

    /* renamed from: a */
    public static final long[] f2087a = {878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042};

    /* renamed from: a */
    public static void m3063a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: b */
    public static void m3064b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr[4] ^ jArr2[4];
        jArr3[5] = jArr[5] ^ jArr2[5];
        jArr3[6] = jArr[6] ^ jArr2[6];
        jArr3[7] = jArr[7] ^ jArr2[7];
        jArr3[8] = jArr2[8] ^ jArr[8];
    }

    /* renamed from: c */
    public static void m3065c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
    }

    /* renamed from: d */
    public static void m3066d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
        jArr2[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: e */
    public static long[] m3067e(BigInteger bigInteger) {
        return p01.m7206q(283, bigInteger);
    }

    /* renamed from: f */
    public static void m3068f(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(9);
        k01.m5765b(jArr, jArr2);
        for (int i = 1; i < 283; i += 2) {
            m3073k(jArr2, m7201l);
            m3077o(m7201l, jArr2);
            m3073k(jArr2, m7201l);
            m3077o(m7201l, jArr2);
            m3066d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m3069g(long[] jArr) {
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
        jArr[0] = j ^ (j2 << 57);
        jArr[1] = (j2 >>> 7) ^ (j3 << 50);
        jArr[2] = (j3 >>> 14) ^ (j4 << 43);
        jArr[3] = (j4 >>> 21) ^ (j5 << 36);
        jArr[4] = (j5 >>> 28) ^ (j6 << 29);
        jArr[5] = (j6 >>> 35) ^ (j7 << 22);
        jArr[6] = (j7 >>> 42) ^ (j8 << 15);
        jArr[7] = (j8 >>> 49) ^ (j9 << 8);
        jArr[8] = (j9 >>> 56) ^ (j10 << 1);
        jArr[9] = j10 >>> 63;
    }

    /* renamed from: h */
    public static void m3070h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        jArr2[0] = j & 144115188075855871L;
        jArr2[1] = ((j >>> 57) ^ (j2 << 7)) & 144115188075855871L;
        jArr2[2] = ((j2 >>> 50) ^ (j3 << 14)) & 144115188075855871L;
        jArr2[3] = ((j3 >>> 43) ^ (j4 << 21)) & 144115188075855871L;
        jArr2[4] = (j4 >>> 36) ^ (j5 << 28);
    }

    /* renamed from: i */
    public static void m3071i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[5];
        long[] jArr5 = new long[5];
        m3070h(jArr, jArr4);
        m3070h(jArr2, jArr5);
        long[] jArr6 = new long[26];
        m3072j(jArr4[0], jArr5[0], jArr6, 0);
        m3072j(jArr4[1], jArr5[1], jArr6, 2);
        m3072j(jArr4[2], jArr5[2], jArr6, 4);
        m3072j(jArr4[3], jArr5[3], jArr6, 6);
        m3072j(jArr4[4], jArr5[4], jArr6, 8);
        long j = jArr4[0] ^ jArr4[1];
        long j2 = jArr5[0] ^ jArr5[1];
        long j3 = jArr4[0] ^ jArr4[2];
        long j4 = jArr5[0] ^ jArr5[2];
        long j5 = jArr4[2] ^ jArr4[4];
        long j6 = jArr5[2] ^ jArr5[4];
        long j7 = jArr4[3] ^ jArr4[4];
        long j8 = jArr5[3] ^ jArr5[4];
        m3072j(j3 ^ jArr4[3], j4 ^ jArr5[3], jArr6, 18);
        m3072j(j5 ^ jArr4[1], j6 ^ jArr5[1], jArr6, 20);
        long j9 = j ^ j7;
        long j10 = j2 ^ j8;
        long j11 = j9 ^ jArr4[2];
        long j12 = jArr5[2] ^ j10;
        m3072j(j9, j10, jArr6, 22);
        m3072j(j11, j12, jArr6, 24);
        m3072j(j, j2, jArr6, 10);
        m3072j(j3, j4, jArr6, 12);
        m3072j(j5, j6, jArr6, 14);
        m3072j(j7, j8, jArr6, 16);
        jArr3[0] = jArr6[0];
        jArr3[9] = jArr6[9];
        long j13 = jArr6[0] ^ jArr6[1];
        long j14 = jArr6[2] ^ j13;
        long j15 = jArr6[10] ^ j14;
        jArr3[1] = j15;
        long j16 = jArr6[3] ^ jArr6[4];
        long j17 = j14 ^ (j16 ^ (jArr6[11] ^ jArr6[12]));
        jArr3[2] = j17;
        long j18 = jArr6[5] ^ jArr6[6];
        long j19 = ((j13 ^ j16) ^ j18) ^ jArr6[8];
        long j20 = jArr6[13] ^ jArr6[14];
        jArr3[3] = (j19 ^ j20) ^ ((jArr6[18] ^ jArr6[22]) ^ jArr6[24]);
        long j21 = (jArr6[7] ^ jArr6[8]) ^ jArr6[9];
        long j22 = j21 ^ jArr6[17];
        jArr3[8] = j22;
        long j23 = (j21 ^ j18) ^ (jArr6[15] ^ jArr6[16]);
        jArr3[7] = j23;
        long j24 = j15 ^ j23;
        long j25 = (jArr6[19] ^ jArr6[20]) ^ (jArr6[25] ^ jArr6[24]);
        jArr3[4] = (j25 ^ (jArr6[18] ^ jArr6[23])) ^ j24;
        jArr3[5] = ((j17 ^ j22) ^ j25) ^ (jArr6[21] ^ jArr6[22]);
        jArr3[6] = ((((jArr6[9] ^ (j19 ^ jArr6[0])) ^ j20) ^ jArr6[21]) ^ jArr6[23]) ^ jArr6[25];
        m3069g(jArr3);
    }

    /* renamed from: j */
    public static void m3072j(long j, long j2, long[] jArr, int i) {
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

    /* renamed from: k */
    public static void m3073k(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        d01.m3086b(jArr[3], jArr2, 6);
        jArr2[8] = d01.m3085a((int) jArr[4]);
    }

    /* renamed from: l */
    public static void m3074l(long[] jArr, long[] jArr2) {
        if (k01.m5770g(jArr)) {
            throw new IllegalStateException();
        }
        long[] m5766c = k01.m5766c();
        long[] m5766c2 = k01.m5766c();
        m3079q(jArr, m5766c);
        m3075m(m5766c, jArr, m5766c);
        m3081s(m5766c, 2, m5766c2);
        m3075m(m5766c2, m5766c, m5766c2);
        m3081s(m5766c2, 4, m5766c);
        m3075m(m5766c, m5766c2, m5766c);
        m3081s(m5766c, 8, m5766c2);
        m3075m(m5766c2, m5766c, m5766c2);
        m3079q(m5766c2, m5766c2);
        m3075m(m5766c2, jArr, m5766c2);
        m3081s(m5766c2, 17, m5766c);
        m3075m(m5766c, m5766c2, m5766c);
        m3079q(m5766c, m5766c);
        m3075m(m5766c, jArr, m5766c);
        m3081s(m5766c, 35, m5766c2);
        m3075m(m5766c2, m5766c, m5766c2);
        m3081s(m5766c2, 70, m5766c);
        m3075m(m5766c, m5766c2, m5766c);
        m3079q(m5766c, m5766c);
        m3075m(m5766c, jArr, m5766c);
        m3081s(m5766c, KeycodeConstants.KEYCODE_F11, m5766c2);
        m3075m(m5766c2, m5766c, m5766c2);
        m3079q(m5766c2, jArr2);
    }

    /* renamed from: m */
    public static void m3075m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5767d = k01.m5767d();
        m3071i(jArr, jArr2, m5767d);
        m3077o(m5767d, jArr3);
    }

    /* renamed from: n */
    public static void m3076n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5767d = k01.m5767d();
        m3071i(jArr, jArr2, m5767d);
        m3064b(jArr3, m5767d, jArr3);
    }

    /* renamed from: o */
    public static void m3077o(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = jArr[8];
        long j10 = j5 ^ ((((j9 >>> 27) ^ (j9 >>> 22)) ^ (j9 >>> 20)) ^ (j9 >>> 15));
        long j11 = j ^ ((((j6 << 37) ^ (j6 << 42)) ^ (j6 << 44)) ^ (j6 << 49));
        long j12 = (j2 ^ ((((j7 << 37) ^ (j7 << 42)) ^ (j7 << 44)) ^ (j7 << 49))) ^ ((((j6 >>> 27) ^ (j6 >>> 22)) ^ (j6 >>> 20)) ^ (j6 >>> 15));
        long j13 = j10 >>> 27;
        jArr2[0] = (((j11 ^ j13) ^ (j13 << 5)) ^ (j13 << 7)) ^ (j13 << 12);
        jArr2[1] = j12;
        jArr2[2] = (j3 ^ ((((j8 << 37) ^ (j8 << 42)) ^ (j8 << 44)) ^ (j8 << 49))) ^ ((((j7 >>> 27) ^ (j7 >>> 22)) ^ (j7 >>> 20)) ^ (j7 >>> 15));
        jArr2[3] = (j4 ^ ((((j9 << 37) ^ (j9 << 42)) ^ (j9 << 44)) ^ (j9 << 49))) ^ ((((j8 >>> 27) ^ (j8 >>> 22)) ^ (j8 >>> 20)) ^ (j8 >>> 15));
        jArr2[4] = 134217727 & j10;
    }

    /* renamed from: p */
    public static void m3078p(long[] jArr, long[] jArr2) {
        long[] m5766c = k01.m5766c();
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        m5766c[0] = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        long m3089e4 = d01.m3089e(jArr[3]);
        long j2 = (m3089e3 & 4294967295L) | (m3089e4 << 32);
        m5766c[1] = (m3089e3 >>> 32) | ((-4294967296L) & m3089e4);
        long m3089e5 = d01.m3089e(jArr[4]);
        m5766c[2] = m3089e5 >>> 32;
        m3075m(m5766c, f2087a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j2;
        jArr2[2] = jArr2[2] ^ (4294967295L & m3089e5);
    }

    /* renamed from: q */
    public static void m3079q(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(9);
        m3073k(jArr, m7201l);
        m3077o(m7201l, jArr2);
    }

    /* renamed from: r */
    public static void m3080r(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(9);
        m3073k(jArr, m7201l);
        m3064b(jArr2, m7201l, jArr2);
    }

    /* renamed from: s */
    public static void m3081s(long[] jArr, int i, long[] jArr2) {
        long[] m7201l = p01.m7201l(9);
        m3073k(jArr, m7201l);
        while (true) {
            m3077o(m7201l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m3073k(jArr2, m7201l);
            }
        }
    }

    /* renamed from: t */
    public static int m3082t(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[4] >>> 15))) & 1;
    }
}
