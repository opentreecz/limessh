package com.google.firebase.crashlytics.internal.log;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes.dex */
public class QueueFile implements Closeable {

    /* renamed from: U */
    public static final Logger f1222U = Logger.getLogger(QueueFile.class.getName());

    /* renamed from: O */
    public final RandomAccessFile f1223O;

    /* renamed from: P */
    public int f1224P;

    /* renamed from: Q */
    public int f1225Q;

    /* renamed from: R */
    public C0660b f1226R;

    /* renamed from: S */
    public C0660b f1227S;

    /* renamed from: T */
    public final byte[] f1228T = new byte[16];

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* loaded from: classes.dex */
    public interface ElementReader {
        /* renamed from: a */
        void mo1784a(InputStream inputStream, int i) throws IOException;
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$a */
    /* loaded from: classes.dex */
    public class C0659a implements ElementReader {

        /* renamed from: a */
        public boolean f1229a = true;

        /* renamed from: b */
        public final /* synthetic */ StringBuilder f1230b;

        public C0659a(QueueFile queueFile, StringBuilder sb) {
            this.f1230b = sb;
        }

        @Override // com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader
        /* renamed from: a */
        public void mo1784a(InputStream inputStream, int i) throws IOException {
            if (this.f1229a) {
                this.f1229a = false;
            } else {
                this.f1230b.append(", ");
            }
            this.f1230b.append(i);
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$b */
    /* loaded from: classes.dex */
    public static class C0660b {

        /* renamed from: c */
        public static final C0660b f1231c = new C0660b(0, 0);

        /* renamed from: a */
        public final int f1232a;

        /* renamed from: b */
        public final int f1233b;

        public C0660b(int i, int i2) {
            this.f1232a = i;
            this.f1233b = i2;
        }

        public String toString() {
            return C0660b.class.getSimpleName() + "[position = " + this.f1232a + ", length = " + this.f1233b + "]";
        }
    }

    /* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
    /* renamed from: com.google.firebase.crashlytics.internal.log.QueueFile$c */
    /* loaded from: classes.dex */
    public final class C0661c extends InputStream {

        /* renamed from: O */
        public int f1234O;

        /* renamed from: P */
        public int f1235P;

        public C0661c(C0660b c0660b) {
            this.f1234O = QueueFile.this.m1777g0(c0660b.f1232a + 4);
            this.f1235P = c0660b.f1233b;
        }

        public /* synthetic */ C0661c(QueueFile queueFile, C0660b c0660b, C0659a c0659a) {
            this(c0660b);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f1235P == 0) {
                return -1;
            }
            QueueFile.this.f1223O.seek(this.f1234O);
            int read = QueueFile.this.f1223O.read();
            this.f1234O = QueueFile.this.m1777g0(this.f1234O + 1);
            this.f1235P--;
            return read;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            QueueFile.m1761b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f1235P;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.m1772c0(this.f1234O, bArr, i, i2);
            this.f1234O = QueueFile.this.m1777g0(this.f1234O + i2);
            this.f1235P -= i2;
            return i2;
        }
    }

    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            m1766x(file);
        }
        this.f1223O = m1758D(file);
        m1769Y();
    }

