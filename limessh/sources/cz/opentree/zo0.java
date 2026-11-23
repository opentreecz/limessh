package cz.opentree;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;

/* compiled from: Buffer.java */
/* loaded from: classes.dex */
public final class zo0 implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: Q */
    public static final byte[] f8571Q = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: O */
    @Nullable
    public jp0 f8572O;

    /* renamed from: P */
    public long f8573P;

    @Override // okio.BufferedSink
    /* renamed from: A */
    public /* bridge */ /* synthetic */ BufferedSink mo4611A(String str) throws IOException {
        m10571s0(str);
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: B */
    public boolean mo4893B(long j, ap0 ap0Var) {
        return m10547Y(j, ap0Var, 0, ap0Var.mo2247w());
    }

    @Override // okio.BufferedSource
    /* renamed from: C */
    public String mo4894C(Charset charset) {
        try {
            return m10551b0(this.f8573P, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: D */
    public long m10546D(byte b, long j, long j2) {
        jp0 jp0Var;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f8573P), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.f8573P;
        long j5 = j2 > j4 ? j4 : j2;
        if (j == j5 || (jp0Var = this.f8572O) == null) {
            return -1L;
        }
        if (j4 - j < j) {
            while (j4 > j) {
                jp0Var = jp0Var.f3644g;
                j4 -= jp0Var.f3640c - jp0Var.f3639b;
            }
        } else {
            while (true) {
                long j6 = (jp0Var.f3640c - jp0Var.f3639b) + j3;
                if (j6 >= j) {
                    break;
                }
                jp0Var = jp0Var.f3643f;
                j3 = j6;
            }
            j4 = j3;
        }
        long j7 = j;
        while (j4 < j5) {
            byte[] bArr = jp0Var.f3638a;
            int min = (int) Math.min(jp0Var.f3640c, (jp0Var.f3639b + j5) - j4);
            for (int i = (int) ((jp0Var.f3639b + j7) - j4); i < min; i++) {
                if (bArr[i] == b) {
                    return (i - jp0Var.f3639b) + j4;
                }
            }
            j4 += jp0Var.f3640c - jp0Var.f3639b;
            jp0Var = jp0Var.f3643f;
            j7 = j4;
        }
        return -1L;
    }

    @Override // okio.BufferedSink
    /* renamed from: E */
    public /* bridge */ /* synthetic */ BufferedSink mo4612E(byte[] bArr, int i, int i2) throws IOException {
        m10564l0(bArr, i, i2);
        return this;
    }

    @Override // okio.Sink
    /* renamed from: F */
    public void mo2189F(zo0 zo0Var, long j) {
        if (zo0Var == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (zo0Var == this) {
            throw new IllegalArgumentException("source == this");
        }
        np0.m6762b(zo0Var.f8573P, 0L, j);
        while (j > 0) {
            jp0 jp0Var = zo0Var.f8572O;
            if (j < jp0Var.f3640c - jp0Var.f3639b) {
                jp0 jp0Var2 = this.f8572O;
                jp0 jp0Var3 = jp0Var2 != null ? jp0Var2.f3644g : null;
                if (jp0Var3 != null && jp0Var3.f3642e) {
                    if ((jp0Var3.f3640c + j) - (jp0Var3.f3641d ? 0 : jp0Var3.f3639b) <= PlaybackStateCompat.ACTION_PLAY_FROM_URI) {
                        jp0Var.m5186f(jp0Var3, (int) j);
                        zo0Var.f8573P -= j;
                        this.f8573P += j;
                        return;
                    }
                }
                zo0Var.f8572O = jp0Var.m5185e((int) j);
            }
            jp0 jp0Var4 = zo0Var.f8572O;
            long j2 = jp0Var4.f3640c - jp0Var4.f3639b;
            zo0Var.f8572O = jp0Var4.m5182b();
            jp0 jp0Var5 = this.f8572O;
            if (jp0Var5 == null) {
                this.f8572O = jp0Var4;
                jp0Var4.f3644g = jp0Var4;
                jp0Var4.f3643f = jp0Var4;
            } else {
                jp0Var5.f3644g.m5183c(jp0Var4);
                jp0Var4.m5181a();
            }
            zo0Var.f8573P -= j2;
            this.f8573P += j2;
            j -= j2;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: G */
    public long mo4613G(Source source) throws IOException {
        if (source == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long mo2186R = source.mo2186R(this, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (mo2186R == -1) {
                return j;
            }
            j += mo2186R;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: H */
    public /* bridge */ /* synthetic */ BufferedSink mo4614H(long j) throws IOException {
        m10567o0(j);
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: I */
    public String mo4895I() throws EOFException {
        return mo4908w(RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    /* renamed from: J */
    public int mo4896J() {
        return np0.m6763c(readInt());
    }

    @Override // okio.BufferedSource
    /* renamed from: L */
    public byte[] mo4897L(long j) throws EOFException {
        np0.m6762b(this.f8573P, 0L, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[(int) j];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
    }

    @Override // okio.BufferedSink
    /* renamed from: N */
    public /* bridge */ /* synthetic */ BufferedSink mo4615N(byte[] bArr) throws IOException {
        m10562k0(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: O */
    public /* bridge */ /* synthetic */ BufferedSink mo4616O(ap0 ap0Var) throws IOException {
        m10561j0(ap0Var);
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: P */
    public short mo4898P() {
        return np0.m6764d(readShort());
    }

    @Override // okio.Source
    /* renamed from: R */
    public long mo2186R(zo0 zo0Var, long j) {
        if (zo0Var == null) {
            throw new IllegalArgumentException("sink == null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j);
        }
        long j2 = this.f8573P;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        zo0Var.mo2189F(this, j);
        return j;
    }

    @Override // okio.BufferedSource
    /* renamed from: U */
    public void mo4899U(long j) throws EOFException {
        if (this.f8573P < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: V */
    public /* bridge */ /* synthetic */ BufferedSink mo4617V(long j) throws IOException {
        m10566n0(j);
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: W */
    public long mo4900W(byte b) {
        return m10546D(b, 0L, RecyclerView.FOREVER_NS);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00a3 A[EDGE_INSN: B:41:0x00a3->B:38:0x00a3 BREAK  A[LOOP:0: B:4:0x000b->B:40:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x009b  */
    @Override // okio.BufferedSource
    /* renamed from: X */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long mo4901X() {
        /*
            r14 = this;
            long r0 = r14.f8573P
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto Laa
            r0 = 0
            r1 = r0
            r4 = r2
        Lb:
            cz.opentree.jp0 r6 = r14.f8572O
            byte[] r7 = r6.f3638a
            int r8 = r6.f3639b
            int r9 = r6.f3640c
        L13:
            if (r8 >= r9) goto L8f
            r10 = r7[r8]
            r11 = 48
            if (r10 < r11) goto L22
            r11 = 57
            if (r10 > r11) goto L22
            int r11 = r10 + (-48)
            goto L3a
        L22:
            r11 = 97
            if (r10 < r11) goto L2f
            r11 = 102(0x66, float:1.43E-43)
            if (r10 > r11) goto L2f
            int r11 = r10 + (-97)
        L2c:
            int r11 = r11 + 10
            goto L3a
        L2f:
            r11 = 65
            if (r10 < r11) goto L70
            r11 = 70
            if (r10 > r11) goto L70
            int r11 = r10 + (-65)
            goto L2c
        L3a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r12 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r12 != 0) goto L4a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L13
        L4a:
            cz.opentree.zo0 r0 = new cz.opentree.zo0
            r0.<init>()
            r0.m10567o0(r4)
            r0.m10565m0(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Number too large: "
            r2.append(r3)
            java.lang.String r0 = r0.m10553c0()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L8f
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            r1.append(r2)
            java.lang.String r2 = java.lang.Integer.toHexString(r10)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L8f:
            if (r8 != r9) goto L9b
            cz.opentree.jp0 r7 = r6.m5182b()
            r14.f8572O = r7
            cz.opentree.kp0.m5987a(r6)
            goto L9d
        L9b:
            r6.f3639b = r8
        L9d:
            if (r1 != 0) goto La3
            cz.opentree.jp0 r6 = r14.f8572O
            if (r6 != 0) goto Lb
        La3:
            long r1 = r14.f8573P
            long r6 = (long) r0
            long r1 = r1 - r6
            r14.f8573P = r1
            return r4
        Laa:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "size == 0"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.opentree.zo0.mo4901X():long");
    }

    /* renamed from: Y */
    public boolean m10547Y(long j, ap0 ap0Var, int i, int i2) {
        if (j < 0 || i < 0 || i2 < 0 || this.f8573P - j < i2 || ap0Var.mo2247w() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (m10575z(i3 + j) != ap0Var.mo2241p(i + i3)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: Z */
    public byte[] m10548Z() {
        try {
            return mo4897L(this.f8573P);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: a0 */
    public ap0 m10549a0() {
        return new ap0(m10548Z());
    }

    /* renamed from: b */
    public final void m10550b() {
        try {
            skip(this.f8573P);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: b0 */
    public String m10551b0(long j, Charset charset) throws EOFException {
        np0.m6762b(this.f8573P, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j);
        }
        if (j == 0) {
            return "";
        }
        jp0 jp0Var = this.f8572O;
        if (jp0Var.f3639b + j > jp0Var.f3640c) {
            return new String(mo4897L(j), charset);
        }
        String str = new String(jp0Var.f3638a, jp0Var.f3639b, (int) j, charset);
        int i = (int) (jp0Var.f3639b + j);
        jp0Var.f3639b = i;
        this.f8573P -= j;
        if (i == jp0Var.f3640c) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        }
        return str;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public zo0 clone() {
        zo0 zo0Var = new zo0();
        if (this.f8573P == 0) {
            return zo0Var;
        }
        jp0 m5184d = this.f8572O.m5184d();
        zo0Var.f8572O = m5184d;
        m5184d.f3644g = m5184d;
        m5184d.f3643f = m5184d;
        jp0 jp0Var = this.f8572O;
        while (true) {
            jp0Var = jp0Var.f3643f;
            if (jp0Var == this.f8572O) {
                zo0Var.f8573P = this.f8573P;
                return zo0Var;
            }
            zo0Var.f8572O.f3644g.m5183c(jp0Var.m5184d());
        }
    }

    /* renamed from: c0 */
    public String m10553c0() {
        try {
            return m10551b0(this.f8573P, np0.f5329a);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d */
    public final long m10554d() {
        long j = this.f8573P;
        if (j == 0) {
            return 0L;
        }
        jp0 jp0Var = this.f8572O.f3644g;
        return (jp0Var.f3640c >= 8192 || !jp0Var.f3642e) ? j : j - (r3 - jp0Var.f3639b);
    }

    /* renamed from: d0 */
    public String m10555d0(long j) throws EOFException {
        return m10551b0(j, np0.f5329a);
    }

    @Override // okio.BufferedSource
    /* renamed from: e */
    public zo0 mo4905e() {
        return this;
    }

    /* renamed from: e0 */
    public String m10556e0(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (m10575z(j2) == 13) {
                String m10555d0 = m10555d0(j2);
                skip(2L);
                return m10555d0;
            }
        }
        String m10555d02 = m10555d0(j);
        skip(1L);
        return m10555d02;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zo0)) {
            return false;
        }
        zo0 zo0Var = (zo0) obj;
        long j = this.f8573P;
        if (j != zo0Var.f8573P) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        jp0 jp0Var = this.f8572O;
        jp0 jp0Var2 = zo0Var.f8572O;
        int i = jp0Var.f3639b;
        int i2 = jp0Var2.f3639b;
        while (j2 < this.f8573P) {
            long min = Math.min(jp0Var.f3640c - i, jp0Var2.f3640c - i2);
            int i3 = 0;
            while (i3 < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (jp0Var.f3638a[i] != jp0Var2.f3638a[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == jp0Var.f3640c) {
                jp0Var = jp0Var.f3643f;
                i = jp0Var.f3639b;
            }
            if (i2 == jp0Var2.f3640c) {
                jp0Var2 = jp0Var2.f3643f;
                i2 = jp0Var2.f3639b;
            }
            j2 += min;
        }
        return true;
    }

    /* renamed from: f0 */
    public final long m10557f0() {
        return this.f8573P;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.Source
    /* renamed from: g */
    public mp0 mo2188g() {
        return mp0.f5125d;
    }

    /* renamed from: g0 */
    public final ap0 m10558g0() {
        long j = this.f8573P;
        if (j <= 2147483647L) {
            return m10559h0((int) j);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8573P);
    }

    /* renamed from: h0 */
    public final ap0 m10559h0(int i) {
        return i == 0 ? ap0.f1502S : new lp0(this, i);
    }

    public int hashCode() {
        jp0 jp0Var = this.f8572O;
        if (jp0Var == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = jp0Var.f3640c;
            for (int i3 = jp0Var.f3639b; i3 < i2; i3++) {
                i = (i * 31) + jp0Var.f3638a[i3];
            }
            jp0Var = jp0Var.f3643f;
        } while (jp0Var != this.f8572O);
        return i;
    }

    /* renamed from: i0 */
    public jp0 m10560i0(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        jp0 jp0Var = this.f8572O;
        if (jp0Var == null) {
            jp0 m5988b = kp0.m5988b();
            this.f8572O = m5988b;
            m5988b.f3644g = m5988b;
            m5988b.f3643f = m5988b;
            return m5988b;
        }
        jp0 jp0Var2 = jp0Var.f3644g;
        if (jp0Var2.f3640c + i <= 8192 && jp0Var2.f3642e) {
            return jp0Var2;
        }
        jp0 m5988b2 = kp0.m5988b();
        jp0Var2.m5183c(m5988b2);
        return m5988b2;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* renamed from: j0 */
    public zo0 m10561j0(ap0 ap0Var) {
        if (ap0Var == null) {
            throw new IllegalArgumentException("byteString == null");
        }
        ap0Var.mo2237C(this);
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: k */
    public ap0 mo4906k(long j) throws EOFException {
        return new ap0(mo4897L(j));
    }

    /* renamed from: k0 */
    public zo0 m10562k0(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        m10564l0(bArr, 0, bArr.length);
        return this;
    }

    /* renamed from: l */
    public final zo0 m10563l(zo0 zo0Var, long j, long j2) {
        if (zo0Var == null) {
            throw new IllegalArgumentException("out == null");
        }
        np0.m6762b(this.f8573P, j, j2);
        if (j2 == 0) {
            return this;
        }
        zo0Var.f8573P += j2;
        jp0 jp0Var = this.f8572O;
        while (true) {
            int i = jp0Var.f3640c;
            int i2 = jp0Var.f3639b;
            if (j < i - i2) {
                break;
            }
            j -= i - i2;
            jp0Var = jp0Var.f3643f;
        }
        while (j2 > 0) {
            jp0 m5184d = jp0Var.m5184d();
            int i3 = (int) (m5184d.f3639b + j);
            m5184d.f3639b = i3;
            m5184d.f3640c = Math.min(i3 + ((int) j2), m5184d.f3640c);
            jp0 jp0Var2 = zo0Var.f8572O;
            if (jp0Var2 == null) {
                m5184d.f3644g = m5184d;
                m5184d.f3643f = m5184d;
                zo0Var.f8572O = m5184d;
            } else {
                jp0Var2.f3644g.m5183c(m5184d);
            }
            j2 -= m5184d.f3640c - m5184d.f3639b;
            jp0Var = jp0Var.f3643f;
            j = 0;
        }
        return this;
    }

    /* renamed from: l0 */
    public zo0 m10564l0(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        np0.m6762b(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            jp0 m10560i0 = m10560i0(1);
            int min = Math.min(i3 - i, 8192 - m10560i0.f3640c);
            System.arraycopy(bArr, i, m10560i0.f3638a, m10560i0.f3640c, min);
            i += min;
            m10560i0.f3640c += min;
        }
        this.f8573P += j;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: m */
    public /* bridge */ /* synthetic */ BufferedSink mo4619m(int i) throws IOException {
        m10569q0(i);
        return this;
    }

    /* renamed from: m0 */
    public zo0 m10565m0(int i) {
        jp0 m10560i0 = m10560i0(1);
        byte[] bArr = m10560i0.f3638a;
        int i2 = m10560i0.f3640c;
        m10560i0.f3640c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f8573P++;
        return this;
    }

    /* renamed from: n0 */
    public zo0 m10566n0(long j) {
        if (j == 0) {
            m10565m0(48);
            return this;
        }
        boolean z = false;
        int i = 1;
        if (j < 0) {
            j = -j;
            if (j < 0) {
                m10571s0("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i = 2;
        }
        if (z) {
            i++;
        }
        jp0 m10560i0 = m10560i0(i);
        byte[] bArr = m10560i0.f3638a;
        int i2 = m10560i0.f3640c + i;
        while (j != 0) {
            i2--;
            bArr[i2] = f8571Q[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i2 - 1] = 45;
        }
        m10560i0.f3640c += i;
        this.f8573P += i;
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: o */
    public /* bridge */ /* synthetic */ BufferedSink mo4620o(int i) throws IOException {
        m10568p0(i);
        return this;
    }

    /* renamed from: o0 */
    public zo0 m10567o0(long j) {
        if (j == 0) {
            m10565m0(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        jp0 m10560i0 = m10560i0(numberOfTrailingZeros);
        byte[] bArr = m10560i0.f3638a;
        int i = m10560i0.f3640c;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = f8571Q[(int) (15 & j)];
            j >>>= 4;
        }
        m10560i0.f3640c += numberOfTrailingZeros;
        this.f8573P += numberOfTrailingZeros;
        return this;
    }

    /* renamed from: p0 */
    public zo0 m10568p0(int i) {
        jp0 m10560i0 = m10560i0(4);
        byte[] bArr = m10560i0.f3638a;
        int i2 = m10560i0.f3640c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        m10560i0.f3640c = i5 + 1;
        this.f8573P += 4;
        return this;
    }

    /* renamed from: q0 */
    public zo0 m10569q0(int i) {
        jp0 m10560i0 = m10560i0(2);
        byte[] bArr = m10560i0.f3638a;
        int i2 = m10560i0.f3640c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        m10560i0.f3640c = i3 + 1;
        this.f8573P += 2;
        return this;
    }

    /* renamed from: r0 */
    public zo0 m10570r0(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(np0.f5329a)) {
            m10572t0(str, i, i2);
            return this;
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        m10564l0(bytes, 0, bytes.length);
        return this;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        jp0 jp0Var = this.f8572O;
        if (jp0Var == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), jp0Var.f3640c - jp0Var.f3639b);
        byteBuffer.put(jp0Var.f3638a, jp0Var.f3639b, min);
        int i = jp0Var.f3639b + min;
        jp0Var.f3639b = i;
        this.f8573P -= min;
        if (i == jp0Var.f3640c) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        }
        return min;
    }

    public int read(byte[] bArr, int i, int i2) {
        np0.m6762b(bArr.length, i, i2);
        jp0 jp0Var = this.f8572O;
        if (jp0Var == null) {
            return -1;
        }
        int min = Math.min(i2, jp0Var.f3640c - jp0Var.f3639b);
        System.arraycopy(jp0Var.f3638a, jp0Var.f3639b, bArr, i, min);
        int i3 = jp0Var.f3639b + min;
        jp0Var.f3639b = i3;
        this.f8573P -= min;
        if (i3 == jp0Var.f3640c) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.f8573P;
        if (j == 0) {
            throw new IllegalStateException("size == 0");
        }
        jp0 jp0Var = this.f8572O;
        int i = jp0Var.f3639b;
        int i2 = jp0Var.f3640c;
        int i3 = i + 1;
        byte b = jp0Var.f3638a[i];
        this.f8573P = j - 1;
        if (i3 == i2) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        } else {
            jp0Var.f3639b = i3;
        }
        return b;
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read == -1) {
                throw new EOFException();
            }
            i += read;
        }
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.f8573P;
        if (j < 4) {
            throw new IllegalStateException("size < 4: " + this.f8573P);
        }
        jp0 jp0Var = this.f8572O;
        int i = jp0Var.f3639b;
        int i2 = jp0Var.f3640c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = jp0Var.f3638a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f8573P = j - 4;
        if (i8 == i2) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        } else {
            jp0Var.f3639b = i8;
        }
        return i9;
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.f8573P;
        if (j < 2) {
            throw new IllegalStateException("size < 2: " + this.f8573P);
        }
        jp0 jp0Var = this.f8572O;
        int i = jp0Var.f3639b;
        int i2 = jp0Var.f3640c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = jp0Var.f3638a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f8573P = j - 2;
        if (i4 == i2) {
            this.f8572O = jp0Var.m5182b();
            kp0.m5987a(jp0Var);
        } else {
            jp0Var.f3639b = i4;
        }
        return (short) i5;
    }

    @Override // okio.BufferedSource
    /* renamed from: s */
    public boolean mo4907s() {
        return this.f8573P == 0;
    }

    /* renamed from: s0 */
    public zo0 m10571s0(String str) {
        m10572t0(str, 0, str.length());
        return this;
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            if (this.f8572O == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j, r0.f3640c - r0.f3639b);
            long j2 = min;
            this.f8573P -= j2;
            j -= j2;
            jp0 jp0Var = this.f8572O;
            int i = jp0Var.f3639b + min;
            jp0Var.f3639b = i;
            if (i == jp0Var.f3640c) {
                this.f8572O = jp0Var.m5182b();
                kp0.m5987a(jp0Var);
            }
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: t */
    public /* bridge */ /* synthetic */ BufferedSink mo4621t(int i) throws IOException {
        m10565m0(i);
        return this;
    }

    /* renamed from: t0 */
    public zo0 m10572t0(String str, int i, int i2) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char charAt = str.charAt(i);
            if (charAt < 128) {
                jp0 m10560i0 = m10560i0(1);
                byte[] bArr = m10560i0.f3638a;
                int i3 = m10560i0.f3640c - i;
                int min = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) charAt;
                while (i4 < min) {
                    char charAt2 = str.charAt(i4);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i4 + i3] = (byte) charAt2;
                    i4++;
                }
                int i5 = m10560i0.f3640c;
                int i6 = (i3 + i4) - i5;
                m10560i0.f3640c = i5 + i6;
                this.f8573P += i6;
                i = i4;
            } else {
                if (charAt < 2048) {
                    m10565m0((charAt >> 6) | 192);
                    m10565m0((charAt & '?') | 128);
                } else if (charAt < 55296 || charAt > 57343) {
                    m10565m0((charAt >> '\f') | 224);
                    m10565m0(((charAt >> 6) & 63) | 128);
                    m10565m0((charAt & '?') | 128);
                } else {
                    int i7 = i + 1;
                    char charAt3 = i7 < i2 ? str.charAt(i7) : (char) 0;
                    if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                        m10565m0(63);
                        i = i7;
                    } else {
                        int i8 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                        m10565m0((i8 >> 18) | 240);
                        m10565m0(((i8 >> 12) & 63) | 128);
                        m10565m0(((i8 >> 6) & 63) | 128);
                        m10565m0((i8 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public String toString() {
        return m10558g0().toString();
    }

    /* renamed from: u0 */
    public zo0 m10573u0(int i) {
        if (i < 128) {
            m10565m0(i);
        } else if (i < 2048) {
            m10565m0((i >> 6) | 192);
            m10565m0((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                m10565m0((i >> 12) | 224);
                m10565m0(((i >> 6) & 63) | 128);
                m10565m0((i & 63) | 128);
            } else {
                m10565m0(63);
            }
        } else {
            if (i > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
            }
            m10565m0((i >> 18) | 240);
            m10565m0(((i >> 12) & 63) | 128);
            m10565m0(((i >> 6) & 63) | 128);
            m10565m0((i & 63) | 128);
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: v */
    public /* bridge */ /* synthetic */ BufferedSink mo4622v() throws IOException {
        m10574y();
        return this;
    }

    @Override // okio.BufferedSource
    /* renamed from: w */
    public String mo4908w(long j) throws EOFException {
        if (j < 0) {
            throw new IllegalArgumentException("limit < 0: " + j);
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        long m10546D = m10546D((byte) 10, 0L, j2);
        if (m10546D != -1) {
            return m10556e0(m10546D);
        }
        if (j2 < m10557f0() && m10575z(j2 - 1) == 13 && m10575z(j2) == 10) {
            return m10556e0(j2);
        }
        zo0 zo0Var = new zo0();
        m10563l(zo0Var, 0L, Math.min(32L, m10557f0()));
        throw new EOFException("\\n not found: limit=" + Math.min(m10557f0(), j) + " content=" + zo0Var.m10549a0().mo2242q() + (char) 8230);
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int remaining = byteBuffer.remaining();
        int i = remaining;
        while (i > 0) {
            jp0 m10560i0 = m10560i0(1);
            int min = Math.min(i, 8192 - m10560i0.f3640c);
            byteBuffer.get(m10560i0.f3638a, m10560i0.f3640c, min);
            i -= min;
            m10560i0.f3640c += min;
        }
        this.f8573P += remaining;
        return remaining;
    }

    /* renamed from: y */
    public zo0 m10574y() {
        return this;
    }

    /* renamed from: z */
    public final byte m10575z(long j) {
        int i;
        np0.m6762b(this.f8573P, j, 1L);
        long j2 = this.f8573P;
        if (j2 - j <= j) {
            long j3 = j - j2;
            jp0 jp0Var = this.f8572O;
            do {
                jp0Var = jp0Var.f3644g;
                int i2 = jp0Var.f3640c;
                i = jp0Var.f3639b;
                j3 += i2 - i;
            } while (j3 < 0);
            return jp0Var.f3638a[i + ((int) j3)];
        }
        jp0 jp0Var2 = this.f8572O;
        while (true) {
            int i3 = jp0Var2.f3640c;
            int i4 = jp0Var2.f3639b;
            long j4 = i3 - i4;
            if (j < j4) {
                return jp0Var2.f3638a[i4 + ((int) j)];
            }
            j -= j4;
            jp0Var2 = jp0Var2.f3643f;
        }
    }
}
