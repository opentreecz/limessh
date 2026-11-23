package com.sonelli;

import java.util.Random;

/* loaded from: classes.dex */
public abstract class e01 {
    /* renamed from: a */
    public static int m3372a(int i) {
        int i2 = 0;
        while ((i & 1) == 0) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    /* renamed from: b */
    public static void m3373b(int[] iArr, int i, int[] iArr2, int[] iArr3) {
        if (i < 0) {
            p01.m7190a(iArr.length, iArr2, iArr, iArr3);
        } else {
            System.arraycopy(iArr2, 0, iArr3, 0, iArr.length);
        }
    }

    /* renamed from: c */
    public static int m3374c(int[] iArr, int[] iArr2, int i, int[] iArr3, int i2) {
        int length = iArr.length;
        int i3 = 0;
        while (iArr2[0] == 0) {
            p01.m7174E(i, iArr2, 0);
            i3 += 32;
        }
        int m3372a = m3372a(iArr2[0]);
        if (m3372a > 0) {
            p01.m7172C(i, iArr2, m3372a, 0);
            i3 += m3372a;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if ((iArr3[0] & 1) != 0) {
                i2 += i2 < 0 ? p01.m7194e(length, iArr, iArr3) : p01.m7185P(length, iArr, iArr3);
            }
            p01.m7171B(length, iArr3, i2);
        }
        return i2;
    }

    /* renamed from: d */
    public static void m3375d(int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        if (p01.m7214y(length, iArr2)) {
            throw new IllegalArgumentException("'x' cannot be 0");
        }
        int i = 0;
        if (p01.m7213x(length, iArr2)) {
            System.arraycopy(iArr2, 0, iArr3, 0, length);
            return;
        }
        int[] m7199j = p01.m7199j(length, iArr2);
        int[] m7200k = p01.m7200k(length);
        m7200k[0] = 1;
        int m3374c = (1 & m7199j[0]) == 0 ? m3374c(iArr, m7199j, length, m7200k, 0) : 0;
        if (p01.m7213x(length, m7199j)) {
            m3373b(iArr, m3374c, m7200k, iArr3);
            return;
        }
        int[] m7199j2 = p01.m7199j(length, iArr);
        int[] m7200k2 = p01.m7200k(length);
        int i2 = length;
        while (true) {
            int i3 = i2 - 1;
            if (m7199j[i3] == 0 && m7199j2[i3] == 0) {
                i2--;
            } else if (p01.m7208s(i2, m7199j, m7199j2)) {
                p01.m7185P(i2, m7199j2, m7199j);
                m3374c = m3374c(iArr, m7199j, i2, m7200k, m3374c + (p01.m7185P(length, m7200k2, m7200k) - i));
                if (p01.m7213x(i2, m7199j)) {
                    m3373b(iArr, m3374c, m7200k, iArr3);
                    return;
                }
            } else {
                p01.m7185P(i2, m7199j, m7199j2);
                i = m3374c(iArr, m7199j2, i2, m7200k2, i + (p01.m7185P(length, m7200k, m7200k2) - m3374c));
                if (p01.m7213x(i2, m7199j2)) {
                    m3373b(iArr, i, m7200k2, iArr3);
                    return;
                }
            }
        }
    }

    /* renamed from: e */
    public static int[] m3376e(int[] iArr) {
        int length = iArr.length;
        Random random = new Random();
        int[] m7200k = p01.m7200k(length);
        int i = length - 1;
        int i2 = iArr[i];
        int i3 = i2 | (i2 >>> 1);
        int i4 = i3 | (i3 >>> 2);
        int i5 = i4 | (i4 >>> 4);
        int i6 = i5 | (i5 >>> 8);
        int i7 = i6 | (i6 >>> 16);
        do {
            for (int i8 = 0; i8 != length; i8++) {
                m7200k[i8] = random.nextInt();
            }
            m7200k[i] = m7200k[i] & i7;
        } while (p01.m7208s(length, m7200k, iArr));
        return m7200k;
    }
}
