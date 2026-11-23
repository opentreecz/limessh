package cz.opentree;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class cc0 {

    /* renamed from: a */
    public final Context f1912a;

    public cc0(Context context) {
        this.f1912a = context;
    }

    /* renamed from: a */
    public final File m2759a() {
        return new File(new mb0(this.f1912a).mo1828b(), "com.crashlytics.settings.json");
    }

    /* renamed from: b */
    public JSONObject m2760b() {
        Throwable th;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        m80.m6375f().m6377b("Reading cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File m2759a = m2759a();
                if (m2759a.exists()) {
                    fileInputStream = new FileInputStream(m2759a);
                    try {
                        jSONObject = new JSONObject(w80.m9421H(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e) {
                        e = e;
                        m80.m6375f().m6380e("Failed to fetch cached settings", e);
                        w80.m9426e(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    m80.m6375f().m6377b("No cached settings found.");
                    jSONObject = null;
                }
                w80.m9426e(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th2) {
                th = th2;
                w80.m9426e(null, "Error while closing settings cache file.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            fileInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            w80.m9426e(null, "Error while closing settings cache file.");
            throw th;
        }
    }

    /* renamed from: c */
    public void m2761c(long j, JSONObject jSONObject) {
        FileWriter fileWriter;
        m80.m6375f().m6377b("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter2 = null;
            try {
                try {
                    jSONObject.put("expires_at", j);
                    fileWriter = new FileWriter(m2759a());
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                fileWriter.write(jSONObject.toString());
                fileWriter.flush();
                w80.m9426e(fileWriter, "Failed to close settings writer.");
            } catch (Exception e2) {
                e = e2;
                fileWriter2 = fileWriter;
                m80.m6375f().m6380e("Failed to cache settings", e);
                w80.m9426e(fileWriter2, "Failed to close settings writer.");
            } catch (Throwable th2) {
                th = th2;
                fileWriter2 = fileWriter;
                w80.m9426e(fileWriter2, "Failed to close settings writer.");
                throw th;
            }
        }
    }
}
