package com.sonelli;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.internal.zzac;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: com.sonelli.bu */
/* loaded from: classes.dex */
public final class C0796bu extends q00 {

    /* renamed from: b */
    public Boolean f1825b;

    /* renamed from: c */
    @NonNull
    public zzac f1826c;

    /* renamed from: d */
    public Boolean f1827d;

    public C0796bu(C2144uz c2144uz) {
        super(c2144uz);
        this.f1826c = w40.f7619a;
    }

    /* renamed from: N */
    public static long m2605N() {
        return C1735pu.f5786E.m6320a(null).longValue();
    }

    /* renamed from: O */
    public static long m2606O() {
        return C1735pu.f5831e.m6320a(null).longValue();
    }

    @WorkerThread
    /* renamed from: A */
    public final boolean m2607A(String str, @NonNull C1529ly<Boolean> c1529ly) {
        if (str == null) {
            return c1529ly.m6320a(null).booleanValue();
        }
        String mo1452k = this.f1826c.mo1452k(str, c1529ly.m6321b());
        return TextUtils.isEmpty(mo1452k) ? c1529ly.m6320a(null).booleanValue() : c1529ly.m6320a(Boolean.valueOf(Boolean.parseBoolean(mo1452k))).booleanValue();
    }

    /* renamed from: B */
    public final int m2608B() {
        return (C0842cr.m2977b() && m7590o().m2607A(null, C1735pu.f5805N0) && m7588m().m4022J0() >= 2147483) ? 100 : 25;
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @androidx.annotation.Nullable
    /* renamed from: C */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<java.lang.String> m2609C(@androidx.annotation.Size(min = 1) java.lang.String r4) {
        /*
            r3 = this;
            com.sonelli.C0813ca.m2725g(r4)
            android.os.Bundle r0 = r3.m2623S()
            r1 = 0
            if (r0 != 0) goto L19
            com.sonelli.sy r4 = r3.mo1484j()
            com.sonelli.uy r4 = r4.m8522H()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.m9083a(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.mo1482h()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            com.sonelli.sy r0 = r3.mo1484j()
            com.sonelli.uy r0 = r0.m8522H()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.m9084b(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C0796bu.m2609C(java.lang.String):java.util.List");
    }

    /* renamed from: D */
    public final boolean m2610D(String str, C1529ly<Boolean> c1529ly) {
        return m2607A(str, c1529ly);
    }

    /* renamed from: E */
    public final long m2611E() {
        mo1480f();
        return 27000L;
    }

    /* renamed from: F */
    public final boolean m2612F(String str) {
        return "1".equals(this.f1826c.mo1452k(str, "gaia_collection_enabled"));
    }

    /* renamed from: G */
    public final boolean m2613G() {
        if (this.f1827d == null) {
            synchronized (this) {
                if (this.f1827d == null) {
                    ApplicationInfo applicationInfo = mo1482h().getApplicationInfo();
                    String m6396a = C1547mc.m6396a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f1827d = Boolean.valueOf(str != null && str.equals(m6396a));
                    }
                    if (this.f1827d == null) {
                        this.f1827d = Boolean.TRUE;
                        mo1484j().m8522H().m9083a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f1827d.booleanValue();
    }

    /* renamed from: H */
    public final boolean m2614H(String str) {
        return "1".equals(this.f1826c.mo1452k(str, "measurement.event_sampling_enabled"));
    }

    /* renamed from: I */
    public final boolean m2615I() {
        mo1480f();
        Boolean m2635z = m2635z("firebase_analytics_collection_deactivated");
        return m2635z != null && m2635z.booleanValue();
    }

    @WorkerThread
    /* renamed from: J */
    public final boolean m2616J(String str) {
        return m2607A(str, C1735pu.f5800L);
    }

    /* renamed from: K */
    public final Boolean m2617K() {
        mo7583b();
        Boolean m2635z = m2635z("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(m2635z == null || m2635z.booleanValue());
    }

    @WorkerThread
    /* renamed from: L */
    public final String m2618L(String str) {
        C1529ly<String> c1529ly = C1735pu.f5802M;
        return str == null ? c1529ly.m6320a(null) : c1529ly.m6320a(this.f1826c.mo1452k(str, c1529ly.m6321b()));
    }

    /* renamed from: M */
    public final Boolean m2619M() {
        mo7583b();
        if (!C1782qs.m7776b() || !m2630u(C1735pu.f5787E0)) {
            return Boolean.TRUE;
        }
        Boolean m2635z = m2635z("google_analytics_automatic_screen_reporting_enabled");
        return Boolean.valueOf(m2635z == null || m2635z.booleanValue());
    }

    /* renamed from: P */
    public final String m2620P() {
        return m2624k("debug.firebase.analytics.app", "");
    }

    /* renamed from: Q */
    public final String m2621Q() {
        return m2624k("debug.deferred.deeplink", "");
    }

    @WorkerThread
    /* renamed from: R */
    public final boolean m2622R() {
        if (this.f1825b == null) {
            Boolean m2635z = m2635z("app_measurement_lite");
            this.f1825b = m2635z;
            if (m2635z == null) {
                this.f1825b = Boolean.FALSE;
            }
        }
        return this.f1825b.booleanValue() || !this.f5899a.m9109O();
    }

    @Nullable
    /* renamed from: S */
    public final Bundle m2623S() {
        try {
            if (mo1482h().getPackageManager() == null) {
                mo1484j().m8522H().m9083a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo m9466c = C2272xc.m9755a(mo1482h()).m9466c(mo1482h().getPackageName(), 128);
            if (m9466c != null) {
                return m9466c.metaData;
            }
            mo1484j().m8522H().m9083a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            mo1484j().m8522H().m9084b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    /* renamed from: k */
    public final String m2624k(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (ClassNotFoundException e) {
            mo1484j().m8522H().m9084b("Could not find SystemProperties class", e);
            return str2;
        } catch (IllegalAccessException e2) {
            mo1484j().m8522H().m9084b("Could not access SystemProperties.get()", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            mo1484j().m8522H().m9084b("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            mo1484j().m8522H().m9084b("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* renamed from: p */
    public final int m2625p(@Size(min = 1) String str) {
        if (C0842cr.m2977b() && m2607A(null, C1735pu.f5803M0)) {
            return m2626q(str, C1735pu.f5794I, 500, RecyclerView.MAX_SCROLL_DURATION);
        }
        return 500;
    }

    @WorkerThread
    /* renamed from: q */
    public final int m2626q(String str, @NonNull C1529ly<Integer> c1529ly, int i, int i2) {
        return Math.max(Math.min(m2632w(str, c1529ly), i2), i);
    }

    @WorkerThread
    /* renamed from: r */
    public final long m2627r(String str, @NonNull C1529ly<Long> c1529ly) {
        if (str == null) {
            return c1529ly.m6320a(null).longValue();
        }
        String mo1452k = this.f1826c.mo1452k(str, c1529ly.m6321b());
        if (TextUtils.isEmpty(mo1452k)) {
            return c1529ly.m6320a(null).longValue();
        }
        try {
            return c1529ly.m6320a(Long.valueOf(Long.parseLong(mo1452k))).longValue();
        } catch (NumberFormatException unused) {
            return c1529ly.m6320a(null).longValue();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x002d, code lost:
    
        if (android.text.TextUtils.isEmpty(r1) != false) goto L10;
     */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m2628s(com.sonelli.C2318xz r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.m9899A()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
            boolean r1 = com.sonelli.C1011fs.m3874b()
            if (r1 == 0) goto L2f
            com.sonelli.bu r1 = r5.m7590o()
            java.lang.String r2 = r6.m9957t()
            com.sonelli.ly<java.lang.Boolean> r3 = com.sonelli.C1735pu.f5856q0
            boolean r1 = r1.m2607A(r2, r3)
            if (r1 == 0) goto L2f
            java.lang.String r1 = r6.m9905G()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L33
        L2f:
            java.lang.String r1 = r6.m9902D()
        L33:
            com.sonelli.ly<java.lang.String> r2 = com.sonelli.C1735pu.f5833f
            r3 = 0
            java.lang.Object r2 = r2.m6320a(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.sonelli.ly<java.lang.String> r4 = com.sonelli.C1735pu.f5835g
            java.lang.Object r3 = r4.m6320a(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L5d
            java.lang.String r1 = r3.concat(r1)
            goto L62
        L5d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L62:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.m9961x()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            long r1 = r5.m2611E()
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "gmp_version"
            r6.appendQueryParameter(r2, r1)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.C0796bu.m2628s(com.sonelli.xz):java.lang.String");
    }

    /* renamed from: t */
    public final void m2629t(@NonNull zzac zzacVar) {
        this.f1826c = zzacVar;
    }

    /* renamed from: u */
    public final boolean m2630u(C1529ly<Boolean> c1529ly) {
        return m2607A(null, c1529ly);
    }

    @WorkerThread
    /* renamed from: v */
    public final int m2631v(@Size(min = 1) String str) {
        return m2632w(str, C1735pu.f5853p);
    }

    @WorkerThread
    /* renamed from: w */
    public final int m2632w(String str, @NonNull C1529ly<Integer> c1529ly) {
        if (str == null) {
            return c1529ly.m6320a(null).intValue();
        }
        String mo1452k = this.f1826c.mo1452k(str, c1529ly.m6321b());
        if (TextUtils.isEmpty(mo1452k)) {
            return c1529ly.m6320a(null).intValue();
        }
        try {
            return c1529ly.m6320a(Integer.valueOf(Integer.parseInt(mo1452k))).intValue();
        } catch (NumberFormatException unused) {
            return c1529ly.m6320a(null).intValue();
        }
    }

    @WorkerThread
    /* renamed from: x */
    public final double m2633x(String str, @NonNull C1529ly<Double> c1529ly) {
        if (str == null) {
            return c1529ly.m6320a(null).doubleValue();
        }
        String mo1452k = this.f1826c.mo1452k(str, c1529ly.m6321b());
        if (TextUtils.isEmpty(mo1452k)) {
            return c1529ly.m6320a(null).doubleValue();
        }
        try {
            return c1529ly.m6320a(Double.valueOf(Double.parseDouble(mo1452k))).doubleValue();
        } catch (NumberFormatException unused) {
            return c1529ly.m6320a(null).doubleValue();
        }
    }

    /* renamed from: y */
    public final int m2634y(@Size(min = 1) String str) {
        if (C0842cr.m2977b() && m2607A(null, C1735pu.f5803M0)) {
            return m2626q(str, C1735pu.f5792H, 25, 100);
        }
        return 25;
    }

    @Nullable
    /* renamed from: z */
    public final Boolean m2635z(@Size(min = 1) String str) {
        C0813ca.m2725g(str);
        Bundle m2623S = m2623S();
        if (m2623S == null) {
            mo1484j().m8522H().m9083a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (m2623S.containsKey(str)) {
            return Boolean.valueOf(m2623S.getBoolean(str));
        }
        return null;
    }
}
