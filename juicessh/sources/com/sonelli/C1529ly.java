package com.sonelli;

import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.measurement.internal.zzek;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ly */
/* loaded from: classes.dex */
public final class C1529ly<V> {

    /* renamed from: h */
    public static final Object f4927h = new Object();

    /* renamed from: a */
    public final String f4928a;

    /* renamed from: b */
    public final zzek<V> f4929b;

    /* renamed from: c */
    public final V f4930c;

    /* renamed from: d */
    public final V f4931d;

    /* renamed from: e */
    public final Object f4932e;

    /* renamed from: f */
    @GuardedBy("overrideLock")
    public volatile V f4933f;

    /* renamed from: g */
    @GuardedBy("cachingLock")
    public volatile V f4934g;

    public C1529ly(@NonNull String str, @NonNull V v, @NonNull V v2, @Nullable zzek<V> zzekVar) {
        this.f4932e = new Object();
        this.f4933f = null;
        this.f4934g = null;
        this.f4928a = str;
        this.f4930c = v;
        this.f4931d = v2;
        this.f4929b = zzekVar;
    }

    /* renamed from: a */
    public final V m6320a(@Nullable V v) {
        synchronized (this.f4932e) {
        }
        if (v != null) {
            return v;
        }
        if (C1478ky.f4675a == null) {
            return this.f4930c;
        }
        synchronized (f4927h) {
            if (t40.m8593a()) {
                return this.f4934g == null ? this.f4930c : this.f4934g;
            }
            try {
                for (C1529ly c1529ly : C1735pu.m7540v0()) {
                    if (t40.m8593a()) {
                        throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                    }
                    V v2 = null;
                    try {
                        zzek<V> zzekVar = c1529ly.f4929b;
                        if (zzekVar != null) {
                            v2 = zzekVar.mo1462a();
                        }
                    } catch (IllegalStateException unused) {
                    }
                    synchronized (f4927h) {
                        c1529ly.f4934g = v2;
                    }
                }
            } catch (SecurityException unused2) {
            }
            zzek<V> zzekVar2 = this.f4929b;
            if (zzekVar2 == null) {
                return this.f4930c;
            }
            try {
                return zzekVar2.mo1462a();
            } catch (IllegalStateException unused3) {
                return this.f4930c;
            } catch (SecurityException unused4) {
                return this.f4930c;
            }
        }
    }

    /* renamed from: b */
    public final String m6321b() {
        return this.f4928a;
    }
}
