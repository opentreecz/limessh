package cz.opentree;

import com.google.android.gms.analytics.zzn;
import java.util.Iterator;
import java.util.List;

/* renamed from: cz.opentree.l4 */
/* loaded from: classes.dex */
public final class RunnableC1489l4 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ C1093h4 f4738O;

    /* renamed from: P */
    public final /* synthetic */ C1434k4 f4739P;

    public RunnableC1489l4(C1434k4 c1434k4, C1093h4 c1093h4) {
        this.f4739P = c1434k4;
        this.f4738O = c1093h4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List list;
        this.f4738O.m4360k().mo2663a(this.f4738O);
        list = this.f4739P.f4470b;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzn) it.next()).m834a(this.f4738O);
        }
        C1434k4 c1434k4 = this.f4739P;
        C1434k4.m5826l(this.f4738O);
    }
}
