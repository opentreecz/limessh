package com.sonelli;

import com.google.android.gms.internal.measurement.zzgm;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.xo */
/* loaded from: classes.dex */
public final class C2304xo implements zzgm {
    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: b */
    public final Map<?, ?> mo1245b(Object obj) {
        return (C2181vo) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: c */
    public final Object mo1246c(Object obj) {
        ((C2181vo) obj).m9331i();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: d */
    public final boolean mo1247d(Object obj) {
        return !((C2181vo) obj).m9332j();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: e */
    public final Map<?, ?> mo1248e(Object obj) {
        return (C2181vo) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: f */
    public final Object mo1249f(Object obj, Object obj2) {
        C2181vo c2181vo = (C2181vo) obj;
        C2181vo c2181vo2 = (C2181vo) obj2;
        if (!c2181vo2.isEmpty()) {
            if (!c2181vo.m9332j()) {
                c2181vo = c2181vo.m9330e();
            }
            c2181vo.m9329d(c2181vo2);
        }
        return c2181vo;
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: g */
    public final C1943to<?, ?> mo1250g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: h */
    public final Object mo1251h(Object obj) {
        return C2181vo.m9328c().m9330e();
    }

    @Override // com.google.android.gms.internal.measurement.zzgm
    /* renamed from: i */
    public final int mo1252i(int i, Object obj, Object obj2) {
        C2181vo c2181vo = (C2181vo) obj;
        if (c2181vo.isEmpty()) {
            return 0;
        }
        Iterator it = c2181vo.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
