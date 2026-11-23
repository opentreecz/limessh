package cz.opentree;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* renamed from: cz.opentree.a6 */
/* loaded from: classes.dex */
public final class C0696a6 {

    /* renamed from: d */
    @Nullable
    public static C0696a6 f1333d;

    /* renamed from: a */
    public C1588n5 f1334a;

    /* renamed from: b */
    @Nullable
    public GoogleSignInAccount f1335b;

    /* renamed from: c */
    @Nullable
    public GoogleSignInOptions f1336c;

    public C0696a6(Context context) {
        C1588n5 m6639b = C1588n5.m6639b(context);
        this.f1334a = m6639b;
        this.f1335b = m6639b.m6642c();
        this.f1336c = this.f1334a.m6643d();
    }

    /* renamed from: c */
    public static synchronized C0696a6 m1982c(@NonNull Context context) {
        C0696a6 m1983d;
        synchronized (C0696a6.class) {
            m1983d = m1983d(context.getApplicationContext());
        }
        return m1983d;
    }

    /* renamed from: d */
    public static synchronized C0696a6 m1983d(Context context) {
        synchronized (C0696a6.class) {
            C0696a6 c0696a6 = f1333d;
            if (c0696a6 != null) {
                return c0696a6;
            }
            C0696a6 c0696a62 = new C0696a6(context);
            f1333d = c0696a62;
            return c0696a62;
        }
    }

    /* renamed from: a */
    public final synchronized void m1984a() {
        this.f1334a.m6641a();
        this.f1335b = null;
        this.f1336c = null;
    }

    /* renamed from: b */
    public final synchronized void m1985b(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        this.f1334a.m6645f(googleSignInAccount, googleSignInOptions);
        this.f1335b = googleSignInAccount;
        this.f1336c = googleSignInOptions;
    }

    @Nullable
    /* renamed from: e */
    public final synchronized GoogleSignInAccount m1986e() {
        return this.f1335b;
    }

    @Nullable
    /* renamed from: f */
    public final synchronized GoogleSignInOptions m1987f() {
        return this.f1336c;
    }
}
