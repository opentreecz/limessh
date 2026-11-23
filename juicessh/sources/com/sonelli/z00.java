package com.sonelli;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class z00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f8387O;

    /* renamed from: P */
    public final /* synthetic */ y00 f8388P;

    public z00(y00 y00Var, AtomicReference atomicReference) {
        this.f8388P = y00Var;
        this.f8387O = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f8387O) {
            try {
                this.f8387O.set(Boolean.valueOf(this.f8388P.m7590o().m2616J(this.f8388P.m10663r().m7571D())));
            } finally {
                this.f8387O.notify();
            }
        }
    }
}
