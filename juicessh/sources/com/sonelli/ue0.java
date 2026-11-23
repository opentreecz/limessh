package com.sonelli;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ue0 {

    /* renamed from: a */
    public static final Executor f6953a = te0.f6761a;

    /* renamed from: a */
    public static Executor m8874a() {
        return f6953a;
    }

    /* renamed from: b */
    public static ExecutorService m8875b() {
        return new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC1755qc("firebase-iid-executor"));
    }
}
