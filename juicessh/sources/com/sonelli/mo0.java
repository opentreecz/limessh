package com.sonelli;

import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import okhttp3.internal.tls.TrustRootIndex;

/* compiled from: AndroidPlatform.java */
/* loaded from: classes.dex */
public class mo0 extends ro0 {

    /* renamed from: c */
    public final qo0<Socket> f5110c;

    /* renamed from: d */
    public final qo0<Socket> f5111d;

    /* renamed from: e */
    public final qo0<Socket> f5112e;

    /* renamed from: f */
    public final qo0<Socket> f5113f;

    /* renamed from: g */
    public final C1566c f5114g = C1566c.m6506b();

    /* compiled from: AndroidPlatform.java */
    /* renamed from: com.sonelli.mo0$a */
    /* loaded from: classes.dex */
    public static final class C1564a extends vo0 {

        /* renamed from: a */
        public final Object f5115a;

        /* renamed from: b */
        public final Method f5116b;

        public C1564a(Object obj, Method method) {
            this.f5115a = obj;
            this.f5116b = method;
        }

        @Override // com.sonelli.vo0
        /* renamed from: a */
        public List<Certificate> mo6504a(List<Certificate> list, String str) throws SSLPeerUnverifiedException {
            try {
                return (List) this.f5116b.invoke(this.f5115a, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e2.getMessage());
                sSLPeerUnverifiedException.initCause(e2);
                throw sSLPeerUnverifiedException;
            }
        }

        public boolean equals(Object obj) {
            return obj instanceof C1564a;
        }

