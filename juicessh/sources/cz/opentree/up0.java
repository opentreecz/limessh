package cz.opentree;

import java.io.IOException;

/* loaded from: classes.dex */
public abstract class up0 extends eq0 {

    /* renamed from: O */
    public aq0 f7083O;

    /* renamed from: P */
    public xp0 f7084P;

    /* renamed from: Q */
    public eq0 f7085Q;

    /* renamed from: R */
    public int f7086R;

    /* renamed from: S */
    public eq0 f7087S;

    public up0(aq0 aq0Var, xp0 xp0Var, eq0 eq0Var, int i, eq0 eq0Var2) {
        m8971v(aq0Var);
        m8968A(xp0Var);
        m8970u(eq0Var);
        m8972w(i);
        eq0Var2.mo1950f();
        m8973x(eq0Var2);
    }

    public up0(rp0 rp0Var) {
        int i = 0;
        eq0 m8969t = m8969t(rp0Var, 0);
        if (m8969t instanceof aq0) {
            this.f7083O = (aq0) m8969t;
            m8969t = m8969t(rp0Var, 1);
            i = 1;
        }
        if (m8969t instanceof xp0) {
            this.f7084P = (xp0) m8969t;
            i++;
            m8969t = m8969t(rp0Var, i);
        }
        if (!(m8969t instanceof iq0)) {
            this.f7085Q = m8969t;
            i++;
            m8969t = m8969t(rp0Var, i);
        }
        if (rp0Var.m8228f() != i + 1) {
            throw new IllegalArgumentException("input vector too large");
        }
        if (!(m8969t instanceof iq0)) {
            throw new IllegalArgumentException("No tagged object found in vector. Structure doesn't seem to be of type External");
        }
        iq0 iq0Var = (iq0) m8969t;
        m8972w(iq0Var.m4911v());
        this.f7087S = iq0Var.m4910u();
    }

    /* renamed from: A */
    public final void m8968A(xp0 xp0Var) {
        this.f7084P = xp0Var;
    }

    @Override // cz.opentree.zp0
    public int hashCode() {
        aq0 aq0Var = this.f7083O;
        int hashCode = aq0Var != null ? aq0Var.hashCode() : 0;
        xp0 xp0Var = this.f7084P;
        if (xp0Var != null) {
            hashCode ^= xp0Var.hashCode();
        }
        eq0 eq0Var = this.f7085Q;
        if (eq0Var != null) {
            hashCode ^= eq0Var.hashCode();
        }
        return hashCode ^ this.f7087S.hashCode();
    }

    @Override // cz.opentree.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        eq0 eq0Var2;
        xp0 xp0Var;
        aq0 aq0Var;
        if (!(eq0Var instanceof up0)) {
            return false;
        }
        if (this == eq0Var) {
            return true;
        }
        up0 up0Var = (up0) eq0Var;
        aq0 aq0Var2 = this.f7083O;
        if (aq0Var2 != null && ((aq0Var = up0Var.f7083O) == null || !aq0Var.m3549o(aq0Var2))) {
            return false;
        }
        xp0 xp0Var2 = this.f7084P;
        if (xp0Var2 != null && ((xp0Var = up0Var.f7084P) == null || !xp0Var.m3549o(xp0Var2))) {
            return false;
        }
        eq0 eq0Var3 = this.f7085Q;
        if (eq0Var3 == null || ((eq0Var2 = up0Var.f7085Q) != null && eq0Var2.m3549o(eq0Var3))) {
            return this.f7087S.m3549o(up0Var.f7087S);
        }
        return false;
    }

    @Override // cz.opentree.eq0
    /* renamed from: n */
    public int mo2261n() throws IOException {
        return getEncoded().length;
    }

    @Override // cz.opentree.eq0
    /* renamed from: q */
    public boolean mo2262q() {
        return true;
    }

    @Override // cz.opentree.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new yq0(this.f7083O, this.f7084P, this.f7085Q, this.f7086R, this.f7087S);
    }

    @Override // cz.opentree.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new wr0(this.f7083O, this.f7084P, this.f7085Q, this.f7086R, this.f7087S);
    }

    /* renamed from: t */
    public final eq0 m8969t(rp0 rp0Var, int i) {
        if (rp0Var.m8228f() > i) {
            return rp0Var.m8226d(i).mo1950f();
        }
        throw new IllegalArgumentException("too few objects in input vector");
    }

    /* renamed from: u */
    public final void m8970u(eq0 eq0Var) {
        this.f7085Q = eq0Var;
    }

    /* renamed from: v */
    public final void m8971v(aq0 aq0Var) {
        this.f7083O = aq0Var;
    }

    /* renamed from: w */
    public final void m8972w(int i) {
        if (i >= 0 && i <= 2) {
            this.f7086R = i;
            return;
        }
        throw new IllegalArgumentException("invalid encoding value: " + i);
    }

    /* renamed from: x */
    public final void m8973x(eq0 eq0Var) {
        this.f7087S = eq0Var;
    }
}
