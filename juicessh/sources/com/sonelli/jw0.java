package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class jw0 {

    /* renamed from: a */
    public static final int[] f4388a = {-21389, -2, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f4389b = {457489321, 42778, 1, 0, 0, -42778, -3, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f4390c = {-457489321, -42779, -2, -1, -1, 42777, 2};

    /* renamed from: a */
    public static void m5733a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3904a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && g01.m3912i(iArr3, f4388a))) {
            p01.m7191b(5, 21389, iArr3);
        }
    }

    /* renamed from: b */
    public static void m5734b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && g01.m3912i(iArr2, f4388a))) {
            p01.m7191b(5, 21389, iArr2);
        }
    }

    /* renamed from: c */
    public static int[] m5735c(BigInteger bigInteger) {
        int[] m3910g = g01.m3910g(bigInteger);
        if (m3910g[4] == -1) {
            int[] iArr = f4388a;
            if (g01.m3912i(m3910g, iArr)) {
                g01.m3923t(iArr, m3910g);
            }
        }
        return m3910g;
    }

    /* renamed from: d */
    public static void m5736d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m3908e = g01.m3908e();
        g01.m3915l(iArr, iArr2, m3908e);
        m5739g(m3908e, iArr3);
    }

    /* renamed from: e */
    public static void m5737e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3919p(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && p01.m7208s(10, iArr3, f4389b))) {
            int[] iArr4 = f4390c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: f */
    public static void m5738f(int[] iArr, int[] iArr2) {
        if (g01.m3914k(iArr)) {
            g01.m3925v(iArr2);
        } else {
            g01.m3922s(f4388a, iArr, iArr2);
        }
    }

    /* renamed from: g */
    public static void m5739g(int[] iArr, int[] iArr2) {
        if (g01.m3917n(21389, g01.m3916m(21389, iArr, 5, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[4] == -1 && g01.m3912i(iArr2, f4388a))) {
            p01.m7191b(5, 21389, iArr2);
        }
    }

    /* renamed from: h */
    public static void m5740h(int i, int[] iArr) {
        if ((i == 0 || g01.m3918o(21389, i, iArr, 0) == 0) && !(iArr[4] == -1 && g01.m3912i(iArr, f4388a))) {
            return;
        }
        p01.m7191b(5, 21389, iArr);
    }

    /* renamed from: i */
    public static void m5741i(int[] iArr, int[] iArr2) {
        int[] m3908e = g01.m3908e();
        g01.m3921r(iArr, m3908e);
        m5739g(m3908e, iArr2);
    }

    /* renamed from: j */
    public static void m5742j(int[] iArr, int i, int[] iArr2) {
        int[] m3908e = g01.m3908e();
        g01.m3921r(iArr, m3908e);
        while (true) {
            m5739g(m3908e, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                g01.m3921r(iArr2, m3908e);
            }
        }
    }

    /* renamed from: k */
    public static void m5743k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3922s(iArr, iArr2, iArr3) != 0) {
            p01.m7183N(5, 21389, iArr3);
        }
    }

    /* renamed from: l */
    public static void m5744l(int[] iArr, int[] iArr2) {
        if (p01.m7176G(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && g01.m3912i(iArr2, f4388a))) {
            p01.m7191b(5, 21389, iArr2);
        }
    }
}
