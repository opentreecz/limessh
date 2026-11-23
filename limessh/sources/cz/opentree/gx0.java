package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class gx0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f3020j = ix0.f3443f;

    /* renamed from: k */
    public static final hv0[] f3021k = {new ix0(ECConstants.f8873b)};

    /* renamed from: i */
    public jx0 f3022i;

    /* renamed from: cz.opentree.gx0$a */
    /* loaded from: classes.dex */
    public class C1082a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f3023a;

        /* renamed from: b */
        public final /* synthetic */ int[] f3024b;

        public C1082a(int i, int[] iArr) {
            this.f3023a = i;
            this.f3024b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m5015i = j01.m5015i();
            int[] m5015i2 = j01.m5015i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f3023a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 8; i5++) {
                    int i6 = m5015i[i5];
                    int[] iArr = this.f3024b;
                    m5015i[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m5015i2[i5] = m5015i2[i5] ^ (iArr[(i2 + 8) + i5] & i4);
                }
                i2 += 16;
            }
            return m4287c(m5015i, m5015i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f3023a;
        }

        /* renamed from: c */
        public final iv0 m4287c(int[] iArr, int[] iArr2) {
            return gx0.this.m4286A(new ix0(iArr), new ix0(iArr2), gx0.f3021k);
        }
    }

    public gx0() {
        super(f3020j);
        this.f3022i = new jx0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFF00000001000000000000000000000000FFFFFFFFFFFFFFFFFFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("5AC635D8AA3A93E7B3EBBD55769886BC651D06B0CC53B0F63BCE3C3E27D2604B")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFF00000000FFFFFFFFFFFFFFFFBCE6FAADA7179E84F3B9CAC2FC632551"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m4286A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new jx0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new gx0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 8 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            j01.m5012f(((ix0) iv0Var.m4940l()).f3444e, 0, iArr, i3);
            int i5 = i3 + 8;
            j01.m5012f(((ix0) iv0Var.m4941m()).f3444e, 0, iArr, i5);
            i3 = i5 + 8;
        }
        return new C1082a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new jx0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new ix0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f3020j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f3022i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
