package com.sonelli;

import com.sonelli.gv0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class ky0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f4676j = {new fy0(ECConstants.f8873b)};

    /* renamed from: i */
    public ly0 f4677i;

    /* renamed from: com.sonelli.ky0$a */
    /* loaded from: classes.dex */
    public class C1479a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f4678a;

        /* renamed from: b */
        public final /* synthetic */ long[] f4679b;

        public C1479a(int i, long[] jArr) {
            this.f4678a = i;
            this.f4679b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m4316i = h01.m4316i();
            long[] m4316i2 = h01.m4316i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f4678a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 3; i4++) {
                    long j2 = m4316i[i4];
                    long[] jArr = this.f4679b;
                    m4316i[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m4316i2[i4] = m4316i2[i4] ^ (jArr[(i2 + 3) + i4] & j);
                }
                i2 += 6;
            }
            return m6011c(m4316i, m4316i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f4678a;
        }

        /* renamed from: c */
        public final iv0 m6011c(long[] jArr, long[] jArr2) {
            return ky0.this.m6010C(new fy0(jArr), new fy0(jArr2), ky0.f4676j);
        }
    }

    public ky0() {
        super(KeycodeConstants.KEYCODE_NUMPAD_RIGHT_PAREN, 3, 6, 7);
        this.f4677i = new ly0(this, null, null);
        this.f2988b = mo2306k(BigInteger.valueOf(1L));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("020A601907B8C953CA1481EB10512F78744A3205FD")));
        this.f2990d = new BigInteger(1, o51.m6872a("040000000000000000000292FE77E70C12A4234C33"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m6010C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new ly0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new ky0();
    }

    @Override // com.sonelli.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 3 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            h01.m4313f(((fy0) iv0Var.m4940l()).f2781e, 0, jArr, i3);
            int i5 = i3 + 3;
            h01.m4313f(((fy0) iv0Var.m4941m()).f2781e, 0, jArr, i5);
            i3 = i5 + 3;
        }
        return new C1479a(i2, jArr);
    }

    @Override // com.sonelli.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new ly0(this, hv0Var, hv0Var2);
    }

    @Override // com.sonelli.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new fy0(bigInteger);
    }

    @Override // com.sonelli.gv0
    /* renamed from: q */
    public int mo2307q() {
        return KeycodeConstants.KEYCODE_NUMPAD_RIGHT_PAREN;
    }

    @Override // com.sonelli.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f4677i;
    }

    @Override // com.sonelli.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
