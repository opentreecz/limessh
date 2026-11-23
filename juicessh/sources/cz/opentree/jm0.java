package cz.opentree;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: classes.dex */
public final class jm0 {

    /* renamed from: c */
    public static final jm0 f3621c = new C1226a().m5170a();

    /* renamed from: a */
    public final Set<C1227b> f3622a;

    /* renamed from: b */
    @Nullable
    public final vo0 f3623b;

    /* compiled from: CertificatePinner.java */
    /* renamed from: cz.opentree.jm0$a */
    /* loaded from: classes.dex */
    public static final class C1226a {

        /* renamed from: a */
        public final List<C1227b> f3624a = new ArrayList();

        /* renamed from: a */
        public jm0 m5170a() {
            return new jm0(new LinkedHashSet(this.f3624a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    /* renamed from: cz.opentree.jm0$b */
    /* loaded from: classes.dex */
    public static final class C1227b {

        /* renamed from: a */
        public final String f3625a;

        /* renamed from: b */
        public final String f3626b;

        /* renamed from: c */
        public final String f3627c;

        /* renamed from: d */
        public final ap0 f3628d;

        /* renamed from: a */
        public boolean m5171a(String str) {
            if (!this.f3625a.startsWith("*.")) {
                return str.equals(this.f3626b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.f3626b.length()) {
                String str2 = this.f3626b;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1227b) {
                C1227b c1227b = (C1227b) obj;
                if (this.f3625a.equals(c1227b.f3625a) && this.f3627c.equals(c1227b.f3627c) && this.f3628d.equals(c1227b.f3628d)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return ((((527 + this.f3625a.hashCode()) * 31) + this.f3627c.hashCode()) * 31) + this.f3628d.hashCode();
        }

        public String toString() {
            return this.f3627c + this.f3628d.mo2238f();
        }
    }

    public jm0(Set<C1227b> set, @Nullable vo0 vo0Var) {
        this.f3622a = set;
        this.f3623b = vo0Var;
    }

    /* renamed from: c */
    public static String m5164c(Certificate certificate) {
        if (!(certificate instanceof X509Certificate)) {
            throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
        }
        return "sha256/" + m5166e((X509Certificate) certificate).mo2238f();
    }

    /* renamed from: d */
    public static ap0 m5165d(X509Certificate x509Certificate) {
        return ap0.m2234r(x509Certificate.getPublicKey().getEncoded()).mo2245u();
    }

    /* renamed from: e */
    public static ap0 m5166e(X509Certificate x509Certificate) {
        return ap0.m2234r(x509Certificate.getPublicKey().getEncoded()).mo2246v();
    }

    /* renamed from: a */
    public void m5167a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<C1227b> m5168b = m5168b(str);
        if (m5168b.isEmpty()) {
            return;
        }
        vo0 vo0Var = this.f3623b;
        if (vo0Var != null) {
            list = vo0Var.mo6504a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = m5168b.size();
            ap0 ap0Var = null;
            ap0 ap0Var2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                C1227b c1227b = m5168b.get(i2);
                if (c1227b.f3627c.equals("sha256/")) {
                    if (ap0Var == null) {
                        ap0Var = m5166e(x509Certificate);
                    }
                    if (c1227b.f3628d.equals(ap0Var)) {
                        return;
                    }
                } else {
                    if (!c1227b.f3627c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + c1227b.f3627c);
                    }
                    if (ap0Var2 == null) {
                        ap0Var2 = m5165d(x509Certificate);
                    }
                    if (c1227b.f3628d.equals(ap0Var2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ");
            sb.append(m5164c(x509Certificate2));
            sb.append(": ");
            sb.append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size4 = m5168b.size();
        for (int i4 = 0; i4 < size4; i4++) {
            C1227b c1227b2 = m5168b.get(i4);
            sb.append("\n    ");
            sb.append(c1227b2);
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    /* renamed from: b */
    public List<C1227b> m5168b(String str) {
        List<C1227b> emptyList = Collections.emptyList();
        for (C1227b c1227b : this.f3622a) {
            if (c1227b.m5171a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(c1227b);
            }
        }
        return emptyList;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof jm0) {
            jm0 jm0Var = (jm0) obj;
            if (fn0.m3836q(this.f3623b, jm0Var.f3623b) && this.f3622a.equals(jm0Var.f3622a)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public jm0 m5169f(@Nullable vo0 vo0Var) {
        return fn0.m3836q(this.f3623b, vo0Var) ? this : new jm0(this.f3622a, vo0Var);
    }

    public int hashCode() {
        vo0 vo0Var = this.f3623b;
        return ((vo0Var != null ? vo0Var.hashCode() : 0) * 31) + this.f3622a.hashCode();
    }
}
