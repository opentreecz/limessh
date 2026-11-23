package com.sonelli;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.zj */
/* loaded from: classes.dex */
public final class C2429zj extends AbstractC2303xn<C2429zj, a> implements zzgv {
    private static final C2429zj zzl;
    private static volatile zzhc<C2429zj> zzm;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzfq<C0718ak> zzf = AbstractC2303xn.m9831C();
    private boolean zzg;
    private C0781bk zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.zj$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C2429zj, a> implements zzgv {
        public a() {
            super(C2429zj.zzl);
        }

        public /* synthetic */ a(C0943ek c0943ek) {
            this();
        }

        /* renamed from: A */
        public final int m10480A() {
            return ((C2429zj) this.f8022P).m10473N();
        }

        /* renamed from: v */
        public final a m10481v(int i, C0718ak c0718ak) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2429zj) this.f8022P).m10467E(i, c0718ak);
            return this;
        }

        /* renamed from: w */
        public final a m10482w(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2429zj) this.f8022P).m10468H(str);
            return this;
        }

        /* renamed from: y */
        public final C0718ak m10483y(int i) {
            return ((C2429zj) this.f8022P).m10466D(i);
        }

        /* renamed from: z */
        public final String m10484z() {
            return ((C2429zj) this.f8022P).m10471L();
        }
    }

    static {
        C2429zj c2429zj = new C2429zj();
        zzl = c2429zj;
        AbstractC2303xn.m9837v(C2429zj.class, c2429zj);
    }

    /* renamed from: U */
    public static a m10464U() {
        return zzl.m9839y();
    }

    /* renamed from: D */
    public final C0718ak m10466D(int i) {
        return this.zzf.get(i);
    }

    /* renamed from: E */
    public final void m10467E(int i, C0718ak c0718ak) {
        c0718ak.getClass();
        zzfq<C0718ak> zzfqVar = this.zzf;
        if (!zzfqVar.mo1236a()) {
            this.zzf = AbstractC2303xn.m9833q(zzfqVar);
        }
        this.zzf.set(i, c0718ak);
    }

    /* renamed from: H */
    public final void m10468H(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* renamed from: I */
    public final boolean m10469I() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: J */
    public final int m10470J() {
        return this.zzd;
    }

    /* renamed from: L */
    public final String m10471L() {
        return this.zze;
    }

    /* renamed from: M */
    public final List<C0718ak> m10472M() {
        return this.zzf;
    }

    /* renamed from: N */
    public final int m10473N() {
        return this.zzf.size();
    }

    /* renamed from: O */
    public final boolean m10474O() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: P */
    public final C0781bk m10475P() {
        C0781bk c0781bk = this.zzh;
        return c0781bk == null ? C0781bk.m2532O() : c0781bk;
    }

    /* renamed from: Q */
    public final boolean m10476Q() {
        return this.zzi;
    }

    /* renamed from: R */
    public final boolean m10477R() {
        return this.zzj;
    }

    /* renamed from: S */
    public final boolean m10478S() {
        return (this.zzc & 64) != 0;
    }

    /* renamed from: T */
    public final boolean m10479T() {
        return this.zzk;
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C2429zj();
            case 2:
                return new a(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", C0718ak.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 4:
                return zzl;
            case 5:
                zzhc<C2429zj> zzhcVar = zzm;
                if (zzhcVar == null) {
                    synchronized (C2429zj.class) {
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
