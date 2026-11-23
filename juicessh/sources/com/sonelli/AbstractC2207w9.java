package com.sonelli;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.w9 */
/* loaded from: classes.dex */
public abstract class AbstractC2207w9 {

    /* renamed from: a */
    public static final Object f7645a = new Object();

    /* renamed from: b */
    public static AbstractC2207w9 f7646b;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.sonelli.w9$a */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: f */
        public static final Uri f7647f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

        /* renamed from: a */
        public final String f7648a;

        /* renamed from: b */
        public final String f7649b;

        /* renamed from: c */
        public final ComponentName f7650c;

        /* renamed from: d */
        public final int f7651d;

        /* renamed from: e */
        public final boolean f7652e;

        public a(String str, String str2, int i, boolean z) {
            C0813ca.m2725g(str);
            this.f7648a = str;
            C0813ca.m2725g(str2);
            this.f7649b = str2;
            this.f7650c = null;
            this.f7651d = i;
            this.f7652e = z;
        }

        /* renamed from: a */
        public final ComponentName m9454a() {
            return this.f7650c;
        }

        /* renamed from: b */
        public final String m9455b() {
            return this.f7649b;
        }

        /* renamed from: c */
        public final Intent m9456c(Context context) {
            if (this.f7648a == null) {
                return new Intent().setComponent(this.f7650c);
            }
            if (this.f7652e) {
                Bundle bundle = new Bundle();
                bundle.putString("serviceActionBundleKey", this.f7648a);
                Bundle call = context.getContentResolver().call(f7647f, "serviceIntentCall", (String) null, bundle);
                r1 = call != null ? (Intent) call.getParcelable("serviceResponseIntentKey") : null;
                if (r1 == null) {
                    String valueOf = String.valueOf(this.f7648a);
                    Log.w("ConnectionStatusConfig", valueOf.length() != 0 ? "Dynamic lookup for intent failed for action: ".concat(valueOf) : new String("Dynamic lookup for intent failed for action: "));
                }
            }
            return r1 == null ? new Intent(this.f7648a).setPackage(this.f7649b) : r1;
        }

        /* renamed from: d */
        public final int m9457d() {
            return this.f7651d;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return C0758ba.m2404a(this.f7648a, aVar.f7648a) && C0758ba.m2404a(this.f7649b, aVar.f7649b) && C0758ba.m2404a(this.f7650c, aVar.f7650c) && this.f7651d == aVar.f7651d && this.f7652e == aVar.f7652e;
        }

        public final int hashCode() {
            return C0758ba.m2405b(this.f7648a, this.f7649b, this.f7650c, Integer.valueOf(this.f7651d), Boolean.valueOf(this.f7652e));
        }

        public final String toString() {
            String str = this.f7648a;
            return str == null ? this.f7650c.flattenToString() : str;
        }
    }

    /* renamed from: a */
    public static AbstractC2207w9 m9450a(Context context) {
        synchronized (f7645a) {
            if (f7646b == null) {
                f7646b = new C2270xa(context.getApplicationContext());
            }
        }
        return f7646b;
    }

    /* renamed from: b */
    public final void m9451b(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        mo9453d(new a(str, str2, i, z), serviceConnection, str3);
    }

    /* renamed from: c */
    public abstract boolean mo9452c(a aVar, ServiceConnection serviceConnection, String str);

    /* renamed from: d */
    public abstract void mo9453d(a aVar, ServiceConnection serviceConnection, String str);
}
