package com.sonelli;

import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class f00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f2587O;

    /* renamed from: P */
    public final /* synthetic */ a00 f2588P;

    public f00(a00 a00Var, zzm zzmVar) {
        this.f2588P = a00Var;
        this.f2587O = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f2588P.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f2588P.f1301a;
        z30Var2.m10385w(this.f2587O);
    }
}
