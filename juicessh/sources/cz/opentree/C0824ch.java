package cz.opentree;

import com.google.android.gms.common.config.GservicesValue;

/* renamed from: cz.opentree.ch */
/* loaded from: classes.dex */
public final class C0824ch<V> {

    /* renamed from: a */
    public final V f1942a;

    public C0824ch(GservicesValue<V> gservicesValue, V v) {
        C0813ca.m2729k(gservicesValue);
        this.f1942a = v;
    }

    /* renamed from: b */
    public static C0824ch<Float> m2796b(String str, float f, float f2) {
        Float valueOf = Float.valueOf(0.5f);
        return new C0824ch<>(GservicesValue.m1024a(str, valueOf), valueOf);
    }

    /* renamed from: c */
    public static C0824ch<Integer> m2797c(String str, int i, int i2) {
        return new C0824ch<>(GservicesValue.m1025b(str, Integer.valueOf(i2)), Integer.valueOf(i));
    }

    /* renamed from: d */
    public static C0824ch<Long> m2798d(String str, long j, long j2) {
        return new C0824ch<>(GservicesValue.m1026c(str, Long.valueOf(j2)), Long.valueOf(j));
    }

    /* renamed from: e */
    public static C0824ch<String> m2799e(String str, String str2, String str3) {
        return new C0824ch<>(GservicesValue.m1027d(str, str3), str2);
    }

    /* renamed from: f */
    public static C0824ch<Boolean> m2800f(String str, boolean z, boolean z2) {
        return new C0824ch<>(GservicesValue.m1028e(str, z2), Boolean.valueOf(z));
    }

    /* renamed from: a */
    public final V m2801a() {
        return this.f1942a;
    }
}
