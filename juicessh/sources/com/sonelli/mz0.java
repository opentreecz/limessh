package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class mz0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f5164j = {new jz0(ECConstants.f8873b)};

    /* renamed from: i */
    public nz0 f5165i;

    /* renamed from: com.sonelli.mz0$a */
    /* loaded from: classes.dex */
    public class C1580a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f5166a;

        /* renamed from: b */
        public final /* synthetic */ long[] f5167b;

        public C1580a(int i, long[] jArr) {
            this.f5166a = i;
            this.f5167b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m6331c = m01.m6331c();
            long[] m6331c2 = m01.m6331c();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5166a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 7; i4++) {
                    long j2 = m6331c[i4];
                    long[] jArr = this.f5167b;
                    m6331c[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m6331c2[i4] = m6331c2[i4] ^ (jArr[(i2 + 7) + i4] & j);
                }
                i2 += 14;
            }
            return m6597c(m6331c, m6331c2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f5166a;
        }

        /* renamed from: c */
        public final iv0 m6597c(long[] jArr, long[] jArr2) {
            return mz0.this.m6596C(new jz0(jArr), new jz0(jArr2), mz0.f5164j);
        }
    }

    public mz0() {
        super(409, 87, 0, 0);
        this.f5165i = new nz0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(1L));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("0021A5C2C8EE9FEB5C4B9A753B7B476B7FD6422EF1F3DD674761FA99D6AC27C8A9A197B272822F6CD57A55AA4F50AE317B13545F")));
        this.f2990d = new BigInteger(1, o51.m6872a("010000000000000000000000000000000000000000000000000001E2AAD6A612F33307BE5FA47C3C9E052F838164CD37D9A21173"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m6596C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new nz0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new mz0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 7 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            m01.m6329a(((jz0) iv0Var.m4940l()).f4398e, 0, jArr, i3);
            int i5 = i3 + 7;
            m01.m6329a(((jz0) iv0Var.m4941m()).f4398e, 0, jArr, i5);
            i3 = i5 + 7;
        }
        return new C1580a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new nz0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new jz0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 409;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f5165i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
