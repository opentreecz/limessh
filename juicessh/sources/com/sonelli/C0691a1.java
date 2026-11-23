package com.sonelli;

import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.a1 */
/* loaded from: classes.dex */
public final /* synthetic */ class C0691a1 implements SynchronizationGuard.CriticalSection {

    /* renamed from: a */
    public final C0748b1 f1305a;

    /* renamed from: b */
    public final AbstractC1138i0 f1306b;

    /* renamed from: c */
    public final AbstractC0906e0 f1307c;

    public C0691a1(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        this.f1305a = c0748b1;
        this.f1306b = abstractC1138i0;
        this.f1307c = abstractC0906e0;
    }

    /* renamed from: a */
    public static SynchronizationGuard.CriticalSection m1949a(C0748b1 c0748b1, AbstractC1138i0 abstractC1138i0, AbstractC0906e0 abstractC0906e0) {
        return new C0691a1(c0748b1, abstractC1138i0, abstractC0906e0);
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
    /* renamed from: h */
    public Object mo806h() {
        return C0748b1.m2333b(this.f1305a, this.f1306b, this.f1307c);
    }
}
