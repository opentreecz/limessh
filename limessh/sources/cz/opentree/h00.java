package cz.opentree;

import com.google.android.gms.measurement.internal.zzaq;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class h00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzaq f3058O;

    /* renamed from: P */
    public final /* synthetic */ String f3059P;

    /* renamed from: Q */
    public final /* synthetic */ a00 f3060Q;

    public h00(a00 a00Var, zzaq zzaqVar, String str) {
        this.f3060Q = a00Var;
        this.f3058O = zzaqVar;
        this.f3059P = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f3060Q.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f3060Q.f1301a;
        z30Var2.m10380q(this.f3058O, this.f3059P);
    }
}
