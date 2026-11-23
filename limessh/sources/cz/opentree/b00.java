package cz.opentree;

import com.google.android.gms.measurement.internal.zzm;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class b00 implements Callable<List<h40>> {

    /* renamed from: a */
    public final /* synthetic */ zzm f1558a;

    /* renamed from: b */
    public final /* synthetic */ String f1559b;

    /* renamed from: c */
    public final /* synthetic */ String f1560c;

    /* renamed from: d */
    public final /* synthetic */ a00 f1561d;

    public b00(a00 a00Var, zzm zzmVar, String str, String str2) {
        this.f1561d = a00Var;
        this.f1558a = zzmVar;
        this.f1559b = str;
        this.f1560c = str2;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<h40> call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f1561d.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f1561d.f1301a;
        return z30Var2.m10355U().m3007K(this.f1558a.f997O, this.f1559b, this.f1560c);
    }
}
