package com.sonelli;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;
import com.sonelli.C1937tk;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.lk */
/* loaded from: classes.dex */
public final class C1512lk extends AbstractC2303xn<C1512lk, a> implements zzgv {
    private static final C1512lk zzh;
    private static volatile zzhc<C1512lk> zzi;
    private int zzc;
    private int zzd;
    private C1937tk zze;
    private C1937tk zzf;
    private boolean zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.lk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1512lk, a> implements zzgv {
        public a() {
            super(C1512lk.zzh);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: v */
        public final a m6245v(int i) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1512lk) this.f8022P).m6234D(i);
            return this;
        }

        /* renamed from: w */
        public final a m6246w(C1937tk.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1512lk) this.f8022P).m6235H((C1937tk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: y */
        public final a m6247y(C1937tk c1937tk) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1512lk) this.f8022P).m6239N(c1937tk);
            return this;
        }

        /* renamed from: z */
        public final a m6248z(boolean z) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1512lk) this.f8022P).m6236I(z);
            return this;
        }
    }

    static {
        C1512lk c1512lk = new C1512lk();
        zzh = c1512lk;
        AbstractC2303xn.m9837v(C1512lk.class, c1512lk);
    }

    /* renamed from: T */
    public static a m6232T() {
        return zzh.m9839y();
    }

    /* renamed from: D */
    public final void m6234D(int i) {
        this.zzc |= 1;
        this.zzd = i;
    }

    /* renamed from: H */
    public final void m6235H(C1937tk c1937tk) {
        c1937tk.getClass();
        this.zze = c1937tk;
        this.zzc |= 2;
    }

    /* renamed from: I */
    public final void m6236I(boolean z) {
        this.zzc |= 8;
        this.zzg = z;
    }

    /* renamed from: J */
    public final boolean m6237J() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: L */
    public final int m6238L() {
        return this.zzd;
    }

    /* renamed from: N */
    public final void m6239N(C1937tk c1937tk) {
        c1937tk.getClass();
        this.zzf = c1937tk;
        this.zzc |= 4;
    }

    /* renamed from: O */
    public final C1937tk m6240O() {
        C1937tk c1937tk = this.zze;
        return c1937tk == null ? C1937tk.m8716d0() : c1937tk;
    }

    /* renamed from: P */
    public final boolean m6241P() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: Q */
    public final C1937tk m6242Q() {
        C1937tk c1937tk = this.zzf;
        return c1937tk == null ? C1937tk.m8716d0() : c1937tk;
    }

    /* renamed from: R */
    public final boolean m6243R() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: S */
    public final boolean m6244S() {
        return this.zzg;
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1512lk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                zzhc<C1512lk> zzhcVar = zzi;
                if (zzhcVar == null) {
                    synchronized (C1512lk.class) {
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
