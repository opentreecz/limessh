package cz.opentree;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.util.encoders.Encoder;

/* loaded from: classes.dex */
public class l51 implements Encoder {

    /* renamed from: a */
    public final byte[] f4751a = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

    /* renamed from: b */
    public byte f4752b = 61;

    /* renamed from: c */
    public final byte[] f4753c = new byte[128];

    public l51() {
        m6086d();
    }

    @Override // org.bouncycastle.util.encoders.Encoder
    /* renamed from: a */
    public int mo6083a(String str, OutputStream outputStream) throws IOException {
        int length = str.length();
        while (length > 0 && m6085c(str.charAt(length - 1))) {
            length--;
        }
        int i = 0;
        if (length == 0) {
            return 0;
        }
        int i2 = length;
        int i3 = 0;
        while (i2 > 0 && i3 != 4) {
            if (!m6085c(str.charAt(i2 - 1))) {
                i3++;
            }
            i2--;
        }
        int m6087e = m6087e(str, 0, i2);
        while (m6087e < i2) {
            int i4 = m6087e + 1;
            byte b = this.f4753c[str.charAt(m6087e)];
            int m6087e2 = m6087e(str, i4, i2);
            int i5 = m6087e2 + 1;
            byte b2 = this.f4753c[str.charAt(m6087e2)];
            int m6087e3 = m6087e(str, i5, i2);
            int i6 = m6087e3 + 1;
            byte b3 = this.f4753c[str.charAt(m6087e3)];
            int m6087e4 = m6087e(str, i6, i2);
            int i7 = m6087e4 + 1;
            byte b4 = this.f4753c[str.charAt(m6087e4)];
            if ((b | b2 | b3 | b4) < 0) {
                throw new IOException("invalid characters encountered in base64 data");
            }
            outputStream.write((b << 2) | (b2 >> 4));
            outputStream.write((b2 << 4) | (b3 >> 2));
            outputStream.write((b3 << 6) | b4);
            i += 3;
            m6087e = m6087e(str, i7, i2);
        }
        int m6087e5 = m6087e(str, m6087e, length);
        int m6087e6 = m6087e(str, m6087e5 + 1, length);
        int m6087e7 = m6087e(str, m6087e6 + 1, length);
        return i + m6084b(outputStream, str.charAt(m6087e5), str.charAt(m6087e6), str.charAt(m6087e7), str.charAt(m6087e(str, m6087e7 + 1, length)));
    }

    /* renamed from: b */
    public final int m6084b(OutputStream outputStream, char c, char c2, char c3, char c4) throws IOException {
        byte b = this.f4752b;
        if (c3 == b) {
            if (c4 != b) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            byte[] bArr = this.f4753c;
            byte b2 = bArr[c];
            byte b3 = bArr[c2];
            if ((b2 | b3) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b2 << 2) | (b3 >> 4));
            return 1;
        }
        if (c4 == b) {
            byte[] bArr2 = this.f4753c;
            byte b4 = bArr2[c];
            byte b5 = bArr2[c2];
            byte b6 = bArr2[c3];
            if ((b4 | b5 | b6) < 0) {
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            outputStream.write((b4 << 2) | (b5 >> 4));
            outputStream.write((b5 << 4) | (b6 >> 2));
            return 2;
        }
        byte[] bArr3 = this.f4753c;
        byte b7 = bArr3[c];
        byte b8 = bArr3[c2];
        byte b9 = bArr3[c3];
        byte b10 = bArr3[c4];
        if ((b7 | b8 | b9 | b10) < 0) {
            throw new IOException("invalid characters encountered at end of base64 data");
        }
        outputStream.write((b7 << 2) | (b8 >> 4));
        outputStream.write((b8 << 4) | (b9 >> 2));
        outputStream.write((b9 << 6) | b10);
        return 3;
    }

    /* renamed from: c */
    public final boolean m6085c(char c) {
        return c == '\n' || c == '\r' || c == '\t' || c == ' ';
    }

    /* renamed from: d */
    public void m6086d() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f4753c;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = this.f4751a;
            if (i >= bArr2.length) {
                return;
            }
            this.f4753c[bArr2[i]] = (byte) i;
            i++;
        }
    }

    /* renamed from: e */
    public final int m6087e(String str, int i, int i2) {
        while (i < i2 && m6085c(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
