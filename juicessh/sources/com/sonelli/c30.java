package com.sonelli;

import android.content.ComponentName;
import android.content.Context;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class c30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ y20 f1868O;

    public c30(y20 y20Var) {
        this.f1868O = y20Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        g20 g20Var = this.f1868O.f8116c;
        Context mo1482h = this.f1868O.f8116c.mo1482h();
        this.f1868O.f8116c.mo1480f();
        g20Var.m3940F(new ComponentName(mo1482h, "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
