package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class yw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f8341j = ax0.f1537f;

    /* renamed from: k */
    public static final hv0[] f8342k = {new ax0(ECConstants.f8873b)};

    /* renamed from: i */
    public bx0 f8343i;

    /* renamed from: cz.opentree.yw0$a */
    /* loaded from: classes.dex */
    public class C2397a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f8344a;

        /* renamed from: b */
        public final /* synthetic */ int[] f8345b;

        public C2397a(int i, int[] iArr) {
            this.f8344a = i;
            this.f8345b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m4687e = i01.m4687e();
            int[] m4687e2 = i01.m4687e();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f8344a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 7; i5++) {
                    int i6 = m4687e[i5];
                    int[] iArr = this.f8345b;
                    m4687e[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m4687e2[i5] = m4687e2[i5] ^ (iArr[(i2 + 7) + i5] & i4);
                }
                i2 += 14;
            }
            return m10235c(m4687e, m4687e2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f8344a;
        }

        /* renamed from: c */
        public final iv0 m10235c(int[] iArr, int[] iArr2) {
            return yw0.this.m10234A(new ax0(iArr), new ax0(iArr2), yw0.f8342k);
        }
    }

    public yw0() {
        super(f8341j);
        this.f8343i = new bx0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFE")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("B4050A850C04B3ABF54132565044B0B7D7BFD8BA270B39432355FFB4")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFF16A2E0B8F03E13DD29455C5C2A3D"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m10234A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new bx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new yw0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 7 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            i01.m4685c(((ax0) iv0Var.m4940l()).f1538e, 0, iArr, i3);
            int i5 = i3 + 7;
            i01.m4685c(((ax0) iv0Var.m4941m()).f1538e, 0, iArr, i5);
            i3 = i5 + 7;
        }
        return new C2397a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new bx0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ax0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f8341j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f8343i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
