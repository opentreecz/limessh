package com.sonelli;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public abstract class p00 extends q00 {

    /* renamed from: b */
    public boolean f5589b;

    public p00(C2144uz c2144uz) {
        super(c2144uz);
        this.f5899a.m9117k(this);
    }

    /* renamed from: p */
    public void mo3596p() {
    }

    /* renamed from: q */
    public final void m7166q() {
        if (!m7169u()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: r */
    public final void m7167r() {
        if (this.f5589b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo3597t()) {
            return;
        }
        this.f5899a.m9126u();
        this.f5589b = true;
    }

    /* renamed from: s */
    public final void m7168s() {
        if (this.f5589b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo3596p();
        this.f5899a.m9126u();
        this.f5589b = true;
    }

    /* renamed from: t */
    public abstract boolean mo3597t();

    /* renamed from: u */
    public final boolean m7169u() {
        return this.f5589b;
    }
}
