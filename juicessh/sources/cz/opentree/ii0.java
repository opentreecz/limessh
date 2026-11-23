package cz.opentree;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.TerminalEmulatorActivity;
import cz.opentree.limessh.connections.transports.TerminalSessionProvider;
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.mi0;
import jackpal.androidterm.emulatorview.TermSession;
import java.util.UUID;

/* compiled from: SSHShellTransport.java */
/* loaded from: classes.dex */
public class ii0 extends ji0 implements TerminalSessionProvider {

    /* renamed from: l */
    public FragmentActivity f3325l;

    /* renamed from: m */
    public mk0 f3326m;

    /* renamed from: n */
    public TermSession f3327n;

    /* renamed from: o */
    public Snippet f3328o;

    /* compiled from: SSHShellTransport.java */
    /* renamed from: cz.opentree.ii0$a */
    /* loaded from: classes.dex */
    public class RunnableC1162a implements Runnable {
        public RunnableC1162a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ii0.this.f3328o == null || ii0.this.f3328o.content == null) {
                return;
            }
            if (!ii0.this.f3328o.content.endsWith("\n")) {
                StringBuilder sb = new StringBuilder();
                Snippet snippet = ii0.this.f3328o;
                sb.append(snippet.content);
                sb.append("\n");
                snippet.content = sb.toString();
            }
            gj0.m4141b("SSHShellTransport", "Sending snippet: \n" + ii0.this.f3328o.content);
            ii0.this.f3327n.write(ii0.this.f3328o.content);
        }
    }

    public ii0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, Connection connection, Identity identity, Snippet snippet) {
        super(fragmentActivity, i, uuid, bi0Var, i2, gi0Var, connection, identity);
        this.f3325l = fragmentActivity;
        this.f3328o = snippet;
    }

    @Override // cz.opentree.ji0
    /* renamed from: B */
    public void mo3775B() {
        try {
            this.f3326m = this.f3568k.m2860u(Config.m5458d("terminal:type", m5124u()), 84, 48);
            m5129z();
        } catch (ek0 e) {
            m5127x().m2505D(this, mi0.EnumC1556b.SHELL_FAILED, e.getMessage());
        }
    }

    /* renamed from: F */
    public final TermSession m4783F() {
        gj0.m4141b("SSHShellTransport", "Creating Terminal Session");
        TermSession termSession = new TermSession();
        this.f3327n = termSession;
        termSession.setTermIn(this.f3326m.m2549d());
        this.f3327n.setTermOut(this.f3326m.m2548c());
        this.f3327n.setDefaultUTF8Mode(Boolean.parseBoolean(Config.m5458d("terminal:utf8", m5124u())));
        new Handler().postDelayed(new RunnableC1162a(), 250L);
        return this.f3327n;
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: a */
    public void mo3503a(int i, int i2, int i3, int i4) {
        mk0 mk0Var = this.f3326m;
        if (mk0Var != null) {
            try {
                mk0Var.m6444f(i4, i3);
            } catch (ek0 unused) {
                gj0.m4142c("SSHShellTransport", String.format("Could not resize PTY to columns:%d rows:%d", Integer.valueOf(i4), Integer.valueOf(i3)));
            }
        }
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: b */
    public void mo3504b() {
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: c */
    public String mo2813c() {
        return "SSH: " + this.f3567j.m5471w();
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: d */
    public String mo2814d() {
        return this.f3567j.address;
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: e */
    public TermSession mo3213e() {
        if (this.f3327n == null) {
            this.f3327n = m4783F();
        }
        return this.f3327n;
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: f */
    public String mo3214f() {
        return Config.m5458d("terminal:type", this.f3325l);
    }

    @Override // cz.opentree.limessh.connections.transports.TerminalSessionProvider
    /* renamed from: g */
    public void mo3505g() {
    }

    @Override // cz.opentree.ji0, cz.opentree.mi0
    /* renamed from: i */
    public void mo3215i() {
        TermSession termSession = this.f3327n;
        if (termSession != null) {
            termSession.finish();
        }
        super.mo3215i();
    }

    @Override // cz.opentree.mi0
    /* renamed from: l */
    public int mo3507l() {
        mk0 mk0Var = this.f3326m;
        return mk0Var != null ? mk0Var.m2547b() : super.mo3507l();
    }

    @Override // cz.opentree.mi0
    /* renamed from: m */
    public NotificationCompat.Builder mo3508m() {
        NotificationCompat.Builder builder = this.f5050b;
        if (builder != null) {
            return builder;
        }
        Intent intent = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(603979776);
        intent.setData(Uri.parse("ssh://" + m5125v() + "/resume"));
        StringBuilder sb = new StringBuilder();
        sb.append("do-not-cache");
        sb.append(System.currentTimeMillis());
        intent.setAction(sb.toString());
        intent.putExtra("session_key", m5126w().toString());
        PendingIntent activity = PendingIntent.getActivity(m5124u(), 0, intent, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(m5124u(), "juicessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(false);
        builder2.setContentIntent(activity);
        Intent intent2 = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent2.setFlags(603979776);
        intent2.setData(Uri.parse("ssh://" + this.f3567j.f3993id.toString()));
        intent2.putExtra("NOTIFICATION_TO_CANCEL", m5125v());
        builder2.addAction(R.drawable.ic_menu_refresh, m5124u().getString(R.string.reconnect), PendingIntent.getActivity(m5124u(), 0, intent2, 0));
        builder2.setContentTitle(m5124u().getString(R.string.app_name) + ": " + m5124u().getString(R.string.connection_failed));
        builder2.setContentText(mo2813c());
        builder2.setTicker(m5124u().getString(R.string.app_name) + ": " + m5124u().getString(R.string.connection_failed));
        builder2.setUsesChronometer(false);
        builder2.setAutoCancel(true);
        builder2.setColor(ContextCompat.getColor(this.f3325l, R.color.primary_bold));
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
        Intent intent = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(603979776);
        intent.setData(Uri.parse("ssh://" + m5125v() + "/resume"));
        StringBuilder sb = new StringBuilder();
        sb.append("do-not-cache");
        sb.append(System.currentTimeMillis());
        intent.setAction(sb.toString());
        intent.putExtra("session_key", m5126w().toString());
        Intent intent2 = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent2.setFlags(1476395008);
        intent2.setData(Uri.parse("ssh://" + m5125v() + "/disconnect"));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("do-not-cache");
        sb2.append(System.currentTimeMillis());
        intent2.setAction(sb2.toString());
        intent2.putExtra("session_key", m5126w().toString());
        PendingIntent activity = PendingIntent.getActivity(m5124u(), 0, intent, 0);
        PendingIntent activity2 = PendingIntent.getActivity(m5124u(), 0, intent2, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(m5124u(), "juicessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(true);
        builder2.setContentIntent(activity);
        builder2.setContentTitle(m5124u().getString(R.string.app_name) + ": " + m5124u().getString(R.string.connected));
        builder2.setContentText(mo2813c());
        builder2.addAction(R.drawable.ic_clear_normal, m5124u().getString(R.string.disconnect), activity2);
        builder2.setUsesChronometer(true);
        builder2.setDeleteIntent(activity2);
        builder2.setAutoCancel(false);
        builder2.setColor(ContextCompat.getColor(this.f3325l, R.color.primary_bold));
        this.f5049a = builder2;
        return builder2;
    }

    @Override // cz.opentree.ji0, cz.opentree.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        mk0 mk0Var = this.f3326m;
        if (mk0Var == null || mk0Var.mo2550e()) {
            return false;
        }
        return super.mo3216o();
    }
}
