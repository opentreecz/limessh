package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECConstants;

/* loaded from: classes.dex */
public class mv0 implements Cloneable {

    /* renamed from: P */
    public static final short[] f5149P = {0, 1, 4, 5, 16, 17, 20, 21, 64, 65, 68, 69, 80, 81, 84, 85, 256, 257, 260, 261, 272, 273, 276, 277, 320, 321, 324, 325, 336, 337, 340, 341, 1024, 1025, 1028, 1029, 1040, 1041, 1044, 1045, 1088, 1089, 1092, 1093, 1104, 1105, 1108, 1109, 1280, 1281, 1284, 1285, 1296, 1297, 1300, 1301, 1344, 1345, 1348, 1349, 1360, 1361, 1364, 1365, 4096, 4097, 4100, 4101, 4112, 4113, 4116, 4117, 4160, 4161, 4164, 4165, 4176, 4177, 4180, 4181, 4352, 4353, 4356, 4357, 4368, 4369, 4372, 4373, 4416, 4417, 4420, 4421, 4432, 4433, 4436, 4437, 5120, 5121, 5124, 5125, 5136, 5137, 5140, 5141, 5184, 5185, 5188, 5189, 5200, 5201, 5204, 5205, 5376, 5377, 5380, 5381, 5392, 5393, 5396, 5397, 5440, 5441, 5444, 5445, 5456, 5457, 5460, 5461, 16384, 16385, 16388, 16389, 16400, 16401, 16404, 16405, 16448, 16449, 16452, 16453, 16464, 16465, 16468, 16469, 16640, 16641, 16644, 16645, 16656, 16657, 16660, 16661, 16704, 16705, 16708, 16709, 16720, 16721, 16724, 16725, 17408, 17409, 17412, 17413, 17424, 17425, 17428, 17429, 17472, 17473, 17476, 17477, 17488, 17489, 17492, 17493, 17664, 17665, 17668, 17669, 17680, 17681, 17684, 17685, 17728, 17729, 17732, 17733, 17744, 17745, 17748, 17749, 20480, 20481, 20484, 20485, 20496, 20497, 20500, 20501, 20544, 20545, 20548, 20549, 20560, 20561, 20564, 20565, 20736, 20737, 20740, 20741, 20752, 20753, 20756, 20757, 20800, 20801, 20804, 20805, 20816, 20817, 20820, 20821, 21504, 21505, 21508, 21509, 21520, 21521, 21524, 21525, 21568, 21569, 21572, 21573, 21584, 21585, 21588, 21589, 21760, 21761, 21764, 21765, 21776, 21777, 21780, 21781, 21824, 21825, 21828, 21829, 21840, 21841, 21844, 21845};

    /* renamed from: Q */
    public static final byte[] f5150Q = {0, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8};

    /* renamed from: O */
    public long[] f5151O;

    public mv0(int i) {
        this.f5151O = new long[i];
    }

    public mv0(BigInteger bigInteger) {
        int i;
        if (bigInteger == null || bigInteger.signum() < 0) {
            throw new IllegalArgumentException("invalid F2m field value");
        }
        if (bigInteger.signum() == 0) {
            this.f5151O = new long[]{0};
            return;
        }
        byte[] byteArray = bigInteger.toByteArray();
        int length = byteArray.length;
        if (byteArray[0] == 0) {
            length--;
            i = 1;
        } else {
            i = 0;
        }
        int i2 = (length + 7) / 8;
        this.f5151O = new long[i2];
        int i3 = i2 - 1;
        int i4 = (length % 8) + i;
        if (i < i4) {
            long j = 0;
            while (i < i4) {
                j = (j << 8) | (byteArray[i] & 255);
                i++;
            }
            this.f5151O[i3] = j;
            i3--;
        }
        while (i3 >= 0) {
            long j2 = 0;
            int i5 = 0;
            while (i5 < 8) {
                j2 = (j2 << 8) | (byteArray[i] & 255);
                i5++;
                i++;
            }
            this.f5151O[i3] = j2;
            i3--;
        }
    }

    public mv0(long[] jArr) {
        this.f5151O = jArr;
    }

    public mv0(long[] jArr, int i, int i2) {
        if (i == 0 && i2 == jArr.length) {
            this.f5151O = jArr;
            return;
        }
        long[] jArr2 = new long[i2];
        this.f5151O = jArr2;
        System.arraycopy(jArr, i, jArr2, 0, i2);
    }

