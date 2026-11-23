package cz.opentree;

import com.google.android.gms.internal.measurement.zzjr;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.fr */
/* loaded from: classes.dex */
public final class C1010fr implements zzjr {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f2763a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f2764b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f2763a = c1875sl.m8464d("measurement.sdk.dynamite.allow_remote_dynamite", false);
        c1875sl.m8464d("measurement.collection.init_params_control_enabled", true);
        f2764b = c1875sl.m8464d("measurement.sdk.dynamite.use_dynamite3", true);
        c1875sl.m8462b("measurement.id.sdk.dynamite.use_dynamite", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    /* renamed from: a */
    public final boolean mo1366a() {
        return f2763a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjr
    /* renamed from: b */
    public final boolean mo1367b() {
        return f2764b.m6459n().booleanValue();
    }
}
