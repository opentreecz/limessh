package com.sonelli;

/* loaded from: classes.dex */
public class m51 extends IllegalStateException {

    /* renamed from: O */
    public Throwable f4990O;

    public m51(String str, Throwable th) {
        super(str);
        this.f4990O = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f4990O;
    }
}
