package cz.opentree;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.annotation.WorkerThread;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.1 */
/* renamed from: cz.opentree.jz */
/* loaded from: classes.dex */
public final class C1417jz {

    /* renamed from: a */
    public final String f4393a;

    /* renamed from: b */
    public final Bundle f4394b;

    /* renamed from: c */
    public boolean f4395c;

    /* renamed from: d */
    public Bundle f4396d;

    /* renamed from: e */
    public final /* synthetic */ C0960ez f4397e;

    public C1417jz(C0960ez c0960ez, String str, Bundle bundle) {
        this.f4397e = c0960ez;
        C0813ca.m2725g(str);
        this.f4393a = str;
        this.f4394b = new Bundle();
    }

    @WorkerThread
    /* renamed from: a */
    public final Bundle m5746a() {
        if (!this.f4395c) {
            this.f4395c = true;
            String string = this.f4397e.m3588D().getString(this.f4393a, null);
            if (string != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = jSONArray.getJSONObject(i);
                            String string2 = jSONObject.getString("n");
                            String string3 = jSONObject.getString("t");
                            char c = 65535;
                            int hashCode = string3.hashCode();
                            if (hashCode != 100) {
                                if (hashCode != 108) {
                                    if (hashCode == 115 && string3.equals("s")) {
                                        c = 0;
                                    }
                                } else if (string3.equals("l")) {
                                    c = 2;
                                }
                            } else if (string3.equals("d")) {
                                c = 1;
                            }
                            if (c == 0) {
                                bundle.putString(string2, jSONObject.getString("v"));
                            } else if (c == 1) {
                                bundle.putDouble(string2, Double.parseDouble(jSONObject.getString("v")));
                            } else if (c != 2) {
                                this.f4397e.mo1484j().m8522H().m9084b("Unrecognized persisted bundle type. Type", string3);
                            } else {
                                bundle.putLong(string2, Long.parseLong(jSONObject.getString("v")));
                            }
                        } catch (NumberFormatException | JSONException unused) {
                            this.f4397e.mo1484j().m8522H().m9083a("Error reading value from SharedPreferences. Value dropped");
                        }
                    }
                    this.f4396d = bundle;
                } catch (JSONException unused2) {
                    this.f4397e.mo1484j().m8522H().m9083a("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (this.f4396d == null) {
                this.f4396d = this.f4394b;
            }
        }
        return this.f4396d;
    }

    @WorkerThread
    /* renamed from: b */
    public final void m5747b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor edit = this.f4397e.m3588D().edit();
        if (bundle.size() == 0) {
            edit.remove(this.f4393a);
        } else {
            edit.putString(this.f4393a, m5748c(bundle));
        }
        edit.apply();
        this.f4396d = bundle;
    }

    /* renamed from: c */
    public final String m5748c(Bundle bundle) {
        JSONArray jSONArray = new JSONArray();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str);
                    jSONObject.put("v", String.valueOf(obj));
                    if (obj instanceof String) {
                        jSONObject.put("t", "s");
                    } else if (obj instanceof Long) {
                        jSONObject.put("t", "l");
                    } else if (obj instanceof Double) {
                        jSONObject.put("t", "d");
                    } else {
                        this.f4397e.mo1484j().m8522H().m9084b("Cannot serialize bundle value to SharedPreferences. Type", obj.getClass());
                    }
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    this.f4397e.mo1484j().m8522H().m9084b("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }
}
