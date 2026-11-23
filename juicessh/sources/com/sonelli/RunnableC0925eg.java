package com.sonelli;

import android.content.ComponentName;

/* renamed from: com.sonelli.eg */
/* loaded from: classes.dex */
public final class RunnableC0925eg implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ ComponentName f2382O;

    /* renamed from: P */
    public final /* synthetic */ ServiceConnectionC0821cg f2383P;

    public RunnableC0925eg(ServiceConnectionC0821cg serviceConnectionC0821cg, ComponentName componentName) {
        this.f2383P = serviceConnectionC0821cg;
        this.f2382O = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f2383P.f1931c.m2057J0(this.f2382O);
    }
}
