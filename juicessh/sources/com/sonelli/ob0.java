package com.sonelli;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class ob0 extends FileOutputStream {

    /* renamed from: R */
    public static final FilenameFilter f5470R = new C1648a();

    /* renamed from: O */
    public final String f5471O;

    /* renamed from: P */
    public File f5472P;

    /* renamed from: Q */
    public boolean f5473Q;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.ob0$a */
    /* loaded from: classes.dex */
    public class C1648a implements FilenameFilter {
        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.endsWith(".cls_temp");
        }
    }

    public ob0(File file, String str) throws FileNotFoundException {
        super(new File(file, str + ".cls_temp"));
        this.f5473Q = false;
        String str2 = file + File.separator + str;
        this.f5471O = str2;
        this.f5472P = new File(str2 + ".cls_temp");
    }

    /* renamed from: a */
    public void m7009a() throws IOException {
        if (this.f5473Q) {
            return;
        }
        this.f5473Q = true;
        super.flush();
        super.close();
    }

    @Override // java.io.FileOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.f5473Q) {
            return;
        }
        this.f5473Q = true;
        super.flush();
        super.close();
        File file = new File(this.f5471O + ".cls");
        if (this.f5472P.renameTo(file)) {
            this.f5472P = null;
            return;
        }
        String str = "";
        if (file.exists()) {
            str = " (target already exists)";
        } else if (!this.f5472P.exists()) {
            str = " (source does not exist)";
        }
        throw new IOException("Could not rename temp file: " + this.f5472P + " -> " + file + str);
    }
}
