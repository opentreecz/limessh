package com.sonelli;

import com.google.android.gms.analytics.zzh;
import com.google.android.gms.common.util.Clock;
import com.sonelli.C1195j4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.sonelli.j4 */
/* loaded from: classes.dex */
public class C1195j4<T extends C1195j4> {

    /* renamed from: a */
    public final C1434k4 f3486a;

    /* renamed from: b */
    public final C1093h4 f3487b;

    /* renamed from: c */
    public final List<zzh> f3488c;

    public C1195j4(C1434k4 c1434k4, Clock clock) {
        C0813ca.m2729k(c1434k4);
        this.f3486a = c1434k4;
        this.f3488c = new ArrayList();
        C1093h4 c1093h4 = new C1093h4(this, clock);
        c1093h4.m4362m();
        this.f3487b = c1093h4;
    }

    /* renamed from: a */
    public void mo2663a(C1093h4 c1093h4) {
        throw null;
    }

    /* renamed from: b */
    public C1093h4 mo2664b() {
        throw null;
    }

    /* renamed from: c */
    public final C1434k4 m5050c() {
        return this.f3486a;
    }

    /* renamed from: d */
    public final void m5051d(C1093h4 c1093h4) {
        Iterator<zzh> it = this.f3488c.iterator();
        while (it.hasNext()) {
            it.next().m833a(this, c1093h4);
        }
    }
}
