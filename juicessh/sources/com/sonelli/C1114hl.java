package com.sonelli;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzci;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.hl */
/* loaded from: classes.dex */
public final class C1114hl implements zzcg {

    /* renamed from: c */
    @GuardedBy("GservicesLoader.class")
    public static C1114hl f3167c;

    /* renamed from: a */
    @Nullable
    public final Context f3168a;

    /* renamed from: b */
    @Nullable
    public final ContentObserver f3169b;

    public C1114hl() {
        this.f3168a = null;
        this.f3169b = null;
    }

    public C1114hl(Context context) {
        this.f3168a = context;
        C1221jl c1221jl = new C1221jl(this, null);
        this.f3169b = c1221jl;
        context.getContentResolver().registerContentObserver(C0719al.f1434a, true, c1221jl);
    }

    /* renamed from: a */
    public static C1114hl m4482a(Context context) {
        C1114hl c1114hl;
        synchronized (C1114hl.class) {
            if (f3167c == null) {
                f3167c = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C1114hl(context) : new C1114hl();
            }
            c1114hl = f3167c;
        }
        return c1114hl;
    }

    /* renamed from: b */
    public static synchronized void m4483b() {
        Context context;
        synchronized (C1114hl.class) {
            C1114hl c1114hl = f3167c;
            if (c1114hl != null && (context = c1114hl.f3168a) != null && c1114hl.f3169b != null) {
                context.getContentResolver().unregisterContentObserver(f3167c.f3169b);
            }
            f3167c = null;
        }
    }

    /* renamed from: c */
    public final /* synthetic */ String m4484c(String str) {
        return C0719al.m2141a(this.f3168a.getContentResolver(), str, null);
    }

    @Override // com.google.android.gms.internal.measurement.zzcg
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final String mo1219f(final String str) {
        if (this.f3168a == null) {
            return null;
        }
        try {
            return (String) C0996fl.m3779a(new zzci(this, str) { // from class: com.sonelli.gl

                /* renamed from: a */
                public final C1114hl f2885a;

                /* renamed from: b */
                public final String f2886b;

                {
                    this.f2885a = this;
                    this.f2886b = str;
                }

                @Override // com.google.android.gms.internal.measurement.zzci
                /* renamed from: a */
                public final Object mo1221a() {
                    return this.f2885a.m4484c(this.f2886b);
                }
            });
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }
}
