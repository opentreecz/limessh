package cz.opentree;

import cz.opentree.rm0;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Authenticator;
import okhttp3.Dns;

/* compiled from: Address.java */
/* loaded from: classes.dex */
public final class gm0 {

    /* renamed from: a */
    public final rm0 f2890a;

    /* renamed from: b */
    public final Dns f2891b;

    /* renamed from: c */
    public final SocketFactory f2892c;

    /* renamed from: d */
    public final Authenticator f2893d;

    /* renamed from: e */
    public final List<vm0> f2894e;

    /* renamed from: f */
    public final List<mm0> f2895f;

    /* renamed from: g */
    public final ProxySelector f2896g;

    /* renamed from: h */
    @Nullable
    public final Proxy f2897h;

    /* renamed from: i */
    @Nullable
    public final SSLSocketFactory f2898i;

    /* renamed from: j */
    @Nullable
    public final HostnameVerifier f2899j;

    /* renamed from: k */
    @Nullable
    public final jm0 f2900k;

    public gm0(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable jm0 jm0Var, Authenticator authenticator, @Nullable Proxy proxy, List<vm0> list, List<mm0> list2, ProxySelector proxySelector) {
        rm0.C1825a c1825a = new rm0.C1825a();
        c1825a.m8197r(sSLSocketFactory != null ? "https" : "http");
        c1825a.m8187f(str);
        c1825a.m8193m(i);
        this.f2890a = c1825a.m8184b();
        Objects.requireNonNull(dns, "dns == null");
        this.f2891b = dns;
        Objects.requireNonNull(socketFactory, "socketFactory == null");
        this.f2892c = socketFactory;
        Objects.requireNonNull(authenticator, "proxyAuthenticator == null");
        this.f2893d = authenticator;
        Objects.requireNonNull(list, "protocols == null");
        this.f2894e = fn0.m3839t(list);
        Objects.requireNonNull(list2, "connectionSpecs == null");
        this.f2895f = fn0.m3839t(list2);
        Objects.requireNonNull(proxySelector, "proxySelector == null");
        this.f2896g = proxySelector;
        this.f2897h = proxy;
        this.f2898i = sSLSocketFactory;
        this.f2899j = hostnameVerifier;
        this.f2900k = jm0Var;
    }

    @Nullable
    /* renamed from: a */
    public jm0 m4168a() {
        return this.f2900k;
    }

    /* renamed from: b */
    public List<mm0> m4169b() {
        return this.f2895f;
    }

    /* renamed from: c */
    public Dns m4170c() {
        return this.f2891b;
    }

    /* renamed from: d */
    public boolean m4171d(gm0 gm0Var) {
        return this.f2891b.equals(gm0Var.f2891b) && this.f2893d.equals(gm0Var.f2893d) && this.f2894e.equals(gm0Var.f2894e) && this.f2895f.equals(gm0Var.f2895f) && this.f2896g.equals(gm0Var.f2896g) && fn0.m3836q(this.f2897h, gm0Var.f2897h) && fn0.m3836q(this.f2898i, gm0Var.f2898i) && fn0.m3836q(this.f2899j, gm0Var.f2899j) && fn0.m3836q(this.f2900k, gm0Var.f2900k) && m4179l().m8176x() == gm0Var.m4179l().m8176x();
    }

    @Nullable
    /* renamed from: e */
    public HostnameVerifier m4172e() {
        return this.f2899j;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof gm0) {
            gm0 gm0Var = (gm0) obj;
            if (this.f2890a.equals(gm0Var.f2890a) && m4171d(gm0Var)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public List<vm0> m4173f() {
        return this.f2894e;
    }

    @Nullable
    /* renamed from: g */
    public Proxy m4174g() {
        return this.f2897h;
    }

    /* renamed from: h */
    public Authenticator m4175h() {
        return this.f2893d;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f2890a.hashCode()) * 31) + this.f2891b.hashCode()) * 31) + this.f2893d.hashCode()) * 31) + this.f2894e.hashCode()) * 31) + this.f2895f.hashCode()) * 31) + this.f2896g.hashCode()) * 31;
        Proxy proxy = this.f2897h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f2898i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f2899j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        jm0 jm0Var = this.f2900k;
        return hashCode4 + (jm0Var != null ? jm0Var.hashCode() : 0);
    }

    /* renamed from: i */
    public ProxySelector m4176i() {
        return this.f2896g;
    }

    /* renamed from: j */
    public SocketFactory m4177j() {
        return this.f2892c;
    }

    @Nullable
    /* renamed from: k */
    public SSLSocketFactory m4178k() {
        return this.f2898i;
    }

    /* renamed from: l */
    public rm0 m4179l() {
        return this.f2890a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f2890a.m8171l());
        sb.append(":");
        sb.append(this.f2890a.m8176x());
        if (this.f2897h != null) {
            sb.append(", proxy=");
            sb.append(this.f2897h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f2896g);
        }
        sb.append("}");
        return sb.toString();
    }
}
