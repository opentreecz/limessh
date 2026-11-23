package cz.opentree;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MarkableInputStream.java */
/* loaded from: classes.dex */
public final class ol0 extends InputStream {

    /* renamed from: O */
    public final InputStream f5503O;

    /* renamed from: P */
    public long f5504P;

    /* renamed from: Q */
    public long f5505Q;

    /* renamed from: R */
    public long f5506R;

    /* renamed from: S */
    public long f5507S;

    public ol0(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public ol0(InputStream inputStream, int i) {
        this.f5507S = -1L;
        this.f5503O = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    /* renamed from: a */
    public void m7051a(long j) throws IOException {
        if (this.f5504P > this.f5506R || j < this.f5505Q) {
            throw new IOException("Cannot reset");
        }
        this.f5503O.reset();
        m7054d(this.f5505Q, j);
        this.f5504P = j;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f5503O.available();
    }

    /* renamed from: b */
    public long m7052b(int i) {
        long j = this.f5504P + i;
        if (this.f5506R < j) {
            m7053c(j);
        }
        return this.f5504P;
    }

    /* renamed from: c */
    public final void m7053c(long j) {
        try {
            long j2 = this.f5505Q;
            long j3 = this.f5504P;
            if (j2 >= j3 || j3 > this.f5506R) {
                this.f5505Q = j3;
                this.f5503O.mark((int) (j - j3));
            } else {
                this.f5503O.reset();
                this.f5503O.mark((int) (j - this.f5505Q));
                m7054d(this.f5505Q, this.f5504P);
            }
            this.f5506R = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f5503O.close();
    }

    /* renamed from: d */
    public final void m7054d(long j, long j2) throws IOException {
        while (j < j2) {
            long skip = this.f5503O.skip(j2 - j);
            if (skip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    skip = 1;
                }
            }
            j += skip;
        }
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f5507S = m7052b(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f5503O.markSupported();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int read = this.f5503O.read();
        if (read != -1) {
            this.f5504P++;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int read = this.f5503O.read(bArr);
        if (read != -1) {
            this.f5504P += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.f5503O.read(bArr, i, i2);
        if (read != -1) {
            this.f5504P += read;
        }
        return read;
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        m7051a(this.f5507S);
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long skip = this.f5503O.skip(j);
        this.f5504P += skip;
        return skip;
    }
}
