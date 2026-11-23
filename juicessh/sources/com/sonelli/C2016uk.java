package com.sonelli;

import com.google.android.gms.internal.measurement.zzfr;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.uk */
/* loaded from: classes.dex */
public final class C2016uk extends AbstractC2303xn<C2016uk, a> implements zzgv {
    private static final C2016uk zzf;
    private static volatile zzhc<C2016uk> zzg;
    private int zzc;
    private int zzd;
    private zzfr zze = AbstractC2303xn.m9830B();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.uk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C2016uk, a> implements zzgv {
        public a() {
            super(C2016uk.zzf);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: v */
        public final a m8914v(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2016uk) this.f8022P).m8911J(i);
            return this;
        }

        /* renamed from: w */
        public final a m8915w(Iterable<? extends Long> iterable) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2016uk) this.f8022P).m8908G(iterable);
            return this;
        }
    }

    static {
        C2016uk c2016uk = new C2016uk();
        zzf = c2016uk;
        AbstractC2303xn.m9837v(C2016uk.class, c2016uk);
    }

    /* renamed from: N */
    public static a m8905N() {
        return zzf.m9839y();
    }

    /* renamed from: D */
    public final long m8907D(int i) {
        return this.zze.mo1239d(i);
    }

    /* renamed from: G */
    public final void m8908G(Iterable<? extends Long> iterable) {
        zzfr zzfrVar = this.zze;
        if (!zzfrVar.mo1236a()) {
            this.zze = AbstractC2303xn.m9834r(zzfrVar);
        }
        AbstractC1464km.m5945h(iterable, this.zze);
    }

    /* renamed from: H */
    public final boolean m8909H() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: I */
    public final int m8910I() {
        return this.zzd;
    }

    /* renamed from: J */
    public final void m8911J(int i) {
        this.zzc |= 1;
        this.zzd = i;
    }

    /* renamed from: L */
    public final List<Long> m8912L() {
        return this.zze;
    }

    /* renamed from: M */
    public final int m8913M() {
        return this.zze.size();
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C2016uk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
            case 4:
                return zzf;
            case 5:
                zzhc<C2016uk> zzhcVar = zzg;
                if (zzhcVar == null) {
                    synchronized (C2016uk.class) {
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
