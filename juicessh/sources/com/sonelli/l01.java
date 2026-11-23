package com.sonelli;

/* loaded from: classes.dex */
public abstract class l01 {
    /* renamed from: a */
    public static void m6038a(int[] iArr, int[] iArr2, int[] iArr3) {
        h01.m4331x(iArr, iArr2, iArr3);
        h01.m4330w(iArr, 6, iArr2, 6, iArr3, 12);
        int m4311d = h01.m4311d(iArr3, 6, iArr3, 12);
        int m4310c = m4311d + h01.m4310c(iArr3, 18, iArr3, 12, h01.m4310c(iArr3, 0, iArr3, 6, 0) + m4311d);
        int[] m4315h = h01.m4315h();
        int[] m4315h2 = h01.m4315h();
        boolean z = h01.m4319l(iArr, 6, iArr, 0, m4315h, 0) != h01.m4319l(iArr2, 6, iArr2, 0, m4315h2, 0);
        int[] m4317j = h01.m4317j();
        h01.m4331x(m4315h, m4315h2, m4317j);
        p01.m7195f(24, m4310c + (z ? p01.m7193d(12, m4317j, 0, iArr3, 6) : p01.m7184O(12, m4317j, 0, iArr3, 6)), iArr3, 18);
    }

    /* renamed from: b */
    public static void m6039b(int[] iArr, int[] iArr2) {
        h01.m4301D(iArr, iArr2);
        h01.m4300C(iArr, 6, iArr2, 12);
        int m4311d = h01.m4311d(iArr2, 6, iArr2, 12);
        int m4310c = m4311d + h01.m4310c(iArr2, 18, iArr2, 12, h01.m4310c(iArr2, 0, iArr2, 6, 0) + m4311d);
        int[] m4315h = h01.m4315h();
        h01.m4319l(iArr, 6, iArr, 0, m4315h, 0);
        int[] m4317j = h01.m4317j();
        h01.m4301D(m4315h, m4317j);
        p01.m7195f(24, m4310c + p01.m7184O(12, m4317j, 0, iArr2, 6), iArr2, 18);
    }
}
