package com.sonelli;

import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class f90 {

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.f90$a */
    /* loaded from: classes.dex */
    public class ThreadFactoryC0975a implements ThreadFactory {

        /* renamed from: a */
        public final /* synthetic */ String f2630a;

        /* renamed from: b */
        public final /* synthetic */ AtomicLong f2631b;

        /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
        /* renamed from: com.sonelli.f90$a$a */
        /* loaded from: classes.dex */
        public class a extends s80 {

            /* renamed from: O */
            public final /* synthetic */ Runnable f2632O;

            public a(ThreadFactoryC0975a threadFactoryC0975a, Runnable runnable) {
                this.f2632O = runnable;
            }

            @Override // com.sonelli.s80
            /* renamed from: a */
            public void mo1834a() {
                this.f2632O.run();
            }
        }

        public ThreadFactoryC0975a(String str, AtomicLong atomicLong) {
            this.f2630a = str;
            this.f2631b = atomicLong;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread newThread = Executors.defaultThreadFactory().newThread(new a(this, runnable));
            newThread.setName(this.f2630a + this.f2631b.getAndIncrement());
            return newThread;
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.f90$b */
    /* loaded from: classes.dex */
    public class C0976b extends s80 {

        /* renamed from: O */
        public final /* synthetic */ String f2633O;

        /* renamed from: P */
        public final /* synthetic */ ExecutorService f2634P;

        /* renamed from: Q */
        public final /* synthetic */ long f2635Q;

        /* renamed from: R */
        public final /* synthetic */ TimeUnit f2636R;

        public C0976b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
            this.f2633O = str;
            this.f2634P = executorService;
            this.f2635Q = j;
            this.f2636R = timeUnit;
        }

        @Override // com.sonelli.s80
        /* renamed from: a */
        public void mo1834a() {
            try {
                m80.m6375f().m6377b("Executing shutdown hook for " + this.f2633O);
                this.f2634P.shutdown();
                if (this.f2634P.awaitTermination(this.f2635Q, this.f2636R)) {
                    return;
                }
                m80.m6375f().m6377b(this.f2633O + " did not shut down in the allocated time. Requesting immediate shutdown.");
                this.f2634P.shutdownNow();
            } catch (InterruptedException unused) {
                m80.m6375f().m6377b(String.format(Locale.US, "Interrupted while waiting for %s to shut down. Requesting immediate shutdown.", this.f2633O));
                this.f2634P.shutdownNow();
            }
        }
    }

    /* renamed from: a */
    public static final void m3692a(String str, ExecutorService executorService) {
        m3693b(str, executorService, 2L, TimeUnit.SECONDS);
    }

    /* renamed from: b */
    public static final void m3693b(String str, ExecutorService executorService, long j, TimeUnit timeUnit) {
        Runtime.getRuntime().addShutdownHook(new Thread(new C0976b(str, executorService, j, timeUnit), "Crashlytics Shutdown Hook for " + str));
    }

    /* renamed from: c */
    public static ExecutorService m3694c(String str) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(m3695d(str));
        m3692a(str, newSingleThreadExecutor);
        return newSingleThreadExecutor;
    }

    /* renamed from: d */
    public static final ThreadFactory m3695d(String str) {
        return new ThreadFactoryC0975a(str, new AtomicLong(1L));
    }
}
