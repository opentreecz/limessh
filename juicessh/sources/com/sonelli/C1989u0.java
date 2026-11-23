package com.sonelli;

import android.content.Context;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.u0 */
/* loaded from: classes.dex */
public final class C1989u0 implements Factory<C1893t0> {

    /* renamed from: a */
    public final Provider<Context> f6877a;

    /* renamed from: b */
    public final Provider<Clock> f6878b;

    /* renamed from: c */
    public final Provider<Clock> f6879c;

    public C1989u0(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f6877a = provider;
        this.f6878b = provider2;
        this.f6879c = provider3;
    }

    /* renamed from: a */
    public static C1989u0 m8821a(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new C1989u0(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1893t0 get() {
        return new C1893t0(this.f6877a.get(), this.f6878b.get(), this.f6879c.get());
    }
}
