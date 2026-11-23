package com.sonelli;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class q80 {

    /* renamed from: a */
    public final String f5959a;

    /* renamed from: b */
    public final String f5960b;

    /* renamed from: c */
    public final String f5961c;

    /* renamed from: d */
    public final String f5962d;

    /* renamed from: e */
    public final String f5963e;

    /* renamed from: f */
    public final String f5964f;

    public q80(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f5959a = str;
        this.f5960b = str2;
        this.f5961c = str3;
        this.f5962d = str4;
        this.f5963e = str5;
        this.f5964f = str6;
    }

    /* renamed from: a */
    public static q80 m7636a(Context context, h90 h90Var, String str, String str2) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String m4390e = h90Var.m4390e();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String num = Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new q80(str, str2, m4390e, packageName, num, str3);
    }
}
