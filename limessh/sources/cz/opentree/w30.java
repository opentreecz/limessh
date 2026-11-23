package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement@@17.4.1 */
/* loaded from: classes.dex */
public abstract class w30 extends x30 {

    /* renamed from: c */
    public boolean f7618c;

    public w30(z30 z30Var) {
        super(z30Var);
        this.f7863b.m10382s(this);
    }

    /* renamed from: s */
    public final boolean m9403s() {
        return this.f7618c;
    }

    /* renamed from: t */
    public final void m9404t() {
        if (!m9403s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: u */
    public final void m9405u() {
        if (this.f7618c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2315v();
        this.f7863b.m10369e0();
        this.f7618c = true;
    }

    /* renamed from: v */
    public abstract boolean mo2315v();
}
