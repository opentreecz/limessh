package com.sonelli;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.ck */
/* loaded from: classes.dex */
public final class C0831ck extends AbstractC2303xn<C0831ck, a> implements zzgv {
    private static final C0831ck zzj;
    private static volatile zzhc<C0831ck> zzk;
    private int zzc;
    private int zzd;
    private String zze = "";
    private C0718ak zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.ck$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C0831ck, a> implements zzgv {
        public a() {
            super(C0831ck.zzj);
        }

        public /* synthetic */ a(C0943ek c0943ek) {
            this();
        }

        /* renamed from: v */
        public final a m2839v(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C0831ck) this.f8022P).m2830E(str);
            return this;
        }
    }

    static {
        C0831ck c0831ck = new C0831ck();
        zzj = c0831ck;
        AbstractC2303xn.m9837v(C0831ck.class, c0831ck);
    }

    /* renamed from: O */
    public static a m2828O() {
        return zzj.m9839y();
    }

    /* renamed from: E */
    public final void m2830E(String str) {
        str.getClass();
        this.zzc |= 2;
        this.zze = str;
    }

    /* renamed from: F */
    public final boolean m2831F() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: G */
    public final int m2832G() {
        return this.zzd;
    }

    /* renamed from: H */
    public final String m2833H() {
        return this.zze;
    }

    /* renamed from: I */
    public final C0718ak m2834I() {
        C0718ak c0718ak = this.zzf;
        return c0718ak == null ? C0718ak.m2121O() : c0718ak;
    }

    /* renamed from: J */
    public final boolean m2835J() {
        return this.zzg;
    }

    /* renamed from: L */
    public final boolean m2836L() {
        return this.zzh;
    }

    /* renamed from: M */
    public final boolean m2837M() {
        return (this.zzc & 32) != 0;
    }

    /* renamed from: N */
    public final boolean m2838N() {
        return this.zzi;
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C0831ck();
            case 2:
                return new a(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
            case 4:
                return zzj;
            case 5:
                zzhc<C0831ck> zzhcVar = zzk;
                if (zzhcVar == null) {
                    synchronized (C0831ck.class) {
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
