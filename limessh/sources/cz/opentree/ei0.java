package cz.opentree;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.ase.Exec;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.TerminalEmulatorActivity;
import cz.opentree.limessh.connections.transports.TerminalSessionProvider;
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.kj0;
import cz.opentree.mi0;
import jackpal.androidterm.emulatorview.TermSession;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.UUID;

/* compiled from: ProcessTransport.java */
/* loaded from: classes.dex */
public abstract class ei0 extends mi0 implements TerminalSessionProvider {

    /* renamed from: d */
    public FragmentActivity f2407d;

    /* renamed from: e */
    public int f2408e;

    /* renamed from: f */
    public UUID f2409f;

    /* renamed from: h */
    public Connection f2411h;

    /* renamed from: i */
    public Thread f2412i;

    /* renamed from: j */
    public volatile InputStream f2413j;

    /* renamed from: k */
    public volatile OutputStream f2414k;

    /* renamed from: l */
    public TermSession f2415l;

    /* renamed from: m */
    public Snippet f2416m;

    /* renamed from: o */
    public volatile FileDescriptor f2418o;

    /* renamed from: g */
    public int f2410g = -1;

    /* renamed from: n */
    public volatile int[] f2417n = new int[1];

    /* renamed from: p */
    public boolean f2419p = false;

    /* compiled from: ProcessTransport.java */
    /* renamed from: cz.opentree.ei0$a */
    /* loaded from: classes.dex */
    public class RunnableC0936a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ FragmentActivity f2420O;

        /* renamed from: P */
        public final /* synthetic */ bi0 f2421P;

        /* renamed from: Q */
        public final /* synthetic */ int f2422Q;

