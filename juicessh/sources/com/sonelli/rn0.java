package com.sonelli;

import com.sonelli.zm0;
import java.io.IOException;
import java.net.ProtocolException;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpCodec;
import okio.BufferedSink;
import okio.Sink;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes.dex */
public final class rn0 implements Interceptor {

    /* renamed from: a */
    public final boolean f6265a;

    /* compiled from: CallServerInterceptor.java */
    /* renamed from: com.sonelli.rn0$a */
    /* loaded from: classes.dex */
    public static final class C1827a extends bp0 {

        /* renamed from: P */
        public long f6266P;

        public C1827a(Sink sink) {
            super(sink);
        }

        @Override // com.sonelli.bp0, okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            super.mo2189F(zo0Var, j);
            this.f6266P += j;
        }
    }

    public rn0(boolean z) {
        this.f6265a = z;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public zm0 mo4577a(Interceptor.Chain chain) throws IOException {
        zm0 m10520c;
        vn0 vn0Var = (vn0) chain;
        HttpCodec m9324i = vn0Var.m9324i();
        pn0 m9326k = vn0Var.m9326k();
        ln0 ln0Var = (ln0) vn0Var.m9322g();
        xm0 mo9320e = vn0Var.mo9320e();
        long currentTimeMillis = System.currentTimeMillis();
        vn0Var.m9323h().m10713o(vn0Var.m9321f());
        m9324i.mo2172b(mo9320e);
        vn0Var.m9323h().m10712n(vn0Var.m9321f(), mo9320e);
        zm0.C2434a c2434a = null;
        if (un0.m8962b(mo9320e.m9819f()) && mo9320e.m9814a() != null) {
            if ("100-continue".equalsIgnoreCase(mo9320e.m9816c("Expect"))) {
                m9324i.mo2175e();
                vn0Var.m9323h().m10717s(vn0Var.m9321f());
                c2434a = m9324i.mo2174d(true);
            }
            if (c2434a == null) {
                vn0Var.m9323h().m10711m(vn0Var.m9321f());
                C1827a c1827a = new C1827a(m9324i.mo2176f(mo9320e, mo9320e.m9814a().mo8770a()));
                BufferedSink m4227a = gp0.m4227a(c1827a);
                mo9320e.m9814a().mo8772g(m4227a);
                m4227a.close();
                vn0Var.m9323h().m10710l(vn0Var.m9321f(), c1827a.f6266P);
            } else if (!ln0Var.m6270n()) {
                m9326k.m7421j();
            }
        }
        m9324i.mo2171a();
        if (c2434a == null) {
            vn0Var.m9323h().m10717s(vn0Var.m9321f());
            c2434a = m9324i.mo2174d(false);
        }
        c2434a.m10533p(mo9320e);
        c2434a.m10525h(m9326k.m7415d().m6267k());
        c2434a.m10534q(currentTimeMillis);
        c2434a.m10532o(System.currentTimeMillis());
        zm0 m10520c2 = c2434a.m10520c();
        int m10508c = m10520c2.m10508c();
        if (m10508c == 100) {
            zm0.C2434a mo2174d = m9324i.mo2174d(false);
            mo2174d.m10533p(mo9320e);
            mo2174d.m10525h(m9326k.m7415d().m6267k());
            mo2174d.m10534q(currentTimeMillis);
            mo2174d.m10532o(System.currentTimeMillis());
            m10520c2 = mo2174d.m10520c();
            m10508c = m10520c2.m10508c();
        }
        vn0Var.m9323h().m10716r(vn0Var.m9321f(), m10520c2);
        if (this.f6265a && m10508c == 101) {
            zm0.C2434a m10513n = m10520c2.m10513n();
            m10513n.m10519b(fn0.f2724c);
            m10520c = m10513n.m10520c();
        } else {
            zm0.C2434a m10513n2 = m10520c2.m10513n();
            m10513n2.m10519b(m9324i.mo2173c(m10520c2));
            m10520c = m10513n2.m10520c();
        }
        if ("close".equalsIgnoreCase(m10520c.m10516y().m9816c("Connection")) || "close".equalsIgnoreCase(m10520c.m10510f("Connection"))) {
            m9326k.m7421j();
        }
        if ((m10508c != 204 && m10508c != 205) || m10520c.m10506a().mo2162b() <= 0) {
            return m10520c;
        }
        throw new ProtocolException("HTTP " + m10508c + " had non-zero Content-Length: " + m10520c.m10506a().mo2162b());
    }
}
