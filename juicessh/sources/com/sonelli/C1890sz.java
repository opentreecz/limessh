package com.sonelli;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.sz */
/* loaded from: classes.dex */
public final class C1890sz<V> extends FutureTask<V> implements Comparable<C1890sz<V>> {

    /* renamed from: O */
    public final long f6616O;

    /* renamed from: P */
    public final boolean f6617P;

    /* renamed from: Q */
    public final String f6618Q;

    /* renamed from: R */
    public final /* synthetic */ C1839rz f6619R;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1890sz(C1839rz c1839rz, Runnable runnable, boolean z, String str) {
        super(runnable, null);
        AtomicLong atomicLong;
        this.f6619R = c1839rz;
        C0813ca.m2729k(str);
        atomicLong = C1839rz.f6301l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f6616O = andIncrement;
        this.f6618Q = str;
        this.f6617P = false;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            c1839rz.mo1484j().m8522H().m9083a("Tasks index overflow");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1890sz(C1839rz c1839rz, Callable<V> callable, boolean z, String str) {
        super(callable);
        AtomicLong atomicLong;
        this.f6619R = c1839rz;
        C0813ca.m2729k(str);
        atomicLong = C1839rz.f6301l;
        long andIncrement = atomicLong.getAndIncrement();
        this.f6616O = andIncrement;
        this.f6618Q = str;
        this.f6617P = z;
        if (andIncrement == RecyclerView.FOREVER_NS) {
            c1839rz.mo1484j().m8522H().m9083a("Tasks index overflow");
        }
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        C1890sz c1890sz = (C1890sz) obj;
        boolean z = this.f6617P;
        if (z != c1890sz.f6617P) {
            return z ? -1 : 1;
        }
        long j = this.f6616O;
        long j2 = c1890sz.f6616O;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.f6619R.mo1484j().m8523I().m9084b("Two tasks share the same index. index", Long.valueOf(this.f6616O));
        return 0;
    }

    @Override // java.util.concurrent.FutureTask
    public final void setException(Throwable th) {
        this.f6619R.mo1484j().m8522H().m9084b(this.f6618Q, th);
        super.setException(th);
    }
}
