package cz.opentree;

import androidx.core.app.NotificationCompat;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;

/* compiled from: RealCall.java */
/* loaded from: classes.dex */
public final class wm0 implements Call {

    /* renamed from: O */
    public final um0 f7765O;

    /* renamed from: P */
    public final yn0 f7766P;

    /* renamed from: Q */
    public final xo0 f7767Q;

    /* renamed from: R */
    @Nullable
    public EventListener f7768R;

    /* renamed from: S */
    public final xm0 f7769S;

    /* renamed from: T */
    public final boolean f7770T;

    /* renamed from: U */
    public boolean f7771U;

    /* compiled from: RealCall.java */
    /* renamed from: cz.opentree.wm0$a */
    /* loaded from: classes.dex */
    public class C2234a extends xo0 {
        public C2234a() {
        }

        @Override // cz.opentree.xo0
        /* renamed from: t */
        public void mo4238t() {
            wm0.this.m9585c();
        }
    }

    /* compiled from: RealCall.java */
    /* renamed from: cz.opentree.wm0$b */
    /* loaded from: classes.dex */
    public final class C2235b extends en0 {

        /* renamed from: P */
        public final Callback f7773P;

        /* renamed from: Q */
        public final /* synthetic */ wm0 f7774Q;

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            IOException e;
            zm0 m9588g;
            this.f7774Q.f7767Q.m9855k();
            boolean z = true;
            try {
                try {
                    m9588g = this.f7774Q.m9588g();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (this.f7774Q.f7766P.m10198e()) {
                        this.f7773P.m10695b(this.f7774Q, new IOException("Canceled"));
                    } else {
                        this.f7773P.m10694a(this.f7774Q, m9588g);
                    }
                } catch (IOException e3) {
                    e = e3;
                    IOException m9592l = this.f7774Q.m9592l(e);
                    if (z) {
                        ro0.m8221j().mo6500p(4, "Callback failure for " + this.f7774Q.m9593m(), m9592l);
                    } else {
                        this.f7774Q.f7768R.m10701b(this.f7774Q, m9592l);
                        this.f7773P.m10695b(this.f7774Q, m9592l);
                    }
                }
            } finally {
                this.f7774Q.f7765O.m8947k().m7058d(this);
            }
        }

        /* renamed from: l */
        public void m9594l(ExecutorService executorService) {
            try {
                try {
                    executorService.execute(this);
                } catch (RejectedExecutionException e) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                    interruptedIOException.initCause(e);
                    this.f7774Q.f7768R.m10701b(this.f7774Q, interruptedIOException);
                    this.f7773P.m10695b(this.f7774Q, interruptedIOException);
                    this.f7774Q.f7765O.m8947k().m7058d(this);
                }
            } catch (Throwable th) {
                this.f7774Q.f7765O.m8947k().m7058d(this);
                throw th;
            }
        }

        /* renamed from: m */
        public wm0 m9595m() {
            return this.f7774Q;
        }

        /* renamed from: n */
        public String m9596n() {
            return this.f7774Q.f7769S.m9821h().m8171l();
        }
    }

    public wm0(um0 um0Var, xm0 xm0Var, boolean z) {
        this.f7765O = um0Var;
        this.f7769S = xm0Var;
        this.f7770T = z;
        this.f7766P = new yn0(um0Var, z);
        C2234a c2234a = new C2234a();
        this.f7767Q = c2234a;
        c2234a.mo3310g(um0Var.m8941c(), TimeUnit.MILLISECONDS);
    }

    /* renamed from: j */
    public static wm0 m9584j(um0 um0Var, xm0 xm0Var, boolean z) {
        wm0 wm0Var = new wm0(um0Var, xm0Var, z);
        wm0Var.f7768R = um0Var.m8949m().mo10720a(wm0Var);
        return wm0Var;
    }

    /* renamed from: c */
    public void m9585c() {
        this.f7766P.m10195b();
    }

    /* renamed from: d */
    public final void m9586d() {
        this.f7766P.m10203j(ro0.m8221j().mo6498m("response.body().close()"));
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public wm0 clone() {
        return m9584j(this.f7765O, this.f7769S, this.f7770T);
    }

    /* renamed from: g */
    public zm0 m9588g() throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f7765O.m8953s());
        arrayList.add(this.f7766P);
        arrayList.add(new qn0(this.f7765O.m8946j()));
        arrayList.add(new hn0(this.f7765O.m8954t()));
        arrayList.add(new jn0(this.f7765O));
        if (!this.f7770T) {
            arrayList.addAll(this.f7765O.m8955u());
        }
        arrayList.add(new rn0(this.f7770T));
        return new vn0(arrayList, null, null, null, 0, this.f7769S, this, this.f7768R, this.f7765O.m8943e(), this.f7765O.m8935E(), this.f7765O.m8939I()).mo9318c(this.f7769S);
    }

    @Override // okhttp3.Call
    /* renamed from: h */
    public zm0 mo9589h() throws IOException {
        synchronized (this) {
            if (this.f7771U) {
                throw new IllegalStateException("Already Executed");
            }
            this.f7771U = true;
        }
        m9586d();
        this.f7767Q.m9855k();
        this.f7768R.m10702c(this);
        try {
            try {
                this.f7765O.m8947k().m7055a(this);
                zm0 m9588g = m9588g();
                if (m9588g != null) {
                    return m9588g;
                }
                throw new IOException("Canceled");
            } catch (IOException e) {
                IOException m9592l = m9592l(e);
                this.f7768R.m10701b(this, m9592l);
                throw m9592l;
            }
        } finally {
            this.f7765O.m8947k().m7059e(this);
        }
    }

    /* renamed from: i */
    public boolean m9590i() {
        return this.f7766P.m10198e();
    }

    /* renamed from: k */
    public String m9591k() {
        return this.f7769S.m9821h().m8161A();
    }

    @Nullable
    /* renamed from: l */
    public IOException m9592l(@Nullable IOException iOException) {
        if (!this.f7767Q.m9858n()) {
            return iOException;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    /* renamed from: m */
    public String m9593m() {
        StringBuilder sb = new StringBuilder();
        sb.append(m9590i() ? "canceled " : "");
        sb.append(this.f7770T ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(m9591k());
        return sb.toString();
    }
}
