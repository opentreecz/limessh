package com.sonelli;

import android.text.TextUtils;
import com.google.android.gms.analytics.GoogleAnalytics;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sonelli.n4 */
/* loaded from: classes.dex */
public final class RunnableC1587n4 implements Runnable {

    /* renamed from: O */
    public final /* synthetic */ Map f5217O;

    /* renamed from: P */
    public final /* synthetic */ boolean f5218P;

    /* renamed from: Q */
    public final /* synthetic */ String f5219Q;

    /* renamed from: R */
    public final /* synthetic */ long f5220R;

    /* renamed from: S */
    public final /* synthetic */ boolean f5221S;

    /* renamed from: T */
    public final /* synthetic */ boolean f5222T;

    /* renamed from: U */
    public final /* synthetic */ String f5223U;

    /* renamed from: V */
    public final /* synthetic */ C2323y3 f5224V;

    public RunnableC1587n4(C2323y3 c2323y3, Map map, boolean z, String str, long j, boolean z2, boolean z3, String str2) {
        this.f5224V = c2323y3;
        this.f5217O = map;
        this.f5218P = z;
        this.f5219Q = str;
        this.f5220R = j;
        this.f5221S = z2;
        this.f5222T = z3;
        this.f5223U = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1602nf m8669q0;
        C1107hg m8670r0;
        C2345yg m8671s0;
        C2345yg m8671s02;
        C1652of m8664l0;
        C1652of m8664l02;
        C1451kh m8660h0;
        C1160ih c1160ih;
        C1451kh m8660h02;
        if (this.f5224V.f8124U.m10079I0()) {
            this.f5217O.put("sc", "start");
        }
        Map map = this.f5217O;
        GoogleAnalytics m8663k0 = this.f5224V.m8663k0();
        C0813ca.m2728j("getClientId can not be called from the main thread");
        C0713ai.m2085n(map, "cid", m8663k0.m2667g().m9491s().m7029J0());
        String str = (String) this.f5217O.get("sf");
        if (str != null) {
            double m2072a = C0713ai.m2072a(str, 100.0d);
            if (C0713ai.m2076e(m2072a, (String) this.f5217O.get("cid"))) {
                this.f5224V.m8653Z("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(m2072a));
                return;
            }
        }
        m8669q0 = this.f5224V.m8669q0();
        if (this.f5218P) {
            C0713ai.m2082k(this.f5217O, "ate", m8669q0.m6667H0());
            C0713ai.m2081j(this.f5217O, "adid", m8669q0.m6668I0());
        } else {
            this.f5217O.remove("ate");
            this.f5217O.remove("adid");
        }
        m8670r0 = this.f5224V.m8670r0();
        C1455ki m4444G0 = m8670r0.m4444G0();
        C0713ai.m2081j(this.f5217O, "an", m4444G0.m5907j());
        C0713ai.m2081j(this.f5217O, "av", m4444G0.m5908k());
        C0713ai.m2081j(this.f5217O, "aid", m4444G0.m5909l());
        C0713ai.m2081j(this.f5217O, "aiid", m4444G0.m5910m());
        this.f5217O.put("v", "1");
        this.f5217O.put("_v", C2167vf.f7454b);
        Map map2 = this.f5217O;
        m8671s0 = this.f5224V.m8671s0();
        C0713ai.m2081j(map2, "ul", m8671s0.m10129G0().m7320e());
        Map map3 = this.f5217O;
        m8671s02 = this.f5224V.m8671s0();
        C0713ai.m2081j(map3, "sr", m8671s02.m10130H0());
        if (!(this.f5219Q.equals("transaction") || this.f5219Q.equals("item"))) {
            c1160ih = this.f5224V.f8123T;
            if (!c1160ih.m4778a()) {
                m8660h02 = this.f5224V.m8660h0();
                m8660h02.m5890H0(this.f5217O, "Too many hits sent too quickly, rate limiting invoked");
                return;
            }
        }
        long m2078g = C0713ai.m2078g((String) this.f5217O.get("ht"));
        if (m2078g == 0) {
            m2078g = this.f5220R;
        }
        long j = m2078g;
        if (this.f5221S) {
            C1043gh c1043gh = new C1043gh(this.f5224V, this.f5217O, j, this.f5222T);
            m8660h0 = this.f5224V.m8660h0();
            m8660h0.m8656d0("Dry run enabled. Would have sent hit", c1043gh);
            return;
        }
        String str2 = (String) this.f5217O.get("cid");
        HashMap hashMap = new HashMap();
        C0713ai.m2075d(hashMap, "uid", this.f5217O);
        C0713ai.m2075d(hashMap, "an", this.f5217O);
        C0713ai.m2075d(hashMap, "aid", this.f5217O);
        C0713ai.m2075d(hashMap, "av", this.f5217O);
        C0713ai.m2075d(hashMap, "aiid", this.f5217O);
        C2424zf c2424zf = new C2424zf(0L, str2, this.f5223U, !TextUtils.isEmpty((CharSequence) this.f5217O.get("adid")), 0L, hashMap);
        m8664l0 = this.f5224V.m8664l0();
        this.f5217O.put("_s", String.valueOf(m8664l0.m7018I0(c2424zf)));
        C1043gh c1043gh2 = new C1043gh(this.f5224V, this.f5217O, j, this.f5222T);
        m8664l02 = this.f5224V.m8664l0();
        m8664l02.m7020L0(c1043gh2);
    }
}
