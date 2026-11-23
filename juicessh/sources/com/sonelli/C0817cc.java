package com.sonelli;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* renamed from: com.sonelli.cc */
/* loaded from: classes.dex */
public final class C0817cc {
    @Deprecated
    /* renamed from: a */
    public static <T> List<T> m2756a() {
        return Collections.emptyList();
    }

    @Deprecated
    /* renamed from: b */
    public static <T> List<T> m2757b(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    /* renamed from: c */
    public static <T> List<T> m2758c(T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : m2757b(tArr[0]) : m2756a();
    }
}
