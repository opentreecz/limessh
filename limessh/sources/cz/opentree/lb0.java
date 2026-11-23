package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform;
import com.google.firebase.crashlytics.internal.settings.SettingsDataProvider;
import cz.opentree.oa0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class lb0 {

    /* renamed from: g */
    public static final Charset f4774g = Charset.forName("UTF-8");

    /* renamed from: h */
    public static final int f4775h = 15;

    /* renamed from: i */
    public static final CrashlyticsReportJsonTransform f4776i = new CrashlyticsReportJsonTransform();

    /* renamed from: j */
    public static final Comparator<? super File> f4777j = jb0.m5099a();

    /* renamed from: k */
    public static final FilenameFilter f4778k = kb0.m5865a();

    /* renamed from: a */
    @NonNull
    public final AtomicInteger f4779a = new AtomicInteger(0);

    /* renamed from: b */
    @NonNull
    public final File f4780b;

    /* renamed from: c */
    @NonNull
    public final File f4781c;

    /* renamed from: d */
    @NonNull
    public final File f4782d;

    /* renamed from: e */
    @NonNull
    public final File f4783e;

    /* renamed from: f */
    @NonNull
    public final SettingsDataProvider f4784f;

    public lb0(@NonNull File file, @NonNull SettingsDataProvider settingsDataProvider) {
        File file2 = new File(file, "report-persistence");
        this.f4780b = new File(file2, "sessions");
        this.f4781c = new File(file2, "priority-reports");
        this.f4782d = new File(file2, "reports");
        this.f4783e = new File(file2, "native-reports");
        this.f4784f = settingsDataProvider;
    }

    /* renamed from: A */
    public static int m6103A(@NonNull File file, @NonNull File file2) {
        return m6119o(file.getName()).compareTo(m6119o(file2.getName()));
    }

    @NonNull
    /* renamed from: D */
    public static File m6104D(@NonNull File file) throws IOException {
        if (m6128z(file)) {
            return file;
        }
        throw new IOException("Could not create directory " + file);
    }

    @NonNull
    /* renamed from: E */
    public static String m6105E(@NonNull File file) throws IOException {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    String str = new String(byteArrayOutputStream.toByteArray(), f4774g);
                    m6112a(null, fileInputStream);
                    return str;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            } finally {
            }
        }
    }

    /* renamed from: F */
    public static void m6106F(@Nullable File file) {
        if (file == null) {
            return;
        }
        if (file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                m6106F(file2);
            }
        }
        file.delete();
    }

    @NonNull
    /* renamed from: G */
    public static List<File> m6107G(@NonNull List<File>... listArr) {
        for (List<File> list : listArr) {
            Collections.sort(list, f4777j);
        }
        return m6116g(listArr);
    }

    /* renamed from: H */
    public static void m6108H(@NonNull File file, @NonNull File file2, @NonNull oa0.AbstractC1644c abstractC1644c, @NonNull String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f4776i;
            oa0 m6925n = crashlyticsReportJsonTransform.m1813E(m6105E(file)).m6925n(abstractC1644c);
            m6104D(file2);
            m6111L(new File(file2, str), crashlyticsReportJsonTransform.m1814F(m6925n));
        } catch (IOException e) {
            m80.m6375f().m6378c("Could not synthesize final native report file for " + file, e);
        }
    }

    /* renamed from: J */
    public static void m6109J(@NonNull File file, @NonNull File file2, @NonNull List<oa0.AbstractC1645d.d> list, long j, boolean z, @Nullable String str) {
        try {
            CrashlyticsReportJsonTransform crashlyticsReportJsonTransform = f4776i;
            oa0 m6924m = crashlyticsReportJsonTransform.m1813E(m6105E(file)).m6926o(j, z, str).m6924m(pa0.m7255e(list));
            oa0.AbstractC1645d mo6921j = m6924m.mo6921j();
            if (mo6921j == null) {
                return;
            }
            m6104D(file2);
            m6111L(new File(file2, mo6921j.mo6961h()), crashlyticsReportJsonTransform.m1814F(m6924m));
        } catch (IOException e) {
            m80.m6375f().m6378c("Could not synthesize final report file for " + file, e);
        }
    }

    /* renamed from: K */
    public static int m6110K(@NonNull File file, int i) {
        List<File> m6121q = m6121q(file, hb0.m4428a());
        Collections.sort(m6121q, ib0.m4743a());
        return m6115e(m6121q, i);
    }

    /* renamed from: L */
    public static void m6111L(File file, String str) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f4774g);
        try {
            outputStreamWriter.write(str);
            m6112a(null, outputStreamWriter);
        } finally {
        }
    }

    /* renamed from: a */
    public static /* synthetic */ void m6112a(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    public static int m6115e(List<File> list, int i) {
        int size = list.size();
        for (File file : list) {
            if (size <= i) {
                return size;
            }
            m6106F(file);
            size--;
        }
        return size;
    }

    @NonNull
    /* renamed from: g */
    public static List<File> m6116g(@NonNull List<File>... listArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (List<File> list : listArr) {
            i += list.size();
        }
        arrayList.ensureCapacity(i);
        for (List<File> list2 : listArr) {
            arrayList.addAll(list2);
        }
        return arrayList;
    }

    @NonNull
    /* renamed from: l */
    public static String m6117l(int i, boolean z) {
        return NotificationCompat.CATEGORY_EVENT + String.format(Locale.US, "%010d", Integer.valueOf(i)) + (z ? "_" : "");
    }

    @NonNull
    /* renamed from: m */
    public static List<File> m6118m(@NonNull File file) {
        return m6120p(file, null);
    }

    @NonNull
    /* renamed from: o */
    public static String m6119o(@NonNull String str) {
        return str.substring(0, f4775h);
    }

    @NonNull
    /* renamed from: p */
    public static List<File> m6120p(@NonNull File file, @Nullable FileFilter fileFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    @NonNull
    /* renamed from: q */
    public static List<File> m6121q(@NonNull File file, @Nullable FilenameFilter filenameFilter) {
        if (!file.isDirectory()) {
            return Collections.emptyList();
        }
        File[] listFiles = filenameFilter == null ? file.listFiles() : file.listFiles(filenameFilter);
        return listFiles != null ? Arrays.asList(listFiles) : Collections.emptyList();
    }

    /* renamed from: s */
    public static boolean m6122s(@NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && str.endsWith("_");
    }

    /* renamed from: t */
    public static boolean m6123t(@NonNull File file, @NonNull String str) {
        return str.startsWith(NotificationCompat.CATEGORY_EVENT) && !str.endsWith("_");
    }

    /* renamed from: u */
    public static /* synthetic */ boolean m6124u(String str, File file) {
        return file.isDirectory() && !file.getName().equals(str);
    }

    /* renamed from: z */
    public static boolean m6128z(@NonNull File file) {
        return file.exists() || file.mkdirs();
    }

    /* renamed from: B */
    public void m6129B(@NonNull oa0.AbstractC1645d.d dVar, @NonNull String str, boolean z) {
        int i = this.f4784f.mo1843b().mo1846b().f4785a;
        File m6139r = m6139r(str);
        try {
            m6111L(new File(m6139r, m6117l(this.f4779a.getAndIncrement(), z)), f4776i.m1816j(dVar));
        } catch (IOException e) {
            m80.m6375f().m6378c("Could not persist event for session " + str, e);
        }
        m6110K(m6139r, i);
    }

    /* renamed from: C */
    public void m6130C(@NonNull oa0 oa0Var) {
        oa0.AbstractC1645d mo6921j = oa0Var.mo6921j();
        if (mo6921j == null) {
            m80.m6375f().m6377b("Could not get session for report");
            return;
        }
        String mo6961h = mo6921j.mo6961h();
        try {
            File m6139r = m6139r(mo6961h);
            m6104D(m6139r);
            m6111L(new File(m6139r, "report"), f4776i.m1814F(oa0Var));
        } catch (IOException e) {
            m80.m6375f().m6378c("Could not persist report for session " + mo6961h, e);
        }
    }

    /* renamed from: I */
    public final void m6131I(@NonNull File file, long j) {
        boolean z;
        List<File> m6121q = m6121q(file, f4778k);
        if (m6121q.isEmpty()) {
            return;
        }
        Collections.sort(m6121q);
        ArrayList arrayList = new ArrayList();
        loop0: while (true) {
            z = false;
            for (File file2 : m6121q) {
                try {
                    arrayList.add(f4776i.m1815i(m6105E(file2)));
                } catch (IOException e) {
                    m80.m6375f().m6378c("Could not add event to report for " + file2, e);
                }
                if (z || m6122s(file2.getName())) {
                    z = true;
                }
            }
        }
        String str = null;
        try {
            str = m6105E(new File(file, "user"));
        } catch (IOException e2) {
            m80.m6375f().m6378c("Could not read user ID file in " + file.getName(), e2);
        }
        m6109J(new File(file, "report"), z ? this.f4781c : this.f4782d, arrayList, j, z, str);
    }

    @NonNull
    /* renamed from: d */
    public final List<File> m6132d(@Nullable String str) {
        List<File> m6120p = m6120p(this.f4780b, gb0.m4110a(str));
        Collections.sort(m6120p, f4777j);
        if (m6120p.size() <= 8) {
            return m6120p;
        }
        Iterator<File> it = m6120p.subList(8, m6120p.size()).iterator();
        while (it.hasNext()) {
            m6106F(it.next());
        }
        return m6120p.subList(0, 8);
    }

    /* renamed from: f */
    public final void m6133f() {
        int i = this.f4784f.mo1843b().mo1846b().f4786b;
        List<File> m6138n = m6138n();
        int size = m6138n.size();
        if (size <= i) {
            return;
        }
        Iterator<File> it = m6138n.subList(i, size).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* renamed from: h */
    public void m6134h() {
        Iterator<File> it = m6138n().iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* renamed from: i */
    public void m6135i(String str) {
        FilenameFilter m3709a = fb0.m3709a(str);
        Iterator<File> it = m6116g(m6121q(this.f4781c, m3709a), m6121q(this.f4783e, m3709a), m6121q(this.f4782d, m3709a)).iterator();
        while (it.hasNext()) {
            it.next().delete();
        }
    }

    /* renamed from: j */
    public void m6136j(@Nullable String str, long j) {
        for (File file : m6132d(str)) {
            m6131I(file, j);
            m6106F(file);
        }
        m6133f();
    }

    /* renamed from: k */
    public void m6137k(@NonNull String str, @NonNull oa0.AbstractC1644c abstractC1644c) {
        m6108H(new File(m6139r(str), "report"), this.f4783e, abstractC1644c, str);
    }

    @NonNull
    /* renamed from: n */
    public final List<File> m6138n() {
        return m6107G(m6116g(m6118m(this.f4781c), m6118m(this.f4783e)), m6118m(this.f4782d));
    }

    @NonNull
    /* renamed from: r */
    public final File m6139r(@NonNull String str) {
        return new File(this.f4780b, str);
    }

    @NonNull
    /* renamed from: y */
    public List<b90> m6140y() {
        List<File> m6138n = m6138n();
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(m6138n.size());
        for (File file : m6138n()) {
            try {
                arrayList.add(b90.m2401a(f4776i.m1813E(m6105E(file)), file.getName()));
            } catch (IOException e) {
                m80.m6375f().m6378c("Could not load report file " + file + "; deleting", e);
                file.delete();
            }
        }
        return arrayList;
    }
}
