package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class oy0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f5576j = {new ny0(ECConstants.f8873b)};

    /* renamed from: i */
    public py0 f5577i;

    /* renamed from: com.sonelli.oy0$a */
    /* loaded from: classes.dex */
    public class C1682a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f5578a;

        /* renamed from: b */
        public final /* synthetic */ long[] f5579b;

        public C1682a(int i, long[] jArr) {
            this.f5578a = i;
            this.f5579b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m5016j = j01.m5016j();
            long[] m5016j2 = j01.m5016j();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5578a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 4; i4++) {
                    long j2 = m5016j[i4];
                    long[] jArr = this.f5579b;
                    m5016j[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m5016j2[i4] = m5016j2[i4] ^ (jArr[(i2 + 4) + i4] & j);
                }
                i2 += 8;
            }
            return m7133c(m5016j, m5016j2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f5578a;
        }

        /* renamed from: c */
        public final iv0 m7133c(long[] jArr, long[] jArr2) {
            return oy0.this.m7132C(new ny0(jArr), new ny0(jArr2), oy0.f5576j);
        }
    }

    public oy0() {
        super(193, 15, 0, 0);
        this.f5577i = new py0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("0017858FEB7A98975169E171F77B4087DE098AC8A911DF7B01")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("00FDFB49BFE6C3A89FACADAA7A1E5BBC7CC1C2E5D831478814")));
        this.f2990d = new BigInteger(1, o51.m6872a("01000000000000000000000000C7F34A778F443ACC920EBA49"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m7132C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new py0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new oy0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 4 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5013g(((ny0) iv0Var.m4940l()).f5390e, 0, jArr, i3);
            int i5 = i3 + 4;
            j01.m5013g(((ny0) iv0Var.m4941m()).f5390e, 0, jArr, i5);
            i3 = i5 + 4;
        }
        return new C1682a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new py0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ny0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 193;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f5577i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
