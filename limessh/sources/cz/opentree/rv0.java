package cz.opentree;

import androidx.appcompat.widget.ActivityChooserView;
import java.math.BigInteger;

/* loaded from: classes.dex */
public class rv0 {

    /* renamed from: a */
    public static final int[] f6293a = {-19, -1, -1, -1, -1, -1, -1, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED};

    /* renamed from: b */
    public static final int[] f6294b = {361, 0, 0, 0, 0, 0, 0, 0, -19, -1, -1, -1, -1, -1, -1, 1073741823};

    /* renamed from: a */
    public static void m8243a(int[] iArr, int[] iArr2, int[] iArr3) {
        j01.m5007a(iArr, iArr2, iArr3);
        if (j01.m5025s(iArr3, f6293a)) {
            m8255m(iArr3);
        }
    }

    /* renamed from: b */
    public static void m8244b(int[] iArr, int[] iArr2) {
        p01.m7210u(8, iArr, iArr2);
        if (j01.m5025s(iArr2, f6293a)) {
            m8255m(iArr2);
        }
    }

    /* renamed from: c */
    public static int m8245c(int[] iArr) {
        long j = (iArr[0] & 4294967295L) - 19;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            j2 = p01.m7203n(7, iArr, 1);
        }
        long j3 = j2 + (4294967295L & iArr[7]) + 2147483648L;
        iArr[7] = (int) j3;
        return (int) (j3 >> 32);
    }

    /* renamed from: d */
    public static int[] m8246d(BigInteger bigInteger) {
        int[] m5022p = j01.m5022p(bigInteger);
        while (true) {
            int[] iArr = f6293a;
            if (!j01.m5025s(m5022p, iArr)) {
                return m5022p;
            }
            j01.m5003I(iArr, m5022p);
        }
    }

    /* renamed from: e */
    public static void m8247e(int[] iArr, int[] iArr2, int[] iArr3) {
        int[] m5017k = j01.m5017k();
        j01.m5031y(iArr, iArr2, m5017k);
        m8250h(m5017k, iArr3);
    }

    /* renamed from: f */
    public static void m8248f(int[] iArr, int[] iArr2, int[] iArr3) {
        j01.m4997C(iArr, iArr2, iArr3);
        if (p01.m7208s(16, iArr3, f6294b)) {
            m8254l(iArr3);
        }
    }

    /* renamed from: g */
    public static void m8249g(int[] iArr, int[] iArr2) {
        if (j01.m5028v(iArr)) {
            j01.m5006L(iArr2);
        } else {
            j01.m5002H(f6293a, iArr, iArr2);
        }
    }

    /* renamed from: h */
    public static void m8250h(int[] iArr, int[] iArr2) {
        int i = iArr[7];
        p01.m7175F(8, iArr, 8, i, iArr2, 0);
        int m4998D = j01.m4998D(19, iArr, iArr2) << 1;
        int i2 = iArr2[7];
        iArr2[7] = (i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + p01.m7196g(7, (m4998D + ((i2 >>> 31) - (i >>> 31))) * 19, iArr2);
        if (j01.m5025s(iArr2, f6293a)) {
            m8255m(iArr2);
        }
    }

    /* renamed from: i */
    public static void m8251i(int i, int[] iArr) {
        int i2 = iArr[7];
        iArr[7] = (i2 & ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED) + p01.m7196g(7, ((i << 1) | (i2 >>> 31)) * 19, iArr);
        if (j01.m5025s(iArr, f6293a)) {
            m8255m(iArr);
        }
    }

    /* renamed from: j */
    public static void m8252j(int[] iArr, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        m8250h(m5017k, iArr2);
    }

    /* renamed from: k */
    public static void m8253k(int[] iArr, int i, int[] iArr2) {
        int[] m5017k = j01.m5017k();
        j01.m5000F(iArr, m5017k);
        while (true) {
            m8250h(m5017k, iArr2);
            i--;
            if (i <= 0) {
                return;
            } else {
                j01.m5000F(iArr2, m5017k);
            }
        }
    }

    /* renamed from: l */
    public static int m8254l(int[] iArr) {
        int[] iArr2 = f6294b;
        long j = (iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L);
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            j2 = p01.m7203n(8, iArr, 1);
        }
        long j3 = j2 + (iArr[8] & 4294967295L) + 19;
        iArr[8] = (int) j3;
        long j4 = j3 >> 32;
        if (j4 != 0) {
            j4 = p01.m7211v(15, iArr, 9);
        }
        long j5 = j4 + ((iArr[15] & 4294967295L) - (4294967295L & (iArr2[15] + 1)));
        iArr[15] = (int) j5;
        return (int) (j5 >> 32);
    }

    /* renamed from: m */
    public static int m8255m(int[] iArr) {
        long j = (iArr[0] & 4294967295L) + 19;
        iArr[0] = (int) j;
        long j2 = j >> 32;
        if (j2 != 0) {
            j2 = p01.m7211v(7, iArr, 1);
        }
        long j3 = j2 + ((4294967295L & iArr[7]) - 2147483648L);
        iArr[7] = (int) j3;
        return (int) (j3 >> 32);
    }

    /* renamed from: n */
    public static void m8256n(int[] iArr, int[] iArr2, int[] iArr3) {
        if (j01.m5002H(iArr, iArr2, iArr3) != 0) {
            m8245c(iArr3);
        }
    }

    /* renamed from: o */
    public static void m8257o(int[] iArr, int[] iArr2) {
        p01.m7176G(8, iArr, 0, iArr2);
        if (j01.m5025s(iArr2, f6293a)) {
            m8255m(iArr2);
        }
    }
}
