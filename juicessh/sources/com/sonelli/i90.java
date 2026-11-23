package com.sonelli;

import android.content.Context;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class i90 {

    /* renamed from: a */
    public String f3273a;

    /* renamed from: b */
    public static String m4730b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? "" : installerPackageName;
    }

    /* renamed from: a */
    public synchronized String m4731a(Context context) {
        if (this.f3273a == null) {
            this.f3273a = m4730b(context);
        }
        return "".equals(this.f3273a) ? null : this.f3273a;
    }
}
