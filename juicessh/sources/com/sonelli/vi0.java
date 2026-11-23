package com.sonelli;

import android.R;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import com.sonelli.wi0;
import java.util.Map;
import java.util.UUID;

/* compiled from: MultiTransferNotificationManager.java */
/* loaded from: classes.dex */
public class vi0 {

    /* renamed from: a */
    public int f7464a;

    /* renamed from: b */
    public Context f7465b;

    /* renamed from: c */
    public int f7466c;

    /* renamed from: d */
    public NotificationManager f7467d;

    /* renamed from: e */
    public String f7468e;

    /* renamed from: f */
    public int f7469f;

    /* renamed from: g */
    public SparseArray<Map.Entry<String, String>> f7470g = new SparseArray<>();

    /* renamed from: h */
    public SparseArray<Map.Entry<String, String>> f7471h = new SparseArray<>();

    /* renamed from: i */
    public SparseArray<Map.Entry<String, String>> f7472i = new SparseArray<>();

    /* renamed from: j */
    public SparseArray<Map.Entry<String, String>> f7473j = new SparseArray<>();

    /* renamed from: k */
    public int f7474k = wi0.m9569b(UUID.randomUUID(), wi0.EnumC2225a.NOTIFICATION_SFTP_TRANSFER);

    /* renamed from: l */
    public NotificationCompat.Builder f7475l;

    public vi0(Context context, int i, int i2, String str, int i3, String str2) {
        this.f7465b = context;
        this.f7464a = i;
        this.f7466c = i2;
        this.f7468e = str;
        this.f7469f = i3;
        this.f7467d = (NotificationManager) context.getSystemService("notification");
    }

    /* renamed from: a */
    public void m9227a(int i, Map.Entry<String, String> entry) {
        this.f7471h.put(i, entry);
    }

    /* renamed from: b */
    public void m9228b(int i, Map.Entry<String, String> entry) {
        this.f7470g.put(i, entry);
    }

    /* renamed from: c */
    public final synchronized NotificationCompat.Builder m9229c() {
        NotificationCompat.Builder builder = this.f7475l;
        if (builder != null) {
            return builder;
        }
        NotificationCompat.Builder autoCancel = new NotificationCompat.Builder(this.f7465b).setSmallIcon(this.f7464a == 0 ? R.drawable.stat_sys_download : R.drawable.stat_sys_upload).setContentTitle(this.f7465b.getString(this.f7464a == 0 ? com.sonelli.juicessh.R.string.sftp_download : com.sonelli.juicessh.R.string.sftp_upload)).setContentText(this.f7468e).setAutoCancel(false);
        this.f7475l = autoCancel;
        autoCancel.setWhen(System.currentTimeMillis()).setUsesChronometer(true).setOngoing(true);
        this.f7475l.addAction(com.sonelli.juicessh.R.drawable.ic_clear_normal, this.f7465b.getString(com.sonelli.juicessh.R.string.cancel), m9230d());
        this.f7475l.addAction(R.drawable.ic_media_pause, this.f7465b.getString(com.sonelli.juicessh.R.string.pause), m9234h());
        return this.f7475l;
    }

    /* renamed from: d */
    public final PendingIntent m9230d() {
        return PendingIntent.getBroadcast(this.f7465b, (int) System.currentTimeMillis(), new Intent("com.sonelli.juicessh.action.SFTP_CANCEL", Uri.parse("sftpservice://" + this.f7466c)), 0);
    }

