package cz.opentree;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: Platform.java */
/* loaded from: classes.dex */
public class ro0 {

    /* renamed from: a */
    public static final ro0 f6268a = m8220i();

    /* renamed from: b */
    public static final Logger f6269b = Logger.getLogger(um0.class.getName());

    /* renamed from: b */
    public static List<String> m8218b(List<vm0> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            vm0 vm0Var = list.get(i);
            if (vm0Var != vm0.HTTP_1_0) {
                arrayList.add(vm0Var.toString());
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public static byte[] m8219e(List<vm0> list) {
        zo0 zo0Var = new zo0();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            vm0 vm0Var = list.get(i);
            if (vm0Var != vm0.HTTP_1_0) {
                zo0Var.m10565m0(vm0Var.toString().length());
                zo0Var.m10571s0(vm0Var.toString());
            }
        }
        return zo0Var.m10548Z();
    }

    /* renamed from: i */
    public static ro0 m8220i() {
        no0 m6758r;
        ro0 m6490t = mo0.m6490t();
        if (m6490t != null) {
            return m6490t;
        }
        if (m8222o() && (m6758r = no0.m6758r()) != null) {
            return m6758r;
        }
        oo0 m7076r = oo0.m7076r();
        if (m7076r != null) {
            return m7076r;
        }
        ro0 m7432r = po0.m7432r();
        return m7432r != null ? m7432r : new ro0();
    }

    /* renamed from: j */
    public static ro0 m8221j() {
        return f6268a;
    }

    /* renamed from: o */
    public static boolean m8222o() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* renamed from: a */
    public void mo7433a(SSLSocket sSLSocket) {
    }

    /* renamed from: c */
    public vo0 mo6492c(X509TrustManager x509TrustManager) {
        return new to0(mo6493d(x509TrustManager));
    }

    /* renamed from: d */
    public TrustRootIndex mo6493d(X509TrustManager x509TrustManager) {
        return new uo0(x509TrustManager.getAcceptedIssuers());
    }

    /* renamed from: f */
    public void mo6759f(SSLSocketFactory sSLSocketFactory) {
    }

    /* renamed from: g */
    public void mo6494g(SSLSocket sSLSocket, @Nullable String str, List<vm0> list) {
    }

    /* renamed from: h */
    public void mo6495h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* renamed from: k */
    public SSLContext mo6496k() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Nullable
    /* renamed from: l */
    public String mo6497l(SSLSocket sSLSocket) {
        return null;
    }

    /* renamed from: m */
    public Object mo6498m(String str) {
        if (f6269b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* renamed from: n */
    public boolean mo6499n(String str) {
        return true;
    }

    /* renamed from: p */
    public void mo6500p(int i, String str, @Nullable Throwable th) {
        f6269b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* renamed from: q */
    public void mo6501q(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo6500p(5, str, (Throwable) obj);
    }

    public String toString() {
        return getClass().getSimpleName();
    }
}
