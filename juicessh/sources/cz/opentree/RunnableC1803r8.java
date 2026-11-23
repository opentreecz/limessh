package cz.opentree;

import com.google.android.gms.signin.internal.zak;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: cz.opentree.r8 */
/* loaded from: classes.dex */
public final class RunnableC1803r8 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zak f6189O;

    /* renamed from: P */
    public final /* synthetic */ BinderC1751q8 f6190P;

    public RunnableC1803r8(BinderC1751q8 binderC1751q8, zak zakVar) {
        this.f6190P = binderC1751q8;
        this.f6189O = zakVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6190P.m7635T0(this.f6189O);
    }
}
