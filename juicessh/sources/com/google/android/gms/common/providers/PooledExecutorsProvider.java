package com.google.android.gms.common.providers;

import com.sonelli.C1206jb;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes.dex */
public class PooledExecutorsProvider {

    /* renamed from: a */
    public static PooledExecutorFactory f872a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes.dex */
    public interface PooledExecutorFactory {
        /* renamed from: a */
        ScheduledExecutorService mo1143a();
    }

    /* renamed from: a */
    public static synchronized PooledExecutorFactory m1142a() {
        PooledExecutorFactory pooledExecutorFactory;
        synchronized (PooledExecutorsProvider.class) {
            if (f872a == null) {
                f872a = new C1206jb();
            }
            pooledExecutorFactory = f872a;
        }
        return pooledExecutorFactory;
    }
}
