package cz.opentree;

import cz.opentree.gv0;
import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class ay0 extends gv0.AbstractC1075b {

    /* renamed from: j */
    public static final hv0[] f1540j = {new zx0(ECConstants.f8873b)};

    /* renamed from: i */
    public by0 f1541i;

    /* renamed from: cz.opentree.ay0$a */
    /* loaded from: classes.dex */
    public class C0743a extends dv0 {

        /* renamed from: a */
        public final /* synthetic */ int f1542a;

        /* renamed from: b */
        public final /* synthetic */ long[] f1543b;

        public C0743a(int i, long[] jArr) {
            this.f1542a = i;
            this.f1543b = jArr;
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: a */
        public iv0 mo2310a(int i) {
            long[] m4316i = h01.m4316i();
            long[] m4316i2 = h01.m4316i();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f1542a; i3++) {
                long j = ((i3 ^ i) - 1) >> 31;
                for (int i4 = 0; i4 < 3; i4++) {
                    long j2 = m4316i[i4];
                    long[] jArr = this.f1543b;
                    m4316i[i4] = j2 ^ (jArr[i2 + i4] & j);
                    m4316i2[i4] = m4316i2[i4] ^ (jArr[(i2 + 3) + i4] & j);
                }
                i2 += 6;
            }
            return m2312c(m4316i, m4316i2);
        }

        @Override // org.bouncycastle.math.ec.ECLookupTable
        /* renamed from: b */
        public int mo2311b() {
            return this.f1542a;
        }

        /* renamed from: c */
        public final iv0 m2312c(long[] jArr, long[] jArr2) {
            return ay0.this.m2302C(new zx0(jArr), new zx0(jArr2), ay0.f1540j);
        }
    }

    public ay0() {
        super(KeycodeConstants.KEYCODE_F1, 2, 3, 8);
        this.f1541i = new by0(this, null, null);
        this.f2988b = mo2306k(new BigInteger(1, o51.m6872a("07A11B09A76B562144418FF3FF8C2570B8")));
        this.f2989c = mo2306k(new BigInteger(1, o51.m6872a("0217C05610884B63B9C6C7291678F9D341")));
        this.f2990d = new BigInteger(1, o51.m6872a("0400000000000000023123953A9464B54D"));
        this.f2991e = BigInteger.valueOf(2L);
        this.f2992f = 6;
    }

    /* renamed from: C */
    public iv0 m2302C(hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        return new by0(this, hv0Var, hv0Var2, hv0VarArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: c */
    public gv0 mo2303c() {
        return new ay0();
    }

    @Override // cz.opentree.gv0
    /* renamed from: e */
    public ECLookupTable mo2304e(iv0[] iv0VarArr, int i, int i2) {
        long[] jArr = new long[i2 * 3 * 2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            iv0 iv0Var = iv0VarArr[i + i4];
            h01.m4313f(((zx0) iv0Var.m4940l()).f8608e, 0, jArr, i3);
            int i5 = i3 + 3;
            h01.m4313f(((zx0) iv0Var.m4941m()).f8608e, 0, jArr, i5);
            i3 = i5 + 3;
        }
        return new C0743a(i2, jArr);
    }

    @Override // cz.opentree.gv0
    /* renamed from: g */
    public iv0 mo2305g(hv0 hv0Var, hv0 hv0Var2) {
        return new by0(this, hv0Var, hv0Var2);
    }

    @Override // cz.opentree.gv0
    /* renamed from: k */
    public hv0 mo2306k(BigInteger bigInteger) {
        return new zx0(bigInteger);
    }

    @Override // cz.opentree.gv0
    /* renamed from: q */
    public int mo2307q() {
        return KeycodeConstants.KEYCODE_F1;
    }

    @Override // cz.opentree.gv0
    /* renamed from: r */
    public iv0 mo2308r() {
        return this.f1541i;
    }

    @Override // cz.opentree.gv0
    /* renamed from: x */
    public boolean mo2309x(int i) {
        return i == 6;
    }
}
