package cz.opentree;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.TerminalEmulatorActivity;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.Identity;
import cz.opentree.libssh.adapter.SSHSftp;
import cz.opentree.mi0;
import java.util.UUID;

/* compiled from: SSHSftpTransport.java */
/* loaded from: classes.dex */
public class hi0 extends ji0 {

    /* renamed from: l */
    public SSHSftp f3160l;

    /* renamed from: m */
    public String f3161m;

    /* renamed from: n */
    public String f3162n;

    public hi0(FragmentActivity fragmentActivity, int i, UUID uuid, bi0 bi0Var, int i2, gi0 gi0Var, Connection connection, Identity identity) {
        super(fragmentActivity, i, uuid, bi0Var, i2, gi0Var, connection, identity);
    }

    @Override // cz.opentree.ji0
    /* renamed from: B */
    public void mo3775B() {
        try {
            this.f3160l = this.f3568k.m2859t();
            m5129z();
        } catch (ek0 e) {
            m5127x().m2505D(this, mi0.EnumC1556b.SHELL_FAILED, e.getMessage());
        }
    }

    /* renamed from: D */
    public String m4452D() {
        return this.f3161m;
    }

    /* renamed from: E */
    public String m4453E() {
        return this.f3162n;
    }

    /* renamed from: F */
    public SSHSftp m4454F() {
        return this.f3160l;
    }

    /* renamed from: G */
    public boolean m4455G() {
        SSHSftp sSHSftp = this.f3160l;
        return (sSHSftp == null || sSHSftp.m6218n()) ? false : true;
    }

    /* renamed from: H */
    public void m4456H(String str) {
        this.f3161m = str;
    }

    /* renamed from: I */
    public void m4457I(String str) {
        this.f3162n = str;
    }

    @Override // cz.opentree.ji0, cz.opentree.mi0
    /* renamed from: i */
    public void mo3215i() {
        SSHSftp sSHSftp = this.f3160l;
        if (sSHSftp != null && !sSHSftp.m6218n()) {
            this.f3160l.m6212g();
        }
        super.mo3215i();
    }

    @Override // cz.opentree.mi0
    /* renamed from: l */
    public int mo3507l() {
        SSHSftp sSHSftp = this.f3160l;
        return sSHSftp != null ? sSHSftp.m6214i() : super.mo3507l();
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
        builder2.setContentText(m5124u().getString(R.string.sftp) + ": " + this.f3567j.m5471w());
        builder2.setTicker(m5124u().getString(R.string.app_name) + ": " + m5124u().getString(R.string.connection_failed));
        builder2.setUsesChronometer(false);
        builder2.setAutoCancel(true);
        builder2.setColor(ContextCompat.getColor(m5124u(), R.color.accent_bold));
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
        builder2.setContentText(m5124u().getString(R.string.sftp) + ": " + this.f3567j.m5471w());
        builder2.addAction(R.drawable.ic_clear_normal, m5124u().getString(R.string.disconnect), activity2);
        builder2.setUsesChronometer(true);
        builder2.setDeleteIntent(activity2);
        builder2.setAutoCancel(false);
        builder2.setColor(ContextCompat.getColor(m5124u(), R.color.accent_bold));
        this.f5049a = builder2;
        return builder2;
    }

    @Override // cz.opentree.ji0, cz.opentree.mi0
    /* renamed from: o */
    public boolean mo3216o() {
        return true;
    }
}
