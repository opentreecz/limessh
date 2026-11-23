package com.sonelli;

import com.google.android.gms.measurement.internal.zzel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class d30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzel f2118O;

    /* renamed from: P */
    public final /* synthetic */ y20 f2119P;

    public d30(y20 y20Var, zzel zzelVar) {
        this.f2119P = y20Var;
        this.f2118O = zzelVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f2119P) {
            y20.m10051c(this.f2119P, false);
            if (!this.f2119P.f8116c.m3955V()) {
                this.f2119P.f8116c.mo1484j().m8529O().m9083a("Connected to remote service");
                this.f2119P.f8116c.m3946L(this.f2118O);
            }
        }
    }
}
