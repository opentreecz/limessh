package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class u60<TResult> implements zzq<TResult> {

    /* renamed from: a */
    public final Executor f6921a;

    /* renamed from: b */
    public final Object f6922b = new Object();

    /* renamed from: c */
    @GuardedBy("mLock")
    public OnFailureListener f6923c;

    public u60(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f6921a = executor;
        this.f6923c = onFailureListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60<TResult> j60Var) {
        if (j60Var.mo2701n() || j60Var.mo2699l()) {
            return;
        }
        synchronized (this.f6922b) {
            if (this.f6923c == null) {
                return;
            }
            this.f6921a.execute(new v60(this, j60Var));
        }
    }
}
