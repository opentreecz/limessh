package com.sonelli;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgt;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.1 */
/* renamed from: com.sonelli.gp */
/* loaded from: classes.dex */
public final class C1063gp implements zzgr {

    /* renamed from: a */
    public final zzgt f2963a;

    /* renamed from: b */
    public final String f2964b;

    /* renamed from: c */
    public final Object[] f2965c;

    /* renamed from: d */
    public final int f2966d;

    public C1063gp(zzgt zzgtVar, String str, Object[] objArr) {
        this.f2963a = zzgtVar;
        this.f2964b = str;
        this.f2965c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f2966d = charAt;
            return;
        }
        int i = charAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char charAt2 = str.charAt(i3);
            if (charAt2 < 55296) {
                this.f2966d = i | (charAt2 << i2);
                return;
            } else {
                i |= (charAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    /* renamed from: a */
    public final int mo1255a() {
        return (this.f2966d & 1) == 1 ? AbstractC2303xn.e.f8032i : AbstractC2303xn.e.f8033j;
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    /* renamed from: b */
    public final boolean mo1256b() {
        return (this.f2966d & 2) == 2;
    }

    @Override // com.google.android.gms.internal.measurement.zzgr
    /* renamed from: c */
    public final zzgt mo1257c() {
        return this.f2963a;
    }

    /* renamed from: d */
    public final String m4225d() {
        return this.f2964b;
    }

    /* renamed from: e */
    public final Object[] m4226e() {
        return this.f2965c;
    }
}
