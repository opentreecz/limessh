package com.sonelli;

import com.google.android.gms.internal.measurement.zzke;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.qr */
/* loaded from: classes.dex */
public final class C1781qr implements zzke {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f6080a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f6081b;

    /* renamed from: c */
    public static final AbstractC1559ml<Boolean> f6082c;

    /* renamed from: d */
    public static final AbstractC1559ml<Boolean> f6083d;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f6080a = c1875sl.m8464d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f6081b = c1875sl.m8464d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f6082c = c1875sl.m8464d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f6083d = c1875sl.m8464d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    /* renamed from: a */
    public final boolean mo1379a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    /* renamed from: b */
    public final boolean mo1380b() {
        return f6080a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    /* renamed from: c */
    public final boolean mo1381c() {
        return f6081b.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    /* renamed from: d */
    public final boolean mo1382d() {
        return f6082c.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzke
    /* renamed from: e */
    public final boolean mo1383e() {
        return f6083d.m6459n().booleanValue();
    }
}
