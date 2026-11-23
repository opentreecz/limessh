package com.sonelli;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: ReflectionUtils.java */
/* loaded from: classes.dex */
public class cm0 {

    /* renamed from: a */
    public static final Logger f1991a = Logger.getLogger(cm0.class.getName());

    /* renamed from: b */
    public static final Method f1992b;

    /* renamed from: c */
    public static final Method f1993c;

    /* renamed from: d */
    public static final Method f1994d;

    /* renamed from: e */
    public static final Method f1995e;

    /* renamed from: f */
    public static final Method f1996f;

    /* renamed from: g */
    public static final Method f1997g;

    /* renamed from: h */
    public static final Method f1998h;

    /* renamed from: i */
    public static final Method f1999i;

    /* renamed from: j */
    public static final Method f2000j;

    /* renamed from: k */
    public static Constructor f2001k;

    static {
        Class m2877g = m2877g("java.lang.invoke.MethodHandles");
        Class m2877g2 = m2877g("java.lang.invoke.MethodHandle");
        Class m2877g3 = m2877g("java.lang.invoke.MethodHandles$Lookup");
        Class m2877g4 = m2877g("java.lang.invoke.MethodType");
        f1992b = m2879i(Method.class, "isDefault", new Class[0]);
        f1993c = m2879i(m2877g, "lookup", new Class[0]);
        f1994d = m2879i(m2877g3, "in", Class.class);
        f1996f = m2879i(m2877g3, "unreflectSpecial", Method.class, Class.class);
        f1997g = m2879i(m2877g3, "findSpecial", Class.class, String.class, m2877g4, Class.class);
        f1998h = m2879i(m2877g2, "bindTo", Object.class);
        f1999i = m2879i(m2877g2, "invokeWithArguments", Object[].class);
        f1995e = m2879i(m2877g, "privateLookupIn", Class.class, m2877g3);
        f2000j = m2879i(m2877g4, "methodType", Class.class, Class[].class);
    }

    /* renamed from: a */
    public static Object m2871a() throws Exception {
        return f1993c.invoke(null, new Object[0]);
    }

    /* renamed from: b */
    public static Object m2872b(Class cls, Object obj) throws Exception {
        return f1995e.invoke(null, cls, obj);
    }

    /* renamed from: c */
    public static Constructor m2873c() {
        if (f2001k == null) {
            f2001k = m2878h(m2877g("java.lang.invoke.MethodHandles$Lookup"), Class.class);
        }
        return f2001k;
    }

    /* renamed from: d */
    public static Object m2874d(Method method) throws Exception {
        try {
            return m2880j(m2872b(method.getDeclaringClass(), m2871a()), method);
        } catch (Exception unused) {
            return m2881k(m2873c().newInstance(method.getDeclaringClass()), method);
        }
    }

    /* renamed from: e */
    public static Object m2875e(Object obj, Object obj2, Object... objArr) throws Throwable {
        return f1999i.invoke(f1998h.invoke(obj2, obj), objArr);
    }

    /* renamed from: f */
    public static boolean m2876f(Method method) {
        Method method2 = f1992b;
        if (method2 == null) {
            return false;
        }
        try {
            return ((Boolean) method2.invoke(method, new Object[0])).booleanValue();
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    /* renamed from: g */
    public static Class m2877g(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            f1991a.log(Level.FINE, "Failed to lookup class: " + str, (Throwable) e);
            return null;
        }
    }

    /* renamed from: h */
    public static Constructor m2878h(Class cls, Class... clsArr) {
        if (cls == null) {
            f1991a.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{cls, Arrays.toString(clsArr)});
            return null;
        }
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (Exception unused) {
            f1991a.log(Level.FINE, "Failed to lookup method: <init>#{1}({2})", new Object[]{cls, Arrays.toString(clsArr)});
            return null;
        }
    }

    /* renamed from: i */
    public static Method m2879i(Class cls, String str, Class... clsArr) {
        if (cls == null) {
            f1991a.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{cls, str, Arrays.toString(clsArr)});
            return null;
        }
        try {
            return cls.getMethod(str, clsArr);
        } catch (Exception unused) {
            f1991a.log(Level.FINE, "Failed to lookup method: {0}#{1}({2})", new Object[]{cls, str, Arrays.toString(clsArr)});
            return null;
        }
    }

    /* renamed from: j */
    public static Object m2880j(Object obj, Method method) throws Exception {
        return f1997g.invoke(obj, method.getDeclaringClass(), method.getName(), f2000j.invoke(null, method.getReturnType(), method.getParameterTypes()), method.getDeclaringClass());
    }

    /* renamed from: k */
    public static Object m2881k(Object obj, Method method) throws Exception {
        return f1996f.invoke(f1994d.invoke(obj, method.getDeclaringClass()), method, method.getDeclaringClass());
    }
}
