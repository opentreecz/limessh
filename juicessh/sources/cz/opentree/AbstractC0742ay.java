package cz.opentree;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ay */
/* loaded from: classes.dex */
public abstract class AbstractC0742ay extends C2446zy {

    /* renamed from: b */
    public boolean f1539b;

    public AbstractC0742ay(C2144uz c2144uz) {
        super(c2144uz);
        this.f5899a.m9116d(this);
    }

    /* renamed from: A */
    public final void m2296A() {
        if (this.f1539b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2297w();
        this.f5899a.m9126u();
        this.f1539b = true;
    }

    /* renamed from: B */
    public abstract boolean mo1960B();

    /* renamed from: w */
    public void mo2297w() {
    }

    /* renamed from: x */
    public final boolean m2298x() {
        return this.f1539b;
    }

    /* renamed from: y */
    public final void m2299y() {
        if (!m2298x()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: z */
    public final void m2300z() {
        if (this.f1539b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo1960B()) {
            return;
        }
        this.f5899a.m9126u();
        this.f1539b = true;
    }
}
