package com.sonelli;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class j10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f3467O;

    /* renamed from: P */
    public final /* synthetic */ String f3468P;

    /* renamed from: Q */
    public final /* synthetic */ String f3469Q;

    /* renamed from: R */
    public final /* synthetic */ String f3470R;

    /* renamed from: S */
    public final /* synthetic */ boolean f3471S;

    /* renamed from: T */
    public final /* synthetic */ y00 f3472T;

    public j10(y00 y00Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f3472T = y00Var;
        this.f3467O = atomicReference;
        this.f3468P = str;
        this.f3469Q = str2;
        this.f3470R = str3;
        this.f3471S = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3472T.f5899a.m9111Q().m3954U(this.f3467O, this.f3468P, this.f3469Q, this.f3470R, this.f3471S);
    }
}
