package cz.opentree;

import com.google.android.gms.measurement.internal.zzgu;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.gu */
/* loaded from: classes.dex */
public final class RunnableC1072gu implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzgu f2983O;

    /* renamed from: P */
    public final /* synthetic */ AbstractC1127hu f2984P;

    public RunnableC1072gu(AbstractC1127hu abstractC1127hu, zzgu zzguVar) {
        this.f2984P = abstractC1127hu;
        this.f2983O = zzguVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2983O.mo1480f();
        if (t40.m8593a()) {
            this.f2983O.mo1481g().m8281A(this);
            return;
        }
        boolean m4650d = this.f2984P.m4650d();
        AbstractC1127hu.m4647a(this.f2984P, 0L);
        if (m4650d) {
            this.f2984P.mo4648b();
        }
    }
}
