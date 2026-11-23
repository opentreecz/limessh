package com.sonelli;

import com.google.android.gms.internal.measurement.zzlz;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.ts */
/* loaded from: classes.dex */
public final class C1947ts implements zzlz {

    /* renamed from: a */
    public static final AbstractC1559ml<Long> f6822a;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        c1875sl.m8462b("measurement.id.max_bundles_per_iteration", 0L);
        f6822a = c1875sl.m8462b("measurement.max_bundles_per_iteration", 2L);
    }

    @Override // com.google.android.gms.internal.measurement.zzlz
    /* renamed from: a */
    public final long mo1414a() {
        return f6822a.m6459n().longValue();
    }
}
