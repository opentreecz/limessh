package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class k90 {
    /* renamed from: a */
    public static void m5849a(@Nullable InputStream inputStream, @NonNull File file) throws IOException {
        if (inputStream == null) {
            return;
        }
        byte[] bArr = new byte[8192];
        GZIPOutputStream gZIPOutputStream = null;
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        gZIPOutputStream2.finish();
                        w80.m9427f(gZIPOutputStream2);
                        return;
                    }
                    gZIPOutputStream2.write(bArr, 0, read);
                } catch (Throwable th) {
                    th = th;
                    gZIPOutputStream = gZIPOutputStream2;
                    w80.m9427f(gZIPOutputStream);
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* renamed from: b */
    public static void m5850b(File file, List<NativeSessionFile> list) {
        for (NativeSessionFile nativeSessionFile : list) {
            InputStream inputStream = null;
            try {
                inputStream = nativeSessionFile.mo1742b();
                if (inputStream != null) {
                    m5849a(inputStream, new File(file, nativeSessionFile.mo1741a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                w80.m9427f(null);
                throw th;
            }
            w80.m9427f(inputStream);
        }
    }
}
