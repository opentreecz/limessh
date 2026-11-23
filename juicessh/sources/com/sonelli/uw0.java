package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class uw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f7312j = ww0.f7803f;

    /* renamed from: k */
    public static final hv0[] f7313k = {new ww0(ECConstants.f8873b)};

    /* renamed from: i */
    public xw0 f7314i;

    /* renamed from: com.sonelli.uw0$a */
    /* loaded from: classes.dex */
    public class C2139a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f7315a;

        /* renamed from: b */
        public final /* synthetic */ int[] f7316b;

        public C2139a(int i, int[] iArr) {
            this.f7315a = i;
            this.f7316b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m4687e = i01.m4687e();
            int[] m4687e2 = i01.m4687e();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f7315a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 7; i5++) {
                    int i6 = m4687e[i5];
                    int[] iArr = this.f7316b;
                    m4687e[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m4687e2[i5] = m4687e2[i5] ^ (iArr[(i2 + 7) + i5] & i4);
                }
                i2 += 14;
            }
            return m9079c(m4687e, m4687e2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f7315a;
        }

        /* renamed from: c */
        public final iv0 m9079c(int[] iArr, int[] iArr2) {
            return uw0.this.m9078A(new ww0(iArr), new ww0(iArr2), uw0.f7313k);
        }
    }

    public uw0() {
        super(f7312j);
        this.f7314i = new xw0(this, null, null);
        this.f2988b = mo2306k(ECConstants.f8872a);
        this.f2989c = mo2306k(BigInteger.valueOf(5L));
        this.f2990d = new BigInteger(1, o51.m6872a("010000000000000000000000000001DCE8D2EC6184CAF0A971769FB1F7"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m9078A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new xw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new uw0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 7 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            i01.m4685c(((ww0) iv0Var.m4940l()).f7805e, 0, iArr, i3);
            int i5 = i3 + 7;
            i01.m4685c(((ww0) iv0Var.m4941m()).f7805e, 0, iArr, i5);
            i3 = i5 + 7;
        }
        return new C2139a(i2, iArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new xw0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ww0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f7312j.bitLength();
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f7314i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
