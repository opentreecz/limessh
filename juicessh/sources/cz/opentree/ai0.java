package cz.opentree;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.juicessh.connections.ConnectionManager;
import cz.opentree.juicessh.connections.transports.ConnectionProvider;
import cz.opentree.juicessh.connections.transports.TerminalSessionProvider;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.ConnectionCounter;
import cz.opentree.juicessh.models.Snippet;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TransportChain.java */
/* loaded from: classes.dex */
public class ai0 {

    /* renamed from: n */
    public static int f1395n = 0;

    /* renamed from: o */
    public static int f1396o = 1;

    /* renamed from: p */
    public static int f1397p = 2000;

    /* renamed from: a */
    public FragmentActivity f1398a;

    /* renamed from: b */
    public int f1399b;

    /* renamed from: d */
    public ConnectionProvider f1401d;

    /* renamed from: e */
    public bi0 f1402e;

    /* renamed from: g */
    public ArrayList<mi0> f1404g;

    /* renamed from: h */
    public AtomicBoolean f1405h;

    /* renamed from: j */
    public boolean f1407j;

    /* renamed from: k */
    public Snippet f1408k;

    /* renamed from: l */
    public boolean f1409l;

    /* renamed from: c */
    public UUID f1400c = m2093j();

    /* renamed from: f */
    public ArrayList<ConnectionProvider> f1403f = new ArrayList<>();

    /* renamed from: i */
    public boolean f1406i = false;

    /* renamed from: m */
    public AtomicBoolean f1410m = new AtomicBoolean(false);

    /* compiled from: TransportChain.java */
    /* renamed from: cz.opentree.ai0$a */
    /* loaded from: classes.dex */
    public class C0714a extends bi0 {
        public C0714a(FragmentActivity fragmentActivity, int i, UUID uuid, ArrayList arrayList, boolean z, Snippet snippet) {
            super(fragmentActivity, i, uuid, arrayList, z, snippet);
        }

        @Override // cz.opentree.bi0
        /* renamed from: A */
        public void mo2111A(ArrayList<mi0> arrayList) {
            ai0.this.f1405h.set(true);
            ai0.this.f1404g = arrayList;
            if (!ai0.this.f1407j) {
                ai0.this.m2104r();
                ConnectionManager.m5352e(ai0.this.f1398a, ai0.this);
            }
            super.mo2111A(arrayList);
        }
    }

    /* compiled from: TransportChain.java */
    /* renamed from: cz.opentree.ai0$b */
    /* loaded from: classes.dex */
    public class RunnableC0715b implements Runnable {
        public RunnableC0715b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ConnectionCounter.m5474s((Connection) ai0.this.f1401d, ai0.this.f1398a);
        }
    }

    public ai0(FragmentActivity fragmentActivity, ConnectionProvider connectionProvider) {
        int i = f1397p;
        f1397p = i + 1;
        this.f1399b = i;
        this.f1401d = connectionProvider;
        this.f1398a = fragmentActivity;
    }

    /* renamed from: j */
    public static UUID m2093j() {
        return UUID.randomUUID();
    }

    /* renamed from: g */
    public ai0 m2094g() {
        this.f1405h = new AtomicBoolean(false);
        m2095h(this.f1401d);
        if (this.f1403f.isEmpty()) {
            return this;
        }
        this.f1402e = new C0714a(this.f1398a, this.f1399b, this.f1400c, this.f1403f, this.f1409l, this.f1408k);
        gj0.m4141b("TransportChain", "Building TransportChain[" + this.f1399b + "] with " + this.f1403f.size() + " connections chained");
        this.f1402e.m2519z(this.f1406i);
        this.f1402e.m2508o();
        return this;
    }

    /* renamed from: h */
    public final void m2095h(ConnectionProvider connectionProvider) {
        Connection mo5368g = connectionProvider.mo5368g();
        if (mo5368g == null) {
            gj0.m4142c("TransportChain", "Connection is null!");
            return;
        }
        Connection connection = mo5368g.via;
        if (connection != null && connection.m5383m() != null) {
            m2095h(mo5368g.via);
        }
        this.f1403f.add(connectionProvider);
    }

    /* renamed from: i */
    public void m2096i() {
        sj0.m8455a(this.f1398a, this.f1401d.mo5368g(), this.f1401d, f1396o);
        this.f1402e.m2511r();
    }

    /* renamed from: k */
    public UUID m2097k() {
        return this.f1400c;
    }

    /* renamed from: l */
    public bi0 m2098l() {
        return this.f1402e;
    }

    /* renamed from: m */
    public ConnectionProvider m2099m() {
        return this.f1401d;
    }

    /* renamed from: n */
    public int m2100n() {
        if (m2102p() != null) {
            return m2102p().mo3507l();
        }
        return -1;
    }

    /* renamed from: o */
    public NotificationCompat.Builder m2101o() {
        if (m2102p() != null) {
            return m2102p().mo3508m();
        }
        return null;
    }

    /* renamed from: p */
    public mi0 m2102p() {
        ArrayList<mi0> arrayList = this.f1404g;
        if (arrayList == null || arrayList.size() != this.f1403f.size() || this.f1403f.size() <= 0) {
            return null;
        }
        return this.f1404g.get(r0.size() - 1);
    }

    /* renamed from: q */
    public NotificationCompat.Builder m2103q() {
        if (m2102p() != null) {
            return m2102p().mo3509n();
        }
        return null;
    }

    /* renamed from: r */
    public final void m2104r() {
        if (this.f1406i || !Connection.class.isAssignableFrom(this.f1401d.getClass()) || this.f1401d.getId() == null) {
            return;
        }
        new Thread(new RunnableC0715b()).start();
    }

    /* renamed from: s */
    public boolean m2105s() {
        return this.f1410m.get();
    }

    /* renamed from: t */
    public boolean m2106t() {
        try {
            if (this.f1404g.size() != this.f1403f.size() || m2102p() == null) {
                return false;
            }
            return m2102p().mo3216o();
        } catch (NullPointerException unused) {
            return false;
        }
    }

    /* renamed from: u */
    public void m2107u(boolean z) {
        if (z) {
            gj0.m4141b("TransportChain", "Transport chain " + this.f1399b + " is now attached");
            if (m2102p() instanceof TerminalSessionProvider) {
                ((TerminalSessionProvider) m2102p()).mo3505g();
            }
        } else {
            gj0.m4141b("TransportChain", "Transport chain " + this.f1399b + " is now unattached");
            if (m2102p() instanceof TerminalSessionProvider) {
                ((TerminalSessionProvider) m2102p()).mo3504b();
            }
        }
        this.f1410m.set(z);
    }

    /* renamed from: v */
    public ai0 m2108v(boolean z) {
        this.f1407j = z;
        return this;
    }

    /* renamed from: w */
    public ai0 m2109w(boolean z) {
        this.f1409l = z;
        return this;
    }

    /* renamed from: x */
    public ai0 m2110x(Snippet snippet) {
        this.f1408k = snippet;
        return this;
    }
}
