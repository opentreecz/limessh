package cz.opentree;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.measurement.zzr;
import com.google.android.gms.measurement.internal.zzha;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
/* renamed from: cz.opentree.wi */
/* loaded from: classes.dex */
public class C2224wi {

    /* renamed from: h */
    public static volatile C2224wi f7712h = null;

    /* renamed from: i */
    public static Boolean f7713i = null;

    /* renamed from: j */
    public static Boolean f7714j = null;

    /* renamed from: k */
    public static boolean f7715k = false;

    /* renamed from: l */
    public static Boolean f7716l = null;

    /* renamed from: m */
    public static String f7717m = "use_dynamite_api";

    /* renamed from: n */
    public static String f7718n = "allow_remote_dynamite";

    /* renamed from: o */
    public static boolean f7719o = true;

    /* renamed from: a */
    public final String f7720a;

    /* renamed from: b */
    public final Clock f7721b;

    /* renamed from: c */
    public final ExecutorService f7722c;

    /* renamed from: d */
    public List<Pair<zzha, b>> f7723d;

    /* renamed from: e */
    public int f7724e;

    /* renamed from: f */
    public boolean f7725f;

    /* renamed from: g */
    public zzr f7726g;

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    /* renamed from: cz.opentree.wi$a */
    /* loaded from: classes.dex */
    public abstract class a implements Runnable {

        /* renamed from: O */
        public final long f7727O;

        /* renamed from: P */
        public final long f7728P;

        /* renamed from: Q */
        public final boolean f7729Q;

        public a(C2224wi c2224wi) {
            this(true);
        }

        public a(boolean z) {
            this.f7727O = C2224wi.this.f7721b.mo1177a();
            this.f7728P = C2224wi.this.f7721b.mo1178b();
            this.f7729Q = z;
        }

        /* renamed from: a */
        public abstract void mo2112a() throws RemoteException;

