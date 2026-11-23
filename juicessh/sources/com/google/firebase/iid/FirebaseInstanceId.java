package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import cz.opentree.C0813ca;
import cz.opentree.ThreadFactoryC1755qc;
import cz.opentree.ae0;
import cz.opentree.e70;
import cz.opentree.ee0;
import cz.opentree.fe0;
import cz.opentree.ff0;
import cz.opentree.he0;
import cz.opentree.id0;
import cz.opentree.j60;
import cz.opentree.ue0;
import cz.opentree.vd0;
import cz.opentree.ze0;
import java.io.IOException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public class FirebaseInstanceId {

    /* renamed from: i */
    public static final long f1261i = TimeUnit.HOURS.toSeconds(8);

    /* renamed from: j */
    public static fe0 f1262j;

    /* renamed from: k */
    @GuardedBy("FirebaseInstanceId.class")
    public static ScheduledExecutorService f1263k;

    /* renamed from: a */
    public final Executor f1264a;

    /* renamed from: b */
    public final FirebaseApp f1265b;

    /* renamed from: c */
    public final vd0 f1266c;

    /* renamed from: d */
    public final ff0 f1267d;

    /* renamed from: e */
    public final ae0 f1268e;

    /* renamed from: f */
    public final FirebaseInstallationsApi f1269f;

    /* renamed from: g */
    @GuardedBy("this")
    public boolean f1270g;

    /* renamed from: h */
    public final C0665a f1271h;

    /* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
    /* renamed from: com.google.firebase.iid.FirebaseInstanceId$a */
    /* loaded from: classes.dex */
    public class C0665a {

        /* renamed from: a */
        public boolean f1272a;

        /* renamed from: b */
        public final Subscriber f1273b;

        /* renamed from: c */
        @GuardedBy("this")
        public boolean f1274c;

        /* renamed from: d */
        @Nullable
        @GuardedBy("this")
        public EventHandler<e70> f1275d;

        /* renamed from: e */
        @Nullable
        @GuardedBy("this")
        public Boolean f1276e;

        public C0665a(Subscriber subscriber) {
            this.f1273b = subscriber;
        }

        /* renamed from: a */
        public final synchronized boolean m1896a() {
            m1897b();
            Boolean bool = this.f1276e;
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.f1272a && FirebaseInstanceId.this.f1265b.m1585p();
        }

        /* renamed from: b */
        public final synchronized void m1897b() {
            if (this.f1274c) {
                return;
            }
            this.f1272a = m1899d();
            Boolean m1898c = m1898c();
            this.f1276e = m1898c;
            if (m1898c == null && this.f1272a) {
                EventHandler<e70> eventHandler = new EventHandler(this) { // from class: cz.opentree.cf0

                    /* renamed from: a */
                    public final FirebaseInstanceId.C0665a f1928a;

                    {
                        this.f1928a = this;
                    }

                    @Override // com.google.firebase.events.EventHandler
                    /* renamed from: a */
                    public final void mo1861a(dd0 dd0Var) {
                        FirebaseInstanceId.C0665a c0665a = this.f1928a;
                        synchronized (c0665a) {
                            if (c0665a.m1896a()) {
                                FirebaseInstanceId.this.m1874A();
                            }
                        }
                    }
                };
                this.f1275d = eventHandler;
                this.f1273b.mo1862a(e70.class, eventHandler);
            }
            this.f1274c = true;
        }

        @Nullable
        /* renamed from: c */
        public final Boolean m1898c() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context m1580g = FirebaseInstanceId.this.f1265b.m1580g();
            SharedPreferences sharedPreferences = m1580g.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = m1580g.getPackageManager();
                if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(m1580g.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return null;
                }
                return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        /* renamed from: d */
        public final boolean m1899d() {
            try {
                Class.forName("com.google.firebase.messaging.FirebaseMessaging");
                return true;
            } catch (ClassNotFoundException unused) {
                Context m1580g = FirebaseInstanceId.this.f1265b.m1580g();
                Intent intent = new Intent("com.google.firebase.MESSAGING_EVENT");
                intent.setPackage(m1580g.getPackageName());
                ResolveInfo resolveService = m1580g.getPackageManager().resolveService(intent, 0);
                return (resolveService == null || resolveService.serviceInfo == null) ? false : true;
            }
        }
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, new vd0(firebaseApp.m1580g()), ue0.m8875b(), ue0.m8875b(), subscriber, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
    }

    public FirebaseInstanceId(FirebaseApp firebaseApp, vd0 vd0Var, Executor executor, Executor executor2, Subscriber subscriber, UserAgentPublisher userAgentPublisher, HeartBeatInfo heartBeatInfo, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.f1270g = false;
        if (vd0.m9213b(firebaseApp) == null) {
            throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
        }
        synchronized (FirebaseInstanceId.class) {
            if (f1262j == null) {
                f1262j = new fe0(firebaseApp.m1580g());
            }
        }
        this.f1265b = firebaseApp;
        this.f1266c = vd0Var;
        this.f1267d = new ff0(firebaseApp, vd0Var, executor, userAgentPublisher, heartBeatInfo, firebaseInstallationsApi);
        this.f1264a = executor2;
        this.f1271h = new C0665a(subscriber);
        this.f1268e = new ae0(executor);
        this.f1269f = firebaseInstallationsApi;
        executor2.execute(new Runnable(this) { // from class: cz.opentree.xe0

            /* renamed from: O */
            public final FirebaseInstanceId f7921O;

            {
                this.f7921O = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f7921O.m1895z();
            }
        });
    }

    @NonNull
    /* renamed from: b */
    public static FirebaseInstanceId m1866b() {
        return getInstance(FirebaseApp.m1572h());
    }

    @NonNull
    @Keep
    public static FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseInstanceId) firebaseApp.m1579f(FirebaseInstanceId.class);
    }

    /* renamed from: k */
    public static String m1868k(String str) {
        return (str.isEmpty() || str.equalsIgnoreCase("fcm") || str.equalsIgnoreCase("gcm")) ? "*" : str;
    }

    /* renamed from: m */
    public static void m1869m(@NonNull FirebaseApp firebaseApp) {
        C0813ca.m2726h(firebaseApp.m1582j().m4386e(), "FirebaseApp has to define a valid projectId.");
        C0813ca.m2726h(firebaseApp.m1582j().m4384c(), "FirebaseApp has to define a valid applicationId.");
        C0813ca.m2726h(firebaseApp.m1582j().m4383b(), "FirebaseApp has to define a valid apiKey.");
    }

    /* renamed from: n */
    public static void m1870n(Runnable runnable, long j) {
        synchronized (FirebaseInstanceId.class) {
            if (f1263k == null) {
                f1263k = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC1755qc("FirebaseInstanceId"));
            }
            f1263k.schedule(runnable, j, TimeUnit.SECONDS);
        }
    }

    /* renamed from: v */
    public static boolean m1873v() {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            return true;
        }
        return Build.VERSION.SDK_INT == 23 && Log.isLoggable("FirebaseInstanceId", 3);
    }

    /* renamed from: A */
    public final void m1874A() {
        if (m1888q(m1889r())) {
            m1875B();
        }
    }

    /* renamed from: B */
    public final synchronized void m1875B() {
        if (!this.f1270g) {
            m1886l(0L);
        }
    }

    /* renamed from: C */
    public final String m1876C() {
        try {
            f1262j.m3739e(this.f1265b.m1583k());
            j60<String> id = this.f1269f.getId();
            C0813ca.m2730l(id, "Task must not be null");
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            id.mo2690c(ze0.f8493a, new OnCompleteListener(countDownLatch) { // from class: cz.opentree.ye0

                /* renamed from: a */
                public final CountDownLatch f8199a;

                {
                    this.f8199a = countDownLatch;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                /* renamed from: a */
                public final void mo1554a(j60 j60Var) {
                    this.f8199a.countDown();
                }
            });
            countDownLatch.await(30000L, TimeUnit.MILLISECONDS);
            if (id.mo2701n()) {
                return id.mo2697j();
            }
            if (id.mo2699l()) {
                throw new CancellationException("Task is already canceled");
            }
            throw new IllegalStateException(id.mo2696i());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: D */
    public final String m1877D() {
        return "[DEFAULT]".equals(this.f1265b.m1581i()) ? "" : this.f1265b.m1583k();
    }

    @NonNull
    @WorkerThread
    /* renamed from: a */
    public String m1878a() {
        m1869m(this.f1265b);
        m1874A();
        return m1876C();
    }

    @Nullable
    @WorkerThread
    /* renamed from: c */
    public String m1879c(@NonNull String str, @NonNull String str2) throws IOException {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return ((InstanceIdResult) m1885j(m1880d(str, str2))).mo1901a();
        }
        throw new IOException("MAIN_THREAD");
    }

    /* renamed from: d */
    public final j60<InstanceIdResult> m1880d(final String str, String str2) {
        final String m1868k = m1868k(str2);
        return Tasks.m1562e(null).mo2695h(this.f1264a, new Continuation(this, str, m1868k) { // from class: cz.opentree.we0

            /* renamed from: a */
            public final FirebaseInstanceId f7667a;

            /* renamed from: b */
            public final String f7668b;

            /* renamed from: c */
            public final String f7669c;

            {
                this.f7667a = this;
                this.f7668b = str;
                this.f7669c = m1868k;
            }

            @Override // com.google.android.gms.tasks.Continuation
            /* renamed from: a */
            public final Object mo1552a(j60 j60Var) {
                return this.f7667a.m1881e(this.f7668b, this.f7669c, j60Var);
            }
        });
    }

    /* renamed from: e */
    public final /* synthetic */ j60 m1881e(final String str, final String str2, j60 j60Var) throws Exception {
        final String m1876C = m1876C();
        ee0 m1890s = m1890s(str, str2);
        return !m1888q(m1890s) ? Tasks.m1562e(new id0(m1876C, m1890s.f2372a)) : this.f1268e.m2047b(str, str2, new zzav(this, m1876C, str, str2) { // from class: cz.opentree.bf0

            /* renamed from: a */
            public final FirebaseInstanceId f1666a;

            /* renamed from: b */
            public final String f1667b;

            /* renamed from: c */
            public final String f1668c;

            /* renamed from: d */
            public final String f1669d;

            {
                this.f1666a = this;
                this.f1667b = m1876C;
                this.f1668c = str;
                this.f1669d = str2;
            }

            @Override // com.google.firebase.iid.zzav
            /* renamed from: a */
            public final j60 mo1902a() {
                return this.f1666a.m1882f(this.f1667b, this.f1668c, this.f1669d);
            }
        });
    }

    /* renamed from: f */
    public final /* synthetic */ j60 m1882f(final String str, final String str2, final String str3) {
        return this.f1267d.m3744a(str, str2, str3).mo2703p(this.f1264a, new SuccessContinuation(this, str2, str3, str) { // from class: cz.opentree.af0

            /* renamed from: a */
            public final FirebaseInstanceId f1373a;

            /* renamed from: b */
            public final String f1374b;

            /* renamed from: c */
            public final String f1375c;

            /* renamed from: d */
            public final String f1376d;

            {
                this.f1373a = this;
                this.f1374b = str2;
                this.f1375c = str3;
                this.f1376d = str;
            }

            @Override // com.google.android.gms.tasks.SuccessContinuation
            /* renamed from: a */
            public final j60 mo1557a(Object obj) {
                return this.f1373a.m1883g(this.f1374b, this.f1375c, this.f1376d, (String) obj);
            }
        });
    }

    /* renamed from: g */
    public final /* synthetic */ j60 m1883g(String str, String str2, String str3, String str4) throws Exception {
        f1262j.m3738d(m1877D(), str, str2, str4, this.f1266c.m9217e());
        return Tasks.m1562e(new id0(str3, str4));
    }

    /* renamed from: h */
    public final FirebaseApp m1884h() {
        return this.f1265b;
    }

    /* renamed from: j */
    public final <T> T m1885j(j60<T> j60Var) throws IOException {
        try {
            return (T) Tasks.m1559b(j60Var, 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | TimeoutException unused) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof IOException) {
                if ("INSTANCE_ID_RESET".equals(cause.getMessage())) {
                    m1892w();
                }
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException(e);
        }
    }

    /* renamed from: l */
    public final synchronized void m1886l(long j) {
        m1870n(new he0(this, Math.min(Math.max(30L, j << 1), f1261i)), j);
        this.f1270g = true;
    }

    /* renamed from: p */
    public final synchronized void m1887p(boolean z) {
        this.f1270g = z;
    }

    /* renamed from: q */
    public final boolean m1888q(@Nullable ee0 ee0Var) {
        return ee0Var == null || ee0Var.m3481c(this.f1266c.m9217e());
    }

    @Nullable
    /* renamed from: r */
    public final ee0 m1889r() {
        return m1890s(vd0.m9213b(this.f1265b), "*");
    }

    @Nullable
    /* renamed from: s */
    public final ee0 m1890s(String str, String str2) {
        return f1262j.m3736a(m1877D(), str, str2);
    }

    /* renamed from: u */
    public final String m1891u() throws IOException {
        return m1879c(vd0.m9213b(this.f1265b), "*");
    }

    /* renamed from: w */
    public final synchronized void m1892w() {
        f1262j.m3737c();
        if (this.f1271h.m1896a()) {
            m1875B();
        }
    }

    /* renamed from: x */
    public final boolean m1893x() {
        return this.f1266c.m9215c();
    }

    /* renamed from: y */
    public final void m1894y() {
        f1262j.m3741h(m1877D());
        m1875B();
    }

    /* renamed from: z */
    public final /* synthetic */ void m1895z() {
        if (this.f1271h.m1896a()) {
            m1874A();
        }
    }
}
