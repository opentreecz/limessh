package cz.opentree;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public class t41 extends z41 {

    /* renamed from: c */
    public int[][] f6707c;

    /* renamed from: d */
    public int f6708d;

    public t41(int i, int[][] iArr) {
        if (iArr[0].length != ((i + 31) >> 5)) {
            throw new ArithmeticException("Int array does not match given number of columns.");
        }
        this.f8455b = i;
        this.f8454a = iArr.length;
        this.f6708d = iArr[0].length;
        int i2 = i & 31;
        int i3 = i2 == 0 ? -1 : (1 << i2) - 1;
        for (int i4 = 0; i4 < this.f8454a; i4++) {
            int[] iArr2 = iArr[i4];
            int i5 = this.f6708d - 1;
            iArr2[i5] = iArr2[i5] & i3;
        }
        this.f6707c = iArr;
    }

    public t41(t41 t41Var) {
        this.f8455b = t41Var.m10391a();
        this.f8454a = t41Var.m10392b();
        this.f6708d = t41Var.f6708d;
        this.f6707c = new int[t41Var.f6707c.length];
        int i = 0;
        while (true) {
            int[][] iArr = this.f6707c;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = w41.m9408a(t41Var.f6707c[i]);
            i++;
        }
    }

    public t41(byte[] bArr) {
        if (bArr.length < 9) {
            throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
        }
        this.f8454a = y41.m10087e(bArr, 0);
        int m10087e = y41.m10087e(bArr, 4);
        this.f8455b = m10087e;
        int i = this.f8454a;
        int i2 = ((m10087e + 7) >>> 3) * i;
        if (i > 0) {
            int i3 = 8;
            if (i2 == bArr.length - 8) {
                int i4 = (m10087e + 31) >>> 5;
                this.f6708d = i4;
                this.f6707c = (int[][]) Array.newInstance((Class<?>) int.class, i, i4);
                int i5 = this.f8455b;
                int i6 = i5 >> 5;
                int i7 = i5 & 31;
                for (int i8 = 0; i8 < this.f8454a; i8++) {
                    int i9 = 0;
                    while (i9 < i6) {
                        this.f6707c[i8][i9] = y41.m10087e(bArr, i3);
                        i9++;
                        i3 += 4;
                    }
                    int i10 = 0;
                    while (i10 < i7) {
                        int[] iArr = this.f6707c[i8];
                        iArr[i6] = ((bArr[i3] & 255) << i10) ^ iArr[i6];
                        i10 += 8;
                        i3++;
                    }
                }
                return;
            }
        }
        throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }

    /* renamed from: c */
    public byte[] m8594c() {
        int i = (this.f8455b + 7) >>> 3;
        int i2 = this.f8454a;
        int i3 = 8;
        byte[] bArr = new byte[(i * i2) + 8];
        y41.m10083a(i2, bArr, 0);
        y41.m10083a(this.f8455b, bArr, 4);
        int i4 = this.f8455b;
        int i5 = i4 >>> 5;
        int i6 = i4 & 31;
        for (int i7 = 0; i7 < this.f8454a; i7++) {
            int i8 = 0;
            while (i8 < i5) {
                y41.m10083a(this.f6707c[i7][i8], bArr, i3);
                i8++;
                i3 += 4;
            }
            int i9 = 0;
            while (i9 < i6) {
                bArr[i3] = (byte) ((this.f6707c[i7][i5] >>> i9) & 255);
                i9 += 8;
                i3++;
            }
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t41)) {
            return false;
        }
        t41 t41Var = (t41) obj;
        if (this.f8454a != t41Var.f8454a || this.f8455b != t41Var.f8455b || this.f6708d != t41Var.f6708d) {
            return false;
        }
        for (int i = 0; i < this.f8454a; i++) {
            if (!w41.m9409b(this.f6707c[i], t41Var.f6707c[i])) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = (((this.f8454a * 31) + this.f8455b) * 31) + this.f6708d;
        for (int i2 = 0; i2 < this.f8454a; i2++) {
            i = (i * 31) + e51.m3448q(this.f6707c[i2]);
        }
        return i;
    }

    public String toString() {
        int i = this.f8455b & 31;
        int i2 = this.f6708d;
        if (i != 0) {
            i2--;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i3 = 0; i3 < this.f8454a; i3++) {
            stringBuffer.append(i3 + ": ");
            for (int i4 = 0; i4 < i2; i4++) {
                int i5 = this.f6707c[i3][i4];
                for (int i6 = 0; i6 < 32; i6++) {
                    if (((i5 >>> i6) & 1) == 0) {
                        stringBuffer.append('0');
                    } else {
                        stringBuffer.append('1');
                    }
                }
                stringBuffer.append(' ');
            }
            int i7 = this.f6707c[i3][this.f6708d - 1];
            for (int i8 = 0; i8 < i; i8++) {
                if (((i7 >>> i8) & 1) == 0) {
                    stringBuffer.append('0');
                } else {
                    stringBuffer.append('1');
                }
            }
            stringBuffer.append('\n');
        }
        return stringBuffer.toString();
    }
}
