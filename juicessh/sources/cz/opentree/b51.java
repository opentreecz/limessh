package cz.opentree;

import com.google.android.material.badge.BadgeDrawable;

/* loaded from: classes.dex */
public class b51 {

    /* renamed from: a */
    public u41 f1610a;

    /* renamed from: b */
    public int f1611b;

    /* renamed from: c */
    public int[] f1612c;

    public b51(b51 b51Var) {
        this.f1610a = b51Var.f1610a;
        this.f1611b = b51Var.f1611b;
        this.f1612c = w41.m9408a(b51Var.f1612c);
    }

    public b51(u41 u41Var, int i) {
        this.f1610a = u41Var;
        this.f1611b = i;
        int[] iArr = new int[i + 1];
        this.f1612c = iArr;
        iArr[i] = 1;
    }

    public b51(u41 u41Var, byte[] bArr) {
        this.f1610a = u41Var;
        int i = 8;
        int i2 = 1;
        while (u41Var.m8847d() > i) {
            i2++;
            i += 8;
        }
        if (bArr.length % i2 != 0) {
            throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
        }
        this.f1612c = new int[bArr.length / i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr = this.f1612c;
            if (i3 >= iArr.length) {
                if (iArr.length != 1 && iArr[iArr.length - 1] == 0) {
                    throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
                }
                m2381d();
                return;
            }
            int i5 = 0;
            while (i5 < i) {
                int[] iArr2 = this.f1612c;
                iArr2[i3] = ((bArr[i4] & 255) << i5) ^ iArr2[i3];
                i5 += 8;
                i4++;
            }
            if (!this.f1610a.m8850g(this.f1612c[i3])) {
                throw new IllegalArgumentException(" Error: byte array is not encoded polynomial over given finite field GF2m");
            }
            i3++;
        }
    }

    public b51(u41 u41Var, int[] iArr) {
        this.f1610a = u41Var;
        this.f1612c = m2378q(iArr);
        m2381d();
    }

    /* renamed from: c */
    public static int m2374c(int[] iArr) {
        int length = iArr.length - 1;
        while (length >= 0 && iArr[length] == 0) {
            length--;
        }
        return length;
    }

    /* renamed from: i */
    public static int m2375i(int[] iArr) {
        int m2374c = m2374c(iArr);
        if (m2374c == -1) {
            return 0;
        }
        return iArr[m2374c];
    }

