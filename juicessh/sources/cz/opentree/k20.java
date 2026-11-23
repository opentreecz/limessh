package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class k20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f4446O;

    /* renamed from: P */
    public final /* synthetic */ g20 f4447P;

    public k20(g20 g20Var, zzm zzmVar) {
        this.f4447P = g20Var;
        this.f4446O = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f4447P.f2805d;
        if (zzelVar == null) {
            this.f4447P.mo1484j().m8522H().m9083a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            zzelVar.mo1469P(this.f4446O);
        } catch (RemoteException e) {
            this.f4447P.mo1484j().m8522H().m9084b("Failed to reset data on the service: remote exception", e);
        }
        this.f4447P.m3964e0();
    }
}
