package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;
import cz.opentree.C0831ck;
import cz.opentree.C2429zj;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.yj */
/* loaded from: classes.dex */
public final class C2356yj extends AbstractC2303xn<C2356yj, a> implements zzgv {
    private static final C2356yj zzi;
    private static volatile zzhc<C2356yj> zzj;
    private int zzc;
    private int zzd;
    private zzfq<C0831ck> zze = AbstractC2303xn.m9831C();
    private zzfq<C2429zj> zzf = AbstractC2303xn.m9831C();
    private boolean zzg;
    private boolean zzh;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.yj$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C2356yj, a> implements zzgv {
        public a() {
            super(C2356yj.zzi);
        }

        public /* synthetic */ a(C0943ek c0943ek) {
            this();
        }

        /* renamed from: A */
        public final int m10175A() {
            return ((C2356yj) this.f8022P).m10174P();
        }

        /* renamed from: B */
        public final C2429zj m10176B(int i) {
            return ((C2356yj) this.f8022P).m10170L(i);
        }

        /* renamed from: v */
        public final int m10177v() {
            return ((C2356yj) this.f8022P).m10172N();
        }

        /* renamed from: w */
        public final a m10178w(int i, C2429zj.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2356yj) this.f8022P).m10166E(i, (C2429zj) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: y */
        public final a m10179y(int i, C0831ck.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C2356yj) this.f8022P).m10167F(i, (C0831ck) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: z */
        public final C0831ck m10180z(int i) {
            return ((C2356yj) this.f8022P).m10165D(i);
        }
    }

    static {
        C2356yj c2356yj = new C2356yj();
        zzi = c2356yj;
        AbstractC2303xn.m9837v(C2356yj.class, c2356yj);
    }

    /* renamed from: D */
    public final C0831ck m10165D(int i) {
        return this.zze.get(i);
    }

    /* renamed from: E */
    public final void m10166E(int i, C2429zj c2429zj) {
        c2429zj.getClass();
        zzfq<C2429zj> zzfqVar = this.zzf;
        if (!zzfqVar.mo1236a()) {
            this.zzf = AbstractC2303xn.m9833q(zzfqVar);
        }
        this.zzf.set(i, c2429zj);
    }

    /* renamed from: F */
    public final void m10167F(int i, C0831ck c0831ck) {
        c0831ck.getClass();
        zzfq<C0831ck> zzfqVar = this.zze;
        if (!zzfqVar.mo1236a()) {
            this.zze = AbstractC2303xn.m9833q(zzfqVar);
        }
        this.zze.set(i, c0831ck);
    }

    /* renamed from: I */
    public final boolean m10168I() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: J */
    public final int m10169J() {
        return this.zzd;
    }

    /* renamed from: L */
    public final C2429zj m10170L(int i) {
        return this.zzf.get(i);
    }

    /* renamed from: M */
    public final List<C0831ck> m10171M() {
        return this.zze;
    }

    /* renamed from: N */
    public final int m10172N() {
        return this.zze.size();
    }

    /* renamed from: O */
    public final List<C2429zj> m10173O() {
        return this.zzf;
    }

    /* renamed from: P */
    public final int m10174P() {
        return this.zzf.size();
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C2356yj();
            case 2:
                return new a(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", C0831ck.class, "zzf", C2429zj.class, "zzg", "zzh"});
            case 4:
                return zzi;
            case 5:
                zzhc<C2356yj> zzhcVar = zzj;
                if (zzhcVar == null) {
                    synchronized (C2356yj.class) {
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
