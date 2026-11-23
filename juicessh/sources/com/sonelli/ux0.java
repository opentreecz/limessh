package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class ux0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f7319j = {new tx0(ECConstants.f8873b)};

    /* renamed from: i */
    public vx0 f7320i;

    /* renamed from: com.sonelli.ux0$a */
    /* loaded from: classes.dex */
    public class C2141a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f7321a;

        /* renamed from: b */
        public final /* synthetic */ long[] f7322b;

        public C2141a(int i, long[] jArr) {
            this.f7321a = i;
            this.f7322b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m3631g = f01.m3631g();
            long[] m3631g2 = f01.m3631g();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f7321a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 2; i4++) {
                    long j2 = m3631g[i4];
                    long[] jArr = this.f7322b;
                    m3631g[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m3631g2[i4] = m3631g2[i4] ^ (jArr[(i2 + 2) + i4] & j);
                }
                i2 += 4;
            }
            return m9082c(m3631g, m3631g2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f7321a;
        }

        /* renamed from: c */
        public final iv0 m9082c(long[] jArr, long[] jArr2) {
            return ux0.this.m9081C(new tx0(jArr), new tx0(jArr2), ux0.f7319j);
        }
    }

    public ux0() {
        super(113, 9, 0, 0);
        this.f7320i = new vx0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("003088250CA6E7C7FE649CE85820F7")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("00E8BEE4D3E2260744188BE0E9C723")));
        this.f2990d = new BigInteger(1, o51.m6872a("0100000000000000D9CCEC8A39E56F"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m9081C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new vx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new ux0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 2 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            f01.m3628d(((tx0) iv0Var.m4940l()).f6866e, 0, jArr, i3);
            int i5 = i3 + 2;
            f01.m3628d(((tx0) iv0Var.m4941m()).f6866e, 0, jArr, i5);
            i3 = i5 + 2;
        }
        return new C2141a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new vx0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new tx0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 113;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f7320i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
