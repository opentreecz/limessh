package cz.opentree;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.w1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C2195w1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final C2254x1 f7586a;

    public C2195w1(C2254x1 c2254x1) {
        this.f7586a = c2254x1;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m9381a(C2254x1 c2254x1) {
        return new C2195w1(c2254x1);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        return C2254x1.m9665b(this.f7586a);
    }
}
