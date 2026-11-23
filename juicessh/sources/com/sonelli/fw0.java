package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class fw0 {

    /* renamed from: a */
    public static final int[] f2776a = {ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, -1, -1, -1, -1};

    /* renamed from: b */
    public static final int[] f2777b = {1, 1073741825, 0, 0, 0, -2, -2, -1, -1, -1};

    /* renamed from: c */
    public static final int[] f2778c = {-1, -1073741826, -1, -1, -1, 1, 1};

    /* renamed from: a */
    public static void m3888a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3904a(iArr, iArr2, iArr3) != 0 || (iArr3[4] == -1 && g01.m3912i(iArr3, f2776a))) {
            p01.m7196g(5, -2147483647, iArr3);
        }
    }

    /* renamed from: b */
    public static void m3889b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(5, iArr, iArr2) != 0 || (iArr2[4] == -1 && g01.m3912i(iArr2, f2776a))) {
            p01.m7196g(5, -2147483647, iArr2);
        }
    }

    /* renamed from: c */
    public static int[] m3890c(BigInteger bigInteger) {
        int[] m3910g = g01.m3910g(bigInteger);
        if (m3910g[4] == -1) {
            int[] iArr = f2776a;
            if (g01.m3912i(m3910g, iArr)) {
                g01.m3923t(iArr, m3910g);
            }
        }
        return m3910g;
    }

    /* renamed from: d */
    public static void m3891d(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m3908e = g01.m3908e();
        g01.m3915l(iArr, iArr2, m3908e);
        m3894g(m3908e, iArr3);
    }

    /* renamed from: e */
    public static void m3892e(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3919p(iArr, iArr2, iArr3) != 0 || (iArr3[9] == -1 && p01.m7208s(10, iArr3, f2777b))) {
            int[] iArr4 = f2778c;
            if (p01.m7194e(iArr4.length, iArr4, iArr3) != 0) {
                p01.m7211v(10, iArr3, iArr4.length);
            }
        }
    }

    /* renamed from: f */
    public static void m3893f(int[] iArr, int[] iArr2) {
        if (g01.m3914k(iArr)) {
            g01.m3925v(iArr2);
        } else {
            g01.m3922s(f2776a, iArr, iArr2);
        }
    }

    /* renamed from: g */
    public static void m3894g(int[] iArr, int[] iArr2) {
        long j = iArr[5] & 4294967295L;
        long j2 = iArr[6] & 4294967295L;
        long j3 = iArr[7] & 4294967295L;
        long j4 = iArr[8] & 4294967295L;
        long j5 = iArr[9] & 4294967295L;
        long j6 = (iArr[0] & 4294967295L) + j + (j << 31) + 0;
        iArr2[0] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[1] & 4294967295L) + j2 + (j2 << 31);
        iArr2[1] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[2] & 4294967295L) + j3 + (j3 << 31);
        iArr2[2] = (int) j8;
        long j9 = (j8 >>> 32) + (iArr[3] & 4294967295L) + j4 + (j4 << 31);
        iArr2[3] = (int) j9;
        long j10 = (j9 >>> 32) + (4294967295L & iArr[4]) + j5 + (j5 << 31);
        iArr2[4] = (int) j10;
        m3895h((int) (j10 >>> 32), iArr2);
    }

    /* renamed from: h */
    public static void m3895h(int i, int[] iArr) {
        if ((i == 0 || g01.m3920q(-2147483647, i, iArr, 0) == 0) && !(iArr[4] == -1 && g01.m3912i(iArr, f2776a))) {
            return;
        }
        p01.m7196g(5, -2147483647, iArr);
    }

    /* renamed from: i */
    public static void m3896i(int[] iArr, int[] iArr2) {
        int[] m3908e = g01.m3908e();
        g01.m3921r(iArr, m3908e);
        m3894g(m3908e, iArr2);
    }

    /* renamed from: j */
    public static void m3897j(int[] iArr, int i, int[] iArr2) {
        int[] m3908e = g01.m3908e();
        g01.m3921r(iArr, m3908e);
        while (true) {
            m3894g(m3908e, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                g01.m3921r(iArr2, m3908e);
            }
        }
    }

    /* renamed from: k */
    public static void m3898k(int[] iArr, int[] iArr2, int[] iArr3) {
        if (g01.m3922s(iArr, iArr2, iArr3) != 0) {
            p01.m7186Q(5, -2147483647, iArr3);
        }
    }

    /* renamed from: l */
    public static void m3899l(int[] iArr, int[] iArr2) {
        if (p01.m7176G(5, iArr, 0, iArr2) != 0 || (iArr2[4] == -1 && g01.m3912i(iArr2, f2776a))) {
            p01.m7196g(5, -2147483647, iArr2);
        }
    }
}
