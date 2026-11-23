package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class x80 {

    /* renamed from: a */
    public final ExecutorService f7898a;

    /* renamed from: b */
    public j60<Void> f7899b = Tasks.m1562e(null);

    /* renamed from: c */
    public final Object f7900c = new Object();

    /* renamed from: d */
    public ThreadLocal<Boolean> f7901d = new ThreadLocal<>();

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.x80$a */
    /* loaded from: classes.dex */
    public class RunnableC2263a implements Runnable {
        public RunnableC2263a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            x80.this.f7901d.set(Boolean.TRUE);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.x80$b */
    /* loaded from: classes.dex */
    public class CallableC2264b implements Callable<Void> {

        /* renamed from: a */
        public final /* synthetic */ Runnable f7903a;

        public CallableC2264b(x80 x80Var, Runnable runnable) {
            this.f7903a = runnable;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            this.f7903a.run();
            return null;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.x80$c */
    /* loaded from: classes.dex */
    public class C2265c<T> implements Continuation<Void, T> {

        /* renamed from: a */
        public final /* synthetic */ Callable f7904a;

        public C2265c(x80 x80Var, Callable callable) {
            this.f7904a = callable;
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: a */
        public T mo1552a(@NonNull j60<Void> j60Var) throws Exception {
            return (T) this.f7904a.call();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.x80$d */
    /* loaded from: classes.dex */
    public class C2266d<T> implements Continuation<T, Void> {
        public C2266d(x80 x80Var) {
        }

        @Override // com.google.android.gms.tasks.Continuation
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void mo1552a(@NonNull j60<T> j60Var) throws Exception {
            return null;
        }
    }

    public x80(ExecutorService executorService) {
        this.f7898a = executorService;
        executorService.submit(new RunnableC2263a());
    }

    /* renamed from: b */
    public void m9731b() {
        if (!m9734e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    /* renamed from: c */
    public Executor m9732c() {
        return this.f7898a;
    }

    /* renamed from: d */
    public final <T> j60<Void> m9733d(j60<T> j60Var) {
        return j60Var.mo2694g(this.f7898a, new C2266d(this));
    }

    /* renamed from: e */
    public final boolean m9734e() {
        return Boolean.TRUE.equals(this.f7901d.get());
    }

    /* renamed from: f */
    public final <T> Continuation<Void, T> m9735f(Callable<T> callable) {
        return new C2265c(this, callable);
    }

    /* renamed from: g */
    public j60<Void> m9736g(Runnable runnable) {
        return m9737h(new CallableC2264b(this, runnable));
    }

    /* renamed from: h */
    public <T> j60<T> m9737h(Callable<T> callable) {
        j60<T> mo2694g;
        synchronized (this.f7900c) {
            mo2694g = this.f7899b.mo2694g(this.f7898a, m9735f(callable));
            this.f7899b = m9733d(mo2694g);
        }
        return mo2694g;
    }

    /* renamed from: i */
    public <T> j60<T> m9738i(Callable<j60<T>> callable) {
        j60<T> mo2695h;
        synchronized (this.f7900c) {
            mo2695h = this.f7899b.mo2695h(this.f7898a, m9735f(callable));
            this.f7899b = m9733d(mo2695h);
        }
        return mo2695h;
    }
}
