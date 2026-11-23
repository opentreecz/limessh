package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.sonelli.xm0;
import com.sonelli.zm0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.HttpRetryException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.internal.http.UnrepeatableRequestBody;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes.dex */
public final class yn0 implements Interceptor {

    /* renamed from: a */
    public final um0 f8284a;

    /* renamed from: b */
    public volatile pn0 f8285b;

    /* renamed from: c */
    public Object f8286c;

    /* renamed from: d */
    public volatile boolean f8287d;

    public yn0(um0 um0Var, boolean z) {
        this.f8284a = um0Var;
    }

    @Override // okhttp3.Interceptor
    /* renamed from: a */
    public zm0 mo4577a(Interceptor.Chain chain) throws IOException {
        zm0 m9325j;
        xm0 m10197d;
        xm0 mo9320e = chain.mo9320e();
        vn0 vn0Var = (vn0) chain;
        Call m9321f = vn0Var.m9321f();
        EventListener m9323h = vn0Var.m9323h();
        pn0 pn0Var = new pn0(this.f8284a.m8944g(), m10196c(mo9320e.m9821h()), m9321f, m9323h, this.f8286c);
        this.f8285b = pn0Var;
        int i = 0;
        zm0 zm0Var = null;
        while (!this.f8287d) {
            try {
                try {
                    m9325j = vn0Var.m9325j(mo9320e, pn0Var, null, null);
                    if (zm0Var != null) {
                        zm0.C2434a m10513n = m9325j.m10513n();
                        zm0.C2434a m10513n2 = zm0Var.m10513n();
                        m10513n2.m10519b(null);
                        m10513n.m10530m(m10513n2.m10520c());
                        m9325j = m10513n.m10520c();
                    }
                    try {
                        m10197d = m10197d(m9325j, pn0Var.m7426o());
                    } catch (IOException e) {
                        pn0Var.m7422k();
                        throw e;
                    }
                } catch (nn0 e2) {
                    if (!m10200g(e2.m6756c(), pn0Var, false, mo9320e)) {
                        throw e2.m6755b();
                    }
                } catch (IOException e3) {
                    if (!m10200g(e3, pn0Var, !(e3 instanceof bo0), mo9320e)) {
                        throw e3;
                    }
                }
                if (m10197d == null) {
                    pn0Var.m7422k();
                    return m9325j;
                }
                fn0.m3826g(m9325j.m10506a());
                int i2 = i + 1;
                if (i2 > 20) {
                    pn0Var.m7422k();
                    throw new ProtocolException("Too many follow-up requests: " + i2);
                }
                if (m10197d.m9814a() instanceof UnrepeatableRequestBody) {
                    pn0Var.m7422k();
                    throw new HttpRetryException("Cannot retry streamed HTTP body", m9325j.m10508c());
                }
                if (!m10202i(m9325j, m10197d.m9821h())) {
                    pn0Var.m7422k();
                    pn0Var = new pn0(this.f8284a.m8944g(), m10196c(m10197d.m9821h()), m9321f, m9323h, this.f8286c);
                    this.f8285b = pn0Var;
                } else if (pn0Var.m7414c() != null) {
                    throw new IllegalStateException("Closing the body of " + m9325j + " didn't close its backing stream. Bad interceptor?");
                }
                zm0Var = m9325j;
                mo9320e = m10197d;
                i = i2;
            } catch (Throwable th) {
                pn0Var.m7428q(null);
                pn0Var.m7422k();
                throw th;
            }
        }
        pn0Var.m7422k();
        throw new IOException("Canceled");
    }

    /* renamed from: b */
    public void m10195b() {
        this.f8287d = true;
        pn0 pn0Var = this.f8285b;
        if (pn0Var != null) {
            pn0Var.m7413b();
        }
    }

