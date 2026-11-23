package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.gtm.zzde;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: cz.opentree.gi */
/* loaded from: classes.dex */
public final class C1044gi implements zzde {
    public C1044gi() {
    }

    @Override // com.google.android.gms.internal.gtm.zzde
    @NonNull
    /* renamed from: a */
    public final ExecutorService mo1218a(int i) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Executors.defaultThreadFactory());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return Executors.unconfigurableExecutorService(threadPoolExecutor);
    }
}
