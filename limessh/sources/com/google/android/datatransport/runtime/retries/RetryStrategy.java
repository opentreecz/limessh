package com.google.android.datatransport.runtime.retries;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.datatransport:transport-runtime@@2.2.1 */
/* loaded from: classes.dex */
public interface RetryStrategy<TInput, TResult> {
    @Nullable
    /* renamed from: a */
    TInput mo750a(TInput tinput, TResult tresult);
}
