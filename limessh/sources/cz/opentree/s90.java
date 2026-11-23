package cz.opentree;

import com.google.firebase.crashlytics.internal.log.FileLogStore;
import com.google.firebase.crashlytics.internal.log.QueueFile;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class s90 implements FileLogStore {

    /* renamed from: d */
    public static final Charset f6415d = Charset.forName("UTF-8");

    /* renamed from: a */
    public final File f6416a;

    /* renamed from: b */
    public final int f6417b;

    /* renamed from: c */
    public QueueFile f6418c;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.s90$a */
    /* loaded from: classes.dex */
    public class C1851a implements QueueFile.ElementReader {

        /* renamed from: a */
        public final /* synthetic */ byte[] f6419a;

        /* renamed from: b */
        public final /* synthetic */ int[] f6420b;

        public C1851a(s90 s90Var, byte[] bArr, int[] iArr) {
            this.f6419a = bArr;
            this.f6420b = iArr;
        }

        @Override // com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader
        /* renamed from: a */
        public void mo1784a(InputStream inputStream, int i) throws IOException {
            try {
                inputStream.read(this.f6419a, this.f6420b[0], i);
                int[] iArr = this.f6420b;
                iArr[0] = iArr[0] + i;
            } finally {
                inputStream.close();
            }
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: cz.opentree.s90$b */
    /* loaded from: classes.dex */
    public class C1852b {

        /* renamed from: a */
        public final byte[] f6421a;

        /* renamed from: b */
        public final int f6422b;

        public C1852b(s90 s90Var, byte[] bArr, int i) {
            this.f6421a = bArr;
            this.f6422b = i;
        }
    }

    public s90(File file, int i) {
        this.f6416a = file;
        this.f6417b = i;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    /* renamed from: a */
    public void mo1744a() {
        w80.m9426e(this.f6418c, "There was a problem closing the Crashlytics log file.");
        this.f6418c = null;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    /* renamed from: b */
    public String mo1745b() {
        byte[] mo1746c = mo1746c();
        if (mo1746c != null) {
            return new String(mo1746c, f6415d);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    /* renamed from: c */
    public byte[] mo1746c() {
        C1852b m8417g = m8417g();
        if (m8417g == null) {
            return null;
        }
        int i = m8417g.f6422b;
        byte[] bArr = new byte[i];
        System.arraycopy(m8417g.f6421a, 0, bArr, 0, i);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    /* renamed from: d */
    public void mo1747d() {
        mo1744a();
        this.f6416a.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
    /* renamed from: e */
    public void mo1748e(long j, String str) {
        m8418h();
        m8416f(j, str);
    }

    /* renamed from: f */
    public final void m8416f(long j, String str) {
        if (this.f6418c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i = this.f6417b / 4;
            if (str.length() > i) {
                str = "..." + str.substring(str.length() - i);
            }
            this.f6418c.m1775f(String.format(Locale.US, "%d %s%n", Long.valueOf(j), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f6415d));
            while (!this.f6418c.m1783y() && this.f6418c.m1776f0() > this.f6417b) {
                this.f6418c.m1771b0();
            }
        } catch (IOException e) {
            m80.m6375f().m6380e("There was a problem writing to the Crashlytics log.", e);
        }
    }

    /* renamed from: g */
    public final C1852b m8417g() {
        if (!this.f6416a.exists()) {
            return null;
        }
        m8418h();
        QueueFile queueFile = this.f6418c;
        if (queueFile == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[queueFile.m1776f0()];
        try {
            this.f6418c.m1782p(new C1851a(this, bArr, iArr));
        } catch (IOException e) {
            m80.m6375f().m6380e("A problem occurred while reading the Crashlytics log file.", e);
        }
        return new C1852b(this, bArr, iArr[0]);
    }

    /* renamed from: h */
    public final void m8418h() {
        if (this.f6418c == null) {
            try {
                this.f6418c = new QueueFile(this.f6416a);
            } catch (IOException e) {
                m80.m6375f().m6380e("Could not open log file: " + this.f6416a, e);
            }
        }
    }
}
