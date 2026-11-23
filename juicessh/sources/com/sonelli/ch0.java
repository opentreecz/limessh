package com.sonelli;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;

/* compiled from: SimpleMultipartEntity.java */
/* loaded from: classes.dex */
public class ch0 implements HttpEntity {

    /* renamed from: S */
    public static final char[] f1943S = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /* renamed from: O */
    public String f1944O;

    /* renamed from: P */
    public ByteArrayOutputStream f1945P = new ByteArrayOutputStream();

    /* renamed from: Q */
    public boolean f1946Q = false;

    /* renamed from: R */
    public boolean f1947R = false;

    public ch0() {
        this.f1944O = null;
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            char[] cArr = f1943S;
            stringBuffer.append(cArr[random.nextInt(cArr.length)]);
        }
        this.f1944O = stringBuffer.toString();
    }

    /* renamed from: a */
    public void m2802a(String str, String str2) {
        m2805d();
        try {
            this.f1945P.write(("Content-Disposition: form-data; name=\"" + str + "\"\r\n\r\n").getBytes());
            this.f1945P.write(str2.getBytes());
            this.f1945P.write(("\r\n--" + this.f1944O + "\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void m2803b(String str, String str2, InputStream inputStream, String str3, boolean z) {
        m2805d();
        try {
            try {
                try {
                    this.f1945P.write(("Content-Disposition: form-data; name=\"" + str + "\"; filename=\"" + str2 + "\"\r\n").getBytes());
                    this.f1945P.write(("Content-Type: " + str3 + "\r\n").getBytes());
                    this.f1945P.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read == -1) {
                            break;
                        } else {
                            this.f1945P.write(bArr, 0, read);
                        }
                    }
                    if (!z) {
                        this.f1945P.write(("\r\n--" + this.f1944O + "\r\n").getBytes());
                    }
                    this.f1945P.flush();
                    inputStream.close();
                } catch (Throwable th) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                inputStream.close();
            }
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: c */
    public void m2804c(String str, String str2, InputStream inputStream, boolean z) {
        m2803b(str, str2, inputStream, "application/octet-stream", z);
    }

    @Override // org.apache.http.HttpEntity
    public void consumeContent() throws IOException, UnsupportedOperationException {
        if (isStreaming()) {
            throw new UnsupportedOperationException("Streaming entity does not implement #consumeContent()");
        }
    }

    /* renamed from: d */
    public void m2805d() {
        if (!this.f1947R) {
            try {
                this.f1945P.write(("--" + this.f1944O + "\r\n").getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.f1947R = true;
    }

    /* renamed from: e */
    public void m2806e() {
        if (this.f1946Q) {
            return;
        }
        try {
            this.f1945P.write(("\r\n--" + this.f1944O + "--\r\n").getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f1946Q = true;
    }

    @Override // org.apache.http.HttpEntity
    public InputStream getContent() throws IOException, UnsupportedOperationException {
        return new ByteArrayInputStream(this.f1945P.toByteArray());
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentEncoding() {
        return null;
    }

    @Override // org.apache.http.HttpEntity
    public long getContentLength() {
        m2806e();
        return this.f1945P.toByteArray().length;
    }

    @Override // org.apache.http.HttpEntity
    public Header getContentType() {
        return new BasicHeader("Content-Type", "multipart/form-data; boundary=" + this.f1944O);
    }

    @Override // org.apache.http.HttpEntity
    public boolean isChunked() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isRepeatable() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public boolean isStreaming() {
        return false;
    }

    @Override // org.apache.http.HttpEntity
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.f1945P.toByteArray());
    }
}
