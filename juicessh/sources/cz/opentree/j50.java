package cz.opentree;

import android.content.Context;
import android.os.Process;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tagmanager.zzd;

/* loaded from: classes.dex */
public final class j50 {

    /* renamed from: h */
    public static Object f3490h = new Object();

    /* renamed from: i */
    public static j50 f3491i;

    /* renamed from: a */
    public volatile long f3492a;

    /* renamed from: b */
    public volatile boolean f3493b;

    /* renamed from: c */
    public final Context f3494c;

    /* renamed from: d */
    public final Clock f3495d;

    /* renamed from: e */
    public final Thread f3496e;

    /* renamed from: f */
    public final Object f3497f;

    /* renamed from: g */
    public zzd f3498g;

    public j50(Context context) {
        this(context, null, C0921ec.m3474d());
    }

    public j50(Context context, zzd zzdVar, Clock clock) {
        this.f3492a = 900000L;
        this.f3493b = false;
        this.f3497f = new Object();
        this.f3498g = new q50(this);
        this.f3495d = clock;
        if (context != null) {
            this.f3494c = context.getApplicationContext();
        } else {
            this.f3494c = context;
        }
        clock.mo1177a();
        this.f3496e = new Thread(new t50(this));
    }

    /* renamed from: d */
    public static j50 m5059d(Context context) {
        if (f3491i == null) {
            synchronized (f3490h) {
                if (f3491i == null) {
                    j50 j50Var = new j50(context);
                    f3491i = j50Var;
                    j50Var.f3496e.start();
                }
            }
        }
        return f3491i;
    }

    /* renamed from: a */
    public final void m5060a() {
        this.f3493b = true;
        this.f3496e.interrupt();
    }

    /* renamed from: e */
    public final void m5061e() {
        Process.setThreadPriority(10);
        while (!this.f3493b) {
            if (this.f3498g.mo1543a() != null) {
                this.f3495d.mo1177a();
                v50.m9169d("Obtained fresh AdvertisingId info from GmsCore.");
            }
            synchronized (this) {
                notifyAll();
            }
            try {
                synchronized (this.f3497f) {
                    this.f3497f.wait(this.f3492a);
                }
            } catch (InterruptedException unused) {
                v50.m9169d("sleep interrupted in AdvertiserDataPoller thread; continuing");
            }
        }
    }
}
