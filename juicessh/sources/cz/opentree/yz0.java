package cz.opentree;

import org.bouncycastle.crypto.Digest;

/* loaded from: classes.dex */
public abstract class yz0 {

    /* renamed from: a */
    public static final byte[] f8350a = j51.m5065d("SigEd25519 no Ed25519 collisions");

    /* renamed from: b */
    public static final int[] f8351b = {1559614445, 1477600026, -1560830762, 350157278, 0, 0, 0, 268435456};

    /* renamed from: c */
    public static final int[] f8352c = {52811034, 25909283, 8072341, 50637101, 13785486, 30858332, 20483199, 20966410, 43936626, 4379245};

    /* renamed from: d */
    public static final int[] f8353d = {40265304, 26843545, 6710886, 53687091, 13421772, 40265318, 26843545, 6710886, 53687091, 13421772};

    /* renamed from: e */
    public static final int[] f8354e = {56195235, 47411844, 25868126, 40503822, 57364, 58321048, 30416477, 31930572, 57760639, 10749657};

    /* renamed from: f */
    public static final int[] f8355f = {45281625, 27714825, 18181821, 13898781, 114729, 49533232, 60832955, 30306712, 48412415, 4722099};

    /* renamed from: g */
    public static final int[] f8356g = {23454386, 55429651, 2809210, 27797563, 229458, 31957600, 54557047, 27058993, 29715967, 9444199};

    /* renamed from: h */
    public static final Object f8357h = new Object();

    /* renamed from: i */
    public static int[] f8358i = null;

    /* renamed from: cz.opentree.yz0$b */
    /* loaded from: classes.dex */
    public static class C2402b {

        /* renamed from: a */
        public int[] f8359a;

        /* renamed from: b */
        public int[] f8360b;

        /* renamed from: c */
        public int[] f8361c;

        /* renamed from: d */
        public int[] f8362d;

        /* renamed from: e */
        public int[] f8363e;

        public C2402b() {
            this.f8359a = xz0.m9971h();
            this.f8360b = xz0.m9971h();
            this.f8361c = xz0.m9971h();
            this.f8362d = xz0.m9971h();
            this.f8363e = xz0.m9971h();
        }
    }

    /* renamed from: cz.opentree.yz0$c */
    /* loaded from: classes.dex */
    public static class C2403c {

        /* renamed from: a */
        public int[] f8364a;

        /* renamed from: b */
        public int[] f8365b;

        /* renamed from: c */
        public int[] f8366c;

        /* renamed from: d */
        public int[] f8367d;

        public C2403c() {
            this.f8364a = xz0.m9971h();
            this.f8365b = xz0.m9971h();
            this.f8366c = xz0.m9971h();
            this.f8367d = xz0.m9971h();
        }
    }

    /* renamed from: cz.opentree.yz0$d */
    /* loaded from: classes.dex */
    public static class C2404d {

        /* renamed from: a */
        public int[] f8368a;

        /* renamed from: b */
        public int[] f8369b;

        /* renamed from: c */
        public int[] f8370c;

        public C2404d() {
            this.f8368a = xz0.m9971h();
            this.f8369b = xz0.m9971h();
            this.f8370c = xz0.m9971h();
        }
    }

    /* renamed from: A */
    public static void m10275A(C2402b c2402b) {
        xz0.m9987x(c2402b.f8359a);
        xz0.m9981r(c2402b.f8360b);
        xz0.m9981r(c2402b.f8361c);
        xz0.m9987x(c2402b.f8362d);
        xz0.m9981r(c2402b.f8363e);
    }

    /* renamed from: B */
    public static void m10276B(C2403c c2403c) {
        xz0.m9987x(c2403c.f8364a);
        xz0.m9981r(c2403c.f8365b);
        xz0.m9981r(c2403c.f8366c);
        xz0.m9987x(c2403c.f8367d);
    }

