package cz.opentree;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzm f4723O;

    /* renamed from: P */
    public final /* synthetic */ zzs f4724P;

    /* renamed from: Q */
    public final /* synthetic */ g20 f4725Q;

    public l20(g20 g20Var, zzm zzmVar, zzs zzsVar) {
        this.f4725Q = g20Var;
        this.f4723O = zzmVar;
        this.f4724P = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        try {
            zzelVar = this.f4725Q.f2805d;
            if (zzelVar == null) {
                this.f4725Q.mo1484j().m8522H().m9083a("Failed to get app instance id");
                return;
            }
            String mo1478v0 = zzelVar.mo1478v0(this.f4723O);
            if (mo1478v0 != null) {
                this.f4725Q.m10662q().m10005O(mo1478v0);
                this.f4725Q.m7589n().f2567l.m6013b(mo1478v0);
            }
            this.f4725Q.m3964e0();
            this.f4725Q.m7588m().m4032R(this.f4724P, mo1478v0);
        } catch (RemoteException e) {
            this.f4725Q.mo1484j().m8522H().m9084b("Failed to get app instance id", e);
        } finally {
            this.f4725Q.m7588m().m4032R(this.f4724P, null);
        }
    }
}
