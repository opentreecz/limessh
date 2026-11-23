package cz.opentree;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.y1 */
/* loaded from: classes.dex */
public final class C2321y1 implements Factory<C2254x1> {

    /* renamed from: a */
    public final Provider<Executor> f8107a;

    /* renamed from: b */
    public final Provider<EventStore> f8108b;

    /* renamed from: c */
    public final Provider<WorkScheduler> f8109c;

    /* renamed from: d */
    public final Provider<SynchronizationGuard> f8110d;

    public C2321y1(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f8107a = provider;
        this.f8108b = provider2;
        this.f8109c = provider3;
        this.f8110d = provider4;
    }

    /* renamed from: a */
    public static C2321y1 m10046a(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new C2321y1(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C2254x1 get() {
        return new C2254x1(this.f8107a.get(), this.f8108b.get(), this.f8109c.get(), this.f8110d.get());
    }
}
