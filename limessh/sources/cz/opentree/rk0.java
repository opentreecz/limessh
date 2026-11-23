package cz.opentree;

import android.util.Log;
import cz.opentree.libssh.SshLibrary;
import cz.opentree.libssh.adapter.SSHPortForward;
import cz.opentree.qk0;
import cz.opentree.sk0;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* compiled from: SSHSocksServer.java */
/* loaded from: classes.dex */
public class rk0 implements SSHPortForward {

    /* renamed from: a */
    public final SshLibrary f6225a;

    /* renamed from: b */
    public final SshLibrary.ssh_session f6226b;

    /* renamed from: c */
    public int f6227c;

    /* renamed from: d */
    public ServerSocketChannel f6228d;

    /* renamed from: e */
    public Selector f6229e;

    /* renamed from: f */
    public boolean f6230f = false;

    /* renamed from: g */
    public int f6231g = 0;

    /* compiled from: SSHSocksServer.java */
    /* renamed from: cz.opentree.rk0$a */
    /* loaded from: classes.dex */
    public static class C1822a {

        /* renamed from: a */
        public int f6232a;

        /* renamed from: b */
        public SshLibrary.ssh_channel f6233b;

        /* renamed from: c */
        public sk0.C1873a f6234c;

        /* renamed from: d */
        public sk0.C1874b f6235d;

        /* renamed from: e */
        public qk0.C1771e f6236e = new qk0.C1771e();

        /* renamed from: f */
        public qk0.C1768b f6237f = new qk0.C1768b();

        /* renamed from: g */
        public byte[] f6238g = new byte[32768];

        /* renamed from: h */
        public byte[] f6239h = new byte[32768];
    }

    public rk0(SshLibrary sshLibrary, SshLibrary.ssh_session ssh_sessionVar, int i) throws ek0 {
        this.f6225a = sshLibrary;
        this.f6226b = ssh_sessionVar;
        this.f6227c = i;
        try {
            this.f6229e = Selector.open();
            ServerSocketChannel open = ServerSocketChannel.open();
            this.f6228d = open;
            open.socket().bind(new InetSocketAddress("127.0.0.1", i));
            this.f6228d.configureBlocking(false);
            this.f6228d.register(this.f6229e, this.f6228d.validOps(), null);
        } catch (IOException e) {
            Log.e("SSHSocksServer", "Could not bind SOCKS server to 127.0.0.1:" + i);
            throw new ek0(ek0.f2449B0, e.getMessage());
        }
    }

    /* renamed from: a */
    public final void m8141a(ServerSocketChannel serverSocketChannel, SelectionKey selectionKey) throws IOException, ek0 {
        SocketChannel accept = serverSocketChannel.accept();
        accept.configureBlocking(false);
        C1822a c1822a = new C1822a();
        int i = this.f6231g;
        c1822a.f6232a = i;
        this.f6231g = i + 1;
        accept.register(this.f6229e, 1, c1822a);
    }

