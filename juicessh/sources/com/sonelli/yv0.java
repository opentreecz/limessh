package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class yv0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f8334j = aw0.f1534f;

    /* renamed from: k */
    public static final hv0[] f8335k = {new aw0(ECConstants.f8873b)};

    /* renamed from: i */
    public bw0 f8336i;

    /* renamed from: com.sonelli.yv0$a */
    /* loaded from: classes.dex */
    public class C2395a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f8337a;

        /* renamed from: b */
        public final /* synthetic */ int[] f8338b;

        public C2395a(int i, int[] iArr) {
            this.f8337a = i;
            this.f8338b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m3630f = f01.m3630f();
            int[] m3630f2 = f01.m3630f();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f8337a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = m3630f[i5];
                    int[] iArr = this.f8338b;
                    m3630f[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m3630f2[i5] = m3630f2[i5] ^ (iArr[(i2 + 4) + i5] & i4);
                }
                i2 += 8;
            }
            return m10232c(m3630f, m3630f2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f8337a;
        }

        /* renamed from: c */
        public final iv0 m10232c(int[] iArr, int[] iArr2) {
            return yv0.this.m10231A(new aw0(iArr), new aw0(iArr2), yv0.f8335k);
        }
    }

    public yv0() {
        super(f8334j);
        this.f8336i = new bw0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFDFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("E87579C11079F43DD824993C2CEE5ED3")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFE0000000075A30D1B9038A115"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m10231A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new bw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new yv0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 4 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            f01.m3627c(((aw0) iv0Var.m4940l()).f1535e, 0, iArr, i3);
            int i5 = i3 + 4;
            f01.m3627c(((aw0) iv0Var.m4941m()).f1535e, 0, iArr, i5);
            i3 = i5 + 4;
        }
        return new C2395a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new bw0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new aw0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f8334j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f8336i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
