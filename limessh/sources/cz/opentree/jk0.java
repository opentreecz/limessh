package cz.opentree;

import android.util.Log;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.adapter.SSHPortForward;
import cz.opentree.sk0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* compiled from: SSHPortForwardLocal.java */
/* loaded from: classes.dex */
public class jk0 implements SSHPortForward {

    /* renamed from: a */
    public final SshLibrary f3589a;

    /* renamed from: b */
    public final SshLibrary.ssh_session f3590b;

    /* renamed from: c */
    public int f3591c;

    /* renamed from: d */
    public String f3592d;

    /* renamed from: e */
    public int f3593e;

    /* renamed from: g */
    public ServerSocketChannel f3595g;

    /* renamed from: h */
    public Selector f3596h;

    /* renamed from: f */
    public boolean f3594f = false;

    /* renamed from: i */
    public int f3597i = 0;

    /* compiled from: SSHPortForwardLocal.java */
    /* renamed from: cz.opentree.jk0$a */
    /* loaded from: classes.dex */
    public static class C1220a {

        /* renamed from: a */
        public int f3598a;

        /* renamed from: b */
        public SshLibrary.ssh_channel f3599b;

        /* renamed from: c */
        public sk0.C1873a f3600c;

        /* renamed from: d */
        public sk0.C1874b f3601d;

        /* renamed from: e */
        public byte[] f3602e = new byte[32768];

        /* renamed from: f */
        public byte[] f3603f = new byte[32768];
    }

    public jk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, int i, String str, int i2) throws ek0 {
        this.f3589a = sshLibrary;
        this.f3590b = ssh_sessionVar;
        this.f3591c = i;
        this.f3592d = str;
        this.f3593e = i2;
        try {
            this.f3596h = Selector.open();
            ServerSocketChannel open = ServerSocketChannel.open();
            this.f3595g = open;
            open.socket().bind(new InetSocketAddress("127.0.0.1", i));
            this.f3595g.configureBlocking(false);
            this.f3595g.register(this.f3596h, this.f3595g.validOps(), null);
        } catch (IOException e) {
            Log.e("SSHPortForwardLocal", "Could not bind to 127.0.0.1:" + i);
            throw new ek0(ek0.f2471i0, e.getMessage());
        }
    }

    /* renamed from: a */
    public final void m5140a(ServerSocketChannel serverSocketChannel, SelectionKey selectionKey) throws IOException {
        Log.d("SSHPortForwardLocal", "Accepted an incoming connection for local port forward");
        SocketChannel accept = serverSocketChannel.accept();
        accept.configureBlocking(false);
        SshLibrary.ssh_channel ssh_channel_new = this.f3589a.ssh_channel_new(this.f3590b);
        if (this.f3589a.ssh_channel_open_forward(ssh_channel_new, this.f3592d, this.f3593e, "127.0.0.1", this.f3591c) != 0) {
            String str = "Failed to open SSH forward channel for inbound connection to 127.0.0.1:" + this.f3591c + ": " + this.f3589a.ssh_get_error(this.f3590b.getPointer());
            Log.e("SSHPortForwardLocal", str);
            throw new IOException(str);
        }
        C1220a c1220a = new C1220a();
        c1220a.f3599b = ssh_channel_new;
        c1220a.f3600c = new sk0.C1873a(this.f3589a, ssh_channel_new, false);
        c1220a.f3601d = new sk0.C1874b(this.f3589a, ssh_channel_new);
        int i = this.f3597i;
        c1220a.f3598a = i;
        this.f3597i = i + 1;
        accept.register(this.f3596h, 5, c1220a);
    }

    /* renamed from: b */
    public final void m5141b(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1220a)) {
            String str = "Failed retrieve SSH channel for write operation to incoming connection for local port forward on 127:0.0.1:" + this.f3591c;
            Log.e("SSHPortForwardLocal", str);
            throw new IOException(str);
        }
        C1220a c1220a = (C1220a) attachment;
        int read = c1220a.f3600c.read(c1220a.f3602e);
        if (read < 0) {
            Log.d("SSHPortForwardLocal", String.format("Received an error or EOF from the ssh channel for incoming connection %d on local port forward 127:0.0.1:%s", Integer.valueOf(c1220a.f3598a), Integer.valueOf(this.f3591c)));
            this.f3589a.ssh_channel_close(c1220a.f3599b);
            socketChannel.close();
        } else if (read == 0) {
            socketChannel.register(this.f3596h, 5, c1220a);
        } else if (read > 0) {
            socketChannel.write(ByteBuffer.wrap(c1220a.f3602e, 0, read));
            socketChannel.register(this.f3596h, 5, c1220a);
        }
    }

    /* renamed from: c */
    public final void m5142c(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1220a)) {
            String str = "Failed retrieve SSH channel for read operation to incoming connection for local port forward on 127:0.0.1:" + this.f3591c;
            Log.e("SSHPortForwardLocal", str);
            throw new IOException(str);
        }
        C1220a c1220a = (C1220a) attachment;
        ByteBuffer wrap = ByteBuffer.wrap(c1220a.f3603f);
        int read = socketChannel.read(wrap);
        if (read < 0) {
            Log.d("SSHPortForwardLocal", String.format("Received an EOF from the socket for incoming connection %d on local port forward 127:0.0.1:%s", Integer.valueOf(c1220a.f3598a), Integer.valueOf(this.f3591c)));
            this.f3589a.ssh_channel_close(c1220a.f3599b);
            socketChannel.close();
        } else if (read == 0) {
            socketChannel.register(this.f3596h, 5, c1220a);
        } else if (read > 0) {
            c1220a.f3601d.write(wrap.array(), 0, read);
            socketChannel.register(this.f3596h, 5, c1220a);
        }
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void close() {
        this.f3594f = true;
        try {
            ServerSocketChannel serverSocketChannel = this.f3595g;
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch (IOException unused) {
            Log.e("SSHPortForwardLocal", "Failed to unbind forward port 127.0.0.1:" + this.f3591c);
        }
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public boolean isClosed() {
        return this.f3594f;
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void start() throws ek0 {
        while (!this.f3594f) {
            try {
                this.f3596h.select();
                Iterator<SelectionKey> it = this.f3596h.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    it.remove();
                    if (next.isValid()) {
                        try {
                            if (next.isAcceptable()) {
                                m5140a(this.f3595g, next);
                            } else if (next.isReadable()) {
                                m5142c(next);
                            } else if (next.isWritable()) {
                                m5141b(next);
                            }
                        } catch (IOException e) {
                            Log.e("SSHPortForwardLocal", "An error occurred on a local port forward connection: " + e.getMessage());
                            Log.e("SSHPortForwardLocal", "Closing local port forward socket");
                            try {
                                ((SocketChannel) next.channel()).close();
                            } catch (IOException | ClassCastException unused) {
                                Log.e("SSHPortForwardLocal", "Failed to close local port forward inbound connection: " + e.getMessage());
                            }
                            Object attachment = next.attachment();
                            if (attachment instanceof C1220a) {
                                Log.e("SSHPortForwardLocal", "Closing local port forward connection channel");
                                this.f3589a.ssh_channel_close(((C1220a) attachment).f3599b);
                            }
                        }
                    }
                }
            } catch (IOException e2) {
                throw new ek0(ek0.f2471i0, "unavailable selector: " + e2.getMessage());
            }
        }
    }
}
