package cz.opentree;

import com.google.android.gms.internal.measurement.zzgm;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: cz.opentree.wo */
/* loaded from: classes.dex */
public final class C2237wo {

    /* renamed from: a */
    public static final zzgm f7780a = m9602c();

    /* renamed from: b */
    public static final zzgm f7781b = new C2304xo();

    /* renamed from: a */
    public static zzgm m9600a() {
        return f7780a;
    }

    /* renamed from: b */
    public static zzgm m9601b() {
        return f7781b;
    }

    /* renamed from: c */
    public static zzgm m9602c() {
        try {
            return (zzgm) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
