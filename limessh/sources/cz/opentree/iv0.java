package cz.opentree;

import cz.opentree.gv0;
import cz.opentree.hv0;
import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.PreCompCallback;
import org.bouncycastle.math.ec.PreCompInfo;

/* loaded from: classes.dex */
public abstract class iv0 {

    /* renamed from: f */
    public static final hv0[] f3426f = new hv0[0];

    /* renamed from: a */
    public gv0 f3427a;

    /* renamed from: b */
    public hv0 f3428b;

    /* renamed from: c */
    public hv0 f3429c;

    /* renamed from: d */
    public hv0[] f3430d;

    /* renamed from: e */
    public Hashtable f3431e;

    /* renamed from: cz.opentree.iv0$a */
    /* loaded from: classes.dex */
    public class C1179a implements PreCompCallback {

        /* renamed from: a */
        public final /* synthetic */ boolean f3432a;

        /* renamed from: b */
        public final /* synthetic */ boolean f3433b;

        public C1179a(boolean z, boolean z2) {
            this.f3432a = z;
            this.f3433b = z2;
        }

        @Override // org.bouncycastle.math.ec.PreCompCallback
        /* renamed from: a */
        public PreCompInfo mo4953a(PreCompInfo preCompInfo) {
            nv0 nv0Var = preCompInfo instanceof nv0 ? (nv0) preCompInfo : null;
            if (nv0Var == null) {
                nv0Var = new nv0();
            }
            if (nv0Var.m6800b()) {
                return nv0Var;
            }
            if (!nv0Var.m6799a()) {
                if (!this.f3432a && !iv0.this.mo4951y()) {
                    nv0Var.m6803e();
                    return nv0Var;
                }
                nv0Var.m6802d();
            }
            if (this.f3433b && !nv0Var.m6801c()) {
                if (!iv0.this.mo4952z()) {
                    nv0Var.m6803e();
                    return nv0Var;
                }
                nv0Var.m6804f();
            }
            return nv0Var;
        }
    }

    /* renamed from: cz.opentree.iv0$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1180b extends iv0 {
        public AbstractC1180b(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
            super(gv0Var, hv0Var, hv0Var2);
        }

        public AbstractC1180b(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
            super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
        }

        @Override // cz.opentree.iv0
        /* renamed from: A */
        public iv0 mo4930A(iv0 iv0Var) {
            return iv0Var.m4945r() ? this : mo2641a(iv0Var.mo2642v());
        }

        @Override // cz.opentree.iv0
        /* renamed from: y */
        public boolean mo4951y() {
            hv0 mo3339l;
            hv0 mo3340p;
            gv0 m4937h = m4937h();
            hv0 hv0Var = this.f3428b;
            hv0 m4266l = m4937h.m4266l();
            hv0 m4267m = m4937h.m4267m();
            int m4269o = m4937h.m4269o();
            if (m4269o != 6) {
                hv0 hv0Var2 = this.f3429c;
                hv0 mo2284j = hv0Var2.mo2277a(hv0Var).mo2284j(hv0Var2);
                if (m4269o != 0) {
                    if (m4269o != 1) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    hv0 hv0Var3 = this.f3430d[0];
                    if (!hv0Var3.mo2282h()) {
                        hv0 mo2284j2 = hv0Var3.mo2284j(hv0Var3.mo2287o());
                        mo2284j = mo2284j.mo2284j(hv0Var3);
                        m4266l = m4266l.mo2284j(hv0Var3);
                        m4267m = m4267m.mo2284j(mo2284j2);
                    }
                }
                return mo2284j.equals(hv0Var.mo2277a(m4266l).mo2284j(hv0Var.mo2287o()).mo2277a(m4267m));
            }
            hv0 hv0Var4 = this.f3430d[0];
            boolean mo2282h = hv0Var4.mo2282h();
            if (hv0Var.mo2283i()) {
                hv0 mo2287o = this.f3429c.mo2287o();
                if (!mo2282h) {
                    m4267m = m4267m.mo2284j(hv0Var4.mo2287o());
                }
                return mo2287o.equals(m4267m);
            }
            hv0 hv0Var5 = this.f3429c;
            hv0 mo2287o2 = hv0Var.mo2287o();
            if (mo2282h) {
                mo3339l = hv0Var5.mo2287o().mo2277a(hv0Var5).mo2277a(m4266l);
                mo3340p = mo2287o2.mo2287o().mo2277a(m4267m);
            } else {
                hv0 mo2287o3 = hv0Var4.mo2287o();
                hv0 mo2287o4 = mo2287o3.mo2287o();
                mo3339l = hv0Var5.mo2277a(hv0Var4).mo3339l(hv0Var5, m4266l, mo2287o3);
                mo3340p = mo2287o2.mo3340p(m4267m, mo2287o4);
            }
            return mo3339l.mo2284j(mo2287o2).equals(mo3340p);
        }

