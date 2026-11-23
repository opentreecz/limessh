package com.sonelli;

import java.io.IOException;

/* loaded from: classes.dex */
public class tp0 extends IOException {

    /* renamed from: O */
    public Throwable f6817O;

    public tp0(String str) {
        super(str);
    }

    public tp0(String str, Throwable th) {
        super(str);
        this.f6817O = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.f6817O;
    }
}
