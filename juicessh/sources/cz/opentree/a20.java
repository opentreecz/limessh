package cz.opentree;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class a20 extends AbstractC0742ay {

    /* renamed from: c */
    public volatile b20 f1314c;

    /* renamed from: d */
    public b20 f1315d;

    /* renamed from: e */
    public b20 f1316e;

    /* renamed from: f */
    public final Map<Activity, b20> f1317f;

    /* renamed from: g */
    public Activity f1318g;

    /* renamed from: h */
    public volatile b20 f1319h;

    /* renamed from: i */
    public b20 f1320i;

    /* renamed from: j */
    public final Object f1321j;

    /* renamed from: k */
    public String f1322k;

    public a20(C2144uz c2144uz) {
        super(c2144uz);
        this.f1321j = new Object();
        this.f1317f = new ConcurrentHashMap();
    }

    /* renamed from: D */
    public static /* synthetic */ b20 m1955D(a20 a20Var, b20 b20Var) {
        a20Var.f1320i = null;
        return null;
    }

    /* renamed from: F */
    public static String m1956F(String str) {
        String[] split = str.split("\\.");
        String str2 = split.length > 0 ? split[split.length - 1] : "";
        return str2.length() > 100 ? str2.substring(0, 100) : str2;
    }

    /* renamed from: M */
    public static void m1959M(b20 b20Var, Bundle bundle, boolean z) {
        if (bundle == null || b20Var == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && b20Var == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = b20Var.f1588a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = b20Var.f1589b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", b20Var.f1590c);
    }

    @Override // cz.opentree.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return false;
    }

    @WorkerThread
    /* renamed from: E */
    public final b20 m1961E(boolean z) {
        m2299y();
        mo7585d();
        if (!m7590o().m2630u(C1735pu.f5789F0) || !z) {
            return this.f1316e;
        }
        b20 b20Var = this.f1316e;
        return b20Var != null ? b20Var : this.f1320i;
    }

    @MainThread
    /* renamed from: G */
    public final void m1962G(Activity activity) {
        if (m7590o().m2630u(C1735pu.f5789F0)) {
            synchronized (this.f1321j) {
                if (activity != this.f1318g) {
                    synchronized (this.f1321j) {
                        this.f1318g = activity;
                    }
                    if (m7590o().m2630u(C1735pu.f5787E0) && m7590o().m2619M().booleanValue()) {
                        this.f1319h = null;
                        mo1481g().m8281A(new h20(this));
                    }
                }
            }
        }
        if (m7590o().m2630u(C1735pu.f5787E0) && !m7590o().m2619M().booleanValue()) {
            this.f1314c = this.f1319h;
            mo1481g().m8281A(new c20(this));
        } else {
            m1964I(activity, m1973U(activity), false);
            C2313xu m10661p = m10661p();
            m10661p.mo1481g().m8281A(new RunnableC2394yv(m10661p, m10661p.mo1483i().mo1178b()));
        }
    }

    @MainThread
    /* renamed from: H */
    public final void m1963H(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!m7590o().m2619M().booleanValue() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f1317f.put(activity, new b20(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    @MainThread
    /* renamed from: I */
    public final void m1964I(Activity activity, b20 b20Var, boolean z) {
        b20 b20Var2;
        b20 b20Var3 = this.f1314c == null ? this.f1315d : this.f1314c;
        if (b20Var.f1589b == null) {
            b20Var2 = new b20(b20Var.f1588a, activity != null ? m1956F(activity.getClass().getCanonicalName()) : null, b20Var.f1590c, b20Var.f1592e);
        } else {
            b20Var2 = b20Var;
        }
        this.f1315d = this.f1314c;
        this.f1314c = b20Var2;
        mo1481g().m8281A(new d20(this, b20Var2, b20Var3, mo1483i().mo1178b(), z));
    }

    @MainThread
    /* renamed from: J */
    public final void m1965J(@NonNull Activity activity, @Nullable @Size(max = 36, min = 1) String str, @Nullable @Size(max = 36, min = 1) String str2) {
        if (!m7590o().m2619M().booleanValue()) {
            mo1484j().m8527M().m9083a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        if (this.f1314c == null) {
            mo1484j().m8527M().m9083a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f1317f.get(activity) == null) {
            mo1484j().m8527M().m9083a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = m1956F(activity.getClass().getCanonicalName());
        }
        boolean m4008z0 = g40.m4008z0(this.f1314c.f1589b, str2);
        boolean m4008z02 = g40.m4008z0(this.f1314c.f1588a, str);
        if (m4008z0 && m4008z02) {
            mo1484j().m8527M().m9083a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > 100)) {
            mo1484j().m8527M().m9084b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > 100)) {
            mo1484j().m8527M().m9084b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        mo1484j().m8530P().m9085c("Setting current screen to name, class", str == null ? "null" : str, str2);
        b20 b20Var = new b20(str, str2, m7588m().m4014D0());
        this.f1317f.put(activity, b20Var);
        m1964I(activity, b20Var, true);
    }

    @WorkerThread
    /* renamed from: N */
    public final void m1966N(b20 b20Var, b20 b20Var2, long j, boolean z, Bundle bundle) {
        boolean z2;
        b20 b20Var3;
        mo7585d();
        if (m7590o().m2630u(C1735pu.f5818V)) {
            z2 = z && this.f1316e != null;
            if (z2) {
                m1967O(this.f1316e, true, j);
            }
        } else {
            if (z && (b20Var3 = this.f1316e) != null) {
                m1967O(b20Var3, true, j);
            }
            z2 = false;
        }
        if ((b20Var2 != null && b20Var2.f1590c == b20Var.f1590c && g40.m4008z0(b20Var2.f1589b, b20Var.f1589b) && g40.m4008z0(b20Var2.f1588a, b20Var.f1588a)) ? false : true) {
            Bundle bundle2 = new Bundle();
            if (m7590o().m2630u(C1735pu.f5789F0)) {
                bundle2 = new Bundle();
            }
            m1959M(b20Var, bundle2, true);
            if (b20Var2 != null) {
                String str = b20Var2.f1588a;
                if (str != null) {
                    bundle2.putString("_pn", str);
                }
                String str2 = b20Var2.f1589b;
                if (str2 != null) {
                    bundle2.putString("_pc", str2);
                }
                bundle2.putLong("_pi", b20Var2.f1590c);
            }
            if (m7590o().m2630u(C1735pu.f5818V) && z2) {
                long m7613g = (C0736as.m2268b() && m7590o().m2630u(C1735pu.f5820X) && C1946tr.m8792b() && m7590o().m2630u(C1735pu.f5783C0)) ? m10667v().f4451e.m7613g(j) : m10667v().f4451e.m7611e();
                if (m7613g > 0) {
                    m7588m().m4025M(bundle2, m7613g);
                }
            }
            String str3 = "auto";
            if (m7590o().m2630u(C1735pu.f5789F0)) {
                if (!m7590o().m2619M().booleanValue()) {
                    bundle2.putLong("_mt", 1L);
                }
                if (b20Var.f1592e) {
                    str3 = "app";
                }
            }
            m10662q().m10036u0(str3, "_vs", bundle2);
        }
        this.f1316e = b20Var;
        if (m7590o().m2630u(C1735pu.f5789F0) && b20Var.f1592e) {
            this.f1320i = b20Var;
        }
        m10664s().m3948N(b20Var);
    }

    @WorkerThread
    /* renamed from: O */
    public final void m1967O(b20 b20Var, boolean z, long j) {
        m10661p().m9893w(mo1483i().mo1178b());
        if (!m10667v().m5799F(b20Var != null && b20Var.f1591d, z, j) || b20Var == null) {
            return;
        }
        b20Var.f1591d = false;
    }

    @WorkerThread
    /* renamed from: P */
    public final void m1968P(String str, b20 b20Var) {
        mo7585d();
        synchronized (this) {
            String str2 = this.f1322k;
            if (str2 == null || str2.equals(str) || b20Var != null) {
                this.f1322k = str;
            }
        }
    }

    /* renamed from: Q */
    public final b20 m1969Q() {
        mo7583b();
        return this.f1314c;
    }

    @MainThread
    /* renamed from: R */
    public final void m1970R(Activity activity) {
        if (m7590o().m2630u(C1735pu.f5789F0)) {
            synchronized (this.f1321j) {
            }
        }
        if (m7590o().m2630u(C1735pu.f5787E0) && !m7590o().m2619M().booleanValue()) {
            this.f1314c = null;
            mo1481g().m8281A(new f20(this));
            return;
        }
        b20 m1973U = m1973U(activity);
        this.f1315d = this.f1314c;
        this.f1314c = null;
        mo1481g().m8281A(new e20(this, m1973U, mo1483i().mo1178b()));
    }

    @MainThread
    /* renamed from: S */
    public final void m1971S(Activity activity, Bundle bundle) {
        b20 b20Var;
        if (!m7590o().m2619M().booleanValue() || bundle == null || (b20Var = this.f1317f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", b20Var.f1590c);
        bundle2.putString("name", b20Var.f1588a);
        bundle2.putString("referrer_name", b20Var.f1589b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    @MainThread
    /* renamed from: T */
    public final void m1972T(Activity activity) {
        synchronized (this.f1321j) {
            if (activity == this.f1318g) {
                this.f1318g = null;
            }
        }
        if (m7590o().m2619M().booleanValue()) {
            this.f1317f.remove(activity);
        }
    }

    @MainThread
    /* renamed from: U */
    public final b20 m1973U(@NonNull Activity activity) {
        C0813ca.m2729k(activity);
        b20 b20Var = this.f1317f.get(activity);
        if (b20Var == null) {
            b20 b20Var2 = new b20(null, m1956F(activity.getClass().getCanonicalName()), m7588m().m4014D0());
            this.f1317f.put(activity, b20Var2);
            b20Var = b20Var2;
        }
        if (!m7590o().m2630u(C1735pu.f5789F0)) {
        }
        return b20Var;
    }
}
