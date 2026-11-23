package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class c70<TResult> extends j60<TResult> {

    /* renamed from: a */
    public final Object f1880a = new Object();

    /* renamed from: b */
    public final a70<TResult> f1881b = new a70<>();

    /* renamed from: c */
    @GuardedBy("mLock")
    public boolean f1882c;

    /* renamed from: d */
    public volatile boolean f1883d;

    /* renamed from: e */
    @GuardedBy("mLock")
    public TResult f1884e;

    /* renamed from: f */
    @GuardedBy("mLock")
    public Exception f1885f;

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: a */
    public final j60<TResult> mo2688a(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.f1881b.m1989b(new q60(executor, onCanceledListener));
        m2712y();
        return this;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: b */
    public final j60<TResult> mo2689b(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        mo2690c(l60.f4754a, onCompleteListener);
        return this;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: c */
    public final j60<TResult> mo2690c(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.f1881b.m1989b(new s60(executor, onCompleteListener));
        m2712y();
        return this;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: d */
    public final j60<TResult> mo2691d(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.f1881b.m1989b(new u60(executor, onFailureListener));
        m2712y();
        return this;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: e */
    public final j60<TResult> mo2692e(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.f1881b.m1989b(new w60(executor, onSuccessListener));
        m2712y();
        return this;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: f */
    public final <TContinuationResult> j60<TContinuationResult> mo2693f(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return mo2694g(l60.f4754a, continuation);
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: g */
    public final <TContinuationResult> j60<TContinuationResult> mo2694g(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        c70 c70Var = new c70();
        this.f1881b.m1989b(new m60(executor, continuation, c70Var));
        m2712y();
        return c70Var;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: h */
    public final <TContinuationResult> j60<TContinuationResult> mo2695h(@NonNull Executor executor, @NonNull Continuation<TResult, j60<TContinuationResult>> continuation) {
        c70 c70Var = new c70();
        this.f1881b.m1989b(new o60(executor, continuation, c70Var));
        m2712y();
        return c70Var;
    }

    @Override // com.sonelli.j60
    @Nullable
    /* renamed from: i */
    public final Exception mo2696i() {
        Exception exc;
        synchronized (this.f1880a) {
            exc = this.f1885f;
        }
        return exc;
    }

    @Override // com.sonelli.j60
    /* renamed from: j */
    public final TResult mo2697j() {
        TResult tresult;
        synchronized (this.f1880a) {
            m2709v();
            m2711x();
            if (this.f1885f != null) {
                throw new i60(this.f1885f);
            }
            tresult = this.f1884e;
        }
        return tresult;
    }

    @Override // com.sonelli.j60
    /* renamed from: k */
    public final <X extends Throwable> TResult mo2698k(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f1880a) {
            m2709v();
            m2711x();
            if (cls.isInstance(this.f1885f)) {
                throw cls.cast(this.f1885f);
            }
            if (this.f1885f != null) {
                throw new i60(this.f1885f);
            }
            tresult = this.f1884e;
        }
        return tresult;
    }

    @Override // com.sonelli.j60
    /* renamed from: l */
    public final boolean mo2699l() {
        return this.f1883d;
    }

    @Override // com.sonelli.j60
    /* renamed from: m */
    public final boolean mo2700m() {
        boolean z;
        synchronized (this.f1880a) {
            z = this.f1882c;
        }
        return z;
    }

    @Override // com.sonelli.j60
    /* renamed from: n */
    public final boolean mo2701n() {
        boolean z;
        synchronized (this.f1880a) {
            z = this.f1882c && !this.f1883d && this.f1885f == null;
        }
        return z;
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: o */
    public final <TContinuationResult> j60<TContinuationResult> mo2702o(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return mo2703p(l60.f4754a, successContinuation);
    }

    @Override // com.sonelli.j60
    @NonNull
    /* renamed from: p */
    public final <TContinuationResult> j60<TContinuationResult> mo2703p(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        c70 c70Var = new c70();
        this.f1881b.m1989b(new y60(executor, successContinuation, c70Var));
        m2712y();
        return c70Var;
    }

    /* renamed from: q */
    public final void m2704q(@NonNull Exception exc) {
        C0813ca.m2730l(exc, "Exception must not be null");
        synchronized (this.f1880a) {
            m2710w();
            this.f1882c = true;
            this.f1885f = exc;
        }
        this.f1881b.m1988a(this);
    }

    /* renamed from: r */
    public final void m2705r(TResult tresult) {
        synchronized (this.f1880a) {
            m2710w();
            this.f1882c = true;
            this.f1884e = tresult;
        }
        this.f1881b.m1988a(this);
    }

    /* renamed from: s */
    public final boolean m2706s(@NonNull Exception exc) {
        C0813ca.m2730l(exc, "Exception must not be null");
        synchronized (this.f1880a) {
            if (this.f1882c) {
                return false;
            }
            this.f1882c = true;
            this.f1885f = exc;
            this.f1881b.m1988a(this);
            return true;
        }
    }

    /* renamed from: t */
    public final boolean m2707t(TResult tresult) {
        synchronized (this.f1880a) {
            if (this.f1882c) {
                return false;
            }
            this.f1882c = true;
            this.f1884e = tresult;
            this.f1881b.m1988a(this);
            return true;
        }
    }

    /* renamed from: u */
    public final boolean m2708u() {
        synchronized (this.f1880a) {
            if (this.f1882c) {
                return false;
            }
            this.f1882c = true;
            this.f1883d = true;
            this.f1881b.m1988a(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    /* renamed from: v */
    public final void m2709v() {
        C0813ca.m2733o(this.f1882c, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    /* renamed from: w */
    public final void m2710w() {
        C0813ca.m2733o(!this.f1882c, "Task is already complete");
    }

    @GuardedBy("mLock")
    /* renamed from: x */
    public final void m2711x() {
        if (this.f1883d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    /* renamed from: y */
    public final void m2712y() {
        synchronized (this.f1880a) {
            if (this.f1882c) {
                this.f1881b.m1988a(this);
            }
        }
    }
}
