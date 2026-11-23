package com.google.firebase.crashlytics.internal.analytics;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsReceiver;
import cz.opentree.m80;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class AnalyticsConnectorReceiver implements AnalyticsConnector.AnalyticsConnectorListener, AnalyticsReceiver {

    /* renamed from: a */
    public final AnalyticsConnector f1119a;

    /* renamed from: b */
    public final BreadcrumbHandler f1120b;

    /* renamed from: c */
    public AnalyticsReceiver.CrashlyticsOriginEventListener f1121c;

    /* renamed from: d */
    public AnalyticsConnector.AnalyticsConnectorHandle f1122d;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface BreadcrumbHandler {
        /* renamed from: a */
        void mo1631a(String str);
    }

    public AnalyticsConnectorReceiver(AnalyticsConnector analyticsConnector, BreadcrumbHandler breadcrumbHandler) {
        this.f1119a = analyticsConnector;
        this.f1120b = breadcrumbHandler;
    }

    /* renamed from: f */
    public static String m1626f(@NonNull String str, @NonNull Bundle bundle) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsReceiver
    /* renamed from: a */
    public void mo1627a(@Nullable AnalyticsReceiver.CrashlyticsOriginEventListener crashlyticsOriginEventListener) {
        this.f1121c = crashlyticsOriginEventListener;
    }

    @Override // com.google.firebase.crashlytics.internal.analytics.AnalyticsReceiver
    /* renamed from: b */
    public boolean mo1628b() {
        AnalyticsConnector analyticsConnector = this.f1119a;
        if (analyticsConnector == null) {
            m80.m6375f().m6377b("Firebase Analytics is not present; you will not see automatic logging of events before a crash occurs.");
            return false;
        }
        AnalyticsConnector.AnalyticsConnectorHandle mo1596b = analyticsConnector.mo1596b("clx", this);
        this.f1122d = mo1596b;
        if (mo1596b == null) {
            m80.m6375f().m6377b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            AnalyticsConnector.AnalyticsConnectorHandle mo1596b2 = this.f1119a.mo1596b("crash", this);
            this.f1122d = mo1596b2;
            if (mo1596b2 != null) {
                m80.m6375f().m6383i("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return this.f1122d != null;
    }

    @Override // com.google.firebase.analytics.connector.AnalyticsConnector.AnalyticsConnectorListener
    /* renamed from: c */
    public void mo1597c(int i, @Nullable Bundle bundle) {
        m80.m6375f().m6377b("AnalyticsConnectorReceiver received message: " + i + " " + bundle);
        if (bundle == null) {
            return;
        }
        Bundle bundle2 = bundle.getBundle("params");
        if (bundle2 == null) {
            bundle2 = new Bundle();
        }
        if ("clx".equals(bundle2.getString("_o"))) {
            m1630e(i, bundle);
            return;
        }
        String string = bundle.getString("name");
        if (string != null) {
            m1629d(string, bundle2);
        }
    }

    /* renamed from: d */
    public final void m1629d(String str, Bundle bundle) {
        try {
            this.f1120b.mo1631a("$A$:" + m1626f(str, bundle));
        } catch (JSONException unused) {
            m80.m6375f().m6383i("Unable to serialize Firebase Analytics event.");
        }
    }

    /* renamed from: e */
    public final void m1630e(int i, @Nullable Bundle bundle) {
        AnalyticsReceiver.CrashlyticsOriginEventListener crashlyticsOriginEventListener = this.f1121c;
        if (crashlyticsOriginEventListener != null) {
            crashlyticsOriginEventListener.mo1632a(i, bundle);
        }
    }
}
