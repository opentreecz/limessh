package com.sonelli;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.oc */
/* loaded from: classes.dex */
public final class C1649oc {
    /* renamed from: a */
    public static boolean m7010a(Context context, int i) {
        if (!m7011b(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return C0862d7.m3159a(context).m3162b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (Log.isLoggable("UidVerifier", 3)) {
                Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            }
            return false;
        }
    }

    @TargetApi(19)
    /* renamed from: b */
    public static boolean m7011b(Context context, int i, String str) {
        return C2272xc.m9755a(context).m9472i(i, str);
    }
}
