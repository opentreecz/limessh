package cz.opentree;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;

/* compiled from: Okio.java */
/* loaded from: classes.dex */
public final class gp0 {

    /* renamed from: a */
    public static final Logger f2967a = Logger.getLogger(gp0.class.getName());

    /* compiled from: Okio.java */
    /* renamed from: cz.opentree.gp0$a */
    /* loaded from: classes.dex */
    public class C1064a implements Sink {

        /* renamed from: O */
        public final /* synthetic */ mp0 f2968O;

        /* renamed from: P */
        public final /* synthetic */ OutputStream f2969P;

        public C1064a(mp0 mp0Var, OutputStream outputStream) {
            this.f2968O = mp0Var;
            this.f2969P = outputStream;
        }

        @Override // okio.Sink
        /* renamed from: F */
        public void mo2189F(zo0 zo0Var, long j) throws IOException {
            np0.m6762b(zo0Var.f8573P, 0L, j);
            while (j > 0) {
                this.f2968O.mo3309f();
                jp0 jp0Var = zo0Var.f8572O;
                int min = (int) Math.min(j, jp0Var.f3640c - jp0Var.f3639b);
                this.f2969P.write(jp0Var.f3638a, jp0Var.f3639b, min);
                int i = jp0Var.f3639b + min;
                jp0Var.f3639b = i;
                long j2 = min;
                j -= j2;
                zo0Var.f8573P -= j2;
                if (i == jp0Var.f3640c) {
                    zo0Var.f8572O = jp0Var.m5182b();
                    kp0.m5987a(jp0Var);
                }
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f2969P.close();
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            this.f2969P.flush();
        }

        @Override // okio.Sink
        /* renamed from: g */
        public mp0 mo2190g() {
            return this.f2968O;
        }

        public String toString() {
            return "sink(" + this.f2969P + ")";
        }
    }

    /* compiled from: Okio.java */
    /* renamed from: cz.opentree.gp0$b */
    /* loaded from: classes.dex */
    public class C1065b implements Source {

        /* renamed from: O */
        public final /* synthetic */ mp0 f2970O;

        /* renamed from: P */
        public final /* synthetic */ InputStream f2971P;

        public C1065b(mp0 mp0Var, InputStream inputStream) {
            this.f2970O = mp0Var;
            this.f2971P = inputStream;
        }

        @Override // okio.Source
        /* renamed from: R */
        public long mo2186R(zo0 zo0Var, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (j == 0) {
                return 0L;
            }
            try {
                this.f2970O.mo3309f();
                jp0 m10560i0 = zo0Var.m10560i0(1);
                int read = this.f2971P.read(m10560i0.f3638a, m10560i0.f3640c, (int) Math.min(j, 8192 - m10560i0.f3640c));
                if (read == -1) {
                    return -1L;
                }
                m10560i0.f3640c += read;
                long j2 = read;
                zo0Var.f8573P += j2;
                return j2;
            } catch (AssertionError e) {
                if (gp0.m4229c(e)) {
                    throw new IOException(e);
                }
                throw e;
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f2971P.close();
        }

        @Override // okio.Source
        /* renamed from: g */
        public mp0 mo2188g() {
            return this.f2970O;
        }

        public String toString() {
            return "source(" + this.f2971P + ")";
        }
    }

    /* compiled from: Okio.java */
    /* renamed from: cz.opentree.gp0$c */
    /* loaded from: classes.dex */
    public class C1066c extends xo0 {

        /* renamed from: k */
        public final /* synthetic */ Socket f2972k;

        public C1066c(Socket socket) {
            this.f2972k = socket;
        }

        @Override // cz.opentree.xo0
        /* renamed from: o */
        public IOException mo4237o(@Nullable IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // cz.opentree.xo0
        /* renamed from: t */
        public void mo4238t() {
            try {
                this.f2972k.close();
            } catch (AssertionError e) {
                if (!gp0.m4229c(e)) {
                    throw e;
                }
                gp0.f2967a.log(Level.WARNING, "Failed to close timed out socket " + this.f2972k, (Throwable) e);
            } catch (Exception e2) {
                gp0.f2967a.log(Level.WARNING, "Failed to close timed out socket " + this.f2972k, (Throwable) e2);
            }
        }
    }

    /* renamed from: a */
    public static BufferedSink m4227a(Sink sink) {
        return new hp0(sink);
    }

    /* renamed from: b */
    public static BufferedSource m4228b(Source source) {
        return new ip0(source);
    }

    /* renamed from: c */
    public static boolean m4229c(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    /* renamed from: d */
    public static Sink m4230d(OutputStream outputStream, mp0 mp0Var) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (mp0Var != null) {
            return new C1064a(mp0Var, outputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* renamed from: e */
    public static Sink m4231e(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getOutputStream() == null) {
            throw new IOException("socket's output stream == null");
        }
        xo0 m4236j = m4236j(socket);
        return m4236j.m9860r(m4230d(socket.getOutputStream(), m4236j));
    }

    /* renamed from: f */
    public static Source m4232f(File file) throws FileNotFoundException {
        if (file != null) {
            return m4233g(new FileInputStream(file));
        }
        throw new IllegalArgumentException("file == null");
    }

    /* renamed from: g */
    public static Source m4233g(InputStream inputStream) {
        return m4234h(inputStream, new mp0());
    }

    /* renamed from: h */
    public static Source m4234h(InputStream inputStream, mp0 mp0Var) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (mp0Var != null) {
            return new C1065b(mp0Var, inputStream);
        }
        throw new IllegalArgumentException("timeout == null");
    }

    /* renamed from: i */
    public static Source m4235i(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        xo0 m4236j = m4236j(socket);
        return m4236j.m9861s(m4234h(socket.getInputStream(), m4236j));
    }

    /* renamed from: j */
    public static xo0 m4236j(Socket socket) {
        return new C1066c(socket);
    }
}
