package cz.opentree;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class jd0 {

    /* renamed from: e */
    @GuardedBy("MessengerIpcClient.class")
    public static jd0 f3543e;

    /* renamed from: a */
    public final Context f3544a;

    /* renamed from: b */
    public final ScheduledExecutorService f3545b;

    /* renamed from: c */
    @GuardedBy("this")
    public kd0 f3546c = new kd0(this);

    /* renamed from: d */
    @GuardedBy("this")
    public int f3547d = 1;

    @VisibleForTesting
    public jd0(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.f3545b = scheduledExecutorService;
        this.f3544a = context.getApplicationContext();
    }

    /* renamed from: d */
    public static synchronized jd0 m5102d(Context context) {
        jd0 jd0Var;
        synchronized (jd0.class) {
            if (f3543e == null) {
                f3543e = new jd0(context, C0985ff.m3743a().mo1207a(1, new ThreadFactoryC1755qc("MessengerIpcClient"), C1210jf.f3552a));
            }
            jd0Var = f3543e;
        }
        return jd0Var;
    }

    /* renamed from: a */
    public final synchronized int m5104a() {
        int i;
        i = this.f3547d;
        this.f3547d = i + 1;
        return i;
    }

    /* renamed from: c */
    public final synchronized <T> j60<T> m5105c(ud0<T> ud0Var) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(ud0Var);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.f3546c.m5871e(ud0Var)) {
            kd0 kd0Var = new kd0(this);
            this.f3546c = kd0Var;
            kd0Var.m5871e(ud0Var);
        }
        return ud0Var.f6950b.m5842a();
    }

    /* renamed from: e */
    public final j60<Bundle> m5106e(int i, Bundle bundle) {
        return m5105c(new wd0(m5104a(), 1, bundle));
    }
}
