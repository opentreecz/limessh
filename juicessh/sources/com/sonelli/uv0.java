package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class uv0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f7305j = wv0.f7800f;

    /* renamed from: k */
    public static final hv0[] f7306k = {new wv0(ECConstants.f8873b)};

    /* renamed from: i */
    public xv0 f7307i;

    /* renamed from: com.sonelli.uv0$a */
    /* loaded from: classes.dex */
    public class C2137a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f7308a;

        /* renamed from: b */
        public final /* synthetic */ int[] f7309b;

        public C2137a(int i, int[] iArr) {
            this.f7308a = i;
            this.f7309b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m5015i = j01.m5015i();
            int[] m5015i2 = j01.m5015i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f7308a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 8; i5++) {
                    int i6 = m5015i[i5];
                    int[] iArr = this.f7309b;
                    m5015i[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m5015i2[i5] = m5015i2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return m9076c(m5015i, m5015i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f7308a;
        }

        /* renamed from: c */
        public final iv0 m9076c(int[] iArr, int[] iArr2) {
            return uv0.this.m9075A(new wv0(iArr), new wv0(iArr2), uv0.f7306k);
        }
    }

    public uv0() {
        super(f7305j);
        this.f7307i = new xv0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF00000000FFFFFFFFFFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("28E9FA9E9D9F5E344D5A9E4BCF6509A7F39789F515AB8F92DDBCBD414D940E93")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFEFFFFFFFFFFFFFFFFFFFFFFFF7203DF6B21C6052B53BBF40939D54123"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m9075A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new xv0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new uv0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 8 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5012f(((wv0) iv0Var.m4940l()).f7801e, 0, iArr, i3);
            int i5 = i3 + 8;
            j01.m5012f(((wv0) iv0Var.m4941m()).f7801e, 0, iArr, i5);
            i3 = i5 + 8;
        }
        return new C2137a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new xv0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new wv0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f7305j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f7307i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
