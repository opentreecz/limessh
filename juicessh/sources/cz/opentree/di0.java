package cz.opentree;

import androidx.fragment.app.FragmentActivity;
import com.google.ase.Exec;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.connections.listeners.BasicTransportChainListener;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.Connection;
import cz.opentree.juicessh.models.Identity;
import cz.opentree.juicessh.models.Snippet;
import cz.opentree.mi0;
import jackpal.androidterm.emulatorview.TermSession;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.conn.util.InetAddressUtils;

/* compiled from: MoshTransport.java */
/* loaded from: classes.dex */
public class di0 extends ei0 {

    /* renamed from: w */
    public static String f2178w = "Mosh Server Command";

    /* renamed from: q */
    public AtomicBoolean f2179q;

    /* renamed from: r */
    public ai0 f2180r;

    /* renamed from: s */
    public bi0 f2181s;

    /* renamed from: t */
    public Connection f2182t;

    /* renamed from: u */
    public int f2183u;

    /* renamed from: v */
    public String f2184v;

    /* compiled from: MoshTransport.java */
    /* renamed from: cz.opentree.di0$a */
    /* loaded from: classes.dex */
    public class C0878a implements BasicTransportChainListener {

        /* renamed from: a */
        public final /* synthetic */ bi0 f2185a;

        /* renamed from: b */
        public final /* synthetic */ FragmentActivity f2186b;

        public C0878a(bi0 bi0Var, FragmentActivity fragmentActivity) {
            this.f2185a = bi0Var;
            this.f2186b = fragmentActivity;
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: a */
        public void mo3218a() {
            gj0.m4141b("MoshTransport", "MOSH transport cancelled (SSH phase)");
        }

        @Override // cz.opentree.juicessh.connections.listeners.BasicTransportChainListener
        /* renamed from: b */
        public void mo3219b(int i, UUID uuid) {
            try {
                di0.this.m3217z();
            } catch (C0881d e) {
                int i2 = C0880c.f2189a[e.m3220a().ordinal()];
                if (i2 == 1) {
                    this.f2185a.m2504C(di0.this, mi0.EnumC1556b.COULD_NOT_FIND_MOSH_INSTALLATION);
                    return;
                }
                if (i2 == 2) {
                    this.f2185a.m2504C(di0.this, mi0.EnumC1556b.MOSH_LOCALE_NOT_AVAILABLE);
                    return;
                }
                if (i2 == 3) {
                    this.f2185a.m2504C(di0.this, mi0.EnumC1556b.MOSH_REQUIRES_UTF8_LOCALE);
                    return;
                } else if (i2 == 4) {
                    this.f2185a.m2504C(di0.this, mi0.EnumC1556b.MOSH_SERVER_TIMED_OUT);
                    return;
                } else if (i2 == 5) {
                    this.f2185a.m2504C(di0.this, mi0.EnumC1556b.COULD_NOT_DETECT_MOSH_PORT_KEY);
                    return;
                }
            }
            Exec.setenv("MOSH_KEY", di0.this.f2184v);
            Exec.setenv("TERMINFO", this.f2186b.getFilesDir() + "/terminfo");
            di0.this.m3510s();
        }
    }

