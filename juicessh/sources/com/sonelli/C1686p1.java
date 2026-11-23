package com.sonelli;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.p1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1686p1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final C1894t1 f5590a;

    /* renamed from: b */
    public final AbstractC1138i0 f5591b;

    public C1686p1(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0) {
        this.f5590a = c1894t1;
        this.f5591b = abstractC1138i0;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m7216a(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0) {
        return new C1686p1(c1894t1, abstractC1138i0);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        Iterable mo761q;
        mo761q = this.f5590a.f6682c.mo761q(this.f5591b);
        return mo761q;
    }
}
