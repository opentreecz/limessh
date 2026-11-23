package com.sonelli;

import jackpal.androidterm.emulatorview.compat.KeycodeConstants;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public final class pb0 implements Flushable {

    /* renamed from: O */
    public final byte[] f5645O;

    /* renamed from: P */
    public final int f5646P;

    /* renamed from: Q */
    public int f5647Q = 0;

    /* renamed from: R */
    public final OutputStream f5648R;

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.sonelli.pb0$a */
    /* loaded from: classes.dex */
    public static class C1697a extends IOException {
        public C1697a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public pb0(OutputStream outputStream, byte[] bArr) {
        this.f5648R = outputStream;
        this.f5645O = bArr;
        this.f5646P = bArr.length;
    }

    /* renamed from: B */
    public static pb0 m7257B(OutputStream outputStream, int i) {
        return new pb0(outputStream, new byte[i]);
    }

    /* renamed from: a */
    public static int m7258a(int i, boolean z) {
        return m7271r(i) + m7259b(z);
    }

    /* renamed from: b */
    public static int m7259b(boolean z) {
        return 1;
    }

    /* renamed from: c */
    public static int m7260c(int i, nb0 nb0Var) {
        return m7271r(i) + m7261d(nb0Var);
    }

    /* renamed from: d */
    public static int m7261d(nb0 nb0Var) {
        return m7267l(nb0Var.m6662f()) + nb0Var.m6662f();
    }

    /* renamed from: f */
    public static int m7262f(int i, int i2) {
        return m7271r(i) + m7263h(i2);
    }

    /* renamed from: h */
    public static int m7263h(int i) {
        return m7266k(i);
    }

    /* renamed from: i */
    public static int m7264i(int i, float f) {
        return m7271r(i) + m7265j(f);
    }

    /* renamed from: j */
    public static int m7265j(float f) {
        return 4;
    }

    /* renamed from: k */
    public static int m7266k(int i) {
        if (i >= 0) {
            return m7267l(i);
        }
        return 10;
    }

    /* renamed from: l */
    public static int m7267l(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: n */
    public static int m7268n(long j) {
        if (((-128) & j) == 0) {
            return 1;
        }
        if (((-16384) & j) == 0) {
            return 2;
        }
        if (((-2097152) & j) == 0) {
            return 3;
        }
        if (((-268435456) & j) == 0) {
            return 4;
        }
        if (((-34359738368L) & j) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    /* renamed from: p */
    public static int m7269p(int i, int i2) {
        return m7271r(i) + m7270q(i2);
    }

    /* renamed from: q */
    public static int m7270q(int i) {
        return m7267l(m7276y(i));
    }

    /* renamed from: r */
    public static int m7271r(int i) {
        return m7267l(rb0.m7902a(i, 0));
    }

    /* renamed from: s */
    public static int m7272s(int i, int i2) {
        return m7271r(i) + m7273u(i2);
    }

    /* renamed from: u */
    public static int m7273u(int i) {
        return m7267l(i);
    }

    /* renamed from: w */
    public static int m7274w(int i, long j) {
        return m7271r(i) + m7275x(j);
    }

    /* renamed from: x */
    public static int m7275x(long j) {
        return m7268n(j);
    }

    /* renamed from: y */
    public static int m7276y(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* renamed from: z */
    public static pb0 m7277z(OutputStream outputStream) {
        return m7257B(outputStream, 4096);
    }

    /* renamed from: C */
    public final void m7278C() throws IOException {
        OutputStream outputStream = this.f5648R;
        if (outputStream == null) {
            throw new C1697a();
        }
        outputStream.write(this.f5645O, 0, this.f5647Q);
        this.f5647Q = 0;
    }

    /* renamed from: D */
    public void m7279D(int i, boolean z) throws IOException {
        m7299e0(i, 0);
        m7280I(z);
    }

    /* renamed from: I */
    public void m7280I(boolean z) throws IOException {
        m7289T(z ? 1 : 0);
    }

    /* renamed from: J */
    public void m7281J(int i, nb0 nb0Var) throws IOException {
        m7299e0(i, 2);
        m7282K(nb0Var);
    }

    /* renamed from: K */
    public void m7282K(nb0 nb0Var) throws IOException {
        m7295a0(nb0Var.m6662f());
        m7290U(nb0Var);
    }

    /* renamed from: L */
    public void m7283L(int i, int i2) throws IOException {
        m7299e0(i, 0);
        m7284M(i2);
    }

    /* renamed from: M */
    public void m7284M(int i) throws IOException {
        m7287R(i);
    }

    /* renamed from: P */
    public void m7285P(int i, float f) throws IOException {
        m7299e0(i, 5);
        m7286Q(f);
    }

    /* renamed from: Q */
    public void m7286Q(float f) throws IOException {
        m7294Z(Float.floatToRawIntBits(f));
    }

    /* renamed from: R */
    public void m7287R(int i) throws IOException {
        if (i >= 0) {
            m7295a0(i);
        } else {
            m7296b0(i);
        }
    }

    /* renamed from: S */
    public void m7288S(byte b) throws IOException {
        if (this.f5647Q == this.f5646P) {
            m7278C();
        }
        byte[] bArr = this.f5645O;
        int i = this.f5647Q;
        this.f5647Q = i + 1;
        bArr[i] = b;
    }

    /* renamed from: T */
    public void m7289T(int i) throws IOException {
        m7288S((byte) i);
    }

    /* renamed from: U */
    public void m7290U(nb0 nb0Var) throws IOException {
        m7291W(nb0Var, 0, nb0Var.m6662f());
    }

    /* renamed from: W */
    public void m7291W(nb0 nb0Var, int i, int i2) throws IOException {
        int i3 = this.f5646P;
        int i4 = this.f5647Q;
        if (i3 - i4 >= i2) {
            nb0Var.m6660d(this.f5645O, i, i4, i2);
            this.f5647Q += i2;
            return;
        }
        int i5 = i3 - i4;
        nb0Var.m6660d(this.f5645O, i, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f5647Q = this.f5646P;
        m7278C();
        if (i7 <= this.f5646P) {
            nb0Var.m6660d(this.f5645O, i6, 0, i7);
            this.f5647Q = i7;
            return;
        }
        InputStream m6661e = nb0Var.m6661e();
        long j = i6;
        if (j != m6661e.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i7 > 0) {
            int min = Math.min(i7, this.f5646P);
            int read = m6661e.read(this.f5645O, 0, min);
            if (read != min) {
                throw new IllegalStateException("Read failed.");
            }
            this.f5648R.write(this.f5645O, 0, read);
            i7 -= read;
        }
    }

    /* renamed from: X */
    public void m7292X(byte[] bArr) throws IOException {
        m7293Y(bArr, 0, bArr.length);
    }

    /* renamed from: Y */
    public void m7293Y(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f5646P;
        int i4 = this.f5647Q;
        if (i3 - i4 >= i2) {
            System.arraycopy(bArr, i, this.f5645O, i4, i2);
            this.f5647Q += i2;
            return;
        }
        int i5 = i3 - i4;
        System.arraycopy(bArr, i, this.f5645O, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f5647Q = this.f5646P;
        m7278C();
        if (i7 > this.f5646P) {
            this.f5648R.write(bArr, i6, i7);
        } else {
            System.arraycopy(bArr, i6, this.f5645O, 0, i7);
            this.f5647Q = i7;
        }
    }

    /* renamed from: Z */
    public void m7294Z(int i) throws IOException {
        m7289T(i & 255);
        m7289T((i >> 8) & 255);
        m7289T((i >> 16) & 255);
        m7289T((i >> 24) & 255);
    }

    /* renamed from: a0 */
    public void m7295a0(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m7289T((i & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
            i >>>= 7;
        }
        m7289T(i);
    }

    /* renamed from: b0 */
    public void m7296b0(long j) throws IOException {
        while (((-128) & j) != 0) {
            m7289T((((int) j) & KeycodeConstants.KEYCODE_MEDIA_PAUSE) | 128);
            j >>>= 7;
        }
        m7289T((int) j);
    }

    /* renamed from: c0 */
    public void m7297c0(int i, int i2) throws IOException {
        m7299e0(i, 0);
        m7298d0(i2);
    }

    /* renamed from: d0 */
    public void m7298d0(int i) throws IOException {
        m7295a0(m7276y(i));
    }

    /* renamed from: e0 */
    public void m7299e0(int i, int i2) throws IOException {
        m7295a0(rb0.m7902a(i, i2));
    }

    /* renamed from: f0 */
    public void m7300f0(int i, int i2) throws IOException {
        m7299e0(i, 0);
        m7301g0(i2);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f5648R != null) {
            m7278C();
        }
    }

    /* renamed from: g0 */
    public void m7301g0(int i) throws IOException {
        m7295a0(i);
    }

    /* renamed from: h0 */
    public void m7302h0(int i, long j) throws IOException {
        m7299e0(i, 0);
        m7303i0(j);
    }

    /* renamed from: i0 */
    public void m7303i0(long j) throws IOException {
        m7296b0(j);
    }
}
