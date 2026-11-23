package cz.opentree;

import java.util.List;

/* loaded from: classes.dex */
public final class m50 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ List f4987O;

    /* renamed from: P */
    public final /* synthetic */ long f4988P;

    /* renamed from: Q */
    public final /* synthetic */ l50 f4989Q;

    public m50(l50 l50Var, List list, long j) {
        this.f4989Q = l50Var;
        this.f4987O = list;
        this.f4988P = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4989Q.m6076h(this.f4987O, this.f4988P);
    }
}
