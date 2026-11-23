package com.sonelli;

import com.google.android.gms.measurement.internal.zzel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class b30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzel f1596O;

    /* renamed from: P */
    public final /* synthetic */ y20 f1597P;

    public b30(y20 y20Var, zzel zzelVar) {
        this.f1597P = y20Var;
        this.f1596O = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f1597P) {
            y20.m10051c(this.f1597P, false);
            if (!this.f1597P.f8116c.m3955V()) {
                this.f1597P.f8116c.mo1484j().m8530P().m9083a("Connected to service");
                this.f1597P.f8116c.m3946L(this.f1596O);
            }
        }
    }
}
