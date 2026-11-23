package com.sonelli;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: BasicTrustRootIndex.java */
/* loaded from: classes.dex */
public final class uo0 implements TrustRootIndex {

    /* renamed from: a */
    public final Map<X500Principal, Set<X509Certificate>> f7082a = new LinkedHashMap();

    public uo0(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f7082a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f7082a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    /* renamed from: a */
    public X509Certificate mo6505a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f7082a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof uo0) && ((uo0) obj).f7082a.equals(this.f7082a);
    }

    public int hashCode() {
        return this.f7082a.hashCode();
    }
}
