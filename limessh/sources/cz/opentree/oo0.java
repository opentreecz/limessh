package cz.opentree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* compiled from: Jdk9Platform.java */
/* loaded from: classes.dex */
public final class oo0 extends ro0 {

    /* renamed from: c */
    public final Method f5526c;

    /* renamed from: d */
    public final Method f5527d;

    public oo0(Method method, Method method2) {
        this.f5526c = method;
        this.f5527d = method2;
    }

    /* renamed from: r */
    public static oo0 m7076r() {
        try {
            return new oo0(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    @Override // cz.opentree.ro0
    /* renamed from: g */
    public void mo6494g(SSLSocket sSLSocket, String str, List<vm0> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> m8218b = ro0.m8218b(list);
            this.f5526c.invoke(sSLParameters, m8218b.toArray(new String[m8218b.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fn0.m3821b("unable to set ssl parameters", e);
        }
    }

    @Override // cz.opentree.ro0
    @Nullable
    /* renamed from: l */
    public String mo6497l(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f5527d.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw fn0.m3821b("unable to get selected protocols", e);
        }
    }
}
