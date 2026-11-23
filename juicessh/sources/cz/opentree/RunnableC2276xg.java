package cz.opentree;

import android.os.Looper;

/* renamed from: cz.opentree.xg */
/* loaded from: classes.dex */
public final class RunnableC2276xg implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ AbstractC2217wg f7924O;

    public RunnableC2276xg(AbstractC2217wg abstractC2217wg) {
        this.f7924O = abstractC2217wg;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C2216wf c2216wf;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c2216wf = this.f7924O.f7689a;
            c2216wf.m9479g().m5829e(this);
            return;
        }
        boolean m9500g = this.f7924O.m9500g();
        AbstractC2217wg.m9495d(this.f7924O, 0L);
        if (m9500g) {
            this.f7924O.mo2457c();
        }
    }
}
