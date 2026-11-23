package com.sonelli;

import android.content.ComponentName;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a30 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ ComponentName f1326O;

    /* renamed from: P */
    public final /* synthetic */ y20 f1327P;

    public a30(y20 y20Var, ComponentName componentName) {
        this.f1327P = y20Var;
        this.f1326O = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f1327P.f8116c.m3940F(this.f1326O);
    }
}
