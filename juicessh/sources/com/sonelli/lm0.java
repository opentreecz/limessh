package com.sonelli;

import androidx.appcompat.widget.ActivityChooserView;
import com.sonelli.pn0;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: ConnectionPool.java */
/* loaded from: classes.dex */
public final class lm0 {

    /* renamed from: g */
    public static final Executor f4876g = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), fn0.m3816G("OkHttp ConnectionPool", true));

    /* renamed from: a */
    public final int f4877a;

    /* renamed from: b */
    public final long f4878b;

    /* renamed from: c */
    public final Runnable f4879c;

    /* renamed from: d */
    public final Deque<ln0> f4880d;

    /* renamed from: e */
    public final mn0 f4881e;

    /* renamed from: f */
    public boolean f4882f;

    /* compiled from: ConnectionPool.java */
    /* renamed from: com.sonelli.lm0$a */
    /* loaded from: classes.dex */
    public class RunnableC1515a implements Runnable {
        public RunnableC1515a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                long m6253a = lm0.this.m6253a(System.nanoTime());
                if (m6253a == -1) {
                    return;
                }
                if (m6253a > 0) {
                    long j = m6253a / 1000000;
                    long j2 = m6253a - (1000000 * j);
                    synchronized (lm0.this) {
                        try {
                            lm0.this.wait(j, (int) j2);
                        } catch (InterruptedException unused) {
                        }
                    }
                }
            }
        }
    }

    public lm0() {
        this(5, 5L, TimeUnit.MINUTES);
    }

    public lm0(int i, long j, TimeUnit timeUnit) {
        this.f4879c = new RunnableC1515a();
        this.f4880d = new ArrayDeque();
        this.f4881e = new mn0();
        this.f4877a = i;
        this.f4878b = timeUnit.toNanos(j);
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException("keepAliveDuration <= 0: " + j);
    }

    /* renamed from: a */
    public long m6253a(long j) {
        synchronized (this) {
            ln0 ln0Var = null;
            long j2 = Long.MIN_VALUE;
            int i = 0;
            int i2 = 0;
            for (ln0 ln0Var2 : this.f4880d) {
                if (m6257e(ln0Var2, j) > 0) {
                    i2++;
                } else {
                    i++;
                    long j3 = j - ln0Var2.f4897o;
                    if (j3 > j2) {
                        ln0Var = ln0Var2;
                        j2 = j3;
                    }
                }
            }
            long j4 = this.f4878b;
            if (j2 < j4 && i <= this.f4877a) {
                if (i > 0) {
                    return j4 - j2;
                }
                if (i2 > 0) {
                    return j4;
                }
                this.f4882f = false;
                return -1L;
            }
            this.f4880d.remove(ln0Var);
            fn0.m3827h(ln0Var.m6273q());
            return 0L;
        }
    }

    /* renamed from: b */
    public boolean m6254b(ln0 ln0Var) {
        if (ln0Var.f4893k || this.f4877a == 0) {
            this.f4880d.remove(ln0Var);
            return true;
        }
        notifyAll();
        return false;
    }

    @Nullable
    /* renamed from: c */
    public Socket m6255c(gm0 gm0Var, pn0 pn0Var) {
        for (ln0 ln0Var : this.f4880d) {
            if (ln0Var.m6268l(gm0Var, null) && ln0Var.m6270n() && ln0Var != pn0Var.m7415d()) {
                return pn0Var.m7424m(ln0Var);
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: d */
    public ln0 m6256d(gm0 gm0Var, pn0 pn0Var, bn0 bn0Var) {
        for (ln0 ln0Var : this.f4880d) {
            if (ln0Var.m6268l(gm0Var, bn0Var)) {
                pn0Var.m7412a(ln0Var, true);
                return ln0Var;
            }
        }
        return null;
    }

    /* renamed from: e */
    public final int m6257e(ln0 ln0Var, long j) {
        List<Reference<pn0>> list = ln0Var.f4896n;
        int i = 0;
        while (i < list.size()) {
            Reference<pn0> reference = list.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                ro0.m8221j().mo6501q("A connection to " + ln0Var.m6272p().m2586a().m4179l() + " was leaked. Did you forget to close a response body?", ((pn0.C1727a) reference).f5741a);
                list.remove(i);
                ln0Var.f4893k = true;
                if (list.isEmpty()) {
                    ln0Var.f4897o = j - this.f4878b;
                    return 0;
                }
            }
        }
        return list.size();
    }

    /* renamed from: f */
    public void m6258f(ln0 ln0Var) {
        if (!this.f4882f) {
            this.f4882f = true;
            f4876g.execute(this.f4879c);
        }
        this.f4880d.add(ln0Var);
    }
}
