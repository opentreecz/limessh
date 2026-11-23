package com.sonelli;

import androidx.core.app.FrameMetricsAggregator;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class px0 {

    /* renamed from: a */
    public static final int[] f5883a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, FrameMetricsAggregator.EVERY_DURATION};

    /* renamed from: a */
    public static void m7557a(int[] iArr, int[] iArr2, int[] iArr3) {
        int m7190a = p01.m7190a(16, iArr, iArr2, iArr3) + iArr[16] + iArr2[16];
        if (m7190a > 511 || (m7190a == 511 && p01.m7204o(16, iArr3, f5883a))) {
            m7190a = (m7190a + p01.m7209t(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = m7190a;
    }

    /* renamed from: b */
    public static void m7558b(int[] iArr, int[] iArr2) {
        int m7210u = p01.m7210u(16, iArr, iArr2) + iArr[16];
        if (m7210u > 511 || (m7210u == 511 && p01.m7204o(16, iArr2, f5883a))) {
            m7210u = (m7210u + p01.m7209t(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = m7210u;
    }

    /* renamed from: c */
    public static int[] m7559c(BigInteger bigInteger) {
        int[] m7205p = p01.m7205p(521, bigInteger);
        if (p01.m7204o(17, m7205p, f5883a)) {
            p01.m7188S(17, m7205p);
        }
        return m7205p;
    }

    /* renamed from: d */
    public static void m7560d(int[] iArr, int[] iArr2, int[] iArr3) {
        n01.m6608a(iArr, iArr2, iArr3);
        int i = iArr[16];
        int i2 = iArr2[16];
        iArr3[32] = p01.m7215z(16, i, iArr2, i2, iArr, iArr3, 16) + (i * i2);
    }

    /* renamed from: e */
    public static void m7561e(int[] iArr, int[] iArr2) {
        n01.m6609b(iArr, iArr2);
        int i = iArr[16];
        iArr2[32] = p01.m7170A(16, i << 1, iArr, 0, iArr2, 16) + (i * i);
    }

    /* renamed from: f */
    public static void m7562f(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m7200k = p01.m7200k(33);
        m7560d(iArr, iArr2, m7200k);
        m7564h(m7200k, iArr3);
    }

    /* renamed from: g */
    public static void m7563g(int[] iArr, int[] iArr2) {
        if (p01.m7214y(17, iArr)) {
            p01.m7188S(17, iArr2);
        } else {
            p01.m7182M(17, f5883a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m7564h(int[] iArr, int[] iArr2) {
        int i = iArr[32];
        int m7173D = (p01.m7173D(16, iArr, 16, 9, i, iArr2, 0) >>> 23) + (i >>> 9) + p01.m7194e(16, iArr, iArr2);
        if (m7173D > 511 || (m7173D == 511 && p01.m7204o(16, iArr2, f5883a))) {
            m7173D = (m7173D + p01.m7209t(16, iArr2)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr2[16] = m7173D;
    }

    /* renamed from: i */
    public static void m7565i(int[] iArr) {
        int i = iArr[16];
        int m7196g = p01.m7196g(16, i >>> 9, iArr) + (i & FrameMetricsAggregator.EVERY_DURATION);
        if (m7196g > 511 || (m7196g == 511 && p01.m7204o(16, iArr, f5883a))) {
            m7196g = (m7196g + p01.m7209t(16, iArr)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr[16] = m7196g;
    }

    /* renamed from: j */
    public static void m7566j(int[] iArr, int[] iArr2) {
        int[] m7200k = p01.m7200k(33);
        m7561e(iArr, m7200k);
        m7564h(m7200k, iArr2);
    }

    /* renamed from: k */
    public static void m7567k(int[] iArr, int i, int[] iArr2) {
        int[] m7200k = p01.m7200k(33);
        m7561e(iArr, m7200k);
        while (true) {
            m7564h(m7200k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m7561e(iArr2, m7200k);
            }
        }
    }

    /* renamed from: l */
    public static void m7568l(int[] iArr, int[] iArr2, int[] iArr3) {
        int m7182M = (p01.m7182M(16, iArr, iArr2, iArr3) + iArr[16]) - iArr2[16];
        if (m7182M < 0) {
            m7182M = (m7182M + p01.m7202m(16, iArr3)) & FrameMetricsAggregator.EVERY_DURATION;
        }
        iArr3[16] = m7182M;
    }

    /* renamed from: m */
    public static void m7569m(int[] iArr, int[] iArr2) {
        int i = iArr[16];
        iArr2[16] = (p01.m7176G(16, iArr, i << 23, iArr2) | (i << 1)) & FrameMetricsAggregator.EVERY_DURATION;
    }
}
