package cz.opentree;

import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class ub0 implements Report {

    /* renamed from: a */
    public final File f6947a;

    public ub0(File file) {
        this.f6947a = file;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: a */
    public Map<String, String> mo1836a() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: b */
    public String mo1837b() {
        return this.f6947a.getName();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: c */
    public File mo1838c() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: d */
    public File[] mo1839d() {
        return this.f6947a.listFiles();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: e */
    public String mo1840e() {
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Report.EnumC0663a getType() {
        return Report.EnumC0663a.NATIVE;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public void remove() {
        for (File file : mo1839d()) {
            m80.m6375f().m6377b("Removing native report file at " + file.getPath());
            file.delete();
        }
        m80.m6375f().m6377b("Removing native report directory at " + this.f6947a);
        this.f6947a.delete();
    }
}
