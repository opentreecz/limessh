package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class sy0 {
    /* renamed from: a */
    public static void m8532a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: b */
    public static void m8533b(long[] jArr, long[] jArr2, long[] jArr3) {
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
    public static void m8534c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: d */
    public static void m8535d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
        jArr2[3] = jArr2[3] ^ jArr[3];
    }

    /* renamed from: e */
    public static long[] m8536e(BigInteger bigInteger) {
        return p01.m7206q(233, bigInteger);
    }

    /* renamed from: f */
    public static void m8537f(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        j01.m5014h(jArr, jArr2);
        for (int i = 1; i < 233; i += 2) {
            m8542k(jArr2, m5018l);
            m8546o(m5018l, jArr2);
            m8542k(jArr2, m5018l);
            m8546o(m5018l, jArr2);
            m8535d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m8538g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        jArr[0] = j ^ (j2 << 59);
        jArr[1] = (j2 >>> 5) ^ (j3 << 54);
        jArr[2] = (j3 >>> 10) ^ (j4 << 49);
        jArr[3] = (j4 >>> 15) ^ (j5 << 44);
        jArr[4] = (j5 >>> 20) ^ (j6 << 39);
        jArr[5] = (j6 >>> 25) ^ (j7 << 34);
        jArr[6] = (j7 >>> 30) ^ (j8 << 29);
        jArr[7] = j8 >>> 35;
    }

    /* renamed from: h */
    public static void m8539h(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        jArr2[0] = j & 576460752303423487L;
        jArr2[1] = ((j >>> 59) ^ (j2 << 5)) & 576460752303423487L;
        jArr2[2] = ((j2 >>> 54) ^ (j3 << 10)) & 576460752303423487L;
        jArr2[3] = (j3 >>> 49) ^ (j4 << 15);
    }

    /* renamed from: i */
    public static void m8540i(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[4];
        long[] jArr5 = new long[4];
        m8539h(jArr, jArr4);
        m8539h(jArr2, jArr5);
        m8541j(jArr4[0], jArr5[0], jArr3, 0);
        m8541j(jArr4[1], jArr5[1], jArr3, 1);
        m8541j(jArr4[2], jArr5[2], jArr3, 2);
        m8541j(jArr4[3], jArr5[3], jArr3, 3);
        for (int i = 5; i > 0; i--) {
            jArr3[i] = jArr3[i] ^ jArr3[i - 1];
        }
        m8541j(jArr4[0] ^ jArr4[1], jArr5[0] ^ jArr5[1], jArr3, 1);
        m8541j(jArr4[2] ^ jArr4[3], jArr5[2] ^ jArr5[3], jArr3, 3);
        for (int i2 = 7; i2 > 1; i2--) {
            jArr3[i2] = jArr3[i2] ^ jArr3[i2 - 2];
        }
        long j = jArr4[0] ^ jArr4[2];
        long j2 = jArr4[1] ^ jArr4[3];
        long j3 = jArr5[0] ^ jArr5[2];
        long j4 = jArr5[1] ^ jArr5[3];
        m8541j(j ^ j2, j3 ^ j4, jArr3, 3);
        long[] jArr6 = new long[3];
        m8541j(j, j3, jArr6, 0);
        m8541j(j2, j4, jArr6, 1);
        long j5 = jArr6[0];
        long j6 = jArr6[1];
        long j7 = jArr6[2];
        jArr3[2] = jArr3[2] ^ j5;
        jArr3[3] = (j5 ^ j6) ^ jArr3[3];
        jArr3[4] = jArr3[4] ^ (j7 ^ j6);
        jArr3[5] = jArr3[5] ^ j7;
        m8538g(jArr3);
    }

    /* renamed from: j */
    public static void m8541j(long j, long j2, long[] jArr, int i) {
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
        jArr[i] = jArr[i] ^ (576460752303423487L & j3);
        int i5 = i + 1;
        jArr[i5] = jArr[i5] ^ ((j3 >>> 59) ^ (j4 << 5));
    }

    /* renamed from: k */
    public static void m8542k(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        d01.m3086b(jArr[3], jArr2, 6);
    }

    /* renamed from: l */
    public static void m8543l(long[] jArr, long[] jArr2) {
        if (j01.m5029w(jArr)) {
            throw new IllegalStateException();
        }
        long[] m5016j = j01.m5016j();
        long[] m5016j2 = j01.m5016j();
        m8548q(jArr, m5016j);
        m8544m(m5016j, jArr, m5016j);
        m8548q(m5016j, m5016j);
        m8544m(m5016j, jArr, m5016j);
        m8550s(m5016j, 3, m5016j2);
        m8544m(m5016j2, m5016j, m5016j2);
        m8548q(m5016j2, m5016j2);
        m8544m(m5016j2, jArr, m5016j2);
        m8550s(m5016j2, 7, m5016j);
        m8544m(m5016j, m5016j2, m5016j);
        m8550s(m5016j, 14, m5016j2);
        m8544m(m5016j2, m5016j, m5016j2);
        m8548q(m5016j2, m5016j2);
        m8544m(m5016j2, jArr, m5016j2);
        m8550s(m5016j2, 29, m5016j);
        m8544m(m5016j, m5016j2, m5016j);
        m8550s(m5016j, 58, m5016j2);
        m8544m(m5016j2, m5016j, m5016j2);
        m8550s(m5016j2, 116, m5016j);
        m8544m(m5016j, m5016j2, m5016j);
        m8548q(m5016j, jArr2);
    }

    /* renamed from: m */
    public static void m8544m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m8540i(jArr, jArr2, m5018l);
        m8546o(m5018l, jArr3);
    }

    /* renamed from: n */
    public static void m8545n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m5018l = j01.m5018l();
        m8540i(jArr, jArr2, m5018l);
        m8533b(jArr3, m5018l, jArr3);
    }

    /* renamed from: o */
    public static void m8546o(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        long j7 = jArr[6];
        long j8 = jArr[7];
        long j9 = j6 ^ (j8 >>> 31);
        long j10 = (j5 ^ ((j8 >>> 41) ^ (j8 << 33))) ^ (j7 >>> 31);
        long j11 = ((j4 ^ (j8 << 23)) ^ ((j7 >>> 41) ^ (j7 << 33))) ^ (j9 >>> 31);
        long j12 = j ^ (j10 << 23);
        long j13 = (j2 ^ (j9 << 23)) ^ ((j10 >>> 41) ^ (j10 << 33));
        long j14 = ((j3 ^ (j7 << 23)) ^ ((j9 >>> 41) ^ (j9 << 33))) ^ (j10 >>> 31);
        long j15 = j11 >>> 41;
        jArr2[0] = j12 ^ j15;
        jArr2[1] = (j15 << 10) ^ j13;
        jArr2[2] = j14;
        jArr2[3] = 2199023255551L & j11;
    }

    /* renamed from: p */
    public static void m8547p(long[] jArr, long[] jArr2) {
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        long j2 = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        long m3089e4 = d01.m3089e(jArr[3]);
        long j3 = (4294967295L & m3089e3) | (m3089e4 << 32);
        long j4 = (m3089e3 >>> 32) | (m3089e4 & (-4294967296L));
        long j5 = j4 >>> 27;
        long j6 = j4 ^ ((j2 >>> 27) | (j4 << 37));
        long j7 = j2 ^ (j2 << 37);
        long[] m5018l = j01.m5018l();
        int[] iArr = {32, 117, 191};
        int i = 0;
        for (int i2 = 3; i < i2; i2 = 3) {
            int i3 = iArr[i] >>> 6;
            int i4 = iArr[i] & 63;
            m5018l[i3] = m5018l[i3] ^ (j7 << i4);
            int i5 = i3 + 1;
            int i6 = -i4;
            m5018l[i5] = m5018l[i5] ^ ((j6 << i4) | (j7 >>> i6));
            int i7 = i3 + 2;
            m5018l[i7] = m5018l[i7] ^ ((j5 << i4) | (j6 >>> i6));
            int i8 = i3 + 3;
            m5018l[i8] = m5018l[i8] ^ (j5 >>> i6);
            i++;
        }
        m8546o(m5018l, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ j3;
    }

    /* renamed from: q */
    public static void m8548q(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m8542k(jArr, m5018l);
        m8546o(m5018l, jArr2);
    }

    /* renamed from: r */
    public static void m8549r(long[] jArr, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m8542k(jArr, m5018l);
        m8533b(jArr2, m5018l, jArr2);
    }

    /* renamed from: s */
    public static void m8550s(long[] jArr, int i, long[] jArr2) {
        long[] m5018l = j01.m5018l();
        m8542k(jArr, m5018l);
        while (true) {
            m8546o(m5018l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m8542k(jArr2, m5018l);
            }
        }
    }

    /* renamed from: t */
    public static int m8551t(long[] jArr) {
        return ((int) (jArr[0] ^ (jArr[2] >>> 31))) & 1;
    }
}
