package cz.opentree;

import java.io.IOException;

/* compiled from: RouteException.java */
/* loaded from: classes.dex */
public final class nn0 extends RuntimeException {

    /* renamed from: O */
    public IOException f5327O;

    /* renamed from: P */
    public IOException f5328P;

    public nn0(IOException iOException) {
        super(iOException);
        this.f5327O = iOException;
        this.f5328P = iOException;
    }

    /* renamed from: a */
    public void m6754a(IOException iOException) {
        fn0.m3820a(this.f5327O, iOException);
        this.f5328P = iOException;
    }

    /* renamed from: b */
    public IOException m6755b() {
        return this.f5327O;
    }

    /* renamed from: c */
    public IOException m6756c() {
        return this.f5328P;
    }
}
