package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class hx0 {

    /* renamed from: a */
    public static final int[] f3241a = {-1, -1, -1, 0, 0, 0, 1, -1};

    /* renamed from: b */
    public static final int[] f3242b = {1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2};

    /* renamed from: a */
    public static void m4666a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5007a(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && j01.m5025s(iArr3, f3241a))) {
            m4668c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m4667b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && j01.m5025s(iArr2, f3241a))) {
            m4668c(iArr2);
        }
    }

    /* renamed from: c */
    public static void m4668c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + ((iArr[3] & 4294967295L) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + ((iArr[6] & 4294967295L) - 1);
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + (4294967295L & iArr[7]) + 1);
    }

    /* renamed from: d */
    public static int[] m4669d(BigInteger bigInteger) {
        int[] m5022p = j01.m5022p(bigInteger);
        if (m5022p[7] == -1) {
            int[] iArr = f3241a;
            if (j01.m5025s(m5022p, iArr)) {
                j01.m5003I(iArr, m5022p);
            }
        }
        return m5022p;
    }

    /* renamed from: e */
    public static void m4670e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m5017k = j01.m5017k();
        j01.m5031y(iArr, iArr2, m5017k);
        m4673h(m5017k, iArr3);
    }

    /* renamed from: f */
    public static void m4671f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m4997C(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && p01.m7208s(16, iArr3, f3242b))) {
            p01.m7185P(16, f3242b, iArr3);
        }
    }

    /* renamed from: g */
    public static void m4672g(int[] iArr, int[] iArr2) {
        if (j01.m5028v(iArr)) {
            j01.m5006L(iArr2);
        } else {
            j01.m5002H(f3241a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m4673h(int[] iArr, int[] iArr2) {
        long j = iArr[9] & 4294967295L;
        long j2 = iArr[10] & 4294967295L;
        long j3 = iArr[11] & 4294967295L;
        long j4 = iArr[12] & 4294967295L;
        long j5 = iArr[13] & 4294967295L;
        long j6 = iArr[14] & 4294967295L;
        long j7 = iArr[15] & 4294967295L;
        long j8 = (iArr[8] & 4294967295L) - 6;
        long j9 = j8 + j;
        long j10 = j + j2;
        long j11 = (j2 + j3) - j7;
        long j12 = j3 + j4;
        long j13 = j4 + j5;
        long j14 = j5 + j6;
        long j15 = j6 + j7;
        long j16 = j14 - j9;
        long j17 = (((iArr[0] & 4294967295L) - j12) - j16) + 0;
        iArr2[0] = (int) j17;
        long j18 = (j17 >> 32) + ((((iArr[1] & 4294967295L) + j10) - j13) - j15);
        iArr2[1] = (int) j18;
        long j19 = (j18 >> 32) + (((iArr[2] & 4294967295L) + j11) - j14);
        iArr2[2] = (int) j19;
        long j20 = (j19 >> 32) + ((((iArr[3] & 4294967295L) + (j12 << 1)) + j16) - j15);
        iArr2[3] = (int) j20;
        long j21 = (j20 >> 32) + ((((iArr[4] & 4294967295L) + (j13 << 1)) + j6) - j10);
        iArr2[4] = (int) j21;
        long j22 = (j21 >> 32) + (((iArr[5] & 4294967295L) + (j14 << 1)) - j11);
        iArr2[5] = (int) j22;
        long j23 = (j22 >> 32) + (iArr[6] & 4294967295L) + (j15 << 1) + j16;
        iArr2[6] = (int) j23;
        long j24 = (j23 >> 32) + (((((iArr[7] & 4294967295L) + (j7 << 1)) + j8) - j11) - j13);
        iArr2[7] = (int) j24;
        m4674i((int) ((j24 >> 32) + 6), iArr2);
    }

    /* renamed from: i */
    public static void m4674i(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + ((iArr[3] & 4294967295L) - j2);
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr[4] & 4294967295L);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (iArr[5] & 4294967295L);
                iArr[5] = (int) j10;
                j8 = j10 >> 32;
            }
            long j11 = j8 + ((iArr[6] & 4294967295L) - j2);
            iArr[6] = (int) j11;
            long j12 = (j11 >> 32) + (4294967295L & iArr[7]) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || (iArr[7] == -1 && j01.m5025s(iArr, f3241a))) {
            m4668c(iArr);
        }
    }

    /* renamed from: j */
    public static void m4675j(int[] iArr, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        m4673h(m5017k, iArr2);
    }

    /* renamed from: k */
    public static void m4676k(int[] iArr, int i, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        while (true) {
            m4673h(m5017k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                j01.m5000F(iArr2, m5017k);
            }
        }
    }

    /* renamed from: l */
    public static void m4677l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        long j5 = j2 + (iArr[3] & 4294967295L) + 1;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            j6 = j8 >> 32;
        }
        long j9 = j6 + (iArr[6] & 4294967295L) + 1;
        iArr[6] = (int) j9;
        iArr[7] = (int) ((j9 >> 32) + ((4294967295L & iArr[7]) - 1));
    }

    /* renamed from: m */
    public static void m4678m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5002H(iArr, iArr2, iArr3) != 0) {
            m4677l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m4679n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && j01.m5025s(iArr2, f3241a))) {
            m4668c(iArr2);
        }
    }
}
