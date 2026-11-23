package cz.opentree;

import android.os.Handler;

/* renamed from: cz.opentree.wg */
/* loaded from: classes.dex */
public abstract class AbstractC2217wg {

    /* renamed from: d */
    public static volatile Handler f7688d;

    /* renamed from: a */
    public final C2216wf f7689a;

    /* renamed from: b */
    public final Runnable f7690b;

    /* renamed from: c */
    public volatile long f7691c;

    public AbstractC2217wg(C2216wf c2216wf) {
        C0813ca.m2729k(c2216wf);
        this.f7689a = c2216wf;
        this.f7690b = new RunnableC2276xg(this);
    }

    /* renamed from: d */
    public static /* synthetic */ long m9495d(AbstractC2217wg abstractC2217wg, long j) {
        abstractC2217wg.f7691c = 0L;
        return 0L;
    }

    /* renamed from: a */
    public final void m9497a() {
        this.f7691c = 0L;
        m9498b().removeCallbacks(this.f7690b);
    }

    /* renamed from: b */
    public final Handler m9498b() {
        Handler handler;
        if (f7688d != null) {
            return f7688d;
        }
        synchronized (AbstractC2217wg.class) {
            if (f7688d == null) {
                f7688d = new HandlerC1161ii(this.f7689a.m9475a().getMainLooper());
            }
            handler = f7688d;
        }
        return handler;
    }

    /* renamed from: c */
    public abstract void mo2457c();

    /* renamed from: f */
    public final long m9499f() {
        if (this.f7691c == 0) {
            return 0L;
        }
        return Math.abs(this.f7689a.m9476d().mo1177a() - this.f7691c);
    }

    /* renamed from: g */
    public final boolean m9500g() {
        return this.f7691c != 0;
    }

    /* renamed from: h */
    public final void m9501h(long j) {
        m9497a();
        if (j >= 0) {
            this.f7691c = this.f7689a.m9476d().mo1177a();
            if (m9498b().postDelayed(this.f7690b, j)) {
                return;
            }
            this.f7689a.m9477e().m8674w0("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    /* renamed from: i */
    public final void m9502i(long j) {
        if (m9500g()) {
            if (j < 0) {
                m9497a();
                return;
            }
            long abs = j - Math.abs(this.f7689a.m9476d().mo1177a() - this.f7691c);
            long j2 = abs >= 0 ? abs : 0L;
            m9498b().removeCallbacks(this.f7690b);
            if (m9498b().postDelayed(this.f7690b, j2)) {
                return;
            }
            this.f7689a.m9477e().m8674w0("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
