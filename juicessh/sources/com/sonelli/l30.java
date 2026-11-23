package com.sonelli;

import android.os.Handler;
import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class l30 {

    /* renamed from: a */
    public o30 f4728a;

    /* renamed from: b */
    public final /* synthetic */ k30 f4729b;

    public l30(k30 k30Var) {
        this.f4729b = k30Var;
    }

    @WorkerThread
    /* renamed from: a */
    public final void m6048a() {
        Handler handler;
        this.f4729b.mo7585d();
        if (this.f4729b.m7590o().m2630u(C1735pu.f5858r0) && this.f4728a != null) {
            handler = this.f4729b.f4449c;
            handler.removeCallbacks(this.f4728a);
        }
        if (this.f4729b.m7590o().m2630u(C1735pu.f5789F0)) {
            this.f4729b.m7589n().f2579x.m4291a(false);
        }
    }

    @WorkerThread
    /* renamed from: b */
    public final void m6049b(long j) {
        Handler handler;
        if (this.f4729b.m7590o().m2630u(C1735pu.f5858r0)) {
            this.f4728a = new o30(this, this.f4729b.mo1483i().mo1177a(), j);
            handler = this.f4729b.f4449c;
            handler.postDelayed(this.f4728a, 2000L);
        }
    }
}
