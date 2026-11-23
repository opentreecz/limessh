package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class i30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ z30 f3261O;

    /* renamed from: P */
    public final /* synthetic */ Runnable f3262P;

    public i30(e30 e30Var, z30 z30Var, Runnable runnable) {
        this.f3261O = z30Var;
        this.f3262P = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3261O.m10367d0();
        this.f3261O.m10388z(this.f3262P);
        this.f3261O.m10365c0();
    }
}
