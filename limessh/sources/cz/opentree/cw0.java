package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class cw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f2065j = kw0.f4666f;

    /* renamed from: k */
    public static final hv0[] f2066k = {new kw0(ECConstants.f8873b)};

    /* renamed from: i */
    public dw0 f2067i;

    /* renamed from: cz.opentree.cw0$a */
    /* loaded from: classes.dex */
    public class C0848a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f2068a;

        /* renamed from: b */
        public final /* synthetic */ int[] f2069b;

        public C0848a(int i, int[] iArr) {
            this.f2068a = i;
            this.f2069b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m3907d = g01.m3907d();
            int[] m3907d2 = g01.m3907d();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f2068a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = m3907d[i5];
                    int[] iArr = this.f2069b;
                    m3907d[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m3907d2[i5] = m3907d2[i5] ^ (iArr[(i2 + 5) + i5] & i4);
                }
                i2 += 10;
            }
            return m3053c(m3907d, m3907d2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f2068a;
        }

        /* renamed from: c */
        public final iv0 m3053c(int[] iArr, int[] iArr2) {
            return cw0.this.m3052A(new kw0(iArr), new kw0(iArr2), cw0.f2066k);
        }
    }

    public cw0() {
        super(f2065j);
        this.f2067i = new dw0(this, null, null);
        this.f2988b = mo2306k(ECConstants.f8872a);
        this.f2989c = mo2306k(BigInteger.valueOf(7L));
        this.f2990d = new BigInteger(1, o51.m6872a("0100000000000000000001B8FA16DFAB9ACA16B6B3"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m3052A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new dw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new cw0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 5 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            g01.m3906c(((kw0) iv0Var.m4940l()).f4667e, 0, iArr, i3);
            int i5 = i3 + 5;
            g01.m3906c(((kw0) iv0Var.m4941m()).f4667e, 0, iArr, i5);
            i3 = i5 + 5;
        }
        return new C0848a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new dw0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new kw0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f2065j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f2067i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
