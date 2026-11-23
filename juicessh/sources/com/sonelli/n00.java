package com.sonelli;

import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class n00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzy f5177O;

    /* renamed from: P */
    public final /* synthetic */ zzm f5178P;

    /* renamed from: Q */
    public final /* synthetic */ a00 f5179Q;

    public n00(a00 a00Var, zzy zzyVar, zzm zzmVar) {
        this.f5179Q = a00Var;
        this.f5177O = zzyVar;
        this.f5178P = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30 z30Var3;
        z30Var = this.f5179Q.f1301a;
        z30Var.m10367d0();
        if (this.f5177O.f1021Q.m1501x() == null) {
            z30Var3 = this.f5179Q.f1301a;
            z30Var3.m10350P(this.f5177O, this.f5178P);
        } else {
            z30Var2 = this.f5179Q.f1301a;
            z30Var2.m10387y(this.f5177O, this.f5178P);
        }
    }
}
