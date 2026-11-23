package com.google.android.gms.common.config;

import cz.opentree.C0916e9;
import cz.opentree.C0974f9;
import cz.opentree.C1031g9;
import cz.opentree.C1098h9;
import cz.opentree.C1150i9;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {

    /* renamed from: a */
    public final T f756a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface zza {
    }

    public GservicesValue(String str, T t) {
        this.f756a = t;
    }

    /* renamed from: a */
    public static GservicesValue<Float> m1024a(String str, Float f) {
        return new C1150i9(str, f);
    }

    /* renamed from: b */
    public static GservicesValue<Integer> m1025b(String str, Integer num) {
        return new C0974f9(str, num);
    }

    /* renamed from: c */
    public static GservicesValue<Long> m1026c(String str, Long l) {
        return new C1031g9(str, l);
    }

    /* renamed from: d */
    public static GservicesValue<String> m1027d(String str, String str2) {
        return new C1098h9(str, str2);
    }

    /* renamed from: e */
    public static GservicesValue<Boolean> m1028e(String str, boolean z) {
        return new C0916e9(str, Boolean.valueOf(z));
    }
}
