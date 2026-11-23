package cz.opentree;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class x20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f7853O;

    /* renamed from: P */
    public final /* synthetic */ String f7854P;

    /* renamed from: Q */
    public final /* synthetic */ zzm f7855Q;

    /* renamed from: R */
    public final /* synthetic */ zzs f7856R;

    /* renamed from: S */
    public final /* synthetic */ g20 f7857S;

    public x20(g20 g20Var, String str, String str2, zzm zzmVar, zzs zzsVar) {
        this.f7857S = g20Var;
        this.f7853O = str;
        this.f7854P = str2;
        this.f7855Q = zzmVar;
        this.f7856R = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        ArrayList<Bundle> arrayList = new ArrayList<>();
        try {
            zzelVar = this.f7857S.f2805d;
            if (zzelVar == null) {
                this.f7857S.mo1484j().m8522H().m9085c("Failed to get conditional properties; not connected to service", this.f7853O, this.f7854P);
                return;
            }
            ArrayList<Bundle> m4002q0 = g40.m4002q0(zzelVar.mo1470R(this.f7853O, this.f7854P, this.f7855Q));
            this.f7857S.m3964e0();
            this.f7857S.m7588m().m4033S(this.f7856R, m4002q0);
        } catch (RemoteException e) {
            this.f7857S.mo1484j().m8522H().m9086d("Failed to get conditional properties; remote exception", this.f7853O, this.f7854P, e);
        } finally {
            this.f7857S.m7588m().m4033S(this.f7856R, arrayList);
        }
    }
}
