package com.sonelli;

import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class c90 {

    /* renamed from: c */
    public final SharedPreferences f1891c;

    /* renamed from: d */
    public volatile boolean f1892d;

    /* renamed from: e */
    public volatile boolean f1893e;

    /* renamed from: f */
    public final FirebaseApp f1894f;

    /* renamed from: a */
    public Object f1889a = new Object();

    /* renamed from: b */
    public k60<Void> f1890b = new k60<>();

    /* renamed from: g */
    public k60<Void> f1895g = new k60<>();

    /* JADX WARN: Removed duplicated region for block: B:9:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c90(com.google.firebase.FirebaseApp r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.f1889a = r0
            com.sonelli.k60 r0 = new com.sonelli.k60
            r0.<init>()
            r4.f1890b = r0
            com.sonelli.k60 r0 = new com.sonelli.k60
            r0.<init>()
            r4.f1895g = r0
            r4.f1894f = r5
            android.content.Context r5 = r5.m1580g()
            if (r5 == 0) goto L82
            android.content.SharedPreferences r0 = com.sonelli.w80.m9441t(r5)
            r4.f1891c = r0
            r1 = 0
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r2 = r0.contains(r2)
            r3 = 1
            if (r2 == 0) goto L39
            java.lang.String r5 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r0.getBoolean(r5, r3)
        L36:
            r1 = r3
            r3 = r5
            goto L6a
        L39:
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            if (r0 == 0) goto L6a
            java.lang.String r5 = r5.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            r2 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r5 = r0.getApplicationInfo(r5, r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            if (r5 == 0) goto L6a
            android.os.Bundle r0 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            if (r0 == 0) goto L6a
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r0 = r0.containsKey(r2)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            if (r0 == 0) goto L6a
            android.os.Bundle r5 = r5.metaData     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            java.lang.String r0 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L60
            goto L36
        L60:
            r5 = move-exception
            com.sonelli.m80 r0 = com.sonelli.m80.m6375f()
            java.lang.String r2 = "Unable to get PackageManager. Falling through"
            r0.m6378c(r2, r5)
        L6a:
            r4.f1893e = r3
            r4.f1892d = r1
            java.lang.Object r5 = r4.f1889a
            monitor-enter(r5)
            boolean r0 = r4.m2716b()     // Catch: java.lang.Throwable -> L7f
            if (r0 == 0) goto L7d
            com.sonelli.k60<java.lang.Void> r0 = r4.f1890b     // Catch: java.lang.Throwable -> L7f
            r1 = 0
            r0.m5846e(r1)     // Catch: java.lang.Throwable -> L7f
        L7d:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7f
            return
        L7f:
            r0 = move-exception
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L7f
            throw r0
        L82:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.c90.<init>(com.google.firebase.FirebaseApp):void");
    }

    /* renamed from: a */
    public void m2715a(boolean z) {
        if (!z) {
            throw new IllegalStateException("An invalid data collection token was used.");
        }
        this.f1895g.m5846e(null);
    }

    /* renamed from: b */
    public boolean m2716b() {
        return this.f1892d ? this.f1893e : this.f1894f.m1585p();
    }

    /* renamed from: c */
    public j60<Void> m2717c() {
        j60<Void> m5842a;
        synchronized (this.f1889a) {
            m5842a = this.f1890b.m5842a();
        }
        return m5842a;
    }

    /* renamed from: d */
    public j60<Void> m2718d() {
        return r90.m7897g(this.f1895g.m5842a(), m2717c());
    }
}
