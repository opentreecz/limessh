package com.sonelli;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.u1 */
/* loaded from: classes.dex */
public final class C1990u1 implements Factory<C1894t1> {

    /* renamed from: a */
    public final Provider<Context> f6890a;

    /* renamed from: b */
    public final Provider<BackendRegistry> f6891b;

    /* renamed from: c */
    public final Provider<EventStore> f6892c;

    /* renamed from: d */
    public final Provider<WorkScheduler> f6893d;

    /* renamed from: e */
    public final Provider<Executor> f6894e;

    /* renamed from: f */
    public final Provider<SynchronizationGuard> f6895f;

    /* renamed from: g */
    public final Provider<Clock> f6896g;

    public C1990u1(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        this.f6890a = provider;
        this.f6891b = provider2;
        this.f6892c = provider3;
        this.f6893d = provider4;
        this.f6894e = provider5;
        this.f6895f = provider6;
        this.f6896g = provider7;
    }

    /* renamed from: a */
    public static C1990u1 m8831a(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7) {
        return new C1990u1(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1894t1 get() {
        return new C1894t1(this.f6890a.get(), this.f6891b.get(), this.f6892c.get(), this.f6893d.get(), this.f6894e.get(), this.f6895f.get(), this.f6896g.get());
    }
}
