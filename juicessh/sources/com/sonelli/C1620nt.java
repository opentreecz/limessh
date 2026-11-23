package com.sonelli;

import com.google.android.gms.internal.measurement.zzmy;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.nt */
/* loaded from: classes.dex */
public final class C1620nt implements zzmy {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f5362a = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement")).m8464d("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.zzmy
    /* renamed from: a */
    public final boolean mo1428a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzmy
    /* renamed from: b */
    public final boolean mo1429b() {
        return f5362a.m6459n().booleanValue();
    }
}
