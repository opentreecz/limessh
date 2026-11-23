package cz.opentree;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/* compiled from: JsonHttpResponseHandler.java */
/* loaded from: classes.dex */
public class zg0 extends yg0 {
    @Override // cz.opentree.yg0
    /* renamed from: b */
    public void mo10132b(Throwable th, String str) {
        if (str == null) {
            mo7341g(th, "");
            return;
        }
        try {
            Object m10456v = m10456v(str);
            if (m10456v instanceof JSONObject) {
                mo7344s(th, (JSONObject) m10456v);
            } else if (m10456v instanceof JSONArray) {
                m10455r(th, (JSONArray) m10456v);
            }
        } catch (JSONException unused) {
            mo7341g(th, str);
        }
    }

    @Override // cz.opentree.yg0
    /* renamed from: d */
    public void mo10134d(String str) {
        super.mo10134d(str);
        try {
            if (str == null) {
                throw new JSONException("Empty response from server");
            }
            Object m10456v = m10456v(str);
            if (m10456v instanceof JSONObject) {
                mo7345u((JSONObject) m10456v);
            } else {
                if (m10456v instanceof JSONArray) {
                    mo5232t((JSONArray) m10456v);
                    return;
                }
                throw new JSONException("Unexpected type " + m10456v.getClass().getName());
            }
        } catch (JSONException e) {
            mo7341g(e, str);
        }
    }

    /* renamed from: r */
    public void m10455r(Throwable th, JSONArray jSONArray) {
    }

    /* renamed from: s */
    public void mo7344s(Throwable th, JSONObject jSONObject) {
    }

    /* renamed from: t */
    public void mo5232t(JSONArray jSONArray) {
    }

    /* renamed from: u */
    public void mo7345u(JSONObject jSONObject) {
    }

    /* renamed from: v */
    public Object m10456v(String str) throws JSONException {
        return new JSONTokener(str).nextValue();
    }
}
