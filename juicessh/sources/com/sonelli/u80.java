package com.sonelli;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.common.NativeSessionFile;
import com.sonelli.oa0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class u80 implements NativeSessionFile {

    /* renamed from: a */
    @Nullable
    public final byte[] f6926a;

    /* renamed from: b */
    @NonNull
    public final String f6927b;

    /* renamed from: c */
    @NonNull
    public final String f6928c;

    public u80(@NonNull String str, @NonNull String str2, @Nullable byte[] bArr) {
        this.f6927b = str;
        this.f6928c = str2;
        this.f6926a = bArr;
    }

    /* renamed from: d */
    public static /* synthetic */ void m8859d(Throwable th, AutoCloseable autoCloseable) {
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
        return this.f6928c;
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    /* renamed from: b */
    public InputStream mo1742b() {
        if (m8861f()) {
            return null;
        }
        return new ByteArrayInputStream(this.f6926a);
    }

    @Override // com.google.firebase.crashlytics.internal.common.NativeSessionFile
    @Nullable
    /* renamed from: c */
    public oa0.AbstractC1644c.b mo1743c() {
        byte[] m8860e = m8860e();
        if (m8860e == null) {
            return null;
        }
        oa0.AbstractC1644c.b.a m6948a = oa0.AbstractC1644c.b.m6948a();
        m6948a.mo6952b(m8860e);
        m6948a.mo6953c(this.f6927b);
        return m6948a.mo6951a();
    }

    @Nullable
    /* renamed from: e */
    public final byte[] m8860e() {
        if (m8861f()) {
            return null;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                try {
                    gZIPOutputStream.write(this.f6926a);
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    m8859d(null, gZIPOutputStream);
                    m8859d(null, byteArrayOutputStream);
                    return byteArray;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: f */
    public final boolean m8861f() {
        byte[] bArr = this.f6926a;
        return bArr == null || bArr.length == 0;
    }
}
