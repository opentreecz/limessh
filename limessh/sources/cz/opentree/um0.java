package cz.opentree;

import cz.opentree.qm0;
import cz.opentree.zm0;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CookieJar;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.WebSocket;
import okhttp3.internal.cache.InternalCache;

/* compiled from: OkHttpClient.java */
/* loaded from: classes.dex */
public class um0 implements Cloneable, Call.Factory, WebSocket.Factory {

    /* renamed from: q0 */
    public static final List<vm0> f7022q0 = fn0.m3840u(vm0.HTTP_2, vm0.HTTP_1_1);

    /* renamed from: r0 */
    public static final List<mm0> f7023r0 = fn0.m3840u(mm0.f5097g, mm0.f5098h);

    /* renamed from: O */
    public final om0 f7024O;

    /* renamed from: P */
    @Nullable
    public final Proxy f7025P;

    /* renamed from: Q */
    public final List<vm0> f7026Q;

    /* renamed from: R */
    public final List<mm0> f7027R;

    /* renamed from: S */
    public final List<Interceptor> f7028S;

    /* renamed from: T */
    public final List<Interceptor> f7029T;

    /* renamed from: U */
    public final EventListener.Factory f7030U;

    /* renamed from: V */
    public final ProxySelector f7031V;

    /* renamed from: W */
    public final CookieJar f7032W;

    /* renamed from: X */
    @Nullable
    public final hm0 f7033X;

    /* renamed from: Y */
    @Nullable
    public final InternalCache f7034Y;

    /* renamed from: Z */
    public final SocketFactory f7035Z;

    /* renamed from: a0 */
    public final SSLSocketFactory f7036a0;

    /* renamed from: b0 */
    public final vo0 f7037b0;

    /* renamed from: c0 */
    public final HostnameVerifier f7038c0;

    /* renamed from: d0 */
    public final jm0 f7039d0;

    /* renamed from: e0 */
    public final Authenticator f7040e0;

    /* renamed from: f0 */
    public final Authenticator f7041f0;

    /* renamed from: g0 */
    public final lm0 f7042g0;

    /* renamed from: h0 */
    public final Dns f7043h0;

    /* renamed from: i0 */
    public final boolean f7044i0;

    /* renamed from: j0 */
    public final boolean f7045j0;

    /* renamed from: k0 */
    public final boolean f7046k0;

    /* renamed from: l0 */
    public final int f7047l0;

    /* renamed from: m0 */
    public final int f7048m0;

    /* renamed from: n0 */
    public final int f7049n0;

    /* renamed from: o0 */
    public final int f7050o0;

    /* renamed from: p0 */
    public final int f7051p0;

    /* compiled from: OkHttpClient.java */
    /* renamed from: cz.opentree.um0$a */
    /* loaded from: classes.dex */
    public class C2021a extends dn0 {
        @Override // cz.opentree.dn0
        /* renamed from: a */
        public void mo3265a(qm0.C1776a c1776a, String str) {
            c1776a.m7756b(str);
        }

        @Override // cz.opentree.dn0
        /* renamed from: b */
        public void mo3266b(qm0.C1776a c1776a, String str, String str2) {
            c1776a.m7757c(str, str2);
        }

        @Override // cz.opentree.dn0
        /* renamed from: c */
        public void mo3267c(mm0 mm0Var, SSLSocket sSLSocket, boolean z) {
            mm0Var.m6463a(sSLSocket, z);
        }

        @Override // cz.opentree.dn0
        /* renamed from: d */
        public int mo3268d(zm0.C2434a c2434a) {
            return c2434a.f8555c;
        }

        @Override // cz.opentree.dn0
        /* renamed from: e */
        public boolean mo3269e(lm0 lm0Var, ln0 ln0Var) {
            return lm0Var.m6254b(ln0Var);
        }

