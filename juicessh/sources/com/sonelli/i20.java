package com.sonelli;

import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class i20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ boolean f3256O;

    /* renamed from: P */
    public final /* synthetic */ zzkn f3257P;

    /* renamed from: Q */
    public final /* synthetic */ zzm f3258Q;

    /* renamed from: R */
    public final /* synthetic */ g20 f3259R;

    public i20(g20 g20Var, boolean z, zzkn zzknVar, zzm zzmVar) {
        this.f3259R = g20Var;
        this.f3256O = z;
        this.f3257P = zzknVar;
        this.f3258Q = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f3259R.f2805d;
        if (zzelVar == null) {
            this.f3259R.mo1484j().m8522H().m9083a("Discarding data. Failed to set user property");
        } else {
            this.f3259R.m3947M(zzelVar, this.f3256O ? null : this.f3257P, this.f3258Q);
            this.f3259R.m3964e0();
        }
    }
}
