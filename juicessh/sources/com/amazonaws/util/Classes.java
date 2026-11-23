package com.amazonaws.util;

/* loaded from: classes.dex */
public enum Classes {
    ;

    /* renamed from: f */
    public static Class<?> m651f(Class<?> cls, Object obj) {
        if (obj == null || obj == Object.class) {
            return null;
        }
        if (cls != null && cls.isInterface()) {
            return null;
        }
        Class<?> cls2 = obj.getClass();
        while (true) {
            Class<? super Object> superclass = cls2.getSuperclass();
            if (superclass == cls) {
                return cls2;
            }
            if (superclass == null) {
                return null;
            }
            cls2 = superclass;
        }
    }
}