        @Override // cz.opentree.dn0
        /* renamed from: f */
        public Socket mo3270f(lm0 lm0Var, gm0 gm0Var, pn0 pn0Var) {
            return lm0Var.m6255c(gm0Var, pn0Var);
        }

        @Override // cz.opentree.dn0
        /* renamed from: g */
        public boolean mo3271g(gm0 gm0Var, gm0 gm0Var2) {
            return gm0Var.m4171d(gm0Var2);
        }

        @Override // cz.opentree.dn0
        /* renamed from: h */
        public ln0 mo3272h(lm0 lm0Var, gm0 gm0Var, pn0 pn0Var, bn0 bn0Var) {
            return lm0Var.m6256d(gm0Var, pn0Var, bn0Var);
        }

        @Override // cz.opentree.dn0
        /* renamed from: i */
        public void mo3273i(lm0 lm0Var, ln0 ln0Var) {
            lm0Var.m6258f(ln0Var);
        }

        @Override // cz.opentree.dn0
        /* renamed from: j */
        public mn0 mo3274j(lm0 lm0Var) {
            return lm0Var.f4881e;
        }

        @Override // cz.opentree.dn0
        @Nullable
        /* renamed from: k */
        public IOException mo3275k(Call call, @Nullable IOException iOException) {
            return ((wm0) call).m9592l(iOException);
        }
    }

    /* compiled from: OkHttpClient.java */
    /* renamed from: cz.opentree.um0$b */
    /* loaded from: classes.dex */
    public static final class C2022b {

        /* renamed from: A */
        public int f7052A;

        /* renamed from: B */
        public int f7053B;

        /* renamed from: a */
        public om0 f7054a;

        /* renamed from: b */
        @Nullable
        public Proxy f7055b;

        /* renamed from: c */
        public List<vm0> f7056c;

        /* renamed from: d */
        public List<mm0> f7057d;

        /* renamed from: e */
        public final List<Interceptor> f7058e;

        /* renamed from: f */
        public final List<Interceptor> f7059f;

        /* renamed from: g */
        public EventListener.Factory f7060g;

        /* renamed from: h */
        public ProxySelector f7061h;

        /* renamed from: i */
        public CookieJar f7062i;

        /* renamed from: j */
        @Nullable
        public hm0 f7063j;

        /* renamed from: k */
        @Nullable
        public InternalCache f7064k;

        /* renamed from: l */
        public SocketFactory f7065l;

        /* renamed from: m */
        @Nullable
        public SSLSocketFactory f7066m;

        /* renamed from: n */
        @Nullable
        public vo0 f7067n;

        /* renamed from: o */
        public HostnameVerifier f7068o;

        /* renamed from: p */
        public jm0 f7069p;

        /* renamed from: q */
        public Authenticator f7070q;

        /* renamed from: r */
        public Authenticator f7071r;

        /* renamed from: s */
        public lm0 f7072s;

        /* renamed from: t */
        public Dns f7073t;

        /* renamed from: u */
        public boolean f7074u;

        /* renamed from: v */
        public boolean f7075v;

        /* renamed from: w */
        public boolean f7076w;

        /* renamed from: x */
        public int f7077x;

        /* renamed from: y */
        public int f7078y;

        /* renamed from: z */
        public int f7079z;

        public C2022b() {
            this.f7058e = new ArrayList();
            this.f7059f = new ArrayList();
            this.f7054a = new om0();
            this.f7056c = um0.f7022q0;
            this.f7057d = um0.f7023r0;
            this.f7060g = EventListener.m10699k(EventListener.f8654a);
            ProxySelector proxySelector = ProxySelector.getDefault();
            this.f7061h = proxySelector;
            if (proxySelector == null) {
                this.f7061h = new so0();
            }
            this.f7062i = CookieJar.f8652a;
            this.f7065l = SocketFactory.getDefault();
            this.f7068o = wo0.f7782a;
            this.f7069p = jm0.f3621c;
            Authenticator authenticator = Authenticator.f8651a;
            this.f7070q = authenticator;
            this.f7071r = authenticator;
            this.f7072s = new lm0();
            this.f7073t = Dns.f8653a;
            this.f7074u = true;
            this.f7075v = true;
            this.f7076w = true;
            this.f7077x = 0;
            this.f7078y = 10000;
            this.f7079z = 10000;
            this.f7052A = 10000;
            this.f7053B = 0;
        }

