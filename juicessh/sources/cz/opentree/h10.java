package cz.opentree;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class h10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f3066O;

    /* renamed from: P */
    public final /* synthetic */ y00 f3067P;

    public h10(y00 y00Var, AtomicReference atomicReference) {
        this.f3067P = y00Var;
        this.f3066O = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f3066O) {
            try {
                this.f3066O.set(this.f3067P.m7590o().m2618L(this.f3067P.m10663r().m7571D()));
            } finally {
                this.f3066O.notify();
            }
        }
    }
}
