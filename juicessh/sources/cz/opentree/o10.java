package cz.opentree;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class o10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f5403O;

    /* renamed from: P */
    public final /* synthetic */ y00 f5404P;

    public o10(y00 y00Var, AtomicReference atomicReference) {
        this.f5404P = y00Var;
        this.f5403O = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f5403O) {
            try {
                this.f5403O.set(Double.valueOf(this.f5404P.m7590o().m2633x(this.f5404P.m10663r().m7571D(), C1735pu.f5808P)));
            } finally {
                this.f5403O.notify();
            }
        }
    }
}
