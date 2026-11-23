package com.sonelli;

import java.util.concurrent.Callable;

/* renamed from: com.sonelli.qg */
/* loaded from: classes.dex */
public final class CallableC1761qg implements Callable<String> {

    /* renamed from: a */
    public final /* synthetic */ C1653og f5994a;

    public CallableC1761qg(C1653og c1653og) {
        this.f5994a = c1653og;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ String call() throws Exception {
        String m7032M0;
        m7032M0 = this.f5994a.m7032M0();
        return m7032M0;
    }
}
