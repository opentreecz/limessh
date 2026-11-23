package com.sonelli;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.SettingsJsonTransform;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class gc0 {

    /* renamed from: a */
    public final CurrentTimeProvider f2858a;

    public gc0(CurrentTimeProvider currentTimeProvider) {
        this.f2858a = currentTimeProvider;
    }

    /* renamed from: a */
    public static SettingsJsonTransform m4113a(int i) {
        return i != 3 ? new dc0() : new hc0();
    }

    /* renamed from: b */
    public mc0 m4114b(JSONObject jSONObject) throws JSONException {
        return m4113a(jSONObject.getInt("settings_version")).mo1844a(this.f2858a, jSONObject);
    }
}
