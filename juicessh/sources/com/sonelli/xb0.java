package com.sonelli;

import com.google.firebase.crashlytics.internal.report.model.Report;
import com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class xb0 extends p80 implements CreateReportSpiCall {

    /* renamed from: f */
    public final String f7917f;

    public xb0(String str, String str2, db0 db0Var, bb0 bb0Var, String str3) {
        super(str, str2, db0Var, bb0Var);
        this.f7917f = str3;
    }

    public xb0(String str, String str2, db0 db0Var, String str3) {
        this(str, str2, db0Var, bb0.POST, str3);
    }

    @Override // com.google.firebase.crashlytics.internal.report.network.CreateReportSpiCall
    /* renamed from: b */
    public boolean mo1841b(tb0 tb0Var, boolean z) {
        if (!z) {
            throw new RuntimeException("An invalid data collection token was used.");
        }
        cb0 m7250c = m7250c();
        m9753g(m7250c, tb0Var);
        m9754h(m7250c, tb0Var.f6756c);
        m80.m6375f().m6377b("Sending report to: " + m7252e());
        try {
            eb0 m2749b = m7250c.m2749b();
            int m3472b = m2749b.m3472b();
            m80.m6375f().m6377b("Create report request ID: " + m2749b.m3473d("X-REQUEST-ID"));
            m80.m6375f().m6377b("Result was: " + m3472b);
            return l90.m6099a(m3472b) == 0;
        } catch (IOException e) {
            m80.m6375f().m6380e("Create report HTTP request failed.", e);
            throw new RuntimeException(e);
        }
    }

    /* renamed from: g */
    public final cb0 m9753g(cb0 cb0Var, tb0 tb0Var) {
        cb0Var.m2751d("X-CRASHLYTICS-GOOGLE-APP-ID", tb0Var.f6755b);
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-TYPE", "android");
        cb0Var.m2751d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f7917f);
        Iterator<Map.Entry<String, String>> it = tb0Var.f6756c.mo1836a().entrySet().iterator();
        while (it.hasNext()) {
            cb0Var.m2752e(it.next());
        }
        return cb0Var;
    }

    /* renamed from: h */
    public final cb0 m9754h(cb0 cb0Var, Report report) {
        cb0Var.m2754g("report[identifier]", report.mo1837b());
        if (report.mo1839d().length == 1) {
            m80.m6375f().m6377b("Adding single file " + report.mo1840e() + " to report " + report.mo1837b());
            cb0Var.m2755h("report[file]", report.mo1840e(), "application/octet-stream", report.mo1838c());
            return cb0Var;
        }
        int i = 0;
        for (File file : report.mo1839d()) {
            m80.m6375f().m6377b("Adding file " + file.getName() + " to report " + report.mo1837b());
            StringBuilder sb = new StringBuilder();
            sb.append("report[file");
            sb.append(i);
            sb.append("]");
            cb0Var.m2755h(sb.toString(), file.getName(), "application/octet-stream", file);
            i++;
        }
        return cb0Var;
    }
}
