package com.google.firebase.crashlytics.internal.log;

import android.content.Context;
import androidx.annotation.Nullable;
import cz.opentree.m80;
import cz.opentree.s90;
import cz.opentree.w80;
import java.io.File;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class LogFileManager {

    /* renamed from: d */
    public static final C0658b f1218d = new C0658b();

    /* renamed from: a */
    public final Context f1219a;

    /* renamed from: b */
    public final DirectoryProvider f1220b;

    /* renamed from: c */
    public FileLogStore f1221c;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface DirectoryProvider {
        /* renamed from: a */
        File mo1735a();
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.log.LogFileManager$b */
    /* loaded from: classes.dex */
    public static final class C0658b implements FileLogStore {
        public C0658b() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        /* renamed from: a */
        public void mo1744a() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        /* renamed from: b */
        public String mo1745b() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        /* renamed from: c */
        public byte[] mo1746c() {
            return null;
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        /* renamed from: d */
        public void mo1747d() {
        }

        @Override // com.google.firebase.crashlytics.internal.log.FileLogStore
        /* renamed from: e */
        public void mo1748e(long j, String str) {
        }
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider) {
        this(context, directoryProvider, null);
    }

    public LogFileManager(Context context, DirectoryProvider directoryProvider, String str) {
        this.f1219a = context;
        this.f1220b = directoryProvider;
        this.f1221c = f1218d;
        m1755g(str);
    }

    /* renamed from: a */
    public void m1749a() {
        this.f1221c.mo1747d();
    }

    /* renamed from: b */
    public void m1750b(Set<String> set) {
        File[] listFiles = this.f1220b.mo1735a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(m1753e(file))) {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: c */
    public byte[] m1751c() {
        return this.f1221c.mo1746c();
    }

    @Nullable
    /* renamed from: d */
    public String m1752d() {
        return this.f1221c.mo1745b();
    }

    /* renamed from: e */
    public final String m1753e(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }

    /* renamed from: f */
    public final File m1754f(String str) {
        return new File(this.f1220b.mo1735a(), "crashlytics-userlog-" + str + ".temp");
    }

    /* renamed from: g */
    public final void m1755g(String str) {
        this.f1221c.mo1744a();
        this.f1221c = f1218d;
        if (str == null) {
            return;
        }
        if (w80.m9433l(this.f1219a, "com.crashlytics.CollectCustomLogs", true)) {
            m1756h(m1754f(str), 65536);
        } else {
            m80.m6375f().m6377b("Preferences requested no custom logs. Aborting log file creation.");
        }
    }

    /* renamed from: h */
    public void m1756h(File file, int i) {
        this.f1221c = new s90(file, i);
    }

    /* renamed from: i */
    public void m1757i(long j, String str) {
        this.f1221c.mo1748e(j, str);
    }
}
