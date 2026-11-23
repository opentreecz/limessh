package cz.opentree;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class u20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f6905O;

    /* renamed from: P */
    public final /* synthetic */ String f6906P;

    /* renamed from: Q */
    public final /* synthetic */ String f6907Q;

    /* renamed from: R */
    public final /* synthetic */ String f6908R;

    /* renamed from: S */
    public final /* synthetic */ zzm f6909S;

    /* renamed from: T */
    public final /* synthetic */ g20 f6910T;

    public u20(g20 g20Var, AtomicReference atomicReference, String str, String str2, String str3, zzm zzmVar) {
        this.f6910T = g20Var;
        this.f6905O = atomicReference;
        this.f6906P = str;
        this.f6907Q = str2;
        this.f6908R = str3;
        this.f6909S = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f6905O) {
            try {
                try {
                    zzelVar = this.f6910T.f2805d;
                } catch (RemoteException e) {
                    this.f6910T.mo1484j().m8522H().m9086d("(legacy) Failed to get conditional properties; remote exception", C1889sy.m8516y(this.f6906P), this.f6907Q, e);
                    this.f6905O.set(Collections.emptyList());
                }
                if (zzelVar == null) {
                    this.f6910T.mo1484j().m8522H().m9086d("(legacy) Failed to get conditional properties; not connected to service", C1889sy.m8516y(this.f6906P), this.f6907Q, this.f6908R);
                    this.f6905O.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f6906P)) {
                    this.f6905O.set(zzelVar.mo1470R(this.f6907Q, this.f6908R, this.f6909S));
                } else {
                    this.f6905O.set(zzelVar.mo1474c0(this.f6906P, this.f6907Q, this.f6908R));
                }
                this.f6910T.m3964e0();
                this.f6905O.notify();
            } finally {
                this.f6905O.notify();
            }
        }
    }
}
