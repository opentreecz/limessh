package cz.opentree;

import android.os.Handler;
import com.google.android.gms.measurement.internal.zzgu;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.hu */
/* loaded from: classes.dex */
public abstract class AbstractC1127hu {

    /* renamed from: d */
    public static volatile Handler f3227d;

    /* renamed from: a */
    public final zzgu f3228a;

    /* renamed from: b */
    public final Runnable f3229b;

    /* renamed from: c */
    public volatile long f3230c;

    public AbstractC1127hu(zzgu zzguVar) {
        C0813ca.m2729k(zzguVar);
        this.f3228a = zzguVar;
        this.f3229b = new RunnableC1072gu(this, zzguVar);
    }

    /* renamed from: a */
    public static /* synthetic */ long m4647a(AbstractC1127hu abstractC1127hu, long j) {
        abstractC1127hu.f3230c = 0L;
        return 0L;
    }

    /* renamed from: b */
    public abstract void mo4648b();

    /* renamed from: c */
    public final void m4649c(long j) {
        m4651e();
        if (j >= 0) {
            this.f3230c = this.f3228a.mo1483i().mo1177a();
            if (m4652f().postDelayed(this.f3229b, j)) {
                return;
            }
            this.f3228a.mo1484j().m8522H().m9084b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    /* renamed from: d */
    public final boolean m4650d() {
        return this.f3230c != 0;
    }

    /* renamed from: e */
    public final void m4651e() {
        this.f3230c = 0L;
        m4652f().removeCallbacks(this.f3229b);
    }

    /* renamed from: f */
    public final Handler m4652f() {
        Handler handler;
        if (f3227d != null) {
            return f3227d;
        }
        synchronized (AbstractC1127hu.class) {
            if (f3227d == null) {
                f3227d = new HandlerC2028us(this.f3228a.mo1482h().getMainLooper());
            }
            handler = f3227d;
        }
        return handler;
    }
}