    /* renamed from: C */
    public static void m10277C() {
        int i;
        synchronized (f8357h) {
            if (f8358i != null) {
                return;
            }
            C2403c c2403c = new C2403c();
            int[] iArr = f8352c;
            xz0.m9970g(iArr, 0, c2403c.f8364a, 0);
            int[] iArr2 = f8353d;
            xz0.m9970g(iArr2, 0, c2403c.f8365b, 0);
            m10308x(c2403c);
            m10310z(c2403c, 32);
            C2402b c2402b = new C2402b();
            xz0.m9970g(iArr, 0, c2402b.f8359a, 0);
            xz0.m9970g(iArr2, 0, c2402b.f8360b, 0);
            m10307w(c2402b);
            f8358i = xz0.m9972i(192);
            int i2 = 0;
            for (int i3 = 0; i3 < 8; i3++) {
                C2403c[] c2403cArr = new C2403c[4];
                C2403c c2403c2 = new C2403c();
                m10276B(c2403c2);
                int i4 = 0;
                while (true) {
                    i = 1;
                    if (i4 >= 4) {
                        break;
                    }
                    m10302r(true, c2403c2, m10303s(c2402b), c2403c2);
                    m10306v(c2402b);
                    c2403cArr[i4] = m10303s(c2402b);
                    if (i3 + i4 != 10) {
                        while (i < 8) {
                            m10306v(c2402b);
                            i++;
                        }
                    }
                    i4++;
                }
                C2403c[] c2403cArr2 = new C2403c[8];
                c2403cArr2[0] = c2403c2;
                int i5 = 0;
                int i6 = 1;
                while (i5 < 3) {
                    int i7 = i << i5;
                    int i8 = 0;
                    while (i8 < i7) {
                        C2403c c2403c3 = c2403cArr2[i6 - i7];
                        C2403c c2403c4 = c2403cArr[i5];
                        C2403c c2403c5 = new C2403c();
                        c2403cArr2[i6] = c2403c5;
                        m10302r(false, c2403c3, c2403c4, c2403c5);
                        i8++;
                        i6++;
                    }
                    i5++;
                    i = 1;
                }
                for (int i9 = 0; i9 < 8; i9++) {
                    C2403c c2403c6 = c2403cArr2[i9];
                    int[] m9971h = xz0.m9971h();
                    int[] m9971h2 = xz0.m9971h();
                    int[] iArr3 = c2403c6.f8366c;
                    xz0.m9964a(iArr3, iArr3, m9971h);
                    xz0.m9977n(m9971h, m9971h2);
                    xz0.m9979p(c2403c6.f8364a, m9971h2, m9971h);
                    xz0.m9979p(c2403c6.f8365b, m9971h2, m9971h2);
                    C2404d c2404d = new C2404d();
                    xz0.m9966c(m9971h2, m9971h, c2404d.f8368a, c2404d.f8369b);
                    xz0.m9979p(m9971h, m9971h2, c2404d.f8370c);
                    int[] iArr4 = c2404d.f8370c;
                    xz0.m9979p(iArr4, f8356g, iArr4);
                    xz0.m9980q(c2404d.f8368a);
                    xz0.m9980q(c2404d.f8369b);
                    xz0.m9970g(c2404d.f8368a, 0, f8358i, i2);
                    int i10 = i2 + 10;
                    xz0.m9970g(c2404d.f8369b, 0, f8358i, i10);
                    int i11 = i10 + 10;
                    xz0.m9970g(c2404d.f8370c, 0, f8358i, i11);
                    i2 = i11 + 10;
                }
            }
        }
    }

    /* renamed from: D */
    public static void m10278D(byte[] bArr, int i, byte[] bArr2) {
        System.arraycopy(bArr, i, bArr2, 0, 32);
        bArr2[0] = (byte) (bArr2[0] & 248);
        bArr2[31] = (byte) (bArr2[31] & Byte.MAX_VALUE);
        bArr2[31] = (byte) (bArr2[31] | 64);
    }

