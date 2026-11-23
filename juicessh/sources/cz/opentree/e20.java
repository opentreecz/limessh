package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class e20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ b20 f2322O;

    /* renamed from: P */
    public final /* synthetic */ long f2323P;

    /* renamed from: Q */
    public final /* synthetic */ a20 f2324Q;

    public e20(a20 a20Var, b20 b20Var, long j) {
        this.f2324Q = a20Var;
        this.f2322O = b20Var;
        this.f2323P = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2324Q.m1967O(this.f2322O, false, this.f2323P);
        a20 a20Var = this.f2324Q;
        a20Var.f1316e = null;
        a20Var.m10664s().m3948N(null);
    }
}
