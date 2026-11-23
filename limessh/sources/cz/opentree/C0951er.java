package cz.opentree;

import com.google.android.gms.internal.measurement.zzjm;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.er */
/* loaded from: classes.dex */
public final class C0951er implements zzjm {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f2526a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f2527b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f2526a = c1875sl.m8464d("measurement.service.configurable_service_limits", false);
        f2527b = c1875sl.m8464d("measurement.client.configurable_service_limits", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    /* renamed from: a */
    public final boolean mo1363a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    /* renamed from: b */
    public final boolean mo1364b() {
        return f2526a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjm
    /* renamed from: c */
    public final boolean mo1365c() {
        return f2527b.m6459n().booleanValue();
    }
}
