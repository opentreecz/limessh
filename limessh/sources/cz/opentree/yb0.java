package cz.opentree;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import java.io.File;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class yb0 extends p80 implements CreateReportSpiCall {

    /* renamed from: f */
    public final String f8194f;

    public yb0(String str, String str2, db0 db0Var, String str3) {
        super(str, str2, db0Var, bb0.POST);
        this.f8194f = str3;
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    /* renamed from: b */
    public boolean mo1841b(tb0 tb0Var, boolean z) {
        if (!z) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        cb0 m7250c = m7250c();
        m10121g(m7250c, tb0Var.f6755b);
        m10122h(m7250c, tb0Var.f6754a, tb0Var.f6756c);
        m80.m6375f().m6377b("Sending report to: " + m7252e());
        try {
            int m3472b = m7250c.m2749b().m3472b();
            m80.m6375f().m6377b("Result was: " + m3472b);
            return l90.m6099a(m3472b) == 0;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: g */
    public final cb0 m10121g(cb0 cb0Var, String str) {
        cb0Var.m2751d("User-Agent", "Crashlytics Android SDK/" + y80.m10100i());
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f8194f);
        cb0Var.m2751d("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        return cb0Var;
    }

    /* renamed from: h */
    public final cb0 m10122h(cb0 cb0Var, @Nullable String str, Report report) {
        if (str != null) {
            cb0Var.m2754g("org_id", str);
        }
        cb0Var.m2754g("report_id", report.mo1837b());
        for (File file : report.mo1839d()) {
            if (file.getName().equals("minidump")) {
                cb0Var.m2755h("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("metadata")) {
                cb0Var.m2755h("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                cb0Var.m2755h("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                cb0Var.m2755h("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                cb0Var.m2755h("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                cb0Var.m2755h("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                cb0Var.m2755h("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("user")) {
                cb0Var.m2755h("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                cb0Var.m2755h("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                cb0Var.m2755h("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return cb0Var;
    }
}
