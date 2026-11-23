package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class m01 {
    /* renamed from: a */
    public static void m6329a(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
        jArr2[i2 + 4] = jArr[i + 4];
        jArr2[i2 + 5] = jArr[i + 5];
        jArr2[i2 + 6] = jArr[i + 6];
    }

    /* renamed from: b */
    public static void m6330b(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
        jArr2[4] = jArr[4];
        jArr2[5] = jArr[5];
        jArr2[6] = jArr[6];
    }

    /* renamed from: c */
    public static long[] m6331c() {
        return new long[7];
    }

    /* renamed from: d */
    public static long[] m6332d() {
        return new long[14];
    }

    /* renamed from: e */
    public static boolean m6333e(long[] jArr, long[] jArr2) {
        for (int i = 6; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static boolean m6334f(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public static boolean m6335g(long[] jArr) {
        for (int i = 0; i < 7; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: h */
    public static BigInteger m6336h(long[] jArr) {
        byte[] bArr = new byte[56];
        for (int i = 0; i < 7; i++) {
            long j = jArr[i];
            if (j != 0) {
                h51.m4372h(j, bArr, (6 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }
}
