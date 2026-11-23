package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.tk */
/* loaded from: classes.dex */
public final class C1937tk extends AbstractC2303xn<C1937tk, a> implements zzgv {
    private static final C1937tk zzg;
    private static volatile zzhc<C1937tk> zzh;
    private zzfr zzc = AbstractC2303xn.m9830B();
    private zzfr zzd = AbstractC2303xn.m9830B();
    private zzfq<C1558mk> zze = AbstractC2303xn.m9831C();
    private zzfq<C2016uk> zzf = AbstractC2303xn.m9831C();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.tk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1937tk, a> implements zzgv {
        public a() {
            super(C1937tk.zzg);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: A */
        public final a m8738A(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8730Y(i);
            return this;
        }

        /* renamed from: B */
        public final a m8739B(Iterable<? extends Long> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8723P(iterable);
            return this;
        }

        /* renamed from: C */
        public final a m8740C(Iterable<? extends C1558mk> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8725S(iterable);
            return this;
        }

        /* renamed from: D */
        public final a m8741D(Iterable<? extends C2016uk> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8728W(iterable);
            return this;
        }

        /* renamed from: v */
        public final a m8742v() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8734f0();
            return this;
        }

        /* renamed from: w */
        public final a m8743w(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8727U(i);
            return this;
        }

        /* renamed from: y */
        public final a m8744y(Iterable<? extends Long> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8720I(iterable);
            return this;
        }

        /* renamed from: z */
        public final a m8745z() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1937tk) this.f8022P).m8735g0();
            return this;
        }
    }

    static {
        C1937tk c1937tk = new C1937tk();
        zzg = c1937tk;
        AbstractC2303xn.m9837v(C1937tk.class, c1937tk);
    }

    /* renamed from: c0 */
    public static a m8715c0() {
        return zzg.m9839y();
    }

    /* renamed from: d0 */
    public static C1937tk m8716d0() {
        return zzg;
    }

    /* renamed from: D */
    public final C1558mk m8718D(int i) {
        return this.zze.get(i);
    }

    /* renamed from: E */
    public final List<Long> m8719E() {
        return this.zzc;
    }

    /* renamed from: I */
    public final void m8720I(Iterable<? extends Long> iterable) {
        zzfr zzfrVar = this.zzc;
        if (!zzfrVar.mo1236a()) {
            this.zzc = AbstractC2303xn.m9834r(zzfrVar);
        }
        AbstractC1464km.m5945h(iterable, this.zzc);
    }

    /* renamed from: J */
    public final int m8721J() {
        return this.zzc.size();
    }

    /* renamed from: L */
    public final C2016uk m8722L(int i) {
        return this.zzf.get(i);
    }

    /* renamed from: P */
    public final void m8723P(Iterable<? extends Long> iterable) {
        zzfr zzfrVar = this.zzd;
        if (!zzfrVar.mo1236a()) {
            this.zzd = AbstractC2303xn.m9834r(zzfrVar);
        }
        AbstractC1464km.m5945h(iterable, this.zzd);
    }

    /* renamed from: Q */
    public final List<Long> m8724Q() {
        return this.zzd;
    }

    /* renamed from: S */
    public final void m8725S(Iterable<? extends C1558mk> iterable) {
        m8736h0();
        AbstractC1464km.m5945h(iterable, this.zze);
    }

    /* renamed from: T */
    public final int m8726T() {
        return this.zzd.size();
    }

    /* renamed from: U */
    public final void m8727U(int i) {
        m8736h0();
        this.zze.remove(i);
    }

    /* renamed from: W */
    public final void m8728W(Iterable<? extends C2016uk> iterable) {
        m8737i0();
        AbstractC1464km.m5945h(iterable, this.zzf);
    }

    /* renamed from: X */
    public final List<C1558mk> m8729X() {
        return this.zze;
    }

    /* renamed from: Y */
    public final void m8730Y(int i) {
        m8737i0();
        this.zzf.remove(i);
    }

    /* renamed from: Z */
    public final int m8731Z() {
        return this.zze.size();
    }

    /* renamed from: a0 */
    public final List<C2016uk> m8732a0() {
        return this.zzf;
    }

    /* renamed from: b0 */
    public final int m8733b0() {
        return this.zzf.size();
    }

    /* renamed from: f0 */
    public final void m8734f0() {
        this.zzc = AbstractC2303xn.m9830B();
    }

    /* renamed from: g0 */
    public final void m8735g0() {
        this.zzd = AbstractC2303xn.m9830B();
    }

    /* renamed from: h0 */
    public final void m8736h0() {
        zzfq<C1558mk> zzfqVar = this.zze;
        if (zzfqVar.mo1236a()) {
            return;
        }
        this.zze = AbstractC2303xn.m9833q(zzfqVar);
    }

    /* renamed from: i0 */
    public final void m8737i0() {
        zzfq<C2016uk> zzfqVar = this.zzf;
        if (zzfqVar.mo1236a()) {
            return;
        }
        this.zzf = AbstractC2303xn.m9833q(zzfqVar);
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1937tk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", C1558mk.class, "zzf", C2016uk.class});
            case 4:
                return zzg;
            case 5:
                zzhc<C1937tk> zzhcVar = zzh;
                if (zzhcVar == null) {
                    synchronized (C1937tk.class) {
                        zzhcVar = zzh;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzg);
                            zzh = zzhcVar;
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
