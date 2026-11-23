package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class rw0 {

    /* renamed from: a */
    public static final int[] f6296a = {-1, -1, -2, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f6297b = {1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f6298c = {-1, -1, -3, -1, -2, -1, 1, 0, 2};

    /* renamed from: a */
    public static void m8258a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4308a(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && h01.m4325r(iArr3, f6296a))) {
            m8260c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m8259b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && h01.m4325r(iArr2, f6296a))) {
            m8260c(iArr2);
        }
    }

    /* renamed from: c */
    public static void m8260c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + (4294967295L & iArr[2]) + 1;
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            p01.m7211v(6, iArr, 3);
        }
    }

    /* renamed from: d */
    public static int[] m8261d(BigInteger bigInteger) {
        int[] m4322o = h01.m4322o(bigInteger);
        if (m4322o[5] == -1) {
            int[] iArr = f6296a;
            if (h01.m4325r(m4322o, iArr)) {
                h01.m4304G(iArr, m4322o);
            }
        }
        return m4322o;
    }

    /* renamed from: e */
    public static void m8262e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m4317j = h01.m4317j();
        h01.m4331x(iArr, iArr2, m4317j);
        m8265h(m4317j, iArr3);
    }

    /* renamed from: f */
    public static void m8263f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4299B(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && p01.m7208s(12, iArr3, f6297b))) {
            int[] iArr4 = f6298c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: g */
    public static void m8264g(int[] iArr, int[] iArr2) {
        if (h01.m4328u(iArr)) {
            h01.m4307J(iArr2);
        } else {
            h01.m4303F(f6296a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m8265h(int[] iArr, int[] iArr2) {
        long j = iArr[6] & 4294967295L;
        long j2 = iArr[7] & 4294967295L;
        long j3 = (iArr[10] & 4294967295L) + j;
        long j4 = (iArr[11] & 4294967295L) + j2;
        long j5 = (iArr[0] & 4294967295L) + j3 + 0;
        int i = (int) j5;
        long j6 = (j5 >> 32) + (iArr[1] & 4294967295L) + j4;
        iArr2[1] = (int) j6;
        long j7 = j3 + (iArr[8] & 4294967295L);
        long j8 = j4 + (iArr[9] & 4294967295L);
        long j9 = (j6 >> 32) + (iArr[2] & 4294967295L) + j7;
        long j10 = j9 & 4294967295L;
        long j11 = (j9 >> 32) + (iArr[3] & 4294967295L) + j8;
        iArr2[3] = (int) j11;
        long j12 = (j11 >> 32) + (iArr[4] & 4294967295L) + (j7 - j);
        iArr2[4] = (int) j12;
        long j13 = (j12 >> 32) + (iArr[5] & 4294967295L) + (j8 - j2);
        iArr2[5] = (int) j13;
        long j14 = j13 >> 32;
        long j15 = j10 + j14;
        long j16 = j14 + (i & 4294967295L);
        iArr2[0] = (int) j16;
        long j17 = j16 >> 32;
        if (j17 != 0) {
            long j18 = j17 + (4294967295L & iArr2[1]);
            iArr2[1] = (int) j18;
            j15 += j18 >> 32;
        }
        iArr2[2] = (int) j15;
        if (((j15 >> 32) == 0 || p01.m7211v(6, iArr2, 3) == 0) && !(iArr2[5] == -1 && h01.m4325r(iArr2, f6296a))) {
            return;
        }
        m8260c(iArr2);
    }

    /* renamed from: i */
    public static void m8266i(int i, int[] iArr) {
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
            long j6 = j4 + (4294967295L & iArr[2]) + j2;
            iArr[2] = (int) j6;
            j = j6 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || p01.m7211v(6, iArr, 3) == 0) && !(iArr[5] == -1 && h01.m4325r(iArr, f6296a))) {
            return;
        }
        m8260c(iArr);
    }

    /* renamed from: j */
    public static void m8267j(int[] iArr, int[] iArr2) {
        int[] m4317j = h01.m4317j();
        h01.m4301D(iArr, m4317j);
        m8265h(m4317j, iArr2);
    }

    /* renamed from: k */
    public static void m8268k(int[] iArr, int i, int[] iArr2) {
        int[] m4317j = h01.m4317j();
        h01.m4301D(iArr, m4317j);
        while (true) {
            m8265h(m4317j, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                h01.m4301D(iArr2, m4317j);
            }
        }
    }

    /* renamed from: l */
    public static void m8269l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            j2 = j3 >> 32;
        }
        long j4 = j2 + ((4294967295L & iArr[2]) - 1);
        iArr[2] = (int) j4;
        if ((j4 >> 32) != 0) {
            p01.m7203n(6, iArr, 3);
        }
    }

    /* renamed from: m */
    public static void m8270m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4303F(iArr, iArr2, iArr3) != 0) {
            m8269l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m8271n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && h01.m4325r(iArr2, f6296a))) {
            m8260c(iArr2);
        }
    }
}