        public int hashCode() {
            return 0;
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: com.sonelli.mo0$b */
    /* loaded from: classes.dex */
    public static final class C1565b implements TrustRootIndex {

        /* renamed from: a */
        public final X509TrustManager f5117a;

        /* renamed from: b */
        public final Method f5118b;

        public C1565b(X509TrustManager x509TrustManager, Method method) {
            this.f5118b = method;
            this.f5117a = x509TrustManager;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        /* renamed from: a */
        public X509Certificate mo6505a(X509Certificate x509Certificate) {
            try {
                TrustAnchor trustAnchor = (TrustAnchor) this.f5118b.invoke(this.f5117a, x509Certificate);
                if (trustAnchor != null) {
                    return trustAnchor.getTrustedCert();
                }
                return null;
            } catch (IllegalAccessException e) {
                throw fn0.m3821b("unable to get issues and signature", e);
            } catch (InvocationTargetException unused) {
                return null;
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C1565b)) {
                return false;
            }
            C1565b c1565b = (C1565b) obj;
            return this.f5117a.equals(c1565b.f5117a) && this.f5118b.equals(c1565b.f5118b);
        }

        public int hashCode() {
            return this.f5117a.hashCode() + (this.f5118b.hashCode() * 31);
        }
    }

    /* compiled from: AndroidPlatform.java */
    /* renamed from: com.sonelli.mo0$c */
    /* loaded from: classes.dex */
    public static final class C1566c {

        /* renamed from: a */
        public final Method f5119a;

        /* renamed from: b */
        public final Method f5120b;

        /* renamed from: c */
        public final Method f5121c;

        public C1566c(Method method, Method method2, Method method3) {
            this.f5119a = method;
            this.f5120b = method2;
            this.f5121c = method3;
        }

        /* renamed from: b */
        public static C1566c m6506b() {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", new Class[0]);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", new Class[0]);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C1566c(method3, method2, method);
        }

        /* renamed from: a */
        public Object m6507a(String str) {
            Method method = this.f5119a;
            if (method != null) {
                try {
                    Object invoke = method.invoke(null, new Object[0]);
                    this.f5120b.invoke(invoke, str);
                    return invoke;
                } catch (Exception unused) {
                }
            }
            return null;
        }

        /* renamed from: c */
        public boolean m6508c(Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                this.f5121c.invoke(obj, new Object[0]);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public mo0(Class<?> cls, qo0<Socket> qo0Var, qo0<Socket> qo0Var2, qo0<Socket> qo0Var3, qo0<Socket> qo0Var4) {
        this.f5110c = qo0Var;
        this.f5111d = qo0Var2;
        this.f5112e = qo0Var3;
        this.f5113f = qo0Var4;
    }

    /* renamed from: t */
    public static ro0 m6490t() {
        Class<?> cls;
        qo0 qo0Var;
        qo0 qo0Var2;
        try {
            try {
                cls = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
            } catch (ClassNotFoundException unused) {
                cls = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
            }
            Class<?> cls2 = cls;
            qo0 qo0Var3 = new qo0(null, "setUseSessionTickets", Boolean.TYPE);
            qo0 qo0Var4 = new qo0(null, "setHostname", String.class);
            if (m6491u()) {
                qo0 qo0Var5 = new qo0(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                qo0Var2 = new qo0(null, "setAlpnProtocols", byte[].class);
                qo0Var = qo0Var5;
            } else {
                qo0Var = null;
                qo0Var2 = null;
            }
            return new mo0(cls2, qo0Var3, qo0Var4, qo0Var, qo0Var2);
        } catch (ClassNotFoundException unused2) {
            return null;
        }
    }

    /* renamed from: u */
    public static boolean m6491u() {
        if (Security.getProvider("GMSCore_OpenSSL") != null) {
            return true;
        }
        try {
            Class.forName("android.net.Network");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: c */
    public vo0 mo6492c(X509TrustManager x509TrustManager) {
        try {
            Class<?> cls = Class.forName("android.net.http.X509TrustManagerExtensions");
            return new C1564a(cls.getConstructor(X509TrustManager.class).newInstance(x509TrustManager), cls.getMethod("checkServerTrusted", X509Certificate[].class, String.class, String.class));
        } catch (Exception unused) {
            return super.mo6492c(x509TrustManager);
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: d */
    public TrustRootIndex mo6493d(X509TrustManager x509TrustManager) {
        try {
            Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", X509Certificate.class);
            declaredMethod.setAccessible(true);
            return new C1565b(x509TrustManager, declaredMethod);
        } catch (NoSuchMethodException unused) {
            return super.mo6493d(x509TrustManager);
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: g */
    public void mo6494g(SSLSocket sSLSocket, String str, List<vm0> list) {
        if (str != null) {
            this.f5110c.m7770e(sSLSocket, Boolean.TRUE);
            this.f5111d.m7770e(sSLSocket, str);
        }
        qo0<Socket> qo0Var = this.f5113f;
        if (qo0Var == null || !qo0Var.m7772g(sSLSocket)) {
            return;
        }
        this.f5113f.m7771f(sSLSocket, ro0.m8219e(list));
    }

    @Override // com.sonelli.ro0
    /* renamed from: h */
    public void mo6495h(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        try {
            socket.connect(inetSocketAddress, i);
        } catch (AssertionError e) {
            if (!fn0.m3810A(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (ClassCastException e2) {
            if (Build.VERSION.SDK_INT != 26) {
                throw e2;
            }
            IOException iOException = new IOException("Exception in connect");
            iOException.initCause(e2);
            throw iOException;
        } catch (SecurityException e3) {
            IOException iOException2 = new IOException("Exception in connect");
            iOException2.initCause(e3);
            throw iOException2;
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: k */
    public SSLContext mo6496k() {
        boolean z = true;
        try {
            int i = Build.VERSION.SDK_INT;
            if (i < 16 || i >= 22) {
                z = false;
            }
        } catch (NoClassDefFoundError unused) {
        }
        if (z) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused2) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    @Override // com.sonelli.ro0
    @Nullable
    /* renamed from: l */
    public String mo6497l(SSLSocket sSLSocket) {
        byte[] bArr;
        qo0<Socket> qo0Var = this.f5112e;
        if (qo0Var == null || !qo0Var.m7772g(sSLSocket) || (bArr = (byte[]) this.f5112e.m7771f(sSLSocket, new Object[0])) == null) {
            return null;
        }
        return new String(bArr, fn0.f2730i);
    }

    @Override // com.sonelli.ro0
    /* renamed from: m */
    public Object mo6498m(String str) {
        return this.f5114g.m6507a(str);
    }

    @Override // com.sonelli.ro0
    /* renamed from: n */
    public boolean mo6499n(String str) {
        try {
            Class<?> cls = Class.forName("android.security.NetworkSecurityPolicy");
            return m6503s(str, cls, cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return super.mo6499n(str);
        } catch (IllegalAccessException e) {
            e = e;
            throw fn0.m3821b("unable to determine cleartext support", e);
        } catch (IllegalArgumentException e2) {
            e = e2;
            throw fn0.m3821b("unable to determine cleartext support", e);
        } catch (InvocationTargetException e3) {
            e = e3;
            throw fn0.m3821b("unable to determine cleartext support", e);
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: p */
    public void mo6500p(int i, String str, @Nullable Throwable th) {
        int min;
        int i2 = i != 5 ? 3 : 5;
        if (th != null) {
            str = str + '\n' + Log.getStackTraceString(th);
        }
        int i3 = 0;
        int length = str.length();
        while (i3 < length) {
            int indexOf = str.indexOf(10, i3);
            if (indexOf == -1) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i3 + 4000);
                Log.println(i2, "OkHttp", str.substring(i3, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i3 = min;
                }
            }
            i3 = min + 1;
        }
    }

    @Override // com.sonelli.ro0
    /* renamed from: q */
    public void mo6501q(String str, Object obj) {
        if (this.f5114g.m6508c(obj)) {
            return;
        }
        mo6500p(5, str, null);
    }

    /* renamed from: r */
    public final boolean m6502r(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(obj, new Object[0])).booleanValue();
        } catch (NoSuchMethodException unused) {
            return super.mo6499n(str);
        }
    }

    /* renamed from: s */
    public final boolean m6503s(String str, Class<?> cls, Object obj) throws InvocationTargetException, IllegalAccessException {
        try {
            return ((Boolean) cls.getMethod("isCleartextTrafficPermitted", String.class).invoke(obj, str)).booleanValue();
        } catch (NoSuchMethodException unused) {
            return m6502r(str, cls, obj);
        }
    }
}
