package cz.opentree;

/* loaded from: classes.dex */
public abstract class bt0 {

    /* renamed from: a */
    public at0 f1824a;

    /* renamed from: a */
    public abstract at0 mo2603a();

    /* renamed from: b */
    public synchronized at0 m2604b() {
        if (this.f1824a == null) {
            this.f1824a = mo2603a();
        }
        return this.f1824a;
    }
}
