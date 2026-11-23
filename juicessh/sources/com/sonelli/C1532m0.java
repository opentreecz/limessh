package com.sonelli;

import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.m0 */
/* loaded from: classes.dex */
public final class C1532m0 implements Factory<C1483l0> {

    /* renamed from: a */
    public final Provider<Clock> f4941a;

    /* renamed from: b */
    public final Provider<Clock> f4942b;

    /* renamed from: c */
    public final Provider<Scheduler> f4943c;

    /* renamed from: d */
    public final Provider<C1894t1> f4944d;

    /* renamed from: e */
    public final Provider<C2254x1> f4945e;

    public C1532m0(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<C1894t1> provider4, Provider<C2254x1> provider5) {
        this.f4941a = provider;
        this.f4942b = provider2;
        this.f4943c = provider3;
        this.f4944d = provider4;
        this.f4945e = provider5;
    }

    /* renamed from: a */
    public static C1532m0 m6327a(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<C1894t1> provider4, Provider<C2254x1> provider5) {
        return new C1532m0(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1483l0 get() {
        return new C1483l0(this.f4941a.get(), this.f4942b.get(), this.f4943c.get(), this.f4944d.get(), this.f4945e.get());
    }
}
