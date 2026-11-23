package com.sonelli;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okhttp3.internal.http2.Header;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

/* compiled from: Http2Stream.java */
/* loaded from: classes.dex */
public final class ho0 {

    /* renamed from: a */
    public long f3187a = 0;

    /* renamed from: b */
    public long f3188b;

    /* renamed from: c */
    public final int f3189c;

    /* renamed from: d */
    public final go0 f3190d;

    /* renamed from: e */
    public final Deque<qm0> f3191e;

    /* renamed from: f */
    public Header.Listener f3192f;

    /* renamed from: g */
    public boolean f3193g;

    /* renamed from: h */
    public final C1120b f3194h;

    /* renamed from: i */
    public final C1119a f3195i;

    /* renamed from: j */
    public final C1121c f3196j;

    /* renamed from: k */
    public final C1121c f3197k;

    /* renamed from: l */
    public co0 f3198l;

    /* compiled from: Http2Stream.java */
    /* renamed from: com.sonelli.ho0$a */
    /* loaded from: classes.dex */
    public final class C1119a implements Sink {

        /* renamed from: O */
        public final zo0 f3199O = new zo0();

        /* renamed from: P */
        public boolean f3200P;

        /* renamed from: Q */
        public boolean f3201Q;

        public C1119a() {
        }

        @Override // okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            this.f3199O.mo2189F(zo0Var, j);
            while (this.f3199O.m10557f0() >= PlaybackStateCompat.ACTION_PREPARE) {
                m4604a(false);
            }
        }

