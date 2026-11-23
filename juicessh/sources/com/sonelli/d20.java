package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ b20 f2105O;

    /* renamed from: P */
    public final /* synthetic */ b20 f2106P;

    /* renamed from: Q */
    public final /* synthetic */ long f2107Q;

    /* renamed from: R */
    public final /* synthetic */ boolean f2108R;

    /* renamed from: S */
    public final /* synthetic */ a20 f2109S;

    public d20(a20 a20Var, b20 b20Var, b20 b20Var2, long j, boolean z) {
        this.f2109S = a20Var;
        this.f2105O = b20Var;
        this.f2106P = b20Var2;
        this.f2107Q = j;
        this.f2108R = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2109S.m1966N(this.f2105O, this.f2106P, this.f2107Q, this.f2108R, null);
    }
}
