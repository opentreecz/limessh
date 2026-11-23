package cz.opentree;

import com.google.firebase.installations.StateListener;
import cz.opentree.vf0;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class tf0 implements StateListener {

    /* renamed from: a */
    public final xf0 f6763a;

    /* renamed from: b */
    public final k60<vf0> f6764b;

    public tf0(xf0 xf0Var, k60<vf0> k60Var) {
        this.f6763a = xf0Var;
        this.f6764b = k60Var;
    }

    @Override // com.google.firebase.installations.StateListener
    /* renamed from: a */
    public boolean mo1909a(bg0 bg0Var, Exception exc) {
        if (!bg0Var.m2466i() && !bg0Var.m2467j() && !bg0Var.m2469l()) {
            return false;
        }
        this.f6764b.m5845d(exc);
        return true;
    }

    @Override // com.google.firebase.installations.StateListener
    /* renamed from: b */
    public boolean mo1910b(bg0 bg0Var) {
        if (!bg0Var.m2468k() || this.f6763a.m9760b(bg0Var)) {
            return false;
        }
        k60<vf0> k60Var = this.f6764b;
        vf0.AbstractC2168a m9221a = vf0.m9221a();
        m9221a.mo5881b(bg0Var.mo2459b());
        m9221a.mo5883d(bg0Var.mo2460c());
        m9221a.mo5882c(bg0Var.mo2465h());
        k60Var.m5844c(m9221a.mo5880a());
        return true;
    }
}
