package com.sonelli;

import androidx.media.AudioAttributesCompat;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.hq */
/* loaded from: classes.dex */
public final class C1123hq {
    /* renamed from: f */
    public static void m4628f(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws C0839co {
        if (m4637o(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m4637o(b3) || m4637o(b4)) {
            throw C0839co.m2894f();
        }
        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & AudioAttributesCompat.FLAG_ALL) + 56320);
    }

    /* renamed from: g */
    public static void m4629g(byte b, byte b2, byte b3, char[] cArr, int i) throws C0839co {
        if (m4637o(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m4637o(b3)))) {
            throw C0839co.m2894f();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    /* renamed from: h */
    public static void m4630h(byte b, byte b2, char[] cArr, int i) throws C0839co {
        if (b < -62 || m4637o(b2)) {
            throw C0839co.m2894f();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    /* renamed from: i */
    public static void m4631i(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    /* renamed from: l */
    public static boolean m4634l(byte b) {
        return b >= 0;
    }

    /* renamed from: m */
    public static boolean m4635m(byte b) {
        return b < -32;
    }

    /* renamed from: n */
    public static boolean m4636n(byte b) {
        return b < -16;
    }

    /* renamed from: o */
    public static boolean m4637o(byte b) {
        return b > -65;
    }
}
