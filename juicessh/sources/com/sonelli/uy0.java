package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class uy0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f7328j = {new ty0(ECConstants.f8873b)};

    /* renamed from: i */
    public vy0 f7329i;

    /* renamed from: com.sonelli.uy0$a */
    /* loaded from: classes.dex */
    public class C2143a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f7330a;

        /* renamed from: b */
        public final /* synthetic */ long[] f7331b;

        public C2143a(int i, long[] jArr) {
            this.f7330a = i;
            this.f7331b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m5016j = j01.m5016j();
            long[] m5016j2 = j01.m5016j();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f7330a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 4; i4++) {
                    long j2 = m5016j[i4];
                    long[] jArr = this.f7331b;
                    m5016j[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m5016j2[i4] = m5016j2[i4] ^ (jArr[(i2 + 4) + i4] & j);
                }
                i2 += 8;
            }
            return m9089c(m5016j, m5016j2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f7330a;
        }

        /* renamed from: c */
        public final iv0 m9089c(long[] jArr, long[] jArr2) {
            return uy0.this.m9088C(new ty0(jArr), new ty0(jArr2), uy0.f7328j);
        }
    }

    public uy0() {
        super(233, 74, 0, 0);
        this.f7329i = new vy0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(0L));
        this.f2989c = mo2306k(BigInteger.valueOf(1L));
        this.f2990d = new BigInteger(1, o51.m6872a("8000000000000000000000000000069D5BB915BCD46EFB1AD5F173ABDF"));
        this.f2991e = BigInteger.valueOf(4L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m9088C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new vy0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new uy0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 4 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5013g(((ty0) iv0Var.m4940l()).f6867e, 0, jArr, i3);
            int i5 = i3 + 4;
            j01.m5013g(((ty0) iv0Var.m4941m()).f6867e, 0, jArr, i5);
            i3 = i5 + 4;
        }
        return new C2143a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new vy0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ty0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 233;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f7329i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
