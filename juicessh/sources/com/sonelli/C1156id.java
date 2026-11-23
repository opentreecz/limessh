package com.sonelli;

import android.util.Log;
import androidx.annotation.NonNull;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
@CheckReturnValue
/* renamed from: com.sonelli.id */
/* loaded from: classes.dex */
public class C1156id {

    /* renamed from: d */
    public static final C1156id f3294d = new C1156id(true, null, null);

    /* renamed from: a */
    public final boolean f3295a;

    /* renamed from: b */
    public final String f3296b;

    /* renamed from: c */
    public final Throwable f3297c;

    public C1156id(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.f3295a = z;
        this.f3296b = str;
        this.f3297c = th;
    }

    /* renamed from: b */
    public static C1156id m4745b(@NonNull String str, @NonNull Throwable th) {
        return new C1156id(false, str, th);
    }

    /* renamed from: c */
    public static C1156id m4746c(Callable<String> callable) {
        return new C1445kd(callable);
    }

    /* renamed from: d */
    public static C1156id m4747d(@NonNull String str) {
        return new C1156id(false, str, null);
    }

    /* renamed from: e */
    public static String m4748e(String str, AbstractBinderC0763bd abstractBinderC0763bd, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, C1036gc.m4111a(C2338yb.m10120b("SHA-1").digest(abstractBinderC0763bd.mo2434s())), Boolean.valueOf(z), "12451009.false");
    }

    /* renamed from: f */
    public static C1156id m4749f() {
        return f3294d;
    }

    @Nullable
    /* renamed from: a */
    public String mo4750a() {
        return this.f3296b;
    }

    /* renamed from: g */
    public final void m4751g() {
        if (this.f3295a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f3297c != null) {
            Log.d("GoogleCertificatesRslt", mo4750a(), this.f3297c);
        } else {
            Log.d("GoogleCertificatesRslt", mo4750a());
        }
    }
}
