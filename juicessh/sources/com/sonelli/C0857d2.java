package com.sonelli;

import dagger.internal.Factory;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.d2 */
/* loaded from: classes.dex */
public final class C0857d2 implements Factory<String> {

    /* renamed from: a */
    public static final C0857d2 f2104a = new C0857d2();

    /* renamed from: a */
    public static C0857d2 m3101a() {
        return f2104a;
    }

    /* renamed from: b */
    public static String m3102b() {
        String m2655a = AbstractC0805c2.m2655a();
        fm0.m3809c(m2655a, "Cannot return null from a non-@Nullable @Provides method");
        return m2655a;
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return m3102b();
    }
}
