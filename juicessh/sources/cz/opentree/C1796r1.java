package cz.opentree;

import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.r1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1796r1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final EventStore f6154a;

    public C1796r1(EventStore eventStore) {
        this.f6154a = eventStore;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m7846a(EventStore eventStore) {
        return new C1796r1(eventStore);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        return Integer.valueOf(this.f6154a.mo759i());
    }
}
