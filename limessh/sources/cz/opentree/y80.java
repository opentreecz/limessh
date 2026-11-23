package cz.opentree;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsConnectorReceiver;
import com.google.firebase.crashlytics.internal.common.CrashlyticsController;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class y80 {

    /* renamed from: a */
    public final Context f8147a;

    /* renamed from: b */
    public final FirebaseApp f8148b;

    /* renamed from: c */
    public final c90 f8149c;

    /* renamed from: d */
    public final long f8150d;

    /* renamed from: e */
    public z80 f8151e;

    /* renamed from: f */
    public z80 f8152f;

    /* renamed from: g */
    public CrashlyticsController f8153g;

    /* renamed from: h */
    public final h90 f8154h;

    /* renamed from: i */
    public final AnalyticsConnector f8155i;

    /* renamed from: j */
    public ExecutorService f8156j;

    /* renamed from: k */
    public x80 f8157k;

    /* renamed from: l */
    public CrashlyticsNativeComponent f8158l;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.y80$a */
    /* loaded from: classes.dex */
    public class C2329a implements AnalyticsConnectorReceiver.BreadcrumbHandler {
        public C2329a() {
        }

        @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsConnectorReceiver.BreadcrumbHandler
        /* renamed from: a */
        public void mo1631a(String str) {
            y80.this.m10107k(str);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.y80$b */
    /* loaded from: classes.dex */
    public class CallableC2330b implements Callable<j60<Void>> {

        /* renamed from: a */
        public final /* synthetic */ SettingsDataProvider f8160a;

        public CallableC2330b(SettingsDataProvider settingsDataProvider) {
            this.f8160a = settingsDataProvider;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j60<Void> call() throws Exception {
            return y80.this.m10104f(this.f8160a);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.y80$c */
    /* loaded from: classes.dex */
    public class RunnableC2331c implements Runnable {

        /* renamed from: O */
        public final /* synthetic */ SettingsDataProvider f8162O;

        public RunnableC2331c(SettingsDataProvider settingsDataProvider) {
            this.f8162O = settingsDataProvider;
        }

        @Override // java.lang.Runnable
        public void run() {
            y80.this.m10104f(this.f8162O);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.y80$d */
    /* loaded from: classes.dex */
    public class CallableC2332d implements Callable<Boolean> {
        public CallableC2332d() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                boolean m10405d = y80.this.f8151e.m10405d();
                m80.m6375f().m6377b("Initialization marker file removed: " + m10405d);
                return Boolean.valueOf(m10405d);
            } catch (Exception e) {
                m80.m6375f().m6380e("Problem encountered deleting Crashlytics initialization marker.", e);
                return Boolean.FALSE;
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.y80$e */
    /* loaded from: classes.dex */
    public class CallableC2333e implements Callable<Boolean> {
        public CallableC2333e() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            return Boolean.valueOf(y80.this.f8153g.m1669D());
        }
    }

    public y80(FirebaseApp firebaseApp, h90 h90Var, CrashlyticsNativeComponent crashlyticsNativeComponent, c90 c90Var, AnalyticsConnector analyticsConnector) {
        this(firebaseApp, h90Var, crashlyticsNativeComponent, c90Var, analyticsConnector, f90.m3694c("Crashlytics Exception Handler"));
    }

    public y80(FirebaseApp firebaseApp, h90 h90Var, CrashlyticsNativeComponent crashlyticsNativeComponent, c90 c90Var, AnalyticsConnector analyticsConnector, ExecutorService executorService) {
        this.f8148b = firebaseApp;
        this.f8149c = c90Var;
        this.f8147a = firebaseApp.m1580g();
        this.f8154h = h90Var;
        this.f8158l = crashlyticsNativeComponent;
        this.f8155i = analyticsConnector;
        this.f8156j = executorService;
        this.f8157k = new x80(executorService);
        this.f8150d = System.currentTimeMillis();
    }

    /* renamed from: i */
    public static String m10100i() {
        return "17.0.0";
    }

    /* renamed from: j */
    public static boolean m10101j(String str, boolean z) {
        if (!z) {
            m80.m6375f().m6377b("Configured not to require a build ID.");
            return true;
        }
        if (!w80.m9416C(str)) {
            return true;
        }
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".     |  | ");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".   \\ |  | /");
        Log.e("FirebaseCrashlytics", ".    \\    /");
        Log.e("FirebaseCrashlytics", ".     \\  /");
        Log.e("FirebaseCrashlytics", ".      \\/");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        Log.e("FirebaseCrashlytics", ".");
        Log.e("FirebaseCrashlytics", ".      /\\");
        Log.e("FirebaseCrashlytics", ".     /  \\");
        Log.e("FirebaseCrashlytics", ".    /    \\");
        Log.e("FirebaseCrashlytics", ".   / |  | \\");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".     |  |");
        Log.e("FirebaseCrashlytics", ".");
        return false;
    }

    /* renamed from: d */
    public final void m10102d() {
        try {
            Boolean.TRUE.equals((Boolean) r90.m7891a(this.f8157k.m9737h(new CallableC2333e())));
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public boolean m10103e() {
        return this.f8151e.m10404c();
    }

    /* renamed from: f */
    public final j60<Void> m10104f(SettingsDataProvider settingsDataProvider) {
        m10109m();
        this.f8153g.m1714x();
        try {
            this.f8153g.m1703m0();
            Settings mo1843b = settingsDataProvider.mo1843b();
            if (!mo1843b.mo1845a().f4513a) {
                m80.m6375f().m6377b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.m1561d(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f8153g.m1681L(mo1843b.mo1846b().f4785a)) {
                m80.m6375f().m6377b("Could not finalize previous sessions.");
            }
            return this.f8153g.m1706p0(1.0f, settingsDataProvider.mo1842a());
        } catch (Exception e) {
            m80.m6375f().m6380e("Crashlytics encountered a problem during asynchronous initialization.", e);
            return Tasks.m1561d(e);
        } finally {
            m10108l();
        }
    }

    /* renamed from: g */
    public j60<Void> m10105g(SettingsDataProvider settingsDataProvider) {
        return r90.m7892b(this.f8156j, new CallableC2330b(settingsDataProvider));
    }

    /* renamed from: h */
    public final void m10106h(SettingsDataProvider settingsDataProvider) {
        Future<?> submit = this.f8156j.submit(new RunnableC2331c(settingsDataProvider));
        m80.m6375f().m6377b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            m80.m6375f().m6380e("Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            m80.m6375f().m6380e("Problem encountered during Crashlytics initialization.", e2);
        } catch (TimeoutException e3) {
            m80.m6375f().m6380e("Crashlytics timed out during initialization.", e3);
        }
    }

    /* renamed from: k */
    public void m10107k(String str) {
        this.f8153g.m1677H0(System.currentTimeMillis() - this.f8150d, str);
    }

    /* renamed from: l */
    public void m10108l() {
        this.f8157k.m9737h(new CallableC2332d());
    }

    /* renamed from: m */
    public void m10109m() {
        this.f8157k.m9731b();
        this.f8151e.m10402a();
        m80.m6375f().m6377b("Initialization marker file created.");
    }

    /* renamed from: n */
    public boolean m10110n(SettingsDataProvider settingsDataProvider) {
        String m9437p = w80.m9437p(this.f8147a);
        m80.m6375f().m6377b("Mapping file ID is: " + m9437p);
        if (!m10101j(m9437p, w80.m9433l(this.f8147a, "com.crashlytics.RequireBuildId", true))) {
            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
        }
        String m4384c = this.f8148b.m1582j().m4384c();
        try {
            m80.m6375f().m6381g("Initializing Crashlytics " + m10100i());
            Context context = this.f8147a;
            mb0 mb0Var = new mb0(context);
            this.f8152f = new z80("crash_marker", mb0Var);
            this.f8151e = new z80("initialization_marker", mb0Var);
            db0 db0Var = new db0();
            q80 m7636a = q80.m7636a(context, this.f8154h, m4384c, m9437p);
            wc0 wc0Var = new wc0(this.f8147a);
            AnalyticsConnectorReceiver analyticsConnectorReceiver = new AnalyticsConnectorReceiver(this.f8155i, new C2329a());
            m80.m6375f().m6377b("Installer package name is: " + m7636a.f5961c);
            this.f8153g = new CrashlyticsController(this.f8147a, this.f8157k, db0Var, this.f8154h, this.f8149c, mb0Var, this.f8152f, m7636a, null, null, this.f8158l, wc0Var, analyticsConnectorReceiver, this.f8155i, settingsDataProvider);
            boolean m10103e = m10103e();
            m10102d();
            this.f8153g.m1678I(Thread.getDefaultUncaughtExceptionHandler(), settingsDataProvider);
            if (!m10103e || !w80.m9424c(this.f8147a)) {
                m80.m6375f().m6377b("Exception handling initialization successful");
                return true;
            }
            m80.m6375f().m6377b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            m10106h(settingsDataProvider);
            return false;
        } catch (Exception e) {
            m80.m6375f().m6380e("Crashlytics was not started due to an exception during initialization", e);
            this.f8153g = null;
            return false;
        }
    }
}
