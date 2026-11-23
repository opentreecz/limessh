package cz.opentree;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import cz.opentree.C1688p3;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.ez */
/* loaded from: classes.dex */
public final class C0960ez extends p00 {

    /* renamed from: E */
    public static final Pair<String, Long> f2553E = new Pair<>("", 0L);

    /* renamed from: A */
    public final C1480kz f2554A;

    /* renamed from: B */
    public final C1480kz f2555B;

    /* renamed from: C */
    public final C1189iz f2556C;

    /* renamed from: D */
    public final C1417jz f2557D;

    /* renamed from: c */
    public SharedPreferences f2558c;

    /* renamed from: d */
    public C1530lz f2559d;

    /* renamed from: e */
    public final C1189iz f2560e;

    /* renamed from: f */
    public final C1189iz f2561f;

    /* renamed from: g */
    public final C1189iz f2562g;

    /* renamed from: h */
    public final C1189iz f2563h;

    /* renamed from: i */
    public final C1189iz f2564i;

    /* renamed from: j */
    public final C1189iz f2565j;

    /* renamed from: k */
    public final C1189iz f2566k;

    /* renamed from: l */
    public final C1480kz f2567l;

    /* renamed from: m */
    public String f2568m;

    /* renamed from: n */
    public boolean f2569n;

    /* renamed from: o */
    public long f2570o;

    /* renamed from: p */
    public final C1189iz f2571p;

    /* renamed from: q */
    public final C1189iz f2572q;

    /* renamed from: r */
    public final C1085gz f2573r;

    /* renamed from: s */
    public final C1480kz f2574s;

    /* renamed from: t */
    public final C1085gz f2575t;

    /* renamed from: u */
    public final C1085gz f2576u;

    /* renamed from: v */
    public final C1189iz f2577v;

    /* renamed from: w */
    public boolean f2578w;

    /* renamed from: x */
    public C1085gz f2579x;

    /* renamed from: y */
    public C1085gz f2580y;

    /* renamed from: z */
    public C1189iz f2581z;

    public C0960ez(C2144uz c2144uz) {
        super(c2144uz);
        this.f2560e = new C1189iz(this, "last_upload", 0L);
        this.f2561f = new C1189iz(this, "last_upload_attempt", 0L);
        this.f2562g = new C1189iz(this, "backoff", 0L);
        this.f2563h = new C1189iz(this, "last_delete_stale", 0L);
        this.f2571p = new C1189iz(this, "time_before_start", 10000L);
        this.f2572q = new C1189iz(this, "session_timeout", 1800000L);
        this.f2573r = new C1085gz(this, "start_new_session", true);
        this.f2577v = new C1189iz(this, "last_pause_time", 0L);
        this.f2574s = new C1480kz(this, "non_personalized_ads", null);
        this.f2575t = new C1085gz(this, "use_dynamite_api", false);
        this.f2576u = new C1085gz(this, "allow_remote_dynamite", false);
        this.f2564i = new C1189iz(this, "midnight_offset", 0L);
        this.f2565j = new C1189iz(this, "first_open_time", 0L);
        this.f2566k = new C1189iz(this, "app_install_time", 0L);
        this.f2567l = new C1480kz(this, "app_instance_id", null);
        this.f2579x = new C1085gz(this, "app_backgrounded", false);
        this.f2580y = new C1085gz(this, "deep_link_retrieval_complete", false);
        this.f2581z = new C1189iz(this, "deep_link_retrieval_attempts", 0L);
        this.f2554A = new C1480kz(this, "firebase_feature_rollouts", null);
        this.f2555B = new C1480kz(this, "deferred_attribution_cache", null);
        this.f2556C = new C1189iz(this, "deferred_attribution_cache_timestamp", 0L);
        this.f2557D = new C1417jz(this, "default_event_parameters", null);
    }

