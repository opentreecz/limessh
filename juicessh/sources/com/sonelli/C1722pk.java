package com.sonelli;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.sonelli.AbstractC2303xn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.pk */
/* loaded from: classes.dex */
public final class C1722pk extends AbstractC2303xn<C1722pk, a> implements zzgv {
    private static final C1722pk zzj;
    private static volatile zzhc<C1722pk> zzk;
    private int zzc;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private zzfq<C1722pk> zzi = AbstractC2303xn.m9831C();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.pk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1722pk, a> implements zzgv {
        public a() {
            super(C1722pk.zzj);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: A */
        public final a m7379A(Iterable<? extends C1722pk> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7360M(iterable);
            return this;
        }

        /* renamed from: B */
        public final a m7380B(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7361N(str);
            return this;
        }

        /* renamed from: C */
        public final a m7381C() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7375h0();
            return this;
        }

        /* renamed from: D */
        public final a m7382D(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7364S(str);
            return this;
        }

        /* renamed from: E */
        public final a m7383E() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7376i0();
            return this;
        }

        /* renamed from: F */
        public final int m7384F() {
            return ((C1722pk) this.f8022P).m7373d0();
        }

        /* renamed from: G */
        public final a m7385G() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7378k0();
            return this;
        }

        /* renamed from: v */
        public final a m7386v() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7374g0();
            return this;
        }

        /* renamed from: w */
        public final a m7387w(double d) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7358D(d);
            return this;
        }

        /* renamed from: y */
        public final a m7388y(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7359E(j);
            return this;
        }

        /* renamed from: z */
        public final a m7389z(a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1722pk) this.f8022P).m7367X((C1722pk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }
    }

    static {
        C1722pk c1722pk = new C1722pk();
        zzj = c1722pk;
        AbstractC2303xn.m9837v(C1722pk.class, c1722pk);
    }

    /* renamed from: e0 */
    public static a m7356e0() {
        return zzj.m9839y();
    }

    /* renamed from: D */
    public final void m7358D(double d) {
        this.zzc |= 16;
        this.zzh = d;
    }

    /* renamed from: E */
    public final void m7359E(long j) {
        this.zzc |= 4;
        this.zzf = j;
    }

    /* renamed from: M */
    public final void m7360M(Iterable<? extends C1722pk> iterable) {
        m7377j0();
        AbstractC1464km.m5945h(iterable, this.zzi);
    }

    /* renamed from: N */
    public final void m7361N(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* renamed from: O */
    public final boolean m7362O() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: P */
    public final String m7363P() {
        return this.zzd;
    }

    /* renamed from: S */
    public final void m7364S(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* renamed from: U */
    public final boolean m7365U() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: V */
    public final String m7366V() {
        return this.zze;
    }

    /* renamed from: X */
    public final void m7367X(C1722pk c1722pk) {
        c1722pk.getClass();
        m7377j0();
        this.zzi.add(c1722pk);
    }

    /* renamed from: Y */
    public final boolean m7368Y() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: Z */
    public final long m7369Z() {
        return this.zzf;
    }

    /* renamed from: a0 */
    public final boolean m7370a0() {
        return (this.zzc & 16) != 0;
    }

    /* renamed from: b0 */
    public final double m7371b0() {
        return this.zzh;
    }

    /* renamed from: c0 */
    public final List<C1722pk> m7372c0() {
        return this.zzi;
    }

    /* renamed from: d0 */
    public final int m7373d0() {
        return this.zzi.size();
    }

    /* renamed from: g0 */
    public final void m7374g0() {
        this.zzc &= -3;
        this.zze = zzj.zze;
    }

    /* renamed from: h0 */
    public final void m7375h0() {
        this.zzc &= -5;
        this.zzf = 0L;
    }

    /* renamed from: i0 */
    public final void m7376i0() {
        this.zzc &= -17;
        this.zzh = ShadowDrawableWrapper.COS_45;
    }

    /* renamed from: j0 */
    public final void m7377j0() {
        zzfq<C1722pk> zzfqVar = this.zzi;
        if (zzfqVar.mo1236a()) {
            return;
        }
        this.zzi = AbstractC2303xn.m9833q(zzfqVar);
    }

    /* renamed from: k0 */
    public final void m7378k0() {
        this.zzi = AbstractC2303xn.m9831C();
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1722pk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", C1722pk.class});
            case 4:
                return zzj;
            case 5:
                zzhc<C1722pk> zzhcVar = zzk;
                if (zzhcVar == null) {
                    synchronized (C1722pk.class) {
                        zzhcVar = zzk;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzj);
                            zzk = zzhcVar;
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
