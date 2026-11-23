package cz.opentree;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.zacf;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.p8 */
/* loaded from: classes.dex */
public final class RunnableC1693p8 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ BinderC1751q8 f5634O;

    public RunnableC1693p8(BinderC1751q8 binderC1751q8) {
        this.f5634O = binderC1751q8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacf zacfVar;
        zacfVar = this.f5634O.f5958g;
        zacfVar.mo1022c(new ConnectionResult(4));
    }
}
