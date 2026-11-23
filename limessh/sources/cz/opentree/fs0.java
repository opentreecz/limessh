package cz.opentree;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class fs0 extends is0 {

    /* renamed from: Q */
    public int f2768Q;

    /* renamed from: R */
    public int f2769R;

    /* renamed from: S */
    public boolean f2770S;

    /* renamed from: T */
    public boolean f2771T;

    public fs0(InputStream inputStream, int i) throws IOException {
        super(inputStream, i);
        this.f2770S = false;
        this.f2771T = true;
        this.f2768Q = inputStream.read();
        int read = inputStream.read();
        this.f2769R = read;
        if (read < 0) {
            throw new EOFException();
        }
        m3876c();
    }

    /* renamed from: c */
    public final boolean m3876c() {
        if (!this.f2770S && this.f2771T && this.f2768Q == 0 && this.f2769R == 0) {
            this.f2770S = true;
            m4917b(true);
        }
        return this.f2770S;
    }

    /* renamed from: d */
    public void m3877d(boolean z) {
        this.f2771T = z;
        m3876c();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (m3876c()) {
            return -1;
        }
        int read = this.f3405O.read();
        if (read < 0) {
            throw new EOFException();
        }
        int i = this.f2768Q;
        this.f2768Q = this.f2769R;
        this.f2769R = read;
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f2771T || i2 < 3) {
            return super.read(bArr, i, i2);
        }
        if (this.f2770S) {
            return -1;
        }
        int read = this.f3405O.read(bArr, i + 2, i2 - 2);
        if (read < 0) {
            throw new EOFException();
        }
        bArr[i] = (byte) this.f2768Q;
        bArr[i + 1] = (byte) this.f2769R;
        this.f2768Q = this.f3405O.read();
        int read2 = this.f3405O.read();
        this.f2769R = read2;
        if (read2 >= 0) {
            return read + 2;
        }
        throw new EOFException();
    }
}
