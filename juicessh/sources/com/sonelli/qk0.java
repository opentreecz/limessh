package com.sonelli;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/* compiled from: SSHSocksRequest.java */
/* loaded from: classes.dex */
public class qk0 {

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C1767a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6013a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f6014b;

        static {
            int[] iArr = new int[EnumC1769c.values().length];
            f6014b = iArr;
            try {
                iArr[EnumC1769c.NEED_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6014b[EnumC1769c.NEED_COMMAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6014b[EnumC1769c.NEED_RESERVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6014b[EnumC1769c.NEED_ADDRESS_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6014b[EnumC1769c.NEED_ADDRESS_IPV4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6014b[EnumC1769c.NEED_ADDRESS_IPV6.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6014b[EnumC1769c.NEED_ADDRESS_DOMAIN_LENGTH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6014b[EnumC1769c.NEED_ADDRESS_DOMAIN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6014b[EnumC1769c.NEED_PORT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f6014b[EnumC1769c.COMPLETE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[EnumC1773g.values().length];
            f6013a = iArr2;
            try {
                iArr2[EnumC1773g.NEED_VERSION.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f6013a[EnumC1773g.NEED_NUM_OF_AUTHENTICATION_METHODS.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f6013a[EnumC1773g.NEED_AUTHENTICATION_METHODS.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f6013a[EnumC1773g.COMPLETE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$b */
    /* loaded from: classes.dex */
    public static class C1768b {

        /* renamed from: a */
        public EnumC1769c f6015a = EnumC1769c.NEED_VERSION;

        /* renamed from: b */
        public int f6016b;

        /* renamed from: c */
        public int f6017c;

        /* renamed from: d */
        public int f6018d;

        /* renamed from: e */
        public byte[] f6019e;

        /* renamed from: f */
        public byte[] f6020f;

        /* renamed from: g */
        public int f6021g;

        /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
        
            if (r0 != 4) goto L12;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String m7731a() {
            /*
                r2 = this;
                int r0 = r2.f6018d
                r1 = 1
                if (r0 == r1) goto L14
                r1 = 3
                if (r0 == r1) goto Lc
                r1 = 4
                if (r0 == r1) goto L14
                goto L1f
            Lc:
                java.lang.String r0 = new java.lang.String
                byte[] r1 = r2.f6019e
                r0.<init>(r1)
                goto L20
            L14:
                byte[] r0 = r2.f6019e     // Catch: java.net.UnknownHostException -> L1f
                java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r0)     // Catch: java.net.UnknownHostException -> L1f
                java.lang.String r0 = r0.getHostAddress()     // Catch: java.net.UnknownHostException -> L1f
                goto L20
            L1f:
                r0 = 0
            L20:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sonelli.qk0.C1768b.m7731a():java.lang.String");
        }

        /* renamed from: b */
        public int m7732b() {
            return ByteBuffer.wrap(this.f6020f).getChar();
        }

        /* renamed from: c */
        public void m7733c(SocketChannel socketChannel) throws IOException, nk0, ok0 {
            switch (C1767a.f6014b[this.f6015a.ordinal()]) {
                case 1:
                    byte[] bArr = new byte[1];
                    if (qk0.m7730b(bArr, 0, socketChannel) < 1) {
                        return;
                    }
                    byte b = bArr[0];
                    this.f6016b = b;
                    if (b == 5) {
                        EnumC1769c enumC1769c = EnumC1769c.COMPLETE;
                        this.f6015a = EnumC1769c.NEED_COMMAND;
                        return;
                    } else {
                        throw new nk0("bad SOCKS version: " + this.f6016b);
                    }
                case 2:
                    byte[] bArr2 = new byte[1];
                    if (qk0.m7730b(bArr2, 0, socketChannel) < 1) {
                        return;
                    }
                    byte b2 = bArr2[0];
                    this.f6017c = b2;
                    if (b2 == 1) {
                        this.f6015a = EnumC1769c.NEED_RESERVED;
                        return;
                    }
                    throw new ok0("unsupported SOCKS commmand: " + this.f6017c);
                case 3:
                    byte[] bArr3 = new byte[1];
                    if (qk0.m7730b(bArr3, 0, socketChannel) < 1) {
                        return;
                    }
                    byte b3 = bArr3[0];
                    this.f6015a = EnumC1769c.NEED_ADDRESS_TYPE;
                    return;
                case 4:
                    byte[] bArr4 = new byte[1];
                    if (qk0.m7730b(bArr4, 0, socketChannel) < 1) {
                        return;
                    }
                    byte b4 = bArr4[0];
                    this.f6018d = b4;
                    if (b4 == 1) {
                        this.f6015a = EnumC1769c.NEED_ADDRESS_IPV4;
                        return;
                    }
                    if (b4 == 3) {
                        this.f6015a = EnumC1769c.NEED_ADDRESS_DOMAIN_LENGTH;
                        return;
                    } else {
                        if (b4 == 4) {
                            this.f6015a = EnumC1769c.NEED_ADDRESS_IPV6;
                            return;
                        }
                        throw new ok0("invalid address type: " + this.f6018d);
                    }
                case 5:
                    byte[] bArr5 = new byte[4];
                    if (qk0.m7730b(bArr5, 0, socketChannel) < 4) {
                        return;
                    }
                    this.f6019e = bArr5;
                    this.f6015a = EnumC1769c.NEED_PORT;
                    return;
                case 6:
                    byte[] bArr6 = new byte[16];
                    if (qk0.m7730b(bArr6, 0, socketChannel) < 16) {
                        return;
                    }
                    this.f6019e = bArr6;
                    this.f6015a = EnumC1769c.NEED_PORT;
                    return;
                case 7:
                    byte[] bArr7 = new byte[1];
                    if (qk0.m7730b(bArr7, 0, socketChannel) < 1) {
                        return;
                    }
                    this.f6021g = bArr7[0];
                    this.f6015a = EnumC1769c.NEED_ADDRESS_DOMAIN;
                    return;
                case 8:
                    int i = this.f6021g;
                    byte[] bArr8 = new byte[i];
                    if (qk0.m7730b(bArr8, 0, socketChannel) < i) {
                        return;
                    }
                    this.f6019e = bArr8;
                    this.f6015a = EnumC1769c.NEED_PORT;
                    return;
                case 9:
                    byte[] bArr9 = new byte[2];
                    if (qk0.m7730b(bArr9, 0, socketChannel) < 2) {
                        return;
                    }
                    this.f6020f = bArr9;
                    this.f6015a = EnumC1769c.COMPLETE;
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$c */
    /* loaded from: classes.dex */
    public enum EnumC1769c {
        NEED_VERSION,
        NEED_COMMAND,
        NEED_RESERVED,
        NEED_ADDRESS_TYPE,
        NEED_ADDRESS_IPV4,
        NEED_ADDRESS_IPV6,
        NEED_ADDRESS_DOMAIN_LENGTH,
        NEED_ADDRESS_DOMAIN,
        NEED_ADDRESS,
        NEED_PORT,
        COMPLETE
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$d */
    /* loaded from: classes.dex */
    public static class C1770d {

        /* renamed from: a */
        public byte f6034a;

        /* renamed from: b */
        public byte f6035b;

        /* renamed from: c */
        public byte f6036c;

        /* renamed from: d */
        public byte[] f6037d;

        /* renamed from: e */
        public byte[] f6038e;

        /* renamed from: a */
        public byte[] m7734a() {
            byte b = this.f6036c;
            int length = b != 1 ? b != 3 ? b != 4 ? 0 : 16 : this.f6037d.length + 1 : 4;
            byte[] bArr = new byte[length + 4 + 2];
            bArr[0] = 5;
            bArr[1] = this.f6034a;
            bArr[2] = this.f6035b;
            bArr[3] = b;
            for (int i = 0; i < length - 1; i++) {
                if (this.f6036c == 3 && i == 0) {
                    bArr[i] = (byte) this.f6037d.length;
                } else {
                    bArr[i + 4] = this.f6037d[i];
                }
            }
            int i2 = length + 3;
            byte[] bArr2 = this.f6038e;
            bArr[i2 + 1] = bArr2[0];
            bArr[i2 + 2] = bArr2[1];
            return bArr;
        }

        /* renamed from: b */
        public void m7735b(InetAddress inetAddress) {
            this.f6037d = inetAddress.getAddress();
        }

        /* renamed from: c */
        public void m7736c(int i) {
            this.f6038e = r0;
            byte[] bArr = {(byte) (i & 255), (byte) ((i >> 8) & 255)};
        }
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$e */
    /* loaded from: classes.dex */
    public static class C1771e {

        /* renamed from: a */
        public int f6039a;

        /* renamed from: b */
        public int f6040b;

        /* renamed from: c */
        public byte[] f6041c;

        /* renamed from: d */
        public EnumC1773g f6042d = EnumC1773g.NEED_VERSION;

        /* renamed from: a */
        public void m7737a(SocketChannel socketChannel) throws IOException {
            boolean z;
            byte[] bArr = this.f6041c;
            int length = bArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else {
                    if (bArr[i] == 0) {
                        z = true;
                        break;
                    }
                    i++;
                }
            }
            C1772f c1772f = new C1772f();
            c1772f.f6043a = (byte) 5;
            if (z) {
                c1772f.f6044b = (byte) 0;
            } else {
                c1772f.f6044b = (byte) -1;
            }
            socketChannel.write(ByteBuffer.wrap(c1772f.m7739a()));
        }

        /* renamed from: b */
        public void m7738b(SocketChannel socketChannel) throws IOException, nk0, pk0 {
            int i = C1767a.f6013a[this.f6042d.ordinal()];
            if (i == 1) {
                byte[] bArr = new byte[1];
                if (qk0.m7730b(bArr, 0, socketChannel) < 1) {
                    return;
                }
                byte b = bArr[0];
                this.f6039a = b;
                if (b == 5) {
                    this.f6042d = EnumC1773g.NEED_NUM_OF_AUTHENTICATION_METHODS;
                    return;
                }
                throw new nk0("bad SOCKS version: " + this.f6039a);
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                int i2 = this.f6040b;
                byte[] bArr2 = new byte[i2];
                if (qk0.m7730b(bArr2, 0, socketChannel) < i2) {
                    return;
                }
                this.f6041c = bArr2;
                if (bArr2.length != this.f6040b) {
                    throw new pk0("mismatch between client stated number of support authentication methods and actual methods found");
                }
                this.f6042d = EnumC1773g.COMPLETE;
                return;
            }
            byte[] bArr3 = new byte[1];
            if (qk0.m7730b(bArr3, 0, socketChannel) < 1) {
                return;
            }
            byte b2 = bArr3[0];
            this.f6040b = b2;
            if (b2 >= 1 && b2 <= 255) {
                this.f6042d = EnumC1773g.NEED_AUTHENTICATION_METHODS;
                return;
            }
            throw new pk0("invalid number of SOCKS authentication methods: " + this.f6040b);
        }
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$f */
    /* loaded from: classes.dex */
    public static class C1772f {

        /* renamed from: a */
        public byte f6043a;

        /* renamed from: b */
        public byte f6044b;

        /* renamed from: a */
        public byte[] m7739a() {
            return new byte[]{this.f6043a, this.f6044b};
        }
    }

    /* compiled from: SSHSocksRequest.java */
    /* renamed from: com.sonelli.qk0$g */
    /* loaded from: classes.dex */
    public enum EnumC1773g {
        NEED_VERSION,
        NEED_NUM_OF_AUTHENTICATION_METHODS,
        NEED_AUTHENTICATION_METHODS,
        COMPLETE
    }

    /* renamed from: b */
    public static int m7730b(byte[] bArr, int i, SocketChannel socketChannel) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
        int read = socketChannel.read(allocate);
        if (read > 0) {
            System.arraycopy(allocate.array(), 0, bArr, i, read);
        }
        return read;
    }
}
