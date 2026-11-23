package com.sonelli;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECLookupTable;

/* loaded from: classes.dex */
public class jv0 extends ev0 {
    @Override // com.sonelli.ev0
    /* renamed from: c */
    public iv0 mo3562c(iv0 iv0Var, BigInteger bigInteger) {
        gv0 m4937h = iv0Var.m4937h();
        if (bigInteger.bitLength() > lv0.m6301a(m4937h)) {
            throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
        }
        kv0 m6302b = lv0.m6302b(iv0Var);
        ECLookupTable m6000a = m6302b.m6000a();
        int m6002c = m6302b.m6002c();
        int i = ((r1 + m6002c) - 1) / m6002c;
        iv0 mo2308r = m4937h.mo2308r();
        int i2 = m6002c * i;
        int[] m7205p = p01.m7205p(i2, bigInteger);
        int i3 = i2 - 1;
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = 0;
            for (int i6 = i3 - i4; i6 >= 0; i6 -= i) {
                int i7 = m7205p[i6 >>> 5] >>> (i6 & 31);
                i5 = ((i5 ^ (i7 >>> 1)) << 1) ^ i7;
            }
            mo2308r = mo2308r.mo2639D(m6000a.mo2310a(i5));
        }
        return mo2308r.mo2641a(m6302b.m6001b());
    }
}
