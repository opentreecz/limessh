package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import com.sonelli.C0813ca;
import com.sonelli.c70;
import com.sonelli.d70;
import com.sonelli.j60;
import com.sonelli.l60;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class Tasks {

    /* renamed from: com.google.android.gms.tasks.Tasks$a */
    /* loaded from: classes.dex */
    public static final class C0454a implements zzb {

        /* renamed from: a */
        public final CountDownLatch f1069a;

        public C0454a() {
            this.f1069a = new CountDownLatch(1);
        }

        public /* synthetic */ C0454a(d70 d70Var) {
            this();
        }

        /* renamed from: a */
        public final void m1565a() throws InterruptedException {
            this.f1069a.await();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        /* renamed from: b */
        public final void mo1556b(Object obj) {
            this.f1069a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        /* renamed from: c */
        public final void mo1553c() {
            this.f1069a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        /* renamed from: d */
        public final void mo1555d(@NonNull Exception exc) {
            this.f1069a.countDown();
        }

        /* renamed from: e */
        public final boolean m1566e(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f1069a.await(j, timeUnit);
        }
    }

    /* loaded from: classes.dex */
    public interface zzb extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* renamed from: a */
    public static <TResult> TResult m1558a(@NonNull j60<TResult> j60Var) throws ExecutionException, InterruptedException {
        C0813ca.m2727i();
        C0813ca.m2730l(j60Var, "Task must not be null");
        if (j60Var.mo2700m()) {
            return (TResult) m1564g(j60Var);
        }
        C0454a c0454a = new C0454a(null);
        m1563f(j60Var, c0454a);
        c0454a.m1565a();
        return (TResult) m1564g(j60Var);
    }

    /* renamed from: b */
    public static <TResult> TResult m1559b(@NonNull j60<TResult> j60Var, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        C0813ca.m2727i();
        C0813ca.m2730l(j60Var, "Task must not be null");
        C0813ca.m2730l(timeUnit, "TimeUnit must not be null");
        if (j60Var.mo2700m()) {
            return (TResult) m1564g(j60Var);
        }
        C0454a c0454a = new C0454a(null);
        m1563f(j60Var, c0454a);
        if (c0454a.m1566e(j, timeUnit)) {
            return (TResult) m1564g(j60Var);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    /* renamed from: c */
    public static <TResult> j60<TResult> m1560c(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        C0813ca.m2730l(executor, "Executor must not be null");
        C0813ca.m2730l(callable, "Callback must not be null");
        c70 c70Var = new c70();
        executor.execute(new d70(c70Var, callable));
        return c70Var;
    }

    /* renamed from: d */
    public static <TResult> j60<TResult> m1561d(@NonNull Exception exc) {
        c70 c70Var = new c70();
        c70Var.m2704q(exc);
        return c70Var;
    }

    /* renamed from: e */
    public static <TResult> j60<TResult> m1562e(TResult tresult) {
        c70 c70Var = new c70();
        c70Var.m2705r(tresult);
        return c70Var;
    }

    /* renamed from: f */
    public static void m1563f(j60<?> j60Var, zzb zzbVar) {
        Executor executor = l60.f4755b;
        j60Var.mo2692e(executor, zzbVar);
        j60Var.mo2691d(executor, zzbVar);
        j60Var.mo2688a(executor, zzbVar);
    }

    /* renamed from: g */
    public static <TResult> TResult m1564g(j60<TResult> j60Var) throws ExecutionException {
        if (j60Var.mo2701n()) {
            return j60Var.mo2697j();
        }
        if (j60Var.mo2699l()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(j60Var.mo2696i());
    }
}