        public C2022b(um0 um0Var) {
            ArrayList arrayList = new ArrayList();
            this.f7058e = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.f7059f = arrayList2;
            this.f7054a = um0Var.f7024O;
            this.f7055b = um0Var.f7025P;
            this.f7056c = um0Var.f7026Q;
            this.f7057d = um0Var.f7027R;
            arrayList.addAll(um0Var.f7028S);
            arrayList2.addAll(um0Var.f7029T);
            this.f7060g = um0Var.f7030U;
            this.f7061h = um0Var.f7031V;
            this.f7062i = um0Var.f7032W;
            this.f7064k = um0Var.f7034Y;
            hm0 hm0Var = um0Var.f7033X;
            this.f7065l = um0Var.f7035Z;
            this.f7066m = um0Var.f7036a0;
            this.f7067n = um0Var.f7037b0;
            this.f7068o = um0Var.f7038c0;
            this.f7069p = um0Var.f7039d0;
            this.f7070q = um0Var.f7040e0;
            this.f7071r = um0Var.f7041f0;
            this.f7072s = um0Var.f7042g0;
            this.f7073t = um0Var.f7043h0;
            this.f7074u = um0Var.f7044i0;
            this.f7075v = um0Var.f7045j0;
            this.f7076w = um0Var.f7046k0;
            this.f7077x = um0Var.f7047l0;
            this.f7078y = um0Var.f7048m0;
            this.f7079z = um0Var.f7049n0;
            this.f7052A = um0Var.f7050o0;
            this.f7053B = um0Var.f7051p0;
        }

        /* renamed from: a */
        public um0 m8959a() {
            return new um0(this);
        }

        /* renamed from: b */
        public C2022b m8960b(long j, TimeUnit timeUnit) {
            this.f7077x = fn0.m3824e("timeout", j, timeUnit);
            return this;
        }
    }

    static {
        dn0.f2249a = new C2021a();
    }

    public um0() {
        this(new C2022b());
    }

