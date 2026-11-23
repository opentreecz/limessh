package cz.opentree;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECMultiplier;

/* loaded from: classes.dex */
public abstract class ev0 implements ECMultiplier {
    @Override // org.bouncycastle.math.ec.ECMultiplier
    /* renamed from: a */
    public iv0 mo3560a(iv0 iv0Var, BigInteger bigInteger) {
        int signum = bigInteger.signum();
        if (signum == 0 || iv0Var.m4945r()) {
            return iv0Var.m4937h().mo2308r();
        }
        iv0 mo3562c = mo3562c(iv0Var, bigInteger.abs());
        if (signum <= 0) {
            mo3562c = mo3562c.mo2642v();
        }
        m3561b(mo3562c);
        return mo3562c;
    }

    /* renamed from: b */
    public iv0 m3561b(iv0 iv0Var) {
        fv0.m3880a(iv0Var);
        return iv0Var;
    }

    /* renamed from: c */
    public abstract iv0 mo3562c(iv0 iv0Var, BigInteger bigInteger);
}