    /* renamed from: j */
    public static boolean m2376j(int[] iArr, int[] iArr2) {
        int m2374c = m2374c(iArr);
        if (m2374c != m2374c(iArr2)) {
            return false;
        }
        for (int i = 0; i <= m2374c; i++) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    public static int[] m2377p(int[] iArr, int i) {
        int m2374c = m2374c(iArr);
        if (m2374c == -1) {
            return new int[1];
        }
        int[] iArr2 = new int[m2374c + i + 1];
        System.arraycopy(iArr, 0, iArr2, i, m2374c + 1);
        return iArr2;
    }

    /* renamed from: q */
    public static int[] m2378q(int[] iArr) {
        int m2374c = m2374c(iArr);
        if (m2374c == -1) {
            return new int[1];
        }
        int i = m2374c + 1;
        if (iArr.length == i) {
            return w41.m9408a(iArr);
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    /* renamed from: a */
    public final int[] m2379a(int[] iArr, int[] iArr2) {
        int[] iArr3;
        if (iArr.length < iArr2.length) {
            iArr3 = new int[iArr2.length];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
        } else {
            iArr3 = new int[iArr.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            iArr = iArr2;
        }
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr3[length] = this.f1610a.m8844a(iArr3[length], iArr[length]);
        }
        return iArr3;
    }

    /* renamed from: b */
    public void m2380b(b51 b51Var) {
        this.f1612c = m2379a(this.f1612c, b51Var.f1612c);
        m2381d();
    }

    /* renamed from: d */
    public final void m2381d() {
        int length = this.f1612c.length;
        do {
            this.f1611b = length - 1;
            length = this.f1611b;
            if (length < 0) {
                return;
            }
        } while (this.f1612c[length] == 0);
    }

    /* renamed from: e */
    public int m2382e(int i) {
        int[] iArr = this.f1612c;
        int i2 = this.f1611b;
        int i3 = iArr[i2];
        for (int i4 = i2 - 1; i4 >= 0; i4--) {
            i3 = this.f1610a.m8851h(i3, i) ^ this.f1612c[i4];
        }
        return i3;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof b51)) {
            b51 b51Var = (b51) obj;
            if (this.f1610a.equals(b51Var.f1610a) && this.f1611b == b51Var.f1611b && m2376j(this.f1612c, b51Var.f1612c)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public int m2383f(int i) {
        if (i < 0 || i > this.f1611b) {
            return 0;
        }
        return this.f1612c[i];
    }

    /* renamed from: g */
    public int m2384g() {
        int[] iArr = this.f1612c;
        int length = iArr.length - 1;
        if (iArr[length] == 0) {
            return -1;
        }
        return length;
    }

    /* renamed from: h */
    public byte[] m2385h() {
        int i = 8;
        int i2 = 1;
        while (this.f1610a.m8847d() > i) {
            i2++;
            i += 8;
        }
        byte[] bArr = new byte[this.f1612c.length * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1612c.length; i4++) {
            int i5 = 0;
            while (i5 < i) {
                bArr[i3] = (byte) (this.f1612c[i4] >>> i5);
                i5 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public int hashCode() {
        int hashCode = this.f1610a.hashCode();
        int i = 0;
        while (true) {
            int[] iArr = this.f1612c;
            if (i >= iArr.length) {
                return hashCode;
            }
            hashCode = (hashCode * 31) + iArr[i];
            i++;
        }
    }

    /* renamed from: k */
    public b51 m2386k(b51 b51Var) {
        return new b51(this.f1610a, m2387l(this.f1612c, b51Var.f1612c));
    }

    /* renamed from: l */
    public final int[] m2387l(int[] iArr, int[] iArr2) {
        int m2374c = m2374c(iArr2);
        if (m2374c == -1) {
            throw new ArithmeticException("Division by zero");
        }
        int length = iArr.length;
        int[] iArr3 = new int[length];
        int m8849f = this.f1610a.m8849f(m2375i(iArr2));
        System.arraycopy(iArr, 0, iArr3, 0, length);
        while (m2374c <= m2374c(iArr3)) {
            iArr3 = m2379a(m2390o(m2377p(iArr2, m2374c(iArr3) - m2374c), this.f1610a.m8851h(m2375i(iArr3), m8849f)), iArr3);
        }
        return iArr3;
    }

    /* renamed from: m */
    public void m2388m(int i) {
        if (!this.f1610a.m8850g(i)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        this.f1612c = m2390o(this.f1612c, i);
        m2381d();
    }

    /* renamed from: n */
    public b51 m2389n(int i) {
        if (!this.f1610a.m8850g(i)) {
            throw new ArithmeticException("Not an element of the finite field this polynomial is defined over.");
        }
        return new b51(this.f1610a, m2390o(this.f1612c, i));
    }

    /* renamed from: o */
    public final int[] m2390o(int[] iArr, int i) {
        int m2374c = m2374c(iArr);
        if (m2374c == -1 || i == 0) {
            return new int[1];
        }
        if (i == 1) {
            return w41.m9408a(iArr);
        }
        int[] iArr2 = new int[m2374c + 1];
        while (m2374c >= 0) {
            iArr2[m2374c] = this.f1610a.m8851h(iArr[m2374c], i);
            m2374c--;
        }
        return iArr2;
    }

    public String toString() {
        String str = " Polynomial over " + this.f1610a.toString() + ": \n";
        for (int i = 0; i < this.f1612c.length; i++) {
            str = str + this.f1610a.m8845b(this.f1612c[i]) + "Y^" + i + BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX;
        }
        return str + ";";
    }
}