        /* renamed from: b */
        public void mo2113b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C2224wi.this.f7725f) {
                mo2113b();
                return;
            }
            try {
                mo2112a();
            } catch (Exception e) {
                C2224wi.this.m9560n(e, false, this.f7729Q);
                mo2113b();
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    /* renamed from: cz.opentree.wi$b */
    /* loaded from: classes.dex */
    public static class b extends AbstractBinderC2391yt {

        /* renamed from: a */
        public final zzha f7731a;

        public b(zzha zzhaVar) {
            this.f7731a = zzhaVar;
        }

        @Override // com.google.android.gms.internal.measurement.zzx
        /* renamed from: a */
        public final int mo1434a() {
            return System.identityHashCode(this.f7731a);
        }

        @Override // com.google.android.gms.internal.measurement.zzx
        /* renamed from: s0 */
        public final void mo1435s0(String str, String str2, Bundle bundle, long j) {
            this.f7731a.mo1451a(str, str2, bundle, j);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.4.1 */
    /* renamed from: cz.opentree.wi$c */
    /* loaded from: classes.dex */
    public class c implements Application.ActivityLifecycleCallbacks {
        public c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C2224wi.this.m9558j(new C1820rj(this, activity, bundle));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
            C2224wi.this.m9558j(new C2226wj(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            C2224wi.this.m9558j(new C2172vj(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            C2224wi.this.m9558j(new C1871sj(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            BinderC1981tt binderC1981tt = new BinderC1981tt();
            C2224wi.this.m9558j(new C2292xj(this, activity, binderC1981tt));
            Bundle m8808O0 = binderC1981tt.m8808O0(50L);
            if (m8808O0 != null) {
                bundle.putAll(m8808O0);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
            C2224wi.this.m9558j(new C1936tj(this, activity));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
            C2224wi.this.m9558j(new C2013uj(this, activity));
        }
    }

    public C2224wi(Context context, String str, String str2, String str3, Bundle bundle) {
        if (str == null || !m9525E(str2, str3)) {
            this.f7720a = "FA";
        } else {
            this.f7720a = str;
        }
        this.f7721b = C0921ec.m3474d();
        this.f7722c = new ThreadPoolExecutor(0, 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        if (!(!m9529M(context) || m9534S())) {
            this.f7725f = true;
            Log.w(this.f7720a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (!m9525E(str2, str3)) {
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f7720a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f7720a, "Deferring to Google Analytics for Firebase for event data collection. https://goo.gl/J1sWQy");
            }
        }
        m9558j(new C2427zi(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f7720a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new c());
        }
    }

    /* renamed from: E */
    public static boolean m9525E(String str, String str2) {
        return (str2 == null || str == null || m9534S()) ? false : true;
    }

    /* renamed from: M */
    public static boolean m9529M(Context context) {
        return new C0977fa(context).m3696a("google_app_id") != null;
    }

    /* renamed from: N */
    public static int m9530N(Context context) {
        return DynamiteModule.m1183b(context, ModuleDescriptor.MODULE_ID);
    }

    /* renamed from: P */
    public static int m9531P(Context context) {
        return DynamiteModule.m1182a(context, ModuleDescriptor.MODULE_ID);
    }

    /* renamed from: Q */
    public static void m9532Q(Context context) {
        synchronized (C2224wi.class) {
            try {
            } catch (Exception e) {
                Log.e("FA", "Exception reading flag from SharedPreferences.", e);
                f7713i = Boolean.valueOf(f7719o);
                f7714j = Boolean.FALSE;
            }
            if (f7713i == null || f7714j == null) {
                if (m9541r(context, "app_measurement_internal_disable_startup_flags")) {
                    f7713i = Boolean.valueOf(f7719o);
                    f7714j = Boolean.FALSE;
                    return;
                }
                SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
                f7713i = Boolean.valueOf(sharedPreferences.getBoolean(f7717m, f7719o));
                f7714j = Boolean.valueOf(sharedPreferences.getBoolean(f7718n, false));
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove(f7717m);
                edit.remove(f7718n);
                edit.apply();
            }
        }
    }

    /* renamed from: S */
    public static boolean m9534S() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static C2224wi m9535a(@NonNull Context context) {
        return m9536b(context, null, null, null, null);
    }

    /* renamed from: b */
    public static C2224wi m9536b(Context context, String str, String str2, String str3, Bundle bundle) {
        C0813ca.m2729k(context);
        if (f7712h == null) {
            synchronized (C2224wi.class) {
                if (f7712h == null) {
                    f7712h = new C2224wi(context, str, str2, str3, bundle);
                }
            }
        }
        return f7712h;
    }

    /* renamed from: r */
    public static boolean m9541r(Context context, @Size(min = 1) String str) {
        Bundle bundle;
        C0813ca.m2725g(str);
        try {
            ApplicationInfo m9466c = C2272xc.m9755a(context).m9466c(context.getPackageName(), 128);
            if (m9466c != null && (bundle = m9466c.metaData) != null) {
                return bundle.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* renamed from: z */
    public static boolean m9545z(Context context) {
        m9532Q(context);
        synchronized (C2224wi.class) {
            if (!f7715k) {
                try {
                    try {
                        String str = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, "measurement.dynamite.enabled", "");
                        if ("true".equals(str)) {
                            f7716l = Boolean.TRUE;
                        } else if ("false".equals(str)) {
                            f7716l = Boolean.FALSE;
                        } else {
                            f7716l = null;
                        }
                        f7715k = true;
                    } finally {
                        f7715k = true;
                    }
                } catch (Exception e) {
                    Log.e("FA", "Unable to call SystemProperties.get()", e);
                    f7716l = null;
                }
            }
        }
        Boolean bool = f7716l;
        if (bool == null) {
            bool = f7713i;
        }
        return bool.booleanValue();
    }

    /* renamed from: B */
    public final String m9546B() {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C0993fj(this, binderC1981tt));
        return binderC1981tt.m8809s(500L);
    }

    /* renamed from: D */
    public final void m9547D(String str) {
        m9558j(new C0882dj(this, str));
    }

    /* renamed from: G */
    public final int m9548G(String str) {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C1511lj(this, str, binderC1981tt));
        Integer num = (Integer) BinderC1981tt.m8807r(binderC1981tt.m8808O0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    /* renamed from: H */
    public final String m9549H() {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C0937ej(this, binderC1981tt));
        return binderC1981tt.m8809s(50L);
    }

    /* renamed from: K */
    public final long m9550K() {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C1112hj(this, binderC1981tt));
        Long l = (Long) BinderC1981tt.m8807r(binderC1981tt.m8808O0(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.f7721b.mo1177a()).nextLong();
        int i = this.f7724e + 1;
        this.f7724e = i;
        return nextLong + i;
    }

    /* renamed from: L */
    public final String m9551L() {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C1045gj(this, binderC1981tt));
        return binderC1981tt.m8809s(500L);
    }

    /* renamed from: O */
    public final String m9552O() {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C1218jj(this, binderC1981tt));
        return binderC1981tt.m8809s(500L);
    }

    /* renamed from: c */
    public final zzr m9553c(Context context, boolean z) {
        try {
            return AbstractBinderC2043ut.asInterface(DynamiteModule.m1184d(context, z ? DynamiteModule.f940k : DynamiteModule.f938i, ModuleDescriptor.MODULE_ID).m1194c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.C0448a e) {
            m9560n(e, true, false);
            return null;
        }
    }

    /* renamed from: f */
    public final Map<String, Object> m9554f(String str, String str2, boolean z) {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C1163ij(this, str, str2, z, binderC1981tt));
        Bundle m8808O0 = binderC1981tt.m8808O0(5000L);
        if (m8808O0 == null || m8808O0.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(m8808O0.size());
        for (String str3 : m8808O0.keySet()) {
            Object obj = m8808O0.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    /* renamed from: g */
    public final void m9555g(int i, String str, Object obj, Object obj2, Object obj3) {
        m9558j(new C1459kj(this, false, 5, str, obj, null, null));
    }

    /* renamed from: h */
    public final void m9556h(Activity activity, String str, String str2) {
        m9558j(new C0779bj(this, activity, str, str2));
    }

    /* renamed from: i */
    public final void m9557i(Bundle bundle) {
        m9558j(new C1765qj(this, bundle));
    }

    /* renamed from: j */
    public final void m9558j(a aVar) {
        this.f7722c.execute(aVar);
    }

    /* renamed from: m */
    public final void m9559m(zzha zzhaVar) {
        C0813ca.m2729k(zzhaVar);
        m9558j(new C1609nj(this, zzhaVar));
    }

    /* renamed from: n */
    public final void m9560n(Exception exc, boolean z, boolean z2) {
        this.f7725f |= z;
        if (z) {
            Log.w(this.f7720a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            m9555g(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.f7720a, "Error with data collection. Data lost.", exc);
    }

    /* renamed from: o */
    public final void m9561o(@NonNull String str, Bundle bundle) {
        m9563q(null, str, bundle, false, true, null);
    }

    /* renamed from: p */
    public final void m9562p(String str, String str2, Bundle bundle) {
        m9563q(str, str2, bundle, true, true, null);
    }

    /* renamed from: q */
    public final void m9563q(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        m9558j(new C1721pj(this, l, str, str2, bundle, z, z2));
    }

    /* renamed from: v */
    public final List<Bundle> m9564v(String str, String str2) {
        BinderC1981tt binderC1981tt = new BinderC1981tt();
        m9558j(new C0716aj(this, str, str2, binderC1981tt));
        List<Bundle> list = (List) BinderC1981tt.m8807r(binderC1981tt.m8808O0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    /* renamed from: w */
    public final void m9565w(String str) {
        m9558j(new C0826cj(this, str));
    }

    /* renamed from: x */
    public final void m9566x(String str, String str2, Bundle bundle) {
        m9558j(new C2348yi(this, str, str2, bundle));
    }

    /* renamed from: y */
    public final void m9567y(boolean z) {
        m9558j(new C1660oj(this, z));
    }
}
