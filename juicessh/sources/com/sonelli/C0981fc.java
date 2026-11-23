package com.sonelli;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.fc */
/* loaded from: classes.dex */
public final class C0981fc {

    /* renamed from: a */
    public static Boolean f2652a;

    /* renamed from: b */
    public static Boolean f2653b;

    /* renamed from: c */
    public static Boolean f2654c;

    /* renamed from: a */
    public static boolean m3710a() {
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    /* renamed from: b */
    public static boolean m3711b(Context context) {
        if (f2652a == null) {
            f2652a = Boolean.valueOf(C1501lc.m6147g() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f2652a.booleanValue();
    }

    @TargetApi(26)
    /* renamed from: c */
    public static boolean m3712c(Context context) {
        if (!m3711b(context)) {
            return false;
        }
        if (C1501lc.m6149i()) {
            return m3713d(context) && !C1501lc.m6150j();
        }
        return true;
    }

    @TargetApi(21)
    /* renamed from: d */
    public static boolean m3713d(Context context) {
        if (f2653b == null) {
            f2653b = Boolean.valueOf(C1501lc.m6148h() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f2653b.booleanValue();
    }

    /* renamed from: e */
    public static boolean m3714e(Context context) {
        if (f2654c == null) {
            f2654c = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f2654c.booleanValue();
    }
}
