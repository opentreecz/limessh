package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class j60<TResult> {
    @NonNull
    /* renamed from: a */
    public j60<TResult> mo2688a(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        throw new UnsupportedOperationException("addOnCanceledListener is not implemented");
    }

    @NonNull
    /* renamed from: b */
    public j60<TResult> mo2689b(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    /* renamed from: c */
    public j60<TResult> mo2690c(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        throw new UnsupportedOperationException("addOnCompleteListener is not implemented");
    }

    @NonNull
    /* renamed from: d */
    public abstract j60<TResult> mo2691d(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener);

    @NonNull
    /* renamed from: e */
    public abstract j60<TResult> mo2692e(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener);

    @NonNull
    /* renamed from: f */
    public <TContinuationResult> j60<TContinuationResult> mo2693f(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    /* renamed from: g */
    public <TContinuationResult> j60<TContinuationResult> mo2694g(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        throw new UnsupportedOperationException("continueWith is not implemented");
    }

    @NonNull
    /* renamed from: h */
    public <TContinuationResult> j60<TContinuationResult> mo2695h(@NonNull Executor executor, @NonNull Continuation<TResult, j60<TContinuationResult>> continuation) {
        throw new UnsupportedOperationException("continueWithTask is not implemented");
    }

    @Nullable
    /* renamed from: i */
    public abstract Exception mo2696i();

    @Nullable
    /* renamed from: j */
    public abstract TResult mo2697j();

    @Nullable
    /* renamed from: k */
    public abstract <X extends Throwable> TResult mo2698k(@NonNull Class<X> cls) throws Throwable;

    /* renamed from: l */
    public abstract boolean mo2699l();

    /* renamed from: m */
    public abstract boolean mo2700m();

    /* renamed from: n */
    public abstract boolean mo2701n();

    @NonNull
    /* renamed from: o */
    public <TContinuationResult> j60<TContinuationResult> mo2702o(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }

    @NonNull
    /* renamed from: p */
    public <TContinuationResult> j60<TContinuationResult> mo2703p(@NonNull Executor executor, @NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        throw new UnsupportedOperationException("onSuccessTask is not implemented");
    }
}