        @Override // cz.opentree.iv0
        /* renamed from: z */
        public boolean mo4952z() {
            BigInteger m4268n = this.f3427a.m4268n();
            if (ECConstants.f8874c.equals(m4268n)) {
                return ((hv0.AbstractC1129a) m4949w().m4935e()).mo3344w() != 0;
            }
            if (!ECConstants.f8875d.equals(m4268n)) {
                return super.mo4952z();
            }
            iv0 m4949w = m4949w();
            hv0 m4935e = m4949w.m4935e();
            gv0 gv0Var = this.f3427a;
            hv0 m4279A = ((gv0.AbstractC1075b) gv0Var).m4279A(m4935e.mo2277a(gv0Var.m4266l()));
            if (m4279A == null) {
                return false;
            }
            return ((hv0.AbstractC1129a) m4935e.mo2284j(m4279A).mo2277a(m4949w.m4936f())).mo3344w() == 0;
        }
    }

    /* renamed from: cz.opentree.iv0$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1181c extends iv0 {
        public AbstractC1181c(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
            super(gv0Var, hv0Var, hv0Var2);
        }

        public AbstractC1181c(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
            super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
        }

        @Override // cz.opentree.iv0
        /* renamed from: A */
        public iv0 mo4930A(iv0 iv0Var) {
            return iv0Var.m4945r() ? this : mo2641a(iv0Var.mo2642v());
        }

        @Override // cz.opentree.iv0
        /* renamed from: g */
        public boolean mo2644g() {
            return m4936f().mo2289s();
        }

        @Override // cz.opentree.iv0
        /* renamed from: y */
        public boolean mo4951y() {
            hv0 hv0Var = this.f3428b;
            hv0 hv0Var2 = this.f3429c;
            hv0 m4266l = this.f3427a.m4266l();
            hv0 m4267m = this.f3427a.m4267m();
            hv0 mo2287o = hv0Var2.mo2287o();
            int m4938i = m4938i();
            if (m4938i != 0) {
                if (m4938i == 1) {
                    hv0 hv0Var3 = this.f3430d[0];
                    if (!hv0Var3.mo2282h()) {
                        hv0 mo2287o2 = hv0Var3.mo2287o();
                        hv0 mo2284j = hv0Var3.mo2284j(mo2287o2);
                        mo2287o = mo2287o.mo2284j(hv0Var3);
                        m4266l = m4266l.mo2284j(mo2287o2);
                        m4267m = m4267m.mo2284j(mo2284j);
                    }
                } else {
                    if (m4938i != 2 && m4938i != 3 && m4938i != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    hv0 hv0Var4 = this.f3430d[0];
                    if (!hv0Var4.mo2282h()) {
                        hv0 mo2287o3 = hv0Var4.mo2287o();
                        hv0 mo2287o4 = mo2287o3.mo2287o();
                        hv0 mo2284j2 = mo2287o3.mo2284j(mo2287o4);
                        m4266l = m4266l.mo2284j(mo2287o4);
                        m4267m = m4267m.mo2284j(mo2284j2);
                    }
                }
            }
            return mo2287o.equals(hv0Var.mo2287o().mo2277a(m4266l).mo2284j(hv0Var).mo2277a(m4267m));
        }
    }

    /* renamed from: cz.opentree.iv0$d */
    /* loaded from: classes.dex */
    public static class C1182d extends AbstractC1180b {
        public C1182d(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
            super(gv0Var, hv0Var, hv0Var2);
        }

        public C1182d(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
            super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
        }

        @Override // cz.opentree.iv0
        /* renamed from: C */
        public iv0 mo2638C() {
            hv0 mo2277a;
            if (m4945r()) {
                return this;
            }
            gv0 m4937h = m4937h();
            hv0 hv0Var = this.f3428b;
            if (hv0Var.mo2283i()) {
                return m4937h.mo2308r();
            }
            int m4269o = m4937h.m4269o();
            if (m4269o == 0) {
                hv0 mo2277a2 = this.f3429c.mo2279d(hv0Var).mo2277a(hv0Var);
                hv0 mo2277a3 = mo2277a2.mo2287o().mo2277a(mo2277a2).mo2277a(m4937h.m4266l());
                return new C1182d(m4937h, mo2277a3, hv0Var.mo3340p(mo2277a3, mo2277a2.mo2278b()));
            }
            if (m4269o == 1) {
                hv0 hv0Var2 = this.f3429c;
                hv0 hv0Var3 = this.f3430d[0];
                boolean mo2282h = hv0Var3.mo2282h();
                hv0 mo2284j = mo2282h ? hv0Var : hv0Var.mo2284j(hv0Var3);
                if (!mo2282h) {
                    hv0Var2 = hv0Var2.mo2284j(hv0Var3);
                }
                hv0 mo2287o = hv0Var.mo2287o();
                hv0 mo2277a4 = mo2287o.mo2277a(hv0Var2);
                hv0 mo2287o2 = mo2284j.mo2287o();
                hv0 mo2277a5 = mo2277a4.mo2277a(mo2284j);
                hv0 mo3339l = mo2277a5.mo3339l(mo2277a4, mo2287o2, m4937h.m4266l());
                return new C1182d(m4937h, mo2284j.mo2284j(mo3339l), mo2287o.mo2287o().mo3339l(mo2284j, mo3339l, mo2277a5), new hv0[]{mo2284j.mo2284j(mo2287o2)});
            }
            if (m4269o != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            hv0 hv0Var4 = this.f3429c;
            hv0 hv0Var5 = this.f3430d[0];
            boolean mo2282h2 = hv0Var5.mo2282h();
            hv0 mo2284j2 = mo2282h2 ? hv0Var4 : hv0Var4.mo2284j(hv0Var5);
            hv0 mo2287o3 = mo2282h2 ? hv0Var5 : hv0Var5.mo2287o();
            hv0 m4266l = m4937h.m4266l();
            hv0 mo2284j3 = mo2282h2 ? m4266l : m4266l.mo2284j(mo2287o3);
            hv0 mo2277a6 = hv0Var4.mo2287o().mo2277a(mo2284j2).mo2277a(mo2284j3);
            if (mo2277a6.mo2283i()) {
                return new C1182d(m4937h, mo2277a6, m4937h.m4267m().mo2286n());
            }
            hv0 mo2287o4 = mo2277a6.mo2287o();
            hv0 mo2284j4 = mo2282h2 ? mo2277a6 : mo2277a6.mo2284j(mo2287o3);
            hv0 m4267m = m4937h.m4267m();
            if (m4267m.mo4653c() < (m4937h.mo2307q() >> 1)) {
                hv0 mo2287o5 = hv0Var4.mo2277a(hv0Var).mo2287o();
                mo2277a = mo2287o5.mo2277a(mo2277a6).mo2277a(mo2287o3).mo2284j(mo2287o5).mo2277a(m4267m.mo2282h() ? mo2284j3.mo2277a(mo2287o3).mo2287o() : mo2284j3.mo3340p(m4267m, mo2287o3.mo2287o())).mo2277a(mo2287o4);
                if (!m4266l.mo2283i()) {
                    if (!m4266l.mo2282h()) {
                        mo2277a = mo2277a.mo2277a(m4266l.mo2278b().mo2284j(mo2284j4));
                    }
                    return new C1182d(m4937h, mo2287o4, mo2277a, new hv0[]{mo2284j4});
                }
            } else {
                if (!mo2282h2) {
                    hv0Var = hv0Var.mo2284j(hv0Var5);
                }
                mo2277a = hv0Var.mo3340p(mo2277a6, mo2284j2).mo2277a(mo2287o4);
            }
            mo2277a = mo2277a.mo2277a(mo2284j4);
            return new C1182d(m4937h, mo2287o4, mo2277a, new hv0[]{mo2284j4});
        }

        @Override // cz.opentree.iv0
        /* renamed from: D */
        public iv0 mo2639D(iv0 iv0Var) {
            if (m4945r()) {
                return iv0Var;
            }
            if (iv0Var.m4945r()) {
                return mo2638C();
            }
            gv0 m4937h = m4937h();
            hv0 hv0Var = this.f3428b;
            if (hv0Var.mo2283i()) {
                return iv0Var;
            }
            if (m4937h.m4269o() != 6) {
                return mo2638C().mo2641a(iv0Var);
            }
            hv0 hv0Var2 = iv0Var.f3428b;
            hv0 hv0Var3 = iv0Var.f3430d[0];
            if (hv0Var2.mo2283i() || !hv0Var3.mo2282h()) {
                return mo2638C().mo2641a(iv0Var);
            }
            hv0 hv0Var4 = this.f3429c;
            hv0 hv0Var5 = this.f3430d[0];
            hv0 hv0Var6 = iv0Var.f3429c;
            hv0 mo2287o = hv0Var.mo2287o();
            hv0 mo2287o2 = hv0Var4.mo2287o();
            hv0 mo2287o3 = hv0Var5.mo2287o();
            hv0 mo2277a = m4937h.m4266l().mo2284j(mo2287o3).mo2277a(mo2287o2).mo2277a(hv0Var4.mo2284j(hv0Var5));
            hv0 mo2278b = hv0Var6.mo2278b();
            hv0 mo3339l = m4937h.m4266l().mo2277a(mo2278b).mo2284j(mo2287o3).mo2277a(mo2287o2).mo3339l(mo2277a, mo2287o, mo2287o3);
            hv0 mo2284j = hv0Var2.mo2284j(mo2287o3);
            hv0 mo2287o4 = mo2284j.mo2277a(mo2277a).mo2287o();
            if (mo2287o4.mo2283i()) {
                return mo3339l.mo2283i() ? iv0Var.mo2638C() : m4937h.mo2308r();
            }
            if (mo3339l.mo2283i()) {
                return new C1182d(m4937h, mo3339l, m4937h.m4267m().mo2286n());
            }
            hv0 mo2284j2 = mo3339l.mo2287o().mo2284j(mo2284j);
            hv0 mo2284j3 = mo3339l.mo2284j(mo2287o4).mo2284j(mo2287o3);
            return new C1182d(m4937h, mo2284j2, mo3339l.mo2277a(mo2287o4).mo2287o().mo3339l(mo2277a, mo2278b, mo2284j3), new hv0[]{mo2284j3});
        }

        @Override // cz.opentree.iv0
        /* renamed from: a */
        public iv0 mo2641a(iv0 iv0Var) {
            hv0 hv0Var;
            hv0 hv0Var2;
            hv0 hv0Var3;
            hv0 hv0Var4;
            hv0 hv0Var5;
            hv0 hv0Var6;
            if (m4945r()) {
                return iv0Var;
            }
            if (iv0Var.m4945r()) {
                return this;
            }
            gv0 m4937h = m4937h();
            int m4269o = m4937h.m4269o();
            hv0 hv0Var7 = this.f3428b;
            hv0 hv0Var8 = iv0Var.f3428b;
            if (m4269o == 0) {
                hv0 hv0Var9 = this.f3429c;
                hv0 hv0Var10 = iv0Var.f3429c;
                hv0 mo2277a = hv0Var7.mo2277a(hv0Var8);
                hv0 mo2277a2 = hv0Var9.mo2277a(hv0Var10);
                if (mo2277a.mo2283i()) {
                    return mo2277a2.mo2283i() ? mo2638C() : m4937h.mo2308r();
                }
                hv0 mo2279d = mo2277a2.mo2279d(mo2277a);
                hv0 mo2277a3 = mo2279d.mo2287o().mo2277a(mo2279d).mo2277a(mo2277a).mo2277a(m4937h.m4266l());
                return new C1182d(m4937h, mo2277a3, mo2279d.mo2284j(hv0Var7.mo2277a(mo2277a3)).mo2277a(mo2277a3).mo2277a(hv0Var9));
            }
            if (m4269o == 1) {
                hv0 hv0Var11 = this.f3429c;
                hv0 hv0Var12 = this.f3430d[0];
                hv0 hv0Var13 = iv0Var.f3429c;
                hv0 hv0Var14 = iv0Var.f3430d[0];
                boolean mo2282h = hv0Var14.mo2282h();
                hv0 mo2277a4 = hv0Var12.mo2284j(hv0Var13).mo2277a(mo2282h ? hv0Var11 : hv0Var11.mo2284j(hv0Var14));
                hv0 mo2277a5 = hv0Var12.mo2284j(hv0Var8).mo2277a(mo2282h ? hv0Var7 : hv0Var7.mo2284j(hv0Var14));
                if (mo2277a5.mo2283i()) {
                    return mo2277a4.mo2283i() ? mo2638C() : m4937h.mo2308r();
                }
                hv0 mo2287o = mo2277a5.mo2287o();
                hv0 mo2284j = mo2287o.mo2284j(mo2277a5);
                if (!mo2282h) {
                    hv0Var12 = hv0Var12.mo2284j(hv0Var14);
                }
                hv0 mo2277a6 = mo2277a4.mo2277a(mo2277a5);
                hv0 mo2277a7 = mo2277a6.mo3339l(mo2277a4, mo2287o, m4937h.m4266l()).mo2284j(hv0Var12).mo2277a(mo2284j);
                hv0 mo2284j2 = mo2277a5.mo2284j(mo2277a7);
                if (!mo2282h) {
                    mo2287o = mo2287o.mo2284j(hv0Var14);
                }
                return new C1182d(m4937h, mo2284j2, mo2277a4.mo3339l(hv0Var7, mo2277a5, hv0Var11).mo3339l(mo2287o, mo2277a6, mo2277a7), new hv0[]{mo2284j.mo2284j(hv0Var12)});
            }
            if (m4269o != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            if (hv0Var7.mo2283i()) {
                return hv0Var8.mo2283i() ? m4937h.mo2308r() : iv0Var.mo2641a(this);
            }
            hv0 hv0Var15 = this.f3429c;
            hv0 hv0Var16 = this.f3430d[0];
            hv0 hv0Var17 = iv0Var.f3429c;
            hv0 hv0Var18 = iv0Var.f3430d[0];
            boolean mo2282h2 = hv0Var16.mo2282h();
            if (mo2282h2) {
                hv0Var = hv0Var8;
                hv0Var2 = hv0Var17;
            } else {
                hv0Var = hv0Var8.mo2284j(hv0Var16);
                hv0Var2 = hv0Var17.mo2284j(hv0Var16);
            }
            boolean mo2282h3 = hv0Var18.mo2282h();
            if (mo2282h3) {
                hv0Var3 = hv0Var15;
            } else {
                hv0Var7 = hv0Var7.mo2284j(hv0Var18);
                hv0Var3 = hv0Var15.mo2284j(hv0Var18);
            }
            hv0 mo2277a8 = hv0Var3.mo2277a(hv0Var2);
            hv0 mo2277a9 = hv0Var7.mo2277a(hv0Var);
            if (mo2277a9.mo2283i()) {
                return mo2277a8.mo2283i() ? mo2638C() : m4937h.mo2308r();
            }
            if (hv0Var8.mo2283i()) {
                iv0 m4949w = m4949w();
                hv0 m4942n = m4949w.m4942n();
                hv0 mo2645o = m4949w.mo2645o();
                hv0 mo2279d2 = mo2645o.mo2277a(hv0Var17).mo2279d(m4942n);
                hv0Var4 = mo2279d2.mo2287o().mo2277a(mo2279d2).mo2277a(m4942n).mo2277a(m4937h.m4266l());
                if (hv0Var4.mo2283i()) {
                    return new C1182d(m4937h, hv0Var4, m4937h.m4267m().mo2286n());
                }
                hv0Var6 = mo2279d2.mo2284j(m4942n.mo2277a(hv0Var4)).mo2277a(hv0Var4).mo2277a(mo2645o).mo2279d(hv0Var4).mo2277a(hv0Var4);
                hv0Var5 = m4937h.mo2306k(ECConstants.f8873b);
            } else {
                hv0 mo2287o2 = mo2277a9.mo2287o();
                hv0 mo2284j3 = mo2277a8.mo2284j(hv0Var7);
                hv0 mo2284j4 = mo2277a8.mo2284j(hv0Var);
                hv0 mo2284j5 = mo2284j3.mo2284j(mo2284j4);
                if (mo2284j5.mo2283i()) {
                    return new C1182d(m4937h, mo2284j5, m4937h.m4267m().mo2286n());
                }
                hv0 mo2284j6 = mo2277a8.mo2284j(mo2287o2);
                hv0 mo2284j7 = !mo2282h3 ? mo2284j6.mo2284j(hv0Var18) : mo2284j6;
                hv0 mo3340p = mo2284j4.mo2277a(mo2287o2).mo3340p(mo2284j7, hv0Var15.mo2277a(hv0Var16));
                if (!mo2282h2) {
                    mo2284j7 = mo2284j7.mo2284j(hv0Var16);
                }
                hv0Var4 = mo2284j5;
                hv0Var5 = mo2284j7;
                hv0Var6 = mo3340p;
            }
            return new C1182d(m4937h, hv0Var4, hv0Var6, new hv0[]{hv0Var5});
        }

        @Override // cz.opentree.iv0
        /* renamed from: g */
        public boolean mo2644g() {
            hv0 m4940l = m4940l();
            if (m4940l.mo2283i()) {
                return false;
            }
            hv0 m4941m = m4941m();
            int m4938i = m4938i();
            return (m4938i == 5 || m4938i == 6) ? m4941m.mo2289s() != m4940l.mo2289s() : m4941m.mo2279d(m4940l).mo2289s();
        }

        @Override // cz.opentree.iv0
        /* renamed from: o */
        public hv0 mo2645o() {
            int m4938i = m4938i();
            if (m4938i != 5 && m4938i != 6) {
                return this.f3429c;
            }
            hv0 hv0Var = this.f3428b;
            hv0 hv0Var2 = this.f3429c;
            if (m4945r() || hv0Var.mo2283i()) {
                return hv0Var2;
            }
            hv0 mo2284j = hv0Var2.mo2277a(hv0Var).mo2284j(hv0Var);
            if (6 != m4938i) {
                return mo2284j;
            }
            hv0 hv0Var3 = this.f3430d[0];
            return !hv0Var3.mo2282h() ? mo2284j.mo2279d(hv0Var3) : mo2284j;
        }

        @Override // cz.opentree.iv0
        /* renamed from: v */
        public iv0 mo2642v() {
            if (m4945r()) {
                return this;
            }
            hv0 hv0Var = this.f3428b;
            if (hv0Var.mo2283i()) {
                return this;
            }
            int m4938i = m4938i();
            if (m4938i == 0) {
                return new C1182d(this.f3427a, hv0Var, this.f3429c.mo2277a(hv0Var));
            }
            if (m4938i == 1) {
                return new C1182d(this.f3427a, hv0Var, this.f3429c.mo2277a(hv0Var), new hv0[]{this.f3430d[0]});
            }
            if (m4938i == 5) {
                return new C1182d(this.f3427a, hv0Var, this.f3429c.mo2278b());
            }
            if (m4938i != 6) {
                throw new IllegalStateException("unsupported coordinate system");
            }
            hv0 hv0Var2 = this.f3429c;
            hv0 hv0Var3 = this.f3430d[0];
            return new C1182d(this.f3427a, hv0Var, hv0Var2.mo2277a(hv0Var3), new hv0[]{hv0Var3});
        }
    }

    /* renamed from: cz.opentree.iv0$e */
    /* loaded from: classes.dex */
    public static class C1183e extends AbstractC1181c {
        public C1183e(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
            super(gv0Var, hv0Var, hv0Var2);
        }

        public C1183e(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
            super(gv0Var, hv0Var, hv0Var2, hv0VarArr);
        }

        @Override // cz.opentree.iv0
        /* renamed from: B */
        public iv0 mo4931B(int i) {
            hv0 mo2287o;
            if (i < 0) {
                throw new IllegalArgumentException("'e' cannot be negative");
            }
            if (i == 0 || m4945r()) {
                return this;
            }
            if (i == 1) {
                return mo2638C();
            }
            gv0 m4937h = m4937h();
            hv0 hv0Var = this.f3429c;
            if (hv0Var.mo2283i()) {
                return m4937h.mo2308r();
            }
            int m4269o = m4937h.m4269o();
            hv0 m4266l = m4937h.m4266l();
            hv0 hv0Var2 = this.f3428b;
            hv0[] hv0VarArr = this.f3430d;
            hv0 mo2306k = hv0VarArr.length < 1 ? m4937h.mo2306k(ECConstants.f8873b) : hv0VarArr[0];
            if (!mo2306k.mo2282h() && m4269o != 0) {
                if (m4269o == 1) {
                    mo2287o = mo2306k.mo2287o();
                    hv0Var2 = hv0Var2.mo2284j(mo2306k);
                    hv0Var = hv0Var.mo2284j(mo2287o);
                } else if (m4269o == 2) {
                    mo2287o = null;
                } else {
                    if (m4269o != 4) {
                        throw new IllegalStateException("unsupported coordinate system");
                    }
                    m4266l = m4957H();
                }
                m4266l = m4954E(mo2306k, mo2287o);
            }
            int i2 = 0;
            while (i2 < i) {
                if (hv0Var.mo2283i()) {
                    return m4937h.mo2308r();
                }
                hv0 m4958I = m4958I(hv0Var2.mo2287o());
                hv0 m4961L = m4961L(hv0Var);
                hv0 mo2284j = m4961L.mo2284j(hv0Var);
                hv0 m4961L2 = m4961L(hv0Var2.mo2284j(mo2284j));
                hv0 m4961L3 = m4961L(mo2284j.mo2287o());
                if (!m4266l.mo2283i()) {
                    m4958I = m4958I.mo2277a(m4266l);
                    m4266l = m4961L(m4961L3.mo2284j(m4266l));
                }
                hv0 mo2288r = m4958I.mo2287o().mo2288r(m4961L(m4961L2));
                hv0Var = m4958I.mo2284j(m4961L2.mo2288r(mo2288r)).mo2288r(m4961L3);
                mo2306k = mo2306k.mo2282h() ? m4961L : m4961L.mo2284j(mo2306k);
                i2++;
                hv0Var2 = mo2288r;
            }
            if (m4269o == 0) {
                hv0 mo2281g = mo2306k.mo2281g();
                hv0 mo2287o2 = mo2281g.mo2287o();
                return new C1183e(m4937h, hv0Var2.mo2284j(mo2287o2), hv0Var.mo2284j(mo2287o2.mo2284j(mo2281g)));
            }
            if (m4269o == 1) {
                return new C1183e(m4937h, hv0Var2.mo2284j(mo2306k), hv0Var, new hv0[]{mo2306k.mo2284j(mo2306k.mo2287o())});
            }
            if (m4269o == 2) {
                return new C1183e(m4937h, hv0Var2, hv0Var, new hv0[]{mo2306k});
            }
            if (m4269o == 4) {
                return new C1183e(m4937h, hv0Var2, hv0Var, new hv0[]{mo2306k, m4266l});
            }
            throw new IllegalStateException("unsupported coordinate system");
        }

        @Override // cz.opentree.iv0
        /* renamed from: C */
        public iv0 mo2638C() {
            hv0 hv0Var;
            hv0 mo2284j;
            if (m4945r()) {
                return this;
            }
            gv0 m4937h = m4937h();
            hv0 hv0Var2 = this.f3429c;
            if (hv0Var2.mo2283i()) {
                return m4937h.mo2308r();
            }
            int m4269o = m4937h.m4269o();
            hv0 hv0Var3 = this.f3428b;
            if (m4269o == 0) {
                hv0 mo2279d = m4958I(hv0Var3.mo2287o()).mo2277a(m4937h().m4266l()).mo2279d(m4961L(hv0Var2));
                hv0 mo2288r = mo2279d.mo2287o().mo2288r(m4961L(hv0Var3));
                return new C1183e(m4937h, mo2288r, mo2279d.mo2284j(hv0Var3.mo2288r(mo2288r)).mo2288r(hv0Var2));
            }
            if (m4269o == 1) {
                hv0 hv0Var4 = this.f3430d[0];
                boolean mo2282h = hv0Var4.mo2282h();
                hv0 m4266l = m4937h.m4266l();
                if (!m4266l.mo2283i() && !mo2282h) {
                    m4266l = m4266l.mo2284j(hv0Var4.mo2287o());
                }
                hv0 mo2277a = m4266l.mo2277a(m4958I(hv0Var3.mo2287o()));
                hv0 mo2284j2 = mo2282h ? hv0Var2 : hv0Var2.mo2284j(hv0Var4);
                hv0 mo2287o = mo2282h ? hv0Var2.mo2287o() : mo2284j2.mo2284j(hv0Var2);
                hv0 m4956G = m4956G(hv0Var3.mo2284j(mo2287o));
                hv0 mo2288r2 = mo2277a.mo2287o().mo2288r(m4961L(m4956G));
                hv0 m4961L = m4961L(mo2284j2);
                hv0 mo2284j3 = mo2288r2.mo2284j(m4961L);
                hv0 m4961L2 = m4961L(mo2287o);
                return new C1183e(m4937h, mo2284j3, m4956G.mo2288r(mo2288r2).mo2284j(mo2277a).mo2288r(m4961L(m4961L2.mo2287o())), new hv0[]{m4961L(mo2282h ? m4961L(m4961L2) : m4961L.mo2287o()).mo2284j(mo2284j2)});
            }
            if (m4269o != 2) {
                if (m4269o == 4) {
                    return m4960K(true);
                }
                throw new IllegalStateException("unsupported coordinate system");
            }
            hv0 hv0Var5 = this.f3430d[0];
            boolean mo2282h2 = hv0Var5.mo2282h();
            hv0 mo2287o2 = hv0Var2.mo2287o();
            hv0 mo2287o3 = mo2287o2.mo2287o();
            hv0 m4266l2 = m4937h.m4266l();
            hv0 mo2285m = m4266l2.mo2285m();
            if (mo2285m.mo2290t().equals(BigInteger.valueOf(3L))) {
                hv0 mo2287o4 = mo2282h2 ? hv0Var5 : hv0Var5.mo2287o();
                hv0Var = m4958I(hv0Var3.mo2277a(mo2287o4).mo2284j(hv0Var3.mo2288r(mo2287o4)));
                mo2284j = mo2287o2.mo2284j(hv0Var3);
            } else {
                hv0 m4958I = m4958I(hv0Var3.mo2287o());
                if (!mo2282h2) {
                    if (m4266l2.mo2283i()) {
                        hv0Var = m4958I;
                    } else {
                        hv0 mo2287o5 = hv0Var5.mo2287o().mo2287o();
                        if (mo2285m.mo4653c() < m4266l2.mo4653c()) {
                            hv0Var = m4958I.mo2288r(mo2287o5.mo2284j(mo2285m));
                        } else {
                            m4266l2 = mo2287o5.mo2284j(m4266l2);
                        }
                    }
                    mo2284j = hv0Var3.mo2284j(mo2287o2);
                }
                hv0Var = m4958I.mo2277a(m4266l2);
                mo2284j = hv0Var3.mo2284j(mo2287o2);
            }
            hv0 m4956G2 = m4956G(mo2284j);
            hv0 mo2288r3 = hv0Var.mo2287o().mo2288r(m4961L(m4956G2));
            hv0 mo2288r4 = m4956G2.mo2288r(mo2288r3).mo2284j(hv0Var).mo2288r(m4955F(mo2287o3));
            hv0 m4961L3 = m4961L(hv0Var2);
            if (!mo2282h2) {
                m4961L3 = m4961L3.mo2284j(hv0Var5);
            }
            return new C1183e(m4937h, mo2288r3, mo2288r4, new hv0[]{m4961L3});
        }

        @Override // cz.opentree.iv0
        /* renamed from: D */
        public iv0 mo2639D(iv0 iv0Var) {
            if (this == iv0Var) {
                return m4959J();
            }
            if (m4945r()) {
                return iv0Var;
            }
            if (iv0Var.m4945r()) {
                return mo2638C();
            }
            hv0 hv0Var = this.f3429c;
            if (hv0Var.mo2283i()) {
                return iv0Var;
            }
            gv0 m4937h = m4937h();
            int m4269o = m4937h.m4269o();
            if (m4269o != 0) {
                return m4269o != 4 ? mo2638C().mo2641a(iv0Var) : m4960K(false).mo2641a(iv0Var);
            }
            hv0 hv0Var2 = this.f3428b;
            hv0 hv0Var3 = iv0Var.f3428b;
            hv0 hv0Var4 = iv0Var.f3429c;
            hv0 mo2288r = hv0Var3.mo2288r(hv0Var2);
            hv0 mo2288r2 = hv0Var4.mo2288r(hv0Var);
            if (mo2288r.mo2283i()) {
                return mo2288r2.mo2283i() ? m4959J() : this;
            }
            hv0 mo2287o = mo2288r.mo2287o();
            hv0 mo2288r3 = mo2287o.mo2284j(m4961L(hv0Var2).mo2277a(hv0Var3)).mo2288r(mo2288r2.mo2287o());
            if (mo2288r3.mo2283i()) {
                return m4937h.mo2308r();
            }
            hv0 mo2281g = mo2288r3.mo2284j(mo2288r).mo2281g();
            hv0 mo2284j = mo2288r3.mo2284j(mo2281g).mo2284j(mo2288r2);
            hv0 mo2288r4 = m4961L(hv0Var).mo2284j(mo2287o).mo2284j(mo2288r).mo2284j(mo2281g).mo2288r(mo2284j);
            hv0 mo2277a = mo2288r4.mo2288r(mo2284j).mo2284j(mo2284j.mo2277a(mo2288r4)).mo2277a(hv0Var3);
            return new C1183e(m4937h, mo2277a, hv0Var2.mo2288r(mo2277a).mo2284j(mo2288r4).mo2288r(hv0Var));
        }

        /* renamed from: E */
        public hv0 m4954E(hv0 hv0Var, hv0 hv0Var2) {
            hv0 m4266l = m4937h().m4266l();
            if (m4266l.mo2283i() || hv0Var.mo2282h()) {
                return m4266l;
            }
            if (hv0Var2 == null) {
                hv0Var2 = hv0Var.mo2287o();
            }
            hv0 mo2287o = hv0Var2.mo2287o();
            hv0 mo2285m = m4266l.mo2285m();
            return mo2285m.mo4653c() < m4266l.mo4653c() ? mo2287o.mo2284j(mo2285m).mo2285m() : mo2287o.mo2284j(m4266l);
        }

        /* renamed from: F */
        public hv0 m4955F(hv0 hv0Var) {
            return m4956G(m4961L(hv0Var));
        }

        /* renamed from: G */
        public hv0 m4956G(hv0 hv0Var) {
            return m4961L(m4961L(hv0Var));
        }

        /* renamed from: H */
        public hv0 m4957H() {
            hv0[] hv0VarArr = this.f3430d;
            hv0 hv0Var = hv0VarArr[1];
            if (hv0Var != null) {
                return hv0Var;
            }
            hv0 m4954E = m4954E(hv0VarArr[0], null);
            hv0VarArr[1] = m4954E;
            return m4954E;
        }

        /* renamed from: I */
        public hv0 m4958I(hv0 hv0Var) {
            return m4961L(hv0Var).mo2277a(hv0Var);
        }

        /* renamed from: J */
        public iv0 m4959J() {
            if (m4945r()) {
                return this;
            }
            hv0 hv0Var = this.f3429c;
            if (hv0Var.mo2283i()) {
                return this;
            }
            gv0 m4937h = m4937h();
            int m4269o = m4937h.m4269o();
            if (m4269o != 0) {
                return m4269o != 4 ? mo2638C().mo2641a(this) : m4960K(false).mo2641a(this);
            }
            hv0 hv0Var2 = this.f3428b;
            hv0 m4961L = m4961L(hv0Var);
            hv0 mo2287o = m4961L.mo2287o();
            hv0 mo2277a = m4958I(hv0Var2.mo2287o()).mo2277a(m4937h().m4266l());
            hv0 mo2288r = m4958I(hv0Var2).mo2284j(mo2287o).mo2288r(mo2277a.mo2287o());
            if (mo2288r.mo2283i()) {
                return m4937h().mo2308r();
            }
            hv0 mo2281g = mo2288r.mo2284j(m4961L).mo2281g();
            hv0 mo2284j = mo2288r.mo2284j(mo2281g).mo2284j(mo2277a);
            hv0 mo2288r2 = mo2287o.mo2287o().mo2284j(mo2281g).mo2288r(mo2284j);
            hv0 mo2277a2 = mo2288r2.mo2288r(mo2284j).mo2284j(mo2284j.mo2277a(mo2288r2)).mo2277a(hv0Var2);
            return new C1183e(m4937h, mo2277a2, hv0Var2.mo2288r(mo2277a2).mo2284j(mo2288r2).mo2288r(hv0Var));
        }

        /* renamed from: K */
        public C1183e m4960K(boolean z) {
            hv0 hv0Var = this.f3428b;
            hv0 hv0Var2 = this.f3429c;
            hv0 hv0Var3 = this.f3430d[0];
            hv0 m4957H = m4957H();
            hv0 mo2277a = m4958I(hv0Var.mo2287o()).mo2277a(m4957H);
            hv0 m4961L = m4961L(hv0Var2);
            hv0 mo2284j = m4961L.mo2284j(hv0Var2);
            hv0 m4961L2 = m4961L(hv0Var.mo2284j(mo2284j));
            hv0 mo2288r = mo2277a.mo2287o().mo2288r(m4961L(m4961L2));
            hv0 m4961L3 = m4961L(mo2284j.mo2287o());
            hv0 mo2288r2 = mo2277a.mo2284j(m4961L2.mo2288r(mo2288r)).mo2288r(m4961L3);
            hv0 m4961L4 = z ? m4961L(m4961L3.mo2284j(m4957H)) : null;
            if (!hv0Var3.mo2282h()) {
                m4961L = m4961L.mo2284j(hv0Var3);
            }
            return new C1183e(m4937h(), mo2288r, mo2288r2, new hv0[]{m4961L, m4961L4});
        }

        /* renamed from: L */
        public hv0 m4961L(hv0 hv0Var) {
            return hv0Var.mo2277a(hv0Var);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0128  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0136  */
        @Override // cz.opentree.iv0
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public cz.opentree.iv0 mo2641a(cz.opentree.iv0 r17) {
            /*
                Method dump skipped, instructions count: 532
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.opentree.iv0.C1183e.mo2641a(cz.opentree.iv0):cz.opentree.iv0");
        }

        @Override // cz.opentree.iv0
        /* renamed from: p */
        public hv0 mo4943p(int i) {
            return (i == 1 && 4 == m4938i()) ? m4957H() : super.mo4943p(i);
        }

        @Override // cz.opentree.iv0
        /* renamed from: v */
        public iv0 mo2642v() {
            if (m4945r()) {
                return this;
            }
            gv0 m4937h = m4937h();
            return m4937h.m4269o() != 0 ? new C1183e(m4937h, this.f3428b, this.f3429c.mo2285m(), this.f3430d) : new C1183e(m4937h, this.f3428b, this.f3429c.mo2285m());
        }
    }

    public iv0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2) {
        this(gv0Var, hv0Var, hv0Var2, m4929k(gv0Var));
    }

    public iv0(gv0 gv0Var, hv0 hv0Var, hv0 hv0Var2, hv0[] hv0VarArr) {
        this.f3431e = null;
        this.f3427a = gv0Var;
        this.f3428b = hv0Var;
        this.f3429c = hv0Var2;
        this.f3430d = hv0VarArr;
    }

    /* renamed from: k */
    public static hv0[] m4929k(gv0 gv0Var) {
        int m4269o = gv0Var == null ? 0 : gv0Var.m4269o();
        if (m4269o == 0 || m4269o == 5) {
            return f3426f;
        }
        hv0 mo2306k = gv0Var.mo2306k(ECConstants.f8873b);
        if (m4269o != 1 && m4269o != 2) {
            if (m4269o == 3) {
                return new hv0[]{mo2306k, mo2306k, mo2306k};
            }
            if (m4269o == 4) {
                return new hv0[]{mo2306k, gv0Var.m4266l()};
            }
            if (m4269o != 6) {
                throw new IllegalArgumentException("unknown coordinate system");
            }
        }
        return new hv0[]{mo2306k};
    }

    /* renamed from: A */
    public abstract iv0 mo4930A(iv0 iv0Var);

    /* renamed from: B */
    public iv0 mo4931B(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("'e' cannot be negative");
        }
        iv0 iv0Var = this;
        while (true) {
            i--;
            if (i < 0) {
                return iv0Var;
            }
            iv0Var = iv0Var.mo2638C();
        }
    }

    /* renamed from: C */
    public abstract iv0 mo2638C();

    /* renamed from: D */
    public iv0 mo2639D(iv0 iv0Var) {
        return mo2638C().mo2641a(iv0Var);
    }

    /* renamed from: a */
    public abstract iv0 mo2641a(iv0 iv0Var);

    /* renamed from: b */
    public void m4932b() {
        if (!m4946s()) {
            throw new IllegalStateException("point not in normal form");
        }
    }

    /* renamed from: c */
    public iv0 m4933c(hv0 hv0Var, hv0 hv0Var2) {
        return m4937h().mo2305g(m4940l().mo2284j(hv0Var), m4941m().mo2284j(hv0Var2));
    }

    /* renamed from: d */
    public boolean m4934d(iv0 iv0Var) {
        iv0 iv0Var2;
        if (iv0Var == null) {
            return false;
        }
        gv0 m4937h = m4937h();
        gv0 m4937h2 = iv0Var.m4937h();
        boolean z = m4937h == null;
        boolean z2 = m4937h2 == null;
        boolean m4945r = m4945r();
        boolean m4945r2 = iv0Var.m4945r();
        if (m4945r || m4945r2) {
            if (m4945r && m4945r2) {
                return z || z2 || m4937h.m4265j(m4937h2);
            }
            return false;
        }
        if (!z || !z2) {
            if (!z) {
                if (z2) {
                    iv0Var2 = m4949w();
                } else {
                    if (!m4937h.m4265j(m4937h2)) {
                        return false;
                    }
                    iv0[] iv0VarArr = {this, m4937h.mo4272t(iv0Var)};
                    m4937h.m4273u(iv0VarArr);
                    iv0Var2 = iv0VarArr[0];
                    iv0Var = iv0VarArr[1];
                }
                return iv0Var2.m4942n().equals(iv0Var.m4942n()) && iv0Var2.mo2645o().equals(iv0Var.mo2645o());
            }
            iv0Var = iv0Var.m4949w();
        }
        iv0Var2 = this;
        if (iv0Var2.m4942n().equals(iv0Var.m4942n())) {
            return false;
        }
    }

    /* renamed from: e */
    public hv0 m4935e() {
        m4932b();
        return m4942n();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof iv0) {
            return m4934d((iv0) obj);
        }
        return false;
    }

    /* renamed from: f */
    public hv0 m4936f() {
        m4932b();
        return mo2645o();
    }

    /* renamed from: g */
    public abstract boolean mo2644g();

    /* renamed from: h */
    public gv0 m4937h() {
        return this.f3427a;
    }

    public int hashCode() {
        gv0 m4937h = m4937h();
        int i = m4937h == null ? 0 : ~m4937h.hashCode();
        if (m4945r()) {
            return i;
        }
        iv0 m4949w = m4949w();
        return (i ^ (m4949w.m4942n().hashCode() * 17)) ^ (m4949w.mo2645o().hashCode() * 257);
    }

    /* renamed from: i */
    public int m4938i() {
        gv0 gv0Var = this.f3427a;
        if (gv0Var == null) {
            return 0;
        }
        return gv0Var.m4269o();
    }

    /* renamed from: j */
    public byte[] m4939j(boolean z) {
        if (m4945r()) {
            return new byte[1];
        }
        iv0 m4949w = m4949w();
        byte[] m4654e = m4949w.m4942n().m4654e();
        if (z) {
            byte[] bArr = new byte[m4654e.length + 1];
            bArr[0] = (byte) (m4949w.mo2644g() ? 3 : 2);
            System.arraycopy(m4654e, 0, bArr, 1, m4654e.length);
            return bArr;
        }
        byte[] m4654e2 = m4949w.mo2645o().m4654e();
        byte[] bArr2 = new byte[m4654e.length + m4654e2.length + 1];
        bArr2[0] = 4;
        System.arraycopy(m4654e, 0, bArr2, 1, m4654e.length);
        System.arraycopy(m4654e2, 0, bArr2, m4654e.length + 1, m4654e2.length);
        return bArr2;
    }

    /* renamed from: l */
    public final hv0 m4940l() {
        return this.f3428b;
    }

    /* renamed from: m */
    public final hv0 m4941m() {
        return this.f3429c;
    }

    /* renamed from: n */
    public hv0 m4942n() {
        return this.f3428b;
    }

    /* renamed from: o */
    public hv0 mo2645o() {
        return this.f3429c;
    }

    /* renamed from: p */
    public hv0 mo4943p(int i) {
        if (i >= 0) {
            hv0[] hv0VarArr = this.f3430d;
            if (i < hv0VarArr.length) {
                return hv0VarArr[i];
            }
        }
        return null;
    }

    /* renamed from: q */
    public boolean m4944q(boolean z, boolean z2) {
        if (m4945r()) {
            return true;
        }
        return !((nv0) m4937h().m4275w(this, "bc_validity", new C1179a(z, z2))).m6800b();
    }

    /* renamed from: r */
    public boolean m4945r() {
        if (this.f3428b != null && this.f3429c != null) {
            hv0[] hv0VarArr = this.f3430d;
            if (hv0VarArr.length <= 0 || !hv0VarArr[0].mo2283i()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: s */
    public boolean m4946s() {
        int m4938i = m4938i();
        return m4938i == 0 || m4938i == 5 || m4945r() || this.f3430d[0].mo2282h();
    }

    /* renamed from: t */
    public boolean m4947t() {
        return m4944q(false, true);
    }

    public String toString() {
        if (m4945r()) {
            return "INF";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append('(');
        stringBuffer.append(m4940l());
        stringBuffer.append(',');
        stringBuffer.append(m4941m());
        for (int i = 0; i < this.f3430d.length; i++) {
            stringBuffer.append(',');
            stringBuffer.append(this.f3430d[i]);
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    /* renamed from: u */
    public boolean m4948u() {
        return m4944q(false, false);
    }

    /* renamed from: v */
    public abstract iv0 mo2642v();

    /* renamed from: w */
    public iv0 m4949w() {
        int m4938i;
        if (m4945r() || (m4938i = m4938i()) == 0 || m4938i == 5) {
            return this;
        }
        hv0 mo4943p = mo4943p(0);
        return mo4943p.mo2282h() ? this : m4950x(mo4943p.mo2281g());
    }

    /* renamed from: x */
    public iv0 m4950x(hv0 hv0Var) {
        int m4938i = m4938i();
        if (m4938i != 1) {
            if (m4938i == 2 || m4938i == 3 || m4938i == 4) {
                hv0 mo2287o = hv0Var.mo2287o();
                return m4933c(mo2287o, mo2287o.mo2284j(hv0Var));
            }
            if (m4938i != 6) {
                throw new IllegalStateException("not a projective coordinate system");
            }
        }
        return m4933c(hv0Var, hv0Var);
    }

    /* renamed from: y */
    public abstract boolean mo4951y();

    /* renamed from: z */
    public boolean mo4952z() {
        BigInteger m4271s;
        return ECConstants.f8873b.equals(this.f3427a.m4268n()) || (m4271s = this.f3427a.m4271s()) == null || fv0.m3887h(this, m4271s).m4945r();
    }
}
