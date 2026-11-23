package com.sonelli;

import com.google.android.gms.internal.measurement.zzja;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.wq */
/* loaded from: classes.dex */
public final class C2239wq implements zzja {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f7786a;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f7786a = c1875sl.m8464d("measurement.androidId.delete_feature", true);
        c1875sl.m8464d("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzja
    /* renamed from: a */
    public final boolean mo1326a() {
        return f7786a.m6459n().booleanValue();
    }
}
