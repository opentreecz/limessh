package cz.opentree;

import android.util.Log;
import cz.opentree.jk0;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.adapter.SSHPortForward;
import cz.opentree.sk0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* compiled from: SSHPortForwardRemote.java */
/* loaded from: classes.dex */
public class kk0 implements SSHPortForward {

    /* renamed from: a */
    public final SshLibrary f4582a;

    /* renamed from: b */
    public final SshLibrary.ssh_session f4583b;

    /* renamed from: c */
    public String f4584c;

    /* renamed from: d */
    public int f4585d;

    /* renamed from: e */
    public Selector f4586e;

    /* renamed from: f */
    public boolean f4587f = false;

    /* renamed from: g */
    public int f4588g = 0;

    /* compiled from: SSHPortForwardRemote.java */
    /* renamed from: cz.opentree.kk0$a */
    /* loaded from: classes.dex */
    public static class C1462a {

        /* renamed from: a */
        public int f4589a;

        /* renamed from: b */
        public SshLibrary.ssh_channel f4590b;

        /* renamed from: c */
        public sk0.C1873a f4591c;

        /* renamed from: d */
        public sk0.C1874b f4592d;

        /* renamed from: e */
        public byte[] f4593e = new byte[32768];

        /* renamed from: f */
        public byte[] f4594f = new byte[32768];
    }

    public kk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, int i, String str, int i2) throws ek0 {
        this.f4582a = sshLibrary;
        this.f4583b = ssh_sessionVar;
        this.f4584c = str;
        this.f4585d = i2;
        if (sshLibrary.ssh_channel_listen_forward(ssh_sessionVar, (String) null, i, (IntBuffer) null) != 0) {
            throw new ek0(ek0.f2472j0, String.format("could not bind to port 0.0.0.0:%d on the remote host", Integer.valueOf(i)));
        }
        try {
            this.f4586e = Selector.open();
        } catch (IOException unused) {
            throw new ek0(ek0.f2472j0, "could not create socket selector");
        }
    }

    /* renamed from: a */
    public final void m5940a(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1462a)) {
            Log.e("SSHPortForwardRemote", "Failed retrieve SSH channel for write operation to incoming connection for remote port forward");
            throw new IOException("Failed retrieve SSH channel for write operation to incoming connection for remote port forward");
        }
        C1462a c1462a = (C1462a) attachment;
        int read = c1462a.f4591c.read(c1462a.f4593e);
        if (read < 0) {
            Log.d("SSHPortForwardRemote", String.format("Received an error or EOF from the ssh channel for incoming connection %d on remote port forward", Integer.valueOf(c1462a.f4589a)));
            this.f4582a.ssh_channel_close(c1462a.f4590b);
            socketChannel.close();
        } else if (read == 0) {
            socketChannel.register(this.f4586e, 5, c1462a);
        } else if (read > 0) {
            socketChannel.write(ByteBuffer.wrap(c1462a.f4593e, 0, read));
            socketChannel.register(this.f4586e, 5, c1462a);
        }
    }

    /* renamed from: b */
    public final void m5941b(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1462a)) {
            Log.e("SSHPortForwardRemote", "Failed retrieve SSH channel for read operation to incoming connection for remote port forward");
            throw new IOException("Failed retrieve SSH channel for read operation to incoming connection for remote port forward");
        }
        C1462a c1462a = (C1462a) attachment;
        ByteBuffer wrap = ByteBuffer.wrap(c1462a.f4594f);
        int read = socketChannel.read(wrap);
        if (read < 0) {
            Log.d("SSHPortForwardRemote", String.format("Received an error or EOF from the socket for incoming connection %d on remote port forward", Integer.valueOf(c1462a.f4589a)));
            this.f4582a.ssh_channel_close(c1462a.f4590b);
            socketChannel.close();
        } else if (read == 0) {
            socketChannel.register(this.f4586e, 5, c1462a);
        } else if (read > 0) {
            c1462a.f4592d.write(wrap.array(), 0, read);
            socketChannel.register(this.f4586e, 5, c1462a);
        }
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void close() {
        this.f4587f = true;
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public boolean isClosed() {
        return this.f4587f;
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void start() throws ek0 {
        while (!isClosed()) {
            try {
                int select = this.f4586e.select(1L);
                Iterator<SelectionKey> it = this.f4586e.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    it.remove();
                    if (next.isValid()) {
                        try {
                            if (next.isReadable()) {
                                m5941b(next);
                            } else if (next.isWritable()) {
                                m5940a(next);
                            }
                        } catch (IOException e) {
                            Log.e("SSHPortForwardRemote", "An error occurred on a remote port forward connection: " + e.getMessage());
                            Log.e("SSHPortForwardRemote", "Closing remote port forward socket");
                            try {
                                ((SocketChannel) next.channel()).close();
                            } catch (IOException | ClassCastException unused) {
                                Log.e("SSHPortForwardRemote", "Failed to close remote port forward connection: " + e.getMessage());
                            }
                            Object attachment = next.attachment();
                            if (attachment instanceof jk0.C1220a) {
                                Log.e("SSHPortForwardRemote", "Closing remote port forward connection channel");
                                this.f4582a.ssh_channel_close(((jk0.C1220a) attachment).f3599b);
                            }
                        }
                    }
                }
                SshLibrary.ssh_channel ssh_channel_accept_forward = this.f4582a.ssh_channel_accept_forward(this.f4583b, select > 0 ? 0 : 100, (IntBuffer) null);
                if (ssh_channel_accept_forward != null) {
                    try {
                        SocketChannel open = SocketChannel.open();
                        open.configureBlocking(false);
                        open.connect(new InetSocketAddress(this.f4584c, this.f4585d));
                        while (!open.finishConnect()) {
                            try {
                                Thread.sleep(25L);
                            } catch (InterruptedException e2) {
                                e2.printStackTrace();
                            }
                        }
                        C1462a c1462a = new C1462a();
                        c1462a.f4589a = this.f4588g;
                        c1462a.f4590b = ssh_channel_accept_forward;
                        c1462a.f4591c = new sk0.C1873a(this.f4582a, ssh_channel_accept_forward, false);
                        c1462a.f4592d = new sk0.C1874b(this.f4582a, ssh_channel_accept_forward);
                        this.f4588g++;
                        open.register(this.f4586e, 5, c1462a);
                    } catch (IOException unused2) {
                        Log.e("SSHPortForwardRemote", "Failed to connect to destination for remote port forward connection");
                        this.f4582a.ssh_channel_close(ssh_channel_accept_forward);
                    }
                }
            } catch (IOException e3) {
                throw new ek0(ek0.f2471i0, "unavailable selector: " + e3.getMessage());
            }
        }
    }
}
