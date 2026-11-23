package cz.opentree;

import com.google.android.gms.internal.measurement.zzjs;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ir */
/* loaded from: classes.dex */
public final class C1173ir implements zzjs {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f3397a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f3398b;

    /* renamed from: c */
    public static final AbstractC1559ml<Boolean> f3399c;

    /* renamed from: d */
    public static final AbstractC1559ml<Boolean> f3400d;

    /* renamed from: e */
    public static final AbstractC1559ml<Boolean> f3401e;

    /* renamed from: f */
    public static final AbstractC1559ml<Boolean> f3402f;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f3397a = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.format_logs", false);
        c1875sl.m8462b("measurement.id.gold.enhanced_ecommerce.service", 0L);
        f3398b = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true);
        f3399c = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", false);
        f3400d = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.updated_schema.client", true);
        f3401e = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.updated_schema.service", false);
        f3402f = c1875sl.m8464d("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", false);
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: a */
    public final boolean mo1368a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: b */
    public final boolean mo1369b() {
        return f3397a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: c */
    public final boolean mo1370c() {
        return f3398b.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: d */
    public final boolean mo1371d() {
        return f3399c.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: e */
    public final boolean mo1372e() {
        return f3400d.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: k */
    public final boolean mo1373k() {
        return f3401e.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzjs
    /* renamed from: m */
    public final boolean mo1374m() {
        return f3402f.m6459n().booleanValue();
    }
}
