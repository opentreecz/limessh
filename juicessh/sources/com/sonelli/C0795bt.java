package com.sonelli;

import com.google.android.gms.internal.measurement.zzmg;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.bt */
/* loaded from: classes.dex */
public final class C0795bt implements zzmg {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f1819a;

    /* renamed from: b */
    public static final AbstractC1559ml<Double> f1820b;

    /* renamed from: c */
    public static final AbstractC1559ml<Long> f1821c;

    /* renamed from: d */
    public static final AbstractC1559ml<Long> f1822d;

    /* renamed from: e */
    public static final AbstractC1559ml<String> f1823e;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f1819a = c1875sl.m8464d("measurement.test.boolean_flag", false);
        f1820b = c1875sl.m8461a("measurement.test.double_flag", -3.0d);
        f1821c = c1875sl.m8462b("measurement.test.int_flag", -2L);
        f1822d = c1875sl.m8462b("measurement.test.long_flag", -1L);
        f1823e = c1875sl.m8463c("measurement.test.string_flag", "---");
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    /* renamed from: a */
    public final boolean mo1417a() {
        return f1819a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    /* renamed from: b */
    public final double mo1418b() {
        return f1820b.m6459n().doubleValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    /* renamed from: c */
    public final long mo1419c() {
        return f1821c.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    /* renamed from: d */
    public final long mo1420d() {
        return f1822d.m6459n().longValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzmg
    /* renamed from: e */
    public final String mo1421e() {
        return f1823e.m6459n();
    }
}
