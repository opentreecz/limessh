package cz.opentree;

import cz.opentree.in0;
import cz.opentree.qm0;
import cz.opentree.zm0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.InternalCache;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes.dex */
public final class hn0 implements Interceptor {

    /* renamed from: a */
    public final InternalCache f3180a;

    /* compiled from: CacheInterceptor.java */
    /* renamed from: cz.opentree.hn0$a */
    /* loaded from: classes.dex */
    public class C1117a implements Source {

        /* renamed from: O */
        public boolean f3181O;

        /* renamed from: P */
        public final /* synthetic */ BufferedSource f3182P;

        /* renamed from: Q */
        public final /* synthetic */ CacheRequest f3183Q;

        /* renamed from: R */
        public final /* synthetic */ BufferedSink f3184R;

        public C1117a(hn0 hn0Var, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
            this.f3182P = bufferedSource;
            this.f3183Q = cacheRequest;
            this.f3184R = bufferedSink;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            try {
                long mo2186R = this.f3182P.mo2186R(zo0Var, j);
                if (mo2186R != -1) {
                    zo0Var.m10563l(this.f3184R.mo4618e(), zo0Var.m10557f0() - mo2186R, mo2186R);
                    this.f3184R.mo4622v();
                    return mo2186R;
                }
                if (!this.f3181O) {
                    this.f3181O = true;
                    this.f3184R.close();
                }
                return -1L;
            } catch (IOException e) {
                if (!this.f3181O) {
                    this.f3181O = true;
                    this.f3183Q.m10721a();
                }
                throw e;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!this.f3181O && !fn0.m3835p(this, 100, TimeUnit.MILLISECONDS)) {
                this.f3181O = true;
                this.f3183Q.m10721a();
            }
            this.f3182P.close();
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return this.f3182P.mo2188g();
        }
    }

    public hn0(InternalCache internalCache) {
        this.f3180a = internalCache;
    }

    /* renamed from: c */
    public static qm0 m4573c(qm0 qm0Var, qm0 qm0Var2) {
        qm0.C1776a c1776a = new qm0.C1776a();
        int m7752h = qm0Var.m7752h();
        for (int i = 0; i < m7752h; i++) {
            String m7750e = qm0Var.m7750e(i);
            String m7753i = qm0Var.m7753i(i);
            if ((!"Warning".equalsIgnoreCase(m7750e) || !m7753i.startsWith("1")) && (m4574d(m7750e) || !m4575e(m7750e) || qm0Var2.m7749c(m7750e) == null)) {
                dn0.f2249a.mo3266b(c1776a, m7750e, m7753i);
            }
        }
        int m7752h2 = qm0Var2.m7752h();
        for (int i2 = 0; i2 < m7752h2; i2++) {
            String m7750e2 = qm0Var2.m7750e(i2);
            if (!m4574d(m7750e2) && m4575e(m7750e2)) {
                dn0.f2249a.mo3266b(c1776a, m7750e2, qm0Var2.m7753i(i2));
            }
        }
        return c1776a.m7758d();
    }

    /* renamed from: d */
    public static boolean m4574d(String str) {
        return "Content-Length".equalsIgnoreCase(str) || "Content-Encoding".equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }

    /* renamed from: e */
    public static boolean m4575e(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    /* renamed from: f */
    public static zm0 m4576f(zm0 zm0Var) {
        if (zm0Var == null || zm0Var.m10506a() == null) {
            return zm0Var;
        }
        zm0.C2434a m10513n = zm0Var.m10513n();
        m10513n.m10519b(null);
        return m10513n.m10520c();
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public zm0 mo4577a(Interceptor.Chain chain) throws IOException {
        InternalCache internalCache = this.f3180a;
        zm0 m10727e = internalCache != null ? internalCache.m10727e(chain.mo9320e()) : null;
        in0 m4818c = new in0.C1169a(System.currentTimeMillis(), chain.mo9320e(), m10727e).m4818c();
        xm0 xm0Var = m4818c.f3365a;
        zm0 zm0Var = m4818c.f3366b;
        InternalCache internalCache2 = this.f3180a;
        if (internalCache2 != null) {
            internalCache2.m10724b(m4818c);
        }
        if (m10727e != null && zm0Var == null) {
            fn0.m3826g(m10727e.m10506a());
        }
        if (xm0Var == null && zm0Var == null) {
            zm0.C2434a c2434a = new zm0.C2434a();
            c2434a.m10533p(chain.mo9320e());
            c2434a.m10531n(vm0.HTTP_1_1);
            c2434a.m10524g(504);
            c2434a.m10528k("Unsatisfiable Request (only-if-cached)");
            c2434a.m10519b(fn0.f2724c);
            c2434a.m10534q(-1L);
            c2434a.m10532o(System.currentTimeMillis());
            return c2434a.m10520c();
        }
        if (xm0Var == null) {
            zm0.C2434a m10513n = zm0Var.m10513n();
            m10513n.m10521d(m4576f(zm0Var));
            return m10513n.m10520c();
        }
        try {
            zm0 mo9318c = chain.mo9318c(xm0Var);
            if (mo9318c == null && m10727e != null) {
            }
            if (zm0Var != null) {
                if (mo9318c.m10508c() == 304) {
                    zm0.C2434a m10513n2 = zm0Var.m10513n();
                    m10513n2.m10527j(m4573c(zm0Var.m10512l(), mo9318c.m10512l()));
                    m10513n2.m10534q(mo9318c.m10517z());
                    m10513n2.m10532o(mo9318c.m10515x());
                    m10513n2.m10521d(m4576f(zm0Var));
                    m10513n2.m10529l(m4576f(mo9318c));
                    zm0 m10520c = m10513n2.m10520c();
                    mo9318c.m10506a().close();
                    this.f3180a.m10723a();
                    this.f3180a.m10728f(zm0Var, m10520c);
                    return m10520c;
                }
                fn0.m3826g(zm0Var.m10506a());
            }
            zm0.C2434a m10513n3 = mo9318c.m10513n();
            m10513n3.m10521d(m4576f(zm0Var));
            m10513n3.m10529l(m4576f(mo9318c));
            zm0 m10520c2 = m10513n3.m10520c();
            if (this.f3180a != null) {
                if (tn0.m8784c(m10520c2) && in0.m4814a(m10520c2, xm0Var)) {
                    return m4578b(this.f3180a.m10726d(m10520c2), m10520c2);
                }
                if (un0.m8961a(xm0Var.m9819f())) {
                    try {
                        this.f3180a.m10725c(xm0Var);
                    } catch (IOException unused) {
                    }
                }
            }
            return m10520c2;
        } finally {
            if (m10727e != null) {
                fn0.m3826g(m10727e.m10506a());
            }
        }
    }

    /* renamed from: b */
    public final zm0 m4578b(CacheRequest cacheRequest, zm0 zm0Var) throws IOException {
        Sink m10722b;
        if (cacheRequest == null || (m10722b = cacheRequest.m10722b()) == null) {
            return zm0Var;
        }
        C1117a c1117a = new C1117a(this, zm0Var.m10506a().mo2164h(), cacheRequest, gp0.m4227a(m10722b));
        String m10510f = zm0Var.m10510f("Content-Type");
        long mo2162b = zm0Var.m10506a().mo2162b();
        zm0.C2434a m10513n = zm0Var.m10513n();
        m10513n.m10519b(new wn0(m10510f, mo2162b, gp0.m4228b(c1117a)));
        return m10513n.m10520c();
    }
}
