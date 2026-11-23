package cz.opentree;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class oz0 {

    /* renamed from: a */
    public static final long[] f5582a = {3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L};

    /* renamed from: a */
    public static void m7136a(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            jArr3[i3 + i4] = jArr[i + i4] ^ jArr2[i2 + i4];
        }
    }

    /* renamed from: b */
    public static void m7137b(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: c */
    public static void m7138c(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3) {
        for (int i4 = 0; i4 < 9; i4++) {
            int i5 = i3 + i4;
            jArr3[i5] = jArr3[i5] ^ (jArr[i + i4] ^ jArr2[i2 + i4]);
        }
    }

    /* renamed from: d */
    public static void m7139d(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 9; i++) {
            jArr3[i] = jArr3[i] ^ (jArr[i] ^ jArr2[i]);
        }
    }

    /* renamed from: e */
    public static void m7140e(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 0; i < 18; i++) {
            jArr3[i] = jArr[i] ^ jArr2[i];
        }
    }

    /* renamed from: f */
    public static void m7141f(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0] ^ 1;
        for (int i = 1; i < 9; i++) {
            jArr2[i] = jArr[i];
        }
    }

    /* renamed from: g */
    public static void m7142g(long[] jArr, long[] jArr2) {
        for (int i = 0; i < 9; i++) {
            jArr2[i] = jArr2[i] ^ jArr[i];
        }
    }

    /* renamed from: h */
    public static long[] m7143h(BigInteger bigInteger) {
        return p01.m7206q(571, bigInteger);
    }

    /* renamed from: i */
    public static void m7144i(long[] jArr, long[] jArr2) {
        long[] m6828d = o01.m6828d();
        o01.m6826b(jArr, jArr2);
        for (int i = 1; i < 571; i += 2) {
            m7147l(jArr2, m6828d);
            m7154s(m6828d, jArr2);
            m7147l(jArr2, m6828d);
            m7154s(m6828d, jArr2);
            m7142g(jArr, jArr2);
        }
    }

    /* renamed from: j */
    public static void m7145j(long[] jArr, long[] jArr2, long[] jArr3) {
        m7146k(jArr, m7153r(jArr2), jArr3);
    }

    /* renamed from: k */
    public static void m7146k(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i = 56; i >= 0; i -= 8) {
            for (int i2 = 1; i2 < 9; i2 += 2) {
                int i3 = (int) (jArr[i2] >>> i);
                m7138c(jArr2, (i3 & 15) * 9, jArr2, (((i3 >>> 4) & 15) + 16) * 9, jArr3, i2 - 1);
            }
            p01.m7180K(16, jArr3, 0, 8, 0L);
        }
        for (int i4 = 56; i4 >= 0; i4 -= 8) {
            for (int i5 = 0; i5 < 9; i5 += 2) {
                int i6 = (int) (jArr[i5] >>> i4);
                m7138c(jArr2, (i6 & 15) * 9, jArr2, (((i6 >>> 4) & 15) + 16) * 9, jArr3, i5);
            }
            if (i4 > 0) {
                p01.m7180K(18, jArr3, 0, 8, 0L);
            }
        }
    }

    /* renamed from: l */
    public static void m7147l(long[] jArr, long[] jArr2) {
        d01.m3086b(jArr[0], jArr2, 0);
        d01.m3086b(jArr[1], jArr2, 2);
        d01.m3086b(jArr[2], jArr2, 4);
        d01.m3086b(jArr[3], jArr2, 6);
        d01.m3086b(jArr[4], jArr2, 8);
        d01.m3086b(jArr[5], jArr2, 10);
        d01.m3086b(jArr[6], jArr2, 12);
        d01.m3086b(jArr[7], jArr2, 14);
        d01.m3086b(jArr[8], jArr2, 16);
    }

    /* renamed from: m */
    public static void m7148m(long[] jArr, long[] jArr2) {
        if (o01.m6831g(jArr)) {
            throw new IllegalStateException();
        }
        long[] m6827c = o01.m6827c();
        long[] m6827c2 = o01.m6827c();
        long[] m6827c3 = o01.m6827c();
        m7157v(jArr, m6827c3);
        m7157v(m6827c3, m6827c);
        m7157v(m6827c, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c, 2, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7149n(m6827c, m6827c3, m6827c);
        m7159x(m6827c, 5, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c2, 5, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c, 15, m6827c2);
        m7149n(m6827c, m6827c2, m6827c3);
        m7159x(m6827c3, 30, m6827c);
        m7159x(m6827c, 30, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c, 60, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c2, 60, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c, 180, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7159x(m6827c2, 180, m6827c2);
        m7149n(m6827c, m6827c2, m6827c);
        m7149n(m6827c, m6827c3, jArr2);
    }

    /* renamed from: n */
    public static void m7149n(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6828d = o01.m6828d();
        m7145j(jArr, jArr2, m6828d);
        m7154s(m6828d, jArr3);
    }

    /* renamed from: o */
    public static void m7150o(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6828d = o01.m6828d();
        m7145j(jArr, jArr2, m6828d);
        m7140e(jArr3, m6828d, jArr3);
    }

    /* renamed from: p */
    public static void m7151p(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6828d = o01.m6828d();
        m7146k(jArr, jArr2, m6828d);
        m7154s(m6828d, jArr3);
    }

    /* renamed from: q */
    public static void m7152q(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] m6828d = o01.m6828d();
        m7146k(jArr, jArr2, m6828d);
        m7140e(jArr3, m6828d, jArr3);
    }

    /* renamed from: r */
    public static long[] m7153r(long[] jArr) {
        long[] jArr2 = new long[288];
        int i = 0;
        System.arraycopy(jArr, 0, jArr2, 9, 9);
        int i2 = 7;
        while (i2 > 0) {
            int i3 = i + 18;
            p01.m7177H(9, jArr2, i3 >>> 1, 0L, jArr2, i3);
            m7155t(jArr2, i3);
            m7136a(jArr2, 9, jArr2, i3, jArr2, i3 + 9);
            i2--;
            i = i3;
        }
        p01.m7181L(KeycodeConstants.KEYCODE_NUMPAD_0, jArr2, 0, 4, 0L, jArr2, KeycodeConstants.KEYCODE_NUMPAD_0);
        return jArr2;
    }

    /* renamed from: s */
    public static void m7154s(long[] jArr, long[] jArr2) {
        long j = jArr[9];
        long j2 = jArr[17];
        long j3 = (((j ^ (j2 >>> 59)) ^ (j2 >>> 57)) ^ (j2 >>> 54)) ^ (j2 >>> 49);
        long j4 = (j2 << 15) ^ (((jArr[8] ^ (j2 << 5)) ^ (j2 << 7)) ^ (j2 << 10));
        for (int i = 16; i >= 10; i--) {
            long j5 = jArr[i];
            jArr2[i - 8] = (((j4 ^ (j5 >>> 59)) ^ (j5 >>> 57)) ^ (j5 >>> 54)) ^ (j5 >>> 49);
            j4 = (((jArr[i - 9] ^ (j5 << 5)) ^ (j5 << 7)) ^ (j5 << 10)) ^ (j5 << 15);
        }
        jArr2[1] = (((j4 ^ (j3 >>> 59)) ^ (j3 >>> 57)) ^ (j3 >>> 54)) ^ (j3 >>> 49);
        long j6 = (j3 << 15) ^ (((jArr[0] ^ (j3 << 5)) ^ (j3 << 7)) ^ (j3 << 10));
        long j7 = jArr2[8];
        long j8 = j7 >>> 59;
        jArr2[0] = (((j6 ^ j8) ^ (j8 << 2)) ^ (j8 << 5)) ^ (j8 << 10);
        jArr2[8] = 576460752303423487L & j7;
    }

    /* renamed from: t */
    public static void m7155t(long[] jArr, int i) {
        int i2 = i + 8;
        long j = jArr[i2];
        long j2 = j >>> 59;
        jArr[i] = ((j2 << 10) ^ (((j2 << 2) ^ j2) ^ (j2 << 5))) ^ jArr[i];
        jArr[i2] = j & 576460752303423487L;
    }

    /* renamed from: u */
    public static void m7156u(long[] jArr, long[] jArr2) {
        long[] m6827c = o01.m6827c();
        long[] m6827c2 = o01.m6827c();
        int i = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = i + 1;
            long m3089e = d01.m3089e(jArr[i]);
            i = i3 + 1;
            long m3089e2 = d01.m3089e(jArr[i3]);
            m6827c[i2] = (4294967295L & m3089e) | (m3089e2 << 32);
            m6827c2[i2] = (m3089e >>> 32) | ((-4294967296L) & m3089e2);
        }
        long m3089e3 = d01.m3089e(jArr[i]);
        m6827c[4] = 4294967295L & m3089e3;
        m6827c2[4] = m3089e3 >>> 32;
        m7149n(m6827c2, f5582a, jArr2);
        m7137b(jArr2, m6827c, jArr2);
    }

    /* renamed from: v */
    public static void m7157v(long[] jArr, long[] jArr2) {
        long[] m6828d = o01.m6828d();
        m7147l(jArr, m6828d);
        m7154s(m6828d, jArr2);
    }

    /* renamed from: w */
    public static void m7158w(long[] jArr, long[] jArr2) {
        long[] m6828d = o01.m6828d();
        m7147l(jArr, m6828d);
        m7140e(jArr2, m6828d, jArr2);
    }

    /* renamed from: x */
    public static void m7159x(long[] jArr, int i, long[] jArr2) {
        long[] m6828d = o01.m6828d();
        m7147l(jArr, m6828d);
        while (true) {
            m7154s(m6828d, jArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                m7147l(jArr2, m6828d);
            }
        }
    }

    /* renamed from: y */
    public static int m7160y(long[] jArr) {
        return ((int) ((jArr[0] ^ (jArr[8] >>> 49)) ^ (jArr[8] >>> 57))) & 1;
    }
}
