package cz.opentree;

import com.google.android.gms.measurement.internal.zzy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class c00 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ zzy f1854O;

    /* renamed from: P */
    public final /* synthetic */ a00 f1855P;

    public c00(a00 a00Var, zzy zzyVar) {
        this.f1855P = a00Var;
        this.f1854O = zzyVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z30 z30Var;
        z30 z30Var2;
        z30 z30Var3;
        z30Var = this.f1855P.f1301a;
        z30Var.m10367d0();
        if (this.f1854O.f1021Q.m1501x() == null) {
            z30Var3 = this.f1855P.f1301a;
            z30Var3.m10349O(this.f1854O);
        } else {
            z30Var2 = this.f1855P.f1301a;
            z30Var2.m10386x(this.f1854O);
        }
    }
}
