package com.sonelli.juicessh.models;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.core.app.NotificationCompat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class Plugin {

    /* renamed from: a */
    public String f4077a;

    /* renamed from: b */
    public String f4078b;

    /* renamed from: c */
    public String f4079c;

    /* renamed from: d */
    public String f4080d;

    /* renamed from: e */
    public String f4081e;

    /* renamed from: g */
    public static Plugin m5483g(JSONObject jSONObject) {
        try {
            Plugin plugin = new Plugin();
            if (jSONObject.has("name")) {
                plugin.f4077a = jSONObject.getString("name");
            }
            if (jSONObject.has("package")) {
                plugin.f4078b = jSONObject.getString("package");
            }
            if (jSONObject.has("description")) {
                plugin.f4079c = jSONObject.getString("description");
            }
            if (jSONObject.has("icon")) {
                plugin.f4080d = jSONObject.getString("icon");
            }
            if (jSONObject.has("author")) {
                plugin.f4081e = jSONObject.getString("author");
            }
            if (jSONObject.has(NotificationCompat.CATEGORY_EMAIL)) {
                jSONObject.getString(NotificationCompat.CATEGORY_EMAIL);
            }
            if (jSONObject.has("url")) {
                jSONObject.getString("url");
            }
            if (jSONObject.has("opensource")) {
                jSONObject.getBoolean("opensource");
            }
            if (jSONObject.has("repository")) {
                jSONObject.getString("repository");
            }
            return plugin;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public String m5484a() {
        return this.f4081e;
    }

    /* renamed from: b */
    public String m5485b() {
        return this.f4079c;
    }

    /* renamed from: c */
    public String m5486c() {
        return this.f4080d;
    }

    /* renamed from: d */
    public String m5487d() {
        return this.f4077a;
    }

    /* renamed from: e */
    public String m5488e() {
        return this.f4078b;
    }

    /* renamed from: f */
    public boolean m5489f(Context context) {
        try {
            context.getPackageManager().getPackageInfo(m5488e(), 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
