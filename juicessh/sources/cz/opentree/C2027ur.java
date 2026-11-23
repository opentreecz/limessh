package cz.opentree;

import com.google.android.gms.internal.measurement.zzkk;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ur */
/* loaded from: classes.dex */
public final class C2027ur implements zzkk {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f7093a;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f7093a = c1875sl.m8464d("measurement.sdk.referrer.delayed_install_referrer_api", false);
        c1875sl.m8462b("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzkk
    /* renamed from: a */
    public final boolean mo1385a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkk
    /* renamed from: b */
    public final boolean mo1386b() {
        return f7093a.m6459n().booleanValue();
    }
}
