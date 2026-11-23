package cz.opentree;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzaa;
import com.google.android.gms.measurement.internal.zzgu;
import com.google.android.gms.measurement.internal.zzib;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.uz */
/* loaded from: classes.dex */
public class C2144uz implements zzgu {

    /* renamed from: G */
    public static volatile C2144uz f7333G;

    /* renamed from: A */
    public volatile Boolean f7334A;

    /* renamed from: B */
    public Boolean f7335B;

    /* renamed from: C */
    public Boolean f7336C;

    /* renamed from: D */
    public int f7337D;

    /* renamed from: F */
    public final long f7339F;

    /* renamed from: a */
    public final Context f7340a;

    /* renamed from: b */
    public final String f7341b;

    /* renamed from: c */
    public final String f7342c;

    /* renamed from: d */
    public final String f7343d;

    /* renamed from: e */
    public final boolean f7344e;

    /* renamed from: f */
    public final t40 f7345f;

    /* renamed from: g */
    public final C0796bu f7346g;

    /* renamed from: h */
    public final C0960ez f7347h;

    /* renamed from: i */
    public final C1889sy f7348i;

    /* renamed from: j */
    public final C1839rz f7349j;

    /* renamed from: k */
    public final k30 f7350k;

    /* renamed from: l */
    public final g40 f7351l;

    /* renamed from: m */
    public final C1790qy f7352m;

    /* renamed from: n */
    public final Clock f7353n;

    /* renamed from: o */
    public final a20 f7354o;

    /* renamed from: p */
    public final y00 f7355p;

    /* renamed from: q */
    public final C2313xu f7356q;

    /* renamed from: r */
    public final v10 f7357r;

    /* renamed from: s */
    public C1681oy f7358s;

    /* renamed from: t */
    public g20 f7359t;

    /* renamed from: u */
    public C1236ju f7360u;

    /* renamed from: v */
    public C1740py f7361v;

    /* renamed from: w */
    public C1626nz f7362w;

    /* renamed from: y */
    public Boolean f7364y;

    /* renamed from: z */
    public long f7365z;

    /* renamed from: x */
    public boolean f7363x = false;

    /* renamed from: E */
    public AtomicInteger f7338E = new AtomicInteger(0);

