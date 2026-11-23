package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;
import cz.opentree.C1046gk;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.hk */
/* loaded from: classes.dex */
public final class C1113hk extends AbstractC2303xn<C1113hk, a> implements zzgv {
    private static final C1113hk zzl;
    private static volatile zzhc<C1113hk> zzm;
    private int zzc;
    private long zzd;
    private int zzf;
    private boolean zzk;
    private String zze = "";
    private zzfq<C1164ik> zzg = AbstractC2303xn.m9831C();
    private zzfq<C1046gk> zzh = AbstractC2303xn.m9831C();
    private zzfq<C2356yj> zzi = AbstractC2303xn.m9831C();
    private String zzj = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.hk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1113hk, a> implements zzgv {
        public a() {
            super(C1113hk.zzl);
        }

        public /* synthetic */ a(C1461kk c1461kk) {
            this();
        }

        /* renamed from: A */
        public final a m4475A() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1113hk) this.f8022P).m4474T();
            return this;
        }

        /* renamed from: v */
        public final int m4476v() {
            return ((C1113hk) this.f8022P).m4471N();
        }

        /* renamed from: w */
        public final C1046gk m4477w(int i) {
            return ((C1113hk) this.f8022P).m4464D(i);
        }

        /* renamed from: y */
        public final a m4478y(int i, C1046gk.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1113hk) this.f8022P).m4465E(i, (C1046gk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: z */
        public final List<C2356yj> m4479z() {
            return Collections.unmodifiableList(((C1113hk) this.f8022P).m4472O());
        }
    }

    static {
        C1113hk c1113hk = new C1113hk();
        zzl = c1113hk;
        AbstractC2303xn.m9837v(C1113hk.class, c1113hk);
    }

    /* renamed from: Q */
    public static a m4461Q() {
        return zzl.m9839y();
    }

    /* renamed from: R */
    public static C1113hk m4462R() {
        return zzl;
    }

    /* renamed from: D */
    public final C1046gk m4464D(int i) {
        return this.zzh.get(i);
    }

    /* renamed from: E */
    public final void m4465E(int i, C1046gk c1046gk) {
        c1046gk.getClass();
        zzfq<C1046gk> zzfqVar = this.zzh;
        if (!zzfqVar.mo1236a()) {
            this.zzh = AbstractC2303xn.m9833q(zzfqVar);
        }
        this.zzh.set(i, c1046gk);
    }

    /* renamed from: H */
    public final boolean m4466H() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: I */
    public final long m4467I() {
        return this.zzd;
    }

    /* renamed from: J */
    public final boolean m4468J() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: L */
    public final String m4469L() {
        return this.zze;
    }

    /* renamed from: M */
    public final List<C1164ik> m4470M() {
        return this.zzg;
    }

    /* renamed from: N */
    public final int m4471N() {
        return this.zzh.size();
    }

    /* renamed from: O */
    public final List<C2356yj> m4472O() {
        return this.zzi;
    }

    /* renamed from: P */
    public final boolean m4473P() {
        return this.zzk;
    }

    /* renamed from: T */
    public final void m4474T() {
        this.zzi = AbstractC2303xn.m9831C();
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C1461kk c1461kk = null;
        switch (C1461kk.f4581a[i - 1]) {
            case 1:
                return new C1113hk();
            case 2:
                return new a(c1461kk);
            case 3:
                return AbstractC2303xn.m9835t(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0003\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", C1164ik.class, "zzh", C1046gk.class, "zzi", C2356yj.class, "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzhc<C1113hk> zzhcVar = zzm;
                if (zzhcVar == null) {
                    synchronized (C1113hk.class) {
                        zzhcVar = zzm;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzl);
                            zzm = zzhcVar;
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