    /* renamed from: F */
    public static void m6530F(long j, long[] jArr, int i, long[] jArr2, int i2) {
        if ((j & 1) != 0) {
            m6541b(jArr2, i2, jArr, 0, i);
        }
        long j2 = j;
        int i3 = 1;
        while (true) {
            long j3 = j2 >>> 1;
            if (j3 == 0) {
                return;
            }
            if ((j3 & 1) != 0) {
                long m6545k = m6545k(jArr2, i2, jArr, 0, i, i3);
                if (m6545k != 0) {
                    int i4 = i2 + i;
                    jArr2[i4] = m6545k ^ jArr2[i4];
                }
            }
            i3++;
            j2 = j3;
        }
    }

    /* renamed from: H */
    public static void m6531H(long[] jArr, int i, int i2, int i3, int[] iArr) {
        m6547r(jArr, i, i2);
        int i4 = i2 - i3;
        int length = iArr.length;
        while (true) {
            length--;
            if (length < 0) {
                m6547r(jArr, i, i4);
                return;
            }
            m6547r(jArr, i, iArr[length] + i4);
        }
    }

    /* renamed from: I */
    public static void m6532I(long[] jArr, int i, int i2, int i3, int[] iArr) {
        while (true) {
            i2--;
            if (i2 < i3) {
                return;
            }
            if (m6540T(jArr, i, i2)) {
                m6531H(jArr, i, i2, i3, iArr);
            }
        }
    }

    /* renamed from: J */
    public static int m6533J(long[] jArr, int i, int i2, int i3, int[] iArr) {
        int i4 = (i3 + 63) >>> 6;
        if (i2 < i4) {
            return i2;
        }
        int i5 = i2 << 6;
        int min = Math.min(i5, (i3 << 1) - 1);
        int i6 = i5 - min;
        int i7 = i2;
        while (i6 >= 64) {
            i7--;
            i6 -= 64;
        }
        int length = iArr.length;
        int i8 = iArr[length - 1];
        int i9 = length > 1 ? iArr[length - 2] : 0;
        int max = Math.max(i3, i8 + 64);
        int min2 = (i6 + Math.min(min - max, i3 - i9)) >> 6;
        if (min2 > 1) {
            int i10 = i7 - min2;
            m6535M(jArr, i, i7, i10, i3, iArr);
            while (i7 > i10) {
                i7--;
                jArr[i + i7] = 0;
            }
            min = i10 << 6;
        }
        if (min > max) {
            m6537O(jArr, i, i7, max, i3, iArr);
        } else {
            max = min;
        }
        if (max > i3) {
            m6532I(jArr, i, max, i3, iArr);
        }
        return i4;
    }

    /* renamed from: L */
    public static mv0 m6534L(long[] jArr, int i, int i2, int i3, int[] iArr) {
        return new mv0(jArr, i, m6533J(jArr, i, i2, i3, iArr));
    }

    /* renamed from: M */
    public static void m6535M(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = (i3 << 6) - i4;
        int length = iArr.length;
        while (true) {
            length--;
            if (length < 0) {
                m6548s(jArr, i, jArr, i + i3, i2 - i3, i5);
                return;
            }
            m6548s(jArr, i, jArr, i + i3, i2 - i3, i5 + iArr[length]);
        }
    }

    /* renamed from: N */
    public static void m6536N(long[] jArr, int i, int i2, long j, int i3, int[] iArr) {
        int i4 = i2 - i3;
        int length = iArr.length;
        while (true) {
            length--;
            if (length < 0) {
                m6549t(jArr, i, i4, j);
                return;
            }
            m6549t(jArr, i, iArr[length] + i4, j);
        }
    }

    /* renamed from: O */
    public static void m6537O(long[] jArr, int i, int i2, int i3, int i4, int[] iArr) {
        int i5 = i3 >>> 6;
        int i6 = i2;
        while (true) {
            int i7 = i6 - 1;
            if (i7 <= i5) {
                break;
            }
            int i8 = i + i7;
            long j = jArr[i8];
            if (j != 0) {
                jArr[i8] = 0;
                m6536N(jArr, i, i7 << 6, j, i4, iArr);
            }
            i6 = i7;
        }
        int i9 = i3 & 63;
        int i10 = i + i5;
        long j2 = jArr[i10] >>> i9;
        if (j2 != 0) {
            jArr[i10] = jArr[i10] ^ (j2 << i9);
            m6536N(jArr, i, i3, j2, i4, iArr);
        }
    }

