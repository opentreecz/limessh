package com.sonelli;

import com.google.android.gms.internal.gtm.zzce;

/* renamed from: com.sonelli.dg */
/* loaded from: classes.dex */
public final class RunnableC0873dg implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzce f2162O;

    /* renamed from: P */
    public final /* synthetic */ ServiceConnectionC0821cg f2163P;

    public RunnableC0873dg(ServiceConnectionC0821cg serviceConnectionC0821cg, zzce zzceVar) {
        this.f2163P = serviceConnectionC0821cg;
        this.f2162O = zzceVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f2163P.f1931c.m2056I0()) {
            return;
        }
        this.f2163P.f1931c.m8678y0("Connected to service after a timeout");
        this.f2163P.f1931c.m2058N0(this.f2162O);
    }
}