        public RunnableC0936a(FragmentActivity fragmentActivity, bi0 bi0Var, int i) {
            this.f2420O = fragmentActivity;
            this.f2421P = bi0Var;
            this.f2422Q = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String str = this.f2420O.getApplicationInfo().nativeLibraryDir;
                gj0.m4141b("LocalTransport", "Settings TERM=" + ei0.this.mo3214f());
                Exec.setenv("TERM", ei0.this.mo3214f());
                gj0.m4141b("LocalTransport", "Setting HOME=" + this.f2420O.getExternalFilesDir(null).getPath());
                Exec.setenv("HOME", this.f2420O.getExternalFilesDir(null).getPath());
                Exec.setenv("ANDROID_VERSION", Build.VERSION.RELEASE);
                Exec.setenv("LIMESSH_VERSION", kj0.m5919c(this.f2420O));
                Exec.setenv("LIMESSH_BIN_DIR", str);
                gj0.m4141b("LocalTransport", "Settings SHELL=" + str);
                Exec.setenv("SHELL", str + "/libcom_sonelli_bash.so");
                gj0.m4141b("LocalTransport", "Setting PS1=" + ei0.this.m3511v());
                Exec.setenv("PS1", ei0.this.m3511v());
                if (!new File(ei0.this.mo2819u()).exists()) {
                    gj0.m4142c("LocalTransport", "Could not find binary " + ei0.this.mo2819u() + " for CPU type " + Build.CPU_ABI);
                    this.f2421P.m2504C(ei0.this, mi0.EnumC1556b.BINARY_NOT_FOUND);
                    return;
                }
                String[] mo2818t = ei0.this.mo2818t();
                if (ei0.this.f2419p) {
                    return;
                }
                ei0 ei0Var = ei0.this;
                ei0Var.f2418o = Exec.createSubprocess(ei0Var.mo2819u(), mo2818t[0], mo2818t[1], mo2818t[2], ei0.this.f2417n);
                ei0.this.f2413j = new FileInputStream(ei0.this.f2418o);
                ei0.this.f2414k = new FileOutputStream(ei0.this.f2418o);
                this.f2421P.m2503B(this.f2422Q, ei0.this);
                ei0 ei0Var2 = ei0.this;
                ei0Var2.f2410g = Exec.waitFor(ei0Var2.f2417n[0]);
                gj0.m4141b("LocalTransport", "Process " + ei0.this.mo2819u() + " (PID:" + ei0.this.f2417n[0] + ") quit with exit code " + ei0.this.f2410g);
                ei0.this.f2417n = new int[1];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ei0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, Connection connection, Snippet snippet) {
        this.f2407d = fragmentActivity;
        this.f2408e = i;
        this.f2409f = uuid;
        this.f2411h = connection;
        this.f2416m = snippet;
        this.f2412i = new Thread(new RunnableC0936a(fragmentActivity, bi0Var, i2));
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: a */
    public void mo3503a(int i, int i2, int i3, int i4) {
        if (Arrays.asList(Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)).contains(0) || this.f2418o == null) {
            return;
        }
        Exec.setPtyWindowSize(this.f2418o, i3, i4, i, i2);
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: b */
    public void mo3504b() {
        if (mo3216o()) {
            gj0.m4141b("LocalTransport", "Sending SIGSTOP signal to process");
            Exec.kill(this.f2417n[0], Exec.f1096d);
        }
    }

    /* renamed from: e */
    public TermSession mo3213e() {
        if (this.f2415l == null) {
            TermSession termSession = new TermSession();
            this.f2415l = termSession;
            termSession.setTermIn(this.f2413j);
            this.f2415l.setTermOut(this.f2414k);
            this.f2415l.setDefaultUTF8Mode(Boolean.parseBoolean(Config.m5458d("terminal:utf8", this.f2407d)));
            Snippet snippet = this.f2416m;
            if (snippet != null) {
                if (!snippet.content.endsWith("\n")) {
                    StringBuilder sb = new StringBuilder();
                    Snippet snippet2 = this.f2416m;
                    sb.append(snippet2.content);
                    sb.append("\n");
                    snippet2.content = sb.toString();
                }
                gj0.m4141b("LocalTransport", "Sending snippet: \n" + this.f2416m.content);
                this.f2415l.write(this.f2416m.content);
            }
        }
        return this.f2415l;
    }

    /* renamed from: f */
    public String mo3214f() {
        return Config.m5458d("terminal:type", this.f2407d);
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: g */
    public void mo3505g() {
        if (mo3216o()) {
            gj0.m4141b("LocalTransport", "Sending SIGCONT signal to process");
            Exec.kill(this.f2417n[0], Exec.f1095c);
        }
    }

    @Override // cz.opentree.mi0
    /* renamed from: h */
    public void mo3506h() {
        this.f2419p = true;
        mo3215i();
    }

    @Override // cz.opentree.mi0
    /* renamed from: i */
    public void mo3215i() {
        if (this.f2417n == null || this.f2417n[0] <= 0) {
            return;
        }
        gj0.m4141b("LocalTransport", "Sending SIGKILL to PID: " + this.f2417n[0]);
        Exec.kill(this.f2417n[0], Exec.f1093a);
    }

    @Override // cz.opentree.mi0
    /* renamed from: k */
    public Connection mo2815k() {
        return this.f2411h;
    }

    @Override // cz.opentree.mi0
    /* renamed from: l */
    public int mo3507l() {
        return this.f2410g;
    }

    @Override // cz.opentree.mi0
    /* renamed from: m */
    public NotificationCompat.Builder mo3508m() {
        NotificationCompat.Builder builder = this.f5050b;
        if (builder != null) {
            return builder;
        }
        Intent intent = new Intent(this.f2407d, (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(603979776);
        intent.setData(Uri.parse("ssh://" + this.f2408e + "/resume"));
        StringBuilder sb = new StringBuilder();
        sb.append("do-not-cache");
        sb.append(System.currentTimeMillis());
        intent.setAction(sb.toString());
        intent.putExtra("session_key", this.f2409f.toString());
        PendingIntent activity = PendingIntent.getActivity(this.f2407d, 0, intent, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.f2407d, "limessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(false);
        builder2.setContentIntent(activity);
        Intent intent2 = new Intent(this.f2407d, (Class<?>) TerminalEmulatorActivity.class);
        intent2.setFlags(603979776);
        intent2.setData(Uri.parse("ssh://" + mo2814d()));
        intent2.putExtra("NOTIFICATION_TO_CANCEL", this.f2408e);
        builder2.addAction(R.drawable.ic_menu_refresh, this.f2407d.getString(R.string.reconnect), PendingIntent.getActivity(this.f2407d, 0, intent2, 0));
        builder2.setContentTitle(this.f2407d.getString(R.string.app_name) + ": " + this.f2407d.getString(R.string.connection_failed));
        builder2.setContentText(mo2813c());
        builder2.setTicker(this.f2407d.getString(R.string.app_name) + ": " + this.f2407d.getString(R.string.connection_failed));
        builder2.setUsesChronometer(false);
        builder2.setAutoCancel(true);
        builder2.setColor(ContextCompat.getColor(this.f2407d, R.color.primary_bold));
        this.f5050b = builder2;
        return builder2;
    }

    @Override // cz.opentree.mi0
    /* renamed from: n */
    public NotificationCompat.Builder mo3509n() {
        NotificationCompat.Builder builder = this.f5049a;
        if (builder != null) {
            return builder;
        }
        Intent intent = new Intent(this.f2407d, (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(603979776);
        intent.setData(Uri.parse("ssh://" + this.f2408e + "/resume"));
        StringBuilder sb = new StringBuilder();
        sb.append("do-not-cache");
        sb.append(System.currentTimeMillis());
        intent.setAction(sb.toString());
        intent.putExtra("session_key", this.f2409f.toString());
        Intent intent2 = new Intent(this.f2407d, (Class<?>) TerminalEmulatorActivity.class);
        intent2.setFlags(1476395008);
        intent2.setData(Uri.parse("ssh://" + this.f2408e + "/disconnect"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("do-not-cache");
        sb2.append(System.currentTimeMillis());
        intent2.setAction(sb2.toString());
        intent2.putExtra("session_key", this.f2409f.toString());
        PendingIntent activity = PendingIntent.getActivity(this.f2407d, 0, intent, 0);
        PendingIntent activity2 = PendingIntent.getActivity(this.f2407d, 0, intent2, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(this.f2407d, "limessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(true);
        builder2.setContentIntent(activity);
        builder2.setContentTitle(this.f2407d.getString(R.string.app_name) + ": " + this.f2407d.getString(R.string.connected));
        builder2.setContentText(mo2813c());
        builder2.addAction(R.drawable.ic_clear_normal, this.f2407d.getString(R.string.disconnect), activity2);
        builder2.setUsesChronometer(true);
        builder2.setDeleteIntent(activity2);
        builder2.setAutoCancel(false);
        builder2.setColor(ContextCompat.getColor(this.f2407d, R.color.primary_bold));
        this.f5049a = builder2;
        return builder2;
    }

    @Override // cz.opentree.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        return this.f2417n != null && this.f2417n[0] > 0;
    }

    /* renamed from: s */
    public void m3510s() {
        this.f2412i.start();
    }

    /* renamed from: t */
    public abstract String[] mo2818t();

    /* renamed from: u */
    public abstract String mo2819u() throws kj0.C1460a;

    /* renamed from: v */
    public String m3511v() {
        return "\\w\\$ ";
    }
}
