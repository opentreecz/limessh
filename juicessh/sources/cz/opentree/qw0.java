package cz.opentree;

import cz.opentree.gv0;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class qw0 extends gv0.AbstractC1076c {

    /* renamed from: j */
    public static final BigInteger f6116j = sw0.f6601f;

    /* renamed from: k */
    public static final hv0[] f6117k = {new sw0(ECConstants.f8873b)};

    /* renamed from: i */
    public tw0 f6118i;

    /* renamed from: cz.opentree.qw0$a */
    /* loaded from: classes.dex */
    public class C1788a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f6119a;

        /* renamed from: b */
        public final /* synthetic */ int[] f6120b;

        public C1788a(int i, int[] iArr) {
            this.f6119a = i;
            this.f6120b = iArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            int[] m4315h = h01.m4315h();
            int[] m4315h2 = h01.m4315h();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f6119a; i3++) {
                int i4 = ((i3 ^ i) - 1) >> 31;
                for (int i5 = 0; i5 < 6; i5++) {
                    int i6 = m4315h[i5];
                    int[] iArr = this.f6120b;
                    m4315h[i5] = i6 ^ (iArr[i2 + i5] & i4);
                    m4315h2[i5] = m4315h2[i5] ^ (iArr[(i2 + 6) + i5] & i4);
                }
                i2 += 12;
            }
            return m7802c(m4315h, m4315h2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f6119a;
        }

        /* renamed from: c */
        public final iv0 m7802c(int[] iArr, int[] iArr2) {
            return qw0.this.m7801A(new sw0(iArr), new sw0(iArr2), qw0.f6117k);
        }
    }

    public qw0() {
        super(f6116j);
        this.f6118i = new tw0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFFFFFFFFFFFC")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("64210519E59C80E70FA7E9AB72243049FEB8DEECC146B9B1")));
        this.f2990d = new BigInteger(1, o51.m6872a("FFFFFFFFFFFFFFFFFFFFFFFF99DEF836146BC9B1B4D22831"));
        this.f2991e = BigInteger.valueOf(1L);
        this.f2992f = 2;
    }

    /* renamed from: A */
    public iv0 m7801A(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new tw0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new qw0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        int[] iArr = new int[i2 * 6 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            h01.m4312e(((sw0) iv0Var.m4940l()).f6602e, 0, iArr, i3);
            int i5 = i3 + 6;
            h01.m4312e(((sw0) iv0Var.m4941m()).f6602e, 0, iArr, i5);
            i3 = i5 + 6;
        }
        return new C1788a(i2, iArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new tw0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new sw0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return f6116j.bitLength();
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f6118i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 2;
    }
}
