package cz.opentree;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.ActivityChooserView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* renamed from: cz.opentree.y3 */
/* loaded from: classes.dex */
public class C2323y3 extends AbstractC2006uf {

    /* renamed from: Q */
    public boolean f8120Q;

    /* renamed from: R */
    public final Map<String, String> f8121R;

    /* renamed from: S */
    public final Map<String, String> f8122S;

    /* renamed from: T */
    public final C1160ih f8123T;

    /* renamed from: U */
    public final a f8124U;

    /* renamed from: V */
    public C1898t3 f8125V;

    /* renamed from: W */
    public C2426zh f8126W;

    /* renamed from: cz.opentree.y3$a */
    /* loaded from: classes.dex */
    public class a extends AbstractC2006uf implements GoogleAnalytics.zza {

        /* renamed from: Q */
        public boolean f8127Q;

        /* renamed from: R */
        public int f8128R;

        /* renamed from: S */
        public long f8129S;

        /* renamed from: T */
        public boolean f8130T;

        /* renamed from: U */
        public long f8131U;

        public a(C2216wf c2216wf) {
            super(c2216wf);
            this.f8129S = -1L;
        }

        @Override // cz.opentree.AbstractC2006uf
        /* renamed from: E0 */
        public final void mo2053E0() {
        }

        /* renamed from: G0 */
        public final void m10077G0(boolean z) {
            this.f8127Q = z;
            m10080J0();
        }

        /* renamed from: H0 */
        public final void m10078H0(long j) {
            this.f8129S = j;
            m10080J0();
        }

        /* renamed from: I0 */
        public final synchronized boolean m10079I0() {
            boolean z;
            z = this.f8130T;
            this.f8130T = false;
            return z;
        }

        /* renamed from: J0 */
        public final void m10080J0() {
            if (this.f8129S >= 0 || this.f8127Q) {
                m8663k0().m823q(C2323y3.this.f8124U);
            } else {
                m8663k0().m826u(C2323y3.this.f8124U);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        /* renamed from: a */
        public final void mo827a(Activity activity) {
            String canonicalName;
            if (this.f8128R == 0) {
                if (m8659g0().mo1178b() >= this.f8131U + Math.max(1000L, this.f8129S)) {
                    this.f8130T = true;
                }
            }
            this.f8128R++;
            if (this.f8127Q) {
                Intent intent = activity.getIntent();
                if (intent != null) {
                    C2323y3.this.m10074K0(intent.getData());
                }
                HashMap hashMap = new HashMap();
                hashMap.put("&t", "screenview");
                C2323y3 c2323y3 = C2323y3.this;
                if (c2323y3.f8126W != null) {
                    C2426zh c2426zh = C2323y3.this.f8126W;
                    canonicalName = activity.getClass().getCanonicalName();
                    String str = c2426zh.f8513g.get(canonicalName);
                    if (str != null) {
                        canonicalName = str;
                    }
                } else {
                    canonicalName = activity.getClass().getCanonicalName();
                }
                c2323y3.m10073J0("&cd", canonicalName);
                if (TextUtils.isEmpty((CharSequence) hashMap.get("&dr"))) {
                    C0813ca.m2729k(activity);
                    Intent intent2 = activity.getIntent();
                    String str2 = null;
                    if (intent2 != null) {
                        String stringExtra = intent2.getStringExtra("android.intent.extra.REFERRER_NAME");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            str2 = stringExtra;
                        }
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        hashMap.put("&dr", str2);
                    }
                }
                C2323y3.this.m10072I0(hashMap);
            }
        }

        @Override // com.google.android.gms.analytics.GoogleAnalytics.zza
        /* renamed from: h */
        public final void mo828h(Activity activity) {
            int i = this.f8128R - 1;
            this.f8128R = i;
            int max = Math.max(0, i);
            this.f8128R = max;
            if (max == 0) {
                this.f8131U = m8659g0().mo1178b();
            }
        }
    }

