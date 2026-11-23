package com.sonelli;

import java.math.BigInteger;

/* loaded from: classes.dex */
public final class x41 {
    static {
        BigInteger.valueOf(0L);
        BigInteger.valueOf(1L);
        BigInteger.valueOf(2L);
        BigInteger.valueOf(4L);
    }

    /* renamed from: a */
    public static int m9699a(int i) {
        if (i == 0) {
            return 1;
        }
        if (i < 0) {
            i = -i;
        }
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 8;
        }
        return i2;
    }
}
