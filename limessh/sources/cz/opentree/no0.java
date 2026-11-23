package cz.opentree;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import org.conscrypt.Conscrypt;

/* compiled from: ConscryptPlatform.java */
/* loaded from: classes.dex */
public class no0 extends ro0 {
    /* renamed from: r */
    public static no0 m6758r() {
        try {
            Class.forName("org.conscrypt.Conscrypt");
            if (Conscrypt.isAvailable()) {
                return new no0();
            }
            return null;
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @Override // cz.opentree.ro0
    /* renamed from: f */
    public void mo6759f(SSLSocketFactory sSLSocketFactory) {
        if (Conscrypt.isConscrypt(sSLSocketFactory)) {
            Conscrypt.setUseEngineSocket(sSLSocketFactory, true);
        }
    }

    @Override // cz.opentree.ro0
    /* renamed from: g */
    public void mo6494g(SSLSocket sSLSocket, String str, List<vm0> list) {
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo6494g(sSLSocket, str, list);
            return;
        }
        if (str != null) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            Conscrypt.setHostname(sSLSocket, str);
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) ro0.m8218b(list).toArray(new String[0]));
    }

    @Override // cz.opentree.ro0
    /* renamed from: k */
    public SSLContext mo6496k() {
        try {
            return SSLContext.getInstance("TLSv1.3", m6760s());
        } catch (NoSuchAlgorithmException e) {
            try {
                return SSLContext.getInstance("TLS", m6760s());
            } catch (NoSuchAlgorithmException unused) {
                throw new IllegalStateException("No TLS provider", e);
            }
        }
    }

    @Override // cz.opentree.ro0
    @Nullable
    /* renamed from: l */
    public String mo6497l(SSLSocket sSLSocket) {
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.mo6497l(sSLSocket);
    }

    /* renamed from: s */
    public final Provider m6760s() {
        return Conscrypt.newProviderBuilder().provideTrustManager().build();
    }
}
