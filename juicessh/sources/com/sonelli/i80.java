package com.sonelli;

import java.util.Objects;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes.dex */
public final class i80 {
    /* renamed from: a */
    public static void m4726a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: b */
    public static <T> T m4727b(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    /* renamed from: c */
    public static <T> T m4728c(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* renamed from: d */
    public static void m4729d(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
