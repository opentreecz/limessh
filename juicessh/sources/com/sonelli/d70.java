package com.sonelli;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class d70 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ c70 f2138O;

    /* renamed from: P */
    public final /* synthetic */ Callable f2139P;

    public d70(c70 c70Var, Callable callable) {
        this.f2138O = c70Var;
        this.f2139P = callable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.f2138O.m2705r(this.f2139P.call());
        } catch (Exception e) {
            this.f2138O.m2704q(e);
        }
    }
}
