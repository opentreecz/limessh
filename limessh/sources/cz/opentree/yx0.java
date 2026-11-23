package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class yx0 {

    /* renamed from: a */
    public static final long[] f8348a = {2791191049453778211L, 2791191049453778402L, 6};

    /* renamed from: a */
    public static void m10236a(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: b */
    public static void m10237b(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr3[0] = jArr[0] ^ jArr2[0];
        jArr3[1] = jArr[1] ^ jArr2[1];
        jArr3[2] = jArr[2] ^ jArr2[2];
        jArr3[3] = jArr[3] ^ jArr2[3];
        jArr3[4] = jArr2[4] ^ jArr[4];
    }

    /* renamed from: c */
    public static void m10238c(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
    }

    /* renamed from: d */
    public static void m10239d(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr2[0] ^ jArr[0];
        jArr2[1] = jArr2[1] ^ jArr[1];
        jArr2[2] = jArr2[2] ^ jArr[2];
    }

    /* renamed from: e */
    public static long[] m10240e(BigInteger bigInteger) {
        return p01.m7206q(KeycodeConstants.KEYCODE_F1, bigInteger);
    }

    /* renamed from: f */
    public static void m10241f(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(5);
        h01.m4314g(jArr, jArr2);
        for (int i = 1; i < 131; i += 2) {
            m10245j(jArr2, m7201l);
            m10249n(m7201l, jArr2);
            m10245j(jArr2, m7201l);
            m10249n(m7201l, jArr2);
            m10239d(jArr, jArr2);
        }
    }

    /* renamed from: g */
    public static void m10242g(long[] jArr) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = jArr[5];
        jArr[0] = j ^ (j2 << 44);
        jArr[1] = (j2 >>> 20) ^ (j3 << 24);
        jArr[2] = ((j3 >>> 40) ^ (j4 << 4)) ^ (j5 << 48);
        jArr[3] = ((j4 >>> 60) ^ (j6 << 28)) ^ (j5 >>> 16);
        jArr[4] = j6 >>> 36;
        jArr[5] = 0;
    }

    /* renamed from: h */
    public static void m10243h(long[] jArr, long[] jArr2, long[] jArr3) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = ((jArr[2] << 40) ^ (j2 >>> 24)) & 17592186044415L;
        long j4 = ((j2 << 20) ^ (j >>> 44)) & 17592186044415L;
        long j5 = j & 17592186044415L;
        long j6 = jArr2[0];
        long j7 = jArr2[1];
        long j8 = ((j7 >>> 24) ^ (jArr2[2] << 40)) & 17592186044415L;
        long j9 = ((j6 >>> 44) ^ (j7 << 20)) & 17592186044415L;
        long j10 = j6 & 17592186044415L;
        long[] jArr4 = new long[10];
        m10244i(j5, j10, jArr4, 0);
        m10244i(j3, j8, jArr4, 2);
        long j11 = (j5 ^ j4) ^ j3;
        long j12 = (j10 ^ j9) ^ j8;
        m10244i(j11, j12, jArr4, 4);
        long j13 = (j4 << 1) ^ (j3 << 2);
        long j14 = (j9 << 1) ^ (j8 << 2);
        m10244i(j5 ^ j13, j10 ^ j14, jArr4, 6);
        m10244i(j11 ^ j13, j12 ^ j14, jArr4, 8);
        long j15 = jArr4[6] ^ jArr4[8];
        long j16 = jArr4[7] ^ jArr4[9];
        long j17 = (j15 << 1) ^ jArr4[6];
        long j18 = (j15 ^ (j16 << 1)) ^ jArr4[7];
        long j19 = jArr4[0];
        long j20 = (jArr4[1] ^ jArr4[0]) ^ jArr4[4];
        long j21 = jArr4[1] ^ jArr4[5];
        long j22 = ((j17 ^ j19) ^ (jArr4[2] << 4)) ^ (jArr4[2] << 1);
        long j23 = (((j20 ^ j18) ^ (jArr4[3] << 4)) ^ (jArr4[3] << 1)) ^ (j22 >>> 44);
        long j24 = (j21 ^ j16) ^ (j23 >>> 44);
        long j25 = j23 & 17592186044415L;
        long j26 = ((j22 & 17592186044415L) >>> 1) ^ ((j25 & 1) << 43);
        long j27 = j26 ^ (j26 << 1);
        long j28 = j27 ^ (j27 << 2);
        long j29 = j28 ^ (j28 << 4);
        long j30 = j29 ^ (j29 << 8);
        long j31 = j30 ^ (j30 << 16);
        long j32 = (j31 ^ (j31 << 32)) & 17592186044415L;
        long j33 = ((j25 >>> 1) ^ ((j24 & 1) << 43)) ^ (j32 >>> 43);
        long j34 = j33 ^ (j33 << 1);
        long j35 = j34 ^ (j34 << 2);
        long j36 = j35 ^ (j35 << 4);
        long j37 = j36 ^ (j36 << 8);
        long j38 = j37 ^ (j37 << 16);
        long j39 = (j38 ^ (j38 << 32)) & 17592186044415L;
        long j40 = (j39 >>> 43) ^ (j24 >>> 1);
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
        m10242g(jArr3);
    }

    /* renamed from: i */
    public static void m10244i(long j, long j2, long[] jArr, int i) {
        long[] jArr2 = {0, j2, jArr2[1] << 1, jArr2[2] ^ j2, jArr2[2] << 1, jArr2[4] ^ j2, jArr2[3] << 1, jArr2[6] ^ j2};
        int i2 = (int) j;
        long j3 = (jArr2[(i2 >>> 6) & 7] << 6) ^ (jArr2[i2 & 7] ^ (jArr2[(i2 >>> 3) & 7] << 3));
        long j4 = 0;
        int i3 = 33;
        do {
            int i4 = (int) (j >>> i3);
            long j5 = ((jArr2[i4 & 7] ^ (jArr2[(i4 >>> 3) & 7] << 3)) ^ (jArr2[(i4 >>> 6) & 7] << 6)) ^ (jArr2[(i4 >>> 9) & 7] << 9);
            j3 ^= j5 << i3;
            j4 ^= j5 >>> (-i3);
            i3 -= 12;
        } while (i3 > 0);
        jArr[i] = 17592186044415L & j3;
        jArr[i + 1] = (j3 >>> 44) ^ (j4 << 20);
    }

    /* renamed from: j */
    public static void m10245j(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        jArr2[4] = d01.m3087c((int) jArr[2]) & 4294967295L;
    }

    /* renamed from: k */
    public static void m10246k(long[] jArr, long[] jArr2) {
        if (h01.m4329v(jArr)) {
            throw new IllegalStateException();
        }
        long[] m4316i = h01.m4316i();
        long[] m4316i2 = h01.m4316i();
        m10251p(jArr, m4316i);
        m10247l(m4316i, jArr, m4316i);
        m10253r(m4316i, 2, m4316i2);
        m10247l(m4316i2, m4316i, m4316i2);
        m10253r(m4316i2, 4, m4316i);
        m10247l(m4316i, m4316i2, m4316i);
        m10253r(m4316i, 8, m4316i2);
        m10247l(m4316i2, m4316i, m4316i2);
        m10253r(m4316i2, 16, m4316i);
        m10247l(m4316i, m4316i2, m4316i);
        m10253r(m4316i, 32, m4316i2);
        m10247l(m4316i2, m4316i, m4316i2);
        m10251p(m4316i2, m4316i2);
        m10247l(m4316i2, jArr, m4316i2);
        m10253r(m4316i2, 65, m4316i);
        m10247l(m4316i, m4316i2, m4316i);
        m10251p(m4316i, jArr2);
    }

    /* renamed from: l */
    public static void m10247l(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m4318k = h01.m4318k();
        m10243h(jArr, jArr2, m4318k);
        m10249n(m4318k, jArr3);
    }

    /* renamed from: m */
    public static void m10248m(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m4318k = h01.m4318k();
        m10243h(jArr, jArr2, m4318k);
        m10237b(jArr3, m4318k, jArr3);
    }

    /* renamed from: n */
    public static void m10249n(long[] jArr, long[] jArr2) {
        long j = jArr[0];
        long j2 = jArr[1];
        long j3 = jArr[2];
        long j4 = jArr[3];
        long j5 = jArr[4];
        long j6 = j4 ^ (j5 >>> 59);
        long j7 = j ^ ((j6 << 61) ^ (j6 << 63));
        long j8 = (j2 ^ ((j5 << 61) ^ (j5 << 63))) ^ ((((j6 >>> 3) ^ (j6 >>> 1)) ^ j6) ^ (j6 << 5));
        long j9 = (j3 ^ ((((j5 >>> 3) ^ (j5 >>> 1)) ^ j5) ^ (j5 << 5))) ^ (j6 >>> 59);
        long j10 = j9 >>> 3;
        jArr2[0] = (((j7 ^ j10) ^ (j10 << 2)) ^ (j10 << 3)) ^ (j10 << 8);
        jArr2[1] = (j10 >>> 56) ^ j8;
        jArr2[2] = 7 & j9;
    }

    /* renamed from: o */
    public static void m10250o(long[] jArr, long[] jArr2) {
        long[] m4316i = h01.m4316i();
        long m3089e = d01.m3089e(jArr[0]);
        long m3089e2 = d01.m3089e(jArr[1]);
        long j = (m3089e & 4294967295L) | (m3089e2 << 32);
        m4316i[0] = (m3089e >>> 32) | (m3089e2 & (-4294967296L));
        long m3089e3 = d01.m3089e(jArr[2]);
        m4316i[1] = m3089e3 >>> 32;
        m10247l(m4316i, f8348a, jArr2);
        jArr2[0] = jArr2[0] ^ j;
        jArr2[1] = jArr2[1] ^ (m3089e3 & 4294967295L);
    }

    /* renamed from: p */
    public static void m10251p(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(5);
        m10245j(jArr, m7201l);
        m10249n(m7201l, jArr2);
    }

    /* renamed from: q */
    public static void m10252q(long[] jArr, long[] jArr2) {
        long[] m7201l = p01.m7201l(5);
        m10245j(jArr, m7201l);
        m10237b(jArr2, m7201l, jArr2);
    }

    /* renamed from: r */
    public static void m10253r(long[] jArr, int i, long[] jArr2) {
        long[] m7201l = p01.m7201l(5);
        m10245j(jArr, m7201l);
        while (true) {
            m10249n(m7201l, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m10245j(jArr2, m7201l);
            }
        }
    }

    /* renamed from: s */
    public static int m10254s(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[1] >>> 59)) ^ (jArr[2] >>> 1))) & 1;
    }
}
