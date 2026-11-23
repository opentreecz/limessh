package okhttp3.internal.http2;

import androidx.appcompat.widget.ActivityChooserView;
import cz.opentree.ap0;
import cz.opentree.co0;
import cz.opentree.do0;
import cz.opentree.eo0;
import cz.opentree.fn0;
import cz.opentree.ko0;
import cz.opentree.mp0;
import cz.opentree.zo0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.BufferedSource;
import okio.Source;

/* loaded from: classes.dex */
public final class Http2Reader implements Closeable {

    /* renamed from: S */
    public static final Logger f8665S = Logger.getLogger(eo0.class.getName());

    /* renamed from: O */
    public final BufferedSource f8666O;

    /* renamed from: P */
    public final C2486a f8667P;

    /* renamed from: Q */
    public final boolean f8668Q;

    /* renamed from: R */
    public final do0.C0892a f8669R;

    /* loaded from: classes.dex */
    public interface Handler {
        /* renamed from: a */
        void mo4214a();

        /* renamed from: b */
        void mo4215b(boolean z, ko0 ko0Var);

        /* renamed from: c */
        void mo4216c(boolean z, int i, int i2, List<Header> list);

        /* renamed from: d */
        void mo4217d(int i, long j);

        /* renamed from: e */
        void mo4218e(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException;

        /* renamed from: f */
        void mo4219f(boolean z, int i, int i2);

        /* renamed from: g */
        void mo4220g(int i, int i2, int i3, boolean z);

        /* renamed from: h */
        void mo4221h(int i, co0 co0Var);

        /* renamed from: i */
        void mo4222i(int i, int i2, List<Header> list) throws IOException;

        /* renamed from: j */
        void mo4223j(int i, co0 co0Var, ap0 ap0Var);
    }

    /* renamed from: okhttp3.internal.http2.Http2Reader$a */
    /* loaded from: classes.dex */
    public static final class C2486a implements Source {

        /* renamed from: O */
        public final BufferedSource f8670O;

        /* renamed from: P */
        public int f8671P;

        /* renamed from: Q */
        public byte f8672Q;

        /* renamed from: R */
        public int f8673R;

        /* renamed from: S */
        public int f8674S;

        /* renamed from: T */
        public short f8675T;

        public C2486a(BufferedSource bufferedSource) {
            this.f8670O = bufferedSource;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            while (true) {
                int i = this.f8674S;
                if (i != 0) {
                    long mo2186R = this.f8670O.mo2186R(zo0Var, Math.min(j, i));
                    if (mo2186R == -1) {
                        return -1L;
                    }
                    this.f8674S = (int) (this.f8674S - mo2186R);
                    return mo2186R;
                }
                this.f8670O.skip(this.f8675T);
                this.f8675T = (short) 0;
                if ((this.f8672Q & 4) != 0) {
                    return -1L;
                }
                m10745a();
            }
        }

        /* renamed from: a */
        public final void m10745a() throws IOException {
            int i = this.f8673R;
            int m10731n = Http2Reader.m10731n(this.f8670O);
            this.f8674S = m10731n;
            this.f8671P = m10731n;
            byte readByte = (byte) (this.f8670O.readByte() & 255);
            this.f8672Q = (byte) (this.f8670O.readByte() & 255);
            Logger logger = Http2Reader.f8665S;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(eo0.m3536b(true, this.f8673R, this.f8671P, readByte, this.f8672Q));
            }
            int readInt = this.f8670O.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            this.f8673R = readInt;
            if (readByte != 9) {
                eo0.m3538d("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
                throw null;
            }
            if (readInt == i) {
                return;
            }
            eo0.m3538d("TYPE_CONTINUATION streamId changed", new Object[0]);
            throw null;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return this.f8670O.mo2188g();
        }
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.f8666O = bufferedSource;
        this.f8668Q = z;
        C2486a c2486a = new C2486a(bufferedSource);
        this.f8667P = c2486a;
        this.f8669R = new do0.C0892a(4096, c2486a);
    }

