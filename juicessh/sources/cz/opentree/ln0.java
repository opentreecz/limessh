package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.recyclerview.widget.RecyclerView;
import cz.opentree.go0;
import cz.opentree.xm0;
import cz.opentree.zm0;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpCodec;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;

/* compiled from: RealConnection.java */
/* loaded from: classes.dex */
public final class ln0 extends go0.AbstractC1060h implements Connection {

    /* renamed from: b */
    public final lm0 f4884b;

    /* renamed from: c */
    public final bn0 f4885c;

    /* renamed from: d */
    public Socket f4886d;

    /* renamed from: e */
    public Socket f4887e;

    /* renamed from: f */
    public pm0 f4888f;

    /* renamed from: g */
    public vm0 f4889g;

    /* renamed from: h */
    public go0 f4890h;

    /* renamed from: i */
    public BufferedSource f4891i;

    /* renamed from: j */
    public BufferedSink f4892j;

    /* renamed from: k */
    public boolean f4893k;

    /* renamed from: l */
    public int f4894l;

    /* renamed from: m */
    public int f4895m = 1;

    /* renamed from: n */
    public final List<Reference<pn0>> f4896n = new ArrayList();

    /* renamed from: o */
    public long f4897o = RecyclerView.FOREVER_NS;

    public ln0(lm0 lm0Var, bn0 bn0Var) {
        this.f4884b = lm0Var;
        this.f4885c = bn0Var;
    }

    @Override // cz.opentree.go0.AbstractC1060h
    /* renamed from: a */
    public void mo4212a(go0 go0Var) {
        synchronized (this.f4884b) {
            this.f4895m = go0Var.m4204p();
        }
    }

    @Override // cz.opentree.go0.AbstractC1060h
    /* renamed from: b */
    public void mo4213b(ho0 ho0Var) throws IOException {
        ho0Var.m4588f(co0.REFUSED_STREAM);
    }

