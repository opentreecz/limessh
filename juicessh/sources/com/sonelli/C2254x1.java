package com.sonelli;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.x1 */
/* loaded from: classes.dex */
public class C2254x1 {

    /* renamed from: a */
    public final Executor f7840a;

    /* renamed from: b */
    public final EventStore f7841b;

    /* renamed from: c */
    public final WorkScheduler f7842c;

    /* renamed from: d */
    public final SynchronizationGuard f7843d;

    public C2254x1(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f7840a = executor;
        this.f7841b = eventStore;
        this.f7842c = workScheduler;
        this.f7843d = synchronizationGuard;
    }

    /* renamed from: b */
    public static /* synthetic */ Object m9665b(C2254x1 c2254x1) {
        Iterator<AbstractC1138i0> it = c2254x1.f7841b.mo763u().iterator();
        while (it.hasNext()) {
            c2254x1.f7842c.mo754a(it.next(), 1);
        }
        return null;
    }

    /* renamed from: a */
    public void m9667a() {
        this.f7840a.execute(RunnableC2147v1.m9141a(this));
    }
}
