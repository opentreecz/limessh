package com.sonelli;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.s1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C1842s1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final C1894t1 f6322a;

    /* renamed from: b */
    public final AbstractC1138i0 f6323b;

    /* renamed from: c */
    public final int f6324c;

    public C1842s1(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i) {
        this.f6322a = c1894t1;
        this.f6323b = abstractC1138i0;
        this.f6324c = i;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m8299a(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i) {
        return new C1842s1(c1894t1, abstractC1138i0, i);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        return C1894t1.m8569d(this.f6322a, this.f6323b, this.f6324c);
    }
}
