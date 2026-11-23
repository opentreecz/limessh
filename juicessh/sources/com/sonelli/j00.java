package com.sonelli;

import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class j00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzkn f3462O;

    /* renamed from: P */
    public final /* synthetic */ zzm f3463P;

    /* renamed from: Q */
    public final /* synthetic */ a00 f3464Q;

    public j00(a00 a00Var, zzkn zzknVar, zzm zzmVar) {
        this.f3464Q = a00Var;
        this.f3462O = zzknVar;
        this.f3463P = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30 z30Var3;
        z30Var = this.f3464Q.f1301a;
        z30Var.m10367d0();
        if (this.f3462O.m1501x() == null) {
            z30Var3 = this.f3464Q.f1301a;
            z30Var3.m10347M(this.f3462O, this.f3463P);
        } else {
            z30Var2 = this.f3464Q.f1301a;
            z30Var2.m10384v(this.f3462O, this.f3463P);
        }
    }
}
