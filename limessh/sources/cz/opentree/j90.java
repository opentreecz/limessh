package cz.opentree;

import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class j90 {

    /* renamed from: a */
    public final File f3522a;

    static {
        Charset.forName("UTF-8");
    }

    public j90(File file) {
        this.f3522a = file;
    }

    /* renamed from: c */
    public static q90 m5083c(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        q90 q90Var = new q90();
        q90Var.m7641d(m5084e(jSONObject, "userId"));
        return q90Var;
    }

    /* renamed from: e */
    public static String m5084e(JSONObject jSONObject, String str) {
        if (jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str, null);
    }

    @NonNull
    /* renamed from: a */
    public File m5085a(String str) {
        return new File(this.f3522a, str + "keys.meta");
    }

    @NonNull
    /* renamed from: b */
    public File m5086b(String str) {
        return new File(this.f3522a, str + "user.meta");
    }

    /* renamed from: d */
    public q90 m5087d(String str) {
        FileInputStream fileInputStream;
        File m5086b = m5086b(str);
        if (!m5086b.exists()) {
            return new q90();
        }
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(m5086b);
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            q90 m5083c = m5083c(w80.m9421H(fileInputStream));
            w80.m9426e(fileInputStream, "Failed to close user metadata file.");
            return m5083c;
        } catch (Exception e2) {
            e = e2;
            fileInputStream2 = fileInputStream;
            m80.m6375f().m6380e("Error deserializing user metadata.", e);
            w80.m9426e(fileInputStream2, "Failed to close user metadata file.");
            return new q90();
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            w80.m9426e(fileInputStream2, "Failed to close user metadata file.");
            throw th;
        }
    }
}
