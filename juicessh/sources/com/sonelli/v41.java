package com.sonelli;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public final class v41 {
    /* renamed from: a */
    public static t41 m9165a(u41 u41Var, b51 b51Var) {
        int m8847d = u41Var.m8847d();
        int i = 1 << m8847d;
        int m2384g = b51Var.m2384g();
        int i2 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, m2384g, i);
        int[][] iArr2 = (int[][]) Array.newInstance((Class<?>) int.class, m2384g, i);
        for (int i3 = 0; i3 < i; i3++) {
            iArr2[0][i3] = u41Var.m8849f(b51Var.m2382e(i3));
        }
        for (int i4 = 1; i4 < m2384g; i4++) {
            for (int i5 = 0; i5 < i; i5++) {
                iArr2[i4][i5] = u41Var.m8851h(iArr2[i4 - 1][i5], i5);
            }
        }
        int i6 = 0;
        while (i6 < m2384g) {
            int i7 = i2;
            while (i7 < i) {
                for (int i8 = i2; i8 <= i6; i8++) {
                    iArr[i6][i7] = u41Var.m8844a(iArr[i6][i7], u41Var.m8851h(iArr2[i8][i7], b51Var.m2383f((m2384g + i8) - i6)));
                }
                i7++;
                i2 = 0;
            }
            i6++;
            i2 = 0;
        }
        int[][] iArr3 = (int[][]) Array.newInstance((Class<?>) int.class, m2384g * m8847d, (i + 31) >>> 5);
        for (int i9 = 0; i9 < i; i9++) {
            int i10 = i9 >>> 5;
            int i11 = 1 << (i9 & 31);
            for (int i12 = 0; i12 < m2384g; i12++) {
                int i13 = iArr[i12][i9];
                for (int i14 = 0; i14 < m8847d; i14++) {
                    if (((i13 >>> i14) & 1) != 0) {
                        int[] iArr4 = iArr3[(((i12 + 1) * m8847d) - i14) - 1];
                        iArr4[i10] = iArr4[i10] ^ i11;
                    }
                }
            }
        }
        return new t41(i, iArr3);
    }
}