    /* renamed from: Q */
    public static long m6538Q(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr[i + i6];
            jArr2[i2 + i6] = j | (j2 << i4);
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: S */
    public static void m6539S(long[] jArr, int i, int i2, int[] iArr) {
        int i3 = i << 1;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            long j = jArr[i];
            int i4 = i3 - 1;
            jArr[i4] = m6550w((int) (j >>> 32));
            i3 = i4 - 1;
            jArr[i3] = m6550w((int) j);
        }
    }

    /* renamed from: T */
    public static boolean m6540T(long[] jArr, int i, int i2) {
        return (jArr[i + (i2 >>> 6)] & (1 << (i2 & 63))) != 0;
    }

    /* renamed from: b */
    public static void m6541b(long[] jArr, int i, long[] jArr2, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = i + i4;
            jArr[i5] = jArr[i5] ^ jArr2[i2 + i4];
        }
    }

    /* renamed from: c */
    public static void m6542c(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            jArr3[i3 + i5] = jArr[i + i5] ^ jArr2[i2 + i5];
        }
    }

    /* renamed from: d */
    public static void m6543d(long[] jArr, int i, long[] jArr2, int i2, long[] jArr3, int i3, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = i + i5;
            jArr[i6] = jArr[i6] ^ (jArr2[i2 + i5] ^ jArr3[i3 + i5]);
        }
    }

    /* renamed from: j */
    public static long m6544j(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        while (true) {
            i3--;
            if (i3 < 0) {
                return j;
            }
            long j2 = jArr2[i2 + i3];
            int i6 = i + i3;
            jArr[i6] = (j | (j2 >>> i4)) ^ jArr[i6];
            j = j2 << i5;
        }
    }

    /* renamed from: k */
    public static long m6545k(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = 64 - i4;
        long j = 0;
        for (int i6 = 0; i6 < i3; i6++) {
            long j2 = jArr2[i2 + i6];
            int i7 = i + i6;
            jArr[i7] = (j | (j2 << i4)) ^ jArr[i7];
            j = j2 >>> i5;
        }
        return j;
    }

    /* renamed from: l */
    public static int m6546l(long j) {
        int i;
        int i2 = 32;
        int i3 = (int) (j >>> 32);
        if (i3 == 0) {
            i3 = (int) j;
            i2 = 0;
        }
        int i4 = i3 >>> 16;
        if (i4 == 0) {
            int i5 = i3 >>> 8;
            i = i5 == 0 ? f5150Q[i3] : f5150Q[i5] + 8;
        } else {
            int i6 = i4 >>> 8;
            i = i6 == 0 ? f5150Q[i4] + 16 : f5150Q[i6] + 24;
        }
        return i2 + i;
    }

    /* renamed from: r */
    public static void m6547r(long[] jArr, int i, int i2) {
        int i3 = i + (i2 >>> 6);
        jArr[i3] = jArr[i3] ^ (1 << (i2 & 63));
    }

    /* renamed from: s */
    public static void m6548s(long[] jArr, int i, long[] jArr2, int i2, int i3, int i4) {
        int i5 = i + (i4 >>> 6);
        int i6 = i4 & 63;
        if (i6 == 0) {
            m6541b(jArr, i5, jArr2, i2, i3);
        } else {
            jArr[i5] = m6544j(jArr, i5 + 1, jArr2, i2, i3, 64 - i6) ^ jArr[i5];
        }
    }

    /* renamed from: t */
    public static void m6549t(long[] jArr, int i, int i2, long j) {
        int i3 = i + (i2 >>> 6);
        int i4 = i2 & 63;
        if (i4 == 0) {
            jArr[i3] = jArr[i3] ^ j;
            return;
        }
        jArr[i3] = jArr[i3] ^ (j << i4);
        long j2 = j >>> (64 - i4);
        if (j2 != 0) {
            int i5 = i3 + 1;
            jArr[i5] = j2 ^ jArr[i5];
        }
    }

    /* renamed from: w */
    public static long m6550w(int i) {
        short[] sArr = f5149P;
        return ((sArr[i & 255] | (sArr[(i >>> 8) & 255] << 16)) & 4294967295L) | ((((sArr[i >>> 24] << 16) | sArr[(i >>> 16) & 255]) & 4294967295L) << 32);
    }

    /* renamed from: A */
    public mv0 m6551A(int i, int[] iArr) {
        int m6565o = m6565o();
        if (m6565o == 0) {
            throw new IllegalStateException();
        }
        int i2 = 1;
        if (m6565o == 1) {
            return this;
        }
        mv0 mv0Var = (mv0) clone();
        int i3 = (i + 63) >>> 6;
        mv0 mv0Var2 = new mv0(i3);
        m6531H(mv0Var2.f5151O, 0, i, i, iArr);
        mv0 mv0Var3 = new mv0(i3);
        mv0Var3.f5151O[0] = 1;
        mv0 mv0Var4 = new mv0(i3);
        int[] iArr2 = new int[2];
        iArr2[0] = m6565o;
        iArr2[1] = i + 1;
        mv0[] mv0VarArr = {mv0Var, mv0Var2};
        int[] iArr3 = {1, 0};
        mv0[] mv0VarArr2 = {mv0Var3, mv0Var4};
        int i4 = iArr2[1];
        int i5 = iArr3[1];
        int i6 = i4 - iArr2[0];
        while (true) {
            if (i6 < 0) {
                i6 = -i6;
                iArr2[i2] = i4;
                iArr3[i2] = i5;
                int i7 = 1 - i2;
                int i8 = iArr2[i7];
                i5 = iArr3[i7];
                i2 = i7;
                i4 = i8;
            }
            int i9 = 1 - i2;
            mv0VarArr[i2].m6562g(mv0VarArr[i9], iArr2[i9], i6);
            int m6566q = mv0VarArr[i2].m6566q(i4);
            if (m6566q == 0) {
                return mv0VarArr2[i9];
            }
            int i10 = iArr3[i9];
            mv0VarArr2[i2].m6562g(mv0VarArr2[i9], i10, i6);
            int i11 = i10 + i6;
            if (i11 > i5) {
                i5 = i11;
            } else if (i11 == i5) {
                i5 = mv0VarArr2[i2].m6566q(i5);
            }
            i6 += m6566q - i4;
            i4 = m6566q;
        }
    }

    /* renamed from: B */
    public mv0 m6552B(mv0 mv0Var, int i, int[] iArr) {
        int i2;
        int i3;
        mv0 mv0Var2;
        mv0 mv0Var3;
        int i4;
        long[] jArr;
        int i5;
        int m6565o = m6565o();
        if (m6565o == 0) {
            return this;
        }
        int m6565o2 = mv0Var.m6565o();
        if (m6565o2 == 0) {
            return mv0Var;
        }
        if (m6565o > m6565o2) {
            i3 = m6565o;
            i2 = m6565o2;
            mv0Var3 = this;
            mv0Var2 = mv0Var;
        } else {
            i2 = m6565o;
            i3 = m6565o2;
            mv0Var2 = this;
            mv0Var3 = mv0Var;
        }
        int i6 = (i2 + 63) >>> 6;
        int i7 = (i3 + 63) >>> 6;
        int i8 = ((i2 + i3) + 62) >>> 6;
        if (i6 == 1) {
            long j = mv0Var2.f5151O[0];
            if (j == 1) {
                return mv0Var3;
            }
            long[] jArr2 = new long[i8];
            m6530F(j, mv0Var3.f5151O, i7, jArr2, 0);
            return m6534L(jArr2, 0, i8, i, iArr);
        }
        int i9 = ((i3 + 7) + 63) >>> 6;
        int[] iArr2 = new int[16];
        int i10 = i9 << 4;
        long[] jArr3 = new long[i10];
        iArr2[1] = i9;
        System.arraycopy(mv0Var3.f5151O, 0, jArr3, i9, i7);
        int i11 = 2;
        int i12 = i9;
        for (int i13 = 16; i11 < i13; i13 = 16) {
            i12 += i9;
            iArr2[i11] = i12;
            if ((i11 & 1) == 0) {
                jArr = jArr3;
                i5 = i10;
                m6538Q(jArr3, i12 >>> 1, jArr3, i12, i9, 1);
            } else {
                jArr = jArr3;
                i5 = i10;
                m6542c(jArr, i9, jArr3, i12 - i9, jArr, i12, i9);
            }
            i11++;
            i10 = i5;
            jArr3 = jArr;
        }
        long[] jArr4 = jArr3;
        int i14 = i10;
        long[] jArr5 = new long[i14];
        m6538Q(jArr4, 0, jArr5, 0, i14, 4);
        long[] jArr6 = mv0Var2.f5151O;
        int i15 = i8 << 3;
        long[] jArr7 = new long[i15];
        int i16 = 0;
        while (i16 < i6) {
            long j2 = jArr6[i16];
            int i17 = i16;
            while (true) {
                int i18 = ((int) j2) & 15;
                long j3 = j2 >>> 4;
                i4 = i16;
                m6543d(jArr7, i17, jArr4, iArr2[i18], jArr5, iArr2[((int) j3) & 15], i9);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i17 += i8;
                i16 = i4;
            }
            i16 = i4 + 1;
        }
        while (true) {
            i15 -= i8;
            if (i15 == 0) {
                return m6534L(jArr7, 0, i8, i, iArr);
            }
            m6545k(jArr7, i15 - i8, jArr7, i15, i8, 8);
        }
    }

    /* renamed from: C */
    public mv0 m6553C(int i, int[] iArr) {
        int m6567u = m6567u();
        if (m6567u == 0) {
            return this;
        }
        int i2 = m6567u << 1;
        long[] jArr = new long[i2];
        int i3 = 0;
        while (i3 < i2) {
            long j = this.f5151O[i3 >>> 1];
            int i4 = i3 + 1;
            jArr[i3] = m6550w((int) j);
            i3 = i4 + 1;
            jArr[i4] = m6550w((int) (j >>> 32));
        }
        return new mv0(jArr, 0, m6533J(jArr, 0, i2, i, iArr));
    }

    /* renamed from: D */
    public mv0 m6554D(int i, int i2, int[] iArr) {
        int m6567u = m6567u();
        if (m6567u == 0) {
            return this;
        }
        int i3 = ((i2 + 63) >>> 6) << 1;
        long[] jArr = new long[i3];
        System.arraycopy(this.f5151O, 0, jArr, 0, m6567u);
        while (true) {
            i--;
            if (i < 0) {
                return new mv0(jArr, 0, m6567u);
            }
            m6539S(jArr, m6567u, i2, iArr);
            m6567u = m6533J(jArr, 0, i3, i2, iArr);
        }
    }

    /* renamed from: E */
    public mv0 m6555E(mv0 mv0Var, int i, int[] iArr) {
        int i2;
        int i3;
        mv0 mv0Var2;
        mv0 mv0Var3;
        long[] jArr;
        int i4;
        int m6565o = m6565o();
        if (m6565o == 0) {
            return this;
        }
        int m6565o2 = mv0Var.m6565o();
        if (m6565o2 == 0) {
            return mv0Var;
        }
        if (m6565o > m6565o2) {
            i3 = m6565o;
            i2 = m6565o2;
            mv0Var3 = this;
            mv0Var2 = mv0Var;
        } else {
            i2 = m6565o;
            i3 = m6565o2;
            mv0Var2 = this;
            mv0Var3 = mv0Var;
        }
        int i5 = (i2 + 63) >>> 6;
        int i6 = (i3 + 63) >>> 6;
        int i7 = ((i2 + i3) + 62) >>> 6;
        if (i5 == 1) {
            long j = mv0Var2.f5151O[0];
            if (j == 1) {
                return mv0Var3;
            }
            long[] jArr2 = new long[i7];
            m6530F(j, mv0Var3.f5151O, i6, jArr2, 0);
            return new mv0(jArr2, 0, i7);
        }
        int i8 = ((i3 + 7) + 63) >>> 6;
        int[] iArr2 = new int[16];
        int i9 = i8 << 4;
        long[] jArr3 = new long[i9];
        iArr2[1] = i8;
        System.arraycopy(mv0Var3.f5151O, 0, jArr3, i8, i6);
        int i10 = 2;
        int i11 = i8;
        for (int i12 = 16; i10 < i12; i12 = 16) {
            i11 += i8;
            iArr2[i10] = i11;
            if ((i10 & 1) == 0) {
                jArr = jArr3;
                i4 = i9;
                m6538Q(jArr3, i11 >>> 1, jArr3, i11, i8, 1);
            } else {
                jArr = jArr3;
                i4 = i9;
                m6542c(jArr, i8, jArr, i11 - i8, jArr3, i11, i8);
            }
            i10++;
            i9 = i4;
            jArr3 = jArr;
        }
        long[] jArr4 = jArr3;
        int i13 = i9;
        long[] jArr5 = new long[i13];
        m6538Q(jArr4, 0, jArr5, 0, i13, 4);
        long[] jArr6 = mv0Var2.f5151O;
        int i14 = i7 << 3;
        long[] jArr7 = new long[i14];
        for (int i15 = 0; i15 < i5; i15++) {
            long j2 = jArr6[i15];
            int i16 = i15;
            while (true) {
                long j3 = j2 >>> 4;
                m6543d(jArr7, i16, jArr4, iArr2[((int) j2) & 15], jArr5, iArr2[((int) j3) & 15], i8);
                j2 = j3 >>> 4;
                if (j2 == 0) {
                    break;
                }
                i16 += i7;
            }
        }
        while (true) {
            i14 -= i7;
            if (i14 == 0) {
                return new mv0(jArr7, 0, i7);
            }
            m6545k(jArr7, i14 - i7, jArr7, i14, i7, 8);
        }
    }

    /* renamed from: G */
    public void m6556G(int i, int[] iArr) {
        long[] jArr = this.f5151O;
        int m6533J = m6533J(jArr, 0, jArr.length, i, iArr);
        if (m6533J < jArr.length) {
            long[] jArr2 = new long[m6533J];
            this.f5151O = jArr2;
            System.arraycopy(jArr, 0, jArr2, 0, m6533J);
        }
    }

    /* renamed from: P */
    public final long[] m6557P(int i) {
        long[] jArr = new long[i];
        long[] jArr2 = this.f5151O;
        System.arraycopy(jArr2, 0, jArr, 0, Math.min(jArr2.length, i));
        return jArr;
    }

    /* renamed from: R */
    public mv0 m6558R(int i, int[] iArr) {
        int m6567u = m6567u();
        if (m6567u == 0) {
            return this;
        }
        int i2 = m6567u << 1;
        long[] jArr = new long[i2];
        int i3 = 0;
        while (i3 < i2) {
            long j = this.f5151O[i3 >>> 1];
            int i4 = i3 + 1;
            jArr[i3] = m6550w((int) j);
            i3 = i4 + 1;
            jArr[i4] = m6550w((int) (j >>> 32));
        }
        return new mv0(jArr, 0, i2);
    }

    /* renamed from: U */
    public boolean m6559U() {
        long[] jArr = this.f5151O;
        return jArr.length > 0 && (1 & jArr[0]) != 0;
    }

    /* renamed from: V */
    public BigInteger m6560V() {
        int m6567u = m6567u();
        if (m6567u == 0) {
            return ECConstants.f8872a;
        }
        int i = m6567u - 1;
        long j = this.f5151O[i];
        byte[] bArr = new byte[8];
        int i2 = 0;
        boolean z = false;
        for (int i3 = 7; i3 >= 0; i3--) {
            byte b = (byte) (j >>> (i3 * 8));
            if (z || b != 0) {
                bArr[i2] = b;
                i2++;
                z = true;
            }
        }
        byte[] bArr2 = new byte[(i * 8) + i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = bArr[i4];
        }
        for (int i5 = m6567u - 2; i5 >= 0; i5--) {
            long j2 = this.f5151O[i5];
            int i6 = 7;
            while (i6 >= 0) {
                bArr2[i2] = (byte) (j2 >>> (i6 * 8));
                i6--;
                i2++;
            }
        }
        return new BigInteger(1, bArr2);
    }

    public Object clone() {
        return new mv0(e51.m3438g(this.f5151O));
    }

    /* renamed from: e */
    public mv0 m6561e() {
        if (this.f5151O.length == 0) {
            return new mv0(new long[]{1});
        }
        long[] m6557P = m6557P(Math.max(1, m6567u()));
        m6557P[0] = 1 ^ m6557P[0];
        return new mv0(m6557P);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof mv0)) {
            return false;
        }
        mv0 mv0Var = (mv0) obj;
        int m6567u = m6567u();
        if (mv0Var.m6567u() != m6567u) {
            return false;
        }
        for (int i = 0; i < m6567u; i++) {
            if (this.f5151O[i] != mv0Var.f5151O[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: g */
    public final void m6562g(mv0 mv0Var, int i, int i2) {
        int i3 = (i + 63) >>> 6;
        int i4 = i2 >>> 6;
        int i5 = i2 & 63;
        if (i5 == 0) {
            m6541b(this.f5151O, i4, mv0Var.f5151O, 0, i3);
            return;
        }
        long m6545k = m6545k(this.f5151O, i4, mv0Var.f5151O, 0, i3, i5);
        if (m6545k != 0) {
            long[] jArr = this.f5151O;
            int i6 = i3 + i4;
            jArr[i6] = m6545k ^ jArr[i6];
        }
    }

    public int hashCode() {
        int m6567u = m6567u();
        int i = 1;
        for (int i2 = 0; i2 < m6567u; i2++) {
            long j = this.f5151O[i2];
            i = (((i * 31) ^ ((int) j)) * 31) ^ ((int) (j >>> 32));
        }
        return i;
    }

    /* renamed from: i */
    public void m6563i(mv0 mv0Var, int i) {
        int m6567u = mv0Var.m6567u();
        if (m6567u == 0) {
            return;
        }
        int i2 = m6567u + i;
        if (i2 > this.f5151O.length) {
            this.f5151O = m6557P(i2);
        }
        m6541b(this.f5151O, i, mv0Var.f5151O, 0, m6567u);
    }

    /* renamed from: m */
    public void m6564m(long[] jArr, int i) {
        long[] jArr2 = this.f5151O;
        System.arraycopy(jArr2, 0, jArr, i, jArr2.length);
    }

    /* renamed from: o */
    public int m6565o() {
        int length = this.f5151O.length;
        while (length != 0) {
            length--;
            long j = this.f5151O[length];
            if (j != 0) {
                return (length << 6) + m6546l(j);
            }
        }
        return 0;
    }

    /* renamed from: q */
    public final int m6566q(int i) {
        int i2 = (i + 62) >>> 6;
        while (i2 != 0) {
            i2--;
            long j = this.f5151O[i2];
            if (j != 0) {
                return (i2 << 6) + m6546l(j);
            }
        }
        return 0;
    }

    public String toString() {
        int m6567u = m6567u();
        if (m6567u == 0) {
            return "0";
        }
        int i = m6567u - 1;
        StringBuffer stringBuffer = new StringBuffer(Long.toBinaryString(this.f5151O[i]));
        while (true) {
            i--;
            if (i < 0) {
                return stringBuffer.toString();
            }
            String binaryString = Long.toBinaryString(this.f5151O[i]);
            int length = binaryString.length();
            if (length < 64) {
                stringBuffer.append("0000000000000000000000000000000000000000000000000000000000000000".substring(length));
            }
            stringBuffer.append(binaryString);
        }
    }

    /* renamed from: u */
    public int m6567u() {
        return m6568v(this.f5151O.length);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001e, code lost:
    
        return r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001f, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if (r0[r8] == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0029, code lost:
    
        if (r8 > 0) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002b, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0028, code lost:
    
        return r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r0[0] != 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        r8 = r8 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (r0[r8] != 0) goto L18;
     */
    /* renamed from: v */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m6568v(int r8) {
        /*
            r7 = this;
            long[] r0 = r7.f5151O
            int r1 = r0.length
            int r8 = java.lang.Math.min(r8, r1)
            r1 = 0
            r2 = 1
            if (r8 >= r2) goto Lc
            return r1
        Lc:
            r3 = r0[r1]
            r5 = 0
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L1f
        L14:
            int r8 = r8 + (-1)
            r3 = r0[r8]
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 != 0) goto L1d
            goto L14
        L1d:
            int r8 = r8 + r2
            return r8
        L1f:
            int r8 = r8 + (-1)
            r3 = r0[r8]
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L29
            int r8 = r8 + r2
            return r8
        L29:
            if (r8 > 0) goto L1f
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sonelli.mv0.m6568v(int):int");
    }

    /* renamed from: y */
    public boolean m6569y() {
        long[] jArr = this.f5151O;
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: z */
    public boolean m6570z() {
        for (long j : this.f5151O) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}
