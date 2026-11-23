package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class n20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ b20 f5199O;

    /* renamed from: P */
    public final /* synthetic */ g20 f5200P;

    public n20(g20 g20Var, b20 b20Var) {
        this.f5200P = g20Var;
        this.f5199O = b20Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f5200P.f2805d;
        if (zzelVar == null) {
            this.f5200P.mo1484j().m8522H().m9083a("Failed to send current screen to service");
            return;
        }
        try {
            b20 b20Var = this.f5199O;
            if (b20Var == null) {
                zzelVar.mo1473a0(0L, null, null, this.f5200P.mo1482h().getPackageName());
            } else {
                zzelVar.mo1473a0(b20Var.f1590c, b20Var.f1588a, b20Var.f1589b, this.f5200P.mo1482h().getPackageName());
            }
            this.f5200P.m3964e0();
        } catch (RemoteException e) {
            this.f5200P.mo1484j().m8522H().m9084b("Failed to send current screen to the service", e);
        }
    }
}
