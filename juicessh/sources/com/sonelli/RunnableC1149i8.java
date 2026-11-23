package com.sonelli;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* renamed from: com.sonelli.i8 */
/* loaded from: classes.dex */
public final class RunnableC1149i8 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ C1200j8 f3272O;

    public RunnableC1149i8(C1200j8 c1200j8) {
        this.f3272O = c1200j8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        client = this.f3272O.f3513a.f6377b;
        client.disconnect();
    }
}
