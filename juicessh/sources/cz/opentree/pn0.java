package cz.opentree;

import cz.opentree.on0;
import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.internal.http.HttpCodec;

/* compiled from: StreamAllocation.java */
/* loaded from: classes.dex */
public final class pn0 {

    /* renamed from: a */
    public final gm0 f5727a;

    /* renamed from: b */
    public on0.C1665a f5728b;

    /* renamed from: c */
    public bn0 f5729c;

    /* renamed from: d */
    public final lm0 f5730d;

    /* renamed from: e */
    public final Call f5731e;

    /* renamed from: f */
    public final EventListener f5732f;

    /* renamed from: g */
    public final Object f5733g;

    /* renamed from: h */
    public final on0 f5734h;

    /* renamed from: i */
    public int f5735i;

    /* renamed from: j */
    public ln0 f5736j;

    /* renamed from: k */
    public boolean f5737k;

    /* renamed from: l */
    public boolean f5738l;

    /* renamed from: m */
    public boolean f5739m;

    /* renamed from: n */
    public HttpCodec f5740n;

    /* compiled from: StreamAllocation.java */
    /* renamed from: cz.opentree.pn0$a */
    /* loaded from: classes.dex */
    public static final class C1727a extends WeakReference<pn0> {

        /* renamed from: a */
        public final Object f5741a;

        public C1727a(pn0 pn0Var, Object obj) {
            super(pn0Var);
            this.f5741a = obj;
        }
    }

    public pn0(lm0 lm0Var, gm0 gm0Var, Call call, EventListener eventListener, Object obj) {
        this.f5730d = lm0Var;
        this.f5727a = gm0Var;
        this.f5731e = call;
        this.f5732f = eventListener;
        this.f5734h = new on0(gm0Var, m7427p(), call, eventListener);
        this.f5733g = obj;
    }

    /* renamed from: a */
    public void m7412a(ln0 ln0Var, boolean z) {
        if (this.f5736j != null) {
            throw new IllegalStateException();
        }
        this.f5736j = ln0Var;
        this.f5737k = z;
        ln0Var.f4896n.add(new C1727a(this, this.f5733g));
    }

    /* renamed from: b */
    public void m7413b() {
        HttpCodec httpCodec;
        ln0 ln0Var;
        synchronized (this.f5730d) {
            this.f5739m = true;
            httpCodec = this.f5740n;
            ln0Var = this.f5736j;
        }
        if (httpCodec != null) {
            httpCodec.cancel();
        } else if (ln0Var != null) {
            ln0Var.m6259c();
        }
    }

    /* renamed from: c */
    public HttpCodec m7414c() {
        HttpCodec httpCodec;
        synchronized (this.f5730d) {
            httpCodec = this.f5740n;
        }
        return httpCodec;
    }

    /* renamed from: d */
    public synchronized ln0 m7415d() {
        return this.f5736j;
    }

    /* renamed from: e */
    public final Socket m7416e(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (z3) {
            this.f5740n = null;
        }
        if (z2) {
            this.f5738l = true;
        }
        ln0 ln0Var = this.f5736j;
        if (ln0Var == null) {
            return null;
        }
        if (z) {
            ln0Var.f4893k = true;
        }
        if (this.f5740n != null) {
            return null;
        }
        if (!this.f5738l && !ln0Var.f4893k) {
            return null;
        }
        m7423l(ln0Var);
        if (this.f5736j.f4896n.isEmpty()) {
            this.f5736j.f4897o = System.nanoTime();
            if (dn0.f2249a.mo3269e(this.f5730d, this.f5736j)) {
                socket = this.f5736j.m6273q();
                this.f5736j = null;
                return socket;
            }
        }
        socket = null;
        this.f5736j = null;
        return socket;
    }

