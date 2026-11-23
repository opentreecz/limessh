package cz.opentree;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.Map;

/* loaded from: classes.dex */
public class i51 {

    /* renamed from: a */
    public static final ThreadLocal f3265a = new ThreadLocal();

    /* renamed from: cz.opentree.i51$a */
    /* loaded from: classes.dex */
    public static class C1144a implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ String f3266a;

        public C1144a(String str) {
            this.f3266a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return Security.getProperty(this.f3266a);
        }
    }

    /* renamed from: cz.opentree.i51$b */
    /* loaded from: classes.dex */
    public static class C1145b implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ String f3267a;

        public C1145b(String str) {
            this.f3267a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            return System.getProperty(this.f3267a);
        }
    }

    /* renamed from: a */
    public static String m4720a(String str) {
        String str2;
        String str3 = (String) AccessController.doPrivileged(new C1144a(str));
        if (str3 != null) {
            return str3;
        }
        Map map = (Map) f3265a.get();
        return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new C1145b(str)) : str2;
    }

    /* renamed from: b */
    public static boolean m4721b(String str) {
        try {
            return "true".equalsIgnoreCase(m4720a(str));
        } catch (AccessControlException unused) {
            return false;
        }
    }
}
