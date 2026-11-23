package com.sonelli;

import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public class wu0 {

    /* renamed from: com.sonelli.wu0$a */
    /* loaded from: classes.dex */
    public static class C2244a implements PrivilegedAction {

        /* renamed from: a */
        public final /* synthetic */ String f7798a;

        public C2244a(String str) {
            this.f7798a = str;
        }

        @Override // java.security.PrivilegedAction
        public Object run() {
            try {
                return Class.forName(this.f7798a);
            } catch (Exception unused) {
                return null;
            }
        }
    }

    /* renamed from: a */
    public static Class m9642a(Class cls, String str) {
        try {
            ClassLoader classLoader = cls.getClassLoader();
            return classLoader != null ? classLoader.loadClass(str) : (Class) AccessController.doPrivileged(new C2244a(str));
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
