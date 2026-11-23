package com.sonelli;

import android.util.Log;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.x0 */
/* loaded from: classes.dex */
public final class C2253x0 {
    /* renamed from: a */
    public static void m9656a(String str, String str2, Object obj) {
        Log.d(m9659d(str), String.format(str2, obj));
    }

    /* renamed from: b */
    public static void m9657b(String str, String str2, Object... objArr) {
        Log.d(m9659d(str), String.format(str2, objArr));
    }

    /* renamed from: c */
    public static void m9658c(String str, String str2, Throwable th) {
        Log.e(m9659d(str), str2, th);
    }

    /* renamed from: d */
    public static String m9659d(String str) {
        return "TransportRuntime." + str;
    }

    /* renamed from: e */
    public static void m9660e(String str, String str2) {
        Log.i(m9659d(str), str2);
    }

    /* renamed from: f */
    public static void m9661f(String str, String str2, Object obj) {
        Log.w(m9659d(str), String.format(str2, obj));
    }
}
