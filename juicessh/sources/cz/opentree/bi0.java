package cz.opentree;

import android.R;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cz.opentree.limessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.limessh.connections.transports.ConnectionProvider;
import cz.opentree.limessh.connections.transports.ForwardTransport;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.PortForward;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.mi0;
import cz.opentree.util.RetryPrompt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TransportChainFactory.java */
/* loaded from: classes.dex */
public abstract class bi0 {

    /* renamed from: a */
    public FragmentActivity f1711a;

    /* renamed from: b */
    public int f1712b;

    /* renamed from: c */
    public UUID f1713c;

    /* renamed from: d */
    public Dialog f1714d;

    /* renamed from: e */
    public TextView f1715e;

    /* renamed from: f */
    public TextView f1716f;

    /* renamed from: g */
    public BroadcastReceiver f1717g;

    /* renamed from: h */
    public boolean f1718h;

    /* renamed from: i */
    public Snippet f1719i;

    /* renamed from: j */
    public boolean f1720j;

    /* renamed from: l */
    public ArrayList<ConnectionProvider> f1722l;

    /* renamed from: o */
    public RetryPrompt f1725o;

    /* renamed from: k */
    public AtomicBoolean f1721k = new AtomicBoolean(false);

    /* renamed from: m */
    public ArrayList<mi0> f1723m = new ArrayList<>();

    /* renamed from: n */
    public ArrayList<BasicTransportChainListener> f1724n = new ArrayList<>();

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$a */
    /* loaded from: classes.dex */
    public class RunnableC0772a implements Runnable {

        /* compiled from: TransportChainFactory.java */
        /* renamed from: cz.opentree.bi0$a$a */
        /* loaded from: classes.dex */
        public class a extends BroadcastReceiver {
            public a() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String stringExtra = intent.getStringExtra("message");
                if (stringExtra == null || stringExtra.length() <= 0) {
                    return;
                }
                bi0.this.f1716f.append(stringExtra + "\n");
            }
        }

