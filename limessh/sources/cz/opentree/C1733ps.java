package cz.opentree;

import com.google.android.gms.internal.measurement.zzlt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ps */
/* loaded from: classes.dex */
public final class C1733ps implements zzlt {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f5760a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f5761b;

    /* renamed from: c */
    public static final AbstractC1559ml<Boolean> f5762c;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        c1875sl.m8462b("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f5760a = c1875sl.m8464d("measurement.lifecycle.app_backgrounded_engagement", false);
        f5761b = c1875sl.m8464d("measurement.lifecycle.app_backgrounded_tracking", true);
        f5762c = c1875sl.m8464d("measurement.lifecycle.app_in_background_parameter", false);
        c1875sl.m8462b("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    /* renamed from: a */
    public final boolean mo1408a() {
        return f5760a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    /* renamed from: b */
    public final boolean mo1409b() {
        return f5761b.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlt
    /* renamed from: c */
    public final boolean mo1410c() {
        return f5762c.m6459n().booleanValue();
    }
}
