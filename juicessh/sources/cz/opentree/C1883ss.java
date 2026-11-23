package cz.opentree;

import com.google.android.gms.internal.measurement.zzlu;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ss */
/* loaded from: classes.dex */
public final class C1883ss implements zzlu {

    /* renamed from: a */
    public static final AbstractC1559ml<Boolean> f6589a;

    /* renamed from: b */
    public static final AbstractC1559ml<Boolean> f6590b;

    static {
        C1875sl c1875sl = new C1875sl(C1611nl.m6734a("com.google.android.gms.measurement"));
        f6589a = c1875sl.m8464d("measurement.sdk.screen.manual_screen_view_logging", true);
        f6590b = c1875sl.m8464d("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    /* renamed from: a */
    public final boolean mo1411a() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    /* renamed from: b */
    public final boolean mo1412b() {
        return f6589a.m6459n().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zzlu
    /* renamed from: c */
    public final boolean mo1413c() {
        return f6590b.m6459n().booleanValue();
    }
}
