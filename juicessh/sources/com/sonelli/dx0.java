package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class dx0 {

    /* renamed from: a */
    public static final int[] f2295a = {-977, -2, -1, -1, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f2296b = {954529, 1954, 1, 0, 0, 0, 0, 0, -1954, -3, -1, -1, -1, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f2297c = {-954529, -1955, -2, -1, -1, -1, -1, -1, 1953, 2};

    /* renamed from: a */
    public static void m3326a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5007a(iArr, iArr2, iArr3) != 0 || (iArr3[7] == -1 && j01.m5025s(iArr3, f2295a))) {
            p01.m7191b(8, 977, iArr3);
        }
    }

    /* renamed from: b */
    public static void m3327b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(8, iArr, iArr2) != 0 || (iArr2[7] == -1 && j01.m5025s(iArr2, f2295a))) {
            p01.m7191b(8, 977, iArr2);
        }
    }

    /* renamed from: c */
    public static int[] m3328c(BigInteger bigInteger) {
        int[] m5022p = j01.m5022p(bigInteger);
        if (m5022p[7] == -1) {
            int[] iArr = f2295a;
            if (j01.m5025s(m5022p, iArr)) {
                j01.m5003I(iArr, m5022p);
            }
        }
        return m5022p;
    }

    /* renamed from: d */
    public static void m3329d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m5017k = j01.m5017k();
        j01.m5031y(iArr, iArr2, m5017k);
        m3332g(m5017k, iArr3);
    }

    /* renamed from: e */
    public static void m3330e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m4997C(iArr, iArr2, iArr3) != 0 || (iArr3[15] == -1 && p01.m7208s(16, iArr3, f2296b))) {
            int[] iArr4 = f2297c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(16, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: f */
    public static void m3331f(int[] iArr, int[] iArr2) {
        if (j01.m5028v(iArr)) {
            j01.m5006L(iArr2);
        } else {
            j01.m5002H(f2295a, iArr, iArr2);
        }
    }

    /* renamed from: g */
    public static void m3332g(int[] iArr, int[] iArr2) {
        if (j01.m4995A(977, j01.m5032z(977, iArr, 8, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[7] == -1 && j01.m5025s(iArr2, f2295a))) {
            p01.m7191b(8, 977, iArr2);
        }
    }

    /* renamed from: h */
    public static void m3333h(int i, int[] iArr) {
        if ((i == 0 || j01.m4996B(977, i, iArr, 0) == 0) && !(iArr[7] == -1 && j01.m5025s(iArr, f2295a))) {
            return;
        }
        p01.m7191b(8, 977, iArr);
    }

    /* renamed from: i */
    public static void m3334i(int[] iArr, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        m3332g(m5017k, iArr2);
    }

    /* renamed from: j */
    public static void m3335j(int[] iArr, int i, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        while (true) {
            m3332g(m5017k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                j01.m5000F(iArr2, m5017k);
            }
        }
    }

    /* renamed from: k */
    public static void m3336k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5002H(iArr, iArr2, iArr3) != 0) {
            p01.m7183N(8, 977, iArr3);
        }
    }

    /* renamed from: l */
    public static void m3337l(int[] iArr, int[] iArr2) {
        if (p01.m7176G(8, iArr, 0, iArr2) != 0 || (iArr2[7] == -1 && j01.m5025s(iArr2, f2295a))) {
            p01.m7191b(8, 977, iArr2);
        }
    }
}
