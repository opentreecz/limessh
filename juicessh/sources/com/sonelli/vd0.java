package com.sonelli;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class vd0 {

    /* renamed from: a */
    public final Context f7448a;

    /* renamed from: b */
    @GuardedBy("this")
    public String f7449b;

    /* renamed from: c */
    @GuardedBy("this")
    public String f7450c;

    /* renamed from: d */
    @GuardedBy("this")
    public int f7451d;

    /* renamed from: e */
    @GuardedBy("this")
    public int f7452e = 0;

    public vd0(Context context) {
        this.f7448a = context;
    }

    /* renamed from: b */
    public static String m9213b(FirebaseApp firebaseApp) {
        String m4385d = firebaseApp.m1582j().m4385d();
        if (m4385d != null) {
            return m4385d;
        }
        String m4384c = firebaseApp.m1582j().m4384c();
        if (!m4384c.startsWith("1:")) {
            return m4384c;
        }
        String[] split = m4384c.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* renamed from: a */
    public final PackageInfo m9214a(String str) {
        try {
            return this.f7448a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to find package ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* renamed from: c */
    public final boolean m9215c() {
        return m9216d() != 0;
    }

    /* renamed from: d */
    public final synchronized int m9216d() {
        int i = this.f7452e;
        if (i != 0) {
            return i;
        }
        PackageManager packageManager = this.f7448a.getPackageManager();
        if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
            Log.e("FirebaseInstanceId", "Google Play services missing or without correct permission.");
            return 0;
        }
        if (!C1501lc.m6150j()) {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage("com.google.android.gms");
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                this.f7452e = 1;
                return 1;
            }
        }
        Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
        intent2.setPackage("com.google.android.gms");
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
        if (queryBroadcastReceivers != null && queryBroadcastReceivers.size() > 0) {
            this.f7452e = 2;
            return 2;
        }
        Log.w("FirebaseInstanceId", "Failed to resolve IID implementation package, falling back");
        if (C1501lc.m6150j()) {
            this.f7452e = 2;
        } else {
            this.f7452e = 1;
        }
        return this.f7452e;
    }

    /* renamed from: e */
    public final synchronized String m9217e() {
        if (this.f7449b == null) {
            m9220h();
        }
        return this.f7449b;
    }

    /* renamed from: f */
    public final synchronized String m9218f() {
        if (this.f7450c == null) {
            m9220h();
        }
        return this.f7450c;
    }

    /* renamed from: g */
    public final synchronized int m9219g() {
        PackageInfo m9214a;
        if (this.f7451d == 0 && (m9214a = m9214a("com.google.android.gms")) != null) {
            this.f7451d = m9214a.versionCode;
        }
        return this.f7451d;
    }

    /* renamed from: h */
    public final synchronized void m9220h() {
        PackageInfo m9214a = m9214a(this.f7448a.getPackageName());
        if (m9214a != null) {
            this.f7449b = Integer.toString(m9214a.versionCode);
            this.f7450c = m9214a.versionName;
        }
    }
}
