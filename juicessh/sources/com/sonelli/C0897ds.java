package com.sonelli;

import com.google.android.gms.internal.measurement.zzlb;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ds */
/* loaded from: classes.dex */
public final class C0897ds implements zzlb {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f2276a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f2277b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f2276a = c1875sl.m8464d("measurement.collection.efficient_engagement_reporting_enabled_2", true);
        f2277b = c1875sl.m8464d("measurement.collection.redundant_engagement_removal_enabled", false);
        c1875sl.m8462b("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    /* renamed from: a */
    public final boolean mo1395a() {
        return f2276a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlb
    /* renamed from: b */
    public final boolean mo1396b() {
        return f2277b.m6459n().booleanValue();
    }
}
