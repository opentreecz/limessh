package com.sonelli;

import com.sonelli.qm0;
import com.sonelli.zm0;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http2.Header;
import okio.Sink;
import okio.Source;

/* compiled from: Http2Codec.java */
/* loaded from: classes.dex */
public final class fo0 implements HttpCodec {

    /* renamed from: f */
    public static final List<String> f2742f = fn0.m3840u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");

    /* renamed from: g */
    public static final List<String> f2743g = fn0.m3840u("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a */
    public final Interceptor.Chain f2744a;

    /* renamed from: b */
    public final pn0 f2745b;

    /* renamed from: c */
    public final go0 f2746c;

    /* renamed from: d */
    public ho0 f2747d;

    /* renamed from: e */
    public final vm0 f2748e;

    /* compiled from: Http2Codec.java */
    /* renamed from: com.sonelli.fo0$a */
    /* loaded from: classes.dex */
    public class C1006a extends cp0 {

        /* renamed from: P */
        public boolean f2749P;

        /* renamed from: Q */
        public long f2750Q;

        public C1006a(Source source) {
            super(source);
            this.f2749P = false;
            this.f2750Q = 0L;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            try {
                long mo2186R = m2901a().mo2186R(zo0Var, j);
                if (mo2186R > 0) {
                    this.f2750Q += mo2186R;
                }
                return mo2186R;
            } catch (IOException e) {
                m3850b(e);
                throw e;
            }
        }

        /* renamed from: b */
        public final void m3850b(IOException iOException) {
            if (this.f2749P) {
                return;
            }
            this.f2749P = true;
            fo0 fo0Var = fo0.this;
            fo0Var.f2745b.m7429r(false, fo0Var, this.f2750Q, iOException);
        }

        @Override // com.sonelli.cp0, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            m3850b(null);
        }
    }

    public fo0(um0 um0Var, Interceptor.Chain chain, pn0 pn0Var, go0 go0Var) {
        this.f2744a = chain;
        this.f2745b = pn0Var;
        this.f2746c = go0Var;
        List<vm0> m8931A = um0Var.m8931A();
        vm0 vm0Var = vm0.H2_PRIOR_KNOWLEDGE;
        this.f2748e = m8931A.contains(vm0Var) ? vm0Var : vm0.HTTP_2;
    }

    /* renamed from: g */
    public static List<Header> m3848g(xm0 xm0Var) {
        qm0 m9817d = xm0Var.m9817d();
        ArrayList arrayList = new ArrayList(m9817d.m7752h() + 4);
        arrayList.add(new Header(Header.f8658f, xm0Var.m9819f()));
        arrayList.add(new Header(Header.f8659g, xn0.m9851c(xm0Var.m9821h())));
        String m9816c = xm0Var.m9816c("Host");
        if (m9816c != null) {
            arrayList.add(new Header(Header.f8661i, m9816c));
        }
        arrayList.add(new Header(Header.f8660h, xm0Var.m9821h().m8163C()));
        int m7752h = m9817d.m7752h();
        for (int i = 0; i < m7752h; i++) {
            ap0 m2233o = ap0.m2233o(m9817d.m7750e(i).toLowerCase(Locale.US));
            if (!f2742f.contains(m2233o.mo2236B())) {
                arrayList.add(new Header(m2233o, m9817d.m7753i(i)));
            }
        }
        return arrayList;
    }

    /* renamed from: h */
    public static zm0.C2434a m3849h(qm0 qm0Var, vm0 vm0Var) throws IOException {
        qm0.C1776a c1776a = new qm0.C1776a();
        int m7752h = qm0Var.m7752h();
        zn0 zn0Var = null;
        for (int i = 0; i < m7752h; i++) {
            String m7750e = qm0Var.m7750e(i);
            String m7753i = qm0Var.m7753i(i);
            if (m7750e.equals(":status")) {
                zn0Var = zn0.m10545a("HTTP/1.1 " + m7753i);
            } else if (!f2743g.contains(m7750e)) {
                dn0.f2249a.mo3266b(c1776a, m7750e, m7753i);
            }
        }
        if (zn0Var == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        zm0.C2434a c2434a = new zm0.C2434a();
        c2434a.m10531n(vm0Var);
        c2434a.m10524g(zn0Var.f8568b);
        c2434a.m10528k(zn0Var.f8569c);
        c2434a.m10527j(c1776a.m7758d());
        return c2434a;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: a */
    public void mo2171a() throws IOException {
        this.f2747d.m4592j().close();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: b */
    public void mo2172b(xm0 xm0Var) throws IOException {
        if (this.f2747d != null) {
            return;
        }
        ho0 m4206y = this.f2746c.m4206y(m3848g(xm0Var), xm0Var.m9814a() != null);
        this.f2747d = m4206y;
        mp0 m4596n = m4206y.m4596n();
        long mo9316a = this.f2744a.mo9316a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        m4596n.mo3310g(mo9316a, timeUnit);
        this.f2747d.m4603u().mo3310g(this.f2744a.mo9317b(), timeUnit);
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: c */
    public an0 mo2173c(zm0 zm0Var) throws IOException {
        pn0 pn0Var = this.f2745b;
        pn0Var.f5732f.m10715q(pn0Var.f5731e);
        return new wn0(zm0Var.m10510f("Content-Type"), tn0.m8783b(zm0Var), gp0.m4228b(new C1006a(this.f2747d.m4593k())));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        ho0 ho0Var = this.f2747d;
        if (ho0Var != null) {
            ho0Var.m4590h(co0.CANCEL);
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: d */
    public zm0.C2434a mo2174d(boolean z) throws IOException {
        zm0.C2434a m3849h = m3849h(this.f2747d.m4601s(), this.f2748e);
        if (z && dn0.f2249a.mo3268d(m3849h) == 100) {
            return null;
        }
        return m3849h;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: e */
    public void mo2175e() throws IOException {
        this.f2746c.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: f */
    public Sink mo2176f(xm0 xm0Var, long j) {
        return this.f2747d.m4592j();
    }
}
