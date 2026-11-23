package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class cx0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f2072j = ex0.f2549f;

    /* renamed from: k */
    public static final hv0[] f2073k = {new ex0(ECConstants.f8873b)};

    /* renamed from: i */
    public fx0 f2074i;

    /* renamed from: cz.opentree.cx0$a */
    /* loaded from: classes.dex */
    public class C0850a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f2075a;

        /* renamed from: b */
        public final /* synthetic */ int[] f2076b;

        public C0850a(int i, int[] iArr) {
            this.f2075a = i;
            this.f2076b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m5015i = j01.m5015i();
            int[] m5015i2 = j01.m5015i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f2075a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 8; i5++) {
                    int i6 = m5015i[i5];
                    int[] iArr = this.f2076b;
                    m5015i[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m5015i2[i5] = m5015i2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return m3056c(m5015i, m5015i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f2075a;
        }

        /* renamed from: c */
        public final iv0 m3056c(int[] iArr, int[] iArr2) {
            return cx0.this.m3055A(new ex0(iArr), new ex0(iArr2), cx0.f2073k);
        }
    }

    public cx0() {
        super(f2072j);
        this.f2074i = new fx0(this, null, null);
        this.f2988b = mo2306k(ECConstants.f8872a);
        this.f2989c = mo2306k(BigInteger.valueOf(7L));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m3055A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new fx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new cx0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 8 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5012f(((ex0) iv0Var.m4940l()).f2550e, 0, iArr, i3);
            int i5 = i3 + 8;
            j01.m5012f(((ex0) iv0Var.m4941m()).f2550e, 0, iArr, i5);
            i3 = i5 + 8;
        }
        return new C0850a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new fx0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ex0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f2072j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f2074i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
