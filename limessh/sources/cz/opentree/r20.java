package cz.opentree;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class r20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ boolean f6158O;

    /* renamed from: P */
    public final /* synthetic */ boolean f6159P;

    /* renamed from: Q */
    public final /* synthetic */ zzaq f6160Q;

    /* renamed from: R */
    public final /* synthetic */ zzm f6161R;

    /* renamed from: S */
    public final /* synthetic */ String f6162S;

    /* renamed from: T */
    public final /* synthetic */ g20 f6163T;

    public r20(g20 g20Var, boolean z, boolean z2, zzaq zzaqVar, zzm zzmVar, String str) {
        this.f6163T = g20Var;
        this.f6158O = z;
        this.f6159P = z2;
        this.f6160Q = zzaqVar;
        this.f6161R = zzmVar;
        this.f6162S = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        zzelVar = this.f6163T.f2805d;
        if (zzelVar == null) {
            this.f6163T.mo1484j().m8522H().m9083a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f6158O) {
            this.f6163T.m3947M(zzelVar, this.f6159P ? null : this.f6160Q, this.f6161R);
        } else {
            try {
                if (TextUtils.isEmpty(this.f6162S)) {
                    zzelVar.mo1468L0(this.f6160Q, this.f6161R);
                } else {
                    zzelVar.mo1464F(this.f6160Q, this.f6162S, this.f6163T.mo1484j().m8531Q());
                }
            } catch (RemoteException e) {
                this.f6163T.mo1484j().m8522H().m9084b("Failed to send event to the service", e);
            }
        }
        this.f6163T.m3964e0();
    }
}