    /* renamed from: f */
    public final ln0 m7417f(int i, int i2, int i3, int i4, boolean z) throws IOException {
        ln0 ln0Var;
        Socket m7425n;
        ln0 ln0Var2;
        Socket socket;
        bn0 bn0Var;
        boolean z2;
        boolean z3;
        on0.C1665a c1665a;
        synchronized (this.f5730d) {
            if (this.f5738l) {
                throw new IllegalStateException("released");
            }
            if (this.f5740n != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f5739m) {
                throw new IOException("Canceled");
            }
            ln0Var = this.f5736j;
            m7425n = m7425n();
            ln0Var2 = this.f5736j;
            socket = null;
            if (ln0Var2 != null) {
                ln0Var = null;
            } else {
                ln0Var2 = null;
            }
            if (!this.f5737k) {
                ln0Var = null;
            }
            if (ln0Var2 == null) {
                dn0.f2249a.mo3272h(this.f5730d, this.f5727a, this, null);
                ln0 ln0Var3 = this.f5736j;
                if (ln0Var3 != null) {
                    z2 = true;
                    ln0Var2 = ln0Var3;
                    bn0Var = null;
                } else {
                    bn0Var = this.f5729c;
                }
            } else {
                bn0Var = null;
            }
            z2 = false;
        }
        fn0.m3827h(m7425n);
        if (ln0Var != null) {
            this.f5732f.m10707h(this.f5731e, ln0Var);
        }
        if (z2) {
            this.f5732f.m10706g(this.f5731e, ln0Var2);
        }
        if (ln0Var2 != null) {
            return ln0Var2;
        }
        if (bn0Var != null || ((c1665a = this.f5728b) != null && c1665a.m7072b())) {
            z3 = false;
        } else {
            this.f5728b = this.f5734h.m7067e();
            z3 = true;
        }
        synchronized (this.f5730d) {
            if (this.f5739m) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<bn0> m7071a = this.f5728b.m7071a();
                int size = m7071a.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    bn0 bn0Var2 = m7071a.get(i5);
                    dn0.f2249a.mo3272h(this.f5730d, this.f5727a, this, bn0Var2);
                    ln0 ln0Var4 = this.f5736j;
                    if (ln0Var4 != null) {
                        this.f5729c = bn0Var2;
                        z2 = true;
                        ln0Var2 = ln0Var4;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (bn0Var == null) {
                    bn0Var = this.f5728b.m7073c();
                }
                this.f5729c = bn0Var;
                this.f5735i = 0;
                ln0Var2 = new ln0(this.f5730d, bn0Var);
                m7412a(ln0Var2, false);
            }
        }
        if (z2) {
            this.f5732f.m10706g(this.f5731e, ln0Var2);
            return ln0Var2;
        }
        ln0Var2.m6260d(i, i2, i3, i4, z, this.f5731e, this.f5732f);
        m7427p().m6483a(ln0Var2.m6272p());
        synchronized (this.f5730d) {
            this.f5737k = true;
            dn0.f2249a.mo3273i(this.f5730d, ln0Var2);
            if (ln0Var2.m6270n()) {
                socket = dn0.f2249a.mo3270f(this.f5730d, this.f5727a, this);
                ln0Var2 = this.f5736j;
            }
        }
        fn0.m3827h(socket);
        this.f5732f.m10706g(this.f5731e, ln0Var2);
        return ln0Var2;
    }

    /* renamed from: g */
    public final ln0 m7418g(int i, int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        while (true) {
            ln0 m7417f = m7417f(i, i2, i3, i4, z);
            synchronized (this.f5730d) {
                if (m7417f.f4894l == 0) {
                    return m7417f;
                }
                if (m7417f.m6269m(z2)) {
                    return m7417f;
                }
                m7421j();
            }
        }
    }

    /* renamed from: h */
    public boolean m7419h() {
        on0.C1665a c1665a;
        return this.f5729c != null || ((c1665a = this.f5728b) != null && c1665a.m7072b()) || this.f5734h.m7065c();
    }

    /* renamed from: i */
    public HttpCodec m7420i(um0 um0Var, Interceptor.Chain chain, boolean z) {
        try {
            HttpCodec m6271o = m7418g(chain.mo9319d(), chain.mo9316a(), chain.mo9317b(), um0Var.m8958z(), um0Var.m8936F(), z).m6271o(um0Var, chain, this);
            synchronized (this.f5730d) {
                this.f5740n = m6271o;
            }
            return m6271o;
        } catch (IOException e) {
            throw new nn0(e);
        }
    }

    /* renamed from: j */
    public void m7421j() {
        ln0 ln0Var;
        Socket m7416e;
        synchronized (this.f5730d) {
            ln0Var = this.f5736j;
            m7416e = m7416e(true, false, false);
            if (this.f5736j != null) {
                ln0Var = null;
            }
        }
        fn0.m3827h(m7416e);
        if (ln0Var != null) {
            this.f5732f.m10707h(this.f5731e, ln0Var);
        }
    }

