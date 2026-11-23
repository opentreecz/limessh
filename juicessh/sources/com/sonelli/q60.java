package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.zzq;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class q60<TResult> implements zzq<TResult> {

    /* renamed from: a */
    public final Executor f5943a;

    /* renamed from: b */
    public final Object f5944b = new Object();

    /* renamed from: c */
    @GuardedBy("mLock")
    public OnCanceledListener f5945c;

    public q60(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f5943a = executor;
        this.f5945c = onCanceledListener;
    }

    @Override // com.google.android.gms.tasks.zzq
    /* renamed from: a */
    public final void mo1567a(@NonNull j60 j60Var) {
        if (j60Var.mo2699l()) {
            synchronized (this.f5944b) {
                if (this.f5945c == null) {
                    return;
                }
                this.f5943a.execute(new r60(this));
            }
        }
    }
}
