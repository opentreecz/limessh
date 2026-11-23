package cz.opentree;

import dagger.internal.Factory;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* renamed from: cz.opentree.e2 */
/* loaded from: classes.dex */
public final class C0908e2 implements Factory<Integer> {

    /* renamed from: a */
    public static final C0908e2 f2321a = new C0908e2();

    /* renamed from: a */
    public static C0908e2 m3381a() {
        return f2321a;
    }

    /* renamed from: c */
    public static int m3382c() {
        return AbstractC0805c2.m2656b();
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(m3382c());
    }
}
