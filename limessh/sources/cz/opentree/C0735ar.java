package cz.opentree;

import com.google.android.gms.internal.measurement.zzjg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ar */
/* loaded from: classes.dex */
public final class C0735ar implements zzjg {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f1514a;

    /* renamed from: b */
    public static final AbstractC1559ml<Long> f1515b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f1514a = c1875sl.m8464d("measurement.sdk.attribution.cache", true);
        f1515b = c1875sl.m8462b("measurement.sdk.attribution.cache.ttl", 604800000L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    /* renamed from: a */
    public final boolean mo1328a() {
        return f1514a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjg
    /* renamed from: b */
    public final long mo1329b() {
        return f1515b.m6459n().longValue();
    }
}
