package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class zw0 {

    /* renamed from: a */
    public static final int[] f8604a = {1, 0, 0, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f8605b = {1, 0, 0, -2, -1, -1, 0, 2, 0, 0, -2, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f8606c = {-1, -1, -1, 1, 0, 0, -1, -3, -1, -1, 1};

    /* renamed from: a */
    public static void m10647a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4683a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && i01.m4692j(iArr3, f8604a))) {
            m10649c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m10648b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && i01.m4692j(iArr2, f8604a))) {
            m10649c(iArr2);
        }
    }

    /* renamed from: c */
    public static void m10649c(int[] iArr) {
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
        long j5 = j2 + (4294967295L & iArr[3]) + 1;
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            p01.m7211v(7, iArr, 4);
        }
    }

    /* renamed from: d */
    public static int[] m10650d(BigInteger bigInteger) {
        int[] m4690h = i01.m4690h(bigInteger);
        if (m4690h[6] == -1) {
            int[] iArr = f8604a;
            if (i01.m4692j(m4690h, iArr)) {
                i01.m4702t(iArr, m4690h);
            }
        }
        return m4690h;
    }

    /* renamed from: e */
    public static void m10651e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m4688f = i01.m4688f();
        i01.m4695m(iArr, iArr2, m4688f);
        m10654h(m4688f, iArr3);
    }

    /* renamed from: f */
    public static void m10652f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4699q(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && p01.m7208s(14, iArr3, f8605b))) {
            int[] iArr4 = f8606c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: g */
    public static void m10653g(int[] iArr, int[] iArr2) {
        if (i01.m4694l(iArr)) {
            i01.m4704v(iArr2);
        } else {
            i01.m4701s(f8604a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m10654h(int[] iArr, int[] iArr2) {
        long j = iArr[10] & 4294967295L;
        long j2 = iArr[11] & 4294967295L;
        long j3 = iArr[12] & 4294967295L;
        long j4 = iArr[13] & 4294967295L;
        long j5 = ((iArr[7] & 4294967295L) + j2) - 1;
        long j6 = (iArr[8] & 4294967295L) + j3;
        long j7 = (iArr[9] & 4294967295L) + j4;
        long j8 = ((iArr[0] & 4294967295L) - j5) + 0;
        long j9 = j8 & 4294967295L;
        long j10 = (j8 >> 32) + ((iArr[1] & 4294967295L) - j6);
        iArr2[1] = (int) j10;
        long j11 = (j10 >> 32) + ((iArr[2] & 4294967295L) - j7);
        iArr2[2] = (int) j11;
        long j12 = (j11 >> 32) + (((iArr[3] & 4294967295L) + j5) - j);
        long j13 = j12 & 4294967295L;
        long j14 = (j12 >> 32) + (((iArr[4] & 4294967295L) + j6) - j2);
        iArr2[4] = (int) j14;
        long j15 = (j14 >> 32) + (((iArr[5] & 4294967295L) + j7) - j3);
        iArr2[5] = (int) j15;
        long j16 = (j15 >> 32) + (((iArr[6] & 4294967295L) + j) - j4);
        iArr2[6] = (int) j16;
        long j17 = (j16 >> 32) + 1;
        long j18 = j13 + j17;
        long j19 = j9 - j17;
        iArr2[0] = (int) j19;
        long j20 = j19 >> 32;
        if (j20 != 0) {
            long j21 = j20 + (iArr2[1] & 4294967295L);
            iArr2[1] = (int) j21;
            long j22 = (j21 >> 32) + (4294967295L & iArr2[2]);
            iArr2[2] = (int) j22;
            j18 += j22 >> 32;
        }
        iArr2[3] = (int) j18;
        if (((j18 >> 32) == 0 || p01.m7211v(7, iArr2, 4) == 0) && !(iArr2[6] == -1 && i01.m4692j(iArr2, f8604a))) {
            return;
        }
        m10649c(iArr2);
    }

    /* renamed from: i */
    public static void m10655i(int i, int[] iArr) {
        long j;
        if (i != 0) {
            long j2 = i & 4294967295L;
            long j3 = ((iArr[0] & 4294967295L) - j2) + 0;
            iArr[0] = (int) j3;
            long j4 = j3 >> 32;
            if (j4 != 0) {
                long j5 = j4 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j5;
                long j6 = (j5 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j6;
                j4 = j6 >> 32;
            }
            long j7 = j4 + (4294967295L & iArr[3]) + j2;
            iArr[3] = (int) j7;
            j = j7 >> 32;
        } else {
            j = 0;
        }
        if ((j == 0 || p01.m7211v(7, iArr, 4) == 0) && !(iArr[6] == -1 && i01.m4692j(iArr, f8604a))) {
            return;
        }
        m10649c(iArr);
    }

    /* renamed from: j */
    public static void m10656j(int[] iArr, int[] iArr2) {
        int[] m4688f = i01.m4688f();
        i01.m4700r(iArr, m4688f);
        m10654h(m4688f, iArr2);
    }

    /* renamed from: k */
    public static void m10657k(int[] iArr, int i, int[] iArr2) {
        int[] m4688f = i01.m4688f();
        i01.m4700r(iArr, m4688f);
        while (true) {
            m10654h(m4688f, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                i01.m4700r(iArr2, m4688f);
            }
        }
    }

    /* renamed from: l */
    public static void m10658l(int[] iArr) {
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
        long j5 = j2 + ((4294967295L & iArr[3]) - 1);
        iArr[3] = (int) j5;
        if ((j5 >> 32) != 0) {
            p01.m7203n(7, iArr, 4);
        }
    }

    /* renamed from: m */
    public static void m10659m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4701s(iArr, iArr2, iArr3) != 0) {
            m10658l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m10660n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && i01.m4692j(iArr2, f8604a))) {
            m10649c(iArr2);
        }
    }
}
