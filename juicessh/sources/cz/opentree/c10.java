package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class c10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ long f1862O;

    /* renamed from: P */
    public final /* synthetic */ y00 f1863P;

    public c10(y00 y00Var, long j) {
        this.f1863P = y00Var;
        this.f1862O = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1863P.m7589n().f2572q.m4969b(this.f1862O);
        this.f1863P.mo1484j().m8529O().m9084b("Session timeout duration set", Long.valueOf(this.f1862O));
    }
}
