package cz.opentree;

import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class j01 {
    /* renamed from: A */
    public static int m4995A(int i, long j, int[] iArr, int i2) {
        long j2 = i & 4294967295L;
        long j3 = j & 4294967295L;
        long j4 = (j2 * j3) + (iArr[r1] & 4294967295L) + 0;
        iArr[i2 + 0] = (int) j4;
        long j5 = j >>> 32;
        long j6 = (j2 * j5) + j3;
        long j7 = (j4 >>> 32) + j6 + (iArr[r7] & 4294967295L);
        iArr[i2 + 1] = (int) j7;
        long j8 = (j7 >>> 32) + j5 + (iArr[r7] & 4294967295L);
        iArr[i2 + 2] = (int) j8;
        long j9 = (j8 >>> 32) + (4294967295L & iArr[r7]);
        iArr[i2 + 3] = (int) j9;
        if ((j9 >>> 32) == 0) {
            return 0;
        }
        return p01.m7212w(8, iArr, i2, 4);
    }

    /* renamed from: B */
    public static int m4996B(int i, int i2, int[] iArr, int i3) {
        long j = i & 4294967295L;
        long j2 = i2 & 4294967295L;
        long j3 = (j * j2) + (iArr[r4] & 4294967295L) + 0;
        iArr[i3 + 0] = (int) j3;
        long j4 = (j3 >>> 32) + j2 + (iArr[r7] & 4294967295L);
        iArr[i3 + 1] = (int) j4;
        long j5 = j4 >>> 32;
        long j6 = j5 + (iArr[r0] & 4294967295L);
        iArr[i3 + 2] = (int) j6;
        if ((j6 >>> 32) == 0) {
            return 0;
        }
        return p01.m7212w(8, iArr, i3, 3);
    }

    /* renamed from: C */
    public static int m4997C(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & 4294967295L;
        long j2 = iArr2[1] & 4294967295L;
        long j3 = iArr2[2] & 4294967295L;
        long j4 = iArr2[3] & 4294967295L;
        long j5 = iArr2[4] & 4294967295L;
        long j6 = iArr2[5] & 4294967295L;
        long j7 = iArr2[6] & 4294967295L;
        long j8 = iArr2[7] & 4294967295L;
        long j9 = 0;
        int i = 0;
        while (i < 8) {
            long j10 = j8;
            long j11 = iArr[i] & 4294967295L;
            long j12 = j6;
            long j13 = (j11 * j) + (iArr3[r27] & 4294967295L) + 0;
            iArr3[i + 0] = (int) j13;
            int i2 = i + 1;
            long j14 = j2;
            long j15 = (j13 >>> 32) + (j11 * j2) + (iArr3[i2] & 4294967295L);
            iArr3[i2] = (int) j15;
            long j16 = (j15 >>> 32) + (j11 * j3) + (iArr3[r6] & 4294967295L);
            iArr3[i + 2] = (int) j16;
            long j17 = (j16 >>> 32) + (j11 * j4) + (iArr3[r6] & 4294967295L);
            iArr3[i + 3] = (int) j17;
            long j18 = (j17 >>> 32) + (j11 * j5) + (iArr3[r6] & 4294967295L);
            iArr3[i + 4] = (int) j18;
            long j19 = (j18 >>> 32) + (j11 * j12) + (iArr3[r6] & 4294967295L);
            iArr3[i + 5] = (int) j19;
            long j20 = (j19 >>> 32) + (j11 * j7) + (iArr3[r6] & 4294967295L);
            iArr3[i + 6] = (int) j20;
            long j21 = (j20 >>> 32) + (j11 * j10) + (iArr3[r6] & 4294967295L);
            iArr3[i + 7] = (int) j21;
            long j22 = (j21 >>> 32) + (iArr3[r2] & 4294967295L) + j9;
            iArr3[i + 8] = (int) j22;
            j9 = j22 >>> 32;
            i = i2;
            j8 = j10;
            j6 = j12;
            j2 = j14;
        }
        return (int) j9;
    }

    /* renamed from: D */
    public static int m4998D(int i, int[] iArr, int[] iArr2) {
        long j = i & 4294967295L;
        long j2 = ((iArr2[0] & 4294967295L) * j) + (iArr[0] & 4294967295L) + 0;
        iArr2[0] = (int) j2;
        long j3 = (j2 >>> 32) + ((iArr2[1] & 4294967295L) * j) + (iArr[1] & 4294967295L);
        iArr2[1] = (int) j3;
        long j4 = (j3 >>> 32) + ((iArr2[2] & 4294967295L) * j) + (iArr[2] & 4294967295L);
        iArr2[2] = (int) j4;
        long j5 = (j4 >>> 32) + ((iArr2[3] & 4294967295L) * j) + (iArr[3] & 4294967295L);
        iArr2[3] = (int) j5;
        long j6 = (j5 >>> 32) + ((iArr2[4] & 4294967295L) * j) + (iArr[4] & 4294967295L);
        iArr2[4] = (int) j6;
        long j7 = (j6 >>> 32) + ((iArr2[5] & 4294967295L) * j) + (iArr[5] & 4294967295L);
        iArr2[5] = (int) j7;
        long j8 = (j7 >>> 32) + ((iArr2[6] & 4294967295L) * j) + (iArr[6] & 4294967295L);
        iArr2[6] = (int) j8;
        long j9 = (j8 >>> 32) + (j * (iArr2[7] & 4294967295L)) + (4294967295L & iArr[7]);
        iArr2[7] = (int) j9;
        return (int) (j9 >>> 32);
    }

    /* renamed from: E */
    public static void m4999E(int[] iArr, int i, int[] iArr2, int i2) {
        long j = iArr[i + 0] & 4294967295L;
        int i3 = 0;
        int i4 = 16;
        int i5 = 7;
        while (true) {
            int i6 = i5 - 1;
            long j2 = iArr[i + i5] & 4294967295L;
            long j3 = j2 * j2;
            int i7 = i4 - 1;
            iArr2[i2 + i7] = (i3 << 31) | ((int) (j3 >>> 33));
            i4 = i7 - 1;
            iArr2[i2 + i4] = (int) (j3 >>> 1);
            i3 = (int) j3;
            if (i6 <= 0) {
                long j4 = j * j;
                iArr2[i2 + 0] = (int) j4;
                long j5 = iArr[i + 1] & 4294967295L;
                long j6 = (((i3 << 31) & 4294967295L) | (j4 >>> 33)) + (j5 * j);
                int i8 = (int) j6;
                iArr2[i2 + 1] = (i8 << 1) | (((int) (j4 >>> 32)) & 1);
                int i9 = i8 >>> 31;
                long j7 = (iArr2[r9] & 4294967295L) + (j6 >>> 32);
                long j8 = iArr[i + 2] & 4294967295L;
                long j9 = j7 + (j8 * j);
                int i10 = (int) j9;
                iArr2[i2 + 2] = (i10 << 1) | i9;
                int i11 = i10 >>> 31;
                long j10 = (iArr2[r15] & 4294967295L) + (j9 >>> 32) + (j8 * j5);
                long j11 = (iArr2[r7] & 4294967295L) + (j10 >>> 32);
                long j12 = iArr[i + 3] & 4294967295L;
                long j13 = (iArr2[r6] & 4294967295L) + (j11 >>> 32);
                long j14 = (iArr2[r24] & 4294967295L) + (j13 >>> 32);
                long j15 = (j10 & 4294967295L) + (j12 * j);
                int i12 = (int) j15;
                iArr2[i2 + 3] = (i12 << 1) | i11;
                long j16 = (j11 & 4294967295L) + (j15 >>> 32) + (j12 * j5);
                long j17 = (j13 & 4294967295L) + (j16 >>> 32) + (j12 * j8);
                long j18 = j14 + (j17 >>> 32);
                long j19 = j17 & 4294967295L;
                long j20 = iArr[i + 4] & 4294967295L;
                long j21 = (iArr2[r3] & 4294967295L) + (j18 >>> 32);
                long j22 = j18 & 4294967295L;
                long j23 = (j16 & 4294967295L) + (j20 * j);
                int i13 = (int) j23;
                iArr2[i2 + 4] = (i12 >>> 31) | (i13 << 1);
                int i14 = i13 >>> 31;
                long j24 = j19 + (j23 >>> 32) + (j20 * j5);
                long j25 = j22 + (j24 >>> 32) + (j20 * j8);
                long j26 = (j21 & 4294967295L) + (j25 >>> 32) + (j20 * j12);
                long j27 = (iArr2[r22] & 4294967295L) + (j21 >>> 32) + (j26 >>> 32);
                long j28 = j26 & 4294967295L;
                long j29 = iArr[i + 5] & 4294967295L;
                long j30 = (iArr2[r5] & 4294967295L) + (j27 >>> 32);
                long j31 = (iArr2[r25] & 4294967295L) + (j30 >>> 32);
                long j32 = (j24 & 4294967295L) + (j29 * j);
                int i15 = (int) j32;
                iArr2[i2 + 5] = i14 | (i15 << 1);
                int i16 = i15 >>> 31;
                long j33 = (j25 & 4294967295L) + (j32 >>> 32) + (j29 * j5);
                long j34 = j28 + (j33 >>> 32) + (j29 * j8);
                long j35 = (j27 & 4294967295L) + (j34 >>> 32) + (j29 * j12);
                long j36 = (j30 & 4294967295L) + (j35 >>> 32) + (j29 * j20);
                long j37 = j35 & 4294967295L;
                long j38 = j31 + (j36 >>> 32);
                long j39 = j36 & 4294967295L;
                long j40 = iArr[i + 6] & 4294967295L;
                long j41 = (iArr2[r11] & 4294967295L) + (j38 >>> 32);
                long j42 = j38 & 4294967295L;
                long j43 = (iArr2[r26] & 4294967295L) + (j41 >>> 32);
                long j44 = (j33 & 4294967295L) + (j40 * j);
                int i17 = (int) j44;
                iArr2[i2 + 6] = i16 | (i17 << 1);
                int i18 = i17 >>> 31;
                long j45 = (j34 & 4294967295L) + (j44 >>> 32) + (j40 * j5);
                long j46 = j37 + (j45 >>> 32) + (j40 * j8);
                long j47 = j39 + (j46 >>> 32) + (j40 * j12);
                long j48 = j46 & 4294967295L;
                long j49 = j42 + (j47 >>> 32) + (j40 * j20);
                long j50 = (j41 & 4294967295L) + (j49 >>> 32) + (j40 * j29);
                long j51 = j43 + (j50 >>> 32);
                long j52 = j50 & 4294967295L;
                long j53 = iArr[i + 7] & 4294967295L;
                long j54 = (iArr2[r15] & 4294967295L) + (j51 >>> 32);
                long j55 = j51 & 4294967295L;
                long j56 = (iArr2[r42] & 4294967295L) + (j54 >>> 32);
                long j57 = (j45 & 4294967295L) + (j * j53);
                int i19 = (int) j57;
                iArr2[i2 + 7] = (i19 << 1) | i18;
                long j58 = j48 + (j57 >>> 32) + (j53 * j5);
                long j59 = (j47 & 4294967295L) + (j58 >>> 32) + (j53 * j8);
                long j60 = (j49 & 4294967295L) + (j59 >>> 32) + (j53 * j12);
                long j61 = j52 + (j60 >>> 32) + (j53 * j20);
                long j62 = j55 + (j61 >>> 32) + (j53 * j29);
                long j63 = (j54 & 4294967295L) + (j62 >>> 32) + (j53 * j40);
                long j64 = j56 + (j63 >>> 32);
                int i20 = (int) j58;
                iArr2[i2 + 8] = (i19 >>> 31) | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j59;
                iArr2[i2 + 9] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j60;
                iArr2[i2 + 10] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j61;
                iArr2[i2 + 11] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j62;
                iArr2[i2 + 12] = i27 | (i28 << 1);
                int i29 = i28 >>> 31;
                int i30 = (int) j63;
                iArr2[i2 + 13] = i29 | (i30 << 1);
                int i31 = i30 >>> 31;
                int i32 = (int) j64;
                iArr2[i2 + 14] = i31 | (i32 << 1);
                int i33 = i32 >>> 31;
                int i34 = i2 + 15;
                iArr2[i34] = i33 | ((iArr2[i34] + ((int) (j64 >>> 32))) << 1);
                return;
            }
            i5 = i6;
        }
    }

    /* renamed from: F */
    public static void m5000F(int[] iArr, int[] iArr2) {
        long j = iArr[0] & 4294967295L;
        int i = 16;
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i3 - 1;
            long j2 = iArr[i3] & 4294967295L;
            long j3 = j2 * j2;
            int i5 = i - 1;
            iArr2[i5] = (i2 << 31) | ((int) (j3 >>> 33));
            i = i5 - 1;
            iArr2[i] = (int) (j3 >>> 1);
            int i6 = (int) j3;
            if (i4 <= 0) {
                long j4 = j * j;
                long j5 = ((i6 << 31) & 4294967295L) | (j4 >>> 33);
                iArr2[0] = (int) j4;
                long j6 = iArr[1] & 4294967295L;
                long j7 = j5 + (j6 * j);
                int i7 = (int) j7;
                iArr2[1] = (i7 << 1) | (((int) (j4 >>> 32)) & 1);
                long j8 = (iArr2[2] & 4294967295L) + (j7 >>> 32);
                long j9 = iArr[2] & 4294967295L;
                long j10 = j8 + (j9 * j);
                int i8 = (int) j10;
                iArr2[2] = (i8 << 1) | (i7 >>> 31);
                long j11 = (iArr2[3] & 4294967295L) + (j10 >>> 32) + (j9 * j6);
                long j12 = (iArr2[4] & 4294967295L) + (j11 >>> 32);
                long j13 = iArr[3] & 4294967295L;
                long j14 = (iArr2[5] & 4294967295L) + (j12 >>> 32);
                long j15 = j12 & 4294967295L;
                long j16 = (iArr2[6] & 4294967295L) + (j14 >>> 32);
                long j17 = (j11 & 4294967295L) + (j13 * j);
                int i9 = (int) j17;
                iArr2[3] = (i9 << 1) | (i8 >>> 31);
                long j18 = j15 + (j17 >>> 32) + (j13 * j6);
                long j19 = (j14 & 4294967295L) + (j18 >>> 32) + (j13 * j9);
                long j20 = j16 + (j19 >>> 32);
                long j21 = j19 & 4294967295L;
                long j22 = iArr[4] & 4294967295L;
                long j23 = (iArr2[7] & 4294967295L) + (j20 >>> 32);
                long j24 = j20 & 4294967295L;
                long j25 = (iArr2[8] & 4294967295L) + (j23 >>> 32);
                long j26 = (j18 & 4294967295L) + (j22 * j);
                int i10 = (int) j26;
                iArr2[4] = (i9 >>> 31) | (i10 << 1);
                int i11 = i10 >>> 31;
                long j27 = j21 + (j26 >>> 32) + (j22 * j6);
                long j28 = j24 + (j27 >>> 32) + (j22 * j9);
                long j29 = (j23 & 4294967295L) + (j28 >>> 32) + (j22 * j13);
                long j30 = j25 + (j29 >>> 32);
                long j31 = j29 & 4294967295L;
                long j32 = iArr[5] & 4294967295L;
                long j33 = (iArr2[9] & 4294967295L) + (j30 >>> 32);
                long j34 = j30 & 4294967295L;
                long j35 = (iArr2[10] & 4294967295L) + (j33 >>> 32);
                long j36 = (j27 & 4294967295L) + (j32 * j);
                int i12 = (int) j36;
                iArr2[5] = (i12 << 1) | i11;
                long j37 = (j28 & 4294967295L) + (j36 >>> 32) + (j32 * j6);
                long j38 = j31 + (j37 >>> 32) + (j32 * j9);
                long j39 = j34 + (j38 >>> 32) + (j32 * j13);
                long j40 = (j33 & 4294967295L) + (j39 >>> 32) + (j32 * j22);
                long j41 = j35 + (j40 >>> 32);
                long j42 = iArr[6] & 4294967295L;
                long j43 = (iArr2[11] & 4294967295L) + (j41 >>> 32);
                long j44 = j41 & 4294967295L;
                long j45 = (iArr2[12] & 4294967295L) + (j43 >>> 32);
                long j46 = (j37 & 4294967295L) + (j42 * j);
                int i13 = (int) j46;
                iArr2[6] = (i13 << 1) | (i12 >>> 31);
                long j47 = (j38 & 4294967295L) + (j46 >>> 32) + (j42 * j6);
                long j48 = (j39 & 4294967295L) + (j47 >>> 32) + (j42 * j9);
                long j49 = (j40 & 4294967295L) + (j48 >>> 32) + (j42 * j13);
                long j50 = j44 + (j49 >>> 32) + (j42 * j22);
                long j51 = (j43 & 4294967295L) + (j50 >>> 32) + (j42 * j32);
                long j52 = j45 + (j51 >>> 32);
                long j53 = j51 & 4294967295L;
                long j54 = iArr[7] & 4294967295L;
                long j55 = (iArr2[13] & 4294967295L) + (j52 >>> 32);
                long j56 = j52 & 4294967295L;
                long j57 = (iArr2[14] & 4294967295L) + (j55 >>> 32);
                long j58 = (j47 & 4294967295L) + (j * j54);
                int i14 = (int) j58;
                iArr2[7] = (i13 >>> 31) | (i14 << 1);
                int i15 = i14 >>> 31;
                long j59 = (j48 & 4294967295L) + (j58 >>> 32) + (j6 * j54);
                long j60 = (j49 & 4294967295L) + (j59 >>> 32) + (j54 * j9);
                long j61 = (j50 & 4294967295L) + (j60 >>> 32) + (j54 * j13);
                long j62 = j53 + (j61 >>> 32) + (j54 * j22);
                long j63 = j56 + (j62 >>> 32) + (j54 * j32);
                long j64 = (j55 & 4294967295L) + (j63 >>> 32) + (j54 * j42);
                long j65 = j57 + (j64 >>> 32);
                int i16 = (int) j59;
                iArr2[8] = i15 | (i16 << 1);
                int i17 = i16 >>> 31;
                int i18 = (int) j60;
                iArr2[9] = i17 | (i18 << 1);
                int i19 = i18 >>> 31;
                int i20 = (int) j61;
                iArr2[10] = i19 | (i20 << 1);
                int i21 = i20 >>> 31;
                int i22 = (int) j62;
                iArr2[11] = i21 | (i22 << 1);
                int i23 = i22 >>> 31;
                int i24 = (int) j63;
                iArr2[12] = i23 | (i24 << 1);
                int i25 = i24 >>> 31;
                int i26 = (int) j64;
                iArr2[13] = i25 | (i26 << 1);
                int i27 = i26 >>> 31;
                int i28 = (int) j65;
                iArr2[14] = i27 | (i28 << 1);
                iArr2[15] = (i28 >>> 31) | ((iArr2[15] + ((int) (j65 >>> 32))) << 1);
                return;
            }
            i3 = i4;
            i2 = i6;
        }
    }

    /* renamed from: G */
    public static int m5001G(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = ((iArr[i + 0] & 4294967295L) - (iArr2[i2 + 0] & 4294967295L)) + 0;
        iArr3[i3 + 0] = (int) j;
        long j2 = (j >> 32) + ((iArr[i + 1] & 4294967295L) - (iArr2[i2 + 1] & 4294967295L));
        iArr3[i3 + 1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[i + 2] & 4294967295L) - (iArr2[i2 + 2] & 4294967295L));
        iArr3[i3 + 2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[i + 3] & 4294967295L) - (iArr2[i2 + 3] & 4294967295L));
        iArr3[i3 + 3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[i + 4] & 4294967295L) - (iArr2[i2 + 4] & 4294967295L));
        iArr3[i3 + 4] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr[i + 5] & 4294967295L) - (iArr2[i2 + 5] & 4294967295L));
        iArr3[i3 + 5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[i + 6] & 4294967295L) - (iArr2[i2 + 6] & 4294967295L));
        iArr3[i3 + 6] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr[i + 7] & 4294967295L) - (iArr2[i2 + 7] & 4294967295L));
        iArr3[i3 + 7] = (int) j8;
        return (int) (j8 >> 32);
    }

    /* renamed from: H */
    public static int m5002H(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = ((iArr[0] & 4294967295L) - (iArr2[0] & 4294967295L)) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >> 32) + ((iArr[1] & 4294967295L) - (iArr2[1] & 4294967295L));
        iArr3[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr[2] & 4294967295L) - (iArr2[2] & 4294967295L));
        iArr3[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr[3] & 4294967295L) - (iArr2[3] & 4294967295L));
        iArr3[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr[4] & 4294967295L) - (iArr2[4] & 4294967295L));
        iArr3[4] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr[5] & 4294967295L) - (iArr2[5] & 4294967295L));
        iArr3[5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr[6] & 4294967295L) - (iArr2[6] & 4294967295L));
        iArr3[6] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr[7] & 4294967295L) - (iArr2[7] & 4294967295L));
        iArr3[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    /* renamed from: I */
    public static int m5003I(int[] iArr, int[] iArr2) {
        long j = ((iArr2[0] & 4294967295L) - (iArr[0] & 4294967295L)) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >> 32) + ((iArr2[1] & 4294967295L) - (iArr[1] & 4294967295L));
        iArr2[1] = (int) j2;
        long j3 = (j2 >> 32) + ((iArr2[2] & 4294967295L) - (iArr[2] & 4294967295L));
        iArr2[2] = (int) j3;
        long j4 = (j3 >> 32) + ((iArr2[3] & 4294967295L) - (iArr[3] & 4294967295L));
        iArr2[3] = (int) j4;
        long j5 = (j4 >> 32) + ((iArr2[4] & 4294967295L) - (iArr[4] & 4294967295L));
        iArr2[4] = (int) j5;
        long j6 = (j5 >> 32) + ((iArr2[5] & 4294967295L) - (iArr[5] & 4294967295L));
        iArr2[5] = (int) j6;
        long j7 = (j6 >> 32) + ((iArr2[6] & 4294967295L) - (iArr[6] & 4294967295L));
        iArr2[6] = (int) j7;
        long j8 = (j7 >> 32) + ((iArr2[7] & 4294967295L) - (4294967295L & iArr[7]));
        iArr2[7] = (int) j8;
        return (int) (j8 >> 32);
    }

    /* renamed from: J */
    public static BigInteger m5004J(int[] iArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 8; i++) {
            int i2 = iArr[i];
            if (i2 != 0) {
                h51.m4367c(i2, bArr, (7 - i) << 2);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: K */
    public static BigInteger m5005K(long[] jArr) {
        byte[] bArr = new byte[32];
        for (int i = 0; i < 4; i++) {
            long j = jArr[i];
            if (j != 0) {
                h51.m4372h(j, bArr, (3 - i) << 3);
            }
        }
        return new BigInteger(1, bArr);
    }

    /* renamed from: L */
    public static void m5006L(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        iArr[3] = 0;
        iArr[4] = 0;
        iArr[5] = 0;
        iArr[6] = 0;
        iArr[7] = 0;
    }

    /* renamed from: a */
    public static int m5007a(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & 4294967295L) + (iArr2[6] & 4294967295L);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[7] & 4294967295L) + (iArr2[7] & 4294967295L);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    /* renamed from: b */
    public static int m5008b(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + (iArr3[0] & 4294967295L) + 0;
        iArr3[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L) + (iArr3[1] & 4294967295L);
        iArr3[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L) + (iArr3[2] & 4294967295L);
        iArr3[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L) + (iArr3[3] & 4294967295L);
        iArr3[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L) + (iArr3[4] & 4294967295L);
        iArr3[4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L) + (iArr3[5] & 4294967295L);
        iArr3[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & 4294967295L) + (iArr2[6] & 4294967295L) + (iArr3[6] & 4294967295L);
        iArr3[6] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[7] & 4294967295L) + (iArr2[7] & 4294967295L) + (iArr3[7] & 4294967295L);
        iArr3[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    /* renamed from: c */
    public static int m5009c(int[] iArr, int i, int[] iArr2, int i2, int i3) {
        long j = (i3 & 4294967295L) + (iArr[i + 0] & 4294967295L) + (iArr2[r13] & 4294967295L);
        iArr2[i2 + 0] = (int) j;
        long j2 = (j >>> 32) + (iArr[i + 1] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[i + 2] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[i + 3] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[i + 4] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[i + 5] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[i + 6] & 4294967295L) + (iArr2[r6] & 4294967295L);
        iArr2[i2 + 6] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[i + 7] & 4294967295L) + (4294967295L & iArr2[r12]);
        iArr2[i2 + 7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    /* renamed from: d */
    public static int m5010d(int[] iArr, int[] iArr2) {
        long j = (iArr[0] & 4294967295L) + (iArr2[0] & 4294967295L) + 0;
        iArr2[0] = (int) j;
        long j2 = (j >>> 32) + (iArr[1] & 4294967295L) + (iArr2[1] & 4294967295L);
        iArr2[1] = (int) j2;
        long j3 = (j2 >>> 32) + (iArr[2] & 4294967295L) + (iArr2[2] & 4294967295L);
        iArr2[2] = (int) j3;
        long j4 = (j3 >>> 32) + (iArr[3] & 4294967295L) + (iArr2[3] & 4294967295L);
        iArr2[3] = (int) j4;
        long j5 = (j4 >>> 32) + (iArr[4] & 4294967295L) + (iArr2[4] & 4294967295L);
        iArr2[4] = (int) j5;
        long j6 = (j5 >>> 32) + (iArr[5] & 4294967295L) + (iArr2[5] & 4294967295L);
        iArr2[5] = (int) j6;
        long j7 = (j6 >>> 32) + (iArr[6] & 4294967295L) + (iArr2[6] & 4294967295L);
        iArr2[6] = (int) j7;
        long j8 = (j7 >>> 32) + (iArr[7] & 4294967295L) + (4294967295L & iArr2[7]);
        iArr2[7] = (int) j8;
        return (int) (j8 >>> 32);
    }

    /* renamed from: e */
    public static int m5011e(int[] iArr, int i, int[] iArr2, int i2) {
        long j = (iArr[r0] & 4294967295L) + (iArr2[r5] & 4294967295L) + 0;
        int i3 = (int) j;
        iArr[i + 0] = i3;
        iArr2[i2 + 0] = i3;
        long j2 = (j >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i4 = (int) j2;
        iArr[i + 1] = i4;
        iArr2[i2 + 1] = i4;
        long j3 = (j2 >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i5 = (int) j3;
        iArr[i + 2] = i5;
        iArr2[i2 + 2] = i5;
        long j4 = (j3 >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i6 = (int) j4;
        iArr[i + 3] = i6;
        iArr2[i2 + 3] = i6;
        long j5 = (j4 >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i7 = (int) j5;
        iArr[i + 4] = i7;
        iArr2[i2 + 4] = i7;
        long j6 = (j5 >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i8 = (int) j6;
        iArr[i + 5] = i8;
        iArr2[i2 + 5] = i8;
        long j7 = (j6 >>> 32) + (iArr[r5] & 4294967295L) + (iArr2[r8] & 4294967295L);
        int i9 = (int) j7;
        iArr[i + 6] = i9;
        iArr2[i2 + 6] = i9;
        long j8 = (j7 >>> 32) + (iArr[r12] & 4294967295L) + (4294967295L & iArr2[r14]);
        int i10 = (int) j8;
        iArr[i + 7] = i10;
        iArr2[i2 + 7] = i10;
        return (int) (j8 >>> 32);
    }

    /* renamed from: f */
    public static void m5012f(int[] iArr, int i, int[] iArr2, int i2) {
        iArr2[i2 + 0] = iArr[i + 0];
        iArr2[i2 + 1] = iArr[i + 1];
        iArr2[i2 + 2] = iArr[i + 2];
        iArr2[i2 + 3] = iArr[i + 3];
        iArr2[i2 + 4] = iArr[i + 4];
        iArr2[i2 + 5] = iArr[i + 5];
        iArr2[i2 + 6] = iArr[i + 6];
        iArr2[i2 + 7] = iArr[i + 7];
    }

    /* renamed from: g */
    public static void m5013g(long[] jArr, int i, long[] jArr2, int i2) {
        jArr2[i2 + 0] = jArr[i + 0];
        jArr2[i2 + 1] = jArr[i + 1];
        jArr2[i2 + 2] = jArr[i + 2];
        jArr2[i2 + 3] = jArr[i + 3];
    }

    /* renamed from: h */
    public static void m5014h(long[] jArr, long[] jArr2) {
        jArr2[0] = jArr[0];
        jArr2[1] = jArr[1];
        jArr2[2] = jArr[2];
        jArr2[3] = jArr[3];
    }

    /* renamed from: i */
    public static int[] m5015i() {
        return new int[8];
    }

    /* renamed from: j */
    public static long[] m5016j() {
        return new long[4];
    }

    /* renamed from: k */
    public static int[] m5017k() {
        return new int[16];
    }

    /* renamed from: l */
    public static long[] m5018l() {
        return new long[8];
    }

    /* renamed from: m */
    public static boolean m5019m(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        boolean m5024r = m5024r(iArr, i, iArr2, i2);
        if (m5024r) {
            m5001G(iArr, i, iArr2, i2, iArr3, i3);
        } else {
            m5001G(iArr2, i2, iArr, i, iArr3, i3);
        }
        return m5024r;
    }

    /* renamed from: n */
    public static boolean m5020n(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            if (iArr[i] != iArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: o */
    public static boolean m5021o(long[] jArr, long[] jArr2) {
        for (int i = 3; i >= 0; i--) {
            if (jArr[i] != jArr2[i]) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: p */
    public static int[] m5022p(BigInteger bigInteger) {
        if (bigInteger.signum() < 0 || bigInteger.bitLength() > 256) {
            throw new IllegalArgumentException();
        }
        int[] m5015i = m5015i();
        int i = 0;
        while (bigInteger.signum() != 0) {
            m5015i[i] = bigInteger.intValue();
            bigInteger = bigInteger.shiftRight(32);
            i++;
        }
        return m5015i;
    }

    /* renamed from: q */
    public static int m5023q(int[] iArr, int i) {
        int i2;
        if (i == 0) {
            i2 = iArr[0];
        } else {
            if ((i & 255) != i) {
                return 0;
            }
            i2 = iArr[i >>> 5] >>> (i & 31);
        }
        return i2 & 1;
    }

    /* renamed from: r */
    public static boolean m5024r(int[] iArr, int i, int[] iArr2, int i2) {
        for (int i3 = 7; i3 >= 0; i3--) {
            int i4 = iArr[i + i3] ^ Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE ^ iArr2[i2 + i3];
            if (i4 < i5) {
                return false;
            }
            if (i4 > i5) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: s */
    public static boolean m5025s(int[] iArr, int[] iArr2) {
        for (int i = 7; i >= 0; i--) {
            int i2 = iArr[i] ^ Integer.MIN_VALUE;
            int i3 = Integer.MIN_VALUE ^ iArr2[i];
            if (i2 < i3) {
                return false;
            }
            if (i2 > i3) {
                return true;
            }
        }
        return true;
    }

    /* renamed from: t */
    public static boolean m5026t(int[] iArr) {
        if (iArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: u */
    public static boolean m5027u(long[] jArr) {
        if (jArr[0] != 1) {
            return false;
        }
        for (int i = 1; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: v */
    public static boolean m5028v(int[] iArr) {
        for (int i = 0; i < 8; i++) {
            if (iArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: w */
    public static boolean m5029w(long[] jArr) {
        for (int i = 0; i < 4; i++) {
            if (jArr[i] != 0) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: x */
    public static void m5030x(int[] iArr, int i, int[] iArr2, int i2, int[] iArr3, int i3) {
        long j = iArr2[i2 + 0] & 4294967295L;
        long j2 = iArr2[i2 + 1] & 4294967295L;
        long j3 = iArr2[i2 + 2] & 4294967295L;
        long j4 = iArr2[i2 + 3] & 4294967295L;
        long j5 = iArr2[i2 + 4] & 4294967295L;
        long j6 = iArr2[i2 + 5] & 4294967295L;
        long j7 = iArr2[i2 + 6] & 4294967295L;
        long j8 = iArr[i + 0] & 4294967295L;
        long j9 = (j8 * j) + 0;
        iArr3[i3 + 0] = (int) j9;
        long j10 = (j9 >>> 32) + (j8 * j2);
        iArr3[i3 + 1] = (int) j10;
        long j11 = (j10 >>> 32) + (j8 * j3);
        iArr3[i3 + 2] = (int) j11;
        long j12 = (j11 >>> 32) + (j8 * j4);
        iArr3[i3 + 3] = (int) j12;
        long j13 = (j12 >>> 32) + (j8 * j5);
        iArr3[i3 + 4] = (int) j13;
        long j14 = (j13 >>> 32) + (j8 * j6);
        iArr3[i3 + 5] = (int) j14;
        long j15 = (j14 >>> 32) + (j8 * j7);
        iArr3[i3 + 6] = (int) j15;
        long j16 = iArr2[i2 + 7] & 4294967295L;
        long j17 = (j15 >>> 32) + (j8 * j16);
        iArr3[i3 + 7] = (int) j17;
        iArr3[i3 + 8] = (int) (j17 >>> 32);
        int i4 = 1;
        int i5 = i3;
        int i6 = 1;
        while (i6 < 8) {
            i5 += i4;
            long j18 = iArr[i + i6] & 4294967295L;
            long j19 = (j18 * j) + (iArr3[r16] & 4294967295L) + 0;
            iArr3[i5 + 0] = (int) j19;
            long j20 = j16;
            long j21 = (j19 >>> 32) + (j18 * j2) + (iArr3[r16] & 4294967295L);
            iArr3[i5 + 1] = (int) j21;
            long j22 = j3;
            long j23 = (j21 >>> 32) + (j18 * j3) + (iArr3[r16] & 4294967295L);
            iArr3[i5 + 2] = (int) j23;
            long j24 = (j23 >>> 32) + (j18 * j4) + (iArr3[r6] & 4294967295L);
            iArr3[i5 + 3] = (int) j24;
            long j25 = (j24 >>> 32) + (j18 * j5) + (iArr3[r6] & 4294967295L);
            iArr3[i5 + 4] = (int) j25;
            long j26 = (j25 >>> 32) + (j18 * j6) + (iArr3[r6] & 4294967295L);
            iArr3[i5 + 5] = (int) j26;
            long j27 = (j26 >>> 32) + (j18 * j7) + (iArr3[r6] & 4294967295L);
            iArr3[i5 + 6] = (int) j27;
            long j28 = (j27 >>> 32) + (j18 * j20) + (iArr3[r4] & 4294967295L);
            iArr3[i5 + 7] = (int) j28;
            iArr3[i5 + 8] = (int) (j28 >>> 32);
            i6++;
            j3 = j22;
            j16 = j20;
            j4 = j4;
            i4 = 1;
        }
    }

    /* renamed from: y */
    public static void m5031y(int[] iArr, int[] iArr2, int[] iArr3) {
        long j = iArr2[0] & 4294967295L;
        long j2 = iArr2[1] & 4294967295L;
        long j3 = iArr2[2] & 4294967295L;
        long j4 = iArr2[3] & 4294967295L;
        long j5 = iArr2[4] & 4294967295L;
        long j6 = iArr2[5] & 4294967295L;
        long j7 = iArr2[6] & 4294967295L;
        long j8 = iArr2[7] & 4294967295L;
        long j9 = iArr[0] & 4294967295L;
        long j10 = (j9 * j) + 0;
        iArr3[0] = (int) j10;
        long j11 = (j10 >>> 32) + (j9 * j2);
        iArr3[1] = (int) j11;
        long j12 = (j11 >>> 32) + (j9 * j3);
        iArr3[2] = (int) j12;
        long j13 = (j12 >>> 32) + (j9 * j4);
        iArr3[3] = (int) j13;
        long j14 = (j13 >>> 32) + (j9 * j5);
        iArr3[4] = (int) j14;
        long j15 = (j14 >>> 32) + (j9 * j6);
        iArr3[5] = (int) j15;
        long j16 = (j15 >>> 32) + (j9 * j7);
        iArr3[6] = (int) j16;
        long j17 = (j16 >>> 32) + (j9 * j8);
        iArr3[7] = (int) j17;
        iArr3[8] = (int) (j17 >>> 32);
        int i = 1;
        for (int i2 = 8; i < i2; i2 = 8) {
            long j18 = iArr[i] & 4294967295L;
            long j19 = (j18 * j) + (iArr3[r3] & 4294967295L) + 0;
            iArr3[i + 0] = (int) j19;
            int i3 = i + 1;
            long j20 = j2;
            long j21 = (j19 >>> 32) + (j18 * j2) + (iArr3[i3] & 4294967295L);
            iArr3[i3] = (int) j21;
            long j22 = j6;
            long j23 = (j21 >>> 32) + (j18 * j3) + (iArr3[r6] & 4294967295L);
            iArr3[i + 2] = (int) j23;
            long j24 = (j23 >>> 32) + (j18 * j4) + (iArr3[r6] & 4294967295L);
            iArr3[i + 3] = (int) j24;
            long j25 = (j24 >>> 32) + (j18 * j5) + (iArr3[r6] & 4294967295L);
            iArr3[i + 4] = (int) j25;
            long j26 = (j25 >>> 32) + (j18 * j22) + (iArr3[r3] & 4294967295L);
            iArr3[i + 5] = (int) j26;
            long j27 = (j26 >>> 32) + (j18 * j7) + (iArr3[r6] & 4294967295L);
            iArr3[i + 6] = (int) j27;
            long j28 = (j27 >>> 32) + (j18 * j8) + (iArr3[r3] & 4294967295L);
            iArr3[i + 7] = (int) j28;
            iArr3[i + 8] = (int) (j28 >>> 32);
            i = i3;
            j = j;
            j2 = j20;
            j6 = j22;
        }
    }

    /* renamed from: z */
    public static long m5032z(int i, int[] iArr, int i2, int[] iArr2, int i3, int[] iArr3, int i4) {
        long j = i & 4294967295L;
        long j2 = iArr[i2 + 0] & 4294967295L;
        long j3 = (j * j2) + (iArr2[i3 + 0] & 4294967295L) + 0;
        iArr3[i4 + 0] = (int) j3;
        long j4 = iArr[i2 + 1] & 4294967295L;
        long j5 = (j3 >>> 32) + (j * j4) + j2 + (iArr2[i3 + 1] & 4294967295L);
        iArr3[i4 + 1] = (int) j5;
        long j6 = j5 >>> 32;
        long j7 = iArr[i2 + 2] & 4294967295L;
        long j8 = j6 + (j * j7) + j4 + (iArr2[i3 + 2] & 4294967295L);
        iArr3[i4 + 2] = (int) j8;
        long j9 = iArr[i2 + 3] & 4294967295L;
        long j10 = (j8 >>> 32) + (j * j9) + j7 + (iArr2[i3 + 3] & 4294967295L);
        iArr3[i4 + 3] = (int) j10;
        long j11 = iArr[i2 + 4] & 4294967295L;
        long j12 = (j10 >>> 32) + (j * j11) + j9 + (iArr2[i3 + 4] & 4294967295L);
        iArr3[i4 + 4] = (int) j12;
        long j13 = iArr[i2 + 5] & 4294967295L;
        long j14 = (j12 >>> 32) + (j * j13) + j11 + (iArr2[i3 + 5] & 4294967295L);
        iArr3[i4 + 5] = (int) j14;
        long j15 = iArr[i2 + 6] & 4294967295L;
        long j16 = (j14 >>> 32) + (j * j15) + j13 + (iArr2[i3 + 6] & 4294967295L);
        iArr3[i4 + 6] = (int) j16;
        long j17 = iArr[i2 + 7] & 4294967295L;
        long j18 = (j16 >>> 32) + (j * j17) + j15 + (4294967295L & iArr2[i3 + 7]);
        iArr3[i4 + 7] = (int) j18;
        return (j18 >>> 32) + j17;
    }
}
