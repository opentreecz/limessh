package cz.opentree;

import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzgx;
import com.google.android.gms.measurement.internal.zzha;
import com.google.android.gms.measurement.internal.zzkn;
import com.google.android.gms.measurement.internal.zzy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* loaded from: classes.dex */
public final class y00 extends AbstractC0742ay {

    /* renamed from: c */
    public r10 f8096c;

    /* renamed from: d */
    public zzgx f8097d;

    /* renamed from: e */
    public final Set<zzha> f8098e;

    /* renamed from: f */
    public boolean f8099f;

    /* renamed from: g */
    public final AtomicReference<String> f8100g;

    /* renamed from: h */
    public final l40 f8101h;

    /* renamed from: i */
    public boolean f8102i;

    public y00(C2144uz c2144uz) {
        super(c2144uz);
        this.f8098e = new CopyOnWriteArraySet();
        this.f8102i = true;
        this.f8100g = new AtomicReference<>();
        this.f8101h = new l40(c2144uz);
    }

    @WorkerThread
    /* renamed from: A0 */
    public final void m9994A0(Bundle bundle) {
        mo7585d();
        m2299y();
        C0813ca.m2729k(bundle);
        C0813ca.m2725g(bundle.getString("name"));
        if (!this.f5899a.m9122q()) {
            mo1484j().m8530P().m9083a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            m10664s().m3950Q(new zzy(bundle.getString("app_id"), bundle.getString("origin"), new zzkn(bundle.getString("name"), 0L, null, null), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), m7588m().m4015F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), bundle.getLong("creation_timestamp"), true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // cz.opentree.AbstractC0742ay
    /* renamed from: B */
    public final boolean mo1960B() {
        return false;
    }

    @WorkerThread
    /* renamed from: B0 */
    public final void m9995B0(boolean z) {
        mo7585d();
        mo7583b();
        m2299y();
        mo1484j().m8529O().m9084b("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        m7589n().m3602z(z);
        m10028l0();
    }

    /* renamed from: C */
    public final ArrayList<Bundle> m9996C(String str, String str2) {
        mo7583b();
        return m10029m0(null, str, str2);
    }

    /* renamed from: D */
    public final ArrayList<Bundle> m9997D(String str, String str2, String str3) {
        C0813ca.m2725g(str);
        mo7582a();
        throw null;
    }

    /* renamed from: E */
    public final Map<String, Object> m9998E(String str, String str2, String str3, boolean z) {
        C0813ca.m2725g(str);
        mo7582a();
        throw null;
    }

    /* renamed from: F */
    public final Map<String, Object> m9999F(String str, String str2, boolean z) {
        mo7583b();
        return m10030n0(null, str, str2, z);
    }

    /* renamed from: G */
    public final void m10000G(long j) {
        mo7583b();
        mo1481g().m8281A(new s10(this, j));
    }

    /* renamed from: H */
    public final void m10001H(Bundle bundle) {
        m10002I(bundle, mo1483i().mo1177a());
    }

    /* renamed from: I */
    public final void m10002I(Bundle bundle, long j) {
        C0813ca.m2729k(bundle);
        mo7583b();
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            mo1484j().m8525K().m9083a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        m10033q0(bundle2, j);
    }

    @WorkerThread
    /* renamed from: J */
    public final void m10003J(zzgx zzgxVar) {
        zzgx zzgxVar2;
        mo7585d();
        mo7583b();
        m2299y();
        if (zzgxVar != null && zzgxVar != (zzgxVar2 = this.f8097d)) {
            C0813ca.m2733o(zzgxVar2 == null, "EventInterceptor already set.");
        }
        this.f8097d = zzgxVar;
    }

    /* renamed from: K */
    public final void m10004K(zzha zzhaVar) {
        mo7583b();
        m2299y();
        C0813ca.m2729k(zzhaVar);
        if (this.f8098e.add(zzhaVar)) {
            return;
        }
        mo1484j().m8525K().m9083a("OnEventListener already registered");
    }

    /* renamed from: O */
    public final void m10005O(@Nullable String str) {
        this.f8100g.set(str);
    }

    @WorkerThread
    /* renamed from: P */
    public final void m10006P(String str, String str2, long j, Bundle bundle) {
        mo7583b();
        mo7585d();
        m10007Q(str, str2, j, bundle, true, this.f8097d == null || g40.m3984B0(str2), false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0595  */
    /* JADX WARN: Removed duplicated region for block: B:198:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0462  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0510  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x03dc  */
    @androidx.annotation.WorkerThread
    /* renamed from: Q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10007Q(java.lang.String r28, java.lang.String r29, long r30, android.os.Bundle r32, boolean r33, boolean r34, boolean r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 1453
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.y00.m10007Q(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    /* renamed from: R */
    public final void m10008R(String str, String str2, long j, Object obj) {
        mo1481g().m8281A(new d10(this, str, str2, obj, j));
    }

    /* renamed from: S */
    public final void m10009S(String str, String str2, Bundle bundle) {
        m10011U(str, str2, bundle, true, true, mo1483i().mo1177a());
    }

    /* renamed from: T */
    public final void m10010T(String str, String str2, Bundle bundle, boolean z) {
        m10011U(str, str2, bundle, false, true, mo1483i().mo1177a());
    }

    /* renamed from: U */
    public final void m10011U(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        mo7583b();
        m10035t0(str == null ? "app" : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.f8097d == null || g40.m3984B0(str2), !z, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
    @androidx.annotation.WorkerThread
    /* renamed from: V */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m10012V(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            cz.opentree.C0813ca.m2725g(r9)
            cz.opentree.C0813ca.m2725g(r10)
            r8.mo7585d()
            r8.mo7583b()
            r8.m2299y()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L63
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L53
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L53
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L38
            r4 = r2
            goto L3a
        L38:
            r4 = 0
        L3a:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            cz.opentree.ez r0 = r8.m7589n()
            cz.opentree.kz r0 = r0.f2574s
            long r4 = r10.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4e
            java.lang.String r11 = "true"
        L4e:
            r0.m6013b(r11)
            r6 = r10
            goto L61
        L53:
            if (r11 != 0) goto L63
            cz.opentree.ez r10 = r8.m7589n()
            cz.opentree.kz r10 = r10.f2574s
            java.lang.String r0 = "unset"
            r10.m6013b(r0)
            r6 = r11
        L61:
            r3 = r1
            goto L65
        L63:
            r3 = r10
            r6 = r11
        L65:
            cz.opentree.uz r10 = r8.f5899a
            boolean r10 = r10.m9122q()
            if (r10 != 0) goto L7b
            cz.opentree.sy r9 = r8.mo1484j()
            cz.opentree.uy r9 = r9.m8530P()
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.m9083a(r10)
            return
        L7b:
            cz.opentree.uz r10 = r8.f5899a
            boolean r10 = r10.m9127v()
            if (r10 != 0) goto L84
            return
        L84:
            com.google.android.gms.measurement.internal.zzkn r10 = new com.google.android.gms.measurement.internal.zzkn
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            cz.opentree.g20 r9 = r8.m10664s()
            r9.m3949P(r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.y00.m10012V(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    /* renamed from: W */
    public final void m10013W(String str, String str2, Object obj, boolean z) {
        m10014X(str, str2, obj, z, mo1483i().mo1177a());
    }

    /* renamed from: X */
    public final void m10014X(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        if (z) {
            i = m7588m().m4050w0(str2);
        } else {
            g40 m7588m = m7588m();
            if (m7588m.m4040f0("user property", str2)) {
                if (!m7588m.m4043k0("user property", u00.f6880a, str2)) {
                    i = 15;
                } else if (m7588m.m4039e0("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            m7588m();
            this.f5899a.m9102H().m4023K(i, "_ev", g40.m3987I(str2, 24, true), str2 != null ? str2.length() : 0);
            return;
        }
        if (obj == null) {
            m10008R(str3, str2, j, null);
            return;
        }
        int m4045o0 = m7588m().m4045o0(str2, obj);
        if (m4045o0 != 0) {
            m7588m();
            this.f5899a.m9102H().m4023K(m4045o0, "_ev", g40.m3987I(str2, 24, true), ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0);
        } else {
            Object m4051x0 = m7588m().m4051x0(str2, obj);
            if (m4051x0 != null) {
                m10008R(str3, str2, j, m4051x0);
            }
        }
    }

    /* renamed from: Y */
    public final void m10015Y(String str, String str2, String str3, Bundle bundle) {
        C0813ca.m2725g(str);
        mo7582a();
        throw null;
    }

    /* renamed from: Z */
    public final void m10016Z(boolean z) {
        m2299y();
        mo7583b();
        mo1481g().m8281A(new n10(this, z));
    }

    /* renamed from: a0 */
    public final void m10017a0() {
        if (mo1482h().getApplicationContext() instanceof Application) {
            ((Application) mo1482h().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f8096c);
        }
    }

    /* renamed from: b0 */
    public final Boolean m10018b0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) mo1481g().m8285w(atomicReference, 15000L, "boolean test flag value", new z00(this, atomicReference));
    }

    /* renamed from: c0 */
    public final String m10019c0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) mo1481g().m8285w(atomicReference, 15000L, "String test flag value", new h10(this, atomicReference));
    }

    /* renamed from: d0 */
    public final Long m10020d0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) mo1481g().m8285w(atomicReference, 15000L, "long test flag value", new m10(this, atomicReference));
    }

    /* renamed from: e0 */
    public final Integer m10021e0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) mo1481g().m8285w(atomicReference, 15000L, "int test flag value", new l10(this, atomicReference));
    }

    /* renamed from: f0 */
    public final Double m10022f0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) mo1481g().m8285w(atomicReference, 15000L, "double test flag value", new o10(this, atomicReference));
    }

    @Nullable
    /* renamed from: g0 */
    public final String m10023g0() {
        mo7583b();
        return this.f8100g.get();
    }

    @WorkerThread
    /* renamed from: h0 */
    public final void m10024h0() {
        mo7585d();
        mo7583b();
        m2299y();
        if (this.f5899a.m9127v()) {
            if (m7590o().m2630u(C1735pu.f5842j0)) {
                C0796bu m7590o = m7590o();
                m7590o.mo1480f();
                Boolean m2635z = m7590o.m2635z("google_analytics_deferred_deep_link_enabled");
                if (m2635z != null && m2635z.booleanValue()) {
                    mo1484j().m8529O().m9083a("Deferred Deep Link feature enabled.");
                    mo1481g().m8281A(new Runnable(this) { // from class: cz.opentree.a10

                        /* renamed from: O */
                        public final y00 f1308O;

                        {
                            this.f1308O = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            y00 y00Var = this.f1308O;
                            y00Var.mo7585d();
                            if (y00Var.m7589n().f2580y.m4292b()) {
                                y00Var.mo1484j().m8529O().m9083a("Deferred Deep Link already retrieved. Not fetching again.");
                                return;
                            }
                            long m4968a = y00Var.m7589n().f2581z.m4968a();
                            y00Var.m7589n().f2581z.m4969b(1 + m4968a);
                            if (m4968a < 5) {
                                y00Var.f5899a.m9128w();
                            } else {
                                y00Var.mo1484j().m8525K().m9083a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
                                y00Var.m7589n().f2580y.m4291a(true);
                            }
                        }
                    });
                }
            }
            m10664s().m3958Y();
            this.f8102i = false;
            String m3594J = m7589n().m3594J();
            if (TextUtils.isEmpty(m3594J)) {
                return;
            }
            m7586e().m7166q();
            if (m3594J.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", m3594J);
            m10009S("auto", "_ou", bundle);
        }
    }

    @Nullable
    /* renamed from: i0 */
    public final String m10025i0() {
        b20 m1969Q = this.f5899a.m9110P().m1969Q();
        if (m1969Q != null) {
            return m1969Q.f1588a;
        }
        return null;
    }

    @Nullable
    /* renamed from: j0 */
    public final String m10026j0() {
        b20 m1969Q = this.f5899a.m9110P().m1969Q();
        if (m1969Q != null) {
            return m1969Q.f1589b;
        }
        return null;
    }

    @Nullable
    /* renamed from: k0 */
    public final String m10027k0() {
        if (this.f5899a.m9106L() != null) {
            return this.f5899a.m9106L();
        }
        try {
            return new C0977fa(mo1482h()).m3696a("google_app_id");
        } catch (IllegalStateException e) {
            this.f5899a.mo1484j().m8522H().m9084b("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    @WorkerThread
    /* renamed from: l0 */
    public final void m10028l0() {
        mo7585d();
        String m6012a = m7589n().f2574s.m6012a();
        if (m6012a != null) {
            if ("unset".equals(m6012a)) {
                m10012V("app", "_npa", null, mo1483i().mo1177a());
            } else {
                m10012V("app", "_npa", Long.valueOf("true".equals(m6012a) ? 1L : 0L), mo1483i().mo1177a());
            }
        }
        if (!this.f5899a.m9122q() || !this.f8102i) {
            mo1484j().m8529O().m9083a("Updating Scion state (FE)");
            m10664s().m3956W();
            return;
        }
        mo1484j().m8529O().m9083a("Recording app launch after enabling measurement for the first time (FE)");
        m10024h0();
        if (C2310xr.m9876b() && m7590o().m2630u(C1735pu.f5872y0)) {
            m10667v().f4450d.m8587a();
        }
        if (C1882sr.m8481b() && m7590o().m2630u(C1735pu.f5785D0)) {
            if (!(this.f5899a.m9099E().f5391a.m9096B().f2566k.m4968a() > 0)) {
                C1626nz m9099E = this.f5899a.m9099E();
                m9099E.f5391a.m9124s();
                m9099E.m6820b(m9099E.f5391a.mo1482h().getPackageName());
            }
        }
        if (m7590o().m2630u(C1735pu.f5813R0)) {
            mo1481g().m8281A(new p10(this));
        }
    }

    /* renamed from: m0 */
    public final ArrayList<Bundle> m10029m0(String str, String str2, String str3) {
        if (mo1481g().m8284I()) {
            mo1484j().m8522H().m9083a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (t40.m8593a()) {
            mo1484j().m8522H().m9083a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f5899a.mo1481g().m8285w(atomicReference, 5000L, "get conditional user properties", new k10(this, atomicReference, str, str2, str3));
        List list = (List) atomicReference.get();
        if (list != null) {
            return g40.m4002q0(list);
        }
        mo1484j().m8522H().m9084b("Timed out waiting for get conditional user properties", str);
        return new ArrayList<>();
    }

    /* renamed from: n0 */
    public final Map<String, Object> m10030n0(String str, String str2, String str3, boolean z) {
        if (mo1481g().m8284I()) {
            mo1484j().m8522H().m9083a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (t40.m8593a()) {
            mo1484j().m8522H().m9083a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f5899a.mo1481g().m8285w(atomicReference, 5000L, "get user properties", new j10(this, atomicReference, str, str2, str3, z));
        List<zzkn> list = (List) atomicReference.get();
        if (list == null) {
            mo1484j().m8522H().m9084b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzkn zzknVar : list) {
            arrayMap.put(zzknVar.f991P, zzknVar.m1501x());
        }
        return arrayMap;
    }

    /* renamed from: o0 */
    public final void m10031o0(long j) {
        mo7583b();
        mo1481g().m8281A(new c10(this, j));
    }

    /* renamed from: p0 */
    public final void m10032p0(Bundle bundle) {
        C0813ca.m2729k(bundle);
        C0813ca.m2725g(bundle.getString("app_id"));
        mo7582a();
        throw null;
    }

    /* renamed from: q0 */
    public final void m10033q0(Bundle bundle, long j) {
        C0813ca.m2729k(bundle);
        r00.m7839a(bundle, "app_id", String.class, null);
        r00.m7839a(bundle, "origin", String.class, null);
        r00.m7839a(bundle, "name", String.class, null);
        r00.m7839a(bundle, "value", Object.class, null);
        r00.m7839a(bundle, "trigger_event_name", String.class, null);
        r00.m7839a(bundle, "trigger_timeout", Long.class, 0L);
        r00.m7839a(bundle, "timed_out_event_name", String.class, null);
        r00.m7839a(bundle, "timed_out_event_params", Bundle.class, null);
        r00.m7839a(bundle, "triggered_event_name", String.class, null);
        r00.m7839a(bundle, "triggered_event_params", Bundle.class, null);
        r00.m7839a(bundle, "time_to_live", Long.class, 0L);
        r00.m7839a(bundle, "expired_event_name", String.class, null);
        r00.m7839a(bundle, "expired_event_params", Bundle.class, null);
        C0813ca.m2725g(bundle.getString("name"));
        C0813ca.m2725g(bundle.getString("origin"));
        C0813ca.m2729k(bundle.get("value"));
        bundle.putLong("creation_timestamp", j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (m7588m().m4050w0(string) != 0) {
            mo1484j().m8522H().m9084b("Invalid conditional user property name", m7587l().m7805B(string));
            return;
        }
        if (m7588m().m4045o0(string, obj) != 0) {
            mo1484j().m8522H().m9085c("Invalid conditional user property value", m7587l().m7805B(string), obj);
            return;
        }
        Object m4051x0 = m7588m().m4051x0(string, obj);
        if (m4051x0 == null) {
            mo1484j().m8522H().m9085c("Unable to normalize conditional user property value", m7587l().m7805B(string), obj);
            return;
        }
        r00.m7840b(bundle, m4051x0);
        long j2 = bundle.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            mo1484j().m8522H().m9085c("Invalid conditional user property timeout", m7587l().m7805B(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle.getLong("time_to_live");
        if (j3 > 15552000000L || j3 < 1) {
            mo1484j().m8522H().m9085c("Invalid conditional user property time to live", m7587l().m7805B(string), Long.valueOf(j3));
        } else {
            mo1481g().m8281A(new f10(this, bundle));
        }
    }

    /* renamed from: r0 */
    public final void m10034r0(zzha zzhaVar) {
        mo7583b();
        m2299y();
        C0813ca.m2729k(zzhaVar);
        if (this.f8098e.remove(zzhaVar)) {
            return;
        }
        mo1484j().m8525K().m9083a("OnEventListener had not been registered");
    }

    /* renamed from: t0 */
    public final void m10035t0(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        mo1481g().m8281A(new b10(this, str, str2, j, g40.m4001p0(bundle), z, z2, z3, str3));
    }

    @WorkerThread
    /* renamed from: u0 */
    public final void m10036u0(String str, String str2, Bundle bundle) {
        mo7583b();
        mo7585d();
        m10006P(str, str2, mo1483i().mo1177a(), bundle);
    }

    /* renamed from: v0 */
    public final void m10037v0(String str, String str2, String str3, Bundle bundle) {
        long mo1177a = mo1483i().mo1177a();
        C0813ca.m2725g(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", mo1177a);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        mo1481g().m8281A(new i10(this, bundle2));
    }

    /* renamed from: w0 */
    public final void m10038w0(boolean z) {
        m2299y();
        mo7583b();
        mo1481g().m8281A(new q10(this, z));
    }

    @WorkerThread
    /* renamed from: x0 */
    public final void m10039x0(Bundle bundle) {
        mo7585d();
        m2299y();
        C0813ca.m2729k(bundle);
        C0813ca.m2725g(bundle.getString("name"));
        C0813ca.m2725g(bundle.getString("origin"));
        C0813ca.m2729k(bundle.get("value"));
        if (!this.f5899a.m9122q()) {
            mo1484j().m8530P().m9083a("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkn zzknVar = new zzkn(bundle.getString("name"), bundle.getLong("triggered_timestamp"), bundle.get("value"), bundle.getString("origin"));
        try {
            zzaq m4015F = m7588m().m4015F(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), bundle.getString("origin"), 0L, true, false);
            m10664s().m3950Q(new zzy(bundle.getString("app_id"), bundle.getString("origin"), zzknVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), m7588m().m4015F(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), bundle.getString("origin"), 0L, true, false), bundle.getLong("trigger_timeout"), m4015F, bundle.getLong("time_to_live"), m7588m().m4015F(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), bundle.getString("origin"), 0L, true, false)));
        } catch (IllegalArgumentException unused) {
        }
    }

    /* renamed from: y0 */
    public final void m10040y0(String str, String str2, Bundle bundle) {
        mo7583b();
        m10037v0(null, str, str2, bundle);
    }

    /* renamed from: z0 */
    public final void m10041z0(long j) {
        m10005O(null);
        mo1481g().m8281A(new e10(this, j));
    }
}
