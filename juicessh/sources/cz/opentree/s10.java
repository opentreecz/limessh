package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class s10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ long f6325O;

    /* renamed from: P */
    public final /* synthetic */ y00 f6326P;

    public s10(y00 y00Var, long j) {
        this.f6326P = y00Var;
        this.f6325O = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6326P.m7589n().f2571p.m4969b(this.f6325O);
        this.f6326P.mo1484j().m8529O().m9084b("Minimum session duration set", Long.valueOf(this.f6325O));
    }
}
