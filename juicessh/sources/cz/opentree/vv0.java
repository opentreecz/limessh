package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class vv0 {

    /* renamed from: a */
    public static final int[] f7559a = {-1, -1, 0, -1, -1, -1, -1, -2};

    /* renamed from: b */
    public static final int[] f7560b = {1, 0, -2, 1, 1, -2, 0, 2, -2, -3, 3, -2, -1, -1, 0, -2};

    /* renamed from: a */
    public static void m9346a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5007a(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= Integer.MAX_VALUE && j01.m5025s(iArr3, f7559a))) {
            m9348c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m9347b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(8, iArr, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && j01.m5025s(iArr2, f7559a))) {
            m9348c(iArr2);
        }
    }

    /* renamed from: c */
    public static void m9348c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + ((iArr[2] & 4294967295L) - 1);
        iArr[2] = (int) j4;
        long j5 = (j4 >> 32) + (iArr[3] & 4294967295L) + 1;
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            long j9 = (j8 >> 32) + (iArr[6] & 4294967295L);
            iArr[6] = (int) j9;
            j6 = j9 >> 32;
        }
        iArr[7] = (int) (j6 + (4294967295L & iArr[7]) + 1);
    }

    /* renamed from: d */
    public static int[] m9349d(BigInteger bigInteger) {
        int[] m5022p = j01.m5022p(bigInteger);
        if ((m5022p[7] >>> 1) >= Integer.MAX_VALUE) {
            int[] iArr = f7559a;
            if (j01.m5025s(m5022p, iArr)) {
                j01.m5003I(iArr, m5022p);
            }
        }
        return m5022p;
    }

    /* renamed from: e */
    public static void m9350e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m5017k = j01.m5017k();
        j01.m5031y(iArr, iArr2, m5017k);
        m9353h(m5017k, iArr3);
    }

    /* renamed from: f */
    public static void m9351f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m4997C(iArr, iArr2, iArr3) != 0 || ((iArr3[15] >>> 1) >= Integer.MAX_VALUE && p01.m7208s(16, iArr3, f7560b))) {
            p01.m7185P(16, f7560b, iArr3);
        }
    }

    /* renamed from: g */
    public static void m9352g(int[] iArr, int[] iArr2) {
        if (j01.m5028v(iArr)) {
            j01.m5006L(iArr2);
        } else {
            j01.m5002H(f7559a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m9353h(int[] iArr, int[] iArr2) {
        long j = iArr[8] & 4294967295L;
        long j2 = iArr[9] & 4294967295L;
        long j3 = iArr[10] & 4294967295L;
        long j4 = iArr[11] & 4294967295L;
        long j5 = iArr[12] & 4294967295L;
        long j6 = iArr[13] & 4294967295L;
        long j7 = iArr[14] & 4294967295L;
        long j8 = iArr[15] & 4294967295L;
        long j9 = j3 + j4;
        long j10 = j6 + j7;
        long j11 = j10 + (j8 << 1);
        long j12 = j + j2 + j10;
        long j13 = j9 + j5 + j8 + j12;
        long j14 = (iArr[0] & 4294967295L) + j13 + j6 + j7 + j8 + 0;
        iArr2[0] = (int) j14;
        long j15 = (j14 >> 32) + (((iArr[1] & 4294967295L) + j13) - j) + j7 + j8;
        iArr2[1] = (int) j15;
        long j16 = (j15 >> 32) + ((iArr[2] & 4294967295L) - j12);
        iArr2[2] = (int) j16;
        long j17 = (j16 >> 32) + ((((iArr[3] & 4294967295L) + j13) - j2) - j3) + j6;
        iArr2[3] = (int) j17;
        long j18 = (j17 >> 32) + ((((iArr[4] & 4294967295L) + j13) - j9) - j) + j7;
        iArr2[4] = (int) j18;
        long j19 = (j18 >> 32) + (iArr[5] & 4294967295L) + j11 + j3;
        iArr2[5] = (int) j19;
        long j20 = (j19 >> 32) + (iArr[6] & 4294967295L) + j4 + j7 + j8;
        iArr2[6] = (int) j20;
        long j21 = (j20 >> 32) + (4294967295L & iArr[7]) + j13 + j11 + j5;
        iArr2[7] = (int) j21;
        m9354i((int) (j21 >> 32), iArr2);
    }

    /* renamed from: i */
    public static void m9354i(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j5;
                j4 = j5 >> 32;
            }
            long j6 = j4 + ((iArr[2] & 4294967295L) - j2);
            iArr[2] = (int) j6;
            long j7 = (j6 >> 32) + (iArr[3] & 4294967295L) + j2;
            iArr[3] = (int) j7;
            long j8 = j7 >> 32;
            if (j8 != 0) {
                long j9 = j8 + (iArr[4] & 4294967295L);
                iArr[4] = (int) j9;
                long j10 = (j9 >> 32) + (iArr[5] & 4294967295L);
                iArr[5] = (int) j10;
                long j11 = (j10 >> 32) + (iArr[6] & 4294967295L);
                iArr[6] = (int) j11;
                j8 = j11 >> 32;
            }
            long j12 = j8 + (4294967295L & iArr[7]) + j2;
            iArr[7] = (int) j12;
            j = j12 >> 32;
        } else {
            j = 0;
        }
        if (j != 0 || ((iArr[7] >>> 1) >= Integer.MAX_VALUE && j01.m5025s(iArr, f7559a))) {
            m9348c(iArr);
        }
    }

    /* renamed from: j */
    public static void m9355j(int[] iArr, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        m9353h(m5017k, iArr2);
    }

    /* renamed from: k */
    public static void m9356k(int[] iArr, int i, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        while (true) {
            m9353h(m5017k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                j01.m5000F(iArr2, m5017k);
            }
        }
    }

    /* renamed from: l */
    public static void m9357l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + (iArr[2] & 4294967295L) + 1;
        iArr[2] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[3] & 4294967295L) - 1);
        iArr[3] = (int) j5;
        long j6 = j5 >> 32;
        if (j6 != 0) {
            long j7 = j6 + (iArr[4] & 4294967295L);
            iArr[4] = (int) j7;
            long j8 = (j7 >> 32) + (iArr[5] & 4294967295L);
            iArr[5] = (int) j8;
            long j9 = (j8 >> 32) + (iArr[6] & 4294967295L);
            iArr[6] = (int) j9;
            j6 = j9 >> 32;
        }
        iArr[7] = (int) (j6 + ((4294967295L & iArr[7]) - 1));
    }

    /* renamed from: m */
    public static void m9358m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5002H(iArr, iArr2, iArr3) != 0) {
            m9357l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m9359n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(8, iArr, 0, iArr2) != 0 || ((iArr2[7] >>> 1) >= Integer.MAX_VALUE && j01.m5025s(iArr2, f7559a))) {
            m9348c(iArr2);
        }
    }
}
