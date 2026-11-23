package cz.opentree;

import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: BasicCertificateChainCleaner.java */
/* loaded from: classes.dex */
public final class to0 extends vo0 {

    /* renamed from: a */
    public final TrustRootIndex f6816a;

    public to0(TrustRootIndex trustRootIndex) {
        this.f6816a = trustRootIndex;
    }

    @Override // cz.opentree.vo0
    /* renamed from: a */
    public List<Certificate> mo6504a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList();
        arrayList.add(arrayDeque.removeFirst());
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
            X509Certificate mo6505a = this.f6816a.mo6505a(x509Certificate);
            if (mo6505a == null) {
                Iterator it = arrayDeque.iterator();
                while (it.hasNext()) {
                    X509Certificate x509Certificate2 = (X509Certificate) it.next();
                    if (m8790c(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || !x509Certificate.equals(mo6505a)) {
                arrayList.add(mo6505a);
            }
            if (m8790c(mo6505a, mo6505a)) {
                return arrayList;
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    /* renamed from: c */
    public final boolean m8790c(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        if (!x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof to0) && ((to0) obj).f6816a.equals(this.f6816a);
    }

    public int hashCode() {
        return this.f6816a.hashCode();
    }
}
