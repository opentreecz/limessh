package com.sonelli;

import dagger.internal.Factory;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: com.sonelli.g0 */
/* loaded from: classes.dex */
public final class C1020g0 implements Factory<Executor> {

    /* renamed from: a */
    public static final C1020g0 f2791a = new C1020g0();

    /* renamed from: a */
    public static C1020g0 m3901a() {
        return f2791a;
    }

    /* renamed from: b */
    public static Executor m3902b() {
        Executor m3624a = AbstractC0963f0.m3624a();
        fm0.m3809c(m3624a, "Cannot return null from a non-@Nullable @Provides method");
        return m3624a;
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return m3902b();
    }
}
