package com.google.android.gms.common.api;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Result;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes.dex */
public abstract class PendingResult<R extends Result> {

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* loaded from: classes.dex */
    public interface StatusListener {
        /* renamed from: a */
        void mo990a(Status status);
    }

    /* renamed from: a */
    public abstract void mo988a(@NonNull StatusListener statusListener);

    @NonNull
    /* renamed from: b */
    public abstract R mo989b(long j, @NonNull TimeUnit timeUnit);
}
