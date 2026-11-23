package cz.opentree;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class o60<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {

    /* renamed from: a */
    public final Executor f5436a;

    /* renamed from: b */
    public final Continuation<TResult, j60<TContinuationResult>> f5437b;

    /* renamed from: c */
    public final c70<TContinuationResult> f5438c;

    public o60(@NonNull Executor executor, @NonNull Continuation<TResult, j60<TContinuationResult>> continuation, @NonNull c70<TContinuationResult> c70Var) {
        this.f5436a = executor;
        this.f5437b = continuation;
        this.f5438c = c70Var;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        this.f5436a.execute(new p60(this, j60Var));
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    /* renamed from: b */
    public final void mo1556b(TContinuationResult tcontinuationresult) {
        this.f5438c.m2705r(tcontinuationresult);
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    /* renamed from: c */
    public final void mo1553c() {
        this.f5438c.m2708u();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    /* renamed from: d */
    public final void mo1555d(@NonNull Exception exc) {
        this.f5438c.m2704q(exc);
    }
}
