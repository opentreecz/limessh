package cz.opentree;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Objects;
import okio.BufferedSource;
import okio.Source;

/* compiled from: RealBufferedSource.java */
/* loaded from: classes.dex */
public final class ip0 implements BufferedSource {

    /* renamed from: O */
    public final zo0 f3391O = new zo0();

    /* renamed from: P */
    public final Source f3392P;

    /* renamed from: Q */
    public boolean f3393Q;

    public ip0(Source source) {
        Objects.requireNonNull(source, "source == null");
        this.f3392P = source;
    }

    @Override // okio.BufferedSource
    /* renamed from: B */
    public boolean mo4893B(long j, ap0 ap0Var) throws IOException {
        return m4903b(j, ap0Var, 0, ap0Var.mo2247w());
    }

    @Override // okio.BufferedSource
    /* renamed from: C */
    public String mo4894C(Charset charset) throws IOException {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        this.f3391O.mo4613G(this.f3392P);
        return this.f3391O.mo4894C(charset);
    }

    @Override // okio.BufferedSource
    /* renamed from: I */
    public String mo4895I() throws IOException {
        return mo4908w(RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    /* renamed from: J */
    public int mo4896J() throws IOException {
        mo4899U(4L);
        return this.f3391O.mo4896J();
    }

    @Override // okio.BufferedSource
    /* renamed from: L */
    public byte[] mo4897L(long j) throws IOException {
        mo4899U(j);
        return this.f3391O.mo4897L(j);
    }

    @Override // okio.BufferedSource
    /* renamed from: P */
    public short mo4898P() throws IOException {
        mo4899U(2L);
        return this.f3391O.mo4898P();
    }

    @Override // okio.Source
    /* renamed from: R */
    public long mo2186R(zo0 zo0Var, long j) throws IOException {
        if (zo0Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        zo0 zo0Var2 = this.f3391O;
        if (zo0Var2.f8573P == 0 && this.f3392P.mo2186R(zo0Var2, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1L;
        }
        return this.f3391O.mo2186R(zo0Var, Math.min(j, this.f3391O.f8573P));
    }

    @Override // okio.BufferedSource
    /* renamed from: U */
    public void mo4899U(long j) throws IOException {
        if (!m4904c(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    /* renamed from: W */
    public long mo4900W(byte b) throws IOException {
        return m4902a(b, 0L, RecyclerView.FOREVER_NS);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0032, code lost:
    
        if (r1 == 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0049, code lost:
    
        throw new java.lang.NumberFormatException(java.lang.String.format("Expected leading [0-9a-fA-F] character but was %#x", java.lang.Byte.valueOf(r3)));
     */
    @Override // okio.BufferedSource
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo4901X() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 1
            r6.mo4899U(r0)
            r0 = 0
            r1 = r0
        L7:
            int r2 = r1 + 1
            long r3 = (long) r2
            boolean r3 = r6.m4904c(r3)
            if (r3 == 0) goto L4a
            cz.opentree.zo0 r3 = r6.f3391O
            long r4 = (long) r1
            byte r3 = r3.m10575z(r4)
            r4 = 48
            if (r3 < r4) goto L1f
            r4 = 57
            if (r3 <= r4) goto L30
        L1f:
            r4 = 97
            if (r3 < r4) goto L27
            r4 = 102(0x66, float:1.43E-43)
            if (r3 <= r4) goto L30
        L27:
            r4 = 65
            if (r3 < r4) goto L32
            r4 = 70
            if (r3 <= r4) goto L30
            goto L32
        L30:
            r1 = r2
            goto L7
        L32:
            if (r1 == 0) goto L35
            goto L4a
        L35:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Byte r3 = java.lang.Byte.valueOf(r3)
            r2[r0] = r3
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was %#x"
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r1.<init>(r0)
            throw r1
        L4a:
            cz.opentree.zo0 r0 = r6.f3391O
            long r0 = r0.mo4901X()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.ip0.mo4901X():long");
    }

    /* renamed from: a */
    public long m4902a(byte b, long j, long j2) throws IOException {
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        }
        while (j < j2) {
            long m10546D = this.f3391O.m10546D(b, j, j2);
            if (m10546D == -1) {
                zo0 zo0Var = this.f3391O;
                long j3 = zo0Var.f8573P;
                if (j3 >= j2 || this.f3392P.mo2186R(zo0Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    break;
                }
                j = Math.max(j, j3);
            } else {
                return m10546D;
            }
        }
        return -1L;
    }

    /* renamed from: b */
    public boolean m4903b(long j, ap0 ap0Var, int i, int i2) throws IOException {
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        if (j < 0 || i < 0 || i2 < 0 || ap0Var.mo2247w() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = i3 + j;
            if (!m4904c(1 + j2) || this.f3391O.m10575z(j2) != ap0Var.mo2241p(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    public boolean m4904c(long j) throws IOException {
        zo0 zo0Var;
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        do {
            zo0Var = this.f3391O;
            if (zo0Var.f8573P >= j) {
                return true;
            }
        } while (this.f3392P.mo2186R(zo0Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1);
        return false;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f3393Q) {
            return;
        }
        this.f3393Q = true;
        this.f3392P.close();
        this.f3391O.m10550b();
    }

    @Override // okio.BufferedSource
    /* renamed from: e */
    public zo0 mo4905e() {
        return this.f3391O;
    }

    @Override // okio.Source
    /* renamed from: g */
    public mp0 mo2188g() {
        return this.f3392P.mo2188g();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f3393Q;
    }

    @Override // okio.BufferedSource
    /* renamed from: k */
    public ap0 mo4906k(long j) throws IOException {
        mo4899U(j);
        return this.f3391O.mo4906k(j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        zo0 zo0Var = this.f3391O;
        if (zo0Var.f8573P == 0 && this.f3392P.mo2186R(zo0Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        }
        return this.f3391O.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        mo4899U(1L);
        return this.f3391O.readByte();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            mo4899U(bArr.length);
            this.f3391O.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                zo0 zo0Var = this.f3391O;
                long j = zo0Var.f8573P;
                if (j <= 0) {
                    throw e;
                }
                int read = zo0Var.read(bArr, i, (int) j);
                if (read == -1) {
                    throw new AssertionError();
                }
                i += read;
            }
        }
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        mo4899U(4L);
        return this.f3391O.readInt();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        mo4899U(2L);
        return this.f3391O.readShort();
    }

    @Override // okio.BufferedSource
    /* renamed from: s */
    public boolean mo4907s() throws IOException {
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        return this.f3391O.mo4907s() && this.f3392P.mo2186R(this.f3391O, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws IOException {
        if (this.f3393Q) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            zo0 zo0Var = this.f3391O;
            if (zo0Var.f8573P == 0 && this.f3392P.mo2186R(zo0Var, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.f3391O.m10557f0());
            this.f3391O.skip(min);
            j -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f3392P + ")";
    }

    @Override // okio.BufferedSource
    /* renamed from: w */
    public String mo4908w(long j) throws IOException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        long m4902a = m4902a((byte) 10, 0L, j2);
        if (m4902a != -1) {
            return this.f3391O.m10556e0(m4902a);
        }
        if (j2 < RecyclerView.FOREVER_NS && m4904c(j2) && this.f3391O.m10575z(j2 - 1) == 13 && m4904c(1 + j2) && this.f3391O.m10575z(j2) == 10) {
            return this.f3391O.m10556e0(j2);
        }
        zo0 zo0Var = new zo0();
        zo0 zo0Var2 = this.f3391O;
        zo0Var2.m10563l(zo0Var, 0L, Math.min(32L, zo0Var2.m10557f0()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f3391O.m10557f0(), j) + " content=" + zo0Var.m10549a0().mo2242q() + (char) 8230);
    }
}