    public C2323y3(C2216wf c2216wf, String str, C1160ih c1160ih) {
        super(c2216wf);
        HashMap hashMap = new HashMap();
        this.f8121R = hashMap;
        this.f8122S = new HashMap();
        if (str != null) {
            hashMap.put("&tid", str);
        }
        hashMap.put("useSecure", "1");
        hashMap.put("&a", Integer.toString(new Random().nextInt(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + 1));
        this.f8123T = new C1160ih("tracking", m8659g0());
        this.f8124U = new a(c2216wf);
    }

    /* renamed from: N0 */
    public static String m10058N0(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        if (key.startsWith("&") && key.length() >= 2) {
            return entry.getKey().substring(1);
        }
        return null;
    }

    /* renamed from: P0 */
    public static void m10059P0(Map<String, String> map, Map<String, String> map2) {
        C0813ca.m2729k(map2);
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String m10058N0 = m10058N0(entry);
            if (m10058N0 != null) {
                map2.put(m10058N0, entry.getValue());
            }
        }
    }

    @Override // cz.opentree.AbstractC2006uf
    /* renamed from: E0 */
    public final void mo2053E0() {
        this.f8124U.m8877D0();
        String m2486G0 = m8666n0().m2486G0();
        if (m2486G0 != null) {
            m10073J0("&an", m2486G0);
        }
        String m2487H0 = m8666n0().m2487H0();
        if (m2487H0 != null) {
            m10073J0("&av", m2487H0);
        }
    }

    /* renamed from: G0 */
    public void m10070G0(boolean z) {
        this.f8124U.m10077G0(z);
    }

    /* renamed from: H0 */
    public void m10071H0(boolean z) {
        synchronized (this) {
            C1898t3 c1898t3 = this.f8125V;
            if ((c1898t3 != null) == z) {
                return;
            }
            if (z) {
                C1898t3 c1898t32 = new C1898t3(this, Thread.getDefaultUncaughtExceptionHandler(), m8675x());
                this.f8125V = c1898t32;
                Thread.setDefaultUncaughtExceptionHandler(c1898t32);
                m8676x0("Uncaught exceptions will be reported to Google Analytics");
            } else {
                Thread.setDefaultUncaughtExceptionHandler(c1898t3.m8586a());
                m8676x0("Uncaught exceptions will not be reported to Google Analytics");
            }
        }
    }

