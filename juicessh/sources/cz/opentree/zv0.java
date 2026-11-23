package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public class zv0 {

    /* renamed from: a */
    public static final int[] f8598a = {-1, -1, -1, -3};

    /* renamed from: b */
    public static final int[] f8599b = {1, 0, 0, 4, -2, -1, 3, -4};

    /* renamed from: c */
    public static final int[] f8600c = {-1, -1, -1, -5, 1, 0, -4, 3};

    /* renamed from: a */
    public static void m10633a(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f01.m3625a(iArr, iArr2, iArr3) != 0 || ((iArr3[3] >>> 1) >= 2147483646 && f01.m3638n(iArr3, f8598a))) {
            m10635c(iArr3);
        }
    }

    /* renamed from: b */
    public static void m10634b(int[] iArr, int[] iArr2) {
        if (p01.m7210u(4, iArr, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && f01.m3638n(iArr2, f8598a))) {
            m10635c(iArr2);
        }
    }

    /* renamed from: c */
    public static void m10635c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + (4294967295L & iArr[3]) + 2);
    }

    /* renamed from: d */
    public static int[] m10636d(BigInteger bigInteger) {
        int[] m3636l = f01.m3636l(bigInteger);
        if ((m3636l[3] >>> 1) >= 2147483646) {
            int[] iArr = f8598a;
            if (f01.m3638n(m3636l, iArr)) {
                f01.m3647w(iArr, m3636l);
            }
        }
        return m3636l;
    }

    /* renamed from: e */
    public static void m10637e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m3632h = f01.m3632h();
        f01.m3643s(iArr, iArr2, m3632h);
        m10640h(m3632h, iArr3);
    }

    /* renamed from: f */
    public static void m10638f(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f01.m3644t(iArr, iArr2, iArr3) != 0 || ((iArr3[7] >>> 1) >= 2147483646 && j01.m5025s(iArr3, f8599b))) {
            int[] iArr4 = f8600c;
            p01.m7194e(iArr4.length, iArr4, iArr3);
        }
    }

    /* renamed from: g */
    public static void m10639g(int[] iArr, int[] iArr2) {
        if (f01.m3641q(iArr)) {
            f01.m3650z(iArr2);
        } else {
            f01.m3646v(f8598a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m10640h(int[] iArr, int[] iArr2) {
        long j = iArr[7] & 4294967295L;
        long j2 = (iArr[3] & 4294967295L) + j;
        long j3 = (iArr[6] & 4294967295L) + (j << 1);
        long j4 = (iArr[2] & 4294967295L) + j3;
        long j5 = (iArr[5] & 4294967295L) + (j3 << 1);
        long j6 = (iArr[1] & 4294967295L) + j5;
        long j7 = (iArr[4] & 4294967295L) + (j5 << 1);
        long j8 = (iArr[0] & 4294967295L) + j7;
        iArr2[0] = (int) j8;
        long j9 = j6 + (j8 >>> 32);
        iArr2[1] = (int) j9;
        long j10 = j4 + (j9 >>> 32);
        iArr2[2] = (int) j10;
        long j11 = j2 + (j7 << 1) + (j10 >>> 32);
        iArr2[3] = (int) j11;
        m10641i((int) (j11 >>> 32), iArr2);
    }

    /* renamed from: i */
    public static void m10641i(int i, int[] iArr) {
        while (i != 0) {
            long j = i & 4294967295L;
            long j2 = (iArr[0] & 4294967295L) + j;
            iArr[0] = (int) j2;
            long j3 = j2 >> 32;
            if (j3 != 0) {
                long j4 = j3 + (iArr[1] & 4294967295L);
                iArr[1] = (int) j4;
                long j5 = (j4 >> 32) + (iArr[2] & 4294967295L);
                iArr[2] = (int) j5;
                j3 = j5 >> 32;
            }
            long j6 = j3 + (4294967295L & iArr[3]) + (j << 1);
            iArr[3] = (int) j6;
            i = (int) (j6 >> 32);
        }
        if ((iArr[3] >>> 1) < 2147483646 || !f01.m3638n(iArr, f8598a)) {
            return;
        }
        m10635c(iArr);
    }

    /* renamed from: j */
    public static void m10642j(int[] iArr, int[] iArr2) {
        int[] m3632h = f01.m3632h();
        f01.m3645u(iArr, m3632h);
        m10640h(m3632h, iArr2);
    }

    /* renamed from: k */
    public static void m10643k(int[] iArr, int i, int[] iArr2) {
        int[] m3632h = f01.m3632h();
        f01.m3645u(iArr, m3632h);
        while (true) {
            m10640h(m3632h, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                f01.m3645u(iArr2, m3632h);
            }
        }
    }

    /* renamed from: l */
    public static void m10644l(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 1;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            long j3 = j2 + (iArr[1] & 4294967295L);
            iArr[1] = (int) j3;
            long j4 = (j3 >> 32) + (iArr[2] & 4294967295L);
            iArr[2] = (int) j4;
            j2 = j4 >> 32;
        }
        iArr[3] = (int) (j2 + ((4294967295L & iArr[3]) - 2));
    }

    /* renamed from: m */
    public static void m10645m(int[] iArr, int[] iArr2, int[] iArr3) {
        if (f01.m3646v(iArr, iArr2, iArr3) != 0) {
            m10644l(iArr3);
        }
    }

    /* renamed from: n */
    public static void m10646n(int[] iArr, int[] iArr2) {
        if (p01.m7176G(4, iArr, 0, iArr2) != 0 || ((iArr2[3] >>> 1) >= 2147483646 && f01.m3638n(iArr2, f8598a))) {
            m10635c(iArr2);
        }
    }
}