    /* renamed from: E */
    public static byte[] m10279E(byte[] bArr) {
        long m10290f = m10290f(bArr, 49) & 4294967295L;
        long m10290f2 = m10290f(bArr, 56) & 4294967295L;
        long j = bArr[63] & 255;
        long m10289e = ((m10289e(bArr, 60) << 4) & 4294967295L) + (m10290f2 >> 28);
        long j2 = m10290f2 & 268435455;
        long m10290f3 = (m10290f(bArr, 28) & 4294967295L) - (m10289e * (-50998291));
        long m10289e2 = (((m10289e(bArr, 32) << 4) & 4294967295L) - (j * (-50998291))) - (m10289e * 19280294);
        long m10290f4 = ((m10290f(bArr, 42) & 4294967295L) - (j * (-6428113))) - (m10289e * 5343);
        long m10289e3 = ((((m10289e(bArr, 39) << 4) & 4294967295L) - (j * 127719000)) - (m10289e * (-6428113))) - (j2 * 5343);
        long m10289e4 = ((m10289e(bArr, 53) << 4) & 4294967295L) + (m10290f >> 28);
        long j3 = m10290f & 268435455;
        long m10290f5 = ((((m10290f(bArr, 35) & 4294967295L) - (j * 19280294)) - (m10289e * 127719000)) - (j2 * (-6428113))) - (m10289e4 * 5343);
        long m10289e5 = ((((m10289e(bArr, 25) << 4) & 4294967295L) - (j2 * (-50998291))) - (m10289e4 * 19280294)) - (j3 * 127719000);
        long j4 = ((m10289e2 - (j2 * 127719000)) - (m10289e4 * (-6428113))) - (j3 * 5343);
        long m10289e6 = (((m10289e(bArr, 46) << 4) & 4294967295L) - (j * 5343)) + (m10290f4 >> 28);
        long j5 = (m10290f4 & 268435455) + (m10289e3 >> 28);
        long m10289e7 = ((m10289e(bArr, 11) << 4) & 4294967295L) - (j5 * (-50998291));
        long m10290f6 = ((m10290f(bArr, 14) & 4294967295L) - (m10289e6 * (-50998291))) - (j5 * 19280294);
        long m10289e8 = ((((m10289e(bArr, 18) << 4) & 4294967295L) - (j3 * (-50998291))) - (m10289e6 * 19280294)) - (j5 * 127719000);
        long m10290f7 = ((((m10290f(bArr, 21) & 4294967295L) - (m10289e4 * (-50998291))) - (j3 * 19280294)) - (m10289e6 * 127719000)) - (j5 * (-6428113));
        long j6 = (m10289e5 - (m10289e6 * (-6428113))) - (j5 * 5343);
        long j7 = (m10289e3 & 268435455) + (m10290f5 >> 28);
        long j8 = m10290f5 & 268435455;
        long m10290f8 = (m10290f(bArr, 7) & 4294967295L) - (j7 * (-50998291));
        long j9 = m10289e7 - (j7 * 19280294);
        long j10 = m10290f6 - (j7 * 127719000);
        long j11 = m10289e8 - (j7 * (-6428113));
        long j12 = m10290f7 - (j7 * 5343);
        long j13 = j8 + (j4 >> 28);
        long j14 = j4 & 268435455;
        long m10289e9 = ((m10289e(bArr, 4) << 4) & 4294967295L) - (j13 * (-50998291));
        long j15 = m10290f8 - (j13 * 19280294);
        long j16 = j9 - (j13 * 127719000);
        long j17 = j10 - (j13 * (-6428113));
        long j18 = j11 - (j13 * 5343);
        long j19 = ((((m10290f3 - (j2 * 19280294)) - (m10289e4 * 127719000)) - (j3 * (-6428113))) - (m10289e6 * 5343)) + (j6 >> 28);
        long j20 = j19 & 268435455;
        long j21 = j20 >>> 27;
        long j22 = j14 + (j19 >> 28) + j21;
        long m10290f9 = (m10290f(bArr, 0) & 4294967295L) - (j22 * (-50998291));
        long j23 = (m10289e9 - (j22 * 19280294)) + (m10290f9 >> 28);
        long j24 = m10290f9 & 268435455;
        long j25 = (j15 - (j22 * 127719000)) + (j23 >> 28);
        long j26 = (j16 - (j22 * (-6428113))) + (j25 >> 28);
        long j27 = (j17 - (j22 * 5343)) + (j26 >> 28);
        long j28 = j18 + (j27 >> 28);
        long j29 = j27 & 268435455;
        long j30 = j12 + (j28 >> 28);
        long j31 = (j6 & 268435455) + (j30 >> 28);
        long j32 = j20 + (j31 >> 28);
        long j33 = (j32 >> 28) - j21;
        long j34 = j24 + (j33 & (-50998291));
        long j35 = (j23 & 268435455) + (j33 & 19280294) + (j34 >> 28);
        long j36 = (j25 & 268435455) + (j33 & 127719000) + (j35 >> 28);
        long j37 = (j26 & 268435455) + (j33 & (-6428113)) + (j36 >> 28);
        long j38 = j29 + (j33 & 5343) + (j37 >> 28);
        long j39 = (j28 & 268435455) + (j38 >> 28);
        long j40 = (j30 & 268435455) + (j39 >> 28);
        long j41 = (j31 & 268435455) + (j40 >> 28);
        byte[] bArr2 = new byte[32];
        m10296l((j34 & 268435455) | ((j35 & 268435455) << 28), bArr2, 0);
        m10296l(((j37 & 268435455) << 28) | (j36 & 268435455), bArr2, 7);
        m10296l((j38 & 268435455) | ((j39 & 268435455) << 28), bArr2, 14);
        m10296l((j40 & 268435455) | ((j41 & 268435455) << 28), bArr2, 21);
        m10295k((int) ((j32 & 268435455) + (j41 >> 28)), bArr2, 28);
        return bArr2;
    }

