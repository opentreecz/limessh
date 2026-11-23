package com.google.android.gms.common.api;

import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import com.sonelli.AbstractC1802r7;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@Deprecated
/* loaded from: classes.dex */
public abstract class GoogleApiClient {

    /* renamed from: a */
    @GuardedBy("sAllClients")
    public static final Set<GoogleApiClient> f724a = Collections.newSetFromMap(new WeakHashMap());

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface ConnectionCallbacks extends com.google.android.gms.common.api.internal.ConnectionCallbacks {
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    @Deprecated
    /* loaded from: classes.dex */
    public interface OnConnectionFailedListener extends com.google.android.gms.common.api.internal.OnConnectionFailedListener {
    }

    /* renamed from: c */
    public static Set<GoogleApiClient> m982c() {
        Set<GoogleApiClient> set = f724a;
        synchronized (set) {
        }
        return set;
    }

    /* renamed from: a */
    public <A extends Api.AnyClient, R extends Result, T extends AbstractC1802r7<R, A>> T mo983a(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: b */
    public <A extends Api.AnyClient, T extends AbstractC1802r7<? extends Result, A>> T mo984b(@NonNull T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public Looper mo985d() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: e */
    public boolean m986e(SignInConnectionListener signInConnectionListener) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: f */
    public void m987f() {
        throw new UnsupportedOperationException();
    }
}
