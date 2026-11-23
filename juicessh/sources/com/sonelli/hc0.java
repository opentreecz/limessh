package com.sonelli;

import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class hc0 implements SettingsJsonTransform {
    /* renamed from: b */
    public static jc0 m4431b(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        String string = jSONObject2.getString(NotificationCompat.CATEGORY_STATUS);
        boolean equals = "new".equals(string);
        String string2 = jSONObject.getString("bundle_id");
        String string3 = jSONObject.getString("org_id");
        String format = equals ? "https://update.crashlytics.com/spi/v1/platforms/android/apps" : String.format(Locale.US, "https://update.crashlytics.com/spi/v1/platforms/android/apps/%s", string2);
        Locale locale = Locale.US;
        return new jc0(string, format, String.format(locale, "https://reports.crashlytics.com/spi/v1/platforms/android/apps/%s/reports", string2), String.format(locale, "https://reports.crashlytics.com/sdk-api/v1/platforms/android/apps/%s/minidumps", string2), string2, string3, jSONObject2.optBoolean("update_required", false), jSONObject2.optInt("report_upload_variant", 0), jSONObject2.optInt("native_report_upload_variant", 0));
    }

    /* renamed from: c */
    public static kc0 m4432c(JSONObject jSONObject) {
        return new kc0(jSONObject.optBoolean("collect_reports", true));
    }

    /* renamed from: d */
    public static lc0 m4433d() {
        return new lc0(8, 4);
    }

    /* renamed from: e */
    public static long m4434e(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : currentTimeProvider.mo1739a() + (j * 1000);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    /* renamed from: a */
    public mc0 mo1844a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new mc0(m4434e(currentTimeProvider, optInt2, jSONObject), m4431b(jSONObject.getJSONObject("fabric"), jSONObject.getJSONObject("app")), m4433d(), m4432c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
