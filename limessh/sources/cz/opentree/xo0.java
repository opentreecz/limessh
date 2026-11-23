package cz.opentree;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okio.Sink;
import okio.Source;

/* compiled from: AsyncTimeout.java */
/* loaded from: classes.dex */
public class xo0 extends mp0 {

    /* renamed from: h */
    public static final long f8036h;

    /* renamed from: i */
    public static final long f8037i;

    /* renamed from: j */
    @Nullable
    public static xo0 f8038j;

    /* renamed from: e */
    public boolean f8039e;

    /* renamed from: f */
    @Nullable
    public xo0 f8040f;

    /* renamed from: g */
    public long f8041g;

    /* compiled from: AsyncTimeout.java */
    /* renamed from: cz.opentree.xo0$a */
    /* loaded from: classes.dex */
    public class C2305a implements Sink {

        /* renamed from: O */
        public final /* synthetic */ Sink f8042O;

        public C2305a(Sink sink) {
            this.f8042O = sink;
        }

        @Override // okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            np0.m6762b(zo0Var.f8573P, 0L, j);
            while (true) {
                long j2 = 0;
                if (j <= 0) {
                    return;
                }
                jp0 jp0Var = zo0Var.f8572O;
                while (true) {
                    if (j2 >= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) {
                        break;
                    }
                    j2 += jp0Var.f3640c - jp0Var.f3639b;
                    if (j2 >= j) {
                        j2 = j;
                        break;
                    }
                    jp0Var = jp0Var.f3643f;
                }
                xo0.this.m9855k();
                try {
                    try {
                        this.f8042O.mo2189F(zo0Var, j2);
                        j -= j2;
                        xo0.this.m9857m(true);
                    } catch (IOException e) {
                        throw xo0.this.m9856l(e);
                    }
                } catch (Throwable th) {
                    xo0.this.m9857m(false);
                    throw th;
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            xo0.this.m9855k();
            try {
                try {
                    this.f8042O.close();
                    xo0.this.m9857m(true);
                } catch (IOException e) {
                    throw xo0.this.m9856l(e);
                }
            } catch (Throwable th) {
                xo0.this.m9857m(false);
                throw th;
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            xo0.this.m9855k();
            try {
                try {
                    this.f8042O.flush();
                    xo0.this.m9857m(true);
                } catch (IOException e) {
                    throw xo0.this.m9856l(e);
                }
            } catch (Throwable th) {
                xo0.this.m9857m(false);
                throw th;
            }
        }

        @Override // okio.Sink
        /* renamed from: g */
        public mp0 mo2190g() {
            return xo0.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f8042O + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: cz.opentree.xo0$b */
    /* loaded from: classes.dex */
    public class C2306b implements Source {

        /* renamed from: O */
        public final /* synthetic */ Source f8044O;

        public C2306b(Source source) {
            this.f8044O = source;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            xo0.this.m9855k();
            try {
                try {
                    long mo2186R = this.f8044O.mo2186R(zo0Var, j);
                    xo0.this.m9857m(true);
                    return mo2186R;
                } catch (IOException e) {
                    throw xo0.this.m9856l(e);
                }
            } catch (Throwable th) {
                xo0.this.m9857m(false);
                throw th;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            try {
                try {
                    this.f8044O.close();
                    xo0.this.m9857m(true);
                } catch (IOException e) {
                    throw xo0.this.m9856l(e);
                }
            } catch (Throwable th) {
                xo0.this.m9857m(false);
                throw th;
            }
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return xo0.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f8044O + ")";
        }
    }

    /* compiled from: AsyncTimeout.java */
    /* renamed from: cz.opentree.xo0$c */
    /* loaded from: classes.dex */
    public static final class C2307c extends Thread {
        public C2307c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x0015, code lost:
        
            r1.mo4238t();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                r3 = this;
            L0:
                java.lang.Class<cz.opentree.xo0> r0 = cz.opentree.xo0.class
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L0
                cz.opentree.xo0 r1 = cz.opentree.xo0.m9852i()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L0
            Lb:
                cz.opentree.xo0 r2 = cz.opentree.xo0.f8038j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                cz.opentree.xo0.f8038j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.mo4238t()     // Catch: java.lang.InterruptedException -> L0
                goto L0
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L0
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.opentree.xo0.C2307c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f8036h = millis;
        f8037i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    @Nullable
    /* renamed from: i */
    public static xo0 m9852i() throws InterruptedException {
        xo0 xo0Var = f8038j.f8040f;
        if (xo0Var == null) {
            long nanoTime = System.nanoTime();
            xo0.class.wait(f8036h);
            if (f8038j.f8040f != null || System.nanoTime() - nanoTime < f8037i) {
                return null;
            }
            return f8038j;
        }
        long m9859p = xo0Var.m9859p(System.nanoTime());
        if (m9859p > 0) {
            long j = m9859p / 1000000;
            xo0.class.wait(j, (int) (m9859p - (1000000 * j)));
            return null;
        }
        f8038j.f8040f = xo0Var.f8040f;
        xo0Var.f8040f = null;
        return xo0Var;
    }

    /* renamed from: j */
    public static synchronized boolean m9853j(xo0 xo0Var) {
        synchronized (xo0.class) {
            xo0 xo0Var2 = f8038j;
            while (xo0Var2 != null) {
                xo0 xo0Var3 = xo0Var2.f8040f;
                if (xo0Var3 == xo0Var) {
                    xo0Var2.f8040f = xo0Var.f8040f;
                    xo0Var.f8040f = null;
                    return false;
                }
                xo0Var2 = xo0Var3;
            }
            return true;
        }
    }

    /* renamed from: q */
    public static synchronized void m9854q(xo0 xo0Var, long j, boolean z) {
        synchronized (xo0.class) {
            if (f8038j == null) {
                f8038j = new xo0();
                new C2307c().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                xo0Var.f8041g = Math.min(j, xo0Var.mo3306c() - nanoTime) + nanoTime;
            } else if (j != 0) {
                xo0Var.f8041g = j + nanoTime;
            } else {
                if (!z) {
                    throw new AssertionError();
                }
                xo0Var.f8041g = xo0Var.mo3306c();
            }
            long m9859p = xo0Var.m9859p(nanoTime);
            xo0 xo0Var2 = f8038j;
            while (true) {
                xo0 xo0Var3 = xo0Var2.f8040f;
                if (xo0Var3 == null || m9859p < xo0Var3.m9859p(nanoTime)) {
                    break;
                } else {
                    xo0Var2 = xo0Var2.f8040f;
                }
            }
            xo0Var.f8040f = xo0Var2.f8040f;
            xo0Var2.f8040f = xo0Var;
            if (xo0Var2 == f8038j) {
                xo0.class.notify();
            }
        }
    }

    /* renamed from: k */
    public final void m9855k() {
        if (this.f8039e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long m6510h = m6510h();
        boolean mo3308e = mo3308e();
        if (m6510h != 0 || mo3308e) {
            this.f8039e = true;
            m9854q(this, m6510h, mo3308e);
        }
    }

    /* renamed from: l */
    public final IOException m9856l(IOException iOException) throws IOException {
        return !m9858n() ? iOException : mo4237o(iOException);
    }

    /* renamed from: m */
    public final void m9857m(boolean z) throws IOException {
        if (m9858n() && z) {
            throw mo4237o(null);
        }
    }

    /* renamed from: n */
    public final boolean m9858n() {
        if (!this.f8039e) {
            return false;
        }
        this.f8039e = false;
        return m9853j(this);
    }

    /* renamed from: o */
    public IOException mo4237o(@Nullable IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: p */
    public final long m9859p(long j) {
        return this.f8041g - j;
    }

    /* renamed from: r */
    public final Sink m9860r(Sink sink) {
        return new C2305a(sink);
    }

    /* renamed from: s */
    public final Source m9861s(Source source) {
        return new C2306b(source);
    }

    /* renamed from: t */
    public void mo4238t() {
    }
}
