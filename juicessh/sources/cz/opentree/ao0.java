package cz.opentree;

import android.support.v4.media.session.PlaybackStateCompat;
import cz.opentree.qm0;
import cz.opentree.zm0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http.HttpCodec;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

/* compiled from: Http1Codec.java */
/* loaded from: classes.dex */
public final class ao0 implements HttpCodec {

    /* renamed from: a */
    public final um0 f1460a;

    /* renamed from: b */
    public final pn0 f1461b;

    /* renamed from: c */
    public final BufferedSource f1462c;

    /* renamed from: d */
    public final BufferedSink f1463d;

    /* renamed from: e */
    public int f1464e = 0;

    /* renamed from: f */
    public long f1465f = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$b */
    /* loaded from: classes.dex */
    public abstract class AbstractC0726b implements Source {

        /* renamed from: O */
        public final dp0 f1466O;

        /* renamed from: P */
        public boolean f1467P;

        /* renamed from: Q */
        public long f1468Q;

        public AbstractC0726b() {
            this.f1466O = new dp0(ao0.this.f1462c.mo2188g());
            this.f1468Q = 0L;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            try {
                long mo2186R = ao0.this.f1462c.mo2186R(zo0Var, j);
                if (mo2186R > 0) {
                    this.f1468Q += mo2186R;
                }
                return mo2186R;
            } catch (IOException e) {
                m2187a(false, e);
                throw e;
            }
        }

        /* renamed from: a */
        public final void m2187a(boolean z, IOException iOException) throws IOException {
            ao0 ao0Var = ao0.this;
            int i = ao0Var.f1464e;
            if (i == 6) {
                return;
            }
            if (i != 5) {
                throw new IllegalStateException("state: " + ao0.this.f1464e);
            }
            ao0Var.m2177g(this.f1466O);
            ao0 ao0Var2 = ao0.this;
            ao0Var2.f1464e = 6;
            pn0 pn0Var = ao0Var2.f1461b;
            if (pn0Var != null) {
                pn0Var.m7429r(!z, ao0Var2, this.f1468Q, iOException);
            }
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return this.f1466O;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$c */
    /* loaded from: classes.dex */
    public final class C0727c implements Sink {

        /* renamed from: O */
        public final dp0 f1470O;

        /* renamed from: P */
        public boolean f1471P;

        public C0727c() {
            this.f1470O = new dp0(ao0.this.f1463d.mo2190g());
        }

        @Override // okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            if (this.f1471P) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            ao0.this.f1463d.mo4614H(j);
            ao0.this.f1463d.mo4611A("\r\n");
            ao0.this.f1463d.mo2189F(zo0Var, j);
            ao0.this.f1463d.mo4611A("\r\n");
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.f1471P) {
                return;
            }
            this.f1471P = true;
            ao0.this.f1463d.mo4611A("0\r\n\r\n");
            ao0.this.m2177g(this.f1470O);
            ao0.this.f1464e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.f1471P) {
                return;
            }
            ao0.this.f1463d.flush();
        }

        @Override // okio.Sink
        /* renamed from: g */
        public mp0 mo2190g() {
            return this.f1470O;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$d */
    /* loaded from: classes.dex */
    public class C0728d extends AbstractC0726b {

        /* renamed from: S */
        public final rm0 f1473S;

        /* renamed from: T */
        public long f1474T;

        /* renamed from: U */
        public boolean f1475U;

        public C0728d(rm0 rm0Var) {
            super();
            this.f1474T = -1L;
            this.f1475U = true;
            this.f1473S = rm0Var;
        }

        @Override // cz.opentree.ao0.AbstractC0726b, okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f1467P) {
                throw new IllegalStateException("closed");
            }
            if (!this.f1475U) {
                return -1L;
            }
            long j2 = this.f1474T;
            if (j2 == 0 || j2 == -1) {
                m2191b();
                if (!this.f1475U) {
                    return -1L;
                }
            }
            long mo2186R = super.mo2186R(zo0Var, Math.min(j, this.f1474T));
            if (mo2186R != -1) {
                this.f1474T -= mo2186R;
                return mo2186R;
            }
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            m2187a(false, protocolException);
            throw protocolException;
        }

