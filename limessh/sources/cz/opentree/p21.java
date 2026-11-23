package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import cz.opentree.t21;
import cz.opentree.v21;
import cz.opentree.w21;
import java.io.Serializable;
import java.util.Objects;
import java.util.Stack;

/* loaded from: classes.dex */
public class p21 implements Serializable, Cloneable {

    /* renamed from: O */
    public h31 f5595O;

    /* renamed from: P */
    public final int f5596P;

    /* renamed from: Q */
    public int f5597Q;

    /* renamed from: R */
    public int f5598R;

    /* renamed from: S */
    public boolean f5599S = false;

    /* renamed from: T */
    public boolean f5600T = false;

    public p21(int i) {
        this.f5596P = i;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public p21 clone() {
        p21 p21Var = new p21(this.f5596P);
        p21Var.f5595O = this.f5595O;
        p21Var.f5597Q = this.f5597Q;
        p21Var.f5598R = this.f5598R;
        p21Var.f5599S = this.f5599S;
        p21Var.f5600T = this.f5600T;
        return p21Var;
    }

    /* renamed from: c */
    public int m7222c() {
        return (!this.f5599S || this.f5600T) ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : this.f5597Q;
    }

    /* renamed from: d */
    public int m7223d() {
        return this.f5598R;
    }

    /* renamed from: e */
    public h31 m7224e() {
        return this.f5595O;
    }

    /* renamed from: i */
    public void m7225i(int i) {
        this.f5595O = null;
        this.f5597Q = this.f5596P;
        this.f5598R = i;
        this.f5599S = true;
        this.f5600T = false;
    }

    /* renamed from: j */
    public boolean m7226j() {
        return this.f5600T;
    }

    /* renamed from: k */
    public boolean m7227k() {
        return this.f5599S;
    }

    /* renamed from: l */
    public void m7228l(h31 h31Var) {
        this.f5595O = h31Var;
        int m4347a = h31Var.m4347a();
        this.f5597Q = m4347a;
        if (m4347a == this.f5596P) {
            this.f5600T = true;
        }
    }

    /* renamed from: m */
    public void m7229m(Stack<h31> stack, x21 x21Var, byte[] bArr, byte[] bArr2, w21 w21Var) {
        Objects.requireNonNull(w21Var, "otsHashAddress == null");
        if (this.f5600T || !this.f5599S) {
            throw new IllegalStateException("finished or not initialized");
        }
        w21.C2198b m2370h = new w21.C2198b().m2369g(w21Var.m2360b()).m2370h(w21Var.m2361c());
        m2370h.m9400p(this.f5598R);
        m2370h.m9398n(w21Var.m9390e());
        m2370h.m9399o(w21Var.m9391f());
        w21 w21Var2 = (w21) m2370h.m2368f(w21Var.m2359a()).m9396l();
        v21.C2150b m2370h2 = new v21.C2150b().m2369g(w21Var2.m2360b()).m2370h(w21Var2.m2361c());
        m2370h2.m9155n(this.f5598R);
        v21 v21Var = (v21) m2370h2.m9153l();
        t21.C1897b m2370h3 = new t21.C1897b().m2369g(w21Var2.m2360b()).m2370h(w21Var2.m2361c());
        m2370h3.m8585n(this.f5598R);
        t21 t21Var = (t21) m2370h3.m8582k();
        x21Var.m9681h(x21Var.m9680g(bArr2, w21Var2), bArr);
        h31 m4713a = i31.m4713a(x21Var, x21Var.m9678e(w21Var2), v21Var);
        while (!stack.isEmpty() && stack.peek().m4347a() == m4713a.m4347a() && stack.peek().m4347a() != this.f5596P) {
            t21.C1897b m2370h4 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
            m2370h4.m8584m(t21Var.m8578e());
            m2370h4.m8585n((t21Var.m8579f() - 1) / 2);
            t21 t21Var2 = (t21) m2370h4.m2368f(t21Var.m2359a()).m8582k();
            h31 m4714b = i31.m4714b(x21Var, stack.pop(), m4713a, t21Var2);
            h31 h31Var = new h31(m4714b.m4347a() + 1, m4714b.m4348b());
            t21.C1897b m2370h5 = new t21.C1897b().m2369g(t21Var2.m2360b()).m2370h(t21Var2.m2361c());
            m2370h5.m8584m(t21Var2.m8578e() + 1);
            m2370h5.m8585n(t21Var2.m8579f());
            t21Var = (t21) m2370h5.m2368f(t21Var2.m2359a()).m8582k();
            m4713a = h31Var;
        }
        h31 h31Var2 = this.f5595O;
        if (h31Var2 == null) {
            this.f5595O = m4713a;
        } else if (h31Var2.m4347a() == m4713a.m4347a()) {
            t21.C1897b m2370h6 = new t21.C1897b().m2369g(t21Var.m2360b()).m2370h(t21Var.m2361c());
            m2370h6.m8584m(t21Var.m8578e());
            m2370h6.m8585n((t21Var.m8579f() - 1) / 2);
            t21 t21Var3 = (t21) m2370h6.m2368f(t21Var.m2359a()).m8582k();
            m4713a = new h31(this.f5595O.m4347a() + 1, i31.m4714b(x21Var, this.f5595O, m4713a, t21Var3).m4348b());
            this.f5595O = m4713a;
            t21.C1897b m2370h7 = new t21.C1897b().m2369g(t21Var3.m2360b()).m2370h(t21Var3.m2361c());
            m2370h7.m8584m(t21Var3.m8578e() + 1);
            m2370h7.m8585n(t21Var3.m8579f());
        } else {
            stack.push(m4713a);
        }
        if (this.f5595O.m4347a() == this.f5596P) {
            this.f5600T = true;
        } else {
            this.f5597Q = m4713a.m4347a();
            this.f5598R++;
        }
    }
}