        /* renamed from: a */
        public final void m4604a(boolean z) throws IOException {
            ho0 ho0Var;
            long min;
            ho0 ho0Var2;
            synchronized (ho0.this) {
                ho0.this.f3197k.m9855k();
                while (true) {
                    try {
                        ho0Var = ho0.this;
                        if (ho0Var.f3188b > 0 || this.f3201Q || this.f3200P || ho0Var.f3198l != null) {
                            break;
                        } else {
                            ho0Var.m4602t();
                        }
                    } finally {
                    }
                }
                ho0Var.f3197k.m4607u();
                ho0.this.m4587e();
                min = Math.min(ho0.this.f3188b, this.f3199O.m10557f0());
                ho0Var2 = ho0.this;
                ho0Var2.f3188b -= min;
            }
            ho0Var2.f3197k.m9855k();
            try {
                ho0 ho0Var3 = ho0.this;
                ho0Var3.f3190d.m4196g0(ho0Var3.f3189c, z && min == this.f3199O.m10557f0(), this.f3199O, min);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (ho0.this) {
                if (this.f3200P) {
                    return;
                }
                if (!ho0.this.f3195i.f3201Q) {
                    if (this.f3199O.m10557f0() > 0) {
                        while (this.f3199O.m10557f0() > 0) {
                            m4604a(true);
                        }
                    } else {
                        ho0 ho0Var = ho0.this;
                        ho0Var.f3190d.m4196g0(ho0Var.f3189c, true, null, 0L);
                    }
                }
                synchronized (ho0.this) {
                    this.f3200P = true;
                }
                ho0.this.f3190d.flush();
                ho0.this.m4586d();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (ho0.this) {
                ho0.this.m4587e();
            }
            while (this.f3199O.m10557f0() > 0) {
                m4604a(false);
                ho0.this.f3190d.flush();
            }
        }

        @Override // okio.Sink
        /* renamed from: g */
        public mp0 mo2190g() {
            return ho0.this.f3197k;
        }
    }

    /* compiled from: Http2Stream.java */
    /* renamed from: com.sonelli.ho0$b */
    /* loaded from: classes.dex */
    public final class C1120b implements Source {

        /* renamed from: O */
        public final zo0 f3203O = new zo0();

        /* renamed from: P */
        public final zo0 f3204P = new zo0();

        /* renamed from: Q */
        public final long f3205Q;

        /* renamed from: R */
        public boolean f3206R;

        /* renamed from: S */
        public boolean f3207S;

        public C1120b(long j) {
            this.f3205Q = j;
        }

        /* JADX WARN: Code restructure failed: missing block: B:61:0x00d3, code lost:
        
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /* renamed from: R */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long mo2186R(com.sonelli.zo0 r17, long r18) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 247
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sonelli.ho0.C1120b.mo2186R(com.sonelli.zo0, long):long");
        }

        /* renamed from: a */
        public void m4605a(BufferedSource bufferedSource, long j) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j > 0) {
                synchronized (ho0.this) {
                    z = this.f3207S;
                    z2 = true;
                    z3 = this.f3204P.m10557f0() + j > this.f3205Q;
                }
                if (z3) {
                    bufferedSource.skip(j);
                    ho0.this.m4590h(co0.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j);
                    return;
                }
                long mo2186R = bufferedSource.mo2186R(this.f3203O, j);
                if (mo2186R == -1) {
                    throw new EOFException();
                }
                j -= mo2186R;
                synchronized (ho0.this) {
                    if (this.f3204P.m10557f0() != 0) {
                        z2 = false;
                    }
                    this.f3204P.mo4613G(this.f3203O);
                    if (z2) {
                        ho0.this.notifyAll();
                    }
                }
            }
        }

        /* renamed from: b */
        public final void m4606b(long j) {
            ho0.this.f3190d.m4195f0(j);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long m10557f0;
            Header.Listener listener;
            ArrayList arrayList;
            synchronized (ho0.this) {
                this.f3206R = true;
                m10557f0 = this.f3204P.m10557f0();
                this.f3204P.m10550b();
                listener = null;
                if (ho0.this.f3191e.isEmpty() || ho0.this.f3192f == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(ho0.this.f3191e);
                    ho0.this.f3191e.clear();
                    listener = ho0.this.f3192f;
                    arrayList = arrayList2;
                }
                ho0.this.notifyAll();
            }
            if (m10557f0 > 0) {
                m4606b(m10557f0);
            }
            ho0.this.m4586d();
            if (listener != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    listener.m10729a((qm0) it.next());
                }
            }
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return ho0.this.f3196j;
        }
    }

    /* compiled from: Http2Stream.java */
    /* renamed from: com.sonelli.ho0$c */
    /* loaded from: classes.dex */
    public class C1121c extends xo0 {
        public C1121c() {
        }

        @Override // com.sonelli.xo0
        /* renamed from: o */
        public IOException mo4237o(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // com.sonelli.xo0
        /* renamed from: t */
        public void mo4238t() {
            ho0.this.m4590h(co0.CANCEL);
        }

        /* renamed from: u */
        public void m4607u() throws IOException {
            if (m9858n()) {
                throw mo4237o(null);
            }
        }
    }

    public ho0(int i, go0 go0Var, boolean z, boolean z2, @Nullable qm0 qm0Var) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.f3191e = arrayDeque;
        this.f3196j = new C1121c();
        this.f3197k = new C1121c();
        this.f3198l = null;
        Objects.requireNonNull(go0Var, "connection == null");
        this.f3189c = i;
        this.f3190d = go0Var;
        this.f3188b = go0Var.f2916c0.m5964d();
        C1120b c1120b = new C1120b(go0Var.f2915b0.m5964d());
        this.f3194h = c1120b;
        C1119a c1119a = new C1119a();
        this.f3195i = c1119a;
        c1120b.f3207S = z2;
        c1119a.f3201Q = z;
        if (qm0Var != null) {
            arrayDeque.add(qm0Var);
        }
        if (m4594l() && qm0Var != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!m4594l() && qm0Var == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* renamed from: c */
    public void m4585c(long j) {
        this.f3188b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* renamed from: d */
    public void m4586d() throws IOException {
        boolean z;
        boolean m4595m;
        synchronized (this) {
            C1120b c1120b = this.f3194h;
            if (!c1120b.f3207S && c1120b.f3206R) {
                C1119a c1119a = this.f3195i;
                if (c1119a.f3201Q || c1119a.f3200P) {
                    z = true;
                    m4595m = m4595m();
                }
            }
            z = false;
            m4595m = m4595m();
        }
        if (z) {
            m4588f(co0.CANCEL);
        } else {
            if (m4595m) {
                return;
            }
            this.f3190d.m4190b0(this.f3189c);
        }
    }

    /* renamed from: e */
    public void m4587e() throws IOException {
        C1119a c1119a = this.f3195i;
        if (c1119a.f3200P) {
            throw new IOException("stream closed");
        }
        if (c1119a.f3201Q) {
            throw new IOException("stream finished");
        }
        if (this.f3198l != null) {
            throw new lo0(this.f3198l);
        }
    }

    /* renamed from: f */
    public void m4588f(co0 co0Var) throws IOException {
        if (m4589g(co0Var)) {
            this.f3190d.m4199i0(this.f3189c, co0Var);
        }
    }

    /* renamed from: g */
    public final boolean m4589g(co0 co0Var) {
        synchronized (this) {
            if (this.f3198l != null) {
                return false;
            }
            if (this.f3194h.f3207S && this.f3195i.f3201Q) {
                return false;
            }
            this.f3198l = co0Var;
            notifyAll();
            this.f3190d.m4190b0(this.f3189c);
            return true;
        }
    }

    /* renamed from: h */
    public void m4590h(co0 co0Var) {
        if (m4589g(co0Var)) {
            this.f3190d.m4200j0(this.f3189c, co0Var);
        }
    }

    /* renamed from: i */
    public int m4591i() {
        return this.f3189c;
    }

    /* renamed from: j */
    public Sink m4592j() {
        synchronized (this) {
            if (!this.f3193g && !m4594l()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f3195i;
    }

    /* renamed from: k */
    public Source m4593k() {
        return this.f3194h;
    }

    /* renamed from: l */
    public boolean m4594l() {
        return this.f3190d.f2902O == ((this.f3189c & 1) == 1);
    }

    /* renamed from: m */
    public synchronized boolean m4595m() {
        if (this.f3198l != null) {
            return false;
        }
        C1120b c1120b = this.f3194h;
        if (c1120b.f3207S || c1120b.f3206R) {
            C1119a c1119a = this.f3195i;
            if (c1119a.f3201Q || c1119a.f3200P) {
                if (this.f3193g) {
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: n */
    public mp0 m4596n() {
        return this.f3196j;
    }

    /* renamed from: o */
    public void m4597o(BufferedSource bufferedSource, int i) throws IOException {
        this.f3194h.m4605a(bufferedSource, i);
    }

    /* renamed from: p */
    public void m4598p() {
        boolean m4595m;
        synchronized (this) {
            this.f3194h.f3207S = true;
            m4595m = m4595m();
            notifyAll();
        }
        if (m4595m) {
            return;
        }
        this.f3190d.m4190b0(this.f3189c);
    }

    /* renamed from: q */
    public void m4599q(List<Header> list) {
        boolean m4595m;
        synchronized (this) {
            this.f3193g = true;
            this.f3191e.add(fn0.m3817H(list));
            m4595m = m4595m();
            notifyAll();
        }
        if (m4595m) {
            return;
        }
        this.f3190d.m4190b0(this.f3189c);
    }

    /* renamed from: r */
    public synchronized void m4600r(co0 co0Var) {
        if (this.f3198l == null) {
            this.f3198l = co0Var;
            notifyAll();
        }
    }

    /* renamed from: s */
    public synchronized qm0 m4601s() throws IOException {
        this.f3196j.m9855k();
        while (this.f3191e.isEmpty() && this.f3198l == null) {
            try {
                m4602t();
            } catch (Throwable th) {
                this.f3196j.m4607u();
                throw th;
            }
        }
        this.f3196j.m4607u();
        if (this.f3191e.isEmpty()) {
            throw new lo0(this.f3198l);
        }
        return this.f3191e.removeFirst();
    }

    /* renamed from: t */
    public void m4602t() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    /* renamed from: u */
    public mp0 m4603u() {
        return this.f3197k;
    }
}
