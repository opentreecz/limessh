package cz.opentree;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class w20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f7600O;

    /* renamed from: P */
    public final /* synthetic */ String f7601P;

    /* renamed from: Q */
    public final /* synthetic */ String f7602Q;

    /* renamed from: R */
    public final /* synthetic */ String f7603R;

    /* renamed from: S */
    public final /* synthetic */ boolean f7604S;

    /* renamed from: T */
    public final /* synthetic */ zzm f7605T;

    /* renamed from: U */
    public final /* synthetic */ g20 f7606U;

    public w20(g20 g20Var, AtomicReference atomicReference, String str, String str2, String str3, boolean z, zzm zzmVar) {
        this.f7606U = g20Var;
        this.f7600O = atomicReference;
        this.f7601P = str;
        this.f7602Q = str2;
        this.f7603R = str3;
        this.f7604S = z;
        this.f7605T = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f7600O) {
            try {
                try {
                    zzelVar = this.f7606U.f2805d;
                } catch (RemoteException e) {
                    this.f7606U.mo1484j().m8522H().m9086d("(legacy) Failed to get user properties; remote exception", C1889sy.m8516y(this.f7601P), this.f7602Q, e);
                    this.f7600O.set(Collections.emptyList());
                }
                if (zzelVar == null) {
                    this.f7606U.mo1484j().m8522H().m9086d("(legacy) Failed to get user properties; not connected to service", C1889sy.m8516y(this.f7601P), this.f7602Q, this.f7603R);
                    this.f7600O.set(Collections.emptyList());
                    return;
                }
                if (TextUtils.isEmpty(this.f7601P)) {
                    this.f7600O.set(zzelVar.mo1472Y(this.f7602Q, this.f7603R, this.f7604S, this.f7605T));
                } else {
                    this.f7600O.set(zzelVar.mo1465G(this.f7601P, this.f7602Q, this.f7603R, this.f7604S));
                }
                this.f7606U.m3964e0();
                this.f7600O.notify();
            } finally {
                this.f7600O.notify();
            }
        }
    }
}
