package cz.opentree;

/* loaded from: classes.dex */
public class dq0 extends IllegalStateException {

    /* renamed from: O */
    public Throwable f2272O;

    public dq0(String str) {
        super(str);
    }

    public dq0(String str, Throwable th) {
        super(str);
        this.f2272O = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f2272O;
    }
}
