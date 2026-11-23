package cz.opentree;

import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.j256.ormlite.stmt.query.SimpleComparison;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.bk */
/* loaded from: classes.dex */
public final class C0781bk extends AbstractC2303xn<C0781bk, b> implements zzgv {
    private static final C0781bk zzi;
    private static volatile zzhc<C0781bk> zzj;
    private int zzc;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.bk$a */
    /* loaded from: classes.dex */
    public enum a implements zzfn {
        UNKNOWN_COMPARISON_TYPE(0),
        LESS_THAN(1),
        GREATER_THAN(2),
        EQUAL(3),
        BETWEEN(4);


        /* renamed from: O */
        public final int f1759O;

        a(int i) {
            this.f1759O = i;
        }

        /* renamed from: f */
        public static a m2544f(int i) {
            if (i == 0) {
                return UNKNOWN_COMPARISON_TYPE;
            }
            if (i == 1) {
                return LESS_THAN;
            }
            if (i == 2) {
                return GREATER_THAN;
            }
            if (i == 3) {
                return EQUAL;
            }
            if (i != 4) {
                return null;
            }
            return BETWEEN;
        }

        /* renamed from: h */
        public static zzfp m2545h() {
            return C0994fk.f2701a;
        }

        @Override // com.google.android.gms.internal.measurement.zzfn
        /* renamed from: a */
        public final int mo1233a() {
            return this.f1759O;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f1759O + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.bk$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC2303xn.b<C0781bk, b> implements zzgv {
        public b() {
            super(C0781bk.zzi);
        }

        public /* synthetic */ b(C0943ek c0943ek) {
            this();
        }
    }

    static {
        C0781bk c0781bk = new C0781bk();
        zzi = c0781bk;
        AbstractC2303xn.m9837v(C0781bk.class, c0781bk);
    }

    /* renamed from: O */
    public static C0781bk m2532O() {
        return zzi;
    }

    /* renamed from: D */
    public final boolean m2534D() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: E */
    public final a m2535E() {
        a m2544f = a.m2544f(this.zzd);
        return m2544f == null ? a.UNKNOWN_COMPARISON_TYPE : m2544f;
    }

    /* renamed from: F */
    public final boolean m2536F() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: G */
    public final boolean m2537G() {
        return this.zze;
    }

    /* renamed from: H */
    public final boolean m2538H() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: I */
    public final String m2539I() {
        return this.zzf;
    }

    /* renamed from: J */
    public final boolean m2540J() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: L */
    public final String m2541L() {
        return this.zzg;
    }

    /* renamed from: M */
    public final boolean m2542M() {
        return (this.zzc & 16) != 0;
    }

    /* renamed from: N */
    public final String m2543N() {
        return this.zzh;
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C0781bk();
            case 2:
                return new b(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", a.m2545h(), "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                zzhc<C0781bk> zzhcVar = zzj;
                if (zzhcVar == null) {
                    synchronized (C0781bk.class) {
                        zzhcVar = zzj;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzi);
                            zzj = zzhcVar;
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
