package cz.opentree;

/* loaded from: classes.dex */
public class n51 extends IllegalStateException {

    /* renamed from: O */
    public Throwable f5235O;

    public n51(String str, Throwable th) {
        super(str);
        this.f5235O = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f5235O;
    }
}