    /* renamed from: k */
    public void m7422k() {
        ln0 ln0Var;
        Socket m7416e;
        synchronized (this.f5730d) {
            ln0Var = this.f5736j;
            m7416e = m7416e(false, true, false);
            if (this.f5736j != null) {
                ln0Var = null;
            }
        }
        fn0.m3827h(m7416e);
        if (ln0Var != null) {
            dn0.f2249a.mo3275k(this.f5731e, null);
            this.f5732f.m10707h(this.f5731e, ln0Var);
            this.f5732f.m10700a(this.f5731e);
        }
    }

    /* renamed from: l */
    public final void m7423l(ln0 ln0Var) {
        int size = ln0Var.f4896n.size();
        for (int i = 0; i < size; i++) {
            if (ln0Var.f4896n.get(i).get() == this) {
                ln0Var.f4896n.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* renamed from: m */
    public Socket m7424m(ln0 ln0Var) {
        if (this.f5740n != null || this.f5736j.f4896n.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<pn0> reference = this.f5736j.f4896n.get(0);
        Socket m7416e = m7416e(true, false, false);
        this.f5736j = ln0Var;
        ln0Var.f4896n.add(reference);
        return m7416e;
    }

    /* renamed from: n */
    public final Socket m7425n() {
        ln0 ln0Var = this.f5736j;
        if (ln0Var == null || !ln0Var.f4893k) {
            return null;
        }
        return m7416e(false, false, true);
    }

    /* renamed from: o */
    public bn0 m7426o() {
        return this.f5729c;
    }

    /* renamed from: p */
    public final mn0 m7427p() {
        return dn0.f2249a.mo3274j(this.f5730d);
    }

    /* renamed from: q */
    public void m7428q(IOException iOException) {
        ln0 ln0Var;
        boolean z;
        Socket m7416e;
        synchronized (this.f5730d) {
            ln0Var = null;
            if (iOException instanceof lo0) {
                co0 co0Var = ((lo0) iOException).f4898O;
                if (co0Var == co0.REFUSED_STREAM) {
                    int i = this.f5735i + 1;
                    this.f5735i = i;
                    if (i > 1) {
                        this.f5729c = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (co0Var != co0.CANCEL) {
                        this.f5729c = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                ln0 ln0Var2 = this.f5736j;
                if (ln0Var2 != null && (!ln0Var2.m6270n() || (iOException instanceof bo0))) {
                    if (this.f5736j.f4894l == 0) {
                        bn0 bn0Var = this.f5729c;
                        if (bn0Var != null && iOException != null) {
                            this.f5734h.m7064a(bn0Var, iOException);
                        }
                        this.f5729c = null;
                    }
                    z = true;
                }
                z = false;
            }
            ln0 ln0Var3 = this.f5736j;
            m7416e = m7416e(z, false, true);
            if (this.f5736j == null && this.f5737k) {
                ln0Var = ln0Var3;
            }
        }
        fn0.m3827h(m7416e);
        if (ln0Var != null) {
            this.f5732f.m10707h(this.f5731e, ln0Var);
        }
    }

    /* renamed from: r */
    public void m7429r(boolean z, HttpCodec httpCodec, long j, IOException iOException) {
        ln0 ln0Var;
        Socket m7416e;
        boolean z2;
        this.f5732f.m10714p(this.f5731e, j);
        synchronized (this.f5730d) {
            if (httpCodec != null) {
                if (httpCodec == this.f5740n) {
                    if (!z) {
                        this.f5736j.f4894l++;
                    }
                    ln0Var = this.f5736j;
                    m7416e = m7416e(z, false, true);
                    if (this.f5736j != null) {
                        ln0Var = null;
                    }
                    z2 = this.f5738l;
                }
            }
            throw new IllegalStateException("expected " + this.f5740n + " but was " + httpCodec);
        }
        fn0.m3827h(m7416e);
        if (ln0Var != null) {
            this.f5732f.m10707h(this.f5731e, ln0Var);
        }
        if (iOException != null) {
            this.f5732f.m10701b(this.f5731e, dn0.f2249a.mo3275k(this.f5731e, iOException));
        } else if (z2) {
            dn0.f2249a.mo3275k(this.f5731e, null);
            this.f5732f.m10700a(this.f5731e);
        }
    }

    public String toString() {
        ln0 m7415d = m7415d();
        return m7415d != null ? m7415d.toString() : this.f5727a.toString();
    }
}
