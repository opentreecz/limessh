package com.sonelli;

import com.google.android.gms.measurement.internal.zzm;
import com.google.android.gms.measurement.internal.zzy;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class d00 implements Callable<List<zzy>> {

    /* renamed from: a */
    public final /* synthetic */ zzm f2094a;

    /* renamed from: b */
    public final /* synthetic */ String f2095b;

    /* renamed from: c */
    public final /* synthetic */ String f2096c;

    /* renamed from: d */
    public final /* synthetic */ a00 f2097d;

    public d00(a00 a00Var, zzm zzmVar, String str, String str2) {
        this.f2097d = a00Var;
        this.f2094a = zzmVar;
        this.f2095b = str;
        this.f2096c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f2097d.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f2097d.f1301a;
        return z30Var2.m10355U().m3024k0(this.f2094a.f997O, this.f2095b, this.f2096c);
    }
}
