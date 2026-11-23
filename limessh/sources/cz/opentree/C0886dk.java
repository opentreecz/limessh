package cz.opentree;

import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.j256.ormlite.stmt.query.SimpleComparison;
import cz.opentree.AbstractC2303xn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.dk */
/* loaded from: classes.dex */
public final class C0886dk extends AbstractC2303xn<C0886dk, a> implements zzgv {
    private static final C0886dk zzh;
    private static volatile zzhc<C0886dk> zzi;
    private int zzc;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private zzfq<String> zzg = AbstractC2303xn.m9831C();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.dk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C0886dk, a> implements zzgv {
        public a() {
            super(C0886dk.zzh);
        }

        public /* synthetic */ a(C0943ek c0943ek) {
            this();
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.dk$b */
    /* loaded from: classes.dex */
    public enum b implements zzfn {
        UNKNOWN_MATCH_TYPE(0),
        REGEXP(1),
        BEGINS_WITH(2),
        ENDS_WITH(3),
        PARTIAL(4),
        EXACT(5),
        IN_LIST(6);


        /* renamed from: O */
        public final int f2223O;

        b(int i) {
            this.f2223O = i;
        }

        /* renamed from: f */
        public static b m3243f(int i) {
            switch (i) {
                case 0:
                    return UNKNOWN_MATCH_TYPE;
                case 1:
                    return REGEXP;
                case 2:
                    return BEGINS_WITH;
                case 3:
                    return ENDS_WITH;
                case 4:
                    return PARTIAL;
                case 5:
                    return EXACT;
                case 6:
                    return IN_LIST;
                default:
                    return null;
            }
        }

        /* renamed from: h */
        public static zzfp m3244h() {
            return C1219jk.f3588a;
        }

        @Override // com.google.android.gms.internal.measurement.zzfn
        /* renamed from: a */
        public final int mo1233a() {
            return this.f2223O;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + b.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f2223O + " name=" + name() + '>';
        }
    }

    static {
        C0886dk c0886dk = new C0886dk();
        zzh = c0886dk;
        AbstractC2303xn.m9837v(C0886dk.class, c0886dk);
    }

    /* renamed from: M */
    public static C0886dk m3233M() {
        return zzh;
    }

    /* renamed from: D */
    public final boolean m3235D() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: E */
    public final b m3236E() {
        b m3243f = b.m3243f(this.zzd);
        return m3243f == null ? b.UNKNOWN_MATCH_TYPE : m3243f;
    }

    /* renamed from: F */
    public final boolean m3237F() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: G */
    public final String m3238G() {
        return this.zze;
    }

    /* renamed from: H */
    public final boolean m3239H() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: I */
    public final boolean m3240I() {
        return this.zzf;
    }

    /* renamed from: J */
    public final List<String> m3241J() {
        return this.zzg;
    }

    /* renamed from: L */
    public final int m3242L() {
        return this.zzg.size();
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C0886dk();
            case 2:
                return new a(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", b.m3244h(), "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                zzhc<C0886dk> zzhcVar = zzi;
                if (zzhcVar == null) {
                    synchronized (C0886dk.class) {
                        zzhcVar = zzi;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzh);
                            zzi = zzhcVar;
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
