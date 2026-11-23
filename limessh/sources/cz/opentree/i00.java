package cz.opentree;

import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class i00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzaq f3245O;

    /* renamed from: P */
    public final /* synthetic */ zzm f3246P;

    /* renamed from: Q */
    public final /* synthetic */ a00 f3247Q;

    public i00(a00 a00Var, zzaq zzaqVar, zzm zzmVar) {
        this.f3247Q = a00Var;
        this.f3245O = zzaqVar;
        this.f3246P = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        zzaq m1944P0 = this.f3247Q.m1944P0(this.f3245O, this.f3246P);
        z30Var = this.f3247Q.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f3247Q.f1301a;
        z30Var2.m10379p(m1944P0, this.f3246P);
    }
}
