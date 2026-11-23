package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.n5 */
/* loaded from: classes.dex */
public class C1588n5 {

    /* renamed from: c */
    public static final Lock f5229c = new ReentrantLock();

    /* renamed from: d */
    @GuardedBy("sLk")
    public static C1588n5 f5230d;

    /* renamed from: a */
    public final Lock f5231a = new ReentrantLock();

    /* renamed from: b */
    @GuardedBy("mLk")
    public final SharedPreferences f5232b;

    public C1588n5(Context context) {
        this.f5232b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: b */
    public static C1588n5 m6639b(Context context) {
        C0813ca.m2729k(context);
        Lock lock = f5229c;
        lock.lock();
        try {
            if (f5230d == null) {
                f5230d = new C1588n5(context.getApplicationContext());
            }
            C1588n5 c1588n5 = f5230d;
            lock.unlock();
            return c1588n5;
        } catch (Throwable th) {
            f5229c.unlock();
            throw th;
        }
    }

    /* renamed from: h */
    public static String m6640h(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public void m6641a() {
        this.f5231a.lock();
        try {
            this.f5232b.edit().clear().apply();
        } finally {
            this.f5231a.unlock();
        }
    }

    @Nullable
    /* renamed from: c */
    public GoogleSignInAccount m6642c() {
        return m6647i(m6649k("defaultGoogleSignInAccount"));
    }

    @Nullable
    /* renamed from: d */
    public GoogleSignInOptions m6643d() {
        return m6648j(m6649k("defaultGoogleSignInAccount"));
    }

    @Nullable
    /* renamed from: e */
    public String m6644e() {
        return m6649k("refreshToken");
    }

    /* renamed from: f */
    public void m6645f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        C0813ca.m2729k(googleSignInAccount);
        C0813ca.m2729k(googleSignInOptions);
        m6646g("defaultGoogleSignInAccount", googleSignInAccount.m900j0());
        C0813ca.m2729k(googleSignInAccount);
        C0813ca.m2729k(googleSignInOptions);
        String m900j0 = googleSignInAccount.m900j0();
        m6646g(m6640h("googleSignInAccount", m900j0), googleSignInAccount.m901k0());
        m6646g(m6640h("googleSignInOptions", m900j0), googleSignInOptions.m924l0());
    }

    /* renamed from: g */
    public final void m6646g(String str, String str2) {
        this.f5231a.lock();
        try {
            this.f5232b.edit().putString(str, str2).apply();
        } finally {
            this.f5231a.unlock();
        }
    }

    @Nullable
    /* renamed from: i */
    public final GoogleSignInAccount m6647i(String str) {
        String m6649k;
        if (!TextUtils.isEmpty(str) && (m6649k = m6649k(m6640h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.m889h0(m6649k);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: j */
    public final GoogleSignInOptions m6648j(String str) {
        String m6649k;
        if (!TextUtils.isEmpty(str) && (m6649k = m6649k(m6640h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.m907f0(m6649k);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: k */
    public final String m6649k(String str) {
        this.f5231a.lock();
        try {
            return this.f5232b.getString(str, null);
        } finally {
            this.f5231a.unlock();
        }
    }
}
