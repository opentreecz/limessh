package com.sonelli;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Call;
import okhttp3.EventListener;

/* compiled from: RouteSelector.java */
/* loaded from: classes.dex */
public final class on0 {

    /* renamed from: a */
    public final gm0 f5515a;

    /* renamed from: b */
    public final mn0 f5516b;

    /* renamed from: c */
    public final Call f5517c;

    /* renamed from: d */
    public final EventListener f5518d;

    /* renamed from: f */
    public int f5520f;

    /* renamed from: e */
    public List<Proxy> f5519e = Collections.emptyList();

    /* renamed from: g */
    public List<InetSocketAddress> f5521g = Collections.emptyList();

    /* renamed from: h */
    public final List<bn0> f5522h = new ArrayList();

    /* compiled from: RouteSelector.java */
    /* renamed from: com.sonelli.on0$a */
    /* loaded from: classes.dex */
    public static final class C1665a {

        /* renamed from: a */
        public final List<bn0> f5523a;

        /* renamed from: b */
        public int f5524b = 0;

        public C1665a(List<bn0> list) {
            this.f5523a = list;
        }

        /* renamed from: a */
        public List<bn0> m7071a() {
            return new ArrayList(this.f5523a);
        }

        /* renamed from: b */
        public boolean m7072b() {
            return this.f5524b < this.f5523a.size();
        }

        /* renamed from: c */
        public bn0 m7073c() {
            if (!m7072b()) {
                throw new NoSuchElementException();
            }
            List<bn0> list = this.f5523a;
            int i = this.f5524b;
            this.f5524b = i + 1;
            return list.get(i);
        }
    }

    public on0(gm0 gm0Var, mn0 mn0Var, Call call, EventListener eventListener) {
        this.f5515a = gm0Var;
        this.f5516b = mn0Var;
        this.f5517c = call;
        this.f5518d = eventListener;
        m7070h(gm0Var.m4179l(), gm0Var.m4174g());
    }

    /* renamed from: b */
    public static String m7063b(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        return address == null ? inetSocketAddress.getHostName() : address.getHostAddress();
    }

    /* renamed from: a */
    public void m7064a(bn0 bn0Var, IOException iOException) {
        if (bn0Var.m2587b().type() != Proxy.Type.DIRECT && this.f5515a.m4176i() != null) {
            this.f5515a.m4176i().connectFailed(this.f5515a.m4179l().m8164D(), bn0Var.m2587b().address(), iOException);
        }
        this.f5516b.m6484b(bn0Var);
    }

    /* renamed from: c */
    public boolean m7065c() {
        return m7066d() || !this.f5522h.isEmpty();
    }

    /* renamed from: d */
    public final boolean m7066d() {
        return this.f5520f < this.f5519e.size();
    }

    /* renamed from: e */
    public C1665a m7067e() throws IOException {
        if (!m7065c()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList = new ArrayList();
        while (m7066d()) {
            Proxy m7068f = m7068f();
            int size = this.f5521g.size();
            for (int i = 0; i < size; i++) {
                bn0 bn0Var = new bn0(this.f5515a, m7068f, this.f5521g.get(i));
                if (this.f5516b.m6485c(bn0Var)) {
                    this.f5522h.add(bn0Var);
                } else {
                    arrayList.add(bn0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.addAll(this.f5522h);
            this.f5522h.clear();
        }
        return new C1665a(arrayList);
    }

    /* renamed from: f */
    public final Proxy m7068f() throws IOException {
        if (m7066d()) {
            List<Proxy> list = this.f5519e;
            int i = this.f5520f;
            this.f5520f = i + 1;
            Proxy proxy = list.get(i);
            m7069g(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f5515a.m4179l().m8171l() + "; exhausted proxy configurations: " + this.f5519e);
    }

    /* renamed from: g */
    public final void m7069g(Proxy proxy) throws IOException {
        String m8171l;
        int m8176x;
        this.f5521g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            m8171l = this.f5515a.m4179l().m8171l();
            m8176x = this.f5515a.m4179l().m8176x();
        } else {
            SocketAddress address = proxy.address();
            if (!(address instanceof InetSocketAddress)) {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
            m8171l = m7063b(inetSocketAddress);
            m8176x = inetSocketAddress.getPort();
        }
        if (m8176x < 1 || m8176x > 65535) {
            throw new SocketException("No route to " + m8171l + ":" + m8176x + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f5521g.add(InetSocketAddress.createUnresolved(m8171l, m8176x));
            return;
        }
        this.f5518d.m10709j(this.f5517c, m8171l);
        List<InetAddress> mo10698a = this.f5515a.m4170c().mo10698a(m8171l);
        if (mo10698a.isEmpty()) {
            throw new UnknownHostException(this.f5515a.m4170c() + " returned no addresses for " + m8171l);
        }
        this.f5518d.m10708i(this.f5517c, m8171l, mo10698a);
        int size = mo10698a.size();
        for (int i = 0; i < size; i++) {
            this.f5521g.add(new InetSocketAddress(mo10698a.get(i), m8176x));
        }
    }

    /* renamed from: h */
    public final void m7070h(rm0 rm0Var, Proxy proxy) {
        if (proxy != null) {
            this.f5519e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f5515a.m4176i().select(rm0Var.m8164D());
            this.f5519e = (select == null || select.isEmpty()) ? fn0.m3840u(Proxy.NO_PROXY) : fn0.m3839t(select);
        }
        this.f5520f = 0;
    }
}
