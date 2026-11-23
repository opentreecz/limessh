package cz.opentree;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.analytics.zzo;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: cz.opentree.d4 */
/* loaded from: classes.dex */
public final class C0859d4 extends C1930tf implements zzo {

    /* renamed from: S */
    public static DecimalFormat f2121S;

    /* renamed from: P */
    public final C2216wf f2122P;

    /* renamed from: Q */
    public final String f2123Q;

    /* renamed from: R */
    public final Uri f2124R;

    public C0859d4(C2216wf c2216wf, String str) {
        this(c2216wf, str, true, false);
    }

    public C0859d4(C2216wf c2216wf, String str, boolean z, boolean z2) {
        super(c2216wf);
        C0813ca.m2725g(str);
        this.f2122P = c2216wf;
        this.f2123Q = str;
        this.f2124R = m3118H0(str);
    }

    /* renamed from: C0 */
    public static String m3113C0(double d) {
        if (f2121S == null) {
            f2121S = new DecimalFormat("0.######");
        }
        return f2121S.format(d);
    }

    /* renamed from: D0 */
    public static void m3114D0(Map<String, String> map, String str, double d) {
        if (d != ShadowDrawableWrapper.COS_45) {
            map.put(str, m3113C0(d));
        }
    }

    /* renamed from: E0 */
    public static void m3115E0(Map<String, String> map, String str, int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(23);
        sb.append(i);
        sb.append("x");
        sb.append(i2);
        map.put(str, sb.toString());
    }

    /* renamed from: F0 */
    public static void m3116F0(Map<String, String> map, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    /* renamed from: G0 */
    public static void m3117G0(Map<String, String> map, String str, boolean z) {
        if (z) {
            map.put(str, "1");
        }
    }

    /* renamed from: H0 */
    public static Uri m3118H0(String str) {
        C0813ca.m2725g(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(NotificationCompat.MessagingStyle.Message.KEY_DATA_URI);
        builder.authority("google-analytics.com");
        builder.path(str);
        return builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        if (android.text.TextUtils.isEmpty(r4) == false) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0067 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x001c A[SYNTHETIC] */
    /* renamed from: I0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.Map<java.lang.String, java.lang.String> m3119I0(cz.opentree.C1093h4 r12) {
        /*
            Method dump skipped, instructions count: 929
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.C0859d4.m3119I0(cz.opentree.h4):java.util.Map");
    }

    @Override // com.google.android.gms.analytics.zzo
    /* renamed from: l */
    public final Uri mo835l() {
        return this.f2124R;
    }

    @Override // com.google.android.gms.analytics.zzo
    /* renamed from: n */
    public final void mo836n(C1093h4 c1093h4) {
        C0813ca.m2729k(c1093h4);
        C0813ca.m2720b(c1093h4.m4358i(), "Can't deliver not submitted measurement");
        C0813ca.m2728j("deliver should be called on worker thread");
        C1093h4 m4353d = c1093h4.m4353d();
        C1933ti c1933ti = (C1933ti) m4353d.m4363n(C1933ti.class);
        if (TextUtils.isEmpty(c1933ti.m8691i())) {
            m8660h0().m5890H0(m3119I0(m4353d), "Ignoring measurement without type");
            return;
        }
        if (TextUtils.isEmpty(c1933ti.m8692j())) {
            m8660h0().m5890H0(m3119I0(m4353d), "Ignoring measurement without client id");
            return;
        }
        if (this.f2122P.m9488p().m817j()) {
            return;
        }
        double m8698p = c1933ti.m8698p();
        if (C0713ai.m2076e(m8698p, c1933ti.m8692j())) {
            m8653Z("Sampling enabled. Hit sampled out. sampling rate", Double.valueOf(m8698p));
            return;
        }
        Map<String, String> m3119I0 = m3119I0(m4353d);
        m3119I0.put("v", "1");
        m3119I0.put("_v", C2167vf.f7454b);
        m3119I0.put("tid", this.f2123Q);
        if (this.f2122P.m9488p().m818l()) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : m3119I0.entrySet()) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(entry.getKey());
                sb.append(SimpleComparison.EQUAL_TO_OPERATION);
                sb.append(entry.getValue());
            }
            m8656d0("Dry run is enabled. GoogleAnalytics would have sent", sb.toString());
            return;
        }
        HashMap hashMap = new HashMap();
        C0713ai.m2081j(hashMap, "uid", c1933ti.m8693k());
        C1455ki c1455ki = (C1455ki) c1093h4.m4350a(C1455ki.class);
        if (c1455ki != null) {
            C0713ai.m2081j(hashMap, "an", c1455ki.m5907j());
            C0713ai.m2081j(hashMap, "aid", c1455ki.m5909l());
            C0713ai.m2081j(hashMap, "av", c1455ki.m5908k());
            C0713ai.m2081j(hashMap, "aiid", c1455ki.m5910m());
        }
        m3119I0.put("_s", String.valueOf(m8664l0().m7018I0(new C2424zf(0L, c1933ti.m8692j(), this.f2123Q, !TextUtils.isEmpty(c1933ti.m8694l()), 0L, hashMap))));
        m8664l0().m7020L0(new C1043gh(m8660h0(), m3119I0, c1093h4.m4356g(), true));
    }
}
