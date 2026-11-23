package com.sonelli;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.sonelli.juicessh.R;
import com.sonelli.juicessh.activities.TerminalEmulatorActivity;
import com.sonelli.juicessh.connections.transports.ForwardTransport;
import com.sonelli.juicessh.models.Connection;
import com.sonelli.juicessh.models.Identity;
import com.sonelli.juicessh.models.PortForward;
import com.sonelli.libssh.adapter.SSHPortForward;
import com.sonelli.mi0;
import java.io.IOException;
import java.util.UUID;

/* compiled from: SSHForwardTransport.java */
/* loaded from: classes.dex */
public class gi0 extends ji0 implements ForwardTransport {

    /* renamed from: l */
    public PortForward f2876l;

    /* renamed from: m */
    public FragmentActivity f2877m;

    /* renamed from: n */
    public SSHPortForward f2878n;

    /* renamed from: o */
    public int f2879o;

    public gi0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, Connection connection, Identity identity) {
        super(fragmentActivity, i, uuid, bi0Var, i2, gi0Var, connection, identity);
        this.f2879o = -1;
        this.f2877m = fragmentActivity;
        this.f3567j = connection;
    }

    public gi0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, PortForward portForward, Identity identity) {
        super(fragmentActivity, i, uuid, bi0Var, i2, gi0Var, portForward.connection.m5383m(), identity);
        this.f2879o = -1;
        this.f2877m = fragmentActivity;
        this.f2876l = portForward;
        this.f3567j = portForward.connection.m5383m();
    }

    @Override // com.sonelli.ji0
    /* renamed from: B */
    public void mo3775B() {
        if (this.f3568k.m2847h()) {
            PortForward portForward = this.f2876l;
            if (portForward != null) {
                try {
                    int i = portForward.mode;
                    if (i == 0) {
                        this.f2878n = this.f3568k.m2848i(portForward.localPort, portForward.host, portForward.remotePort);
                    } else if (i == 1) {
                        this.f2878n = this.f3568k.m2850k(portForward.localPort, portForward.host, portForward.remotePort);
                    } else if (i == 2) {
                        this.f2878n = this.f3568k.m2861v(portForward.localPort);
                    }
                } catch (ek0 e) {
                    gj0.m4142c("SSHTransport", "Failed to create port forward: " + e.getMessage());
                    m5127x().m2504C(this, mi0.EnumC1556b.FAILED_TO_INITIATE_SSH_TRANSPORT);
                    return;
                }
            }
            m5129z();
        } else {
            m5127x().m2504C(this, mi0.EnumC1556b.FAILED_TO_INITIATE_SSH_TRANSPORT);
        }
        SSHPortForward sSHPortForward = this.f2878n;
        if (sSHPortForward != null) {
            try {
                sSHPortForward.start();
            } catch (ek0 e2) {
                gj0.m4142c("SSHTransport", e2.getMessage());
            }
        }
    }

    /* renamed from: D */
    public int m4138D(String str, int i) throws ForwardTransport.C1322a {
        if (this.f3568k == null) {
            throw new ForwardTransport.C1322a("Session isn't connected", Thread.currentThread().getStackTrace());
        }
        try {
            int m5369a = ForwardTransport.C1323b.m5369a();
            this.f2878n = this.f3568k.m2848i(m5369a, str, i);
            this.f2879o = m5369a;
            gj0.m4141b("SSHTransport", "Added local port forward: " + m5369a + " -> " + str + ":" + i);
            return m5369a;
        } catch (ek0 e) {
            gj0.m4142c("SSHTransport", "Failed to create port forward for connect-via: " + e.getMessage());
            throw new ForwardTransport.C1322a(e.getMessage(), e.getStackTrace());
        } catch (IOException e2) {
            throw new ForwardTransport.C1322a(e2.getMessage(), e2.getStackTrace());
        }
    }

    /* renamed from: E */
    public int m4139E() {
        return this.f2879o;
    }

    @Override // com.sonelli.ji0, com.sonelli.mi0
    /* renamed from: i */
    public void mo3215i() {
        SSHPortForward sSHPortForward;
        if (this.f3568k == null) {
            return;
        }
        if (this.f2876l != null && (sSHPortForward = this.f2878n) != null) {
            sSHPortForward.close();
        }
        super.mo3215i();
    }

    @Override // com.sonelli.ji0, com.sonelli.mi0
    /* renamed from: k */
    public Connection mo2815k() {
        return this.f3567j;
    }

    @Override // com.sonelli.mi0
    /* renamed from: m */
    public NotificationCompat.Builder mo3508m() {
        if (this.f2876l == null) {
            return null;
        }
        NotificationCompat.Builder builder = this.f5050b;
        if (builder != null) {
            return builder;
        }
        Intent intent = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(603979776);
        intent.setData(Uri.parse("ssh://" + this.f2876l.f3993id.toString()));
        intent.putExtra("NOTIFICATION_TO_CANCEL", m5125v() + RecyclerView.MAX_SCROLL_DURATION);
        PendingIntent activity = PendingIntent.getActivity(m5124u(), 0, intent, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(m5124u(), "juicessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(false);
        builder2.addAction(R.drawable.ic_menu_refresh, m5124u().getString(R.string.reconnect), activity);
        builder2.setContentTitle(m5124u().getString(R.string.app_name) + ": " + this.f2876l.name);
        builder2.setContentText(m5124u().getString(R.string.connection_failed));
        builder2.setColor(ContextCompat.getColor(this.f2877m, R.color.accent_bold));
        builder2.setContentIntent(PendingIntent.getActivity(m5124u(), 0, new Intent(), 0));
        builder2.setTicker(m5124u().getString(R.string.app_name) + ": " + m5124u().getString(R.string.connection_failed));
        builder2.setUsesChronometer(false);
        builder2.setAutoCancel(true);
        this.f5049a = null;
        this.f5050b = builder2;
        return builder2;
    }

    @Override // com.sonelli.mi0
    /* renamed from: n */
    public NotificationCompat.Builder mo3509n() {
        if (this.f2876l == null) {
            return null;
        }
        NotificationCompat.Builder builder = this.f5049a;
        if (builder != null) {
            return builder;
        }
        Intent intent = new Intent(m5124u(), (Class<?>) TerminalEmulatorActivity.class);
        intent.setFlags(1476395008);
        intent.setData(Uri.parse("ssh://" + m5125v() + "/disconnect"));
        StringBuilder sb = new StringBuilder();
        sb.append("do-not-cache");
        sb.append(System.currentTimeMillis());
        intent.setAction(sb.toString());
        intent.putExtra("session_key", m5126w().toString());
        PendingIntent activity = PendingIntent.getActivity(m5124u(), 0, intent, 0);
        NotificationCompat.Builder builder2 = new NotificationCompat.Builder(m5124u(), "juicessh");
        builder2.setSmallIcon(R.drawable.ic_notification);
        builder2.setWhen(System.currentTimeMillis());
        builder2.setOngoing(true);
        builder2.setContentTitle(m5124u().getString(R.string.app_name) + ": " + this.f2876l.name);
        builder2.setContentText(this.f2876l.m5495t(m5124u()));
        builder2.addAction(R.drawable.ic_clear_normal, m5124u().getString(R.string.disconnect), activity);
        builder2.setUsesChronometer(true);
        builder2.setDeleteIntent(activity);
        builder2.setAutoCancel(false);
        builder2.setColor(ContextCompat.getColor(this.f2877m, R.color.accent_bold));
        if (this.f2876l.openInBrowser.booleanValue()) {
            String str = "http://localhost:" + this.f2876l.localPort;
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str));
            intent2.setFlags(1074266112);
            builder2.setContentIntent(PendingIntent.getActivity(m5124u(), 0, intent2, 0));
        } else {
            builder2.setContentIntent(PendingIntent.getActivity(m5124u(), 0, new Intent(), 0));
        }
        this.f5050b = null;
        this.f5049a = builder2;
        return builder2;
    }

    @Override // com.sonelli.ji0, com.sonelli.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        if (this.f2878n != null) {
            return !r0.isClosed();
        }
        return false;
    }
}
