package cz.opentree;

import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import cz.opentree.AbstractC2303xn;
import cz.opentree.C1821rk;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: cz.opentree.qk */
/* loaded from: classes.dex */
public final class C1766qk extends AbstractC2303xn<C1766qk, a> implements zzgv {
    private static final C1766qk zzd;
    private static volatile zzhc<C1766qk> zze;
    private zzfq<C1821rk> zzc = AbstractC2303xn.m9831C();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: cz.opentree.qk$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C1766qk, a> implements zzgv {
        public a() {
            super(C1766qk.zzd);
        }

        public /* synthetic */ a(C2229wk c2229wk) {
            this();
        }

        /* renamed from: v */
        public final a m7727v(C1821rk.a aVar) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C1766qk) this.f8022P).m7726G((C1821rk) ((AbstractC2303xn) aVar.mo1259f()));
            return this;
        }

        /* renamed from: w */
        public final C1821rk m7728w(int i) {
            return ((C1766qk) this.f8022P).m7724D(0);
        }
    }

    static {
        C1766qk c1766qk = new C1766qk();
        zzd = c1766qk;
        AbstractC2303xn.m9837v(C1766qk.class, c1766qk);
    }

    /* renamed from: H */
    public static a m7722H() {
        return zzd.m9839y();
    }

    /* renamed from: D */
    public final C1821rk m7724D(int i) {
        return this.zzc.get(0);
    }

    /* renamed from: E */
    public final List<C1821rk> m7725E() {
        return this.zzc;
    }

    /* renamed from: G */
    public final void m7726G(C1821rk c1821rk) {
        c1821rk.getClass();
        zzfq<C1821rk> zzfqVar = this.zzc;
        if (!zzfqVar.mo1236a()) {
            this.zzc = AbstractC2303xn.m9833q(zzfqVar);
        }
        this.zzc.add(c1821rk);
    }

    @Override // cz.opentree.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1766qk();
            case 2:
                return new a(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", C1821rk.class});
            case 4:
                return zzd;
            case 5:
                zzhc<C1766qk> zzhcVar = zze;
                if (zzhcVar == null) {
                    synchronized (C1766qk.class) {
                        zzhcVar = zze;
                        if (zzhcVar == null) {
                            zzhcVar = new AbstractC2303xn.a<>(zzd);
                            zze = zzhcVar;
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
