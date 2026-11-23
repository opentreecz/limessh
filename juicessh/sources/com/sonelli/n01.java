package com.sonelli;

/* loaded from: classes.dex */
public abstract class n01 {
    /* renamed from: a */
    public static void m6608a(int[] iArr, int[] iArr2, int[] iArr3) {
        j01.m5031y(iArr, iArr2, iArr3);
        j01.m5030x(iArr, 8, iArr2, 8, iArr3, 16);
        int m5011e = j01.m5011e(iArr3, 8, iArr3, 16);
        int m5009c = m5011e + j01.m5009c(iArr3, 24, iArr3, 16, j01.m5009c(iArr3, 0, iArr3, 8, 0) + m5011e);
        int[] m5015i = j01.m5015i();
        int[] m5015i2 = j01.m5015i();
        boolean z = j01.m5019m(iArr, 8, iArr, 0, m5015i, 0) != j01.m5019m(iArr2, 8, iArr2, 0, m5015i2, 0);
        int[] m5017k = j01.m5017k();
        j01.m5031y(m5015i, m5015i2, m5017k);
        p01.m7195f(32, m5009c + (z ? p01.m7193d(16, m5017k, 0, iArr3, 8) : p01.m7184O(16, m5017k, 0, iArr3, 8)), iArr3, 24);
    }

    /* renamed from: b */
    public static void m6609b(int[] iArr, int[] iArr2) {
        j01.m5000F(iArr, iArr2);
        j01.m4999E(iArr, 8, iArr2, 16);
        int m5011e = j01.m5011e(iArr2, 8, iArr2, 16);
        int m5009c = m5011e + j01.m5009c(iArr2, 24, iArr2, 16, j01.m5009c(iArr2, 0, iArr2, 8, 0) + m5011e);
        int[] m5015i = j01.m5015i();
        j01.m5019m(iArr, 8, iArr, 0, m5015i, 0);
        int[] m5017k = j01.m5017k();
        j01.m5000F(m5015i, m5017k);
        p01.m7195f(32, m5009c + p01.m7184O(16, m5017k, 0, iArr2, 8), iArr2, 24);
    }
}
