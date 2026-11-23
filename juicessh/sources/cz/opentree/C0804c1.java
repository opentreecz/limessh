package cz.opentree;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import dagger.internal.Factory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.c1 */
/* loaded from: classes.dex */
public final class C0804c1 implements Factory<C0748b1> {

    /* renamed from: a */
    public final Provider<Executor> f1857a;

    /* renamed from: b */
    public final Provider<BackendRegistry> f1858b;

    /* renamed from: c */
    public final Provider<WorkScheduler> f1859c;

    /* renamed from: d */
    public final Provider<EventStore> f1860d;

    /* renamed from: e */
    public final Provider<SynchronizationGuard> f1861e;

    public C0804c1(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f1857a = provider;
        this.f1858b = provider2;
        this.f1859c = provider3;
        this.f1860d = provider4;
        this.f1861e = provider5;
    }

    /* renamed from: a */
    public static C0804c1 m2650a(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new C0804c1(provider, provider2, provider3, provider4, provider5);
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0748b1 get() {
        return new C0748b1(this.f1857a.get(), this.f1858b.get(), this.f1859c.get(), this.f1860d.get(), this.f1861e.get());
    }
}