    /* renamed from: F */
    public static void m10280F(byte[] bArr, C2402b c2402b) {
        m10277C();
        m10275A(c2402b);
        int[] iArr = new int[8];
        m10292h(bArr, 0, iArr);
        p01.m7197h(8, (~iArr[0]) & 1, iArr, f8351b, iArr);
        p01.m7171B(8, iArr, 1);
        for (int i = 0; i < 8; i++) {
            iArr[i] = d01.m3088d(iArr[i]);
        }
        C2404d c2404d = new C2404d();
        int i2 = 28;
        while (true) {
            for (int i3 = 0; i3 < 8; i3++) {
                int i4 = iArr[i3] >>> i2;
                int i5 = (i4 >>> 3) & 1;
                m10309y(i3, (i4 ^ (-i5)) & 7, c2404d);
                xz0.m9973j(i5, c2404d.f8368a, c2404d.f8369b);
                xz0.m9969f(i5, c2404d.f8370c);
                m10301q(c2404d, c2402b);
            }
            i2 -= 4;
            if (i2 < 0) {
                return;
            } else {
                m10306v(c2402b);
            }
        }
    }

    /* renamed from: G */
    public static void m10281G(byte[] bArr, byte[] bArr2, int i) {
        C2402b c2402b = new C2402b();
        m10280F(bArr, c2402b);
        if (m10297m(c2402b, bArr2, i) == 0) {
            throw new IllegalStateException();
        }
    }

    /* renamed from: H */
    public static void m10282H(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3, int i4, byte[] bArr4, int i5) {
        m10300p(bArr, i, bArr2, i2, null, (byte) 0, bArr3, i3, i4, bArr4, i5);
    }

    /* renamed from: I */
    public static void m10283I(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        m10300p(bArr, i, bArr2, i2, bArr3, (byte) 0, bArr4, i3, i4, bArr5, i5);
    }

    /* renamed from: J */
    public static void m10284J(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4, int i3, byte[] bArr5, int i4) {
        m10300p(bArr, i, bArr2, i2, bArr3, (byte) 1, bArr4, i3, 64, bArr5, i4);
    }

    /* renamed from: a */
    public static byte[] m10285a(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int[] iArr = new int[16];
        m10292h(bArr, 0, iArr);
        int[] iArr2 = new int[8];
        m10292h(bArr2, 0, iArr2);
        int[] iArr3 = new int[8];
        m10292h(bArr3, 0, iArr3);
        j01.m4997C(iArr2, iArr3, iArr);
        byte[] bArr4 = new byte[64];
        for (int i = 0; i < 16; i++) {
            m10295k(iArr[i], bArr4, i * 4);
        }
        return m10279E(bArr4);
    }

    /* renamed from: b */
    public static boolean m10286b(byte[] bArr, byte b) {
        return (bArr == null && b == 0) || (bArr != null && bArr.length < 256);
    }

    /* renamed from: c */
    public static int m10287c(int[] iArr, int[] iArr2) {
        int[] m9971h = xz0.m9971h();
        int[] m9971h2 = xz0.m9971h();
        int[] m9971h3 = xz0.m9971h();
        xz0.m9985v(iArr, m9971h2);
        xz0.m9985v(iArr2, m9971h3);
        xz0.m9979p(m9971h2, m9971h3, m9971h);
        xz0.m9986w(m9971h3, m9971h2, m9971h3);
        xz0.m9979p(m9971h, f8354e, m9971h);
        xz0.m9965b(m9971h);
        xz0.m9986w(m9971h, m9971h3, m9971h);
        xz0.m9980q(m9971h);
        return xz0.m9978o(m9971h);
    }

