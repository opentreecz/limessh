package com.sonelli;

import com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class qc0 extends p80 implements SettingsSpiCall {

    /* renamed from: f */
    public m80 f5972f;

    public qc0(String str, String str2, db0 db0Var) {
        this(str, str2, db0Var, bb0.GET, m80.m6375f());
    }

    public qc0(String str, String str2, db0 db0Var, bb0 bb0Var, m80 m80Var) {
        super(str, str2, db0Var, bb0Var);
        this.f5972f = m80Var;
    }

    @Override // com.google.firebase.crashlytics.internal.settings.network.SettingsSpiCall
    /* renamed from: a */
    public JSONObject mo1847a(nc0 nc0Var, boolean z) {
        if (!z) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        try {
            Map<String, String> m7676j = m7676j(nc0Var);
            cb0 m7251d = m7251d(m7676j);
            m7673g(m7251d, nc0Var);
            this.f5972f.m6377b("Requesting settings from " + m7252e());
            this.f5972f.m6377b("Settings query params were: " + m7676j);
            eb0 m2749b = m7251d.m2749b();
            this.f5972f.m6377b("Settings request ID: " + m2749b.m3473d("X-REQUEST-ID"));
            return m7677k(m2749b);
        } catch (IOException e) {
            this.f5972f.m6380e("Settings request failed.", e);
            return null;
        }
    }

    /* renamed from: g */
    public final cb0 m7673g(cb0 cb0Var, nc0 nc0Var) {
        m7674h(cb0Var, "X-CRASHLYTICS-GOOGLE-APP-ID", nc0Var.f5248a);
        m7674h(cb0Var, "X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        m7674h(cb0Var, "X-CRASHLYTICS-API-CLIENT-VERSION", y80.m10100i());
        m7674h(cb0Var, "Accept", "application/json");
        m7674h(cb0Var, "X-CRASHLYTICS-DEVICE-MODEL", nc0Var.f5249b);
        m7674h(cb0Var, "X-CRASHLYTICS-OS-BUILD-VERSION", nc0Var.f5250c);
        m7674h(cb0Var, "X-CRASHLYTICS-OS-DISPLAY-VERSION", nc0Var.f5251d);
        m7674h(cb0Var, "X-CRASHLYTICS-INSTALLATION-ID", nc0Var.f5252e.mo1740a());
        return cb0Var;
    }

    /* renamed from: h */
    public final void m7674h(cb0 cb0Var, String str, String str2) {
        if (str2 != null) {
            cb0Var.m2751d(str, str2);
        }
    }

    /* renamed from: i */
    public final JSONObject m7675i(String str) {
        try {
            return new JSONObject(str);
        } catch (Exception e) {
            this.f5972f.m6378c("Failed to parse settings JSON from " + m7252e(), e);
            this.f5972f.m6377b("Settings response " + str);
            return null;
        }
    }

    /* renamed from: j */
    public final Map<String, String> m7676j(nc0 nc0Var) {
        HashMap hashMap = new HashMap();
        hashMap.put("build_version", nc0Var.f5255h);
        hashMap.put("display_version", nc0Var.f5254g);
        hashMap.put("source", Integer.toString(nc0Var.f5256i));
        String str = nc0Var.f5253f;
        if (!w80.m9416C(str)) {
            hashMap.put("instance", str);
        }
        return hashMap;
    }

    /* renamed from: k */
    public JSONObject m7677k(eb0 eb0Var) {
        int m3472b = eb0Var.m3472b();
        this.f5972f.m6377b("Settings result was: " + m3472b);
        if (m7678l(m3472b)) {
            return m7675i(eb0Var.m3471a());
        }
        this.f5972f.m6379d("Failed to retrieve settings from " + m7252e());
        return null;
    }

    /* renamed from: l */
    public boolean m7678l(int i) {
        return i == 200 || i == 201 || i == 202 || i == 203;
    }
}
