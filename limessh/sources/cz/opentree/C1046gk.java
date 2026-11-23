package cz.opentree;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.gk */
/* loaded from: classes.dex */
public final class C1046gk extends AbstractC2303xn<C1046gk, a> implements zzgv {
    private static final C1046gk zzh;
    private static volatile zzhc<C1046gk> zzi;
    private int zzc;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.gk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1046gk, a> implements zzgv {
        public a() {
            super(C1046gk.zzh);
        }

        public /* synthetic */ a(C1461kk c1461kk) {
            this();
        }

        /* renamed from: A */
        public final boolean m4154A() {
            return ((C1046gk) this.f8022P).m4152I();
        }

        /* renamed from: B */
        public final int m4155B() {
            return ((C1046gk) this.f8022P).m4153J();
        }

        /* renamed from: v */
        public final a m4156v(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1046gk) this.f8022P).m4149F(str);
            return this;
        }

        /* renamed from: w */
        public final String m4157w() {
            return ((C1046gk) this.f8022P).m4148D();
        }

        /* renamed from: y */
        public final boolean m4158y() {
            return ((C1046gk) this.f8022P).m4150G();
        }

        /* renamed from: z */
        public final boolean m4159z() {
            return ((C1046gk) this.f8022P).m4151H();
        }
    }

    static {
        C1046gk c1046gk = new C1046gk();
        zzh = c1046gk;
        AbstractC2303xn.m9837v(C1046gk.class, c1046gk);
    }

    /* renamed from: D */
    public final String m4148D() {
        return this.zzd;
    }

    /* renamed from: F */
    public final void m4149F(String str) {
        str.getClass();
        this.zzc |= 1;
        this.zzd = str;
    }

    /* renamed from: G */
    public final boolean m4150G() {
        return this.zze;
    }

    /* renamed from: H */
    public final boolean m4151H() {
        return this.zzf;
    }

    /* renamed from: I */
    public final boolean m4152I() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: J */
    public final int m4153J() {
        return this.zzg;
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C1461kk c1461kk = null;
        switch (C1461kk.f4581a[i - 1]) {
            case 1:
                return new C1046gk();
            case 2:
                return new a(c1461kk);
            case 3:
                return AbstractC2303xn.m9835t(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                zzhc<C1046gk> zzhcVar = zzi;
                if (zzhcVar == null) {
                    synchronized (C1046gk.class) {
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
