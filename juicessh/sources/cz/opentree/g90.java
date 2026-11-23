package cz.opentree;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import cz.opentree.oa0;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class g90 implements NativeSessionFile {

    /* renamed from: a */
    @NonNull
    public final File f2842a;

    /* renamed from: b */
    @NonNull
    public final String f2843b;

    /* renamed from: c */
    @NonNull
    public final String f2844c;

    public g90(@NonNull String str, @NonNull String str2, @NonNull File file) {
        this.f2843b = str;
        this.f2844c = str2;
        this.f2842a = file;
    }

    /* renamed from: d */
    public static /* synthetic */ void m4059d(Throwable th, AutoCloseable autoCloseable) {
        if (th == null) {
            autoCloseable.close();
        } else {
            try {
                autoCloseable.close();
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @NonNull
    /* renamed from: a */
    public String mo1741a() {
        return this.f2844c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    /* renamed from: b */
    public InputStream mo1742b() {
        if (this.f2842a.exists() && this.f2842a.isFile()) {
            try {
                return new FileInputStream(this.f2842a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    /* renamed from: c */
    public oa0.AbstractC1644c.b mo1743c() {
        byte[] m4060e = m4060e();
        if (m4060e == null) {
            return null;
        }
        oa0.AbstractC1644c.b.a m6948a = oa0.AbstractC1644c.b.m6948a();
        m6948a.mo6952b(m4060e);
        m6948a.mo6953c(this.f2843b);
        return m6948a.mo6951a();
    }

    @Nullable
    /* renamed from: e */
    public final byte[] m4060e() {
        byte[] bArr = new byte[8192];
        try {
            InputStream mo1742b = mo1742b();
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                    if (mo1742b == null) {
                        m4059d(null, gZIPOutputStream);
                        m4059d(null, byteArrayOutputStream);
                        if (mo1742b != null) {
                            m4059d(null, mo1742b);
                        }
                        return null;
                    }
                    while (true) {
                        try {
                            int read = mo1742b.read(bArr);
                            if (read <= 0) {
                                break;
                            }
                            gZIPOutputStream.write(bArr, 0, read);
                        } finally {
                        }
                    }
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    m4059d(null, gZIPOutputStream);
                    m4059d(null, byteArrayOutputStream);
                    if (mo1742b != null) {
                        m4059d(null, mo1742b);
                    }
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }
}
