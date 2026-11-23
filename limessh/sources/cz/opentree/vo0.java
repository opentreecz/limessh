package cz.opentree;

import java.security.cert.Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

/* compiled from: CertificateChainCleaner.java */
/* loaded from: classes.dex */
public abstract class vo0 {
    /* renamed from: b */
    public static vo0 m9334b(X509TrustManager x509TrustManager) {
        return ro0.m8221j().mo6492c(x509TrustManager);
    }

    /* renamed from: a */
    public abstract List<Certificate> mo6504a(List<Certificate> list, String str) throws SSLPeerUnverifiedException;
}
