package cz.opentree;

import java.io.IOException;
import okhttp3.Interceptor;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes.dex */
public final class jn0 implements Interceptor {

    /* renamed from: a */
    public final um0 f3630a;

    public jn0(um0 um0Var) {
        this.f3630a = um0Var;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public zm0 mo4577a(Interceptor.Chain chain) throws IOException {
        vn0 vn0Var = (vn0) chain;
        xm0 mo9320e = vn0Var.mo9320e();
        pn0 m9326k = vn0Var.m9326k();
        return vn0Var.m9325j(mo9320e, m9326k, m9326k.m7420i(this.f3630a, chain, !mo9320e.m9819f().equals("GET")), m9326k.m7415d());
    }
}
