package com.sonelli;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import org.bouncycastle.util.encoders.Encoder;

/* loaded from: classes.dex */
public class p51 implements Encoder {

    /* renamed from: a */
    public final byte[] f5629a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: b */
    public final byte[] f5630b = new byte[128];

    public p51() {
        m7249e();
    }

    /* renamed from: d */
    public static boolean m7246d(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    /* renamed from: a */
    public int mo6083a(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && m7246d(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        int i2 = 0;
        while (i < length) {
            while (i < length && m7246d(str.charAt(i))) {
                i++;
            }
            int i3 = i + 1;
            byte b = this.f5630b[str.charAt(i)];
            while (i3 < length && m7246d(str.charAt(i3))) {
                i3++;
            }
            int i4 = i3 + 1;
            byte b2 = this.f5630b[str.charAt(i3)];
            if ((b | b2) < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            outputStream.write((b << 4) | b2);
            i2++;
            i = i4;
        }
        return i2;
    }

    /* renamed from: b */
    public byte[] m7247b(String str, int i, int i2) throws IOException {
        Objects.requireNonNull(str, "'str' cannot be null");
        if (i < 0 || i2 < 0 || i > str.length() - i2) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        }
        if ((i2 & 1) != 0) {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
        int i3 = i2 >>> 1;
        byte[] bArr = new byte[i3];
        int i4 = 0;
        while (i4 < i3) {
            int i5 = i + 1;
            int i6 = i5 + 1;
            int i7 = (this.f5630b[str.charAt(i)] << 4) | this.f5630b[str.charAt(i5)];
            if (i7 < 0) {
                throw new IOException("invalid characters encountered in Hex string");
            }
            bArr[i4] = (byte) i7;
            i4++;
            i = i6;
        }
        return bArr;
    }

    /* renamed from: c */
    public int m7248c(byte[] bArr, int i, int i2, OutputStream outputStream) throws IOException {
        for (int i3 = i; i3 < i + i2; i3++) {
            int i4 = bArr[i3] & 255;
            outputStream.write(this.f5629a[i4 >>> 4]);
            outputStream.write(this.f5629a[i4 & 15]);
        }
        return i2 * 2;
    }

    /* renamed from: e */
    public void m7249e() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f5630b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f5629a;
            if (i >= bArr2.length) {
                byte[] bArr3 = this.f5630b;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
            this.f5630b[bArr2[i]] = (byte) i;
            i++;
        }
    }
}
