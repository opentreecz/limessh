package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class m60<TResult, TContinuationResult> implements zzq<TResult> {

    /* renamed from: a */
    public final Executor f4992a;

    /* renamed from: b */
    public final Continuation<TResult, TContinuationResult> f4993b;

    /* renamed from: c */
    public final c70<TContinuationResult> f4994c;

    public m60(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull c70<TContinuationResult> c70Var) {
        this.f4992a = executor;
        this.f4993b = continuation;
        this.f4994c = c70Var;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        this.f4992a.execute(new n60(this, j60Var));
    }
}