        /* compiled from: TransportChainFactory.java */
        /* renamed from: cz.opentree.bi0$a$b */
        /* loaded from: classes.dex */
        public class b implements DialogInterface.OnCancelListener {
            public b() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                bi0.this.m2511r();
            }
        }

        public RunnableC0772a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bi0.this.f1714d = new Dialog(bi0.this.f1711a, R.style.Theme.Black.NoTitleBar);
            bi0.this.f1714d.setContentView(cz.opentree.limessh.R.layout.connecting);
            bi0 bi0Var = bi0.this;
            bi0Var.f1715e = (TextView) bi0Var.f1714d.findViewById(cz.opentree.limessh.R.id.subtitle);
            bi0 bi0Var2 = bi0.this;
            bi0Var2.f1716f = (TextView) bi0Var2.f1714d.findViewById(cz.opentree.limessh.R.id.log_text);
            bi0.this.f1717g = new a();
            bi0.this.f1714d.setCancelable(true);
            bi0.this.f1714d.setOnCancelListener(new b());
            bi0.this.f1714d.show();
            LocalBroadcastManager.getInstance(bi0.this.f1711a).registerReceiver(bi0.this.f1717g, new IntentFilter("cz.opentree.limessh.logs.ssh"));
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$b */
    /* loaded from: classes.dex */
    public class RunnableC0773b implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ PortForward f1729O;

        public RunnableC0773b(PortForward portForward) {
            this.f1729O = portForward;
        }

        @Override // java.lang.Runnable
        public void run() {
            bi0.this.f1715e.setText(this.f1729O.connection.m5471w());
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$c */
    /* loaded from: classes.dex */
    public class RunnableC0774c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Connection f1731O;

        public RunnableC0774c(Connection connection) {
            this.f1731O = connection;
        }

        @Override // java.lang.Runnable
        public void run() {
            bi0.this.f1715e.setText(this.f1731O.m5471w());
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$d */
    /* loaded from: classes.dex */
    public class RunnableC0775d implements Runnable {
        public RunnableC0775d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                bi0.this.f1714d.dismiss();
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$e */
    /* loaded from: classes.dex */
    public class RunnableC0776e implements Runnable {
        public RunnableC0776e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                bi0.this.f1714d.dismiss();
            } catch (IllegalArgumentException unused) {
            }
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$f */
    /* loaded from: classes.dex */
    public class RunnableC0777f implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ String f1735O;

        /* compiled from: TransportChainFactory.java */
        /* renamed from: cz.opentree.bi0$f$a */
        /* loaded from: classes.dex */
        public class a implements RetryPrompt.RetryPromptListener {
            public a() {
            }

            @Override // cz.opentree.util.RetryPrompt.RetryPromptListener
            /* renamed from: a */
            public void mo2520a() {
                gj0.m4141b("TransportChainFactory", "Retrying transport chain " + bi0.this.f1712b + " at users request");
                bi0.this.m2517x();
            }

            @Override // cz.opentree.util.RetryPrompt.RetryPromptListener
            public void onCancel() {
                gj0.m4141b("TransportChainFactory", "Cancelling transport chain " + bi0.this.f1712b + " as user declined retry");
                bi0.this.m2511r();
            }
        }

        public RunnableC0777f(String str) {
            this.f1735O = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (bi0.this.f1725o == null) {
                bi0.this.f1725o = new RetryPrompt(bi0.this.f1711a, new a());
            }
            bi0.this.f1725o.m9295h(this.f1735O + "\n\n" + bi0.this.f1711a.getString(cz.opentree.limessh.R.string.do_you_want_to_retry));
            bi0.this.f1725o.show();
        }
    }

    /* compiled from: TransportChainFactory.java */
    /* renamed from: cz.opentree.bi0$g */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0778g {

        /* renamed from: a */
        public static final /* synthetic */ int[] f1738a;

        static {
            int[] iArr = new int[mi0.EnumC1556b.values().length];
            f1738a = iArr;
            try {
                iArr[mi0.EnumC1556b.INCORRECT_PRIVATE_KEY_PASSPHRASE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1738a[mi0.EnumC1556b.AUTHENTICATION_FAILED_PASSWORD_AVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1738a[mi0.EnumC1556b.AUTHENTICATION_FAILURE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1738a[mi0.EnumC1556b.NO_IDENTITY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public bi0(FragmentActivity fragmentActivity, int i, UUID uuid, ArrayList<ConnectionProvider> arrayList, boolean z, Snippet snippet) {
        this.f1720j = z;
        this.f1719i = snippet;
        m2507n(fragmentActivity, i, uuid, arrayList);
    }

    /* renamed from: A */
    public void mo2111A(ArrayList<mi0> arrayList) {
        try {
            if (!this.f1711a.isFinishing()) {
                LocalBroadcastManager.getInstance(this.f1711a).unregisterReceiver(this.f1717g);
            }
        } catch (IllegalArgumentException unused) {
        }
        this.f1711a.runOnUiThread(new RunnableC0776e());
        Iterator<BasicTransportChainListener> it = this.f1724n.iterator();
        while (it.hasNext()) {
            it.next().mo3219b(this.f1712b, this.f1713c);
        }
        ConnectionProvider connectionProvider = this.f1722l.get(r4.size() - 1);
        sj0.m8455a(this.f1711a, connectionProvider.mo5368g(), connectionProvider, ai0.f1395n);
        qi0.m7716c(this.f1711a).m7717a("Session Statistics", connectionProvider.mo5368g().m5469u(), "CONNECTION_SUCCESSFUL");
    }

    /* renamed from: B */
    public void m2503B(int i, mi0 mi0Var) {
        if (this.f1721k.get()) {
            mi0Var.mo3506h();
            return;
        }
        this.f1723m.add(mi0Var);
        if (this.f1723m.size() < this.f1722l.size()) {
            m2509p(i + 1);
        } else {
            mo2111A(this.f1723m);
        }
    }

    /* renamed from: C */
    public void m2504C(mi0 mi0Var, mi0.EnumC1556b enumC1556b) {
        m2505D(mi0Var, enumC1556b, this.f1711a.getString(mi0.f5048c.get(enumC1556b).intValue()));
    }

    /* renamed from: D */
    public void m2505D(mi0 mi0Var, mi0.EnumC1556b enumC1556b, String str) {
        mi0Var.mo3506h();
        if (enumC1556b == null) {
            enumC1556b = mi0.EnumC1556b.UNKNOWN;
        }
        gj0.m4142c("TransportChainFactory", "Transport failed: " + enumC1556b.toString());
        ConnectionProvider connectionProvider = this.f1722l.get(this.f1723m.size());
        Identity m5470v = connectionProvider.mo5368g().m5470v(this.f1711a);
        qi0.m7716c(this.f1711a).m7717a("Session Statistics", connectionProvider.mo5368g().m5469u(), enumC1556b.toString());
        int i = C0778g.f1738a[enumC1556b.ordinal()];
        if (i == 1) {
            ki0.m5912b(this.f1711a, m5470v, this);
            return;
        }
        if (i == 2) {
            ki0.m5911a(this.f1711a, m5470v, this);
            return;
        }
        if (i == 3) {
            m2515v(this.f1711a.getString(cz.opentree.limessh.R.string.authentication_failure));
        } else if (i != 4) {
            m2515v(str);
        } else {
            ki0.m5913c(this.f1711a, mi0Var.mo2815k(), connectionProvider, this);
        }
    }

    /* renamed from: m */
    public void m2506m(BasicTransportChainListener basicTransportChainListener) {
        this.f1724n.add(basicTransportChainListener);
    }

    /* renamed from: n */
    public final void m2507n(FragmentActivity fragmentActivity, int i, UUID uuid, ArrayList<ConnectionProvider> arrayList) {
        this.f1711a = fragmentActivity;
        this.f1712b = i;
        this.f1713c = uuid;
        this.f1722l = arrayList;
    }

    /* renamed from: o */
    public void m2508o() {
        this.f1711a.runOnUiThread(new RunnableC0772a());
        m2509p(0);
    }

    /* renamed from: p */
    public final void m2509p(int i) {
        m2510q(i, this.f1722l.get(i).mo5368g().m5470v(this.f1711a));
    }

    /* renamed from: q */
    public final void m2510q(int i, Identity identity) {
        String str;
        if (!this.f1721k.get() && this.f1722l.size() >= i + 1) {
            gj0.m4141b("TransportChainFactory", "Building chain member " + i);
            ConnectionProvider connectionProvider = this.f1722l.get(i);
            gi0 gi0Var = null;
            if (i > 0) {
                int i2 = i - 1;
                if (this.f1723m.get(i2) instanceof ForwardTransport) {
                    gi0Var = (gi0) this.f1723m.get(i2);
                }
            }
            gi0 gi0Var2 = gi0Var;
            if (connectionProvider instanceof PortForward) {
                gj0.m4141b("TransportChainFactory", "Chain member " + i + " is a port forward transport");
                PortForward portForward = (PortForward) connectionProvider;
                portForward.connection.m5383m();
                if (portForward.connection != null) {
                    this.f1715e.postDelayed(new RunnableC0773b(portForward), 0L);
                }
                new gi0(this.f1711a, this.f1712b, this.f1713c, this, i, gi0Var2, portForward, identity);
                return;
            }
            Connection mo5368g = connectionProvider.mo5368g();
            TextView textView = this.f1715e;
            if (textView != null) {
                textView.postDelayed(new RunnableC0774c(mo5368g), 0L);
            }
            int i3 = mo5368g.type;
            if (i3 == 0) {
                if (i == this.f1722l.size() - 1) {
                    if (this.f1720j) {
                        new hi0(this.f1711a, this.f1712b, this.f1713c, this, i, gi0Var2, mo5368g, identity);
                        return;
                    } else {
                        new ii0(this.f1711a, this.f1712b, this.f1713c, this, i, gi0Var2, mo5368g, identity, this.f1719i);
                        return;
                    }
                }
                gj0.m4141b("TransportChainFactory", "Chain member " + i + " is an SSHForward transport");
                new gi0(this.f1711a, this.f1712b, this.f1713c, this, i, gi0Var2, mo5368g, identity);
                return;
            }
            if (i3 != 1) {
                if (i3 == 2) {
                    gj0.m4141b("TransportChainFactory", "Chain member " + i + " is a local transport");
                    new ci0(this.f1711a, this.f1712b, this.f1713c, this, i, mo5368g, this.f1719i);
                    return;
                }
                if (i3 != 3) {
                    return;
                }
                gj0.m4141b("TransportChainFactory", "Chain member " + i + " is a telnet connection");
                new li0(this.f1711a, this.f1712b, this.f1713c, this, i, mo5368g, this.f1719i);
                return;
            }
            Snippet snippet = this.f1719i;
            if (snippet == null || (str = snippet.name) == null || !str.equals(di0.f2178w)) {
                gj0.m4141b("TransportChainFactory", "Chain member " + i + " is a MOSH transport");
                new di0(this.f1711a, this.f1712b, this.f1713c, this, i, mo5368g, identity, this.f1719i);
                return;
            }
            gj0.m4141b("TransportChainFactory", "Chain member " + i + " is a MOSH transport (SSH phase)");
            new fi0(this.f1711a, this.f1712b, this.f1713c, this, i, gi0Var2, mo5368g, identity, this.f1719i);
        }
    }

    /* renamed from: r */
    public void m2511r() {
        m2512s();
        try {
            LocalBroadcastManager.getInstance(this.f1711a).unregisterReceiver(this.f1717g);
        } catch (IllegalArgumentException unused) {
        }
        Iterator<BasicTransportChainListener> it = this.f1724n.iterator();
        while (it.hasNext()) {
            it.next().mo3218a();
        }
    }

    /* renamed from: s */
    public void m2512s() {
        this.f1721k.set(true);
        Iterator<mi0> it = this.f1723m.iterator();
        while (it.hasNext()) {
            it.next().mo3215i();
        }
        this.f1711a.runOnUiThread(new RunnableC0775d());
    }

    /* renamed from: t */
    public void m2513t() {
        this.f1724n.clear();
    }

    /* renamed from: u */
    public boolean m2514u() {
        return this.f1718h;
    }

    /* renamed from: v */
    public final void m2515v(String str) {
        if (this.f1711a.isFinishing()) {
            m2511r();
        } else {
            this.f1711a.runOnUiThread(new RunnableC0777f(str));
        }
    }

    /* renamed from: w */
    public void m2516w() {
        m2512s();
        this.f1723m.clear();
        this.f1721k.set(false);
    }

    /* renamed from: x */
    public void m2517x() {
        gj0.m4142c("TransportChainFactory", "Resuming transport chain build: " + this.f1712b);
        gj0.m4142c("TransportChainFactory", "Number of transports in chain: " + this.f1723m.size());
        Iterator<mi0> it = this.f1723m.iterator();
        while (it.hasNext()) {
            mi0 next = it.next();
            if (next.mo2815k() != null) {
                int i = next.mo2815k().port > 0 ? next.mo2815k().port : 0;
                gj0.m4142c("TransportChainFactory", "Transport: " + (next.mo2815k().address != null ? next.mo2815k().address : "") + ":" + i);
            }
        }
        m2509p(this.f1723m.size());
    }

    /* renamed from: y */
    public void m2518y(Identity identity) {
        m2510q(this.f1723m.size(), identity);
    }

    /* renamed from: z */
    public void m2519z(boolean z) {
        this.f1718h = z;
    }
}
