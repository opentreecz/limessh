package com.sonelli;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzel;
import com.google.android.gms.measurement.internal.zzm;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m20 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f4957O;

    /* renamed from: P */
    public final /* synthetic */ zzm f4958P;

    /* renamed from: Q */
    public final /* synthetic */ g20 f4959Q;

    public m20(g20 g20Var, AtomicReference atomicReference, zzm zzmVar) {
        this.f4959Q = g20Var;
        this.f4957O = atomicReference;
        this.f4958P = zzmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzel zzelVar;
        synchronized (this.f4957O) {
            try {
                try {
                    zzelVar = this.f4959Q.f2805d;
                } catch (RemoteException e) {
                    this.f4959Q.mo1484j().m8522H().m9084b("Failed to get app instance id", e);
                }
                if (zzelVar == null) {
                    this.f4959Q.mo1484j().m8522H().m9083a("Failed to get app instance id");
                    return;
                }
                this.f4957O.set(zzelVar.mo1478v0(this.f4958P));
                String str = (String) this.f4957O.get();
                if (str != null) {
                    this.f4959Q.m10662q().m10005O(str);
                    this.f4959Q.m7589n().f2567l.m6013b(str);
                }
                this.f4959Q.m3964e0();
                this.f4957O.notify();
            } finally {
                this.f4957O.notify();
            }
        }
    }
}
