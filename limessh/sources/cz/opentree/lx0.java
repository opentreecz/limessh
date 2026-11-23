package cz.opentree;

import com.sun.jna.Function;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class lx0 {

    /* renamed from: a */
    public static final int[] f4924a = {-1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f4925b = {1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f4926c = {-1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2};

    /* renamed from: a */
    public static void m6306a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (p01.m7190a(12, iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && p01.m7208s(12, iArr3, f4924a))) {
            m6309d(iArr3);
        }
    }

    /* renamed from: b */
    public static void m6307b(int[] iArr, int[] iArr2, int[] iArr3) {
        if (p01.m7190a(24, iArr, iArr2, iArr3) != 0 || (iArr3[23] == -1 && p01.m7208s(24, iArr3, f4925b))) {
            int[] iArr4 = f4926c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(24, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: c */
    public static void m6308c(int[] iArr, int[] iArr2) {
        if (p01.m7210u(12, iArr, iArr2) != 0 || (iArr2[11] == -1 && p01.m7208s(12, iArr2, f4924a))) {
            m6309d(iArr2);
        }
    }

    /* renamed from: d */
    public static void m6309d(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & 4294967295L) - 1);
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + (iArr[3] & 4294967295L) + 1;
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + (4294967295L & iArr[4]) + 1;
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            p01.m7211v(12, iArr, 5);
        }
    }

    /* renamed from: e */
    public static int[] m6310e(BigInteger bigInteger) {
        int[] m7205p = p01.m7205p(Function.USE_VARARGS, bigInteger);
        if (m7205p[11] == -1) {
            int[] iArr = f4924a;
            if (p01.m7208s(12, m7205p, iArr)) {
                p01.m7185P(12, iArr, m7205p);
            }
        }
        return m7205p;
    }

    /* renamed from: f */
    public static void m6311f(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m7200k = p01.m7200k(24);
        l01.m6038a(iArr, iArr2, m7200k);
        m6313h(m7200k, iArr3);
    }

    /* renamed from: g */
    public static void m6312g(int[] iArr, int[] iArr2) {
        if (p01.m7214y(12, iArr)) {
            p01.m7188S(12, iArr2);
        } else {
            p01.m7182M(12, f4924a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m6313h(int[] iArr, int[] iArr2) {
        long j = iArr[16] & 4294967295L;
        long j2 = iArr[17] & 4294967295L;
        long j3 = iArr[18] & 4294967295L;
        long j4 = iArr[19] & 4294967295L;
        long j5 = iArr[20] & 4294967295L;
        long j6 = iArr[21] & 4294967295L;
        long j7 = iArr[22] & 4294967295L;
        long j8 = iArr[23] & 4294967295L;
        long j9 = ((iArr[12] & 4294967295L) + j5) - 1;
        long j10 = (iArr[13] & 4294967295L) + j7;
        long j11 = (iArr[14] & 4294967295L) + j7 + j8;
        long j12 = (iArr[15] & 4294967295L) + j8;
        long j13 = j2 + j6;
        long j14 = j6 - j8;
        long j15 = j7 - j8;
        long j16 = j9 + j14;
        long j17 = (iArr[0] & 4294967295L) + j16 + 0;
        iArr2[0] = (int) j17;
        long j18 = (j17 >> 32) + (((iArr[1] & 4294967295L) + j8) - j9) + j10;
        iArr2[1] = (int) j18;
        long j19 = (j18 >> 32) + (((iArr[2] & 4294967295L) - j6) - j10) + j11;
        iArr2[2] = (int) j19;
        long j20 = (j19 >> 32) + ((iArr[3] & 4294967295L) - j11) + j12 + j16;
        iArr2[3] = (int) j20;
        long j21 = (j20 >> 32) + (((((iArr[4] & 4294967295L) + j) + j6) + j10) - j12) + j16;
        iArr2[4] = (int) j21;
        long j22 = (j21 >> 32) + ((iArr[5] & 4294967295L) - j) + j10 + j11 + j13;
        iArr2[5] = (int) j22;
        long j23 = (j22 >> 32) + (((iArr[6] & 4294967295L) + j3) - j2) + j11 + j12;
        iArr2[6] = (int) j23;
        long j24 = (j23 >> 32) + ((((iArr[7] & 4294967295L) + j) + j4) - j3) + j12;
        iArr2[7] = (int) j24;
        long j25 = (j24 >> 32) + (((((iArr[8] & 4294967295L) + j) + j2) + j5) - j4);
        iArr2[8] = (int) j25;
        long j26 = (j25 >> 32) + (((iArr[9] & 4294967295L) + j3) - j5) + j13;
        iArr2[9] = (int) j26;
        long j27 = (j26 >> 32) + ((((iArr[10] & 4294967295L) + j3) + j4) - j14) + j15;
        iArr2[10] = (int) j27;
        long j28 = (j27 >> 32) + ((((iArr[11] & 4294967295L) + j4) + j5) - j15);
        iArr2[11] = (int) j28;
        m6314i((int) ((j28 >> 32) + 1), iArr2);
    }

    /* renamed from: i */
    public static void m6314i(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = (iArr[0] & 4294967295L) + j2 + 0;
            iArr[0] = (int) j3;
            long j4 = (j3 >> 32) + ((iArr[1] & 4294967295L) - j2);
            iArr[1] = (int) j4;
            long j5 = j4 >> 32;
            if (j5 != 0) {
                long j6 = j5 + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j5 = j6 >> 32;
            }
            long j7 = j5 + (iArr[3] & 4294967295L) + j2;
            iArr[3] = (int) j7;
            long j8 = (j7 >> 32) + (4294967295L & iArr[4]) + j2;
            iArr[4] = (int) j8;
            j = j8 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || p01.m7211v(12, iArr, 5) == 0) && !(iArr[11] == -1 && p01.m7208s(12, iArr, f4924a))) {
            return;
        }
        m6309d(iArr);
    }

    /* renamed from: j */
    public static void m6315j(int[] iArr, int[] iArr2) {
        int[] m7200k = p01.m7200k(24);
        l01.m6039b(iArr, m7200k);
        m6313h(m7200k, iArr2);
    }

    /* renamed from: k */
    public static void m6316k(int[] iArr, int i, int[] iArr2) {
        int[] m7200k = p01.m7200k(24);
        l01.m6039b(iArr, m7200k);
        while (true) {
            m6313h(m7200k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                l01.m6039b(iArr2, m7200k);
            }
        }
    }

    /* renamed from: l */
    public static void m6317l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = (j >> 32) + (iArr[1] & 4294967295L) + 1;
        iArr[1] = (int) j2;
        long j3 = j2 >> 32;
        if (j3 != 0) {
            long j4 = j3 + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j3 = j4 >> 32;
        }
        long j5 = j3 + ((iArr[3] & 4294967295L) - 1);
        iArr[3] = (int) j5;
        long j6 = (j5 >> 32) + ((4294967295L & iArr[4]) - 1);
        iArr[4] = (int) j6;
        if ((j6 >> 32) != 0) {
            p01.m7203n(12, iArr, 5);
        }
    }

    /* renamed from: m */
    public static void m6318m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (p01.m7182M(12, iArr, iArr2, iArr3) != 0) {
            m6317l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m6319n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(12, iArr, 0, iArr2) != 0 || (iArr2[11] == -1 && p01.m7208s(12, iArr2, f4924a))) {
            m6309d(iArr2);
        }
    }
}
