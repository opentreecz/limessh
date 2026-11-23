package com.sonelli;

import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes.dex */
public final class pm0 {

    /* renamed from: a */
    public final cn0 f5723a;

    /* renamed from: b */
    public final km0 f5724b;

    /* renamed from: c */
    public final List<Certificate> f5725c;

    /* renamed from: d */
    public final List<Certificate> f5726d;

    public pm0(cn0 cn0Var, km0 km0Var, List<Certificate> list, List<Certificate> list2) {
        this.f5723a = cn0Var;
        this.f5724b = km0Var;
        this.f5725c = list;
        this.f5726d = list2;
    }

    /* renamed from: b */
    public static pm0 m7409b(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        km0 m5949a = km0.m5949a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        cn0 m2887f = cn0.m2887f(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List m3840u = certificateArr != null ? fn0.m3840u(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new pm0(m2887f, m5949a, m3840u, localCertificates != null ? fn0.m3840u(localCertificates) : Collections.emptyList());
    }

    /* renamed from: a */
    public km0 m7410a() {
        return this.f5724b;
    }

    /* renamed from: c */
    public List<Certificate> m7411c() {
        return this.f5725c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof pm0)) {
            return false;
        }
        pm0 pm0Var = (pm0) obj;
        return this.f5723a.equals(pm0Var.f5723a) && this.f5724b.equals(pm0Var.f5724b) && this.f5725c.equals(pm0Var.f5725c) && this.f5726d.equals(pm0Var.f5726d);
    }

    public int hashCode() {
        return ((((((527 + this.f5723a.hashCode()) * 31) + this.f5724b.hashCode()) * 31) + this.f5725c.hashCode()) * 31) + this.f5726d.hashCode();
    }
}
