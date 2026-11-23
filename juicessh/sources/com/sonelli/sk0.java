package com.sonelli;

import android.util.Log;
import com.sonelli.libssh.SshLibrary;
import com.sun.jna.Memory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: SSHStream.java */
/* loaded from: classes.dex */
public class sk0 {

    /* renamed from: a */
    public static int f6484a = 0;

    /* renamed from: b */
    public static int f6485b = 50;

    /* compiled from: SSHStream.java */
    /* renamed from: com.sonelli.sk0$a */
    /* loaded from: classes.dex */
    public static class C1873a extends InputStream {

        /* renamed from: O */
        public SshLibrary f6486O;

        /* renamed from: P */
        public SshLibrary.ssh_channel f6487P;

        /* renamed from: R */
        public boolean f6489R;

        /* renamed from: T */
        public Memory f6491T;

        /* renamed from: U */
        public Memory f6492U;

        /* renamed from: Q */
        public boolean f6488Q = false;

        /* renamed from: S */
        public Memory f6490S = new Memory(1);

        /* renamed from: V */
        public int f6493V = sk0.f6484a;

        public C1873a(SshLibrary sshLibrary, SshLibrary.ssh_channel ssh_channelVar, boolean z) {
            this.f6489R = false;
            this.f6486O = sshLibrary;
            this.f6487P = ssh_channelVar;
            this.f6489R = z;
        }

        /* renamed from: a */
        public boolean m8459a() {
            return this.f6488Q || this.f6486O.ssh_channel_is_open(this.f6487P) == 0;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f6488Q = true;
            super.close();
        }

        @Override // java.io.InputStream
        public int read() {
            if (m8459a()) {
                return -1;
            }
            int ssh_channel_read_nonblocking = this.f6486O.ssh_channel_read_nonblocking(this.f6487P, this.f6490S, 1, this.f6489R ? 1 : 0);
            if (ssh_channel_read_nonblocking != 0) {
                this.f6493V = sk0.f6484a;
                if (ssh_channel_read_nonblocking < 0) {
                    return -1;
                }
                return this.f6490S.getByte(0L);
            }
            if (this.f6486O.ssh_channel_is_eof(this.f6487P) != 0) {
                Log.e("SSHStream", "Got an EOF from the SSH channel");
                return -1;
            }
            try {
                Thread.sleep(this.f6493V);
                int i = this.f6493V;
                if (i >= sk0.f6485b) {
                    return 0;
                }
                this.f6493V = i + 1;
                return 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return 0;
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            if (m8459a()) {
                return -1;
            }
            if (this.f6491T == null) {
                this.f6491T = new Memory(bArr.length);
            }
            int ssh_channel_read_nonblocking = this.f6486O.ssh_channel_read_nonblocking(this.f6487P, this.f6491T, bArr.length, this.f6489R ? 1 : 0);
            if (ssh_channel_read_nonblocking != 0) {
                this.f6493V = sk0.f6484a;
                if (ssh_channel_read_nonblocking < 0) {
                    return -1;
                }
                System.arraycopy(this.f6491T.getByteArray(0L, ssh_channel_read_nonblocking), 0, bArr, 0, ssh_channel_read_nonblocking);
                return ssh_channel_read_nonblocking;
            }
            if (this.f6486O.ssh_channel_is_eof(this.f6487P) != 0) {
                Log.e("SSHStream", "Got an EOF from the SSH channel");
                return -1;
            }
            try {
                Thread.sleep(this.f6493V);
                int i = this.f6493V;
                if (i < sk0.f6485b) {
                    this.f6493V = i + 1;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            if (m8459a()) {
                return -1;
            }
            if (this.f6492U == null) {
                this.f6492U = new Memory(bArr.length);
            }
            int ssh_channel_read = this.f6486O.ssh_channel_read(this.f6487P, this.f6492U, i2, this.f6489R ? 1 : 0);
            if (ssh_channel_read != 0) {
                this.f6493V = sk0.f6484a;
                if (ssh_channel_read < 0) {
                    return -1;
                }
                System.arraycopy(this.f6492U.getByteArray(0L, ssh_channel_read), 0, bArr, i, ssh_channel_read);
                return ssh_channel_read;
            }
            if (this.f6486O.ssh_channel_is_eof(this.f6487P) != 0) {
                Log.e("SSHStream", "Got an EOF from the SSH channel");
                return -1;
            }
            try {
                Thread.sleep(this.f6493V);
                int i3 = this.f6493V;
                if (i3 <= sk0.f6485b) {
                    this.f6493V = i3 + 1;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 0;
        }
    }

    /* compiled from: SSHStream.java */
    /* renamed from: com.sonelli.sk0$b */
    /* loaded from: classes.dex */
    public static class C1874b extends OutputStream {

        /* renamed from: O */
        public SshLibrary f6494O;

        /* renamed from: P */
        public SshLibrary.ssh_channel f6495P;

        /* renamed from: Q */
        public boolean f6496Q = false;

        /* renamed from: R */
        public Memory f6497R = new Memory(1);

        /* renamed from: S */
        public Memory f6498S;

        /* renamed from: T */
        public Memory f6499T;

        public C1874b(SshLibrary sshLibrary, SshLibrary.ssh_channel ssh_channelVar) {
            this.f6494O = sshLibrary;
            this.f6495P = ssh_channelVar;
        }

        /* renamed from: a */
        public boolean m8460a() {
            return this.f6496Q || this.f6494O.ssh_channel_is_open(this.f6495P) == 0;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f6496Q = true;
            super.close();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            if (this.f6496Q) {
                throw new IOException("could not write to closed SSH stream");
            }
            this.f6497R.setByte(0L, (byte) i);
            if (this.f6494O.ssh_channel_write(this.f6495P, this.f6497R, 1) != 1) {
                throw new IOException("failed to write to SSH channel");
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            if (this.f6496Q) {
                throw new IOException("could not write to closed SSH stream");
            }
            if (this.f6498S == null) {
                this.f6498S = new Memory(bArr.length);
            }
            this.f6498S.write(0L, bArr, 0, bArr.length);
            if (this.f6494O.ssh_channel_write(this.f6495P, this.f6498S, bArr.length) != bArr.length) {
                throw new IOException("failed to write to SSH channel");
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            if (this.f6496Q) {
                throw new IOException("could not write to closed SSH stream");
            }
            if (this.f6499T == null) {
                this.f6499T = new Memory(bArr.length);
            }
            this.f6499T.write(0L, bArr, i, i2);
            if (this.f6494O.ssh_channel_write(this.f6495P, this.f6499T, i2) > bArr.length) {
                throw new IOException("failed to write to SSH channel");
            }
        }
    }
}
