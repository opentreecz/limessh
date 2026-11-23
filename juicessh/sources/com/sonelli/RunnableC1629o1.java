package com.sonelli;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.o1 */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1629o1 implements Runnable {

    /* renamed from: O */
    public final C1894t1 f5399O;

    /* renamed from: P */
    public final AbstractC1138i0 f5400P;

    /* renamed from: Q */
    public final int f5401Q;

    /* renamed from: R */
    public final Runnable f5402R;

    public RunnableC1629o1(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i, Runnable runnable) {
        this.f5399O = c1894t1;
        this.f5400P = abstractC1138i0;
        this.f5401Q = i;
        this.f5402R = runnable;
    }

    /* renamed from: a */
    public static Runnable m6833a(C1894t1 c1894t1, AbstractC1138i0 abstractC1138i0, int i, Runnable runnable) {
        return new RunnableC1629o1(c1894t1, abstractC1138i0, i, runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        C1894t1.m8570e(this.f5399O, this.f5400P, this.f5401Q, this.f5402R);
    }
}
