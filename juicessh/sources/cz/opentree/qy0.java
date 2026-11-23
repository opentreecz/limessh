package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class qy0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f6128j = {new ny0(ECConstants.f8873b)};

    /* renamed from: i */
    public ry0 f6129i;

    /* renamed from: cz.opentree.qy0$a */
    /* loaded from: classes.dex */
    public class C1791a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f6130a;

        /* renamed from: b */
        public final /* synthetic */ long[] f6131b;

        public C1791a(int i, long[] jArr) {
            this.f6130a = i;
            this.f6131b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m5016j = j01.m5016j();
            long[] m5016j2 = j01.m5016j();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6130a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 4; i4++) {
                    long j2 = m5016j[i4];
                    long[] jArr = this.f6131b;
                    m5016j[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m5016j2[i4] = m5016j2[i4] ^ (jArr[(i2 + 4) + i4] & j);
                }
                i2 += 8;
            }
            return m7813c(m5016j, m5016j2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f6130a;
        }

        /* renamed from: c */
        public final iv0 m7813c(long[] jArr, long[] jArr2) {
            return qy0.this.m7812C(new ny0(jArr), new ny0(jArr2), qy0.f6128j);
        }
    }

    public qy0() {
        super(193, 15, 0, 0);
        this.f6129i = new ry0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("0163F35A5137C2CE3EA6ED8667190B0BC43ECD69977702709B")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("00C9BB9E8927D4D64C377E2AB2856A5B16E3EFB7F61D4316AE")));
        this.f2990d = new BigInteger(1, o51.m6872a("010000000000000000000000015AAB561B005413CCD4EE99D5"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m7812C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new ry0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new qy0();
    }

    @Override // cz.opentree.gv0
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
        return new C1791a(i2, jArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new ry0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ny0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return 193;
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f6129i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
