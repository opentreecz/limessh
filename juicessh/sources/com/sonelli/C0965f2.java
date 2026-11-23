package com.sonelli;

import dagger.internal.Factory;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.f2 */
/* loaded from: classes.dex */
public final class C0965f2 implements Factory<AbstractC0749b2> {

    /* renamed from: a */
    public static final C0965f2 f2597a = new C0965f2();

    /* renamed from: a */
    public static C0965f2 m3657a() {
        return f2597a;
    }

    /* renamed from: c */
    public static AbstractC0749b2 m3658c() {
        AbstractC0749b2 m2657c = AbstractC0805c2.m2657c();
        fm0.m3809c(m2657c, "Cannot return null from a non-@Nullable @Provides method");
        return m2657c;
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AbstractC0749b2 get() {
        return m3658c();
    }
}
