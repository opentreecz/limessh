package cz.opentree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e51 {

    /* renamed from: cz.opentree.e51$a */
    /* loaded from: classes.dex */
    public static class C0912a<T> implements Iterator<T> {

        /* renamed from: O */
        public final T[] f2339O;

        /* renamed from: P */
        public int f2340P = 0;

        public C0912a(T[] tArr) {
            this.f2339O = tArr;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2340P < this.f2339O.length;
        }

        @Override // java.util.Iterator
        public T next() {
            int i = this.f2340P;
            T[] tArr = this.f2339O;
            if (i != tArr.length) {
                this.f2340P = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException("Out of elements: " + this.f2340P);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }

    /* renamed from: a */
    public static boolean m3432a(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    /* renamed from: b */
    public static boolean m3433b(char[] cArr, char[] cArr2) {
        return Arrays.equals(cArr, cArr2);
    }

    /* renamed from: c */
    public static boolean m3434c(int[] iArr, int[] iArr2) {
        return Arrays.equals(iArr, iArr2);
    }

    /* renamed from: d */
    public static boolean m3435d(short[] sArr, short[] sArr2) {
        return Arrays.equals(sArr, sArr2);
    }

    /* renamed from: e */
    public static byte[] m3436e(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return (byte[]) bArr.clone();
    }

    /* renamed from: f */
    public static int[] m3437f(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        return (int[]) iArr.clone();
    }

    /* renamed from: g */
    public static long[] m3438g(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        return (long[]) jArr.clone();
    }

    /* renamed from: h */
    public static short[] m3439h(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        return (short[]) sArr.clone();
    }

    /* renamed from: i */
    public static byte[] m3440i(byte[] bArr, byte[] bArr2) {
        Object clone;
        if (bArr == null) {
            clone = bArr2.clone();
        } else {
            if (bArr2 != null) {
                byte[] bArr3 = new byte[bArr.length + bArr2.length];
                System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
                System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
                return bArr3;
            }
            clone = bArr.clone();
        }
        return (byte[]) clone;
    }

    /* renamed from: j */
    public static byte[] m3441j(byte[] bArr, int i, int i2) {
        int m3444m = m3444m(i, i2);
        byte[] bArr2 = new byte[m3444m];
        System.arraycopy(bArr, i, bArr2, 0, Math.min(bArr.length - i, m3444m));
        return bArr2;
    }

    /* renamed from: k */
    public static void m3442k(byte[] bArr, byte b) {
        Arrays.fill(bArr, b);
    }

    /* renamed from: l */
    public static void m3443l(byte[] bArr, int i, int i2, byte b) {
        Arrays.fill(bArr, i, i2, b);
    }

    /* renamed from: m */
    public static int m3444m(int i, int i2) {
        int i3 = i2 - i;
        if (i3 >= 0) {
            return i3;
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        stringBuffer.append(" > ");
        stringBuffer.append(i2);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    /* renamed from: n */
    public static int m3445n(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ bArr[length];
        }
    }

    /* renamed from: o */
    public static int m3446o(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ bArr[i + i2];
        }
    }

    /* renamed from: p */
    public static int m3447p(char[] cArr) {
        if (cArr == null) {
            return 0;
        }
        int length = cArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ cArr[length];
        }
    }

    /* renamed from: q */
    public static int m3448q(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int length = iArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ iArr[length];
        }
    }

    /* renamed from: r */
    public static int m3449r(int[] iArr, int i, int i2) {
        if (iArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            i3 = (i3 * 257) ^ iArr[i + i2];
        }
    }

    /* renamed from: s */
    public static int m3450s(long[] jArr, int i, int i2) {
        if (jArr == null) {
            return 0;
        }
        int i3 = i2 + 1;
        while (true) {
            i2--;
            if (i2 < 0) {
                return i3;
            }
            long j = jArr[i + i2];
            i3 = (((i3 * 257) ^ ((int) j)) * 257) ^ ((int) (j >>> 32));
        }
    }

    /* renamed from: t */
    public static int m3451t(short[] sArr) {
        if (sArr == null) {
            return 0;
        }
        int length = sArr.length;
        int i = length + 1;
        while (true) {
            length--;
            if (length < 0) {
                return i;
            }
            i = (i * 257) ^ (sArr[length] & 255);
        }
    }

    /* renamed from: u */
    public static int m3452u(short[][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + m3451t(sArr[i2]);
        }
        return i;
    }

    /* renamed from: v */
    public static int m3453v(short[][][] sArr) {
        int i = 0;
        for (int i2 = 0; i2 != sArr.length; i2++) {
            i = (i * 257) + m3452u(sArr[i2]);
        }
        return i;
    }
}
