package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.sonelli.C0813ca;
import com.sonelli.C1849s8;
import com.sonelli.C2415z8;
import com.sonelli.HandlerC2215we;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* renamed from: n */
    public static final ThreadLocal<Boolean> f741n = new C2415z8();

    /* renamed from: a */
    public final Object f742a;

    /* renamed from: b */
    public final HandlerC0430a<R> f743b;

    /* renamed from: c */
    public final CountDownLatch f744c;

    /* renamed from: d */
    public final ArrayList<PendingResult.StatusListener> f745d;

    /* renamed from: e */
    public ResultCallback<? super R> f746e;

    /* renamed from: f */
    public final AtomicReference<zacq> f747f;

    /* renamed from: g */
    public R f748g;

    /* renamed from: h */
    public Status f749h;

    /* renamed from: i */
    public volatile boolean f750i;

    /* renamed from: j */
    public boolean f751j;

    /* renamed from: k */
    public boolean f752k;

    /* renamed from: l */
    public volatile C1849s8<R> f753l;

    /* renamed from: m */
    public boolean f754m;

    @KeepName
    public C0431b mResultGuardian;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$a */
    /* loaded from: classes.dex */
    public static class HandlerC0430a<R extends Result> extends HandlerC2215we {
        public HandlerC0430a(Looper looper) {
            super(looper);
        }

        /* renamed from: a */
        public final void m1017a(ResultCallback<? super R> resultCallback, R r) {
            BasePendingResult.m1008j(resultCallback);
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).m1015l(Status.f730V);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.m992a(result);
            } catch (RuntimeException e) {
                BasePendingResult.m1009k(result);
                throw e;
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: com.google.android.gms.common.api.internal.BasePendingResult$b */
    /* loaded from: classes.dex */
    public final class C0431b {
        public C0431b() {
        }

        public /* synthetic */ C0431b(BasePendingResult basePendingResult, C2415z8 c2415z8) {
            this();
        }

        public final void finalize() throws Throwable {
            BasePendingResult.m1009k(BasePendingResult.this.f748g);
            super.finalize();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.f742a = new Object();
        this.f744c = new CountDownLatch(1);
        this.f745d = new ArrayList<>();
        this.f747f = new AtomicReference<>();
        this.f754m = false;
        this.f743b = new HandlerC0430a<>(Looper.getMainLooper());
        new WeakReference(null);
    }

    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.f742a = new Object();
        this.f744c = new CountDownLatch(1);
        this.f745d = new ArrayList<>();
        this.f747f = new AtomicReference<>();
        this.f754m = false;
        this.f743b = new HandlerC0430a<>(googleApiClient != null ? googleApiClient.mo985d() : Looper.getMainLooper());
        new WeakReference(googleApiClient);
    }

    /* renamed from: h */
    public static <R extends Result> ResultCallback<R> m1007h(ResultCallback<R> resultCallback) {
        return resultCallback;
    }

    /* renamed from: j */
    public static /* synthetic */ ResultCallback m1008j(ResultCallback resultCallback) {
        m1007h(resultCallback);
        return resultCallback;
    }

    /* renamed from: k */
    public static void m1009k(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* renamed from: a */
    public final void mo988a(PendingResult.StatusListener statusListener) {
        C0813ca.m2720b(statusListener != null, "Callback cannot be null.");
        synchronized (this.f742a) {
            if (m1012e()) {
                statusListener.mo990a(this.f749h);
            } else {
                this.f745d.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    /* renamed from: b */
    public final R mo989b(long j, TimeUnit timeUnit) {
        if (j > 0) {
            C0813ca.m2728j("await must not be called on the UI thread when time is greater than zero.");
        }
        C0813ca.m2733o(!this.f750i, "Result has already been consumed.");
        C0813ca.m2733o(this.f753l == null, "Cannot await if then() has been called.");
        try {
            if (!this.f744c.await(j, timeUnit)) {
                m1015l(Status.f730V);
            }
        } catch (InterruptedException unused) {
            m1015l(Status.f728T);
        }
        C0813ca.m2733o(m1012e(), "Result is not ready.");
        return m1011d();
    }

    @NonNull
    /* renamed from: c */
    public abstract R mo1010c(Status status);

    /* renamed from: d */
    public final R m1011d() {
        R r;
        synchronized (this.f742a) {
            C0813ca.m2733o(!this.f750i, "Result has already been consumed.");
            C0813ca.m2733o(m1012e(), "Result is not ready.");
            r = this.f748g;
            this.f748g = null;
            this.f746e = null;
            this.f750i = true;
        }
        zacq andSet = this.f747f.getAndSet(null);
        if (andSet != null) {
            andSet.m1023a(this);
        }
        return r;
    }

    /* renamed from: e */
    public final boolean m1012e() {
        return this.f744c.getCount() == 0;
    }

    /* renamed from: f */
    public final void m1013f(R r) {
        synchronized (this.f742a) {
            if (this.f752k || this.f751j) {
                m1009k(r);
                return;
            }
            m1012e();
            boolean z = true;
            C0813ca.m2733o(!m1012e(), "Results have already been set");
            if (this.f750i) {
                z = false;
            }
            C0813ca.m2733o(z, "Result has already been consumed");
            m1014i(r);
        }
    }

    /* renamed from: i */
    public final void m1014i(R r) {
        this.f748g = r;
        this.f744c.countDown();
        this.f749h = this.f748g.mo991n();
        C2415z8 c2415z8 = null;
        if (this.f751j) {
            this.f746e = null;
        } else if (this.f746e != null) {
            this.f743b.removeMessages(2);
            this.f743b.m1017a(this.f746e, m1011d());
        } else if (this.f748g instanceof Releasable) {
            this.mResultGuardian = new C0431b(this, c2415z8);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f745d;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.mo990a(this.f749h);
        }
        this.f745d.clear();
    }

    /* renamed from: l */
    public final void m1015l(Status status) {
        synchronized (this.f742a) {
            if (!m1012e()) {
                m1013f(mo1010c(status));
                this.f752k = true;
            }
        }
    }

    /* renamed from: m */
    public final void m1016m() {
        this.f754m = this.f754m || f741n.get().booleanValue();
    }
}
