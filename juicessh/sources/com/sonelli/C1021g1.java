package com.sonelli;

import android.content.Context;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.g1 */
/* loaded from: classes.dex */
public final class C1021g1 implements Factory<WorkScheduler> {

    /* renamed from: a */
    public final Provider<Context> f2796a;

    /* renamed from: b */
    public final Provider<EventStore> f2797b;

    /* renamed from: c */
    public final Provider<AbstractC1583n1> f2798c;

    /* renamed from: d */
    public final Provider<Clock> f2799d;

    public C1021g1(Provider<Context> provider, Provider<EventStore> provider2, Provider<AbstractC1583n1> provider3, Provider<Clock> provider4) {
        this.f2796a = provider;
        this.f2797b = provider2;
        this.f2798c = provider3;
        this.f2799d = provider4;
    }

    /* renamed from: a */
    public static C1021g1 m3926a(Provider<Context> provider, Provider<EventStore> provider2, Provider<AbstractC1583n1> provider3, Provider<Clock> provider4) {
        return new C1021g1(provider, provider2, provider3, provider4);
    }

    /* renamed from: c */
    public static WorkScheduler m3927c(Context context, EventStore eventStore, AbstractC1583n1 abstractC1583n1, Clock clock) {
        WorkScheduler m3651a = AbstractC0964f1.m3651a(context, eventStore, abstractC1583n1, clock);
        fm0.m3809c(m3651a, "Cannot return null from a non-@Nullable @Provides method");
        return m3651a;
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkScheduler get() {
        return m3927c(this.f2796a.get(), this.f2797b.get(), this.f2798c.get(), this.f2799d.get());
    }
}
