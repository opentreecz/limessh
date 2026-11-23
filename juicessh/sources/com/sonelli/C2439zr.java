package com.sonelli;

import com.google.android.gms.internal.measurement.zzkv;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.zr */
/* loaded from: classes.dex */
public final class C2439zr implements zzkv {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f8583a;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f8583a = c1875sl.m8464d("measurement.client.sessions.check_on_reset_and_enable2", true);
        c1875sl.m8464d("measurement.client.sessions.check_on_startup", true);
        c1875sl.m8464d("measurement.client.sessions.start_session_before_view_screen", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzkv
    /* renamed from: a */
    public final boolean mo1391a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzkv
    /* renamed from: b */
    public final boolean mo1392b() {
        return f8583a.m6459n().booleanValue();
    }
}