    public C2144uz(v00 v00Var) {
        Bundle bundle;
        boolean z = false;
        C0813ca.m2729k(v00Var);
        Context context = v00Var.f7372a;
        t40 t40Var = new t40(context);
        this.f7345f = t40Var;
        C1478ky.f4675a = t40Var;
        this.f7340a = context;
        this.f7341b = v00Var.f7373b;
        this.f7342c = v00Var.f7374c;
        this.f7343d = v00Var.f7375d;
        this.f7344e = v00Var.f7379h;
        this.f7334A = v00Var.f7376e;
        zzaa zzaaVar = v00Var.f7378g;
        if (zzaaVar != null && (bundle = zzaaVar.f971U) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.f7335B = (Boolean) obj;
            }
            Object obj2 = zzaaVar.f971U.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.f7336C = (Boolean) obj2;
            }
        }
        AbstractC1559ml.m6450h(context);
        Clock m3474d = C0921ec.m3474d();
        this.f7353n = m3474d;
        Long l = v00Var.f7380i;
        this.f7339F = l != null ? l.longValue() : m3474d.mo1177a();
        this.f7346g = new C0796bu(this);
        C0960ez c0960ez = new C0960ez(this);
        c0960ez.m7167r();
        this.f7347h = c0960ez;
        C1889sy c1889sy = new C1889sy(this);
        c1889sy.m7167r();
        this.f7348i = c1889sy;
        g40 g40Var = new g40(this);
        g40Var.m7167r();
        this.f7351l = g40Var;
        C1790qy c1790qy = new C1790qy(this);
        c1790qy.m7167r();
        this.f7352m = c1790qy;
        this.f7356q = new C2313xu(this);
        a20 a20Var = new a20(this);
        a20Var.m2300z();
        this.f7354o = a20Var;
        y00 y00Var = new y00(this);
        y00Var.m2300z();
        this.f7355p = y00Var;
        k30 k30Var = new k30(this);
        k30Var.m2300z();
        this.f7350k = k30Var;
        v10 v10Var = new v10(this);
        v10Var.m7167r();
        this.f7357r = v10Var;
        C1839rz c1839rz = new C1839rz(this);
        c1839rz.m7167r();
        this.f7349j = c1839rz;
        zzaa zzaaVar2 = v00Var.f7378g;
        if (zzaaVar2 != null && zzaaVar2.f966P != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            y00 m9101G = m9101G();
            if (m9101G.mo1482h().getApplicationContext() instanceof Application) {
                Application application = (Application) m9101G.mo1482h().getApplicationContext();
                if (m9101G.f8096c == null) {
                    m9101G.f8096c = new r10(m9101G, null);
                }
                if (z2) {
                    application.unregisterActivityLifecycleCallbacks(m9101G.f8096c);
                    application.registerActivityLifecycleCallbacks(m9101G.f8096c);
                    m9101G.mo1484j().m8530P().m9083a("Registered activity lifecycle callback");
                }
            }
        } else {
            mo1484j().m8525K().m9083a("Application context is not an Application");
        }
        c1839rz.m8281A(new RunnableC2251wz(this, v00Var));
    }

    /* renamed from: A */
    public static void m9090A(p00 p00Var) {
        if (p00Var == null) {
            throw new IllegalStateException("Component not created");
        }
        if (p00Var.m7169u()) {
            return;
        }
        String valueOf = String.valueOf(p00Var.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: a */
    public static C2144uz m9091a(Context context, zzaa zzaaVar, Long l) {
        Bundle bundle;
        if (zzaaVar != null && (zzaaVar.f969S == null || zzaaVar.f970T == null)) {
            zzaaVar = new zzaa(zzaaVar.f965O, zzaaVar.f966P, zzaaVar.f967Q, zzaaVar.f968R, null, null, zzaaVar.f971U);
        }
        C0813ca.m2729k(context);
        C0813ca.m2729k(context.getApplicationContext());
        if (f7333G == null) {
            synchronized (C2144uz.class) {
                if (f7333G == null) {
                    f7333G = new C2144uz(new v00(context, zzaaVar, l));
                }
            }
        } else if (zzaaVar != null && (bundle = zzaaVar.f971U) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            f7333G.m9120o(zzaaVar.f971U.getBoolean("dataCollectionDefaultEnabled"));
        }
        return f7333G;
    }

    /* renamed from: b */
    public static C2144uz m9092b(Context context, String str, String str2, Bundle bundle) {
        return m9091a(context, new zzaa(0L, 0L, true, null, null, null, bundle), null);
    }

    /* renamed from: l */
    public static void m9094l(q00 q00Var) {
        if (q00Var == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    /* renamed from: z */
    public static void m9095z(AbstractC0742ay abstractC0742ay) {
        if (abstractC0742ay == null) {
            throw new IllegalStateException("Component not created");
        }
        if (abstractC0742ay.m2298x()) {
            return;
        }
        String valueOf = String.valueOf(abstractC0742ay.getClass());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("Component not initialized: ");
        sb.append(valueOf);
        throw new IllegalStateException(sb.toString());
    }

    /* renamed from: B */
    public final C0960ez m9096B() {
        m9094l(this.f7347h);
        return this.f7347h;
    }

    /* renamed from: C */
    public final C1889sy m9097C() {
        C1889sy c1889sy = this.f7348i;
        if (c1889sy == null || !c1889sy.m7169u()) {
            return null;
        }
        return this.f7348i;
    }

    /* renamed from: D */
    public final k30 m9098D() {
        m9095z(this.f7350k);
        return this.f7350k;
    }

    /* renamed from: E */
    public final C1626nz m9099E() {
        return this.f7362w;
    }

    /* renamed from: F */
    public final C1839rz m9100F() {
        return this.f7349j;
    }

    /* renamed from: G */
    public final y00 m9101G() {
        m9095z(this.f7355p);
        return this.f7355p;
    }

    /* renamed from: H */
    public final g40 m9102H() {
        m9094l(this.f7351l);
        return this.f7351l;
    }

    /* renamed from: I */
    public final C1790qy m9103I() {
        m9094l(this.f7352m);
        return this.f7352m;
    }

    /* renamed from: J */
    public final C1681oy m9104J() {
        m9095z(this.f7358s);
        return this.f7358s;
    }

    /* renamed from: K */
    public final boolean m9105K() {
        return TextUtils.isEmpty(this.f7341b);
    }

    /* renamed from: L */
    public final String m9106L() {
        return this.f7341b;
    }

    /* renamed from: M */
    public final String m9107M() {
        return this.f7342c;
    }

    /* renamed from: N */
    public final String m9108N() {
        return this.f7343d;
    }

    /* renamed from: O */
    public final boolean m9109O() {
        return this.f7344e;
    }

    /* renamed from: P */
    public final a20 m9110P() {
        m9095z(this.f7354o);
        return this.f7354o;
    }

    /* renamed from: Q */
    public final g20 m9111Q() {
        m9095z(this.f7359t);
        return this.f7359t;
    }

    /* renamed from: R */
    public final C1236ju m9112R() {
        m9090A(this.f7360u);
        return this.f7360u;
    }

    /* renamed from: S */
    public final C1740py m9113S() {
        m9095z(this.f7361v);
        return this.f7361v;
    }

    /* renamed from: T */
    public final C2313xu m9114T() {
        C2313xu c2313xu = this.f7356q;
        if (c2313xu != null) {
            return c2313xu;
        }
        throw new IllegalStateException("Component not created");
    }

    @WorkerThread
    /* renamed from: c */
    public final void m9115c() {
        mo1481g().mo7585d();
        if (m9096B().f2560e.m4968a() == 0) {
            m9096B().f2560e.m4969b(this.f7353n.mo1177a());
        }
        if (Long.valueOf(m9096B().f2565j.m4968a()).longValue() == 0) {
            mo1484j().m8530P().m9084b("Persisting first open", Long.valueOf(this.f7339F));
            m9096B().f2565j.m4969b(this.f7339F);
        }
        if (this.f7346g.m2630u(C1735pu.f5813R0)) {
            m9101G().f8101h.m6064c();
        }
        if (m9127v()) {
            if (!TextUtils.isEmpty(m9113S().m7572E()) || !TextUtils.isEmpty(m9113S().m7573F())) {
                m9102H();
                if (g40.m3997i0(m9113S().m7572E(), m9096B().m3589E(), m9113S().m7573F(), m9096B().m3590F())) {
                    mo1484j().m8528N().m9083a("Rechecking which service to use due to a GMP App Id change");
                    m9096B().m3592H();
                    m9104J().m7126I();
                    this.f7359t.m3961b0();
                    this.f7359t.m3959Z();
                    m9096B().f2565j.m4969b(this.f7339F);
                    m9096B().f2567l.m6013b(null);
                }
                m9096B().m3585A(m9113S().m7572E());
                m9096B().m3587C(m9113S().m7573F());
            }
            m9101G().m10005O(m9096B().f2567l.m6012a());
            if (C1520lr.m6279b() && this.f7346g.m2630u(C1735pu.f5870x0) && !m9102H().m4028N0() && !TextUtils.isEmpty(m9096B().f2554A.m6012a())) {
                mo1484j().m8525K().m9083a("Remote config removed with active feature rollouts");
                m9096B().f2554A.m6013b(null);
            }
            if (!TextUtils.isEmpty(m9113S().m7572E()) || !TextUtils.isEmpty(m9113S().m7573F())) {
                boolean m9122q = m9122q();
                if (!m9096B().m3595K() && !this.f7346g.m2615I()) {
                    m9096B().m3586B(!m9122q);
                }
                if (m9122q) {
                    m9101G().m10024h0();
                }
                m9098D().f4450d.m8587a();
                m9111Q().m3952S(new AtomicReference<>());
            }
        } else if (m9122q()) {
            if (!m9102H().m4009A0("android.permission.INTERNET")) {
                mo1484j().m8522H().m9083a("App is missing INTERNET permission");
            }
            if (!m9102H().m4009A0("android.permission.ACCESS_NETWORK_STATE")) {
                mo1484j().m8522H().m9083a("App is missing ACCESS_NETWORK_STATE permission");
            }
            if (!C2272xc.m9755a(this.f7340a).m9470g() && !this.f7346g.m2622R()) {
                if (!C1683oz.m7134b(this.f7340a)) {
                    mo1484j().m8522H().m9083a("AppMeasurementReceiver not registered/enabled");
                }
                if (!g40.m3991X(this.f7340a, false)) {
                    mo1484j().m8522H().m9083a("AppMeasurementService not registered/enabled");
                }
            }
            mo1484j().m8522H().m9083a("Uploading is not possible. App measurement disabled");
        }
        m9096B().f2575t.m4291a(this.f7346g.m2630u(C1735pu.f5826b0));
        m9096B().f2576u.m4291a(this.f7346g.m2630u(C1735pu.f5828c0));
    }

    /* renamed from: d */
    public final void m9116d(AbstractC0742ay abstractC0742ay) {
        this.f7337D++;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: f */
    public final t40 mo1480f() {
        return this.f7345f;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: g */
    public final C1839rz mo1481g() {
        m9090A(this.f7349j);
        return this.f7349j;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: h */
    public final Context mo1482h() {
        return this.f7340a;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: i */
    public final Clock mo1483i() {
        return this.f7353n;
    }

    @Override // com.google.android.gms.measurement.internal.zzgu
    /* renamed from: j */
    public final C1889sy mo1484j() {
        m9090A(this.f7348i);
        return this.f7348i;
    }

    /* renamed from: k */
    public final void m9117k(p00 p00Var) {
        this.f7337D++;
    }

    @WorkerThread
    /* renamed from: m */
    public final void m9118m(v00 v00Var) {
        String concat;
        C2142uy c2142uy;
        mo1481g().mo7585d();
        C1236ju c1236ju = new C1236ju(this);
        c1236ju.m7167r();
        this.f7360u = c1236ju;
        C1740py c1740py = new C1740py(this, v00Var.f7377f);
        c1740py.m2300z();
        this.f7361v = c1740py;
        C1681oy c1681oy = new C1681oy(this);
        c1681oy.m2300z();
        this.f7358s = c1681oy;
        g20 g20Var = new g20(this);
        g20Var.m2300z();
        this.f7359t = g20Var;
        this.f7351l.m7168s();
        this.f7347h.m7168s();
        this.f7362w = new C1626nz(this);
        this.f7361v.m2296A();
        mo1484j().m8528N().m9084b("App measurement initialized, version", Long.valueOf(this.f7346g.m2611E()));
        mo1484j().m8528N().m9083a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String m7571D = c1740py.m7571D();
        if (TextUtils.isEmpty(this.f7341b)) {
            if (m9102H().m4012C0(m7571D)) {
                c2142uy = mo1484j().m8528N();
                concat = "Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.";
            } else {
                C2142uy m8528N = mo1484j().m8528N();
                String valueOf = String.valueOf(m7571D);
                concat = valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app ");
                c2142uy = m8528N;
            }
            c2142uy.m9083a(concat);
        }
        mo1484j().m8529O().m9083a("Debug-level message logging enabled");
        if (this.f7337D != this.f7338E.get()) {
            mo1484j().m8522H().m9085c("Not all components initialized", Integer.valueOf(this.f7337D), Integer.valueOf(this.f7338E.get()));
        }
        this.f7363x = true;
    }

    /* renamed from: n */
    public final /* synthetic */ void m9119n(String str, int i, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        boolean z = true;
        if (!((i == 200 || i == 204 || i == 304) && th == null)) {
            mo1484j().m8525K().m9085c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        m9096B().f2580y.m4291a(true);
        if (bArr.length == 0) {
            mo1484j().m8529O().m9083a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String optString = jSONObject.optString("deeplink", "");
            String optString2 = jSONObject.optString("gclid", "");
            double optDouble = jSONObject.optDouble("timestamp", ShadowDrawableWrapper.COS_45);
            if (TextUtils.isEmpty(optString)) {
                mo1484j().m8529O().m9083a("Deferred Deep Link is empty.");
                return;
            }
            g40 m9102H = m9102H();
            m9102H.mo7583b();
            if (TextUtils.isEmpty(optString) || (queryIntentActivities = m9102H.mo1482h().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) == null || queryIntentActivities.isEmpty()) {
                z = false;
            }
            if (!z) {
                mo1484j().m8525K().m9085c("Deferred Deep Link validation failed. gclid, deep link", optString2, optString);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("gclid", optString2);
            bundle.putString("_cis", "ddp");
            this.f7355p.m10009S("auto", "_cmp", bundle);
            g40 m9102H2 = m9102H();
            if (TextUtils.isEmpty(optString) || !m9102H2.m4038d0(optString, optDouble)) {
                return;
            }
            m9102H2.mo1482h().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            mo1484j().m8522H().m9084b("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    @WorkerThread
    /* renamed from: o */
    public final void m9120o(boolean z) {
        this.f7334A = Boolean.valueOf(z);
    }

    @WorkerThread
    /* renamed from: p */
    public final boolean m9121p() {
        return this.f7334A != null && this.f7334A.booleanValue();
    }

    @WorkerThread
    /* renamed from: q */
    public final boolean m9122q() {
        return m9123r() == 0;
    }

    @WorkerThread
    /* renamed from: r */
    public final int m9123r() {
        mo1481g().mo7585d();
        if (this.f7346g.m2615I()) {
            return 1;
        }
        Boolean bool = this.f7336C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        Boolean m3593I = m9096B().m3593I();
        if (m3593I != null) {
            return m3593I.booleanValue() ? 0 : 3;
        }
        C0796bu c0796bu = this.f7346g;
        c0796bu.mo1480f();
        Boolean m2635z = c0796bu.m2635z("firebase_analytics_collection_enabled");
        if (m2635z != null) {
            return m2635z.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.f7335B;
        if (bool2 != null) {
            return bool2.booleanValue() ? 0 : 5;
        }
        if (C1902t7.m8600d()) {
            return 6;
        }
        return (!this.f7346g.m2630u(C1735pu.f5817U) || this.f7334A == null || this.f7334A.booleanValue()) ? 0 : 7;
    }

    /* renamed from: s */
    public final void m9124s() {
    }

    /* renamed from: t */
    public final void m9125t() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* renamed from: u */
    public final void m9126u() {
        this.f7338E.incrementAndGet();
    }

    @WorkerThread
    /* renamed from: v */
    public final boolean m9127v() {
        if (!this.f7363x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        mo1481g().mo7585d();
        Boolean bool = this.f7364y;
        if (bool == null || this.f7365z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f7353n.mo1178b() - this.f7365z) > 1000)) {
            this.f7365z = this.f7353n.mo1178b();
            boolean z = true;
            Boolean valueOf = Boolean.valueOf(m9102H().m4009A0("android.permission.INTERNET") && m9102H().m4009A0("android.permission.ACCESS_NETWORK_STATE") && (C2272xc.m9755a(this.f7340a).m9470g() || this.f7346g.m2622R() || (C1683oz.m7134b(this.f7340a) && g40.m3991X(this.f7340a, false))));
            this.f7364y = valueOf;
            if (valueOf.booleanValue()) {
                if (!m9102H().m4042h0(m9113S().m7572E(), m9113S().m7573F(), m9113S().m7574G()) && TextUtils.isEmpty(m9113S().m7573F())) {
                    z = false;
                }
                this.f7364y = Boolean.valueOf(z);
            }
        }
        return this.f7364y.booleanValue();
    }

    @WorkerThread
    /* renamed from: w */
    public final void m9128w() {
        mo1481g().mo7585d();
        m9090A(m9129x());
        String m7571D = m9113S().m7571D();
        Pair<String, Boolean> m3598v = m9096B().m3598v(m7571D);
        if (!this.f7346g.m2617K().booleanValue() || ((Boolean) m3598v.second).booleanValue() || TextUtils.isEmpty((CharSequence) m3598v.first)) {
            mo1484j().m8529O().m9083a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return;
        }
        if (!m9129x().m9145y()) {
            mo1484j().m8525K().m9083a("Network is not available for Deferred Deep Link request. Skipping");
            return;
        }
        URL m4021J = m9102H().m4021J(m9113S().m7590o().m2611E(), m7571D, (String) m3598v.first, m9096B().f2581z.m4968a() - 1);
        v10 m9129x = m9129x();
        zzib zzibVar = new zzib(this) { // from class: cz.opentree.yz

            /* renamed from: a */
            public final C2144uz f8349a;

            {
                this.f8349a = this;
            }

            @Override // com.google.android.gms.measurement.internal.zzib
            /* renamed from: a */
            public final void mo1500a(String str, int i, Throwable th, byte[] bArr, Map map) {
                this.f8349a.m9119n(str, i, th, bArr, map);
            }
        };
        m9129x.mo7585d();
        m9129x.m7166q();
        C0813ca.m2729k(m4021J);
        C0813ca.m2729k(zzibVar);
        m9129x.mo1481g().m8283D(new x10(m9129x, m7571D, m4021J, null, null, zzibVar));
    }

    /* renamed from: x */
    public final v10 m9129x() {
        m9090A(this.f7357r);
        return this.f7357r;
    }

    /* renamed from: y */
    public final C0796bu m9130y() {
        return this.f7346g;
    }
}
