package com.sonelli;

import com.google.android.gms.internal.measurement.zzkd;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.nr */
/* loaded from: classes.dex */
public final class C1618nr implements zzkd {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f5355a = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement")).m8464d("measurement.client.firebase_feature_rollout.v1.enable", true);

    @Override // com.google.android.gms.internal.measurement.zzkd
    /* renamed from: a */
    public final boolean mo1377a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkd
    /* renamed from: b */
    public final boolean mo1378b() {
        return f5355a.m6459n().booleanValue();
    }
}
