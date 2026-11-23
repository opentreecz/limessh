package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class ew0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f2542j = gw0.f3017f;

    /* renamed from: k */
    public static final hv0[] f2543k = {new gw0(ECConstants.f8873b)};

    /* renamed from: i */
    public hw0 f2544i;

    /* renamed from: cz.opentree.ew0$a */
    /* loaded from: classes.dex */
    public class C0957a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f2545a;

        /* renamed from: b */
        public final /* synthetic */ int[] f2546b;

        public C0957a(int i, int[] iArr) {
            this.f2545a = i;
            this.f2546b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m3907d = g01.m3907d();
            int[] m3907d2 = g01.m3907d();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f2545a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = m3907d[i5];
                    int[] iArr = this.f2546b;
                    m3907d[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m3907d2[i5] = m3907d2[i5] ^ (iArr[(i2 + 5) + i5] & i4);
                }
                i2 += 10;
            }
            return m3565c(m3907d, m3907d2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f2545a;
        }

        /* renamed from: c */
        public final iv0 m3565c(int[] iArr, int[] iArr2) {
            return ew0.this.m3564A(new gw0(iArr), new gw0(iArr2), ew0.f2543k);
        }
    }

    public ew0() {
        super(f2542j);
        this.f2544i = new hw0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF7FFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("1C97BEFC54BD7A8B65ACF89F81D4D4ADC565FA45")));
        this.f2990d = new BigInteger(1, o51.m6872a("0100000000000000000001F4C8F927AED3CA752257"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m3564A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new hw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new ew0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 5 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            g01.m3906c(((gw0) iv0Var.m4940l()).f3018e, 0, iArr, i3);
            int i5 = i3 + 5;
            g01.m3906c(((gw0) iv0Var.m4941m()).f3018e, 0, iArr, i5);
            i3 = i5 + 5;
        }
        return new C0957a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new hw0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new gw0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f2542j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f2544i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
