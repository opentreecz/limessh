package cz.opentree;

import java.math.BigInteger;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;

/* loaded from: classes.dex */
public abstract class pv0 {

    /* renamed from: a */
    public static final int[] f5879a = {13, 41, 121, 337, 897, 2305};

    /* renamed from: cz.opentree.pv0$a */
    /* loaded from: classes.dex */
    public static class C1737a implements PreCompCallback {

        /* renamed from: a */
        public final /* synthetic */ int f5880a;

        public C1737a(int i) {
            this.f5880a = i;
        }

        @Override // org.bouncycastle.math.ec.PreCompCallback
        /* renamed from: a */
        public PreCompInfo mo4953a(PreCompInfo preCompInfo) {
            ov0 ov0Var = preCompInfo instanceof ov0 ? (ov0) preCompInfo : null;
            if (ov0Var != null && ov0Var.m7106a() == this.f5880a) {
                ov0Var.m7114i(0);
                return ov0Var;
            }
            ov0 ov0Var2 = new ov0();
            ov0Var2.m7114i(0);
            ov0Var2.m7111f(this.f5880a);
            if (ov0Var != null) {
                ov0Var2.m7112g(ov0Var.m7107b());
                ov0Var2.m7113h(ov0Var.m7108c());
                ov0Var2.m7115j(ov0Var.m7109d());
                ov0Var2.m7116k(ov0Var.m7110e());
            }
            return ov0Var2;
        }
    }

    /* renamed from: a */
    public static void m7553a(iv0 iv0Var) {
        gv0 m4937h = iv0Var.m4937h();
        if (m4937h == null) {
            return;
        }
        BigInteger m4271s = m4937h.m4271s();
        m4937h.m4275w(iv0Var, "bc_wnaf", new C1737a(Math.min(16, m7554b(m4271s == null ? m4937h.mo2307q() + 1 : m4271s.bitLength()) + 3)));
    }

    /* renamed from: b */
    public static int m7554b(int i) {
        return m7555c(i, f5879a, 16);
    }

    /* renamed from: c */
    public static int m7555c(int i, int[] iArr, int i2) {
        int i3 = 0;
        while (i3 < iArr.length && i >= iArr[i3]) {
            i3++;
        }
        return Math.max(2, Math.min(i2, i3 + 2));
    }
}
