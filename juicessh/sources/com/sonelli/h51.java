package com.sonelli;

/* loaded from: classes.dex */
public abstract class h51 {
    /* renamed from: a */
    public static int m4365a(byte[] bArr, int i) {
        int i2 = bArr[i] << 24;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 16);
        int i5 = i3 + 1;
        return (bArr[i5 + 1] & 255) | i4 | ((bArr[i5] & 255) << 8);
    }

    /* renamed from: b */
    public static long m4366b(byte[] bArr, int i) {
        return (m4365a(bArr, i + 4) & 4294967295L) | ((m4365a(bArr, i) & 4294967295L) << 32);
    }

    /* renamed from: c */
    public static void m4367c(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) (i >>> 24);
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 16);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 8);
        bArr[i4 + 1] = (byte) i;
    }

    /* renamed from: d */
    public static void m4368d(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: e */
    public static int m4369e(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = i3 + 1;
        return (bArr[i5 + 1] << 24) | i4 | ((bArr[i5] & 255) << 16);
    }

    /* renamed from: f */
    public static long m4370f(byte[] bArr, int i) {
        return ((m4369e(bArr, i + 4) & 4294967295L) << 32) | (m4369e(bArr, i) & 4294967295L);
    }

    /* renamed from: g */
    public static short m4371g(byte[] bArr, int i) {
        return (short) (((bArr[i + 1] & 255) << 8) | (bArr[i] & 255));
    }

    /* renamed from: h */
    public static void m4372h(long j, byte[] bArr, int i) {
        m4367c((int) (j >>> 32), bArr, i);
        m4367c((int) (j & 4294967295L), bArr, i + 4);
    }

    /* renamed from: i */
    public static void m4373i(long j, byte[] bArr, int i) {
        m4368d((int) (4294967295L & j), bArr, i);
        m4368d((int) (j >>> 32), bArr, i + 4);
    }

    /* renamed from: j */
    public static void m4374j(long[] jArr, int i, int i2, byte[] bArr, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            m4373i(jArr[i + i4], bArr, i3);
            i3 += 8;
        }
    }

    /* renamed from: k */
    public static void m4375k(short s, byte[] bArr, int i) {
        bArr[i] = (byte) (s >>> 8);
        bArr[i + 1] = (byte) s;
    }

    /* renamed from: l */
    public static void m4376l(short s, byte[] bArr, int i) {
        bArr[i] = (byte) s;
        bArr[i + 1] = (byte) (s >>> 8);
    }
}
