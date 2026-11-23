package com.sonelli;

import com.google.android.gms.measurement.internal.zzm;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class m00 implements Callable<List<h40>> {

    /* renamed from: a */
    public final /* synthetic */ zzm f4946a;

    /* renamed from: b */
    public final /* synthetic */ a00 f4947b;

    public m00(a00 a00Var, zzm zzmVar) {
        this.f4947b = a00Var;
        this.f4946a = zzmVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<h40> call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f4947b.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f4947b.f1301a;
        return z30Var2.m10355U().m3005I(this.f4946a.f997O);
    }
}
