package cz.opentree;

import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import cz.opentree.bg0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
/* loaded from: classes.dex */
public class ag0 {

    /* renamed from: a */
    public final File f1381a;

    /* renamed from: b */
    @NonNull
    public final FirebaseApp f1382b;

    /* compiled from: com.google.firebase:firebase-installations@@16.2.1 */
    /* renamed from: cz.opentree.ag0$a */
    /* loaded from: classes.dex */
    public enum EnumC0710a {
        ATTEMPT_MIGRATION,
        NOT_GENERATED,
        UNREGISTERED,
        REGISTERED,
        REGISTER_ERROR
    }

    public ag0(@NonNull FirebaseApp firebaseApp) {
        this.f1381a = new File(firebaseApp.m1580g().getFilesDir(), "PersistedInstallation." + firebaseApp.m1583k() + ".json");
        this.f1382b = firebaseApp;
    }

    @NonNull
    /* renamed from: a */
    public bg0 m2062a(@NonNull bg0 bg0Var) {
        File createTempFile;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("Fid", bg0Var.mo2461d());
            jSONObject.put("Status", bg0Var.mo2464g().ordinal());
            jSONObject.put("AuthToken", bg0Var.mo2459b());
            jSONObject.put("RefreshToken", bg0Var.mo2463f());
            jSONObject.put("TokenCreationEpochInSecs", bg0Var.mo2465h());
            jSONObject.put("ExpiresInSecs", bg0Var.mo2460c());
            jSONObject.put("FisError", bg0Var.mo2462e());
            createTempFile = File.createTempFile("PersistedInstallation", "tmp", this.f1382b.m1580g().getFilesDir());
            FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
            fileOutputStream.write(jSONObject.toString().getBytes("UTF-8"));
            fileOutputStream.close();
        } catch (IOException | JSONException unused) {
        }
        if (createTempFile.renameTo(this.f1381a)) {
            return bg0Var;
        }
        throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }

    /* renamed from: b */
    public final JSONObject m2063b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            FileInputStream fileInputStream = new FileInputStream(this.f1381a);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr, 0, 16384);
                    if (read < 0) {
                        return new JSONObject(byteArrayOutputStream.toString());
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } finally {
                }
            }
        } catch (IOException | JSONException unused) {
            return new JSONObject();
        }
    }

    @NonNull
    /* renamed from: c */
    public bg0 m2064c() {
        JSONObject m2063b = m2063b();
        String optString = m2063b.optString("Fid", null);
        int optInt = m2063b.optInt("Status", EnumC0710a.ATTEMPT_MIGRATION.ordinal());
        String optString2 = m2063b.optString("AuthToken", null);
        String optString3 = m2063b.optString("RefreshToken", null);
        long optLong = m2063b.optLong("TokenCreationEpochInSecs", 0L);
        long optLong2 = m2063b.optLong("ExpiresInSecs", 0L);
        String optString4 = m2063b.optString("FisError", null);
        bg0.AbstractC0769a m2458a = bg0.m2458a();
        m2458a.mo2481d(optString);
        m2458a.mo2484g(EnumC0710a.values()[optInt]);
        m2458a.mo2479b(optString2);
        m2458a.mo2483f(optString3);
        m2458a.mo2485h(optLong);
        m2458a.mo2480c(optLong2);
        m2458a.mo2482e(optString4);
        return m2458a.mo2478a();
    }
}
