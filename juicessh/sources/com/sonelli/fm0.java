package com.sonelli;

import java.util.Objects;

/* compiled from: Preconditions.java */
/* loaded from: classes.dex */
public final class fm0 {
    /* renamed from: a */
    public static <T> void m3807a(T t, Class<T> cls) {
        if (t != null) {
            return;
        }
        throw new IllegalStateException(cls.getCanonicalName() + " must be set");
    }

    /* renamed from: b */
    public static <T> T m3808b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* renamed from: c */
    public static <T> T m3809c(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }
}
