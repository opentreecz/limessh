package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class vw0 {

    /* renamed from: a */
    public static final int[] f7562a = {-6803, -2, -1, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f7563b = {46280809, 13606, 1, 0, 0, 0, 0, -13606, -3, -1, -1, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f7564c = {-46280809, -13607, -2, -1, -1, -1, -1, 13605, 2};

    /* renamed from: a */
    public static void m9360a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4683a(iArr, iArr2, iArr3) != 0 || (iArr3[6] == -1 && i01.m4692j(iArr3, f7562a))) {
            p01.m7191b(7, 6803, iArr3);
        }
    }

    /* renamed from: b */
    public static void m9361b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(7, iArr, iArr2) != 0 || (iArr2[6] == -1 && i01.m4692j(iArr2, f7562a))) {
            p01.m7191b(7, 6803, iArr2);
        }
    }

    /* renamed from: c */
    public static int[] m9362c(BigInteger bigInteger) {
        int[] m4690h = i01.m4690h(bigInteger);
        if (m4690h[6] == -1 && i01.m4692j(m4690h, f7562a)) {
            p01.m7191b(7, 6803, m4690h);
        }
        return m4690h;
    }

    /* renamed from: d */
    public static void m9363d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m4688f = i01.m4688f();
        i01.m4695m(iArr, iArr2, m4688f);
        m9366g(m4688f, iArr3);
    }

    /* renamed from: e */
    public static void m9364e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4699q(iArr, iArr2, iArr3) != 0 || (iArr3[13] == -1 && p01.m7208s(14, iArr3, f7563b))) {
            int[] iArr4 = f7564c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(14, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: f */
    public static void m9365f(int[] iArr, int[] iArr2) {
        if (i01.m4694l(iArr)) {
            i01.m4704v(iArr2);
        } else {
            i01.m4701s(f7562a, iArr, iArr2);
        }
    }

    /* renamed from: g */
    public static void m9366g(int[] iArr, int[] iArr2) {
        if (i01.m4697o(6803, i01.m4696n(6803, iArr, 7, iArr, 0, iArr2, 0), iArr2, 0) != 0 || (iArr2[6] == -1 && i01.m4692j(iArr2, f7562a))) {
            p01.m7191b(7, 6803, iArr2);
        }
    }

    /* renamed from: h */
    public static void m9367h(int i, int[] iArr) {
        if ((i == 0 || i01.m4698p(6803, i, iArr, 0) == 0) && !(iArr[6] == -1 && i01.m4692j(iArr, f7562a))) {
            return;
        }
        p01.m7191b(7, 6803, iArr);
    }

    /* renamed from: i */
    public static void m9368i(int[] iArr, int[] iArr2) {
        int[] m4688f = i01.m4688f();
        i01.m4700r(iArr, m4688f);
        m9366g(m4688f, iArr2);
    }

    /* renamed from: j */
    public static void m9369j(int[] iArr, int i, int[] iArr2) {
        int[] m4688f = i01.m4688f();
        i01.m4700r(iArr, m4688f);
        while (true) {
            m9366g(m4688f, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                i01.m4700r(iArr2, m4688f);
            }
        }
    }

    /* renamed from: k */
    public static void m9370k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (i01.m4701s(iArr, iArr2, iArr3) != 0) {
            p01.m7183N(7, 6803, iArr3);
        }
    }

    /* renamed from: l */
    public static void m9371l(int[] iArr, int[] iArr2) {
        if (p01.m7176G(7, iArr, 0, iArr2) != 0 || (iArr2[6] == -1 && i01.m4692j(iArr2, f7562a))) {
            p01.m7191b(7, 6803, iArr2);
        }
    }
}