    /* renamed from: c */
    public final gm0 m10196c(rm0 rm0Var) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        jm0 jm0Var;
        if (rm0Var.m8172m()) {
            SSLSocketFactory m8938H = this.f8284a.m8938H();
            hostnameVerifier = this.f8284a.m8952r();
            sSLSocketFactory = m8938H;
            jm0Var = this.f8284a.m8942d();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            jm0Var = null;
        }
        return new gm0(rm0Var.m8171l(), rm0Var.m8176x(), this.f8284a.m8948l(), this.f8284a.m8937G(), sSLSocketFactory, hostnameVerifier, jm0Var, this.f8284a.m8933C(), this.f8284a.m8932B(), this.f8284a.m8931A(), this.f8284a.m8945i(), this.f8284a.m8934D());
    }

    /* renamed from: d */
    public final xm0 m10197d(zm0 zm0Var, bn0 bn0Var) throws IOException {
        String m10510f;
        rm0 m8162B;
        if (zm0Var == null) {
            throw new IllegalStateException();
        }
        int m10508c = zm0Var.m10508c();
        String m9819f = zm0Var.m10516y().m9819f();
        if (m10508c == 307 || m10508c == 308) {
            if (!m9819f.equals("GET") && !m9819f.equals("HEAD")) {
                return null;
            }
        } else {
            if (m10508c == 401) {
                return this.f8284a.m8940b().mo10693a(bn0Var, zm0Var);
            }
            if (m10508c == 503) {
                if ((zm0Var.m10514p() == null || zm0Var.m10514p().m10508c() != 503) && m10201h(zm0Var, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) == 0) {
                    return zm0Var.m10516y();
                }
                return null;
            }
            if (m10508c == 407) {
                if ((bn0Var != null ? bn0Var.m2587b() : this.f8284a.m8932B()).type() == Proxy.Type.HTTP) {
                    return this.f8284a.m8933C().mo10693a(bn0Var, zm0Var);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (m10508c == 408) {
                if (!this.f8284a.m8936F() || (zm0Var.m10516y().m9814a() instanceof UnrepeatableRequestBody)) {
                    return null;
                }
                if ((zm0Var.m10514p() == null || zm0Var.m10514p().m10508c() != 408) && m10201h(zm0Var, 0) <= 0) {
                    return zm0Var.m10516y();
                }
                return null;
            }
            switch (m10508c) {
                case 300:
                case 301:
                case 302:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        if (!this.f8284a.m8950o() || (m10510f = zm0Var.m10510f("Location")) == null || (m8162B = zm0Var.m10516y().m9821h().m8162B(m10510f)) == null) {
            return null;
        }
        if (!m8162B.m8163C().equals(zm0Var.m10516y().m9821h().m8163C()) && !this.f8284a.m8951q()) {
            return null;
        }
        xm0.C2302a m9820g = zm0Var.m10516y().m9820g();
        if (un0.m8962b(m9819f)) {
            boolean m8964d = un0.m8964d(m9819f);
            if (un0.m8963c(m9819f)) {
                m9820g.m9826e("GET", null);
            } else {
                m9820g.m9826e(m9819f, m8964d ? zm0Var.m10516y().m9814a() : null);
            }
            if (!m8964d) {
                m9820g.m9827f("Transfer-Encoding");
                m9820g.m9827f("Content-Length");
                m9820g.m9827f("Content-Type");
            }
        }
        if (!m10202i(zm0Var, m8162B)) {
            m9820g.m9827f("Authorization");
        }
        m9820g.m9828g(m8162B);
        return m9820g.m9822a();
    }

    /* renamed from: e */
    public boolean m10198e() {
        return this.f8287d;
    }

    /* renamed from: f */
    public final boolean m10199f(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    /* renamed from: g */
    public final boolean m10200g(IOException iOException, pn0 pn0Var, boolean z, xm0 xm0Var) {
        pn0Var.m7428q(iOException);
        if (this.f8284a.m8936F()) {
            return !(z && (xm0Var.m9814a() instanceof UnrepeatableRequestBody)) && m10199f(iOException, z) && pn0Var.m7419h();
        }
        return false;
    }

    /* renamed from: h */
    public final int m10201h(zm0 zm0Var, int i) {
        String m10510f = zm0Var.m10510f("Retry-After");
        return m10510f == null ? i : m10510f.matches("\\d+") ? Integer.valueOf(m10510f).intValue() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    /* renamed from: i */
    public final boolean m10202i(zm0 zm0Var, rm0 rm0Var) {
        rm0 m9821h = zm0Var.m10516y().m9821h();
        return m9821h.m8171l().equals(rm0Var.m8171l()) && m9821h.m8176x() == rm0Var.m8176x() && m9821h.m8163C().equals(rm0Var.m8163C());
    }

    /* renamed from: j */
    public void m10203j(Object obj) {
        this.f8286c = obj;
    }
}
