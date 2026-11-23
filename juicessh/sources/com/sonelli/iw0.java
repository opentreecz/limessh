package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class iw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f3436j = kw0.f4666f;

    /* renamed from: k */
    public static final hv0[] f3437k = {new kw0(ECConstants.f8873b)};

    /* renamed from: i */
    public lw0 f3438i;

    /* renamed from: com.sonelli.iw0$a */
    /* loaded from: classes.dex */
    public class C1185a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f3439a;

        /* renamed from: b */
        public final /* synthetic */ int[] f3440b;

        public C1185a(int i, int[] iArr) {
            this.f3439a = i;
            this.f3440b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m3907d = g01.m3907d();
            int[] m3907d2 = g01.m3907d();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f3439a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = m3907d[i5];
                    int[] iArr = this.f3440b;
                    m3907d[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m3907d2[i5] = m3907d2[i5] ^ (iArr[(i2 + 5) + i5] & i4);
                }
                i2 += 10;
            }
            return m4964c(m3907d, m3907d2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f3439a;
        }

        /* renamed from: c */
        public final iv0 m4964c(int[] iArr, int[] iArr2) {
            return iw0.this.m4963A(new kw0(iArr), new kw0(iArr2), iw0.f3437k);
        }
    }

    public iw0() {
        super(f3436j);
        this.f3438i = new lw0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFAC70")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("B4E134D3FB59EB8BAB57274904664D5AF50388BA")));
        this.f2990d = new BigInteger(1, o51.m6872a("0100000000000000000000351EE786A818F3A1A16B"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m4963A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new lw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new iw0();
    }

    @Override // com.sonelli.gv0
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
        return new C1185a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new lw0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new kw0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f3436j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f3438i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
