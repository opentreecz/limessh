package com.sonelli;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o30 implements Runnable {

    /* renamed from: O */
    public long f5412O;

    /* renamed from: P */
    public long f5413P;

    /* renamed from: Q */
    public final /* synthetic */ l30 f5414Q;

    public o30(l30 l30Var, long j, long j2) {
        this.f5414Q = l30Var;
        this.f5412O = j;
        this.f5413P = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5414Q.f4729b.mo1481g().m8281A(new Runnable(this) { // from class: com.sonelli.n30

            /* renamed from: O */
            public final o30 f5214O;

            {
                this.f5214O = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                o30 o30Var = this.f5214O;
                l30 l30Var = o30Var.f5414Q;
                long j = o30Var.f5412O;
                long j2 = o30Var.f5413P;
                l30Var.f4729b.mo7585d();
                l30Var.f4729b.mo1484j().m8529O().m9083a("Application going to the background");
                if (l30Var.f4729b.m7590o().m2630u(C1735pu.f5789F0)) {
                    l30Var.f4729b.m7589n().f2579x.m4291a(true);
                }
                if (!l30Var.f4729b.m7590o().m2619M().booleanValue()) {
                    l30Var.f4729b.f4451e.m7612f(j2);
                    l30Var.f4729b.m5799F(false, false, j2);
                }
                l30Var.f4729b.m10662q().m10006P("auto", "_ab", j, new Bundle());
            }
        });
    }
}
