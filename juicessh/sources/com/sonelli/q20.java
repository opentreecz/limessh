package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzel;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class q20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzaq f5919O;

    /* renamed from: P */
    public final /* synthetic */ String f5920P;

    /* renamed from: Q */
    public final /* synthetic */ zzs f5921Q;

    /* renamed from: R */
    public final /* synthetic */ g20 f5922R;

    public q20(g20 g20Var, zzaq zzaqVar, String str, zzs zzsVar) {
        this.f5922R = g20Var;
        this.f5919O = zzaqVar;
        this.f5920P = str;
        this.f5921Q = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        try {
            zzelVar = this.f5922R.f2805d;
            if (zzelVar == null) {
                this.f5922R.mo1484j().m8522H().m9083a("Discarding data. Failed to send event to service to bundle");
                return;
            }
            byte[] mo1477v = zzelVar.mo1477v(this.f5919O, this.f5920P);
            this.f5922R.m3964e0();
            this.f5922R.m7588m().m4035U(this.f5921Q, mo1477v);
        } catch (RemoteException e) {
            this.f5922R.mo1484j().m8522H().m9084b("Failed to send event to the service to bundle", e);
        } finally {
            this.f5922R.m7588m().m4035U(this.f5921Q, null);
        }
    }
}