    /* renamed from: D */
    public static RandomAccessFile m1758D(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    /* renamed from: Z */
    public static int m1759Z(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* renamed from: b */
    public static /* synthetic */ Object m1761b(Object obj, String str) {
        m1767z(obj, str);
        return obj;
    }

    /* renamed from: i0 */
    public static void m1764i0(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* renamed from: j0 */
    public static void m1765j0(byte[] bArr, int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            m1764i0(bArr, i, i2);
            i += 4;
        }
    }

    /* renamed from: x */
    public static void m1766x(File file) throws IOException {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile m1758D = m1758D(file2);
        try {
            m1758D.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
            m1758D.seek(0L);
            byte[] bArr = new byte[16];
            m1765j0(bArr, 4096, 0, 0, 0);
            m1758D.write(bArr);
            m1758D.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            m1758D.close();
            throw th;
        }
    }

    /* renamed from: z */
    public static <T> T m1767z(T t, String str) {
        Objects.requireNonNull(t, str);
        return t;
    }

    /* renamed from: K */
    public final C0660b m1768K(int i) throws IOException {
        if (i == 0) {
            return C0660b.f1231c;
        }
        this.f1223O.seek(i);
        return new C0660b(i, this.f1223O.readInt());
    }

    /* renamed from: Y */
    public final void m1769Y() throws IOException {
        this.f1223O.seek(0L);
        this.f1223O.readFully(this.f1228T);
        int m1759Z = m1759Z(this.f1228T, 0);
        this.f1224P = m1759Z;
        if (m1759Z <= this.f1223O.length()) {
            this.f1225Q = m1759Z(this.f1228T, 4);
            int m1759Z2 = m1759Z(this.f1228T, 8);
            int m1759Z3 = m1759Z(this.f1228T, 12);
            this.f1226R = m1768K(m1759Z2);
            this.f1227S = m1768K(m1759Z3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.f1224P + ", Actual length: " + this.f1223O.length());
    }

    /* renamed from: a0 */
    public final int m1770a0() {
        return this.f1224P - m1776f0();
    }

    /* renamed from: b0 */
    public synchronized void m1771b0() throws IOException {
        if (m1783y()) {
            throw new NoSuchElementException();
        }
        if (this.f1225Q == 1) {
            m1780l();
        } else {
            C0660b c0660b = this.f1226R;
            int m1777g0 = m1777g0(c0660b.f1232a + 4 + c0660b.f1233b);
            m1772c0(m1777g0, this.f1228T, 0, 4);
            int m1759Z = m1759Z(this.f1228T, 0);
            m1779h0(this.f1224P, this.f1225Q - 1, m1777g0, this.f1227S.f1232a);
            this.f1225Q--;
            this.f1226R = new C0660b(m1777g0, m1759Z);
        }
    }

    /* renamed from: c0 */
    public final void m1772c0(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m1777g0 = m1777g0(i);
        int i4 = m1777g0 + i3;
        int i5 = this.f1224P;
        if (i4 <= i5) {
            this.f1223O.seek(m1777g0);
            this.f1223O.readFully(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m1777g0;
        this.f1223O.seek(m1777g0);
        this.f1223O.readFully(bArr, i2, i6);
        this.f1223O.seek(16L);
        this.f1223O.readFully(bArr, i2 + i6, i3 - i6);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f1223O.close();
    }

    /* renamed from: d0 */
    public final void m1773d0(int i, byte[] bArr, int i2, int i3) throws IOException {
        int m1777g0 = m1777g0(i);
        int i4 = m1777g0 + i3;
        int i5 = this.f1224P;
        if (i4 <= i5) {
            this.f1223O.seek(m1777g0);
            this.f1223O.write(bArr, i2, i3);
            return;
        }
        int i6 = i5 - m1777g0;
        this.f1223O.seek(m1777g0);
        this.f1223O.write(bArr, i2, i6);
        this.f1223O.seek(16L);
        this.f1223O.write(bArr, i2 + i6, i3 - i6);
    }

    /* renamed from: e0 */
    public final void m1774e0(int i) throws IOException {
        this.f1223O.setLength(i);
        this.f1223O.getChannel().force(true);
    }

    /* renamed from: f */
    public void m1775f(byte[] bArr) throws IOException {
        m1778h(bArr, 0, bArr.length);
    }

    /* renamed from: f0 */
    public int m1776f0() {
        if (this.f1225Q == 0) {
            return 16;
        }
        C0660b c0660b = this.f1227S;
        int i = c0660b.f1232a;
        int i2 = this.f1226R.f1232a;
        return i >= i2 ? (i - i2) + 4 + c0660b.f1233b + 16 : (((i + 4) + c0660b.f1233b) + this.f1224P) - i2;
    }

    /* renamed from: g0 */
    public final int m1777g0(int i) {
        int i2 = this.f1224P;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* renamed from: h */
    public synchronized void m1778h(byte[] bArr, int i, int i2) throws IOException {
        int m1777g0;
        m1767z(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        m1781n(i2);
        boolean m1783y = m1783y();
        if (m1783y) {
            m1777g0 = 16;
        } else {
            C0660b c0660b = this.f1227S;
            m1777g0 = m1777g0(c0660b.f1232a + 4 + c0660b.f1233b);
        }
        C0660b c0660b2 = new C0660b(m1777g0, i2);
        m1764i0(this.f1228T, 0, i2);
        m1773d0(c0660b2.f1232a, this.f1228T, 0, 4);
        m1773d0(c0660b2.f1232a + 4, bArr, i, i2);
        m1779h0(this.f1224P, this.f1225Q + 1, m1783y ? c0660b2.f1232a : this.f1226R.f1232a, c0660b2.f1232a);
        this.f1227S = c0660b2;
        this.f1225Q++;
        if (m1783y) {
            this.f1226R = c0660b2;
        }
    }

    /* renamed from: h0 */
    public final void m1779h0(int i, int i2, int i3, int i4) throws IOException {
        m1765j0(this.f1228T, i, i2, i3, i4);
        this.f1223O.seek(0L);
        this.f1223O.write(this.f1228T);
    }

    /* renamed from: l */
    public synchronized void m1780l() throws IOException {
        m1779h0(4096, 0, 0, 0);
        this.f1225Q = 0;
        C0660b c0660b = C0660b.f1231c;
        this.f1226R = c0660b;
        this.f1227S = c0660b;
        if (this.f1224P > 4096) {
            m1774e0(4096);
        }
        this.f1224P = 4096;
    }

    /* renamed from: n */
    public final void m1781n(int i) throws IOException {
        int i2 = i + 4;
        int m1770a0 = m1770a0();
        if (m1770a0 >= i2) {
            return;
        }
        int i3 = this.f1224P;
        do {
            m1770a0 += i3;
            i3 <<= 1;
        } while (m1770a0 < i2);
        m1774e0(i3);
        C0660b c0660b = this.f1227S;
        int m1777g0 = m1777g0(c0660b.f1232a + 4 + c0660b.f1233b);
        if (m1777g0 < this.f1226R.f1232a) {
            FileChannel channel = this.f1223O.getChannel();
            channel.position(this.f1224P);
            long j = m1777g0 - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.f1227S.f1232a;
        int i5 = this.f1226R.f1232a;
        if (i4 < i5) {
            int i6 = (this.f1224P + i4) - 16;
            m1779h0(i3, this.f1225Q, i5, i6);
            this.f1227S = new C0660b(i6, this.f1227S.f1233b);
        } else {
            m1779h0(i3, this.f1225Q, i5, i4);
        }
        this.f1224P = i3;
    }

    /* renamed from: p */
    public synchronized void m1782p(ElementReader elementReader) throws IOException {
        int i = this.f1226R.f1232a;
        for (int i2 = 0; i2 < this.f1225Q; i2++) {
            C0660b m1768K = m1768K(i);
            elementReader.mo1784a(new C0661c(this, m1768K, null), m1768K.f1233b);
            i = m1777g0(m1768K.f1232a + 4 + m1768K.f1233b);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QueueFile.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f1224P);
        sb.append(", size=");
        sb.append(this.f1225Q);
        sb.append(", first=");
        sb.append(this.f1226R);
        sb.append(", last=");
        sb.append(this.f1227S);
        sb.append(", element lengths=[");
        try {
            m1782p(new C0659a(this, sb));
        } catch (IOException e) {
            f1222U.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* renamed from: y */
    public synchronized boolean m1783y() {
        return this.f1225Q == 0;
    }
}
