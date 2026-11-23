package com.sonelli;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzhi;
import com.google.android.gms.internal.measurement.zzhl;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.po */
/* loaded from: classes.dex */
public final class C1728po implements zzhl {

    /* renamed from: b */
    public static final zzgq f5742b = new C1879so();

    /* renamed from: a */
    public final zzgq f5743a;

    public C1728po() {
        this(new C1828ro(C2362yn.m10194c(), m7430b()));
    }

    public C1728po(zzgq zzgqVar) {
        C2435zn.m10540f(zzgqVar, "messageInfoFactory");
        this.f5743a = zzgqVar;
    }

    /* renamed from: b */
    public static zzgq m7430b() {
        try {
            return (zzgq) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return f5742b;
        }
    }

    /* renamed from: c */
    public static boolean m7431c(zzgr zzgrVar) {
        return zzgrVar.mo1255a() == AbstractC2303xn.e.f8032i;
    }

    @Override // com.google.android.gms.internal.measurement.zzhl
    /* renamed from: a */
    public final <T> zzhi<T> mo1281a(Class<T> cls) {
        C1171ip.m4882p(cls);
        zzgr mo1254b = this.f5743a.mo1254b(cls);
        return mo1254b.mo1256b() ? AbstractC2303xn.class.isAssignableFrom(cls) ? C0791bp.m2590j(C1171ip.m4838B(), C1613nn.m6751a(), mo1254b.mo1257c()) : C0791bp.m2590j(C1171ip.m4872f(), C1613nn.m6752b(), mo1254b.mo1257c()) : AbstractC2303xn.class.isAssignableFrom(cls) ? m7431c(mo1254b) ? C0732ap.m2201q(cls, mo1254b, C0949ep.m3540b(), AbstractC1563mo.m6487c(), C1171ip.m4838B(), C1613nn.m6751a(), C2237wo.m9601b()) : C0732ap.m2201q(cls, mo1254b, C0949ep.m3540b(), AbstractC1563mo.m6487c(), C1171ip.m4838B(), null, C2237wo.m9601b()) : m7431c(mo1254b) ? C0732ap.m2201q(cls, mo1254b, C0949ep.m3539a(), AbstractC1563mo.m6486a(), C1171ip.m4872f(), C1613nn.m6752b(), C2237wo.m9600a()) : C0732ap.m2201q(cls, mo1254b, C0949ep.m3539a(), AbstractC1563mo.m6486a(), C1171ip.m4888v(), null, C2237wo.m9600a());
    }
}
