package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class y60<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {

    /* renamed from: a */
    public final Executor f8143a;

    /* renamed from: b */
    public final SuccessContinuation<TResult, TContinuationResult> f8144b;

    /* renamed from: c */
    public final c70<TContinuationResult> f8145c;

    public y60(@NonNull Executor executor, @NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation, @NonNull c70<TContinuationResult> c70Var) {
        this.f8143a = executor;
        this.f8144b = successContinuation;
        this.f8145c = c70Var;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        this.f8143a.execute(new z60(this, j60Var));
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: b */
    public final void mo1556b(TContinuationResult tcontinuationresult) {
        this.f8145c.m2705r(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    /* renamed from: c */
    public final void mo1553c() {
        this.f8145c.m2708u();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    /* renamed from: d */
    public final void mo1555d(@NonNull Exception exc) {
        this.f8145c.m2704q(exc);
    }
}