        /* renamed from: b */
        public final void m2191b() throws IOException {
            if (this.f1474T != -1) {
                ao0.this.f1462c.mo4895I();
            }
            try {
                this.f1474T = ao0.this.f1462c.mo4901X();
                String trim = ao0.this.f1462c.mo4895I().trim();
                if (this.f1474T < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f1474T + trim + "\"");
                }
                if (this.f1474T == 0) {
                    this.f1475U = false;
                    tn0.m8786e(ao0.this.f1460a.m8946j(), this.f1473S, ao0.this.m2184n());
                    m2187a(true, null);
                }
            } catch (NumberFormatException e) {
                throw new ProtocolException(e.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1467P) {
                return;
            }
            if (this.f1475U && !fn0.m3835p(this, 100, TimeUnit.MILLISECONDS)) {
                m2187a(false, null);
            }
            this.f1467P = true;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$e */
    /* loaded from: classes.dex */
    public final class C0729e implements Sink {

        /* renamed from: O */
        public final dp0 f1477O;

        /* renamed from: P */
        public boolean f1478P;

        /* renamed from: Q */
        public long f1479Q;

        public C0729e(long j) {
            this.f1477O = new dp0(ao0.this.f1463d.mo2190g());
            this.f1479Q = j;
        }

        @Override // okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            if (this.f1478P) {
                throw new IllegalStateException("closed");
            }
            fn0.m3825f(zo0Var.m10557f0(), 0L, j);
            if (j <= this.f1479Q) {
                ao0.this.f1463d.mo2189F(zo0Var, j);
                this.f1479Q -= j;
                return;
            }
            throw new ProtocolException("expected " + this.f1479Q + " bytes but received " + j);
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1478P) {
                return;
            }
            this.f1478P = true;
            if (this.f1479Q > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            ao0.this.m2177g(this.f1477O);
            ao0.this.f1464e = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.f1478P) {
                return;
            }
            ao0.this.f1463d.flush();
        }

        @Override // okio.Sink
        /* renamed from: g */
        public mp0 mo2190g() {
            return this.f1477O;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$f */
    /* loaded from: classes.dex */
    public class C0730f extends AbstractC0726b {

        /* renamed from: S */
        public long f1481S;

        public C0730f(ao0 ao0Var, long j) throws IOException {
            super();
            this.f1481S = j;
            if (j == 0) {
                m2187a(true, null);
            }
        }

        @Override // cz.opentree.ao0.AbstractC0726b, okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f1467P) {
                throw new IllegalStateException("closed");
            }
            long j2 = this.f1481S;
            if (j2 == 0) {
                return -1L;
            }
            long mo2186R = super.mo2186R(zo0Var, Math.min(j2, j));
            if (mo2186R == -1) {
                ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                m2187a(false, protocolException);
                throw protocolException;
            }
            long j3 = this.f1481S - mo2186R;
            this.f1481S = j3;
            if (j3 == 0) {
                m2187a(true, null);
            }
            return mo2186R;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1467P) {
                return;
            }
            if (this.f1481S != 0 && !fn0.m3835p(this, 100, TimeUnit.MILLISECONDS)) {
                m2187a(false, null);
            }
            this.f1467P = true;
        }
    }

    /* compiled from: Http1Codec.java */
    /* renamed from: cz.opentree.ao0$g */
    /* loaded from: classes.dex */
    public class C0731g extends AbstractC0726b {

        /* renamed from: S */
        public boolean f1482S;

        public C0731g(ao0 ao0Var) {
            super();
        }

        @Override // cz.opentree.ao0.AbstractC0726b, okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.f1467P) {
                throw new IllegalStateException("closed");
            }
            if (this.f1482S) {
                return -1L;
            }
            long mo2186R = super.mo2186R(zo0Var, j);
            if (mo2186R != -1) {
                return mo2186R;
            }
            this.f1482S = true;
            m2187a(true, null);
            return -1L;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.f1467P) {
                return;
            }
            if (!this.f1482S) {
                m2187a(false, null);
            }
            this.f1467P = true;
        }
    }

    public ao0(um0 um0Var, pn0 pn0Var, BufferedSource bufferedSource, BufferedSink bufferedSink) {
        this.f1460a = um0Var;
        this.f1461b = pn0Var;
        this.f1462c = bufferedSource;
        this.f1463d = bufferedSink;
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: a */
    public void mo2171a() throws IOException {
        this.f1463d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: b */
    public void mo2172b(xm0 xm0Var) throws IOException {
        m2185o(xm0Var.m9817d(), xn0.m9849a(xm0Var, this.f1461b.m7415d().m6272p().m2587b().type()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: c */
    public an0 mo2173c(zm0 zm0Var) throws IOException {
        pn0 pn0Var = this.f1461b;
        pn0Var.f5732f.m10715q(pn0Var.f5731e);
        String m10510f = zm0Var.m10510f("Content-Type");
        if (!tn0.m8784c(zm0Var)) {
            return new wn0(m10510f, 0L, gp0.m4228b(m2181k(0L)));
        }
        if ("chunked".equalsIgnoreCase(zm0Var.m10510f("Transfer-Encoding"))) {
            return new wn0(m10510f, -1L, gp0.m4228b(m2179i(zm0Var.m10516y().m9821h())));
        }
        long m8783b = tn0.m8783b(zm0Var);
        return m8783b != -1 ? new wn0(m10510f, m8783b, gp0.m4228b(m2181k(m8783b))) : new wn0(m10510f, -1L, gp0.m4228b(m2182l()));
    }

    @Override // okhttp3.internal.http.HttpCodec
    public void cancel() {
        ln0 m7415d = this.f1461b.m7415d();
        if (m7415d != null) {
            m7415d.m6259c();
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: d */
    public zm0.C2434a mo2174d(boolean z) throws IOException {
        int i = this.f1464e;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.f1464e);
        }
        try {
            zn0 m10545a = zn0.m10545a(m2183m());
            zm0.C2434a c2434a = new zm0.C2434a();
            c2434a.m10531n(m10545a.f8567a);
            c2434a.m10524g(m10545a.f8568b);
            c2434a.m10528k(m10545a.f8569c);
            c2434a.m10527j(m2184n());
            if (z && m10545a.f8568b == 100) {
                return null;
            }
            if (m10545a.f8568b == 100) {
                this.f1464e = 3;
                return c2434a;
            }
            this.f1464e = 4;
            return c2434a;
        } catch (EOFException e) {
            IOException iOException = new IOException("unexpected end of stream on " + this.f1461b);
            iOException.initCause(e);
            throw iOException;
        }
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: e */
    public void mo2175e() throws IOException {
        this.f1463d.flush();
    }

    @Override // okhttp3.internal.http.HttpCodec
    /* renamed from: f */
    public Sink mo2176f(xm0 xm0Var, long j) {
        if ("chunked".equalsIgnoreCase(xm0Var.m9816c("Transfer-Encoding"))) {
            return m2178h();
        }
        if (j != -1) {
            return m2180j(j);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    /* renamed from: g */
    public void m2177g(dp0 dp0Var) {
        mp0 m3311i = dp0Var.m3311i();
        dp0Var.m3312j(mp0.f5125d);
        m3311i.mo3304a();
        m3311i.mo3305b();
    }

    /* renamed from: h */
    public Sink m2178h() {
        if (this.f1464e == 1) {
            this.f1464e = 2;
            return new C0727c();
        }
        throw new IllegalStateException("state: " + this.f1464e);
    }

    /* renamed from: i */
    public Source m2179i(rm0 rm0Var) throws IOException {
        if (this.f1464e == 4) {
            this.f1464e = 5;
            return new C0728d(rm0Var);
        }
        throw new IllegalStateException("state: " + this.f1464e);
    }

    /* renamed from: j */
    public Sink m2180j(long j) {
        if (this.f1464e == 1) {
            this.f1464e = 2;
            return new C0729e(j);
        }
        throw new IllegalStateException("state: " + this.f1464e);
    }

    /* renamed from: k */
    public Source m2181k(long j) throws IOException {
        if (this.f1464e == 4) {
            this.f1464e = 5;
            return new C0730f(this, j);
        }
        throw new IllegalStateException("state: " + this.f1464e);
    }

    /* renamed from: l */
    public Source m2182l() throws IOException {
        if (this.f1464e != 4) {
            throw new IllegalStateException("state: " + this.f1464e);
        }
        pn0 pn0Var = this.f1461b;
        if (pn0Var == null) {
            throw new IllegalStateException("streamAllocation == null");
        }
        this.f1464e = 5;
        pn0Var.m7421j();
        return new C0731g(this);
    }

    /* renamed from: m */
    public final String m2183m() throws IOException {
        String mo4908w = this.f1462c.mo4908w(this.f1465f);
        this.f1465f -= mo4908w.length();
        return mo4908w;
    }

    /* renamed from: n */
    public qm0 m2184n() throws IOException {
        qm0.C1776a c1776a = new qm0.C1776a();
        while (true) {
            String m2183m = m2183m();
            if (m2183m.length() == 0) {
                return c1776a.m7758d();
            }
            dn0.f2249a.mo3265a(c1776a, m2183m);
        }
    }

    /* renamed from: o */
    public void m2185o(qm0 qm0Var, String str) throws IOException {
        if (this.f1464e != 0) {
            throw new IllegalStateException("state: " + this.f1464e);
        }
        this.f1463d.mo4611A(str).mo4611A("\r\n");
        int m7752h = qm0Var.m7752h();
        for (int i = 0; i < m7752h; i++) {
            this.f1463d.mo4611A(qm0Var.m7750e(i)).mo4611A(": ").mo4611A(qm0Var.m7753i(i)).mo4611A("\r\n");
        }
        this.f1463d.mo4611A("\r\n");
        this.f1464e = 1;
    }
}
