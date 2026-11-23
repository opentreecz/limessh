package cz.opentree;

import com.google.firebase.crashlytics.internal.report.ReportUploader;
import com.google.firebase.crashlytics.internal.report.model.Report;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class sb0 {

    /* renamed from: a */
    public final ReportUploader.ReportFilesProvider f6424a;

    public sb0(ReportUploader.ReportFilesProvider reportFilesProvider) {
        this.f6424a = reportFilesProvider;
    }

    /* renamed from: a */
    public boolean m8420a() {
        File[] mo1737b = this.f6424a.mo1737b();
        File[] mo1736a = this.f6424a.mo1736a();
        if (mo1737b == null || mo1737b.length <= 0) {
            return mo1736a != null && mo1736a.length > 0;
        }
        return true;
    }

    /* renamed from: b */
    public void m8421b(Report report) {
        report.remove();
    }

    /* renamed from: c */
    public void m8422c(List<Report> list) {
        Iterator<Report> it = list.iterator();
        while (it.hasNext()) {
            m8421b(it.next());
        }
    }

    /* renamed from: d */
    public List<Report> m8423d() {
        m80.m6375f().m6377b("Checking for crash reports...");
        File[] mo1737b = this.f6424a.mo1737b();
        File[] mo1736a = this.f6424a.mo1736a();
        LinkedList linkedList = new LinkedList();
        if (mo1737b != null) {
            for (File file : mo1737b) {
                m80.m6375f().m6377b("Found crash report " + file.getPath());
                linkedList.add(new vb0(file));
            }
        }
        if (mo1736a != null) {
            for (File file2 : mo1736a) {
                linkedList.add(new ub0(file2));
            }
        }
        if (linkedList.isEmpty()) {
            m80.m6375f().m6377b("No reports found.");
        }
        return linkedList;
    }
}
