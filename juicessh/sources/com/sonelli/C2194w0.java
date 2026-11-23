package com.sonelli;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.w0 */
/* loaded from: classes.dex */
public final class C2194w0 implements Factory<C2146v0> {

    /* renamed from: a */
    public final Provider<Context> f7578a;

    /* renamed from: b */
    public final Provider<C1893t0> f7579b;

    public C2194w0(Provider<Context> provider, Provider<C1893t0> provider2) {
        this.f7578a = provider;
        this.f7579b = provider2;
    }

    /* renamed from: a */
    public static C2194w0 m9377a(Provider<Context> provider, Provider<C1893t0> provider2) {
        return new C2194w0(provider, provider2);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2146v0 get() {
        return new C2146v0(this.f7578a.get(), this.f7579b.get());
    }
}
