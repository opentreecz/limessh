package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import cz.opentree.mc0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public interface SettingsJsonTransform {
    /* renamed from: a */
    mc0 mo1844a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) throws JSONException;
}
