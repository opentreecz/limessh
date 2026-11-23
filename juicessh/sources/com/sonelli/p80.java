package com.sonelli;

import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public abstract class p80 {

    /* renamed from: e */
    public static final Pattern f5635e = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* renamed from: a */
    public final String f5636a;

    /* renamed from: b */
    public final db0 f5637b;

    /* renamed from: c */
    public final bb0 f5638c;

    /* renamed from: d */
    public final String f5639d;

    public p80(String str, String str2, db0 db0Var, bb0 bb0Var) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (db0Var == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.f5639d = str;
        this.f5636a = m7253f(str2);
        this.f5637b = db0Var;
        this.f5638c = bb0Var;
    }

    /* renamed from: c */
    public cb0 m7250c() {
        return m7251d(Collections.emptyMap());
    }

    /* renamed from: d */
    public cb0 m7251d(Map<String, String> map) {
        cb0 m3182a = this.f5637b.m3182a(this.f5638c, m7252e(), map);
        m3182a.m2751d("User-Agent", "Crashlytics Android SDK/" + y80.m10100i());
        m3182a.m2751d("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return m3182a;
    }

    /* renamed from: e */
    public String m7252e() {
        return this.f5636a;
    }

    /* renamed from: f */
    public final String m7253f(String str) {
        return !w80.m9416C(this.f5639d) ? f5635e.matcher(str).replaceFirst(this.f5639d) : str;
    }
}
