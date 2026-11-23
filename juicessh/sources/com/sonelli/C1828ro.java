package com.sonelli;

import com.google.android.gms.internal.measurement.zzgq;
import com.google.android.gms.internal.measurement.zzgr;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.ro */
/* loaded from: classes.dex */
public final class C1828ro implements zzgq {

    /* renamed from: a */
    public zzgq[] f6267a;

    public C1828ro(zzgq... zzgqVarArr) {
        this.f6267a = zzgqVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    /* renamed from: a */
    public final boolean mo1253a(Class<?> cls) {
        for (zzgq zzgqVar : this.f6267a) {
            if (zzgqVar.mo1253a(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzgq
    /* renamed from: b */
    public final zzgr mo1254b(Class<?> cls) {
        for (zzgq zzgqVar : this.f6267a) {
            if (zzgqVar.mo1253a(cls)) {
                return zzgqVar.mo1254b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
