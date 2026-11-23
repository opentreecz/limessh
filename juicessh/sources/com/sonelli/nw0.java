package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class nw0 {

    /* renamed from: a */
    public static final int[] f5386a = {-4553, -2, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f5387b = {20729809, 9106, 1, 0, 0, 0, -9106, -3, -1, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f5388c = {-20729809, -9107, -2, -1, -1, -1, 9105, 2};

    /* renamed from: a */
    public static void m6805a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4308a(iArr, iArr2, iArr3) != 0 || (iArr3[5] == -1 && h01.m4325r(iArr3, f5386a))) {
            p01.m7191b(6, 4553, iArr3);
        }
    }

    /* renamed from: b */
    public static void m6806b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(6, iArr, iArr2) != 0 || (iArr2[5] == -1 && h01.m4325r(iArr2, f5386a))) {
            p01.m7191b(6, 4553, iArr2);
        }
    }

    /* renamed from: c */
    public static int[] m6807c(BigInteger bigInteger) {
        int[] m4322o = h01.m4322o(bigInteger);
        if (m4322o[5] == -1) {
            int[] iArr = f5386a;
            if (h01.m4325r(m4322o, iArr)) {
                h01.m4304G(iArr, m4322o);
            }
        }
        return m4322o;
    }

    /* renamed from: d */
    public static void m6808d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m4317j = h01.m4317j();
        h01.m4331x(iArr, iArr2, m4317j);
        m6811g(m4317j, iArr3);
    }

    /* renamed from: e */
    public static void m6809e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4299B(iArr, iArr2, iArr3) != 0 || (iArr3[11] == -1 && p01.m7208s(12, iArr3, f5387b))) {
            int[] iArr4 = f5388c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(12, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: f */
    public static void m6810f(int[] iArr, int[] iArr2) {
        if (h01.m4328u(iArr)) {
            h01.m4307J(iArr2);
        } else {
            h01.m4303F(f5386a, iArr, iArr2);
        }
    }

    /* renamed from: g */
    public static void m6811g(int[] iArr, int[] iArr2) {
        if (h01.m4333z(4553, h01.m4332y(4553, iArr, 6, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[5] == -1 && h01.m4325r(iArr2, f5386a))) {
            p01.m7191b(6, 4553, iArr2);
        }
    }

    /* renamed from: h */
    public static void m6812h(int i, int[] iArr) {
        if ((i == 0 || h01.m4298A(4553, i, iArr, 0) == 0) && !(iArr[5] == -1 && h01.m4325r(iArr, f5386a))) {
            return;
        }
        p01.m7191b(6, 4553, iArr);
    }

    /* renamed from: i */
    public static void m6813i(int[] iArr, int[] iArr2) {
        int[] m4317j = h01.m4317j();
        h01.m4301D(iArr, m4317j);
        m6811g(m4317j, iArr2);
    }

    /* renamed from: j */
    public static void m6814j(int[] iArr, int i, int[] iArr2) {
        int[] m4317j = h01.m4317j();
        h01.m4301D(iArr, m4317j);
        while (true) {
            m6811g(m4317j, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                h01.m4301D(iArr2, m4317j);
            }
        }
    }

    /* renamed from: k */
    public static void m6815k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (h01.m4303F(iArr, iArr2, iArr3) != 0) {
            p01.m7183N(6, 4553, iArr3);
        }
    }

    /* renamed from: l */
    public static void m6816l(int[] iArr, int[] iArr2) {
        if (p01.m7176G(6, iArr, 0, iArr2) != 0 || (iArr2[5] == -1 && h01.m4325r(iArr2, f5386a))) {
            p01.m7191b(6, 4553, iArr2);
        }
    }
}
