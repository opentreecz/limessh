package com.sonelli;

import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final /* synthetic */ class te0 implements Executor {

    /* renamed from: a */
    public static final Executor f6761a = new te0();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
