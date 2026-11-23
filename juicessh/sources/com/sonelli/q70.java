package com.sonelli;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.4.1 */
/* loaded from: classes.dex */
public final /* synthetic */ class q70 implements Executor {

    /* renamed from: a */
    public static final Executor f5950a = new q70();

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        runnable.run();
    }
}
