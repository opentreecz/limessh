package cz.opentree;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class e00 implements Callable<List<h40>> {

    /* renamed from: a */
    public final /* synthetic */ String f2312a;

    /* renamed from: b */
    public final /* synthetic */ String f2313b;

    /* renamed from: c */
    public final /* synthetic */ String f2314c;

    /* renamed from: d */
    public final /* synthetic */ a00 f2315d;

    public e00(a00 a00Var, String str, String str2, String str3) {
        this.f2315d = a00Var;
        this.f2312a = str;
        this.f2313b = str2;
        this.f2314c = str3;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<h40> call() throws Exception {
        z30 z30Var;
        z30 z30Var2;
        z30Var = this.f2315d.f1301a;
        z30Var.m10367d0();
        z30Var2 = this.f2315d.f1301a;
        return z30Var2.m10355U().m3007K(this.f2312a, this.f2313b, this.f2314c);
    }
}
