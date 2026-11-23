package com.sonelli;

import androidx.annotation.NonNull;
import com.google.android.gms.tasks.zzq;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class a70<TResult> {

    /* renamed from: a */
    public final Object f1338a = new Object();

    /* renamed from: b */
    @GuardedBy("mLock")
    public Queue<zzq<TResult>> f1339b;

    /* renamed from: c */
    @GuardedBy("mLock")
    public boolean f1340c;

    /* renamed from: a */
    public final void m1988a(@NonNull j60<TResult> j60Var) {
        zzq<TResult> poll;
        synchronized (this.f1338a) {
            if (this.f1339b != null && !this.f1340c) {
                this.f1340c = true;
                while (true) {
                    synchronized (this.f1338a) {
                        poll = this.f1339b.poll();
                        if (poll == null) {
                            this.f1340c = false;
                            return;
                        }
                    }
                    poll.mo1567a(j60Var);
                }
            }
        }
    }

    /* renamed from: b */
    public final void m1989b(@NonNull zzq<TResult> zzqVar) {
        synchronized (this.f1338a) {
            if (this.f1339b == null) {
                this.f1339b = new ArrayDeque();
            }
            this.f1339b.add(zzqVar);
        }
    }
}
