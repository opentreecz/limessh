package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f5406O;

    /* renamed from: P */
    public final /* synthetic */ g20 f5407P;

    public o20(g20 g20Var, zzm zzmVar) {
        this.f5407P = g20Var;
        this.f5406O = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f5407P.f2805d;
        if (zzelVar == null) {
            this.f5407P.mo1484j().m8522H().m9083a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            zzelVar.mo1466G0(this.f5406O);
            this.f5407P.m10666u().m7128K();
            this.f5407P.m3947M(zzelVar, null, this.f5406O);
            this.f5407P.m3964e0();
        } catch (RemoteException e) {
            this.f5407P.mo1484j().m8522H().m9084b("Failed to send app launch to the service", e);
        }
    }
}
