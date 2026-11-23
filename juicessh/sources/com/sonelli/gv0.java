package com.sonelli;

import com.sonelli.hv0;
import com.sonelli.iv0;
import java.math.BigInteger;
import java.util.Hashtable;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.ECMultiplier;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;
import org.bouncycastle.math.ec.endo.ECEndomorphism;
import org.bouncycastle.math.field.FiniteField;

/* loaded from: classes.dex */
public abstract class gv0 {

    /* renamed from: a */
    public FiniteField f2987a;

    /* renamed from: b */
    public hv0 f2988b;

    /* renamed from: c */
    public hv0 f2989c;

    /* renamed from: d */
    public BigInteger f2990d;

    /* renamed from: e */
    public BigInteger f2991e;

    /* renamed from: f */
    public int f2992f = 0;

    /* renamed from: g */
    public ECEndomorphism f2993g = null;

    /* renamed from: h */
    public ECMultiplier f2994h = null;

    /* renamed from: com.sonelli.gv0$a */
    /* loaded from: classes.dex */
    public class C1074a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f2995a;

        /* renamed from: b */
        public final /* synthetic */ int f2996b;

        /* renamed from: c */
        public final /* synthetic */ byte[] f2997c;

        public C1074a(int i, int i2, byte[] bArr) {
            this.f2995a = i;
            this.f2996b = i2;
            this.f2997c = bArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int i2;
            int i3 = this.f2996b;
            byte[] bArr = new byte[i3];
            byte[] bArr2 = new byte[i3];
            int i4 = 0;
            for (int i5 = 0; i5 < this.f2995a; i5++) {
                int i6 = ((i5 ^ i) - 1) >> 31;
                int i7 = 0;
                while (true) {
                    i2 = this.f2996b;
                    if (i7 < i2) {
                        byte b = bArr[i7];
                        byte[] bArr3 = this.f2997c;
                        bArr[i7] = (byte) (b ^ (bArr3[i4 + i7] & i6));
                        bArr2[i7] = (byte) ((bArr3[(i2 + i4) + i7] & i6) ^ bArr2[i7]);
                        i7++;
                    }
                }
                i4 += i2 * 2;
            }
            return m4277c(bArr, bArr2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f2995a;
        }

        /* renamed from: c */
        public final iv0 m4277c(byte[] bArr, byte[] bArr2) {
            gv0 gv0Var = gv0.this;
            return gv0Var.mo2305g(gv0Var.mo2306k(new BigInteger(1, bArr)), gv0.this.mo2306k(new BigInteger(1, bArr2)));
        }
    }

    /* renamed from: com.sonelli.gv0$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1075b extends gv0 {
        public AbstractC1075b(int i, int i2, int i3, int i4) {
            super(m4278z(i, i2, i3, i4));
        }

        /* renamed from: z */
        public static FiniteField m4278z(int i, int i2, int i3, int i4) {
            if (i2 == 0) {
                throw new IllegalArgumentException("k1 must be > 0");
            }
            if (i3 == 0) {
                if (i4 == 0) {
                    return zz0.m10668a(new int[]{0, i2, i});
                }
                throw new IllegalArgumentException("k3 must be 0 if k2 == 0");
            }
            if (i3 <= i2) {
                throw new IllegalArgumentException("k2 must be > k1");
            }
            if (i4 > i3) {
                return zz0.m10668a(new int[]{0, i2, i3, i4, i});
            }
            throw new IllegalArgumentException("k3 must be > k2");
        }

        /* renamed from: A */
        public hv0 m4279A(hv0 hv0Var) {
            hv0 hv0Var2;
            hv0.AbstractC1129a abstractC1129a = (hv0.AbstractC1129a) hv0Var;
            boolean mo3343v = abstractC1129a.mo3343v();
            if (mo3343v && abstractC1129a.mo3344w() != 0) {
                return null;
            }
            int mo2307q = mo2307q();
            if ((mo2307q & 1) != 0) {
                hv0 mo3342u = abstractC1129a.mo3342u();
                if (mo3343v || mo3342u.mo2287o().mo2277a(mo3342u).mo2277a(hv0Var).mo2283i()) {
                    return mo3342u;
                }
                return null;
            }
            if (hv0Var.mo2283i()) {
                return hv0Var;
            }
            hv0 mo2306k = mo2306k(ECConstants.f8872a);
            Random random = new Random();
            do {
                hv0 mo2306k2 = mo2306k(new BigInteger(mo2307q, random));
                hv0 hv0Var3 = hv0Var;
                hv0Var2 = mo2306k;
                for (int i = 1; i < mo2307q; i++) {
                    hv0 mo2287o = hv0Var3.mo2287o();
                    hv0Var2 = hv0Var2.mo2287o().mo2277a(mo2287o.mo2284j(mo2306k2));
                    hv0Var3 = mo2287o.mo2277a(hv0Var);
                }
                if (!hv0Var3.mo2283i()) {
                    return null;
                }
            } while (hv0Var2.mo2287o().mo2277a(hv0Var2).mo2283i());
            return hv0Var2;
        }

