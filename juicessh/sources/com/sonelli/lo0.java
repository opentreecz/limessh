package com.sonelli;

import java.io.IOException;

/* compiled from: StreamResetException.java */
/* loaded from: classes.dex */
public final class lo0 extends IOException {

    /* renamed from: O */
    public final co0 f4898O;

    public lo0(co0 co0Var) {
        super("stream was reset: " + co0Var);
        this.f4898O = co0Var;
    }
}
