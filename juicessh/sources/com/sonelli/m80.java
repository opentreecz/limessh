package com.sonelli;

import android.util.Log;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class m80 {

    /* renamed from: c */
    public static final m80 f5001c = new m80("FirebaseCrashlytics");

    /* renamed from: a */
    public final String f5002a;

    /* renamed from: b */
    public int f5003b = 4;

    public m80(String str) {
        this.f5002a = str;
    }

    /* renamed from: f */
    public static m80 m6375f() {
        return f5001c;
    }

    /* renamed from: a */
    public final boolean m6376a(int i) {
        return this.f5003b <= i || Log.isLoggable(this.f5002a, i);
    }

    /* renamed from: b */
    public void m6377b(String str) {
        m6378c(str, null);
    }

    /* renamed from: c */
    public void m6378c(String str, Throwable th) {
        if (m6376a(3)) {
            Log.d(this.f5002a, str, th);
        }
    }

    /* renamed from: d */
    public void m6379d(String str) {
        m6380e(str, null);
    }

    /* renamed from: e */
    public void m6380e(String str, Throwable th) {
        if (m6376a(6)) {
            Log.e(this.f5002a, str, th);
        }
    }

    /* renamed from: g */
    public void m6381g(String str) {
        m6382h(str, null);
    }

    /* renamed from: h */
    public void m6382h(String str, Throwable th) {
        if (m6376a(4)) {
            Log.i(this.f5002a, str, th);
        }
    }

    /* renamed from: i */
    public void m6383i(String str) {
        m6384j(str, null);
    }

    /* renamed from: j */
    public void m6384j(String str, Throwable th) {
        if (m6376a(5)) {
            Log.w(this.f5002a, str, th);
        }
    }
}
