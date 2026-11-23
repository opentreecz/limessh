package com.sonelli;

import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.ak */
/* loaded from: classes.dex */
public final class C0718ak extends AbstractC2303xn<C0718ak, a> implements zzgv {
    private static final C0718ak zzh;
    private static volatile zzhc<C0718ak> zzi;
    private int zzc;
    private C0886dk zzd;
    private C0781bk zze;
    private boolean zzf;
    private String zzg = "";

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.ak$a */
    /* loaded from: classes.dex */
    public static final class a extends AbstractC2303xn.b<C0718ak, a> implements zzgv {
        public a() {
            super(C0718ak.zzh);
        }

        public /* synthetic */ a(C0943ek c0943ek) {
            this();
        }

        /* renamed from: v */
        public final a m2133v(String str) {
            if (this.f8023Q) {
                m9844s();
                this.f8023Q = false;
            }
            ((C0718ak) this.f8022P).m2123E(str);
            return this;
        }
    }

    static {
        C0718ak c0718ak = new C0718ak();
        zzh = c0718ak;
        AbstractC2303xn.m9837v(C0718ak.class, c0718ak);
    }

    /* renamed from: O */
    public static C0718ak m2121O() {
        return zzh;
    }

    /* renamed from: E */
    public final void m2123E(String str) {
        str.getClass();
        this.zzc |= 8;
        this.zzg = str;
    }

    /* renamed from: F */
    public final boolean m2124F() {
        return (this.zzc & 1) != 0;
    }

    /* renamed from: G */
    public final C0886dk m2125G() {
        C0886dk c0886dk = this.zzd;
        return c0886dk == null ? C0886dk.m3233M() : c0886dk;
    }

    /* renamed from: H */
    public final boolean m2126H() {
        return (this.zzc & 2) != 0;
    }

    /* renamed from: I */
    public final C0781bk m2127I() {
        C0781bk c0781bk = this.zze;
        return c0781bk == null ? C0781bk.m2532O() : c0781bk;
    }

    /* renamed from: J */
    public final boolean m2128J() {
        return (this.zzc & 4) != 0;
    }

    /* renamed from: L */
    public final boolean m2129L() {
        return this.zzf;
    }

    /* renamed from: M */
    public final boolean m2130M() {
        return (this.zzc & 8) != 0;
    }

    /* renamed from: N */
    public final String m2131N() {
        return this.zzg;
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C0943ek c0943ek = null;
        switch (C0943ek.f2447a[i - 1]) {
            case 1:
                return new C0718ak();
            case 2:
                return new a(c0943ek);
            case 3:
                return AbstractC2303xn.m9835t(zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 4:
                return zzh;
            case 5:
                zzhc<C0718ak> zzhcVar = zzi;
                if (zzhcVar == null) {
                    synchronized (C0718ak.class) {
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
