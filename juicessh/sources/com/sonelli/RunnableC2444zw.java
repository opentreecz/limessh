package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.zw */
/* loaded from: classes.dex */
public final class RunnableC2444zw implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f8601O;

    /* renamed from: P */
    public final /* synthetic */ long f8602P;

    /* renamed from: Q */
    public final /* synthetic */ C2313xu f8603Q;

    public RunnableC2444zw(C2313xu c2313xu, String str, long j) {
        this.f8603Q = c2313xu;
        this.f8601O = str;
        this.f8602P = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f8603Q.m9892G(this.f8601O, this.f8602P);
    }
}
