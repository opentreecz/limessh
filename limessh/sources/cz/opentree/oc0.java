package cz.opentree;

import com.google.firebase.crashlytics.internal.settings.network.AppSpiCall;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public abstract class oc0 extends p80 implements AppSpiCall {

    /* renamed from: f */
    public final String f5474f;

    public oc0(String str, String str2, db0 db0Var, bb0 bb0Var, String str3) {
        super(str, str2, db0Var, bb0Var);
        this.f5474f = str3;
    }

    /* renamed from: g */
    public final cb0 m7012g(cb0 cb0Var, ic0 ic0Var) {
        cb0Var.m2751d("X-CRASHLYTICS-ORG-ID", ic0Var.f3284a);
        cb0Var.m2751d("X-CRASHLYTICS-GOOGLE-APP-ID", ic0Var.f3285b);
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f5474f);
        return cb0Var;
    }

    /* renamed from: h */
    public final cb0 m7013h(cb0 cb0Var, ic0 ic0Var) {
        cb0Var.m2754g("org_id", ic0Var.f3284a);
        cb0Var.m2754g("app[identifier]", ic0Var.f3286c);
        cb0Var.m2754g("app[name]", ic0Var.f3290g);
        cb0Var.m2754g("app[display_version]", ic0Var.f3287d);
        cb0Var.m2754g("app[build_version]", ic0Var.f3288e);
        cb0Var.m2754g("app[source]", Integer.toString(ic0Var.f3291h));
        cb0Var.m2754g("app[minimum_sdk_version]", ic0Var.f3292i);
        cb0Var.m2754g("app[built_sdk_version]", ic0Var.f3293j);
        if (!w80.m9416C(ic0Var.f3289f)) {
            cb0Var.m2754g("app[instance_identifier]", ic0Var.f3289f);
        }
        return cb0Var;
    }

    /* renamed from: i */
    public boolean m7014i(ic0 ic0Var, boolean z) {
        if (!z) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        cb0 m7250c = m7250c();
        m7012g(m7250c, ic0Var);
        m7013h(m7250c, ic0Var);
        m80.m6375f().m6377b("Sending app info to " + m7252e());
        try {
            eb0 m2749b = m7250c.m2749b();
            int m3472b = m2749b.m3472b();
            String str = "POST".equalsIgnoreCase(m7250c.m2753f()) ? "Create" : "Update";
            m80.m6375f().m6377b(str + " app request ID: " + m2749b.m3473d("X-REQUEST-ID"));
            m80.m6375f().m6377b("Result was " + m3472b);
            return l90.m6099a(m3472b) == 0;
        } catch (IOException e) {
            m80.m6375f().m6380e("HTTP request failed.", e);
            throw new RuntimeException(e);
        }
    }
}
