package com.sonelli;

import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class l00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f4709O;

    /* renamed from: P */
    public final /* synthetic */ a00 f4710P;

    public l00(a00 a00Var, zzm zzmVar) {
        this.f4710P = a00Var;
        this.f4709O = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f4710P.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f4710P.f1301a;
        z30Var2.m10348N(this.f4709O);
    }
}
