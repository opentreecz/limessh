package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class t20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f6693O;

    /* renamed from: P */
    public final /* synthetic */ g20 f6694P;

    public t20(g20 g20Var, zzm zzmVar) {
        this.f6694P = g20Var;
        this.f6693O = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f6694P.f2805d;
        if (zzelVar == null) {
            this.f6694P.mo1484j().m8522H().m9083a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            zzelVar.mo1476o0(this.f6693O);
            this.f6694P.m3964e0();
        } catch (RemoteException e) {
            this.f6694P.mo1484j().m8522H().m9084b("Failed to send measurementEnabled to the service", e);
        }
    }
}
