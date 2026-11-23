package com.sonelli;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.JsonReader;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.platforminfo.UserAgentPublisher;
import com.sonelli.fg0;
import com.sonelli.gg0;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class eg0 {

    /* renamed from: d */
    public static final Pattern f2384d = Pattern.compile("[0-9]+s");

    /* renamed from: e */
    public static final Charset f2385e = Charset.forName("UTF-8");

    /* renamed from: a */
    public final Context f2386a;

    /* renamed from: b */
    public final UserAgentPublisher f2387b;

    /* renamed from: c */
    public final HeartBeatInfo f2388c;

    public eg0(@NonNull Context context, @Nullable UserAgentPublisher userAgentPublisher, @Nullable HeartBeatInfo heartBeatInfo) {
        this.f2386a = context;
        this.f2387b = userAgentPublisher;
        this.f2388c = heartBeatInfo;
    }

    /* renamed from: a */
    public static JSONObject m3482a(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("fid", str);
        jSONObject.put("appId", str2);
        jSONObject.put("authVersion", "FIS_v2");
        jSONObject.put("sdkVersion", "a:16.2.1");
        return jSONObject;
    }

    /* renamed from: b */
    public static JSONObject m3483b() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("sdkVersion", "a:16.2.1");
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("installation", jSONObject);
        return jSONObject2;
    }

    /* renamed from: g */
    public static long m3484g(String str) {
        C0813ca.m2720b(f2384d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    @NonNull
    /* renamed from: c */
    public fg0 m3485c(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @Nullable String str5) throws IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations", str3)));
        while (i <= 1) {
            HttpURLConnection m3488f = m3488f(url, str);
            try {
                m3488f.setRequestMethod("POST");
                m3488f.setDoOutput(true);
                if (str5 != null) {
                    m3488f.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                }
                m3491j(m3488f, str2, str4);
                int responseCode = m3488f.getResponseCode();
                if (responseCode == 200) {
                    return m3489h(m3488f);
                }
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    fg0.AbstractC0987a m3771a = fg0.m3771a();
                    m3771a.mo2794e(fg0.EnumC0988b.BAD_CONFIG);
                    return m3771a.mo2790a();
                }
                i++;
            } finally {
                m3488f.disconnect();
            }
        }
        throw new IOException();
    }

    @NonNull
    /* renamed from: d */
    public gg0 m3486d(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4) throws IOException {
        int i = 0;
        URL url = new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", String.format("projects/%s/installations/%s/authTokens:generate", str3, str2)));
        while (i <= 1) {
            HttpURLConnection m3488f = m3488f(url, str);
            try {
                m3488f.setRequestMethod("POST");
                m3488f.addRequestProperty("Authorization", "FIS_v2 " + str4);
                m3492k(m3488f);
                int responseCode = m3488f.getResponseCode();
                if (responseCode == 200) {
                    return m3490i(m3488f);
                }
                if (responseCode == 401 || responseCode == 404) {
                    gg0.AbstractC1041a m4121a = gg0.m4121a();
                    m4121a.mo3199b(gg0.EnumC1042b.AUTH_ERROR);
                    return m4121a.mo3198a();
                }
                if (responseCode != 429 && (responseCode < 500 || responseCode >= 600)) {
                    gg0.AbstractC1041a m4121a2 = gg0.m4121a();
                    m4121a2.mo3199b(gg0.EnumC1042b.BAD_CONFIG);
                    return m4121a2.mo3198a();
                }
                i++;
            } finally {
                m3488f.disconnect();
            }
        }
        throw new IOException();
    }

    /* renamed from: e */
    public final String m3487e() {
        try {
            Context context = this.f2386a;
            byte[] m10119a = C2338yb.m10119a(context, context.getPackageName());
            if (m10119a != null) {
                return C1036gc.m4112b(m10119a, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f2386a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.f2386a.getPackageName(), e);
            return null;
        }
    }

    /* renamed from: f */
    public final HttpURLConnection m3488f(URL url, String str) throws IOException {
        HeartBeatInfo.EnumC0664a mo1864a;
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.addRequestProperty("Content-Type", "application/json");
        httpURLConnection.addRequestProperty("Accept", "application/json");
        httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.addRequestProperty("X-Android-Package", this.f2386a.getPackageName());
        HeartBeatInfo heartBeatInfo = this.f2388c;
        if (heartBeatInfo != null && this.f2387b != null && (mo1864a = heartBeatInfo.mo1864a("fire-installations-id")) != HeartBeatInfo.EnumC0664a.NONE) {
            httpURLConnection.addRequestProperty("x-firebase-client", this.f2387b.mo1911a());
            httpURLConnection.addRequestProperty("x-firebase-client-log-type", Integer.toString(mo1864a.m1865f()));
        }
        httpURLConnection.addRequestProperty("X-Android-Cert", m3487e());
        httpURLConnection.addRequestProperty("x-goog-api-key", str);
        return httpURLConnection;
    }

    /* renamed from: h */
    public final fg0 m3489h(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), f2385e));
        gg0.AbstractC1041a m4121a = gg0.m4121a();
        fg0.AbstractC0987a m3771a = fg0.m3771a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("name")) {
                m3771a.mo2795f(jsonReader.nextString());
            } else if (nextName.equals("fid")) {
                m3771a.mo2792c(jsonReader.nextString());
            } else if (nextName.equals("refreshToken")) {
                m3771a.mo2793d(jsonReader.nextString());
            } else if (nextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    if (nextName2.equals("token")) {
                        m4121a.mo3200c(jsonReader.nextString());
                    } else if (nextName2.equals("expiresIn")) {
                        m4121a.mo3201d(m3484g(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                m3771a.mo2791b(m4121a.mo3198a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        m3771a.mo2794e(fg0.EnumC0988b.OK);
        return m3771a.mo2790a();
    }

    /* renamed from: i */
    public final gg0 m3490i(HttpURLConnection httpURLConnection) throws IOException {
        JsonReader jsonReader = new JsonReader(new InputStreamReader(httpURLConnection.getInputStream(), f2385e));
        gg0.AbstractC1041a m4121a = gg0.m4121a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (nextName.equals("token")) {
                m4121a.mo3200c(jsonReader.nextString());
            } else if (nextName.equals("expiresIn")) {
                m4121a.mo3201d(m3484g(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        m4121a.mo3199b(gg0.EnumC1042b.OK);
        return m4121a.mo3198a();
    }

    /* renamed from: j */
    public final void m3491j(HttpURLConnection httpURLConnection, @NonNull String str, @NonNull String str2) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send CreateInstallation request to FIS. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            try {
                gZIPOutputStream.write(m3482a(str, str2).toString().getBytes("UTF-8"));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        } finally {
            gZIPOutputStream.close();
        }
    }

    /* renamed from: k */
    public final void m3492k(HttpURLConnection httpURLConnection) throws IOException {
        OutputStream outputStream = httpURLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send GenerateAuthToken request to FIS. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            try {
                gZIPOutputStream.write(m3483b().toString().getBytes("UTF-8"));
            } catch (JSONException e) {
                throw new IllegalStateException(e);
            }
        } finally {
            gZIPOutputStream.close();
        }
    }
}
