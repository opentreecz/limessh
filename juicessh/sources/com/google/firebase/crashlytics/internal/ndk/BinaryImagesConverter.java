package com.google.firebase.crashlytics.internal.ndk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import cz.opentree.m80;
import cz.opentree.ya0;
import cz.opentree.za0;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class BinaryImagesConverter {

    /* renamed from: a */
    public final Context f1238a;

    /* renamed from: b */
    public final FileIdStrategy f1239b;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface FileIdStrategy {
        /* renamed from: a */
        String mo1826a(File file) throws IOException;
    }

    public BinaryImagesConverter(Context context, FileIdStrategy fileIdStrategy) {
        this.f1238a = context;
        this.f1239b = fileIdStrategy;
    }

    @NonNull
    /* renamed from: c */
    public static JSONObject m1818c(String str, ya0 ya0Var) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("base_address", ya0Var.f8190a);
        jSONObject.put("size", ya0Var.f8191b);
        jSONObject.put("name", ya0Var.f8193d);
        jSONObject.put("uuid", str);
        return jSONObject;
    }

    @NonNull
    /* renamed from: d */
    public static byte[] m1819d(JSONArray jSONArray) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("binary_images", jSONArray);
            return jSONObject.toString().getBytes(Charset.forName("UTF-8"));
        } catch (JSONException e) {
            m80.m6375f().m6384j("Binary images string is null", e);
            return new byte[0];
        }
    }

    /* renamed from: f */
    public static boolean m1820f(ya0 ya0Var) {
        return (ya0Var.f8192c.indexOf(120) == -1 || ya0Var.f8193d.indexOf(47) == -1) ? false : true;
    }

    @NonNull
    /* renamed from: a */
    public byte[] m1821a(BufferedReader bufferedReader) throws IOException {
        return m1819d(m1825h(bufferedReader));
    }

    @NonNull
    /* renamed from: b */
    public final File m1822b(File file) {
        if (Build.VERSION.SDK_INT < 9 || !file.getAbsolutePath().startsWith("/data")) {
            return file;
        }
        try {
            return new File(this.f1238a.getPackageManager().getApplicationInfo(this.f1238a.getPackageName(), 0).nativeLibraryDir, file.getName());
        } catch (PackageManager.NameNotFoundException e) {
            m80.m6375f().m6380e("Error getting ApplicationInfo", e);
            return file;
        }
    }

    @NonNull
    /* renamed from: e */
    public final File m1823e(String str) {
        File file = new File(str);
        return !file.exists() ? m1822b(file) : file;
    }

    @Nullable
    /* renamed from: g */
    public final JSONObject m1824g(String str) {
        ya0 m10416a = za0.m10416a(str);
        if (m10416a != null && m1820f(m10416a)) {
            try {
                try {
                    return m1818c(this.f1239b.mo1826a(m1823e(m10416a.f8193d)), m10416a);
                } catch (JSONException e) {
                    m80.m6375f().m6378c("Could not create a binary image json string", e);
                    return null;
                }
            } catch (IOException e2) {
                m80.m6375f().m6378c("Could not generate ID for file " + m10416a.f8193d, e2);
            }
        }
        return null;
    }

    @NonNull
    /* renamed from: h */
    public final JSONArray m1825h(BufferedReader bufferedReader) throws IOException {
        JSONArray jSONArray = new JSONArray();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return jSONArray;
            }
            JSONObject m1824g = m1824g(readLine);
            if (m1824g != null) {
                jSONArray.put(m1824g);
            }
        }
    }
}