    /* renamed from: c */
    public void m6259c() {
        fn0.m3827h(this.f4886d);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f4 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0142 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m6260d(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            Method dump skipped, instructions count: 344
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.ln0.m6260d(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    /* renamed from: e */
    public final void m6261e(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Proxy m2587b = this.f4885c.m2587b();
        this.f4886d = (m2587b.type() == Proxy.Type.DIRECT || m2587b.type() == Proxy.Type.HTTP) ? this.f4885c.m2586a().m4177j().createSocket() : new Socket(m2587b);
        eventListener.m10705f(call, this.f4885c.m2589d(), m2587b);
        this.f4886d.setSoTimeout(i2);
        try {
            ro0.m8221j().mo6495h(this.f4886d, this.f4885c.m2589d(), i);
            try {
                this.f4891i = gp0.m4228b(gp0.m4235i(this.f4886d));
                this.f4892j = gp0.m4227a(gp0.m4231e(this.f4886d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f4885c.m2589d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: f */
    public final void m6262f(kn0 kn0Var) throws IOException {
        SSLSocket sSLSocket;
        gm0 m2586a = this.f4885c.m2586a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) m2586a.m4178k().createSocket(this.f4886d, m2586a.m4179l().m8171l(), m2586a.m4179l().m8176x(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            mm0 m5957a = kn0Var.m5957a(sSLSocket);
            if (m5957a.m6468f()) {
                ro0.m8221j().mo6494g(sSLSocket, m2586a.m4179l().m8171l(), m2586a.m4173f());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            pm0 m7409b = pm0.m7409b(session);
            if (m2586a.m4172e().verify(m2586a.m4179l().m8171l(), session)) {
                m2586a.m4168a().m5167a(m2586a.m4179l().m8171l(), m7409b.m7411c());
                String mo6497l = m5957a.m6468f() ? ro0.m8221j().mo6497l(sSLSocket) : null;
                this.f4887e = sSLSocket;
                this.f4891i = gp0.m4228b(gp0.m4235i(sSLSocket));
                this.f4892j = gp0.m4227a(gp0.m4231e(this.f4887e));
                this.f4888f = m7409b;
                this.f4889g = mo6497l != null ? vm0.m9313f(mo6497l) : vm0.HTTP_1_1;
                if (sSLSocket != null) {
                    ro0.m8221j().mo7433a(sSLSocket);
                    return;
                }
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) m7409b.m7411c().get(0);
            throw new SSLPeerUnverifiedException("Hostname " + m2586a.m4179l().m8171l() + " not verified:\n    certificate: " + jm0.m5164c(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + wo0.m9603a(x509Certificate));
        } catch (AssertionError e2) {
            e = e2;
            if (!fn0.m3810A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                ro0.m8221j().mo7433a(sSLSocket2);
            }
            fn0.m3827h(sSLSocket2);
            throw th;
        }
    }

    /* renamed from: g */
    public final void m6263g(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        xm0 m6265i = m6265i();
        rm0 m9821h = m6265i.m9821h();
        for (int i4 = 0; i4 < 21; i4++) {
            m6261e(i, i2, call, eventListener);
            m6265i = m6264h(i2, i3, m6265i, m9821h);
            if (m6265i == null) {
                return;
            }
            fn0.m3827h(this.f4886d);
            this.f4886d = null;
            this.f4892j = null;
            this.f4891i = null;
            eventListener.m10703d(call, this.f4885c.m2589d(), this.f4885c.m2587b(), null);
        }
    }

    /* renamed from: h */
    public final xm0 m6264h(int i, int i2, xm0 xm0Var, rm0 rm0Var) throws IOException {
        String str = "CONNECT " + fn0.m3838s(rm0Var, true) + " HTTP/1.1";
        while (true) {
            BufferedSource bufferedSource = this.f4891i;
            ao0 ao0Var = new ao0(null, null, bufferedSource, this.f4892j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            bufferedSource.mo2188g().mo3310g(i, timeUnit);
            this.f4892j.mo2190g().mo3310g(i2, timeUnit);
            ao0Var.m2185o(xm0Var.m9817d(), str);
            ao0Var.mo2171a();
            zm0.C2434a mo2174d = ao0Var.mo2174d(false);
            mo2174d.m10533p(xm0Var);
            zm0 m10520c = mo2174d.m10520c();
            long m8783b = tn0.m8783b(m10520c);
            if (m8783b == -1) {
                m8783b = 0;
            }
            Source m2181k = ao0Var.m2181k(m8783b);
            fn0.m3813D(m2181k, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, timeUnit);
            m2181k.close();
            int m10508c = m10520c.m10508c();
            if (m10508c == 200) {
                if (this.f4891i.mo4905e().mo4907s() && this.f4892j.mo4618e().mo4907s()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (m10508c != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + m10520c.m10508c());
            }
            xm0 mo10693a = this.f4885c.m2586a().m4175h().mo10693a(this.f4885c, m10520c);
            if (mo10693a == null) {
                throw new IOException("Failed to authenticate with proxy");
            }
            if ("close".equalsIgnoreCase(m10520c.m10510f("Connection"))) {
                return mo10693a;
            }
            xm0Var = mo10693a;
        }
    }

    /* renamed from: i */
    public final xm0 m6265i() throws IOException {
        xm0.C2302a c2302a = new xm0.C2302a();
        c2302a.m9828g(this.f4885c.m2586a().m4179l());
        c2302a.m9826e("CONNECT", null);
        c2302a.m9824c("Host", fn0.m3838s(this.f4885c.m2586a().m4179l(), true));
        c2302a.m9824c("Proxy-Connection", "Keep-Alive");
        c2302a.m9824c("User-Agent", gn0.m4180a());
        xm0 m9822a = c2302a.m9822a();
        zm0.C2434a c2434a = new zm0.C2434a();
        c2434a.m10533p(m9822a);
        c2434a.m10531n(vm0.HTTP_1_1);
        c2434a.m10524g(407);
        c2434a.m10528k("Preemptive Authenticate");
        c2434a.m10519b(fn0.f2724c);
        c2434a.m10534q(-1L);
        c2434a.m10532o(-1L);
        c2434a.m10526i("Proxy-Authenticate", "OkHttp-Preemptive");
        xm0 mo10693a = this.f4885c.m2586a().m4175h().mo10693a(this.f4885c, c2434a.m10520c());
        return mo10693a != null ? mo10693a : m9822a;
    }

    /* renamed from: j */
    public final void m6266j(kn0 kn0Var, int i, Call call, EventListener eventListener) throws IOException {
        if (this.f4885c.m2586a().m4178k() != null) {
            eventListener.m10719u(call);
            m6262f(kn0Var);
            eventListener.m10718t(call, this.f4888f);
            if (this.f4889g == vm0.HTTP_2) {
                m6274r(i);
                return;
            }
            return;
        }
        List<vm0> m4173f = this.f4885c.m2586a().m4173f();
        vm0 vm0Var = vm0.H2_PRIOR_KNOWLEDGE;
        if (!m4173f.contains(vm0Var)) {
            this.f4887e = this.f4886d;
            this.f4889g = vm0.HTTP_1_1;
        } else {
            this.f4887e = this.f4886d;
            this.f4889g = vm0Var;
            m6274r(i);
        }
    }

    /* renamed from: k */
    public pm0 m6267k() {
        return this.f4888f;
    }

    /* renamed from: l */
    public boolean m6268l(gm0 gm0Var, @Nullable bn0 bn0Var) {
        if (this.f4896n.size() >= this.f4895m || this.f4893k || !dn0.f2249a.mo3271g(this.f4885c.m2586a(), gm0Var)) {
            return false;
        }
        if (gm0Var.m4179l().m8171l().equals(m6272p().m2586a().m4179l().m8171l())) {
            return true;
        }
        if (this.f4890h == null || bn0Var == null || bn0Var.m2587b().type() != Proxy.Type.DIRECT || this.f4885c.m2587b().type() != Proxy.Type.DIRECT || !this.f4885c.m2589d().equals(bn0Var.m2589d()) || bn0Var.m2586a().m4172e() != wo0.f7782a || !m6275s(gm0Var.m4179l())) {
            return false;
        }
        try {
            gm0Var.m4168a().m5167a(gm0Var.m4179l().m8171l(), m6267k().m7411c());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    /* renamed from: m */
    public boolean m6269m(boolean z) {
        if (this.f4887e.isClosed() || this.f4887e.isInputShutdown() || this.f4887e.isOutputShutdown()) {
            return false;
        }
        if (this.f4890h != null) {
            return !r0.m4203n();
        }
        if (z) {
            try {
                int soTimeout = this.f4887e.getSoTimeout();
                try {
                    this.f4887e.setSoTimeout(1);
                    return !this.f4891i.mo4907s();
                } finally {
                    this.f4887e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: n */
    public boolean m6270n() {
        return this.f4890h != null;
    }

    /* renamed from: o */
    public HttpCodec m6271o(um0 um0Var, Interceptor.Chain chain, pn0 pn0Var) throws SocketException {
        if (this.f4890h != null) {
            return new fo0(um0Var, chain, pn0Var, this.f4890h);
        }
        this.f4887e.setSoTimeout(chain.mo9316a());
        mp0 mo2188g = this.f4891i.mo2188g();
        long mo9316a = chain.mo9316a();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        mo2188g.mo3310g(mo9316a, timeUnit);
        this.f4892j.mo2190g().mo3310g(chain.mo9317b(), timeUnit);
        return new ao0(um0Var, pn0Var, this.f4891i, this.f4892j);
    }

    /* renamed from: p */
    public bn0 m6272p() {
        return this.f4885c;
    }

    /* renamed from: q */
    public Socket m6273q() {
        return this.f4887e;
    }

    /* renamed from: r */
    public final void m6274r(int i) throws IOException {
        this.f4887e.setSoTimeout(0);
        go0.C1059g c1059g = new go0.C1059g(true);
        c1059g.m4211d(this.f4887e, this.f4885c.m2586a().m4179l().m8171l(), this.f4891i, this.f4892j);
        c1059g.m4209b(this);
        c1059g.m4210c(i);
        go0 m4208a = c1059g.m4208a();
        this.f4890h = m4208a;
        m4208a.m4192d0();
    }

    /* renamed from: s */
    public boolean m6275s(rm0 rm0Var) {
        if (rm0Var.m8176x() != this.f4885c.m2586a().m4179l().m8176x()) {
            return false;
        }
        if (rm0Var.m8171l().equals(this.f4885c.m2586a().m4179l().m8171l())) {
            return true;
        }
        return this.f4888f != null && wo0.f7782a.m9605c(rm0Var.m8171l(), (X509Certificate) this.f4888f.m7411c().get(0));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f4885c.m2586a().m4179l().m8171l());
        sb.append(":");
        sb.append(this.f4885c.m2586a().m4179l().m8176x());
        sb.append(", proxy=");
        sb.append(this.f4885c.m2587b());
        sb.append(" hostAddress=");
        sb.append(this.f4885c.m2589d());
        sb.append(" cipherSuite=");
        pm0 pm0Var = this.f4888f;
        sb.append(pm0Var != null ? pm0Var.m7410a() : "none");
        sb.append(" protocol=");
        sb.append(this.f4889g);
        sb.append('}');
        return sb.toString();
    }
}
