package cz.opentree;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: OkHostnameVerifier.java */
/* loaded from: classes.dex */
public final class wo0 implements HostnameVerifier {

    /* renamed from: a */
    public static final wo0 f7782a = new wo0();

    /* renamed from: a */
    public static List<String> m9603a(X509Certificate x509Certificate) {
        List<String> m9604b = m9604b(x509Certificate, 7);
        List<String> m9604b2 = m9604b(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(m9604b.size() + m9604b2.size());
        arrayList.addAll(m9604b);
        arrayList.addAll(m9604b2);
        return arrayList;
    }

    /* renamed from: b */
    public static List<String> m9604b(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* renamed from: c */
    public boolean m9605c(String str, X509Certificate x509Certificate) {
        return fn0.m3819J(str) ? m9608f(str, x509Certificate) : m9607e(str, x509Certificate);
    }

    /* renamed from: d */
    public boolean m9606d(String str, String str2) {
        if (str != null && str.length() != 0 && !str.startsWith(".") && !str.endsWith("..") && str2 != null && str2.length() != 0 && !str2.startsWith(".") && !str2.endsWith("..")) {
            if (!str.endsWith(".")) {
                str = str + '.';
            }
            if (!str2.endsWith(".")) {
                str2 = str2 + '.';
            }
            String lowerCase = str2.toLowerCase(Locale.US);
            if (!lowerCase.contains("*")) {
                return str.equals(lowerCase);
            }
            if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
                return false;
            }
            String substring = lowerCase.substring(1);
            if (!str.endsWith(substring)) {
                return false;
            }
            int length = str.length() - substring.length();
            return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
        }
        return false;
    }

    /* renamed from: e */
    public final boolean m9607e(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = m9604b(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (m9606d(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public final boolean m9608f(String str, X509Certificate x509Certificate) {
        List<String> m9604b = m9604b(x509Certificate, 7);
        int size = m9604b.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(m9604b.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m9605c(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }
}
