package cz.opentree;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class es0 extends is0 {

    /* renamed from: S */
    public static final byte[] f2532S = new byte[0];

    /* renamed from: Q */
    public final int f2533Q;

    /* renamed from: R */
    public int f2534R;

    public es0(InputStream inputStream, int i, int i2) {
        super(inputStream, i2);
        if (i < 0) {
            throw new IllegalArgumentException("negative lengths not allowed");
        }
        this.f2533Q = i;
        this.f2534R = i;
        if (i == 0) {
            m4917b(true);
        }
    }

    /* renamed from: c */
    public int m3551c() {
        return this.f2534R;
    }

    /* renamed from: d */
    public void m3552d(byte[] bArr) throws IOException {
        int i = this.f2534R;
        if (i != bArr.length) {
            throw new IllegalArgumentException("buffer length not right for data");
        }
        if (i == 0) {
            return;
        }
        int m4916a = m4916a();
        int i2 = this.f2534R;
        if (i2 >= m4916a) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f2534R + " >= " + m4916a);
        }
        int m7881c = i2 - r51.m7881c(this.f3405O, bArr);
        this.f2534R = m7881c;
        if (m7881c == 0) {
            m4917b(true);
            return;
        }
        throw new EOFException("DEF length " + this.f2533Q + " object truncated by " + this.f2534R);
    }

    /* renamed from: f */
    public byte[] m3553f() throws IOException {
        if (this.f2534R == 0) {
            return f2532S;
        }
        int m4916a = m4916a();
        int i = this.f2534R;
        if (i >= m4916a) {
            throw new IOException("corrupted stream - out of bounds length found: " + this.f2534R + " >= " + m4916a);
        }
        byte[] bArr = new byte[i];
        int m7881c = i - r51.m7881c(this.f3405O, bArr);
        this.f2534R = m7881c;
        if (m7881c == 0) {
            m4917b(true);
            return bArr;
        }
        throw new EOFException("DEF length " + this.f2533Q + " object truncated by " + this.f2534R);
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.f2534R == 0) {
            return -1;
        }
        int read = this.f3405O.read();
        if (read >= 0) {
            int i = this.f2534R - 1;
            this.f2534R = i;
            if (i == 0) {
                m4917b(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f2533Q + " object truncated by " + this.f2534R);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f2534R;
        if (i3 == 0) {
            return -1;
        }
        int read = this.f3405O.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this.f2534R - read;
            this.f2534R = i4;
            if (i4 == 0) {
                m4917b(true);
            }
            return read;
        }
        throw new EOFException("DEF length " + this.f2533Q + " object truncated by " + this.f2534R);
    }
}
