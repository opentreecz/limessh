package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import cz.opentree.wm0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: Dispatcher.java */
/* loaded from: classes.dex */
public final class om0 {

    /* renamed from: c */
    @Nullable
    public Runnable f5510c;

    /* renamed from: d */
    @Nullable
    public ExecutorService f5511d;

    /* renamed from: a */
    public int f5508a = 64;

    /* renamed from: b */
    public int f5509b = 5;

    /* renamed from: e */
    public final Deque<wm0.C2235b> f5512e = new ArrayDeque();

    /* renamed from: f */
    public final Deque<wm0.C2235b> f5513f = new ArrayDeque();

    /* renamed from: g */
    public final Deque<wm0> f5514g = new ArrayDeque();

    /* renamed from: a */
    public synchronized void m7055a(wm0 wm0Var) {
        this.f5514g.add(wm0Var);
    }

    /* renamed from: b */
    public synchronized ExecutorService m7056b() {
        if (this.f5511d == null) {
            this.f5511d = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, TimeUnit.SECONDS, new SynchronousQueue(), fn0.m3816G("OkHttp Dispatcher", false));
        }
        return this.f5511d;
    }

    /* renamed from: c */
    public final <T> void m7057c(Deque<T> deque, T t) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(t)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f5510c;
        }
        if (m7060f() || runnable == null) {
            return;
        }
        runnable.run();
    }

    /* renamed from: d */
    public void m7058d(wm0.C2235b c2235b) {
        m7057c(this.f5513f, c2235b);
    }

    /* renamed from: e */
    public void m7059e(wm0 wm0Var) {
        m7057c(this.f5514g, wm0Var);
    }

    /* renamed from: f */
    public final boolean m7060f() {
        int i;
        boolean z;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<wm0.C2235b> it = this.f5512e.iterator();
            while (it.hasNext()) {
                wm0.C2235b next = it.next();
                if (this.f5513f.size() >= this.f5508a) {
                    break;
                }
                if (m7062h(next) < this.f5509b) {
                    it.remove();
                    arrayList.add(next);
                    this.f5513f.add(next);
                }
            }
            z = m7061g() > 0;
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((wm0.C2235b) arrayList.get(i)).m9594l(m7056b());
        }
        return z;
    }

    /* renamed from: g */
    public synchronized int m7061g() {
        return this.f5513f.size() + this.f5514g.size();
    }

    /* renamed from: h */
    public final int m7062h(wm0.C2235b c2235b) {
        int i = 0;
        for (wm0.C2235b c2235b2 : this.f5513f) {
            if (!c2235b2.m9595m().f7770T && c2235b2.m9596n().equals(c2235b.m9596n())) {
                i++;
            }
        }
        return i;
    }
}
