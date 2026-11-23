package com.sonelli;

import android.util.Log;
import com.sonelli.C1434k4;
import java.lang.Thread;
import java.util.concurrent.FutureTask;

/* JADX INFO: Add missing generic type declarations: [T] */
/* renamed from: com.sonelli.m4 */
/* loaded from: classes.dex */
public final class C1537m4<T> extends FutureTask<T> {

    /* renamed from: O */
    public final /* synthetic */ C1434k4.a f4981O;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1537m4(C1434k4.a aVar, Runnable runnable, Object obj) {
        super(runnable, obj);
        this.f4981O = aVar;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        uncaughtExceptionHandler = C1434k4.this.f4473e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        } else if (Log.isLoggable("GAv4", 6)) {
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 37);
            sb.append("MeasurementExecutor: job failed with ");
            sb.append(valueOf);
            Log.e("GAv4", sb.toString());
        }
        super.setException(th);
    }
}
