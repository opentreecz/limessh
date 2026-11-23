package cz.opentree;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.q1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1744q1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final C1894t1 f5906a;

    /* renamed from: b */
    public final AbstractC1795r0 f5907b;

    /* renamed from: c */
    public final Iterable f5908c;

    /* renamed from: d */
    public final AbstractC1138i0 f5909d;

    /* renamed from: e */
    public final int f5910e;

    public C1744q1(C1894t1 c1894t1, AbstractC1795r0 abstractC1795r0, Iterable iterable, AbstractC1138i0 abstractC1138i0, int i) {
        this.f5906a = c1894t1;
        this.f5907b = abstractC1795r0;
        this.f5908c = iterable;
        this.f5909d = abstractC1138i0;
        this.f5910e = i;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m7598a(C1894t1 c1894t1, AbstractC1795r0 abstractC1795r0, Iterable iterable, AbstractC1138i0 abstractC1138i0, int i) {
        return new C1744q1(c1894t1, abstractC1795r0, iterable, abstractC1138i0, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        return C1894t1.m8568c(this.f5906a, this.f5907b, this.f5908c, this.f5909d, this.f5910e);
    }
}