    /* compiled from: MoshTransport.java */
    /* renamed from: cz.opentree.di0$b */
    /* loaded from: classes.dex */
    public class RunnableC0879b implements Runnable {
        public RunnableC0879b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; di0.this.f2417n.length > 0 && di0.this.f2417n[0] > 0 && i <= 30000; i += 500) {
                gj0.m4141b("MoshTransport", "Waiting for mosh-client to shutdown nicely...");
                try {
                    Thread.sleep(500L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            di0.super.mo3215i();
        }
    }

    /* compiled from: MoshTransport.java */
    /* renamed from: cz.opentree.di0$c */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0880c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f2189a;

        static {
            int[] iArr = new int[C0881d.a.values().length];
            f2189a = iArr;
            try {
                iArr[C0881d.a.REASON_NOT_INSTALLED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2189a[C0881d.a.LOCALE_NOT_AVAILABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2189a[C0881d.a.UTF8_LOCALE_REQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2189a[C0881d.a.REASON_TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2189a[C0881d.a.REASON_UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: MoshTransport.java */
    /* renamed from: cz.opentree.di0$d */
    /* loaded from: classes.dex */
    public static final class C0881d extends Exception {

        /* renamed from: O */
        public a f2190O;

        /* compiled from: MoshTransport.java */
        /* renamed from: cz.opentree.di0$d$a */
        /* loaded from: classes.dex */
        public enum a {
            REASON_TIMEOUT,
            REASON_NOT_INSTALLED,
            LOCALE_NOT_AVAILABLE,
            UTF8_LOCALE_REQUIRED,
            REASON_UNKNOWN
        }

        public C0881d(a aVar) {
            this.f2190O = aVar;
        }

        /* renamed from: a */
        public a m3220a() {
            return this.f2190O;
        }
    }

    public di0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, Connection connection, Identity identity, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, connection, snippet);
        this.f2183u = 60001;
        this.f2181s = bi0Var;
        this.f2182t = connection;
        this.f2179q = new AtomicBoolean(false);
        if (identity == null) {
            bi0Var.m2504C(this, mi0.EnumC1556b.NO_IDENTITY);
            return;
        }
        try {
            ri0.m7913b(fragmentActivity, "terminfo", R.raw.terminfo);
        } catch (IOException unused) {
            bi0Var.m2504C(this, mi0.EnumC1556b.COULD_NOT_FIND_MOSH_INSTALLATION);
        }
        String str = connection.moshCommand;
        String m5458d = (str == null || str.length() <= 0) ? Config.m5458d("mosh:mosh-server", fragmentActivity) : connection.moshCommand;
        ai0 ai0Var = new ai0(fragmentActivity, connection);
        ai0Var.m2108v(true);
        ai0Var.m2110x(new Snippet(f2178w, m5458d));
        ai0 m2094g = ai0Var.m2094g();
        this.f2180r = m2094g;
        m2094g.m2098l().m2506m(new C0878a(bi0Var, fragmentActivity));
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: c */
    public String mo2813c() {
        return "Mosh: " + this.f2182t.m5471w();
    }

    @Override // cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: d */
    public String mo2814d() {
        return this.f2182t.address;
    }

    @Override // cz.opentree.ei0, cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: e */
    public TermSession mo3213e() {
        super.mo3213e();
        TermSession termSession = this.f2415l;
        if (termSession != null) {
            termSession.setDefaultUTF8Mode(true);
        }
        return this.f2415l;
    }

    @Override // cz.opentree.ei0, cz.opentree.juicessh.connections.transports.TerminalSessionProvider
    /* renamed from: f */
    public String mo3214f() {
        return "xterm-256color";
    }

    @Override // cz.opentree.ei0, cz.opentree.mi0
    /* renamed from: i */
    public void mo3215i() {
        this.f2179q.set(true);
        if (this.f2417n.length > 0) {
            if (this.f2417n[0] > 0) {
                for (int i : this.f2417n) {
                    gj0.m4141b("MoshTransport", "Sending SIGCONT to mosh-client PID " + i);
                    Exec.kill(i, Exec.f1095c);
                    gj0.m4141b("MoshTransport", "Sending SIGTERM to mosh-client PID " + i);
                    Exec.kill(i, Exec.f1094b);
                }
                new Thread(new RunnableC0879b()).start();
            }
        }
    }

    @Override // cz.opentree.ei0, cz.opentree.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        if (this.f2179q.get()) {
            return false;
        }
        return super.mo3216o();
    }

    @Override // cz.opentree.mi0
    /* renamed from: p */
    public boolean mo2816p() {
        return true;
    }

    @Override // cz.opentree.mi0
    /* renamed from: q */
    public boolean mo2817q() {
        return false;
    }

    @Override // cz.opentree.ei0
    /* renamed from: t */
    public String[] mo2818t() {
        String str = this.f2182t.address;
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
            int i = 0;
            char c = 4;
            while (true) {
                if (i >= allByName.length && c != 4) {
                    break;
                }
                if (i == allByName.length) {
                    i = 0;
                    c = 6;
                }
                if (allByName.length == 0) {
                    break;
                }
                if (c != 4 || !(allByName[i] instanceof Inet4Address)) {
                    if (c == 6 && (allByName[i] instanceof Inet6Address)) {
                        str = allByName[i].getHostAddress();
                        break;
                    }
                    i++;
                } else {
                    str = allByName[i].getHostAddress();
                    break;
                }
            }
            if (str == null) {
                gj0.m4142c("MoshTransport", "Host resolution failed: " + this.f2182t.address);
                this.f2181s.m2504C(this, mi0.EnumC1556b.UNKNOWN_HOST);
                return new String[0];
            }
            if (InetAddressUtils.isIPv6Address(str)) {
                gj0.m4142c("MoshTransport", "Detected IPv6 Address: " + str);
            }
            return new String[]{str, String.valueOf(this.f2183u), null};
        } catch (UnknownHostException unused) {
            gj0.m4142c("MoshTransport", "Host resolution failed: " + this.f2182t.address);
            this.f2181s.m2504C(this, mi0.EnumC1556b.UNKNOWN_HOST);
            return new String[0];
        }
    }

    @Override // cz.opentree.ei0
    /* renamed from: u */
    public String mo2819u() {
        return this.f2407d.getApplicationInfo().nativeLibraryDir + "/libcom_sonelli_mosh-client.so";
    }

    /* renamed from: z */
    public final void m3217z() throws C0881d {
        Pattern compile = Pattern.compile("^MOSH CONNECT (\\d+) (\\S+)$");
        Pattern compile2 = Pattern.compile("^The locale requested by");
        Pattern compile3 = Pattern.compile("^mosh-server needs a UTF-8 native locale to run");
        fi0 fi0Var = (fi0) this.f2180r.m2102p();
        new hj0(this.f2407d);
        gj0.m4141b("MoshTransport", "Attempting to detect MOSH port and security key...");
        Scanner scanner = new Scanner(fi0Var.m3776G());
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            Matcher matcher = compile.matcher(nextLine);
            if (matcher.find()) {
                this.f2183u = Integer.valueOf(matcher.group(1)).intValue();
                this.f2184v = matcher.group(2);
            }
            if (compile2.matcher(nextLine).find()) {
                throw new C0881d(C0881d.a.LOCALE_NOT_AVAILABLE);
            }
            if (compile3.matcher(nextLine).find()) {
                throw new C0881d(C0881d.a.UTF8_LOCALE_REQUIRED);
            }
            if (this.f2184v != null) {
                break;
            }
        }
        this.f2180r.m2096i();
        int mo3507l = fi0Var.mo3507l();
        if (mo3507l == 1) {
            throw new C0881d(C0881d.a.REASON_UNKNOWN);
        }
        if (mo3507l == 127) {
            throw new C0881d(C0881d.a.REASON_NOT_INSTALLED);
        }
    }
}
