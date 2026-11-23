package com.sonelli;

import java.nio.charset.Charset;

/* compiled from: Util.java */
/* loaded from: classes.dex */
public final class np0 {

    /* renamed from: a */
    public static final Charset f5329a = Charset.forName("UTF-8");

    /* renamed from: a */
    public static boolean m6761a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static void m6762b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3)));
        }
    }

    /* renamed from: c */
    public static int m6763c(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    /* renamed from: d */
    public static short m6764d(short s) {
        int i = s & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    /* renamed from: e */
    public static void m6765e(Throwable th) {
        m6766f(th);
        throw null;
    }

    /* renamed from: f */
    public static <T extends Throwable> void m6766f(Throwable th) throws Throwable {
        throw th;
    }
}
