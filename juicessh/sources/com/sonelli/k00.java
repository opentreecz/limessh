package com.sonelli;

import com.google.android.gms.measurement.internal.zzaq;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class k00 implements Callable<byte[]> {

    /* renamed from: a */
    public final /* synthetic */ zzaq f4418a;

    /* renamed from: b */
    public final /* synthetic */ String f4419b;

    /* renamed from: c */
    public final /* synthetic */ a00 f4420c;

    public k00(a00 a00Var, zzaq zzaqVar, String str) {
        this.f4420c = a00Var;
        this.f4418a = zzaqVar;
        this.f4419b = str;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f4420c.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f4420c.f1301a;
        z30Var2.m10358X().m10321w(this.f4418a, this.f4419b);
        throw null;
    }
}
