package com.sonelli;

import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.rz */
/* loaded from: classes.dex */
public final class C1839rz extends p00 {

    /* renamed from: l */
    public static final AtomicLong f6301l = new AtomicLong(Long.MIN_VALUE);

    /* renamed from: c */
    public C2192vz f6302c;

    /* renamed from: d */
    public C2192vz f6303d;

    /* renamed from: e */
    public final PriorityBlockingQueue<C1890sz<?>> f6304e;

    /* renamed from: f */
    public final BlockingQueue<C1890sz<?>> f6305f;

    /* renamed from: g */
    public final Thread.UncaughtExceptionHandler f6306g;

    /* renamed from: h */
    public final Thread.UncaughtExceptionHandler f6307h;

    /* renamed from: i */
    public final Object f6308i;

    /* renamed from: j */
    public final Semaphore f6309j;

    /* renamed from: k */
    public volatile boolean f6310k;

    public C1839rz(C2144uz c2144uz) {
        super(c2144uz);
        this.f6308i = new Object();
        this.f6309j = new Semaphore(2);
        this.f6304e = new PriorityBlockingQueue<>();
        this.f6305f = new LinkedBlockingQueue();
        this.f6306g = new C1987tz(this, "Thread death: Uncaught exception on worker thread");
        this.f6307h = new C1987tz(this, "Thread death: Uncaught exception on network thread");
    }

    /* renamed from: B */
    public static /* synthetic */ C2192vz m8273B(C1839rz c1839rz, C2192vz c2192vz) {
        c1839rz.f6303d = null;
        return null;
    }

    /* renamed from: v */
    public static /* synthetic */ C2192vz m8279v(C1839rz c1839rz, C2192vz c2192vz) {
        c1839rz.f6302c = null;
        return null;
    }

    /* renamed from: A */
    public final void m8281A(Runnable runnable) throws IllegalStateException {
        m7166q();
        C0813ca.m2729k(runnable);
        m8287z(new C1890sz<>(this, runnable, false, "Task exception on worker thread"));
    }

    /* renamed from: C */
    public final <V> Future<V> m8282C(Callable<V> callable) throws IllegalStateException {
        m7166q();
        C0813ca.m2729k(callable);
        C1890sz<?> c1890sz = new C1890sz<>(this, (Callable<?>) callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6302c) {
            c1890sz.run();
        } else {
            m8287z(c1890sz);
        }
        return c1890sz;
    }

    /* renamed from: D */
    public final void m8283D(Runnable runnable) throws IllegalStateException {
        m7166q();
        C0813ca.m2729k(runnable);
        C1890sz<?> c1890sz = new C1890sz<>(this, runnable, false, "Task exception on network thread");
        synchronized (this.f6308i) {
            this.f6305f.add(c1890sz);
            C2192vz c2192vz = this.f6303d;
            if (c2192vz == null) {
                C2192vz c2192vz2 = new C2192vz(this, "Measurement Network", this.f6305f);
                this.f6303d = c2192vz2;
                c2192vz2.setUncaughtExceptionHandler(this.f6307h);
                this.f6303d.start();
            } else {
                c2192vz.m9372a();
            }
        }
    }

    /* renamed from: I */
    public final boolean m8284I() {
        return Thread.currentThread() == this.f6302c;
    }

    @Override // com.sonelli.q00
    /* renamed from: c */
    public final void mo7584c() {
        if (Thread.currentThread() != this.f6303d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override // com.sonelli.q00
    /* renamed from: d */
    public final void mo7585d() {
        if (Thread.currentThread() != this.f6302c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override // com.sonelli.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        return false;
    }

    /* renamed from: w */
    public final <T> T m8285w(AtomicReference<T> atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            mo1481g().m8281A(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                C2142uy m8525K = mo1484j().m8525K();
                String valueOf = String.valueOf(str);
                m8525K.m9083a(valueOf.length() != 0 ? "Interrupted waiting for ".concat(valueOf) : new String("Interrupted waiting for "));
                return null;
            }
        }
        T t = atomicReference.get();
        if (t == null) {
            C2142uy m8525K2 = mo1484j().m8525K();
            String valueOf2 = String.valueOf(str);
            m8525K2.m9083a(valueOf2.length() != 0 ? "Timed out waiting for ".concat(valueOf2) : new String("Timed out waiting for "));
        }
        return t;
    }

    /* renamed from: x */
    public final <V> Future<V> m8286x(Callable<V> callable) throws IllegalStateException {
        m7166q();
        C0813ca.m2729k(callable);
        C1890sz<?> c1890sz = new C1890sz<>(this, (Callable<?>) callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f6302c) {
            if (!this.f6304e.isEmpty()) {
                mo1484j().m8525K().m9083a("Callable skipped the worker queue.");
            }
            c1890sz.run();
        } else {
            m8287z(c1890sz);
        }
        return c1890sz;
    }

    /* renamed from: z */
    public final void m8287z(C1890sz<?> c1890sz) {
        synchronized (this.f6308i) {
            this.f6304e.add(c1890sz);
            C2192vz c2192vz = this.f6302c;
            if (c2192vz == null) {
                C2192vz c2192vz2 = new C2192vz(this, "Measurement Worker", this.f6304e);
                this.f6302c = c2192vz2;
                c2192vz2.setUncaughtExceptionHandler(this.f6306g);
                this.f6302c.start();
            } else {
                c2192vz.m9372a();
            }
        }
    }
}
