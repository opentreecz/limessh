package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class qv0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f6107j = sv0.f6597f;

    /* renamed from: k */
    public static final BigInteger f6108k;

    /* renamed from: l */
    public static final BigInteger f6109l;

    /* renamed from: m */
    public static final hv0[] f6110m;

    /* renamed from: i */
    public tv0 f6111i;

    /* renamed from: com.sonelli.qv0$a */
    /* loaded from: classes.dex */
    public class C1786a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f6112a;

        /* renamed from: b */
        public final /* synthetic */ int[] f6113b;

        public C1786a(int i, int[] iArr) {
            this.f6112a = i;
            this.f6113b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m5015i = j01.m5015i();
            int[] m5015i2 = j01.m5015i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6112a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 8; i5++) {
                    int i6 = m5015i[i5];
                    int[] iArr = this.f6113b;
                    m5015i[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m5015i2[i5] = m5015i2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return m7799c(m5015i, m5015i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f6112a;
        }

        /* renamed from: c */
        public final iv0 m7799c(int[] iArr, int[] iArr2) {
            return qv0.this.m7798A(new sv0(iArr), new sv0(iArr2), qv0.f6110m);
        }
    }

    static {
        BigInteger bigInteger = new BigInteger(1, o51.m6872a("2AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA984914A144"));
        f6108k = bigInteger;
        f6109l = new BigInteger(1, o51.m6872a("7B425ED097B425ED097B425ED097B425ED097B425ED097B4260B5E9C7710C864"));
        f6110m = new hv0[]{new sv0(ECConstants.f8873b), new sv0(bigInteger)};
    }

    public qv0() {
        super(f6107j);
        this.f6111i = new tv0(this, null, null);
        this.f2988b = mo2306k(f6108k);
        this.f2989c = mo2306k(f6109l);
        this.f2990d = new BigInteger(1, o51.m6872a("1000000000000000000000000000000014DEF9DEA2F79CD65812631A5CF5D3ED"));
        this.f2991e = BigInteger.valueOf(8L);
        this.f2992f = 4;
    }

    /* renamed from: A */
    public iv0 m7798A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new tv0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new qv0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 8 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5012f(((sv0) iv0Var.m4940l()).f6599e, 0, iArr, i3);
            int i5 = i3 + 8;
            j01.m5012f(((sv0) iv0Var.m4941m()).f6599e, 0, iArr, i5);
            i3 = i5 + 8;
        }
        return new C1786a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new tv0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new sv0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f6107j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f6111i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 4;
    }
}
