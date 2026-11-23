package cz.opentree;

import com.google.android.gms.internal.measurement.zzli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ks */
/* loaded from: classes.dex */
public final class C1471ks implements zzli {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f4644a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f4645b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f4644a = c1875sl.m8464d("measurement.client.global_params.dev", false);
        f4645b = c1875sl.m8464d("measurement.service.global_params", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    /* renamed from: a */
    public final boolean mo1400a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    /* renamed from: b */
    public final boolean mo1401b() {
        return f4644a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzli
    /* renamed from: c */
    public final boolean mo1402c() {
        return f4645b.m6459n().booleanValue();
    }
}