    /* renamed from: e */
    public final synchronized NotificationCompat.Builder m9231e(boolean z) {
        NotificationCompat.Builder usesChronometer;
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this.f7465b).setSmallIcon(R.drawable.ic_menu_close_clear_cancel);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7465b.getString(z ? com.sonelli.juicessh.R.string.cancelled : com.sonelli.juicessh.R.string.failed));
        sb.append(": ");
        sb.append(this.f7465b.getString(this.f7464a == 0 ? com.sonelli.juicessh.R.string.sftp_download : com.sonelli.juicessh.R.string.sftp_upload));
        usesChronometer = smallIcon.setContentTitle(sb.toString()).setContentInfo(String.format("%" + m9237k() + "d/%d", Integer.valueOf(m9233g()), Integer.valueOf(this.f7469f))).setContentText(this.f7468e).setUsesChronometer(false);
        usesChronometer.addAction(R.drawable.ic_menu_info_details, this.f7465b.getString(com.sonelli.juicessh.R.string.details), m9238l());
        return usesChronometer;
    }

    /* renamed from: f */
    public final int m9232f() {
        return this.f7472i.size() + this.f7470g.size();
    }

    /* renamed from: g */
    public final int m9233g() {
        return this.f7473j.size() + this.f7472i.size() + this.f7471h.size() + this.f7470g.size();
    }

    /* renamed from: h */
    public final PendingIntent m9234h() {
        return PendingIntent.getBroadcast(this.f7465b, (int) System.currentTimeMillis(), new Intent("com.sonelli.juicessh.action.SFTP_PAUSE", Uri.parse("sftpservice://" + this.f7466c)), 0);
    }

    /* renamed from: i */
    public final synchronized NotificationCompat.Builder m9235i() {
        NotificationCompat.Builder contentText;
        NotificationCompat.Builder smallIcon = new NotificationCompat.Builder(this.f7465b).setSmallIcon(R.drawable.ic_media_pause);
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7465b.getString(com.sonelli.juicessh.R.string.paused));
        sb.append(": ");
        sb.append(this.f7465b.getString(this.f7464a == 0 ? com.sonelli.juicessh.R.string.sftp_download : com.sonelli.juicessh.R.string.sftp_upload));
        contentText = smallIcon.setContentTitle(sb.toString()).setContentInfo(String.format("%" + m9237k() + "d/%d", Integer.valueOf(m9233g()), Integer.valueOf(this.f7469f))).setContentText(this.f7468e);
        contentText.setDeleteIntent(m9230d());
        contentText.addAction(com.sonelli.juicessh.R.drawable.ic_clear_normal, this.f7465b.getString(com.sonelli.juicessh.R.string.cancel), m9230d());
        contentText.addAction(R.drawable.ic_menu_info_details, this.f7465b.getString(com.sonelli.juicessh.R.string.details), m9238l());
        contentText.addAction(R.drawable.ic_media_play, this.f7465b.getString(com.sonelli.juicessh.R.string.resume), m9236j());
        return contentText;
    }

    /* renamed from: j */
    public final PendingIntent m9236j() {
        return PendingIntent.getBroadcast(this.f7465b, (int) System.currentTimeMillis(), new Intent("com.sonelli.juicessh.action.SFTP_RESUME", Uri.parse("sftpservice://" + this.f7466c)), 0);
    }

    /* renamed from: k */
    public final int m9237k() {
        return String.valueOf(this.f7469f).length();
    }

    /* renamed from: l */
    public final PendingIntent m9238l() {
        return PendingIntent.getBroadcast(this.f7465b, (int) System.currentTimeMillis(), new Intent("android.intent.action.VIEW", Uri.parse("sftptranscript://" + this.f7466c)), 0);
    }

    /* renamed from: m */
    public void m9239m(boolean z) {
        m9229c().setOngoing(false);
        this.f7467d.notify(this.f7474k, m9231e(z).build());
    }

    /* renamed from: n */
    public void m9240n() {
        m9229c().setOngoing(false);
        this.f7467d.notify(this.f7474k, m9235i().setWhen(System.currentTimeMillis()).setContentInfo(String.format("%d/%d", Integer.valueOf(m9233g()), Integer.valueOf(this.f7469f))).build());
    }

    /* renamed from: o */
    public void m9241o(SparseArray<String> sparseArray) {
        NotificationCompat.InboxStyle inboxStyle = new NotificationCompat.InboxStyle();
        for (int i = 0; i < sparseArray.size(); i++) {
            SpannableString spannableString = new SpannableString(String.format("%0" + m9237k() + "d/%d %s", Integer.valueOf(sparseArray.keyAt(i) + 1), Integer.valueOf(this.f7469f), sparseArray.get(sparseArray.keyAt(i))));
            spannableString.setSpan(new StyleSpan(1), (m9237k() * 2) + 1, spannableString.length(), 33);
            inboxStyle.addLine(spannableString);
        }
        if (m9232f() > 0) {
            inboxStyle.setSummaryText(this.f7465b.getString(com.sonelli.juicessh.R.string.x_errors, Integer.valueOf(m9232f())));
        }
        this.f7467d.notify(this.f7474k, m9229c().setContentInfo(String.format("%d/%d", Integer.valueOf(m9233g()), Integer.valueOf(this.f7469f))).setStyle(inboxStyle).setOngoing(true).build());
    }
}
