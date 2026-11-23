package com.sonelli;

import com.sonelli.qm0;
import com.sonelli.xm0;
import com.sonelli.zm0;
import java.io.IOException;
import java.util.List;
import okhttp3.CookieJar;
import okhttp3.Interceptor;

/* compiled from: BridgeInterceptor.java */
/* loaded from: classes.dex */
public final class qn0 implements Interceptor {

    /* renamed from: a */
    public final CookieJar f6058a;

    public qn0(CookieJar cookieJar) {
        this.f6058a = cookieJar;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public zm0 mo4577a(Interceptor.Chain chain) throws IOException {
        xm0 mo9320e = chain.mo9320e();
        xm0.C2302a m9820g = mo9320e.m9820g();
        ym0 m9814a = mo9320e.m9814a();
        if (m9814a != null) {
            sm0 mo8771b = m9814a.mo8771b();
            if (mo8771b != null) {
                m9820g.m9824c("Content-Type", mo8771b.toString());
            }
            long mo8770a = m9814a.mo8770a();
            if (mo8770a != -1) {
                m9820g.m9824c("Content-Length", Long.toString(mo8770a));
                m9820g.m9827f("Transfer-Encoding");
            } else {
                m9820g.m9824c("Transfer-Encoding", "chunked");
                m9820g.m9827f("Content-Length");
            }
        }
        boolean z = false;
        if (mo9320e.m9816c("Host") == null) {
            m9820g.m9824c("Host", fn0.m3838s(mo9320e.m9821h(), false));
        }
        if (mo9320e.m9816c("Connection") == null) {
            m9820g.m9824c("Connection", "Keep-Alive");
        }
        if (mo9320e.m9816c("Accept-Encoding") == null && mo9320e.m9816c("Range") == null) {
            z = true;
            m9820g.m9824c("Accept-Encoding", "gzip");
        }
        List<nm0> mo10697b = this.f6058a.mo10697b(mo9320e.m9821h());
        if (!mo10697b.isEmpty()) {
            m9820g.m9824c("Cookie", m7761b(mo10697b));
        }
        if (mo9320e.m9816c("User-Agent") == null) {
            m9820g.m9824c("User-Agent", gn0.m4180a());
        }
        zm0 mo9318c = chain.mo9318c(m9820g.m9822a());
        tn0.m8786e(this.f6058a, mo9320e.m9821h(), mo9318c.m10512l());
        zm0.C2434a m10513n = mo9318c.m10513n();
        m10513n.m10533p(mo9320e);
        if (z && "gzip".equalsIgnoreCase(mo9318c.m10510f("Content-Encoding")) && tn0.m8784c(mo9318c)) {
            ep0 ep0Var = new ep0(mo9318c.m10506a().mo2164h());
            qm0.C1776a m7751f = mo9318c.m10512l().m7751f();
            m7751f.m7759e("Content-Encoding");
            m7751f.m7759e("Content-Length");
            m10513n.m10527j(m7751f.m7758d());
            m10513n.m10519b(new wn0(mo9318c.m10510f("Content-Type"), -1L, gp0.m4228b(ep0Var)));
        }
        return m10513n.m10520c();
    }

    /* renamed from: b */
    public final String m7761b(List<nm0> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append("; ");
            }
            nm0 nm0Var = list.get(i);
            sb.append(nm0Var.m6748c());
            sb.append('=');
            sb.append(nm0Var.m6750k());
        }
        return sb.toString();
    }
}
