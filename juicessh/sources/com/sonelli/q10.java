package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ boolean f5911O;

    /* renamed from: P */
    public final /* synthetic */ y00 f5912P;

    public q10(y00 y00Var, boolean z) {
        this.f5912P = y00Var;
        this.f5911O = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean m9122q = this.f5912P.f5899a.m9122q();
        boolean m9121p = this.f5912P.f5899a.m9121p();
        this.f5912P.f5899a.m9120o(this.f5911O);
        if (m9121p == this.f5911O) {
            this.f5912P.f5899a.mo1484j().m8530P().m9084b("Default data collection state already set to", Boolean.valueOf(this.f5911O));
        }
        if (this.f5912P.f5899a.m9122q() == m9122q || this.f5912P.f5899a.m9122q() != this.f5912P.f5899a.m9121p()) {
            this.f5912P.f5899a.mo1484j().m8527M().m9085c("Default data collection is different than actual status", Boolean.valueOf(this.f5911O), Boolean.valueOf(m9122q));
        }
        this.f5912P.m10028l0();
    }
}