    /* renamed from: d */
    public static Digest m10288d() {
        return new st0();
    }

    /* renamed from: e */
    public static int m10289e(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = i + 1;
        return ((bArr[i3 + 1] & 255) << 16) | i2 | ((bArr[i3] & 255) << 8);
    }

    /* renamed from: f */
    public static int m10290f(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = i + 1;
        int i4 = i2 | ((bArr[i3] & 255) << 8);
        int i5 = i3 + 1;
        return (bArr[i5 + 1] << 24) | i4 | ((bArr[i5] & 255) << 16);
    }

    /* renamed from: g */
    public static void m10291g(byte[] bArr, int i, int[] iArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            iArr[i2 + i4] = m10290f(bArr, (i4 * 4) + i);
        }
    }

    /* renamed from: h */
    public static void m10292h(byte[] bArr, int i, int[] iArr) {
        m10291g(bArr, i, iArr, 0, 8);
    }

    /* renamed from: i */
    public static void m10293i(Digest digest, byte b, byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = f8350a;
            digest.mo6293a(bArr2, 0, bArr2.length);
            digest.mo6294c(b);
            digest.mo6294c((byte) bArr.length);
            digest.mo6293a(bArr, 0, bArr.length);
        }
    }

    /* renamed from: j */
    public static void m10294j(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        bArr[i3 + 1] = (byte) (i >>> 16);
    }

    /* renamed from: k */
    public static void m10295k(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        int i3 = i2 + 1;
        bArr[i3] = (byte) (i >>> 8);
        int i4 = i3 + 1;
        bArr[i4] = (byte) (i >>> 16);
        bArr[i4 + 1] = (byte) (i >>> 24);
    }

    /* renamed from: l */
    public static void m10296l(long j, byte[] bArr, int i) {
        m10295k((int) j, bArr, i);
        m10294j((int) (j >>> 32), bArr, i + 4);
    }

    /* renamed from: m */
    public static int m10297m(C2402b c2402b, byte[] bArr, int i) {
        int[] m9971h = xz0.m9971h();
        int[] m9971h2 = xz0.m9971h();
        xz0.m9977n(c2402b.f8361c, m9971h2);
        xz0.m9979p(c2402b.f8359a, m9971h2, m9971h);
        xz0.m9979p(c2402b.f8360b, m9971h2, m9971h2);
        xz0.m9980q(m9971h);
        xz0.m9980q(m9971h2);
        int m10287c = m10287c(m9971h, m9971h2);
        xz0.m9974k(m9971h2, bArr, i);
        int i2 = (i + 32) - 1;
        bArr[i2] = (byte) (((m9971h[0] & 1) << 7) | bArr[i2]);
        return m10287c;
    }

    /* renamed from: n */
    public static void m10298n(byte[] bArr, int i, byte[] bArr2, int i2) {
        Digest m10288d = m10288d();
        byte[] bArr3 = new byte[m10288d.mo6519f()];
        m10288d.mo6293a(bArr, i, 32);
        m10288d.mo7096b(bArr3, 0);
        byte[] bArr4 = new byte[32];
        m10278D(bArr3, 0, bArr4);
        m10281G(bArr4, bArr2, i2);
    }

    /* renamed from: o */
    public static void m10299o(Digest digest, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, byte[] bArr4, byte b, byte[] bArr5, int i2, int i3, byte[] bArr6, int i4) {
        m10293i(digest, b, bArr4);
        digest.mo6293a(bArr, 32, 32);
        digest.mo6293a(bArr5, i2, i3);
        digest.mo7096b(bArr, 0);
        byte[] m10279E = m10279E(bArr);
        byte[] bArr7 = new byte[32];
        m10281G(m10279E, bArr7, 0);
        m10293i(digest, b, bArr4);
        digest.mo6293a(bArr7, 0, 32);
        digest.mo6293a(bArr3, i, 32);
        digest.mo6293a(bArr5, i2, i3);
        digest.mo7096b(bArr, 0);
        byte[] m10285a = m10285a(m10279E, m10279E(bArr), bArr2);
        System.arraycopy(bArr7, 0, bArr6, i4, 32);
        System.arraycopy(m10285a, 0, bArr6, i4 + 32, 32);
    }

    /* renamed from: p */
    public static void m10300p(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, byte b, byte[] bArr4, int i3, int i4, byte[] bArr5, int i5) {
        if (!m10286b(bArr3, b)) {
            throw new IllegalArgumentException("ctx");
        }
        Digest m10288d = m10288d();
        byte[] bArr6 = new byte[m10288d.mo6519f()];
        m10288d.mo6293a(bArr, i, 32);
        m10288d.mo7096b(bArr6, 0);
        byte[] bArr7 = new byte[32];
        m10278D(bArr6, 0, bArr7);
        m10299o(m10288d, bArr6, bArr7, bArr2, i2, bArr3, b, bArr4, i3, i4, bArr5, i5);
    }

    /* renamed from: q */
    public static void m10301q(C2404d c2404d, C2402b c2402b) {
        int[] m9971h = xz0.m9971h();
        int[] m9971h2 = xz0.m9971h();
        int[] m9971h3 = xz0.m9971h();
        int[] iArr = c2402b.f8362d;
        int[] m9971h4 = xz0.m9971h();
        int[] m9971h5 = xz0.m9971h();
        int[] iArr2 = c2402b.f8363e;
        xz0.m9966c(c2402b.f8360b, c2402b.f8359a, m9971h2, m9971h);
        xz0.m9979p(m9971h, c2404d.f8369b, m9971h);
        xz0.m9979p(m9971h2, c2404d.f8368a, m9971h2);
        xz0.m9979p(c2402b.f8362d, c2402b.f8363e, m9971h3);
        xz0.m9979p(m9971h3, c2404d.f8370c, m9971h3);
        xz0.m9966c(m9971h2, m9971h, iArr2, iArr);
        xz0.m9966c(c2402b.f8361c, m9971h3, m9971h5, m9971h4);
        xz0.m9967d(m9971h5);
        xz0.m9979p(iArr, m9971h4, c2402b.f8359a);
        xz0.m9979p(m9971h5, iArr2, c2402b.f8360b);
        xz0.m9979p(m9971h4, m9971h5, c2402b.f8361c);
    }

    /* renamed from: r */
    public static void m10302r(boolean z, C2403c c2403c, C2403c c2403c2, C2403c c2403c3) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        int[] iArr4;
        int[] m9971h = xz0.m9971h();
        int[] m9971h2 = xz0.m9971h();
        int[] m9971h3 = xz0.m9971h();
        int[] m9971h4 = xz0.m9971h();
        int[] m9971h5 = xz0.m9971h();
        int[] m9971h6 = xz0.m9971h();
        int[] m9971h7 = xz0.m9971h();
        int[] m9971h8 = xz0.m9971h();
        if (z) {
            iArr2 = m9971h3;
            iArr = m9971h4;
            iArr4 = m9971h6;
            iArr3 = m9971h7;
        } else {
            iArr = m9971h3;
            iArr2 = m9971h4;
            iArr3 = m9971h6;
            iArr4 = m9971h7;
        }
        xz0.m9966c(c2403c.f8365b, c2403c.f8364a, m9971h2, m9971h);
        xz0.m9966c(c2403c2.f8365b, c2403c2.f8364a, iArr2, iArr);
        xz0.m9979p(m9971h, m9971h3, m9971h);
        xz0.m9979p(m9971h2, m9971h4, m9971h2);
        xz0.m9979p(c2403c.f8367d, c2403c2.f8367d, m9971h3);
        xz0.m9979p(m9971h3, f8355f, m9971h3);
        xz0.m9979p(c2403c.f8366c, c2403c2.f8366c, m9971h4);
        xz0.m9964a(m9971h4, m9971h4, m9971h4);
        xz0.m9966c(m9971h2, m9971h, m9971h8, m9971h5);
        xz0.m9966c(m9971h4, m9971h3, iArr4, iArr3);
        xz0.m9967d(iArr4);
        xz0.m9979p(m9971h5, m9971h6, c2403c3.f8364a);
        xz0.m9979p(m9971h7, m9971h8, c2403c3.f8365b);
        xz0.m9979p(m9971h6, m9971h7, c2403c3.f8366c);
        xz0.m9979p(m9971h5, m9971h8, c2403c3.f8367d);
    }

    /* renamed from: s */
    public static C2403c m10303s(C2402b c2402b) {
        C2403c c2403c = new C2403c();
        xz0.m9970g(c2402b.f8359a, 0, c2403c.f8364a, 0);
        xz0.m9970g(c2402b.f8360b, 0, c2403c.f8365b, 0);
        xz0.m9970g(c2402b.f8361c, 0, c2403c.f8366c, 0);
        xz0.m9979p(c2402b.f8362d, c2402b.f8363e, c2403c.f8367d);
        return c2403c;
    }

    /* renamed from: t */
    public static C2403c m10304t(C2403c c2403c) {
        C2403c c2403c2 = new C2403c();
        m10305u(c2403c, c2403c2);
        return c2403c2;
    }

    /* renamed from: u */
    public static void m10305u(C2403c c2403c, C2403c c2403c2) {
        xz0.m9970g(c2403c.f8364a, 0, c2403c2.f8364a, 0);
        xz0.m9970g(c2403c.f8365b, 0, c2403c2.f8365b, 0);
        xz0.m9970g(c2403c.f8366c, 0, c2403c2.f8366c, 0);
        xz0.m9970g(c2403c.f8367d, 0, c2403c2.f8367d, 0);
    }

    /* renamed from: v */
    public static void m10306v(C2402b c2402b) {
        int[] m9971h = xz0.m9971h();
        int[] m9971h2 = xz0.m9971h();
        int[] m9971h3 = xz0.m9971h();
        int[] iArr = c2402b.f8362d;
        int[] m9971h4 = xz0.m9971h();
        int[] m9971h5 = xz0.m9971h();
        int[] iArr2 = c2402b.f8363e;
        xz0.m9985v(c2402b.f8359a, m9971h);
        xz0.m9985v(c2402b.f8360b, m9971h2);
        xz0.m9985v(c2402b.f8361c, m9971h3);
        xz0.m9964a(m9971h3, m9971h3, m9971h3);
        xz0.m9966c(m9971h, m9971h2, iArr2, m9971h5);
        xz0.m9964a(c2402b.f8359a, c2402b.f8360b, iArr);
        xz0.m9985v(iArr, iArr);
        xz0.m9986w(iArr2, iArr, iArr);
        xz0.m9964a(m9971h3, m9971h5, m9971h4);
        xz0.m9967d(m9971h4);
        xz0.m9979p(iArr, m9971h4, c2402b.f8359a);
        xz0.m9979p(m9971h5, iArr2, c2402b.f8360b);
        xz0.m9979p(m9971h4, m9971h5, c2402b.f8361c);
    }

    /* renamed from: w */
    public static void m10307w(C2402b c2402b) {
        xz0.m9981r(c2402b.f8361c);
        xz0.m9970g(c2402b.f8359a, 0, c2402b.f8362d, 0);
        xz0.m9970g(c2402b.f8360b, 0, c2402b.f8363e, 0);
    }

    /* renamed from: x */
    public static void m10308x(C2403c c2403c) {
        xz0.m9981r(c2403c.f8366c);
        xz0.m9979p(c2403c.f8364a, c2403c.f8365b, c2403c.f8367d);
    }

    /* renamed from: y */
    public static void m10309y(int i, int i2, C2404d c2404d) {
        int i3 = i * 8 * 3 * 10;
        for (int i4 = 0; i4 < 8; i4++) {
            int i5 = ((i4 ^ i2) - 1) >> 31;
            xz0.m9968e(i5, f8358i, i3, c2404d.f8368a, 0);
            int i6 = i3 + 10;
            xz0.m9968e(i5, f8358i, i6, c2404d.f8369b, 0);
            int i7 = i6 + 10;
            xz0.m9968e(i5, f8358i, i7, c2404d.f8370c, 0);
            i3 = i7 + 10;
        }
    }

    /* renamed from: z */
    public static C2403c[] m10310z(C2403c c2403c, int i) {
        C2403c c2403c2 = new C2403c();
        m10302r(false, c2403c, c2403c, c2403c2);
        C2403c[] c2403cArr = new C2403c[i];
        c2403cArr[0] = m10304t(c2403c);
        for (int i2 = 1; i2 < i; i2++) {
            C2403c c2403c3 = c2403cArr[i2 - 1];
            C2403c c2403c4 = new C2403c();
            c2403cArr[i2] = c2403c4;
            m10302r(false, c2403c3, c2403c2, c2403c4);
        }
        return c2403cArr;
    }
}
