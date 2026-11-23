package cz.opentree;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.ok */
/* loaded from: classes.dex */
public final class C1661ok extends AbstractC2303xn<C1661ok, a> implements zzgv {
    private static final C1661ok zzf;
    private static volatile zzhc<C1661ok> zzg;
    private int zzc;
    private String zzd = "";
    private long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.ok$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1661ok, a> implements zzgv {
        public a() {
            super(C1661ok.zzf);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }
    }

    static {
        C1661ok c1661ok = new C1661ok();
        zzf = c1661ok;
        AbstractC2303xn.m9837v(C1661ok.class, c1661ok);
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1661ok();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzhc<C1661ok> zzhcVar = zzg;
                if (zzhcVar == null) {
                    synchronized (C1661ok.class) {
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
