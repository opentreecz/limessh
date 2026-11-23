package cz.opentree;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;

/* compiled from: JdkWithJettyBootPlatform.java */
/* loaded from: classes.dex */
public class po0 extends ro0 {

    /* renamed from: c */
    public final Method f5744c;

    /* renamed from: d */
    public final Method f5745d;

    /* renamed from: e */
    public final Method f5746e;

    /* renamed from: f */
    public final Class<?> f5747f;

    /* renamed from: g */
    public final Class<?> f5748g;

    /* compiled from: JdkWithJettyBootPlatform.java */
    /* renamed from: cz.opentree.po0$a */
    /* loaded from: classes.dex */
    public static class C1729a implements InvocationHandler {

        /* renamed from: a */
        public final List<String> f5749a;

        /* renamed from: b */
        public boolean f5750b;

        /* renamed from: c */
        public String f5751c;

        public C1729a(List<String> list) {
            this.f5749a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = fn0.f2723b;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.f5750b = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.f5749a;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.f5751c = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.f5749a.contains(list.get(i))) {
                    String str = (String) list.get(i);
                    this.f5751c = str;
                    return str;
                }
            }
            String str2 = this.f5749a.get(0);
            this.f5751c = str2;
            return str2;
        }
    }

    public po0(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
        this.f5744c = method;
        this.f5745d = method2;
        this.f5746e = method3;
        this.f5747f = cls;
        this.f5748g = cls2;
    }

    /* renamed from: r */
    public static ro0 m7432r() {
        try {
            Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN");
            Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
            return new po0(cls.getMethod("put", SSLSocket.class, cls2), cls.getMethod("get", SSLSocket.class), cls.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // cz.opentree.ro0
    /* renamed from: a */
    public void mo7433a(SSLSocket sSLSocket) {
        try {
            this.f5746e.invoke(null, sSLSocket);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fn0.m3821b("unable to remove alpn", e);
        }
    }

    @Override // cz.opentree.ro0
    /* renamed from: g */
    public void mo6494g(SSLSocket sSLSocket, String str, List<vm0> list) {
        try {
            this.f5744c.invoke(null, sSLSocket, Proxy.newProxyInstance(ro0.class.getClassLoader(), new Class[]{this.f5747f, this.f5748g}, new C1729a(ro0.m8218b(list))));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fn0.m3821b("unable to set alpn", e);
        }
    }

    @Override // cz.opentree.ro0
    @Nullable
    /* renamed from: l */
    public String mo6497l(SSLSocket sSLSocket) {
        try {
            C1729a c1729a = (C1729a) Proxy.getInvocationHandler(this.f5745d.invoke(null, sSLSocket));
            boolean z = c1729a.f5750b;
            if (!z && c1729a.f5751c == null) {
                ro0.m8221j().mo6500p(4, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", null);
                return null;
            }
            if (z) {
                return null;
            }
            return c1729a.f5751c;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fn0.m3821b("unable to get selected protocol", e);
        }
    }
}
