package cz.opentree;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: OptionalMethod.java */
/* loaded from: classes.dex */
public class qo0<T> {

    /* renamed from: a */
    public final Class<?> f6062a;

    /* renamed from: b */
    public final String f6063b;

    /* renamed from: c */
    public final Class[] f6064c;

    public qo0(Class<?> cls, String str, Class... clsArr) {
        this.f6062a = cls;
        this.f6063b = str;
        this.f6064c = clsArr;
    }

    /* renamed from: b */
    public static Method m7766b(Class<?> cls, String str, Class[] clsArr) {
        try {
            Method method = cls.getMethod(str, clsArr);
            try {
                if ((method.getModifiers() & 1) == 0) {
                    return null;
                }
            } catch (NoSuchMethodException unused) {
            }
            return method;
        } catch (NoSuchMethodException unused2) {
            return null;
        }
    }

    /* renamed from: a */
    public final Method m7767a(Class<?> cls) {
        Class<?> cls2;
        String str = this.f6063b;
        if (str == null) {
            return null;
        }
        Method m7766b = m7766b(cls, str, this.f6064c);
        if (m7766b == null || (cls2 = this.f6062a) == null || cls2.isAssignableFrom(m7766b.getReturnType())) {
            return m7766b;
        }
        return null;
    }

    /* renamed from: c */
    public Object m7768c(T t, Object... objArr) throws InvocationTargetException {
        Method m7767a = m7767a(t.getClass());
        if (m7767a == null) {
            throw new AssertionError("Method " + this.f6063b + " not supported for object " + t);
        }
        try {
            return m7767a.invoke(t, objArr);
        } catch (IllegalAccessException e) {
            AssertionError assertionError = new AssertionError("Unexpectedly could not call: " + m7767a);
            assertionError.initCause(e);
            throw assertionError;
        }
    }

    /* renamed from: d */
    public Object m7769d(T t, Object... objArr) throws InvocationTargetException {
        Method m7767a = m7767a(t.getClass());
        if (m7767a == null) {
            return null;
        }
        try {
            return m7767a.invoke(t, objArr);
        } catch (IllegalAccessException unused) {
            return null;
        }
    }

    /* renamed from: e */
    public Object m7770e(T t, Object... objArr) {
        try {
            return m7769d(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: f */
    public Object m7771f(T t, Object... objArr) {
        try {
            return m7768c(t, objArr);
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof RuntimeException) {
                throw ((RuntimeException) targetException);
            }
            AssertionError assertionError = new AssertionError("Unexpected exception");
            assertionError.initCause(targetException);
            throw assertionError;
        }
    }

    /* renamed from: g */
    public boolean m7772g(T t) {
        return m7767a(t.getClass()) != null;
    }
}
