package com.sonelli;

import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
/* loaded from: classes.dex */
public final class ee0 {

    /* renamed from: d */
    public static final long f2371d = TimeUnit.DAYS.toMillis(7);

    /* renamed from: a */
    public final String f2372a;

    /* renamed from: b */
    public final String f2373b;

    /* renamed from: c */
    public final long f2374c;

    public ee0(String str, String str2, long j) {
        this.f2372a = str;
        this.f2373b = str2;
        this.f2374c = j;
    }

    /* renamed from: a */
    public static ee0 m3479a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("{")) {
            return new ee0(str, null, 0L);
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new ee0(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("Failed to parse token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* renamed from: b */
    public static String m3480b(String str, String str2, long j) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("appVersion", str2);
            jSONObject.put("timestamp", j);
            return jSONObject.toString();
        } catch (JSONException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 24);
            sb.append("Failed to encode token: ");
            sb.append(valueOf);
            Log.w("FirebaseInstanceId", sb.toString());
            return null;
        }
    }

    /* renamed from: c */
    public final boolean m3481c(String str) {
        return System.currentTimeMillis() > this.f2374c + f2371d || !str.equals(this.f2373b);
    }
}
