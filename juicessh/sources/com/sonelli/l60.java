package com.sonelli;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class l60 {

    /* renamed from: a */
    public static final Executor f4754a = new ExecutorC1492a();

    /* renamed from: b */
    public static final Executor f4755b = new b70();

    /* renamed from: com.sonelli.l60$a */
    /* loaded from: classes.dex */
    public static final class ExecutorC1492a implements Executor {

        /* renamed from: a */
        public final Handler f4756a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public final void execute(@NonNull Runnable runnable) {
            this.f4756a.post(runnable);
        }
    }
}
