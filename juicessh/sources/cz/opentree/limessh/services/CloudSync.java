package cz.opentree.limessh.services;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.text.format.DateUtils;
import androidx.core.app.NotificationCompat;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import cz.opentree.gj0;
import cz.opentree.limessh.R;
import cz.opentree.limessh.activities.MainActivity;
import cz.opentree.limessh.models.Config;
import cz.opentree.limessh.models.Connection;
import cz.opentree.limessh.models.ConnectionCounter;
import cz.opentree.limessh.models.ConnectionGroup;
import cz.opentree.limessh.models.ConnectionGroupMembership;
import cz.opentree.limessh.models.ConnectionIdentity;
import cz.opentree.limessh.models.DeletedItem;
import cz.opentree.limessh.models.Host;
import cz.opentree.limessh.models.Identity;
import cz.opentree.limessh.models.PortForward;
import cz.opentree.limessh.models.Share;
import cz.opentree.limessh.models.Snippet;
import cz.opentree.limessh.models.Team;
import cz.opentree.limessh.models.TeamEncryption;
import cz.opentree.limessh.models.TeamMembership;
import cz.opentree.limessh.models.User;
import cz.opentree.limessh.models.ec2link.Ec2Filter;
import cz.opentree.limessh.models.ec2link.Ec2GroupMapping;
import cz.opentree.limessh.models.ec2link.Ec2Mapping;
import cz.opentree.limessh.models.ec2link.Ec2Profile;
import cz.opentree.limessh.p002db.BaseModel;
import cz.opentree.limessh.p002db.C1328DB;
import cz.opentree.oi0;
import cz.opentree.pi0;
import cz.opentree.qg0;
import cz.opentree.util.PasswordPrompt;
import cz.opentree.vk0;
import cz.opentree.wi0;
import cz.opentree.xi0;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class CloudSync extends JobService {

    /* renamed from: cz.opentree.limessh.services.CloudSync$a */
    /* loaded from: classes.dex */
    public class C1368a extends AbstractC1376i {

        /* renamed from: a */
        public final /* synthetic */ JobParameters f4162a;

        public C1368a(JobParameters jobParameters) {
            this.f4162a = jobParameters;
        }

        @Override // cz.opentree.limessh.services.CloudSync.AbstractC1376i
        /* renamed from: a */
        public void mo5314a() {
            super.mo5314a();
            CloudSync.this.jobFinished(this.f4162a, false);
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$b */
    /* loaded from: classes.dex */
    public static class C1369b extends AbstractC1376i {
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$c */
    /* loaded from: classes.dex */
    public static class RunnableC1370c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ Context f4164O;

        /* renamed from: P */
        public final /* synthetic */ Handler f4165P;

        /* renamed from: Q */
        public final /* synthetic */ AbstractC1376i f4166Q;

        /* renamed from: cz.opentree.limessh.services.CloudSync$c$a */
        /* loaded from: classes.dex */
        public class a extends pi0.AbstractC1720p {

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC2495a implements Runnable {
                public RunnableC2495a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1370c.this.f4166Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$b */
            /* loaded from: classes.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1370c.this.f4166Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$c */
            /* loaded from: classes.dex */
            public class c implements Runnable {
                public c() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1370c.this.f4166Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$d */
            /* loaded from: classes.dex */
            public class d implements Runnable {

                /* renamed from: O */
                public final /* synthetic */ User f4171O;

                public d(User user) {
                    this.f4171O = user;
                }

                @Override // java.lang.Runnable
                public void run() {
                    User user = this.f4171O;
                    RunnableC1370c runnableC1370c = RunnableC1370c.this;
                    CloudSync.m5623c(user, null, runnableC1370c.f4164O, runnableC1370c.f4166Q);
                    RunnableC1370c.this.f4166Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$e */
            /* loaded from: classes.dex */
            public class e implements Runnable {
                public e() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    RunnableC1370c.this.f4166Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$f */
            /* loaded from: classes.dex */
            public class f extends pi0.AbstractC1718n {

                /* renamed from: cz.opentree.limessh.services.CloudSync$c$a$f$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public class RunnableC2496a implements Runnable {
                    public RunnableC2496a() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        RunnableC1370c.this.f4166Q.mo5314a();
                    }
                }

                public f() {
                }

                @Override // cz.opentree.pi0.AbstractC1718n
                /* renamed from: b */
                public void mo5630b() {
                    super.mo5630b();
                    RunnableC1370c runnableC1370c = RunnableC1370c.this;
                    if (runnableC1370c.f4166Q != null) {
                        runnableC1370c.f4165P.post(new RunnableC2496a());
                    }
                }
            }

            public a() {
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: a */
            public void mo3228a(String str) {
                super.mo3228a(str);
                RunnableC1370c.this.f4165P.post(new RunnableC2495a());
            }

            @Override // cz.opentree.pi0.AbstractC1720p
            /* renamed from: b */
            public void mo3229b(User user) {
                JSONObject jSONObject;
                Config.m5456b(RunnableC1370c.this.f4164O);
                if (!oi0.m7047d(user)) {
                    RunnableC1370c.this.f4165P.post(new b());
                    return;
                }
                if (!Config.m5459e(RunnableC1370c.this.f4164O, "cloudsync:enabled")) {
                    gj0.m4141b("CloudSync", "CloudSync requested but not enabled - ignoring");
                    RunnableC1370c.this.f4165P.post(new c());
                    return;
                }
                LocalBroadcastManager.getInstance(RunnableC1370c.this.f4164O).sendBroadcast(new Intent("cz.opentree.limessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 1));
                String str = user.encryptionTest;
                if (str != null && str.length() > 0) {
                    gj0.m4141b("CloudSync", "Checking encryption password for user");
                    try {
                        String m7700a = qg0.m7700a(user.encryptionTest, User.m5527u(RunnableC1370c.this.f4164O));
                        if (m7700a == null || !m7700a.equals("JuiceSSH")) {
                            throw new qg0.C1762a();
                        }
                    } catch (qg0.C1762a unused) {
                        gj0.m4142c("CloudSync", "Encryption test failed for user");
                        RunnableC1370c.this.f4165P.post(new d(user));
                        return;
                    }
                }
                RunnableC1370c runnableC1370c = RunnableC1370c.this;
                if (!CloudSync.m5621a(user, runnableC1370c.f4164O, runnableC1370c.f4166Q)) {
                    RunnableC1370c.this.f4165P.post(new e());
                    return;
                }
                TeamEncryption.m5511r(user, RunnableC1370c.this.f4164O);
                JSONObject jSONObject2 = new JSONObject();
                try {
                    boolean m5459e = Config.m5459e(RunnableC1370c.this.f4164O, "cloudsync:identities");
                    jSONObject2.put("config", Config.m5457c(user, RunnableC1370c.this.f4164O));
                    jSONObject2.put("deleted", DeletedItem.m5478r(RunnableC1370c.this.f4164O));
                    JSONObject jSONObject3 = new JSONObject();
                    try {
                        jSONObject3.put(Team.class.getName(), C1328DB.m5401a(Team.class, user, RunnableC1370c.this.f4164O, false));
                        jSONObject3.put(TeamMembership.class.getName(), C1328DB.m5401a(TeamMembership.class, user, RunnableC1370c.this.f4164O, false));
                        jSONObject3.put(Share.class.getName(), C1328DB.m5401a(Share.class, user, RunnableC1370c.this.f4164O, false));
                        jSONObject3.put(ConnectionGroupMembership.class.getName(), C1328DB.m5401a(ConnectionGroupMembership.class, user, RunnableC1370c.this.f4164O, false));
                        jSONObject3.put(TeamEncryption.class.getName(), C1328DB.m5401a(TeamEncryption.class, user, RunnableC1370c.this.f4164O, false));
                        jSONObject3.put(ConnectionCounter.class.getName(), C1328DB.m5401a(ConnectionCounter.class, user, RunnableC1370c.this.f4164O, false));
                        if (m5459e) {
                            jSONObject3.put(ConnectionIdentity.class.getName(), C1328DB.m5401a(ConnectionIdentity.class, user, RunnableC1370c.this.f4164O, false));
                        }
                        if (m5459e) {
                            jSONObject3.put(Identity.class.getName(), C1328DB.m5401a(Identity.class, user, RunnableC1370c.this.f4164O, true));
                        }
                        jSONObject3.put(Connection.class.getName(), C1328DB.m5401a(Connection.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(ConnectionGroup.class.getName(), C1328DB.m5401a(ConnectionGroup.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Host.class.getName(), C1328DB.m5401a(Host.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Snippet.class.getName(), C1328DB.m5401a(Snippet.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Ec2Filter.class.getName(), C1328DB.m5401a(Ec2Filter.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Ec2GroupMapping.class.getName(), C1328DB.m5401a(Ec2GroupMapping.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Ec2Mapping.class.getName(), C1328DB.m5401a(Ec2Mapping.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(Ec2Profile.class.getName(), C1328DB.m5401a(Ec2Profile.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject3.put(PortForward.class.getName(), C1328DB.m5401a(PortForward.class, user, RunnableC1370c.this.f4164O, true));
                        jSONObject = jSONObject2;
                        try {
                            jSONObject.put("objects", jSONObject3);
                            jSONObject.put("date", System.currentTimeMillis() / 1000);
                        } catch (JSONException unused2) {
                        }
                    } catch (JSONException unused3) {
                        jSONObject = jSONObject2;
                    }
                } catch (JSONException unused4) {
                    jSONObject = jSONObject2;
                }
                RunnableC1370c runnableC1370c2 = RunnableC1370c.this;
                pi0.m7327f(runnableC1370c2.f4164O, user, jSONObject, runnableC1370c2.f4166Q, new f());
            }
        }

        public RunnableC1370c(Context context, Handler handler, AbstractC1376i abstractC1376i) {
            this.f4164O = context;
            this.f4165P = handler;
            this.f4166Q = abstractC1376i;
        }

        @Override // java.lang.Runnable
        public void run() {
            pi0.m7331j(this.f4164O, new a());
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$d */
    /* loaded from: classes.dex */
    public static class RunnableC1371d implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ User f4176O;

        /* renamed from: P */
        public final /* synthetic */ Team f4177P;

        /* renamed from: Q */
        public final /* synthetic */ Context f4178Q;

        /* renamed from: R */
        public final /* synthetic */ AbstractC1376i f4179R;

        public RunnableC1371d(User user, Team team, Context context, AbstractC1376i abstractC1376i) {
            this.f4176O = user;
            this.f4177P = team;
            this.f4178Q = context;
            this.f4179R = abstractC1376i;
        }

        @Override // java.lang.Runnable
        public void run() {
            CloudSync.m5624d(this.f4176O, this.f4177P, (Activity) this.f4178Q, this.f4179R);
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$e */
    /* loaded from: classes.dex */
    public static class C1372e implements PasswordPrompt.PasswordPromptListener {

        /* renamed from: a */
        public final /* synthetic */ Team f4180a;

        /* renamed from: b */
        public final /* synthetic */ Activity f4181b;

        /* renamed from: c */
        public final /* synthetic */ AbstractC1376i f4182c;

        /* renamed from: cz.opentree.limessh.services.CloudSync$e$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1372e.this.f4182c.mo5314a();
            }
        }

        public C1372e(Team team, Activity activity, AbstractC1376i abstractC1376i) {
            this.f4180a = team;
            this.f4181b = activity;
            this.f4182c = abstractC1376i;
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        /* renamed from: a */
        public void mo5299a(String str, boolean z) {
            Team team = this.f4180a;
            if (team == null) {
                User.m5521D(str, false, this.f4181b);
            } else {
                team.m5510y(this.f4181b, str);
            }
            CloudSync.m5628h(this.f4181b, this.f4182c);
        }

        @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
        public void onCancel() {
            this.f4181b.runOnUiThread(new a());
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$f */
    /* loaded from: classes.dex */
    public static class DialogInterfaceOnClickListenerC1373f implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ Activity f4184O;

        /* renamed from: P */
        public final /* synthetic */ User f4185P;

        /* renamed from: Q */
        public final /* synthetic */ AbstractC1376i f4186Q;

        /* renamed from: cz.opentree.limessh.services.CloudSync$f$a */
        /* loaded from: classes.dex */
        public class a implements PasswordPrompt.PasswordPromptListener {

            /* renamed from: cz.opentree.limessh.services.CloudSync$f$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC2497a implements Runnable {
                public RunnableC2497a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    DialogInterfaceOnClickListenerC1373f.this.f4186Q.mo5314a();
                }
            }

            /* renamed from: cz.opentree.limessh.services.CloudSync$f$a$b */
            /* loaded from: classes.dex */
            public class b implements Runnable {
                public b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    DialogInterfaceOnClickListenerC1373f.this.f4186Q.mo5314a();
                }
            }

            public a() {
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            /* renamed from: a */
            public void mo5299a(String str, boolean z) {
                DialogInterfaceOnClickListenerC1373f dialogInterfaceOnClickListenerC1373f = DialogInterfaceOnClickListenerC1373f.this;
                pi0.m7339r(dialogInterfaceOnClickListenerC1373f.f4184O, dialogInterfaceOnClickListenerC1373f.f4185P);
                User.m5521D(str, false, DialogInterfaceOnClickListenerC1373f.this.f4184O);
                DialogInterfaceOnClickListenerC1373f.this.f4184O.runOnUiThread(new RunnableC2497a());
                DialogInterfaceOnClickListenerC1373f dialogInterfaceOnClickListenerC1373f2 = DialogInterfaceOnClickListenerC1373f.this;
                CloudSync.m5628h(dialogInterfaceOnClickListenerC1373f2.f4184O, dialogInterfaceOnClickListenerC1373f2.f4186Q);
            }

            @Override // cz.opentree.util.PasswordPrompt.PasswordPromptListener
            public void onCancel() {
                DialogInterfaceOnClickListenerC1373f.this.f4184O.runOnUiThread(new b());
            }
        }

        public DialogInterfaceOnClickListenerC1373f(Activity activity, User user, AbstractC1376i abstractC1376i) {
            this.f4184O = activity;
            this.f4185P = user;
            this.f4186Q = abstractC1376i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            PasswordPrompt passwordPrompt = new PasswordPrompt(this.f4184O, new a());
            passwordPrompt.m9295h(this.f4184O.getString(R.string.forgotten_password_warning));
            passwordPrompt.m9297j(this.f4184O.getString(R.string.new_password));
            if (this.f4184O.isFinishing()) {
                return;
            }
            passwordPrompt.show();
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$g */
    /* loaded from: classes.dex */
    public static class DialogInterfaceOnClickListenerC1374g implements DialogInterface.OnClickListener {

        /* renamed from: O */
        public final /* synthetic */ Activity f4190O;

        /* renamed from: P */
        public final /* synthetic */ Team f4191P;

        /* renamed from: Q */
        public final /* synthetic */ User f4192Q;

        /* renamed from: R */
        public final /* synthetic */ AbstractC1376i f4193R;

        /* renamed from: cz.opentree.limessh.services.CloudSync$g$a */
        /* loaded from: classes.dex */
        public class a implements DialogInterface.OnClickListener {

            /* renamed from: cz.opentree.limessh.services.CloudSync$g$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC2498a implements Runnable {
                public RunnableC2498a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    DialogInterfaceOnClickListenerC1374g.this.f4193R.mo5314a();
                }
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                DialogInterfaceOnClickListenerC1374g dialogInterfaceOnClickListenerC1374g = DialogInterfaceOnClickListenerC1374g.this;
                dialogInterfaceOnClickListenerC1374g.f4191P.m5509w(dialogInterfaceOnClickListenerC1374g.f4192Q, dialogInterfaceOnClickListenerC1374g.f4190O);
                DialogInterfaceOnClickListenerC1374g.this.f4190O.runOnUiThread(new RunnableC2498a());
                DialogInterfaceOnClickListenerC1374g dialogInterfaceOnClickListenerC1374g2 = DialogInterfaceOnClickListenerC1374g.this;
                CloudSync.m5628h(dialogInterfaceOnClickListenerC1374g2.f4190O, dialogInterfaceOnClickListenerC1374g2.f4193R);
            }
        }

        public DialogInterfaceOnClickListenerC1374g(Activity activity, Team team, User user, AbstractC1376i abstractC1376i) {
            this.f4190O = activity;
            this.f4191P = team;
            this.f4192Q = user;
            this.f4193R = abstractC1376i;
        }

        @Override // android.content.DialogInterface.OnClickListener
        @SuppressLint({"StringFormatInvalid"})
        public void onClick(DialogInterface dialogInterface, int i) {
            vk0 vk0Var = new vk0(this.f4190O);
            vk0Var.setPositiveButton(this.f4190O.getString(R.string.yes), new a());
            vk0Var.setNegativeButton(this.f4190O.getString(R.string.f3673no), (DialogInterface.OnClickListener) null);
            vk0Var.m9295h(String.format(this.f4190O.getString(R.string.are_you_sure_you_want_to_leave_team), this.f4191P.name));
            vk0Var.m9297j(this.f4190O.getString(R.string.leave_team));
            if (this.f4190O.isFinishing()) {
                return;
            }
            vk0Var.show();
        }
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$h */
    /* loaded from: classes.dex */
    public static class C1375h extends Exception {
    }

    /* renamed from: cz.opentree.limessh.services.CloudSync$i */
    /* loaded from: classes.dex */
    public static abstract class AbstractC1376i {
        /* renamed from: a */
        public void mo5314a() {
        }
    }

    /* renamed from: a */
    public static boolean m5621a(User user, Context context, AbstractC1376i abstractC1376i) {
        for (Team team : Team.m5505v(user, context)) {
            if (team != null) {
                try {
                    String m5508t = team.m5508t(context);
                    if (m5508t == null) {
                        throw new qg0.C1762a();
                    }
                    String m7700a = qg0.m7700a(team.encryptionTest, m5508t);
                    if (m7700a == null || !m7700a.equals("JuiceSSH")) {
                        throw new qg0.C1762a();
                    }
                } catch (qg0.C1762a unused) {
                    gj0.m4142c("CloudSync", "Encryption test failed for team " + team.name);
                    m5623c(user, team, context, abstractC1376i);
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: b */
    public static String m5622b(Context context) {
        long j;
        try {
            j = Long.parseLong(Config.m5458d("last:cloudsync", context)) * 1000;
        } catch (NumberFormatException unused) {
            j = 0;
        }
        if (j <= 1) {
            return context.getString(R.string.never_syncronised);
        }
        return String.format(context.getString(R.string.last_sync), DateUtils.formatDateTime(context, j, 16), DateUtils.formatDateTime(context, j, 1));
    }

    /* renamed from: c */
    public static void m5623c(User user, Team team, Context context, AbstractC1376i abstractC1376i) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(new Intent("cz.opentree.limessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 8));
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                activity.runOnUiThread(new RunnableC1371d(user, team, context, abstractC1376i));
                return;
            }
        }
        m5625e(team, context);
    }

    /* renamed from: d */
    public static void m5624d(User user, Team team, Activity activity, AbstractC1376i abstractC1376i) {
        PasswordPrompt passwordPrompt = new PasswordPrompt(activity, new C1372e(team, activity, abstractC1376i));
        passwordPrompt.m9018q();
        if (team == null) {
            passwordPrompt.setNeutralButton(activity.getString(R.string.forgotten), new DialogInterfaceOnClickListenerC1373f(activity, user, abstractC1376i));
        } else {
            passwordPrompt.setNeutralButton(activity.getString(R.string.leave_team), new DialogInterfaceOnClickListenerC1374g(activity, team, user, abstractC1376i));
        }
        if (team == null) {
            passwordPrompt.m9297j(activity.getResources().getString(R.string.cloudsync) + ": " + activity.getResources().getString(R.string.bad_password));
            passwordPrompt.m9295h(activity.getResources().getString(R.string.decryption_of_your_backups_failed));
        } else if (team.m5508t(activity) == null) {
            passwordPrompt.m9297j(activity.getResources().getString(R.string.teamshare) + ": " + activity.getResources().getString(R.string.team_password));
            passwordPrompt.m9295h(String.format(activity.getResources().getString(R.string.please_enter_the_password_for_team), team.name));
        } else {
            passwordPrompt.m9297j(activity.getResources().getString(R.string.teamshare) + ": " + activity.getResources().getString(R.string.bad_password));
            passwordPrompt.m9295h(activity.getResources().getString(R.string.decyrption_of_items_for_team) + " '" + team.name + "' " + activity.getResources().getString(R.string.failed_due_to_incorrect_password));
        }
        LocalBroadcastManager.getInstance(activity).sendBroadcast(new Intent("cz.opentree.limessh.cloudsync.progress").putExtra(NotificationCompat.MessagingStyle.Message.KEY_DATA_MIME_TYPE, 8));
        ((NotificationManager) activity.getSystemService("notification")).cancel(wi0.m9568a(wi0.EnumC2225a.NOTIFICATION_CLOUDSYNC_PASSWORD_INCORRECT));
        if (activity.isFinishing()) {
            return;
        }
        passwordPrompt.show();
    }

    /* renamed from: e */
    public static void m5625e(Team team, Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        Intent intent = new Intent(context, (Class<?>) MainActivity.class);
        intent.putExtra("cloudsync", true);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.drawable.ic_notification);
        if (team == null) {
            builder.setContentTitle(context.getResources().getString(R.string.app_name) + ": " + context.getResources().getString(R.string.cloudsync));
            builder.setContentText(context.getResources().getString(R.string.incorrect_decryption_password));
        } else {
            builder.setContentTitle(context.getResources().getString(R.string.app_name) + ": " + context.getResources().getString(R.string.teamshare));
            builder.setContentText(context.getResources().getString(R.string.incorrect_decryption_password_for_team) + " '" + team.name + "'");
        }
        builder.setWhen(System.currentTimeMillis());
        builder.setOngoing(false);
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        notificationManager.notify(wi0.m9568a(wi0.EnumC2225a.NOTIFICATION_CLOUDSYNC_PASSWORD_INCORRECT), builder.build());
    }

    /* renamed from: f */
    public static <T extends BaseModel<?>> void m5626f(JSONObject jSONObject, User user, Context context, AbstractC1376i abstractC1376i) throws C1375h {
        xi0 xi0Var = new xi0(user, context);
        if (jSONObject == null || user == null || context == null) {
            return;
        }
        try {
            if (!jSONObject.isNull("configs")) {
                Config.m5461g(jSONObject.getJSONArray("configs"), user, context);
            }
            if (!jSONObject.isNull("objects")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("objects");
                if (!jSONObject2.isNull("cz.opentree.limessh.models.TeamEncryption")) {
                    gj0.m4141b("CloudSync", "Importing: cz.opentree.limessh.models.TeamEncryption");
                    try {
                        C1328DB.m5403c(jSONObject2.getJSONArray("cz.opentree.limessh.models.TeamEncryption"), TeamEncryption.class, xi0Var, user, true, context);
                        jSONObject2.remove("cz.opentree.limessh.models.TeamEncryption");
                    } catch (qg0.C1762a unused) {
                    }
                }
                if (!jSONObject2.isNull("cz.opentree.limessh.models.Team")) {
                    gj0.m4141b("CloudSync", "Importing: cz.opentree.limessh.models.Team");
                    try {
                        C1328DB.m5403c(jSONObject2.getJSONArray("cz.opentree.limessh.models.Team"), Team.class, xi0Var, user, true, context);
                        jSONObject2.remove("cz.opentree.limessh.models.Team");
                    } catch (qg0.C1762a unused2) {
                    }
                }
                if (!jSONObject2.isNull("cz.opentree.limessh.models.TeamMembership")) {
                    gj0.m4141b("CloudSync", "Importing: cz.opentree.limessh.models.TeamMembership");
                    try {
                        C1328DB.m5403c(jSONObject2.getJSONArray("cz.opentree.limessh.models.TeamMembership"), TeamMembership.class, xi0Var, user, true, context);
                        jSONObject2.remove("cz.opentree.limessh.models.TeamMembership");
                    } catch (qg0.C1762a unused3) {
                    }
                }
                if (!m5621a(user, context, abstractC1376i)) {
                    throw new C1375h();
                }
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (Config.m5459e(context, "cloudsync:identities") || (!next.equals("cz.opentree.limessh.models.Identity") && !next.equals("cz.opentree.limessh.models.ConnectionIdentity"))) {
                        try {
                            try {
                                Class<?> cls = Class.forName(next);
                                if (BaseModel.class.isAssignableFrom(cls)) {
                                    gj0.m4141b("CloudSync", "Importing: " + next);
                                    C1328DB.m5403c(jSONObject2.getJSONArray(next), cls, xi0Var, user, true, context);
                                } else {
                                    gj0.m4142c("CloudSync", "Attempting to import an unknown CloudSync object " + next);
                                }
                            } catch (qg0.C1762a unused4) {
                                m5623c(user, null, context, abstractC1376i);
                            }
                        } catch (ClassNotFoundException unused5) {
                            gj0.m4142c("CloudSync", "Attempting to import an unknown CloudSync object " + next);
                        } catch (NoClassDefFoundError unused6) {
                            gj0.m4142c("CloudSync", "Attempting to import an unknown CloudSync object" + next);
                        }
                    }
                }
            }
        } catch (JSONException e) {
            gj0.m4141b("CloudSync", "JSON Error: " + e.getMessage());
            e.printStackTrace();
        }
        Ec2Link.m5631a(context);
        xi0Var.m9778d();
    }

    /* renamed from: g */
    public static void m5627g(Context context) {
        m5628h(context, new C1369b());
    }

    /* renamed from: h */
    public static void m5628h(Context context, AbstractC1376i abstractC1376i) {
        new Thread(new RunnableC1370c(context, new Handler(), abstractC1376i)).start();
    }

    /* renamed from: i */
    public static void m5629i(Context context, long j) {
        gj0.m4141b("CloudSync", "Scheduling CloudSync to run every " + (j / 1000) + " seconds");
        ((JobScheduler) context.getSystemService("jobscheduler")).schedule(new JobInfo.Builder(87253, new ComponentName(context, (Class<?>) CloudSync.class)).setRequiredNetworkType(1).setPeriodic(j).setPersisted(true).build());
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        m5628h(getApplicationContext(), new C1368a(jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
