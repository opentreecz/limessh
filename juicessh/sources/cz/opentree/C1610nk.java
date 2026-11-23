package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;
import cz.opentree.C1722pk;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.nk */
/* loaded from: classes.dex */
public final class C1610nk extends AbstractC2303xn<C1610nk, a> implements zzgv {
    private static final C1610nk zzi;
    private static volatile zzhc<C1610nk> zzj;
    private int zzc;
    private zzfq<C1722pk> zzd = AbstractC2303xn.m9831C();
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.nk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1610nk, a> implements zzgv {
        public a() {
            super(C1610nk.zzi);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: A */
        public final a m6718A(C1722pk c1722pk) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6703P(c1722pk);
            return this;
        }

        /* renamed from: B */
        public final a m6719B(Iterable<? extends C1722pk> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6704Q(iterable);
            return this;
        }

        /* renamed from: C */
        public final a m6720C(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6705R(str);
            return this;
        }

        /* renamed from: D */
        public final C1722pk m6721D(int i) {
            return ((C1610nk) this.f8022P).m6699D(i);
        }

        /* renamed from: E */
        public final List<C1722pk> m6722E() {
            return Collections.unmodifiableList(((C1610nk) this.f8022P).m6700E());
        }

        /* renamed from: F */
        public final int m6723F() {
            return ((C1610nk) this.f8022P).m6706S();
        }

        /* renamed from: G */
        public final a m6724G(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6707T(i);
            return this;
        }

        /* renamed from: H */
        public final a m6725H(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6708U(j);
            return this;
        }

        /* renamed from: I */
        public final a m6726I() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6717g0();
            return this;
        }

        /* renamed from: J */
        public final String m6727J() {
            return ((C1610nk) this.f8022P).m6709W();
        }

        /* renamed from: L */
        public final long m6728L() {
            return ((C1610nk) this.f8022P).m6711Y();
        }

        /* renamed from: M */
        public final long m6729M() {
            return ((C1610nk) this.f8022P).m6713a0();
        }

        /* renamed from: v */
        public final a m6730v(int i, C1722pk.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6701F(i, (C1722pk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: w */
        public final a m6731w(int i, C1722pk c1722pk) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6701F(i, c1722pk);
            return this;
        }

        /* renamed from: y */
        public final a m6732y(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6702G(j);
            return this;
        }

        /* renamed from: z */
        public final a m6733z(C1722pk.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1610nk) this.f8022P).m6703P((C1722pk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }
    }

    static {
        C1610nk c1610nk = new C1610nk();
        zzi = c1610nk;
        AbstractC2303xn.m9837v(C1610nk.class, c1610nk);
    }

    /* renamed from: d0 */
    public static a m6697d0() {
        return zzi.m9839y();
    }

    /* renamed from: D */
    public final C1722pk m6699D(int i) {
        return this.zzd.get(i);
    }

    /* renamed from: E */
    public final List<C1722pk> m6700E() {
        return this.zzd;
    }

    /* renamed from: F */
    public final void m6701F(int i, C1722pk c1722pk) {
        c1722pk.getClass();
        m6716f0();
        this.zzd.set(i, c1722pk);
    }

    /* renamed from: G */
    public final void m6702G(long j) {
        this.zzc |= 2;
        this.zzf = j;
    }

    /* renamed from: P */
    public final void m6703P(C1722pk c1722pk) {
        c1722pk.getClass();
        m6716f0();
        this.zzd.add(c1722pk);
    }

    /* renamed from: Q */
    public final void m6704Q(Iterable<? extends C1722pk> iterable) {
        m6716f0();
        AbstractC1464km.m5945h(iterable, this.zzd);
    }

    /* renamed from: R */
    public final void m6705R(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zze = str;
    }

    /* renamed from: S */
    public final int m6706S() {
        return this.zzd.size();
    }

    /* renamed from: T */
    public final void m6707T(int i) {
        m6716f0();
        this.zzd.remove(i);
    }

    /* renamed from: U */
    public final void m6708U(long j) {
        this.zzc |= 4;
        this.zzg = j;
    }

    /* renamed from: W */
    public final String m6709W() {
        return this.zze;
    }

    /* renamed from: X */
    public final boolean m6710X() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: Y */
    public final long m6711Y() {
        return this.zzf;
    }

    /* renamed from: Z */
    public final boolean m6712Z() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: a0 */
    public final long m6713a0() {
        return this.zzg;
    }

    /* renamed from: b0 */
    public final boolean m6714b0() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: c0 */
    public final int m6715c0() {
        return this.zzh;
    }

    /* renamed from: f0 */
    public final void m6716f0() {
        zzfq<C1722pk> zzfqVar = this.zzd;
        if (zzfqVar.mo1236a()) {
            return;
        }
        this.zzd = AbstractC2303xn.m9833q(zzfqVar);
    }

    /* renamed from: g0 */
    public final void m6717g0() {
        this.zzd = AbstractC2303xn.m9831C();
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1610nk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", C1722pk.class, "zze", "zzf", "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                zzhc<C1610nk> zzhcVar = zzj;
                if (zzhcVar == null) {
                    synchronized (C1610nk.class) {
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
