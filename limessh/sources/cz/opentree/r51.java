package cz.opentree;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class r51 {

    /* renamed from: a */
    public static int f6186a = 4096;

    /* renamed from: a */
    public static void m7879a(InputStream inputStream, OutputStream outputStream) throws IOException {
        int i = f6186a;
        byte[] bArr = new byte[i];
        while (true) {
            int read = inputStream.read(bArr, 0, i);
            if (read < 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    /* renamed from: b */
    public static byte[] m7880b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        m7879a(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: c */
    public static int m7881c(InputStream inputStream, byte[] bArr) throws IOException {
        return m7882d(inputStream, bArr, 0, bArr.length);
    }

    /* renamed from: d */
    public static int m7882d(InputStream inputStream, byte[] bArr, int i, int i2) throws IOException {
        int i3 = 0;
        while (i3 < i2) {
            int read = inputStream.read(bArr, i + i3, i2 - i3);
            if (read < 0) {
                break;
            }
            i3 += read;
        }
        return i3;
    }
}
