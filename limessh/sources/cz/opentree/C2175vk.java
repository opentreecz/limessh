package cz.opentree;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.vk */
/* loaded from: classes.dex */
public final class C2175vk extends AbstractC2303xn<C2175vk, a> implements zzgv {
    private static final C2175vk zzj;
    private static volatile zzhc<C2175vk> zzk;
    private int zzc;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.vk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C2175vk, a> implements zzgv {
        public a() {
            super(C2175vk.zzj);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: A */
        public final a m9283A() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9281d0();
            return this;
        }

        /* renamed from: B */
        public final a m9284B(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9271N(j);
            return this;
        }

        /* renamed from: C */
        public final a m9285C(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9272R(str);
            return this;
        }

        /* renamed from: D */
        public final a m9286D() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9282e0();
            return this;
        }

        /* renamed from: v */
        public final a m9287v() {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9280c0();
            return this;
        }

        /* renamed from: w */
        public final a m9288w(double d) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9266D(d);
            return this;
        }

        /* renamed from: y */
        public final a m9289y(long j) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9267E(j);
            return this;
        }

        /* renamed from: z */
        public final a m9290z(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2175vk) this.f8022P).m9268J(str);
            return this;
        }
    }

    static {
        C2175vk c2175vk = new C2175vk();
        zzj = c2175vk;
        AbstractC2303xn.m9837v(C2175vk.class, c2175vk);
    }

    /* renamed from: a0 */
    public static a m9264a0() {
        return zzj.m9839y();
    }

    /* renamed from: D */
    public final void m9266D(double d) {
        this.zzc |= 32;
        this.zzi = d;
    }

    /* renamed from: E */
    public final void m9267E(long j) {
        this.zzc |= 1;
        this.zzd = j;
    }

    /* renamed from: J */
    public final void m9268J(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* renamed from: L */
    public final boolean m9269L() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: M */
    public final long m9270M() {
        return this.zzd;
    }

    /* renamed from: N */
    public final void m9271N(long j) {
        this.zzc |= 8;
        this.zzg = j;
    }

    /* renamed from: R */
    public final void m9272R(String str) {
        str.getClass();
        this.zzc |= 4;
        this.zzf = str;
    }

    /* renamed from: S */
    public final String m9273S() {
        return this.zze;
    }

    /* renamed from: U */
    public final boolean m9274U() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: V */
    public final String m9275V() {
        return this.zzf;
    }

    /* renamed from: W */
    public final boolean m9276W() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: X */
    public final long m9277X() {
        return this.zzg;
    }

    /* renamed from: Y */
    public final boolean m9278Y() {
        return (this.zzc & 32) != 0;
    }

    /* renamed from: Z */
    public final double m9279Z() {
        return this.zzi;
    }

    /* renamed from: c0 */
    public final void m9280c0() {
        this.zzc &= -5;
        this.zzf = zzj.zzf;
    }

    /* renamed from: d0 */
    public final void m9281d0() {
        this.zzc &= -9;
        this.zzg = 0L;
    }

    /* renamed from: e0 */
    public final void m9282e0() {
        this.zzc &= -33;
        this.zzi = ShadowDrawableWrapper.COS_45;
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C2175vk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                zzhc<C2175vk> zzhcVar = zzk;
                if (zzhcVar == null) {
                    synchronized (C2175vk.class) {
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
