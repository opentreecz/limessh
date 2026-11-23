package com.sonelli;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzs;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ String f8412O;

    /* renamed from: P */
    public final /* synthetic */ String f8413P;

    /* renamed from: Q */
    public final /* synthetic */ boolean f8414Q;

    /* renamed from: R */
    public final /* synthetic */ zzm f8415R;

    /* renamed from: S */
    public final /* synthetic */ zzs f8416S;

    /* renamed from: T */
    public final /* synthetic */ g20 f8417T;

    public z20(g20 g20Var, String str, String str2, boolean z, zzm zzmVar, zzs zzsVar) {
        this.f8417T = g20Var;
        this.f8412O = str;
        this.f8413P = str2;
        this.f8414Q = z;
        this.f8415R = zzmVar;
        this.f8416S = zzsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        Bundle bundle = new Bundle();
        try {
            zzelVar = this.f8417T.f2805d;
            if (zzelVar == null) {
                this.f8417T.mo1484j().m8522H().m9085c("Failed to get user properties; not connected to service", this.f8412O, this.f8413P);
                return;
            }
            Bundle m3985E = g40.m3985E(zzelVar.mo1472Y(this.f8412O, this.f8413P, this.f8414Q, this.f8415R));
            this.f8417T.m3964e0();
            this.f8417T.m7588m().m4031Q(this.f8416S, m3985E);
        } catch (RemoteException e) {
            this.f8417T.mo1484j().m8522H().m9085c("Failed to get user properties; remote exception", this.f8412O, e);
        } finally {
            this.f8417T.m7588m().m4031Q(this.f8416S, bundle);
        }
    }
}
