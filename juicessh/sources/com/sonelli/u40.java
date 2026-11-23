package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public final class u40 extends r40 {

    /* renamed from: g */
    public C0831ck f6915g;

    /* renamed from: h */
    public final /* synthetic */ o40 f6916h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u40(o40 o40Var, String str, int i, C0831ck c0831ck) {
        super(str, i);
        this.f6916h = o40Var;
        this.f6915g = c0831ck;
    }

    @Override // com.sonelli.r40
    /* renamed from: a */
    public final int mo7869a() {
        return this.f6915g.m2832G();
    }

    @Override // com.sonelli.r40
    /* renamed from: i */
    public final boolean mo7870i() {
        return true;
    }

    @Override // com.sonelli.r40
    /* renamed from: j */
    public final boolean mo7871j() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: k */
    public final boolean m8842k(Long l, Long l2, C2175vk c2175vk, boolean z) {
        Object[] objArr = C1669or.m7080b() && this.f6916h.m7590o().m2607A(this.f6171a, C1735pu.f5836g0);
        boolean m2835J = this.f6915g.m2835J();
        boolean m2836L = this.f6915g.m2836L();
        boolean m2838N = this.f6915g.m2838N();
        Object[] objArr2 = m2835J || m2836L || m2838N;
        Boolean bool = null;
        bool = null;
        bool = null;
        bool = null;
        bool = null;
        if (z && objArr2 != true) {
            this.f6916h.mo1484j().m8530P().m9085c("Property filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", Integer.valueOf(this.f6172b), this.f6915g.m2831F() ? Integer.valueOf(this.f6915g.m2832G()) : null);
            return true;
        }
        C0718ak m2834I = this.f6915g.m2834I();
        boolean m2129L = m2834I.m2129L();
        if (c2175vk.m9276W()) {
            if (m2834I.m2126H()) {
                bool = r40.m7864d(r40.m7863c(c2175vk.m9277X(), m2834I.m2127I()), m2129L);
            } else {
                this.f6916h.mo1484j().m8525K().m9084b("No number filter for long property. property", this.f6916h.m7587l().m7805B(c2175vk.m9273S()));
            }
        } else if (c2175vk.m9278Y()) {
            if (m2834I.m2126H()) {
                bool = r40.m7864d(r40.m7862b(c2175vk.m9279Z(), m2834I.m2127I()), m2129L);
            } else {
                this.f6916h.mo1484j().m8525K().m9084b("No number filter for double property. property", this.f6916h.m7587l().m7805B(c2175vk.m9273S()));
            }
        } else if (!c2175vk.m9274U()) {
            this.f6916h.mo1484j().m8525K().m9084b("User property has no value, property", this.f6916h.m7587l().m7805B(c2175vk.m9273S()));
        } else if (m2834I.m2124F()) {
            bool = r40.m7864d(r40.m7867g(c2175vk.m9275V(), m2834I.m2125G(), this.f6916h.mo1484j()), m2129L);
        } else if (!m2834I.m2126H()) {
            this.f6916h.mo1484j().m8525K().m9084b("No string or number filter defined. property", this.f6916h.m7587l().m7805B(c2175vk.m9273S()));
        } else if (d40.m3128T(c2175vk.m9275V())) {
            bool = r40.m7864d(r40.m7865e(c2175vk.m9275V(), m2834I.m2127I()), m2129L);
        } else {
            this.f6916h.mo1484j().m8525K().m9085c("Invalid user property value for Numeric number filter. property, value", this.f6916h.m7587l().m7805B(c2175vk.m9273S()), c2175vk.m9275V());
        }
        this.f6916h.mo1484j().m8530P().m9084b("Property filter result", bool == null ? "null" : bool);
        if (bool == null) {
            return false;
        }
        this.f6173c = Boolean.TRUE;
        if (m2838N && !bool.booleanValue()) {
            return true;
        }
        if (!z || this.f6915g.m2835J()) {
            this.f6174d = bool;
        }
        if (bool.booleanValue() && objArr2 != false && c2175vk.m9269L()) {
            long m9270M = c2175vk.m9270M();
            if (l != null) {
                m9270M = l.longValue();
            }
            if (objArr != false && this.f6915g.m2835J() && !this.f6915g.m2836L() && l2 != null) {
                m9270M = l2.longValue();
            }
            if (this.f6915g.m2836L()) {
                this.f6176f = Long.valueOf(m9270M);
            } else {
                this.f6175e = Long.valueOf(m9270M);
            }
        }
        return true;
    }
}
