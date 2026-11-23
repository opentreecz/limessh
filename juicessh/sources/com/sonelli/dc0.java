package com.sonelli;

import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform;
import com.google.firebase.crashlytics.internal.settings.model.Settings;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class dc0 implements SettingsJsonTransform {
    /* renamed from: b */
    public static jc0 m3185b(JSONObject jSONObject) throws JSONException {
        return new jc0(jSONObject.getString(NotificationCompat.CATEGORY_STATUS), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.getString("ndk_reports_url"), jSONObject.optBoolean("update_required", false));
    }

    /* renamed from: c */
    public static kc0 m3186c(JSONObject jSONObject) {
        return new kc0(jSONObject.optBoolean("collect_reports", true));
    }

    /* renamed from: d */
    public static lc0 m3187d(JSONObject jSONObject) {
        return new lc0(jSONObject.optInt("max_custom_exception_events", 8), 4);
    }

    /* renamed from: e */
    public static Settings m3188e(CurrentTimeProvider currentTimeProvider) {
        JSONObject jSONObject = new JSONObject();
        return new mc0(m3189f(currentTimeProvider, 3600L, jSONObject), null, m3187d(jSONObject), m3186c(jSONObject), 0, 3600);
    }

    /* renamed from: f */
    public static long m3189f(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        return jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : currentTimeProvider.mo1739a() + (j * 1000);
    }

    @Override // com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform
    /* renamed from: a */
    public mc0 mo1844a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new mc0(m3189f(currentTimeProvider, optInt2, jSONObject), m3185b(jSONObject.getJSONObject("app")), m3187d(jSONObject.getJSONObject("session")), m3186c(jSONObject.getJSONObject("features")), optInt, optInt2);
    }
}
