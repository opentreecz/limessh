package cz.opentree;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class v20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ boolean f7390O;

    /* renamed from: P */
    public final /* synthetic */ boolean f7391P;

    /* renamed from: Q */
    public final /* synthetic */ zzy f7392Q;

    /* renamed from: R */
    public final /* synthetic */ zzm f7393R;

    /* renamed from: S */
    public final /* synthetic */ zzy f7394S;

    /* renamed from: T */
    public final /* synthetic */ g20 f7395T;

    public v20(g20 g20Var, boolean z, boolean z2, zzy zzyVar, zzm zzmVar, zzy zzyVar2) {
        this.f7395T = g20Var;
        this.f7390O = z;
        this.f7391P = z2;
        this.f7392Q = zzyVar;
        this.f7393R = zzmVar;
        this.f7394S = zzyVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f7395T.f2805d;
        if (zzelVar == null) {
            this.f7395T.mo1484j().m8522H().m9083a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f7390O) {
            this.f7395T.m3947M(zzelVar, this.f7391P ? null : this.f7392Q, this.f7393R);
        } else {
            try {
                if (TextUtils.isEmpty(this.f7394S.f1019O)) {
                    zzelVar.mo1467H(this.f7392Q, this.f7393R);
                } else {
                    zzelVar.mo1471X(this.f7392Q);
                }
            } catch (RemoteException e) {
                this.f7395T.mo1484j().m8522H().m9084b("Failed to send conditional user property to the service", e);
            }
        }
        this.f7395T.m3964e0();
    }
}
