package com.sonelli;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.y6 */
/* loaded from: classes.dex */
public class C2326y6 {

    /* renamed from: a */
    public static final int f8141a = C0810c7.f1875a;

    /* renamed from: b */
    public static final C2326y6 f8142b = new C2326y6();

    /* renamed from: f */
    public static C2326y6 m10090f() {
        return f8142b;
    }

    /* renamed from: j */
    public static String m10091j(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(f8141a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(C2272xc.m9755a(context).m9468e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public int m10092a(Context context) {
        return C0810c7.m2676a(context);
    }

    @Nullable
    /* renamed from: b */
    public Intent mo9709b(Context context, int i, @Nullable String str) {
        if (i == 1 || i == 2) {
            return (context == null || !C0981fc.m3712c(context)) ? C2337ya.m10116a("com.google.android.gms", m10091j(context, str)) : C2337ya.m10118c();
        }
        if (i != 3) {
            return null;
        }
        return C2337ya.m10117b("com.google.android.gms");
    }

    @Nullable
    /* renamed from: c */
    public PendingIntent mo9710c(Context context, int i, int i2) {
        return m10093d(context, i, i2, null);
    }

    @Nullable
    /* renamed from: d */
    public PendingIntent m10093d(Context context, int i, int i2, @Nullable String str) {
        Intent mo9709b = mo9709b(context, i, str);
        if (mo9709b == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i2, mo9709b, 134217728);
    }

    /* renamed from: e */
    public String mo9711e(int i) {
        return C0810c7.m2677b(i);
    }

    /* renamed from: g */
    public int mo9712g(Context context) {
        return mo9713h(context, f8141a);
    }

    /* renamed from: h */
    public int mo9713h(Context context, int i) {
        int m2681f = C0810c7.m2681f(context, i);
        if (C0810c7.m2682g(context, m2681f)) {
            return 18;
        }
        return m2681f;
    }

    /* renamed from: i */
    public boolean mo9714i(int i) {
        return C0810c7.m2685j(i);
    }
}
