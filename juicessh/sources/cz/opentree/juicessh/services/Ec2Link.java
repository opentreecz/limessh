package cz.opentree.juicessh.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import cz.opentree.gj0;
import cz.opentree.juicessh.R;
import cz.opentree.juicessh.activities.Ec2ProfilesActivity;
import cz.opentree.juicessh.models.Config;
import cz.opentree.juicessh.models.ConnectionCounter;
import cz.opentree.juicessh.models.ConnectionGroupMembership;
import cz.opentree.juicessh.models.ConnectionIdentity;
import cz.opentree.juicessh.models.User;
import cz.opentree.juicessh.models.ec2link.Ec2Connection;
import cz.opentree.juicessh.models.ec2link.Ec2Filter;
import cz.opentree.juicessh.models.ec2link.Ec2GroupMapping;
import cz.opentree.juicessh.models.ec2link.Ec2Mapping;
import cz.opentree.juicessh.models.ec2link.Ec2Profile;
import cz.opentree.juicessh.p002db.C1328DB;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.si0;
import cz.opentree.tj0;
import cz.opentree.wi0;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class Ec2Link extends JobService {

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$a */
    /* loaded from: classes.dex */
    public static class RunnableC1377a implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Context f4196O;

        public RunnableC1377a(Context context) {
            this.f4196O = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                for (Ec2Mapping ec2Mapping : C1328DB.m5404d(Ec2Mapping.class, this.f4196O).queryForAll()) {
                    try {
                        Ec2Profile ec2Profile = ec2Mapping.profile;
                        if (ec2Profile == null || ec2Profile.m5383m() == null) {
                            C1328DB.m5404d(Ec2Mapping.class, this.f4196O).delete(ec2Mapping);
                        }
                    } catch (NullPointerException unused) {
                        C1328DB.m5404d(Ec2Mapping.class, this.f4196O).delete(ec2Mapping);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                for (Ec2Filter ec2Filter : C1328DB.m5404d(Ec2Filter.class, this.f4196O).queryForAll()) {
                    try {
                        Ec2Mapping ec2Mapping2 = ec2Filter.mapping;
                        if (ec2Mapping2 == null || ec2Mapping2.m5383m() == null) {
                            C1328DB.m5404d(Ec2Filter.class, this.f4196O).delete(ec2Filter);
                        }
                    } catch (NullPointerException unused2) {
                        C1328DB.m5404d(Ec2Filter.class, this.f4196O).delete(ec2Filter);
                    }
                }
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
            try {
                for (Ec2Connection ec2Connection : C1328DB.m5404d(Ec2Connection.class, this.f4196O).queryForAll()) {
                    try {
                        Ec2Mapping ec2Mapping3 = ec2Connection.mapping;
                        if (ec2Mapping3 == null || ec2Mapping3.m5383m() == null) {
                            gj0.m4141b("Ec2Link", "Cleaning connection " + ec2Connection.toString());
                            C1328DB.m5404d(ConnectionGroupMembership.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionGroupMembership.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                            C1328DB.m5404d(ConnectionCounter.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionCounter.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                            C1328DB.m5404d(ConnectionIdentity.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionIdentity.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                            C1328DB.m5404d(Ec2Connection.class, this.f4196O).delete(ec2Connection);
                        }
                    } catch (NullPointerException e3) {
                        gj0.m4141b("Ec2Link", "Cleaning connection " + ec2Connection.toString());
                        e3.printStackTrace();
                        C1328DB.m5404d(ConnectionGroupMembership.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionGroupMembership.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                        C1328DB.m5404d(ConnectionCounter.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionCounter.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                        C1328DB.m5404d(ConnectionIdentity.class, this.f4196O).delete((Collection) C1328DB.m5404d(ConnectionIdentity.class, this.f4196O).queryForEq("connection_id", ec2Connection.f3993id));
                        C1328DB.m5404d(Ec2Connection.class, this.f4196O).delete(ec2Connection);
                    }
                }
            } catch (SQLException e4) {
                e4.printStackTrace();
            }
            try {
                for (Ec2GroupMapping ec2GroupMapping : C1328DB.m5404d(Ec2GroupMapping.class, this.f4196O).queryForAll()) {
                    try {
                        Ec2Mapping ec2Mapping4 = ec2GroupMapping.mapping;
                        if (ec2Mapping4 == null || ec2Mapping4.m5383m() == null) {
                            C1328DB.m5404d(Ec2GroupMapping.class, this.f4196O).delete(ec2GroupMapping);
                        }
                    } catch (NullPointerException unused3) {
                        C1328DB.m5404d(Ec2GroupMapping.class, this.f4196O).delete(ec2GroupMapping);
                    }
                }
            } catch (SQLException e5) {
                e5.printStackTrace();
            }
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$b */
    /* loaded from: classes.dex */
    public class C1378b extends AbstractC1385i {

        /* renamed from: a */
        public final /* synthetic */ JobParameters f4197a;

        public C1378b(JobParameters jobParameters) {
            this.f4197a = jobParameters;
        }

        @Override // cz.opentree.juicessh.services.Ec2Link.AbstractC1385i
        /* renamed from: a */
        public void mo5636a() {
            super.mo5636a();
            Ec2Link.this.jobFinished(this.f4197a, false);
            Ec2Link.this.stopSelf();
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$c */
    /* loaded from: classes.dex */
    public class C1379c extends AbstractC1386j {
        public C1379c(Ec2Link ec2Link, Context context) {
            super(context);
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$d */
    /* loaded from: classes.dex */
    public class C1380d extends AbstractC1385i {
        public C1380d() {
        }

        @Override // cz.opentree.juicessh.services.Ec2Link.AbstractC1385i
        /* renamed from: a */
        public void mo5636a() {
            super.mo5636a();
            Ec2Link.this.stopSelf();
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$e */
    /* loaded from: classes.dex */
    public class C1381e extends AbstractC1386j {
        public C1381e(Ec2Link ec2Link, Context context) {
            super(context);
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$f */
    /* loaded from: classes.dex */
    public static class C1382f extends AbstractC1385i {
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$g */
    /* loaded from: classes.dex */
    public static class C1383g extends AbstractC1386j {
        public C1383g(Context context) {
            super(context);
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$h */
    /* loaded from: classes.dex */
    public static class RunnableC1384h implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Context f4200O;

        /* renamed from: P */
        public final /* synthetic */ AbstractC1385i f4201P;

        /* renamed from: Q */
        public final /* synthetic */ Ec2Profile f4202Q;

        /* renamed from: R */
        public final /* synthetic */ AbstractC1386j f4203R;

        /* renamed from: cz.opentree.juicessh.services.Ec2Link$h$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {
            public a() {
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: a */
            public void mo3228a(String str) {
                super.mo3228a(str);
                RunnableC1384h.this.f4201P.mo5636a();
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                List<Ec2Profile> queryForEq;
                Config.m5456b(RunnableC1384h.this.f4200O);
                if (!oi0.m7047d(user)) {
                    RunnableC1384h.this.f4201P.mo5636a();
                    return;
                }
                RunnableC1384h runnableC1384h = RunnableC1384h.this;
                Ec2Profile ec2Profile = runnableC1384h.f4202Q;
                if (ec2Profile == null) {
                    try {
                        queryForEq = C1328DB.m5404d(Ec2Profile.class, runnableC1384h.f4200O).queryForEq("isEnabled", Boolean.TRUE);
                    } catch (SQLException unused) {
                        gj0.m4141b("Ec2Link", "Couldn't find any profiles. Exiting.");
                        RunnableC1384h.this.f4201P.mo5636a();
                        return;
                    }
                } else {
                    queryForEq = Arrays.asList(ec2Profile);
                }
                if (queryForEq.isEmpty()) {
                    gj0.m4141b("Ec2Link", "Couldn't find any profiles. Exiting.");
                    RunnableC1384h.this.f4201P.mo5636a();
                    return;
                }
                for (Ec2Profile ec2Profile2 : queryForEq) {
                    RunnableC1384h.this.f4203R.m5639c();
                    RunnableC1384h runnableC1384h2 = RunnableC1384h.this;
                    new Thread(new si0(runnableC1384h2.f4200O, ec2Profile2, runnableC1384h2.f4203R)).start();
                }
            }
        }

        public RunnableC1384h(Context context, AbstractC1385i abstractC1385i, Ec2Profile ec2Profile, AbstractC1386j abstractC1386j) {
            this.f4200O = context;
            this.f4201P = abstractC1385i;
            this.f4202Q = ec2Profile;
            this.f4203R = abstractC1386j;
        }

        @Override // java.lang.Runnable
        public void run() {
            pi0.m7331j(this.f4200O, new a());
            Ec2Link.m5631a(this.f4200O);
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$i */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1385i {
        /* renamed from: a */
        public void mo5636a() {
        }
    }

    /* renamed from: cz.opentree.juicessh.services.Ec2Link$j */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1386j {

        /* renamed from: a */
        public Context f4205a;

        /* renamed from: b */
        public AtomicInteger f4206b = new AtomicInteger(0);

        public AbstractC1386j(Context context) {
            this.f4205a = context;
        }

        /* renamed from: a */
        public void mo5637a() {
        }

        /* renamed from: b */
        public void mo5638b() {
        }

        /* renamed from: c */
        public void m5639c() {
            this.f4206b.incrementAndGet();
        }

        /* renamed from: d */
        public void mo5640d(si0.C1869b c1869b, Ec2Profile ec2Profile) {
            ec2Profile.isEnabled = false;
            tj0.m8703a(this.f4205a, ec2Profile.f3993id, c1869b.getMessage(), true);
            ec2Profile.disabledReason = c1869b.getMessage();
            Ec2Link.m5635e(this.f4205a, ec2Profile, c1869b.getMessage());
            try {
                C1328DB.m5404d(Ec2Profile.class, this.f4205a).update(ec2Profile);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            c1869b.printStackTrace();
            m5641e();
        }

        /* renamed from: e */
        public void m5641e() {
            if (this.f4206b.decrementAndGet() == 0) {
                mo5637a();
            }
        }
    }

    /* renamed from: a */
    public static void m5631a(Context context) {
        new Thread(new RunnableC1377a(context)).start();
    }

    /* renamed from: b */
    public static void m5632b(Context context, Ec2Profile ec2Profile) {
        m5633c(context, new C1382f(), new C1383g(context), ec2Profile);
    }

    /* renamed from: c */
    public static void m5633c(Context context, AbstractC1385i abstractC1385i, AbstractC1386j abstractC1386j, Ec2Profile ec2Profile) {
        new Thread(new RunnableC1384h(context, abstractC1385i, ec2Profile, abstractC1386j)).start();
    }

    /* renamed from: d */
    public static void m5634d(Context context, long j) {
        gj0.m4141b("Ec2Link", "Scheduling EC2Link to run every " + (j / 1000) + " seconds");
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(87254, new ComponentName(context, (Class<?>) Ec2Link.class)).setRequiredNetworkType(1).setPeriodic(j).setPersisted(true).build());
    }

    /* renamed from: e */
    public static void m5635e(Context context, Ec2Profile ec2Profile, String str) {
        if (!Boolean.parseBoolean(Config.m5458d("notifications:enabled", context))) {
            gj0.m4141b("Ec2Link", "Not showing ec2 profile disabled notification as notifications are disabled");
            return;
        }
        String str2 = context.getResources().getString(R.string.app_name) + ": " + ec2Profile.name;
        NotificationCompat.Builder color = new NotificationCompat.Builder(context).setSmallIcon(R.drawable.ic_notification).setContentTitle(str2).setContentText(((Object) context.getText(R.string.ec2_profile_disabled)) + " - " + str).setWhen(System.currentTimeMillis()).setOngoing(false).setAutoCancel(true).setSmallIcon(R.drawable.ic_notification).setColor(ContextCompat.getColor(context, R.color.accent_bold));
        Intent intent = new Intent(context, (Class<?>) Ec2ProfilesActivity.class);
        intent.setFlags(603979776);
        color.setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
        NotificationCompat.BigTextStyle bigTextStyle = new NotificationCompat.BigTextStyle(color);
        bigTextStyle.setBigContentTitle(str2);
        bigTextStyle.bigText(((Object) context.getText(R.string.ec2_profile_disabled)) + " - " + str);
        ((NotificationManager) context.getSystemService("notification")).notify(wi0.m9569b(ec2Profile.f3993id, wi0.EnumC2225a.NOTIFICATION_EC2_PROFILE_DISABLED), bigTextStyle.build());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        gj0.m4145f("Ec2Link", "Destroying Ec2Link Service");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        m5633c(getApplicationContext(), new C1380d(), new C1381e(this, getApplicationContext()), null);
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        m5633c(getApplicationContext(), new C1378b(jobParameters), new C1379c(this, getApplicationContext()), null);
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
