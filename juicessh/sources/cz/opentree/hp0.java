package cz.opentree;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import okio.BufferedSink;
import okio.Sink;
import okio.Source;

/* compiled from: RealBufferedSink.java */
/* loaded from: classes.dex */
public final class hp0 implements BufferedSink {

    /* renamed from: O */
    public final zo0 f3213O = new zo0();

    /* renamed from: P */
    public final Sink f3214P;

    /* renamed from: Q */
    public boolean f3215Q;

    public hp0(Sink sink) {
        Objects.requireNonNull(sink, "sink == null");
        this.f3214P = sink;
    }

    @Override // okio.BufferedSink
    /* renamed from: A */
    public BufferedSink mo4611A(String str) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10571s0(str);
        mo4622v();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: E */
    public BufferedSink mo4612E(byte[] bArr, int i, int i2) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10564l0(bArr, i, i2);
        mo4622v();
        return this;
    }

    @Override // okio.Sink
    /* renamed from: F */
    public void mo2189F(zo0 zo0Var, long j) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.mo2189F(zo0Var, j);
        mo4622v();
    }

    @Override // okio.BufferedSink
    /* renamed from: G */
    public long mo4613G(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo2186R = source.mo2186R(this.f3213O, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (mo2186R == -1) {
                return j;
            }
            j += mo2186R;
            mo4622v();
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: H */
    public BufferedSink mo4614H(long j) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10567o0(j);
        return mo4622v();
    }

    @Override // okio.BufferedSink
    /* renamed from: N */
    public BufferedSink mo4615N(byte[] bArr) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10562k0(bArr);
        mo4622v();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: O */
    public BufferedSink mo4616O(ap0 ap0Var) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10561j0(ap0Var);
        mo4622v();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: V */
    public BufferedSink mo4617V(long j) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10566n0(j);
        mo4622v();
        return this;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3215Q) {
            return;
        }
        try {
            zo0 zo0Var = this.f3213O;
            long j = zo0Var.f8573P;
            if (j > 0) {
                this.f3214P.mo2189F(zo0Var, j);
            }
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.f3214P.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        this.f3215Q = true;
        if (th == null) {
            return;
        }
        np0.m6765e(th);
        throw null;
    }

    @Override // okio.BufferedSink
    /* renamed from: e */
    public zo0 mo4618e() {
        return this.f3213O;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        zo0 zo0Var = this.f3213O;
        long j = zo0Var.f8573P;
        if (j > 0) {
            this.f3214P.mo2189F(zo0Var, j);
        }
        this.f3214P.flush();
    }

    @Override // okio.Sink
    /* renamed from: g */
    public mp0 mo2190g() {
        return this.f3214P.mo2190g();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3215Q;
    }

    @Override // okio.BufferedSink
    /* renamed from: m */
    public BufferedSink mo4619m(int i) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10569q0(i);
        mo4622v();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: o */
    public BufferedSink mo4620o(int i) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10568p0(i);
        mo4622v();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: t */
    public BufferedSink mo4621t(int i) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        this.f3213O.m10565m0(i);
        return mo4622v();
    }

    public String toString() {
        return "buffer(" + this.f3214P + ")";
    }

    @Override // okio.BufferedSink
    /* renamed from: v */
    public BufferedSink mo4622v() throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        long m10554d = this.f3213O.m10554d();
        if (m10554d > 0) {
            this.f3214P.mo2189F(this.f3213O, m10554d);
        }
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (this.f3215Q) {
            throw new IllegalStateException("closed");
        }
        int write = this.f3213O.write(byteBuffer);
        mo4622v();
        return write;
    }
}
