package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.nn */
/* loaded from: classes.dex */
public final class C1613nn {

    /* renamed from: a */
    public static final AbstractC1562mn<?> f5325a = new C1664on();

    /* renamed from: b */
    public static final AbstractC1562mn<?> f5326b = m6753c();

    /* renamed from: a */
    public static AbstractC1562mn<?> m6751a() {
        return f5325a;
    }

    /* renamed from: b */
    public static AbstractC1562mn<?> m6752b() {
        AbstractC1562mn<?> abstractC1562mn = f5326b;
        if (abstractC1562mn != null) {
            return abstractC1562mn;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    /* renamed from: c */
    public static AbstractC1562mn<?> m6753c() {
        try {
            return (AbstractC1562mn) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
