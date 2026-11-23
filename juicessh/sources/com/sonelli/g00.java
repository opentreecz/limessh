package com.sonelli;

import com.google.android.gms.measurement.internal.zzy;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class g00 implements Callable<List<zzy>> {

    /* renamed from: a */
    public final /* synthetic */ String f2792a;

    /* renamed from: b */
    public final /* synthetic */ String f2793b;

    /* renamed from: c */
    public final /* synthetic */ String f2794c;

    /* renamed from: d */
    public final /* synthetic */ a00 f2795d;

    public g00(a00 a00Var, String str, String str2, String str3) {
        this.f2795d = a00Var;
        this.f2792a = str;
        this.f2793b = str2;
        this.f2794c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzy> call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f2795d.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f2795d.f1301a;
        return z30Var2.m10355U().m3024k0(this.f2792a, this.f2793b, this.f2794c);
    }
}
