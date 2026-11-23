package cz.opentree;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECLookupTable;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;

/* loaded from: classes.dex */
public class lv0 {

    /* renamed from: cz.opentree.lv0$a */
    /* loaded from: classes.dex */
    public static class C1526a implements PreCompCallback {

        /* renamed from: a */
        public final /* synthetic */ gv0 f4920a;

        /* renamed from: b */
        public final /* synthetic */ iv0 f4921b;

        public C1526a(gv0 gv0Var, iv0 iv0Var) {
            this.f4920a = gv0Var;
            this.f4921b = iv0Var;
        }

        @Override // org.bouncycastle.math.ec.PreCompCallback
        /* renamed from: a */
        public PreCompInfo mo4953a(PreCompInfo preCompInfo) {
            kv0 kv0Var = preCompInfo instanceof kv0 ? (kv0) preCompInfo : null;
            int m6301a = lv0.m6301a(this.f4920a);
            int i = m6301a > 250 ? 6 : 5;
            int i2 = 1 << i;
            if (m6303b(kv0Var, i2)) {
                return kv0Var;
            }
            int i3 = ((m6301a + i) - 1) / i;
            iv0[] iv0VarArr = new iv0[i + 1];
            iv0VarArr[0] = this.f4921b;
            for (int i4 = 1; i4 < i; i4++) {
                iv0VarArr[i4] = iv0VarArr[i4 - 1].mo4931B(i3);
            }
            iv0VarArr[i] = iv0VarArr[0].mo4930A(iv0VarArr[1]);
            this.f4920a.m4273u(iv0VarArr);
            iv0[] iv0VarArr2 = new iv0[i2];
            iv0VarArr2[0] = iv0VarArr[0];
            for (int i5 = i - 1; i5 >= 0; i5--) {
                iv0 iv0Var = iv0VarArr[i5];
                int i6 = 1 << i5;
                for (int i7 = i6; i7 < i2; i7 += i6 << 1) {
                    iv0VarArr2[i7] = iv0VarArr2[i7 - i6].mo2641a(iv0Var);
                }
            }
            this.f4920a.m4273u(iv0VarArr2);
            kv0 kv0Var2 = new kv0();
            kv0Var2.m6003d(this.f4920a.mo2304e(iv0VarArr2, 0, i2));
            kv0Var2.m6004e(iv0VarArr[i]);
            kv0Var2.m6005f(i);
            return kv0Var2;
        }

        /* renamed from: b */
        public final boolean m6303b(kv0 kv0Var, int i) {
            return kv0Var != null && m6304c(kv0Var.m6000a(), i);
        }

        /* renamed from: c */
        public final boolean m6304c(ECLookupTable eCLookupTable, int i) {
            return eCLookupTable != null && eCLookupTable.mo2311b() >= i;
        }
    }

    /* renamed from: a */
    public static int m6301a(gv0 gv0Var) {
        BigInteger m4271s = gv0Var.m4271s();
        return m4271s == null ? gv0Var.mo2307q() + 1 : m4271s.bitLength();
    }

    /* renamed from: b */
    public static kv0 m6302b(iv0 iv0Var) {
        gv0 m4937h = iv0Var.m4937h();
        return (kv0) m4937h.m4275w(iv0Var, "bc_fixed_point", new C1526a(m4937h, iv0Var));
    }
}
