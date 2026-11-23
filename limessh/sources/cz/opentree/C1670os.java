package cz.opentree;

import com.google.android.gms.internal.measurement.zzlo;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.os */
/* loaded from: classes.dex */
public final class C1670os implements zzlo {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f5537a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f5538b;

    /* renamed from: c */
    public static final AbstractC1559ml<Boolean> f5539c;

    /* renamed from: d */
    public static final AbstractC1559ml<Boolean> f5540d;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f5537a = c1875sl.m8464d("measurement.sdk.collection.enable_extend_user_property_size", true);
        f5538b = c1875sl.m8464d("measurement.sdk.collection.last_deep_link_referrer2", true);
        f5539c = c1875sl.m8464d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        f5540d = c1875sl.m8464d("measurement.sdk.collection.last_gclid_from_referrer2", false);
        c1875sl.m8462b("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    /* renamed from: a */
    public final boolean mo1404a() {
        return f5537a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    /* renamed from: b */
    public final boolean mo1405b() {
        return f5538b.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    /* renamed from: c */
    public final boolean mo1406c() {
        return f5539c.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlo
    /* renamed from: d */
    public final boolean mo1407d() {
        return f5540d.m6459n().booleanValue();
    }
}
