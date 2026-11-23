package com.sonelli;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class m10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f4950O;

    /* renamed from: P */
    public final /* synthetic */ y00 f4951P;

    public m10(y00 y00Var, AtomicReference atomicReference) {
        this.f4951P = y00Var;
        this.f4950O = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4950O) {
            try {
                this.f4950O.set(Long.valueOf(this.f4951P.m7590o().m2627r(this.f4951P.m10663r().m7571D(), C1735pu.f5804N)));
            } finally {
                this.f4950O.notify();
            }
        }
    }
}
