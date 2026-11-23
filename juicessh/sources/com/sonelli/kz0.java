package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class kz0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f4685j = {new jz0(ECConstants.f8873b)};

    /* renamed from: i */
    public lz0 f4686i;

    /* renamed from: com.sonelli.kz0$a */
    /* loaded from: classes.dex */
    public class C1481a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f4687a;

        /* renamed from: b */
        public final /* synthetic */ long[] f4688b;

        public C1481a(int i, long[] jArr) {
            this.f4687a = i;
            this.f4688b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m6331c = m01.m6331c();
            long[] m6331c2 = m01.m6331c();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4687a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 7; i4++) {
                    long j2 = m6331c[i4];
                    long[] jArr = this.f4688b;
                    m6331c[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m6331c2[i4] = m6331c2[i4] ^ (jArr[(i2 + 7) + i4] & j);
                }
                i2 += 14;
            }
            return m6016c(m6331c, m6331c2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f4687a;
        }

        /* renamed from: c */
        public final iv0 m6016c(long[] jArr, long[] jArr2) {
            return kz0.this.m6015C(new jz0(jArr), new jz0(jArr2), kz0.f4685j);
        }
    }

    public kz0() {
        super(409, 87, 0, 0);
        this.f4686i = new lz0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(0L));
        this.f2989c = mo2306k(BigInteger.valueOf(1L));
        this.f2990d = new BigInteger(1, o51.m6872a("7FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFE5F83B2D4EA20400EC4557D5ED3E3E7CA5B4B5C83B8E01E5FCF"));
        this.f2991e = BigInteger.valueOf(4L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m6015C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new lz0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new kz0();
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
        return new C1481a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new lz0(this, hv0Var, hv0Var2);
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
        return this.f4686i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
