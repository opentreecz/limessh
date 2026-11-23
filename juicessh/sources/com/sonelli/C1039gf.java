package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.firebase_messaging.zzb;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* renamed from: com.sonelli.gf */
/* loaded from: classes.dex */
public final class C1039gf implements zzb {
    public C1039gf() {
    }

    @Override // com.google.android.gms.internal.firebase_messaging.zzb
    @NonNull
    /* renamed from: a */
    public final ScheduledExecutorService mo1207a(int i, ThreadFactory threadFactory, int i2) {
        return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, threadFactory));
    }
}
