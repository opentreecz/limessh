package com.google.android.datatransport.runtime.synchronization;

import androidx.annotation.WorkerThread;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
@WorkerThread
/* loaded from: classes.dex */
public interface SynchronizationGuard {

    /* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
    /* loaded from: classes.dex */
    public interface CriticalSection<T> {
        /* renamed from: h */
        T mo806h();
    }

    /* renamed from: a */
    <T> T mo784a(CriticalSection<T> criticalSection);
}