        @Override // com.sonelli.gv0
        /* renamed from: f */
        public iv0 mo4262f(BigInteger bigInteger, BigInteger bigInteger2) {
            hv0 mo2306k = mo2306k(bigInteger);
            hv0 mo2306k2 = mo2306k(bigInteger2);
            int m4269o = m4269o();
            if (m4269o == 5 || m4269o == 6) {
                if (!mo2306k.mo2283i()) {
                    mo2306k2 = mo2306k2.mo2279d(mo2306k).mo2277a(mo2306k);
                } else if (!mo2306k2.mo2287o().equals(m4267m())) {
                    throw new IllegalArgumentException();
                }
            }
            return mo2305g(mo2306k, mo2306k2);
        }

        @Override // com.sonelli.gv0
        /* renamed from: i */
        public iv0 mo4264i(int i, BigInteger bigInteger) {
            hv0 hv0Var;
            hv0 mo2306k = mo2306k(bigInteger);
            if (mo2306k.mo2283i()) {
                hv0Var = m4267m().mo2286n();
            } else {
                hv0 m4279A = m4279A(mo2306k.mo2287o().mo2281g().mo2284j(m4267m()).mo2277a(m4266l()).mo2277a(mo2306k));
                if (m4279A != null) {
                    if (m4279A.mo2289s() != (i == 1)) {
                        m4279A = m4279A.mo2278b();
                    }
                    int m4269o = m4269o();
                    hv0Var = (m4269o == 5 || m4269o == 6) ? m4279A.mo2277a(mo2306k) : m4279A.mo2284j(mo2306k);
                } else {
                    hv0Var = null;
                }
            }
            if (hv0Var != null) {
                return mo2305g(mo2306k, hv0Var);
            }
            throw new IllegalArgumentException("Invalid point compression");
        }
    }

    /* renamed from: com.sonelli.gv0$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1076c extends gv0 {
        public AbstractC1076c(BigInteger bigInteger) {
            super(zz0.m10669b(bigInteger));
        }

        @Override // com.sonelli.gv0
        /* renamed from: i */
        public iv0 mo4264i(int i, BigInteger bigInteger) {
            hv0 mo2306k = mo2306k(bigInteger);
            hv0 mo2286n = mo2306k.mo2287o().mo2277a(this.f2988b).mo2284j(mo2306k).mo2277a(this.f2989c).mo2286n();
            if (mo2286n == null) {
                throw new IllegalArgumentException("Invalid point compression");
            }
            if (mo2286n.mo2289s() != (i == 1)) {
                mo2286n = mo2286n.mo2285m();
            }
            return mo2305g(mo2306k, mo2286n);
        }
    }

    /* renamed from: com.sonelli.gv0$d */
    /* loaded from: classes.dex */
    public class C1077d {

        /* renamed from: a */
        public int f2999a;

        /* renamed from: b */
        public ECEndomorphism f3000b;

        /* renamed from: c */
        public ECMultiplier f3001c;

        public C1077d(int i, ECEndomorphism eCEndomorphism, ECMultiplier eCMultiplier) {
            this.f2999a = i;
            this.f3000b = eCEndomorphism;
            this.f3001c = eCMultiplier;
        }

        /* renamed from: a */
        public gv0 m4280a() {
            if (!gv0.this.mo2309x(this.f2999a)) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            gv0 mo2303c = gv0.this.mo2303c();
            if (mo2303c == gv0.this) {
                throw new IllegalStateException("implementation returned current curve");
            }
            synchronized (mo2303c) {
                mo2303c.f2992f = this.f2999a;
                mo2303c.f2993g = this.f3000b;
                mo2303c.f2994h = this.f3001c;
            }
            return mo2303c;
        }

        /* renamed from: b */
        public C1077d m4281b(ECEndomorphism eCEndomorphism) {
            this.f3000b = eCEndomorphism;
            return this;
        }
    }

    /* renamed from: com.sonelli.gv0$e */
    /* loaded from: classes.dex */
    public static class C1078e extends AbstractC1075b {

        /* renamed from: i */
        public int f3003i;

        /* renamed from: j */
        public int f3004j;

        /* renamed from: k */
        public int f3005k;

        /* renamed from: l */
        public int f3006l;

        /* renamed from: m */
        public iv0.C1182d f3007m;

        /* renamed from: com.sonelli.gv0$e$a */
        /* loaded from: classes.dex */
        public class a extends dv0 {

            /* renamed from: a */
            public final /* synthetic */ int f3008a;

            /* renamed from: b */
            public final /* synthetic */ int f3009b;

            /* renamed from: c */
            public final /* synthetic */ long[] f3010c;

            /* renamed from: d */
            public final /* synthetic */ int[] f3011d;

            public a(int i, int i2, long[] jArr, int[] iArr) {
                this.f3008a = i;
                this.f3009b = i2;
                this.f3010c = jArr;
                this.f3011d = iArr;
            }

            @Override // org.bouncycastle.math.ec.ECLookupTable
            /* renamed from: a */
            public iv0 mo2310a(int i) {
                int i2;
                long[] m7201l = p01.m7201l(this.f3009b);
                long[] m7201l2 = p01.m7201l(this.f3009b);
                int i3 = 0;
                for (int i4 = 0; i4 < this.f3008a; i4++) {
                    long j = ((i4 ^ i) - 1) >> 31;
                    int i5 = 0;
                    while (true) {
                        i2 = this.f3009b;
                        if (i5 < i2) {
                            long j2 = m7201l[i5];
                            long[] jArr = this.f3010c;
                            m7201l[i5] = j2 ^ (jArr[i3 + i5] & j);
                            m7201l2[i5] = m7201l2[i5] ^ (jArr[(i2 + i3) + i5] & j);
                            i5++;
                        }
                    }
                    i3 += i2 * 2;
                }
                return m4284c(m7201l, m7201l2);
            }

            @Override // org.bouncycastle.math.ec.ECLookupTable
            /* renamed from: b */
            public int mo2311b() {
                return this.f3008a;
            }

            /* renamed from: c */
            public final iv0 m4284c(long[] jArr, long[] jArr2) {
                return C1078e.this.mo2305g(new hv0.C1131c(C1078e.this.f3003i, this.f3011d, new mv0(jArr)), new hv0.C1131c(C1078e.this.f3003i, this.f3011d, new mv0(jArr2)));
            }
        }

        public C1078e(int i, int i2, int i3, int i4, hv0 hv0Var, hv0 hv0Var2, BigInteger bigInteger, BigInteger bigInteger2) {
            super(i, i2, i3, i4);
            this.f3003i = i;
            this.f3004j = i2;
            this.f3005k = i3;
            this.f3006l = i4;
            this.f2990d = bigInteger;
            this.f2991e = bigInteger2;
            this.f3007m = new iv0.C1182d(this, null, null);
            this.f2988b = hv0Var;
            this.f2989c = hv0Var2;
            this.f2992f = 6;
        }

        public C1078e(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2) {
            this(i, i2, i3, i4, bigInteger, bigInteger2, (BigInteger) null, (BigInteger) null);
        }

        public C1078e(int i, int i2, int i3, int i4, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(i, i2, i3, i4);
            this.f3003i = i;
            this.f3004j = i2;
            this.f3005k = i3;
            this.f3006l = i4;
            this.f2990d = bigInteger3;
            this.f2991e = bigInteger4;
            this.f3007m = new iv0.C1182d(this, null, null);
            this.f2988b = mo2306k(bigInteger);
            this.f2989c = mo2306k(bigInteger2);
            this.f2992f = 6;
        }

        public C1078e(int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4) {
            this(i, i2, 0, 0, bigInteger, bigInteger2, bigInteger3, bigInteger4);
        }

        /* renamed from: C */
        public boolean m4283C() {
            return this.f3005k == 0 && this.f3006l == 0;
        }

        @Override // com.sonelli.gv0
        /* renamed from: c */
        public gv0 mo2303c() {
            return new C1078e(this.f3003i, this.f3004j, this.f3005k, this.f3006l, this.f2988b, this.f2989c, this.f2990d, this.f2991e);
        }

        @Override // com.sonelli.gv0
        /* renamed from: e */
        public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
            int i3 = (this.f3003i + 63) >>> 6;
            int[] iArr = m4283C() ? new int[]{this.f3004j} : new int[]{this.f3004j, this.f3005k, this.f3006l};
            long[] jArr = new long[i2 * i3 * 2];
            int i4 = 0;
            for (int i5 = 0; i5 < i2; i5++) {
                iv0 iv0Var = iv0VarArr[i + i5];
                ((hv0.C1131c) iv0Var.m4940l()).f3235h.m6564m(jArr, i4);
                int i6 = i4 + i3;
                ((hv0.C1131c) iv0Var.m4941m()).f3235h.m6564m(jArr, i6);
                i4 = i6 + i3;
            }
            return new a(i2, i3, jArr, iArr);
        }

        @Override // com.sonelli.gv0
        /* renamed from: g */
        public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
            return new iv0.C1182d(this, hv0Var, hv0Var2);
        }

        @Override // com.sonelli.gv0
        /* renamed from: k */
        public hv0 mo2306k(BigInteger bigInteger) {
            return new hv0.C1131c(this.f3003i, this.f3004j, this.f3005k, this.f3006l, bigInteger);
        }

        @Override // com.sonelli.gv0
        /* renamed from: q */
        public int mo2307q() {
            return this.f3003i;
        }

        @Override // com.sonelli.gv0
        /* renamed from: r */
        public iv0 mo2308r() {
            return this.f3007m;
        }

        @Override // com.sonelli.gv0
        /* renamed from: x */
        public boolean mo2309x(int i) {
            return i == 0 || i == 1 || i == 6;
        }
    }

    /* renamed from: com.sonelli.gv0$f */
    /* loaded from: classes.dex */
    public static class C1079f extends AbstractC1076c {

        /* renamed from: i */
        public BigInteger f3013i;

        /* renamed from: j */
        public BigInteger f3014j;

        /* renamed from: k */
        public iv0.C1183e f3015k;

        public C1079f(BigInteger bigInteger, BigInteger bigInteger2, hv0 hv0Var, hv0 hv0Var2, BigInteger bigInteger3, BigInteger bigInteger4) {
            super(bigInteger);
            this.f3013i = bigInteger;
            this.f3014j = bigInteger2;
            this.f3015k = new iv0.C1183e(this, null, null);
            this.f2988b = hv0Var;
            this.f2989c = hv0Var2;
            this.f2990d = bigInteger3;
            this.f2991e = bigInteger4;
            this.f2992f = 4;
        }

        public C1079f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            this(bigInteger, bigInteger2, bigInteger3, null, null);
        }

        public C1079f(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, BigInteger bigInteger5) {
            super(bigInteger);
            this.f3013i = bigInteger;
            this.f3014j = hv0.C1132d.m4655u(bigInteger);
            this.f3015k = new iv0.C1183e(this, null, null);
            this.f2988b = mo2306k(bigInteger2);
            this.f2989c = mo2306k(bigInteger3);
            this.f2990d = bigInteger4;
            this.f2991e = bigInteger5;
            this.f2992f = 4;
        }

        @Override // com.sonelli.gv0
        /* renamed from: c */
        public gv0 mo2303c() {
            return new C1079f(this.f3013i, this.f3014j, this.f2988b, this.f2989c, this.f2990d, this.f2991e);
        }

        @Override // com.sonelli.gv0
        /* renamed from: g */
        public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
            return new iv0.C1183e(this, hv0Var, hv0Var2);
        }

        @Override // com.sonelli.gv0
        /* renamed from: k */
        public hv0 mo2306k(BigInteger bigInteger) {
            return new hv0.C1132d(this.f3013i, this.f3014j, bigInteger);
        }

        @Override // com.sonelli.gv0
        /* renamed from: q */
        public int mo2307q() {
            return this.f3013i.bitLength();
        }

        @Override // com.sonelli.gv0
        /* renamed from: r */
        public iv0 mo2308r() {
            return this.f3015k;
        }

        @Override // com.sonelli.gv0
        /* renamed from: t */
        public iv0 mo4272t(iv0 iv0Var) {
            int m4269o;
            return (this == iv0Var.m4937h() || m4269o() != 2 || iv0Var.m4945r() || !((m4269o = iv0Var.m4937h().m4269o()) == 2 || m4269o == 3 || m4269o == 4)) ? super.mo4272t(iv0Var) : new iv0.C1183e(this, mo2306k(iv0Var.f3428b.mo2290t()), mo2306k(iv0Var.f3429c.mo2290t()), new hv0[]{mo2306k(iv0Var.f3430d[0].mo2290t())});
        }

        @Override // com.sonelli.gv0
        /* renamed from: x */
        public boolean mo2309x(int i) {
            return i == 0 || i == 1 || i == 2 || i == 4;
        }
    }

    public gv0(FiniteField finiteField) {
        this.f2987a = finiteField;
    }

    /* renamed from: a */
    public void m4259a(iv0 iv0Var) {
        if (iv0Var == null || this != iv0Var.m4937h()) {
            throw new IllegalArgumentException("'point' must be non-null and on this curve");
        }
    }

    /* renamed from: b */
    public void m4260b(iv0[] iv0VarArr, int i, int i2) {
        if (iv0VarArr == null) {
            throw new IllegalArgumentException("'points' cannot be null");
        }
        if (i < 0 || i2 < 0 || i > iv0VarArr.length - i2) {
            throw new IllegalArgumentException("invalid range specified for 'points'");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            iv0 iv0Var = iv0VarArr[i + i3];
            if (iv0Var != null && this != iv0Var.m4937h()) {
                throw new IllegalArgumentException("'points' entries must be null or on this curve");
            }
        }
    }

    /* renamed from: c */
    public abstract gv0 mo2303c();

    /* renamed from: d */
    public synchronized C1077d m4261d() {
        return new C1077d(this.f2992f, this.f2993g, this.f2994h);
    }

    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int mo2307q = (mo2307q() + 7) >>> 3;
        byte[] bArr = new byte[i2 * mo2307q * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            byte[] byteArray = iv0Var.m4940l().mo2290t().toByteArray();
            byte[] byteArray2 = iv0Var.m4941m().mo2290t().toByteArray();
            int i5 = 1;
            int i6 = byteArray.length > mo2307q ? 1 : 0;
            int length = byteArray.length - i6;
            if (byteArray2.length <= mo2307q) {
                i5 = 0;
            }
            int length2 = byteArray2.length - i5;
            int i7 = i3 + mo2307q;
            System.arraycopy(byteArray, i6, bArr, i7 - length, length);
            i3 = i7 + mo2307q;
            System.arraycopy(byteArray2, i5, bArr, i3 - length2, length2);
        }
        return new C1074a(i2, mo2307q, bArr);
    }

    public boolean equals(Object obj) {
        return this == obj || ((obj instanceof gv0) && m4265j((gv0) obj));
    }

    /* renamed from: f */
    public iv0 mo4262f(BigInteger bigInteger, BigInteger bigInteger2) {
        return mo2305g(mo2306k(bigInteger), mo2306k(bigInteger2));
    }

    /* renamed from: g */
    public abstract iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2);

    /* renamed from: h */
    public iv0 m4263h(byte[] bArr) {
        iv0 mo2308r;
        int mo2307q = (mo2307q() + 7) / 8;
        byte b = bArr[0];
        if (b != 0) {
            if (b == 2 || b == 3) {
                if (bArr.length != mo2307q + 1) {
                    throw new IllegalArgumentException("Incorrect length for compressed encoding");
                }
                mo2308r = mo4264i(b & 1, f51.m3685d(bArr, 1, mo2307q));
                if (!mo2308r.m4944q(true, true)) {
                    throw new IllegalArgumentException("Invalid point");
                }
            } else if (b != 4) {
                if (b != 6 && b != 7) {
                    throw new IllegalArgumentException("Invalid point encoding 0x" + Integer.toString(b, 16));
                }
                if (bArr.length != (mo2307q * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for hybrid encoding");
                }
                BigInteger m3685d = f51.m3685d(bArr, 1, mo2307q);
                BigInteger m3685d2 = f51.m3685d(bArr, mo2307q + 1, mo2307q);
                if (m3685d2.testBit(0) != (b == 7)) {
                    throw new IllegalArgumentException("Inconsistent Y coordinate in hybrid encoding");
                }
                mo2308r = m4276y(m3685d, m3685d2);
            } else {
                if (bArr.length != (mo2307q * 2) + 1) {
                    throw new IllegalArgumentException("Incorrect length for uncompressed encoding");
                }
                mo2308r = m4276y(f51.m3685d(bArr, 1, mo2307q), f51.m3685d(bArr, mo2307q + 1, mo2307q));
            }
        } else {
            if (bArr.length != 1) {
                throw new IllegalArgumentException("Incorrect length for infinity encoding");
            }
            mo2308r = mo2308r();
        }
        if (b == 0 || !mo2308r.m4945r()) {
            return mo2308r;
        }
        throw new IllegalArgumentException("Invalid infinity encoding");
    }

    public int hashCode() {
        return (m4270p().hashCode() ^ g51.m4056b(m4266l().mo2290t().hashCode(), 8)) ^ g51.m4056b(m4267m().mo2290t().hashCode(), 16);
    }

    /* renamed from: i */
    public abstract iv0 mo4264i(int i, BigInteger bigInteger);

    /* renamed from: j */
    public boolean m4265j(gv0 gv0Var) {
        return this == gv0Var || (gv0Var != null && m4270p().equals(gv0Var.m4270p()) && m4266l().mo2290t().equals(gv0Var.m4266l().mo2290t()) && m4267m().mo2290t().equals(gv0Var.m4267m().mo2290t()));
    }

    /* renamed from: k */
    public abstract hv0 mo2306k(BigInteger bigInteger);

    /* renamed from: l */
    public hv0 m4266l() {
        return this.f2988b;
    }

    /* renamed from: m */
    public hv0 m4267m() {
        return this.f2989c;
    }

    /* renamed from: n */
    public BigInteger m4268n() {
        return this.f2991e;
    }

    /* renamed from: o */
    public int m4269o() {
        return this.f2992f;
    }

    /* renamed from: p */
    public FiniteField m4270p() {
        return this.f2987a;
    }

    /* renamed from: q */
    public abstract int mo2307q();

    /* renamed from: r */
    public abstract iv0 mo2308r();

    /* renamed from: s */
    public BigInteger m4271s() {
        return this.f2990d;
    }

    /* renamed from: t */
    public iv0 mo4272t(iv0 iv0Var) {
        if (this == iv0Var.m4937h()) {
            return iv0Var;
        }
        if (iv0Var.m4945r()) {
            return mo2308r();
        }
        iv0 m4949w = iv0Var.m4949w();
        return mo4262f(m4949w.m4942n().mo2290t(), m4949w.mo2645o().mo2290t());
    }

    /* renamed from: u */
    public void m4273u(iv0[] iv0VarArr) {
        m4274v(iv0VarArr, 0, iv0VarArr.length, null);
    }

    /* renamed from: v */
    public void m4274v(iv0[] iv0VarArr, int i, int i2, hv0 hv0Var) {
        m4260b(iv0VarArr, i, i2);
        int m4269o = m4269o();
        if (m4269o == 0 || m4269o == 5) {
            if (hv0Var != null) {
                throw new IllegalArgumentException("'iso' not valid for affine coordinates");
            }
            return;
        }
        hv0[] hv0VarArr = new hv0[i2];
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i + i4;
            iv0 iv0Var = iv0VarArr[i5];
            if (iv0Var != null && (hv0Var != null || !iv0Var.m4946s())) {
                hv0VarArr[i3] = iv0Var.mo4943p(0);
                iArr[i3] = i5;
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        fv0.m3886g(hv0VarArr, 0, i3, hv0Var);
        for (int i6 = 0; i6 < i3; i6++) {
            int i7 = iArr[i6];
            iv0VarArr[i7] = iv0VarArr[i7].m4950x(hv0VarArr[i6]);
        }
    }

    /* renamed from: w */
    public PreCompInfo m4275w(iv0 iv0Var, String str, PreCompCallback preCompCallback) {
        Hashtable hashtable;
        PreCompInfo mo4953a;
        m4259a(iv0Var);
        synchronized (iv0Var) {
            hashtable = iv0Var.f3431e;
            if (hashtable == null) {
                hashtable = new Hashtable(4);
                iv0Var.f3431e = hashtable;
            }
        }
        synchronized (hashtable) {
            PreCompInfo preCompInfo = (PreCompInfo) hashtable.get(str);
            mo4953a = preCompCallback.mo4953a(preCompInfo);
            if (mo4953a != preCompInfo) {
                hashtable.put(str, mo4953a);
            }
        }
        return mo4953a;
    }

    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 0;
    }

    /* renamed from: y */
    public iv0 m4276y(BigInteger bigInteger, BigInteger bigInteger2) {
        iv0 mo4262f = mo4262f(bigInteger, bigInteger2);
        if (mo4262f.m4947t()) {
            return mo4262f;
        }
        throw new IllegalArgumentException("Invalid point coordinates");
    }
}