    /* renamed from: a */
    public static int m10730a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        eo0.m3538d("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        throw null;
    }

    /* renamed from: n */
    public static int m10731n(BufferedSource bufferedSource) throws IOException {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: D */
    public final void m10732D(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            eo0.m3538d("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
            throw null;
        }
        if (i2 == 0) {
            eo0.m3538d("TYPE_RST_STREAM streamId == 0", new Object[0]);
            throw null;
        }
        int readInt = this.f8666O.readInt();
        co0 m2895f = co0.m2895f(readInt);
        if (m2895f != null) {
            handler.mo4221h(i2, m2895f);
        } else {
            eo0.m3538d("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            throw null;
        }
    }

    /* renamed from: K */
    public final void m10733K(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            eo0.m3538d("TYPE_SETTINGS streamId != 0", new Object[0]);
            throw null;
        }
        if ((b & 1) != 0) {
            if (i == 0) {
                handler.mo4214a();
                return;
            } else {
                eo0.m3538d("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                throw null;
            }
        }
        if (i % 6 != 0) {
            eo0.m3538d("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
            throw null;
        }
        ko0 ko0Var = new ko0();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int readShort = this.f8666O.readShort() & 65535;
            int readInt = this.f8666O.readInt();
            if (readShort != 2) {
                if (readShort == 3) {
                    readShort = 4;
                } else if (readShort == 4) {
                    readShort = 7;
                    if (readInt < 0) {
                        eo0.m3538d("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        throw null;
                    }
                } else if (readShort == 5 && (readInt < 16384 || readInt > 16777215)) {
                    eo0.m3538d("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                    throw null;
                }
            } else if (readInt != 0 && readInt != 1) {
                eo0.m3538d("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                throw null;
            }
            ko0Var.m5969i(readShort, readInt);
        }
        handler.mo4215b(false, ko0Var);
    }

    /* renamed from: Y */
    public final void m10734Y(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            eo0.m3538d("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
            throw null;
        }
        long readInt = this.f8666O.readInt() & 2147483647L;
        if (readInt != 0) {
            handler.mo4217d(i2, readInt);
        } else {
            eo0.m3538d("windowSizeIncrement was 0", Long.valueOf(readInt));
            throw null;
        }
    }

    /* renamed from: b */
    public boolean m10735b(boolean z, Handler handler) throws IOException {
        try {
            this.f8666O.mo4899U(9L);
            int m10731n = m10731n(this.f8666O);
            if (m10731n < 0 || m10731n > 16384) {
                eo0.m3538d("FRAME_SIZE_ERROR: %s", Integer.valueOf(m10731n));
                throw null;
            }
            byte readByte = (byte) (this.f8666O.readByte() & 255);
            if (z && readByte != 4) {
                eo0.m3538d("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
                throw null;
            }
            byte readByte2 = (byte) (this.f8666O.readByte() & 255);
            int readInt = this.f8666O.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            Logger logger = f8665S;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(eo0.m3536b(true, readInt, m10731n, readByte, readByte2));
            }
            switch (readByte) {
                case 0:
                    m10737d(handler, m10731n, readByte2, readInt);
                    return true;
                case 1:
                    m10740l(handler, m10731n, readByte2, readInt);
                    return true;
                case 2:
                    m10743y(handler, m10731n, readByte2, readInt);
                    return true;
                case 3:
                    m10732D(handler, m10731n, readByte2, readInt);
                    return true;
                case 4:
                    m10733K(handler, m10731n, readByte2, readInt);
                    return true;
                case 5:
                    m10744z(handler, m10731n, readByte2, readInt);
                    return true;
                case 6:
                    m10741p(handler, m10731n, readByte2, readInt);
                    return true;
                case 7:
                    m10738f(handler, m10731n, readByte2, readInt);
                    return true;
                case 8:
                    m10734Y(handler, m10731n, readByte2, readInt);
                    return true;
                default:
                    this.f8666O.skip(m10731n);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public void m10736c(Handler handler) throws IOException {
        if (this.f8668Q) {
            if (m10735b(true, handler)) {
                return;
            }
            eo0.m3538d("Required SETTINGS preface not received", new Object[0]);
            throw null;
        }
        BufferedSource bufferedSource = this.f8666O;
        ap0 ap0Var = eo0.f2515a;
        ap0 mo4906k = bufferedSource.mo4906k(ap0Var.mo2247w());
        Logger logger = f8665S;
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(fn0.m3837r("<< CONNECTION %s", mo4906k.mo2242q()));
        }
        if (ap0Var.equals(mo4906k)) {
            return;
        }
        eo0.m3538d("Expected a connection header but was %s", mo4906k.mo2236B());
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f8666O.close();
    }

    /* renamed from: d */
    public final void m10737d(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            eo0.m3538d("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            eo0.m3538d("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            throw null;
        }
        short readByte = (b & 8) != 0 ? (short) (this.f8666O.readByte() & 255) : (short) 0;
        handler.mo4218e(z, i2, this.f8666O, m10730a(i, b, readByte));
        this.f8666O.skip(readByte);
    }

    /* renamed from: f */
    public final void m10738f(Handler handler, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            eo0.m3538d("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            eo0.m3538d("TYPE_GOAWAY streamId != 0", new Object[0]);
            throw null;
        }
        int readInt = this.f8666O.readInt();
        int readInt2 = this.f8666O.readInt();
        int i3 = i - 8;
        co0 m2895f = co0.m2895f(readInt2);
        if (m2895f == null) {
            eo0.m3538d("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            throw null;
        }
        ap0 ap0Var = ap0.f1502S;
        if (i3 > 0) {
            ap0Var = this.f8666O.mo4906k(i3);
        }
        handler.mo4223j(readInt, m2895f, ap0Var);
    }

    /* renamed from: h */
    public final List<Header> m10739h(int i, short s, byte b, int i2) throws IOException {
        C2486a c2486a = this.f8667P;
        c2486a.f8674S = i;
        c2486a.f8671P = i;
        c2486a.f8675T = s;
        c2486a.f8672Q = b;
        c2486a.f8673R = i2;
        this.f8669R.m3289k();
        return this.f8669R.m3283e();
    }

    /* renamed from: l */
    public final void m10740l(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            eo0.m3538d("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            throw null;
        }
        boolean z = (b & 1) != 0;
        short readByte = (b & 8) != 0 ? (short) (this.f8666O.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            m10742x(handler, i2);
            i -= 5;
        }
        handler.mo4216c(z, i2, -1, m10739h(m10730a(i, b, readByte), readByte, b, i2));
    }

    /* renamed from: p */
    public final void m10741p(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            eo0.m3538d("TYPE_PING length != 8: %s", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            eo0.m3538d("TYPE_PING streamId != 0", new Object[0]);
            throw null;
        }
        handler.mo4219f((b & 1) != 0, this.f8666O.readInt(), this.f8666O.readInt());
    }

    /* renamed from: x */
    public final void m10742x(Handler handler, int i) throws IOException {
        int readInt = this.f8666O.readInt();
        handler.mo4220g(i, readInt & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (this.f8666O.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    /* renamed from: y */
    public final void m10743y(Handler handler, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            eo0.m3538d("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
            throw null;
        }
        if (i2 != 0) {
            m10742x(handler, i2);
        } else {
            eo0.m3538d("TYPE_PRIORITY streamId == 0", new Object[0]);
            throw null;
        }
    }

    /* renamed from: z */
    public final void m10744z(Handler handler, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            eo0.m3538d("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            throw null;
        }
        short readByte = (b & 8) != 0 ? (short) (this.f8666O.readByte() & 255) : (short) 0;
        handler.mo4222i(i2, this.f8666O.readInt() & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, m10739h(m10730a(i - 4, b, readByte), readByte, b, i2));
    }
}