    @WorkerThread
    /* renamed from: A */
    public final void m3585A(String str) {
        mo7585d();
        SharedPreferences.Editor edit = m3588D().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    @WorkerThread
    /* renamed from: B */
    public final void m3586B(boolean z) {
        mo7585d();
        mo1484j().m8530P().m9084b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = m3588D().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    @WorkerThread
    /* renamed from: C */
    public final void m3587C(String str) {
        mo7585d();
        SharedPreferences.Editor edit = m3588D().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    @WorkerThread
    /* renamed from: D */
    public final SharedPreferences m3588D() {
        mo7585d();
        m7166q();
        return this.f2558c;
    }

    @WorkerThread
    /* renamed from: E */
    public final String m3589E() {
        mo7585d();
        return m3588D().getString("gmp_app_id", null);
    }

    @WorkerThread
    /* renamed from: F */
    public final String m3590F() {
        mo7585d();
        return m3588D().getString("admob_app_id", null);
    }

    @WorkerThread
    /* renamed from: G */
    public final Boolean m3591G() {
        mo7585d();
        if (m3588D().contains("use_service")) {
            return Boolean.valueOf(m3588D().getBoolean("use_service", false));
        }
        return null;
    }

    @WorkerThread
    /* renamed from: H */
    public final void m3592H() {
        mo7585d();
        Boolean m3593I = m3593I();
        SharedPreferences.Editor edit = m3588D().edit();
        edit.clear();
        edit.apply();
        if (m3593I != null) {
            m3602z(m3593I.booleanValue());
        }
    }

    @WorkerThread
    /* renamed from: I */
    public final Boolean m3593I() {
        mo7585d();
        if (m3588D().contains("measurement_enabled")) {
            return Boolean.valueOf(m3588D().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    @WorkerThread
    /* renamed from: J */
    public final String m3594J() {
        mo7585d();
        String string = m3588D().getString("previous_os_version", null);
        m7586e().m7166q();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = m3588D().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    @WorkerThread
    /* renamed from: K */
    public final boolean m3595K() {
        return this.f2558c.contains("deferred_analytics_collection");
    }

    @Override // cz.opentree.p00
    @WorkerThread
    /* renamed from: p */
    public final void mo3596p() {
        SharedPreferences sharedPreferences = mo1482h().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f2558c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.f2578w = z;
        if (!z) {
            SharedPreferences.Editor edit = this.f2558c.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.f2559d = new C1530lz(this, "health_monitor", Math.max(0L, C1735pu.f5829d.m6320a(null).longValue()));
    }

    @Override // cz.opentree.p00
    /* renamed from: t */
    public final boolean mo3597t() {
        return true;
    }

    @NonNull
    @WorkerThread
    /* renamed from: v */
    public final Pair<String, Boolean> m3598v(String str) {
        mo7585d();
        long mo1178b = mo1483i().mo1178b();
        if (this.f2568m != null && mo1178b < this.f2570o) {
            return new Pair<>(this.f2568m, Boolean.valueOf(this.f2569n));
        }
        this.f2570o = mo1178b + m7590o().m2627r(str, C1735pu.f5827c);
        C1688p3.m7231d(true);
        try {
            C1688p3.a m7230b = C1688p3.m7230b(mo1482h());
            if (m7230b != null) {
                this.f2568m = m7230b.m7239a();
                this.f2569n = m7230b.m7240b();
            }
            if (this.f2568m == null) {
                this.f2568m = "";
            }
        } catch (Exception e) {
            mo1484j().m8529O().m9084b("Unable to get advertising id", e);
            this.f2568m = "";
        }
        C1688p3.m7231d(false);
        return new Pair<>(this.f2568m, Boolean.valueOf(this.f2569n));
    }

    @WorkerThread
    /* renamed from: w */
    public final void m3599w(boolean z) {
        mo7585d();
        SharedPreferences.Editor edit = m3588D().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* renamed from: x */
    public final boolean m3600x(long j) {
        return j - this.f2572q.m4968a() > this.f2577v.m4968a();
    }

    @WorkerThread
    /* renamed from: y */
    public final String m3601y(String str) {
        mo7585d();
        String str2 = (String) m3598v(str).first;
        MessageDigest m3988I0 = g40.m3988I0();
        if (m3988I0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, m3988I0.digest(str2.getBytes())));
    }

    @WorkerThread
    /* renamed from: z */
    public final void m3602z(boolean z) {
        mo7585d();
        SharedPreferences.Editor edit = m3588D().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }
}
