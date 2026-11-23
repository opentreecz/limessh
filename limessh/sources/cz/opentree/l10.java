package cz.opentree;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l10 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AtomicReference f4714O;

    /* renamed from: P */
    public final /* synthetic */ y00 f4715P;

    public l10(y00 y00Var, AtomicReference atomicReference) {
        this.f4715P = y00Var;
        this.f4714O = atomicReference;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.f4714O) {
            try {
                this.f4714O.set(Integer.valueOf(this.f4715P.m7590o().m2632w(this.f4715P.m10663r().m7571D(), C1735pu.f5806O)));
            } finally {
                this.f4714O.notify();
            }
        }
    }
}