    /* renamed from: b */
    public final void m8142b(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1822a)) {
            Log.e("SSHSocksServer", "Failed retrieve SSH channel for incoming SOCKS connection");
            throw new IOException("Failed retrieve SSH channel for incoming SOCKS connection");
        }
        C1822a c1822a = (C1822a) attachment;
        int read = c1822a.f6234c.read(c1822a.f6238g);
        if (read < 0) {
            Log.d("SSHSocksServer", String.format("Received an error or EOF from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c)));
            this.f6225a.ssh_channel_close(c1822a.f6233b);
            socketChannel.close();
        } else if (read == 0) {
            socketChannel.register(this.f6229e, 5, c1822a);
        } else if (read > 0) {
            socketChannel.write(ByteBuffer.wrap(c1822a.f6238g, 0, read));
            socketChannel.register(this.f6229e, 5, c1822a);
        }
    }

    /* renamed from: c */
    public final void m8143c(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        Object attachment = selectionKey.attachment();
        if (attachment == null || !(attachment instanceof C1822a)) {
            Log.e("SSHSocksServer", "Failed retrieve SSH channel for incoming SOCKS connection");
            throw new IOException("Failed retrieve SSH channel for incoming SOCKS connection");
        }
        C1822a c1822a = (C1822a) attachment;
        try {
            qk0.C1771e c1771e = c1822a.f6236e;
            qk0.EnumC1773g enumC1773g = c1771e.f6042d;
            qk0.EnumC1773g enumC1773g2 = qk0.EnumC1773g.COMPLETE;
            if (enumC1773g != enumC1773g2) {
                c1771e.m7738b(socketChannel);
                qk0.C1771e c1771e2 = c1822a.f6236e;
                if (c1771e2.f6042d != enumC1773g2) {
                    socketChannel.register(this.f6229e, 1, c1822a);
                    return;
                }
                c1771e2.m7737a(socketChannel);
            }
            try {
                qk0.C1768b c1768b = c1822a.f6237f;
                qk0.EnumC1769c enumC1769c = c1768b.f6015a;
                qk0.EnumC1769c enumC1769c2 = qk0.EnumC1769c.COMPLETE;
                if (enumC1769c != enumC1769c2) {
                    c1768b.m7733c(socketChannel);
                    if (c1822a.f6237f.f6015a != enumC1769c2) {
                        socketChannel.register(this.f6229e, 1, c1822a);
                        return;
                    }
                    qk0.C1770d c1770d = new qk0.C1770d();
                    c1770d.f6036c = (byte) 1;
                    c1770d.m7735b(socketChannel.socket().getInetAddress());
                    c1770d.m7736c(0);
                    String m7731a = c1822a.f6237f.m7731a();
                    int m7732b = c1822a.f6237f.m7732b();
                    if (m7731a != null && m7732b != -1) {
                        c1822a.f6233b = this.f6225a.ssh_channel_new(this.f6226b);
                        c1822a.f6234c = new sk0.C1873a(this.f6225a, c1822a.f6233b, false);
                        c1822a.f6235d = new sk0.C1874b(this.f6225a, c1822a.f6233b);
                        if (this.f6225a.ssh_channel_open_forward(c1822a.f6233b, m7731a, m7732b, "127.0.0.1", this.f6227c) != 0) {
                            Log.e("SSHSocksServer", "Failed to open SSH forward channel for inbound connection to SOCKS 127.0.0.1:" + this.f6227c + ": " + this.f6225a.ssh_get_error(this.f6226b.getPointer()));
                            c1770d.f6034a = (byte) 4;
                            socketChannel.write(ByteBuffer.wrap(c1770d.m7734a()));
                            socketChannel.close();
                            return;
                        }
                        c1770d.f6034a = (byte) 0;
                        socketChannel.write(ByteBuffer.wrap(c1770d.m7734a()));
                    }
                    Log.e("SSHSocksServer", "Got a SOCKS request with invalid address/port");
                    c1770d.f6034a = (byte) 4;
                    socketChannel.write(ByteBuffer.wrap(c1770d.m7734a()));
                    socketChannel.close();
                    return;
                }
                ByteBuffer wrap = ByteBuffer.wrap(c1822a.f6239h);
                int read = socketChannel.read(wrap);
                if (read < 0) {
                    Log.d("SSHSocksServer", String.format("Received an error or EOF from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c)));
                    this.f6225a.ssh_channel_close(c1822a.f6233b);
                    socketChannel.close();
                } else if (read == 0) {
                    socketChannel.register(this.f6229e, 5, c1822a);
                } else if (read > 0) {
                    c1822a.f6235d.write(wrap.array(), 0, read);
                    socketChannel.register(this.f6229e, 5, c1822a);
                }
            } catch (nk0 e) {
                Log.e("SSHSocksServer", String.format("Received a bad SOCKS request version from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s - ", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c), e.getMessage()));
                this.f6225a.ssh_channel_close(c1822a.f6233b);
                socketChannel.close();
            } catch (ok0 e2) {
                Log.e("SSHSocksServer", String.format("Received an invalid SOCKS request from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s - %s", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c), e2.getMessage()));
                this.f6225a.ssh_channel_close(c1822a.f6233b);
                socketChannel.close();
            }
        } catch (nk0 e3) {
            Log.e("SSHSocksServer", String.format("Received a bad SOCKS handshake version from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s - %s", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c), e3.getMessage()));
            this.f6225a.ssh_channel_close(c1822a.f6233b);
            socketChannel.close();
        } catch (pk0 e4) {
            Log.e("SSHSocksServer", String.format("Received an invalid SOCKS handshake from the socket for incoming connection %d to SOCKS server 127:0.0.1:%s - %s", Integer.valueOf(c1822a.f6232a), Integer.valueOf(this.f6227c), e4.getMessage()));
            this.f6225a.ssh_channel_close(c1822a.f6233b);
            socketChannel.close();
        }
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void close() {
        this.f6230f = true;
        try {
            ServerSocketChannel serverSocketChannel = this.f6228d;
            if (serverSocketChannel != null) {
                serverSocketChannel.close();
            }
        } catch (IOException unused) {
            Log.e("SSHSocksServer", "Failed to unbind SOCKS port 127.0.0.1:" + this.f6227c);
        }
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public boolean isClosed() {
        return this.f6230f;
    }

    @Override // cz.opentree.libssh.adapter.SSHPortForward
    public void start() throws ek0 {
        while (!this.f6230f) {
            try {
                this.f6229e.select();
                Iterator<SelectionKey> it = this.f6229e.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey next = it.next();
                    it.remove();
                    if (next.isValid()) {
                        if (next.isAcceptable()) {
                            m8141a(this.f6228d, next);
                        } else if (next.isReadable()) {
                            m8143c(next);
                        } else if (next.isWritable()) {
                            m8142b(next);
                        }
                    }
                }
            } catch (ek0 e) {
                throw new ek0(ek0.f2448A0, e.getMessage());
            } catch (IOException e2) {
                throw new ek0(ek0.f2448A0, e2.getMessage());
            }
        }
    }
}
