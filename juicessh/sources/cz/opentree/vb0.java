package cz.opentree;

import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class vb0 implements Report {

    /* renamed from: a */
    public final File f7437a;

    /* renamed from: b */
    public final File[] f7438b;

    /* renamed from: c */
    public final Map<String, String> f7439c;

    public vb0(File file) {
        this(file, Collections.emptyMap());
    }

    public vb0(File file, Map<String, String> map) {
        this.f7437a = file;
        this.f7438b = new File[]{file};
        this.f7439c = new HashMap(map);
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: a */
    public Map<String, String> mo1836a() {
        return Collections.unmodifiableMap(this.f7439c);
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: b */
    public String mo1837b() {
        String mo1840e = mo1840e();
        return mo1840e.substring(0, mo1840e.lastIndexOf(46));
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: c */
    public File mo1838c() {
        return this.f7437a;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: d */
    public File[] mo1839d() {
        return this.f7438b;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    /* renamed from: e */
    public String mo1840e() {
        return mo1838c().getName();
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public Report.EnumC0663a getType() {
        return Report.EnumC0663a.JAVA;
    }

    @Override // com.google.firebase.crashlytics.internal.report.model.Report
    public void remove() {
        m80.m6375f().m6377b("Removing report at " + this.f7437a.getPath());
        this.f7437a.delete();
    }
}
