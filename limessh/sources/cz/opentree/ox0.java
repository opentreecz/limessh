package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class ox0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f5568j = qx0.f6123f;

    /* renamed from: k */
    public static final hv0[] f5569k = {new qx0(ECConstants.f8873b)};

    /* renamed from: i */
    public rx0 f5570i;

    /* renamed from: cz.opentree.ox0$a */
    /* loaded from: classes.dex */
    public class C1680a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f5571a;

        /* renamed from: b */
        public final /* synthetic */ int[] f5572b;

        public C1680a(int i, int[] iArr) {
            this.f5571a = i;
            this.f5572b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m7200k = p01.m7200k(17);
            int[] m7200k2 = p01.m7200k(17);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f5571a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 17; i5++) {
                    int i6 = m7200k[i5];
                    int[] iArr = this.f5572b;
                    m7200k[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m7200k2[i5] = m7200k2[i5] ^ (iArr[(i2 + 17) + i5] & i4);
                }
                i2 += 34;
            }
            return m7119c(m7200k, m7200k2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f5571a;
        }

        /* renamed from: c */
        public final iv0 m7119c(int[] iArr, int[] iArr2) {
            return ox0.this.m7118A(new qx0(iArr), new qx0(iArr2), ox0.f5569k);
        }
    }

    public ox0() {
        super(f5568j);
        this.f5570i = new rx0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("0051953EB9618E1C9A1F929A21A0B68540EEA2DA725B99B315F3B8B489918EF109E156193951EC7E937B1652C0BD3BB1BF073573DF883D2C34F1EF451FD46B503F00")));
        this.f2990d = new BigInteger(1, o51.m6872a("01FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFA51868783BF2F966B7FCC0148F709A5D03BB5C9B8899C47AEBB6FB71E91386409"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m7118A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new rx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new ox0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 17 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            p01.m7198i(17, ((qx0) iv0Var.m4940l()).f6124e, 0, iArr, i3);
            int i5 = i3 + 17;
            p01.m7198i(17, ((qx0) iv0Var.m4941m()).f6124e, 0, iArr, i5);
            i3 = i5 + 17;
        }
        return new C1680a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new rx0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new qx0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f5568j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f5570i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
