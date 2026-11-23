package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class gz0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f3037j = {new dz0(ECConstants.f8873b)};

    /* renamed from: i */
    public hz0 f3038i;

    /* renamed from: com.sonelli.gz0$a */
    /* loaded from: classes.dex */
    public class C1086a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f3039a;

        /* renamed from: b */
        public final /* synthetic */ long[] f3040b;

        public C1086a(int i, long[] jArr) {
            this.f3039a = i;
            this.f3040b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m5766c = k01.m5766c();
            long[] m5766c2 = k01.m5766c();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f3039a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 5; i4++) {
                    long j2 = m5766c[i4];
                    long[] jArr = this.f3040b;
                    m5766c[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m5766c2[i4] = m5766c2[i4] ^ (jArr[(i2 + 5) + i4] & j);
                }
                i2 += 10;
            }
            return m4295c(m5766c, m5766c2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f3039a;
        }

        /* renamed from: c */
        public final iv0 m4295c(long[] jArr, long[] jArr2) {
            return gz0.this.m4294C(new dz0(jArr), new dz0(jArr2), gz0.f3037j);
        }
    }

    public gz0() {
        super(283, 5, 7, 12);
        this.f3038i = new hz0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(1L));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("027B680AC8B8596DA5A4AF8A19A0303FCA97FD7645309FA2A581485AF6263E313B79A2F5")));
        this.f2990d = new BigInteger(1, o51.m6872a("03FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEF90399660FC938A90165B042A7CEFADB307"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m4294C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new hz0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new gz0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 5 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            k01.m5764a(((dz0) iv0Var.m4940l()).f2305e, 0, jArr, i3);
            int i5 = i3 + 5;
            k01.m5764a(((dz0) iv0Var.m4941m()).f2305e, 0, jArr, i5);
            i3 = i5 + 5;
        }
        return new C1086a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new hz0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new dz0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 283;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f3038i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
