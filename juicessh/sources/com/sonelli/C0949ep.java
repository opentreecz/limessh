package com.sonelli;

import com.google.android.gms.internal.measurement.zzhb;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ep */
/* loaded from: classes.dex */
public final class C0949ep {

    /* renamed from: a */
    public static final zzhb f2519a = m3541c();

    /* renamed from: b */
    public static final zzhb f2520b = new C0894dp();

    /* renamed from: a */
    public static zzhb m3539a() {
        return f2519a;
    }

    /* renamed from: b */
    public static zzhb m3540b() {
        return f2520b;
    }

    /* renamed from: c */
    public static zzhb m3541c() {
        try {
            return (zzhb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
