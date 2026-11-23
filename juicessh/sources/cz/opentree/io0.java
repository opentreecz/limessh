package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import cz.opentree.do0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.http2.Header;
import okio.BufferedSink;

/* compiled from: Http2Writer.java */
/* loaded from: classes.dex */
public final class io0 implements Closeable {

    /* renamed from: U */
    public static final Logger f3380U = Logger.getLogger(eo0.class.getName());

    /* renamed from: O */
    public final BufferedSink f3381O;

    /* renamed from: P */
    public final boolean f3382P;

    /* renamed from: Q */
    public final zo0 f3383Q;

    /* renamed from: R */
    public int f3384R;

    /* renamed from: S */
    public boolean f3385S;

    /* renamed from: T */
    public final do0.C0893b f3386T;

    public io0(BufferedSink bufferedSink, boolean z) {
        this.f3381O = bufferedSink;
        this.f3382P = z;
        zo0 zo0Var = new zo0();
        this.f3383Q = zo0Var;
        this.f3386T = new do0.C0893b(zo0Var);
        this.f3384R = 16384;
    }

    /* renamed from: Z */
    public static void m4821Z(BufferedSink bufferedSink, int i) throws IOException {
        bufferedSink.mo4621t((i >>> 16) & 255);
        bufferedSink.mo4621t((i >>> 8) & 255);
        bufferedSink.mo4621t(i & 255);
    }

    /* renamed from: D */
    public synchronized void m4822D(boolean z, int i, int i2, List<Header> list) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        m4831l(z, i, list);
    }

    /* renamed from: K */
    public synchronized void m4823K(int i, long j) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            eo0.m3537c("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
            throw null;
        }
        m4829f(i, 4, (byte) 8, (byte) 0);
        this.f3381O.mo4620o((int) j);
        this.f3381O.flush();
    }

    /* renamed from: Y */
    public final void m4824Y(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min(this.f3384R, j);
            long j2 = min;
            j -= j2;
            m4829f(i, min, (byte) 9, j == 0 ? (byte) 4 : (byte) 0);
            this.f3381O.mo2189F(this.f3383Q, j2);
        }
    }

    /* renamed from: a */
    public synchronized void m4825a(ko0 ko0Var) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        this.f3384R = ko0Var.m5966f(this.f3384R);
        if (ko0Var.m5963c() != -1) {
            this.f3386T.m3300e(ko0Var.m5963c());
        }
        m4829f(0, 0, (byte) 4, (byte) 1);
        this.f3381O.flush();
    }

    /* renamed from: b */
    public synchronized void m4826b() throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        if (this.f3382P) {
            Logger logger = f3380U;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(fn0.m3837r(">> CONNECTION %s", eo0.f2515a.mo2242q()));
            }
            this.f3381O.mo4615N(eo0.f2515a.mo2235A());
            this.f3381O.flush();
        }
    }

    /* renamed from: c */
    public synchronized void m4827c(boolean z, int i, zo0 zo0Var, int i2) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        m4828d(i, z ? (byte) 1 : (byte) 0, zo0Var, i2);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f3385S = true;
        this.f3381O.close();
    }

    /* renamed from: d */
    public void m4828d(int i, byte b, zo0 zo0Var, int i2) throws IOException {
        m4829f(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f3381O.mo2189F(zo0Var, i2);
        }
    }

    /* renamed from: f */
    public void m4829f(int i, int i2, byte b, byte b2) throws IOException {
        Logger logger = f3380U;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(eo0.m3536b(false, i, i2, b, b2));
        }
        int i3 = this.f3384R;
        if (i2 > i3) {
            eo0.m3537c("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i3), Integer.valueOf(i2));
            throw null;
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            eo0.m3537c("reserved bit set: %s", Integer.valueOf(i));
            throw null;
        }
        m4821Z(this.f3381O, i2);
        this.f3381O.mo4621t(b & 255);
        this.f3381O.mo4621t(b2 & 255);
        this.f3381O.mo4620o(i & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public synchronized void flush() throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        this.f3381O.flush();
    }

    /* renamed from: h */
    public synchronized void m4830h(int i, co0 co0Var, byte[] bArr) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        if (co0Var.f2021O == -1) {
            eo0.m3537c("errorCode.httpCode == -1", new Object[0]);
            throw null;
        }
        m4829f(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f3381O.mo4620o(i);
        this.f3381O.mo4620o(co0Var.f2021O);
        if (bArr.length > 0) {
            this.f3381O.mo4615N(bArr);
        }
        this.f3381O.flush();
    }

    /* renamed from: l */
    public void m4831l(boolean z, int i, List<Header> list) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        this.f3386T.m3302g(list);
        long m10557f0 = this.f3383Q.m10557f0();
        int min = (int) Math.min(this.f3384R, m10557f0);
        long j = min;
        byte b = m10557f0 == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m4829f(i, min, (byte) 1, b);
        this.f3381O.mo2189F(this.f3383Q, j);
        if (m10557f0 > j) {
            m4824Y(i, m10557f0 - j);
        }
    }

    /* renamed from: n */
    public int m4832n() {
        return this.f3384R;
    }

    /* renamed from: p */
    public synchronized void m4833p(boolean z, int i, int i2) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        m4829f(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f3381O.mo4620o(i);
        this.f3381O.mo4620o(i2);
        this.f3381O.flush();
    }

    /* renamed from: x */
    public synchronized void m4834x(int i, int i2, List<Header> list) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        this.f3386T.m3302g(list);
        long m10557f0 = this.f3383Q.m10557f0();
        int min = (int) Math.min(this.f3384R - 4, m10557f0);
        long j = min;
        m4829f(i, min + 4, (byte) 5, m10557f0 == j ? (byte) 4 : (byte) 0);
        this.f3381O.mo4620o(i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.f3381O.mo2189F(this.f3383Q, j);
        if (m10557f0 > j) {
            m4824Y(i, m10557f0 - j);
        }
    }

    /* renamed from: y */
    public synchronized void m4835y(int i, co0 co0Var) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        if (co0Var.f2021O == -1) {
            throw new IllegalArgumentException();
        }
        m4829f(i, 4, (byte) 3, (byte) 0);
        this.f3381O.mo4620o(co0Var.f2021O);
        this.f3381O.flush();
    }

    /* renamed from: z */
    public synchronized void m4836z(ko0 ko0Var) throws IOException {
        if (this.f3385S) {
            throw new IOException("closed");
        }
        int i = 0;
        m4829f(0, ko0Var.m5970j() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (ko0Var.m5967g(i)) {
                this.f3381O.mo4619m(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f3381O.mo4620o(ko0Var.m5962b(i));
            }
            i++;
        }
        this.f3381O.flush();
    }
}
