package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class mw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f5153j = ow0.f5565f;

    /* renamed from: k */
    public static final hv0[] f5154k = {new ow0(ECConstants.f8873b)};

    /* renamed from: i */
    public pw0 f5155i;

    /* renamed from: com.sonelli.mw0$a */
    /* loaded from: classes.dex */
    public class C1576a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f5156a;

        /* renamed from: b */
        public final /* synthetic */ int[] f5157b;

        public C1576a(int i, int[] iArr) {
            this.f5156a = i;
            this.f5157b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m4315h = h01.m4315h();
            int[] m4315h2 = h01.m4315h();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5156a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 6; i5++) {
                    int i6 = m4315h[i5];
                    int[] iArr = this.f5157b;
                    m4315h[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m4315h2[i5] = m4315h2[i5] ^ (iArr[(i2 + 6) + i5] & i4);
                }
                i2 += 12;
            }
            return m6573c(m4315h, m4315h2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f5156a;
        }

        /* renamed from: c */
        public final iv0 m6573c(int[] iArr, int[] iArr2) {
            return mw0.this.m6572A(new ow0(iArr), new ow0(iArr2), mw0.f5154k);
        }
    }

    public mw0() {
        super(f5153j);
        this.f5155i = new pw0(this, null, null);
        this.f2988b = mo2306k(ECConstants.f8872a);
        this.f2989c = mo2306k(BigInteger.valueOf(3L));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFE26F2FC170F69466A74DEFD8D"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m6572A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new pw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new mw0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 6 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            h01.m4312e(((ow0) iv0Var.m4940l()).f5566e, 0, iArr, i3);
            int i5 = i3 + 6;
            h01.m4312e(((ow0) iv0Var.m4941m()).f5566e, 0, iArr, i5);
            i3 = i5 + 6;
        }
        return new C1576a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new pw0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ow0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f5153j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f5155i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
