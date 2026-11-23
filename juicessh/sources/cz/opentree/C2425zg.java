package cz.opentree;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.PersistableBundle;
import androidx.core.app.NotificationCompat;

/* renamed from: cz.opentree.zg */
/* loaded from: classes.dex */
public final class C2425zg extends AbstractC2006uf {

    /* renamed from: Q */
    public boolean f8503Q;

    /* renamed from: R */
    public boolean f8504R;

    /* renamed from: S */
    public final AlarmManager f8505S;

    /* renamed from: T */
    public Integer f8506T;

    public C2425zg(C2216wf c2216wf) {
        super(c2216wf);
        this.f8505S = (AlarmManager) m8675x().getSystemService(NotificationCompat.CATEGORY_ALARM);
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        try {
            m10449G0();
            if (C2007ug.m8882e() > 0) {
                Context m8675x = m8675x();
                ActivityInfo receiverInfo = m8675x.getPackageManager().getReceiverInfo(new ComponentName(m8675x, "com.google.android.gms.analytics.AnalyticsReceiver"), 0);
                if (receiverInfo == null || !receiverInfo.enabled) {
                    return;
                }
                m8676x0("Receiver registered for local dispatch.");
                this.f8503Q = true;
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    /* renamed from: G0 */
    public final void m10449G0() {
        this.f8504R = false;
        this.f8505S.cancel(m10454L0());
        if (Build.VERSION.SDK_INT >= 24) {
            JobScheduler jobScheduler = (JobScheduler) m8675x().getSystemService("jobscheduler");
            int m10450H0 = m10450H0();
            m8679z("Cancelling job. JobID", Integer.valueOf(m10450H0));
            jobScheduler.cancel(m10450H0);
        }
    }

    /* renamed from: H0 */
    public final int m10450H0() {
        if (this.f8506T == null) {
            String valueOf = String.valueOf(m8675x().getPackageName());
            this.f8506T = Integer.valueOf((valueOf.length() != 0 ? "analytics".concat(valueOf) : new String("analytics")).hashCode());
        }
        return this.f8506T.intValue();
    }

    /* renamed from: I0 */
    public final boolean m10451I0() {
        return this.f8504R;
    }

    /* renamed from: J0 */
    public final boolean m10452J0() {
        return this.f8503Q;
    }

    /* renamed from: K0 */
    public final void m10453K0() {
        m8878F0();
        C0813ca.m2733o(this.f8503Q, "Receiver not registered");
        long m8882e = C2007ug.m8882e();
        if (m8882e > 0) {
            m10449G0();
            long mo1178b = m8659g0().mo1178b() + m8882e;
            this.f8504R = true;
            C0770bh.f1675E.m2801a().booleanValue();
            if (Build.VERSION.SDK_INT < 24) {
                m8676x0("Scheduling upload with AlarmManager");
                this.f8505S.setInexactRepeating(2, mo1178b, m8882e, m10454L0());
                return;
            }
            m8676x0("Scheduling upload with JobScheduler");
            Context m8675x = m8675x();
            ComponentName componentName = new ComponentName(m8675x, "com.google.android.gms.analytics.AnalyticsJobService");
            int m10450H0 = m10450H0();
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("action", "com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            JobInfo build = new JobInfo.Builder(m10450H0, componentName).setMinimumLatency(m8882e).setOverrideDeadline(m8882e << 1).setExtras(persistableBundle).build();
            m8679z("Scheduling job. JobID", Integer.valueOf(m10450H0));
            C0825ci.m2807b(m8675x, build, "com.google.android.gms", "DispatchAlarm");
        }
    }

    /* renamed from: L0 */
    public final PendingIntent m10454L0() {
        Context m8675x = m8675x();
        return PendingIntent.getBroadcast(m8675x, 0, new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH").setComponent(new ComponentName(m8675x, "com.google.android.gms.analytics.AnalyticsReceiver")), 0);
    }
}
