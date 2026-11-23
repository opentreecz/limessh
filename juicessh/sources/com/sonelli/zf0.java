package com.sonelli;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class zf0 {

    /* renamed from: c */
    public static final String[] f8500c = {"*", "FCM", "GCM", ""};

    /* renamed from: a */
    @GuardedBy("iidPrefs")
    public final SharedPreferences f8501a;

    /* renamed from: b */
    public final String f8502b;

    public zf0(@NonNull FirebaseApp firebaseApp) {
        this.f8501a = firebaseApp.m1580g().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f8502b = m10440b(firebaseApp);
    }

    /* renamed from: b */
    public static String m10440b(FirebaseApp firebaseApp) {
        String m4385d = firebaseApp.m1582j().m4385d();
        if (m4385d != null) {
            return m4385d;
        }
        String m4384c = firebaseApp.m1582j().m4384c();
        if (!m4384c.startsWith("1:") && !m4384c.startsWith("2:")) {
            return m4384c;
        }
        String[] split = m4384c.split(":");
        if (split.length != 4) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    @Nullable
    /* renamed from: c */
    public static String m10441c(@NonNull PublicKey publicKey) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    /* renamed from: a */
    public final String m10442a(@NonNull String str, @NonNull String str2) {
        return "|T|" + str + "|" + str2;
    }

    /* renamed from: d */
    public final String m10443d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    /* renamed from: e */
    public final PublicKey m10444e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.w("ContentValues", "Invalid key stored " + e);
            return null;
        }
    }

    @Nullable
    /* renamed from: f */
    public String m10445f() {
        synchronized (this.f8501a) {
            String m10446g = m10446g();
            if (m10446g != null) {
                return m10446g;
            }
            return m10447h();
        }
    }

    @Nullable
    /* renamed from: g */
    public final String m10446g() {
        String string;
        synchronized (this.f8501a) {
            string = this.f8501a.getString("|S|id", null);
        }
        return string;
    }

    @Nullable
    /* renamed from: h */
    public final String m10447h() {
        synchronized (this.f8501a) {
            String string = this.f8501a.getString("|S||P|", null);
            if (string == null) {
                return null;
            }
            PublicKey m10444e = m10444e(string);
            if (m10444e == null) {
                return null;
            }
            return m10441c(m10444e);
        }
    }

    @Nullable
    /* renamed from: i */
    public String m10448i() {
        synchronized (this.f8501a) {
            for (String str : f8500c) {
                String string = this.f8501a.getString(m10442a(this.f8502b, str), null);
                if (string != null && !string.isEmpty()) {
                    if (string.startsWith("{")) {
                        string = m10443d(string);
                    }
                    return string;
                }
            }
            return null;
        }
    }
}
