package com.sonelli;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.ik */
/* loaded from: classes.dex */
public final class C1164ik extends AbstractC2303xn<C1164ik, a> implements zzgv {
    private static final C1164ik zzf;
    private static volatile zzhc<C1164ik> zzg;
    private int zzc;
    private String zzd = "";
    private String zze = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.ik$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1164ik, a> implements zzgv {
        public a() {
            super(C1164ik.zzf);
        }

        public /* synthetic */ a(C1461kk c1461kk) {
            this();
        }
    }

    static {
        C1164ik c1164ik = new C1164ik();
        zzf = c1164ik;
        AbstractC2303xn.m9837v(C1164ik.class, c1164ik);
    }

    /* renamed from: D */
    public final String m4785D() {
        return this.zzd;
    }

    /* renamed from: E */
    public final String m4786E() {
        return this.zze;
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C1461kk c1461kk = null;
        switch (C1461kk.f4581a[i - 1]) {
            case 1:
                return new C1164ik();
            case 2:
                return new a(c1461kk);
            case 3:
                return AbstractC2303xn.m9835t(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzhc<C1164ik> zzhcVar = zzg;
                if (zzhcVar == null) {
                    synchronized (C1164ik.class) {
                        zzhcVar = zzg;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzf);
                            zzg = zzhcVar;
                        }
                    }
                }
                return zzhcVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
