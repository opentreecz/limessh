package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class kx0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f4669j = mx0.f5160f;

    /* renamed from: k */
    public static final hv0[] f4670k = {new mx0(ECConstants.f8873b)};

    /* renamed from: i */
    public nx0 f4671i;

    /* renamed from: cz.opentree.kx0$a */
    /* loaded from: classes.dex */
    public class C1477a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f4672a;

        /* renamed from: b */
        public final /* synthetic */ int[] f4673b;

        public C1477a(int i, int[] iArr) {
            this.f4672a = i;
            this.f4673b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m7200k = p01.m7200k(12);
            int[] m7200k2 = p01.m7200k(12);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4672a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 12; i5++) {
                    int i6 = m7200k[i5];
                    int[] iArr = this.f4673b;
                    m7200k[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m7200k2[i5] = m7200k2[i5] ^ (iArr[(i2 + 12) + i5] & i4);
                }
                i2 += 24;
            }
            return m6008c(m7200k, m7200k2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f4672a;
        }

        /* renamed from: c */
        public final iv0 m6008c(int[] iArr, int[] iArr2) {
            return kx0.this.m6007A(new mx0(iArr), new mx0(iArr2), kx0.f4670k);
        }
    }

    public kx0() {
        super(f4669j);
        this.f4671i = new nx0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFF0000000000000000FFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("B3312FA7E23EE7E4988E056BE3F82D19181D9C6EFE8141120314088F5013875AC656398D8A2ED19D2A85C8EDD3EC2AEF")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC7634D81F4372DDF581A0DB248B0A77AECEC196ACCC52973"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m6007A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new nx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new kx0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 12 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            p01.m7198i(12, ((mx0) iv0Var.m4940l()).f5161e, 0, iArr, i3);
            int i5 = i3 + 12;
            p01.m7198i(12, ((mx0) iv0Var.m4941m()).f5161e, 0, iArr, i5);
            i3 = i5 + 12;
        }
        return new C1477a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new nx0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new mx0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f4669j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f4671i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