    /* renamed from: I0 */
    public void m10072I0(Map<String, String> map) {
        long mo1177a = m8659g0().mo1177a();
        if (m8663k0().m817j()) {
            m8678y0("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        boolean m818l = m8663k0().m818l();
        HashMap hashMap = new HashMap();
        m10059P0(this.f8121R, hashMap);
        m10059P0(map, hashMap);
        int i = 1;
        boolean m2083l = C0713ai.m2083l(this.f8121R.get("useSecure"), true);
        Map<String, String> map2 = this.f8122S;
        C0813ca.m2729k(hashMap);
        if (map2 != null) {
            for (Map.Entry<String, String> entry : map2.entrySet()) {
                String m10058N0 = m10058N0(entry);
                if (m10058N0 != null && !hashMap.containsKey(m10058N0)) {
                    hashMap.put(m10058N0, entry.getValue());
                }
            }
        }
        this.f8122S.clear();
        String str = hashMap.get("t");
        if (TextUtils.isEmpty(str)) {
            m8660h0().m5890H0(hashMap, "Missing hit type parameter");
            return;
        }
        String str2 = hashMap.get("tid");
        if (TextUtils.isEmpty(str2)) {
            m8660h0().m5890H0(hashMap, "Missing tracking id parameter");
            return;
        }
        boolean z = this.f8120Q;
        synchronized (this) {
            if ("screenview".equalsIgnoreCase(str) || "pageview".equalsIgnoreCase(str) || "appview".equalsIgnoreCase(str) || TextUtils.isEmpty(str)) {
                int parseInt = Integer.parseInt(this.f8121R.get("&a")) + 1;
                if (parseInt < Integer.MAX_VALUE) {
                    i = parseInt;
                }
                this.f8121R.put("&a", Integer.toString(i));
            }
        }
        m8662j0().m5829e(new RunnableC1587n4(this, hashMap, z, str, mo1177a, m818l, m2083l, str2));
    }

    /* renamed from: J0 */
    public void m10073J0(String str, String str2) {
        C0813ca.m2730l(str, "Key should be non-null");
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f8121R.put(str, str2);
    }

    /* renamed from: K0 */
    public void m10074K0(Uri uri) {
        if (uri == null || uri.isOpaque()) {
            return;
        }
        String queryParameter = uri.getQueryParameter("referrer");
        if (TextUtils.isEmpty(queryParameter)) {
            return;
        }
        String valueOf = String.valueOf(queryParameter);
        Uri parse = Uri.parse(valueOf.length() != 0 ? "http://hostname/?".concat(valueOf) : new String("http://hostname/?"));
        String queryParameter2 = parse.getQueryParameter("utm_id");
        if (queryParameter2 != null) {
            this.f8122S.put("&ci", queryParameter2);
        }
        String queryParameter3 = parse.getQueryParameter("anid");
        if (queryParameter3 != null) {
            this.f8122S.put("&anid", queryParameter3);
        }
        String queryParameter4 = parse.getQueryParameter("utm_campaign");
        if (queryParameter4 != null) {
            this.f8122S.put("&cn", queryParameter4);
        }
        String queryParameter5 = parse.getQueryParameter("utm_content");
        if (queryParameter5 != null) {
            this.f8122S.put("&cc", queryParameter5);
        }
        String queryParameter6 = parse.getQueryParameter("utm_medium");
        if (queryParameter6 != null) {
            this.f8122S.put("&cm", queryParameter6);
        }
        String queryParameter7 = parse.getQueryParameter("utm_source");
        if (queryParameter7 != null) {
            this.f8122S.put("&cs", queryParameter7);
        }
        String queryParameter8 = parse.getQueryParameter("utm_term");
        if (queryParameter8 != null) {
            this.f8122S.put("&ck", queryParameter8);
        }
        String queryParameter9 = parse.getQueryParameter("dclid");
        if (queryParameter9 != null) {
            this.f8122S.put("&dclid", queryParameter9);
        }
        String queryParameter10 = parse.getQueryParameter("gclid");
        if (queryParameter10 != null) {
            this.f8122S.put("&gclid", queryParameter10);
        }
        String queryParameter11 = parse.getQueryParameter("aclid");
        if (queryParameter11 != null) {
            this.f8122S.put("&aclid", queryParameter11);
        }
    }

    /* renamed from: L0 */
    public void m10075L0(long j) {
        this.f8124U.m10078H0(j * 1000);
    }

    /* renamed from: O0 */
    public final void m10076O0(C2426zh c2426zh) {
        m8676x0("Loading Tracker config values");
        this.f8126W = c2426zh;
        String str = c2426zh.f8507a;
        if (str != null) {
            m10073J0("&tid", str);
            m8679z("trackingId loaded", str);
        }
        double d = this.f8126W.f8508b;
        if (d >= ShadowDrawableWrapper.COS_45) {
            String d2 = Double.toString(d);
            m10073J0("&sf", d2);
            m8679z("Sample frequency loaded", d2);
        }
        int i = this.f8126W.f8509c;
        if (i >= 0) {
            m10075L0(i);
            m8679z("Session timeout loaded", Integer.valueOf(i));
        }
        int i2 = this.f8126W.f8510d;
        if (i2 != -1) {
            boolean z = i2 == 1;
            m10070G0(z);
            m8679z("Auto activity tracking loaded", Boolean.valueOf(z));
        }
        int i3 = this.f8126W.f8511e;
        if (i3 != -1) {
            boolean z2 = i3 == 1;
            if (z2) {
                m10073J0("&aip", "1");
            }
            m8679z("Anonymize ip loaded", Boolean.valueOf(z2));
        }
        m10071H0(this.f8126W.f8512f == 1);
    }
}
