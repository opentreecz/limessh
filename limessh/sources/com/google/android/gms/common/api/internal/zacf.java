package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@WorkerThread
/* loaded from: classes.dex */
public interface zacf {
    /* renamed from: b */
    void mo1021b(IAccountAccessor iAccountAccessor, Set<Scope> set);

    /* renamed from: c */
    void mo1022c(ConnectionResult connectionResult);
}
