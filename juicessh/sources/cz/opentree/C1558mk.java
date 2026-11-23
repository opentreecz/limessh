package cz.opentree;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.mk */
/* loaded from: classes.dex */
public final class C1558mk extends AbstractC2303xn<C1558mk, a> implements zzgv {
    private static final C1558mk zzf;
    private static volatile zzhc<C1558mk> zzg;
    private int zzc;
    private int zzd;
    private long zze;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.mk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1558mk, a> implements zzgv {
        public a() {
            super(C1558mk.zzf);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: v */
        public final a m6442v(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1558mk) this.f8022P).m6436D(i);
            return this;
        }

        /* renamed from: w */
        public final a m6443w(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1558mk) this.f8022P).m6437E(j);
            return this;
        }
    }

    static {
        C1558mk c1558mk = new C1558mk();
        zzf = c1558mk;
        AbstractC2303xn.m9837v(C1558mk.class, c1558mk);
    }

    /* renamed from: M */
    public static a m6434M() {
        return zzf.m9839y();
    }

    /* renamed from: D */
    public final void m6436D(int i) {
        this.zzc |= 1;
        this.zzd = i;
    }

    /* renamed from: E */
    public final void m6437E(long j) {
        this.zzc |= 2;
        this.zze = j;
    }

    /* renamed from: H */
    public final boolean m6438H() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: I */
    public final int m6439I() {
        return this.zzd;
    }

    /* renamed from: J */
    public final boolean m6440J() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: L */
    public final long m6441L() {
        return this.zze;
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1558mk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzhc<C1558mk> zzhcVar = zzg;
                if (zzhcVar == null) {
                    synchronized (C1558mk.class) {
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
