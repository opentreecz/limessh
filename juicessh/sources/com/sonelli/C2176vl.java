package com.sonelli;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.annotation.GuardedBy;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzcg;
import com.google.android.gms.internal.measurement.zzch;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.vl */
/* loaded from: classes.dex */
public final class C2176vl implements zzcg {

    /* renamed from: f */
    @GuardedBy("SharedPreferencesLoader.class")
    public static final Map<String, C2176vl> f7497f = new ArrayMap();

    /* renamed from: a */
    public final SharedPreferences f7498a;

    /* renamed from: b */
    public final SharedPreferences.OnSharedPreferenceChangeListener f7499b;

    /* renamed from: c */
    public final Object f7500c;

    /* renamed from: d */
    public volatile Map<String, ?> f7501d;

    /* renamed from: e */
    @GuardedBy("this")
    public final List<zzch> f7502e;

    public C2176vl(SharedPreferences sharedPreferences) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener(this) { // from class: com.sonelli.ul

            /* renamed from: O */
            public final C2176vl f6994O;

            {
                this.f6994O = this;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.f6994O.m9302c(sharedPreferences2, str);
            }
        };
        this.f7499b = onSharedPreferenceChangeListener;
        this.f7500c = new Object();
        this.f7502e = new ArrayList();
        this.f7498a = sharedPreferences;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    /* renamed from: a */
    public static C2176vl m9299a(Context context, String str) {
        C2176vl c2176vl;
        if (!((!C0834cl.m2864a() || str.startsWith("direct_boot:")) ? true : C0834cl.m2865b(context))) {
            return null;
        }
        synchronized (C2176vl.class) {
            Map<String, C2176vl> map = f7497f;
            c2176vl = map.get(str);
            if (c2176vl == null) {
                c2176vl = new C2176vl(m9301d(context, str));
                map.put(str, c2176vl);
            }
        }
        return c2176vl;
    }

    /* renamed from: b */
    public static synchronized void m9300b() {
        synchronized (C2176vl.class) {
            for (C2176vl c2176vl : f7497f.values()) {
                c2176vl.f7498a.unregisterOnSharedPreferenceChangeListener(c2176vl.f7499b);
            }
            f7497f.clear();
        }
    }

    /* renamed from: d */
    public static SharedPreferences m9301d(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                return context.getSharedPreferences(str, 0);
            }
            if (C0834cl.m2864a()) {
                context = context.createDeviceProtectedStorageContext();
            }
            return context.getSharedPreferences(str.substring(12), 0);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    /* renamed from: c */
    public final /* synthetic */ void m9302c(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f7500c) {
            this.f7501d = null;
            AbstractC1559ml.m6449g();
        }
        synchronized (this) {
            Iterator<zzch> it = this.f7502e.iterator();
            while (it.hasNext()) {
                it.next().m1220a();
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzcg
    /* renamed from: f */
    public final Object mo1219f(String str) {
        Map<String, ?> map = this.f7501d;
        if (map == null) {
            synchronized (this.f7500c) {
                map = this.f7501d;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.f7498a.getAll();
                        this.f7501d = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
