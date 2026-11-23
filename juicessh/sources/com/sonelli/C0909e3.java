package com.sonelli;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.e3 */
/* loaded from: classes.dex */
public final class C0909e3 implements Factory<SchemaManager> {

    /* renamed from: a */
    public final Provider<Context> f2325a;

    /* renamed from: b */
    public final Provider<String> f2326b;

    /* renamed from: c */
    public final Provider<Integer> f2327c;

    public C0909e3(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        this.f2325a = provider;
        this.f2326b = provider2;
        this.f2327c = provider3;
    }

    /* renamed from: a */
    public static C0909e3 m3395a(Provider<Context> provider, Provider<String> provider2, Provider<Integer> provider3) {
        return new C0909e3(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public SchemaManager get() {
        return new SchemaManager(this.f2325a.get(), this.f2326b.get(), this.f2327c.get().intValue());
    }
}
