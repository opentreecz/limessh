package com.sonelli;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.bouncycastle.asn1.ASN1String;

/* loaded from: classes.dex */
public abstract class pp0 extends eq0 implements ASN1String {

    /* renamed from: Q */
    public static final char[] f5755Q = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: O */
    public final byte[] f5756O;

    /* renamed from: P */
    public final int f5757P;

    public pp0(byte[] bArr, int i) {
        Objects.requireNonNull(bArr, "'data' cannot be null");
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.f5756O = e51.m3436e(bArr);
        this.f5757P = i;
    }

    /* renamed from: t */
    public static byte[] m7435t(byte[] bArr, int i) {
        if (bArr.length == 0) {
            return bArr;
        }
        byte[] m3436e = e51.m3436e(bArr);
        int length = bArr.length - 1;
        m3436e[length] = (byte) ((255 << i) & m3436e[length]);
        return m3436e;
    }

    /* renamed from: u */
    public static pp0 m7436u(int i, InputStream inputStream) throws IOException {
        if (i < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int read = inputStream.read();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        if (i2 != 0) {
            if (r51.m7881c(inputStream, bArr) != i2) {
                throw new EOFException("EOF encountered in middle of BIT STRING");
            }
            if (read > 0 && read < 8) {
                int i3 = i2 - 1;
                if (bArr[i3] != ((byte) (bArr[i3] & (255 << read)))) {
                    return new vr0(bArr, read);
                }
            }
        }
        return new xq0(bArr, read);
    }

    @Override // com.sonelli.zp0
    public int hashCode() {
        byte[] bArr = this.f5756O;
        int length = bArr.length - 1;
        if (length < 0) {
            return 1;
        }
        return ((e51.m3446o(bArr, 0, length) * 257) ^ ((byte) (bArr[length] & (255 << this.f5757P)))) ^ this.f5757P;
    }

    @Override // com.sonelli.eq0
    /* renamed from: k */
    public boolean mo2259k(eq0 eq0Var) {
        if (!(eq0Var instanceof pp0)) {
            return false;
        }
        pp0 pp0Var = (pp0) eq0Var;
        if (this.f5757P != pp0Var.f5757P) {
            return false;
        }
        byte[] bArr = this.f5756O;
        byte[] bArr2 = pp0Var.f5756O;
        int length = bArr.length;
        if (length != bArr2.length) {
            return false;
        }
        int i = length - 1;
        if (i < 0) {
            return true;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        byte b = bArr[i];
        int i3 = this.f5757P;
        return ((byte) (b & (255 << i3))) == ((byte) (bArr2[i] & (255 << i3)));
    }

    @Override // com.sonelli.eq0
    /* renamed from: r */
    public eq0 mo2596r() {
        return new xq0(this.f5756O, this.f5757P);
    }

    @Override // com.sonelli.eq0
    /* renamed from: s */
    public eq0 mo2597s() {
        return new vr0(this.f5756O, this.f5757P);
    }

    public String toString() {
        return m7439x();
    }

    /* renamed from: v */
    public byte[] m7437v() {
        return m7435t(this.f5756O, this.f5757P);
    }

    /* renamed from: w */
    public byte[] m7438w() {
        if (this.f5757P == 0) {
            return e51.m3436e(this.f5756O);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    /* renamed from: x */
    public String m7439x() {
        StringBuffer stringBuffer = new StringBuffer("#");
        try {
            byte[] encoded = getEncoded();
            for (int i = 0; i != encoded.length; i++) {
                char[] cArr = f5755Q;
                stringBuffer.append(cArr[(encoded[i] >>> 4) & 15]);
                stringBuffer.append(cArr[encoded[i] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e) {
            throw new dq0("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }
}
