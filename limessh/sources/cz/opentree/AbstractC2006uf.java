package cz.opentree;

/* renamed from: cz.opentree.uf */
/* loaded from: classes.dex */
public abstract class AbstractC2006uf extends C1930tf {

    /* renamed from: P */
    public boolean f6954P;

    public AbstractC2006uf(C2216wf c2216wf) {
        super(c2216wf);
    }

    /* renamed from: C0 */
    public final boolean m8876C0() {
        return this.f6954P;
    }

    /* renamed from: D0 */
    public final void m8877D0() {
        mo2053E0();
        this.f6954P = true;
    }

    /* renamed from: E0 */
    public abstract void mo2053E0();

    /* renamed from: F0 */
    public final void m8878F0() {
        if (!m8876C0()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
