package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import androidx.core.internal.view.SupportMenu;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.http2.Header;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.http2.PushObserver;
import okio.BufferedSink;
import okio.BufferedSource;

/* compiled from: Http2Connection.java */
/* loaded from: classes.dex */
public final class go0 implements Closeable {

    /* renamed from: i0 */
    public static final ExecutorService f2901i0 = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60, TimeUnit.SECONDS, new SynchronousQueue(), fn0.m3816G("OkHttp Http2Connection", true));

    /* renamed from: O */
    public final boolean f2902O;

    /* renamed from: P */
    public final AbstractC1060h f2903P;

    /* renamed from: R */
    public final String f2905R;

    /* renamed from: S */
    public int f2906S;

    /* renamed from: T */
    public int f2907T;

    /* renamed from: U */
    public boolean f2908U;

    /* renamed from: V */
    public final ScheduledExecutorService f2909V;

    /* renamed from: W */
    public final ExecutorService f2910W;

    /* renamed from: X */
    public final PushObserver f2911X;

    /* renamed from: Y */
    public boolean f2912Y;

    /* renamed from: a0 */
    public long f2914a0;

    /* renamed from: c0 */
    public final ko0 f2916c0;

    /* renamed from: d0 */
    public boolean f2917d0;

    /* renamed from: e0 */
    public final Socket f2918e0;

    /* renamed from: f0 */
    public final io0 f2919f0;

    /* renamed from: g0 */
    public final C1062j f2920g0;

    /* renamed from: h0 */
    public final Set<Integer> f2921h0;

    /* renamed from: Q */
    public final Map<Integer, ho0> f2904Q = new LinkedHashMap();

    /* renamed from: Z */
    public long f2913Z = 0;

    /* renamed from: b0 */
    public ko0 f2915b0 = new ko0();

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$a */
    /* loaded from: classes.dex */
    public class C1053a extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2922P;

        /* renamed from: Q */
        public final /* synthetic */ co0 f2923Q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1053a(String str, Object[] objArr, int i, co0 co0Var) {
            super(str, objArr);
            this.f2922P = i;
            this.f2923Q = co0Var;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            try {
                go0.this.m4199i0(this.f2922P, this.f2923Q);
            } catch (IOException unused) {
                go0.this.m4197h();
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$b */
    /* loaded from: classes.dex */
    public class C1054b extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2925P;

        /* renamed from: Q */
        public final /* synthetic */ long f2926Q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1054b(String str, Object[] objArr, int i, long j) {
            super(str, objArr);
            this.f2925P = i;
            this.f2926Q = j;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            try {
                go0.this.f2919f0.m4823K(this.f2925P, this.f2926Q);
            } catch (IOException unused) {
                go0.this.m4197h();
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$c */
    /* loaded from: classes.dex */
    public class C1055c extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2928P;

        /* renamed from: Q */
        public final /* synthetic */ List f2929Q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1055c(String str, Object[] objArr, int i, List list) {
            super(str, objArr);
            this.f2928P = i;
            this.f2929Q = list;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            if (go0.this.f2911X.mo10746a(this.f2928P, this.f2929Q)) {
                try {
                    go0.this.f2919f0.m4835y(this.f2928P, co0.CANCEL);
                    synchronized (go0.this) {
                        go0.this.f2921h0.remove(Integer.valueOf(this.f2928P));
                    }
                } catch (IOException unused) {
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$d */
    /* loaded from: classes.dex */
    public class C1056d extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2931P;

        /* renamed from: Q */
        public final /* synthetic */ List f2932Q;

        /* renamed from: R */
        public final /* synthetic */ boolean f2933R;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1056d(String str, Object[] objArr, int i, List list, boolean z) {
            super(str, objArr);
            this.f2931P = i;
            this.f2932Q = list;
            this.f2933R = z;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            boolean mo10747b = go0.this.f2911X.mo10747b(this.f2931P, this.f2932Q, this.f2933R);
            if (mo10747b) {
                try {
                    go0.this.f2919f0.m4835y(this.f2931P, co0.CANCEL);
                } catch (IOException unused) {
                    return;
                }
            }
            if (mo10747b || this.f2933R) {
                synchronized (go0.this) {
                    go0.this.f2921h0.remove(Integer.valueOf(this.f2931P));
                }
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$e */
    /* loaded from: classes.dex */
    public class C1057e extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2935P;

        /* renamed from: Q */
        public final /* synthetic */ zo0 f2936Q;

        /* renamed from: R */
        public final /* synthetic */ int f2937R;

        /* renamed from: S */
        public final /* synthetic */ boolean f2938S;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1057e(String str, Object[] objArr, int i, zo0 zo0Var, int i2, boolean z) {
            super(str, objArr);
            this.f2935P = i;
            this.f2936Q = zo0Var;
            this.f2937R = i2;
            this.f2938S = z;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            try {
                boolean mo10749d = go0.this.f2911X.mo10749d(this.f2935P, this.f2936Q, this.f2937R, this.f2938S);
                if (mo10749d) {
                    go0.this.f2919f0.m4835y(this.f2935P, co0.CANCEL);
                }
                if (mo10749d || this.f2938S) {
                    synchronized (go0.this) {
                        go0.this.f2921h0.remove(Integer.valueOf(this.f2935P));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$f */
    /* loaded from: classes.dex */
    public class C1058f extends en0 {

        /* renamed from: P */
        public final /* synthetic */ int f2940P;

        /* renamed from: Q */
        public final /* synthetic */ co0 f2941Q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1058f(String str, Object[] objArr, int i, co0 co0Var) {
            super(str, objArr);
            this.f2940P = i;
            this.f2941Q = co0Var;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            go0.this.f2911X.mo10748c(this.f2940P, this.f2941Q);
            synchronized (go0.this) {
                go0.this.f2921h0.remove(Integer.valueOf(this.f2940P));
            }
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$g */
    /* loaded from: classes.dex */
    public static class C1059g {

        /* renamed from: a */
        public Socket f2943a;

        /* renamed from: b */
        public String f2944b;

        /* renamed from: c */
        public BufferedSource f2945c;

        /* renamed from: d */
        public BufferedSink f2946d;

        /* renamed from: e */
        public AbstractC1060h f2947e = AbstractC1060h.f2951a;

        /* renamed from: f */
        public PushObserver f2948f = PushObserver.f8676a;

        /* renamed from: g */
        public boolean f2949g;

        /* renamed from: h */
        public int f2950h;

        public C1059g(boolean z) {
            this.f2949g = z;
        }

        /* renamed from: a */
        public go0 m4208a() {
            return new go0(this);
        }

        /* renamed from: b */
        public C1059g m4209b(AbstractC1060h abstractC1060h) {
            this.f2947e = abstractC1060h;
            return this;
        }

        /* renamed from: c */
        public C1059g m4210c(int i) {
            this.f2950h = i;
            return this;
        }

        /* renamed from: d */
        public C1059g m4211d(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f2943a = socket;
            this.f2944b = str;
            this.f2945c = bufferedSource;
            this.f2946d = bufferedSink;
            return this;
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$h */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1060h {

        /* renamed from: a */
        public static final AbstractC1060h f2951a = new a();

        /* compiled from: Http2Connection.java */
        /* renamed from: cz.opentree.go0$h$a */
        /* loaded from: classes.dex */
        public class a extends AbstractC1060h {
            @Override // cz.opentree.go0.AbstractC1060h
            /* renamed from: b */
            public void mo4213b(ho0 ho0Var) throws IOException {
                ho0Var.m4588f(co0.REFUSED_STREAM);
            }
        }

        /* renamed from: a */
        public void mo4212a(go0 go0Var) {
        }

        /* renamed from: b */
        public abstract void mo4213b(ho0 ho0Var) throws IOException;
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$i */
    /* loaded from: classes.dex */
    public final class C1061i extends en0 {

        /* renamed from: P */
        public final boolean f2952P;

        /* renamed from: Q */
        public final int f2953Q;

        /* renamed from: R */
        public final int f2954R;

        public C1061i(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", go0.this.f2905R, Integer.valueOf(i), Integer.valueOf(i2));
            this.f2952P = z;
            this.f2953Q = i;
            this.f2954R = i2;
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            go0.this.m4198h0(this.f2952P, this.f2953Q, this.f2954R);
        }
    }

    /* compiled from: Http2Connection.java */
    /* renamed from: cz.opentree.go0$j */
    /* loaded from: classes.dex */
    public class C1062j extends en0 implements Http2Reader.Handler {

        /* renamed from: P */
        public final Http2Reader f2956P;

        /* compiled from: Http2Connection.java */
        /* renamed from: cz.opentree.go0$j$a */
        /* loaded from: classes.dex */
        public class a extends en0 {

            /* renamed from: P */
            public final /* synthetic */ ho0 f2958P;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, Object[] objArr, ho0 ho0Var) {
                super(str, objArr);
                this.f2958P = ho0Var;
            }

            @Override // cz.opentree.en0
            /* renamed from: k */
            public void mo3533k() {
                try {
                    go0.this.f2903P.mo4213b(this.f2958P);
                } catch (IOException e) {
                    ro0.m8221j().mo6500p(4, "Http2Connection.Listener failure for " + go0.this.f2905R, e);
                    try {
                        this.f2958P.m4588f(co0.PROTOCOL_ERROR);
                    } catch (IOException unused) {
                    }
                }
            }
        }

        /* compiled from: Http2Connection.java */
        /* renamed from: cz.opentree.go0$j$b */
        /* loaded from: classes.dex */
        public class b extends en0 {
            public b(String str, Object... objArr) {
                super(str, objArr);
            }

            @Override // cz.opentree.en0
            /* renamed from: k */
            public void mo3533k() {
                go0 go0Var = go0.this;
                go0Var.f2903P.mo4212a(go0Var);
            }
        }

        /* compiled from: Http2Connection.java */
        /* renamed from: cz.opentree.go0$j$c */
        /* loaded from: classes.dex */
        public class c extends en0 {

            /* renamed from: P */
            public final /* synthetic */ ko0 f2961P;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, Object[] objArr, ko0 ko0Var) {
                super(str, objArr);
                this.f2961P = ko0Var;
            }

            @Override // cz.opentree.en0
            /* renamed from: k */
            public void mo3533k() {
                try {
                    go0.this.f2919f0.m4825a(this.f2961P);
                } catch (IOException unused) {
                    go0.this.m4197h();
                }
            }
        }

        public C1062j(Http2Reader http2Reader) {
            super("OkHttp %s", go0.this.f2905R);
            this.f2956P = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: a */
        public void mo4214a() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: b */
        public void mo4215b(boolean z, ko0 ko0Var) {
            ho0[] ho0VarArr;
            long j;
            int i;
            synchronized (go0.this) {
                int m5964d = go0.this.f2916c0.m5964d();
                if (z) {
                    go0.this.f2916c0.m5961a();
                }
                go0.this.f2916c0.m5968h(ko0Var);
                m4224l(ko0Var);
                int m5964d2 = go0.this.f2916c0.m5964d();
                ho0VarArr = null;
                if (m5964d2 == -1 || m5964d2 == m5964d) {
                    j = 0;
                } else {
                    j = m5964d2 - m5964d;
                    go0 go0Var = go0.this;
                    if (!go0Var.f2917d0) {
                        go0Var.f2917d0 = true;
                    }
                    if (!go0Var.f2904Q.isEmpty()) {
                        ho0VarArr = (ho0[]) go0.this.f2904Q.values().toArray(new ho0[go0.this.f2904Q.size()]);
                    }
                }
                go0.f2901i0.execute(new b("OkHttp %s settings", go0.this.f2905R));
            }
            if (ho0VarArr == null || j == 0) {
                return;
            }
            for (ho0 ho0Var : ho0VarArr) {
                synchronized (ho0Var) {
                    ho0Var.m4585c(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: c */
        public void mo4216c(boolean z, int i, int i2, List<Header> list) {
            if (go0.this.m4189a0(i)) {
                go0.this.m4186K(i, list, z);
                return;
            }
            synchronized (go0.this) {
                ho0 m4202l = go0.this.m4202l(i);
                if (m4202l != null) {
                    m4202l.m4599q(list);
                    if (z) {
                        m4202l.m4598p();
                        return;
                    }
                    return;
                }
                go0 go0Var = go0.this;
                if (go0Var.f2908U) {
                    return;
                }
                if (i <= go0Var.f2906S) {
                    return;
                }
                if (i % 2 == go0Var.f2907T % 2) {
                    return;
                }
                ho0 ho0Var = new ho0(i, go0.this, false, z, fn0.m3817H(list));
                go0 go0Var2 = go0.this;
                go0Var2.f2906S = i;
                go0Var2.f2904Q.put(Integer.valueOf(i), ho0Var);
                go0.f2901i0.execute(new a("OkHttp %s stream %d", new Object[]{go0.this.f2905R, Integer.valueOf(i)}, ho0Var));
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: d */
        public void mo4217d(int i, long j) {
            if (i == 0) {
                synchronized (go0.this) {
                    go0 go0Var = go0.this;
                    go0Var.f2914a0 += j;
                    go0Var.notifyAll();
                }
                return;
            }
            ho0 m4202l = go0.this.m4202l(i);
            if (m4202l != null) {
                synchronized (m4202l) {
                    m4202l.m4585c(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: e */
        public void mo4218e(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (go0.this.m4189a0(i)) {
                go0.this.m4207z(i, bufferedSource, i2, z);
                return;
            }
            ho0 m4202l = go0.this.m4202l(i);
            if (m4202l == null) {
                go0.this.m4200j0(i, co0.PROTOCOL_ERROR);
                long j = i2;
                go0.this.m4195f0(j);
                bufferedSource.skip(j);
                return;
            }
            m4202l.m4597o(bufferedSource, i2);
            if (z) {
                m4202l.m4598p();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: f */
        public void mo4219f(boolean z, int i, int i2) {
            if (!z) {
                try {
                    go0.this.f2909V.execute(new C1061i(true, i, i2));
                } catch (RejectedExecutionException unused) {
                }
            } else {
                synchronized (go0.this) {
                    go0.this.f2912Y = false;
                    go0.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: g */
        public void mo4220g(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: h */
        public void mo4221h(int i, co0 co0Var) {
            if (go0.this.m4189a0(i)) {
                go0.this.m4188Z(i, co0Var);
                return;
            }
            ho0 m4190b0 = go0.this.m4190b0(i);
            if (m4190b0 != null) {
                m4190b0.m4600r(co0Var);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: i */
        public void mo4222i(int i, int i2, List<Header> list) {
            go0.this.m4187Y(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        /* renamed from: j */
        public void mo4223j(int i, co0 co0Var, ap0 ap0Var) {
            ho0[] ho0VarArr;
            ap0Var.mo2247w();
            synchronized (go0.this) {
                ho0VarArr = (ho0[]) go0.this.f2904Q.values().toArray(new ho0[go0.this.f2904Q.size()]);
                go0.this.f2908U = true;
            }
            for (ho0 ho0Var : ho0VarArr) {
                if (ho0Var.m4591i() > i && ho0Var.m4594l()) {
                    ho0Var.m4600r(co0.REFUSED_STREAM);
                    go0.this.m4190b0(ho0Var.m4591i());
                }
            }
        }

        @Override // cz.opentree.en0
        /* renamed from: k */
        public void mo3533k() {
            co0 co0Var;
            co0 co0Var2 = co0.INTERNAL_ERROR;
            try {
                try {
                    this.f2956P.m10736c(this);
                    do {
                    } while (this.f2956P.m10735b(false, this));
                    co0Var = co0.NO_ERROR;
                    try {
                        try {
                            go0.this.m4194f(co0Var, co0.CANCEL);
                        } catch (IOException unused) {
                            co0 co0Var3 = co0.PROTOCOL_ERROR;
                            go0.this.m4194f(co0Var3, co0Var3);
                            fn0.m3826g(this.f2956P);
                        }
                    } catch (Throwable th) {
                        th = th;
                        try {
                            go0.this.m4194f(co0Var, co0Var2);
                        } catch (IOException unused2) {
                        }
                        fn0.m3826g(this.f2956P);
                        throw th;
                    }
                } catch (IOException unused3) {
                }
            } catch (IOException unused4) {
                co0Var = co0Var2;
            } catch (Throwable th2) {
                th = th2;
                co0Var = co0Var2;
                go0.this.m4194f(co0Var, co0Var2);
                fn0.m3826g(this.f2956P);
                throw th;
            }
            fn0.m3826g(this.f2956P);
        }

        /* renamed from: l */
        public final void m4224l(ko0 ko0Var) {
            try {
                go0.this.f2909V.execute(new c("OkHttp %s ACK Settings", new Object[]{go0.this.f2905R}, ko0Var));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    public go0(C1059g c1059g) {
        ko0 ko0Var = new ko0();
        this.f2916c0 = ko0Var;
        this.f2917d0 = false;
        this.f2921h0 = new LinkedHashSet();
        this.f2911X = c1059g.f2948f;
        boolean z = c1059g.f2949g;
        this.f2902O = z;
        this.f2903P = c1059g.f2947e;
        int i = z ? 1 : 2;
        this.f2907T = i;
        if (z) {
            this.f2907T = i + 2;
        }
        if (z) {
            this.f2915b0.m5969i(7, 16777216);
        }
        String str = c1059g.f2944b;
        this.f2905R = str;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, fn0.m3816G(fn0.m3837r("OkHttp %s Writer", str), false));
        this.f2909V = scheduledThreadPoolExecutor;
        if (c1059g.f2950h != 0) {
            C1061i c1061i = new C1061i(false, 0, 0);
            int i2 = c1059g.f2950h;
            scheduledThreadPoolExecutor.scheduleAtFixedRate(c1061i, i2, i2, TimeUnit.MILLISECONDS);
        }
        this.f2910W = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), fn0.m3816G(fn0.m3837r("OkHttp %s Push Observer", str), true));
        ko0Var.m5969i(7, SupportMenu.USER_MASK);
        ko0Var.m5969i(5, 16384);
        this.f2914a0 = ko0Var.m5964d();
        this.f2918e0 = c1059g.f2943a;
        this.f2919f0 = new io0(c1059g.f2946d, z);
        this.f2920g0 = new C1062j(new Http2Reader(c1059g.f2945c, z));
    }

    /* renamed from: D */
    public final synchronized void m4185D(en0 en0Var) {
        if (!m4203n()) {
            this.f2910W.execute(en0Var);
        }
    }

    /* renamed from: K */
    public void m4186K(int i, List<Header> list, boolean z) {
        try {
            m4185D(new C1056d("OkHttp %s Push Headers[%s]", new Object[]{this.f2905R, Integer.valueOf(i)}, i, list, z));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: Y */
    public void m4187Y(int i, List<Header> list) {
        synchronized (this) {
            if (this.f2921h0.contains(Integer.valueOf(i))) {
                m4200j0(i, co0.PROTOCOL_ERROR);
                return;
            }
            this.f2921h0.add(Integer.valueOf(i));
            try {
                m4185D(new C1055c("OkHttp %s Push Request[%s]", new Object[]{this.f2905R, Integer.valueOf(i)}, i, list));
            } catch (RejectedExecutionException unused) {
            }
        }
    }

    /* renamed from: Z */
    public void m4188Z(int i, co0 co0Var) {
        m4185D(new C1058f("OkHttp %s Push Reset[%s]", new Object[]{this.f2905R, Integer.valueOf(i)}, i, co0Var));
    }

    /* renamed from: a0 */
    public boolean m4189a0(int i) {
        return i != 0 && (i & 1) == 0;
    }

    /* renamed from: b0 */
    public synchronized ho0 m4190b0(int i) {
        ho0 remove;
        remove = this.f2904Q.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    /* renamed from: c0 */
    public void m4191c0(co0 co0Var) throws IOException {
        synchronized (this.f2919f0) {
            synchronized (this) {
                if (this.f2908U) {
                    return;
                }
                this.f2908U = true;
                this.f2919f0.m4830h(this.f2906S, co0Var, fn0.f2722a);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        m4194f(co0.NO_ERROR, co0.CANCEL);
    }

    /* renamed from: d0 */
    public void m4192d0() throws IOException {
        m4193e0(true);
    }

    /* renamed from: e0 */
    public void m4193e0(boolean z) throws IOException {
        if (z) {
            this.f2919f0.m4826b();
            this.f2919f0.m4836z(this.f2915b0);
            if (this.f2915b0.m5964d() != 65535) {
                this.f2919f0.m4823K(0, r6 - SupportMenu.USER_MASK);
            }
        }
        new Thread(this.f2920g0).start();
    }

    /* renamed from: f */
    public void m4194f(co0 co0Var, co0 co0Var2) throws IOException {
        ho0[] ho0VarArr = null;
        try {
            m4191c0(co0Var);
            e = null;
        } catch (IOException e) {
            e = e;
        }
        synchronized (this) {
            if (!this.f2904Q.isEmpty()) {
                ho0VarArr = (ho0[]) this.f2904Q.values().toArray(new ho0[this.f2904Q.size()]);
                this.f2904Q.clear();
            }
        }
        if (ho0VarArr != null) {
            for (ho0 ho0Var : ho0VarArr) {
                try {
                    ho0Var.m4588f(co0Var2);
                } catch (IOException e2) {
                    if (e != null) {
                        e = e2;
                    }
                }
            }
        }
        try {
            this.f2919f0.close();
        } catch (IOException e3) {
            if (e == null) {
                e = e3;
            }
        }
        try {
            this.f2918e0.close();
        } catch (IOException e4) {
            e = e4;
        }
        this.f2909V.shutdown();
        this.f2910W.shutdown();
        if (e != null) {
            throw e;
        }
    }

    /* renamed from: f0 */
    public synchronized void m4195f0(long j) {
        long j2 = this.f2913Z + j;
        this.f2913Z = j2;
        if (j2 >= this.f2915b0.m5964d() / 2) {
            m4201k0(0, this.f2913Z);
            this.f2913Z = 0L;
        }
    }

    public void flush() throws IOException {
        this.f2919f0.flush();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
    
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r4), r8.f2919f0.m4832n());
        r6 = r2;
        r8.f2914a0 -= r6;
     */
    /* renamed from: g0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m4196g0(int r9, boolean r10, cz.opentree.zo0 r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            r3 = 0
            if (r2 != 0) goto Ld
            cz.opentree.io0 r12 = r8.f2919f0
            r12.m4827c(r10, r9, r11, r3)
            return
        Ld:
            int r2 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r2 <= 0) goto L67
            monitor-enter(r8)
        L12:
            long r4 = r8.f2914a0     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 > 0) goto L30
            java.util.Map<java.lang.Integer, cz.opentree.ho0> r2 = r8.f2904Q     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            boolean r2 = r2.containsKey(r4)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            if (r2 == 0) goto L28
            r8.wait()     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            goto L12
        L28:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
            throw r9     // Catch: java.lang.Throwable -> L56 java.lang.InterruptedException -> L58
        L30:
            long r4 = java.lang.Math.min(r12, r4)     // Catch: java.lang.Throwable -> L56
            int r2 = (int) r4     // Catch: java.lang.Throwable -> L56
            cz.opentree.io0 r4 = r8.f2919f0     // Catch: java.lang.Throwable -> L56
            int r4 = r4.m4832n()     // Catch: java.lang.Throwable -> L56
            int r2 = java.lang.Math.min(r2, r4)     // Catch: java.lang.Throwable -> L56
            long r4 = r8.f2914a0     // Catch: java.lang.Throwable -> L56
            long r6 = (long) r2     // Catch: java.lang.Throwable -> L56
            long r4 = r4 - r6
            r8.f2914a0 = r4     // Catch: java.lang.Throwable -> L56
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            long r12 = r12 - r6
            cz.opentree.io0 r4 = r8.f2919f0
            if (r10 == 0) goto L51
            int r5 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = r3
        L52:
            r4.m4827c(r5, r9, r11, r2)
            goto Ld
        L56:
            r9 = move-exception
            goto L65
        L58:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L56
            r9.interrupt()     // Catch: java.lang.Throwable -> L56
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L56
            r9.<init>()     // Catch: java.lang.Throwable -> L56
            throw r9     // Catch: java.lang.Throwable -> L56
        L65:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L56
            throw r9
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.go0.m4196g0(int, boolean, cz.opentree.zo0, long):void");
    }

    /* renamed from: h */
    public final void m4197h() {
        try {
            co0 co0Var = co0.PROTOCOL_ERROR;
            m4194f(co0Var, co0Var);
        } catch (IOException unused) {
        }
    }

    /* renamed from: h0 */
    public void m4198h0(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.f2912Y;
                this.f2912Y = true;
            }
            if (z2) {
                m4197h();
                return;
            }
        }
        try {
            this.f2919f0.m4833p(z, i, i2);
        } catch (IOException unused) {
            m4197h();
        }
    }

    /* renamed from: i0 */
    public void m4199i0(int i, co0 co0Var) throws IOException {
        this.f2919f0.m4835y(i, co0Var);
    }

    /* renamed from: j0 */
    public void m4200j0(int i, co0 co0Var) {
        try {
            this.f2909V.execute(new C1053a("OkHttp %s stream %d", new Object[]{this.f2905R, Integer.valueOf(i)}, i, co0Var));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: k0 */
    public void m4201k0(int i, long j) {
        try {
            this.f2909V.execute(new C1054b("OkHttp Window Update %s stream %d", new Object[]{this.f2905R, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    /* renamed from: l */
    public synchronized ho0 m4202l(int i) {
        return this.f2904Q.get(Integer.valueOf(i));
    }

    /* renamed from: n */
    public synchronized boolean m4203n() {
        return this.f2908U;
    }

    /* renamed from: p */
    public synchronized int m4204p() {
        return this.f2916c0.m5965e(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0041 A[Catch: all -> 0x0073, TryCatch #0 {, blocks: (B:6:0x0007, B:8:0x000e, B:9:0x0013, B:11:0x0017, B:13:0x0029, B:15:0x0031, B:19:0x003b, B:21:0x0041, B:22:0x004a, B:36:0x006d, B:37:0x0072), top: B:5:0x0007, outer: #1 }] */
    /* renamed from: x */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final cz.opentree.ho0 m4205x(int r11, java.util.List<okhttp3.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            cz.opentree.io0 r7 = r10.f2919f0
            monitor-enter(r7)
            monitor-enter(r10)     // Catch: java.lang.Throwable -> L76
            int r0 = r10.f2907T     // Catch: java.lang.Throwable -> L73
            r1 = 1073741823(0x3fffffff, float:1.9999999)
            if (r0 <= r1) goto L13
            cz.opentree.co0 r0 = cz.opentree.co0.REFUSED_STREAM     // Catch: java.lang.Throwable -> L73
            r10.m4191c0(r0)     // Catch: java.lang.Throwable -> L73
        L13:
            boolean r0 = r10.f2908U     // Catch: java.lang.Throwable -> L73
            if (r0 != 0) goto L6d
            int r8 = r10.f2907T     // Catch: java.lang.Throwable -> L73
            int r0 = r8 + 2
            r10.f2907T = r0     // Catch: java.lang.Throwable -> L73
            cz.opentree.ho0 r9 = new cz.opentree.ho0     // Catch: java.lang.Throwable -> L73
            r5 = 0
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L73
            if (r13 == 0) goto L3a
            long r0 = r10.f2914a0     // Catch: java.lang.Throwable -> L73
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L3a
            long r0 = r9.f3188b     // Catch: java.lang.Throwable -> L73
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L38
            goto L3a
        L38:
            r13 = 0
            goto L3b
        L3a:
            r13 = 1
        L3b:
            boolean r0 = r9.m4595m()     // Catch: java.lang.Throwable -> L73
            if (r0 == 0) goto L4a
            java.util.Map<java.lang.Integer, cz.opentree.ho0> r0 = r10.f2904Q     // Catch: java.lang.Throwable -> L73
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch: java.lang.Throwable -> L73
            r0.put(r1, r9)     // Catch: java.lang.Throwable -> L73
        L4a:
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            if (r11 != 0) goto L53
            cz.opentree.io0 r0 = r10.f2919f0     // Catch: java.lang.Throwable -> L76
            r0.m4822D(r6, r8, r11, r12)     // Catch: java.lang.Throwable -> L76
            goto L5c
        L53:
            boolean r0 = r10.f2902O     // Catch: java.lang.Throwable -> L76
            if (r0 != 0) goto L65
            cz.opentree.io0 r0 = r10.f2919f0     // Catch: java.lang.Throwable -> L76
            r0.m4834x(r11, r8, r12)     // Catch: java.lang.Throwable -> L76
        L5c:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            if (r13 == 0) goto L64
            cz.opentree.io0 r11 = r10.f2919f0
            r11.flush()
        L64:
            return r9
        L65:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L76
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch: java.lang.Throwable -> L76
            throw r11     // Catch: java.lang.Throwable -> L76
        L6d:
            cz.opentree.bo0 r11 = new cz.opentree.bo0     // Catch: java.lang.Throwable -> L73
            r11.<init>()     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L73
        L73:
            r11 = move-exception
            monitor-exit(r10)     // Catch: java.lang.Throwable -> L73
            throw r11     // Catch: java.lang.Throwable -> L76
        L76:
            r11 = move-exception
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L76
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.go0.m4205x(int, java.util.List, boolean):cz.opentree.ho0");
    }

    /* renamed from: y */
    public ho0 m4206y(List<Header> list, boolean z) throws IOException {
        return m4205x(0, list, z);
    }

    /* renamed from: z */
    public void m4207z(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        zo0 zo0Var = new zo0();
        long j = i2;
        bufferedSource.mo4899U(j);
        bufferedSource.mo2186R(zo0Var, j);
        if (zo0Var.m10557f0() == j) {
            m4185D(new C1057e("OkHttp %s Push Data[%s]", new Object[]{this.f2905R, Integer.valueOf(i)}, i, zo0Var, i2, z));
            return;
        }
        throw new IOException(zo0Var.m10557f0() + " != " + i2);
    }
}
