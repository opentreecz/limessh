package cz.opentree;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class pf0 implements Runnable {

    /* renamed from: O */
    public final qf0 f5658O;

    /* renamed from: P */
    public final boolean f5659P;

    public pf0(qf0 qf0Var, boolean z) {
        this.f5658O = qf0Var;
        this.f5659P = z;
    }

    /* renamed from: a */
    public static Runnable m7318a(qf0 qf0Var, boolean z) {
        return new pf0(qf0Var, z);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f5658O.m7688j(this.f5659P);
    }
}
