package cz.opentree;

/* loaded from: classes.dex */
public final class c51 {
    /* renamed from: a */
    public static int m2670a(int i) {
        int i2 = -1;
        while (i != 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    /* renamed from: b */
    public static int m2671b(int i, int i2) {
        while (true) {
            int i3 = i2;
            int i4 = i;
            i = i3;
            if (i == 0) {
                return i4;
            }
            i2 = m2674e(i4, i);
        }
    }

    /* renamed from: c */
    public static boolean m2672c(int i) {
        if (i == 0) {
            return false;
        }
        int m2670a = m2670a(i) >>> 1;
        int i2 = 2;
        for (int i3 = 0; i3 < m2670a; i3++) {
            i2 = m2673d(i2, i2, i);
            if (m2671b(i2 ^ 2, i) != 1) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    public static int m2673d(int i, int i2, int i3) {
        int m2674e = m2674e(i, i3);
        int m2674e2 = m2674e(i2, i3);
        int i4 = 0;
        if (m2674e2 != 0) {
            int m2670a = 1 << m2670a(i3);
            while (m2674e != 0) {
                if (((byte) (m2674e & 1)) == 1) {
                    i4 ^= m2674e2;
                }
                m2674e >>>= 1;
                m2674e2 <<= 1;
                if (m2674e2 >= m2670a) {
                    m2674e2 ^= i3;
                }
            }
        }
        return i4;
    }

    /* renamed from: e */
    public static int m2674e(int i, int i2) {
        if (i2 == 0) {
            System.err.println("Error: to be divided by 0");
            return 0;
        }
        while (m2670a(i) >= m2670a(i2)) {
            i ^= i2 << (m2670a(i) - m2670a(i2));
        }
        return i;
    }
}
