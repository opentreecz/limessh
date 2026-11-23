package com.sonelli;

import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfp;
import com.google.android.gms.internal.measurement.zzfq;
import com.google.android.gms.internal.measurement.zzgv;
import com.google.android.gms.internal.measurement.zzhc;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.sonelli.AbstractC2303xn;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* renamed from: com.sonelli.sk */
/* loaded from: classes.dex */
public final class C1872sk extends AbstractC2303xn<C1872sk, b> implements zzgv {
    private static final C1872sk zzf;
    private static volatile zzhc<C1872sk> zzg;
    private int zzc;
    private int zzd = 1;
    private zzfq<C1661ok> zze = AbstractC2303xn.m9831C();

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.sk$a */
    /* loaded from: classes.dex */
    public enum a implements zzfn {
        RADS(1),
        PROVISIONING(2);


        /* renamed from: O */
        public final int f6483O;

        a(int i) {
            this.f6483O = i;
        }

        /* renamed from: f */
        public static a m8457f(int i) {
            if (i == 1) {
                return RADS;
            }
            if (i != 2) {
                return null;
            }
            return PROVISIONING;
        }

        /* renamed from: h */
        public static zzfp m8458h() {
            return C2297xk.f7989a;
        }

        @Override // com.google.android.gms.internal.measurement.zzfn
        /* renamed from: a */
        public final int mo1233a() {
            return this.f6483O;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return SimpleComparison.LESS_THAN_OPERATION + a.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f6483O + " name=" + name() + '>';
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
    /* renamed from: com.sonelli.sk$b */
    /* loaded from: classes.dex */
    public static final class b extends AbstractC2303xn.b<C1872sk, b> implements zzgv {
        public b() {
            super(C1872sk.zzf);
        }

        public /* synthetic */ b(C2229wk c2229wk) {
            this();
        }
    }

    static {
        C1872sk c1872sk = new C1872sk();
        zzf = c1872sk;
        AbstractC2303xn.m9837v(C1872sk.class, c1872sk);
    }

    @Override // com.sonelli.AbstractC2303xn
    /* renamed from: s */
    public final Object mo2132s(int i, Object obj, Object obj2) {
        C2229wk c2229wk = null;
        switch (C2229wk.f7756a[i - 1]) {
            case 1:
                return new C1872sk();
            case 2:
                return new b(c2229wk);
            case 3:
                return AbstractC2303xn.m9835t(zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", a.m8458h(), "zze", C1661ok.class});
            case 4:
                return zzf;
            case 5:
                zzhc<C1872sk> zzhcVar = zzg;
                if (zzhcVar == null) {
                    synchronized (C1872sk.class) {
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