    public um0(C2022b c2022b) {
        boolean z;
        this.f7024O = c2022b.f7054a;
        this.f7025P = c2022b.f7055b;
        this.f7026Q = c2022b.f7056c;
        List<mm0> list = c2022b.f7057d;
        this.f7027R = list;
        this.f7028S = fn0.m3839t(c2022b.f7058e);
        this.f7029T = fn0.m3839t(c2022b.f7059f);
        this.f7030U = c2022b.f7060g;
        this.f7031V = c2022b.f7061h;
        this.f7032W = c2022b.f7062i;
        hm0 hm0Var = c2022b.f7063j;
        this.f7034Y = c2022b.f7064k;
        this.f7035Z = c2022b.f7065l;
        Iterator<mm0> it = list.iterator();
        loop0: while (true) {
            z = false;
            while (it.hasNext()) {
                z = (z || it.next().m6466d()) ? true : z;
            }
        }
        SSLSocketFactory sSLSocketFactory = c2022b.f7066m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager m3812C = fn0.m3812C();
            this.f7036a0 = m8930y(m3812C);
            this.f7037b0 = vo0.m9334b(m3812C);
        } else {
            this.f7036a0 = sSLSocketFactory;
            this.f7037b0 = c2022b.f7067n;
        }
        if (this.f7036a0 != null) {
            ro0.m8221j().mo6759f(this.f7036a0);
        }
        this.f7038c0 = c2022b.f7068o;
        this.f7039d0 = c2022b.f7069p.m5169f(this.f7037b0);
        this.f7040e0 = c2022b.f7070q;
        this.f7041f0 = c2022b.f7071r;
        this.f7042g0 = c2022b.f7072s;
        this.f7043h0 = c2022b.f7073t;
        this.f7044i0 = c2022b.f7074u;
        this.f7045j0 = c2022b.f7075v;
        this.f7046k0 = c2022b.f7076w;
        this.f7047l0 = c2022b.f7077x;
        this.f7048m0 = c2022b.f7078y;
        this.f7049n0 = c2022b.f7079z;
        this.f7050o0 = c2022b.f7052A;
        this.f7051p0 = c2022b.f7053B;
        if (this.f7028S.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f7028S);
        }
        if (this.f7029T.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f7029T);
        }
    }

    /* renamed from: y */
    public static SSLSocketFactory m8930y(X509TrustManager x509TrustManager) {
        try {
            SSLContext mo6496k = ro0.m8221j().mo6496k();
            mo6496k.init(null, new TrustManager[]{x509TrustManager}, null);
            return mo6496k.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw fn0.m3821b("No System TLS", e);
        }
    }

    /* renamed from: A */
    public List<vm0> m8931A() {
        return this.f7026Q;
    }

    @Nullable
    /* renamed from: B */
    public Proxy m8932B() {
        return this.f7025P;
    }

    /* renamed from: C */
    public Authenticator m8933C() {
        return this.f7040e0;
    }

    /* renamed from: D */
    public ProxySelector m8934D() {
        return this.f7031V;
    }

    /* renamed from: E */
    public int m8935E() {
        return this.f7049n0;
    }

    /* renamed from: F */
    public boolean m8936F() {
        return this.f7046k0;
    }

    /* renamed from: G */
    public SocketFactory m8937G() {
        return this.f7035Z;
    }

    /* renamed from: H */
    public SSLSocketFactory m8938H() {
        return this.f7036a0;
    }

    /* renamed from: I */
    public int m8939I() {
        return this.f7050o0;
    }

    /* renamed from: b */
    public Authenticator m8940b() {
        return this.f7041f0;
    }

    /* renamed from: c */
    public int m8941c() {
        return this.f7047l0;
    }

    /* renamed from: d */
    public jm0 m8942d() {
        return this.f7039d0;
    }

    /* renamed from: e */
    public int m8943e() {
        return this.f7048m0;
    }

    /* renamed from: g */
    public lm0 m8944g() {
        return this.f7042g0;
    }

    /* renamed from: i */
    public List<mm0> m8945i() {
        return this.f7027R;
    }

    /* renamed from: j */
    public CookieJar m8946j() {
        return this.f7032W;
    }

    /* renamed from: k */
    public om0 m8947k() {
        return this.f7024O;
    }

    /* renamed from: l */
    public Dns m8948l() {
        return this.f7043h0;
    }

    /* renamed from: m */
    public EventListener.Factory m8949m() {
        return this.f7030U;
    }

    /* renamed from: o */
    public boolean m8950o() {
        return this.f7045j0;
    }

    /* renamed from: q */
    public boolean m8951q() {
        return this.f7044i0;
    }

    /* renamed from: r */
    public HostnameVerifier m8952r() {
        return this.f7038c0;
    }

    /* renamed from: s */
    public List<Interceptor> m8953s() {
        return this.f7028S;
    }

    /* renamed from: t */
    public InternalCache m8954t() {
        hm0 hm0Var = this.f7033X;
        return hm0Var != null ? hm0Var.f3173O : this.f7034Y;
    }

    /* renamed from: u */
    public List<Interceptor> m8955u() {
        return this.f7029T;
    }

    /* renamed from: v */
    public C2022b m8956v() {
        return new C2022b(this);
    }

    /* renamed from: w */
    public Call m8957w(xm0 xm0Var) {
        return wm0.m9584j(this, xm0Var, false);
    }

    /* renamed from: z */
    public int m8958z() {
        return this.f7051p0;
    }
}
