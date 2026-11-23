package com.sonelli;

import com.sonelli.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class qz0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f6141j = {new pz0(ECConstants.f8873b)};

    /* renamed from: i */
    public rz0 f6142i;

    /* renamed from: com.sonelli.qz0$a */
    /* loaded from: classes.dex */
    public class C1793a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f6143a;

        /* renamed from: b */
        public final /* synthetic */ long[] f6144b;

        public C1793a(int i, long[] jArr) {
            this.f6143a = i;
            this.f6144b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m6827c = o01.m6827c();
            long[] m6827c2 = o01.m6827c();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6143a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 9; i4++) {
                    long j2 = m6827c[i4];
                    long[] jArr = this.f6144b;
                    m6827c[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m6827c2[i4] = m6827c2[i4] ^ (jArr[(i2 + 9) + i4] & j);
                }
                i2 += 18;
            }
            return m7832c(m6827c, m6827c2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f6143a;
        }

        /* renamed from: c */
        public final iv0 m7832c(long[] jArr, long[] jArr2) {
            return qz0.this.m7831C(new pz0(jArr), new pz0(jArr2), qz0.f6141j);
        }
    }

    public qz0() {
        super(571, 2, 5, 10);
        this.f6142i = new rz0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(0L));
        this.f2989c = mo2306k(BigInteger.valueOf(1L));
        this.f2990d = new BigInteger(1, o51.m6872a("020000000000000000000000000000000000000000000000000000000000000000000000131850E1F19A63E4B391A8DB917F4138B630D84BE5D639381E91DEB45CFE778F637C1001"));
        this.f2991e = BigInteger.valueOf(4L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m7831C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new rz0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new qz0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 9 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            o01.m6825a(((pz0) iv0Var.m4940l()).f5898e, 0, jArr, i3);
            int i5 = i3 + 9;
            o01.m6825a(((pz0) iv0Var.m4941m()).f5898e, 0, jArr, i5);
            i3 = i5 + 9;
        }
        return new C1793a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new rz0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new pz0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 571;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f6142i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
