package com.amazonaws.util;

/* loaded from: classes.dex */
public enum ClassLoaderHelper {
    ;

    /* renamed from: f */
    public static Class<?> m647f(String str, boolean z, Class<?>... clsArr) throws ClassNotFoundException {
        Class<?> m650l;
        if (z) {
            m650l = m649k(str, clsArr);
            if (m650l == null) {
                m650l = m650l(str);
            }
        } else {
            m650l = m650l(str);
            if (m650l == null) {
                m650l = m649k(str, clsArr);
            }
        }
        return m650l == null ? Class.forName(str) : m650l;
    }

    /* renamed from: h */
    public static Class<?> m648h(String str, Class<?>... clsArr) throws ClassNotFoundException {
        return m647f(str, true, clsArr);
    }

    /* renamed from: k */
    public static Class<?> m649k(String str, Class<?>[] clsArr) {
        if (clsArr == null) {
            return null;
        }
        for (Class<?> cls : clsArr) {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader != null) {
                try {
                    return classLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                    continue;
                }
            }
        }
        return null;
    }

    /* renamed from: l */
    public static Class<?> m650l(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }
        return contextClassLoader.loadClass(str);
    }
}
