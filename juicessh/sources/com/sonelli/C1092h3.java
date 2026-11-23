package com.sonelli;

import com.google.android.datatransport.runtime.time.Clock;
import dagger.internal.Factory;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.h3 */
/* loaded from: classes.dex */
public final class C1092h3 implements Factory<Clock> {

    /* renamed from: a */
    public static final C1092h3 f3082a = new C1092h3();

    /* renamed from: a */
    public static C1092h3 m4344a() {
        return f3082a;
    }

    /* renamed from: b */
    public static Clock m4345b() {
        Clock m3969a = AbstractC1023g3.m3969a();
        fm0.m3809c(m3969a, "Cannot return null from a non-@Nullable @Provides method");
        return m3969a;
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Clock get() {
        return m4345b();
    }
}
